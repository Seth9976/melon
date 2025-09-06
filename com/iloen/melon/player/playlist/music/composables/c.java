package com.iloen.melon.player.playlist.music.composables;

import Dc.g;
import Dc.u;
import O.F;
import O.j;
import O.w;
import com.iloen.melon.custom.B1;
import com.iloen.melon.player.playlist.common.SongListItemRightIconType;
import com.iloen.melon.player.playlist.music.MusicPlaylistUiState.Success;
import ie.H;
import kotlin.jvm.internal.q;
import m0.b;
import p0.p;
import we.a;
import we.k;
import we.n;

public final class c implements k {
    public final p a;
    public final a b;
    public final n c;
    public final u d;
    public final g e;
    public final F f;
    public final n g;
    public final Success h;
    public final boolean i;
    public final SongListItemRightIconType j;
    public final k k;
    public final k l;
    public final a m;
    public final k n;
    public final k o;
    public final k r;

    public c(p p0, a a0, n n0, u u0, g g0, F f0, n n1, Success musicPlaylistUiState$Success0, boolean z, SongListItemRightIconType songListItemRightIconType0, k k0, k k1, a a1, k k2, k k3, k k4) {
        this.a = p0;
        this.b = a0;
        this.c = n0;
        this.d = u0;
        this.e = g0;
        this.f = f0;
        this.g = n1;
        this.h = musicPlaylistUiState$Success0;
        this.i = z;
        this.j = songListItemRightIconType0;
        this.k = k0;
        this.l = k1;
        this.m = a1;
        this.n = k2;
        this.o = k3;
        this.r = k4;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((w)object0), "$this$LazyColumn");
        com.iloen.melon.player.playlist.drawernew.composable.k k0 = new com.iloen.melon.player.playlist.drawernew.composable.k(this.b, this.a, this.c, 2);
        com.iloen.melon.player.playlist.drawernew.composable.k k1 = new com.iloen.melon.player.playlist.drawernew.composable.k(this.a, this.b, this.c, 3);
        com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.lambda.26.lambda.19.lambda.18.lambda.15.lambda.14..inlined.itemsIndexed.default.1 musicSongListKt$MusicSongList$lambda$26$lambda$19$lambda$18$lambda$15$lambda$14$$inlined$itemsIndexed$default$10 = new com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.lambda.26.lambda.19.lambda.18.lambda.15.lambda.14..inlined.itemsIndexed.default.1(new B1(9), this.a);
        com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.lambda.26.lambda.19.lambda.18.lambda.15.lambda.14..inlined.itemsIndexed.default.2 musicSongListKt$MusicSongList$lambda$26$lambda$19$lambda$18$lambda$15$lambda$14$$inlined$itemsIndexed$default$20 = new com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.lambda.26.lambda.19.lambda.18.lambda.15.lambda.14..inlined.itemsIndexed.default.2(this.a);
        b b0 = new b(0xBEF78951, new com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.lambda.26.lambda.19.lambda.18.lambda.15.lambda.14..inlined.itemsIndexed.default.3(this.a, this.d, this.e, this.f, this.g, this.h, this.i, k0, k1, this.j, this.k, this.l, this.m, this.n, this.o, this.r), true);
        ((j)(((w)object0))).u(this.a.size(), musicSongListKt$MusicSongList$lambda$26$lambda$19$lambda$18$lambda$15$lambda$14$$inlined$itemsIndexed$default$10, musicSongListKt$MusicSongList$lambda$26$lambda$19$lambda$18$lambda$15$lambda$14$$inlined$itemsIndexed$default$20, b0);
        return H.a;
    }
}

