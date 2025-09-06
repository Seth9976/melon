package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

@Deprecated
public final class ExtractorMediaSource extends CompositeMediaSource {
    @Deprecated
    public interface EventListener {
        void onLoadError(IOException arg1);
    }

    @Deprecated
    static final class EventListenerWrapper implements MediaSourceEventListener {
        private final EventListener eventListener;

        public EventListenerWrapper(EventListener extractorMediaSource$EventListener0) {
            this.eventListener = (EventListener)Assertions.checkNotNull(extractorMediaSource$EventListener0);
        }

        @Override  // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadError(int v, MediaPeriodId mediaSource$MediaPeriodId0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0, IOException iOException0, boolean z) {
            this.eventListener.onLoadError(iOException0);
        }
    }

    @Deprecated
    public static final class Factory implements MediaSourceFactory {
        private int continueLoadingCheckIntervalBytes;
        private String customCacheKey;
        private final com.google.android.exoplayer2.upstream.DataSource.Factory dataSourceFactory;
        private ExtractorsFactory extractorsFactory;
        private boolean isCreateCalled;
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
        private Object tag;

        public Factory(com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0) {
            this.dataSourceFactory = dataSource$Factory0;
            this.loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
            this.continueLoadingCheckIntervalBytes = 0x100000;
        }

        public ExtractorMediaSource createMediaSource(Uri uri0) {
            this.isCreateCalled = true;
            if(this.extractorsFactory == null) {
                this.extractorsFactory = new DefaultExtractorsFactory();
            }
            return new ExtractorMediaSource(uri0, this.dataSourceFactory, this.extractorsFactory, this.loadErrorHandlingPolicy, this.customCacheKey, this.continueLoadingCheckIntervalBytes, this.tag, null);
        }

        @Deprecated
        public ExtractorMediaSource createMediaSource(Uri uri0, Handler handler0, MediaSourceEventListener mediaSourceEventListener0) {
            ExtractorMediaSource extractorMediaSource0 = this.createMediaSource(uri0);
            if(handler0 != null && mediaSourceEventListener0 != null) {
                extractorMediaSource0.addEventListener(handler0, mediaSourceEventListener0);
            }
            return extractorMediaSource0;
        }

        @Override  // com.google.android.exoplayer2.source.MediaSourceFactory
        public MediaSource createMediaSource(Uri uri0) {
            return this.createMediaSource(uri0);
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

        @Deprecated
        public Factory setDrmSessionManager(DrmSessionManager drmSessionManager0) {
            throw new UnsupportedOperationException();
        }

        @Override  // com.google.android.exoplayer2.source.MediaSourceFactory
        @Deprecated
        public MediaSourceFactory setDrmSessionManager(DrmSessionManager drmSessionManager0) {
            return this.setDrmSessionManager(drmSessionManager0);
        }

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

        @Deprecated
        public Factory setMinLoadableRetryCount(int v) {
            return this.setLoadErrorHandlingPolicy(new DefaultLoadErrorHandlingPolicy(v));
        }

        public Factory setTag(Object object0) {
            Assertions.checkState(!this.isCreateCalled);
            this.tag = object0;
            return this;
        }
    }

    @Deprecated
    public static final int DEFAULT_LOADING_CHECK_INTERVAL_BYTES = 0x100000;
    private final ProgressiveMediaSource progressiveMediaSource;

    @Deprecated
    public ExtractorMediaSource(Uri uri0, com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0, ExtractorsFactory extractorsFactory0, Handler handler0, EventListener extractorMediaSource$EventListener0) {
        this(uri0, dataSource$Factory0, extractorsFactory0, handler0, extractorMediaSource$EventListener0, null);
    }

    @Deprecated
    public ExtractorMediaSource(Uri uri0, com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0, ExtractorsFactory extractorsFactory0, Handler handler0, EventListener extractorMediaSource$EventListener0, String s) {
        this(uri0, dataSource$Factory0, extractorsFactory0, handler0, extractorMediaSource$EventListener0, s, 0x100000);
    }

    @Deprecated
    public ExtractorMediaSource(Uri uri0, com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0, ExtractorsFactory extractorsFactory0, Handler handler0, EventListener extractorMediaSource$EventListener0, String s, int v) {
        this(uri0, dataSource$Factory0, extractorsFactory0, new DefaultLoadErrorHandlingPolicy(), s, v, null);
        if(extractorMediaSource$EventListener0 != null && handler0 != null) {
            this.addEventListener(handler0, new EventListenerWrapper(extractorMediaSource$EventListener0));
        }
    }

    private ExtractorMediaSource(Uri uri0, com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0, ExtractorsFactory extractorsFactory0, LoadErrorHandlingPolicy loadErrorHandlingPolicy0, String s, int v, Object object0) {
        this.progressiveMediaSource = new ProgressiveMediaSource(uri0, dataSource$Factory0, extractorsFactory0, DrmSessionManager.getDummyDrmSessionManager(), loadErrorHandlingPolicy0, s, v, object0);
    }

    public ExtractorMediaSource(Uri uri0, com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0, ExtractorsFactory extractorsFactory0, LoadErrorHandlingPolicy loadErrorHandlingPolicy0, String s, int v, Object object0, com.google.android.exoplayer2.source.ExtractorMediaSource.1 extractorMediaSource$10) {
        this(uri0, dataSource$Factory0, extractorsFactory0, loadErrorHandlingPolicy0, s, v, object0);
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaPeriodId mediaSource$MediaPeriodId0, Allocator allocator0, long v) {
        return this.progressiveMediaSource.createPeriod(mediaSource$MediaPeriodId0, allocator0, v);
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public Object getTag() {
        return this.progressiveMediaSource.getTag();
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public void onChildSourceInfoRefreshed(Object object0, MediaSource mediaSource0, Timeline timeline0) {
        this.onChildSourceInfoRefreshed(((Void)object0), mediaSource0, timeline0);
    }

    public void onChildSourceInfoRefreshed(Void void0, MediaSource mediaSource0, Timeline timeline0) {
        this.refreshSourceInfo(timeline0);
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public void prepareSourceInternal(TransferListener transferListener0) {
        super.prepareSourceInternal(transferListener0);
        this.prepareChildSource(null, this.progressiveMediaSource);
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod0) {
        this.progressiveMediaSource.releasePeriod(mediaPeriod0);
    }

    class com.google.android.exoplayer2.source.ExtractorMediaSource.1 {
    }

}

