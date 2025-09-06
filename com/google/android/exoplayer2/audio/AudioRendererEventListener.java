package com.google.android.exoplayer2.audio;

import A6.d;
import android.os.Handler;
import b.l;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public interface AudioRendererEventListener {
    public static final class EventDispatcher {
        private final Handler handler;
        private final AudioRendererEventListener listener;

        public EventDispatcher(Handler handler0, AudioRendererEventListener audioRendererEventListener0) {
            this.handler = audioRendererEventListener0 == null ? null : ((Handler)Assertions.checkNotNull(handler0));
            this.listener = audioRendererEventListener0;
        }

        public static void a(EventDispatcher audioRendererEventListener$EventDispatcher0, int v, long v1, long v2) {
            audioRendererEventListener$EventDispatcher0.lambda$audioTrackUnderrun$3(v, v1, v2);
        }

        public void audioSessionId(int v) {
            Handler handler0 = this.handler;
            if(handler0 != null) {
                handler0.post(new d(this, v, 8));
            }
        }

        public void audioTrackUnderrun(int v, long v1, long v2) {
            Handler handler0 = this.handler;
            if(handler0 != null) {
                handler0.post(new c(this, v, 0, v1, v2));
            }
        }

        public static void b(EventDispatcher audioRendererEventListener$EventDispatcher0, DecoderCounters decoderCounters0) {
            audioRendererEventListener$EventDispatcher0.lambda$disabled$4(decoderCounters0);
        }

        public static void c(EventDispatcher audioRendererEventListener$EventDispatcher0, Format format0) {
            audioRendererEventListener$EventDispatcher0.lambda$inputFormatChanged$2(format0);
        }

        public static void d(EventDispatcher audioRendererEventListener$EventDispatcher0, DecoderCounters decoderCounters0) {
            audioRendererEventListener$EventDispatcher0.lambda$enabled$0(decoderCounters0);
        }

        public void decoderInitialized(String s, long v, long v1) {
            Handler handler0 = this.handler;
            if(handler0 != null) {
                handler0.post(new a(this, s, v, v1, 0));
            }
        }

        public void disabled(DecoderCounters decoderCounters0) {
            Handler handler0 = this.handler;
            if(handler0 != null) {
                handler0.post(new b(this, decoderCounters0, 1));
            }
        }

        public static void e(EventDispatcher audioRendererEventListener$EventDispatcher0, int v) {
            audioRendererEventListener$EventDispatcher0.lambda$audioSessionId$5(v);
        }

        public void enabled(DecoderCounters decoderCounters0) {
            Handler handler0 = this.handler;
            if(handler0 != null) {
                handler0.post(new b(this, decoderCounters0, 0));
            }
        }

        public static void f(EventDispatcher audioRendererEventListener$EventDispatcher0, String s, long v, long v1) {
            audioRendererEventListener$EventDispatcher0.lambda$decoderInitialized$1(s, v, v1);
        }

        public void inputFormatChanged(Format format0) {
            Handler handler0 = this.handler;
            if(handler0 != null) {
                handler0.post(new l(15, this, format0));
            }
        }

        private void lambda$audioSessionId$5(int v) {
            this.listener.onAudioSessionId(v);
        }

        private void lambda$audioTrackUnderrun$3(int v, long v1, long v2) {
            this.listener.onAudioSinkUnderrun(v, v1, v2);
        }

        private void lambda$decoderInitialized$1(String s, long v, long v1) {
            this.listener.onAudioDecoderInitialized(s, v, v1);
        }

        private void lambda$disabled$4(DecoderCounters decoderCounters0) {
            this.listener.onAudioDisabled(decoderCounters0);
        }

        private void lambda$enabled$0(DecoderCounters decoderCounters0) {
            ((AudioRendererEventListener)Util.castNonNull(this.listener)).onAudioEnabled(decoderCounters0);
        }

        private void lambda$inputFormatChanged$2(Format format0) {
            this.listener.onAudioInputFormatChanged(format0);
        }
    }

    default void onAudioDecoderInitialized(String s, long v, long v1) {
    }

    default void onAudioDisabled(DecoderCounters decoderCounters0) {
    }

    default void onAudioEnabled(DecoderCounters decoderCounters0) {
    }

    default void onAudioInputFormatChanged(Format format0) {
    }

    default void onAudioSessionId(int v) {
    }

    default void onAudioSinkUnderrun(int v, long v1, long v2) {
    }
}

