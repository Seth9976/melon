package m9;

import Ac.L;
import Ac.V;
import Cb.i;
import O.j;
import U4.F;
import Ub.v;
import X0.u;
import android.content.Context;
import androidx.fragment.app.I;
import androidx.fragment.app.w;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.musicwave.MusicWaveLogInfoForMiniPlayer;
import com.iloen.melon.player.playlist.tiara.MixUpPlaylistTiaraLogHelper;
import com.iloen.melon.premium.PremiumPlaylistEntity;
import com.iloen.melon.userstore.entity.ExcludedArtistEntity;
import com.iloen.melon.userstore.entity.RestoreDataEntity;
import com.iloen.melon.userstore.entity.TabMenuShortcutEntity;
import com.iloen.melon.userstore.entity.TagEntity;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.track.Event;
import com.melon.ui.F1;
import com.melon.ui.H1;
import com.melon.ui.I4;
import com.melon.ui.L1;
import com.melon.ui.N1;
import com.melon.ui.V1;
import com.melon.ui.X1;
import com.melon.ui.e2;
import com.melon.ui.f2;
import com.melon.ui.i2;
import com.melon.ui.j2;
import com.melon.ui.k2;
import com.melon.ui.k3;
import com.melon.ui.playback.VideoControllerHelper;
import com.melon.ui.playermusic.BgType.SpecialImage;
import com.melon.ui.playermusic.BgType.SpecialVideo;
import com.melon.ui.popup.context.more.ExtraProperties.Link;
import com.melon.ui.popup.context.more.ExtraProperties;
import com.melon.ui.popup.context.more.MelonBottomSheetComposeDialogFragment;
import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import com.melon.ui.w1;
import com.melon.ui.x1;
import d3.g;
import ie.H;
import ie.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.q;
import oc.Q;
import pc.a;
import pc.c;
import q8.b;
import q8.d;
import q8.f;
import q8.h;
import qd.J;
import rd.B0;
import rd.K1;
import rd.P;
import rd.c0;
import rd.d0;
import rd.e0;
import td.g0;
import td.n0;
import ud.C;
import ud.f0;
import we.k;
import we.n;
import xc.s;
import xc.z;
import zd.M;
import zd.o;
import zd.x;

public final class l implements k {
    public final int a;
    public final Object b;
    public final Object c;

