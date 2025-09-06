package xd;

import java.util.ArrayList;

public final class k extends l {
    public final ArrayList a;

    public k(ArrayList arrayList0) {
        this.a = arrayList0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof k && this.a.equals(((k)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Success(dataList=" + this.a + ")";
    }
}

