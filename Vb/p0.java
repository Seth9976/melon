package Vb;

import Ac.K;
import Ac.L;
import Ac.m2;
import Ac.p2;
import Bd.e;
import Cb.i;
import F.s;
import Ld.p;
import O.j;
import O.w;
import Tf.o;
import Uc.a;
import Vc.r0;
import X0.u;
import X0.x;
import Xc.g;
import Yc.E;
import android.net.Uri;
import android.webkit.URLUtil;
import androidx.compose.foundation.S;
import androidx.fragment.app.I;
import androidx.lifecycle.M;
import cd.X;
import cd.c;
import cd.d;
import cd.v2;
import com.iloen.melon.custom.e1;
import com.iloen.melon.net.v4x.common.BannerBase;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.GenreInfoBase;
import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible.Content;
import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible.Header;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.CONTENTS;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.ChartHeader;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TAGCONTENTS;
import com.iloen.melon.net.v6x.response.BannerRes.RESPONSE;
import com.iloen.melon.net.v6x.response.BannerRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.db.PlaylistDao_Impl;
import com.iloen.melon.playback.playlist.db.entity.MusicEntity;
import com.iloen.melon.player.playlist.PlaylistMainTiaraLogHelper;
import com.iloen.melon.player.playlist.VideoPlaylistFragment;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.billing.SingleLiveEvent;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.data.ViewImpContent;
import com.melon.data.database.entity.BannerPopupEntity;
import com.melon.data.database.entity.LocalPlaybackLogEntity;
import com.melon.data.database.entity.MusicSearchHistoryEntity;
import com.melon.data.database.entity.PremiumOffPlayLogEntity;
import com.melon.ui.K4;
import com.melon.ui.Z0;
import com.melon.ui.a1;
import com.melon.ui.b1;
import com.melon.ui.c1;
import com.melon.ui.d1;
import dd.Q;
import ed.F0;
import ed.d0;
import ed.i0;
import ed.m0;
import ed.t0;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import k8.Y;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.q;
import m0.b;
import q8.f;
import va.e0;
import we.k;
import xd.h;

public final class p0 implements k {
    public final int a;
    public final Object b;
    public final Object c;

