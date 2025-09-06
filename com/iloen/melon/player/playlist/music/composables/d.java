package com.iloen.melon.player.playlist.music.composables;

import androidx.compose.runtime.l;
import com.iloen.melon.player.playlist.music.MusicPlaylistUiState.Success;
import ie.H;
import kotlinx.coroutines.flow.StateFlow;
import we.a;
import we.k;
import we.n;

public final class d implements n {
    public final Success a;
    public final StateFlow b;
    public final k c;
    public final k d;
    public final k e;
    public final k f;
    public final k g;
    public final a h;
    public final n i;
    public final a j;
    public final n k;
    public final int l;
    public final int m;
    public final int n;

    public d(Success musicPlaylistUiState$Success0, StateFlow stateFlow0, k k0, k k1, k k2, k k3, k k4, a a0, n n0, a a1, n n1, int v, int v1, int v2) {
        this.a = musicPlaylistUiState$Success0;
        this.b = stateFlow0;
        this.c = k0;
        this.d = k1;
        this.e = k2;
        this.f = k3;
        this.g = k4;
        this.h = a0;
        this.i = n0;
        this.j = a1;
        this.k = n1;
        this.l = v;
        this.m = v1;
        this.n = v2;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Integer)object1).intValue();
        MusicSongListKt.MusicSongList(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, ((l)object0), (this.l | 1) & -920350135 | ((0x24924924 & (this.l | 1)) >> 1 | 306783378 & (this.l | 1)) | (306783378 & (this.l | 1)) << 1 & (0x24924924 & (this.l | 1)), this.m & -920350135 | ((0x24924924 & this.m) >> 1 | 306783378 & this.m) | (306783378 & this.m) << 1 & (0x24924924 & this.m), this.n);
        return H.a;
    }
}

