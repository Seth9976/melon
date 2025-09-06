package com.iloen.melon.player.playlist.mixup;

import Cc.x2;
import Md.h;
import Pc.d;
import Xd.a;
import db.c;
import ge.b;
import ob.z;

public final class MixUpPlaylistComposeFragment_MembersInjector implements a {
    public final b a;
    public final b b;
    public final b c;
    public final b d;
    public final b e;
    public final b f;

    public MixUpPlaylistComposeFragment_MembersInjector(b b0, b b1, b b2, b b3, b b4, b b5) {
        this.a = b0;
        this.b = b1;
        this.c = b2;
        this.d = b3;
        this.e = b4;
        this.f = b5;
    }

    public static a create(b b0, b b1, b b2, b b3, b b4, b b5) {
        return new MixUpPlaylistComposeFragment_MembersInjector(b0, b1, b2, b3, b4, b5);
    }

    public static void injectLocationUseCase(MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0, c c0) {
        mixUpPlaylistComposeFragment0.locationUseCase = c0;
    }

    public void injectMembers(MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0) {
        mixUpPlaylistComposeFragment0.downloadHelper = (h)this.a.get();
        MixUpPlaylistComposeFragment_MembersInjector.injectStringProvider(mixUpPlaylistComposeFragment0, ((d)this.b.get()));
        MixUpPlaylistComposeFragment_MembersInjector.injectPlayerUiHelper(mixUpPlaylistComposeFragment0, ((Bc.h)this.c.get()));
        MixUpPlaylistComposeFragment_MembersInjector.injectPlayerUseCase(mixUpPlaylistComposeFragment0, ((z)this.d.get()));
        MixUpPlaylistComposeFragment_MembersInjector.injectLocationUseCase(mixUpPlaylistComposeFragment0, ((c)this.e.get()));
        MixUpPlaylistComposeFragment_MembersInjector.injectPlayBgColorExtractor(mixUpPlaylistComposeFragment0, ((x2)this.f.get()));
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((MixUpPlaylistComposeFragment)object0));
    }

    public static void injectPlayBgColorExtractor(MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0, x2 x20) {
        mixUpPlaylistComposeFragment0.playBgColorExtractor = x20;
    }

    public static void injectPlayerUiHelper(MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0, Bc.h h0) {
        mixUpPlaylistComposeFragment0.playerUiHelper = h0;
    }

    public static void injectPlayerUseCase(MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0, z z0) {
        mixUpPlaylistComposeFragment0.playerUseCase = z0;
    }

    public static void injectStringProvider(MixUpPlaylistComposeFragment mixUpPlaylistComposeFragment0, d d0) {
        mixUpPlaylistComposeFragment0.stringProvider = d0;
    }
}

