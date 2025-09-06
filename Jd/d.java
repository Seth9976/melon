package jd;

public final class d extends y2 {
    public final String a;
    public final String b;

    public d(String s, String s1) {
        this.a = s;
        this.b = s1;
    }

    @Override  // jd.y2
    public final String a() {
        return "date";
    }

    @Override  // jd.y2
    public final String b() {
        return this.b;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof d && this.a.equals(((d)object0).a) && this.b.equals(((d)object0).b);
    }

    @Override
    public final int hashCode() {
        return (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F + 3076014;
    }

    @Override
    public final String toString() {
        return "DateMessage(date=" + this.a + ", uniqueKey=" + this.b + ", messageType=date)";
    }
}

