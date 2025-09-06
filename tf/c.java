package tf;

import Hf.M;
import J0.h;
import Me.E;
import Me.N;
import Me.S;
import Me.b;
import Me.e;
import Me.k;
import Me.x;
import Pe.C;
import java.util.Collection;
import je.p;
import kotlin.jvm.internal.q;
import we.n;

public final class c implements If.c {
    public static final c a;

    static {
        c.a = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static void a(int v) {
        Object[] arr_object = new Object[3];
        arr_object[0] = v == 1 ? "b" : "a";
        arr_object[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
        arr_object[2] = "equals";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter \'%s\' of %s.%s must not be null", arr_object));
    }

    public boolean b(k k0, k k1, boolean z) {
        if(k0 instanceof e && k1 instanceof e) {
            return q.b(((e)k0).q(), ((e)k1).q());
        }
        if(k0 instanceof S && k1 instanceof S) {
            return this.c(((S)k0), ((S)k1), z, a.a);
        }
        if(k0 instanceof b && k1 instanceof b) {
            q.g(((b)k0), "a");
            q.g(((b)k1), "b");
            if(!((b)k0).equals(((b)k1))) {
                if(q.b(((b)k0).getName(), ((b)k1).getName()) && (!(((b)k0) instanceof x) || !(((b)k1) instanceof x) || ((x)(((b)k0))).r0() == ((x)(((b)k1))).r0()) && (!q.b(((b)k0).e(), ((b)k1).e()) || z && q.b(c.e(((b)k0)), c.e(((b)k1)))) && !tf.e.n(((b)k0)) && !tf.e.n(((b)k1))) {
                    k k2 = ((b)k0).e();
                    k k3 = ((b)k1).e();
                    if((k2 instanceof Me.c || k3 instanceof Me.c ? false : this.b(k2, k3, z))) {
                        tf.k k4 = new tf.k(new h(z, ((b)k0), ((b)k1), 13));
                        return k4.m(((b)k0), ((b)k1), null, true).b() == 1 && k4.m(((b)k1), ((b)k0), null, true).b() == 1;
                    }
                }
                return false;
            }
            return true;
        }
        return !(k0 instanceof E) || !(k1 instanceof E) ? q.b(k0, k1) : q.b(((C)(((E)k0))).e, ((C)(((E)k1))).e);
    }

    public boolean c(S s0, S s1, boolean z, n n0) {
        q.g(s0, "a");
        q.g(s1, "b");
        if(!s0.equals(s1)) {
            if(!q.b(s0.e(), s1.e())) {
                k k0 = s0.e();
                k k1 = s1.e();
                return (k0 instanceof Me.c || k1 instanceof Me.c ? ((Boolean)n0.invoke(k0, k1)).booleanValue() : this.b(k0, k1, z)) && s0.getIndex() == s1.getIndex();
            }
            return false;
        }
        return true;
    }

    @Override  // If.c
    public boolean d(M m0, M m1) {
        if(m0 != null) {
            if(m1 != null) {
                return m0.equals(m1);
            }
            c.a(1);
            throw null;
        }
        c.a(0);
        throw null;
    }

    public static N e(b b0) {
        while(b0 instanceof Me.c && ((Me.c)b0).getKind() == 2) {
            Collection collection0 = ((Me.c)b0).f();
            q.f(collection0, "getOverriddenDescriptors(...)");
            b0 = (Me.c)p.F0(collection0);
            if(b0 == null) {
                return null;
            }
            if(false) {
                break;
            }
        }
        return b0.getSource();
    }
}

