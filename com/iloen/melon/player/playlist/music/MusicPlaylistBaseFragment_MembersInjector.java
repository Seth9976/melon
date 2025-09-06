package com.iloen.melon.player.playlist.music;

import Md.h;
import Pc.d;
import Xd.a;
import ge.b;

public final class MusicPlaylistBaseFragment_MembersInjector implements a {
    public final b a;
    public final b b;
    public final b c;

    public MusicPlaylistBaseFragment_MembersInjector(b b0, b b1, b b2) {
        this.a = b0;
        this.b = b1;
        this.c = b2;
    }

    public static a create(b b0, b b1, b b2) {
        return new MusicPlaylistBaseFragment_MembersInjector(b0, b1, b2);
    }

    public void injectMembers(MusicPlaylistBaseFragment musicPlaylistBaseFragment0) {
        musicPlaylistBaseFragment0.downloadHelper = (h)this.a.get();
        MusicPlaylistBaseFragment_MembersInjector.injectPlayerUiHelper(musicPlaylistBaseFragment0, ((Bc.h)this.b.get()));
        MusicPlaylistBaseFragment_MembersInjector.injectStringProvider(musicPlaylistBaseFragment0, ((d)this.c.get()));
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((MusicPlaylistBaseFragment)object0));
    }

    public static void injectPlayerUiHelper(MusicPlaylistBaseFragment musicPlaylistBaseFragment0, Bc.h h0) {
        musicPlaylistBaseFragment0.playerUiHelper = h0;
    }

    public static void injectStringProvider(MusicPlaylistBaseFragment musicPlaylistBaseFragment0, d d0) {
        musicPlaylistBaseFragment0.stringProvider = d0;
    }
}

