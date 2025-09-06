package androidx.media3.exoplayer;

import B.a;
import H6.k;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest.Builder;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import java.util.Objects;

public final class d {
    public final k a;
    public final c b;
    public y c;
    public b3.d d;
    public int e;
    public int f;
    public float g;
    public AudioFocusRequest h;

    public d(Context context0, Handler handler0, y y0) {
        this.g = 1.0f;
        this.a = a.T(new b(context0, 0));
        this.c = y0;
        this.b = new c(this, handler0, 0);
        this.e = 0;
    }

    public final void a() {
        if(this.e != 0 && this.e != 1) {
            k k0 = this.a;
            if(this.h != null) {
                ((AudioManager)k0.get()).abandonAudioFocusRequest(this.h);
            }
        }
    }

    public final void b(b3.d d0) {
        int v1;
        if(!Objects.equals(this.d, d0)) {
            this.d = d0;
            boolean z = false;
            if(d0 == null) {
                v1 = 0;
            }
            else {
                int v = d0.c;
                v1 = 3;
                switch(v) {
                    case 0: {
                        e3.b.D("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
                        v1 = 1;
                        break;
                    }
                    case 3: {
                        v1 = 0;
                        break;
                    }
                    case 2: 
                    case 4: {
                        v1 = 2;
                        break;
                    }
                    case 11: {
                        if(d0.a == 1) {
                            v1 = 2;
                        }
                        break;
                    }
                    case 5: 
                    case 6: 
                    case 7: 
                    case 8: 
                    case 9: 
                    case 10: 
                    case 12: 
                    case 13: {
                        break;
                    }
                    case 1: 
                    case 14: {
                        v1 = 1;
                        break;
                    }
                    case 16: {
                        v1 = 4;
                        break;
                    }
                    default: {
                        com.iloen.melon.utils.a.r(v, "Unidentified audio usage: ", "AudioFocusManager");
                        v1 = 0;
                    }
                }
            }
            this.f = v1;
            if(v1 == 0 || v1 == 1) {
                z = true;
            }
            e3.b.d(z, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
        }
    }

    public final void c(int v) {
        if(this.e != v) {
            this.e = v;
            float f = v == 4 ? 0.2f : 1.0f;
            if(this.g != f) {
                this.g = f;
                y y0 = this.c;
                if(y0 != null) {
                    y0.a.z0(1, 2, ((float)(y0.a.U * y0.a.C.g)));
                }
            }
        }
    }

    public final int d(boolean z, int v) {
        int v1 = 0;
        if(v != 1 && this.f == 1) {
            if(z) {
                if(this.e == 2) {
                    return 1;
                }
                k k0 = this.a;
                c c0 = this.b;
                if(this.h == null) {
                    AudioFocusRequest.Builder audioFocusRequest$Builder0 = new AudioFocusRequest.Builder(this.f);
                    b3.d d0 = this.d;
                    if(d0 != null && d0.a == 1) {
                        v1 = 1;
                    }
                    d0.getClass();
                    this.h = audioFocusRequest$Builder0.setAudioAttributes(((AudioAttributes)d0.b().a)).setWillPauseWhenDucked(((boolean)v1)).setOnAudioFocusChangeListener(c0).build();
                }
                if(((AudioManager)k0.get()).requestAudioFocus(this.h) == 1) {
                    this.c(2);
                    return 1;
                }
                this.c(1);
                return -1;
            }
            switch(this.e) {
                case 1: {
                    return -1;
                }
                case 3: {
                    return 0;
                }
                default: {
                    return 1;
                }
            }
        }
        this.a();
        this.c(0);
        return 1;
    }
}

