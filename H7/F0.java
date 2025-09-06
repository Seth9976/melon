package h7;

import U4.x;

public final class f0 extends I0 {
    public final H0 a;
    public final String b;
    public final String c;
    public final long d;

    public f0(g0 g00, String s, String s1, long v) {
        this.a = g00;
        this.b = s;
        this.c = s1;
        this.d = v;
    }

    // 去混淆评级： 中等(50)
    @Override
    public final boolean equals(Object object0) {
        return object0 == this ? true : object0 instanceof I0 && this.a.equals(((f0)(((I0)object0))).a) && this.b.equals(((f0)(((I0)object0))).b) && this.c.equals(((f0)(((I0)object0))).c) && this.d == ((f0)(((I0)object0))).d;
    }

    @Override
    public final int hashCode() {
        return (((this.a.hashCode() ^ 1000003) * 1000003 ^ this.b.hashCode()) * 1000003 ^ this.c.hashCode()) * 1000003 ^ ((int)(this.d >>> 0x20 ^ this.d));
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("RolloutAssignment{rolloutVariant=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", parameterKey=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", parameterValue=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", templateVersion=");
        return x.h(this.d, "}", stringBuilder0);
    }
}

