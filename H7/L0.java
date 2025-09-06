package h7;

public final class l0 {
    public final m0 a;
    public final o0 b;
    public final n0 c;

    public l0(m0 m00, o0 o00, n0 n00) {
        this.a = m00;
        this.b = o00;
        this.c = n00;
    }

    // 去混淆评级： 中等(50)
    @Override
    public final boolean equals(Object object0) {
        return object0 == this ? true : object0 instanceof l0 && this.a.equals(((l0)object0).a) && this.b.equals(((l0)object0).b) && this.c.equals(((l0)object0).c);
    }

    @Override
    public final int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003 ^ this.b.hashCode()) * 1000003 ^ this.c.hashCode();
    }

    @Override
    public final String toString() {
        return "StaticSessionData{appData=" + this.a + ", osData=" + this.b + ", deviceData=" + this.c + "}";
    }
}

