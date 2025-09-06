package com.iloen.melon.player.playlist.music;

import Xd.a;
import eb.n;
import eb.u;
import ge.b;

public final class MusicPlaylistViewModel_MembersInjector implements a {
    public final b a;
    public final b b;

    public MusicPlaylistViewModel_MembersInjector(b b0, b b1) {
        this.a = b0;
        this.b = b1;
    }

    public static a create(b b0, b b1) {
        return new MusicPlaylistViewModel_MembersInjector(b0, b1);
    }

    public void injectMembers(MusicPlaylistViewModel musicPlaylistViewModel0) {
        musicPlaylistViewModel0.pvUseCase = (n)this.a.get();
        musicPlaylistViewModel0.screenCaptureUseCase = (u)this.b.get();
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((MusicPlaylistViewModel)object0));
    }
}

