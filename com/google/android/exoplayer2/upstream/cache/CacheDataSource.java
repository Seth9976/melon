package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.TeeDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.Map;

public final class CacheDataSource implements DataSource {
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface CacheIgnoredReason {
    }

    public interface EventListener {
        void onCacheIgnored(int arg1);

        void onCachedBytesRead(long arg1, long arg2);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static final int CACHE_IGNORED_REASON_ERROR = 0;
    public static final int CACHE_IGNORED_REASON_UNSET_LENGTH = 1;
    private static final int CACHE_NOT_IGNORED = -1;
    public static final int FLAG_BLOCK_ON_CACHE = 1;
    public static final int FLAG_IGNORE_CACHE_FOR_UNSET_LENGTH_REQUESTS = 4;
    public static final int FLAG_IGNORE_CACHE_ON_ERROR = 2;
    private static final long MIN_READ_BEFORE_CHECKING_CACHE = 0x19000L;
    private Uri actualUri;
    private final boolean blockOnCache;
    private long bytesRemaining;
    private final Cache cache;
    private final CacheKeyFactory cacheKeyFactory;
    private final DataSource cacheReadDataSource;
    private final DataSource cacheWriteDataSource;
    private long checkCachePosition;
    private DataSource currentDataSource;
    private boolean currentDataSpecLengthUnset;
    private CacheSpan currentHoleSpan;
    private boolean currentRequestIgnoresCache;
    private final EventListener eventListener;
    private int flags;
    private byte[] httpBody;
    private int httpMethod;
    private Map httpRequestHeaders;
    private final boolean ignoreCacheForUnsetLengthRequests;
    private final boolean ignoreCacheOnError;
    private String key;
    private long readPosition;
    private boolean seenCacheError;
    private long totalCachedBytesRead;
    private final DataSource upstreamDataSource;
    private Uri uri;

    public CacheDataSource(Cache cache0, DataSource dataSource0) {
        this(cache0, dataSource0, 0);
    }

    public CacheDataSource(Cache cache0, DataSource dataSource0, int v) {
        this(cache0, dataSource0, new FileDataSource(), new CacheDataSink(cache0, 0x500000L), v, null);
    }

    public CacheDataSource(Cache cache0, DataSource dataSource0, DataSource dataSource1, DataSink dataSink0, int v, EventListener cacheDataSource$EventListener0) {
        this(cache0, dataSource0, dataSource1, dataSink0, v, cacheDataSource$EventListener0, null);
    }

