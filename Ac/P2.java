package Ac;

import C8.b;
import Cc.N1;
import Cc.e0;
import Dd.g2;
import Ge.o0;
import Hd.T;
import Hd.h;
import Hd.z;
import M.j;
import M.w;
import M.y;
import Mc.H;
import N0.M;
import Nc.W0;
import P0.i;
import Qc.e;
import Qc.f;
import Qc.t;
import Qc.u;
import Qc.v;
import Xc.g;
import android.content.Context;
import androidx.compose.foundation.lazy.a;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import cd.d2;
import cd.m2;
import cd.n2;
import com.iloen.melon.net.v4x.response.StreamGetSongInfoRes.RESPONSE.ContentsInfo;
import com.iloen.melon.net.v5x.response.CastPopularListRes.Response.CAST;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TAG.CONTENTS;
import com.iloen.melon.utils.log.LogU;
import com.melon.net.res.MusicDnaMainRes.RESPONSE.MYDNA.CARD;
import com.melon.net.res.v3.CommentConfig;
import com.melon.net.res.v3.CommentUiModel;
import com.melon.ui.K4;
import gd.r6;
import gd.u6;
import java.util.ArrayList;
import java.util.List;
import jd.D1;
import jd.F1;
import kotlin.jvm.internal.r;
import m0.c;
import r0.d;
import r0.n;
import r0.q;
import we.p;

public final class p2 extends r implements p {
    public final int f;
    public final List g;
    public final Object h;
    public final Object i;

    public p2(List list0, g g0, List list1) {
        this.f = 6;
        this.g = list0;
        this.i = g0;
        this.h = list1;
        super(4);
    }

