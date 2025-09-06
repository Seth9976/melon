package zc;

import A7.d;
import java.util.List;
import kotlin.jvm.internal.q;
import r1.f;

public final class k {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public final int h;
    public final int i;
    public final List j;

    public k() {
        List list0 = e.k.A(new Integer[]{0x7F06017C, 0x7F06047B, 0x7F060458, 0x7F060442, 0x7F060444});  // color:green500s_support_high_contrast
        super();
        this.a = 235.0f;
        this.b = 282.0f;
        this.c = 18.0f;
        this.d = 52.0f;
        this.e = 26.0f;
        this.f = 24.0f;
        this.g = 24.0f;
        this.h = 0x7F06015D;  // color:gray500s_support_high_contrast
        this.i = 0x7F06017C;  // color:green500s_support_high_contrast
        this.j = list0;
    }

    // 去混淆评级： 中等(90)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof k && f.a(this.a, ((k)object0).a) && f.a(this.b, ((k)object0).b) && f.a(this.c, ((k)object0).c) && f.a(this.d, ((k)object0).d) && f.a(this.e, ((k)object0).e) && f.a(this.f, ((k)object0).f) && f.a(this.g, ((k)object0).g) && this.h == ((k)object0).h && this.i == ((k)object0).i && q.b(this.j, ((k)object0).j);
    }

    @Override
    public final int hashCode() {
        return this.j.hashCode() + d.b(this.i, d.b(this.h, d.a(this.g, d.a(this.f, d.a(this.e, d.a(this.d, d.a(this.c, d.a(this.b, Float.hashCode(this.a) * 0x1F, 0x1F), 0x1F), 0x1F), 0x1F), 0x1F), 0x1F), 0x1F), 0x1F);
    }

    @Override
    public final String toString() {
        String s = f.b(this.a);
        String s1 = f.b(this.b);
        String s2 = f.b(this.c);
        String s3 = f.b(this.d);
        String s4 = f.b(this.e);
        String s5 = f.b(this.f);
        String s6 = f.b(this.g);
        StringBuilder stringBuilder0 = d.o("FiveMinuteLineGraphStyle(canvasHeight=", s, ", graphCanvasHeight=", s1, ", graphTopMargin=");
        d.u(stringBuilder0, s2, ", horizontalPadding=", s3, ", leftPadding=");
        d.u(stringBuilder0, s4, ", topMargin=", s5, ", baseLineBottomMargin=");
        d.t(stringBuilder0, s6, ", defaultColor=", this.h, ", lastBottomTextColor=");
        stringBuilder0.append(this.i);
        stringBuilder0.append(", lineColors=");
        stringBuilder0.append(this.j);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

