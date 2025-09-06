package com.iloen.melon.player.playlist.search;

import Md.h;
import Pc.d;
import Xd.a;
import ge.b;
import kc.s2;
import ob.z;

public final class PlaylistSearchFragment_MembersInjector implements a {
    public final b a;
    public final b b;
    public final b c;
    public final b d;
    public final b e;

    public PlaylistSearchFragment_MembersInjector(b b0, b b1, b b2, b b3, b b4) {
        this.a = b0;
        this.b = b1;
        this.c = b2;
        this.d = b3;
        this.e = b4;
    }

    public static a create(b b0, b b1, b b2, b b3, b b4) {
        return new PlaylistSearchFragment_MembersInjector(b0, b1, b2, b3, b4);
    }

    public void injectMembers(PlaylistSearchFragment playlistSearchFragment0) {
        playlistSearchFragment0.downloadHelper = (h)this.a.get();
        PlaylistSearchFragment_MembersInjector.injectPlayerUseCase(playlistSearchFragment0, ((z)this.b.get()));
        PlaylistSearchFragment_MembersInjector.injectPlaylistManager(playlistSearchFragment0, ((s2)this.c.get()));
        PlaylistSearchFragment_MembersInjector.injectPlayerUiHelper(playlistSearchFragment0, ((Bc.h)this.d.get()));
        PlaylistSearchFragment_MembersInjector.injectStringProvider(playlistSearchFragment0, ((d)this.e.get()));
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((PlaylistSearchFragment)object0));
    }

    public static void injectPlayerUiHelper(PlaylistSearchFragment playlistSearchFragment0, Bc.h h0) {
        playlistSearchFragment0.playerUiHelper = h0;
    }

    public static void injectPlayerUseCase(PlaylistSearchFragment playlistSearchFragment0, z z0) {
        playlistSearchFragment0.playerUseCase = z0;
    }

    public static void injectPlaylistManager(PlaylistSearchFragment playlistSearchFragment0, s2 s20) {
        playlistSearchFragment0.playlistManager = s20;
    }

    public static void injectStringProvider(PlaylistSearchFragment playlistSearchFragment0, d d0) {
        playlistSearchFragment0.stringProvider = d0;
    }
}

