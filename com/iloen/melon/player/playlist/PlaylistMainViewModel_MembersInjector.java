package com.iloen.melon.player.playlist;

import Xd.a;
import eb.n;
import eb.u;
import ge.b;

public final class PlaylistMainViewModel_MembersInjector implements a {
    public final b a;
    public final b b;

    public PlaylistMainViewModel_MembersInjector(b b0, b b1) {
        this.a = b0;
        this.b = b1;
    }

    public static a create(b b0, b b1) {
        return new PlaylistMainViewModel_MembersInjector(b0, b1);
    }

    public void injectMembers(PlaylistMainViewModel playlistMainViewModel0) {
        playlistMainViewModel0.pvUseCase = (n)this.a.get();
        playlistMainViewModel0.screenCaptureUseCase = (u)this.b.get();
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((PlaylistMainViewModel)object0));
    }
}

