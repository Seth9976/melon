package com.iloen.melon.player.playlist.drawernew;

import Bc.h;
import Xd.a;
import ge.b;

public final class DrawerBtmSheetFragment_MembersInjector implements a {
    public final b a;

    public DrawerBtmSheetFragment_MembersInjector(b b0) {
        this.a = b0;
    }

    public static a create(b b0) {
        return new DrawerBtmSheetFragment_MembersInjector(b0);
    }

    public void injectMembers(DrawerBtmSheetFragment drawerBtmSheetFragment0) {
        DrawerBtmSheetFragment_MembersInjector.injectPlayerUiHelper(drawerBtmSheetFragment0, ((h)this.a.get()));
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((DrawerBtmSheetFragment)object0));
    }

    public static void injectPlayerUiHelper(DrawerBtmSheetFragment drawerBtmSheetFragment0, h h0) {
        drawerBtmSheetFragment0.playerUiHelper = h0;
    }
}

