package gd;

import java.util.List;

public final class b8 extends i8 {
    public final Object a;

    public b8(List list0) {
        this.a = list0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof b8 && this.a.equals(((b8)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "LikeTagListItem(tagList=" + this.a + ")";
    }
}

