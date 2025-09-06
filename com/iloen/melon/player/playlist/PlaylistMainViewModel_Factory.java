package com.iloen.melon.player.playlist;

import Pc.d;
import com.melon.ui.n4;
import eb.n;
import eb.u;
import ge.b;
import kc.s2;
import mb.k;
import ob.z;

public final class PlaylistMainViewModel_Factory implements b {
    public final b a;
    public final b b;
    public final b c;
    public final b d;
    public final b e;
    public final b f;
    public final b g;

    public PlaylistMainViewModel_Factory(b b0, b b1, b b2, b b3, b b4, b b5, b b6) {
        this.a = b0;
        this.b = b1;
        this.c = b2;
        this.d = b3;
        this.e = b4;
        this.f = b5;
        this.g = b6;
    }

    public static PlaylistMainViewModel_Factory create(b b0, b b1, b b2, b b3, b b4, b b5, b b6) {
        return new PlaylistMainViewModel_Factory(b0, b1, b2, b3, b4, b5, b6);
    }

    public PlaylistMainViewModel get() {
        PlaylistMainViewModel playlistMainViewModel0 = PlaylistMainViewModel_Factory.newInstance(((d)this.a.get()), ((s2)this.b.get()), ((z)this.c.get()), ((k)this.d.get()), ((n4)this.e.get()));
        playlistMainViewModel0.pvUseCase = (n)this.f.get();
        playlistMainViewModel0.screenCaptureUseCase = (u)this.g.get();
        return playlistMainViewModel0;
    }

    @Override  // javax.inject.Provider
    public Object get() {
        return this.get();
    }

    public static PlaylistMainViewModel newInstance(d d0, s2 s20, z z0, k k0, n4 n40) {
        return new PlaylistMainViewModel(d0, s20, z0, k0, n40);
    }
}

