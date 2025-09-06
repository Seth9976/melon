package f1;

public final class k {
    public final int a;

    public k(int v) {
        this.a = v;
    }

    public static String a(int v) {
        switch(v) {
            case -1: {
                return "Unspecified";
            }
            case 0: {
                return "None";
            }
            case 1: {
                return "Characters";
            }
            case 2: {
                return "Words";
            }
            case 3: {
                return "Sentences";
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
        return k.a(this.a);
    }
}

