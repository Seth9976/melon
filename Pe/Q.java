package Pe;

import Gf.n;
import Hf.B;
import Hf.M;
import Hf.i;
import Me.N;
import Me.T;
import Me.e;
import Me.f;
import Me.o;
import Me.y;
import Ne.h;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class q extends j {
    public final i g;
    public final p h;
    public final n i;
    public final h j;

    public q(Gf.p p0, e e0, B b0, qf.e e1, n n0, h h0, N n1) {
        if(p0 != null) {
            if(e0 != null) {
                if(b0 != null) {
                    if(e1 != null) {
                        if(n0 != null) {
                            super(p0, e0, e1, n1);
                            this.j = h0;
                            this.g = new i(this, Collections.EMPTY_LIST, Collections.singleton(b0), p0);
                            this.h = new p(this, p0);
                            this.i = n0;
                            return;
                        }
                        q.o(10);
                        throw null;
                    }
                    q.o(9);
                    throw null;
                }
                q.o(8);
                throw null;
            }
            q.o(7);
            throw null;
        }
        q.o(6);
        throw null;
    }

    @Override  // Me.e
    public final Pe.i B() {
        return null;
    }

    @Override  // Me.e
    public final boolean O0() {
        return false;
    }

    @Override  // Me.e
    public final T a0() {
        return null;
    }

    @Override  // Me.x
    public final boolean e0() {
        return false;
    }

    @Override  // Me.e
    public final boolean g0() {
        return false;
    }

    @Override  // Ne.a
    public final h getAnnotations() {
        h h0 = this.j;
        if(h0 != null) {
            return h0;
        }
        q.o(21);
        throw null;
    }

    @Override  // Me.e
    public final f getKind() {
        return f.d;
    }

    @Override  // Me.e
    public final o getVisibility() {
        o o0 = Me.p.e;
        if(o0 != null) {
            return o0;
        }
        q.o(20);
        throw null;
    }

    @Override  // Me.e
    public final List h() {
        List list0 = Collections.EMPTY_LIST;
        if(list0 != null) {
            return list0;
        }
        q.o(22);
        throw null;
    }

    @Override  // Me.e
    public final y i() {
        return y.b;
    }

    @Override  // Me.e
    public final boolean isInline() {
        return false;
    }

    @Override  // Me.e
    public final boolean j() {
        return false;
    }

    @Override  // Me.e
    public final boolean l0() {
        return false;
    }

    @Override  // Pe.y
    public final Af.p n(If.f f0) {
        Af.p p0 = this.h;
        if(p0 != null) {
            return p0;
        }
        q.o(14);
        throw null;
    }

    @Override  // Pe.j
    public static void o(int v) {
        IllegalArgumentException illegalArgumentException0;
        int v1;
        String s;
        switch(v) {
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: {
                s = "@NotNull method %s.%s must not return null";
                break;
            }
            default: {
                s = "Argument for @NotNull parameter \'%s\' of %s.%s must not be null";
            }
        }
        switch(v) {
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: {
                v1 = 2;
                break;
            }
            default: {
                v1 = 3;
            }
        }
        Object[] arr_object = new Object[v1];
        switch(v) {
            case 1: {
                arr_object[0] = "enumClass";
                break;
            }
            case 7: {
                arr_object[0] = "containingClass";
                break;
            }
            case 8: {
                arr_object[0] = "supertype";
                break;
            }
            case 2: 
            case 9: {
                arr_object[0] = "name";
                break;
            }
            case 3: 
            case 10: {
                arr_object[0] = "enumMemberNames";
                break;
            }
            case 4: 
            case 11: {
                arr_object[0] = "annotations";
                break;
            }
            case 5: 
            case 12: {
                arr_object[0] = "source";
                break;
            }
            case 13: {
                arr_object[0] = "kotlinTypeRefiner";
                break;
            }
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: {
                arr_object[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
            }
            default: {
                arr_object[0] = "storageManager";
            }
        }
        switch(v) {
            case 14: {
                arr_object[1] = "getUnsubstitutedMemberScope";
                break;
            }
            case 15: {
                arr_object[1] = "getStaticScope";
                break;
            }
            case 16: {
                arr_object[1] = "getConstructors";
                break;
            }
            case 17: {
                arr_object[1] = "getTypeConstructor";
                break;
            }
            case 18: {
                arr_object[1] = "getKind";
                break;
            }
            case 19: {
                arr_object[1] = "getModality";
                break;
            }
            case 20: {
                arr_object[1] = "getVisibility";
                break;
            }
            case 21: {
                arr_object[1] = "getAnnotations";
                break;
            }
            case 22: {
                arr_object[1] = "getDeclaredTypeParameters";
                break;
            }
            case 23: {
                arr_object[1] = "getSealedSubclasses";
                break;
            }
            default: {
                arr_object[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
            }
        }
        switch(v) {
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: {
                arr_object[2] = "<init>";
                break;
            }
            case 13: {
                arr_object[2] = "getUnsubstitutedMemberScope";
                break;
            }
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: {
                break;
            }
            default: {
                arr_object[2] = "create";
            }
        }
        String s1 = String.format(s, arr_object);
        switch(v) {
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22: 
            case 23: {
                illegalArgumentException0 = new IllegalStateException(s1);
                break;
            }
            default: {
                illegalArgumentException0 = new IllegalArgumentException(s1);
            }
        }
        throw illegalArgumentException0;
    }

    @Override  // Me.h
    public final M q() {
        M m0 = this.g;
        if(m0 != null) {
            return m0;
        }
        q.o(17);
        throw null;
    }

    public static q r(Gf.p p0, e e0, qf.e e1, Gf.i i0, h h0, N n0) {
        if(p0 != null) {
            if(e0 != null) {
                if(e1 != null) {
                    if(i0 != null) {
                        return new q(p0, e0, e0.g(), e1, i0, h0, n0);
                    }
                    q.o(3);
                    throw null;
                }
                q.o(2);
                throw null;
            }
            q.o(1);
            throw null;
        }
        q.o(0);
        throw null;
    }

    @Override  // Me.x
    public final boolean r0() {
        return false;
    }

    @Override  // Me.e
    public final Collection s() {
        Collection collection0 = Collections.EMPTY_LIST;
        if(collection0 != null) {
            return collection0;
        }
        q.o(16);
        throw null;
    }

    @Override  // Me.e
    public final Af.p t0() {
        return Af.o.b;
    }

    @Override
    public final String toString() {
        return "enum entry " + this.getName();
    }

    @Override  // Me.i
    public final boolean x() {
        return false;
    }
}

