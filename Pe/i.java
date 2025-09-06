package Pe;

import Gf.h;
import Hf.V;
import Hf.x;
import Me.L;
import Me.N;
import Me.b;
import Me.c;
import Me.k;
import Me.l;
import Me.m;
import Me.o;
import Me.y;
import Ne.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import qf.e;
import we.a;

public class I extends T implements L {
    public final boolean B;
    public List D;
    public u E;
    public u G;
    public ArrayList I;
    public J M;
    public K N;
    public r S;
    public r T;
    public final boolean f;
    public h g;
    public a h;
    public final y i;
    public o j;
    public Collection k;
    public final L l;
    public final int m;
    public final boolean n;
    public final boolean o;
    public final boolean r;
    public final boolean w;

    public I(k k0, L l0, Ne.h h0, y y0, o o0, boolean z, e e0, int v, N n0, boolean z1, boolean z2, boolean z3, boolean z4, boolean z5) {
        if(k0 != null) {
            if(h0 != null) {
                if(y0 != null) {
                    if(o0 != null) {
                        if(e0 != null) {
                            if(v != 0) {
                                if(n0 != null) {
                                    super(k0, h0, e0, null, n0);
                                    this.f = z;
                                    this.k = null;
                                    this.D = Collections.EMPTY_LIST;
                                    this.i = y0;
                                    this.j = o0;
                                    if(l0 == null) {
                                        l0 = this;
                                    }
                                    this.l = l0;
                                    this.m = v;
                                    this.n = z1;
                                    this.o = z2;
                                    this.r = z3;
                                    this.w = z4;
                                    this.B = z5;
                                    return;
                                }
                                I.Q0(6);
                                throw null;
                            }
                            I.Q0(5);
                            throw null;
                        }
                        I.Q0(4);
                        throw null;
                    }
                    I.Q0(3);
                    throw null;
                }
                I.Q0(2);
                throw null;
            }
            I.Q0(1);
            throw null;
        }
        I.Q0(0);
        throw null;
    }

    public final void A1(x x0, List list0, u u0, u u1, List list1) {
        if(x0 != null) {
            if(list0 != null) {
                if(list1 != null) {
                    this.e = x0;
                    this.I = new ArrayList(list0);
                    this.G = u1;
                    this.E = u0;
                    this.D = list1;
                    return;
                }
                I.Q0(19);
                throw null;
            }
            I.Q0(18);
            throw null;
        }
        I.Q0(17);
        throw null;
    }

    @Override  // Me.L
    public final r C0() {
        return this.S;
    }

    @Override  // Me.b
    public final List D0() {
        List list0 = this.D;
        if(list0 != null) {
            return list0;
        }
        I.Q0(22);
        throw null;
    }

    @Override  // Me.V
    public final boolean E0() {
        return this.n;
    }

    @Override  // Me.c
    public final void I0(Collection collection0) {
        if(collection0 != null) {
            this.k = collection0;
            return;
        }
        I.Q0(40);
        throw null;
    }

    @Override  // Pe.T, Me.b
    public final u L() {
        return this.E;
    }

    @Override  // Me.V
    public final boolean P() {
        return this.f;
    }

    @Override  // Pe.T, Me.b
    public final u Q() {
        return this.G;
    }

