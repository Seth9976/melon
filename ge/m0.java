package Ge;

import B.a;
import De.w;
import Me.L;
import Me.c;
import U4.x;
import d3.g;
import i.n.i.b.a.s.e.w8;
import ie.j;
import ie.k;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.q;
import nf.f;

public abstract class m0 extends s implements w {
    public final F g;
    public final String h;
    public final String i;
    public final Object j;
    public final Object k;
    public final u0 l;
    public static final Object m;

    static {
        m0.m = new Object();
    }

    public m0(F f0, L l0) {
        q.g(l0, "descriptor");
        String s = l0.getName().b();
        q.f(s, "asString(...)");
        this(f0, s, y0.b(l0).k(), l0, e.NO_RECEIVER);
    }

    public m0(F f0, String s, String s1, L l0, Object object0) {
        this.g = f0;
        this.h = s;
        this.i = s1;
        this.j = object0;
        g0 g00 = new g0(this, 0);
        this.k = g.P(k.b, g00);
        this.l = E9.w.H(l0, new g0(this, 1));
    }

    public m0(F f0, String s, String s1, Object object0) {
        q.g(f0, "container");
        q.g(s, "name");
        q.g(s1, "signature");
        this(f0, s, s1, null, object0);
    }

    // 去混淆评级： 低(25)
    @Override
    public final boolean equals(Object object0) {
        m0 m00 = A0.c(object0);
        return m00 == null ? false : q.b(this.g, m00.g) && q.b(this.h, m00.h) && q.b(this.i, m00.i) && q.b(this.j, m00.j);
    }

    @Override  // Ge.s
    public final He.g g() {
        return this.u().g();
    }

    @Override  // De.c
    public final String getName() {
        return this.h;
    }

    @Override  // Ge.s
    public final F h() {
        return this.g;
    }

    @Override
    public final int hashCode() {
        return this.i.hashCode() + x.b(this.g.hashCode() * 0x1F, 0x1F, this.h);
    }

    @Override  // Ge.s
    public final He.g i() {
        this.u().getClass();
        return null;
    }

    @Override  // De.w
    public final boolean isConst() {
        return this.t().isConst();
    }

    @Override  // De.w
    public final boolean isLateinit() {
        return this.t().E0();
    }

    @Override  // De.c
    public final boolean isSuspend() {
        return false;
    }

    @Override  // Ge.s
    public final c n() {
        return this.t();
    }

    @Override  // Ge.s
    public final boolean q() {
        return this.j != e.NO_RECEIVER;
    }

    public final Member r() {
        if(!this.t().z()) {
            return null;
        }
        a a0 = y0.b(this.t());
        if(a0 instanceof n) {
            f f0 = ((n)a0).h;
            of.e e0 = ((n)a0).g;
            if((e0.b & 16) == 16) {
                of.c c0 = e0.g;
                if((c0.b & 1) == 1 && (c0.b & 2) == 2) {
                    String s = f0.getString(c0.c);
                    String s1 = f0.getString(c0.d);
                    return this.g.h(s, s1);
                }
                return null;
            }
        }
        return (Field)((j)this.k).getValue();
    }

    public final Object s(Member member0, Object object0) {
        Object object2;
        try {
            Object object1 = m0.m;
            if(object0 == object1 && this.t().Q() == null) {
                throw new RuntimeException("\'" + this + "\' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");
            }
            if(this.q()) {
                L l0 = this.t();
                object2 = d5.f.l(this.j, l0);
            }
            else {
                object2 = object0;
            }
            if(object2 == object1) {
                object2 = null;
            }
            if(!this.q()) {
                object0 = null;
            }
            if(object0 == object1) {
                object0 = null;
            }
            AccessibleObject accessibleObject0 = member0 instanceof AccessibleObject ? ((AccessibleObject)member0) : null;
            if(accessibleObject0 != null) {
                accessibleObject0.setAccessible(U4.F.L(this));
            }
            if(member0 == null) {
                return null;
            }
            if(member0 instanceof Field) {
                return ((Field)member0).get(object2);
            }
            if(!(member0 instanceof Method)) {
                throw new AssertionError("delegate field/method " + member0 + " neither field nor method");
            }
            switch(((Method)member0).getParameterTypes().length) {
                case 0: {
                    return ((Method)member0).invoke(null, null);
                }
                case 1: {
                    if(object2 == null) {
                        Class class0 = ((Method)member0).getParameterTypes()[0];
                        q.f(class0, "get(...)");
                        object2 = A0.e(class0);
                    }
                    return ((Method)member0).invoke(null, object2);
                }
                case 2: {
                    if(object0 == null) {
                        Class class1 = ((Method)member0).getParameterTypes()[1];
                        q.f(class1, "get(...)");
                        object0 = A0.e(class1);
                    }
                    return ((Method)member0).invoke(null, object2, object0);
                }
                default: {
                    throw new AssertionError("delegate method " + member0 + " should take 0, 1, or 2 parameters");
                }
            }
        }
        catch(IllegalAccessException illegalAccessException0) {
        }
        throw new w8("Cannot obtain the delegate of a non-accessible property. Use \"isAccessible = true\" to make the property accessible", illegalAccessException0);  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
    }

    public final L t() {
        Object object0 = this.l.invoke();
        q.f(object0, "invoke(...)");
        return (L)object0;
    }

    @Override
    public final String toString() {
        return x0.c(this.t());
    }

    public abstract j0 u();
}

