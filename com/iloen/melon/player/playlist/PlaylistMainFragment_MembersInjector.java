package com.iloen.melon.player.playlist;

import Cc.x2;
import Md.h;
import Xd.a;
import ge.b;

public final class PlaylistMainFragment_MembersInjector implements a {
    public final b a;
    public final b b;
    public final b c;

    public PlaylistMainFragment_MembersInjector(b b0, b b1, b b2) {
        this.a = b0;
        this.b = b1;
        this.c = b2;
    }

    public static a create(b b0, b b1, b b2) {
        return new PlaylistMainFragment_MembersInjector(b0, b1, b2);
    }

    public void injectMembers(PlaylistMainFragment playlistMainFragment0) {
        playlistMainFragment0.downloadHelper = (h)this.a.get();
        PlaylistMainFragment_MembersInjector.injectPlayerUiHelper(playlistMainFragment0, ((Bc.h)this.b.get()));
        PlaylistMainFragment_MembersInjector.injectPlayBgColorExtractor(playlistMainFragment0, ((x2)this.c.get()));
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((PlaylistMainFragment)object0));
    }

    public static void injectPlayBgColorExtractor(PlaylistMainFragment playlistMainFragment0, x2 x20) {
        playlistMainFragment0.playBgColorExtractor = x20;
    }

    public static void injectPlayerUiHelper(PlaylistMainFragment playlistMainFragment0, Bc.h h0) {
        playlistMainFragment0.playerUiHelper = h0;
    }
}

