package qf;

public final class e implements Comparable {
    public final String a;
    public final boolean b;

    public e(String s, boolean z) {
        if(s != null) {
            super();
            this.a = s;
            this.b = z;
            return;
        }
        e.a(0);
        throw null;
    }

    public static void a(int v) {
        Object[] arr_object = new Object[(v == 1 || v == 2 || v == 3 || v == 4 ? 2 : 3)];
        arr_object[0] = v == 1 || v == 2 || v == 3 || v == 4 ? "kotlin/reflect/jvm/internal/impl/name/Name" : "name";
        switch(v) {
            case 1: {
                arr_object[1] = "asString";
                break;
            }
            case 2: {
                arr_object[1] = "getIdentifier";
                break;
            }
            case 3: 
            case 4: {
                arr_object[1] = "asStringStripSpecialMarkers";
                break;
            }
            default: {
                arr_object[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
            }
        }
        switch(v) {
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                break;
            }
            case 5: {
                arr_object[2] = "identifier";
                break;
            }
            case 6: {
                arr_object[2] = "isValidIdentifier";
                break;
            }
            case 7: {
                arr_object[2] = "identifierIfValid";
                break;
            }
            case 8: {
                arr_object[2] = "special";
                break;
            }
            case 9: {
                arr_object[2] = "guessByFirstCharacter";
                break;
            }
            default: {
                arr_object[2] = "<init>";
            }
        }
        String s = String.format((v == 1 || v == 2 || v == 3 || v == 4 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter \'%s\' of %s.%s must not be null"), arr_object);
        IllegalStateException illegalStateException0 = v == 1 || v == 2 || v == 3 || v == 4 ? new IllegalStateException(s) : new IllegalArgumentException(s);
        throw illegalStateException0;
    }

    public final String b() {
        String s = this.a;
        if(s != null) {
            return s;
        }
        e.a(1);
        throw null;
    }

    public final String c() {
        if(this.b) {
            throw new IllegalStateException("not identifier: " + this);
        }
        String s = this.b();
        if(s != null) {
            return s;
        }
        e.a(2);
        throw null;
    }

    @Override
    public final int compareTo(Object object0) {
        return this.a.compareTo(((e)object0).a);
    }

    public static e d(String s) {
        if(s != null) {
            return s.startsWith("<") ? e.g(s) : e.e(s);
        }
        e.a(9);
        throw null;
    }

    public static e e(String s) {
        if(s != null) {
            return new e(s, false);
        }
        e.a(5);
        throw null;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof e && this.b == ((e)object0).b && this.a.equals(((e)object0).a);
    }

    public static boolean f(String s) {
        if(s != null) {
            if(!s.isEmpty() && !s.startsWith("<")) {
                int v = 0;
                while(v < s.length()) {
                    if(s.charAt(v) != 46 && s.charAt(v) != 0x2F && s.charAt(v) != 92) {
                        ++v;
                        continue;
                    }
                    return false;
                }
                return true;
            }
            return false;
        }
        e.a(6);
        throw null;
    }

    public static e g(String s) {
        if(s != null) {
            if(!s.startsWith("<")) {
                throw new IllegalArgumentException("special name must start with \'<\': " + s);
            }
            return new e(s, true);
        }
        e.a(8);
        throw null;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode() * 0x1F + this.b;
    }

    @Override
    public final String toString() {
        return this.a;
    }
}