    public CacheDataSource(Cache cache0, DataSource dataSource0, DataSource dataSource1, DataSink dataSink0, int v, EventListener cacheDataSource$EventListener0, CacheKeyFactory cacheKeyFactory0) {
        this.httpRequestHeaders = Collections.EMPTY_MAP;
        this.cache = cache0;
        this.cacheReadDataSource = dataSource1;
        if(cacheKeyFactory0 == null) {
            cacheKeyFactory0 = CacheUtil.DEFAULT_CACHE_KEY_FACTORY;
        }
        this.cacheKeyFactory = cacheKeyFactory0;
        boolean z = false;
        this.blockOnCache = (v & 1) != 0;
        this.ignoreCacheOnError = (v & 2) != 0;
        if((v & 4) != 0) {
            z = true;
        }
        this.ignoreCacheForUnsetLengthRequests = z;
        this.upstreamDataSource = dataSource0;
        this.cacheWriteDataSource = dataSink0 == null ? null : new TeeDataSource(dataSource0, dataSink0);
        this.eventListener = cacheDataSource$EventListener0;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public void addTransferListener(TransferListener transferListener0) {
        this.cacheReadDataSource.addTransferListener(transferListener0);
        this.upstreamDataSource.addTransferListener(transferListener0);
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        this.uri = null;
        this.actualUri = null;
        this.httpMethod = 1;
        this.httpBody = null;
        this.httpRequestHeaders = Collections.EMPTY_MAP;
        this.flags = 0;
        this.readPosition = 0L;
        this.key = null;
        this.notifyBytesRead();
        try {
            this.closeCurrentSource();
        }
        catch(Throwable throwable0) {
            this.handleBeforeThrow(throwable0);
            throw throwable0;
        }
    }

    private void closeCurrentSource() {
        CacheSpan cacheSpan0;
        DataSource dataSource0 = this.currentDataSource;
        if(dataSource0 != null) {
            try {
                dataSource0.close();
                this.currentDataSource = null;
                this.currentDataSpecLengthUnset = false;
                cacheSpan0 = this.currentHoleSpan;
            }
            catch(Throwable throwable0) {
                this.currentDataSource = null;
                this.currentDataSpecLengthUnset = false;
                CacheSpan cacheSpan1 = this.currentHoleSpan;
                if(cacheSpan1 != null) {
                    this.cache.releaseHoleSpan(cacheSpan1);
                    this.currentHoleSpan = null;
                }
                throw throwable0;
            }
            if(cacheSpan0 != null) {
                this.cache.releaseHoleSpan(cacheSpan0);
                this.currentHoleSpan = null;
            }
        }
    }

    private static Uri getRedirectedUriOrDefault(Cache cache0, String s, Uri uri0) {
        Uri uri1 = ContentMetadata.getRedirectedUri(cache0.getContentMetadata(s));
        return uri1 == null ? uri0 : uri1;
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public Map getResponseHeaders() {
        return this.isReadingFromUpstream() ? this.upstreamDataSource.getResponseHeaders() : Collections.EMPTY_MAP;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        return this.actualUri;
    }

    private void handleBeforeThrow(Throwable throwable0) {
        if(!this.isReadingFromCache() && !(throwable0 instanceof CacheException)) {
            return;
        }
        this.seenCacheError = true;
    }

    private boolean isBypassingCache() {
        return this.currentDataSource == this.upstreamDataSource;
    }

    private boolean isReadingFromCache() {
        return this.currentDataSource == this.cacheReadDataSource;
    }

    private boolean isReadingFromUpstream() {
        return !this.isReadingFromCache();
    }

    private boolean isWritingToCache() {
        return this.currentDataSource == this.cacheWriteDataSource;
    }

    private void notifyBytesRead() {
        EventListener cacheDataSource$EventListener0 = this.eventListener;
        if(cacheDataSource$EventListener0 != null && this.totalCachedBytesRead > 0L) {
            cacheDataSource$EventListener0.onCachedBytesRead(this.cache.getCacheSpace(), this.totalCachedBytesRead);
            this.totalCachedBytesRead = 0L;
        }
    }

    private void notifyCacheIgnored(int v) {
        EventListener cacheDataSource$EventListener0 = this.eventListener;
        if(cacheDataSource$EventListener0 != null) {
            cacheDataSource$EventListener0.onCacheIgnored(v);
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec0) {
        try {
            String s = this.cacheKeyFactory.buildCacheKey(dataSpec0);
            this.key = s;
            this.uri = dataSpec0.uri;
            this.actualUri = CacheDataSource.getRedirectedUriOrDefault(this.cache, s, dataSpec0.uri);
            this.httpMethod = dataSpec0.httpMethod;
            this.httpBody = dataSpec0.httpBody;
            this.httpRequestHeaders = dataSpec0.httpRequestHeaders;
            this.flags = dataSpec0.flags;
            this.readPosition = dataSpec0.position;
            int v = this.shouldIgnoreCacheForRequest(dataSpec0);
            this.currentRequestIgnoresCache = v != -1;
            if(v != -1) {
                this.notifyCacheIgnored(v);
            }
            long v1 = dataSpec0.length;
            if(v1 != -1L || this.currentRequestIgnoresCache) {
                this.bytesRemaining = v1;
            }
            else {
                long v2 = ContentMetadata.getContentLength(this.cache.getContentMetadata(this.key));
                this.bytesRemaining = v2;
                if(v2 != -1L) {
                    long v3 = v2 - dataSpec0.position;
                    this.bytesRemaining = v3;
                    if(v3 <= 0L) {
                        throw new DataSourceException(0);
                    }
                }
            }
            this.openNextSource(false);
            return this.bytesRemaining;
        }
        catch(Throwable throwable0) {
        }
        this.handleBeforeThrow(throwable0);
        throw throwable0;
    }

    private void openNextSource(boolean z) {
        long v3;
        CacheSpan cacheSpan1;
        DataSpec dataSpec0;
        DataSource dataSource0;
        CacheSpan cacheSpan0;
        if(this.currentRequestIgnoresCache) {
            cacheSpan0 = null;
        }
        else if(this.blockOnCache) {
            try {
                cacheSpan0 = this.cache.startReadWrite(this.key, this.readPosition);
            }
            catch(InterruptedException unused_ex) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        }
        else {
            cacheSpan0 = this.cache.startReadWriteNonBlocking(this.key, this.readPosition);
        }
        if(cacheSpan0 == null) {
            dataSource0 = this.upstreamDataSource;
            dataSpec0 = new DataSpec(this.uri, this.httpMethod, this.httpBody, this.readPosition, this.readPosition, this.bytesRemaining, this.key, this.flags, this.httpRequestHeaders);
            cacheSpan1 = null;
        }
        else if(cacheSpan0.isCached) {
            Uri uri0 = Uri.fromFile(cacheSpan0.file);
            long v = this.readPosition - cacheSpan0.position;
            long v1 = cacheSpan0.length - v;
            long v2 = this.bytesRemaining;
            if(v2 != -1L) {
                v1 = Math.min(v1, v2);
            }
            dataSpec0 = new DataSpec(uri0, this.readPosition, v, v1, this.key, this.flags);
            dataSource0 = this.cacheReadDataSource;
            cacheSpan1 = cacheSpan0;
        }
        else {
            if(cacheSpan0.isOpenEnded()) {
                v3 = this.bytesRemaining;
            }
            else {
                v3 = cacheSpan0.length;
                long v4 = this.bytesRemaining;
                if(v4 != -1L) {
                    v3 = Math.min(v3, v4);
                }
            }
            DataSpec dataSpec1 = new DataSpec(this.uri, this.httpMethod, this.httpBody, this.readPosition, this.readPosition, v3, this.key, this.flags, this.httpRequestHeaders);
            dataSource0 = this.cacheWriteDataSource;
            if(dataSource0 == null) {
                dataSource0 = this.upstreamDataSource;
                this.cache.releaseHoleSpan(cacheSpan0);
                dataSpec0 = dataSpec1;
                cacheSpan1 = null;
            }
            else {
                cacheSpan1 = cacheSpan0;
                dataSpec0 = dataSpec1;
            }
        }
        this.checkCachePosition = this.currentRequestIgnoresCache || dataSource0 != this.upstreamDataSource ? 0x7FFFFFFFFFFFFFFFL : this.readPosition + 0x19000L;
        if(z) {
            Assertions.checkState(this.isBypassingCache());
            if(dataSource0 != this.upstreamDataSource) {
                try {
                    this.closeCurrentSource();
                    goto label_52;
                }
                catch(Throwable throwable0) {
                    if(cacheSpan1.isHoleSpan()) {
                        this.cache.releaseHoleSpan(cacheSpan1);
                    }
                    throw throwable0;
                }
            }
        }
        else {
        label_52:
            if(cacheSpan1 != null && cacheSpan1.isHoleSpan()) {
                this.currentHoleSpan = cacheSpan1;
            }
            this.currentDataSource = dataSource0;
            this.currentDataSpecLengthUnset = dataSpec0.length == -1L;
            long v5 = dataSource0.open(dataSpec0);
            ContentMetadataMutations contentMetadataMutations0 = new ContentMetadataMutations();
            if(this.currentDataSpecLengthUnset && v5 != -1L) {
                this.bytesRemaining = v5;
                ContentMetadataMutations.setContentLength(contentMetadataMutations0, this.readPosition + v5);
            }
            if(this.isReadingFromUpstream()) {
                Uri uri1 = this.currentDataSource.getUri();
                this.actualUri = uri1;
                ContentMetadataMutations.setRedirectedUri(contentMetadataMutations0, (this.uri.equals(uri1) ? null : this.actualUri));
            }
            if(this.isWritingToCache()) {
                this.cache.applyContentMetadataMutations(this.key, contentMetadataMutations0);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] arr_b, int v, int v1) {
        if(v1 == 0) {
            return 0;
        }
        if(Long.compare(this.bytesRemaining, 0L) == 0) {
            return -1;
        }
        try {
            if(this.readPosition >= this.checkCachePosition) {
                this.openNextSource(true);
            }
            int v2 = this.currentDataSource.read(arr_b, v, v1);
            if(v2 != -1) {
                if(this.isReadingFromCache()) {
                    this.totalCachedBytesRead += (long)v2;
                }
                this.readPosition += (long)v2;
                long v3 = this.bytesRemaining;
                if(v3 == -1L) {
                    return v2;
                }
                this.bytesRemaining = v3 - ((long)v2);
                return v2;
            }
            if(this.currentDataSpecLengthUnset) {
                this.setNoBytesRemainingAndMaybeStoreLength();
                return -1;
            }
            if(this.bytesRemaining <= 0L && this.bytesRemaining != -1L) {
                return v2;
            }
            this.closeCurrentSource();
            this.openNextSource(false);
            return this.read(arr_b, v, v1);
        }
        catch(IOException iOException0) {
        }
        catch(Throwable throwable0) {
            this.handleBeforeThrow(throwable0);
            throw throwable0;
        }
        if(this.currentDataSpecLengthUnset && CacheUtil.isCausedByPositionOutOfRange(iOException0)) {
            this.setNoBytesRemainingAndMaybeStoreLength();
            return -1;
        }
        this.handleBeforeThrow(iOException0);
        throw iOException0;
    }

    private void setNoBytesRemainingAndMaybeStoreLength() {
        this.bytesRemaining = 0L;
        if(this.isWritingToCache()) {
            ContentMetadataMutations contentMetadataMutations0 = new ContentMetadataMutations();
            ContentMetadataMutations.setContentLength(contentMetadataMutations0, this.readPosition);
            this.cache.applyContentMetadataMutations(this.key, contentMetadataMutations0);
        }
    }

    private int shouldIgnoreCacheForRequest(DataSpec dataSpec0) {
        if(this.ignoreCacheOnError && this.seenCacheError) {
            return 0;
        }
        return !this.ignoreCacheForUnsetLengthRequests || dataSpec0.length != -1L ? -1 : 1;
    }
}

