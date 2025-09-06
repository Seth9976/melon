package gd;

import java.util.ArrayList;

public final class g8 extends i8 {
    public final ArrayList a;

    public g8(ArrayList arrayList0) {
        this.a = arrayList0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof g8 && this.a.equals(((g8)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "TodayRecommendTagItem(list=" + this.a + ")";
    }
}

