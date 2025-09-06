package com.iloen.melon.player.playlist.mixup;

import Pc.d;
import android.content.Context;
import com.iloen.melon.player.playlist.common.PlaylistDeleteHelper;
import com.melon.ui.Q;
import com.melon.ui.b3;
import com.melon.ui.t3;
import db.c;
import eb.n;
import eb.u;
import eb.y;
import ge.b;
import kc.s2;
import mb.k;
import ob.a;
import ob.z;

public final class MixUpPlaylistComposeViewModel_Factory implements b {
    public final b a;
    public final b b;
    public final b c;
    public final b d;
    public final b e;
    public final b f;
    public final b g;
    public final b h;
    public final b i;
    public final b j;
    public final b k;
    public final b l;
    public final b m;
    public final b n;
    public final b o;

    public MixUpPlaylistComposeViewModel_Factory(b b0, b b1, b b2, b b3, b b4, b b5, b b6, b b7, b b8, b b9, b b10, b b11, b b12, b b13, b b14) {
        this.a = b0;
        this.b = b1;
        this.c = b2;
        this.d = b3;
        this.e = b4;
        this.f = b5;
        this.g = b6;
        this.h = b7;
        this.i = b8;
        this.j = b9;
        this.k = b10;
        this.l = b11;
        this.m = b12;
        this.n = b13;
        this.o = b14;
    }

    public static MixUpPlaylistComposeViewModel_Factory create(b b0, b b1, b b2, b b3, b b4, b b5, b b6, b b7, b b8, b b9, b b10, b b11, b b12, b b13, b b14) {
        return new MixUpPlaylistComposeViewModel_Factory(b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14);
    }

    public MixUpPlaylistComposeViewModel get() {
        MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0 = MixUpPlaylistComposeViewModel_Factory.newInstance(((Context)this.a.get()), ((d)this.b.get()), ((s2)this.c.get()), ((z)this.d.get()), ((a)this.e.get()), ((y)this.f.get()), ((PlaylistDeleteHelper)this.g.get()), ((k)this.h.get()), ((t3)this.i.get()), ((b3)this.j.get()), ((Q)this.k.get()), ((c)this.l.get()), ((k8.a)this.m.get()));
        mixUpPlaylistComposeViewModel0.pvUseCase = (n)this.n.get();
        mixUpPlaylistComposeViewModel0.screenCaptureUseCase = (u)this.o.get();
        return mixUpPlaylistComposeViewModel0;
    }

    @Override  // javax.inject.Provider
    public Object get() {
        return this.get();
    }

    public static MixUpPlaylistComposeViewModel newInstance(Context context0, d d0, s2 s20, z z0, a a0, y y0, PlaylistDeleteHelper playlistDeleteHelper0, k k0, t3 t30, b3 b30, Q q0, c c0, k8.a a1) {
        return new MixUpPlaylistComposeViewModel(context0, d0, s20, z0, a0, y0, playlistDeleteHelper0, k0, t30, b30, q0, c0, a1);
    }
}

