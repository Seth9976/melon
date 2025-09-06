package com.iloen.melon.fragments;

import com.melon.ui.k2;
import we.k;
import xd.h;

public final class t implements k {
    public final int a;
    public final Object b;

    public t(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                return com.iloen.melon.fragments.MelonBaseFragment.37.lambda$run$1(((OnBottomSheetItemClickListener)this.b), ((k2)object0));
            }
            case 1: {
                return ((com.iloen.melon.fragments.MelonBaseFragment.40)this.b).lambda$run$0(((String)object0));
            }
            default: {
                return ((MelonBaseFragment)this.b).lambda$showMultiArtistPopup$7(((h)object0));
            }
        }
    }
}

