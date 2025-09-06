package Ff;

import Ce.f;
import Ce.g;
import Df.l;
import Gf.m;
import Gf.p;
import Hf.B;
import Hf.G;
import Hf.I;
import Hf.W;
import Hf.b0;
import Hf.b;
import Hf.x;
import Me.D;
import Me.O;
import Me.S;
import Me.e;
import Me.z;
import Q8.h;
import Ze.v;
import androidx.media3.session.legacy.V;
import cf.a;
import com.google.firebase.messaging.u;
import df.j;
import i.n.i.b.a.s.e.M3;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import je.w;
import kotlin.jvm.internal.q;
import lf.T;
import qf.c;
import vf.y;

public final class i extends b {
    public final int c;
    public final Gf.i d;
    public final Pe.b e;

    public i(k k0) {
        this.c = 0;
        this.e = k0;
        super(((Df.i)k0.l.a).a);
        m m0 = ((Df.i)k0.l.a).a;
        d d0 = new d(k0, 6);
        m0.getClass();
        this.d = new Gf.i(m0, d0);  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
    }

    public i(j j0) {
        this.c = 1;
        this.e = j0;
        super(((a)j0.j.a).a);
        p p0 = ((a)j0.j.a).a;
        df.i i0 = new df.i(j0, 2);
        ((m)p0).getClass();
        this.d = new Gf.i(((m)p0), i0);  // 初始化器: LGf/h;-><init>(LGf/m;Lwe/a;)V
    }

