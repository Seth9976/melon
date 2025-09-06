package i1;

import A0.h;
import A1.k;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.TextPaint;
import androidx.compose.runtime.E;
import androidx.compose.runtime.w;
import d3.g;
import kotlin.jvm.internal.q;
import l1.l;
import x0.e;
import y0.J;
import y0.M;
import y0.O;
import y0.P;
import y0.T;
import y0.o;
import y0.s;

public final class d extends TextPaint {
    public k a;
    public l b;
    public int c;
    public P d;
    public s e;
    public o f;
    public E g;
    public e h;
    public A0.e i;

    public final J a() {
        J j0 = this.a;
        if(j0 != null) {
            return j0;
        }
        k k0 = new k(this);
        this.a = k0;
        return k0;
    }

    public final void b(int v) {
        if(v == this.c) {
            return;
        }
        ((k)this.a()).l(v);
        this.c = v;
    }

    public final void c(o o0, long v, float f) {
        if(o0 == null) {
            this.g = null;
            this.f = null;
            this.h = null;
            this.setShader(null);
            return;
        }
        if(o0 instanceof T) {
            this.d(g.T(((T)o0).a, f));
            return;
        }
        if(o0 instanceof O) {
            if((!q.b(this.f, o0) || !(this.h == null ? false : e.a(this.h.a, v))) && v != 0x7FC000007FC00000L) {
                this.f = o0;
                this.h = new e(v);
                this.g = w.i(new P0.T(o0, v, 1));
            }
            ((k)this.a()).q((this.g == null ? null : ((Shader)this.g.getValue())));
            this.e = null;
            i.b(this, f);
        }
    }

    public final void d(long v) {
        if(!(this.e == null ? false : s.d(this.e.a, v)) && v != 16L) {
            this.e = new s(v);
            this.setColor(M.z(v));
            this.g = null;
            this.f = null;
            this.h = null;
            this.setShader(null);
        }
    }

    public final void e(A0.e e0) {
        if(e0 != null && !q.b(this.i, e0)) {
            this.i = e0;
            if(e0.equals(h.b)) {
                this.setStyle(Paint.Style.FILL);
                return;
            }
            if(e0 instanceof A0.i) {
                ((k)this.a()).u(1);
                ((k)this.a()).t(((A0.i)e0).b);
                ((Paint)((k)this.a()).c).setStrokeMiter(((A0.i)e0).c);
                ((k)this.a()).s(((A0.i)e0).e);
                ((k)this.a()).r(((A0.i)e0).d);
                ((k)this.a()).p(null);
            }
        }
    }

    public final void f(P p0) {
        if(p0 != null && !q.b(this.d, p0)) {
            this.d = p0;
            if(p0.equals(P.d)) {
                this.clearShadowLayer();
                return;
            }
            P p1 = this.d;
            float f = Float.intBitsToFloat(((int)(this.d.b & 0xFFFFFFFFL)));
            int v = M.z(this.d.a);
            this.setShadowLayer((p1.c == 0.0f ? 1.401298E-45f : p1.c), Float.intBitsToFloat(((int)(p1.b >> 0x20))), f, v);
        }
    }

    public final void g(l l0) {
        if(l0 != null && !q.b(this.b, l0)) {
            this.b = l0;
            boolean z = false;
            this.setUnderlineText((l0.a | 1) == l0.a);
            if((this.b.a | 2) == this.b.a) {
                z = true;
            }
            this.setStrikeThruText(z);
        }
    }
}

