package androidx.media3.exoplayer;

public final class h0 {
    public final int a;
    public final boolean b;
    public static final h0 c;

    static {
        h0.c = new h0(0, false);
    }

    public h0(int v, boolean z) {
        this.a = v;
        this.b = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return h0.class == class0 && this.a == ((h0)object0).a && this.b == ((h0)object0).b;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return (this.a << 1) + this.b;
    }
}

