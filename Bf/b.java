package bf;

import Hf.x;
import Me.N;
import Me.e;
import Me.k;
import Me.o;
import Me.u;
import Me.y;
import Ne.h;
import Pe.i;
import Pe.t;
import Re.g;
import ie.m;
import java.util.ArrayList;
import java.util.List;
import je.w;

public final class b extends i implements a {
    public Boolean Z;
    public Boolean b0;

    public b(e e0, b b0, h h0, boolean z, int v, N n0) {
        if(e0 != null) {
            if(h0 != null) {
                if(v != 0) {
                    if(n0 != null) {
                        super(e0, b0, h0, z, v, n0);
                        this.Z = null;
                        this.b0 = null;
                        return;
                    }
                    b.Q0(3);
                    throw null;
                }
                b.Q0(2);
                throw null;
            }
            b.Q0(1);
            throw null;
        }
        b.Q0(0);
        throw null;
    }

    @Override  // Pe.t
    public final void B1(boolean z) {
        this.Z = Boolean.valueOf(z);
    }

    @Override  // Pe.t
    public final void C1(boolean z) {
        this.b0 = Boolean.valueOf(z);
    }

    @Override  // Pe.i
    public final i E1(int v, k k0, u u0, N n0, h h0, qf.e e0) {
        return this.L1(k0, u0, v, h0, n0);
    }

    public static b K1(e e0, h h0, boolean z, g g0) {
        if(e0 != null) {
            return new b(e0, null, h0, z, 1, g0);
        }
        b.Q0(4);
        throw null;
    }

    public final b L1(k k0, u u0, int v, h h0, N n0) {
        if(k0 != null) {
            if(v != 0) {
                if(h0 != null) {
                    if(n0 != null) {
                        if(v != 1 && v != 4) {
                            throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + k0 + "\nkind: " + H0.b.x(v));
                        }
                        b b0 = new b(((e)k0), ((b)u0), h0, this.Y, v, n0);
                        Boolean boolean0 = this.Z;
                        boolean0.getClass();
                        b0.Z = boolean0;
                        Boolean boolean1 = this.b0;
                        boolean1.getClass();
                        b0.b0 = boolean1;
                        return b0;
                    }
                    b.Q0(10);
                    throw null;
                }
                b.Q0(9);
                throw null;
            }
            b.Q0(8);
            throw null;
        }
        b.Q0(7);
        throw null;
    }

    @Override  // Pe.i
    public static void Q0(int v) {
        Object[] arr_object = new Object[(v == 11 || v == 18 ? 2 : 3)];
        switch(v) {
            case 3: 
            case 6: 
            case 10: {
                arr_object[0] = "source";
                break;
            }
            case 7: 
            case 12: {
                arr_object[0] = "newOwner";
                break;
            }
            case 2: 
            case 8: 
            case 13: {
                arr_object[0] = "kind";
                break;
            }
            case 14: {
                arr_object[0] = "sourceElement";
                break;
            }
            case 1: 
            case 5: 
            case 9: 
            case 15: {
                arr_object[0] = "annotations";
                break;
            }
            case 16: {
                arr_object[0] = "enhancedValueParameterTypes";
                break;
            }
            case 17: {
                arr_object[0] = "enhancedReturnType";
                break;
            }
            case 11: 
            case 18: {
                arr_object[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
                break;
            }
            default: {
                arr_object[0] = "containingDeclaration";
            }
        }
        switch(v) {
            case 11: {
                arr_object[1] = "createSubstitutedCopy";
                break;
            }
            case 18: {
                arr_object[1] = "enhance";
                break;
            }
            default: {
                arr_object[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
            }
        }
        switch(v) {
            case 4: 
            case 5: 
            case 6: {
                arr_object[2] = "createJavaConstructor";
                break;
            }
            case 7: 
            case 8: 
            case 9: 
            case 10: {
                arr_object[2] = "createSubstitutedCopy";
                break;
            }
            case 12: 
            case 13: 
            case 14: 
            case 15: {
                arr_object[2] = "createDescriptor";
                break;
            }
            case 16: 
            case 17: {
                arr_object[2] = "enhance";
                break;
            }
            case 11: 
            case 18: {
                break;
            }
            default: {
                arr_object[2] = "<init>";
            }
        }
        String s = String.format((v == 11 || v == 18 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter \'%s\' of %s.%s must not be null"), arr_object);
        IllegalStateException illegalStateException0 = v == 11 || v == 18 ? new IllegalStateException(s) : new IllegalArgumentException(s);
        throw illegalStateException0;
    }

    @Override  // Pe.t, Me.b
    public final boolean o0() {
        return this.b0.booleanValue();
    }

    @Override  // Pe.i
    public final t v1(int v, k k0, u u0, N n0, h h0, qf.e e0) {
        return this.L1(k0, u0, v, h0, n0);
    }

    @Override  // bf.a
    public final a x0(x x0, ArrayList arrayList0, x x1, m m0) {
        a a0 = this.L1(this.F1(), null, this.getKind(), this.getAnnotations(), this.getSource());
        Pe.u u0 = x0 == null ? null : tf.m.k(a0, x0, Ne.g.a);
        Pe.u u1 = this.j;
        List list0 = this.getTypeParameters();
        ArrayList arrayList1 = x1.a.o(arrayList0, this.F(), ((u)a0));
        y y0 = this.i();
        o o0 = this.getVisibility();
        ((t)a0).y1(u0, u1, w.a, list0, arrayList1, x1, y0, o0);
        if(m0 != null) {
            ((t)a0).A1(((Me.a)m0.a), m0.b);
        }
        return a0;
    }
}

