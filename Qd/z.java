package qd;

import Cc.e0;
import De.I;
import Ec.g;
import M.j;
import M.v;
import M.w;
import M.y;
import N0.m;
import P0.h;
import P0.i;
import U4.x;
import android.content.Context;
import androidx.compose.foundation.Q0;
import androidx.compose.foundation.layout.a;
import androidx.compose.foundation.layout.c;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.J;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.iloen.melon.custom.l1;
import hd.E;
import ie.H;
import jd.Z0;
import kotlinx.coroutines.CoroutineScope;
import r0.n;
import r0.q;
import we.k;
import we.o;

public final class z implements o {
    public final boolean a;
    public final boolean b;
    public final Context c;
    public final long d;
    public final long e;
    public final boolean f;
    public final b0 g;
    public final k h;
    public final a0 i;
    public final b0 j;

    public z(boolean z, boolean z1, Context context0, long v, long v1, boolean z2, b0 b00, k k0, a0 a00, b0 b01) {
        this.a = z;
        this.b = z1;
        this.c = context0;
        this.d = v;
        this.e = v1;
        this.f = z2;
        this.g = b00;
        this.h = k0;
        this.i = a00;
        this.j = b01;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        q q18;
        int v10;
        String s2;
        String s1;
        q q12;
        q q6;
        int v5;
        int v4;
        q q4;
        int v = (int)(((Integer)object2));
        kotlin.jvm.internal.q.g(((v)object0), "$this$BoxWithConstraints");
        if((v & 6) == 0) {
            v |= (((p)(((l)object1))).g(((v)object0)) ? 4 : 2);
        }
        p p0 = (p)(((l)object1));
        if(p0.Q(v & 1, (v & 19) != 18)) {
            Q0 q00 = androidx.compose.foundation.q.t(p0);
            int v1 = Float.compare(((c)(((v)object0))).b(), 78.0f);
            n n0 = n.a;
            if(v1 >= 0) {
                p0.a0(0x7ECB608D);
                q q0 = a.n(androidx.compose.foundation.q.x(e0.S(d.c, q00, 30.0f), q00, false, 14), 0.0f, 20.0f, 0.0f, 10.0f, 5);
                y y0 = w.a(j.c, r0.d.m, p0, 0);
                int v2 = p0.P;
                i0 i00 = p0.m();
                q q1 = r0.a.d(p0, q0);
                P0.k.y.getClass();
                i i0 = P0.j.b;
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, y0, P0.j.f);
                androidx.compose.runtime.w.x(p0, i00, P0.j.e);
                h h0 = P0.j.g;
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                    A7.d.q(v2, p0, v2, h0);
                }
                androidx.compose.runtime.w.x(p0, q1, P0.j.d);
                CoroutineScope coroutineScope0 = p0.N();
                V v3 = androidx.compose.runtime.k.a;
                if(coroutineScope0 == v3) {
                    coroutineScope0 = J.i(p0);
                    p0.l0(coroutineScope0);
                }
                boolean z = this.a;
                boolean z1 = this.b;
                k k0 = this.h;
                if(!z || z1) {
                    p0.a0(0x18D305F8);
                    q q7 = e2.a.r(d.n(n0, 48.0f), 0.3f);
                    ld.j j2 = p0.N();
                    if(j2 == v3) {
                        j2 = new ld.j(22);
                        p0.l0(j2);
                    }
                    q6 = X0.n.c(q7, false, j2);
                    p0.p(false);
                label_69:
                    q4 = q6;
                    v4 = 0x7F130B74;  // string:talkback_lyric_seek_mode_on "가사 위치로 이동 켜기"
                    v5 = 0x7F0801C2;  // drawable:btn_fullplayer_lyrics_seek_off
                }
                else {
                    b0 b00 = this.g;
                    if(((Boolean)b00.getValue()).booleanValue()) {
                        p0.a0(0x18DC3DF7);
                        q q2 = r0.a.a(d.n(n0, 48.0f), new g(k0, b00, 2));
                        ld.j j0 = p0.N();
                        if(j0 == v3) {
                            j0 = new ld.j(23);
                            p0.l0(j0);
                        }
                        q q3 = X0.n.c(q2, false, j0);
                        p0.p(false);
                        q4 = q3;
                        v4 = 0x7F130B73;  // string:talkback_lyric_seek_mode_off "가사 위치로 이동 끄기"
                        v5 = 0x7F0801C3;  // drawable:btn_fullplayer_lyrics_seek_on
                    }
                    else {
                        p0.a0(0x18EA0C16);
                        q q5 = r0.a.a(d.n(n0, 48.0f), new g(k0, b00, 3));
                        ld.j j1 = p0.N();
                        if(j1 == v3) {
                            j1 = new ld.j(24);
                            p0.l0(j1);
                        }
                        q6 = X0.n.c(q5, false, j1);
                        p0.p(false);
                        goto label_69;
                    }
                }
                androidx.compose.foundation.q.c(I.Q(v5, p0, 0), this.c.getString(v4), q4, null, N0.j.g, 0.0f, null, p0, 0x6000, 104);
                m m0 = N0.j.g;
                M.c.d(p0, d.h(n0, 8.0f));
                qd.J j3 = qd.I.f(((K0)this.i).m());
                String s = "가사 크기 변경, " + this.c.getString(j3.c) + ", " + "변경";
                kotlin.jvm.internal.q.f(s, "toString(...)");
                q q8 = d.n(n0, 48.0f);
                b0 b01 = this.j;
                Context context0 = this.c;
                q q9 = r0.a.a(q8, new E(coroutineScope0, k0, j3, this.i, context0, b01));
                ld.j j4 = p0.N();
                if(j4 == v3) {
                    j4 = new ld.j(15);
                    p0.l0(j4);
                }
                q q10 = X0.n.c(q9, false, j4);
                androidx.compose.foundation.q.c(I.Q(j3.b, p0, 0), s, q10, null, m0, 0.0f, null, p0, 0x6000, 104);
                M.c.d(p0, d.h(n0, 8.0f));
                int v6 = 0x7F0801BD;  // drawable:btn_fullplayer_lyrics_position_off
                if(!z || z1) {
                    p0.a0(0x191B4E10);
                    q q14 = e2.a.r(d.n(n0, 48.0f), 0.3f);
                    ld.j j7 = p0.N();
                    if(j7 == v3) {
                        j7 = new ld.j(16);
                        p0.l0(j7);
                    }
                    q12 = X0.n.c(q14, false, j7);
                    p0.p(false);
                }
                else if(((Boolean)b01.getValue()).booleanValue()) {
                    p0.a0(0x192302AE);
                    q q11 = d.n(n0, 48.0f);
                    ld.j j5 = p0.N();
                    if(j5 == v3) {
                        j5 = new ld.j(17);
                        p0.l0(j5);
                    }
                    q12 = X0.n.c(q11, false, j5);
                    p0.p(false);
                }
                else {
                    p0.a0(0x1929B618);
                    q q13 = r0.a.a(d.n(n0, 48.0f), new g(k0, b01, 4));
                    ld.j j6 = p0.N();
                    if(j6 == v3) {
                        j6 = new ld.j(18);
                        p0.l0(j6);
                    }
                    q12 = X0.n.c(q13, false, j6);
                    p0.p(false);
                    v6 = 0x7F0801BE;  // drawable:btn_fullplayer_lyrics_position_on
                }
                androidx.compose.foundation.q.c(I.Q(v6, p0, 0), "현재 가사 보기", q12, null, m0, 0.0f, null, p0, 0x6000, 104);
                M.c.d(p0, d.h(n0, 8.0f));
                long v7 = this.d;
                int v8 = Long.compare(v7, -1L);
                if(v8 > 0) {
                    long v9 = this.e;
                    if(v9 > -1L) {
                        s1 = context0.getString(0x7F130C11, new Object[]{((long)(v7 / 60000L)), ((long)(v7 % 60000L / 1000L)), ((long)(v9 / 60000L)), ((long)(v9 % 60000L / 1000L))});  // string:talkback_range_repeat_b "구간반복 사용중 %d분 %d초부터 %d분 %d초까지"
                        s2 = l1.m(s1, "getString(...)", context0, 0x7F130C12, "getString(...)");  // string:talkback_range_repeat_click_to_off "구간반복을 해제하려면 두 번 탭하세요."
                        v10 = 0x7F0801C0;  // drawable:btn_fullplayer_lyrics_repeat_all
                        goto label_138;
                    }
                    goto label_130;
                }
                else {
                label_130:
                    if(v8 > 0) {
                        s1 = context0.getString(0x7F130C10, new Object[]{((long)(v7 / 60000L)), ((long)(v7 % 60000L / 1000L))});  // string:talkback_range_repeat_a "구간반복 시작시간 설정됨 %d분 %d초"
                        s2 = l1.m(s1, "getString(...)", context0, 0x7F130C13, "getString(...)");  // string:talkback_range_repeat_click_to_set "현재 재생 위치를 구간의 마지막으로 설정하려면 두 번 탭하세요."
                        v10 = 0x7F0801BF;  // drawable:btn_fullplayer_lyrics_repeat_a
                    }
                    else {
                        s1 = "구간반복 사용안함";
                        s2 = l1.m("구간반복 사용안함", "getString(...)", context0, 0x7F130C14, "getString(...)");  // string:talkback_range_repeat_click_to_start "현재 재생 위치에서 구간반복을 시작하려면 두 번 탭하세요."
                        v10 = 0x7F0801C1;  // drawable:btn_fullplayer_lyrics_repeat_off
                    }
                }
            label_138:
                q q15 = r0.a.a(d.n(n0, 48.0f), new Z0(11, k0));
                ld.j j8 = p0.N();
                if(j8 == v3) {
                    j8 = new ld.j(19);
                    p0.l0(j8);
                }
                q q16 = X0.n.c(q15, false, j8);
                androidx.compose.foundation.q.c(I.Q(v10, p0, 0), s1 + ", " + s2, q16, null, m0, 0.0f, null, p0, 0x6000, 104);
                M.c.d(p0, d.h(n0, 8.0f));
                if(this.f) {
                    p0.a0(426190117);
                    q q17 = r0.a.a(d.n(n0, 48.0f), new Z0(12, k0));
                    ld.j j9 = p0.N();
                    if(j9 == v3) {
                        j9 = new ld.j(20);
                        p0.l0(j9);
                    }
                    q18 = X0.n.c(q17, false, j9);
                }
                else {
                    p0.a0(0x196CF962);
                    q q19 = e2.a.r(d.n(n0, 48.0f), 0.3f);
                    ld.j j10 = p0.N();
                    if(j10 == v3) {
                        j10 = new ld.j(21);
                        p0.l0(j10);
                    }
                    q18 = X0.n.c(q19, false, j10);
                }
                p0.p(false);
                androidx.compose.foundation.q.c(I.Q(0x7F0801BC, p0, 6), "가사 하이라이트", q18, null, m0, 0.0f, null, p0, 0x6000, 104);  // drawable:btn_fullplayer_lyrics_highlight
                p0.p(true);
                M.c.d(p0, d.q(n0, 8.0f));
                p0.p(false);
                return H.a;
            }
            p0.a0(0x7F756CC9);
            x.z(n0, 56.0f, p0, false);
            return H.a;
        }
        p0.T();
        return H.a;
    }
}

