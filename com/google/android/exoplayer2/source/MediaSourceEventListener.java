package com.google.android.exoplayer2.source;

import D5.a;
import I7.k;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.media3.exoplayer.W;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public interface MediaSourceEventListener {
    public static final class EventDispatcher {
        static final class ListenerAndHandler {
            public final Handler handler;
            public final MediaSourceEventListener listener;

            public ListenerAndHandler(Handler handler0, MediaSourceEventListener mediaSourceEventListener0) {
                this.handler = handler0;
                this.listener = mediaSourceEventListener0;
            }
        }

        private final CopyOnWriteArrayList listenerAndHandlers;
        public final MediaPeriodId mediaPeriodId;
        private final long mediaTimeOffsetMs;
        public final int windowIndex;

        public EventDispatcher() {
            this(new CopyOnWriteArrayList(), 0, null, 0L);
        }

        private EventDispatcher(CopyOnWriteArrayList copyOnWriteArrayList0, int v, MediaPeriodId mediaSource$MediaPeriodId0, long v1) {
            this.listenerAndHandlers = copyOnWriteArrayList0;
            this.windowIndex = v;
            this.mediaPeriodId = mediaSource$MediaPeriodId0;
            this.mediaTimeOffsetMs = v1;
        }

        public void addEventListener(Handler handler0, MediaSourceEventListener mediaSourceEventListener0) {
            Assertions.checkArgument(handler0 != null && mediaSourceEventListener0 != null);
            ListenerAndHandler mediaSourceEventListener$EventDispatcher$ListenerAndHandler0 = new ListenerAndHandler(handler0, mediaSourceEventListener0);
            this.listenerAndHandlers.add(mediaSourceEventListener$EventDispatcher$ListenerAndHandler0);
        }

        private long adjustMediaTime(long v) {
            long v1 = C.usToMs(v);
            return v1 == 0x8000000000000001L ? 0x8000000000000001L : this.mediaTimeOffsetMs + v1;
        }

        public static void c(EventDispatcher mediaSourceEventListener$EventDispatcher0, MediaSourceEventListener mediaSourceEventListener0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
            mediaSourceEventListener$EventDispatcher0.lambda$downstreamFormatChanged$8(mediaSourceEventListener0, mediaSourceEventListener$MediaLoadData0);
        }

        public void downstreamFormatChanged(int v, Format format0, int v1, Object object0, long v2) {
            this.downstreamFormatChanged(new MediaLoadData(1, v, format0, v1, object0, this.adjustMediaTime(v2), 0x8000000000000001L));
        }

        public void downstreamFormatChanged(MediaLoadData mediaSourceEventListener$MediaLoadData0) {
            for(Object object0: this.listenerAndHandlers) {
                k k0 = new k(this, ((ListenerAndHandler)object0).listener, mediaSourceEventListener$MediaLoadData0, 24);
                this.postOrRun(((ListenerAndHandler)object0).handler, k0);
            }
        }

        public static void i(EventDispatcher mediaSourceEventListener$EventDispatcher0, MediaSourceEventListener mediaSourceEventListener0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0, IOException iOException0, boolean z) {
            mediaSourceEventListener$EventDispatcher0.lambda$loadError$5(mediaSourceEventListener0, mediaSourceEventListener$LoadEventInfo0, mediaSourceEventListener$MediaLoadData0, iOException0, z);
        }

        private void lambda$downstreamFormatChanged$8(MediaSourceEventListener mediaSourceEventListener0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
            mediaSourceEventListener0.onDownstreamFormatChanged(this.windowIndex, this.mediaPeriodId, mediaSourceEventListener$MediaLoadData0);
        }

        private void lambda$loadCanceled$4(MediaSourceEventListener mediaSourceEventListener0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
            mediaSourceEventListener0.onLoadCanceled(this.windowIndex, this.mediaPeriodId, mediaSourceEventListener$LoadEventInfo0, mediaSourceEventListener$MediaLoadData0);
        }

        private void lambda$loadCompleted$3(MediaSourceEventListener mediaSourceEventListener0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
            mediaSourceEventListener0.onLoadCompleted(this.windowIndex, this.mediaPeriodId, mediaSourceEventListener$LoadEventInfo0, mediaSourceEventListener$MediaLoadData0);
        }

        private void lambda$loadError$5(MediaSourceEventListener mediaSourceEventListener0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0, IOException iOException0, boolean z) {
            mediaSourceEventListener0.onLoadError(this.windowIndex, this.mediaPeriodId, mediaSourceEventListener$LoadEventInfo0, mediaSourceEventListener$MediaLoadData0, iOException0, z);
        }

        private void lambda$loadStarted$2(MediaSourceEventListener mediaSourceEventListener0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
            mediaSourceEventListener0.onLoadStarted(this.windowIndex, this.mediaPeriodId, mediaSourceEventListener$LoadEventInfo0, mediaSourceEventListener$MediaLoadData0);
        }

        private void lambda$mediaPeriodCreated$0(MediaSourceEventListener mediaSourceEventListener0, MediaPeriodId mediaSource$MediaPeriodId0) {
            mediaSourceEventListener0.onMediaPeriodCreated(this.windowIndex, mediaSource$MediaPeriodId0);
        }

        private void lambda$mediaPeriodReleased$1(MediaSourceEventListener mediaSourceEventListener0, MediaPeriodId mediaSource$MediaPeriodId0) {
            mediaSourceEventListener0.onMediaPeriodReleased(this.windowIndex, mediaSource$MediaPeriodId0);
        }

        private void lambda$readingStarted$6(MediaSourceEventListener mediaSourceEventListener0, MediaPeriodId mediaSource$MediaPeriodId0) {
            mediaSourceEventListener0.onReadingStarted(this.windowIndex, mediaSource$MediaPeriodId0);
        }

        private void lambda$upstreamDiscarded$7(MediaSourceEventListener mediaSourceEventListener0, MediaPeriodId mediaSource$MediaPeriodId0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
            mediaSourceEventListener0.onUpstreamDiscarded(this.windowIndex, mediaSource$MediaPeriodId0, mediaSourceEventListener$MediaLoadData0);
        }

        public void loadCanceled(LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
            for(Object object0: this.listenerAndHandlers) {
                d d0 = new d(this, ((ListenerAndHandler)object0).listener, mediaSourceEventListener$LoadEventInfo0, mediaSourceEventListener$MediaLoadData0, 2);
                this.postOrRun(((ListenerAndHandler)object0).handler, d0);
            }
        }

        public void loadCanceled(DataSpec dataSpec0, Uri uri0, Map map0, int v, int v1, Format format0, int v2, Object object0, long v3, long v4, long v5, long v6, long v7) {
            this.loadCanceled(new LoadEventInfo(dataSpec0, uri0, map0, v5, v6, v7), new MediaLoadData(v, v1, format0, v2, object0, this.adjustMediaTime(v3), this.adjustMediaTime(v4)));
        }

        public void loadCanceled(DataSpec dataSpec0, Uri uri0, Map map0, int v, long v1, long v2, long v3) {
            this.loadCanceled(dataSpec0, uri0, map0, v, -1, null, 0, null, 0x8000000000000001L, 0x8000000000000001L, v1, v2, v3);
        }

        public void loadCompleted(LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
            for(Object object0: this.listenerAndHandlers) {
                d d0 = new d(this, ((ListenerAndHandler)object0).listener, mediaSourceEventListener$LoadEventInfo0, mediaSourceEventListener$MediaLoadData0, 0);
                this.postOrRun(((ListenerAndHandler)object0).handler, d0);
            }
        }

        public void loadCompleted(DataSpec dataSpec0, Uri uri0, Map map0, int v, int v1, Format format0, int v2, Object object0, long v3, long v4, long v5, long v6, long v7) {
            this.loadCompleted(new LoadEventInfo(dataSpec0, uri0, map0, v5, v6, v7), new MediaLoadData(v, v1, format0, v2, object0, this.adjustMediaTime(v3), this.adjustMediaTime(v4)));
        }

        public void loadCompleted(DataSpec dataSpec0, Uri uri0, Map map0, int v, long v1, long v2, long v3) {
            this.loadCompleted(dataSpec0, uri0, map0, v, -1, null, 0, null, 0x8000000000000001L, 0x8000000000000001L, v1, v2, v3);
        }

        public void loadError(LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0, IOException iOException0, boolean z) {
            for(Object object0: this.listenerAndHandlers) {
                W w0 = new W(this, ((ListenerAndHandler)object0).listener, mediaSourceEventListener$LoadEventInfo0, mediaSourceEventListener$MediaLoadData0, iOException0, z, 1);
                this.postOrRun(((ListenerAndHandler)object0).handler, w0);
            }
        }

        public void loadError(DataSpec dataSpec0, Uri uri0, Map map0, int v, int v1, Format format0, int v2, Object object0, long v3, long v4, long v5, long v6, long v7, IOException iOException0, boolean z) {
            this.loadError(new LoadEventInfo(dataSpec0, uri0, map0, v5, v6, v7), new MediaLoadData(v, v1, format0, v2, object0, this.adjustMediaTime(v3), this.adjustMediaTime(v4)), iOException0, z);
        }

        public void loadError(DataSpec dataSpec0, Uri uri0, Map map0, int v, long v1, long v2, long v3, IOException iOException0, boolean z) {
            this.loadError(dataSpec0, uri0, map0, v, -1, null, 0, null, 0x8000000000000001L, 0x8000000000000001L, v1, v2, v3, iOException0, z);
        }

        public void loadStarted(LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
            for(Object object0: this.listenerAndHandlers) {
                d d0 = new d(this, ((ListenerAndHandler)object0).listener, mediaSourceEventListener$LoadEventInfo0, mediaSourceEventListener$MediaLoadData0, 1);
                this.postOrRun(((ListenerAndHandler)object0).handler, d0);
            }
        }

        public void loadStarted(DataSpec dataSpec0, int v, int v1, Format format0, int v2, Object object0, long v3, long v4, long v5) {
            this.loadStarted(new LoadEventInfo(dataSpec0, dataSpec0.uri, Collections.EMPTY_MAP, v5, 0L, 0L), new MediaLoadData(v, v1, format0, v2, object0, this.adjustMediaTime(v3), this.adjustMediaTime(v4)));
        }

        public void loadStarted(DataSpec dataSpec0, int v, long v1) {
            this.loadStarted(dataSpec0, v, -1, null, 0, null, 0x8000000000000001L, 0x8000000000000001L, v1);
        }

        public void mediaPeriodCreated() {
            MediaPeriodId mediaSource$MediaPeriodId0 = (MediaPeriodId)Assertions.checkNotNull(this.mediaPeriodId);
            for(Object object0: this.listenerAndHandlers) {
                c c0 = new c(this, ((ListenerAndHandler)object0).listener, mediaSource$MediaPeriodId0, 2);
                this.postOrRun(((ListenerAndHandler)object0).handler, c0);
            }
        }

        public void mediaPeriodReleased() {
            MediaPeriodId mediaSource$MediaPeriodId0 = (MediaPeriodId)Assertions.checkNotNull(this.mediaPeriodId);
            for(Object object0: this.listenerAndHandlers) {
                c c0 = new c(this, ((ListenerAndHandler)object0).listener, mediaSource$MediaPeriodId0, 0);
                this.postOrRun(((ListenerAndHandler)object0).handler, c0);
            }
        }

        private void postOrRun(Handler handler0, Runnable runnable0) {
            if(handler0.getLooper() == Looper.myLooper()) {
                runnable0.run();
                return;
            }
            handler0.post(runnable0);
        }

        public void readingStarted() {
            MediaPeriodId mediaSource$MediaPeriodId0 = (MediaPeriodId)Assertions.checkNotNull(this.mediaPeriodId);
            for(Object object0: this.listenerAndHandlers) {
                c c0 = new c(this, ((ListenerAndHandler)object0).listener, mediaSource$MediaPeriodId0, 1);
                this.postOrRun(((ListenerAndHandler)object0).handler, c0);
            }
        }

        public void removeEventListener(MediaSourceEventListener mediaSourceEventListener0) {
            for(Object object0: this.listenerAndHandlers) {
                ListenerAndHandler mediaSourceEventListener$EventDispatcher$ListenerAndHandler0 = (ListenerAndHandler)object0;
                if(mediaSourceEventListener$EventDispatcher$ListenerAndHandler0.listener == mediaSourceEventListener0) {
                    this.listenerAndHandlers.remove(mediaSourceEventListener$EventDispatcher$ListenerAndHandler0);
                }
            }
        }

        public void upstreamDiscarded(int v, long v1, long v2) {
            this.upstreamDiscarded(new MediaLoadData(1, v, null, 3, null, this.adjustMediaTime(v1), this.adjustMediaTime(v2)));
        }

        public void upstreamDiscarded(MediaLoadData mediaSourceEventListener$MediaLoadData0) {
            Object object0 = Assertions.checkNotNull(this.mediaPeriodId);
            for(Object object1: this.listenerAndHandlers) {
                a a0 = new a(this, ((ListenerAndHandler)object1).listener, ((MediaPeriodId)object0), mediaSourceEventListener$MediaLoadData0, 19);
                this.postOrRun(((ListenerAndHandler)object1).handler, a0);
            }
        }

        public EventDispatcher withParameters(int v, MediaPeriodId mediaSource$MediaPeriodId0, long v1) {
            return new EventDispatcher(this.listenerAndHandlers, v, mediaSource$MediaPeriodId0, v1);
        }
    }

    public static final class LoadEventInfo {
        public final long bytesLoaded;
        public final DataSpec dataSpec;
        public final long elapsedRealtimeMs;
        public final long loadDurationMs;
        public final Map responseHeaders;
        public final Uri uri;

        public LoadEventInfo(DataSpec dataSpec0, Uri uri0, Map map0, long v, long v1, long v2) {
            this.dataSpec = dataSpec0;
            this.uri = uri0;
            this.responseHeaders = map0;
            this.elapsedRealtimeMs = v;
            this.loadDurationMs = v1;
            this.bytesLoaded = v2;
        }
    }

    public static final class MediaLoadData {
        public final int dataType;
        public final long mediaEndTimeMs;
        public final long mediaStartTimeMs;
        public final Format trackFormat;
        public final Object trackSelectionData;
        public final int trackSelectionReason;
        public final int trackType;

        public MediaLoadData(int v, int v1, Format format0, int v2, Object object0, long v3, long v4) {
            this.dataType = v;
            this.trackType = v1;
            this.trackFormat = format0;
            this.trackSelectionReason = v2;
            this.trackSelectionData = object0;
            this.mediaStartTimeMs = v3;
            this.mediaEndTimeMs = v4;
        }
    }

    default void onDownstreamFormatChanged(int v, MediaPeriodId mediaSource$MediaPeriodId0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
    }

    default void onLoadCanceled(int v, MediaPeriodId mediaSource$MediaPeriodId0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
    }

    default void onLoadCompleted(int v, MediaPeriodId mediaSource$MediaPeriodId0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
    }

    default void onLoadError(int v, MediaPeriodId mediaSource$MediaPeriodId0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0, IOException iOException0, boolean z) {
    }

    default void onLoadStarted(int v, MediaPeriodId mediaSource$MediaPeriodId0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
    }

    default void onMediaPeriodCreated(int v, MediaPeriodId mediaSource$MediaPeriodId0) {
    }

    default void onMediaPeriodReleased(int v, MediaPeriodId mediaSource$MediaPeriodId0) {
    }

    default void onReadingStarted(int v, MediaPeriodId mediaSource$MediaPeriodId0) {
    }

    default void onUpstreamDiscarded(int v, MediaPeriodId mediaSource$MediaPeriodId0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
    }
}

