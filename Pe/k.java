package Pe;

import Hf.x;
import Me.L;
import Me.N;
import Me.b;
import Me.c;
import Me.k;
import Me.l;
import Me.m;
import Me.o;
import Me.u;
import Me.y;
import Ne.h;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import qf.e;
import qf.g;
import xf.d;

public final class K extends G implements Me.K {
    public S m;
    public final K n;

    public K(L l0, h h0, y y0, o o0, boolean z, boolean z1, boolean z2, int v, K k0, N n0) {
        if(h0 != null) {
            if(y0 != null) {
                if(o0 != null) {
                    if(v != 0) {
                        if(n0 != null) {
                            super(y0, o0, l0, h0, e.g(("<set-" + l0.getName() + ">")), z, z1, z2, v, n0);
                            this.n = k0 == null ? this : k0;
                            return;
                        }
                        K.Q0(5);
                        throw null;
                    }
                    K.Q0(4);
                    throw null;
                }
                K.Q0(3);
                throw null;
            }
            K.Q0(2);
            throw null;
        }
        K.Q0(1);
        throw null;
    }

    @Override  // Me.b
    public final List F() {
        S s0 = this.m;
        if(s0 == null) {
            throw new IllegalStateException();
        }
        List list0 = Collections.singletonList(s0);
        if(list0 != null) {
            return list0;
        }
        K.Q0(11);
        throw null;
    }

    @Override  // Pe.G
    public static void Q0(int v) {
        Object[] arr_object = new Object[(v == 10 || v == 11 || v == 12 || v == 13 ? 2 : 3)];
        switch(v) {
            case 2: {
                arr_object[0] = "modality";
                break;
            }
            case 3: {
                arr_object[0] = "visibility";
                break;
            }
            case 4: {
                arr_object[0] = "kind";
                break;
            }
            case 5: {
                arr_object[0] = "source";
                break;
            }
            case 6: {
                arr_object[0] = "parameter";
                break;
            }
            case 7: {
                arr_object[0] = "setterDescriptor";
                break;
            }
            case 8: {
                arr_object[0] = "type";
                break;
            }
            case 1: 
            case 9: {
                arr_object[0] = "annotations";
                break;
            }
            case 10: 
            case 11: 
            case 12: 
            case 13: {
                arr_object[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
            }
            default: {
                arr_object[0] = "correspondingProperty";
            }
        }
        switch(v) {
            case 10: {
                arr_object[1] = "getOverriddenDescriptors";
                break;
            }
            case 11: {
                arr_object[1] = "getValueParameters";
                break;
            }
            case 12: {
                arr_object[1] = "getReturnType";
                break;
            }
            case 13: {
                arr_object[1] = "getOriginal";
                break;
            }
            default: {
                arr_object[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
            }
        }
        switch(v) {
            case 6: {
                arr_object[2] = "initialize";
                break;
            }
            case 7: 
            case 8: 
            case 9: {
                arr_object[2] = "createSetterParameter";
                break;
            }
            case 10: 
            case 11: 
            case 12: 
            case 13: {
                break;
            }
            default: {
                arr_object[2] = "<init>";
            }
        }
        String s = String.format((v == 10 || v == 11 || v == 12 || v == 13 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter \'%s\' of %s.%s must not be null"), arr_object);
        IllegalArgumentException illegalArgumentException0 = v == 10 || v == 11 || v == 12 || v == 13 ? new IllegalStateException(s) : new IllegalArgumentException(s);
        throw illegalArgumentException0;
    }

    @Override  // Me.k
    public final Object R(m m0, Object object0) {
        return m0.g(this, object0);
    }

    @Override  // Me.b
    public final b a() {
        return this.w1();
    }

    @Override  // Me.c
    public final c a() {
        return this.w1();
    }

    @Override  // Pe.n, Me.k
    public final k a() {
        return this.w1();
    }

    @Override  // Me.u
    public final u a() {
        return this.w1();
    }

    @Override  // Me.c
    public final Collection f() {
        return this.u1(false);
    }

    @Override  // Me.b
    public final x getReturnType() {
        return d.e(this).x();
    }

    @Override  // Pe.n
    public final l s1() {
        return this.w1();
    }

    public static S v1(K k0, x x0, h h0) {
        if(x0 != null) {
            if(h0 != null) {
                return new S(k0, null, 0, h0, g.g, x0, false, false, false, null, N.q);
            }
            K.Q0(9);
            throw null;
        }
        K.Q0(8);
        throw null;
    }

    public final K w1() {
        K k0 = this.n;
        if(k0 != null) {
            return k0;
        }
        K.Q0(13);
        throw null;
    }
}

