package Ac;

import H0.b;
import java.util.ArrayList;

public final class y1 implements B1 {
    public final String a;
    public final ArrayList b;
    public final ArrayList c;

    public y1(String s, ArrayList arrayList0, ArrayList arrayList1) {
        this.a = s;
        this.b = arrayList0;
        this.c = arrayList1;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof y1 && this.a.equals(((y1)object0).a) && this.b.equals(((y1)object0).b) && this.c.equals(((y1)object0).c);
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + b.a(this.b, this.a.hashCode() * 0x1F, 0x1F);
    }

    @Override
    public final String toString() {
        return "BottomPopupUiEvent(title=" + this.a + ", itemTitleList=" + this.b + ", dataList=" + this.c + ")";
    }
}

