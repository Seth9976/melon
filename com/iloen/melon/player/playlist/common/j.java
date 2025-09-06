package com.iloen.melon.player.playlist.common;

import X0.x;
import android.content.Context;
import ie.H;
import kotlin.jvm.internal.q;
import we.a;
import we.k;

public final class j implements k {
    public final Context a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final String e;
    public final String f;
    public final boolean g;
    public final a h;
    public final a i;
    public final a j;
    public final a k;
    public final a l;
    public final a m;

    public j(Context context0, boolean z, boolean z1, boolean z2, String s, String s1, boolean z3, a a0, a a1, a a2, a a3, a a4, a a5) {
        this.a = context0;
        this.b = z;
        this.c = z1;
        this.d = z2;
        this.e = s;
        this.f = s1;
        this.g = z3;
        this.h = a0;
        this.i = a1;
        this.j = a2;
        this.k = a3;
        this.l = a4;
        this.m = a5;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((x)object0), "$this$clearAndSetSemantics");
        PlaylistCommonSongListComposableKt.setSongItemSemantics(((x)object0), this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m);
        return H.a;
    }
}

