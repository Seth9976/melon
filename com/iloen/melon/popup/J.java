package com.iloen.melon.popup;

import O.w;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.q;
import m0.b;
import we.k;

public final class j implements k {
    public final List a;
    public final int b;
    public final k c;

    public j(List list0, int v, k k0) {
        this.a = list0;
        this.b = v;
        this.c = k0;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((w)object0), "$this$LazyRow");
        com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterAlyac.lambda.63.lambda.62..inlined.itemsIndexed.default.2 commonFilterPopupKt$CommonFilterAlyac$lambda$63$lambda$62$$inlined$itemsIndexed$default$20 = new com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterAlyac.lambda.63.lambda.62..inlined.itemsIndexed.default.2(this.a);
        b b0 = new b(0xBEF78951, new com.iloen.melon.popup.CommonFilterPopupKt.CommonFilterAlyac.lambda.63.lambda.62..inlined.itemsIndexed.default.3(this.a, this.b, this.c), true);
        ((O.j)(((w)object0))).u(this.a.size(), null, commonFilterPopupKt$CommonFilterAlyac$lambda$63$lambda$62$$inlined$itemsIndexed$default$20, b0);
        return H.a;
    }
}

