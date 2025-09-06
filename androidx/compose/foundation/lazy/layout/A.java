package androidx.compose.foundation.lazy.layout;

import B3.v;
import android.view.Choreographer.FrameCallback;
import android.view.Choreographer;
import android.view.Display;
import android.view.View;
import androidx.compose.runtime.w0;
import g0.e;

public final class a implements Choreographer.FrameCallback, b0, w0, Runnable {
    public final View a;
    public final e b;
    public boolean c;
    public final Choreographer d;
    public boolean e;
    public long f;
    public static long g;

    public a(View view0) {
        float f;
        this.a = view0;
        this.b = new e(new a0[16]);
        this.d = Choreographer.getInstance();
        if(a.g == 0L) {
            Display display0 = view0.getDisplay();
            if(view0.isInEditMode() || display0 == null) {
                f = 60.0f;
            }
            else {
                f = display0.getRefreshRate();
                if(f < 30.0f) {
                    f = 60.0f;
                }
            }
            a.g = (long)(1000000000.0f / f);
        }
    }

    @Override  // androidx.compose.foundation.lazy.layout.b0
    public final void a(a0 a00) {
        this.b.b(a00);
        if(!this.c) {
            this.c = true;
            this.a.post(this);
        }
    }

    @Override  // androidx.compose.runtime.w0
    public final void c() {
        this.e = true;
    }

    @Override  // androidx.compose.runtime.w0
    public final void d() {
    }

    @Override  // android.view.Choreographer$FrameCallback
    public final void doFrame(long v) {
        if(this.e) {
            this.f = v;
            this.a.post(this);
        }
    }

    @Override  // androidx.compose.runtime.w0
    public final void e() {
        this.e = false;
        this.a.removeCallbacks(this);
        this.d.removeFrameCallback(this);
    }

    @Override
    public final void run() {
        e e0 = this.b;
        if(e0.c != 0 && this.c && this.e && this.a.getWindowVisibility() == 0) {
            long v = this.f + a.g;
            v v1 = new v();  // 初始化器: Ljava/lang/Object;-><init>()V
            v1.a = v;
            boolean z = false;
            while(e0.c != 0 && !z) {
                if(Long.compare(Math.max(0L, v1.a - System.nanoTime()), 0L) <= 0 || ((a0)e0.a[0]).b(v1)) {
                    z = true;
                }
                else {
                    e0.k(0);
                }
            }
            if(z) {
                this.d.postFrameCallback(this);
                return;
            }
            this.c = false;
            return;
        }
        this.c = false;
    }
}

