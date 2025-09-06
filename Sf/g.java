package sf;

import De.I;
import Hf.B;
import Hf.M;
import Hf.P;
import Hf.Y;
import Hf.a0;
import Hf.c;
import Hf.l;
import Hf.x;
import Hf.z;
import Me.D;
import Me.E;
import Me.L;
import Me.Q;
import Me.S;
import Me.V;
import Me.h;
import Me.w;
import Me.y;
import Pe.J;
import Pe.K;
import Tf.o;
import Tf.v;
import com.melon.ui.l0;
import d5.m;
import df.e;
import e1.n;
import h7.u0;
import i.n.i.b.a.s.e.M3;
import ie.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import je.p;
import kotlin.jvm.internal.q;
import vf.a;
import vf.b;
import vf.s;
import vf.t;
import vf.u;
import we.k;

public final class g implements i {
    public final j a;
    public final r b;
    public static final g c;
    public static final g d;
    public static final g e;

    static {
        n.G(d.b);
        n.G(d.d);
        n.G(d.e);
        n.G(d.f);
        n.G(d.g);
        n.G(d.h);
        g.c = n.G(d.i);
        n.G(d.j);
        g.d = n.G(d.k);
        g.e = n.G(d.l);
        n.G(d.c);
    }

    public g(j j0) {
        this.a = j0;
        this.b = d3.g.Q(new e(this, 4));
    }

    public final void A(Me.i i0, StringBuilder stringBuilder0) {
        List list0 = i0.h();
        q.f(list0, "getDeclaredTypeParameters(...)");
        List list1 = i0.q().getParameters();
        q.f(list1, "getParameters(...)");
        if(this.u() && i0.x() && list1.size() > list0.size()) {
            stringBuilder0.append(" /*captured type parameters: ");
            this.b0(list1.subList(list0.size(), list1.size()), stringBuilder0);
            stringBuilder0.append("*/");
        }
    }

    public final String B(vf.g g0) {
        k k0 = (k)this.a.v.getValue(this.a, j.Y[20]);
        if(k0 != null) {
            return (String)k0.invoke(g0);
        }
        if(g0 instanceof b) {
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: ((Iterable)((b)g0).a)) {
                String s = this.B(((vf.g)object0));
                if(s != null) {
                    arrayList0.add(s);
                }
            }
            return p.q0(arrayList0, ", ", "{", "}", null, 56);
        }
        if(g0 instanceof a) {
            return o.N0(this.x(((Ne.b)((a)g0).a), null), "@");
        }
        if(g0 instanceof u) {
            t t0 = (t)((u)g0).a;
            if(t0 instanceof vf.r) {
                return ((vf.r)t0).a + "::class";
            }
            if(!(t0 instanceof s)) {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            String s1 = ((s)t0).a.a.a().a.a;
            int v = ((s)t0).a.b;
            for(int v1 = 0; v1 < v; ++v1) {
                s1 = "kotlin.Array<" + s1 + '>';
            }
            return s1 + "::class";
        }
        return g0.toString();
    }

    public final void C(List list0, StringBuilder stringBuilder0) {
        if(!list0.isEmpty()) {
            stringBuilder0.append("context(");
            int v = 0;
            for(Object object0: list0) {
                this.y(stringBuilder0, ((Pe.u)object0), Ne.d.g);
                x x0 = ((Pe.u)object0).getType();
                q.f(x0, "getType(...)");
                stringBuilder0.append(this.G(x0));
                if(v == e.k.s(list0)) {
                    stringBuilder0.append(") ");
                }
                else {
                    stringBuilder0.append(", ");
                }
                ++v;
            }
        }
    }

