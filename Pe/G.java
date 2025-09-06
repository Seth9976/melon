package Pe;

import Gf.p;
import Hf.f;
import Hf.x;
import Je.i;
import Jf.k;
import Jf.l;
import Me.O;
import Me.S;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import tf.a;
import tf.c;
import xf.d;

public final class g extends f {
    public final O c;
    public final h d;

    public g(h h0, p p0, O o0) {
        if(p0 != null) {
            this.d = h0;
            super(p0);
            this.c = o0;
            return;
        }
        g.l(0);
        throw null;
    }

    @Override  // Hf.f
    public final Collection b() {
        Collection collection0 = this.d.u1();
        if(collection0 != null) {
            return collection0;
        }
        g.l(1);
        throw null;
    }

    @Override  // Hf.f
    public final x c() {
        return l.c(k.g, new String[0]);
    }

    @Override  // Hf.M
    public final i d() {
        i i0 = d.e(this.d);
        if(i0 != null) {
            return i0;
        }
        g.l(4);
        throw null;
    }

    @Override  // Hf.M
    public final Me.h e() {
        Me.h h0 = this.d;
        if(h0 != null) {
            return h0;
        }
        g.l(3);
        throw null;
    }

    @Override  // Hf.M
    public final boolean g() {
        return true;
    }

    @Override  // Hf.M
    public final List getParameters() {
        List list0 = Collections.EMPTY_LIST;
        if(list0 != null) {
            return list0;
        }
        g.l(2);
        throw null;
    }

    @Override  // Hf.f
    public final O h() {
        O o0 = this.c;
        if(o0 != null) {
            return o0;
        }
        g.l(5);
        throw null;
    }

    // 去混淆评级： 低(20)
    @Override  // Hf.f
    public final boolean j(Me.h h0) {
        return h0 instanceof S && c.a.c(this.d, ((S)h0), true, a.a);
    }

    @Override  // Hf.f
    public final List k(List list0) {
        List list1 = this.d.t1(list0);
        if(list1 != null) {
            return list1;
        }
        g.l(8);
        throw null;
    }

    public static void l(int v) {
        IllegalStateException illegalStateException0;
        int v1;
        String s;
        switch(v) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 8: {
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
            case 4: 
            case 5: 
            case 8: {
                v1 = 2;
                break;
            }
            default: {
                v1 = 3;
            }
        }
        Object[] arr_object = new Object[v1];
        switch(v) {
            case 6: {
                arr_object[0] = "type";
                break;
            }
            case 7: {
                arr_object[0] = "supertypes";
                break;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 8: {
                arr_object[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
                break;
            }
            case 9: {
                arr_object[0] = "classifier";
                break;
            }
            default: {
                arr_object[0] = "storageManager";
            }
        }
        switch(v) {
            case 1: {
                arr_object[1] = "computeSupertypes";
                break;
            }
            case 2: {
                arr_object[1] = "getParameters";
                break;
            }
            case 3: {
                arr_object[1] = "getDeclarationDescriptor";
                break;
            }
            case 4: {
                arr_object[1] = "getBuiltIns";
                break;
            }
            case 5: {
                arr_object[1] = "getSupertypeLoopChecker";
                break;
            }
            case 8: {
                arr_object[1] = "processSupertypesWithoutCycles";
                break;
            }
            default: {
                arr_object[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
            }
        }
        switch(v) {
            case 6: {
                arr_object[2] = "reportSupertypeLoopError";
                break;
            }
            case 7: {
                arr_object[2] = "processSupertypesWithoutCycles";
                break;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 8: {
                break;
            }
            case 9: {
                arr_object[2] = "isSameClassifier";
                break;
            }
            default: {
                arr_object[2] = "<init>";
            }
        }
        String s1 = String.format(s, arr_object);
        switch(v) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 8: {
                illegalStateException0 = new IllegalStateException(s1);
                break;
            }
            default: {
                illegalStateException0 = new IllegalArgumentException(s1);
            }
        }
        throw illegalStateException0;
    }

    @Override
    public final String toString() {
        return this.d.getName().a;
    }
}

