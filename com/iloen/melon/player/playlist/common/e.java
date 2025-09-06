package com.iloen.melon.player.playlist.common;

import androidx.compose.runtime.l;
import ie.H;
import we.a;
import we.n;

public final class e implements n {
    public final String a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final a e;
    public final int f;

    public e(String s, boolean z, boolean z1, boolean z2, a a0, int v) {
        this.a = s;
        this.b = z;
        this.c = z1;
        this.d = z2;
        this.e = a0;
        this.f = v;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Integer)object1).intValue();
        PlaylistCommonSongListComposableKt.SongThumbNailLayoutIsPlaying(this.a, this.b, this.c, this.d, this.e, ((l)object0), (this.f | 1) & -920350135 | ((0x24924924 & (this.f | 1)) >> 1 | 306783378 & (this.f | 1)) | (306783378 & (this.f | 1)) << 1 & (0x24924924 & (this.f | 1)));
        return H.a;
    }
}

