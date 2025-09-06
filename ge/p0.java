package Ge;

import Ac.W;
import De.e;
import De.t;
import De.w;
import De.x;
import Hf.P;
import Hf.Y;
import Me.Q;
import Me.S;
import Me.h;
import Se.c;
import V4.u;
import com.iloen.melon.utils.a;
import df.d;
import ie.l;
import java.lang.reflect.Array;
import java.util.List;
import je.p;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.z;

public final class p0 implements x {
    public final Hf.x a;
    public final u0 b;
    public final u0 c;
    public final u0 d;
    public static final w[] e;

    static {
        z z0 = new z(p0.class, "classifier", "getClassifier()Lkotlin/reflect/KClassifier;", 0);
        t t0 = a.e(p0.class, "arguments", "getArguments()Ljava/util/List;", 0, I.a);
        p0.e = new w[]{I.a.g(z0), t0};
    }

    public p0(Hf.x x0, we.a a0) {
        q.g(x0, "type");
        super();
        this.a = x0;
        u0 u00 = a0 instanceof u0 ? ((u0)a0) : null;
        if(u00 == null) {
            u00 = a0 == null ? null : E9.w.H(null, a0);
        }
        this.b = u00;
        this.c = E9.w.H(null, new n0(this, 0));
        this.d = E9.w.H(null, new W(12, this, a0));
    }

    public final e c(Hf.x x0) {
        h h0 = x0.w().e();
        if(h0 instanceof Me.e) {
            Class class0 = A0.k(((Me.e)h0));
            if(class0 == null) {
                return null;
            }
            if(class0.isArray()) {
                P p0 = (P)p.G0(x0.r());
                if(p0 != null) {
                    Hf.x x1 = p0.b();
                    if(x1 != null) {
                        e e0 = this.c(x1);
                        if(e0 == null) {
                            throw new s0("Cannot determine classifier for array element type: " + this);
                        }
                        return new B(Array.newInstance(d.v(u.q(e0)), 0).getClass());
                    }
                }
                return new B(class0);
            }
            if(!Y.e(x0)) {
                Class class1 = (Class)c.b.get(class0);
                if(class1 != null) {
                    class0 = class1;
                }
                return new B(class0);
            }
            return new B(class0);
        }
        if(h0 instanceof S) {
            return new q0(null, ((S)h0));
        }
        if(h0 instanceof Q) {
            throw new l("An operation is not implemented: Type alias classifiers are not yet supported");  // 初始化器: Ljava/lang/Error;-><init>(Ljava/lang/String;)V
        }
        return null;
    }

    @Override  // De.x
    public final e d() {
        w w0 = p0.e[0];
        return (e)this.c.invoke();
    }

    @Override  // De.x
    public final List e() {
        w w0 = p0.e[1];
        Object object0 = this.d.invoke();
        q.f(object0, "getValue(...)");
        return (List)object0;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof p0 && q.b(this.a, ((p0)object0).a) && q.b(this.d(), ((p0)object0).d()) && this.e().equals(((p0)object0).e());
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        e e0 = this.d();
        return e0 == null ? this.e().hashCode() + v * 961 : this.e().hashCode() + (v * 0x1F + e0.hashCode()) * 0x1F;
    }

    @Override
    public final String toString() {
        return x0.d(this.a);
    }
}

