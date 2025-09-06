package com.iloen.melon.player.playlist.music.composables;

import androidx.compose.runtime.l;
import ie.H;
import oc.c0;
import we.a;
import we.n;

public final class b implements n {
    public final boolean a;
    public final String b;
    public final String c;
    public final Ib.b d;
    public final c0 e;
    public final a f;
    public final a g;
    public final a h;
    public final a i;
    public final a j;
    public final int k;

    public b(boolean z, String s, String s1, Ib.b b0, c0 c00, a a0, a a1, a a2, a a3, a a4, int v) {
        this.a = z;
        this.b = s;
        this.c = s1;
        this.d = b0;
        this.e = c00;
        this.f = a0;
        this.g = a1;
        this.h = a2;
        this.i = a3;
        this.j = a4;
        this.k = v;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Integer)object1).intValue();
        MusicPlaylistHeaderKt.MusicPlaylistHeader(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, ((l)object0), (this.k | 1) & -920350135 | ((0x24924924 & (this.k | 1)) >> 1 | 306783378 & (this.k | 1)) | (306783378 & (this.k | 1)) << 1 & (0x24924924 & (this.k | 1)));
        return H.a;
    }
}