    @Override  // Pe.T
    public static void Q0(int v) {
        IllegalStateException illegalStateException0;
        int v1;
        String s;
        if(v == 28 || v == 38 || v == 39 || v == 41 || v == 42) {
            s = "@NotNull method %s.%s must not return null";
        }
        else {
            switch(v) {
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: {
                    s = "@NotNull method %s.%s must not return null";
                    break;
                }
                default: {
                    s = "Argument for @NotNull parameter \'%s\' of %s.%s must not be null";
                }
            }
        }
        if(v == 28 || v == 38 || v == 39 || v == 41 || v == 42) {
            v1 = 2;
        }
        else {
            switch(v) {
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: {
                    v1 = 2;
                    break;
                }
                default: {
                    v1 = 3;
                }
            }
        }
        Object[] arr_object = new Object[v1];
        switch(v) {
            case 1: 
            case 8: {
                arr_object[0] = "annotations";
                break;
            }
            case 2: 
            case 9: {
                arr_object[0] = "modality";
                break;
            }
            case 4: 
            case 11: {
                arr_object[0] = "name";
                break;
            }
            case 14: {
                arr_object[0] = "inType";
                break;
            }
            case 15: 
            case 17: {
                arr_object[0] = "outType";
                break;
            }
            case 16: 
            case 18: {
                arr_object[0] = "typeParameters";
                break;
            }
            case 19: {
                arr_object[0] = "contextReceiverParameters";
                break;
            }
            case 3: 
            case 10: 
            case 20: {
                arr_object[0] = "visibility";
                break;
            }
            case 27: {
                arr_object[0] = "originalSubstitutor";
                break;
            }
            case 29: {
                arr_object[0] = "copyConfiguration";
                break;
            }
            case 30: {
                arr_object[0] = "substitutor";
                break;
            }
            case 0x1F: {
                arr_object[0] = "accessorDescriptor";
                break;
            }
            case 0x20: {
                arr_object[0] = "newOwner";
                break;
            }
            case 33: {
                arr_object[0] = "newModality";
                break;
            }
            case 34: {
                arr_object[0] = "newVisibility";
                break;
            }
            case 5: 
            case 12: 
            case 35: {
                arr_object[0] = "kind";
                break;
            }
            case 36: {
                arr_object[0] = "newName";
                break;
            }
            case 6: 
            case 13: 
            case 37: {
                arr_object[0] = "source";
                break;
            }
            case 40: {
                arr_object[0] = "overriddenDescriptors";
                break;
            }
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 28: 
            case 38: 
            case 39: 
            case 41: 
            case 42: {
                arr_object[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                break;
            }
            default: {
                arr_object[0] = "containingDeclaration";
            }
        }
        switch(v) {
            case 21: {
                arr_object[1] = "getTypeParameters";
                break;
            }
            case 22: {
                arr_object[1] = "getContextReceiverParameters";
                break;
            }
            case 23: {
                arr_object[1] = "getReturnType";
                break;
            }
            case 24: {
                arr_object[1] = "getModality";
                break;
            }
            case 25: {
                arr_object[1] = "getVisibility";
                break;
            }
            case 26: {
                arr_object[1] = "getAccessors";
                break;
            }
            case 28: {
                arr_object[1] = "getSourceToUseForCopy";
                break;
            }
            case 38: {
                arr_object[1] = "getOriginal";
                break;
            }
            case 39: {
                arr_object[1] = "getKind";
                break;
            }
            case 41: {
                arr_object[1] = "getOverriddenDescriptors";
                break;
            }
            case 42: {
                arr_object[1] = "copy";
                break;
            }
            default: {
                arr_object[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
            }
        }
        switch(v) {
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: {
                arr_object[2] = "create";
                break;
            }
            case 14: {
                arr_object[2] = "setInType";
                break;
            }
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: {
                arr_object[2] = "setType";
                break;
            }
            case 20: {
                arr_object[2] = "setVisibility";
                break;
            }
            case 27: {
                arr_object[2] = "substitute";
                break;
            }
            case 29: {
                arr_object[2] = "doSubstitute";
                break;
            }
            case 30: 
            case 0x1F: {
                arr_object[2] = "getSubstitutedInitialSignatureDescriptor";
                break;
            }
            case 0x20: 
            case 33: 
            case 34: 
            case 35: 
            case 36: 
            case 37: {
                arr_object[2] = "createSubstitutedCopy";
                break;
            }
            case 40: {
                arr_object[2] = "setOverriddenDescriptors";
                break;
            }
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: 
            case 26: 
            case 28: 
            case 38: 
            case 39: 
            case 41: 
            case 42: {
                break;
            }
            default: {
                arr_object[2] = "<init>";
            }
        }
        String s1 = String.format(s, arr_object);
        if(v == 28 || v == 38 || v == 39 || v == 41 || v == 42) {
            illegalStateException0 = new IllegalStateException(s1);
        }
        else {
            switch(v) {
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: {
                    illegalStateException0 = new IllegalStateException(s1);
                    break;
                }
                default: {
                    illegalStateException0 = new IllegalArgumentException(s1);
                }
            }
        }
        throw illegalStateException0;
    }

    @Override  // Me.k
    public final Object R(m m0, Object object0) {
        return m0.j(this, object0);
    }

    @Override  // Me.L
    public final r T() {
        return this.T;
    }

    @Override  // Me.b
    public Object X(Me.a a0) {
        return null;
    }

    @Override  // Me.L
    public final L a() {
        L l0 = this.l;
        L l1 = l0 == this ? this : l0.a();
        if(l1 != null) {
            return l1;
        }
        I.Q0(38);
        throw null;
    }

    @Override  // Me.b
    public final b a() {
        return this.a();
    }

    @Override  // Me.c
    public final c a() {
        return this.a();
    }

    @Override  // Pe.n, Me.k
    public final k a() {
        return this.a();
    }

    @Override  // Me.L
    public final K b() {
        return this.N;
    }

    @Override  // Me.L
    public final L c(V v0) {
        if(v0 != null) {
            if(v0.a.e()) {
                return this;
            }
            H h0 = new H(this);
            Hf.T t0 = v0.f();
            if(t0 != null) {
                h0.f = t0;
                h0.d = this.a();
                return h0.b();
            }
            H.a(15);
            throw null;
        }
        I.Q0(27);
        throw null;
    }

    @Override  // Me.P
    public final l c(V v0) {
        return this.c(v0);
    }

    @Override  // Me.x
    public final boolean e0() {
        return false;
    }

    @Override  // Me.c, Me.b
    public final Collection f() {
        Collection collection0 = this.k;
        if(collection0 == null) {
            collection0 = Collections.EMPTY_LIST;
        }
        if(collection0 != null) {
            return collection0;
        }
        I.Q0(41);
        throw null;
    }

    @Override  // Me.L
    public final J getGetter() {
        return this.M;
    }

    @Override  // Me.c
    public final int getKind() {
        int v = this.m;
        if(v != 0) {
            return v;
        }
        I.Q0(39);
        throw null;
    }

    @Override  // Pe.T, Me.b
    public final x getReturnType() {
        x x0 = this.getType();
        if(x0 != null) {
            return x0;
        }
        I.Q0(23);
        throw null;
    }

    @Override  // Pe.T, Me.b
    public final List getTypeParameters() {
        List list0 = this.I;
        if(list0 == null) {
            throw new IllegalStateException("typeParameters == null for " + this);
        }
        return list0;
    }

    @Override  // Me.x, Me.n
    public final o getVisibility() {
        o o0 = this.j;
        if(o0 != null) {
            return o0;
        }
        I.Q0(25);
        throw null;
    }

    @Override  // Me.x
    public final y i() {
        y y0 = this.i;
        if(y0 != null) {
            return y0;
        }
        I.Q0(24);
        throw null;
    }

    @Override  // Me.V
    public boolean isConst() {
        return this.o;
    }

    @Override  // Me.x
    public boolean isExternal() {
        return this.w;
    }

    @Override  // Me.L
    public final ArrayList m() {
        ArrayList arrayList0 = new ArrayList(2);
        J j0 = this.M;
        if(j0 != null) {
            arrayList0.add(j0);
        }
        K k0 = this.N;
        if(k0 != null) {
            arrayList0.add(k0);
        }
        return arrayList0;
    }

    @Override  // Me.x
    public final boolean r0() {
        return this.r;
    }

    @Override  // Pe.n
    public final l s1() {
        return this.a();
    }

    public final I t1(k k0, y y0, o o0) {
        H h0 = new H(this);
        if(k0 != null) {
            h0.a = k0;
            h0.d = null;
            h0.b = y0;
            if(o0 != null) {
                h0.c = o0;
                h0.e = 2;
                h0.g = false;
                I i0 = h0.b();
                if(i0 != null) {
                    return i0;
                }
                I.Q0(42);
                throw null;
            }
            H.a(8);
            throw null;
        }
        H.a(0);
        throw null;
    }

    public static I u1(k k0, y y0, o o0, boolean z, e e0, int v, N n0) {
        if(k0 != null) {
            if(o0 != null) {
                if(e0 != null) {
                    if(v != 0) {
                        if(n0 != null) {
                            return new I(k0, null, g.a, y0, o0, z, e0, v, n0, false, false, false, false, false);
                        }
                        I.Q0(13);
                        throw null;
                    }
                    I.Q0(12);
                    throw null;
                }
                I.Q0(11);
                throw null;
            }
            I.Q0(10);
            throw null;
        }
        I.Q0(7);
        throw null;
    }

    @Override  // Me.c
    public final c v(Me.e e0, y y0, o o0) {
        return this.t1(e0, y0, o0);
    }

    @Override  // Me.V
    public final vf.g v0() {
        return this.g == null ? null : ((vf.g)this.g.invoke());
    }

    public I v1(k k0, y y0, o o0, L l0, int v, e e0) {
        if(k0 != null) {
            if(y0 != null) {
                if(o0 != null) {
                    if(v != 0) {
                        if(e0 != null) {
                            Ne.h h0 = this.getAnnotations();
                            boolean z = this.isConst();
                            boolean z1 = this.isExternal();
                            return new I(k0, l0, h0, y0, o0, this.f, e0, v, N.q, this.n, z, this.r, z1, this.B);
                        }
                        I.Q0(36);
                        throw null;
                    }
                    I.Q0(35);
                    throw null;
                }
                I.Q0(34);
                throw null;
            }
            I.Q0(33);
            throw null;
        }
        I.Q0(0x20);
        throw null;
    }

    public static Me.u w1(V v0, Me.K k0) {
        if(k0 != null) {
            Me.u u0 = ((G)k0).l;
            return u0 == null ? null : u0.c(v0);
        }
        I.Q0(0x1F);
        throw null;
    }

    public final void x1(J j0, K k0, r r0, r r1) {
        this.M = j0;
        this.N = k0;
        this.S = r0;
        this.T = r1;
    }

    public final void y1(h h0, a a0) {
        if(a0 == null) {
            throw new IllegalArgumentException("Argument for @NotNull parameter \'compileTimeInitializerFactory\' of kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl.setCompileTimeInitializer must not be null");
        }
        this.h = a0;
        if(h0 == null) {
            h0 = (h)a0.invoke();
        }
        this.g = h0;
    }

    @Override  // Me.L
    public final boolean z() {
        return this.B;
    }

    public void z1(x x0) {
    }
}

