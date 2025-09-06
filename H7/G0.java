package h7;

import U4.x;

public final class g0 extends H0 {
    public final String a;
    public final String b;

    public g0(String s, String s1) {
        this.a = s;
        this.b = s1;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return object0 == this ? true : object0 instanceof H0 && this.a.equals(((g0)(((H0)object0))).a) && this.b.equals(((g0)(((H0)object0))).b);
    }

    @Override
    public final int hashCode() {
        return (this.a.hashCode() ^ 1000003) * 1000003 ^ this.b.hashCode();
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("RolloutVariant{rolloutId=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", variantId=");
        return x.m(stringBuilder0, this.b, "}");
    }
}

