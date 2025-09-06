package com.iloen.melon.player.playlist.mixup;

import O.F;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.b;
import androidx.lifecycle.f0;
import com.iloen.melon.playback.Playable;
import ie.H;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import r0.d;
import we.a;

public final class n implements a {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;

    public n(Object object0, Object object1, Object object2, int v) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        this.d = object2;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        Object object0 = this.d;
        Object object1 = this.c;
        Object object2 = this.b;
        if(this.a != 0) {
            return X0.n.c(r0.a.a((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(r0.n.a, d.h), new com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeFragment.MixUpPlaylistList.lambda.62.lambda.61.lambda.60..inlined.noRippleClickable-YQRRFTQ.default.1(true, null, 0, ((CoroutineScope)object2), ((F)object1))), false, new c(((MixUpPlaylistComposeFragment)object0), 1));
        }
        BuildersKt__Builders_commonKt.launch$default(f0.h(((MixUpPlaylistComposeViewModel)object2)), null, null, new MixUpPlaylistComposeViewModel.playInternal.2.1(((MixUpPlaylistComposeViewModel)object2), ((Integer)object1), ((Playable)object0), null), 3, null);
        return H.a;
    }
}

