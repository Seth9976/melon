package wd;

import java.util.ArrayList;

public final class g extends h {
    public final ArrayList a;

    public g(ArrayList arrayList0) {
        this.a = arrayList0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof g && this.a.equals(((g)object0).a);
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

