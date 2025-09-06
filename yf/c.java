package yf;

import Je.k;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;

public enum c {
    BOOLEAN(k.f, "boolean", "Z", "java.lang.Boolean"),
    CHAR(k.g, "char", "C", "java.lang.Character"),
    BYTE(k.h, "byte", "B", "java.lang.Byte"),
    SHORT(k.i, "short", "S", "java.lang.Short"),
    INT(k.j, "int", "I", "java.lang.Integer"),
    FLOAT(k.k, "float", "F", "java.lang.Float"),
    LONG(k.l, "long", "J", "java.lang.Long"),
    DOUBLE(k.m, "double", "D", "java.lang.Double");

    public final k a;
    public final String b;
    public final String c;
    public final qf.c d;
    public static final HashMap m;
    public static final EnumMap n;
    public static final HashMap o;
    public static final HashSet r;
    public static final HashMap w;

    static {
        c.m = new HashMap();
        c.n = new EnumMap(k.class);
        c.o = new HashMap();
        c.r = new HashSet();
        c.w = new HashMap();
        c[] arr_c = (c[])c.B.clone();
        for(int v = 0; v < arr_c.length; ++v) {
            c c0 = arr_c[v];
            c.m.put(c0.b, c0);
            k k0 = c0.d();
            c.n.put(k0, c0);
            String s = c0.c();
            c.o.put(s, c0);
            String s1 = c0.d.a.a.replace('.', '/');
            c.r.add(s1);
            c.w.put(s1, "(" + c0.c + ")L" + s1 + ";");
        }
    }

    public c(k k0, String s1, String s2, String s3) {
        if(k0 != null) {
            super(s, v);
            this.a = k0;
            this.b = s1;
            this.c = s2;
            this.d = new qf.c(s3);
            return;
        }
        c.a(8);
        throw null;
    }

    public static void a(int v) {
        Object[] arr_object = new Object[(v == 4 || v == 6 || (v == 12 || v == 13 || v == 14 || v == 15) ? 2 : 3)];
        switch(v) {
            case 1: {
                arr_object[0] = "owner";
                break;
            }
            case 2: {
                arr_object[0] = "methodDescriptor";
                break;
            }
            case 5: {
                arr_object[0] = "type";
                break;
            }
            case 8: {
                arr_object[0] = "primitiveType";
                break;
            }
            case 3: 
            case 9: {
                arr_object[0] = "name";
                break;
            }
            case 7: 
            case 10: {
                arr_object[0] = "desc";
                break;
            }
            case 11: {
                arr_object[0] = "wrapperClassName";
                break;
            }
            case 4: 
            case 6: 
            case 12: 
            case 13: 
            case 14: 
            case 15: {
                arr_object[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
                break;
            }
            default: {
                arr_object[0] = "internalName";
            }
        }
        if(v == 4 || v == 6) {
            arr_object[1] = "get";
        }
        else {
            switch(v) {
                case 12: {
                    arr_object[1] = "getPrimitiveType";
                    break;
                }
                case 13: {
                    arr_object[1] = "getJavaKeywordName";
                    break;
                }
                case 14: {
                    arr_object[1] = "getDesc";
                    break;
                }
                case 15: {
                    arr_object[1] = "getWrapperFqName";
                    break;
                }
                default: {
                    arr_object[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
                }
            }
        }
        switch(v) {
            case 1: 
            case 2: {
                arr_object[2] = "isBoxingMethodDescriptor";
                break;
            }
            case 3: 
            case 5: {
                arr_object[2] = "get";
                break;
            }
            case 7: {
                arr_object[2] = "getByDesc";
                break;
            }
            case 8: 
            case 9: 
            case 10: 
            case 11: {
                arr_object[2] = "<init>";
                break;
            }
            case 4: 
            case 6: 
            case 12: 
            case 13: 
            case 14: 
            case 15: {
                break;
            }
            default: {
                arr_object[2] = "isWrapperClassInternalName";
            }
        }
        String s = String.format((v == 4 || v == 6 || (v == 12 || v == 13 || v == 14 || v == 15) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter \'%s\' of %s.%s must not be null"), arr_object);
        IllegalStateException illegalStateException0 = v == 4 || v == 6 || (v == 12 || v == 13 || v == 14 || v == 15) ? new IllegalStateException(s) : new IllegalArgumentException(s);
        throw illegalStateException0;
    }

    public static c b(String s) {
        c c0 = (c)c.m.get(s);
        if(c0 == null) {
            throw new AssertionError("Non-primitive type name passed: " + s);
        }
        return c0;
    }

    public final String c() {
        String s = this.c;
        if(s != null) {
            return s;
        }
        c.a(14);
        throw null;
    }

    public final k d() {
        k k0 = this.a;
        if(k0 != null) {
            return k0;
        }
        c.a(12);
        throw null;
    }
}

