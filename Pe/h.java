package Pe;

import Bf.b;
import Hf.T;
import Hf.V;
import Hf.b0;
import Hf.c;
import Hf.x;
import Me.L;
import Me.N;
import Me.O;
import Me.k;
import Me.o;
import Me.p;
import Me.y;
import Ne.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import qf.e;
import we.a;
import xf.d;

public final class H {
    public k a;
    public y b;
    public o c;
    public L d;
    public int e;
    public T f;
    public boolean g;
    public final u h;
    public final e i;
    public final x j;
    public final I k;

    public H(I i0) {
        this.k = i0;
        this.a = i0.e();
        this.b = i0.i();
        this.c = i0.getVisibility();
        this.d = null;
        this.e = i0.getKind();
        this.f = T.a;
        this.g = true;
        this.h = i0.E;
        this.i = i0.getName();
        this.j = i0.getType();
    }

    public static void a(int v) {
        IllegalStateException illegalStateException0;
        int v1;
        String s;
        switch(v) {
            case 1: 
            case 2: 
            case 3: 
            case 5: 
            case 7: 
            case 9: 
            case 11: 
            case 13: 
            case 14: 
            case 16: 
            case 17: 
            case 19: {
                s = "@NotNull method %s.%s must not return null";
                break;
            }
            default: {
                s = "Argument for @NotNull parameter \'%s\' of %s.%s must not be null";
            }
        }
        switch(v) {
            case 1: 
            case 2: 
            case 3: 
            case 5: 
            case 7: 
            case 9: 
            case 11: 
            case 13: 
            case 14: 
            case 16: 
            case 17: 
            case 19: {
                v1 = 2;
                break;
            }
            default: {
                v1 = 3;
            }
        }
        Object[] arr_object = new Object[v1];
        switch(v) {
            case 4: {
                arr_object[0] = "type";
                break;
            }
            case 6: {
                arr_object[0] = "modality";
                break;
            }
            case 8: {
                arr_object[0] = "visibility";
                break;
            }
            case 10: {
                arr_object[0] = "kind";
                break;
            }
            case 12: {
                arr_object[0] = "typeParameters";
                break;
            }
            case 15: {
                arr_object[0] = "substitution";
                break;
            }
            case 18: {
                arr_object[0] = "name";
                break;
            }
            case 1: 
            case 2: 
            case 3: 
            case 5: 
            case 7: 
            case 9: 
            case 11: 
            case 13: 
            case 14: 
            case 16: 
            case 17: 
            case 19: {
                arr_object[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                break;
            }
            default: {
                arr_object[0] = "owner";
            }
        }
        switch(v) {
            case 1: {
                arr_object[1] = "setOwner";
                break;
            }
            case 2: {
                arr_object[1] = "setOriginal";
                break;
            }
            case 3: {
                arr_object[1] = "setPreserveSourceElement";
                break;
            }
            case 5: {
                arr_object[1] = "setReturnType";
                break;
            }
            case 7: {
                arr_object[1] = "setModality";
                break;
            }
            case 9: {
                arr_object[1] = "setVisibility";
                break;
            }
            case 11: {
                arr_object[1] = "setKind";
                break;
            }
            case 13: {
                arr_object[1] = "setTypeParameters";
                break;
            }
            case 14: {
                arr_object[1] = "setDispatchReceiverParameter";
                break;
            }
            case 16: {
                arr_object[1] = "setSubstitution";
                break;
            }
            case 17: {
                arr_object[1] = "setCopyOverrides";
                break;
            }
            case 19: {
                arr_object[1] = "setName";
                break;
            }
            default: {
                arr_object[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
            }
        }
        switch(v) {
            case 4: {
                arr_object[2] = "setReturnType";
                break;
            }
            case 6: {
                arr_object[2] = "setModality";
                break;
            }
            case 8: {
                arr_object[2] = "setVisibility";
                break;
            }
            case 10: {
                arr_object[2] = "setKind";
                break;
            }
            case 12: {
                arr_object[2] = "setTypeParameters";
                break;
            }
            case 15: {
                arr_object[2] = "setSubstitution";
                break;
            }
            case 18: {
                arr_object[2] = "setName";
                break;
            }
            case 1: 
            case 2: 
            case 3: 
            case 5: 
            case 7: 
            case 9: 
            case 11: 
            case 13: 
            case 14: 
            case 16: 
            case 17: 
            case 19: {
                break;
            }
            default: {
                arr_object[2] = "setOwner";
            }
        }
        String s1 = String.format(s, arr_object);
        switch(v) {
            case 1: 
            case 2: 
            case 3: 
            case 5: 
            case 7: 
            case 9: 
            case 11: 
            case 13: 
            case 14: 
            case 16: 
            case 17: 
            case 19: {
                illegalStateException0 = new IllegalStateException(s1);
                break;
            }
            default: {
                illegalStateException0 = new IllegalArgumentException(s1);
            }
        }
        throw illegalStateException0;
    }

    public final I b() {
        Me.u u8;
        J j1;
        u u7;
        u u5;
        u u4;
        I i0 = this.k;
        I i1 = i0.v1(this.a, this.b, this.c, this.d, this.e, this.i);
        List list0 = i0.getTypeParameters();
        ArrayList arrayList0 = new ArrayList(((ArrayList)list0).size());
        V v0 = c.A(list0, this.f, i1, arrayList0);
        x x0 = this.j;
        x x1 = v0.i(x0, b0.e);
        r r0 = null;
        if(x1 != null) {
            b0 b00 = b0.d;
            x x2 = v0.i(x0, b00);
            if(x2 != null) {
                i1.z1(x2);
            }
            u u0 = this.h;
            if(u0 == null) {
                goto label_19;
            }
            u u1 = u0.u1(v0);
            if(u1 != null) {
                u u2 = u1;
                goto label_20;
            label_19:
                u2 = null;
            label_20:
                u u3 = i0.G;
                if(u3 == null) {
                    u5 = null;
                }
                else {
                    x x3 = v0.i(u3.getType(), b00);
                    if(x3 == null) {
                        u4 = null;
                    }
                    else {
                        u3.t1();
                        u4 = new u(i1, new Bf.c(i1, x3), u3.getAnnotations());
                    }
                    u5 = u4;
                }
                ArrayList arrayList1 = new ArrayList();
                for(Object object0: i0.D) {
                    u u6 = (u)object0;
                    x x4 = v0.i(u6.getType(), b0.d);
                    if(x4 == null) {
                        u7 = null;
                    }
                    else {
                        e e0 = ((b)u6.t1()).r1();
                        u6.t1();
                        u7 = new u(i1, new b(i1, x4, e0), u6.getAnnotations());
                    }
                    if(u7 != null) {
                        arrayList1.add(u7);
                    }
                }
                i1.A1(x1, arrayList0, u2, u5, arrayList1);
                J j0 = i0.M;
                O o0 = N.q;
                if(j0 == null) {
                    j1 = null;
                }
                else {
                    h h0 = j0.getAnnotations();
                    y y0 = this.b;
                    o o1 = i0.M.getVisibility();
                    if(this.e == 2 && p.e(p.f(o1.a.c()))) {
                        o1 = p.h;
                    }
                    j1 = new J(i1, h0, y0, o1, i0.M.e, i0.M.f, i0.M.i, this.e, (this.d == null ? null : this.d.getGetter()), o0);
                }
                if(j1 != null) {
                    x x5 = i0.M.m;
                    j1.l = I.w1(v0, i0.M);
                    j1.w1((x5 == null ? null : v0.i(x5, b0.e)));
                }
                K k0 = i0.N;
                if(k0 == null) {
                    u8 = null;
                }
                else {
                    h h1 = k0.getAnnotations();
                    y y1 = this.b;
                    o o2 = i0.N.getVisibility();
                    if(this.e == 2 && p.e(p.f(o2.a.c()))) {
                        o2 = p.h;
                    }
                    u8 = new K(i1, h1, y1, o2, i0.N.e, i0.N.f, i0.N.i, this.e, (this.d == null ? null : this.d.b()), o0);
                }
                if(u8 != null) {
                    List list1 = t.x1(u8, i0.N.F(), v0, false, false, null);
                    if(list1 == null) {
                        list1 = Collections.singletonList(K.v1(((K)u8), d.e(this.a).o(), ((S)i0.N.F().get(0)).getAnnotations()));
                    }
                    if(list1.size() != 1) {
                        throw new IllegalStateException();
                    }
                    u8.l = I.w1(v0, i0.N);
                    S s0 = (S)list1.get(0);
                    if(s0 != null) {
                        u8.m = s0;
                        goto label_85;
                    }
                    K.Q0(6);
                    throw null;
                }
            label_85:
                r r1 = i0.S == null ? null : new r(i0.S.getAnnotations(), i1);
                r r2 = i0.T;
                if(r2 != null) {
                    r0 = new r(r2.getAnnotations(), i1);
                }
                i1.x1(j1, ((K)u8), r1, r0);
                if(this.g) {
                    Qf.h h2 = Qf.k.e();
                    for(Object object1: i0.f()) {
                        h2.add(((L)object1).c(v0));
                    }
                    i1.k = h2;
                }
                if(i0.isConst()) {
                    a a0 = i0.h;
                    if(a0 != null) {
                        i1.y1(i0.g, a0);
                    }
                }
                return i1;
            }
        }
        return null;
    }
}

