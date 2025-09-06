package Ac;

import Cc.N1;
import Cc.c1;
import Cc.e0;
import De.I;
import H0.b;
import Ld.B;
import Ld.J;
import M.Q;
import M.c;
import M.g;
import M.j0;
import M.n0;
import M.p0;
import M.v;
import M.y;
import N0.M;
import P.F;
import P0.h;
import P0.i;
import P0.j;
import P0.k;
import T.e;
import U8.r;
import V4.u;
import Yc.m;
import Zc.T;
import Zc.X;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.a;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import bd.s;
import cd.L1;
import cd.Q1;
import cd.W;
import cd.a0;
import cd.c0;
import com.iloen.melon.fragments.shortform.TrendMusicWaveExclusiveFragmentKt;
import com.iloen.melon.net.v4x.common.BannerBase;
import com.iloen.melon.net.v4x.common.HeaderBase;
import com.iloen.melon.net.v5x.response.FlexibleRes.LiveStatusCode;
import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible.Content;
import com.iloen.melon.net.v6x.response.MyMusicInformStorageRes.RESPONSE.RECNTSONGINFO;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.K4;
import f1.x;
import ie.H;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.sync.MutexImpl;
import r0.d;
import r0.n;
import r1.f;
import we.o;
import xc.z;

public final class a4 implements o {
    public final int a;
    public final Object b;
    public final Object c;

