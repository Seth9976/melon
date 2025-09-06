package A8;

public final class w implements G {
    public final int a;

    public w(int v) {
        this.a = v;
    }

    @Override  // A8.G
    public final String a() {
        return "AUTO_RETRY" + this.a;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof w ? this.a == ((w)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return this.a;
    }

    @Override
    public final String toString() {
        return "Auto(retryCount=" + this.a + ")";
    }
}

