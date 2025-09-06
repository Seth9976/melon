package u5;

import e1.m;

public final class a extends m {
    public final int e;

    public a(int v) {
        this.e = v;
        if(v <= 0) {
            throw new IllegalArgumentException("px must be > 0.");
        }
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof a && this.e == ((a)object0).e;
    }

    @Override
    public final int hashCode() {
        return this.e;
    }

    @Override
    public final String toString() {
        return String.valueOf(this.e);
    }
}

