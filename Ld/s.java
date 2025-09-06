package ld;

import Bd.w;
import Uc.o;
import com.kakao.tiara.data.ActionKind;
import hd.a1;
import ie.H;
import kotlin.jvm.internal.q;
import q8.d;
import q8.h;
import we.k;

public final class s implements k {
    public final String a;
    public final p8.s b;
    public final ActionKind c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;

    public s(String s, p8.s s1, ActionKind actionKind0, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10) {
        this.a = s;
        this.b = s1;
        this.c = actionKind0;
        this.d = s2;
        this.e = s3;
        this.f = s4;
        this.g = s5;
        this.h = s6;
        this.i = s7;
        this.j = s8;
        this.k = s9;
        this.l = s10;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((d)object0), "$this$tiaraEventLogBuilder");
        new com.iloen.melon.playback.playlist.db.d(this.a, 15).invoke(((h)((d)object0).b));
        ((d)object0).c(new o(this.b, this.c, 6));
        ((d)object0).b(new H8.d(1, this.d, this.e, this.f, this.g, this.h));
        ((d)object0).e(new a1(3, this.i, this.j, this.k, this.l));
        ((d)object0).d(new w(this.b, 10));
        return H.a;
    }
}

