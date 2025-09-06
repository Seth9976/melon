package kc;

import com.iloen.melon.net.v4x.common.BgVideoBase;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.q;

public final class f3 {
    public final BgVideoBase a;
    public final List b;

    public f3(BgVideoBase bgVideoBase0, ArrayList arrayList0) {
        this.a = bgVideoBase0;
        this.b = arrayList0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof f3)) {
            return false;
        }
        return q.b(this.a, ((f3)object0).a) ? q.b(this.b, ((f3)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        List list0 = this.b;
        if(list0 != null) {
            v = list0.hashCode();
        }
        return v1 * 0x1F + v;
    }

    @Override
    public final String toString() {
        return "SpecialContentsInfo(bgVideo=" + this.a + ", bgImgs=" + this.b + ")";
    }
}