    public p0(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        String s18;
        GenreInfoBase genreInfoBase0;
        String s = "";
        String s1 = null;
        boolean z = false;
        H h0 = H.a;
        Object object1 = this.c;
        Object object2 = this.b;
        switch(this.a) {
            case 0: {
                q.g(((StringBuilder)object0), "$this$buildDebug");
                ((StringBuilder)object0).append("removeData()");
                i.a(((StringBuilder)object0), "Uri[Previous]: " + ((Uri)object2));
                i.a(((StringBuilder)object0), "Uri[Update]: " + ((Uri)object1));
                return h0;
            }
            case 1: {
                q.g(((r0)object0), "event");
                if(!(((r0)object0) instanceof r0)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                int v = ((r0)object0).a;
                int v1 = ((F)object2).a;
                if(v > v1) {
                    Wc.k.f(((Wc.k)object1), ActionKind.ClickContent, "", null, "", 0, null, null, null, 0xF4);
                }
                else if(v < v1) {
                    Wc.k.f(((Wc.k)object1), ActionKind.ClickContent, "", null, "", 0, null, null, null, 0xF4);
                }
                ((F)object2).a = v;
                return h0;
            }
            case 2: {
                q.g(((w)object0), "$this$MelonLazyColumn");
                ((j)(((w)object0))).u(((List)object2).size(), new p(25, new a(3), ((List)object2)), new K(((List)object2), 24), new b(0xBEF78951, new p2(((List)object2), ((g)object1), ((List)object2)), true));
                return h0;
            }
            case 3: {
                q.g(((w)object0), "$this$MelonLazyColumn");
                ((j)(((w)object0))).u(((ArrayList)object2).size(), new p(26, new a(4), ((ArrayList)object2)), new s(17, ((ArrayList)object2)), new b(0xBEF78951, new L(13, ((ArrayList)object2), ((E)object1)), true));
                return h0;
            }
            case 4: {
                q.g(((q8.j)object0), "$this$tiaraViewLogBuilder");
                ((q8.j)object0).c(new p0(6, ((q8.j)object0), ((ad.p)object2)));
                ((q8.j)object0).d(new m2(((q8.j)object0), ((ViewImpContent)object1), ((ad.p)object2), 23));
                return h0;
            }
            case 5: {
                q.g(((f)object0), "$this$eventMeta");
                ((f)object0).a = (String)object2;
                String s2 = ((Header)object1).getContsTypeCode();
                if(s2 != null) {
                    s = s2;
                }
                ((f)object0).b = p8.b.a(s);
                return h0;
            }
            case 6: {
                q.g(((q8.b)object0), "$this$common");
                p8.s s3 = ((ad.p)object1).b;
                ((q8.b)object0).a = s3 == null ? null : s3.a;
                p8.s s4 = ((ad.p)object1).b;
                ((q8.b)object0).b = s4 == null ? null : s4.b;
                ((q8.j)object2).getClass();
                p8.s s5 = ((ad.p)object1).b;
                if(s5 != null) {
                    s1 = s5.c;
                }
                if(s1 != null) {
                    s = s1;
                }
                ((q8.j)object2).a = s;
                return h0;
            }
            case 7: {
                q.g(((w)object0), "$this$MelonLazyRow");
                ((j)(((w)object0))).u(((List)object2).size(), new S(9, new a(12), ((List)object2)), new K(((List)object2), 28), new b(0xBEF78951, new L(14, ((List)object2), ((cd.F)object1)), true));
                return h0;
            }
            case 8: {
                q.g(((w)object0), "$this$LazyColumn");
                ((j)(((w)object0))).u(((List)object2).size(), null, new X(((List)object2), 1), new b(0xDA480CDF, new L(15, ((List)object2), ((Content)object1)), true));
                return h0;
            }
            case 9: {
                if(((e1)object2).l.compareAndSet(true, false)) {
                    ((M)object1).onChanged(object0);
                }
                return h0;
            }
            case 10: {
                return ((PlaylistDao_Impl)object2).lambda$insertMusicEntity$1(((MusicEntity)object1), ((G4.a)object0));
            }
            case 11: {
                q.g(((q8.a)object0), "$this$click");
                String s6 = (String)((PlaylistMainTiaraLogHelper)object2).f.invoke(((Playable)object1));
                if(s6 != null) {
                    ((q8.a)object0).h = s6;
                }
                String s7 = (String)((PlaylistMainTiaraLogHelper)object2).g.invoke(((Playable)object1));
                if(s7 != null) {
                    ((q8.a)object0).i = s7;
                }
                ((q8.a)object0).a = ((PlaylistMainTiaraLogHelper)object2).a(0x7F130F9F);  // string:tiara_playlist_controller_layer1 "재생목록패널"
                return h0;
            }
            case 12: {
                q.g(((q8.a)object0), "$this$click");
                ((q8.a)object0).a = ((PlaylistMainTiaraLogHelper)object2).a(0x7F130DF3);  // string:tiara_common_layer1_gnb "GNB"
                ((q8.a)object0).g = (String)object1;
                return h0;
            }
            case 13: {
                q.g(((f)object0), "$this$pageMeta");
                ((f)object0).b = ((VideoPlaylistFragment)object2).getString(0x7F130EFE);  // string:tiara_meta_type_mv "영상"
                ((f)object0).a = "";
                ((f)object0).c = "";
                return h0;
            }
            case 14: {
                if(((SingleLiveEvent)object2).l.compareAndSet(true, false)) {
                    ((M)object1).onChanged(object0);
                }
                return h0;
            }
            case 15: {
                q.g(((h)object0), "action");
                if(((h)object0) instanceof xd.g) {
                    Navigator.openArtistInfo(((xd.g)(((h)object0))).b);
                    ((e)object2).invoke(((xd.g)(((h)object0))).b, ((xd.g)(((h)object0))).c, ((Playable)object1));
                }
                return h0;
            }
            case 16: {
                String s8 = "음악재생";
                q.g(((p8.f)object0), "$this$getTiaraEventBuilder");
                ((p8.f)object0).d = ActionKind.PlayMusic;
                if(((I)object2).getContext() == null) {
                    s8 = "";
                }
                String s9 = "더보기 팝업";
                ((p8.f)object0).a = s8;
                if(((I)object2).getContext() == null) {
                    s9 = "";
                }
                String s10 = "이 곡으로 믹스업";
                ((p8.f)object0).y = s9;
                if(((I)object2).getContext() == null) {
                    s10 = "";
                }
                ((p8.f)object0).F = s10;
                ((p8.f)object0).o = "";
                if(((I)object2).getContext() != null) {
                    s = "곡";
                }
                ((p8.f)object0).p = s;
                ((p8.f)object0).q = "";
                ((p8.f)object0).e = "";
                ((p8.f)object0).f = Y.i(ContsTypeCode.SONG_MIXUP, "code(...)");
                ((p8.f)object0).g = "";
                ((p8.f)object0).W = "1000003099";
                return (p8.f)object0;
            }
            case 17: {
                q.g(((cd.g)object0), "chartItemUserEvent");
                if(((cd.g)object0) instanceof c) {
                    cd.b b0 = ((c)(((cd.g)object0))).a;
                    Navigator.openAlbumInfo(b0.a.albumId);
                    ((dd.a)object2).getClass();
                    MelonPrefs.getInstance().setBoolean("useTabMusicChartNotice", true);
                    ActionKind actionKind0 = ActionKind.ClickContent;
                    ChartHeader mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader0 = b0.b;
                    if(mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader0 != null) {
                        s1 = mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader0.getChartTypeName();
                    }
                    ((dd.a)object2).p(actionKind0, (s1 == null ? "" : s1), b0.c, b0.d, b0.a, true);
                    return h0;
                }
                if(((cd.g)object0) instanceof d) {
                    cd.b b1 = ((d)(((cd.g)object0))).a;
                    MelonLinkExecutor.open(MelonLinkInfo.b(b1.b));
                    ((dd.a)object2).getClass();
                    MelonPrefs.getInstance().setBoolean("useTabMusicChartNotice", true);
                    ActionKind actionKind1 = ActionKind.ClickContent;
                    ChartHeader mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader1 = b1.b;
                    if(mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader1 != null) {
                        s1 = mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader1.getChartTypeName();
                    }
                    ((dd.a)object2).p(actionKind1, (s1 == null ? "" : s1), b1.c, b1.d, b1.a, false);
                    return h0;
                }
                if(((cd.g)object0) instanceof cd.e) {
                    cd.b b2 = ((cd.e)(((cd.g)object0))).b;
                    String s11 = b2.a.songId;
                    String s12 = s11 == null ? "" : s11;
                    if(s11 == null) {
                        s11 = "";
                    }
                    String s13 = Y.i(ContsTypeCode.SONG, "code(...)");
                    String s14 = b2.a.songName;
                    int v2 = b2.d;
                    ChartHeader mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader2 = ((Chart)((List)object1).get(((cd.e)(((cd.g)object0))).a)).getHeader();
                    if(mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader2 != null) {
                        s1 = mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader2.title;
                    }
                    dd.H.a(((dd.a)object2), s12, v2, s11, s13, (s14 == null ? "" : s14), null, null, 0, (s1 == null ? "" : s1), 0x3D0);
                    return h0;
                }
                if(!(((cd.g)object0) instanceof cd.f)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                cd.b b3 = ((cd.f)(((cd.g)object0))).a;
                ArrayList arrayList0 = b3.a.genreList;
                if(arrayList0 == null) {
                    genreInfoBase0 = null;
                }
                else {
                    for(Object object3: arrayList0) {
                        String s15 = ((GenreInfoBase)object3).genreCode;
                        q.f(s15, "genreCode");
                        if(!o.v0(s15, "GN", false)) {
                            continue;
                        }
                        goto label_167;
                    }
                    object3 = null;
                label_167:
                    genreInfoBase0 = (GenreInfoBase)object3;
                }
                if(genreInfoBase0 != null) {
                    z = true;
                }
                CONTENTS mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS0 = b3.a;
                p8.s s16 = ((dd.a)object2).b().b;
                if(s16 != null) {
                    s1 = s16.c;
                }
                ((dd.a)object2).h(e.k.z(Playable.from(mainMusicRes$RESPONSE$MELONCHART$Chart$CONTENTS0, s1, ((dd.a)object2).f)), z);
                ActionKind actionKind2 = ActionKind.PlayMusic;
                ChartHeader mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader3 = b3.b;
                if(mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader3 == null) {
                    s18 = "";
                }
                else {
                    String s17 = mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader3.getChartTypeName();
                    s18 = s17 == null ? "" : s17;
                }
                ((dd.a)object2).p(actionKind2, s18, b3.c, b3.d, b3.a, false);
                return h0;
            }
            case 18: {
                q.g(((f)object0), "$this$eventMeta");
                ((f)object0).a = ((TAGCONTENTS)object2).plylstseq;
                String s19 = ((TAGCONTENTS)object2).contstypecode;
                q.f(s19, "contstypecode");
                ((f)object0).b = p8.b.a(s19);
                ((f)object0).g = (String)object1;
                ((f)object0).c = ((TAGCONTENTS)object2).plylsttitleorg;
                return h0;
            }
            case 19: {
                q.g(((v2)object0), "userEvent");
                if(!(((v2)object0) instanceof v2)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                RESPONSE bannerRes$RESPONSE0 = ((BannerRes)object2).getResponse();
                if(bannerRes$RESPONSE0 != null) {
                    List list0 = bannerRes$RESPONSE0.getBannerList();
                    if(list0 != null) {
                        BannerBase bannerBase0 = (BannerBase)je.p.m0(list0);
                        if(bannerBase0 != null) {
                            ((Q)object1).getClass();
                            Uc.p p0 = dd.H.c(((Q)object1), ActionKind.ClickContent, null, 0, 0, null, false, null, 0, null, 0x3FE);
                            p0.e(new Ld.F(bannerBase0, 1));
                            p0.p().track();
                            if(((e0)va.o.a()).m()) {
                                MelonLinkExecutor.open(MelonLinkInfo.b(bannerBase0));
                                return h0;
                            }
                            if(URLUtil.isNetworkUrl(bannerBase0.linkurl)) {
                                Navigator.openLoginView(r8.f.h.buildUpon().appendQueryParameter("url", bannerBase0.linkurl).appendQueryParameter("type", bannerBase0.linktype).build());
                            }
                        }
                    }
                }
                return h0;
            }
            case 20: {
                return ((Eb.f)((ea.a)object2).b).insertAndReturnId(((G4.a)object0), ((BannerPopupEntity)object1));
            }
            case 21: {
                return ((Eb.f)((ea.b)object2).b).insertAndReturnId(((G4.a)object0), ((LocalPlaybackLogEntity)object1));
            }
            case 22: {
                return ((Eb.f)((ea.c)object2).c).insertAndReturnId(((G4.a)object0), ((MusicSearchHistoryEntity)object1));
            }
            case 23: {
                return ((Eb.f)((ea.d)object2).b).insertAndReturnId(((G4.a)object0), ((PremiumOffPlayLogEntity)object1));
            }
            case 24: {
                q.g(((x)object0), "$this$clearAndSetSemantics");
                String s20 = ((m0)object2).b ? ((ed.Z.a)object1).getString(0x7F130C37) : ((ed.Z.a)object1).getString(0x7F130C36);  // string:talkback_search_shortcut_last_Visited "최근 방문"
                q.d(s20);
                u.h(((x)object0), ", " + s20);
                u.k(((x)object0), 0);
                return h0;
            }
            case 25: {
                q.g(((x)object0), "$this$semantics");
                String s21 = ((fd.a)object2).b;
                String s22 = q.b(((fd.a)object2).a, "UP") ? ((ed.Z.a)object1).getString(0x7F130C62, new Object[]{s21}) : ((ed.Z.a)object1).getString(0x7F130C61, new Object[]{s21});  // string:talkback_step_up "%s단계 상승"
                q.f(s22, "getString(...)");
                u.h(((x)object0), s22);
                return h0;
            }
            case 26: {
                q.g(((w)object0), "$this$MelonLazyColumn");
                ((j)(((w)object0))).u(((List)object2).size(), null, new X(((List)object2), 8), new b(0xDA480CDF, new L(16, ((List)object2), ((ed.Z.a)object1)), true));
                return h0;
            }
            case 27: {
                return F0.i(((K4)object2), ((List)object1), ((K4)object0));
            }
            case 28: {
                q.g(((d1)object0), "it");
                if(((d1)object0) instanceof Z0) {
                    LogU.debug$default(((F0)object2).h, "hotKeywordResult is FetchResult.Error", null, false, 6, null);
                    return new ed.r0(((Z0)(((d1)object0))).a);
                }
                if(((d1)object0) instanceof c1) {
                    LogU.debug$default(((F0)object2).h, "hotKeywordResult is FetchResult.Success", null, false, 6, null);
                    i0 i00 = new i0(androidx.compose.runtime.w.s(new d0(((com.iloen.melon.net.v6x.response.SearchHotKeywordAndMenuListRes.RESPONSE)((c1)(((d1)object0))).a))));
                    ((F0)object2).m = i00;
                    ((List)object1).add(i00);
                    return new t0(((List)object1));
                }
                if(((d1)object0) instanceof b1) {
                    LogU.debug$default(((F0)object2).h, "hotKeywordResult is FechResult.NotificationScreen", null, false, 6, null);
                    return ((b1)(((d1)object0))).a;
                }
                if(!(((d1)object0) instanceof a1)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                return null;
            }
            default: {
                q.g(((x)object0), "$this$semantics");
                u.k(((x)object0), 0);
                u.h(((x)object0), U4.x.l(((gd.x)object2).c, " ", ((String)object1), " ", ((gd.x)object2).e));
                return h0;
            }
        }
    }
}

