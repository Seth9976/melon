package i.n.i.b.a.s.e;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import androidx.media3.exoplayer.c;

public final class t0 {
    public final AudioManager a;
    public final c b;
    public zc c;
    public int d;
    public float e;

    public t0(Context context0, Handler handler0, zc zc0) {
        this.e = 1.0f;
        AudioManager audioManager0 = (AudioManager)context0.getApplicationContext().getSystemService("audio");
        audioManager0.getClass();
        this.a = audioManager0;
        this.c = zc0;
        this.b = new c(this, handler0, 1);
        this.d = 0;
    }

    public final int a(int v, boolean z) {
        this.b();
        return z ? 1 : -1;
    }

    public final void b() {
        if(this.d == 0) {
            return;
        }
        if(L7.a < 26) {
            this.a.abandonAudioFocus(this.b);
        }
        this.c(0);
    }

    public final void c(int v) {
        if(this.d != v) {
            this.d = v;
            float f = v == 3 ? 0.2f : 1.0f;
            if(this.e != f) {
                this.e = f;
                zc zc0 = this.c;
                if(zc0 != null) {
                    zc0.a.x1(1, 2, ((float)(zc0.a.V * zc0.a.m.e)));
                }
            }
        }
    }
}

