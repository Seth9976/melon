package com.iloen.melon.player.playlist.music;

import androidx.compose.runtime.l;
import d8.d;
import ie.H;
import we.a;
import we.n;

public final class q implements n {
    public final int a;
    public final int b;
    public final int c;
    public final a d;

    public q(int v, int v1, a a0) {
        this.a = 0;
        super();
        this.d = a0;
        this.b = v;
        this.c = v1;
    }

    public q(int v, int v1, a a0, int v2) {
        this.a = 1;
        super();
        this.b = v;
        this.c = v1;
        this.d = a0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        if(this.a != 0) {
            ((Integer)object1).getClass();
            d.g(this.b, this.c, this.d, ((l)object0), 1);
            return H.a;
        }
        ((Integer)object1).intValue();
        MusicPlaylistFragmentKt.MusicPlaylistEmptyView(this.d, ((l)object0), (this.b | 1) & -920350135 | ((0x24924924 & (this.b | 1)) >> 1 | 306783378 & (this.b | 1)) | (306783378 & (this.b | 1)) << 1 & (0x24924924 & (this.b | 1)), this.c);
        return H.a;
    }
}

