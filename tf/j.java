package tf;

public final class j {
    public final int a;
    public final String b;
    public static final j c;

    static {
        j.c = new j(1, "SUCCESS");
    }

    public j(int v, String s) {
        if(v != 0) {
            super();
            this.a = v;
            this.b = s;
            return;
        }
        j.a(3);
        throw null;
    }

    public static void a(int v) {
        Object[] arr_object = new Object[(v == 1 || v == 2 || v == 3 || v == 4 ? 3 : 2)];
        switch(v) {
            case 3: {
                arr_object[0] = "success";
                break;
            }
            case 1: 
            case 2: 
            case 4: {
                arr_object[0] = "debugMessage";
                break;
            }
            default: {
                arr_object[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
            }
        }
        switch(v) {
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                arr_object[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
                break;
            }
            case 5: {
                arr_object[1] = "getResult";
                break;
            }
            case 6: {
                arr_object[1] = "getDebugMessage";
                break;
            }
            default: {
                arr_object[1] = "success";
            }
        }
        switch(v) {
            case 1: {
                arr_object[2] = "incompatible";
                break;
            }
            case 2: {
                arr_object[2] = "conflict";
                break;
            }
            case 3: 
            case 4: {
                arr_object[2] = "<init>";
            }
        }
        String s = String.format((v == 1 || v == 2 || v == 3 || v == 4 ? "Argument for @NotNull parameter \'%s\' of %s.%s must not be null" : "@NotNull method %s.%s must not return null"), arr_object);
        IllegalArgumentException illegalArgumentException0 = v == 1 || v == 2 || v == 3 || v == 4 ? new IllegalArgumentException(s) : new IllegalStateException(s);
        throw illegalArgumentException0;
    }

    public final int b() {
        int v = this.a;
        if(v != 0) {
            return v;
        }
        j.a(5);
        throw null;
    }

    public static j c(String s) {
        return new j(2, s);
    }

    @Override
    public final String toString() {
        String s;
        StringBuilder stringBuilder0 = new StringBuilder();
        switch(this.a) {
            case 1: {
                s = "OVERRIDABLE";
                break;
            }
            case 2: {
                s = "INCOMPATIBLE";
                break;
            }
            case 3: {
                s = "CONFLICT";
                break;
            }
            default: {
                s = "null";
            }
        }
        stringBuilder0.append(s);
        stringBuilder0.append(": ");
        stringBuilder0.append(this.b);
        return stringBuilder0.toString();
    }
}

