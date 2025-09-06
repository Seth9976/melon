package com.iloen.melon.player.playlist.drawernew;

import Cc.c1;
import Cc.e0;
import M.j;
import M.y;
import M.z;
import N0.M;
import P0.h;
import T.e;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.runtime.V;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.fragment.app.I;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.main.foru.ForUUtils;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import com.iloen.melon.player.playlist.drawernew.composable.DrawerNeedLoginKt;
import com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListItemData;
import com.iloen.melon.player.playlist.drawernew.composable.DrawerSongListKt;
import com.iloen.melon.utils.StringUtils;
import com.melon.ui.K4;
import com.melon.ui.c3;
import com.melon.ui.e3;
import ie.H;
import ie.s;
import java.util.Collection;
import java.util.List;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;
import oc.c0;
import r0.d;
import r0.i;
import r0.q;
import we.n;

public final class a implements n {
    public final int a;
    public final I b;
    public final Object c;

    public a(I i0, K4 k40, int v) {
        this.a = v;
        this.b = i0;
        this.c = k40;
        super();
    }

    public a(DrawerBtmSheetFragment drawerBtmSheetFragment0, we.a a0, int v) {
        this.a = 1;
        super();
        this.b = drawerBtmSheetFragment0;
        this.c = a0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        c0 c00;
        boolean z8;
        String s3;
        String s1;
        h h15;
        p p2;
        String s4;
        r0.n n0 = r0.n.a;
        V v0 = k.a;
        H h0 = H.a;
        Object object2 = this.c;
        I i0 = this.b;
        switch(this.a) {
            case 0: {
                int v4 = (int)(((Integer)object1));
                i i6 = d.a;
                p p1 = (p)(((l)object0));
                if(p1.Q(v4 & 1, (v4 & 3) != 2)) {
                    List list1 = ((DrawerFragmentViewModel)((DrawerBtmSheetFragment)i0).getViewModel()).getAlyacList();
                    Object object8 = w.f(((DrawerFragmentViewModel)((DrawerBtmSheetFragment)i0).getViewModel()).getSelectedAlyacKey(), p1).getValue();
                    List list2 = (List)w.f(((DrawerFragmentViewModel)((DrawerBtmSheetFragment)i0).getViewModel()).getDrawerPlytListListUiState(), p1).getValue();
                    FillElement fillElement0 = androidx.compose.foundation.layout.d.c;
                    q q2 = androidx.compose.foundation.q.f(fillElement0, e0.T(p1, 0x7F0604AB), e.d(8.0f, 8.0f, 0.0f, 0.0f, 12));  // color:white001s
                    y y1 = M.w.a(j.c, d.m, p1, 0);
                    int v5 = p1.P;
                    i0 i02 = p1.m();
                    q q3 = r0.a.d(p1, q2);
                    P0.k.y.getClass();
                    P0.i i7 = P0.j.b;
                    p1.e0();
                    if(p1.O) {
                        p1.l(i7);
                    }
                    else {
                        p1.o0();
                    }
                    h h11 = P0.j.f;
                    w.x(p1, y1, h11);
                    h h12 = P0.j.e;
                    w.x(p1, i02, h12);
                    h h13 = P0.j.g;
                    if(p1.O) {
                        s4 = (String)object8;
                        A7.d.q(v5, p1, v5, h13);
                    }
                    else {
                        Object object9 = p1.N();
                        s4 = (String)object8;
                        if(!kotlin.jvm.internal.q.b(object9, v5)) {
                            A7.d.q(v5, p1, v5, h13);
                        }
                    }
                    h h14 = P0.j.d;
                    w.x(p1, q3, h14);
                    ((DrawerBtmSheetFragment)i0).o(p1, 0);
                    if(((K4)object2).equals(NeedLogin.INSTANCE)) {
                        p1.a0(0x293FC846);
                        q q4 = z.a(androidx.compose.foundation.layout.d.f(n0, 1.0f), 1.0f);
                        M m1 = M.p.d(i6, false);
                        int v6 = p1.P;
                        i0 i03 = p1.m();
                        q q5 = r0.a.d(p1, q4);
                        p1.e0();
                        if(p1.O) {
                            p1.l(i7);
                        }
                        else {
                            p1.o0();
                        }
                        w.x(p1, m1, h11);
                        w.x(p1, i03, h12);
                        if(p1.O || !kotlin.jvm.internal.q.b(p1.N(), v6)) {
                            A7.d.q(v6, p1, v6, h13);
                        }
                        w.x(p1, q5, h14);
                        DrawerNeedLoginKt.DrawerNeedLogin(p1, 0);
                        p1.p(true);
                        p1.p(false);
                        p2 = p1;
                    }
                    else {
                        p1.a0(0x2945B9B2);
                        boolean z19 = p1.i(((DrawerBtmSheetFragment)i0));
                        b b0 = p1.N();
                        if(z19 || b0 == v0) {
                            b0 = new b(((DrawerBtmSheetFragment)i0), 0);
                            p1.l0(b0);
                        }
                        p2 = p1;
                        ((DrawerBtmSheetFragment)i0).p(0, p2, s4, list1, b0);
                        q q6 = z.a(n0, 1.0f);
                        M m2 = M.p.d(i6, false);
                        int v7 = p2.P;
                        i0 i04 = p2.m();
                        q q7 = r0.a.d(p2, q6);
                        p2.e0();
                        if(p2.O) {
                            p2.l(i7);
                        }
                        else {
                            p2.o0();
                        }
                        w.x(p2, m2, h11);
                        w.x(p2, i04, h12);
                        if(!p2.O && kotlin.jvm.internal.q.b(p2.N(), v7)) {
                            h15 = h13;
                        }
                        else {
                            h15 = h13;
                            A7.d.q(v7, p2, v7, h15);
                        }
                        w.x(p2, q7, h14);
                        if(((K4)object2) instanceof Idle) {
                            p2.a0(0x4AE1D78D);
                            boolean z20 = p2.i(((DrawerBtmSheetFragment)i0));
                            b b1 = p2.N();
                            if(z20 || b1 == v0) {
                                b1 = new b(((DrawerBtmSheetFragment)i0), 1);
                                p2.l0(b1);
                            }
                            boolean z21 = p2.i(((DrawerBtmSheetFragment)i0));
                            b b2 = p2.N();
                            if(z21 || b2 == v0) {
                                b2 = new b(((DrawerBtmSheetFragment)i0), 2);
                                p2.l0(b2);
                            }
                            ((DrawerBtmSheetFragment)i0).n(list2, s4, b1, b2, p2, 0);
                        }
                        else if(((K4)object2) instanceof Loading) {
                            p2.a0(0x4AF034AF);
                            M m3 = M.p.d(d.e, false);
                            int v8 = p2.P;
                            i0 i05 = p2.m();
                            q q8 = r0.a.d(p2, fillElement0);
                            p2.e0();
                            if(p2.O) {
                                p2.l(i7);
                            }
                            else {
                                p2.o0();
                            }
                            w.x(p2, m3, h11);
                            w.x(p2, i05, h12);
                            if(p2.O || !kotlin.jvm.internal.q.b(p2.N(), v8)) {
                                A7.d.q(v8, p2, v8, h15);
                            }
                            w.x(p2, q8, h14);
                            c1.H(null, 0L, p2, 0x30, 1);
                            p2.p(true);
                        }
                        else if(((K4)object2) instanceof Error) {
                            p2.a0(0x4AF71943);
                            c3 c30 = ((Error)(((K4)object2))).getErrorUiState();
                            kotlin.jvm.internal.q.g(c30.a, "message");
                            c1.w(new c3(0x7F080430, c30.a, c30.d, false), ((DrawerBtmSheetFragment)i0).getDefaultNetworkErrorHandle().a(), ((DrawerBtmSheetFragment)i0).getDefaultNetworkErrorHandle().b(), 0.0f, 0.0f, p2, 0, 24);  // drawable:ic_error_wifi
                        }
                        else if(((K4)object2) instanceof Notification) {
                            p2.a0(0x4B010F03);
                            c1.y(new e3(H0.e.Y(p2, 0x7F130389), null, null, null, 28), p2, 0);  // string:empty_content_list "목록이 없습니다."
                        }
                        else {
                            p2.a0(0x4A6E4CD4);
                        }
                        p2.p(false);
                        p2.p(true);
                        p2.p(false);
                    }
                    boolean z22 = p2.i(((DrawerBtmSheetFragment)i0));
                    c c0 = p2.N();
                    if(z22 || c0 == v0) {
                        c0 = new c(((DrawerBtmSheetFragment)i0), 0);
                        p2.l0(c0);
                    }
                    ((DrawerBtmSheetFragment)i0).q(c0, p2, 0);
                    p2.p(true);
                    return h0;
                }
                p1.T();
                return h0;
            }
            case 1: {
                ((Integer)object1).getClass();
                ((DrawerBtmSheetFragment)i0).q(((we.a)object2), ((l)object0), 1);
                return h0;
            }
            case 2: {
                int v9 = (int)(((Integer)object1));
                p p3 = (p)(((l)object0));
                if(p3.Q(v9 & 1, (v9 & 3) != 2)) {
                    List list3 = ((DrawerFragmentViewModel)((DrawerFragment)i0).getViewModel()).getAlyacList();
                    Object object10 = B.a.r(((DrawerFragmentViewModel)((DrawerFragment)i0).getViewModel()).getSelectedAlyacKey(), p3, 0).getValue();
                    Object object11 = B.a.r(((DrawerFragmentViewModel)((DrawerFragment)i0).getViewModel()).getDrawerPlytViewType(), p3, 0).getValue();
                    List list4 = (List)B.a.r(((DrawerFragmentViewModel)((DrawerFragment)i0).getViewModel()).getDrawerPlytListListUiState(), p3, 0).getValue();
                    boolean z23 = ((Boolean)B.a.r(((DrawerFragmentViewModel)((DrawerFragment)i0).getViewModel()).getShowProgressForIdle(), p3, 0).getValue()).booleanValue();
                    y y2 = M.w.a(j.c, d.m, p3, 0);
                    int v10 = p3.P;
                    i0 i06 = p3.m();
                    q q9 = r0.a.d(p3, androidx.compose.foundation.layout.d.c);
                    P0.k.y.getClass();
                    P0.i i8 = P0.j.b;
                    p3.e0();
                    if(p3.O) {
                        p3.l(i8);
                    }
                    else {
                        p3.o0();
                    }
                    w.x(p3, y2, P0.j.f);
                    w.x(p3, i06, P0.j.e);
                    h h16 = P0.j.g;
                    if(p3.O || !kotlin.jvm.internal.q.b(p3.N(), v10)) {
                        A7.d.q(v10, p3, v10, h16);
                    }
                    w.x(p3, q9, P0.j.d);
                    if(((K4)object2).equals(NeedLogin.INSTANCE)) {
                        p3.a0(0xDFF334E1);
                        DrawerNeedLoginKt.DrawerNeedLogin(p3, 0);
                    }
                    else {
                        p3.a0(0xDFF6558D);
                        com.iloen.melon.player.playlist.common.h h17 = p3.N();
                        if(h17 == v0) {
                            h17 = new com.iloen.melon.player.playlist.common.h(2);
                            p3.l0(h17);
                        }
                        q q10 = X0.n.c(n0, false, h17);
                        boolean z24 = p3.i(((DrawerFragment)i0));
                        com.iloen.melon.player.playlist.drawernew.e e0 = p3.N();
                        if(z24 || e0 == v0) {
                            e0 = new com.iloen.melon.player.playlist.drawernew.e(((DrawerFragment)i0), 0);
                            p3.l0(e0);
                        }
                        boolean z25 = p3.i(((DrawerFragment)i0));
                        c c1 = p3.N();
                        if(z25 || c1 == v0) {
                            c1 = new c(((DrawerFragment)i0), 1);
                            p3.l0(c1);
                        }
                        ((DrawerFragment)i0).o(q10, list3, ((String)object10), ((String)object11), e0, c1, p3, 0);
                        if(((K4)object2) instanceof Loading) {
                            p3.a0(0xE0044B45);
                            c1.H(null, 0L, p3, 0, 3);
                        }
                        else if(((K4)object2) instanceof Idle) {
                            p3.a0(0xE007159A);
                            com.iloen.melon.player.playlist.common.h h18 = p3.N();
                            if(h18 == v0) {
                                h18 = new com.iloen.melon.player.playlist.common.h(3);
                                p3.l0(h18);
                            }
                            q q11 = X0.n.c(n0, false, h18);
                            boolean z26 = p3.i(((DrawerFragment)i0));
                            com.iloen.melon.player.playlist.drawernew.e e1 = p3.N();
                            if(z26 || e1 == v0) {
                                e1 = new com.iloen.melon.player.playlist.drawernew.e(((DrawerFragment)i0), 1);
                                p3.l0(e1);
                            }
                            boolean z27 = p3.i(((DrawerFragment)i0));
                            com.iloen.melon.player.playlist.drawernew.e e2 = p3.N();
                            if(z27 || e2 == v0) {
                                e2 = new com.iloen.melon.player.playlist.drawernew.e(((DrawerFragment)i0), 2);
                                p3.l0(e2);
                            }
                            ((DrawerFragment)i0).n(q11, list4, z23, ((String)object11), ((String)object10), e1, e2, p3, 0);
                        }
                        else if(((K4)object2) instanceof Error) {
                            p3.a0(0xE01A870A);
                            c1.w(((Error)(((K4)object2))).getErrorUiState(), ((DrawerFragment)i0).getDefaultNetworkErrorHandle().a(), ((DrawerFragment)i0).getDefaultNetworkErrorHandle().b(), 0.0f, 0.0f, p3, 0, 24);
                        }
                        else if(((K4)object2) instanceof Notification) {
                            p3.a0(0xE021A849);
                            e3 e30 = ((Notification)(((K4)object2))).getNotificationUiState();
                            if(e30.c != null && e30.c.length() > 0 || e30.d != null && e30.d.length() > 0) {
                                p3.a0(0xE026B116);
                                c1.y(e30, p3, 0);
                            }
                            else {
                                p3.a0(0xE02A25EB);
                                String s5 = e30.b;
                                if(s5 == null) {
                                    s5 = l1.h(p3, 0xEE752198, 0x7F1303D9, p3, false);  // string:error_network_connectivity "해당 페이지의 접속이 지연되고 있습니다.\n네트워크 연결 상태를 확인하거나,\n잠시 
                                                                                       // 후 다시 이용해주세요."
                                }
                                else {
                                    p3.a0(0xEE751807);
                                    p3.p(false);
                                }
                                c1.w(new c3(s5, 0x7F080431, e30.f, null, 8), ((DrawerFragment)i0).getDefaultNetworkErrorHandle().a(), null, 0.0f, 0.0f, p3, 0, 28);  // drawable:ic_error_wifi_w
                            }
                            p3.p(false);
                        }
                        else {
                            p3.a0(0xDFA8F202);
                        }
                        p3.p(false);
                    }
                    p3.p(false);
                    p3.p(true);
                    return h0;
                }
                p3.T();
                return h0;
            }
            default: {
                DrawerSongFragment drawerSongFragment0 = (DrawerSongFragment)i0;
                int v1 = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(v1 & 1, (v1 & 3) != 2)) {
                    DrawerPlaylistInfo drawerPlaylistInfo0 = (DrawerPlaylistInfo)B.a.r(((DrawerSongFragmentViewModel)drawerSongFragment0.getViewModel()).getPlaylistInfoStateFlow(), ((p)(((l)object0))), 0).getValue();
                    List list0 = (List)B.a.r(((DrawerSongFragmentViewModel)drawerSongFragment0.getViewModel()).getSongListState(), ((p)(((l)object0))), 0).getValue();
                    boolean z = ((Boolean)B.a.r(((DrawerSongFragmentViewModel)drawerSongFragment0.getViewModel()).isProgressVisible(), ((p)(((l)object0))), 0).getValue()).booleanValue();
                    SharedFlow sharedFlow0 = ((DrawerSongFragmentViewModel)drawerSongFragment0.getViewModel()).getScrollTopEventByFetch();
                    Object object3 = B.a.r(((DrawerSongFragmentViewModel)drawerSongFragment0.getViewModel()).getSectionSelectState(), ((p)(((l)object0))), 0).getValue();
                    Object object4 = B.a.r(((DrawerSongFragmentViewModel)drawerSongFragment0.getViewModel()).getOfflinePlaylistHelper().k, ((p)(((l)object0))), 0).getValue();
                    s s0 = (s)B.a.p(((DrawerSongFragmentViewModel)drawerSongFragment0.getViewModel()).getOnSwapCancelPosition(), new s(-1, -1, -1), ((p)(((l)object0))), 0).getValue();
                    com.iloen.melon.fragments.mymusic.dna.d d0 = ((p)(((l)object0))).N();
                    if(d0 == v0) {
                        d0 = new com.iloen.melon.fragments.mymusic.dna.d(16);
                        ((p)(((l)object0))).l0(d0);
                    }
                    boolean z1 = false;
                    Object object5 = d5.w.P(new Object[0], null, null, d0, ((p)(((l)object0))), 0, 6);
                    p p0 = (p)(((l)object0));
                    boolean z2 = ((Boolean)object5).booleanValue();
                    if(!(list0 instanceof Collection) || !list0.isEmpty()) {
                        for(Object object6: list0) {
                            if(((DrawerSongListItemData)object6).isSelected()) {
                                z1 = true;
                                break;
                            }
                        }
                    }
                    if(drawerPlaylistInfo0 == null || list0.isEmpty()) {
                        p0.a0(0x54F8DD6C);
                        p0.p(false);
                        s1 = "";
                    }
                    else if(drawerPlaylistInfo0.hasSongCountForFilter()) {
                        p0.a0(0x54FA3F42);
                        p0.p(false);
                        Bc.h h1 = drawerSongFragment0.getPlayerUiHelper();
                        h1.getClass();
                        s1 = va.e.h(StringUtils.getFormattedStringNumber(list0.size()), h1.a.a(0x7F1302FA));  // string:detail_common_title_song "곡"
                    }
                    else {
                        s1 = l1.h(p0, 0x54FB9B86, 0x7F130914, p0, false);  // string:select_all "전체선택"
                    }
                    y y0 = M.w.a(j.c, d.m, p0, 0);
                    int v2 = p0.P;
                    i0 i00 = p0.m();
                    q q0 = r0.a.d(p0, androidx.compose.foundation.layout.d.c);
                    P0.k.y.getClass();
                    P0.i i1 = P0.j.b;
                    p0.e0();
                    if(p0.O) {
                        p0.l(i1);
                    }
                    else {
                        p0.o0();
                    }
                    w.x(p0, y0, P0.j.f);
                    w.x(p0, i00, P0.j.e);
                    h h2 = P0.j.g;
                    if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                        A7.d.q(v2, p0, v2, h2);
                    }
                    w.x(p0, q0, P0.j.d);
                    if(drawerPlaylistInfo0 == null || !kotlin.jvm.internal.q.b(drawerPlaylistInfo0.getContsTypeCode(), "N10078")) {
                        s3 = drawerPlaylistInfo0 == null ? null : drawerPlaylistInfo0.getTitle();
                        if(s3 == null) {
                            s3 = "";
                        }
                    }
                    else {
                        String s2 = ForUUtils.replaceNicknameWithMarkup(drawerPlaylistInfo0.getTitle(), "<b>MAINREPLACE</b>", drawerPlaylistInfo0.getTitleReplace(), 10);
                        kotlin.jvm.internal.q.d(s2);
                        s3 = s2;
                    }
                    boolean z3 = p0.i(drawerSongFragment0);
                    com.iloen.melon.player.playlist.drawernew.h h3 = p0.N();
                    if(z3 || h3 == v0) {
                        h3 = new com.iloen.melon.player.playlist.drawernew.h(drawerSongFragment0, 1);
                        p0.l0(h3);
                    }
                    DrawerSongFragmentKt.b(s3, h3, p0, 0);
                    if(s1.length() > 0) {
                        p0.a0(0x8C93B01B);
                        boolean z4 = p0.i(drawerSongFragment0);
                        com.iloen.melon.player.playlist.drawernew.h h4 = p0.N();
                        if(z4 || h4 == v0) {
                            h4 = new com.iloen.melon.player.playlist.drawernew.h(drawerSongFragment0, 2);
                            p0.l0(h4);
                        }
                        boolean z5 = p0.i(drawerSongFragment0);
                        com.iloen.melon.player.playlist.drawernew.h h5 = p0.N();
                        if(z5 || h5 == v0) {
                            h5 = new com.iloen.melon.player.playlist.drawernew.h(drawerSongFragment0, 3);
                            p0.l0(h5);
                        }
                        boolean z6 = p0.i(drawerSongFragment0);
                        com.iloen.melon.player.playlist.drawernew.h h6 = p0.N();
                        if(z6 || h6 == v0) {
                            h6 = new com.iloen.melon.player.playlist.drawernew.h(drawerSongFragment0, 4);
                            p0.l0(h6);
                        }
                        boolean z7 = p0.i(drawerSongFragment0);
                        com.iloen.melon.player.playlist.drawernew.h h7 = p0.N();
                        if(z7 || h7 == v0) {
                            h7 = new com.iloen.melon.player.playlist.drawernew.h(drawerSongFragment0, 5);
                            p0.l0(h7);
                        }
                        z8 = list0 instanceof Collection;
                        DrawerSongFragmentKt.a(s1, z1, ((Ib.b)object4), z2, ((c0)object3), h4, h5, h6, h7, p0, 0, 0);
                        c00 = (c0)object3;
                    }
                    else {
                        z8 = list0 instanceof Collection;
                        c00 = (c0)object3;
                        p0.a0(-1950857748);
                    }
                    p0.p(false);
                    if(((K4)object2) instanceof com.iloen.melon.player.playlist.drawernew.DrawerSongUiState.Idle) {
                        boolean z9 = false;
                        p0.a0(0x8CA380E0);
                        if(!z8 || !list0.isEmpty()) {
                            for(Object object7: list0) {
                                if(((DrawerSongListItemData)object7).isSelectedForSelectRepeat()) {
                                    z9 = true;
                                    break;
                                }
                            }
                        }
                        M m0 = M.p.d(d.a, false);
                        int v3 = p0.P;
                        i0 i01 = p0.m();
                        q q1 = r0.a.d(p0, n0);
                        P0.k.y.getClass();
                        P0.i i2 = P0.j.b;
                        p0.e0();
                        if(p0.O) {
                            p0.l(i2);
                        }
                        else {
                            p0.o0();
                        }
                        w.x(p0, m0, P0.j.f);
                        w.x(p0, i01, P0.j.e);
                        h h8 = P0.j.g;
                        if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                            A7.d.q(v3, p0, v3, h8);
                        }
                        w.x(p0, q1, P0.j.d);
                        StateFlow stateFlow0 = ((DrawerSongFragmentViewModel)drawerSongFragment0.getViewModel()).isToolbarVisible();
                        boolean z10 = p0.i(drawerSongFragment0);
                        boolean z11 = p0.e(c00.ordinal());
                        f f0 = p0.N();
                        if(z10 || z11 || f0 == v0) {
                            f0 = new f(1, drawerSongFragment0, c00);
                            p0.l0(f0);
                        }
                        boolean z12 = p0.i(drawerSongFragment0);
                        com.iloen.melon.player.playlist.drawernew.i i3 = p0.N();
                        if(z12 || i3 == v0) {
                            i3 = new com.iloen.melon.player.playlist.drawernew.i(drawerSongFragment0, 0);
                            p0.l0(i3);
                        }
                        boolean z13 = p0.i(drawerSongFragment0);
                        com.iloen.melon.player.playlist.drawernew.i i4 = p0.N();
                        if(z13 || i4 == v0) {
                            i4 = new com.iloen.melon.player.playlist.drawernew.i(drawerSongFragment0, 1);
                            p0.l0(i4);
                        }
                        boolean z14 = p0.i(drawerSongFragment0);
                        com.iloen.melon.player.playlist.drawernew.i i5 = p0.N();
                        if(z14 || i5 == v0) {
                            i5 = new com.iloen.melon.player.playlist.drawernew.i(drawerSongFragment0, 2);
                            p0.l0(i5);
                        }
                        boolean z15 = p0.i(drawerSongFragment0);
                        com.iloen.melon.player.playlist.drawernew.k k0 = p0.N();
                        if(z15 || k0 == v0) {
                            k0 = new com.iloen.melon.player.playlist.drawernew.k(drawerSongFragment0, 2);
                            p0.l0(k0);
                        }
                        boolean z16 = p0.i(drawerSongFragment0);
                        com.iloen.melon.player.playlist.drawernew.h h9 = p0.N();
                        if(z16 || h9 == v0) {
                            h9 = new com.iloen.melon.player.playlist.drawernew.h(drawerSongFragment0, 7);
                            p0.l0(h9);
                        }
                        boolean z17 = p0.i(drawerSongFragment0);
                        com.iloen.melon.player.playlist.drawernew.k k1 = p0.N();
                        if(z17 || k1 == v0) {
                            k1 = new com.iloen.melon.player.playlist.drawernew.k(drawerSongFragment0, 1);
                            p0.l0(k1);
                        }
                        boolean z18 = p0.i(drawerSongFragment0);
                        com.iloen.melon.player.playlist.drawernew.h h10 = p0.N();
                        if(z18 || h10 == v0) {
                            h10 = new com.iloen.melon.player.playlist.drawernew.h(drawerSongFragment0, 0);
                            p0.l0(h10);
                        }
                        DrawerSongListKt.DrawerSongList(list0, z9, stateFlow0, s0, sharedFlow0, f0, i3, i4, i5, k0, h9, k1, h10, p0, 0, 0, 0);
                        if(z) {
                            p0.a0(0xD9DF6804);
                            c1.H(r0.a.a(n0, new com.iloen.melon.player.playlist.drawernew.DrawerSongFragment.renderUi.lambda.39.lambda.38.lambda.37.lambda.36..inlined.noRippleClickable-YQRRFTQ.default.1(true, null, 0)), 0L, p0, 0, 2);
                        }
                        else {
                            p0.a0(-657896470);
                        }
                        p0.p(false);
                        p0.p(true);
                    }
                    else if(((K4)object2) instanceof com.iloen.melon.player.playlist.drawernew.DrawerSongUiState.Error) {
                        p0.a0(-1932288500);
                        c1.w(((com.iloen.melon.player.playlist.drawernew.DrawerSongUiState.Error)(((K4)object2))).getErrorUiState(), drawerSongFragment0.getDefaultNetworkErrorHandle().a(), drawerSongFragment0.getDefaultNetworkErrorHandle().b(), 0.0f, 0.0f, p0, 0, 24);
                    }
                    else if(((K4)object2) instanceof com.iloen.melon.player.playlist.drawernew.DrawerSongUiState.Notification) {
                        p0.a0(0x8CD9D158);
                        c1.y(((com.iloen.melon.player.playlist.drawernew.DrawerSongUiState.Notification)(((K4)object2))).getNotificationUiState(), p0, 0);
                    }
                    else {
                        p0.a0(-1950857748);
                    }
                    p0.p(false);
                    p0.p(true);
                    return h0;
                }
                ((p)(((l)object0))).T();
                return h0;
            }
        }
    }
}

