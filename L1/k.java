package l1;

public final class k {
    public final int a;

    public k(int v) {
        this.a = v;
    }

    public static final k a(int v) {
        return new k(v);
    }

    public static String b(int v) {
        switch(v) {
            case 0x80000000: {
                return "Unspecified";
            }
            case 1: {
                return "Left";
            }
            case 2: {
                return "Right";
            }
            case 3: {
                return "Center";
            }
            case 4: {
                return "Justify";
            }
            case 5: {
                return "Start";
            }
            case 6: {
                return "End";
            }
            default: {
                return "Invalid";
            }
        }
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof k && this.a == ((k)object0).a;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        return k.b(this.a);
    }
}

