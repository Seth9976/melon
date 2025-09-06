package Ge;

import Af.g;
import De.w;
import De.y;
import Ff.m;
import Ff.n;
import Me.S;
import Me.e;
import Me.k;
import Re.c;
import df.d;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.z;

public final class q0 implements y {
    public final S a;
    public final u0 b;
    public final r0 c;
    public static final w[] d;

    static {
        z z0 = new z(q0.class, "upperBounds", "getUpperBounds()Ljava/util/List;", 0);
        q0.d = new w[]{I.a.g(z0)};
    }

    public q0(r0 r00, S s0) {
        q.g(s0, "descriptor");
        super();
        this.a = s0;
        c c0 = null;
        this.b = E9.w.H(null, new g(this, 11));
        if(r00 == null) {
            k k0 = s0.e();
            q.f(k0, "getContainingDeclaration(...)");
            if(k0 instanceof e) {
                r00 = q0.b(((e)k0));
            }
            else {
                if(!(k0 instanceof Me.c)) {
                    throw new s0("Unknown type parameter container: " + k0);
                }
                k k1 = ((Me.c)k0).e();
                q.f(k1, "getContainingDeclaration(...)");
                if(k1 instanceof e) {
                    r00 = k0.R(new A0.c(q0.b(((e)k1)), 22), H.a);
                }
                else {
                    n n0 = k0 instanceof n ? ((n)k0) : null;
                    if(n0 == null) {
                        throw new s0("Non-class callable descriptor must be deserialized: " + k0);
                    }
                    m m0 = n0.K();
                    jf.g g0 = m0 instanceof jf.g ? ((jf.g)m0) : null;
                    c c1 = g0 == null ? null : g0.c;
                    if(c1 instanceof c) {
                        c0 = c1;
                    }
                    if(c0 != null) {
                        Class class0 = c0.a;
                        if(class0 != null) {
                            r00 = k0.R(new A0.c(((B)d.y(class0)), 22), H.a);
                            this.c = r00;
                            return;
                        }
                    }
                    throw new s0("Container of deserialized member is not resolved: " + n0);
                }
            }
        }
        this.c = r00;
    }

    public final String a() {
        String s = this.a.getName().b();
        q.f(s, "asString(...)");
        return s;
    }

    public static B b(e e0) {
        Class class0 = A0.k(e0);
        De.d d0 = class0 == null ? null : d.y(class0);
        if(((B)d0) == null) {
            throw new s0("Type parameter container is not resolved: " + e0.e());
        }
        return (B)d0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof q0 && q.b(this.c, ((q0)object0).c) && this.a().equals(((q0)object0).a());
    }

    @Override
    public final int hashCode() {
        return this.a().hashCode() + this.c.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        De.B b0;
        StringBuilder stringBuilder0 = new StringBuilder();
        switch(this.a.y().ordinal()) {
            case 0: {
                b0 = De.B.a;
                break;
            }
            case 1: {
                b0 = De.B.b;
                break;
            }
            case 2: {
                b0 = De.B.c;
                break;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        switch(b0.ordinal()) {
            case 0: {
                break;
            }
            case 1: {
                stringBuilder0.append("in ");
                break;
            }
            case 2: {
                stringBuilder0.append("out ");
                break;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        stringBuilder0.append(this.a());
        return stringBuilder0.toString();
    }
}

