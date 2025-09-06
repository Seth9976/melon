package w7;

import java.util.ArrayList;

public final class a {
    public final String a;
    public final ArrayList b;

    public a(String s, ArrayList arrayList0) {
        if(s == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.a = s;
        this.b = arrayList0;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return object0 == this || object0 instanceof a && this.a.equals(((a)object0).a) && this.b.equals(((a)object0).b);
    }

    @Override
    public final int hashCode() {
        return (this.a.hashCode() ^ 1000003) * 1000003 ^ this.b.hashCode();
    }

    @Override
    public final String toString() {
        return "HeartBeatResult{userAgent=" + this.a + ", usedDates=" + this.b + "}";
    }
}

