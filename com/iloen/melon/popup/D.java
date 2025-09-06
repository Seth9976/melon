package com.iloen.melon.popup;

import com.iloen.melon.utils.log.LogU;
import ie.H;
import k8.Y;
import we.o;

public final class d implements o {
    public final int a;
    public final Object b;

    public d(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        H h0 = H.a;
        Object object3 = this.b;
        if(this.a != 0) {
            ((Integer)object0).intValue();
            ((Integer)object1).intValue();
            ((Integer)object2).intValue();
            if(((o)object3) != null) {
                ((o)object3).invoke(((Integer)object0), ((Integer)object1), ((Integer)object2));
            }
            return h0;
        }
        ((Integer)object2).intValue();
        LogU.Companion.d("ComposeBottomSheet", Y.h(((int)(((Integer)object0))), ((int)(((Integer)object1))), "onItemClick() oneDepthIndex:", ", twoDepthIndex:"));
        o o0 = CommonFilterPopup.h;
        if(o0 != null) {
            o0.invoke(((Integer)object0), ((Integer)object1), ((Integer)object2));
        }
        ((CommonFilterPopup)object3).dismiss();
        return h0;
    }
}

