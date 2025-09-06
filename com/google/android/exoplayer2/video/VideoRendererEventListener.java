package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.view.Surface;
import b.l;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import i.n.i.b.a.s.e.R3;

public interface VideoRendererEventListener {
    public static final class EventDispatcher {
        private final Handler handler;
        private final VideoRendererEventListener listener;

        public EventDispatcher(Handler handler0, VideoRendererEventListener videoRendererEventListener0) {
            this.handler = videoRendererEventListener0 == null ? null : ((Handler)Assertions.checkNotNull(handler0));
            this.listener = videoRendererEventListener0;
        }

        public static void a(EventDispatcher videoRendererEventListener$EventDispatcher0, DecoderCounters decoderCounters0) {
            videoRendererEventListener$EventDispatcher0.lambda$disabled$6(decoderCounters0);
        }

        public static void b(EventDispatcher videoRendererEventListener$EventDispatcher0, int v, long v1) {
            videoRendererEventListener$EventDispatcher0.lambda$droppedFrames$3(v, v1);
        }

        public static void c(EventDispatcher videoRendererEventListener$EventDispatcher0, Surface surface0) {
            videoRendererEventListener$EventDispatcher0.lambda$renderedFirstFrame$5(surface0);
        }

        public static void d(EventDispatcher videoRendererEventListener$EventDispatcher0, DecoderCounters decoderCounters0) {
            videoRendererEventListener$EventDispatcher0.lambda$enabled$0(decoderCounters0);
        }

        public void decoderInitialized(String s, long v, long v1) {
            Handler handler0 = this.handler;
            if(handler0 != null) {
                handler0.post(new a(this, s, v, v1, 1));
            }
        }

        public void disabled(DecoderCounters decoderCounters0) {
            Handler handler0 = this.handler;
            if(handler0 != null) {
                handler0.post(new b(this, decoderCounters0, 0));
            }
        }

        public void droppedFrames(int v, long v1) {
            Handler handler0 = this.handler;
            if(handler0 != null) {
                handler0.post(new R3(this, v, 2, v1));
            }
        }

        public static void e(EventDispatcher videoRendererEventListener$EventDispatcher0, String s, long v, long v1) {
            videoRendererEventListener$EventDispatcher0.lambda$decoderInitialized$1(s, v, v1);
        }

        public void enabled(DecoderCounters decoderCounters0) {
            Handler handler0 = this.handler;
            if(handler0 != null) {
                handler0.post(new b(this, decoderCounters0, 1));
            }
        }

        public static void f(EventDispatcher videoRendererEventListener$EventDispatcher0, int v, int v1, int v2, float f) {
            videoRendererEventListener$EventDispatcher0.lambda$videoSizeChanged$4(v, v1, v2, f);
        }

        public static void g(EventDispatcher videoRendererEventListener$EventDispatcher0, Format format0) {
            videoRendererEventListener$EventDispatcher0.lambda$inputFormatChanged$2(format0);
        }

        public void inputFormatChanged(Format format0) {
            Handler handler0 = this.handler;
            if(handler0 != null) {
                handler0.post(new l(18, this, format0));
            }
        }

        private void lambda$decoderInitialized$1(String s, long v, long v1) {
            this.listener.onVideoDecoderInitialized(s, v, v1);
        }

        private void lambda$disabled$6(DecoderCounters decoderCounters0) {
            this.listener.onVideoDisabled(decoderCounters0);
        }

        private void lambda$droppedFrames$3(int v, long v1) {
            this.listener.onDroppedFrames(v, v1);
        }

        private void lambda$enabled$0(DecoderCounters decoderCounters0) {
            this.listener.onVideoEnabled(decoderCounters0);
        }

        private void lambda$inputFormatChanged$2(Format format0) {
            this.listener.onVideoInputFormatChanged(format0);
        }

        private void lambda$renderedFirstFrame$5(Surface surface0) {
            this.listener.onRenderedFirstFrame(surface0);
        }

        private void lambda$videoSizeChanged$4(int v, int v1, int v2, float f) {
            ((VideoRendererEventListener)Util.castNonNull(this.listener)).onVideoSizeChanged(v, v1, v2, f);
        }

        public void renderedFirstFrame(Surface surface0) {
            Handler handler0 = this.handler;
            if(handler0 != null) {
                handler0.post(new l(17, this, surface0));
            }
        }

        public void videoSizeChanged(int v, int v1, int v2, float f) {
            Handler handler0 = this.handler;
            if(handler0 != null) {
                handler0.post(new com.google.android.exoplayer2.video.a(this, v, v1, v2, f));
            }
        }
    }

    default void onDroppedFrames(int v, long v1) {
    }

    default void onRenderedFirstFrame(Surface surface0) {
    }

    default void onVideoDecoderInitialized(String s, long v, long v1) {
    }

    default void onVideoDisabled(DecoderCounters decoderCounters0) {
    }

    default void onVideoEnabled(DecoderCounters decoderCounters0) {
    }

    default void onVideoInputFormatChanged(Format format0) {
    }

    default void onVideoSizeChanged(int v, int v1, int v2, float f) {
    }
}

