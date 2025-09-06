package G;

import Cc.i;
import P4.a;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.w;
import ie.H;
import kotlin.coroutines.Continuation;

public final class e {
    public final y0 a;
    public final Object b;
    public final p c;
    public final b0 d;
    public final b0 e;
    public final V f;
    public final a0 g;
    public final u h;
    public final u i;
    public final u j;
    public final u k;

    public e(Object object0, y0 y00, Object object1, int v) {
        if((v & 4) != 0) {
            object1 = null;
        }
        this(object0, y00, object1, "Animatable");
    }

    public e(Object object0, y0 y00, Object object1, String s) {
        q q1;
        q q0;
        this.a = y00;
        this.b = object1;
        p p0 = new p(y00, object0, null, 60);
        this.c = p0;
        this.d = w.s(Boolean.FALSE);
        this.e = w.s(object0);
        this.f = new V();
        this.g = new a0(object1, 3);
        u u0 = p0.c;
        if(u0 instanceof q) {
            q0 = f.e;
        }
        else if(u0 instanceof r) {
            q0 = f.f;
        }
        else if(u0 instanceof s) {
            q0 = f.g;
        }
        else {
            q0 = f.h;
        }
        this.h = q0;
        if(u0 instanceof q) {
            q1 = f.a;
        }
        else if(u0 instanceof r) {
            q1 = f.b;
        }
        else if(u0 instanceof s) {
            q1 = f.c;
        }
        else {
            q1 = f.d;
        }
        this.i = q1;
        this.j = q0;
        this.k = q1;
    }

    public static final Object a(e e0, Object object0) {
        y0 y00 = e0.a;
        u u0 = e0.k;
        u u1 = e0.j;
        if(!kotlin.jvm.internal.q.b(u1, e0.h) || !kotlin.jvm.internal.q.b(u0, e0.i)) {
            u u2 = (u)y00.a.invoke(object0);
            int v = u2.b();
            boolean z = false;
            for(int v1 = 0; v1 < v; ++v1) {
                if(u2.a(v1) < u1.a(v1) || u2.a(v1) > u0.a(v1)) {
                    u2.e(a.i(u2.a(v1), u1.a(v1), u0.a(v1)), v1);
                    z = true;
                }
            }
            return z ? y00.b.invoke(u2) : object0;
        }
        return object0;
    }

    public static final void b(e e0) {
        e0.c.c.d();
        e0.c.d = 0x8000000000000000L;
        ((O0)e0.d).setValue(Boolean.FALSE);
    }

    public static Object c(e e0, Object object0, o o0, i i0, Continuation continuation0, int v) {
        if((v & 2) != 0) {
            o0 = e0.g;
        }
        Object object1 = e0.a.b.invoke(e0.c.c);
        if((v & 8) != 0) {
            i0 = null;
        }
        Object object2 = e0.d();
        Object object3 = e0.a.a.invoke(object1);
        b b0 = new b(e0, object1, new j0(o0, e0.a, object2, object0, ((u)object3)), e0.c.d, i0, null);
        return V.a(e0.f, b0, continuation0);
    }

    public final Object d() {
        return ((O0)this.c.b).getValue();
    }

    public final Object e(Object object0, Continuation continuation0) {
        c c0 = new c(this, object0, null);
        Object object1 = V.a(this.f, c0, continuation0);
        return object1 == ne.a.a ? object1 : H.a;
    }

    public final Object f(oe.i i0) {
        d d0 = new d(this, null);
        Object object0 = V.a(this.f, d0, i0);
        return object0 == ne.a.a ? object0 : H.a;
    }
}

