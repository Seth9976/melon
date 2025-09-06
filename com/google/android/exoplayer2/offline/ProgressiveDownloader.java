package com.google.android.exoplayer2.offline;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheKeyFactory;
import com.google.android.exoplayer2.upstream.cache.CacheUtil.ProgressListener;
import com.google.android.exoplayer2.upstream.cache.CacheUtil;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ProgressiveDownloader implements Downloader {
    static final class ProgressForwarder implements ProgressListener {
        private final com.google.android.exoplayer2.offline.Downloader.ProgressListener progessListener;

        public ProgressForwarder(com.google.android.exoplayer2.offline.Downloader.ProgressListener downloader$ProgressListener0) {
            this.progessListener = downloader$ProgressListener0;
        }

        @Override  // com.google.android.exoplayer2.upstream.cache.CacheUtil$ProgressListener
        public void onProgress(long v, long v1, long v2) {
            this.progessListener.onProgress(v, v1, (v == -1L || v == 0L ? -1.0f : ((float)v1) * 100.0f / ((float)v)));
        }
    }

    private static final int BUFFER_SIZE_BYTES = 0x20000;
    private final Cache cache;
    private final CacheKeyFactory cacheKeyFactory;
    private final CacheDataSource dataSource;
    private final DataSpec dataSpec;
    private final AtomicBoolean isCanceled;
    private final PriorityTaskManager priorityTaskManager;

    public ProgressiveDownloader(Uri uri0, String s, DownloaderConstructorHelper downloaderConstructorHelper0) {
        this.dataSpec = new DataSpec(uri0, 0L, -1L, s, 4);
        this.cache = downloaderConstructorHelper0.getCache();
        this.dataSource = downloaderConstructorHelper0.createCacheDataSource();
        this.cacheKeyFactory = downloaderConstructorHelper0.getCacheKeyFactory();
        this.priorityTaskManager = downloaderConstructorHelper0.getPriorityTaskManager();
        this.isCanceled = new AtomicBoolean();
    }

    @Override  // com.google.android.exoplayer2.offline.Downloader
    public void cancel() {
        this.isCanceled.set(true);
    }

    @Override  // com.google.android.exoplayer2.offline.Downloader
    public void download(com.google.android.exoplayer2.offline.Downloader.ProgressListener downloader$ProgressListener0) {
        this.priorityTaskManager.add(-1000);
        try {
            ProgressForwarder progressiveDownloader$ProgressForwarder0 = downloader$ProgressListener0 == null ? null : new ProgressForwarder(downloader$ProgressListener0);
            CacheUtil.cache(this.dataSpec, this.cache, this.cacheKeyFactory, this.dataSource, new byte[0x20000], this.priorityTaskManager, -1000, progressiveDownloader$ProgressForwarder0, this.isCanceled, true);
        }
        finally {
            this.priorityTaskManager.remove(-1000);
        }
    }

    @Override  // com.google.android.exoplayer2.offline.Downloader
    public void remove() {
        CacheUtil.remove(this.dataSpec, this.cache, this.cacheKeyFactory);
    }
}

