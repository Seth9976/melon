package com.google.android.exoplayer2.offline;

import android.net.Uri;
import android.util.Pair;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheKeyFactory;
import com.google.android.exoplayer2.upstream.cache.CacheUtil.ProgressListener;
import com.google.android.exoplayer2.upstream.cache.CacheUtil;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class SegmentDownloader implements Downloader {
    static final class ProgressNotifier implements ProgressListener {
        private long bytesDownloaded;
        private final long contentLength;
        private final com.google.android.exoplayer2.offline.Downloader.ProgressListener progressListener;
        private int segmentsDownloaded;
        private final int totalSegments;

        public ProgressNotifier(com.google.android.exoplayer2.offline.Downloader.ProgressListener downloader$ProgressListener0, long v, int v1, long v2, int v3) {
            this.progressListener = downloader$ProgressListener0;
            this.contentLength = v;
            this.totalSegments = v1;
            this.bytesDownloaded = v2;
            this.segmentsDownloaded = v3;
        }

        private float getPercentDownloaded() {
            long v = this.contentLength;
            if(Long.compare(v, -1L) != 0 && v != 0L) {
                return ((float)this.bytesDownloaded) * 100.0f / ((float)v);
            }
            return this.totalSegments == 0 ? -1.0f : ((float)this.segmentsDownloaded) * 100.0f / ((float)this.totalSegments);
        }

        @Override  // com.google.android.exoplayer2.upstream.cache.CacheUtil$ProgressListener
        public void onProgress(long v, long v1, long v2) {
            long v3 = this.bytesDownloaded + v2;
            this.bytesDownloaded = v3;
            float f = this.getPercentDownloaded();
            this.progressListener.onProgress(this.contentLength, v3, f);
        }

        public void onSegmentDownloaded() {
            ++this.segmentsDownloaded;
            long v = this.bytesDownloaded;
            float f = this.getPercentDownloaded();
            this.progressListener.onProgress(this.contentLength, v, f);
        }
    }

    public static class Segment implements Comparable {
        public final DataSpec dataSpec;
        public final long startTimeUs;

        public Segment(long v, DataSpec dataSpec0) {
            this.startTimeUs = v;
            this.dataSpec = dataSpec0;
        }

        public int compareTo(Segment segmentDownloader$Segment0) {
            return Util.compareLong(this.startTimeUs, segmentDownloader$Segment0.startTimeUs);
        }

        @Override
        public int compareTo(Object object0) {
            return this.compareTo(((Segment)object0));
        }
    }

    private static final int BUFFER_SIZE_BYTES = 0x20000;
    private final Cache cache;
    private final CacheKeyFactory cacheKeyFactory;
    private final CacheDataSource dataSource;
    private final AtomicBoolean isCanceled;
    private final DataSpec manifestDataSpec;
    private final CacheDataSource offlineDataSource;
    private final PriorityTaskManager priorityTaskManager;
    private final ArrayList streamKeys;

    public SegmentDownloader(Uri uri0, List list0, DownloaderConstructorHelper downloaderConstructorHelper0) {
        this.manifestDataSpec = SegmentDownloader.getCompressibleDataSpec(uri0);
        this.streamKeys = new ArrayList(list0);
        this.cache = downloaderConstructorHelper0.getCache();
        this.dataSource = downloaderConstructorHelper0.createCacheDataSource();
        this.offlineDataSource = downloaderConstructorHelper0.createOfflineCacheDataSource();
        this.cacheKeyFactory = downloaderConstructorHelper0.getCacheKeyFactory();
        this.priorityTaskManager = downloaderConstructorHelper0.getPriorityTaskManager();
        this.isCanceled = new AtomicBoolean();
    }

    @Override  // com.google.android.exoplayer2.offline.Downloader
    public void cancel() {
        this.isCanceled.set(true);
    }

    @Override  // com.google.android.exoplayer2.offline.Downloader
    public final void download(com.google.android.exoplayer2.offline.Downloader.ProgressListener downloader$ProgressListener0) {
        this.priorityTaskManager.add(-1000);
        try {
            FilterableManifest filterableManifest0 = this.getManifest(this.dataSource, this.manifestDataSpec);
            if(!this.streamKeys.isEmpty()) {
                filterableManifest0 = (FilterableManifest)filterableManifest0.copy(this.streamKeys);
            }
            List list0 = this.getSegments(this.dataSource, filterableManifest0, false);
            int v2 = list0.size();
            int v3 = list0.size() - 1;
            int v4 = 0;
            long v5 = 0L;
            long v6 = 0L;
            while(v3 >= 0) {
                Pair pair0 = CacheUtil.getCached(((Segment)list0.get(v3)).dataSpec, this.cache, this.cacheKeyFactory);
                long v7 = (long)(((Long)pair0.first));
                long v8 = (long)(((Long)pair0.second));
                v6 += v8;
                if(v7 == -1L) {
                    v5 = -1L;
                }
                else {
                    if(v7 == v8) {
                        ++v4;
                        list0.remove(v3);
                    }
                    if(v5 != -1L) {
                        v5 += v7;
                    }
                }
                --v3;
            }
            Collections.sort(list0);
            ProgressNotifier segmentDownloader$ProgressNotifier0 = downloader$ProgressListener0 == null ? null : new ProgressNotifier(downloader$ProgressListener0, v5, v2, v6, v4);
            for(int v1 = 0; v1 < list0.size(); ++v1) {
                CacheUtil.cache(((Segment)list0.get(v1)).dataSpec, this.cache, this.cacheKeyFactory, this.dataSource, new byte[0x20000], this.priorityTaskManager, -1000, segmentDownloader$ProgressNotifier0, this.isCanceled, true);
                if(segmentDownloader$ProgressNotifier0 != null) {
                    segmentDownloader$ProgressNotifier0.onSegmentDownloaded();
                }
            }
        }
        finally {
            this.priorityTaskManager.remove(-1000);
        }
    }

    public static DataSpec getCompressibleDataSpec(Uri uri0) {
        return new DataSpec(uri0, 0L, -1L, null, 1);
    }

    public abstract FilterableManifest getManifest(DataSource arg1, DataSpec arg2);

    public abstract List getSegments(DataSource arg1, FilterableManifest arg2, boolean arg3);

    @Override  // com.google.android.exoplayer2.offline.Downloader
    public final void remove() {
        try {
            FilterableManifest filterableManifest0 = this.getManifest(this.offlineDataSource, this.manifestDataSpec);
            List list0 = this.getSegments(this.offlineDataSource, filterableManifest0, true);
            for(int v1 = 0; v1 < list0.size(); ++v1) {
                this.removeDataSpec(((Segment)list0.get(v1)).dataSpec);
            }
        }
        catch(IOException unused_ex) {
        }
        finally {
            this.removeDataSpec(this.manifestDataSpec);
        }
    }

    private void removeDataSpec(DataSpec dataSpec0) {
        CacheUtil.remove(dataSpec0, this.cache, this.cacheKeyFactory);
    }
}

