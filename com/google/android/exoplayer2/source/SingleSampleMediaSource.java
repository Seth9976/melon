package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

public final class SingleSampleMediaSource extends BaseMediaSource {
    @Deprecated
    public interface EventListener {
        void onLoadError(int arg1, IOException arg2);
    }

    @Deprecated
    static final class EventListenerWrapper implements MediaSourceEventListener {
        private final EventListener eventListener;
        private final int eventSourceId;

        public EventListenerWrapper(EventListener singleSampleMediaSource$EventListener0, int v) {
            this.eventListener = (EventListener)Assertions.checkNotNull(singleSampleMediaSource$EventListener0);
            this.eventSourceId = v;
        }

        @Override  // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadError(int v, MediaPeriodId mediaSource$MediaPeriodId0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0, IOException iOException0, boolean z) {
            this.eventListener.onLoadError(this.eventSourceId, iOException0);
        }
    }

    public static final class Factory {
        private final com.google.android.exoplayer2.upstream.DataSource.Factory dataSourceFactory;
        private boolean isCreateCalled;
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
        private Object tag;
        private boolean treatLoadErrorsAsEndOfStream;

        public Factory(com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0) {
            this.dataSourceFactory = (com.google.android.exoplayer2.upstream.DataSource.Factory)Assertions.checkNotNull(dataSource$Factory0);
            this.loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
        }

        public SingleSampleMediaSource createMediaSource(Uri uri0, Format format0, long v) {
            this.isCreateCalled = true;
            return new SingleSampleMediaSource(uri0, this.dataSourceFactory, format0, v, this.loadErrorHandlingPolicy, this.treatLoadErrorsAsEndOfStream, this.tag, null);
        }

        @Deprecated
        public SingleSampleMediaSource createMediaSource(Uri uri0, Format format0, long v, Handler handler0, MediaSourceEventListener mediaSourceEventListener0) {
            SingleSampleMediaSource singleSampleMediaSource0 = this.createMediaSource(uri0, format0, v);
            if(handler0 != null && mediaSourceEventListener0 != null) {
                singleSampleMediaSource0.addEventListener(handler0, mediaSourceEventListener0);
            }
            return singleSampleMediaSource0;
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

        public Factory setTreatLoadErrorsAsEndOfStream(boolean z) {
            Assertions.checkState(!this.isCreateCalled);
            this.treatLoadErrorsAsEndOfStream = z;
            return this;
        }
    }

    private final com.google.android.exoplayer2.upstream.DataSource.Factory dataSourceFactory;
    private final DataSpec dataSpec;
    private final long durationUs;
    private final Format format;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final Object tag;
    private final Timeline timeline;
    private TransferListener transferListener;
    private final boolean treatLoadErrorsAsEndOfStream;

    @Deprecated
    public SingleSampleMediaSource(Uri uri0, com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0, Format format0, long v) {
        this(uri0, dataSource$Factory0, format0, v, 3);
    }

    @Deprecated
    public SingleSampleMediaSource(Uri uri0, com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0, Format format0, long v, int v1) {
        this(uri0, dataSource$Factory0, format0, v, new DefaultLoadErrorHandlingPolicy(v1), false, null);
    }

    @Deprecated
    public SingleSampleMediaSource(Uri uri0, com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0, Format format0, long v, int v1, Handler handler0, EventListener singleSampleMediaSource$EventListener0, int v2, boolean z) {
        this(uri0, dataSource$Factory0, format0, v, new DefaultLoadErrorHandlingPolicy(v1), z, null);
        if(handler0 != null && singleSampleMediaSource$EventListener0 != null) {
            this.addEventListener(handler0, new EventListenerWrapper(singleSampleMediaSource$EventListener0, v2));
        }
    }

    private SingleSampleMediaSource(Uri uri0, com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0, Format format0, long v, LoadErrorHandlingPolicy loadErrorHandlingPolicy0, boolean z, Object object0) {
        this.dataSourceFactory = dataSource$Factory0;
        this.format = format0;
        this.durationUs = v;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy0;
        this.treatLoadErrorsAsEndOfStream = z;
        this.tag = object0;
        this.dataSpec = new DataSpec(uri0, 1);
        this.timeline = new SinglePeriodTimeline(v, true, false, false, null, object0);
    }

    public SingleSampleMediaSource(Uri uri0, com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0, Format format0, long v, LoadErrorHandlingPolicy loadErrorHandlingPolicy0, boolean z, Object object0, com.google.android.exoplayer2.source.SingleSampleMediaSource.1 singleSampleMediaSource$10) {
        this(uri0, dataSource$Factory0, format0, v, loadErrorHandlingPolicy0, z, object0);
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaPeriodId mediaSource$MediaPeriodId0, Allocator allocator0, long v) {
        TransferListener transferListener0 = this.transferListener;
        EventDispatcher mediaSourceEventListener$EventDispatcher0 = this.createEventDispatcher(mediaSource$MediaPeriodId0);
        return new SingleSampleMediaPeriod(this.dataSpec, this.dataSourceFactory, transferListener0, this.format, this.durationUs, this.loadErrorHandlingPolicy, mediaSourceEventListener$EventDispatcher0, this.treatLoadErrorsAsEndOfStream);
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public Object getTag() {
        return this.tag;
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override  // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(TransferListener transferListener0) {
        this.transferListener = transferListener0;
        this.refreshSourceInfo(this.timeline);
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod0) {
        ((SingleSampleMediaPeriod)mediaPeriod0).release();
    }

    @Override  // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
    }

    class com.google.android.exoplayer2.source.SingleSampleMediaSource.1 {
    }

}

