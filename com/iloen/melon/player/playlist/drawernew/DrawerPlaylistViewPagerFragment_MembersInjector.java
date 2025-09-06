package com.iloen.melon.player.playlist.drawernew;

import Xd.a;
import ge.b;
import kc.s2;

public final class DrawerPlaylistViewPagerFragment_MembersInjector implements a {
    public final b a;

    public DrawerPlaylistViewPagerFragment_MembersInjector(b b0) {
        this.a = b0;
    }

    public static a create(b b0) {
        return new DrawerPlaylistViewPagerFragment_MembersInjector(b0);
    }

    public void injectMembers(DrawerPlaylistViewPagerFragment drawerPlaylistViewPagerFragment0) {
        DrawerPlaylistViewPagerFragment_MembersInjector.injectPlaylistManager(drawerPlaylistViewPagerFragment0, ((s2)this.a.get()));
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((DrawerPlaylistViewPagerFragment)object0));
    }

    public static void injectPlaylistManager(DrawerPlaylistViewPagerFragment drawerPlaylistViewPagerFragment0, s2 s20) {
        drawerPlaylistViewPagerFragment0.playlistManager = s20;
    }
}

