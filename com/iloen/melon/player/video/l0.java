package com.iloen.melon.player.video;

import Gd.F;
import com.iloen.melon.playback.Playable;
import ie.H;
import kotlin.jvm.internal.q;
import q8.d;
import q8.h;
import we.k;

public final class l0 implements k {
    public final VideoPlayerFragmentBase a;
    public final TiaraLogType b;
    public final int c;
    public final boolean d;
    public final Playable e;
    public final boolean f;

    public l0(VideoPlayerFragmentBase videoPlayerFragmentBase0, TiaraLogType videoPlayerFragmentBase$TiaraLogType0, int v, boolean z, Playable playable0, boolean z1) {
        this.a = videoPlayerFragmentBase0;
        this.b = videoPlayerFragmentBase$TiaraLogType0;
        this.c = v;
        this.d = z;
        this.e = playable0;
        this.f = z1;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((d)object0), "$this$tiaraEventLogBuilder");
        new g0(this.a, this.b).invoke(((h)((d)object0).b));
        ((d)object0).c(new g0(this.b, this.a));
        ((d)object0).b(new h0(this.a, this.c, 0));
        ((d)object0).k(new F(this.a, this.d, this.e, 11));
        ((d)object0).d(new F(this.b, this.a, this.f, 12));
        return H.a;
    }
}