    @Override  // Hf.f
    public final Collection b() {
        String s2;
        B b2;
        c c2;
        c c0;
        w w1;
        Pe.b b0 = this.e;
        if(this.c != 0) {
            u u0 = ((j)b0).j;
            Class class0 = ((j)b0).h.a;
            Type type0 = Object.class;
            boolean z = q.b(class0, type0);
            w w0 = w.a;
            if(z) {
                w1 = w0;
            }
            else {
                h h0 = new h(2);
                ArrayList arrayList0 = h0.a;
                Type type1 = class0.getGenericSuperclass();
                if(type1 != null) {
                    type0 = type1;
                }
                h0.f(type0);
                h0.h(class0.getGenericInterfaces());
                Iterable iterable0 = e.k.A(arrayList0.toArray(new Type[arrayList0.size()]));
                w1 = new ArrayList(je.q.Q(10, iterable0));
                for(Object object0: iterable0) {
                    ((ArrayList)w1).add(new Se.p(((Type)object0)));
                }
            }
            ArrayList arrayList1 = new ArrayList(w1.size());
            ArrayList arrayList2 = new ArrayList(0);
            q.f(v.n, "PURELY_IMPLEMENTS_ANNOTATION");
            Ne.b b1 = ((j)b0).G.e0(v.n);
            if(b1 == null) {
                c0 = null;
            }
            else {
                Object object1 = je.p.F0(b1.a().values());
                y y0 = object1 instanceof y ? ((y)object1) : null;
                if(y0 == null) {
                    c0 = null;
                }
                else {
                    String s = (String)y0.a;
                    if(s == null) {
                        c0 = null;
                    }
                    else {
                        qf.i i0 = qf.i.a;
                        int v = 0;
                        while(v < s.length()) {
                            int v1 = s.charAt(v);
                            switch(i0.ordinal()) {
                                case 1: {
                                    if(v1 == 46) {
                                        i0 = qf.i.c;
                                    }
                                    else {
                                        if(Character.isJavaIdentifierPart(((char)v1))) {
                                            break;
                                        }
                                        c0 = null;
                                        goto label_61;
                                    }
                                    break;
                                }
                                case 0: 
                                case 2: {
                                    if(!Character.isJavaIdentifierStart(((char)v1))) {
                                        c0 = null;
                                        goto label_61;
                                    }
                                    i0 = qf.i.b;
                                    break;
                                }
                                default: {
                                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                }
                            }
                            ++v;
                        }
                        c0 = i0 == qf.i.c ? null : new c(s);
                    }
                }
            }
        label_61:
            if(c0 == null || c0.a.c() || !c0.c(Je.p.k)) {
                c0 = null;
            }
            if(c0 == null) {
                c c1 = xf.d.g(((j)b0));
                c2 = (c)Ze.j.b.get(c1);
                if(c2 == null) {
                    b2 = null;
                }
                else {
                    goto label_70;
                }
            }
            else {
                c2 = c0;
            label_70:
                z z1 = ((a)u0.a).o;
                q.g(z1, "<this>");
                c2.a.c();
                Me.h h1 = ((Pe.w)z1.K0(c2.b())).g.c(c2.a.f(), Ue.c.h);
                e e0 = h1 instanceof e ? ((e)h1) : null;
                if(e0 == null) {
                    b2 = null;
                }
                else {
                    int v2 = e0.q().getParameters().size();
                    List list0 = ((j)b0).r.getParameters();
                    q.f(list0, "getParameters(...)");
                    int v3 = list0.size();
                    if(v3 == v2) {
                        ArrayList arrayList3 = new ArrayList(je.q.Q(10, list0));
                        for(Object object2: list0) {
                            arrayList3.add(new G(((S)object2).g(), b0.c));
                        }
                        I.b.getClass();
                        b2 = Hf.c.t(I.c, e0, arrayList3);
                    }
                    else if(v3 != 1 || v2 <= 1 || c0 != null) {
                        b2 = null;
                    }
                    else {
                        G g0 = new G(((S)je.p.E0(list0)).g(), b0.c);
                        g g1 = new g(1, v2, 1);  // 初始化器: LCe/e;-><init>(III)V
                        ArrayList arrayList4 = new ArrayList(je.q.Q(10, g1));
                        f f0 = g1.b();
                        while(f0.c) {
                            f0.nextInt();
                            arrayList4.add(g0);
                        }
                        I.b.getClass();
                        b2 = Hf.c.t(I.c, e0, arrayList4);
                    }
                }
            }
            for(Object object3: w1) {
                x x0 = ((V)u0.d).C(((Se.p)object3), df.v.L(W.a, false, null, 7));
                hf.c c3 = ((a)u0.a).r;
                c3.getClass();
                H4.c c4 = new H4.c(null, false, u0, Ze.a.e, true);
                Se.p p0 = (Se.p)object3;
                x x1 = x0;
                x x2 = c3.a(c4, x1, w0, null, false);
                if(x2 == null) {
                    x2 = x1;
                }
                if(x2.w().e() instanceof D) {
                    arrayList2.add(p0);
                }
                if(!q.b(x2.w(), (b2 == null ? null : b2.w())) && !Je.i.y(x2)) {
                    arrayList1.add(x2);
                }
            }
            e e1 = ((j)b0).i;
            Qf.k.a(arrayList1, (e1 == null ? null : new Hf.V(Q1.c.r(e1, ((j)b0))).i(e1.g(), b0.c)));
            Qf.k.a(arrayList1, b2);
            if(!arrayList2.isEmpty()) {
                l l0 = ((a)u0.a).f;
                ArrayList arrayList5 = new ArrayList(je.q.Q(10, arrayList2));
                for(Object object4: arrayList2) {
                    q.e(((gf.d)object4), "null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.JavaClassifierType");
                    arrayList5.add(((Se.p)(((gf.d)object4))).a.toString());
                }
                l0.a(((j)b0), arrayList5);
            }
            return arrayList1.isEmpty() ? e.k.z(((a)u0.a).o.d().e()) : je.p.P0(arrayList1);
        }
        A1.g g2 = ((k)b0).l;
        Iterable iterable1 = e1.G.F(((k)b0).e, ((Pe.z)g2.d));
        ArrayList arrayList6 = new ArrayList(je.q.Q(10, iterable1));
        for(Object object5: iterable1) {
            arrayList6.add(((Df.B)g2.h).g(((T)object5)));
        }
        ArrayList arrayList7 = je.p.A0(arrayList6, ((Df.i)g2.a).n.e(((k)b0)));
        ArrayList arrayList8 = new ArrayList();
        for(Object object6: arrayList7) {
            Me.h h2 = ((x)object6).w().e();
            D d0 = h2 instanceof D ? ((D)h2) : null;
            if(d0 != null) {
                arrayList8.add(d0);
            }
        }
        if(!arrayList8.isEmpty()) {
            l l1 = ((Df.i)g2.a).h;
            ArrayList arrayList9 = new ArrayList(je.q.Q(10, arrayList8));
            for(Object object7: arrayList8) {
                D d1 = (D)object7;
                qf.b b3 = xf.d.f(d1);
                if(b3 == null) {
                    s2 = d1.getName().b();
                    q.f(s2, "asString(...)");
                }
                else {
                    c c5 = b3.a();
                    if(c5 != null) {
                        String s1 = c5.a.a;
                        if(s1 != null) {
                            s2 = s1;
                        }
                    }
                }
                arrayList9.add(s2);
            }
            l1.a(((k)b0), arrayList9);
        }
        return je.p.P0(arrayList7);
    }

    @Override  // Hf.b
    public final Me.h e() {
        return this.c != 0 ? ((j)this.e) : ((k)this.e);
    }

    @Override  // Hf.M
    public final boolean g() {
        return true;
    }

    @Override  // Hf.M
    public final List getParameters() {
        return (List)this.d.invoke();
    }

    @Override  // Hf.f
    public final O h() {
        return this.c == 0 ? O.c : ((a)((j)this.e).j.a).m;
    }

    @Override  // Hf.b
    public final e m() {
        return this.c != 0 ? ((j)this.e) : ((k)this.e);
    }

    @Override
    public final String toString() {
        if(this.c != 0) {
            String s = ((j)this.e).getName().b();
            q.f(s, "asString(...)");
            return s;
        }
        qf.e e0 = ((k)this.e).getName();
        q.f(e0.a, "toString(...)");
        return e0.a;
    }
}

