package Jc;

import H0.b;
import java.util.ArrayList;
import we.a;

public final class a0 extends e0 {
    public final boolean a;
    public final ArrayList b;
    public final a c;

    public a0(ArrayList arrayList0, a a0, boolean z) {
        this.a = z;
        this.b = arrayList0;
        this.c = a0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof a0 && this.a == ((a0)object0).a && this.b.equals(((a0)object0).b) && this.c.equals(((a0)object0).c);
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + b.a(this.b, Boolean.hashCode(this.a) * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        return "StationUiState(isViewAll=" + this.a + ", stationList=" + this.b + ", clickViewAll=" + this.c + ")";
    }
}

