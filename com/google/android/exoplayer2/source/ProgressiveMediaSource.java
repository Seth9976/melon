package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;

public final class ProgressiveMediaSource extends BaseMediaSource implements Listener {
    public static final class Factory implements MediaSourceFactory {
        private int continueLoadingCheckIntervalBytes;
        private String customCacheKey;
        private final com.google.android.exoplayer2.upstream.DataSource.Factory dataSourceFactory;
        private DrmSessionManager drmSessionManager;
        private ExtractorsFactory extractorsFactory;
        private boolean isCreateCalled;
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
        private Object tag;

        public Factory(com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0) {
            this(dataSource$Factory0, new DefaultExtractorsFactory());
        }

        public Factory(com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0, ExtractorsFactory extractorsFactory0) {
            this.dataSourceFactory = dataSource$Factory0;
            this.extractorsFactory = extractorsFactory0;
            this.drmSessionManager = DrmSessionManager.getDummyDrmSessionManager();
            this.loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
            this.continueLoadingCheckIntervalBytes = 0x100000;
        }

        @Override  // com.google.android.exoplayer2.source.MediaSourceFactory
        public MediaSource createMediaSource(Uri uri0) {
            return this.createMediaSource(uri0);
        }

        public ProgressiveMediaSource createMediaSource(Uri uri0) {
            this.isCreateCalled = true;
            return new ProgressiveMediaSource(uri0, this.dataSourceFactory, this.extractorsFactory, this.drmSessionManager, this.loadErrorHandlingPolicy, this.customCacheKey, this.continueLoadingCheckIntervalBytes, this.tag);
        }

        @Override  // com.google.android.exoplayer2.source.MediaSourceFactory
        public int[] getSupportedTypes() {
            return new int[]{3};
        }

        public Factory setContinueLoadingCheckIntervalBytes(int v) {
            Assertions.checkState(!this.isCreateCalled);
            this.continueLoadingCheckIntervalBytes = v;
            return this;
        }

        public Factory setCustomCacheKey(String s) {
            Assertions.checkState(!this.isCreateCalled);
            this.customCacheKey = s;
            return this;
        }

        @Override  // com.google.android.exoplayer2.source.MediaSourceFactory
        public MediaSourceFactory setDrmSessionManager(DrmSessionManager drmSessionManager0) {
            return this.setDrmSessionManager(drmSessionManager0);
        }

        public Factory setDrmSessionManager(DrmSessionManager drmSessionManager0) {
            Assertions.checkState(!this.isCreateCalled);
            if(drmSessionManager0 == null) {
                drmSessionManager0 = DrmSessionManager.getDummyDrmSessionManager();
            }
            this.drmSessionManager = drmSessionManager0;
            return this;
        }

        @Deprecated
        public Factory setExtractorsFactory(ExtractorsFactory extractorsFactory0) {
            Assertions.checkState(!this.isCreateCalled);
            this.extractorsFactory = extractorsFactory0;
            return this;
        }

        public Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy0) {
            Assertions.checkState(!this.isCreateCalled);
            this.loadErrorHandlingPolicy = loadErrorHandlingPolicy0;
            return this;
        }

        public Factory setTag(Object object0) {
            Assertions.checkState(!this.isCreateCalled);
            this.tag = object0;
            return this;
        }
    }

    public static final int DEFAULT_LOADING_CHECK_INTERVAL_BYTES = 0x100000;
    private final int continueLoadingCheckIntervalBytes;
    private final String customCacheKey;
    private final com.google.android.exoplayer2.upstream.DataSource.Factory dataSourceFactory;
    private final DrmSessionManager drmSessionManager;
    private final ExtractorsFactory extractorsFactory;
    private final LoadErrorHandlingPolicy loadableLoadErrorHandlingPolicy;
    private final Object tag;
    private long timelineDurationUs;
    private boolean timelineIsLive;
    private boolean timelineIsSeekable;
    private TransferListener transferListener;
    private final Uri uri;

    public ProgressiveMediaSource(Uri uri0, com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0, ExtractorsFactory extractorsFactory0, DrmSessionManager drmSessionManager0, LoadErrorHandlingPolicy loadErrorHandlingPolicy0, String s, int v, Object object0) {
        this.uri = uri0;
        this.dataSourceFactory = dataSource$Factory0;
        this.extractorsFactory = extractorsFactory0;
        this.drmSessionManager = drmSessionManager0;
        this.loadableLoadErrorHandlingPolicy = loadErrorHandlingPolicy0;
        this.customCacheKey = s;
        this.continueLoadingCheckIntervalBytes = v;
        this.timelineDurationUs = 0x8000000000000001L;
        this.tag = object0;
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaPeriodId mediaSource$MediaPeriodId0, Allocator allocator0, long v) {
        DataSource dataSource0 = this.dataSourceFactory.createDataSource();
        TransferListener transferListener0 = this.transferListener;
        if(transferListener0 != null) {
            dataSource0.addTransferListener(transferListener0);
        }
        Extractor[] arr_extractor = this.extractorsFactory.createExtractors();
        EventDispatcher mediaSourceEventListener$EventDispatcher0 = this.createEventDispatcher(mediaSource$MediaPeriodId0);
        return new ProgressiveMediaPeriod(this.uri, dataSource0, arr_extractor, this.drmSessionManager, this.loadableLoadErrorHandlingPolicy, mediaSourceEventListener$EventDispatcher0, this, allocator0, this.customCacheKey, this.continueLoadingCheckIntervalBytes);
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public Object getTag() {
        return this.tag;
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    private void notifySourceInfoRefreshed(long v, boolean z, boolean z1) {
        this.timelineDurationUs = v;
        this.timelineIsSeekable = z;
        this.timelineIsLive = z1;
        this.refreshSourceInfo(new SinglePeriodTimeline(this.timelineDurationUs, this.timelineIsSeekable, false, this.timelineIsLive, null, this.tag));
    }

    @Override  // com.google.android.exoplayer2.source.ProgressiveMediaPeriod$Listener
    public void onSourceInfoRefreshed(long v, boolean z, boolean z1) {
        if(v == 0x8000000000000001L) {
            v = this.timelineDurationUs;
        }
        if(this.timelineDurationUs == v && this.timelineIsSeekable == z && this.timelineIsLive == z1) {
            return;
        }
        this.notifySourceInfoRefreshed(v, z, z1);
    }

    @Override  // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(TransferListener transferListener0) {
        this.transferListener = transferListener0;
        this.drmSessionManager.prepare();
        this.notifySourceInfoRefreshed(this.timelineDurationUs, this.timelineIsSeekable, this.timelineIsLive);
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod0) {
        ((ProgressiveMediaPeriod)mediaPeriod0).release();
    }

    @Override  // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        this.drmSessionManager.release();
    }
}

