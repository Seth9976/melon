package Pe;

import Bf.a;
import Bf.d;
import Bf.e;
import Bf.f;
import Hf.V;
import Hf.b0;
import Hf.x;
import Me.J;
import Me.N;
import Me.b;
import Me.k;
import Me.l;
import Me.o;
import Me.p;
import Ne.g;
import Ne.h;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class u extends m implements J {
    public final int c;
    public final k d;
    public final e e;

    public u(Me.e e0) {
        this.c = 0;
        super(g.a, qf.g.d);
        this.d = e0;
        this.e = new d(e0);
    }

    public u(k k0, a a0, h h0) {
        this.c = 1;
        if(k0 != null) {
            if(h0 != null) {
                this(k0, a0, h0, qf.g.d);
                return;
            }
            u.R0(2);
            throw null;
        }
        u.R0(0);
        throw null;
    }

    public u(k k0, a a0, h h0, qf.e e0) {
        this.c = 1;
        if(k0 != null) {
            if(h0 != null) {
                if(e0 != null) {
                    super(h0, e0);
                    this.d = k0;
                    this.e = a0;
                    return;
                }
                u.R0(6);
                throw null;
            }
            u.R0(5);
            throw null;
        }
        u.R0(3);
        throw null;
    }

    @Override  // Me.b
    public final List F() {
        List list0 = Collections.EMPTY_LIST;
        if(list0 != null) {
            return list0;
        }
        u.s1(7);
        throw null;
    }

    @Override  // Me.b
    public final u L() {
        return null;
    }

    @Override  // Me.b
    public final u Q() {
        return null;
    }

    @Override  // Pe.m
    public static void Q0(int v) {
        Object[] arr_object = new Object[(v == 1 || v == 2 ? 2 : 3)];
        switch(v) {
            case 1: 
            case 2: {
                arr_object[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
                break;
            }
            case 3: {
                arr_object[0] = "newOwner";
                break;
            }
            default: {
                arr_object[0] = "descriptor";
            }
        }
        switch(v) {
            case 1: {
                arr_object[1] = "getValue";
                break;
            }
            case 2: {
                arr_object[1] = "getContainingDeclaration";
                break;
            }
            default: {
                arr_object[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
            }
        }
        switch(v) {
            case 1: 
            case 2: {
                break;
            }
            case 3: {
                arr_object[2] = "copy";
                break;
            }
            default: {
                arr_object[2] = "<init>";
            }
        }
        String s = String.format((v == 1 || v == 2 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter \'%s\' of %s.%s must not be null"), arr_object);
        IllegalStateException illegalStateException0 = v == 1 || v == 2 ? new IllegalStateException(s) : new IllegalArgumentException(s);
        throw illegalStateException0;
    }

    @Override  // Me.k
    public final Object R(Me.m m0, Object object0) {
        return m0.q(this, object0);
    }

    @Override  // Bf.a
    public static void R0(int v) {
        Object[] arr_object = new Object[(v == 7 || v == 8 ? 2 : 3)];
        switch(v) {
            case 1: 
            case 4: {
                arr_object[0] = "value";
                break;
            }
            case 2: 
            case 5: {
                arr_object[0] = "annotations";
                break;
            }
            case 6: {
                arr_object[0] = "name";
                break;
            }
            case 7: 
            case 8: {
                arr_object[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
                break;
            }
            case 9: {
                arr_object[0] = "newOwner";
                break;
            }
            case 10: {
                arr_object[0] = "outType";
                break;
            }
            default: {
                arr_object[0] = "containingDeclaration";
            }
        }
        switch(v) {
            case 7: {
                arr_object[1] = "getValue";
                break;
            }
            case 8: {
                arr_object[1] = "getContainingDeclaration";
                break;
            }
            default: {
                arr_object[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
            }
        }
        switch(v) {
            case 7: 
            case 8: {
                break;
            }
            case 9: {
                arr_object[2] = "copy";
                break;
            }
            case 10: {
                arr_object[2] = "setOutType";
                break;
            }
            default: {
                arr_object[2] = "<init>";
            }
        }
        String s = String.format((v == 7 || v == 8 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter \'%s\' of %s.%s must not be null"), arr_object);
        IllegalStateException illegalStateException0 = v == 7 || v == 8 ? new IllegalStateException(s) : new IllegalArgumentException(s);
        throw illegalStateException0;
    }

    @Override  // Me.b
    public final b a() {
        return this;
    }

    @Override  // Pe.m, Me.k
    public final k a() {
        return this;
    }

    @Override  // Me.P
    public final l c(V v0) {
        return this.u1(v0);
    }

    @Override  // Me.k
    public final k e() {
        if(this.c != 0) {
            k k0 = this.d;
            if(k0 != null) {
                return k0;
            }
            u.R0(8);
            throw null;
        }
        k k1 = (Me.e)this.d;
        if(k1 != null) {
            return k1;
        }
        u.Q0(2);
        throw null;
    }

    @Override  // Me.b
    public final Collection f() {
        Collection collection0 = Collections.EMPTY_SET;
        if(collection0 != null) {
            return collection0;
        }
        u.s1(8);
        throw null;
    }

    @Override  // Me.b
    public final x getReturnType() {
        return this.getType();
    }

    @Override  // Me.l
    public final N getSource() {
        return N.q;
    }

    @Override  // Bf.a, Me.U
    public final x getType() {
        x x0 = this.t1().getType();
        if(x0 != null) {
            return x0;
        }
        u.s1(6);
        throw null;
    }

    @Override  // Me.b
    public final List getTypeParameters() {
        List list0 = Collections.EMPTY_LIST;
        if(list0 != null) {
            return list0;
        }
        u.s1(5);
        throw null;
    }

    @Override  // Me.n
    public final o getVisibility() {
        o o0 = p.f;
        if(o0 != null) {
            return o0;
        }
        u.s1(9);
        throw null;
    }

    @Override  // Me.b
    public final boolean o0() {
        return false;
    }

    public static void s1(int v) {
        IllegalArgumentException illegalArgumentException0;
        int v1;
        String s;
        switch(v) {
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                s = "@NotNull method %s.%s must not return null";
                break;
            }
            default: {
                s = "Argument for @NotNull parameter \'%s\' of %s.%s must not be null";
            }
        }
        switch(v) {
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                v1 = 2;
                break;
            }
            default: {
                v1 = 3;
            }
        }
        Object[] arr_object = new Object[v1];
        switch(v) {
            case 2: {
                arr_object[0] = "name";
                break;
            }
            case 3: {
                arr_object[0] = "substitutor";
                break;
            }
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                arr_object[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
            }
            default: {
                arr_object[0] = "annotations";
            }
        }
        switch(v) {
            case 4: {
                arr_object[1] = "getContextReceiverParameters";
                break;
            }
            case 5: {
                arr_object[1] = "getTypeParameters";
                break;
            }
            case 6: {
                arr_object[1] = "getType";
                break;
            }
            case 7: {
                arr_object[1] = "getValueParameters";
                break;
            }
            case 8: {
                arr_object[1] = "getOverriddenDescriptors";
                break;
            }
            case 9: {
                arr_object[1] = "getVisibility";
                break;
            }
            case 10: {
                arr_object[1] = "getOriginal";
                break;
            }
            case 11: {
                arr_object[1] = "getSource";
                break;
            }
            default: {
                arr_object[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
            }
        }
        switch(v) {
            case 3: {
                arr_object[2] = "substitute";
                break;
            }
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                break;
            }
            default: {
                arr_object[2] = "<init>";
            }
        }
        String s1 = String.format(s, arr_object);
        switch(v) {
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                illegalArgumentException0 = new IllegalStateException(s1);
                break;
            }
            default: {
                illegalArgumentException0 = new IllegalArgumentException(s1);
            }
        }
        throw illegalArgumentException0;
    }

    public final e t1() {
        if(this.c != 0) {
            e e0 = (a)this.e;
            if(e0 != null) {
                return e0;
            }
            u.R0(7);
            throw null;
        }
        e e1 = (d)this.e;
        if(e1 != null) {
            return e1;
        }
        u.Q0(1);
        throw null;
    }

    @Override  // Pe.m
    public String toString() {
        return this.c == 0 ? "class " + ((Me.e)this.d).getName() + "::this" : super.toString();
    }

    public final u u1(V v0) {
        if(v0 != null) {
            if(!v0.a.e()) {
                x x0 = this.e() instanceof Me.e ? v0.i(this.getType(), b0.e) : v0.i(this.getType(), b0.c);
                if(x0 == null) {
                    return null;
                }
                return x0 == this.getType() ? this : new u(this.e(), new f(x0), this.getAnnotations());  // 初始化器: LBf/a;-><init>(LHf/x;)V
            }
            return this;
        }
        u.s1(3);
        throw null;
    }
}

