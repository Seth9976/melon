package com.iloen.melon.player.playlist.drawernew.composable;

import O.F;
import X0.n;
import android.content.Context;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.b;
import kotlinx.coroutines.CoroutineScope;
import r0.d;
import we.a;

public final class i implements a {
    public final int a;
    public final CoroutineScope b;
    public final F c;
    public final Context d;

    public i(CoroutineScope coroutineScope0, F f0, Context context0, int v) {
        this.a = v;
        this.b = coroutineScope0;
        this.c = f0;
        this.d = context0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        return this.a == 0 ? n.c(r0.a.a((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(r0.n.a, d.h), new com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt.DrawerSongList.lambda.26.lambda.25.lambda.24..inlined.noRippleClickable-YQRRFTQ.default.1(true, null, 0, this.b, this.c)), false, new Cc.n(this.d, 8)) : n.c(r0.a.a((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(r0.n.a, d.h), new com.iloen.melon.player.playlist.music.composables.MusicSongListKt.MusicSongList.lambda.26.lambda.25.lambda.24..inlined.noRippleClickable-YQRRFTQ.default.1(true, null, 0, this.b, this.c)), false, new Cc.n(this.d, 9));
    }
}

