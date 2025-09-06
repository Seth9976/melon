package vf;

import Hf.B;
import Hf.G;
import Hf.I;
import Hf.a0;
import Hf.c;
import Hf.x;
import Je.i;
import Je.o;
import Jf.l;
import Me.e;
import Me.w;
import Me.z;
import U4.F;
import e.k;
import i.n.i.b.a.s.e.M3;
import kotlin.jvm.internal.q;
import qf.b;

public final class u extends g {
    public u(b b0, int v) {
        super(new s(new f(b0, v)));
    }

    @Override  // vf.g
    public final x a(z z0) {
        q.g(z0, "module");
        I.b.getClass();
        I i0 = I.c;
        i i1 = z0.d();
        i1.getClass();
        e e0 = i1.j(o.Q.g());
        Object object0 = this.a;
        if(((t)object0) instanceof r) {
            return c.t(i0, e0, k.z(new G(((r)object0).a)));
        }
        if(!(((t)object0) instanceof s)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        b b0 = ((s)object0).a.a;
        int v = ((s)object0).a.b;
        e e1 = w.d(z0, b0);
        if(e1 == null) {
            return c.t(i0, e0, k.z(new G(l.c(Jf.k.d, new String[]{b0.toString(), String.valueOf(v)}))));
        }
        B b1 = e1.g();
        q.f(b1, "getDefaultType(...)");
        a0 a00 = F.T(b1);
        for(int v1 = 0; v1 < v; ++v1) {
            a00 = z0.d().h(a00);
        }
        return c.t(i0, e0, k.z(new G(a00)));
    }
}

