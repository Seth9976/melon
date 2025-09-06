package com.iloen.melon.popup;

import O.j;
import O.w;
import com.iloen.melon.player.playlist.common.h;
import com.kakao.tiara.data.ContentList;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.q;
import m0.b;
import we.k;
import we.o;

public final class p implements k {
    public final int a;
    public final Object b;

    public p(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        Object object1 = this.b;
        switch(this.a) {
            case 0: {
                ((Integer)object0).intValue();
                if(((o)object1) != null) {
                    ((o)object1).invoke(((Integer)object0), -1, -1);
                }
                return h0;
            }
            case 1: {
                q.g(((DjSelectionPopupData)object0), "selectedDj");
                k k0 = DjSelectionPopup.c;
                if(k0 != null) {
                    k0.invoke(((DjSelectionPopupData)object0));
                }
                ((DjSelectionPopup)object1).dismiss();
                return h0;
            }
            case 2: {
                q.g(((w)object0), "$this$LazyColumn");
                ((j)(((w)object0))).u(((List)object1).size(), null, new com.iloen.melon.popup.DjSelectionPopupKt.DjSelectionPopupPreview.lambda.23.lambda.22.lambda.19.lambda.18..inlined.itemsIndexed.default.2(((List)object1)), new b(0xBEF78951, new com.iloen.melon.popup.DjSelectionPopupKt.DjSelectionPopupPreview.lambda.23.lambda.22.lambda.19.lambda.18..inlined.itemsIndexed.default.3(((List)object1)), true));
                return h0;
            }
            default: {
                q.g(((q8.j)object0), "$this$tiaraViewLogBuilder");
                ((q8.j)object0).c(new h(21));
                ((q8.j)object0).d(new l(2, ((q8.j)object0), ((ContentList)object1)));
                return h0;
            }
        }
    }
}

