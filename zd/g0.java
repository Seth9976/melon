package zd;

import Ad.C;
import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import kotlin.jvm.internal.q;

public final class g0 extends C {
    public final int a;
    public final MelonBottomSheetItem b;
    public final Q c;

    public g0(int v, MelonBottomSheetItem melonBottomSheetItem0, Q q0) {
        q.g(melonBottomSheetItem0, "item");
        q.g(q0, "popupType");
        super();
        this.a = v;
        this.b = melonBottomSheetItem0;
        this.c = q0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof g0)) {
            return false;
        }
        if(this.a != ((g0)object0).a) {
            return false;
        }
        return q.b(this.b, ((g0)object0).b) ? q.b(this.c, ((g0)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() + this.a * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        return "ClickListItem(index=" + this.a + ", item=" + this.b + ", popupType=" + this.c + ")";
    }
}

