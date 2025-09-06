package zc;

import A7.d;
import U4.x;
import kotlin.jvm.internal.q;
import r1.f;

public final class a {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final int f;
    public final String g;

    public a() {
        q.g("", "title");
        super();
        this.a = 134.0f;
        this.b = 26.0f;
        this.c = 26.0f;
        this.d = 22.0f;
        this.e = 18.0f;
        this.f = 0x7F06013E;  // color:gray000s
        this.g = "";
    }

    // 去混淆评级： 中等(70)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof a && f.a(this.a, ((a)object0).a) && f.a(this.b, ((a)object0).b) && f.a(this.c, ((a)object0).c) && f.a(this.d, ((a)object0).d) && f.a(this.e, ((a)object0).e) && this.f == ((a)object0).f && q.b(this.g, ((a)object0).g);
    }

    @Override
    public final int hashCode() {
        return this.g.hashCode() + d.b(this.f, d.a(this.e, d.a(this.d, d.a(this.c, d.a(this.b, Float.hashCode(this.a) * 0x1F, 0x1F), 0x1F), 0x1F), 0x1F), 0x1F);
    }

    @Override
    public final String toString() {
        String s = f.b(this.a);
        String s1 = f.b(this.b);
        String s2 = f.b(this.c);
        String s3 = f.b(this.d);
        String s4 = f.b(this.e);
        StringBuilder stringBuilder0 = d.o("BarGraphStyle(graphHeight=", s, ", xLeftMargin=", s1, ", xRightMargin=");
        d.u(stringBuilder0, s2, ", barWidth=", s3, ", barMargin=");
        d.t(stringBuilder0, s4, ", bgColor=", this.f, ", title=");
        return x.m(stringBuilder0, this.g, ")");
    }
}

