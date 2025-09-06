package com.iloen.melon.player.video;

import Gd.F;
import com.iloen.melon.playback.Playable;
import com.kakao.tiara.data.ActionKind;
import ie.H;
import kotlin.jvm.internal.q;
import q8.d;
import q8.h;
import we.k;

public final class i implements k {
    public final VideoChatFragment a;
    public final ActionKind b;
    public final String c;
    public final boolean d;
    public final Playable e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;

    public i(VideoChatFragment videoChatFragment0, ActionKind actionKind0, String s, boolean z, Playable playable0, String s1, String s2, String s3, String s4) {
        this.a = videoChatFragment0;
        this.b = actionKind0;
        this.c = s;
        this.d = z;
        this.e = playable0;
        this.f = s1;
        this.g = s2;
        this.h = s3;
        this.i = s4;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((d)object0), "$this$tiaraEventLogBuilder");
        new g(this.a, 2).invoke(((h)((d)object0).b));
        ((d)object0).c(new s(2, this.a, this.b));
        ((d)object0).b(new m(this.a, this.c));
        ((d)object0).k(new F(this.a, this.d, this.e, 8));
        ((d)object0).e(new n(this.f, this.g, this.h, 0));
        ((d)object0).d(new m(this.i, this.a));
        return H.a;
    }
}

