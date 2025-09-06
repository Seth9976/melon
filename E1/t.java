package e1;

public final class t {
    public final int a;

    public t(int v) {
        this.a = v;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof t && this.a == ((t)object0).a;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        int v = this.a;
        if(v == 0) {
            return "None";
        }
        switch(v) {
            case 1: {
                return "Weight";
            }
            case 2: {
                return "Style";
            }
            case 0xFFFF: {
                return "All";
            }
            default: {
                return "Invalid";
            }
        }
    }
}

