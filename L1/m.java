package l1;

public final class m {
    public final int a;

    public m(int v) {
        this.a = v;
    }

    public static String a(int v) {
        switch(v) {
            case 0x80000000: {
                return "Unspecified";
            }
            case 1: {
                return "Ltr";
            }
            case 2: {
                return "Rtl";
            }
            case 3: {
                return "Content";
            }
            case 4: {
                return "ContentOrLtr";
            }
            case 5: {
                return "ContentOrRtl";
            }
            default: {
                return "Invalid";
            }
        }
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof m && this.a == ((m)object0).a;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        return m.a(this.a);
    }
}

