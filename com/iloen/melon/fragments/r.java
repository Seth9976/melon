package com.iloen.melon.fragments;

import com.melon.ui.k2;
import we.k;
import xd.h;

public final class r implements k {
    public final int a;
    public final Object b;
    public final Object c;

    public r(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                return ((com.iloen.melon.fragments.MelonBaseFragment.23)this.b).lambda$run$0(((String)this.c), ((Float)object0));
            }
            case 1: {
                return ((com.iloen.melon.fragments.MelonBaseFragment.32)this.b).lambda$run$1(this.c, ((k2)object0));
            }
            default: {
                return ((MelonBaseFragment)this.b).lambda$showMultiCreatorPopup$8(((String)this.c), ((h)object0));
            }
        }
    }
}

