package com.iloen.melon.popup;

import O.j;
import O.w;
import androidx.compose.runtime.b0;
import com.kakao.tiara.data.ContentList;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.q;
import m0.b;
import q8.a;
import q8.c;
import we.k;

public final class l implements k {
    public final int a;
    public final Object b;
    public final Object c;

    public l(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    public l(List list0, k k0) {
        this.a = 1;
        super();
        this.c = list0;
        this.b = k0;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        Object object1 = this.c;
        Object object2 = this.b;
        switch(this.a) {
            case 0: {
                ((Integer)object0).getClass();
                ((b0)object1).setValue(((Integer)object0));
                if(((k)object2) != null) {
                    ((k)object2).invoke(((Number)((b0)object1).getValue()).intValue());
                }
                return h0;
            }
            case 1: {
                q.g(((w)object0), "$this$LazyColumn");
                ((j)(((w)object0))).u(((List)object1).size(), null, new com.iloen.melon.popup.DjSelectionPopupKt.DjSelectionPopupBase.lambda.4.lambda.3.lambda.2.lambda.1..inlined.itemsIndexed.default.2(((List)object1)), new b(0xBEF78951, new com.iloen.melon.popup.DjSelectionPopupKt.DjSelectionPopupBase.lambda.4.lambda.3.lambda.2.lambda.1..inlined.itemsIndexed.default.3(((List)object1), ((k)object2)), true));
                return h0;
            }
            case 2: {
                q.g(((c)object0), "$this$customProps");
                ((q8.j)object2).getClass();
                ((q8.j)object2).h = (ContentList)object1;
                ((c)object0).a.put("menuid", "1000001797");
                return h0;
            }
            default: {
                q.g(((a)object0), "$this$click");
                ((a)object0).a = "";
                ((a)object0).g = (String)object2;
                ((a)object0).c = (String)object1;
                ((a)object0).i = "melon_admin";
                return h0;
            }
        }
    }
}

