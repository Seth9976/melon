package i.n.i.b.a.s.e;

public final class x4 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    public x4(String s, String s1, String s2, String s3, String s4) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof x4 ? L7.p(this.a, ((x4)object0).a) && L7.p(this.b, ((x4)object0).b) && L7.p(this.c, ((x4)object0).c) && L7.p(this.d, ((x4)object0).d) && L7.p(this.e, ((x4)object0).e) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        int v4 = this.d == null ? 0 : this.d.hashCode();
        String s = this.e;
        if(s != null) {
            v = s.hashCode();
        }
        return ((((v1 + 0x20F) * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v;
    }
}

