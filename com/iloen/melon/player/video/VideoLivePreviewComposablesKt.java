package com.iloen.melon.player.video;

import Ac.U0;
import Cc.N1;
import Cc.a0;
import Cc.c1;
import Cc.e0;
import M.c;
import M.j;
import M.n0;
import M.p0;
import M.w;
import M.y;
import P0.h;
import U4.x;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.iloen.melon.net.v6x.common.LiveInfoBase.CARD.BUTTON;
import com.iloen.melon.net.v6x.common.LiveInfoBase.CARD.ITEM;
import com.iloen.melon.net.v6x.common.LiveInfoBase.CARD;
import com.iloen.melon.net.v6x.common.LiveInfoBase;
import com.iloen.melon.utils.color.ColorUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.e;
import r0.d;
import r0.g;
import r0.i;
import r0.n;
import wc.u;
import we.a;
import y0.M;
import y0.s;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A)\u0010\u0005\u001A\u00020\u00032\b\u0010\u0001\u001A\u0004\u0018\u00010\u00002\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001A\u0019\u0010\b\u001A\u00020\u00032\b\u0010\u0001\u001A\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\b\u0010\t\u001A\u001D\u0010\u000B\u001A\u00020\u00032\f\u0010\u0001\u001A\b\u0012\u0004\u0012\u00020\u00070\nH\u0007¢\u0006\u0004\b\u000B\u0010\f\u001A\'\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u0001\u001A\u00020\r2\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/net/v6x/common/LiveInfoBase;", "data", "Lkotlin/Function0;", "Lie/H;", "onButtonClick", "VideoLiveContentsArea", "(Lcom/iloen/melon/net/v6x/common/LiveInfoBase;Lwe/a;Landroidx/compose/runtime/l;II)V", "", "VideoLiveDesc", "(Ljava/lang/String;Landroidx/compose/runtime/l;I)V", "", "VideoLiveItems", "(Ljava/util/List;Landroidx/compose/runtime/l;I)V", "Lcom/iloen/melon/net/v6x/common/LiveInfoBase$CARD;", "VideoLiveCard", "(Lcom/iloen/melon/net/v6x/common/LiveInfoBase$CARD;Lwe/a;Landroidx/compose/runtime/l;II)V", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class VideoLivePreviewComposablesKt {
    public static final void VideoLiveCard(@NotNull CARD liveInfoBase$CARD0, @Nullable a a0, @Nullable l l0, int v, int v1) {
        a a2;
        u u2;
        n n1;
        u u1;
        long v3;
        a a1;
        i i0 = d.e;
        q.g(liveInfoBase$CARD0, "data");
        p p0 = (p)l0;
        p0.c0(0x6ED6E401);
        int v2 = (v & 6) == 0 ? v | (p0.i(liveInfoBase$CARD0) ? 4 : 2) : v;
        if((v1 & 2) != 0) {
            v2 |= 0x30;
        }
        else if((v & 0x30) == 0) {
            v2 |= (p0.i(a0) ? 0x20 : 16);
        }
        if(p0.Q(v2 & 1, (v2 & 19) != 18)) {
            if((v1 & 2) == 0) {
                a1 = a0;
            }
            else {
                e e0 = p0.N();
                if(e0 == k.a) {
                    e0 = new e(24);
                    p0.l0(e0);
                }
                a1 = e0;
            }
            try {
                v3 = M.c(ColorUtils.getColorFromHexStr(liveInfoBase$CARD0.bgColor));
            }
            catch(Exception unused_ex) {
                v3 = s.f;
            }
            n n0 = n.a;
            r0.q q0 = d5.n.o(androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(n0, 1.0f), 3), T.e.b(10.0f));
            u u0 = M.a;
            r0.q q1 = androidx.compose.foundation.q.f(q0, v3, u0);
            g g0 = d.m;
            y y0 = w.a(j.c, g0, p0, 0);
            int v4 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            P0.i i1 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q2, h3);
            c.d(p0, androidx.compose.foundation.layout.d.h(n0, 24.0f));
            r0.q q3 = androidx.compose.foundation.layout.a.l(androidx.compose.foundation.q.f(d5.n.o(androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.v(n0, null, 3), 24.0f), 20.0f, 0.0f, 2), T.e.b(2.0f)), e0.T(p0, 0x7F06015F), u0), 6.0f, 0.0f, 2);  // color:gray600e
            N0.M m0 = M.p.d(i0, false);
            int v5 = p0.P;
            i0 i01 = p0.m();
            r0.q q4 = r0.a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            androidx.compose.runtime.w.x(p0, q4, h3);
            b b0 = (b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false));
            r0.q q5 = b0.a(n0, i0);
            String s = liveInfoBase$CARD0.badge;
            String s1 = "";
            if(s == null) {
                s = "";
            }
            N1.b(s, q5, e0.T(p0, 0x7F0604A1), 14.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 1, 0, null, null, p0, 0x30C00, 0xC00, 0x1DFD0);  // color:white000e
            p0.p(true);
            r0.q q6 = androidx.compose.foundation.layout.a.l(x.s(n0, 12.0f, p0, n0, 1.0f), 20.0f, 0.0f, 2);
            N1.b((liveInfoBase$CARD0.title == null ? "" : liveInfoBase$CARD0.title), q6, e0.T(p0, 0x7F0604A1), 22.0f, e1.y.i, null, 0L, null, 26.0f, 0, false, 0, 0, null, null, p0, 0x30C30, 6, 130000);  // color:white000e
            r0.q q7 = androidx.compose.foundation.layout.a.l(x.s(n0, 10.0f, p0, n0, 1.0f), 20.0f, 0.0f, 2);
            String s2 = liveInfoBase$CARD0.desc;
            if(s2 != null) {
                s1 = s2;
            }
            N1.b(s1, q7, e0.T(p0, 0x7F0604B7), 15.0f, null, null, 0L, null, 18.0f, 0, false, 0, 0, null, null, p0, 0xC30, 6, 0x1FBF0);  // color:white700e
            List list0 = liveInfoBase$CARD0.items;
            if(list0 == null || list0.isEmpty()) {
                u1 = u0;
                p0.a0(0xB91B0277);
                p0.p(false);
            }
            else {
                p0.a0(-1183198903);
                c.d(p0, androidx.compose.foundation.layout.d.h(n0, 20.0f));
                r0.q q8 = androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(n0, 1.0f), 1), 20.0f, 0.0f, 2);
                y y1 = w.a(j.h(4.0f), g0, p0, 6);
                int v6 = p0.P;
                i0 i02 = p0.m();
                r0.q q9 = r0.a.d(p0, q8);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, y1, h0);
                androidx.compose.runtime.w.x(p0, i02, h1);
                if(p0.O || !q.b(p0.N(), v6)) {
                    A7.d.q(v6, p0, v6, h2);
                }
                androidx.compose.runtime.w.x(p0, q9, h3);
                p0.a0(10481208);
                for(Object object0: list0) {
                    r0.q q10 = androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(n0, 1.0f), 3);
                    p0 p00 = n0.a(j.a, d.j, p0, 0);
                    int v7 = p0.P;
                    i0 i03 = p0.m();
                    r0.q q11 = r0.a.d(p0, q10);
                    P0.k.y.getClass();
                    P0.i i2 = P0.j.b;
                    p0.e0();
                    if(p0.O) {
                        p0.l(i2);
                    }
                    else {
                        p0.o0();
                    }
                    h h4 = P0.j.f;
                    androidx.compose.runtime.w.x(p0, p00, h4);
                    h h5 = P0.j.e;
                    androidx.compose.runtime.w.x(p0, i03, h5);
                    h h6 = P0.j.g;
                    if(p0.O || !q.b(p0.N(), v7)) {
                        A7.d.q(v7, p0, v7, h6);
                    }
                    h h7 = P0.j.d;
                    androidx.compose.runtime.w.x(p0, q11, h7);
                    r0.q q12 = androidx.compose.foundation.layout.a.l(androidx.compose.foundation.q.f(d5.n.o(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.v(n0, null, 3), 24.0f), T.e.b(12.0f)), e0.T(p0, 0x7F060153), u0), 9.0f, 0.0f, 2);  // color:gray200e
                    N0.M m1 = M.p.d(i0, false);
                    int v8 = p0.P;
                    i0 i04 = p0.m();
                    r0.q q13 = r0.a.d(p0, q12);
                    p0.e0();
                    if(p0.O) {
                        p0.l(i2);
                    }
                    else {
                        p0.o0();
                    }
                    androidx.compose.runtime.w.x(p0, m1, h4);
                    androidx.compose.runtime.w.x(p0, i04, h5);
                    if(p0.O || !q.b(p0.N(), v8)) {
                        A7.d.q(v8, p0, v8, h6);
                    }
                    androidx.compose.runtime.w.x(p0, q13, h7);
                    r0.q q14 = androidx.compose.foundation.layout.d.v(n0, null, 3);
                    String s3 = ((ITEM)object0).badge;
                    q.f(s3, "badge");
                    N1.b(s3, q14, e0.T(p0, 0x7F0604A1), 13.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 1, 0, null, null, p0, 0x30C30, 0xC00, 0x1DFD0);  // color:white000e
                    p0.p(true);
                    c.d(p0, androidx.compose.foundation.layout.d.q(n0, 12.0f));
                    r0.q q15 = androidx.compose.foundation.layout.a.n(n0, 0.0f, 2.0f, 0.0f, 4.0f, 5);
                    String s4 = ((ITEM)object0).text;
                    q.f(s4, "text");
                    N1.b(s4, q15, e0.T(p0, 0x7F0604A1), 14.0f, null, null, 0L, null, 17.0f, 0, false, 0, 0, null, null, p0, 0xC30, 6, 0x1FBF0);  // color:white000e
                    p0.p(true);
                }
                u1 = u0;
                A7.d.s(p0, false, true, false);
            }
            BUTTON liveInfoBase$CARD$BUTTON0 = liveInfoBase$CARD0.button;
            if(liveInfoBase$CARD$BUTTON0 == null || (liveInfoBase$CARD$BUTTON0.text == null || liveInfoBase$CARD$BUTTON0.text.length() == 0)) {
                n1 = n0;
                u2 = u1;
                p0.a0(0xB91B0277);
            }
            else {
                p0.a0(-1181049704);
                c.d(p0, androidx.compose.foundation.layout.d.h(n0, 24.0f));
                r0.q q16 = r0.a.a(androidx.compose.foundation.q.f(d5.n.o(androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 48.0f), 20.0f, 0.0f, 2), T.e.b(4.0f)), e0.T(p0, 0x7F060157), u1), new a0(0, 0, null, a1, true));  // color:gray400e
                N0.M m2 = M.p.d(d.a, false);
                int v9 = p0.P;
                i0 i05 = p0.m();
                r0.q q17 = r0.a.d(p0, q16);
                P0.k.y.getClass();
                P0.i i3 = P0.j.b;
                p0.e0();
                if(p0.O) {
                    p0.l(i3);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, m2, P0.j.f);
                androidx.compose.runtime.w.x(p0, i05, P0.j.e);
                h h8 = P0.j.g;
                if(p0.O || !q.b(p0.N(), v9)) {
                    A7.d.q(v9, p0, v9, h8);
                }
                androidx.compose.runtime.w.x(p0, q17, P0.j.d);
                r0.q q18 = b0.a(n0, i0);
                String s5 = liveInfoBase$CARD$BUTTON0.text;
                q.f(s5, "text");
                n1 = n0;
                u2 = u1;
                N1.b(s5, q18, e0.T(p0, 0x7F0604A1), 15.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 1, 0, null, null, p0, 0x30C00, 0xC00, 0x1DFD0);  // color:white000e
                p0.p(true);
            }
            p0.p(false);
            String s6 = liveInfoBase$CARD0.imgUrl;
            if(s6 == null || s6.length() <= 0) {
                p0.a0(0xB9B0E8B6);
                A7.d.v(n1, 30.0f, p0, false);
            }
            else {
                p0.a0(-1180148007);
                c1.n(androidx.compose.foundation.q.f(androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.j(x.s(n1, 30.0f, p0, n1, 1.0f), 0.0f, 1000.0f, 1), 3), e0.T(p0, 0x7F06014D), u2), s6, null, N0.j.e, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0xC00, 0, 0x7FF4);  // color:gray125e
                p0.p(false);
            }
            p0.p(true);
            a2 = a1;
        }
        else {
            p0.T();
            a2 = a0;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Nc.p(liveInfoBase$CARD0, a2, v, v1, 5);
        }
    }

    public static final void VideoLiveContentsArea(@Nullable LiveInfoBase liveInfoBase0, @Nullable a a0, @Nullable l l0, int v, int v1) {
        p p0 = (p)l0;
        p0.c0(0xC0050065);
        int v2 = (v & 6) == 0 ? (p0.i(liveInfoBase0) ? 4 : 2) | v : v;
        if((v1 & 2) != 0) {
            v2 |= 0x30;
        }
        else if((v & 0x30) == 0) {
            v2 |= (p0.i(a0) ? 0x20 : 16);
        }
        if(p0.Q(v2 & 1, (v2 & 19) != 18)) {
            if((v1 & 2) != 0) {
                e e0 = p0.N();
                if(e0 == k.a) {
                    e0 = new e(24);
                    p0.l0(e0);
                }
                a0 = e0;
            }
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(n0, 1.0f), 3);
            y y0 = w.a(j.c, d.m, p0, 0);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
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
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            List list0 = null;
            List list1 = liveInfoBase0 == null ? null : liveInfoBase0.versionPush;
            if(list1 != null && (!(list1 instanceof Collection) || !list1.isEmpty())) {
                for(Object object0: list1) {
                    q.d(((String)object0));
                    if(((String)object0).length() <= 0) {
                        continue;
                    }
                    p0.a0(2047047103);
                    c.d(p0, androidx.compose.foundation.layout.d.h(n0, 30.0f));
                    VideoLivePreviewComposablesKt.VideoLiveItems(list1, p0, 0);
                    goto label_47;
                }
            }
            p0.a0(2045203347);
        label_47:
            p0.p(false);
            String s = liveInfoBase0 == null ? null : liveInfoBase0.text3;
            if(s == null || s.length() <= 0) {
                p0.a0(2045203347);
            }
            else {
                p0.a0(0x7A069AC7);
                c.d(p0, androidx.compose.foundation.layout.d.h(n0, 40.0f));
                VideoLivePreviewComposablesKt.VideoLiveDesc(s, p0, 0);
            }
            p0.p(false);
            CARD liveInfoBase$CARD0 = liveInfoBase0 == null ? null : liveInfoBase0.card;
            if(liveInfoBase$CARD0 == null) {
                p0.a0(2045203347);
            }
            else {
                p0.a0(0x7A093DFF);
                c.d(p0, androidx.compose.foundation.layout.d.h(n0, 40.0f));
                VideoLivePreviewComposablesKt.VideoLiveCard(liveInfoBase$CARD0, a0, p0, v2 & 0x70, 0);
            }
            p0.p(false);
            if(liveInfoBase0 != null) {
                list0 = liveInfoBase0.caution;
            }
            if(list0 != null && (!(list0 instanceof Collection) || !list0.isEmpty())) {
                for(Object object1: list0) {
                    q.d(((String)object1));
                    if(((String)object1).length() <= 0) {
                        continue;
                    }
                    p0.a0(2047654083);
                    c.d(p0, androidx.compose.foundation.layout.d.h(n0, 30.0f));
                    VideoLivePreviewComposablesKt.VideoLiveItems(list0, p0, 0);
                    goto label_77;
                }
            }
            p0.a0(2045203347);
        label_77:
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Nc.p(liveInfoBase0, a0, v, v1, 4);
        }
    }

    public static final void VideoLiveDesc(@Nullable String s, @Nullable l l0, int v) {
        ((p)l0).c0(0xA547DFF5);
        int v1 = (v & 6) == 0 ? (((p)l0).g(s) ? 4 : 2) | v : v;
        if(((p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            N1.b((s == null ? "" : s), androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(n.a, 1.0f), 3), e0.T(((p)l0), 0x7F060169), 16.0f, null, null, 0L, null, 22.0f, 0, false, 0, 0, null, null, ((p)l0), 0xC30, 6, 0x1FBF0);  // color:gray850s
        }
        else {
            ((p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new U0(s, v, 3);
        }
    }

    public static final void VideoLiveItems(@NotNull List list0, @Nullable l l0, int v) {
        q.g(list0, "data");
        p p0 = (p)l0;
        p0.c0(0x76DDE745);
        int v1 = (v & 6) == 0 ? (p0.i(list0) ? 4 : 2) | v : v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(n0, 1.0f), 3);
            y y0 = w.a(j.h(10.0f), d.m, p0, 6);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
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
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            androidx.compose.runtime.w.x(p0, q1, P0.j.d);
            p0.a0(0x7EC1E0BA);
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: list0) {
                if(((String)object0).length() > 0) {
                    arrayList0.add(object0);
                }
            }
            for(Object object1: arrayList0) {
                r0.q q2 = androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(n0, 1.0f), 3);
                p0 p00 = n0.a(j.a, d.j, p0, 0);
                int v3 = p0.P;
                i0 i01 = p0.m();
                r0.q q3 = r0.a.d(p0, q2);
                P0.k.y.getClass();
                P0.i i1 = P0.j.b;
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, p00, P0.j.f);
                androidx.compose.runtime.w.x(p0, i01, P0.j.e);
                h h1 = P0.j.g;
                if(p0.O || !q.b(p0.N(), v3)) {
                    A7.d.q(v3, p0, v3, h1);
                }
                androidx.compose.runtime.w.x(p0, q3, P0.j.d);
                N1.b("ㆍ", androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.v(n0, null, 3), 3), e0.T(p0, 0x7F06015D), 12.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC36, 0, 0x1FFF0);  // color:gray500s_support_high_contrast
                N1.b(((String)object1), androidx.compose.foundation.layout.d.t(new LayoutWeightElement(1.0f, true), 3), e0.T(p0, 0x7F06015D), 12.0f, null, null, 0L, null, 15.0f, 0, false, 0, 0, null, null, p0, 0xC00, 6, 0x1FBF0);  // color:gray500s_support_high_contrast
                p0.p(true);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new W8.a(list0, v, 3);
        }
    }
}

