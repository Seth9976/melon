package ed;

import java.util.ArrayList;

public final class h0 extends l0 {
    public final ArrayList a;

    public h0(ArrayList arrayList0) {
        this.a = arrayList0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof h0 && this.a.equals(((h0)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "GenreAndTheme(list=" + this.a + ")";
    }
}

