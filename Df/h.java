package df;

import De.t;
import De.w;
import Gf.i;
import Gf.m;
import Hf.B;
import Hf.P;
import Hf.W;
import Hf.x;
import Jf.k;
import Jf.l;
import Me.N;
import Pe.S;
import Re.g;
import Se.D;
import Se.d;
import Se.f;
import Se.o;
import Se.p;
import Se.s;
import Se.y;
import Ze.v;
import androidx.media3.session.legacy.V;
import com.google.firebase.messaging.u;
import com.iloen.melon.utils.a;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.z;
import qf.b;
import qf.c;
import qf.e;
import vf.j;
import vf.r;

public final class h implements bf.h {
    public final u a;
    public final d b;
    public final Gf.h c;
    public final i d;
    public final g e;
    public final i f;
    public final boolean g;
    public static final w[] h;

    static {
        z z0 = new z(h.class, "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;", 0);
        t t0 = a.e(h.class, "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;", 0, I.a);
        t t1 = a.e(h.class, "allValueArguments", "getAllValueArguments()Ljava/util/Map;", 0, I.a);
        h.h = new w[]{I.a.g(z0), t0, t1};
    }

    public h(d d0, u u0, boolean z) {
        q.g(u0, "c");
        q.g(d0, "javaAnnotation");
        super();
        this.a = u0;
        this.b = d0;
        cf.a a0 = (cf.a)u0.a;
        df.g g0 = new df.g(this, 0);
        ((m)a0.a).getClass();
        this.c = new Gf.h(((m)a0.a), g0);
        df.g g1 = new df.g(this, 1);
        ((m)a0.a).getClass();
        this.d = new i(((m)a0.a), g1);  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
        this.e = a0.j.b(d0);
        df.g g2 = new df.g(this, 2);
        ((m)a0.a).getClass();
        this.f = new i(((m)a0.a), g2);  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
        this.g = z;
    }

    @Override  // Ne.b
    public final Map a() {
        return (Map)P4.a.r(this.f, h.h[2]);
    }

    @Override  // Ne.b
    public final c b() {
        w w0 = h.h[0];
        q.g(this.c, "<this>");
        q.g(w0, "p");
        return (c)this.c.invoke();
    }

    public final vf.g c(gf.a a0) {
        y y0;
        x x0;
        if(a0 instanceof Se.u) {
            return vf.i.b(null, ((Se.u)a0).b);
        }
        if(a0 instanceof s) {
            Class class0 = ((s)a0).b.getClass();
            if(!class0.isEnum()) {
                class0 = class0.getEnclosingClass();
            }
            q.d(class0);
            return new j(Se.c.a(class0), e.e(((s)a0).b.name()));
        }
        u u0 = this.a;
        if(a0 instanceof Se.g) {
            e e0 = ((Se.g)a0).a;
            if(e0 == null) {
                e0 = v.b;
            }
            q.d(e0);
            ArrayList arrayList0 = ((Se.g)a0).a();
            if(!Hf.c.k(((B)P4.a.r(this.d, h.h[1])))) {
                Me.e e1 = xf.d.d(this);
                q.d(e1);
                S s0 = V4.u.p(e0, e1);
                if(s0 == null) {
                    x0 = ((cf.a)u0.a).o.d().h(l.c(k.Y, new String[0]));
                }
                else {
                    x0 = s0.getType();
                    if(x0 == null) {
                        x0 = ((cf.a)u0.a).o.d().h(l.c(k.Y, new String[0]));
                    }
                }
                ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
                for(Object object0: arrayList0) {
                    vf.g g0 = this.c(((gf.a)object0));
                    if(g0 == null) {
                        g0 = new vf.w(null);  // 初始化器: Lvf/g;-><init>(Ljava/lang/Object;)V
                    }
                    arrayList1.add(g0);
                }
                return new vf.z(arrayList1, x0);
            }
        }
        else {
            if(a0 instanceof f) {
                return new vf.a(new h(new d(((f)a0).b), u0, false));  // 初始化器: Lvf/g;-><init>(Ljava/lang/Object;)V
            }
            if(a0 instanceof o) {
                Class class1 = ((o)a0).b;
                if(class1.isPrimitive()) {
                    y0 = new y(class1);
                }
                else if(class1 instanceof GenericArrayType || class1.isArray()) {
                    y0 = new Se.h(class1);
                }
                else if(class1 instanceof WildcardType) {
                    y0 = new D(((WildcardType)class1));
                }
                else {
                    y0 = new p(class1);
                }
                x x1 = ((V)u0.d).C(y0, df.v.L(W.b, false, null, 7));
                if(!Hf.c.k(x1)) {
                    x x2 = x1;
                    int v;
                    for(v = 0; Je.i.z(x2); ++v) {
                        x2 = ((P)je.p.E0(x2.r())).b();
                        q.f(x2, "getType(...)");
                    }
                    Me.h h0 = x2.w().e();
                    if(h0 instanceof Me.e) {
                        b b0 = xf.d.f(h0);
                        return b0 == null ? new vf.u(new r(x1)) : new vf.u(b0, v);  // 初始化器: Lvf/g;-><init>(Ljava/lang/Object;)V
                    }
                    if(h0 instanceof Me.S) {
                        c c0 = Je.o.a.g();
                        return new vf.u(new b(c0.b(), c0.a.f()), 0);
                    }
                }
            }
        }
        return null;
    }

    @Override  // Ne.b
    public final N getSource() {
        return this.e;
    }

    @Override  // Ne.b
    public final x getType() {
        return (B)P4.a.r(this.d, h.h[1]);
    }

    @Override
    public final String toString() {
        return sf.g.c.x(this, null);
    }
}

