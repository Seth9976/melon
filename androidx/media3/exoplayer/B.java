package androidx.media3.exoplayer;

import B3.o;
import H6.k;
import android.content.Context;
import android.media.AudioManager;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter.Builder;
import w3.f;

public final class b implements k {
    public final int a;
    public final Context b;

    public b(Context context0, int v) {
        this.a = v;
        this.b = context0;
        super();
    }

    @Override  // H6.k
    public final Object get() {
        switch(this.a) {
            case 0: {
                AudioManager audioManager0 = (AudioManager)this.b.getApplicationContext().getSystemService("audio");
                audioManager0.getClass();
                return audioManager0;
            }
            case 1: {
                return new DefaultRenderersFactory(this.b);
            }
            case 2: {
                o o0 = new o();
                return new DefaultMediaSourceFactory(this.b, o0);
            }
            case 3: {
                return new DefaultTrackSelector(this.b);
            }
            default: {
                Context context0 = this.b;
                Class class0 = f.class;
                synchronized(class0) {
                    if(f.t == null) {
                        DefaultBandwidthMeter.Builder defaultBandwidthMeter$Builder0 = new DefaultBandwidthMeter.Builder(context0);
                        f.t = new f(defaultBandwidthMeter$Builder0.a, defaultBandwidthMeter$Builder0.b, defaultBandwidthMeter$Builder0.c, defaultBandwidthMeter$Builder0.d, defaultBandwidthMeter$Builder0.e);
                    }
                    return f.t;
                }
            }
        }
    }
}

