package cd;

import bd.s;
import com.melon.ui.K4;
import java.util.List;
import kotlin.jvm.internal.q;
import va.e;

public final class j1 implements K4 {
    public final s a;
    public final Object b;
    public final Object c;

    public j1(s s0, List list0, List list1) {
        this.a = s0;
        this.b = list0;
        this.c = list1;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof j1 && q.b(this.a, ((j1)object0).a) && this.b.equals(((j1)object0).b) && this.c.equals(((j1)object0).c);
    }

    @Override
    public final int hashCode() {
        return this.a == null ? this.c.hashCode() + this.b.hashCode() * 0x1F : this.c.hashCode() + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("MagazineSlotUiState(headerUiState=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", tabList=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", magazineList=");
        return e.d(stringBuilder0, this.c, ")");
    }
}

