package com.iloen.melon.player.playlist.music;

import Xd.a;
import eb.n;
import eb.u;
import ge.b;

public final class SmartPlaylistViewModel_MembersInjector implements a {
    public final b a;
    public final b b;

    public SmartPlaylistViewModel_MembersInjector(b b0, b b1) {
        this.a = b0;
        this.b = b1;
    }

    public static a create(b b0, b b1) {
        return new SmartPlaylistViewModel_MembersInjector(b0, b1);
    }

    public void injectMembers(SmartPlaylistViewModel smartPlaylistViewModel0) {
        smartPlaylistViewModel0.pvUseCase = (n)this.a.get();
        smartPlaylistViewModel0.screenCaptureUseCase = (u)this.b.get();
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((SmartPlaylistViewModel)object0));
    }
}

