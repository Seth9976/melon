package x0;

import com.iloen.melon.utils.a;
import de.c;
import e1.b;

public final class d {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final long e;
    public final long f;
    public final long g;
    public final long h;

    static {
        b.l(0.0f, 0.0f, 0.0f, 0.0f, 0L);
    }

    public d(float f, float f1, float f2, float f3, long v, long v1, long v2, long v3) {
        this.a = f;
        this.b = f1;
        this.c = f2;
        this.d = f3;
        this.e = v;
        this.f = v1;
        this.g = v2;
        this.h = v3;
    }

    public final float a() {
        return this.d - this.b;
    }

    public final float b() {
        return this.c - this.a;
    }

    // 去混淆评级： 中等(50)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof d && Float.compare(this.a, ((d)object0).a) == 0 && Float.compare(this.b, ((d)object0).b) == 0 && Float.compare(this.c, ((d)object0).c) == 0 && Float.compare(this.d, ((d)object0).d) == 0 && c.q(this.e, ((d)object0).e) && c.q(this.f, ((d)object0).f) && c.q(this.g, ((d)object0).g) && c.q(this.h, ((d)object0).h);
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.h) + A7.d.c(A7.d.c(A7.d.c(A7.d.a(this.d, A7.d.a(this.c, A7.d.a(this.b, Float.hashCode(this.a) * 0x1F, 0x1F), 0x1F), 0x1F), 0x1F, this.e), 0x1F, this.f), 0x1F, this.g);
    }

    @Override
    public final String toString() {
        String s = df.d.N(this.a) + ", " + df.d.N(this.b) + ", " + df.d.N(this.c) + ", " + df.d.N(this.d);
        long v = this.e;
        long v1 = this.f;
        long v2 = this.g;
        long v3 = this.h;
        if(c.q(v, v1) && c.q(v1, v2) && c.q(v2, v3)) {
            if(Float.intBitsToFloat(((int)(v >> 0x20))) == Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)))) {
                StringBuilder stringBuilder0 = a.n("RoundRect(rect=", s, ", radius=");
                stringBuilder0.append(df.d.N(Float.intBitsToFloat(((int)(v >> 0x20)))));
                stringBuilder0.append(')');
                return stringBuilder0.toString();
            }
            StringBuilder stringBuilder1 = a.n("RoundRect(rect=", s, ", x=");
            stringBuilder1.append(df.d.N(Float.intBitsToFloat(((int)(v >> 0x20)))));
            stringBuilder1.append(", y=");
            stringBuilder1.append(df.d.N(Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL)))));
            stringBuilder1.append(')');
            return stringBuilder1.toString();
        }
        StringBuilder stringBuilder2 = a.n("RoundRect(rect=", s, ", topLeft=");
        stringBuilder2.append(c.x(v));
        stringBuilder2.append(", topRight=");
        stringBuilder2.append(c.x(v1));
        stringBuilder2.append(", bottomRight=");
        stringBuilder2.append(c.x(v2));
        stringBuilder2.append(", bottomLeft=");
        stringBuilder2.append(c.x(v3));
        stringBuilder2.append(')');
        return stringBuilder2.toString();
    }
}