    public final void D(StringBuilder stringBuilder0, B b0) {
        g.z(this, stringBuilder0, b0);
        if(c.k(b0)) {
            j j0 = this.a;
            if(!(b0 instanceof Jf.i) || !((Jf.i)b0).d.b || !((Boolean)j0.V.getValue(j0, j.Y[0x2F])).booleanValue()) {
                if(!(b0 instanceof Jf.i) || ((Boolean)j0.X.getValue(j0, j.Y[49])).booleanValue()) {
                    stringBuilder0.append(b0.w().toString());
                }
                else {
                    stringBuilder0.append(((Jf.i)b0).h);
                }
                stringBuilder0.append(this.Y(b0.r()));
            }
            else {
                if(b0 instanceof Jf.i) {
                    Jf.i i0 = (Jf.i)b0;
                }
                M m0 = b0.w();
                q.e(m0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
                stringBuilder0.append(this.E(((Jf.j)m0).b[0]));
            }
        }
        else {
            M m1 = b0.w();
            h h0 = b0.w().e();
            m m2 = w.a(b0, (h0 instanceof Me.i ? ((Me.i)h0) : null), 0);
            if(m2 == null) {
                stringBuilder0.append(this.Z(m1));
                stringBuilder0.append(this.Y(b0.r()));
            }
            else {
                this.T(stringBuilder0, m2);
            }
        }
        if(b0.D()) {
            stringBuilder0.append("?");
        }
        if(b0 instanceof l) {
            stringBuilder0.append(" & Any");
        }
    }

    public final String E(String s) {
        switch(this.s().ordinal()) {
            case 0: {
                return s;
            }
            case 1: {
                return "<font color=red><b>" + s + "</b></font>";
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    public final String F(String s, String s1, Je.i i0) {
        q.g(s, "lowerRendered");
        q.g(s1, "upperRendered");
        if(e1.u.V(s, s1)) {
            return v.r0(s1, "(", false) ? "(" + s + ")!" : s + "!";
        }
        String s2 = o.b1(this.p().a(i0.j(Je.o.C), this), "Collection");
        String s3 = e1.u.P(s, s2 + "Mutable", s1, s2, s2 + "(Mutable)");
        if(s3 != null) {
            return s3;
        }
        String s4 = e1.u.P(s, s2 + "MutableMap.MutableEntry", s1, s2 + "Map.Entry", s2 + "(Mutable)Map.(Mutable)Entry");
        if(s4 != null) {
            return s4;
        }
        String s5 = o.b1(this.p().a(i0.k("Array"), this), "Array");
        String s6 = e1.u.P(s, s5 + this.o("Array<"), s1, s5 + this.o("Array<out "), s5 + this.o("Array<(out) "));
        return s6 == null ? "(" + s + ".." + s1 + ')' : s6;
    }

    public final String G(x x0) {
        String s = this.X(x0);
        return (!g.i0(x0) || Y.e(x0)) && !(x0 instanceof l) ? s : "(" + s + ')';
    }

    public final void H(V v0, StringBuilder stringBuilder0) {
        if(((Boolean)this.a.u.getValue(this.a, j.Y[19])).booleanValue()) {
            vf.g g0 = v0.v0();
            if(g0 != null) {
                String s = this.B(g0);
                if(s != null) {
                    stringBuilder0.append(" = ");
                    stringBuilder0.append(this.o(s));
                }
            }
        }
    }

    public final String I(String s) {
        switch(this.s().ordinal()) {
            case 0: {
                return s;
            }
            case 1: {
                return ((Boolean)this.a.W.getValue(this.a, j.Y[0x30])).booleanValue() ? s : "<b>" + s + "</b>";
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    public final void J(Me.c c0, StringBuilder stringBuilder0) {
        String s;
        if(this.q().contains(sf.h.i) && this.u() && c0.getKind() != 1) {
            stringBuilder0.append("/*");
            switch(c0.getKind()) {
                case 1: {
                    s = "DECLARATION";
                    break;
                }
                case 2: {
                    s = "FAKE_OVERRIDE";
                    break;
                }
                case 3: {
                    s = "DELEGATION";
                    break;
                }
                case 4: {
                    s = "SYNTHESIZED";
                    break;
                }
                default: {
                    throw null;
                }
            }
            stringBuilder0.append(I.X(s));
            stringBuilder0.append("*/ ");
        }
    }

    public final void K(Me.x x0, StringBuilder stringBuilder0) {
        this.N(stringBuilder0, x0.isExternal(), "external");
        boolean z = false;
        this.N(stringBuilder0, this.q().contains(sf.h.l) && x0.r0(), "expect");
        if(this.q().contains(sf.h.m) && x0.e0()) {
            z = true;
        }
        this.N(stringBuilder0, z, "actual");
    }

    public final void L(y y0, StringBuilder stringBuilder0, y y1) {
        if(!((Boolean)this.a.p.getValue(this.a, j.Y[14])).booleanValue() && y0 == y1) {
            return;
        }
        this.N(stringBuilder0, this.q().contains(sf.h.e), I.X(y0.name()));
    }

    public final void M(Me.c c0, StringBuilder stringBuilder0) {
        if(tf.e.r(c0) && c0.i() == y.b || ((sf.m)this.a.B.getValue(this.a, j.Y[26])) == sf.m.a && c0.i() == y.d && !c0.f().isEmpty()) {
            return;
        }
        y y0 = c0.i();
        q.f(y0, "getModality(...)");
        this.L(y0, stringBuilder0, g.v(c0));
    }

    public final void N(StringBuilder stringBuilder0, boolean z, String s) {
        if(z) {
            stringBuilder0.append(this.I(s));
            stringBuilder0.append(" ");
        }
    }

    public final String O(qf.e e0, boolean z) {
        String s = this.o(e1.u.N(e0));
        return !((Boolean)this.a.W.getValue(this.a, j.Y[0x30])).booleanValue() || this.s() != sf.r.b || !z ? s : "<b>" + s + "</b>";
    }

    public final void P(Me.k k0, StringBuilder stringBuilder0, boolean z) {
        qf.e e0 = k0.getName();
        q.f(e0, "getName(...)");
        stringBuilder0.append(this.O(e0, z));
    }

    public final void Q(StringBuilder stringBuilder0, x x0) {
        a0 a00 = x0.I();
        Hf.a a0 = a00 instanceof Hf.a ? ((Hf.a)a00) : null;
        if(a0 != null) {
            B b0 = a0.c;
            B b1 = a0.b;
            j j0 = this.a;
            De.w[] arr_w = j.Y;
            if(((Boolean)j0.R.getValue(j0, arr_w[42])).booleanValue()) {
                this.R(stringBuilder0, b1);
                if(((Boolean)j0.S.getValue(j0, arr_w[43])).booleanValue()) {
                    sf.r r0 = this.s();
                    sf.p p0 = sf.r.b;
                    if(r0 == p0) {
                        stringBuilder0.append("<font color=\"808080\"><i>");
                    }
                    stringBuilder0.append(" /* ");
                    stringBuilder0.append("from: ");
                    this.R(stringBuilder0, b0);
                    stringBuilder0.append(" */");
                    if(this.s() == p0) {
                        stringBuilder0.append("</i></font>");
                        return;
                    }
                }
            }
            else {
                this.R(stringBuilder0, b0);
                if(((Boolean)j0.Q.getValue(j0, arr_w[41])).booleanValue()) {
                    sf.r r1 = this.s();
                    sf.p p1 = sf.r.b;
                    if(r1 == p1) {
                        stringBuilder0.append("<font color=\"808080\"><i>");
                    }
                    stringBuilder0.append(" /* ");
                    stringBuilder0.append("= ");
                    this.R(stringBuilder0, b1);
                    stringBuilder0.append(" */");
                    if(this.s() == p1) {
                        stringBuilder0.append("</i></font>");
                    }
                }
            }
            return;
        }
        this.R(stringBuilder0, x0);
    }

    public final void R(StringBuilder stringBuilder0, x x0) {
        String s;
        qf.e e0;
        j j0 = this.a;
        if(x0 instanceof z && j0.n()) {
            Gf.i i0 = ((z)x0).d;
            if(i0.c == Gf.k.a || i0.c == Gf.k.b) {
                stringBuilder0.append("<Not computed yet>");
                return;
            }
        }
        a0 a00 = x0.I();
        if(a00 instanceof Hf.p) {
            stringBuilder0.append(((Hf.p)a00).W(this, this));
            return;
        }
        if(!(a00 instanceof B)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        if(!((B)a00).equals(Y.b) && ((B)a00).w() != Y.a.b) {
            M m0 = ((B)a00).w();
            if(m0 instanceof Jf.j && ((Jf.j)m0).a == Jf.k.j) {
                if(((Boolean)j0.t.getValue(j0, j.Y[18])).booleanValue()) {
                    M m1 = ((B)a00).w();
                    q.e(m1, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
                    stringBuilder0.append(this.E(((Jf.j)m1).b[0]));
                    return;
                }
                stringBuilder0.append("???");
                return;
            }
            if(c.k(((B)a00))) {
                this.D(stringBuilder0, ((B)a00));
                return;
            }
            if(g.i0(((B)a00))) {
                int v = stringBuilder0.length();
                g.z(((g)this.b.getValue()), stringBuilder0, ((B)a00));
                boolean z = stringBuilder0.length() != v;
                x x1 = u0.D(((B)a00));
                List list0 = u0.A(((B)a00));
                boolean z1 = u0.J(((B)a00));
                boolean z2 = ((B)a00).D();
                boolean z3 = z2 || z && x1 != null;
                if(z3) {
                    if(z1) {
                        stringBuilder0.insert(v, '(');
                    }
                    else {
                        if(z) {
                            o.I0(stringBuilder0);
                            if(stringBuilder0.charAt(o.B0(stringBuilder0) - 1) != 41) {
                                stringBuilder0.insert(o.B0(stringBuilder0), "()");
                            }
                        }
                        stringBuilder0.append("(");
                    }
                }
                this.N(stringBuilder0, z1, "suspend");
                if(!list0.isEmpty()) {
                    stringBuilder0.append("context(");
                    for(Object object0: list0.subList(0, e.k.s(list0))) {
                        this.Q(stringBuilder0, ((x)object0));
                        stringBuilder0.append(", ");
                    }
                    this.Q(stringBuilder0, ((x)p.s0(list0)));
                    stringBuilder0.append(") ");
                }
                if(x1 != null) {
                    boolean z4 = g.i0(x1) && !x1.D() || u0.J(x1) || !x1.getAnnotations().isEmpty() || x1 instanceof l;
                    if(z4) {
                        stringBuilder0.append("(");
                    }
                    this.Q(stringBuilder0, x1);
                    if(z4) {
                        stringBuilder0.append(")");
                    }
                    stringBuilder0.append(".");
                }
                stringBuilder0.append("(");
                if(!u0.H(((B)a00)) || ((B)a00).getAnnotations().e0(Je.o.p) == null || ((B)a00).r().size() > 1) {
                    int v1 = 0;
                    for(Object object1: u0.F(((B)a00))) {
                        P p0 = (P)object1;
                        if(v1 > 0) {
                            stringBuilder0.append(", ");
                        }
                        if(((Boolean)j0.U.getValue(j0, j.Y[45])).booleanValue()) {
                            x x2 = p0.b();
                            q.f(x2, "getType(...)");
                            e0 = u0.x(x2);
                        }
                        else {
                            e0 = null;
                        }
                        if(e0 != null) {
                            stringBuilder0.append(this.O(e0, false));
                            stringBuilder0.append(": ");
                        }
                        q.g(p0, "typeProjection");
                        StringBuilder stringBuilder1 = new StringBuilder();
                        p.p0(e.k.z(p0), stringBuilder1, ", ", null, null, new f(this, 0), 60);
                        stringBuilder0.append(stringBuilder1.toString());
                        ++v1;
                    }
                }
                else {
                    stringBuilder0.append("???");
                }
                stringBuilder0.append(") ");
                switch(this.s().ordinal()) {
                    case 0: {
                        s = this.o("->");
                        break;
                    }
                    case 1: {
                        s = "&rarr;";
                        break;
                    }
                    default: {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
                stringBuilder0.append(s);
                stringBuilder0.append(" ");
                u0.H(((B)a00));
                x x3 = ((P)p.s0(((B)a00).r())).b();
                q.f(x3, "getType(...)");
                this.Q(stringBuilder0, x3);
                if(z3) {
                    stringBuilder0.append(")");
                }
                if(z2) {
                    stringBuilder0.append("?");
                }
                return;
            }
            this.D(stringBuilder0, ((B)a00));
            return;
        }
        stringBuilder0.append("???");
    }

    public final void S(Me.c c0, StringBuilder stringBuilder0) {
        if(this.q().contains(sf.h.f) && !c0.f().isEmpty() && ((sf.m)this.a.B.getValue(this.a, j.Y[26])) != sf.m.b) {
            this.N(stringBuilder0, true, "override");
            if(this.u()) {
                stringBuilder0.append("/*");
                stringBuilder0.append(c0.f().size());
                stringBuilder0.append("*/ ");
            }
        }
    }

    public final void T(StringBuilder stringBuilder0, m m0) {
        m m1 = (m)m0.d;
        Me.i i0 = (Me.i)m0.b;
        if(m1 == null) {
            M m2 = i0.q();
            q.f(m2, "getTypeConstructor(...)");
            stringBuilder0.append(this.Z(m2));
        }
        else {
            this.T(stringBuilder0, m1);
            stringBuilder0.append('.');
            qf.e e0 = i0.getName();
            q.f(e0, "getName(...)");
            stringBuilder0.append(this.O(e0, false));
        }
        stringBuilder0.append(this.Y(((List)m0.c)));
    }

    public final void U(Me.c c0, StringBuilder stringBuilder0) {
        Pe.u u0 = c0.Q();
        if(u0 != null) {
            this.y(stringBuilder0, u0, Ne.d.g);
            x x0 = u0.getType();
            q.f(x0, "getType(...)");
            stringBuilder0.append(this.G(x0));
            stringBuilder0.append(".");
        }
    }

    public final void V(Me.c c0, StringBuilder stringBuilder0) {
        if(((Boolean)this.a.F.getValue(this.a, j.Y[30])).booleanValue()) {
            Pe.u u0 = c0.Q();
            if(u0 != null) {
                stringBuilder0.append(" on ");
                x x0 = u0.getType();
                q.f(x0, "getType(...)");
                stringBuilder0.append(this.X(x0));
            }
        }
    }

    public static void W(StringBuilder stringBuilder0) {
        int v = stringBuilder0.length();
        if(v != 0 && stringBuilder0.charAt(v - 1) == 0x20) {
            return;
        }
        stringBuilder0.append(' ');
    }

    public final String X(x x0) {
        q.g(x0, "type");
        StringBuilder stringBuilder0 = new StringBuilder();
        this.Q(stringBuilder0, ((x)((k)this.a.y.getValue(this.a, j.Y[23])).invoke(x0)));
        return stringBuilder0.toString();
    }

    public final String Y(List list0) {
        q.g(list0, "typeArguments");
        if(list0.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(this.o("<"));
        p.p0(list0, stringBuilder0, ", ", null, null, new f(this, 0), 60);
        stringBuilder0.append(this.o(">"));
        return stringBuilder0.toString();
    }

    public final String Z(M m0) {
        q.g(m0, "typeConstructor");
        h h0 = m0.e();
        if(!(h0 instanceof S) && !(h0 instanceof Me.e) && !(h0 instanceof Q)) {
            if(h0 != null) {
                throw new IllegalStateException(("Unexpected classifier: " + h0.getClass()).toString());
            }
            return m0 instanceof Hf.w ? ((Hf.w)m0).c(d.m) : m0.toString();
        }
        q.g(h0, "klass");
        return Jf.l.f(h0) ? h0.q().toString() : this.p().a(h0, this);
    }

    @Override  // sf.i
    public final void a() {
        this.a.a();
    }

    public final void a0(S s0, StringBuilder stringBuilder0, boolean z) {
        if(z) {
            stringBuilder0.append(this.o("<"));
        }
        if(this.u()) {
            stringBuilder0.append("/*");
            stringBuilder0.append(s0.getIndex());
            stringBuilder0.append("*/ ");
        }
        this.N(stringBuilder0, s0.u(), "reified");
        String s1 = s0.y().a;
        boolean z1 = true;
        this.N(stringBuilder0, s1.length() > 0, s1);
        this.y(stringBuilder0, s0, null);
        this.P(s0, stringBuilder0, z);
        int v = s0.getUpperBounds().size();
        if(v > 1 && !z || v == 1) {
            Object object0 = s0.getUpperBounds().iterator().next();
            if(((x)object0) == null) {
                Je.i.a(0x8D);
                throw null;
            }
            else if(!Je.i.y(((x)object0)) || !((x)object0).D()) {
                stringBuilder0.append(" : ");
                stringBuilder0.append(this.X(((x)object0)));
            }
        }
        else if(z) {
            for(Object object1: s0.getUpperBounds()) {
                x x0 = (x)object1;
                if(x0 != null) {
                    if(Je.i.y(x0) && x0.D()) {
                        continue;
                    }
                    if(z1) {
                        stringBuilder0.append(" : ");
                    }
                    else {
                        stringBuilder0.append(" & ");
                    }
                    stringBuilder0.append(this.X(x0));
                    z1 = false;
                    continue;
                }
                Je.i.a(0x8D);
                throw null;
            }
        }
        if(z) {
            stringBuilder0.append(this.o(">"));
        }
    }

    @Override  // sf.i
    public final void b() {
        this.a.b();
    }

    public final void b0(List list0, StringBuilder stringBuilder0) {
        Iterator iterator0 = list0.iterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            this.a0(((S)object0), stringBuilder0, false);
            if(iterator0.hasNext()) {
                stringBuilder0.append(", ");
            }
        }
    }

    @Override  // sf.i
    public final void c(sf.c c0) {
        this.a.c(c0);
    }

    public final void c0(List list0, StringBuilder stringBuilder0, boolean z) {
        if(!((Boolean)this.a.w.getValue(this.a, j.Y[21])).booleanValue() && !list0.isEmpty()) {
            stringBuilder0.append(this.o("<"));
            this.b0(list0, stringBuilder0);
            stringBuilder0.append(this.o(">"));
            if(z) {
                stringBuilder0.append(" ");
            }
        }
    }

    @Override  // sf.i
    public final void d() {
        this.a.d();
    }

    public final void d0(V v0, StringBuilder stringBuilder0, boolean z) {
        if(!z && v0 instanceof Pe.S) {
            return;
        }
        stringBuilder0.append(this.I((v0.P() ? "var" : "val")));
        stringBuilder0.append(" ");
    }

    @Override  // sf.i
    public final void e(sf.n n0) {
        this.a.e(n0);
    }

    public final void e0(Pe.S s0, boolean z, StringBuilder stringBuilder0, boolean z1) {
        boolean z2;
        if(z1) {
            stringBuilder0.append(this.I("value-parameter"));
            stringBuilder0.append(" ");
        }
        if(this.u()) {
            stringBuilder0.append("/*");
            stringBuilder0.append(s0.f);
            stringBuilder0.append("*/ ");
        }
        Pe.i i0 = null;
        this.y(stringBuilder0, s0, null);
        this.N(stringBuilder0, s0.h, "crossinline");
        this.N(stringBuilder0, s0.i, "noinline");
        j j0 = this.a;
        De.w[] arr_w = j.Y;
        if(((Boolean)j0.r.getValue(j0, arr_w[16])).booleanValue()) {
            Me.b b0 = s0.v1();
            if(b0 instanceof Pe.i) {
                i0 = (Pe.i)b0;
            }
            z2 = i0 == null || !i0.Y ? false : true;
        }
        else {
            z2 = false;
        }
        if(z2) {
            this.N(stringBuilder0, ((Boolean)j0.s.getValue(j0, arr_w[17])).booleanValue(), "actual");
        }
        x x0 = s0.getType();
        q.f(x0, "getType(...)");
        x x1 = s0.j;
        this.N(stringBuilder0, x1 != null, "vararg");
        if(z2 || z1 && !this.r()) {
            this.d0(s0, stringBuilder0, z2);
        }
        if(z) {
            this.P(s0, stringBuilder0, z1);
            stringBuilder0.append(": ");
        }
        stringBuilder0.append(this.X((x1 == null ? x0 : x1)));
        this.H(s0, stringBuilder0);
        if(this.u() && x1 != null) {
            stringBuilder0.append(" /*");
            stringBuilder0.append(this.X(x0));
            stringBuilder0.append("*/");
        }
        if(((k)j0.z.getValue(j0, arr_w[24])) != null && (j0.n() ? s0.u1() : xf.d.a(s0))) {
            k k0 = (k)j0.z.getValue(j0, arr_w[24]);
            q.d(k0);
            stringBuilder0.append(" = " + ((String)k0.invoke(s0)));
        }
    }

    @Override  // sf.i
    public final void f() {
        this.a.f();
    }

    public final void f0(Collection collection0, boolean z, StringBuilder stringBuilder0) {
        boolean z1;
        switch(((sf.n)this.a.E.getValue(this.a, j.Y[29])).ordinal()) {
            case 0: {
                z1 = true;
                break;
            }
            case 1: {
                z1 = z ? false : true;
                break;
            }
            case 2: {
                z1 = false;
                break;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        int v = collection0.size();
        this.t().getClass();
        q.g(stringBuilder0, "builder");
        stringBuilder0.append("(");
        int v1 = 0;
        for(Object object0: collection0) {
            this.t().getClass();
            q.g(((Pe.S)object0), "parameter");
            this.e0(((Pe.S)object0), z1, stringBuilder0, false);
            this.t().getClass();
            if(v1 != v - 1) {
                stringBuilder0.append(", ");
            }
            ++v1;
        }
        this.t().getClass();
        stringBuilder0.append(")");
    }

    @Override  // sf.i
    public final Set g() {
        return this.a.g();
    }

    public final boolean g0(Me.o o0, StringBuilder stringBuilder0) {
        if(this.q().contains(sf.h.d)) {
            j j0 = this.a;
            De.w[] arr_w = j.Y;
            if(((Boolean)j0.n.getValue(j0, arr_w[12])).booleanValue()) {
                o0 = Me.p.f(o0.a.c());
            }
            if(((Boolean)j0.o.getValue(j0, arr_w[13])).booleanValue() || !q.b(o0, Me.p.l)) {
                stringBuilder0.append(this.I(o0.a.b()));
                stringBuilder0.append(" ");
                return true;
            }
        }
        return false;
    }

    @Override  // sf.i
    public final void h() {
        this.a.h();
    }

    public final void h0(List list0, StringBuilder stringBuilder0) {
        if(!((Boolean)this.a.w.getValue(this.a, j.Y[21])).booleanValue()) {
            ArrayList arrayList0 = new ArrayList(0);
            for(Object object0: list0) {
                S s0 = (S)object0;
                List list1 = s0.getUpperBounds();
                q.f(list1, "getUpperBounds(...)");
                for(Object object1: p.f0(1, list1)) {
                    qf.e e0 = s0.getName();
                    q.f(e0, "getName(...)");
                    q.d(((x)object1));
                    arrayList0.add(this.O(e0, false) + " : " + this.X(((x)object1)));
                }
            }
            if(!arrayList0.isEmpty()) {
                stringBuilder0.append(" ");
                stringBuilder0.append(this.I("where"));
                stringBuilder0.append(" ");
                p.p0(arrayList0, stringBuilder0, ", ", null, null, null, 0x7C);
            }
        }
    }

    @Override  // sf.i
    public final void i() {
        this.a.i();
    }

    public static boolean i0(x x0) {
        if(u0.H(x0)) {
            Iterable iterable0 = x0.r();
            if(!(iterable0 instanceof Collection) || !((Collection)iterable0).isEmpty()) {
                for(Object object0: iterable0) {
                    if(((P)object0).c()) {
                        return false;
                    }
                    if(false) {
                        break;
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override  // sf.i
    public final void j(Set set0) {
        q.g(set0, "<set-?>");
        this.a.j(set0);
    }

    @Override  // sf.i
    public final void k(LinkedHashSet linkedHashSet0) {
        this.a.k(linkedHashSet0);
    }

    @Override  // sf.i
    public final void l() {
        this.a.l();
    }

    @Override  // sf.i
    public final void m() {
        this.a.m();
    }

    public static final void n(g g0, L l0, StringBuilder stringBuilder0) {
        boolean z = g0.r();
        j j0 = g0.a;
        if(!z) {
            De.w[] arr_w = j.Y;
            if(!((Boolean)j0.g.getValue(j0, arr_w[5])).booleanValue()) {
                List list0 = l0.D0();
                q.f(list0, "getContextReceiverParameters(...)");
                g0.C(list0, stringBuilder0);
                if(g0.q().contains(sf.h.g)) {
                    g0.y(stringBuilder0, l0, null);
                    Pe.r r0 = l0.C0();
                    if(r0 != null) {
                        g0.y(stringBuilder0, r0, Ne.d.b);
                    }
                    Pe.r r1 = l0.T();
                    if(r1 != null) {
                        g0.y(stringBuilder0, r1, Ne.d.j);
                    }
                    if(((sf.o)j0.H.getValue(j0, arr_w[0x20])) == sf.o.b) {
                        J j1 = l0.getGetter();
                        if(j1 != null) {
                            g0.y(stringBuilder0, j1, Ne.d.e);
                        }
                        K k0 = l0.b();
                        if(k0 != null) {
                            g0.y(stringBuilder0, k0, Ne.d.f);
                            List list1 = k0.F();
                            q.f(list1, "getValueParameters(...)");
                            Pe.S s0 = (Pe.S)p.E0(list1);
                            q.d(s0);
                            g0.y(stringBuilder0, s0, Ne.d.i);
                        }
                    }
                }
                Me.o o0 = l0.getVisibility();
                q.f(o0, "getVisibility(...)");
                g0.g0(o0, stringBuilder0);
                g0.N(stringBuilder0, g0.q().contains(sf.h.n) && l0.isConst(), "const");
                g0.K(l0, stringBuilder0);
                g0.M(l0, stringBuilder0);
                g0.S(l0, stringBuilder0);
                g0.N(stringBuilder0, g0.q().contains(sf.h.o) && l0.E0(), "lateinit");
                g0.J(l0, stringBuilder0);
            }
            g0.d0(l0, stringBuilder0, false);
            List list2 = l0.getTypeParameters();
            q.f(list2, "getTypeParameters(...)");
            g0.c0(list2, stringBuilder0, true);
            g0.U(l0, stringBuilder0);
        }
        g0.P(l0, stringBuilder0, true);
        stringBuilder0.append(": ");
        x x0 = l0.getType();
        q.f(x0, "getType(...)");
        stringBuilder0.append(g0.X(x0));
        g0.V(l0, stringBuilder0);
        g0.H(l0, stringBuilder0);
        List list3 = l0.getTypeParameters();
        q.f(list3, "getTypeParameters(...)");
        g0.h0(list3, stringBuilder0);
    }

    public final String o(String s) {
        return this.s().a(s);
    }

    public final sf.c p() {
        return (sf.c)this.a.b.getValue(this.a, j.Y[0]);
    }

    public final Set q() {
        return (Set)this.a.e.getValue(this.a, j.Y[3]);
    }

    public final boolean r() {
        return ((Boolean)this.a.f.getValue(this.a, j.Y[4])).booleanValue();
    }

    public final sf.r s() {
        return (sf.r)this.a.D.getValue(this.a, j.Y[28]);
    }

    public final sf.e t() {
        return (sf.e)this.a.C.getValue(this.a, j.Y[27]);
    }

    public final boolean u() {
        return ((Boolean)this.a.j.getValue(this.a, j.Y[8])).booleanValue();
    }

    public static y v(Me.x x0) {
        if(x0 instanceof Me.e) {
            return ((Me.e)x0).getKind() == Me.f.b ? y.e : y.b;
        }
        Me.k k0 = x0.e();
        Me.e e0 = k0 instanceof Me.e ? ((Me.e)k0) : null;
        if(e0 == null) {
            return y.b;
        }
        if(!(x0 instanceof Me.c)) {
            return y.b;
        }
        Collection collection0 = ((Me.c)x0).f();
        q.f(collection0, "getOverriddenDescriptors(...)");
        if(!collection0.isEmpty() && e0.i() != y.b) {
            return y.d;
        }
        if(e0.getKind() == Me.f.b && !q.b(((Me.c)x0).getVisibility(), Me.p.a)) {
            return ((Me.c)x0).i() == y.e ? y.e : y.d;
        }
        return y.b;
    }

    public final String w(Me.k k0) {
        String s;
        q.g(k0, "declarationDescriptor");
        StringBuilder stringBuilder0 = new StringBuilder();
        k0.R(new pc.t(this, 13), stringBuilder0);
        j j0 = this.a;
        De.w[] arr_w = j.Y;
        if(((Boolean)j0.c.getValue(j0, arr_w[1])).booleanValue() && !(k0 instanceof E) && !(k0 instanceof Me.I)) {
            Me.k k1 = k0.e();
            if(k1 != null && !(k1 instanceof Me.z)) {
                stringBuilder0.append(" ");
                switch(this.s().ordinal()) {
                    case 0: {
                        s = "defined in";
                        break;
                    }
                    case 1: {
                        s = "<i>defined in</i>";
                        break;
                    }
                    default: {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
                stringBuilder0.append(s);
                stringBuilder0.append(" ");
                qf.d d0 = tf.e.g(k1);
                q.f(d0, "getFqName(...)");
                stringBuilder0.append((d0.c() ? "root package" : this.o(e1.u.O(qf.d.e(d0)))));
                if(((Boolean)j0.d.getValue(j0, arr_w[2])).booleanValue() && k1 instanceof E && k0 instanceof Me.l) {
                    ((Me.l)k0).getSource().getClass();
                }
            }
        }
        return stringBuilder0.toString();
    }

    public final String x(Ne.b b0, Ne.d d0) {
        j j0 = this.a;
        l0 l00 = j0.N;
        q.g(b0, "annotation");
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append('@');
        if(d0 != null) {
            stringBuilder0.append(d0.a + ':');
        }
        x x0 = b0.getType();
        stringBuilder0.append(this.X(x0));
        De.w[] arr_w = j.Y;
        if(((sf.a)l00.getValue(j0, arr_w[38])).a) {
            Map map0 = b0.a();
            je.w w0 = null;
            Me.e e0 = ((Boolean)j0.I.getValue(j0, arr_w[33])).booleanValue() ? xf.d.d(b0) : null;
            if(e0 != null) {
                Pe.i i0 = e0.B();
                if(i0 != null) {
                    List list0 = i0.F();
                    if(list0 != null) {
                        ArrayList arrayList0 = new ArrayList();
                        for(Object object0: list0) {
                            if(((Pe.S)object0).u1()) {
                                arrayList0.add(object0);
                            }
                        }
                        ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
                        for(Object object1: arrayList0) {
                            arrayList1.add(((Pe.S)object1).getName());
                        }
                        w0 = arrayList1;
                    }
                }
            }
            if(w0 == null) {
                w0 = je.w.a;
            }
            ArrayList arrayList2 = new ArrayList();
            for(Object object2: w0) {
                if(!map0.containsKey(((qf.e)object2))) {
                    arrayList2.add(object2);
                }
            }
            ArrayList arrayList3 = new ArrayList(je.q.Q(10, arrayList2));
            for(Object object3: arrayList2) {
                arrayList3.add(((qf.e)object3).b() + " = ...");
            }
            Iterable iterable0 = map0.entrySet();
            ArrayList arrayList4 = new ArrayList(je.q.Q(10, iterable0));
            for(Object object4: iterable0) {
                qf.e e1 = (qf.e)((Map.Entry)object4).getKey();
                vf.g g0 = (vf.g)((Map.Entry)object4).getValue();
                arrayList4.add(e1.b() + " = " + (w0.contains(e1) ? "..." : this.B(g0)));
            }
            List list1 = p.I0(p.A0(arrayList3, arrayList4));
            if(((sf.a)l00.getValue(j0, j.Y[38])).b || !list1.isEmpty()) {
                p.p0(list1, stringBuilder0, ", ", "(", ")", null, 0x70);
            }
        }
        if(this.u() && (c.k(x0) || x0.w().e() instanceof D)) {
            stringBuilder0.append(" /* annotation class not found */");
        }
        return stringBuilder0.toString();
    }

    public final void y(StringBuilder stringBuilder0, Ne.a a0, Ne.d d0) {
        if(this.q().contains(sf.h.g)) {
            j j0 = this.a;
            Set set0 = a0 instanceof x ? j0.g() : ((Set)j0.K.getValue(j0, j.Y[35]));
            k k0 = (k)j0.M.getValue(j0, j.Y[37]);
            for(Object object0: a0.getAnnotations()) {
                Ne.b b0 = (Ne.b)object0;
                if(!p.d0(set0, b0.b()) && !q.b(b0.b(), Je.o.r) && (k0 == null || ((Boolean)k0.invoke(b0)).booleanValue())) {
                    stringBuilder0.append(this.x(b0, d0));
                    if(((Boolean)j0.J.getValue(j0, j.Y[34])).booleanValue()) {
                        stringBuilder0.append('\n');
                    }
                    else {
                        stringBuilder0.append(" ");
                    }
                }
            }
        }
    }

    public static void z(g g0, StringBuilder stringBuilder0, Ne.a a0) {
        g0.y(stringBuilder0, a0, null);
    }
}

