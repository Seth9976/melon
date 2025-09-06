package Ge;

import De.t;
import De.w;
import Me.e;
import com.iloen.melon.utils.a;
import d3.g;
import ie.k;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.z;

public final class y extends C {
    public final Object c;
    public final u0 d;
    public final u0 e;
    public final u0 f;
    public final u0 g;
    public final u0 h;
    public final u0 i;
    public final u0 j;
    public final u0 k;
    public final u0 l;
    public static final w[] m;

    static {
        z z0 = new z(y.class, "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0);
        t t0 = a.e(y.class, "annotations", "getAnnotations()Ljava/util/List;", 0, I.a);
        t t1 = a.e(y.class, "simpleName", "getSimpleName()Ljava/lang/String;", 0, I.a);
        t t2 = a.e(y.class, "qualifiedName", "getQualifiedName()Ljava/lang/String;", 0, I.a);
        t t3 = a.e(y.class, "constructors", "getConstructors()Ljava/util/Collection;", 0, I.a);
        t t4 = a.e(y.class, "nestedClasses", "getNestedClasses()Ljava/util/Collection;", 0, I.a);
        t t5 = a.e(y.class, "typeParameters", "getTypeParameters()Ljava/util/List;", 0, I.a);
        t t6 = a.e(y.class, "supertypes", "getSupertypes()Ljava/util/List;", 0, I.a);
        t t7 = a.e(y.class, "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;", 0, I.a);
        t t8 = a.e(y.class, "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;", 0, I.a);
        t t9 = a.e(y.class, "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;", 0, I.a);
        t t10 = a.e(y.class, "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;", 0, I.a);
        t t11 = a.e(y.class, "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;", 0, I.a);
        t t12 = a.e(y.class, "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;", 0, I.a);
        t t13 = a.e(y.class, "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;", 0, I.a);
        t t14 = a.e(y.class, "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;", 0, I.a);
        t t15 = a.e(y.class, "allMembers", "getAllMembers()Ljava/util/Collection;", 0, I.a);
        y.m = new w[]{I.a.g(z0), t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15};
    }

    public y(B b0) {
        super(b0);
        v v0 = new v(this, 0);
        this.c = g.P(k.b, v0);
        this.d = E9.w.H(null, new Ge.t(b0, 5));
        E9.w.H(null, new Ge.t(b0, 6));
        this.e = E9.w.H(null, new Ge.t(b0, this));
        this.f = E9.w.H(null, new Ge.t(b0, 8));
        E9.w.H(null, new Ge.t(b0, 9));
        E9.w.H(null, new Ge.w(this, b0, 1));
        Ge.w w0 = new Ge.w(this, b0, 2);
        g.P(k.b, w0);
        E9.w.H(null, new Ge.w(this, b0, 3));
        E9.w.H(null, new Ge.w(this, b0, 4));
        E9.w.H(null, new Ge.w(b0, this));
        this.g = E9.w.H(null, new Ge.t(b0, 1));
        this.h = E9.w.H(null, new Ge.t(b0, 2));
        this.i = E9.w.H(null, new Ge.t(b0, 3));
        this.j = E9.w.H(null, new Ge.t(b0, 4));
        this.k = E9.w.H(null, new v(this, 1));
        this.l = E9.w.H(null, new v(this, 2));
        E9.w.H(null, new v(this, 3));
        E9.w.H(null, new v(this, 4));
    }

    public final e a() {
        w w0 = y.m[0];
        Object object0 = this.d.invoke();
        q.f(object0, "getValue(...)");
        return (e)object0;
    }
}

