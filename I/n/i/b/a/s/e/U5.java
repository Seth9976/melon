package i.n.i.b.a.s.e;

public final class u5 {
    public final int a;
    public final boolean b;

    public u5(int v, boolean z) {
        this.a = v;
        this.b = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 != null) {
                Class class0 = object0.getClass();
                return u5.class == class0 && this.a == ((u5)object0).a && this.b == ((u5)object0).b;
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        return this.a * 0x1F + this.b;
    }
}

