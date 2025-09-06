package com.iloen.melon.player.playlist.drawernew;

import Md.h;
import Xd.a;
import ge.b;

public final class DrawerFragment_MembersInjector implements a {
    public final b a;
    public final b b;

    public DrawerFragment_MembersInjector(b b0, b b1) {
        this.a = b0;
        this.b = b1;
    }

    public static a create(b b0, b b1) {
        return new DrawerFragment_MembersInjector(b0, b1);
    }

    public void injectMembers(DrawerFragment drawerFragment0) {
        drawerFragment0.downloadHelper = (h)this.a.get();
        DrawerFragment_MembersInjector.injectPlayerUiHelper(drawerFragment0, ((Bc.h)this.b.get()));
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((DrawerFragment)object0));
    }

    public static void injectPlayerUiHelper(DrawerFragment drawerFragment0, Bc.h h0) {
        drawerFragment0.playerUiHelper = h0;
    }
}

