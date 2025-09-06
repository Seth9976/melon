package Pe;

import Hf.x;
import Me.K;
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

public final class J extends G implements K {
    public x m;
    public final J n;

    public J(L l0, h h0, y y0, o o0, boolean z, boolean z1, boolean z2, int v, J j0, N n0) {
        if(h0 != null) {
            if(y0 != null) {
                if(o0 != null) {
                    if(v != 0) {
                        if(n0 != null) {
                            super(y0, o0, l0, h0, e.g(("<get-" + l0.getName() + ">")), z, z1, z2, v, n0);
                            this.n = j0 == null ? this : j0;
                            return;
                        }
                        J.Q0(5);
                        throw null;
                    }
                    J.Q0(4);
                    throw null;
                }
                J.Q0(3);
                throw null;
            }
            J.Q0(2);
            throw null;
        }
        J.Q0(1);
        throw null;
    }

    @Override  // Me.b
    public final List F() {
        List list0 = Collections.EMPTY_LIST;
        if(list0 != null) {
            return list0;
        }
        J.Q0(7);
        throw null;
    }

    @Override  // Pe.G
    public static void Q0(int v) {
        Object[] arr_object = new Object[(v == 6 || v == 7 || v == 8 ? 2 : 3)];
        switch(v) {
            case 1: {
                arr_object[0] = "annotations";
                break;
            }
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
            case 6: 
            case 7: 
            case 8: {
                arr_object[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
                break;
            }
            default: {
                arr_object[0] = "correspondingProperty";
            }
        }
        switch(v) {
            case 6: {
                arr_object[1] = "getOverriddenDescriptors";
                break;
            }
            case 7: {
                arr_object[1] = "getValueParameters";
                break;
            }
            case 8: {
                arr_object[1] = "getOriginal";
                break;
            }
            default: {
                arr_object[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
            }
        }
        if(v != 6 && v != 7 && v != 8) {
            arr_object[2] = "<init>";
        }
        String s = String.format((v == 6 || v == 7 || v == 8 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter \'%s\' of %s.%s must not be null"), arr_object);
        IllegalStateException illegalStateException0 = v == 6 || v == 7 || v == 8 ? new IllegalStateException(s) : new IllegalArgumentException(s);
        throw illegalStateException0;
    }

    @Override  // Me.k
    public final Object R(m m0, Object object0) {
        return m0.w(this, object0);
    }

    @Override  // Me.b
    public final b a() {
        return this.v1();
    }

    @Override  // Me.c
    public final c a() {
        return this.v1();
    }

    @Override  // Pe.n, Me.k
    public final k a() {
        return this.v1();
    }

    @Override  // Me.u
    public final u a() {
        return this.v1();
    }

    @Override  // Me.c
    public final Collection f() {
        return this.u1(true);
    }

    @Override  // Me.b
    public final x getReturnType() {
        return this.m;
    }

    @Override  // Pe.n
    public final l s1() {
        return this.v1();
    }

    public final J v1() {
        J j0 = this.n;
        if(j0 != null) {
            return j0;
        }
        J.Q0(8);
        throw null;
    }

    public final void w1(x x0) {
        if(x0 == null) {
            x0 = this.t1().getType();
        }
        this.m = x0;
    }
}

