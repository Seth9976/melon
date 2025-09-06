package com.iloen.melon.player.playlist.common;

import androidx.compose.runtime.l;
import androidx.compose.runtime.w;
import ie.H;
import r0.q;
import we.n;

public final class d implements n {
    public final q a;
    public final String b;
    public final String c;
    public final boolean d;
    public final Integer e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final int i;
    public final int j;

    public d(q q0, String s, String s1, boolean z, Integer integer0, boolean z1, boolean z2, boolean z3, int v, int v1) {
        this.a = q0;
        this.b = s;
        this.c = s1;
        this.d = z;
        this.e = integer0;
        this.f = z1;
        this.g = z2;
        this.h = z3;
        this.i = v;
        this.j = v1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Integer)object1).intValue();
        PlaylistCommonSongListComposableKt.SongTitleAndArtistLayout(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, ((l)object0), w.A(this.i | 1), this.j);
        return H.a;
    }
}

