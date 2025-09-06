package j5;

import A0.f;
import C0.c;
import N0.g0;
import N0.k;
import P4.a;
import android.os.SystemClock;
import androidx.compose.runtime.I0;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.Z;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.w;
import e1.m;
import x0.e;

public final class t extends c {
    public c a;
    public final c b;
    public final k c;
    public final int d;
    public final boolean e;
    public final a0 f;
    public long g;
    public boolean h;
    public final Z i;
    public final b0 j;

    public t(c c0, c c1, k k0, int v, boolean z) {
        this.a = c0;
        this.b = c1;
        this.c = k0;
        this.d = v;
        this.e = z;
        this.f = w.p(0);
        this.g = -1L;
        this.i = w.o(1.0f);
        this.j = w.s(null);
    }

    public final void a(f f0, c c0, float f1) {
        long v2;
        if(c0 != null && f1 > 0.0f) {
            long v = f0.c();
            long v1 = c0.getIntrinsicSize-NH-jbRc();
            if(v1 == 0x7FC000007FC00000L) {
                v2 = v;
            }
            else if(!e.e(v1) && v != 0x7FC000007FC00000L && !e.e(v)) {
                v2 = g0.i(v1, this.c.a(v1, v));
            }
            else {
                v2 = v;
            }
            b0 b00 = this.j;
            if(Long.compare(v, 0x7FC000007FC00000L) == 0 || e.e(v)) {
                c0.draw-x_KDEd0(f0, v2, f1, ((y0.t)((O0)b00).getValue()));
                return;
            }
            float f2 = (e.d(v) - e.d(v2)) / 2.0f;
            float f3 = (e.b(v) - e.b(v2)) / 2.0f;
            ((A0.c)f0.a0().a).C(f2, f3, f2, f3);
            c0.draw-x_KDEd0(f0, v2, f1, ((y0.t)((O0)b00).getValue()));
            ((A0.c)f0.a0().a).C(-f2, -f3, -f2, -f3);
        }
    }

    @Override  // C0.c
    public final boolean applyAlpha(float f) {
        ((I0)this.i).n(f);
        return true;
    }

    @Override  // C0.c
    public final boolean applyColorFilter(y0.t t0) {
        ((O0)this.j).setValue(t0);
        return true;
    }

    @Override  // C0.c
    public final long getIntrinsicSize-NH-jbRc() {
        long v = 0L;
        long v1 = this.a == null ? 0L : this.a.getIntrinsicSize-NH-jbRc();
        c c0 = this.b;
        if(c0 != null) {
            v = c0.getIntrinsicSize-NH-jbRc();
        }
        boolean z = false;
        boolean z1 = Long.compare(v1, 0x7FC000007FC00000L) != 0;
        if(v != 0x7FC000007FC00000L) {
            z = true;
        }
        return !z1 || !z ? 0x7FC000007FC00000L : m.i(Math.max(e.d(v1), e.d(v)), Math.max(e.b(v1), e.b(v)));
    }

    @Override  // C0.c
    public final void onDraw(f f0) {
        Z z0 = this.i;
        c c0 = this.b;
        if(this.h) {
            this.a(f0, c0, ((I0)z0).m());
            return;
        }
        long v = SystemClock.uptimeMillis();
        if(this.g == -1L) {
            this.g = v;
        }
        float f1 = ((float)(v - this.g)) / ((float)this.d);
        float f2 = a.i(f1, 0.0f, 1.0f);
        float f3 = ((I0)z0).m() * f2;
        float f4 = this.e ? ((I0)z0).m() - f3 : ((I0)z0).m();
        this.h = Float.compare(f1, 1.0f) >= 0;
        this.a(f0, this.a, f4);
        this.a(f0, c0, f3);
        if(this.h) {
            this.a = null;
            return;
        }
        int v1 = ((K0)this.f).m();
        ((K0)this.f).n(v1 + 1);
    }
}