    public a4(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        String s6;
        HeaderBase headerBase1;
        p p3;
        int v11;
        p p1;
        String s2;
        n n1;
        Q q3;
        switch(this.a) {
            case 0: {
                b0 b00 = (b0)this.b;
                l4 l40 = (l4)this.c;
                int v1 = (int)(((Integer)object2));
                q.g(((we.n)object0), "innerTextField");
                if((v1 & 6) == 0) {
                    v1 |= (((p)(((l)object1))).i(((we.n)object0)) ? 4 : 2);
                }
                p p0 = (p)(((l)object1));
                if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
                    r0.q q0 = a.n(a.l(n.a, 20.0f, 0.0f, 2), 0.0f, 16.0f, 0.0f, 0.0f, 13);
                    M m0 = M.p.d(d.a, false);
                    int v2 = p0.P;
                    i0 i00 = p0.m();
                    r0.q q1 = r0.a.d(p0, q0);
                    k.y.getClass();
                    i i0 = j.b;
                    p0.e0();
                    if(p0.O) {
                        p0.l(i0);
                    }
                    else {
                        p0.o0();
                    }
                    w.x(p0, m0, j.f);
                    w.x(p0, i00, j.e);
                    h h2 = j.g;
                    if(p0.O || !q.b(p0.N(), v2)) {
                        A7.d.q(v2, p0, v2, h2);
                    }
                    w.x(p0, q1, j.d);
                    if(((x)b00.getValue()).a.b.length() == 0) {
                        p0.a0(0x93CB0741);
                        long v3 = e0.T(p0, 0x7F060159);  // color:gray400s_support_high_contrast
                        N1.b(l40.b, null, v3, 0.0f, null, null, 0L, null, 22.0f, 0, false, 0, 0, null, null, p0, 0, 6, 0x1FBFA);
                    }
                    else {
                        p0.a0(0x92DF68A4);
                    }
                    p0.p(false);
                    ((we.n)object0).invoke(p0, ((int)(v1 & 14)));
                    p0.p(true);
                    return H.a;
                }
                p0.T();
                return H.a;
            }
            case 1: {
                String s = (String)this.b;
                String s1 = (String)this.c;
                int v4 = (int)(((Integer)object2));
                q.g(((Q)object0), "$this$FlowRow");
                if((v4 & 6) == 0) {
                    v4 |= (((p)(((l)object1))).g(((Q)object0)) ? 4 : 2);
                }
                if(((p)(((l)object1))).Q(v4 & 1, (v4 & 19) != 18)) {
                    n n0 = n.a;
                    if(s.length() > 0) {
                        ((p)(((l)object1))).a0(0x45BBFFF8);
                        long v5 = ye.a.v(((p)(((l)object1))), 0x7F060165);  // color:gray800s
                        r0.q q2 = a.n(n0, 0.0f, 0.0f, 0.0f, 2.0f, 7);
                        q3 = (Q)object0;
                        n1 = n0;
                        s2 = s1;
                        N1.b(s, q2, v5, 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, ((p)(((l)object1))), 0xC30, 0, 0x1FFF0);
                        p1 = (p)(((l)object1));
                    }
                    else {
                        s2 = s1;
                        q3 = (Q)object0;
                        p1 = (p)(((l)object1));
                        n1 = n0;
                        p1.a0(0x45973BD6);
                    }
                    p1.p(false);
                    if(s.length() <= 0 || s2.length() <= 0) {
                        p1.a0(0x45973BD6);
                    }
                    else {
                        p1.a0(1170375069);
                        r0.q q4 = androidx.compose.foundation.q.f(androidx.compose.foundation.layout.d.n(n1, 2.0f), e0.T(p1, 0x7F060154), e.a);  // color:gray200s_support_high_contrast
                        q3.getClass();
                        M.p.a(b.r(d.k, q4), p1, 0);
                    }
                    p1.p(false);
                    if(s2.length() > 0) {
                        p1.a0(1170857305);
                        long v6 = ye.a.v(p1, 0x7F060165);  // color:gray800s
                        N1.b(s2, a.n(n1, 0.0f, 0.0f, 0.0f, 2.0f, 7), v6, 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p1, 0xC30, 0, 0x1FFF0);
                    }
                    else {
                        p1.a0(0x45973BD6);
                    }
                    p1.p(false);
                    return H.a;
                }
                ((p)(((l)object1))).T();
                return H.a;
            }
            case 2: {
                Ld.i i1 = (Ld.i)this.b;
                K4 k40 = (K4)this.c;
                int v7 = (int)(((Integer)object2));
                q.g(((androidx.compose.foundation.lazy.a)object0), "$this$item");
                if(((p)(((l)object1))).Q(v7 & 1, (v7 & 17) != 16)) {
                    i1.o(((p)(((l)object1))), 0);
                    BannerBase bannerBase0 = ((B)k40).b;
                    if(bannerBase0 == null) {
                        ((p)(((l)object1))).a0(2057598908);
                    }
                    else {
                        ((p)(((l)object1))).a0(2057598909);
                        boolean z = ((p)(((l)object1))).i(bannerBase0);
                        Ld.d d0 = ((p)(((l)object1))).N();
                        if(z || d0 == androidx.compose.runtime.k.a) {
                            d0 = new Ld.d(bannerBase0, 0);
                            ((p)(((l)object1))).l0(d0);
                        }
                        i1.m(bannerBase0, d0, ((p)(((l)object1))), 0);
                        ((J)i1.getViewModel()).d(bannerBase0);
                    }
                    ((p)(((l)object1))).p(false);
                    c.d(((p)(((l)object1))), androidx.compose.foundation.layout.d.h(n.a, 40.0f));
                    i1.r(((B)k40).a, ((p)(((l)object1))), 0);
                    c.d(((p)(((l)object1))), androidx.compose.foundation.layout.d.h(n.a, 40.0f));
                    i1.p(((p)(((l)object1))), 0);
                    c.d(((p)(((l)object1))), androidx.compose.foundation.layout.d.h(n.a, 160.0f));
                    return H.a;
                }
                ((p)(((l)object1))).T();
                return H.a;
            }
            case 3: {
                Ld.i i2 = (Ld.i)this.b;
                BannerBase bannerBase1 = (BannerBase)this.c;
                int v8 = (int)(((Integer)object2));
                q.g(((androidx.compose.foundation.lazy.a)object0), "$this$item");
                if(((p)(((l)object1))).Q(v8 & 1, (v8 & 17) != 16)) {
                    boolean z1 = ((p)(((l)object1))).i(bannerBase1);
                    Ld.d d1 = ((p)(((l)object1))).N();
                    if(z1 || d1 == androidx.compose.runtime.k.a) {
                        d1 = new Ld.d(bannerBase1, 1);
                        ((p)(((l)object1))).l0(d1);
                    }
                    i2.m(bannerBase1, d1, ((p)(((l)object1))), 0);
                    ((J)i2.getViewModel()).d(bannerBase1);
                    return H.a;
                }
                ((p)(((l)object1))).T();
                return H.a;
            }
            case 4: {
                U8.l l0 = (U8.l)this.b;
                r r0 = (r)this.c;
                int v9 = (int)(((Integer)object2));
                q.g(((v)object0), "$this$BoxWithConstraints");
                if((v9 & 6) == 0) {
                    v9 |= (((p)(((l)object1))).g(((v)object0)) ? 4 : 2);
                }
                p p2 = (p)(((l)object1));
                if(p2.Q(v9 & 1, (v9 & 19) != 18)) {
                    float f = ((androidx.compose.foundation.layout.c)(((v)object0))).b();
                    String s3 = androidx.appcompat.app.o.o("maxHeight: ", f.b(f), ", criteriaHeight: ", "249.0.dp");
                    LogU.debug$default(l0.e, s3, null, false, 6, null);
                    n n2 = n.a;
                    r0.q q5 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n2, 290.0f), 190.0f);
                    r0.q q6 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q5, d.e);
                    y y0 = M.w.a(M.j.e, d.m, p2, 6);
                    int v10 = p2.P;
                    i0 i01 = p2.m();
                    r0.q q7 = r0.a.d(p2, q6);
                    k.y.getClass();
                    i i3 = j.b;
                    p2.e0();
                    if(p2.O) {
                        p2.l(i3);
                    }
                    else {
                        p2.o0();
                    }
                    w.x(p2, y0, j.f);
                    w.x(p2, i01, j.e);
                    h h3 = j.g;
                    if(p2.O || !q.b(p2.N(), v10)) {
                        A7.d.q(v10, p2, v10, h3);
                    }
                    w.x(p2, q7, j.d);
                    if(Float.compare(f, 249.0f) > 0) {
                        p2.a0(791024520);
                        if(r0.c) {
                            v11 = 0x7F080635;  // drawable:img_eq_wave_01
                        }
                        else {
                            v11 = r0.d ? 0x7F080636 : 0x7F080637;  // drawable:img_eq_wave_02
                        }
                        r0.q q8 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n2, 1.0f), 80.0f);
                        androidx.compose.foundation.q.c(I.Q(v11, p2, 0), l0.getString(0x7F130B50), q8, null, null, 0.0f, null, p2, 0x180, 120);  // string:talkback_image "이미지"
                        p3 = p2;
                        A7.d.v(n2, 26.0f, p3, false);
                    }
                    else {
                        p3 = p2;
                        p3.a0(773067243);
                        p3.p(false);
                    }
                    r0.q q9 = androidx.compose.foundation.layout.d.f(n2, 1.0f);
                    r0.q q10 = b.q(d.n, q9);
                    N1.b(H0.e.Y(p3, 0x7F130396), q10, e0.T(p3, 0x7F06016D), 15.0f, null, null, 0L, new l1.k(3), 22.0f, 2, false, 2, 0, null, null, p3, 0xC00, 0xC36, 0x1D1F0);  // string:eq_ai_desc "AI 기술을 활용해 곡의 정보를 분석하여 자동으로 음향효과를 적용합니다."
                    c.d(p3, androidx.compose.foundation.layout.d.h(n2, 26.0f));
                    r0.q q11 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n2, 120.0f), 14.0f);
                    r0.q q12 = b.q(d.n, q11);
                    C0.c c0 = I.Q(0x7F080647, p3, 6);  // drawable:img_logo_gaudio
                    y0.k k0 = new y0.k(e0.T(p3, 0x7F060156), 5);  // color:gray300s
                    androidx.compose.foundation.q.c(c0, l0.getString(0x7F130B50), q12, null, null, 0.0f, k0, p3, 0, 56);  // string:talkback_image "이미지"
                    p3.p(true);
                    return H.a;
                }
                p2.T();
                return H.a;
            }
            case 5: {
                return BufferedChannel.c(((we.k)this.b), this.c, ((Throwable)object0), object1, ((me.i)object2));
            }
            case 6: {
                RECNTSONGINFO myMusicInformStorageRes$RESPONSE$RECNTSONGINFO0 = (RECNTSONGINFO)this.b;
                we.k k1 = (we.k)this.c;
                int v12 = (int)(((Integer)object2));
                q.g(((androidx.compose.foundation.lazy.a)object0), "$this$item");
                if(((p)(((l)object1))).Q(v12 & 1, (v12 & 17) != 16)) {
                    m.c(myMusicInformStorageRes$RESPONSE$RECNTSONGINFO0, k1, ((p)(((l)object1))), 0);
                    return H.a;
                }
                ((p)(((l)object1))).T();
                return H.a;
            }
            case 7: {
                X x0 = (X)this.b;
                we.k k2 = (we.k)this.c;
                int v13 = (int)(((Integer)object2));
                q.g(((v)object0), "$this$BoxWithConstraints");
                if((v13 & 6) == 0) {
                    v13 |= (((p)(((l)object1))).g(((v)object0)) ? 4 : 2);
                }
                p p4 = (p)(((l)object1));
                if(p4.Q(v13 & 1, (v13 & 19) != 18)) {
                    int v14 = Float.compare(((androidx.compose.foundation.layout.c)(((v)object0))).c(), 260.0f) <= 0 ? 5 : 28;
                    p0 p00 = n0.a(M.j.a, d.j, p4, 0);
                    int v15 = p4.P;
                    i0 i02 = p4.m();
                    n n3 = n.a;
                    r0.q q13 = r0.a.d(p4, n3);
                    k.y.getClass();
                    i i4 = j.b;
                    p4.e0();
                    if(p4.O) {
                        p4.l(i4);
                    }
                    else {
                        p4.o0();
                    }
                    w.x(p4, p00, j.f);
                    w.x(p4, i02, j.e);
                    h h4 = j.g;
                    if(p4.O || !q.b(p4.N(), v15)) {
                        A7.d.q(v15, p4, v15, h4);
                    }
                    w.x(p4, q13, j.d);
                    p4.a0(0xB3BA8FC0);
                    int v16 = 0;
                    for(Object object3: x0.b) {
                        if(v16 >= 0) {
                            Zc.h.a(((T)object3), k2, p4, 0);
                            if(v16 == x0.b.size() - 1) {
                                p4.a0(0x961E862B);
                            }
                            else {
                                p4.a0(0x97036F6E);
                                c.d(p4, androidx.compose.foundation.layout.d.q(n3, ((float)v14)));
                            }
                            p4.p(false);
                            ++v16;
                            continue;
                        }
                        e.k.O();
                        throw null;
                    }
                    p4.p(false);
                    p4.p(true);
                    return H.a;
                }
                p4.T();
                return H.a;
            }
            case 8: {
                return MutexImpl.b(((MutexImpl)this.b), this.c, ((Throwable)object0), object1, ((me.i)object2));
            }
            case 9: {
                c0 c00 = (c0)this.b;
                Content flexibleRes$RESPONSE$Flexible$Content0 = (Content)this.c;
                int v17 = (int)(((Integer)object2));
                q.g(((v)object0), "$this$BoxWithConstraints");
                if((v17 & 6) == 0) {
                    v17 |= (((p)(((l)object1))).g(((v)object0)) ? 4 : 2);
                }
                p p5 = (p)(((l)object1));
                if(p5.Q(v17 & 1, (v17 & 19) != 18)) {
                    float f1 = ((androidx.compose.foundation.layout.c)(((v)object0))).c();
                    float f2 = 9.0f * f1 / 16.0f;
                    n n4 = n.a;
                    r0.q q14 = androidx.compose.foundation.layout.d.f(n4, 1.0f);
                    y y1 = M.w.a(M.j.c, d.m, p5, 0);
                    int v18 = p5.P;
                    i0 i03 = p5.m();
                    r0.q q15 = r0.a.d(p5, q14);
                    k.y.getClass();
                    i i5 = j.b;
                    p5.e0();
                    if(p5.O) {
                        p5.l(i5);
                    }
                    else {
                        p5.o0();
                    }
                    h h5 = j.f;
                    w.x(p5, y1, h5);
                    h h6 = j.e;
                    w.x(p5, i03, h6);
                    h h7 = j.g;
                    if(p5.O || !q.b(p5.N(), v18)) {
                        A7.d.q(v18, p5, v18, h7);
                    }
                    h h8 = j.d;
                    w.x(p5, q15, h8);
                    s s4 = c00.a;
                    V v19 = androidx.compose.runtime.k.a;
                    if(s4 == null) {
                        p5.a0(0xCFBF863);
                    }
                    else {
                        p5.a0(0xCFBF864);
                        HeaderBase headerBase0 = s4.a;
                        boolean z2 = p5.i(s4);
                        W w0 = p5.N();
                        if(z2 || w0 == v19) {
                            headerBase1 = headerBase0;
                            w0 = new W(s4, 2);
                            p5.l0(w0);
                        }
                        else {
                            headerBase1 = headerBase0;
                        }
                        boolean z3 = p5.i(s4);
                        W w1 = p5.N();
                        if(z3 || w1 == v19) {
                            w1 = new W(s4, 3);
                            p5.l0(w1);
                        }
                        com.google.firebase.b.j(new s(headerBase1, w0, w1, null, 0x4FE), p5, 0);
                    }
                    p5.p(false);
                    r0.q q16 = e0.L(a.k(androidx.compose.foundation.layout.d.o(n4, f1, f2), 20.0f, 3.0f), 0x7F0604AE);  // color:white120e
                    M m1 = M.p.d(d.a, false);
                    int v20 = p5.P;
                    i0 i04 = p5.m();
                    r0.q q17 = r0.a.d(p5, q16);
                    p5.e0();
                    if(p5.O) {
                        p5.l(i5);
                    }
                    else {
                        p5.o0();
                    }
                    w.x(p5, m1, h5);
                    w.x(p5, i04, h6);
                    if(p5.O || !q.b(p5.N(), v20)) {
                        A7.d.q(v20, p5, v20, h7);
                    }
                    w.x(p5, q17, h8);
                    if(MelonSettingInfo.isLowMemoryMode()) {
                        s6 = "";
                    }
                    else {
                        String s5 = flexibleRes$RESPONSE$Flexible$Content0.getPreviewUrl();
                        s6 = s5 == null ? "" : s5;
                    }
                    String s7 = flexibleRes$RESPONSE$Flexible$Content0.getImgUrl();
                    String s8 = flexibleRes$RESPONSE$Flexible$Content0.getPreviewMvid() + flexibleRes$RESPONSE$Flexible$Content0.getFileUpdateDate();
                    long v21 = flexibleRes$RESPONSE$Flexible$Content0.getCurrentPosition();
                    boolean z4 = p5.i(c00);
                    b9.a a0 = p5.N();
                    if(z4 || a0 == v19) {
                        a0 = new b9.a(c00, 6);
                        p5.l0(a0);
                    }
                    boolean z5 = p5.i(flexibleRes$RESPONSE$Flexible$Content0);
                    a0 a00 = p5.N();
                    if(z5 || a00 == v19) {
                        a00 = new a0(flexibleRes$RESPONSE$Flexible$Content0, 0);
                        p5.l0(a00);
                    }
                    u.b(s6, s7, f1, f2, s8, v21, a0, a00, p5, 0);
                    c1.n(a.j(n4, 10.0f), ((int)(LiveStatusCode.LIVE == flexibleRes$RESPONSE$Flexible$Content0.getLiveStatusCode() ? 0x7F0805AC : 0x7F0804A3)), null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p5, 6, 0, 0x7FFC);  // drawable:ic_player_live
                    p5.p(true);
                    String s9 = flexibleRes$RESPONSE$Flexible$Content0.getTitle();
                    if(s9 != null && s9.length() != 0) {
                        p5.a0(0xD18CF3C);
                        String s10 = flexibleRes$RESPONSE$Flexible$Content0.getTitle();
                        N1.b((s10 == null ? "" : s10), a.l(U4.x.s(n4, 6.0f, p5, n4, 1.0f), 20.0f, 0.0f, 2), 0L, 17.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p5, 0xC30, 0xC30, 120820);
                    }
                    else {
                        p5.a0(0xCE0E68F);
                    }
                    p5.p(false);
                    p5.p(true);
                    return H.a;
                }
                p5.T();
                return H.a;
            }
            case 10: {
                Q1 q10_1 = (Q1)this.b;
                F f3 = (F)this.c;
                int v22 = (int)(((Integer)object2));
                q.g(((v)object0), "$this$BoxWithConstraints");
                if((v22 & 6) == 0) {
                    v22 |= (((p)(((l)object1))).g(((v)object0)) ? 4 : 2);
                }
                boolean z6 = false;
                int v23 = 3;
                if(((p)(((l)object1))).Q(v22 & 1, (v22 & 19) != 18)) {
                    if(q10_1.b.size() > 3) {
                        z6 = true;
                    }
                    else {
                        v23 = q10_1.b.size();
                    }
                    float f4 = z6 ? 292.0f : ((androidx.compose.foundation.layout.c)(((v)object0))).c();
                    r0.q q18 = androidx.compose.foundation.layout.d.h(n.a, ((float)v23) * 78.0f);
                    j0 j00 = a.a(20.0f, 0.0f, 2);
                    g g0 = M.j.h(20.0f);
                    P.a a1 = new P.a(v23);
                    boolean z7 = ((p)(((l)object1))).i(q10_1);
                    boolean z8 = ((p)(((l)object1))).d(f4);
                    L1 l10 = ((p)(((l)object1))).N();
                    if(z7 || z8 || l10 == androidx.compose.runtime.k.a) {
                        l10 = new L1(q10_1, f4, 78.0f);
                        ((p)(((l)object1))).l0(l10);
                    }
                    E9.h.h(a1, q18, f3, j00, g0, null, null, false, null, l10, ((p)(((l)object1))), 0x30C00, 0, 0x3D0);
                    return H.a;
                }
                ((p)(((l)object1))).T();
                return H.a;
            }
            case 11: {
                return TrendMusicWaveExclusiveFragmentKt.AutoSwitchingImage_WPi__2c$lambda$5(((r0.q)this.b), ((ArrayList)this.c), ((int)(((Integer)object0))), ((l)object1), ((int)(((Integer)object2))));
            }
            case 12: {
                kotlin.jvm.internal.H h9 = (kotlin.jvm.internal.H)this.b;
                xc.k k3 = (xc.k)this.c;
                int v24 = (int)(((Integer)object2));
                q.g(((androidx.compose.foundation.lazy.a)object0), "$this$item");
                if(((p)(((l)object1))).Q(v24 & 1, (v24 & 17) != 16)) {
                    Jc.B b1 = (Jc.B)h9.a;
                    if(b1 == null) {
                        ((p)(((l)object1))).a0(-636050063);
                    }
                    else {
                        ((p)(((l)object1))).a0(-636050062);
                        k3.s(b1, ((p)(((l)object1))), 0);
                    }
                    ((p)(((l)object1))).p(false);
                    return H.a;
                }
                ((p)(((l)object1))).T();
                return H.a;
            }
            case 13: {
                kotlin.jvm.internal.H h10 = (kotlin.jvm.internal.H)this.b;
                xc.s s11 = (xc.s)this.c;
                int v25 = (int)(((Integer)object2));
                q.g(((androidx.compose.foundation.lazy.a)object0), "$this$item");
                if(((p)(((l)object1))).Q(v25 & 1, (v25 & 17) != 16)) {
                    Jc.B b2 = (Jc.B)h10.a;
                    if(b2 == null) {
                        ((p)(((l)object1))).a0(0xB78EEEF1);
                    }
                    else {
                        ((p)(((l)object1))).a0(0xB78EEEF2);
                        s11.v(b2, ((p)(((l)object1))), 0);
                    }
                    ((p)(((l)object1))).p(false);
                    return H.a;
                }
                ((p)(((l)object1))).T();
                return H.a;
            }
            case 14: {
                kotlin.jvm.internal.H h11 = (kotlin.jvm.internal.H)this.b;
                z z9 = (z)this.c;
                int v26 = (int)(((Integer)object2));
                q.g(((androidx.compose.foundation.lazy.a)object0), "$this$item");
                if(((p)(((l)object1))).Q(v26 & 1, (v26 & 17) != 16)) {
                    Jc.B b3 = (Jc.B)h11.a;
                    if(b3 == null) {
                        ((p)(((l)object1))).a0(0x610D869D);
                    }
                    else {
                        ((p)(((l)object1))).a0(0x610D869E);
                        z9.t(b3, ((p)(((l)object1))), 0);
                    }
                    ((p)(((l)object1))).p(false);
                    return H.a;
                }
                ((p)(((l)object1))).T();
                return H.a;
            }
            default: {
                kotlin.jvm.internal.H h0 = (kotlin.jvm.internal.H)this.b;
                xc.H h1 = (xc.H)this.c;
                int v = (int)(((Integer)object2));
                q.g(((androidx.compose.foundation.lazy.a)object0), "$this$item");
                if(((p)(((l)object1))).Q(v & 1, (v & 17) != 16)) {
                    Jc.B b0 = (Jc.B)h0.a;
                    if(b0 == null) {
                        ((p)(((l)object1))).a0(0x8A2794B7);
                    }
                    else {
                        ((p)(((l)object1))).a0(0x8A2794B8);
                        h1.u(b0, ((p)(((l)object1))), 0);
                    }
                    ((p)(((l)object1))).p(false);
                    return H.a;
                }
                ((p)(((l)object1))).T();
                return H.a;
            }
        }
    }
}

