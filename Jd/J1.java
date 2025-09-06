package jd;

import Ac.m4;
import java.util.List;

public final class j1 extends m4 {
    public final Object a;
    public final int b;

    public j1(List list0, int v) {
        this.a = list0;
        this.b = v;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof j1 && this.a.equals(((j1)object0).a) && this.b == ((j1)object0).b;
    }

    @Override
    public final int hashCode() {
        return this.b + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "Success(itemList=" + this.a + ", clearCount=" + this.b + ")";
    }
}

