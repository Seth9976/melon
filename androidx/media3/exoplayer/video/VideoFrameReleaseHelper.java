package androidx.media3.exoplayer.video;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.Surface;
import e3.b;
import i.n.i.b.a.s.e.Ae;
import i.n.i.b.a.s.e.s2;
import i.n.i.b.a.s.e.ze;
import l4.P;
import z3.m;

public final class VideoFrameReleaseHelper {
    public final Ae a;
    public final s2 b;
    public final m c;
    public boolean d;
    public Surface e;
    public float f;
    public float g;
    public float h;
    public float i;
    public int j;
    public long k;
    public long l;
    public long m;
    public long n;
    public long o;
    public long p;
    public long q;

    public VideoFrameReleaseHelper(Context context0) {
        s2 s20;
        Ae ae0 = new Ae();  // 初始化器: Ljava/lang/Object;-><init>()V
        ae0.d = new ze(1);
        ae0.e = new ze(1);
        ae0.b = 0x8000000000000001L;
        this.a = ae0;
        m m0 = null;
        if(context0 == null) {
            s20 = null;
        }
        else {
            DisplayManager displayManager0 = (DisplayManager)context0.getSystemService("display");
            s20 = displayManager0 == null ? null : new s2(this, displayManager0, 1);
        }
        this.b = s20;
        if(s20 != null) {
            m0 = m.e;
        }
        this.c = m0;
        this.k = 0x8000000000000001L;
        this.l = 0x8000000000000001L;
        this.f = -1.0f;
        this.i = 1.0f;
        this.j = 0;
    }

    public static void a(VideoFrameReleaseHelper videoFrameReleaseHelper0, Display display0) {
        if(display0 != null) {
            long v = (long)(1000000000.0 / ((double)display0.getRefreshRate()));
            videoFrameReleaseHelper0.k = v;
            videoFrameReleaseHelper0.l = v * 80L / 100L;
            return;
        }
        b.D("VideoFrameReleaseHelper", "Unable to query display refresh rate");
        videoFrameReleaseHelper0.k = 0x8000000000000001L;
        videoFrameReleaseHelper0.l = 0x8000000000000001L;
    }

    public final void b() {
        Surface surface0 = this.e;
        if(surface0 != null && this.j != 0x80000000 && this.h != 0.0f) {
            try {
                this.h = 0.0f;
                P.o(surface0, 0.0f, 0);
            }
            catch(IllegalStateException illegalStateException0) {
                b.q("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", illegalStateException0);
            }
        }
    }

    public final void c() {
        float f;
        if(this.e != null) {
            Ae ae0 = this.a;
            if(!((ze)ae0.d).d()) {
                f = this.f;
            }
            else if(((ze)ae0.d).d()) {
                long v = ((ze)ae0.d).e;
                f = (float)(1000000000.0 / ((double)(v == 0L ? 0L : ((ze)ae0.d).f / v)));
            }
            else {
                f = -1.0f;
            }
            float f1 = this.g;
            if(f != f1) {
                int v1 = Float.compare(f, -1.0f);
                if(v1 != 0 && f1 != -1.0f) {
                    float f2 = !((ze)ae0.d).d() || (((ze)ae0.d).d() ? ((ze)ae0.d).f : 0x8000000000000001L) < 5000000000L ? 1.0f : 0.02f;
                    if(Math.abs(f - this.g) >= f2) {
                        this.g = f;
                        this.d(false);
                    }
                }
                else if(v1 != 0 || ae0.c >= 30) {
                    this.g = f;
                    this.d(false);
                }
            }
        }
    }

    public final void d(boolean z) {
        float f1;
        Surface surface0 = this.e;
        if(surface0 != null && this.j != 0x80000000) {
            if(this.d) {
                float f = this.g;
                f1 = f == -1.0f ? 0.0f : f * this.i;
            }
            else {
                f1 = 0.0f;
            }
            if(z || this.h != f1) {
                try {
                    this.h = f1;
                    P.o(surface0, f1, (f1 == 0.0f ? 0 : 1));
                }
                catch(IllegalStateException illegalStateException0) {
                    b.q("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", illegalStateException0);
                }
            }
        }
    }
}

