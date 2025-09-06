package com.iloen.melon.player.playlist.drawernew;

import com.iloen.melon.player.playlist.drawernew.model.DrawerAlyac;
import com.iloen.melon.player.playlist.drawernew.model.DrawerPlytWrapper;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;

public final class b implements k {
    public final int a;
    public final DrawerBtmSheetFragment b;

    public b(DrawerBtmSheetFragment drawerBtmSheetFragment0, int v) {
        this.a = v;
        this.b = drawerBtmSheetFragment0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        DrawerBtmSheetFragment drawerBtmSheetFragment0 = this.b;
        switch(this.a) {
            case 0: {
                q.g(((DrawerAlyac)object0), "it");
                ((DrawerFragmentViewModel)drawerBtmSheetFragment0.getViewModel()).updateUserEvent(new OnClickAlyac(((DrawerAlyac)object0).getKey()));
                return h0;
            }
            case 1: {
                q.g(((DrawerPlytWrapper)object0), "it");
                ((DrawerFragmentViewModel)drawerBtmSheetFragment0.getViewModel()).updateUserEvent(new OnClickPlay(((DrawerPlytWrapper)object0).getDrawerPlaylistInfo()));
                return h0;
            }
            default: {
                q.g(((DrawerPlytWrapper)object0), "it");
                ((DrawerFragmentViewModel)drawerBtmSheetFragment0.getViewModel()).updateUserEvent(new OnClickItem(((DrawerPlytWrapper)object0).getDrawerPlaylistInfo()));
                return h0;
            }
        }
    }
}

