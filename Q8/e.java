package q8;

import A7.d;
import kotlin.jvm.internal.q;

public final class e {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    public e(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
        this.f = s5;
        this.g = s6;
        this.h = s7;
    }

    // 去混淆评级： 中等(90)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof e && q.b(this.a, ((e)object0).a) && q.b(this.b, ((e)object0).b) && q.b(this.c, ((e)object0).c) && q.b(this.d, ((e)object0).d) && q.b(this.e, ((e)object0).e) && q.b(this.f, ((e)object0).f) && q.b(this.g, ((e)object0).g) && q.b(this.h, ((e)object0).h);
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        int v4 = this.d == null ? 0 : this.d.hashCode();
        int v5 = this.e == null ? 0 : this.e.hashCode();
        int v6 = this.f == null ? 0 : this.f.hashCode();
        int v7 = this.g == null ? 0 : this.g.hashCode();
        String s = this.h;
        if(s != null) {
            v = s.hashCode();
        }
        return (((((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0xE1781 + v5) * 0x1F + v6) * 961 + v7) * 0x1F + v) * 0x745F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("Meta(id=", this.a, ", type=", this.b, ", name=");
        d.u(stringBuilder0, this.c, ", category=", this.d, ", categoryId=null, series=null, seriesId=null, provider=");
        d.u(stringBuilder0, this.e, ", providerId=", this.f, ", providerType=null, tags=");
        return d.n(stringBuilder0, this.g, ", author=", this.h, ", authorId=null, image=null, plink=null)");
    }
}

