package cd;

import Cc.M;
import Cc.N1;
import Cc.a3;
import Cc.c1;
import Cc.e0;
import Cc.m3;
import M.c;
import M.j0;
import M.j;
import M.n0;
import M.p0;
import M.y;
import Nc.Y;
import P.F;
import P.I;
import P0.h;
import T.e;
import U4.x;
import Vb.i;
import Zc.N;
import android.content.Context;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.J;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import b9.a;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v5x.response.MainMusicRes.NOTICE;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.HEADER;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.CONTENTS;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.ChartHeader;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART;
import com.iloen.melon.utils.ResourceUtilsKt;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import d5.w;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.CoroutineScope;
import m0.b;
import r0.g;
import r0.n;

public abstract class q {
    public static final void a(r r0, l l0, int v) {
        ChartHeader mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader2;
        n n2;
        ArrayList arrayList1;
        List list1;
        K0 k00;
        V v6;
        a3 a30;
        F f1;
        String s4;
        h h4;
        MELONCHART mainMusicRes$RESPONSE$MELONCHART1;
        kotlin.jvm.internal.q.g(r0, "uiState");
        p p0 = (p)l0;
        p0.c0(0x9490BB72);
        int v1 = v | (p0.i(r0) ? 4 : 2);
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            CoroutineScope coroutineScope0 = p0.N();
            V v2 = k.a;
            if(coroutineScope0 == v2) {
                coroutineScope0 = J.i(p0);
                p0.l0(coroutineScope0);
            }
            F f0 = I.a(p0);
            i i0 = p0.N();
            if(i0 == v2) {
                i0 = new i(14);
                p0.l0(i0);
            }
            a0 a00 = (a0)w.P(new Object[0], null, null, i0, p0, 0, 6);
            boolean z = p0.i(r0);
            a a0 = p0.N();
            if(z || a0 == v2) {
                a0 = new a(r0, 4);
                p0.l0(a0);
            }
            b0 b00 = (b0)w.P(new Object[0], null, null, a0, p0, 0, 6);
            i i1 = p0.N();
            if(i1 == v2) {
                i1 = new i(15);
                p0.l0(i1);
            }
            b0 b01 = (b0)w.P(new Object[0], null, null, i1, p0, 0, 6);
            a0 a01 = p0.N();
            if(a01 == v2) {
                a01 = androidx.compose.runtime.w.p(0);
                p0.l0(a01);
            }
            MELONCHART mainMusicRes$RESPONSE$MELONCHART0 = r0.b;
            List list0 = mainMusicRes$RESPONSE$MELONCHART0.getCharts();
            if(list0 == null) {
                list0 = je.w.a;
            }
            n n0 = n.a;
            r0.q q0 = d.f(n0, 1.0f);
            g g0 = r0.d.m;
            y y0 = M.w.a(j.c, g0, p0, 0);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i2 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i2);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O) {
                mainMusicRes$RESPONSE$MELONCHART1 = mainMusicRes$RESPONSE$MELONCHART0;
                A7.d.q(v3, p0, v3, h2);
            }
            else {
                mainMusicRes$RESPONSE$MELONCHART1 = mainMusicRes$RESPONSE$MELONCHART0;
                if(!kotlin.jvm.internal.q.b(p0.N(), v3)) {
                    A7.d.q(v3, p0, v3, h2);
                }
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            if(mainMusicRes$RESPONSE$MELONCHART1.getToolTip() == null || ((Boolean)b01.getValue()).booleanValue()) {
                h4 = h3;
                p0.a0(0x66A3903A);
            }
            else {
                p0.a0(0xFB105F28);
                NOTICE mainMusicRes$NOTICE0 = mainMusicRes$RESPONSE$MELONCHART1.getToolTip();
                if(mainMusicRes$NOTICE0 == null) {
                    p0.a0(0x66FC0084);
                    p0.p(false);
                    h4 = h3;
                }
                else {
                    p0.a0(0x66FC0085);
                    String s = mainMusicRes$NOTICE0.getTitleHeader();
                    if(s == null) {
                        s = "";
                    }
                    String s1 = mainMusicRes$NOTICE0.getTitle() == null ? "" : mainMusicRes$NOTICE0.getTitle();
                    boolean z1 = p0.g(b01);
                    boolean z2 = p0.i(r0);
                    N n1 = p0.N();
                    if(z1 || z2 || n1 == v2) {
                        h4 = h3;
                        n1 = new N(3, b01, r0);
                        p0.l0(n1);
                    }
                    else {
                        h4 = h3;
                    }
                    q.c(s, s1, n1, p0, 0);
                    p0.p(false);
                }
            }
            p0.p(false);
            M m0 = r0.a;
            String s2 = (String)b00.getValue();
            boolean z3 = p0.i(r0);
            boolean z4 = p0.i(list0);
            boolean z5 = p0.g(a00);
            cd.j j0 = p0.N();
            if((z3 | z4 | z5) != 0 || j0 == v2) {
                j0 = new cd.j(r0, list0, a00, 0);
                p0.l0(j0);
            }
            boolean z6 = p0.i(r0);
            boolean z7 = p0.i(list0);
            boolean z8 = p0.g(a00);
            cd.j j1 = p0.N();
            if((z6 | z7 | z8) != 0 || j1 == v2) {
                j1 = new cd.j(r0, list0, a00, 1);
                p0.l0(j1);
            }
            kotlin.jvm.internal.q.g(m0.a, "title");
            kotlin.jvm.internal.q.g(m0.b, "titleReplace");
            kotlin.jvm.internal.q.g(m0.c, "titleReplaceTextKey");
            kotlin.jvm.internal.q.g(s2, "subTitle");
            kotlin.jvm.internal.q.g(m0.e, "subTitleReplace");
            kotlin.jvm.internal.q.g(m0.f, "subTitleReplaceTextKey");
            kotlin.jvm.internal.q.g(m0.i, "titleRightImage");
            kotlin.jvm.internal.q.g(m0.l, "viewAllText");
            M m1 = new M(m0.a, m0.b, m0.c, s2, m0.e, m0.f, m0.g, m0.h, m0.i, m0.j, m0.k, m0.l, j0, j1);
            r0.q q2 = d.j(n0, e0.Z(p0, ((K0)a01).m()), 0.0f, 2);
            cd.k k0 = p0.N();
            if(k0 == v2) {
                k0 = new cd.k(((K0)a01), 0);
                p0.l0(k0);
            }
            r0.q q3 = androidx.compose.ui.layout.a.f(q2, k0);
            y y1 = M.w.a(j.d, g0, p0, 6);
            int v4 = p0.P;
            i0 i01 = p0.m();
            r0.q q4 = r0.a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                p0.l(i2);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y1, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            androidx.compose.runtime.w.x(p0, q4, h4);
            e0.o(m1, p0, 0);
            p0.p(true);
            c.d(p0, d.h(n0, 3.0f));
            ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
            for(Object object0: list0) {
                ChartHeader mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader0 = ((Chart)object0).getHeader();
                if(mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader0 == null) {
                    s4 = "";
                }
                else {
                    String s3 = mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader0.title;
                    if(s3 != null) {
                        s4 = s3;
                    }
                }
                arrayList0.add(s4);
            }
            int v5 = ((K0)a00).m();
            b b0 = m0.c.e(0xA413AB97, p0, new Y(25, mainMusicRes$RESPONSE$MELONCHART1, r0));
            boolean z9 = p0.i(list0);
            boolean z10 = p0.g(((K0)a00));
            boolean z11 = p0.g(b00);
            boolean z12 = p0.i(coroutineScope0);
            boolean z13 = p0.g(f0);
            boolean z14 = p0.i(r0);
            Object object1 = p0.N();
            if((z9 | z10 | z11 | z12 | z13 | z14) != 0 || object1 == v2) {
                k00 = (K0)a00;
                list1 = list0;
                v6 = v2;
                a30 = new a3(list1, k00, b00, coroutineScope0, r0, f0);
                f1 = f0;
                p0.l0(a30);
            }
            else {
                f1 = f0;
                a30 = object1;
                v6 = v2;
                k00 = (K0)a00;
                list1 = list0;
            }
            c1.N(arrayList0, null, v5, b0, a30, p0, 0xC00, 2);
            c.d(p0, d.h(n0, 12.0f));
            ChartHeader mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader1 = ((Chart)list1.get(k00.m())).getHeader();
            List list2 = mainMusicRes$RESPONSE$MELONCHART1.getCharts();
            String s5 = null;
            if(list2 == null) {
                arrayList1 = null;
            }
            else {
                Chart mainMusicRes$RESPONSE$MELONCHART$Chart0 = (Chart)list2.get(k00.m());
                if(mainMusicRes$RESPONSE$MELONCHART$Chart0 == null) {
                    arrayList1 = null;
                }
                else {
                    List list3 = mainMusicRes$RESPONSE$MELONCHART$Chart0.getContents();
                    if(list3 == null) {
                        arrayList1 = null;
                    }
                    else {
                        arrayList1 = new ArrayList(je.q.Q(10, list3));
                        int v7 = 0;
                        for(Object object2: list3) {
                            if(v7 >= 0) {
                                Chart mainMusicRes$RESPONSE$MELONCHART$Chart1 = (Chart)je.p.n0(k00.m(), list1);
                                arrayList1.add(new cd.b(((CONTENTS)object2), (mainMusicRes$RESPONSE$MELONCHART$Chart1 == null ? null : mainMusicRes$RESPONSE$MELONCHART$Chart1.getHeader()), k00.m(), v7, r0.d));
                                ++v7;
                                continue;
                            }
                            e.k.O();
                            throw null;
                        }
                    }
                }
            }
            r0.q q5 = d.h(n0, 252.0f);
            P.a a1 = new P.a(4);
            j0 j00 = androidx.compose.foundation.layout.a.a(14.0f, 0.0f, 2);
            M.g g1 = j.h(14.0f);
            M.g g2 = j.h(4.0f);
            boolean z15 = p0.i(arrayList1);
            boolean z16 = p0.g(k00);
            boolean z17 = p0.i(mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader1);
            boolean z18 = p0.i(list1);
            boolean z19 = p0.i(coroutineScope0);
            boolean z20 = p0.i(r0);
            cd.h h5 = p0.N();
            if((z15 | z16 | z17 | z18 | z19 | z20) != 0 || h5 == v6) {
                n2 = n0;
                mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader2 = mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader1;
                cd.h h6 = new cd.h(arrayList1, k00, 60.0f, mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader2, list1, coroutineScope0, r0);
                p0.l0(h6);
                h5 = h6;
            }
            else {
                n2 = n0;
                mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader2 = mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader1;
            }
            E9.h.h(a1, q5, f1, j00, g1, g2, null, false, null, h5, p0, 0x1B0C30, 0, 0x390);
            r0.q q6 = androidx.compose.foundation.layout.a.l(d.h(x.s(n2, 12.0f, p0, n2, 1.0f), 48.0f), 20.0f, 0.0f, 2);
            T.d d0 = e.b(4.0f);
            r0.q q7 = r0.a.a(androidx.compose.foundation.q.f(q6, e0.T(p0, 0x7F060145), d0), new Ac.r(r0, mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader2, k00, 10));  // color:gray050s
            p0 p00 = n0.a(new M.g(8.0f, true, new M.i(2, 1)), r0.d.k, p0, 54);
            int v8 = p0.P;
            i0 i02 = p0.m();
            r0.q q8 = r0.a.d(p0, q7);
            P0.k.y.getClass();
            P0.i i3 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i3);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, P0.j.f);
            androidx.compose.runtime.w.x(p0, i02, P0.j.e);
            h h7 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v8)) {
                A7.d.q(v8, p0, v8, h7);
            }
            androidx.compose.runtime.w.x(p0, q8, P0.j.d);
            ChartHeader mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader3 = ((Chart)list1.get(k00.m())).getHeader();
            if(mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader3 != null) {
                s5 = mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader3.title;
            }
            String s6 = va.e.c(StringUtils.getTrimmed((s5 == null ? "" : s5), 13), " ", H0.e.Y(p0, 0x7F1300E9));  // string:all_play "전체듣기"
            c1.n(null, 0x7F080405, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30, 0, 0x7FFD);  // drawable:ic_common_play_01
            N1.b(s6, null, 0L, 0.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0, 0, 0x1FFFE);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Zc.c(r0, v, 8);
        }
    }

    public static final void b(r0.q q0, cd.b b0, HEADER mainMusicRes$RESPONSE$HEADER0, boolean z, CoroutineScope coroutineScope0, we.a a0, l l0, int v) {
        V v10;
        CONTENTS mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS1;
        V v9;
        P0.i i1;
        long v6;
        float f;
        String s4;
        int v5;
        int v4;
        int v3;
        boolean z1;
        kotlin.jvm.internal.q.g(b0, "itemUiState");
        kotlin.jvm.internal.q.g(coroutineScope0, "coroutineScope");
        p p0 = (p)l0;
        p0.c0(0x3313C16);
        int v1 = v | (p0.i(b0) ? 0x20 : 16) | (p0.i(mainMusicRes$RESPONSE$HEADER0) ? 0x100 : 0x80) | (p0.h(z) ? 0x800 : 0x400) | (p0.i(coroutineScope0) ? 0x4000 : 0x2000) | (p0.i(a0) ? 0x20000 : 0x10000);
        if(p0.Q(v1 & 1, (74899 & v1) != 74898)) {
            CONTENTS mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS0 = b0.a;
            a0 a00 = p0.N();
            V v2 = k.a;
            if(a00 == v2) {
                a00 = androidx.compose.runtime.w.p(0);
                p0.l0(a00);
            }
            String s = mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS0.getRankType();
            if(s == null) {
                v3 = 0;
            }
            else {
                switch(s) {
                    case "DOWN": {
                        v3 = 0x7F0803D8;  // drawable:ic_common_arrow_down_01
                        break;
                    }
                    case "NEW": {
                        v3 = 0x7F080402;  // drawable:ic_common_new_01
                        break;
                    }
                    case "NONE": {
                        if(z) {
                            p0.a0(2122857830);
                            p0.p(false);
                            z1 = true;
                        }
                        else {
                            p0.a0(-70066954);
                            z1 = ScreenUtils.isDarkMode(((Context)p0.k(AndroidCompositionLocals_androidKt.b)));
                            p0.p(false);
                        }
                        v3 = z1 ? 0x7F0803DA : 0x7F0803DB;  // drawable:ic_common_arrow_equal_01
                        break;
                    }
                    case "UP": {
                        v3 = 0x7F0803DD;  // drawable:ic_common_arrow_up_01
                        break;
                    }
                    default: {
                        v3 = 0;
                    }
                }
            }
            String s1 = mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS0.getRankType();
            if(s1 == null) {
                v4 = v3;
                v5 = 0;
            }
            else {
                v4 = v3;
                switch(s1) {
                    case "DOWN": {
                        v5 = 0x7F130B99;  // string:talkback_music_chart_rank_type_down "순위 하락"
                        break;
                    }
                    case "NEW": {
                        v5 = 0x7F130B9A;  // string:talkback_music_chart_rank_type_new "신규 진입"
                        break;
                    }
                    case "NONE": {
                        v5 = 0x7F130B9B;  // string:talkback_music_chart_rank_type_same "순위 변동 없음"
                        break;
                    }
                    case "UP": {
                        v5 = 0x7F130B9C;  // string:talkback_music_chart_rank_type_up "순위 상승"
                        break;
                    }
                    default: {
                        v5 = 0;
                    }
                }
            }
            String s2 = ResourceUtilsKt.getString(v5, new Object[0]);
            String s3 = mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS0.getRankType();
            if(s3 == null) {
                s4 = s2;
                f = 0.0f;
            }
            else {
                s4 = s2;
                switch(s3) {
                    case "DOWN": 
                    case "UP": {
                        f = 6.0f;
                        break;
                    }
                    case "NEW": 
                    case "NONE": {
                        f = 14.0f;
                        break;
                    }
                    default: {
                        f = 0.0f;
                    }
                }
            }
            Wf.a a1 = p0.N();
            if(a1 == v2) {
                a1 = new Wf.a(15);
                p0.l0(a1);
            }
            r0.q q1 = e0.L(androidx.compose.foundation.layout.a.n(d.h(d.q(X0.n.c(q0, false, a1), 298.0f), 60.0f), 0.0f, 2.0f, 0.0f, 2.0f, 5), 0x7F06048A);  // color:transparent
            if(z) {
                p0.a0(0x7E97FEB6);
                p0.p(false);
                v6 = y0.M.c(((K0)a00).m());
            }
            else {
                v6 = A7.d.f(p0, 2123950808, 0x7F06048A, p0, false);  // color:transparent
            }
            r0.q q2 = androidx.compose.foundation.q.f(q1, v6, y0.M.a);
            Bc.d d0 = p0.N();
            if((0x70000 & v1) == 0x20000 || d0 == v2) {
                d0 = new Bc.d(21, a0);
                p0.l0(d0);
            }
            r0.q q3 = r0.a.a(m3.b(q2, d0), new Ac.l(14, b0, mainMusicRes$RESPONSE$HEADER0));
            M.b b1 = j.a;
            p0 p00 = n0.a(b1, r0.d.k, p0, 0x30);
            int v7 = p0.P;
            i0 i00 = p0.m();
            r0.q q4 = r0.a.d(p0, q3);
            P0.k.y.getClass();
            r0.h h0 = r0.d.k;
            P0.i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, P0.j.f);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            h h3 = P0.j.f;
            if(p0.O) {
                i1 = i0;
                A7.d.q(v7, p0, v7, h2);
            }
            else {
                i1 = i0;
                if(!kotlin.jvm.internal.q.b(p0.N(), v7)) {
                    A7.d.q(v7, p0, v7, h2);
                }
            }
            androidx.compose.runtime.w.x(p0, q4, P0.j.d);
            n n0 = n.a;
            c.d(p0, d.q(n0, 6.0f));
            r0.q q5 = e0.L(d.n(n0, 44.0f), 0x7F06014A);  // color:gray100a
            h h4 = P0.j.d;
            r0.q q6 = r0.a.a(q5, new cd.p(0, b0));
            String s5 = mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS0.albumImg;
            boolean z2 = p0.i(coroutineScope0);
            Gd.F f1 = p0.N();
            if((v1 & 0x1C00) == 0x800 || z2 || f1 == v2) {
                f1 = new Gd.F(z, coroutineScope0, a00, 6);
                p0.l0(f1);
            }
            c1.n(q6, s5, "", null, false, 0x7F08078B, f1, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30000, 0, 0x7F98);  // drawable:noimage_logo_mini
            c.d(p0, d.q(n0, 8.0f));
            String s6 = "";
            if(mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS0.getCurrentRank() == null) {
                mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS1 = mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS0;
                v10 = v2;
                p0.a0(-1780950424);
            }
            else {
                p0.a0(0x96CE6CD5);
                r0.q q7 = d.q(n0, 30.0f);
                y y0 = M.w.a(j.c, r0.d.n, p0, 0x30);
                int v8 = p0.P;
                i0 i01 = p0.m();
                r0.q q8 = r0.a.d(p0, q7);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, y0, h3);
                androidx.compose.runtime.w.x(p0, i01, h1);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v8)) {
                    A7.d.q(v8, p0, v8, h2);
                }
                androidx.compose.runtime.w.x(p0, q8, h4);
                boolean z3 = p0.i(mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS0);
                cd.i i2 = p0.N();
                if(z3) {
                    v9 = v2;
                    i2 = new cd.i(mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS0, 0);
                    p0.l0(i2);
                }
                else {
                    v9 = v2;
                    if(i2 == v9) {
                        i2 = new cd.i(mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS0, 0);
                        p0.l0(i2);
                    }
                }
                mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS1 = mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS0;
                v10 = v9;
                N1.b((mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS0.getCurrentRank() == null ? "" : mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS0.getCurrentRank()), X0.n.c(n0, false, i2), e0.T(p0, (z ? 0x7F0604A0 : 0x7F06016D)), 17.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);  // color:white
                if(v4 == 0) {
                    p0.a0(0x5D4FA057);
                }
                else {
                    p0.a0(0x5E4E9D9F);
                    r0.q q9 = d.h(n0, 13.0f);
                    p0 p01 = n0.a(b1, h0, p0, 0x30);
                    int v11 = p0.P;
                    i0 i02 = p0.m();
                    r0.q q10 = r0.a.d(p0, q9);
                    p0.e0();
                    if(p0.O) {
                        p0.l(i1);
                    }
                    else {
                        p0.o0();
                    }
                    androidx.compose.runtime.w.x(p0, p01, h3);
                    androidx.compose.runtime.w.x(p0, i02, h1);
                    if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v11)) {
                        A7.d.q(v11, p0, v11, h2);
                    }
                    androidx.compose.runtime.w.x(p0, q10, h4);
                    c1.n(d.h(n0, f), v4, s4, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0, 0, 0x7FF8);
                    if(kotlin.jvm.internal.q.b(mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS1.getRankGap(), "0")) {
                        p0.a0(0xA23774D8);
                    }
                    else {
                        p0.a0(0xA33DB338);
                        c.d(p0, d.q(n0, 3.0f));
                        N1.b((mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS1.getRankGap() == null ? "" : mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS1.getRankGap()), null, e0.T(p0, (kotlin.jvm.internal.q.b(mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS1.getRankType(), "UP") ? 0x7F06045A : 0x7F060046)), 12.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // color:rank_up_color
                    }
                    p0.p(false);
                    p0.p(true);
                }
                p0.p(false);
                p0.p(true);
            }
            p0.p(false);
            c.d(p0, d.q(n0, 8.0f));
            LayoutWeightElement layoutWeightElement0 = new LayoutWeightElement(1.0f, true);
            y y1 = M.w.a(j.e, r0.d.m, p0, 6);
            int v12 = p0.P;
            i0 i03 = p0.m();
            r0.q q11 = r0.a.d(p0, layoutWeightElement0);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y1, h3);
            androidx.compose.runtime.w.x(p0, i03, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v12)) {
                A7.d.q(v12, p0, v12, h2);
            }
            androidx.compose.runtime.w.x(p0, q11, h4);
            N1.b((mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS1.songName == null ? "" : mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS1.songName), null, e0.T(p0, (z ? 0x7F0604A0 : 0x7F06016D)), 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);  // color:white
            c.d(p0, d.h(n0, 2.0f));
            boolean z4 = p0.i(mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS1);
            cd.i i3 = p0.N();
            if(z4 || i3 == v10) {
                i3 = new cd.i(mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS1, 1);
                p0.l0(i3);
            }
            r0.q q12 = X0.n.c(n0, false, i3);
            String s7 = ProtocolUtils.getArtistNames(mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS1.artistList);
            if(s7 != null) {
                s6 = s7;
            }
            N1.b(s6, q12, e0.T(p0, (z ? 0x7F0604A0 : 0x7F060160)), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);  // color:white
            p0.p(true);
            c.d(p0, d.q(n0, 10.0f));
            c1.n(r0.a.a(d.n(n0, 28.0f), new cd.p(1, b0)), 0x7F08015F, null, null, false, 0, null, null, null, 0.0f, new y0.k(e0.T(p0, (z ? 0x7F0604A0 : 0x7F06016D)), 5), 0, 0, false, false, p0, 0x30, 0, 0x7BFC);  // drawable:btn_common_play_02
            x.z(n0, 8.0f, p0, true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Cc.I(q0, b0, mainMusicRes$RESPONSE$HEADER0, z, coroutineScope0, a0, v);
        }
    }

    public static final void c(String s, String s1, we.a a0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0x2A12EFE8);
        int v1 = v | (p0.g(s) ? 4 : 2) | (p0.g(s1) ? 0x20 : 16) | (p0.i(a0) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.layout.a.l(d.f(n0, 1.0f), 20.0f, 0.0f, 2);
            y y0 = M.w.a(j.c, r0.d.m, p0, 0);
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
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            r0.q q2 = androidx.compose.foundation.q.f(d5.n.o(d.h(d.f(n0, 1.0f), 39.0f), e.b(4.0f)), e0.T(p0, 0x7F060142), y0.M.a);  // color:gray030s
            p0 p00 = n0.a(j.a, r0.d.k, p0, 0x30);
            int v3 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            androidx.compose.runtime.w.x(p0, q3, h3);
            N1.b(s, null, A7.d.g(n0, 12.0f, p0, 0x7F06017C, p0), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v1 & 14 | 0xC00, 0xC30, 0x1D7F2);  // color:green500s_support_high_contrast
            c.d(p0, d.q(n0, 5.0f));
            N1.b(s1, new LayoutWeightElement(1.0f, true), e0.T(p0, 0x7F06016D), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v1 >> 3 & 14 | 0xC00, 0xC30, 0x1D7F0);  // color:gray900s
            c.d(p0, d.q(n0, 12.0f));
            c1.n(r0.a.a(d.n(n0, 26.0f), new Lc.c(25, a0)), 0x7F080133, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30, 0, 0x7FFC);  // drawable:btn_common_delete_26_gray
            x.z(n0, 6.0f, p0, true);
            c1.n(d.q(androidx.compose.foundation.layout.a.n(n0, 10.0f, 0.0f, 0.0f, 0.0f, 14), 16.0f), 0x7F080618, null, null, false, 0, null, null, null, 0.0f, new y0.k(e0.T(p0, 0x7F060142), 5), 0, 0, false, false, p0, 54, 0, 0x7BFC);  // drawable:img_bg_tooltip
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Id.h(v, 10, s1, a0, s);
        }
    }
}

