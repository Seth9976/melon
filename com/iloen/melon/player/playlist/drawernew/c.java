package com.iloen.melon.player.playlist.drawernew;

import androidx.fragment.app.I;
import ie.H;
import we.a;

public final class c implements a {
    public final int a;
    public final I b;

    public c(I i0, int v) {
        this.a = v;
        this.b = i0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        H h0 = H.a;
        I i0 = this.b;
        if(this.a != 0) {
            ((DrawerFragmentViewModel)((DrawerFragment)i0).getViewModel()).updateUserEvent(OnToggleViewMode.INSTANCE);
            return h0;
        }
        ((DrawerBtmSheetFragment)i0).dismiss();
        return h0;
    }
}

