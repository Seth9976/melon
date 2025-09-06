package com.iloen.melon.player.playlist.mixup;

import Xd.a;
import eb.n;
import eb.u;
import ge.b;

public final class MixUpPlaylistComposeViewModel_MembersInjector implements a {
    public final b a;
    public final b b;

    public MixUpPlaylistComposeViewModel_MembersInjector(b b0, b b1) {
        this.a = b0;
        this.b = b1;
    }

    public static a create(b b0, b b1) {
        return new MixUpPlaylistComposeViewModel_MembersInjector(b0, b1);
    }

    public void injectMembers(MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0) {
        mixUpPlaylistComposeViewModel0.pvUseCase = (n)this.a.get();
        mixUpPlaylistComposeViewModel0.screenCaptureUseCase = (u)this.b.get();
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((MixUpPlaylistComposeViewModel)object0));
    }
}

