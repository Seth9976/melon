package ad;

import java.util.ArrayList;
import java.util.List;

public final class q {
    public final List a;
    public final ArrayList b;

    public q(List list0, ArrayList arrayList0) {
        kotlin.jvm.internal.q.g(list0, "titleItemUiStateList");
        super();
        this.a = list0;
        this.b = arrayList0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof q && kotlin.jvm.internal.q.b(this.a, ((q)object0).a) && this.b.equals(((q)object0).b);
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "MusicTabResult(titleItemUiStateList=" + this.a + ", slotUiStateList=" + this.b + ")";
    }
}