    public p2(List list0, Object object0, Object object1, int v) {
        this.f = v;
        this.g = list0;
        this.h = object0;
        this.i = object1;
        super(4);
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        String s5;
        H h4;
        g g1;
        switch(this.f) {
            case 0: {
                int v4 = ((Number)object1).intValue();
                int v5 = ((Number)object3).intValue();
                v2 v20 = (v2)this.i;
                int v6 = (v5 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v5 : v5;
                if((v5 & 0x30) == 0) {
                    v6 |= (((androidx.compose.runtime.p)(((l)object2))).e(v4) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v6 & 1, (v6 & 0x93) != 0x92)) {
                    K4 k40 = (K4)this.g.get(v4);
                    ((androidx.compose.runtime.p)(((l)object2))).a0(0x2F6E5126);
                    if(k40 instanceof O2) {
                        ((androidx.compose.runtime.p)(((l)object2))).a0(0x2F6F34CD);
                        CommentUiModel commentUiModel0 = ((O2)k40).a;
                        boolean z2 = v4 == ((List)this.h).size() - 1;
                        CommentConfig commentConfig0 = ((O2)k40).b;
                        boolean z3 = ((androidx.compose.runtime.p)(((l)object2))).i(v20);
                        o2 o20 = ((androidx.compose.runtime.p)(((l)object2))).N();
                        if(z3 || o20 == k.a) {
                            o2 o21 = new o2(1, v20, v2.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 1);
                            ((androidx.compose.runtime.p)(((l)object2))).l0(o21);
                            o20 = o21;
                        }
                        o1.d(commentUiModel0, v4 == 0, z2, 0.0f, false, commentConfig0, o20, ((androidx.compose.runtime.p)(((l)object2))), 0x6000, 8);
                        ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    }
                    else {
                        ((androidx.compose.runtime.p)(((l)object2))).a0(0x2F76D741);
                        ((androidx.compose.runtime.p)(((l)object2))).p(false);
                        LogU.debug$default(v20.h, "else", null, false, 6, null);
                    }
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    return ie.H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return ie.H.a;
            }
            case 1: {
                int v7 = ((Number)object1).intValue();
                int v8 = ((Number)object3).intValue();
                j3 j30 = (j3)this.i;
                int v9 = (v8 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v8 : v8;
                if((v8 & 0x30) == 0) {
                    v9 |= (((androidx.compose.runtime.p)(((l)object2))).e(v7) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v9 & 1, (v9 & 0x93) != 0x92)) {
                    K4 k41 = (K4)this.g.get(v7);
                    ((androidx.compose.runtime.p)(((l)object2))).a0(0xB061226F);
                    V v10 = k.a;
                    if(k41 instanceof O2) {
                        ((androidx.compose.runtime.p)(((l)object2))).a0(0xB061E7EF);
                        CommentUiModel commentUiModel1 = ((O2)k41).a;
                        boolean z4 = v7 == e.k.s(((List)this.h));
                        CommentConfig commentConfig1 = ((O2)k41).b;
                        boolean z5 = ((androidx.compose.runtime.p)(((l)object2))).i(j30);
                        o2 o22 = ((androidx.compose.runtime.p)(((l)object2))).N();
                        if(z5 || o22 == v10) {
                            o22 = new o2(1, j30, j3.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 6);
                            ((androidx.compose.runtime.p)(((l)object2))).l0(o22);
                        }
                        o1.d(commentUiModel1, v7 == 0, z4, 40.0f, false, commentConfig1, o22, ((androidx.compose.runtime.p)(((l)object2))), 0x6C00, 0);
                    }
                    else if(k41 instanceof P2) {
                        ((androidx.compose.runtime.p)(((l)object2))).a0(0xB06AA7CE);
                        String s = ((P2)k41).a;
                        String s1 = ((P2)k41).b;
                        String s2 = ((P2)k41).c;
                        boolean z6 = ((androidx.compose.runtime.p)(((l)object2))).i(j30);
                        o2 o23 = ((androidx.compose.runtime.p)(((l)object2))).N();
                        if(z6 || o23 == v10) {
                            o23 = new o2(1, j30, j3.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 7);
                            ((androidx.compose.runtime.p)(((l)object2))).l0(o23);
                        }
                        o1.g(s, s1, s2, o23, ((androidx.compose.runtime.p)(((l)object2))), 0);
                    }
                    else {
                        ((androidx.compose.runtime.p)(((l)object2))).a0(-1350640603);
                    }
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    return ie.H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return ie.H.a;
            }
            case 2: {
                int v11 = ((Number)object1).intValue();
                int v12 = ((Number)object3).intValue();
                T t0 = (T)this.i;
                int v13 = (v12 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v12 : v12;
                if((v12 & 0x30) == 0) {
                    v13 |= (((androidx.compose.runtime.p)(((l)object2))).e(v11) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v13 & 1, (v13 & 0x93) != 0x92)) {
                    z z7 = (z)this.g.get(v11);
                    ((androidx.compose.runtime.p)(((l)object2))).a0(0x97C305CF);
                    if(v11 == 0) {
                        ((androidx.compose.runtime.p)(((l)object2))).a0(0x97C33774);
                        h h1 = (h)this.h;
                        boolean z8 = ((androidx.compose.runtime.p)(((l)object2))).i(t0);
                        g2 g20 = ((androidx.compose.runtime.p)(((l)object2))).N();
                        if(z8 || g20 == k.a) {
                            g2 g21 = new g2(1, t0, T.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 10);
                            ((androidx.compose.runtime.p)(((l)object2))).l0(g21);
                            g20 = g21;
                        }
                        Id.l.d(h1, g20, ((androidx.compose.runtime.p)(((l)object2))), 0);
                        q q3 = androidx.compose.foundation.layout.a.m(n.a, 16.0f, 20.0f, 16.0f, 12.0f);
                        String s3 = t0.getString(0x7F1308B7);  // string:radio_episode_all "전체 회차"
                        kotlin.jvm.internal.q.f(s3, "getString(...)");
                        N1.b(s3, q3, e0.T(((androidx.compose.runtime.p)(((l)object2))), 0x7F06016D), 18.0f, null, null, 0L, null, 0.0f, 0, false, 1, 0, null, null, ((androidx.compose.runtime.p)(((l)object2))), 0xC00, 0xC00, 0x1DFF0);  // color:gray900s
                    }
                    else {
                        ((androidx.compose.runtime.p)(((l)object2))).a0(0x96F863C9);
                    }
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    Id.l.e(v11, z7, ((androidx.compose.runtime.p)(((l)object2))), (v13 & 0x7E) >> 3 & 14);
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    return ie.H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return ie.H.a;
            }
            case 3: {
                int v14 = ((Number)object1).intValue();
                int v15 = ((Number)object3).intValue();
                f f0 = (f)this.i;
                int v16 = (v15 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v15 : v15;
                if((v15 & 0x30) == 0) {
                    v16 |= (((androidx.compose.runtime.p)(((l)object2))).e(v14) ? 0x20 : 16);
                }
                androidx.compose.runtime.p p1 = (androidx.compose.runtime.p)(((l)object2));
                if(p1.Q(v16 & 1, (v16 & 0x93) != 0x92)) {
                    K4 k42 = (K4)((ArrayList)this.g).get(v14);
                    p1.a0(0x80A7E1B3);
                    n n0 = n.a;
                    if(k42 instanceof t) {
                        p1.a0(0x80A8B57D);
                        int v17 = ((t)k42).a;
                        y y0 = w.a(j.c, d.m, p1, 0);
                        int v18 = p1.P;
                        i0 i01 = p1.m();
                        q q4 = r0.a.d(p1, n0);
                        P0.k.y.getClass();
                        i i2 = P0.j.b;
                        p1.e0();
                        if(p1.O) {
                            p1.l(i2);
                        }
                        else {
                            p1.o0();
                        }
                        androidx.compose.runtime.w.x(p1, y0, P0.j.f);
                        androidx.compose.runtime.w.x(p1, i01, P0.j.e);
                        P0.h h2 = P0.j.g;
                        if(p1.O || !kotlin.jvm.internal.q.b(p1.N(), v18)) {
                            A7.d.q(v18, p1, v18, h2);
                        }
                        androidx.compose.runtime.w.x(p1, q4, P0.j.d);
                        b b0 = new b(0.0f, 7.0f, 5);
                        b0.e = c.e(0xAEC2EB8C, p1, new Qc.d(v17, f0));
                        b0.f = c.e(0x9EADC7AB, p1, new ud.r(f0, 2));
                        M.c.d(p1, androidx.compose.foundation.layout.d.h(n0, 15.0f));
                        b0.a().invoke(p1, 0);
                        M.c.d(p1, androidx.compose.foundation.layout.d.h(n0, 12.0f));
                        p1.p(true);
                    }
                    else {
                        V v19 = k.a;
                        if(k42 instanceof u) {
                            p1.a0(0x80C06B8E);
                            boolean z9 = ((Qc.i)this.h).b;
                            q q5 = androidx.compose.foundation.layout.a.n(n0, 20.0f, 15.0f, 0.0f, 0.0f, 12);
                            M m1 = M.p.d(d.a, false);
                            int v20_1 = p1.P;
                            i0 i02 = p1.m();
                            q q6 = r0.a.d(p1, q5);
                            P0.k.y.getClass();
                            i i3 = P0.j.b;
                            p1.e0();
                            if(p1.O) {
                                p1.l(i3);
                            }
                            else {
                                p1.o0();
                            }
                            androidx.compose.runtime.w.x(p1, m1, P0.j.f);
                            androidx.compose.runtime.w.x(p1, i02, P0.j.e);
                            P0.h h3 = P0.j.g;
                            if(p1.O || !kotlin.jvm.internal.q.b(p1.N(), v20_1)) {
                                A7.d.q(v20_1, p1, v20_1, h3);
                            }
                            androidx.compose.runtime.w.x(p1, q6, P0.j.d);
                            b0 b00 = androidx.compose.runtime.w.s(Boolean.valueOf(z9));
                            boolean z10 = p1.i(f0);
                            e e0 = p1.N();
                            if(z10 || e0 == v19) {
                                e0 = new e(1, f0);
                                p1.l0(e0);
                            }
                            x1.a.e(b00, e0, p1, 0);
                            p1.p(true);
                        }
                        else if(k42 instanceof v) {
                            p1.a0(0x80C93EEC);
                            boolean z11 = p1.i(f0);
                            boolean z12 = p1.i(k42);
                            W0 w00 = p1.N();
                            if(z11 || z12 || w00 == v19) {
                                w00 = new W0(4, f0, ((v)k42));
                                p1.l0(w00);
                            }
                            f0.p(((v)k42), w00, p1, 0);
                        }
                        else {
                            p1.a0(0x801C3ED2);
                        }
                    }
                    p1.p(false);
                    p1.p(false);
                    return ie.H.a;
                }
                p1.T();
                return ie.H.a;
            }
            case 4: {
                int v21 = ((Number)object1).intValue();
                int v22 = ((Number)object3).intValue();
                we.k k0 = (we.k)this.i;
                b0 b01 = (b0)this.h;
                int v23 = (v22 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v22 : v22;
                if((v22 & 0x30) == 0) {
                    v23 |= (((androidx.compose.runtime.p)(((l)object2))).e(v21) ? 0x20 : 16);
                }
                boolean z13 = true;
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v23 & 1, (v23 & 0x93) != 0x92)) {
                    String s4 = (String)this.g.get(v21);
                    ((androidx.compose.runtime.p)(((l)object2))).a0(0xE887DF78);
                    boolean z14 = v21 == ((Number)b01.getValue()).intValue();
                    if(((v23 & 0x70 ^ 0x30) <= 0x20 || !((androidx.compose.runtime.p)(((l)object2))).e(v21)) && (v23 & 0x30) != 0x20) {
                        z13 = false;
                    }
                    boolean z15 = ((androidx.compose.runtime.p)(((l)object2))).g(k0);
                    o0 o00 = ((androidx.compose.runtime.p)(((l)object2))).N();
                    if(z15 || z13 || o00 == k.a) {
                        o00 = new o0(b01, v21, k0, 2);
                        ((androidx.compose.runtime.p)(((l)object2))).l0(o00);
                    }
                    U8.p.d(s4, z14, o00, ((androidx.compose.runtime.p)(((l)object2))), 0);
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    return ie.H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return ie.H.a;
            }
            case 5: {
                int v24 = ((Number)object1).intValue();
                int v25 = ((Number)object3).intValue();
                int v26 = (v25 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v25 : v25;
                if((v25 & 0x30) == 0) {
                    v26 |= (((androidx.compose.runtime.p)(((l)object2))).e(v24) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v26 & 1, (v26 & 0x93) != 0x92)) {
                    Object object4 = this.g.get(v24);
                    ((androidx.compose.runtime.p)(((l)object2))).a0(462840338);
                    ((Uc.j.a)this.h).p(((K4)object4), v24, ((b0)this.i), ((androidx.compose.runtime.p)(((l)object2))), 0x180 | v26 & 0x70);
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    return ie.H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return ie.H.a;
            }
            case 6: {
                g g0 = (g)this.i;
                int v27 = ((Number)object1).intValue();
                int v28 = ((Number)object3).intValue();
                int v29 = (v28 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v28 : v28;
                if((v28 & 0x30) == 0) {
                    v29 |= (((androidx.compose.runtime.p)(((l)object2))).e(v27) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v29 & 1, (v29 & 0x93) != 0x92)) {
                    Object object5 = this.g.get(v27);
                    ((androidx.compose.runtime.p)(((l)object2))).a0(0x350546F5);
                    if(((CAST)object5) == null) {
                        ((androidx.compose.runtime.p)(((l)object2))).p(false);
                        return ie.H.a;
                    }
                    int v30 = ((List)this.h).size();
                    boolean z16 = ((androidx.compose.runtime.p)(((l)object2))).i(g0);
                    Object object6 = ((androidx.compose.runtime.p)(((l)object2))).N();
                    if(!z16 && object6 != k.a) {
                        g1 = g0;
                        h4 = object6;
                    }
                    else {
                        g1 = g0;
                        h4 = new H(1, g1, g.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 27);
                        ((androidx.compose.runtime.p)(((l)object2))).l0(h4);
                    }
                    g1.o(((CAST)object5), v27, v30, h4, ((androidx.compose.runtime.p)(((l)object2))), v29 & 0x70);
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    return ie.H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return ie.H.a;
            }
            case 7: {
                int v31 = ((Number)object1).intValue();
                int v32 = ((Number)object3).intValue();
                int v33 = (v32 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v32 : v32;
                if((v32 & 0x30) == 0) {
                    v33 |= (((androidx.compose.runtime.p)(((l)object2))).e(v31) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v33 & 1, (v33 & 0x93) != 0x92)) {
                    d2 d20 = (d2)this.g.get(v31);
                    ((androidx.compose.runtime.p)(((l)object2))).a0(0x9DAC933E);
                    int v34 = ((K0)this.i).m();
                    CONTENTS mainMusicRes$RESPONSE$TAG$CONTENTS0 = (CONTENTS)((n2)this.h).b.get(v34);
                    if(mainMusicRes$RESPONSE$TAG$CONTENTS0 == null) {
                        s5 = "";
                    }
                    else {
                        s5 = mainMusicRes$RESPONSE$TAG$CONTENTS0.getTagName();
                        if(s5 == null) {
                            s5 = "";
                        }
                    }
                    m2.a(d20, s5, ((androidx.compose.runtime.p)(((l)object2))), 0);
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    return ie.H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return ie.H.a;
            }
            case 8: {
                int v35 = ((Number)object1).intValue();
                int v36 = ((Number)object3).intValue();
                int v37 = (v36 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v36 : v36;
                if((v36 & 0x30) == 0) {
                    v37 |= (((androidx.compose.runtime.p)(((l)object2))).e(v35) ? 0x20 : 16);
                }
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v37 & 1, (v37 & 0x93) != 0x92)) {
                    Object object7 = this.g.get(v35);
                    ((androidx.compose.runtime.p)(((l)object2))).a0(0xD70CCA47);
                    e1.b.f(v35 == 0, v35 == ((u6)this.h).g.size() - 1, ((r6)object7), ((we.k)this.i), ((androidx.compose.runtime.p)(((l)object2))), 0);
                    ((androidx.compose.runtime.p)(((l)object2))).p(false);
                    return ie.H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return ie.H.a;
            }
            case 9: {
                int v38 = ((Number)object1).intValue();
                int v39 = ((Number)object3).intValue();
                int v40 = (v39 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v39 : v39;
                if((v39 & 0x30) == 0) {
                    v40 |= (((androidx.compose.runtime.p)(((l)object2))).e(v38) ? 0x20 : 16);
                }
                androidx.compose.runtime.p p2 = (androidx.compose.runtime.p)(((l)object2));
                if(p2.Q(v40 & 1, (v40 & 0x93) != 0x92)) {
                    Object object8 = this.g.get(v38);
                    p2.a0(0x505E4CFC);
                    n n1 = n.a;
                    q q7 = androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.q(n1, 275.0f), 3);
                    y y1 = w.a(j.c, d.m, p2, 0);
                    int v41 = p2.P;
                    i0 i03 = p2.m();
                    q q8 = r0.a.d(p2, q7);
                    P0.k.y.getClass();
                    i i4 = P0.j.b;
                    p2.e0();
                    if(p2.O) {
                        p2.l(i4);
                    }
                    else {
                        p2.o0();
                    }
                    P0.h h5 = P0.j.f;
                    androidx.compose.runtime.w.x(p2, y1, h5);
                    P0.h h6 = P0.j.e;
                    androidx.compose.runtime.w.x(p2, i03, h6);
                    P0.h h7 = P0.j.g;
                    if(p2.O || !kotlin.jvm.internal.q.b(p2.N(), v41)) {
                        A7.d.q(v41, p2, v41, h7);
                    }
                    P0.h h8 = P0.j.d;
                    androidx.compose.runtime.w.x(p2, q8, h8);
                    M.c.d(p2, androidx.compose.foundation.layout.d.h(n1, 9.0f));
                    String s6 = ((CARD)object8).date;
                    kotlin.jvm.internal.q.f(s6, "date");
                    N1.b(s6, null, e0.T(p2, 0x7F06017C), 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p2, 0xC00, 0, 0x1FFF2);  // color:green500s_support_high_contrast
                    M.c.d(p2, androidx.compose.foundation.layout.d.h(n1, 9.0f));
                    q q9 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n1, 275.0f), 419.0f);
                    M m2 = M.p.d(d.a, false);
                    int v42 = p2.P;
                    i0 i04 = p2.m();
                    q q10 = r0.a.d(p2, q9);
                    p2.e0();
                    if(p2.O) {
                        p2.l(i4);
                    }
                    else {
                        p2.o0();
                    }
                    androidx.compose.runtime.w.x(p2, m2, h5);
                    androidx.compose.runtime.w.x(p2, i04, h6);
                    if(p2.O || !kotlin.jvm.internal.q.b(p2.N(), v42)) {
                        A7.d.q(v42, p2, v42, h7);
                    }
                    androidx.compose.runtime.w.x(p2, q10, h8);
                    m0.b b1 = c.e(0xC80C4302, p2, new hd.v(((CARD)object8), v38, ((we.k)this.i)));
                    we.a a0 = hd.a.a(((Context)this.h), b1, p2);
                    hd.H.h(((CARD)object8), v38, 1.0f, ((we.k)this.i), a0, p2, 0x180 | v40 & 0x70);
                    A7.d.s(p2, true, true, false);
                    return ie.H.a;
                }
                p2.T();
                return ie.H.a;
            }
            default: {
                int v = ((Number)object1).intValue();
                int v1 = ((Number)object3).intValue();
                Ec.i i0 = (Ec.i)this.h;
                int v2 = (v1 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v1 : v1;
                if((v1 & 0x30) == 0) {
                    v2 |= (((androidx.compose.runtime.p)(((l)object2))).e(v) ? 0x20 : 16);
                }
                androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)(((l)object2));
                if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
                    ContentsInfo streamGetSongInfoRes$RESPONSE$ContentsInfo0 = (ContentsInfo)this.g.get(v);
                    p0.a0(0xFB80516E);
                    Integer integer0 = i0.a();
                    q q0 = r0.a.e(n.a, (integer0 == null || v != ((int)integer0) ? 0.0f : 1.0f));
                    boolean z = p0.g(i0);
                    boolean z1 = (v2 & 0x70 ^ 0x30) > 0x20 && p0.e(v) || (v2 & 0x30) == 0x20;
                    D1 d10 = p0.N();
                    if(z1 || z || d10 == k.a) {
                        d10 = new D1(i0, v, 0);
                        p0.l0(d10);
                    }
                    q q1 = androidx.compose.ui.graphics.a.a(q0, d10);
                    M m0 = M.p.d(d.a, false);
                    int v3 = p0.P;
                    i0 i00 = p0.m();
                    q q2 = r0.a.d(p0, q1);
                    P0.k.y.getClass();
                    i i1 = P0.j.b;
                    p0.e0();
                    if(p0.O) {
                        p0.l(i1);
                    }
                    else {
                        p0.o0();
                    }
                    androidx.compose.runtime.w.x(p0, m0, P0.j.f);
                    androidx.compose.runtime.w.x(p0, i00, P0.j.e);
                    P0.h h0 = P0.j.g;
                    if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                        A7.d.q(v3, p0, v3, h0);
                    }
                    androidx.compose.runtime.w.x(p0, q2, P0.j.d);
                    ((F1)this.i).t(v, streamGetSongInfoRes$RESPONSE$ContentsInfo0, i0, p0, (v2 & 0x7E) >> 3 & 14);
                    p0.p(true);
                    p0.p(false);
                    return ie.H.a;
                }
                p0.T();
                return ie.H.a;
            }
        }
    }
}

