package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.HashMap;

public abstract class CompositeMediaSource extends BaseMediaSource {
    final class ForwardingEventListener implements MediaSourceEventListener {
        private EventDispatcher eventDispatcher;
        private final Object id;

        public ForwardingEventListener(Object object0) {
            this.eventDispatcher = compositeMediaSource0.createEventDispatcher(null);
            this.id = object0;
        }

        private boolean maybeUpdateEventDispatcher(int v, MediaPeriodId mediaSource$MediaPeriodId0) {
            MediaPeriodId mediaSource$MediaPeriodId1;
            if(mediaSource$MediaPeriodId0 == null) {
                mediaSource$MediaPeriodId1 = null;
            }
            else {
                mediaSource$MediaPeriodId1 = CompositeMediaSource.this.getMediaPeriodIdForChildMediaPeriodId(this.id, mediaSource$MediaPeriodId0);
                if(mediaSource$MediaPeriodId1 == null) {
                    return false;
                }
            }
            int v1 = CompositeMediaSource.this.getWindowIndexForChildWindowIndex(this.id, v);
            if(this.eventDispatcher.windowIndex != v1 || !Util.areEqual(this.eventDispatcher.mediaPeriodId, mediaSource$MediaPeriodId1)) {
                this.eventDispatcher = CompositeMediaSource.this.createEventDispatcher(v1, mediaSource$MediaPeriodId1, 0L);
            }
            return true;
        }

        private MediaLoadData maybeUpdateMediaLoadData(MediaLoadData mediaSourceEventListener$MediaLoadData0) {
            long v = CompositeMediaSource.this.getMediaTimeForChildMediaTime(this.id, mediaSourceEventListener$MediaLoadData0.mediaStartTimeMs);
            long v1 = CompositeMediaSource.this.getMediaTimeForChildMediaTime(this.id, mediaSourceEventListener$MediaLoadData0.mediaEndTimeMs);
            return v != mediaSourceEventListener$MediaLoadData0.mediaStartTimeMs || v1 != mediaSourceEventListener$MediaLoadData0.mediaEndTimeMs ? new MediaLoadData(mediaSourceEventListener$MediaLoadData0.dataType, mediaSourceEventListener$MediaLoadData0.trackType, mediaSourceEventListener$MediaLoadData0.trackFormat, mediaSourceEventListener$MediaLoadData0.trackSelectionReason, mediaSourceEventListener$MediaLoadData0.trackSelectionData, v, v1) : mediaSourceEventListener$MediaLoadData0;
        }

        @Override  // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onDownstreamFormatChanged(int v, MediaPeriodId mediaSource$MediaPeriodId0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
            if(this.maybeUpdateEventDispatcher(v, mediaSource$MediaPeriodId0)) {
                this.eventDispatcher.downstreamFormatChanged(this.maybeUpdateMediaLoadData(mediaSourceEventListener$MediaLoadData0));
            }
        }

