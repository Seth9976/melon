package com.iloen.melon.player.playlist.common.scrollbar;

import I.u0;
import N0.v;
import androidx.compose.runtime.b0;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;

public final class b implements k {
    public final b0 a;

    public b(b0 b00) {
        this.a = b00;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((v)object0), "coordinates");
        long v = ((v)object0).j0(0L);
        float f = ScrollbarKt.valueOf-Uv8p0NA(u0.a, v);
        long v1 = ((v)object0).l();
        ScrollbarTrack scrollbarTrack0 = ScrollbarTrack.box-impl(ScrollbarTrack.constructor-impl(f, ((float)ScrollbarKt.valueOf-O0kMr_c(u0.a, v1)) + f));
        this.a.setValue(scrollbarTrack0);
        return H.a;
    }
}

