package com.iloen.melon.player.video;

import C8.e;
import Gd.F;
import com.iloen.melon.playback.Playable;
import ie.H;
import kotlin.jvm.internal.q;
import q8.d;
import q8.h;
import we.k;

public final class b0 implements k {
    public final VideoMiniPlayer a;
    public final TiaraLogType b;
    public final boolean c;
    public final boolean d;
    public final int e;
    public final boolean f;
    public final Playable g;

    public b0(VideoMiniPlayer videoMiniPlayer0, TiaraLogType videoPlayerFragmentBase$TiaraLogType0, boolean z, boolean z1, int v, boolean z2, Playable playable0) {
        this.a = videoMiniPlayer0;
        this.b = videoPlayerFragmentBase$TiaraLogType0;
        this.c = z;
        this.d = z1;
        this.e = v;
        this.f = z2;
        this.g = playable0;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((d)object0), "$this$tiaraEventLogBuilder");
        new s(7, this.a, this.b).invoke(((h)((d)object0).b));
        ((d)object0).c(new c0(this.b, this.a, this.c, this.d));
        ((d)object0).b(new e(this.a, this.e, 9));
        ((d)object0).k(new F(this.a, this.f, this.g, 10));
        ((d)object0).d(new d0(this.c, this.d, 0));
        return H.a;
    }
}