        @Override  // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadCanceled(int v, MediaPeriodId mediaSource$MediaPeriodId0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
            if(this.maybeUpdateEventDispatcher(v, mediaSource$MediaPeriodId0)) {
                this.eventDispatcher.loadCanceled(mediaSourceEventListener$LoadEventInfo0, this.maybeUpdateMediaLoadData(mediaSourceEventListener$MediaLoadData0));
            }
        }

        @Override  // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadCompleted(int v, MediaPeriodId mediaSource$MediaPeriodId0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
            if(this.maybeUpdateEventDispatcher(v, mediaSource$MediaPeriodId0)) {
                this.eventDispatcher.loadCompleted(mediaSourceEventListener$LoadEventInfo0, this.maybeUpdateMediaLoadData(mediaSourceEventListener$MediaLoadData0));
            }
        }

        @Override  // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadError(int v, MediaPeriodId mediaSource$MediaPeriodId0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0, IOException iOException0, boolean z) {
            if(this.maybeUpdateEventDispatcher(v, mediaSource$MediaPeriodId0)) {
                this.eventDispatcher.loadError(mediaSourceEventListener$LoadEventInfo0, this.maybeUpdateMediaLoadData(mediaSourceEventListener$MediaLoadData0), iOException0, z);
            }
        }

        @Override  // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onLoadStarted(int v, MediaPeriodId mediaSource$MediaPeriodId0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
            if(this.maybeUpdateEventDispatcher(v, mediaSource$MediaPeriodId0)) {
                this.eventDispatcher.loadStarted(mediaSourceEventListener$LoadEventInfo0, this.maybeUpdateMediaLoadData(mediaSourceEventListener$MediaLoadData0));
            }
        }

        @Override  // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onMediaPeriodCreated(int v, MediaPeriodId mediaSource$MediaPeriodId0) {
            if(this.maybeUpdateEventDispatcher(v, mediaSource$MediaPeriodId0)) {
                MediaPeriodId mediaSource$MediaPeriodId1 = (MediaPeriodId)Assertions.checkNotNull(this.eventDispatcher.mediaPeriodId);
                if(CompositeMediaSource.this.shouldDispatchCreateOrReleaseEvent(mediaSource$MediaPeriodId1)) {
                    this.eventDispatcher.mediaPeriodCreated();
                }
            }
        }

        @Override  // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onMediaPeriodReleased(int v, MediaPeriodId mediaSource$MediaPeriodId0) {
            if(this.maybeUpdateEventDispatcher(v, mediaSource$MediaPeriodId0)) {
                MediaPeriodId mediaSource$MediaPeriodId1 = (MediaPeriodId)Assertions.checkNotNull(this.eventDispatcher.mediaPeriodId);
                if(CompositeMediaSource.this.shouldDispatchCreateOrReleaseEvent(mediaSource$MediaPeriodId1)) {
                    this.eventDispatcher.mediaPeriodReleased();
                }
            }
        }

        @Override  // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onReadingStarted(int v, MediaPeriodId mediaSource$MediaPeriodId0) {
            if(this.maybeUpdateEventDispatcher(v, mediaSource$MediaPeriodId0)) {
                this.eventDispatcher.readingStarted();
            }
        }

        @Override  // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void onUpstreamDiscarded(int v, MediaPeriodId mediaSource$MediaPeriodId0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
            if(this.maybeUpdateEventDispatcher(v, mediaSource$MediaPeriodId0)) {
                this.eventDispatcher.upstreamDiscarded(this.maybeUpdateMediaLoadData(mediaSourceEventListener$MediaLoadData0));
            }
        }
    }

    static final class MediaSourceAndListener {
        public final MediaSourceCaller caller;
        public final MediaSourceEventListener eventListener;
        public final MediaSource mediaSource;

        public MediaSourceAndListener(MediaSource mediaSource0, MediaSourceCaller mediaSource$MediaSourceCaller0, MediaSourceEventListener mediaSourceEventListener0) {
            this.mediaSource = mediaSource0;
            this.caller = mediaSource$MediaSourceCaller0;
            this.eventListener = mediaSourceEventListener0;
        }
    }

    private final HashMap childSources;
    private Handler eventHandler;
    private TransferListener mediaTransferListener;

    public CompositeMediaSource() {
        this.childSources = new HashMap();
    }

    public final void disableChildSource(Object object0) {
        MediaSourceAndListener compositeMediaSource$MediaSourceAndListener0 = (MediaSourceAndListener)Assertions.checkNotNull(((MediaSourceAndListener)this.childSources.get(object0)));
        compositeMediaSource$MediaSourceAndListener0.mediaSource.disable(compositeMediaSource$MediaSourceAndListener0.caller);
    }

    @Override  // com.google.android.exoplayer2.source.BaseMediaSource
    public void disableInternal() {
        for(Object object0: this.childSources.values()) {
            ((MediaSourceAndListener)object0).mediaSource.disable(((MediaSourceAndListener)object0).caller);
        }
    }

    public final void enableChildSource(Object object0) {
        MediaSourceAndListener compositeMediaSource$MediaSourceAndListener0 = (MediaSourceAndListener)Assertions.checkNotNull(((MediaSourceAndListener)this.childSources.get(object0)));
        compositeMediaSource$MediaSourceAndListener0.mediaSource.enable(compositeMediaSource$MediaSourceAndListener0.caller);
    }

    @Override  // com.google.android.exoplayer2.source.BaseMediaSource
    public void enableInternal() {
        for(Object object0: this.childSources.values()) {
            ((MediaSourceAndListener)object0).mediaSource.enable(((MediaSourceAndListener)object0).caller);
        }
    }

    public MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Object object0, MediaPeriodId mediaSource$MediaPeriodId0) {
        return mediaSource$MediaPeriodId0;
    }

    public long getMediaTimeForChildMediaTime(Object object0, long v) {
        return v;
    }

    public int getWindowIndexForChildWindowIndex(Object object0, int v) {
        return v;
    }

    private void lambda$prepareChildSource$0(Object object0, MediaSource mediaSource0, Timeline timeline0) {
        this.onChildSourceInfoRefreshed(object0, mediaSource0, timeline0);
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
        for(Object object0: this.childSources.values()) {
            ((MediaSourceAndListener)object0).mediaSource.maybeThrowSourceInfoRefreshError();
        }
    }

    public abstract void onChildSourceInfoRefreshed(Object arg1, MediaSource arg2, Timeline arg3);

    public final void prepareChildSource(Object object0, MediaSource mediaSource0) {
        Assertions.checkArgument(!this.childSources.containsKey(object0));
        a a0 = new a(this, object0);
        ForwardingEventListener compositeMediaSource$ForwardingEventListener0 = new ForwardingEventListener(this, object0);
        MediaSourceAndListener compositeMediaSource$MediaSourceAndListener0 = new MediaSourceAndListener(mediaSource0, a0, compositeMediaSource$ForwardingEventListener0);
        this.childSources.put(object0, compositeMediaSource$MediaSourceAndListener0);
        mediaSource0.addEventListener(((Handler)Assertions.checkNotNull(this.eventHandler)), compositeMediaSource$ForwardingEventListener0);
        mediaSource0.prepareSource(a0, this.mediaTransferListener);
        if(!this.isEnabled()) {
            mediaSource0.disable(a0);
        }
    }

    @Override  // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(TransferListener transferListener0) {
        this.mediaTransferListener = transferListener0;
        this.eventHandler = new Handler();
    }

    public final void releaseChildSource(Object object0) {
        MediaSourceAndListener compositeMediaSource$MediaSourceAndListener0 = (MediaSourceAndListener)Assertions.checkNotNull(((MediaSourceAndListener)this.childSources.remove(object0)));
        compositeMediaSource$MediaSourceAndListener0.mediaSource.releaseSource(compositeMediaSource$MediaSourceAndListener0.caller);
        compositeMediaSource$MediaSourceAndListener0.mediaSource.removeEventListener(compositeMediaSource$MediaSourceAndListener0.eventListener);
    }

    @Override  // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        for(Object object0: this.childSources.values()) {
            ((MediaSourceAndListener)object0).mediaSource.releaseSource(((MediaSourceAndListener)object0).caller);
            ((MediaSourceAndListener)object0).mediaSource.removeEventListener(((MediaSourceAndListener)object0).eventListener);
        }
        this.childSources.clear();
    }

    public boolean shouldDispatchCreateOrReleaseEvent(MediaPeriodId mediaSource$MediaPeriodId0) {
        return true;
    }
}

