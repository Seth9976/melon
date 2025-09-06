package af;

import De.w;
import Gf.i;
import Gf.m;
import Hf.B;
import Me.N;
import Nc.W0;
import Re.g;
import Se.d;
import bf.h;
import com.google.firebase.messaging.u;
import gf.a;
import java.util.Map;
import je.p;
import je.x;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.z;
import qf.c;

public class b implements h {
    public final c a;
    public final N b;
    public final i c;
    public final a d;
    public static final w[] e;

    static {
        z z0 = new z(b.class, "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;", 0);
        b.e = new w[]{I.a.g(z0)};
    }

    public b(u u0, d d0, c c0) {
        q.g(u0, "c");
        cf.a a0 = (cf.a)u0.a;
        q.g(c0, "fqName");
        super();
        this.a = c0;
        g g0 = d0 == null ? N.q : a0.j.b(d0);
        this.b = g0;
        W0 w00 = new W0(11, u0, this);
        ((m)a0.a).getClass();
        this.c = new i(((m)a0.a), w00);  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
        this.d = d0 == null ? null : ((a)p.l0(d0.b()));
    }

    @Override  // Ne.b
    public Map a() {
        return x.a;
    }

    @Override  // Ne.b
    public final c b() {
        return this.a;
    }

    @Override  // Ne.b
    public final N getSource() {
        return this.b;
    }

    @Override  // Ne.b
    public final Hf.x getType() {
        return (B)P4.a.r(this.c, b.e[0]);
    }
}

