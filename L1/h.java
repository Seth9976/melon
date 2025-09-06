package l1;

public final class h {
    public final int a;

    public h(int v) {
        this.a = v;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof h && this.a == ((h)object0).a;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        int v = this.a;
        if(v == 1) {
            return "LineHeightStyle.Trim.FirstLineTop";
        }
        switch(v) {
            case 0: {
                return "LineHeightStyle.Trim.None";
            }
            case 16: {
                return "LineHeightStyle.Trim.LastLineBottom";
            }
            case 17: {
                return "LineHeightStyle.Trim.Both";
            }
            default: {
                return "Invalid";
            }
        }
    }
}

