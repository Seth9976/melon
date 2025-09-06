package hd;

import Bd.w;
import Cc.U2;
import Uc.o;
import com.kakao.tiara.data.ActionKind;
import ie.H;
import kotlin.jvm.internal.q;
import p8.s;
import q8.d;
import q8.h;
import we.k;

public final class y1 implements k {
    public final String a;
    public final String b;
    public final String c;
    public final ActionKind d;
    public final s e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;

    public y1(String s, String s1, String s2, ActionKind actionKind0, s s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = actionKind0;
        this.e = s3;
        this.f = s4;
        this.g = s5;
        this.h = s6;
        this.i = s7;
        this.j = s8;
        this.k = s9;
        this.l = s10;
        this.m = s11;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((d)object0), "$this$tiaraEventLogBuilder");
        new com.iloen.melon.playback.playlist.db.d(this.c, 12).invoke(((h)((d)object0).b));
        s s0 = this.e;
        ((d)object0).c(new o(this.d, s0, 5));
        ((d)object0).b(new a1(2, this.f, this.g, this.h, this.i));
        String s1 = this.a;
        if(s1.length() > 0) {
            ((d)object0).k(new U2(7, s1, this.j, this.k));
        }
        String s2 = this.b;
        if(s2.length() > 0) {
            ((d)object0).e(new U2(8, s2, this.l, this.m));
        }
        ((d)object0).d(new w(s0, 7));
        return H.a;
    }
}

