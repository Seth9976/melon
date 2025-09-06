package l1;

public final class u {
    public final int a;

    public u(int v) {
        this.a = v;
    }

    public static String a(int v) {
        switch(v) {
            case 1: {
                return "Clip";
            }
            case 2: {
                return "Ellipsis";
            }
            case 3: {
                return "Visible";
            }
            case 4: {
                return "StartEllipsis";
            }
            case 5: {
                return "MiddleEllipsis";
            }
            default: {
                return "Invalid";
            }
        }
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof u && this.a == ((u)object0).a;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        return u.a(this.a);
    }
}

