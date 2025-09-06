package com.iloen.melon.player.playlist.drawernew;

import com.iloen.melon.player.playlist.common.PlaylistDeleteHelper;
import com.melon.ui.Q;
import com.melon.ui.b3;
import com.melon.ui.t3;
import eb.n;
import eb.u;
import eb.y;
import ge.b;
import j9.d;
import kc.s2;
import kotlinx.coroutines.CoroutineDispatcher;
import mb.k;
import ob.a;
import ob.z;

public final class DrawerSongFragmentViewModel_Factory implements b {
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
    public final b p;

    public DrawerSongFragmentViewModel_Factory(b b0, b b1, b b2, b b3, b b4, b b5, b b6, b b7, b b8, b b9, b b10, b b11, b b12, b b13, b b14, b b15) {
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
        this.p = b15;
    }

    public static DrawerSongFragmentViewModel_Factory create(b b0, b b1, b b2, b b3, b b4, b b5, b b6, b b7, b b8, b b9, b b10, b b11, b b12, b b13, b b14, b b15) {
        return new DrawerSongFragmentViewModel_Factory(b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15);
    }

    public DrawerSongFragmentViewModel get() {
        DrawerSongFragmentViewModel drawerSongFragmentViewModel0 = DrawerSongFragmentViewModel_Factory.newInstance(((CoroutineDispatcher)this.a.get()), ((CoroutineDispatcher)this.b.get()), ((CoroutineDispatcher)this.c.get()), ((k)this.d.get()), ((y)this.e.get()), ((z)this.f.get()), ((a)this.g.get()), ((s2)this.h.get()), ((d)this.i.get()), ((Pc.d)this.j.get()), ((Q)this.k.get()), ((t3)this.l.get()), ((PlaylistDeleteHelper)this.m.get()), ((b3)this.n.get()));
        drawerSongFragmentViewModel0.pvUseCase = (n)this.o.get();
        drawerSongFragmentViewModel0.screenCaptureUseCase = (u)this.p.get();
        return drawerSongFragmentViewModel0;
    }

    @Override  // javax.inject.Provider
    public Object get() {
        return this.get();
    }

    public static DrawerSongFragmentViewModel newInstance(CoroutineDispatcher coroutineDispatcher0, CoroutineDispatcher coroutineDispatcher1, CoroutineDispatcher coroutineDispatcher2, k k0, y y0, z z0, a a0, s2 s20, d d0, Pc.d d1, Q q0, t3 t30, PlaylistDeleteHelper playlistDeleteHelper0, b3 b30) {
        return new DrawerSongFragmentViewModel(coroutineDispatcher0, coroutineDispatcher1, coroutineDispatcher2, k0, y0, z0, a0, s20, d0, d1, q0, t30, playlistDeleteHelper0, b30);
    }
}

