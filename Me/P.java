package Me;

import Bf.e;
import Pe.N;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceConfigurationError;
import java.util.Set;
import je.n;

public abstract class p {
    public static final o a;
    public static final o b;
    public static final o c;
    public static final o d;
    public static final o e;
    public static final o f;
    public static final o g;
    public static final o h;
    public static final o i;
    public static final Set j;
    public static final Map k;
    public static final o l;
    public static final O m;
    public static final O n;
    public static final O o;
    public static final Nf.o p;
    public static final HashMap q;

    static {
        Nf.o o9;
        Iterator iterator0;
        a0 a00 = a0.c;
        o o0 = new o(a00, 0);
        p.a = o0;
        b0 b00 = b0.c;
        o o1 = new o(b00, 1);
        p.b = o1;
        c0 c00 = c0.c;
        o o2 = new o(c00, 2);
        p.c = o2;
        X x0 = X.c;
        o o3 = new o(x0, 3);
        p.d = o3;
        d0 d00 = d0.c;
        o o4 = new o(d00, 4);
        p.e = o4;
        Z z0 = Z.c;
        o o5 = new o(z0, 5);
        p.f = o5;
        W w0 = W.c;
        o o6 = new o(w0, 6);
        p.g = o6;
        o o7 = new o(Y.c, 7);
        p.h = o7;
        e0 e00 = e0.c;
        Y y0 = Y.c;
        o o8 = new o(e00, 8);
        p.i = o8;
        p.j = Collections.unmodifiableSet(n.A0(new o[]{o0, o1, o3, o5}));
        HashMap hashMap0 = new HashMap(6);
        hashMap0.put(o1, 0);
        hashMap0.put(o0, 0);
        hashMap0.put(o3, 1);
        hashMap0.put(o2, 1);
        hashMap0.put(o4, 2);
        p.k = Collections.unmodifiableMap(hashMap0);
        p.l = o4;
        p.m = new O(2);
        p.n = new O(3);
        p.o = new O(4);
        try {
            iterator0 = Arrays.asList(new Nf.o[0]).iterator();
        }
        catch(Throwable throwable0) {
            throw new ServiceConfigurationError(throwable0.getMessage(), throwable0);
        }
        if(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            o9 = (Nf.o)object0;
        }
        else {
            o9 = Nf.o.a;
        }
        p.p = o9;
        HashMap hashMap1 = new HashMap();
        p.q = hashMap1;
        hashMap1.put(a00, o0);
        hashMap1.put(b00, o1);
        hashMap1.put(c00, o2);
        hashMap1.put(x0, o3);
        hashMap1.put(d00, o4);
        hashMap1.put(z0, o5);
        hashMap1.put(w0, o6);
        hashMap1.put(y0, o7);
        hashMap1.put(e00, o8);
    }

    public static void a(int v) {
        Object[] arr_object = new Object[(v == 16 ? 2 : 3)];
        if(v == 1 || v == 3 || (v == 5 || v == 7)) {
            arr_object[0] = "from";
        }
        else {
            switch(v) {
                case 9: {
                    arr_object[0] = "from";
                    break;
                }
                case 10: 
                case 12: {
                    arr_object[0] = "first";
                    break;
                }
                case 11: 
                case 13: {
                    arr_object[0] = "second";
                    break;
                }
                case 14: 
                case 15: {
                    arr_object[0] = "visibility";
                    break;
                }
                case 16: {
                    arr_object[0] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
                    break;
                }
                default: {
                    arr_object[0] = "what";
                }
            }
        }
        arr_object[1] = v == 16 ? "toDescriptorVisibility" : "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
        switch(v) {
            case 2: 
            case 3: {
                arr_object[2] = "isVisibleIgnoringReceiver";
                break;
            }
            case 4: 
            case 5: {
                arr_object[2] = "isVisibleWithAnyReceiver";
                break;
            }
            case 6: 
            case 7: {
                arr_object[2] = "inSameFile";
                break;
            }
            case 8: 
            case 9: {
                arr_object[2] = "findInvisibleMember";
                break;
            }
            case 10: 
            case 11: {
                arr_object[2] = "compareLocal";
                break;
            }
            case 12: 
            case 13: {
                arr_object[2] = "compare";
                break;
            }
            case 14: {
                arr_object[2] = "isPrivate";
                break;
            }
            case 15: {
                arr_object[2] = "toDescriptorVisibility";
                break;
            }
            case 16: {
                break;
            }
            default: {
                arr_object[2] = "isVisible";
            }
        }
        String s = String.format((v == 16 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter \'%s\' of %s.%s must not be null"), arr_object);
        IllegalArgumentException illegalArgumentException0 = v == 16 ? new IllegalStateException(s) : new IllegalArgumentException(s);
        throw illegalArgumentException0;
    }

    public static Integer b(o o0, o o1) {
        if(o0 != null) {
            g0 g00 = o0.a;
            if(o1 != null) {
                g0 g01 = o1.a;
                Integer integer0 = g00.a(g01);
                if(integer0 != null) {
                    return integer0;
                }
                Integer integer1 = g01.a(g00);
                return integer1 == null ? null : ((int)(-((int)integer1)));
            }
            p.a(13);
            throw null;
        }
        p.a(12);
        throw null;
    }

    public static Me.n c(e e0, Me.n n0, k k0) {
        if(n0 != null) {
            if(k0 != null) {
                for(Me.n n1 = (Me.n)n0.a(); n1 != null && n1.getVisibility() != p.f; n1 = (Me.n)tf.e.i(n1, Me.n.class, true)) {
                    if(!n1.getVisibility().a(e0, n1, k0)) {
                        return n1;
                    }
                }
                if(n0 instanceof N) {
                    Me.n n2 = p.c(e0, ((Pe.O)(((N)n0))).b0, k0);
                    return n2 == null ? null : n2;
                }
                return null;
            }
            p.a(9);
            throw null;
        }
        p.a(8);
        throw null;
    }

    public static boolean d(Me.n n0, k k0) {
        if(k0 != null) {
            O o0 = tf.e.f(k0);
            return o0 == () -> switch(this.a) {
                case 2: {
                    throw new IllegalStateException("This method should not be called");
                }
                case 3: {
                    throw new IllegalStateException("This method should not be called");
                }
                default: {
                    throw new IllegalStateException("This method should not be called");
                }
            } ? false : o0.equals(tf.e.f(n0));
        }
        p.a(7);
        throw null;
    }

    public static boolean e(o o0) {
        if(o0 != null) {
            return o0 == p.a || o0 == p.b;
        }
        p.a(14);
        throw null;
    }

    public static o f(g0 g00) {
        if(g00 != null) {
            o o0 = (o)p.q.get(g00);
            if(o0 == null) {
                throw new IllegalArgumentException("Inapplicable visibility: " + g00);
            }
            return o0;
        }
        p.a(15);
        throw null;
    }
}

