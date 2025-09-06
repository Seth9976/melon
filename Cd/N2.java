package cd;

import A7.d;
import bd.s;
import com.melon.ui.K4;
import dd.z;
import java.util.List;
import kotlin.jvm.internal.q;

public final class n2 implements K4 {
    public final s a;
    public final List b;
    public final Object c;
    public final z d;

    public n2(s s0, List list0, List list1, z z0) {
        q.g(list0, "tagList");
        super();
        this.a = s0;
        this.b = list0;
        this.c = list1;
        this.d = z0;
    }

    // 去混淆评级： 中等(50)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof n2 && q.b(this.a, ((n2)object0).a) && q.b(this.b, ((n2)object0).b) && this.c.equals(((n2)object0).c) && this.d.equals(((n2)object0).d);
    }

    @Override
    public final int hashCode() {
        return this.a == null ? this.d.hashCode() + (this.c.hashCode() + d.d(0, 0x1F, this.b)) * 0x1F : this.d.hashCode() + (this.c.hashCode() + d.d(this.a.hashCode() * 0x1F, 0x1F, this.b)) * 0x1F;
    }

    @Override
    public final String toString() {
        return "TagSlotUiState(headerUiState=" + this.a + ", tagList=" + this.b + ", items=" + this.c + ", tagUserEvent=" + this.d + ")";
    }
}

