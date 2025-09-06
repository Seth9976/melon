package ad;

public final class t extends w {
    public final String a;
    public final O b;

    public t(String s, O o0) {
        this.a = s;
        this.b = o0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof t && this.a.equals(((t)object0).a) && this.b.equals(((t)object0).b);
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "CustomLogoItem(logoUrl=" + this.a + ", userEvent=" + this.b + ")";
    }
}

