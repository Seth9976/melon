package Ac;

import java.util.List;

public final class y0 extends z0 {
    public final Object a;

    public y0(List list0) {
        this.a = list0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof y0 && this.a.equals(((y0)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Success(list=" + this.a + ")";
    }
}

