package gd;

import Ac.m4;
import java.util.ArrayList;

public final class h2 extends m4 {
    public final ArrayList a;

    public h2(ArrayList arrayList0) {
        this.a = arrayList0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof h2 && this.a.equals(((h2)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Success(itemList=" + this.a + ")";
    }
}

