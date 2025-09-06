package Pe;

import Hf.x;
import Me.N;
import Me.V;
import Me.k;
import Ne.h;
import java.util.Collections;
import java.util.List;
import qf.e;

public abstract class T extends n implements V {
    public x e;

    public T(k k0, h h0, e e0, x x0, N n0) {
        if(k0 != null) {
            if(h0 != null) {
                if(e0 != null) {
                    if(n0 != null) {
                        super(k0, h0, e0, n0);
                        this.e = x0;
                        return;
                    }
                    T.Q0(3);
                    throw null;
                }
                T.Q0(2);
                throw null;
            }
            T.Q0(1);
            throw null;
        }
        T.Q0(0);
        throw null;
    }

    @Override  // Me.b
    public final List F() {
        List list0 = Collections.EMPTY_LIST;
        if(list0 != null) {
            return list0;
        }
        T.Q0(6);
        throw null;
    }

    @Override  // Me.b
    public u L() {
        return null;
    }

    @Override  // Me.b
    public u Q() {
        return null;
    }

    @Override  // Pe.n
    public static void Q0(int v) {
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
            case 10: {
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
            case 10: {
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
                arr_object[0] = "annotations";
                break;
            }
            case 2: {
                arr_object[0] = "name";
                break;
            }
            case 3: {
                arr_object[0] = "source";
                break;
            }
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: {
                arr_object[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
            }
            default: {
                arr_object[0] = "containingDeclaration";
            }
        }
        switch(v) {
            case 4: {
                arr_object[1] = "getType";
                break;
            }
            case 5: {
                arr_object[1] = "getOriginal";
                break;
            }
            case 6: {
                arr_object[1] = "getValueParameters";
                break;
            }
            case 7: {
                arr_object[1] = "getOverriddenDescriptors";
                break;
            }
            case 8: {
                arr_object[1] = "getTypeParameters";
                break;
            }
            case 9: {
                arr_object[1] = "getContextReceiverParameters";
                break;
            }
            case 10: {
                arr_object[1] = "getReturnType";
                break;
            }
            default: {
                arr_object[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
            }
        }
        switch(v) {
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: {
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
            case 10: {
                illegalArgumentException0 = new IllegalStateException(s1);
                break;
            }
            default: {
                illegalArgumentException0 = new IllegalArgumentException(s1);
            }
        }
        throw illegalArgumentException0;
    }

    @Override  // Me.b
    public x getReturnType() {
        x x0 = this.getType();
        if(x0 != null) {
            return x0;
        }
        T.Q0(10);
        throw null;
    }

    @Override  // Me.U, Bf.a
    public final x getType() {
        x x0 = this.e;
        if(x0 != null) {
            return x0;
        }
        T.Q0(4);
        throw null;
    }

    @Override  // Me.b
    public List getTypeParameters() {
        List list0 = Collections.EMPTY_LIST;
        if(list0 != null) {
            return list0;
        }
        T.Q0(8);
        throw null;
    }

    @Override  // Me.b
    public boolean o0() {
        return false;
    }
}

