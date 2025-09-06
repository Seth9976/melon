package Ze;

import Bf.e;
import Me.E;
import Me.k;
import Me.n;
import Me.p;
import Pe.C;
import Qe.a;
import Qe.b;
import Qe.c;
import java.util.HashMap;

public abstract class o {
    public static final Me.o a;
    public static final Me.o b;
    public static final Me.o c;
    public static final HashMap d;

    static {
        Me.o o0 = new Me.o(a.c, 9);
        o.a = o0;
        Me.o o1 = new Me.o(c.c, 10);
        o.b = o1;
        Me.o o2 = new Me.o(b.c, 11);
        o.c = o2;
        HashMap hashMap0 = new HashMap();
        o.d = hashMap0;
        hashMap0.put(a.c, o0);
        hashMap0.put(c.c, o1);
        hashMap0.put(b.c, o2);
    }

    public static void a(int v) {
        Object[] arr_object = new Object[(v == 5 || v == 6 ? 2 : 3)];
        switch(v) {
            case 1: {
                arr_object[0] = "from";
                break;
            }
            case 2: {
                arr_object[0] = "first";
                break;
            }
            case 3: {
                arr_object[0] = "second";
                break;
            }
            case 4: {
                arr_object[0] = "visibility";
                break;
            }
            case 5: 
            case 6: {
                arr_object[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
                break;
            }
            default: {
                arr_object[0] = "what";
            }
        }
        arr_object[1] = v == 5 || v == 6 ? "toDescriptorVisibility" : "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        if(v == 2 || v == 3) {
            arr_object[2] = "areInSamePackage";
        }
        else {
            switch(v) {
                case 4: {
                    arr_object[2] = "toDescriptorVisibility";
                    break;
                }
                case 5: 
                case 6: {
                    break;
                }
                default: {
                    arr_object[2] = "isVisibleForProtectedAndPackage";
                }
            }
        }
        String s = String.format((v == 5 || v == 6 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter \'%s\' of %s.%s must not be null"), arr_object);
        IllegalStateException illegalStateException0 = v == 5 || v == 6 ? new IllegalStateException(s) : new IllegalArgumentException(s);
        throw illegalStateException0;
    }

    public static boolean b(e e0, n n0, k k0) {
        if(k0 != null) {
            if(n0 instanceof Me.c) {
                return o.c(tf.e.s(((Me.c)n0)), k0) ? true : p.c.a(e0, n0, k0);
            }
            return o.c(n0, k0) ? true : p.c.a(e0, n0, k0);
        }
        o.a(1);
        throw null;
    }

    public static boolean c(n n0, k k0) {
        if(n0 != null) {
            if(k0 != null) {
                E e0 = (E)tf.e.i(n0, E.class, false);
                E e1 = (E)tf.e.i(k0, E.class, false);
                return e1 != null && e0 != null && ((C)e0).e.equals(((C)e1).e);
            }
            o.a(3);
            throw null;
        }
        o.a(2);
        throw null;
    }
}

