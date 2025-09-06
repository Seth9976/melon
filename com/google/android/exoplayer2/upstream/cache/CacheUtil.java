package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import android.util.Pair;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CacheUtil {
    public interface ProgressListener {
        void onProgress(long arg1, long arg2, long arg3);
    }

    static final class ProgressNotifier {
        private long bytesCached;
        private final ProgressListener listener;
        private long requestLength;

        public ProgressNotifier(ProgressListener cacheUtil$ProgressListener0) {
            this.listener = cacheUtil$ProgressListener0;
        }

        public void init(long v, long v1) {
            this.requestLength = v;
            this.bytesCached = v1;
            this.listener.onProgress(v, v1, 0L);
        }

        public void onBytesCached(long v) {
            long v1 = this.bytesCached + v;
            this.bytesCached = v1;
            this.listener.onProgress(this.requestLength, v1, v);
        }

        public void onRequestLengthResolved(long v) {
            if(this.requestLength == -1L && v != -1L) {
                this.requestLength = v;
                this.listener.onProgress(v, this.bytesCached, 0L);
            }
        }
    }

    public static final int DEFAULT_BUFFER_SIZE_BYTES = 0x20000;
    public static final CacheKeyFactory DEFAULT_CACHE_KEY_FACTORY;

    static {
        CacheUtil.DEFAULT_CACHE_KEY_FACTORY = new a(0);
    }

    private static String buildCacheKey(DataSpec dataSpec0, CacheKeyFactory cacheKeyFactory0) {
        if(cacheKeyFactory0 == null) {
            cacheKeyFactory0 = CacheUtil.DEFAULT_CACHE_KEY_FACTORY;
        }
        return cacheKeyFactory0.buildCacheKey(dataSpec0);
    }

    public static void cache(DataSpec dataSpec0, Cache cache0, DataSource dataSource0, ProgressListener cacheUtil$ProgressListener0, AtomicBoolean atomicBoolean0) {
        CacheUtil.cache(dataSpec0, cache0, null, new CacheDataSource(cache0, dataSource0), new byte[0x20000], null, 0, cacheUtil$ProgressListener0, atomicBoolean0, false);
    }

    public static void cache(DataSpec dataSpec0, Cache cache0, CacheKeyFactory cacheKeyFactory0, CacheDataSource cacheDataSource0, byte[] arr_b, PriorityTaskManager priorityTaskManager0, int v, ProgressListener cacheUtil$ProgressListener0, AtomicBoolean atomicBoolean0, boolean z) {
        long v6;
        long v1;
        ProgressNotifier cacheUtil$ProgressNotifier1;
        Assertions.checkNotNull(cacheDataSource0);
        Assertions.checkNotNull(arr_b);
        String s = CacheUtil.buildCacheKey(dataSpec0, cacheKeyFactory0);
        if(cacheUtil$ProgressListener0 == null) {
            v1 = CacheUtil.getRequestLength(dataSpec0, cache0, s);
            cacheUtil$ProgressNotifier1 = null;
        }
        else {
            ProgressNotifier cacheUtil$ProgressNotifier0 = new ProgressNotifier(cacheUtil$ProgressListener0);
            Pair pair0 = CacheUtil.getCached(dataSpec0, cache0, cacheKeyFactory0);
            cacheUtil$ProgressNotifier0.init(((long)(((Long)pair0.first))), ((long)(((Long)pair0.second))));
            cacheUtil$ProgressNotifier1 = cacheUtil$ProgressNotifier0;
            v1 = (long)(((Long)pair0.first));
        }
        long v2 = dataSpec0.absoluteStreamPosition;
        boolean z1 = Long.compare(v1, -1L) == 0;
        long v3 = v1;
        while(v3 != 0L) {
            CacheUtil.throwExceptionIfInterruptedOrCancelled(atomicBoolean0);
            long v4 = cache0.getCachedLength(s, v2, (z1 ? 0x7FFFFFFFFFFFFFFFL : v3));
            if(v4 <= 0L) {
                long v5 = -v4;
                if(v5 == 0x7FFFFFFFFFFFFFFFL) {
                    v6 = 0x7FFFFFFFFFFFFFFFL;
                    v5 = -1L;
                }
                else {
                    v6 = v5;
                }
                if(CacheUtil.readAndDiscard(dataSpec0, v2, v5, cacheDataSource0, arr_b, priorityTaskManager0, v, cacheUtil$ProgressNotifier1, v5 == v3, atomicBoolean0) < v6) {
                    if(z && !z1) {
                        throw new EOFException();
                    }
                    break;
                }
                v4 = v6;
            }
            if(!z1) {
                v3 -= v4;
            }
            v2 += v4;
        }
    }

    public static String generateKey(Uri uri0) {
        return uri0.toString();
    }

    public static Pair getCached(DataSpec dataSpec0, Cache cache0, CacheKeyFactory cacheKeyFactory0) {
        String s = CacheUtil.buildCacheKey(dataSpec0, cacheKeyFactory0);
        long v = dataSpec0.absoluteStreamPosition;
        long v1 = CacheUtil.getRequestLength(dataSpec0, cache0, s);
        long v2 = v1;
        long v3 = 0L;
        while(v2 != 0L) {
            int v4 = Long.compare(v2, -1L);
            long v5 = cache0.getCachedLength(s, v, (v4 == 0 ? 0x7FFFFFFFFFFFFFFFL : v2));
            if(v5 > 0L) {
                v3 += v5;
            }
            else {
                v5 = -v5;
                if(v5 != 0x7FFFFFFFFFFFFFFFL) {
                    goto label_13;
                }
                break;
            }
        label_13:
            v += v5;
            if(v4 == 0) {
                v5 = 0L;
            }
            v2 -= v5;
        }
        return Pair.create(v1, v3);
    }

    private static long getRequestLength(DataSpec dataSpec0, Cache cache0, String s) {
        long v = dataSpec0.length;
        if(v != -1L) {
            return v;
        }
        long v1 = ContentMetadata.getContentLength(cache0.getContentMetadata(s));
        return v1 == -1L ? -1L : v1 - dataSpec0.absoluteStreamPosition;
    }

    public static boolean isCausedByPositionOutOfRange(IOException iOException0) {
        while(iOException0 != null) {
            if(iOException0 instanceof DataSourceException && ((DataSourceException)iOException0).reason == 0) {
                return true;
            }
            iOException0 = iOException0.getCause();
        }
        return false;
    }

    private static String lambda$static$0(DataSpec dataSpec0) {
        return dataSpec0.key == null ? CacheUtil.generateKey(dataSpec0.uri) : dataSpec0.key;
    }

    private static long readAndDiscard(DataSpec dataSpec0, long v, long v1, DataSource dataSource0, byte[] arr_b, PriorityTaskManager priorityTaskManager0, int v2, ProgressNotifier cacheUtil$ProgressNotifier0, boolean z, AtomicBoolean atomicBoolean0) {
        boolean z1;
        long v7;
        long v3 = v - dataSpec0.absoluteStreamPosition;
        long v4 = v1 == -1L ? -1L : v3 + v1;
        long v5 = v3;
    alab1:
        while(true) {
            if(priorityTaskManager0 != null) {
                priorityTaskManager0.proceed(v2);
            }
            CacheUtil.throwExceptionIfInterruptedOrCancelled(atomicBoolean0);
            int v6 = Long.compare(v4, -1L);
            if(v6 == 0) {
                goto label_15;
            }
            else {
                try {
                    try {
                        v7 = dataSource0.open(dataSpec0.subrange(v5, v4 - v5));
                        z1 = true;
                    }
                    catch(IOException iOException0) {
                        try {
                            if(!z || !CacheUtil.isCausedByPositionOutOfRange(iOException0)) {
                                throw iOException0;
                            }
                            Util.closeQuietly(dataSource0);
                        label_15:
                            v7 = -1L;
                            z1 = false;
                        label_17:
                            if(!z1) {
                                v7 = dataSource0.open(dataSpec0.subrange(v5, -1L));
                            }
                            if(z && cacheUtil$ProgressNotifier0 != null && v7 != -1L) {
                                cacheUtil$ProgressNotifier0.onRequestLengthResolved(v7 + v5);
                            }
                            goto label_21;
                        }
                        catch(PriorityTooLowException unused_ex) {
                            goto label_32;
                        }
                    }
                }
                catch(Throwable throwable0) {
                    Util.closeQuietly(dataSource0);
                    throw throwable0;
                }
            }
            goto label_17;
            while(true) {
            label_21:
                if(v5 == v4) {
                    break alab1;
                }
                try {
                    CacheUtil.throwExceptionIfInterruptedOrCancelled(atomicBoolean0);
                    int v8 = dataSource0.read(arr_b, 0, (v6 == 0 ? arr_b.length : ((int)Math.min(arr_b.length, v4 - v5))));
                    if(v8 != -1) {
                        v5 += (long)v8;
                        if(cacheUtil$ProgressNotifier0 == null) {
                            continue;
                        }
                        cacheUtil$ProgressNotifier0.onBytesCached(((long)v8));
                        continue;
                    }
                    if(cacheUtil$ProgressNotifier0 != null) {
                        cacheUtil$ProgressNotifier0.onRequestLengthResolved(v5);
                    }
                    break alab1;
                }
                catch(PriorityTooLowException unused_ex) {
                label_32:
                    Util.closeQuietly(dataSource0);
                    break;
                }
                catch(Throwable throwable0) {
                    Util.closeQuietly(dataSource0);
                    throw throwable0;
                }
            }
        }
        Util.closeQuietly(dataSource0);
        return v5 - v3;
    }

    public static void remove(DataSpec dataSpec0, Cache cache0, CacheKeyFactory cacheKeyFactory0) {
        CacheUtil.remove(cache0, CacheUtil.buildCacheKey(dataSpec0, cacheKeyFactory0));
    }

    public static void remove(Cache cache0, String s) {
        for(Object object0: cache0.getCachedSpans(s)) {
            CacheSpan cacheSpan0 = (CacheSpan)object0;
            try {
                cache0.removeSpan(cacheSpan0);
            }
            catch(CacheException unused_ex) {
            }
        }
    }

    private static void throwExceptionIfInterruptedOrCancelled(AtomicBoolean atomicBoolean0) {
        if(Thread.interrupted() || atomicBoolean0 != null && atomicBoolean0.get()) {
            throw new InterruptedException();
        }
    }
}

