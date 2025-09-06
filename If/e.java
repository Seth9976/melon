package If;

import Dd.g2;
import Hf.B;
import Hf.I;
import Hf.M;
import Hf.P;
import Hf.a0;
import Hf.b0;
import Hf.c;
import Hf.p;
import Hf.w;
import Hf.x;
import Kf.b;
import Kf.d;
import U4.F;
import i.n.i.b.a.s.e.M3;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.q;

public final class e extends c {
    public static final e a;

    static {
        e.a = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public final a0 H(d d0) {
        a0 a01;
        q.g(d0, "type");
        if(!(d0 instanceof x)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        a0 a00 = ((x)d0).I();
        if(a00 instanceof B) {
            a01 = e.I(((B)a00));
        }
        else if(a00 instanceof p) {
            B b0 = e.I(((p)a00).b);
            B b1 = e.I(((p)a00).c);
            a01 = b0 != ((p)a00).b || b1 != ((p)a00).c ? c.f(b0, b1) : a00;
        }
        else {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        g2 g20 = new g2(1, this, e.class, "prepareType", "prepareType(Lorg/jetbrains/kotlin/types/model/KotlinTypeMarker;)Lorg/jetbrains/kotlin/types/UnwrappedType;", 0, 27);
        x x0 = c.g(a00);
        return x0 == null ? c.G(a01, null) : c.G(a01, ((x)g20.invoke(x0)));
    }

    public static B I(B b0) {
        a0 a01;
        M m0 = b0.w();
        a0 a00 = null;
        if(m0 instanceof uf.c) {
            P p0 = ((uf.c)m0).a;
            if(p0.a() != b0.d) {
                p0 = null;
            }
            if(p0 == null) {
                a01 = null;
            }
            else {
                x x0 = p0.b();
                a01 = x0 == null ? null : x0.I();
            }
            if(((uf.c)m0).b == null) {
                P p1 = ((uf.c)m0).a;
                Iterable iterable0 = ((uf.c)m0).f();
                ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
                for(Object object0: iterable0) {
                    arrayList0.add(((x)object0).I());
                }
                q.g(p1, "projection");
                ((uf.c)m0).b = new i(p1, new Ff.e(1, arrayList0), null, 8);
            }
            i i0 = ((uf.c)m0).b;
            q.d(i0);
            I i1 = b0.t();
            boolean z = b0.D();
            return new h(b.a, i0, a01, i1, z, 0x20);
        }
        if(m0 instanceof w && b0.D()) {
            w w0 = (w)m0;
            ArrayList arrayList1 = new ArrayList(je.q.Q(10, w0.b));
            boolean z1 = false;
            for(Object object1: w0.b) {
                arrayList1.add(F.N(((x)object1)));
                z1 = true;
            }
            if(z1) {
                x x1 = w0.a;
                if(x1 != null) {
                    a00 = F.N(x1);
                }
                LinkedHashSet linkedHashSet0 = new LinkedHashSet(arrayList1);
                linkedHashSet0.hashCode();
                w w1 = new w(linkedHashSet0);
                w1.a = a00;
                a00 = w1;
            }
            if(a00 != null) {
                w0 = a00;
            }
            return w0.b();
        }
        return b0;
    }
}

