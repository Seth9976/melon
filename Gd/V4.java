package gd;

import Ac.m4;
import java.util.ArrayList;

public final class v4 extends m4 {
    public final ArrayList a;

    public v4(ArrayList arrayList0) {
        this.a = arrayList0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof v4 && this.a.equals(((v4)object0).a);
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

