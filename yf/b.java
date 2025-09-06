package yf;

import qf.c;

public final class b {
    public final String a;

    public b(String s) {
        if(s != null) {
            super();
            this.a = s;
            return;
        }
        b.a(7);
        throw null;
    }

    public static void a(int v) {
        Object[] arr_object = new Object[(v == 3 || v == 5 || (v == 8 || v == 9 || v == 10) ? 2 : 3)];
        switch(v) {
            case 1: 
            case 2: {
                arr_object[0] = "classId";
                break;
            }
            case 4: 
            case 6: {
                arr_object[0] = "fqName";
                break;
            }
            case 3: 
            case 5: 
            case 8: 
            case 9: 
            case 10: {
                arr_object[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
                break;
            }
            default: {
                arr_object[0] = "internalName";
            }
        }
        switch(v) {
            case 3: {
                arr_object[1] = "internalNameByClassId";
                break;
            }
            case 5: {
                arr_object[1] = "byFqNameWithoutInnerClasses";
                break;
            }
            case 8: {
                arr_object[1] = "getFqNameForClassNameWithoutDollars";
                break;
            }
            case 9: {
                arr_object[1] = "getPackageFqName";
                break;
            }
            case 10: {
                arr_object[1] = "getInternalName";
                break;
            }
            default: {
                arr_object[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
            }
        }
        switch(v) {
            case 1: {
                arr_object[2] = "byClassId";
                break;
            }
            case 2: {
                arr_object[2] = "internalNameByClassId";
                break;
            }
            case 4: 
            case 6: {
                arr_object[2] = "byFqNameWithoutInnerClasses";
                break;
            }
            case 7: {
                arr_object[2] = "<init>";
                break;
            }
            case 3: 
            case 5: 
            case 8: 
            case 9: 
            case 10: {
                break;
            }
            default: {
                arr_object[2] = "byInternalName";
            }
        }
        String s = String.format((v == 3 || v == 5 || (v == 8 || v == 9 || v == 10) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter \'%s\' of %s.%s must not be null"), arr_object);
        IllegalStateException illegalStateException0 = v == 3 || v == 5 || (v == 8 || v == 9 || v == 10) ? new IllegalStateException(s) : new IllegalArgumentException(s);
        throw illegalStateException0;
    }

    public static b b(c c0) {
        if(c0 != null) {
            return new b(c0.a.a.replace('.', '/'));
        }
        b.a(4);
        throw null;
    }

    public static b c(String s) {
        if(s != null) {
            return new b(s);
        }
        b.a(0);
        throw null;
    }

    public final String d() {
        String s = this.a;
        if(s != null) {
            return s;
        }
        b.a(10);
        throw null;
    }

    public static String e(qf.b b0) {
        c c0 = b0.a;
        String s = b0.b.a.a.replace('.', '$');
        if(!c0.a.c()) {
            s = c0.a.a.replace('.', '/') + "/" + s;
        }
        if(s != null) {
            return s;
        }
        b.a(3);
        throw null;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return b.class == class0 ? this.a.equals(((b)object0).a) : false;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return this.a;
    }
}

