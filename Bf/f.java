package bf;

import Hf.V;
import Hf.x;
import Me.N;
import Me.k;
import Me.o;
import Me.y;
import Ne.h;
import Nf.i;
import Nf.r;
import Pe.L;
import Pe.s;
import Pe.t;
import Pe.u;
import Re.g;
import Tf.n;
import b3.Z;
import cf.c;
import ie.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.q;

public final class f extends L implements a {
    public int Y;
    public final boolean Z;
    public static final e b0;
    public static final e c0;

    static {
        f.b0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        f.c0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public f(k k0, L l0, h h0, qf.e e0, int v, N n0, boolean z) {
        if(k0 != null) {
            if(h0 != null) {
                if(e0 != null) {
                    if(v != 0) {
                        super(k0, l0, h0, e0, v, n0);
                        this.Y = 0;
                        this.Z = z;
                        return;
                    }
                    f.Q0(3);
                    throw null;
                }
                f.Q0(2);
                throw null;
            }
            f.Q0(1);
            throw null;
        }
        f.Q0(0);
        throw null;
    }

    @Override  // Pe.L
    public final L H1(u u0, u u1, List list0, List list1, List list2, x x0, y y0, o o0, Map map0) {
        Nf.f f0;
        if(list0 != null) {
            if(list1 != null) {
                if(list2 != null) {
                    if(o0 != null) {
                        super.H1(u0, u1, list0, list1, list2, x0, y0, o0, map0);
                        for(Object object0: r.e) {
                            i i0 = (i)object0;
                            n n0 = i0.b;
                            if(i0.a != null && !q.b(this.getName(), i0.a)) {
                                continue;
                            }
                            if(n0 != null) {
                                String s = this.getName().b();
                                q.f(s, "asString(...)");
                                if(n0.b(s)) {
                                    goto label_15;
                                }
                                continue;
                            }
                        label_15:
                            if(i0.c != null && !i0.c.contains(this.getName())) {
                                continue;
                            }
                            Nf.e[] arr_e = i0.e;
                            for(int v = 0; v < arr_e.length; ++v) {
                                if(arr_e[v].b(this) != null) {
                                    f0 = new Nf.f(false);  // 初始化器: LNf/g;-><init>(Z)V
                                    this.m = f0.a;
                                    return this;
                                }
                            }
                            f0 = ((String)i0.d.invoke(this)) == null ? Nf.f.c : new Nf.f(false);  // 初始化器: LNf/g;-><init>(Z)V
                            this.m = f0.a;
                            return this;
                        }
                        f0 = Nf.f.b;
                        this.m = f0.a;
                        return this;
                    }
                    f.Q0(12);
                    throw null;
                }
                f.Q0(11);
                throw null;
            }
            f.Q0(10);
            throw null;
        }
        f.Q0(9);
        throw null;
    }

    public static f I1(k k0, c c0, qf.e e0, g g0, boolean z) {
        if(k0 != null) {
            if(e0 != null) {
                return new f(k0, null, c0, e0, 1, g0, z);
            }
            f.Q0(7);
            throw null;
        }
        f.Q0(5);
        throw null;
    }

    public final void J1(boolean z, boolean z1) {
        int v;
        if(!z) {
            v = z1 ? 3 : 1;
        }
        else if(z1) {
            v = 4;
        }
        else {
            v = 2;
        }
        this.Y = v;
    }

    @Override  // Pe.L
    public static void Q0(int v) {
        Object[] arr_object = new Object[(v == 13 || v == 18 || v == 21 ? 2 : 3)];
        switch(v) {
            case 2: 
            case 7: {
                arr_object[0] = "name";
                break;
            }
            case 9: {
                arr_object[0] = "contextReceiverParameters";
                break;
            }
            case 10: {
                arr_object[0] = "typeParameters";
                break;
            }
            case 11: {
                arr_object[0] = "unsubstitutedValueParameters";
                break;
            }
            case 12: {
                arr_object[0] = "visibility";
                break;
            }
            case 14: {
                arr_object[0] = "newOwner";
                break;
            }
            case 3: 
            case 15: {
                arr_object[0] = "kind";
                break;
            }
            case 1: 
            case 6: 
            case 16: {
                arr_object[0] = "annotations";
                break;
            }
            case 4: 
            case 8: 
            case 17: {
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
            case 13: 
            case 18: 
            case 21: {
                arr_object[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
            }
            default: {
                arr_object[0] = "containingDeclaration";
            }
        }
        switch(v) {
            case 13: {
                arr_object[1] = "initialize";
                break;
            }
            case 18: {
                arr_object[1] = "createSubstitutedCopy";
                break;
            }
            case 21: {
                arr_object[1] = "enhance";
                break;
            }
            default: {
                arr_object[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
            }
        }
        switch(v) {
            case 5: 
            case 6: 
            case 7: 
            case 8: {
                arr_object[2] = "createJavaMethod";
                break;
            }
            case 9: 
            case 10: 
            case 11: 
            case 12: {
                arr_object[2] = "initialize";
                break;
            }
            case 14: 
            case 15: 
            case 16: 
            case 17: {
                arr_object[2] = "createSubstitutedCopy";
                break;
            }
            case 19: 
            case 20: {
                arr_object[2] = "enhance";
                break;
            }
            case 13: 
            case 18: 
            case 21: {
                break;
            }
            default: {
                arr_object[2] = "<init>";
            }
        }
        String s = String.format((v == 13 || v == 18 || v == 21 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter \'%s\' of %s.%s must not be null"), arr_object);
        IllegalStateException illegalStateException0 = v == 13 || v == 18 || v == 21 ? new IllegalStateException(s) : new IllegalArgumentException(s);
        throw illegalStateException0;
    }

    @Override  // Pe.t, Me.b
    public final boolean o0() {
        return Z.a(this.Y);
    }

    @Override  // Pe.L
    public final t v1(int v, k k0, Me.u u0, N n0, h h0, qf.e e0) {
        if(k0 != null) {
            if(v != 0) {
                if(h0 != null) {
                    if(e0 == null) {
                        e0 = this.getName();
                    }
                    t t0 = new f(k0, ((L)u0), h0, e0, v, n0, this.Z);
                    int v1 = this.Y;
                    boolean z = false;
                    switch(v1) {
                        case 1: 
                        case 3: {
                            break;
                        }
                        case 2: 
                        case 4: {
                            z = true;
                            break;
                        }
                        default: {
                            throw null;
                        }
                    }
                    ((f)t0).J1(z, Z.a(v1));
                    return t0;
                }
                f.Q0(16);
                throw null;
            }
            f.Q0(15);
            throw null;
        }
        f.Q0(14);
        throw null;
    }

    @Override  // bf.a
    public final a x0(x x0, ArrayList arrayList0, x x1, m m0) {
        ArrayList arrayList1 = x1.a.o(arrayList0, this.F(), this);
        u u0 = x0 == null ? null : tf.m.k(this, x0, Ne.g.a);
        s s0 = this.z1(V.b);
        s0.g = arrayList1;
        s0.k = x1;
        s0.i = u0;
        s0.r = true;
        s0.o = true;
        a a0 = (f)s0.N.w1(s0);
        if(m0 != null) {
            ((t)a0).A1(((Me.a)m0.a), m0.b);
        }
        if(a0 != null) {
            return a0;
        }
        f.Q0(21);
        throw null;
    }
}

