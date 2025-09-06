package bf;

import Hf.Y;
import Hf.x;
import Je.i;
import Je.t;
import Me.L;
import Me.N;
import Me.k;
import Me.o;
import Me.y;
import Ne.h;
import Pe.I;
import Pe.J;
import Pe.K;
import Pe.S;
import Pe.u;
import Ze.v;
import cf.c;
import ie.m;
import java.util.ArrayList;
import je.w;
import kotlin.jvm.internal.q;
import qf.e;

public class g extends I implements a {
    public final boolean V;
    public final m W;

    public g(k k0, h h0, y y0, o o0, boolean z, e e0, N n0, L l0, int v, boolean z1, m m0) {
        if(k0 != null) {
            if(h0 != null) {
                if(y0 != null) {
                    if(o0 != null) {
                        if(e0 != null) {
                            if(n0 != null) {
                                if(v != 0) {
                                    super(k0, l0, h0, y0, o0, z, e0, v, n0, false, false, false, false, false);
                                    this.V = z1;
                                    this.W = m0;
                                    return;
                                }
                                g.Q0(6);
                                throw null;
                            }
                            g.Q0(5);
                            throw null;
                        }
                        g.Q0(4);
                        throw null;
                    }
                    g.Q0(3);
                    throw null;
                }
                g.Q0(2);
                throw null;
            }
            g.Q0(1);
            throw null;
        }
        g.Q0(0);
        throw null;
    }

    public static g B1(k k0, c c0, o o0, boolean z, e e0, Re.g g0, boolean z1) {
        y y0 = y.b;
        if(k0 != null) {
            if(e0 != null) {
                return new g(k0, c0, y0, o0, z, e0, g0, null, 1, z1, null);
            }
            g.Q0(11);
            throw null;
        }
        g.Q0(7);
        throw null;
    }

    @Override  // Pe.I
    public static void Q0(int v) {
        Object[] arr_object = new Object[(v == 21 ? 2 : 3)];
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
            case 3: 
            case 10: {
                arr_object[0] = "visibility";
                break;
            }
            case 4: 
            case 11: {
                arr_object[0] = "name";
                break;
            }
            case 13: {
                arr_object[0] = "newOwner";
                break;
            }
            case 14: {
                arr_object[0] = "newModality";
                break;
            }
            case 15: {
                arr_object[0] = "newVisibility";
                break;
            }
            case 6: 
            case 16: {
                arr_object[0] = "kind";
                break;
            }
            case 17: {
                arr_object[0] = "newName";
                break;
            }
            case 5: 
            case 12: 
            case 18: {
                arr_object[0] = "source";
                break;
            }
            case 19: {
                arr_object[0] = "enhancedValueParameterTypes";
                break;
            }
            case 20: {
                arr_object[0] = "enhancedReturnType";
                break;
            }
            case 21: {
                arr_object[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
                break;
            }
            case 22: {
                arr_object[0] = "inType";
                break;
            }
            default: {
                arr_object[0] = "containingDeclaration";
            }
        }
        arr_object[1] = v == 21 ? "enhance" : "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
        switch(v) {
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: {
                arr_object[2] = "create";
                break;
            }
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: {
                arr_object[2] = "createSubstitutedCopy";
                break;
            }
            case 19: 
            case 20: {
                arr_object[2] = "enhance";
                break;
            }
            case 21: {
                break;
            }
            case 22: {
                arr_object[2] = "setInType";
                break;
            }
            default: {
                arr_object[2] = "<init>";
            }
        }
        String s = String.format((v == 21 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter \'%s\' of %s.%s must not be null"), arr_object);
        IllegalArgumentException illegalArgumentException0 = v == 21 ? new IllegalStateException(s) : new IllegalArgumentException(s);
        throw illegalArgumentException0;
    }

    @Override  // Pe.I, Me.b
    public final Object X(Me.a a0) {
        return this.W == null || !((Me.a)this.W.a).equals(a0) ? null : this.W.b;
    }

    @Override  // Pe.I
    public final boolean isConst() {
        x x0 = this.getType();
        if(this.V) {
            q.g(x0, "type");
            if((i.G(x0) || t.a(x0)) && !Y.e(x0) || i.H(x0)) {
                q.f(v.p, "ENHANCED_NULLABILITY_ANNOTATION");
                return !If.g.u(x0, v.p) || i.H(x0);
            }
        }
        return false;
    }

    @Override  // Pe.T, Me.b
    public final boolean o0() {
        return false;
    }

    @Override  // Pe.I
    public final I v1(k k0, y y0, o o0, L l0, int v, e e0) {
        if(k0 != null) {
            if(y0 != null) {
                if(o0 != null) {
                    if(v != 0) {
                        if(e0 != null) {
                            return new g(k0, this.getAnnotations(), y0, o0, this.f, e0, N.q, l0, v, this.V, this.W);
                        }
                        g.Q0(17);
                        throw null;
                    }
                    g.Q0(16);
                    throw null;
                }
                g.Q0(15);
                throw null;
            }
            g.Q0(14);
            throw null;
        }
        g.Q0(13);
        throw null;
    }

    @Override  // bf.a
    public final a x0(x x0, ArrayList arrayList0, x x1, m m0) {
        K k3;
        J j3;
        u u0 = null;
        L l0 = this.a() == this ? null : this.a();
        k k0 = this.e();
        h h0 = this.getAnnotations();
        y y0 = this.i();
        o o0 = this.getVisibility();
        e e0 = this.getName();
        N n0 = this.getSource();
        int v = this.getKind();
        g g0 = new g(k0, h0, y0, o0, this.f, e0, n0, l0, v, this.V, m0);
        J j0 = this.M;
        if(j0 == null) {
            j3 = null;
        }
        else {
            h h1 = j0.getAnnotations();
            y y1 = j0.i();
            o o1 = j0.getVisibility();
            boolean z = j0.e;
            int v1 = this.getKind();
            J j1 = l0 == null ? null : l0.getGetter();
            J j2 = new J(g0, h1, y1, o1, z, j0.f, j0.i, v1, j1, j0.getSource());
            j2.l = j0.l;
            j2.m = x1;
            j3 = j2;
        }
        K k1 = this.N;
        if(k1 == null) {
            k3 = null;
        }
        else {
            h h2 = k1.getAnnotations();
            y y2 = k1.i();
            o o2 = k1.getVisibility();
            boolean z1 = k1.e;
            int v2 = this.getKind();
            K k2 = l0 == null ? null : l0.b();
            k3 = new K(g0, h2, y2, o2, z1, k1.f, k1.i, v2, k2, k1.getSource());
            k3.l = k3.l;
            S s0 = (S)k1.F().get(0);
            if(s0 != null) {
                k3.m = s0;
                goto label_41;
            }
            K.Q0(6);
            throw null;
        }
    label_41:
        g0.x1(j3, k3, this.S, this.T);
        we.a a0 = this.h;
        if(a0 != null) {
            g0.y1(this.g, a0);
        }
        g0.I0(this.f());
        if(x0 != null) {
            u0 = tf.m.k(this, x0, Ne.g.a);
        }
        g0.A1(x1, this.getTypeParameters(), this.E, u0, w.a);
        return g0;
    }

    @Override  // Pe.I
    public final void z1(x x0) {
    }
}

