package i.n.i.b.a.s.e;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;

public final class en {
    public final Ae a;
    public final WindowManager b;
    public final t2 c;
    public final s2 d;
    public boolean e;
    public Surface f;
    public float g;
    public float h;
    public float i;
    public float j;
    public long k;
    public long l;
    public long m;
    public long n;
    public long o;
    public long p;
    public long q;

    public en(Context context0) {
        Ae ae0 = new Ae();  // 初始化器: Ljava/lang/Object;-><init>()V
        ae0.d = new ze(0);
        ae0.e = new ze(0);
        ae0.b = 0x8000000000000001L;
        this.a = ae0;
        s2 s20 = null;
        if(context0 == null) {
            this.b = null;
        }
        else {
            context0 = context0.getApplicationContext();
            this.b = (WindowManager)context0.getSystemService("window");
        }
        if(this.b == null) {
            this.d = null;
            this.c = null;
        }
        else {
            if(L7.a >= 17) {
                context0.getClass();
                DisplayManager displayManager0 = (DisplayManager)context0.getSystemService("display");
                if(displayManager0 != null) {
                    s20 = new s2(this, displayManager0, 0);
                }
            }
            this.d = s20;
            this.c = t2.e;
        }
        this.k = 0x8000000000000001L;
        this.l = 0x8000000000000001L;
        this.g = -1.0f;
        this.j = 1.0f;
    }

    public final void a(boolean z) {
        float f1;
        if(L7.a >= 30) {
            Surface surface0 = this.f;
            if(surface0 != null) {
                if(this.e) {
                    float f = this.h;
                    f1 = f == -1.0f ? 0.0f : f * this.j;
                }
                else {
                    f1 = 0.0f;
                }
                if(z || this.i != f1) {
                    try {
                        this.i = f1;
                        surface0.setFrameRate(f1, (f1 == 0.0f ? 0 : 1));
                    }
                    catch(IllegalStateException illegalStateException0) {
                        M7.H("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", illegalStateException0);
                    }
                }
            }
        }
    }

    public final void b() {
        this.b.getClass();
        Display display0 = this.b.getDefaultDisplay();
        if(display0 != null) {
            long v = (long)(1000000000.0 / ((double)display0.getRefreshRate()));
            this.k = v;
            this.l = v * 80L / 100L;
            return;
        }
        Log.w("VideoFrameReleaseHelper", "Unable to query display refresh rate");
        this.k = 0x8000000000000001L;
        this.l = 0x8000000000000001L;
    }

    public final void c() {
        float f;
        if(L7.a >= 30 && this.f != null) {
            Ae ae0 = this.a;
            if(!((ze)ae0.d).b()) {
                f = this.g;
            }
            else if(((ze)ae0.d).b()) {
                long v = ((ze)ae0.d).e;
                f = (float)(1000000000.0 / ((double)(v == 0L ? 0L : ((ze)ae0.d).f / v)));
            }
            else {
                f = -1.0f;
            }
            float f1 = this.h;
            if(f != f1) {
                int v1 = Float.compare(f, -1.0f);
                if(v1 != 0 && f1 != -1.0f) {
                    float f2 = !((ze)ae0.d).b() || (((ze)ae0.d).b() ? ((ze)ae0.d).f : 0x8000000000000001L) < 5000000000L ? 1.0f : 0.02f;
                    if(Math.abs(f - this.h) >= f2) {
                        this.h = f;
                        this.a(false);
                    }
                }
                else if(v1 != 0 || ae0.c >= 30) {
                    this.h = f;
                    this.a(false);
                }
            }
        }
    }
}