    public l(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        m m0;
        Playable playable1;
        switch(this.a) {
            case 0: {
                MixUpPlaylistTiaraLogHelper mixUpPlaylistTiaraLogHelper0 = (MixUpPlaylistTiaraLogHelper)this.b;
                c c0 = (c)this.c;
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                mixUpPlaylistTiaraLogHelper0.c(((d)object0));
                b b1 = (b)((d)object0).c;
                if(b1 == null) {
                    b b2 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    b2.a(new m9.d(15));
                    ((d)object0).c = b2;
                }
                else {
                    b1.a(new m9.d(15));
                }
                ((d)object0).b(new m9.b(mixUpPlaylistTiaraLogHelper0, 13));
                ((h)((d)object0).b).a = mixUpPlaylistTiaraLogHelper0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                if(c0 instanceof a) {
                    f f0 = (f)((d)object0).f;
                    if(f0 != null) {
                        f0.a = ((a)c0).c;
                        f0.b = ((a)c0).d;
                        return H.a;
                    }
                    f f1 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
                    f1.a = ((a)c0).c;
                    f1.b = ((a)c0).d;
                    ((d)object0).f = f1;
                }
                return H.a;
            }
            case 1: {
                return ((H8.h)((o9.b)this.b).d).handleMultiple(((G4.a)object0), ((List)this.c));
            }
            case 2: {
                ((Eb.f)((o9.b)this.b).c).insert(((G4.a)object0), ((PremiumPlaylistEntity)this.c));
                return null;
            }
            case 3: {
                w w0 = (w)this.c;
                q.g(((StringBuilder)object0), "$this$buildDebug");
                ((StringBuilder)object0).append("dismissDialogIfExist()");
                i.a(((StringBuilder)object0), "activity: " + i.o(((pd.d)this.b).getActivity()));
                i.a(((StringBuilder)object0), "dialog: " + (w0 == null ? null : i.o(w0)));
                return H.a;
            }
            case 4: {
                Object object1 = null;
                VideoControllerHelper videoControllerHelper0 = (VideoControllerHelper)this.c;
                Q q0 = (Q)((m)this.b).a;
                fc.a a0 = (fc.a)((m)this.b).b;
                String s = a0.c;
                long v = a0.e;
                Playable playable0 = e1.b.y(q0);
                if(playable0 != null) {
                    playable1 = playable0;
                }
                else if(s.length() == 0) {
                    playable1 = null;
                }
                else {
                    String s1 = F.Y(s).a;
                    for(Object object2: e1.b.B(q0)) {
                        if(q.b("", s1)) {
                            object1 = object2;
                            break;
                        }
                        if(false) {
                            break;
                        }
                    }
                    playable1 = (Playable)object1;
                }
                if(playable1 == null || !playable1.isOnAir()) {
                    long v1 = 0L;
                    long v2 = 0L;
                    long v3 = a0.d;
                    if(Long.compare(v3, 0x8000000000000001L) == 0) {
                        if(playable1 != null) {
                            v2 = playable1.getDuration();
                        }
                        m0 = new m(0L, v2);
                    }
                    else if(v == 0x8000000000000001L) {
                        if(playable1 != null) {
                            v1 = playable1.getDuration();
                        }
                        m0 = new m(0L, v1);
                    }
                    else {
                        m0 = new m(v3, v);
                    }
                }
                else {
                    m0 = new m(100L, 100L);
                }
                long v4 = ((Number)m0.a).longValue();
                long v5 = ((Number)m0.b).longValue();
                boolean z1 = g.N(a0);
                String s2 = StringUtils.INSTANCE.formatPlayerTime(v4);
                String s3 = StringUtils.INSTANCE.formatPlayerTime(v4);
                String s4 = StringUtils.INSTANCE.formatPlayerDurationTime(v5);
                boolean z2 = ((v)videoControllerHelper0.h).a();
                return pd.a.a(((pd.a)object0), a0.b, z1, s2, s3, s4, v4, v5, 0L, false, z2, playable1, 0x180);
            }
            case 5: {
                q.g(((O.w)object0), "$this$MelonLazyColumn");
                V v6 = new V(this.b, 13);
                m0.b b3 = new m0.b(0xBEF78951, new L(21, this.b, ((J)this.c)), true);
                ((j)(((O.w)object0))).u(((List)this.b).size(), null, v6, b3);
                return H.a;
            }
            case 6: {
                Playable playable2 = (Playable)this.b;
                P p0 = (P)this.c;
                q.g(((MelonBottomSheetItem)object0), "item");
                if(playable2 != null) {
                    Link extraProperties$Link0 = null;
                    M m1 = ((MelonBottomSheetItem)object0).a;
                    if(m1 == x.f.a) {
                        e0 e00 = p0.o();
                        Playable playable3 = (Playable)e00.b.invoke();
                        d d0 = new d();  // 初始化器: LQb/h;-><init>()V
                        e00.b(d0, ActionKind.ClickContent, playable3);
                        ((h)d0.b).a = e00.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        d0.b(new c0(e00, 8));
                        d0.e(new m9.k(11, playable3));
                        ((Event)d0.p()).track();
                        q.f("", "getSongidString(...)");
                        p0.q(new f2(playable2, ""));
                        return H.a;
                    }
                    if(m1 == x.g.a) {
                        e0 e01 = p0.o();
                        Playable playable4 = (Playable)e01.b.invoke();
                        d d1 = new d();  // 初始化器: LQb/h;-><init>()V
                        e01.b(d1, ActionKind.ClickContent, playable4);
                        ((h)d1.b).a = e01.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        d1.b(new c0(e01, 9));
                        d1.e(new m9.k(12, playable4));
                        ((Event)d1.p()).track();
                        p0.q(new w1(playable2));
                        return H.a;
                    }
                    if(m1 == x.h.a) {
                        e0 e02 = p0.o();
                        Playable playable5 = (Playable)e02.b.invoke();
                        d d2 = new d();  // 初始化器: LQb/h;-><init>()V
                        e02.b(d2, ActionKind.ClickContent, playable5);
                        ((h)d2.b).a = e02.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        d2.b(new c0(e02, 7));
                        d2.e(new m9.k(10, playable5));
                        ((Event)d2.p()).track();
                        p0.q(new x1(playable2, null, 2));
                        return H.a;
                    }
                    if(m1 == x.m.a) {
                        e0 e03 = p0.o();
                        e1.m.F(new d0(e03, ((Playable)e03.b.invoke()), 1)).track();
                        p0.q(new N1(playable2));
                        return H.a;
                    }
                    if(m1 == x.p.a) {
                        e0 e04 = p0.o();
                        Playable playable6 = (Playable)e04.b.invoke();
                        d d3 = new d();  // 初始化器: LQb/h;-><init>()V
                        e04.b(d3, ActionKind.ClickContent, playable6);
                        ((h)d3.b).a = e04.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        d3.b(new c0(e04, 5));
                        d3.e(new m9.k(7, playable6));
                        ((Event)d3.p()).track();
                        p0.q(new e2(""));
                        return H.a;
                    }
                    if(m1 == x.Z.a) {
                        e0 e05 = p0.o();
                        Playable playable7 = (Playable)e05.b.invoke();
                        d d4 = new d();  // 初始化器: LQb/h;-><init>()V
                        e05.b(d4, ActionKind.ClickContent, playable7);
                        ((h)d4.b).a = e05.a(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
                        d4.b(new c0(e05, 6));
                        d4.e(new m9.k(9, playable7));
                        ((Event)d4.p()).track();
                        p0.q(new H1("", "", ((K1)p0.getViewModel()).getMenuId()));
                        return H.a;
                    }
                    if(m1 == x.s.a) {
                        e0 e06 = p0.o();
                        Playable playable8 = (Playable)e06.b.invoke();
                        d d5 = new d();  // 初始化器: LQb/h;-><init>()V
                        Playable playable9 = (Playable)e06.b.invoke();
                        e06.b(d5, ActionKind.ClickContent, playable9);
                        ((h)d5.b).a = e06.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        d5.b(new c0(e06, 1));
                        d5.e(new m9.k(4, playable8));
                        ((Event)d5.p()).track();
                        p0.q(new L1(playable2));
                        return H.a;
                    }
                    if(m1 == x.B.a) {
                        e0 e07 = p0.o();
                        Playable playable10 = (Playable)e07.b.invoke();
                        d d6 = new d();  // 初始化器: LQb/h;-><init>()V
                        Playable playable11 = (Playable)e07.b.invoke();
                        e07.b(d6, ActionKind.ClickContent, playable11);
                        ((h)d6.b).a = e07.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        d6.b(new c0(e07, 13));
                        d6.e(new m9.k(17, playable10));
                        ((Event)d6.p()).track();
                        ExtraProperties extraProperties0 = ((MelonBottomSheetItem)object0).f;
                        if(extraProperties0 instanceof Link) {
                            extraProperties$Link0 = (Link)extraProperties0;
                        }
                        if(extraProperties$Link0 != null) {
                            String s5 = extraProperties$Link0.a;
                            String s6 = "";
                            if(s5 == null) {
                                s5 = "";
                            }
                            String s7 = extraProperties$Link0.b;
                            if(s7 != null) {
                                s6 = s7;
                            }
                            p0.q(new i2(s5, s6));
                            return H.a;
                        }
                    }
                    else {
                        LogU.debug$default(p0.i, "handleMoreClickContextMenu() unknown type=" + ((MelonBottomSheetItem)object0), null, false, 6, null);
                    }
                }
                return H.a;
            }
            case 7: {
                ActionKind actionKind0 = (ActionKind)this.b;
                q.g(((b)object0), "$this$common");
                ((b)object0).a = ((e0)this.c).a(0x7F130E4C);  // string:tiara_common_section_dj_malrang_player "말랑이플레이어"
                ((b)object0).b = ((e0)this.c).a(0x7F130E3E);  // string:tiara_common_page_dj_malrang_player_more_view "먈랑이플레이어_더보기"
                if(actionKind0 != null) {
                    ((b)object0).c = actionKind0;
                }
                return H.a;
            }
            case 8: {
                q.g(((q8.a)object0), "$this$click");
                ((q8.a)object0).a = ((B0)this.b).a(0x7F130DF9);  // string:tiara_common_layer1_lyric "가사"
                ((q8.a)object0).g = ((B0)this.b).a(0x7F130D4A);  // string:tiara_click_copy_lyric_size "가사확대"
                ((q8.a)object0).e = (String)this.c;
                return H.a;
            }
            case 9: {
                ActionKind actionKind1 = (ActionKind)this.b;
                q.g(((b)object0), "$this$common");
                ((b)object0).a = ((B0)this.c).a(0x7F130E4C);  // string:tiara_common_section_dj_malrang_player "말랑이플레이어"
                ((b)object0).b = ((B0)this.c).a(0x7F130E3D);  // string:tiara_common_page_dj_malrang_player "말랑이플레이어_재생화면"
                if(actionKind1 != null) {
                    ((b)object0).c = actionKind1;
                }
                return H.a;
            }
            case 10: {
                ((s8.a)this.b).b.insert(((G4.a)object0), ((s8.b)this.c));
                return null;
            }
            case 11: {
                q.g(((f)object0), "$this$pageMeta");
                MusicWaveLogInfoForMiniPlayer musicWaveLogInfoForMiniPlayer0 = ((rc.m)(((rc.a)(((oc.H)this.b))))).c().e;
                String s8 = null;
                ((f)object0).a = musicWaveLogInfoForMiniPlayer0 == null ? null : musicWaveLogInfoForMiniPlayer0.getKey();
                ((f)object0).b = ((P0.d0)this.c).d(0x7F130EFD);  // string:tiara_meta_type_music_wave "뮤직웨이브"
                if(musicWaveLogInfoForMiniPlayer0 != null) {
                    s8 = musicWaveLogInfoForMiniPlayer0.getTitle();
                }
                ((f)object0).c = s8;
                return H.a;
            }
            case 12: {
                q.g(((X0.x)object0), "$this$semantics");
                u.h(((X0.x)object0), com.melon.ui.playermusic.l.f(((Context)this.b), ((SpecialImage)this.c)));
                return H.a;
            }
            case 13: {
                q.g(((X0.x)object0), "$this$semantics");
                u.h(((X0.x)object0), com.melon.ui.playermusic.l.f(((Context)this.b), ((SpecialVideo)this.c)));
                return H.a;
            }
            case 14: {
                ActionKind actionKind2 = (ActionKind)this.b;
                q.g(((b)object0), "$this$common");
                ((b)object0).a = ((g0)this.c).a(0x7F130E53);  // string:tiara_common_section_music_player "곡플레이어"
                ((b)object0).b = ((g0)this.c).a(0x7F130E45);  // string:tiara_common_page_music_player_more_view "곡플레이어_더보기"
                if(actionKind2 != null) {
                    ((b)object0).c = actionKind2;
                }
                return H.a;
            }
            case 15: {
                q.g(((q8.a)object0), "$this$click");
                ((q8.a)object0).a = ((n0)this.b).a(0x7F130DF9);  // string:tiara_common_layer1_lyric "가사"
                ((q8.a)object0).g = ((n0)this.b).a(0x7F130D4A);  // string:tiara_click_copy_lyric_size "가사확대"
                ((q8.a)object0).e = (String)this.c;
                return H.a;
            }
            case 16: {
                ActionKind actionKind3 = (ActionKind)this.b;
                q.g(((b)object0), "$this$common");
                ((b)object0).a = ((n0)this.c).a(0x7F130E53);  // string:tiara_common_section_music_player "곡플레이어"
                ((b)object0).b = ((n0)this.c).a(0x7F130E44);  // string:tiara_common_page_music_player "곡플레이어_재생화면"
                if(actionKind3 != null) {
                    ((b)object0).c = actionKind3;
                }
                return H.a;
            }
            case 17: {
                q.g(((O.w)object0), "$this$MelonLazyColumn");
                V v7 = new V(this.b, 14);
                m0.b b4 = new m0.b(0xBEF78951, new L(23, this.b, ((Integer)this.c)), true);
                ((j)(((O.w)object0))).u(((List)this.b).size(), null, v7, b4);
                return H.a;
            }
            case 18: {
                C c1 = (C)this.b;
                I4 i40 = (I4)this.c;
                q.g(((xd.h)object0), "action");
                if(((xd.h)object0) instanceof xd.g) {
                    c1.onUiEvent(new ud.c0(((f0)i40).b, ((xd.g)(((xd.h)object0))).b));
                }
                return H.a;
            }
            case 19: {
                q.g(((I)object0), "it");
                return !(((I)object0) instanceof MelonBottomSheetComposeDialogFragment) || !q.b(((zd.c0)((MelonBottomSheetComposeDialogFragment)(((I)object0))).getViewModel()).i, new o(((String)this.b), ((ArrayList)this.c))) ? false : true;
            }
            case 20: {
                ((Boolean)object0).booleanValue();
                ((n)this.b).invoke(((m)this.c).a, ((Boolean)object0));
                return H.a;
            }
            case 21: {
                ((w9.d)this.b).e.insert(((G4.a)object0), ((y9.d)this.c));
                return H.a;
            }
            case 22: {
                ((w9.d)this.b).c.insert(((G4.a)object0), ((ExcludedArtistEntity)this.c));
                return H.a;
            }
            case 23: {
                ((w9.d)this.b).d.insert(((G4.a)object0), ((y9.b)this.c));
                return H.a;
            }
            case 24: {
                ((w9.d)this.b).b.insert(((G4.a)object0), ((y9.a)this.c));
                return null;
            }
            case 25: {
                ((Eb.f)((x9.a)this.b).b).insert(((G4.a)object0), ((RestoreDataEntity)this.c));
                return null;
            }
            case 26: {
                return ((Eb.f)((x9.b)this.b).b).insertAndReturnId(((G4.a)object0), ((TabMenuShortcutEntity)this.c));
            }
            case 27: {
                ((Eb.f)((x9.c)this.b).c).insert(((G4.a)object0), ((TagEntity)this.c));
                return null;
            }
            case 28: {
                s s9 = (s)this.b;
                zd.b b5 = (zd.b)this.c;
                q.g(((k2)object0), "popupEvent");
                if(((k2)object0) instanceof X1) {
                    s9.handleMoreListPopupOnEvent(s9, new xc.j(1, s9, s.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 7), b5, ((k2)object0));
                    return H.a;
                }
                if(((k2)object0) instanceof x1) {
                    s9.handleMoreListPopupOnEvent(s9, new xc.j(1, s9, s.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 8), b5, ((k2)object0));
                    return H.a;
                }
                if(((k2)object0) instanceof V1) {
                    ArrayList arrayList1 = wc.w.r(((wc.w)s9.getViewModel()));
                    if(!arrayList1.isEmpty()) {
                        xc.i i1 = new xc.i(0, s9, s.class, "unselectAll", "unselectAll()V", 0, 2);
                        xc.j j1 = new xc.j(1, s9, s.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 9);
                        k3.c(s9, s9, ((V1)(((k2)object0))).b, arrayList1, i1, j1, false, 0x60);
                        return H.a;
                    }
                    else if(((wc.x)s9.getViewModel()).v()) {
                        ToastManager.show(0x7F130023);  // string:add_available_empty "담기 가능한 곡이 없습니다."
                        return H.a;
                    }
                }
                else if(((k2)object0) instanceof j2) {
                    if(q.b(((j2)(((k2)object0))).c, "N10002")) {
                        s9.sendUserEvent(new Ic.e0(((j2)(((k2)object0))).a, ((j2)(((k2)object0))).b));
                        return H.a;
                    }
                }
                else if(((k2)object0) instanceof F1) {
                    s9.handleMoreListPopupOnEvent(s9, new xc.j(1, s9, s.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 10), b5, ((k2)object0));
                }
                return H.a;
            }
            default: {
                z z0 = (z)this.b;
                zd.b b0 = (zd.b)this.c;
                q.g(((k2)object0), "popupEvent");
                if(((k2)object0) instanceof X1) {
                    z0.handleMoreListPopupOnEvent(z0, new xc.j(1, z0, z.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 15), b0, ((k2)object0));
                    return H.a;
                }
                if(((k2)object0) instanceof x1) {
                    z0.handleMoreListPopupOnEvent(z0, new xc.j(1, z0, z.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 16), b0, ((k2)object0));
                    return H.a;
                }
                if(((k2)object0) instanceof V1) {
                    ArrayList arrayList0 = wc.w.r(((wc.w)z0.getViewModel()));
                    if(!arrayList0.isEmpty()) {
                        xc.i i0 = new xc.i(0, z0, z.class, "unselectAll", "unselectAll()V", 0, 4);
                        xc.j j0 = new xc.j(1, z0, z.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 17);
                        k3.c(z0, z0, ((V1)(((k2)object0))).b, arrayList0, i0, j0, false, 0x60);
                        return H.a;
                    }
                    else if(((wc.x)z0.getViewModel()).v()) {
                        ToastManager.show(0x7F130023);  // string:add_available_empty "담기 가능한 곡이 없습니다."
                        return H.a;
                    }
                }
                else if(((k2)object0) instanceof j2) {
                    if(q.b(((j2)(((k2)object0))).c, "N10002")) {
                        z0.sendUserEvent(new Ic.e0(((j2)(((k2)object0))).a, ((j2)(((k2)object0))).b));
                        return H.a;
                    }
                }
                else if(((k2)object0) instanceof F1) {
                    z0.handleMoreListPopupOnEvent(z0, new xc.j(1, z0, z.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 18), b0, ((k2)object0));
                }
                return H.a;
            }
        }
    }
}

