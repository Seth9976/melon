package com.iloen.melon.player.playlist.mixup.composables;

import androidx.compose.runtime.l;
import ie.H;
import r0.q;
import we.n;

public final class a implements n {
    public final int a;
    public final q b;
    public final q c;
    public final we.a d;
    public final SongListClickListener e;
    public final int f;
    public final int g;

    public a(q q0, q q1, we.a a0, SongListClickListener songListClickListener0, int v, int v1, int v2) {
        this.a = v2;
        this.b = q0;
        this.c = q1;
        this.d = a0;
        this.e = songListClickListener0;
        this.f = v;
        this.g = v1;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.a != 0) {
            ((Integer)object1).intValue();
            MixUpSongListKt.MixUpSongItemInPlaylist(this.b, this.c, this.d, this.e, ((l)object0), (this.f | 1) & -920350135 | ((0x24924924 & (this.f | 1)) >> 1 | 306783378 & (this.f | 1)) | (306783378 & (this.f | 1)) << 1 & (0x24924924 & (this.f | 1)), this.g);
            return H.a;
        }
        ((Integer)object1).intValue();
        MixUpSongListKt.MixUpSongItemInPlaylist(this.b, this.c, this.d, this.e, ((l)object0), (this.f | 1) & -920350135 | ((0x24924924 & (this.f | 1)) >> 1 | 306783378 & (this.f | 1)) | (306783378 & (this.f | 1)) << 1 & (0x24924924 & (this.f | 1)), this.g);
        return H.a;
    }
}

