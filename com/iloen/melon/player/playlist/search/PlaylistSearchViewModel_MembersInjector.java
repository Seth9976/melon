package com.iloen.melon.player.playlist.search;

import Xd.a;
import eb.n;
import eb.u;
import ge.b;

public final class PlaylistSearchViewModel_MembersInjector implements a {
    public final b a;
    public final b b;

    public PlaylistSearchViewModel_MembersInjector(b b0, b b1) {
        this.a = b0;
        this.b = b1;
    }

    public static a create(b b0, b b1) {
        return new PlaylistSearchViewModel_MembersInjector(b0, b1);
    }

    public void injectMembers(PlaylistSearchViewModel playlistSearchViewModel0) {
        playlistSearchViewModel0.pvUseCase = (n)this.a.get();
        playlistSearchViewModel0.screenCaptureUseCase = (u)this.b.get();
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((PlaylistSearchViewModel)object0));
    }
}

