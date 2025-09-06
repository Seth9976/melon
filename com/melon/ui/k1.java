package com.melon.ui;

import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import kotlin.jvm.internal.q;

public final class K1 implements k2 {
    public final int a;
    public final MelonBottomSheetItem b;

    public K1(int v, MelonBottomSheetItem melonBottomSheetItem0) {
        q.g(melonBottomSheetItem0, "item");
        super();
        this.a = v;
        this.b = melonBottomSheetItem0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof K1)) {
            return false;
        }
        return this.a == ((K1)object0).a ? q.b(this.b, ((K1)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a * 0x1F;
    }

    @Override
    public final String toString() {
        return "ClickListItem(index=" + this.a + ", item=" + this.b + ")";
    }
}

