package Ac;

import H0.b;
import com.melon.ui.I4;
import java.util.ArrayList;

public final class x3 implements I4 {
    public final String a;
    public final ArrayList b;
    public final ArrayList c;
    public final int d;

    public x3(String s, ArrayList arrayList0, ArrayList arrayList1, int v) {
        this.a = s;
        this.b = arrayList0;
        this.c = arrayList1;
        this.d = v;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof x3 && this.a.equals(((x3)object0).a) && this.b.equals(((x3)object0).b) && this.c.equals(((x3)object0).c) && this.d == ((x3)object0).d;
    }

    @Override
    public final int hashCode() {
        return this.d + b.a(this.c, b.a(this.b, this.a.hashCode() * 0x1F, 0x1F), 0x1F);
    }

    @Override
    public final String toString() {
        return "SortBottomPopupUiEvent(title=" + this.a + ", itemTitleList=" + this.b + ", dataList=" + this.c + ", selectedPosition=" + this.d + ")";
    }
}

