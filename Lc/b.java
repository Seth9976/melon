package lc;

import java.util.ArrayList;

public final class b {
    public final ArrayList a;
    public final boolean b;

    public b(ArrayList arrayList0, boolean z) {
        this.a = arrayList0;
        this.b = z;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof b && this.a.equals(((b)object0).a) && this.b == ((b)object0).b;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.b) + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "DuplicatedListData(list=" + this.a + ", wasRemovedCurrent=" + this.b + ")";
    }
}

