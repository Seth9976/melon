package com.iloen.melon.player.playlist.drawernew;

import Md.h;
import Pc.d;
import Xd.a;
import ge.b;

public final class DrawerSongFragment_MembersInjector implements a {
    public final b a;
    public final b b;
    public final b c;

    public DrawerSongFragment_MembersInjector(b b0, b b1, b b2) {
        this.a = b0;
        this.b = b1;
        this.c = b2;
    }

    public static a create(b b0, b b1, b b2) {
        return new DrawerSongFragment_MembersInjector(b0, b1, b2);
    }

    public void injectMembers(DrawerSongFragment drawerSongFragment0) {
        drawerSongFragment0.downloadHelper = (h)this.a.get();
        DrawerSongFragment_MembersInjector.injectPlayerUiHelper(drawerSongFragment0, ((Bc.h)this.b.get()));
        DrawerSongFragment_MembersInjector.injectStringProvider(drawerSongFragment0, ((d)this.c.get()));
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((DrawerSongFragment)object0));
    }

    public static void injectPlayerUiHelper(DrawerSongFragment drawerSongFragment0, Bc.h h0) {
        drawerSongFragment0.playerUiHelper = h0;
    }

    public static void injectStringProvider(DrawerSongFragment drawerSongFragment0, d d0) {
        drawerSongFragment0.stringProvider = d0;
    }
}

