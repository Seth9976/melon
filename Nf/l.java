package Nf;

import Hf.B;
import Hf.G;
import Hf.I;
import Hf.Y;
import Hf.a0;
import Hf.c;
import Hf.x;
import Je.n;
import Je.o;
import Me.w;
import Me.z;
import Pe.S;
import bf.f;
import e.k;
import java.util.Collection;
import java.util.List;
import je.p;
import kotlin.jvm.internal.q;
import xf.d;
import y5.a;

public final class l implements e {
    public final int a;
    public static final l b;
    public static final l c;

    static {
        l.b = new l(0);
        l.c = new l(1);
    }

    public l(int v) {
        this.a = v;
        super();
    }

    @Override  // Nf.e
    public final boolean a(f f0) {
        B b0;
        if(this.a != 0) {
            List list0 = f0.F();
            q.f(list0, "getValueParameters(...)");
            if(!(list0 instanceof Collection) || !list0.isEmpty()) {
                for(Object object0: list0) {
                    q.d(((S)object0));
                    if(d.a(((S)object0)) || ((S)object0).j != null) {
                        return false;
                    }
                    if(false) {
                        break;
                    }
                }
            }
            return true;
        }
        S s0 = (S)f0.F().get(1);
        q.d(s0);
        z z0 = d.j(s0);
        n.d.getClass();
        Me.e e0 = w.d(z0, o.R);
        if(e0 == null) {
            b0 = null;
        }
        else {
            I.b.getClass();
            List list1 = e0.q().getParameters();
            q.f(list1, "getParameters(...)");
            Object object1 = p.E0(list1);
            q.f(object1, "single(...)");
            List list2 = k.z(new G(((Me.S)object1)));
            b0 = c.t(I.c, e0, list2);
        }
        if(b0 != null) {
            x x0 = s0.getType();
            q.f(x0, "getType(...)");
            a0 a00 = Y.g(x0, false);
            return If.d.a.b(b0, a00);
        }
        return false;
    }

    @Override  // Nf.e
    public final String b(f f0) {
        return a.L(this, f0);
    }

    @Override  // Nf.e
    public final String getDescription() {
        return this.a == 0 ? "second parameter must be of type KProperty<*> or its supertype" : "should not have varargs or parameters with default values";
    }
}

