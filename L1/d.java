package l1;

public final class d {
    public final int a;

    public d(int v) {
        this.a = v;
    }

    public static String a(int v) {
        switch(v) {
            case 0x80000000: {
                return "Hyphens.Unspecified";
            }
            case 1: {
                return "Hyphens.None";
            }
            case 2: {
                return "Hyphens.Auto";
            }
            default: {
                return "Invalid";
            }
        }
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof d && this.a == ((d)object0).a;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        return d.a(this.a);
    }
}

