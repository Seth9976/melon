package Y6;

public final class j {
    public final s a;
    public final boolean b;

    public j(s s0, boolean z) {
        this.a = s0;
        this.b = z;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof j && ((j)object0).a.equals(this.a) && ((j)object0).b == this.b;
    }

    @Override
    public final int hashCode() {
        return (this.a.hashCode() ^ 1000003) * 1000003 ^ Boolean.valueOf(this.b).hashCode();
    }
}

