package Ge;

import De.t;
import De.w;
import com.iloen.melon.utils.a;
import d3.g;
import ie.k;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.z;

public final class S extends C {
    public final u0 c;
    public final u0 d;
    public final Object e;
    public final Object f;
    public static final w[] g;

    static {
        z z0 = new z(S.class, "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;", 0);
        t t0 = a.e(S.class, "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", 0, I.a);
        t t1 = a.e(S.class, "members", "getMembers()Ljava/util/Collection;", 0, I.a);
        S.g = new w[]{I.a.g(z0), t0, t1};
    }

    public S(T t0) {
        super(t0);
        this.c = E9.w.H(null, new O(t0, 1));
        this.d = E9.w.H(null, new P(this, 0));
        Q q0 = new Q(this, t0);
        this.e = g.P(k.b, q0);
        P p0 = new P(this, 1);
        this.f = g.P(k.b, p0);
        E9.w.H(null, new Q(t0, this));
    }
}

