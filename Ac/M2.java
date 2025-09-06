package Ac;

import Bd.s;
import Bd.v;
import Bd.y;
import Cc.O1;
import Dd.g1;
import F8.p;
import G.e;
import Gd.A;
import Gd.G;
import Gd.t;
import Hd.T;
import Hd.W;
import Hd.n0;
import Ld.i;
import M8.f;
import Nc.u0;
import Nc.v0;
import Nc.w0;
import O.j;
import Tf.o;
import Ub.m;
import Vb.p0;
import Vc.M;
import Vc.e0;
import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.compose.foundation.S;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.b1;
import b3.E;
import cd.X;
import cd.n2;
import com.iloen.melon.custom.CoverView;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventRemotePlayer.EventDlna;
import com.iloen.melon.eventbus.EventRemotePlayer;
import com.iloen.melon.fragments.MelonFragmentManager;
import com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment;
import com.iloen.melon.net.v4x.common.BannerBase;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v5x.response.GenreDetailRes.RESPONSE.GNRDETAILCONTENTS.LICENSE2TYPE.ALBUMLIST;
import com.iloen.melon.net.v5x.response.GenreDetailRes.RESPONSE.GNRDETAILCONTENTS.LICENSE2TYPE;
import com.iloen.melon.net.v6x.response.MyMusicInformStorageRes.RESPONSE.RECNTSONGINFO;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.player.playlist.PlaylistMainTiaraLogHelper;
import com.iloen.melon.player.playlist.VideoPlaylistFragment;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.template.TemplateData.DrawerPlaylistArtistMixTemplateDataBuilder;
import com.iloen.melon.utils.template.TemplateImageLoader;
import com.kakao.tiara.data.ContentList;
import com.kakao.tiara.data.ViewImpContent.Builder;
import com.kakao.tiara.data.ViewImpContent;
import com.melon.playlist.mixup.DjMalrangInfo;
import com.melon.ui.d1;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.r4;
import d5.n;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import je.w;
import kg.l;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import m0.b;
import oc.Q;
import pc.Z;
import pc.z0;
import q8.a;
import q8.c;
import q8.d;
import q8.h;
import we.k;
import xd.g;
import y0.N;

public final class m2 implements k {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;

    public m2(Serializable serializable0, List list0, Object object0, int v) {
        this.a = v;
        this.c = serializable0;
        this.b = list0;
        this.d = object0;
        super();
    }

    public m2(Object object0, Object object1, Object object2, int v) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        this.d = object2;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        boolean z;
        w w0;
        String s = "";
        H h0 = H.a;
        Object object1 = this.d;
        Object object2 = this.b;
        Object object3 = this.c;
        switch(this.a) {
            case 0: {
                q.g(((O.w)object0), "$this$MelonLazyColumn");
                O.w.a(((O.w)object0), new b(1095426666, new i2(((O2)object3), ((List)object2), ((v2)object1), 0), true));
                ((j)(((O.w)object0))).u(((List)object2).size(), new J(3, new F(4), ((List)object2)), new K(((List)object2), 1), new b(0xBEF78951, new p2(((List)object2), ((List)object2), ((v2)object1), 0), true));
                return h0;
            }
            case 1: {
                q.g(((N)object0), "$this$graphicsLayer");
                if(((Number)((e)object2).d()).floatValue() >= 0.0f && ((Number)((e)object3).d()).floatValue() >= 0.0f) {
                    ((N)object0).f(true);
                    ((N)object0).A(((s)object1));
                }
                return h0;
            }
            case 2: {
                q.g(((a)object0), "$this$click");
                ((a)object0).a = ((y)object2).a(0x7F130F93);  // string:tiara_other_recommend_popup_layer1 "다른제안보기팝업"
                ((a)object0).g = ((y)object2).a(0x7F130F9D);  // string:tiara_play_other_recommend_popup_copy "다른제안듣기"
                ((a)object0).e = (String)object3;
                ((a)object0).h = ((y)object2).g.a(((Playable)object1));
                ((a)object0).i = ((y)object2).g.b();
                return h0;
            }
            case 3: {
                q.g(((c)object0), "$this$customProps");
                LinkedHashMap linkedHashMap0 = ((c)object0).a;
                String s1 = U4.F.A(((v)object3));
                if(s1 == null) {
                    s1 = "";
                }
                linkedHashMap0.put("recmd_key", s1);
                String s2 = ((v)object3).l;
                if(s2 == null) {
                    s2 = "";
                }
                linkedHashMap0.put("personal_seed_code", s2);
                DjMalrangInfo djMalrangInfo0 = ((y)object2).d.b.h;
                String s3 = djMalrangInfo0 == null ? null : n.w(djMalrangInfo0);
                if(s3 == null) {
                    s3 = "";
                }
                linkedHashMap0.put("focus_song_recmd_key", s3);
                Q q0 = (Q)((y)object2).f.invoke();
                if(q0 instanceof z0) {
                    pc.c c0 = ((z0)q0).c;
                    if(c0 != null && c0 instanceof DjMalrangInfo) {
                        Playable playable0 = e1.b.y(q0);
                        String s4 = playable0 == null ? null : "";
                        if(s4 == null) {
                            s4 = "";
                        }
                        linkedHashMap0.put("focus_song_id", s4);
                        String s5 = ((y)object2).g.d(((y)object2).a, playable0);
                        if(s5 == null) {
                            s5 = "";
                        }
                        linkedHashMap0.put("focus_song_timestamp", s5);
                        q.g(((z0)q0), "<this>");
                        String s6 = String.valueOf(((z0)q0).b + 1);
                        if(s6 == null) {
                            s6 = "";
                        }
                        linkedHashMap0.put("focus_song_ordnum", s6);
                    }
                }
                if(((p8.s)object1) != null) {
                    String s7 = ((p8.s)object1).c;
                    if(s7 != null) {
                        s = s7;
                    }
                }
                linkedHashMap0.put("menuid", s);
                return h0;
            }
            case 4: {
                q.g(((q8.j)object0), "$this$tiaraViewLogBuilder");
                new A2(((Bd.H)object2), 5).invoke(((h)((q8.j)object0).b));
                ((q8.j)object0).c(new Bd.w(((p8.s)object3), 1));
                ((q8.j)object0).d(new Bd.F(((q8.j)object0), ((ContentList)object1), ((p8.s)object3), ((Bd.H)object2), 0));
                return h0;
            }
            case 5: {
                return g1.l(((g1)object2), ((C)object3), ((C)object1), ((d1)object0));
            }
            case 6: {
                q.g(((a1.Q)object0), "textLayoutResult");
                if(((a1.Q)object0).d()) {
                    String s8 = o.d1(Math.min(((String)object2).length(), ((a1.Q)object0).b.c(1, true)), ((String)object2));
                    if(s8.length() >= 2) {
                        s8 = o.y0(2, s8);
                    }
                    ((b0)object1).setValue(s8 + "..." + ((String)object3));
                }
                return h0;
            }
            case 7: {
                if(!q.b(((t)object0), t.a)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                q.f("", "getUserId(...)");
                StringProviderImpl stringProviderImpl0 = ((G)object2).d;
                if(((String)object1).length() == 0) {
                    LogU.warn$default(((G)object2).f, "checkRemoveSimpleAccount() invalid parameter", null, false, 6, null);
                    return h0;
                }
                LogU.debug$default(((G)object2).f, androidx.appcompat.app.o.o("checkRemoveSimpleAccount() currentUserId:", "", ", targetUserId:", ((String)object1)), null, false, 6, null);
                if("".equals(((String)object1))) {
                    ((G)object2).sendUiEvent(new r4(stringProviderImpl0.a(0x7F1300D0), stringProviderImpl0.a(0x7F1309C2), null, new A(((G)object2), ((String)object1), 1), null, new A9.a(21), 44));  // string:alert_dlg_title_info "안내"
                    return h0;
                }
                ((G)object2).sendUiEvent(new r4(stringProviderImpl0.a(0x7F1300D0), stringProviderImpl0.a(0x7F1309C1), null, new A(((G)object2), ((String)object1), 2), null, new A9.a(21), 44));  // string:alert_dlg_title_info "안내"
                return h0;
            }
            case 8: {
                q.g(((O.w)object0), "$this$MelonLazyColumn");
                ((j)(((O.w)object0))).u(((List)object2).size(), new J(18, new F(18), ((List)object2)), new K(((List)object2), 13), new b(0xBEF78951, new p2(((List)object2), ((Hd.h)object3), ((T)object1), 2), true));
                return h0;
            }
            case 9: {
                q.g(((xd.h)object0), "action");
                if(((xd.h)object0) instanceof g) {
                    LogU.info$default(((T)object2).f, "showArtistPopup() action: " + ((xd.h)object0), null, false, 6, null);
                    n0 n00 = (n0)((T)object2).getViewModel();
                    Bc.b b0 = (Bc.b)((ArrayList)object1).get(((g)(((xd.h)object0))).a);
                    n00.getClass();
                    q.g(b0, "creator");
                    String s9 = b0.a;
                    if(((ContsTypeCode)object3).equals(ContsTypeCode.ARTIST)) {
                        Navigator.openArtistInfo(s9);
                        return h0;
                    }
                    if(((ContsTypeCode)object3).equals(ContsTypeCode.USER) || ((ContsTypeCode)object3).equals(ContsTypeCode.BRANDDJ)) {
                        Navigator.openUserMain(s9);
                    }
                }
                return h0;
            }
            case 10: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                ((d)object0).a = ((d)object0).a;
                ((d)object0).c(new W(((n0)object2), 0));
                new W(((n0)object2), 1).invoke(((h)((d)object0).b));
                ((d)object0).b(new W(((n0)object2), 2));
                ((d)object0).e(new Dd.J(((Hd.h)object3), ((n0)object2), ((ArrayList)object1)));
                return h0;
            }
            case 11: {
                q.g(((O.w)object0), "$this$MelonLazyColumn");
                O.w.a(((O.w)object0), new b(0x6F6BAC40, new Ld.c(((i)object1), 0), true));
                if(((BannerBase)object3) != null) {
                    O.w.a(((O.w)object0), new b(0x16D3F8D4, new a4(3, ((i)object1), ((BannerBase)object3)), true));
                }
                O.w.a(((O.w)object0), Ld.a.a);
                ((j)(((O.w)object0))).u(((List)object2).size(), new J(29, new F(23), ((List)object2)), new K(((List)object2), 16), new b(0xBEF78951, new L(11, ((List)object2), ((i)object1)), true));
                O.w.a(((O.w)object0), new b(0xBC537008, new Ld.c(((i)object1), 1), true));
                return h0;
            }
            case 12: {
                q.g(((Map)object0), "result");
                Map map0 = ((M8.e)object2).c;
                if(!map0.containsKey(((l)object3).j)) {
                    String s10 = ((l)object3).j;
                    String s11 = (String)((Map)object0).get("Sink");
                    if(s11 == null) {
                        w0 = w.a;
                    }
                    else {
                        ArrayList arrayList0 = new ArrayList();
                        for(Object object4: o.R0(s11, new String[]{","}, 0, 6)) {
                            String s12 = (String)object4;
                            try {
                                arrayList0.add(new f(s12));
                            }
                            catch(Exception exception0) {
                                H0.b.w("parseFrom() - error : ", exception0.getMessage(), LogU.Companion, "ProtocolInfo");
                            }
                        }
                        w0 = arrayList0;
                    }
                    map0.put(s10, new M8.b(((M8.a)object1), w0));
                    Iterator iterator1 = ((M8.e)object2).d.iterator();
                    q.f(iterator1, "iterator(...)");
                    while(iterator1.hasNext()) {
                        Object object5 = iterator1.next();
                        q.f(object5, "next(...)");
                        LogU.info$default(((m)(((M8.d)object5))).a.b, va.e.b("onDiscover() - device : ", ((M8.a)object1).a.l), null, false, 6, null);
                        EventRemotePlayer eventRemotePlayer0 = EventDlna.FOUND_DEVICE;
                        eventRemotePlayer0.setRemoteDevice(new ic.c(((M8.a)object1)));
                        EventBusHelper.post(eventRemotePlayer0);
                    }
                }
                return h0;
            }
            case 13: {
                q.g(((Context)object0), "context");
                TitleBar titleBar0 = new TitleBar(((Context)object0));
                p p0 = new p(1);
                F8.j j0 = new F8.j(2, true);  // 初始化器: LF8/m;-><init>(IZ)V
                j0.c = new A6.b(((Mc.g)object2), 15);
                p0.g(j0);
                titleBar0.a(p0);
                ((Mc.g)object2).g = p0;
                titleBar0.setBackgroundColor(0);
                titleBar0.setTitle(((String)((b1)object3).getValue()));
                Ud.j.a(((Ud.j)object1), titleBar0, new U(((Mc.g)object2), 27));
                return titleBar0;
            }
            case 14: {
                q.g(((w0)object0), "userEvent");
                if(((w0)object0) instanceof u0) {
                    Navigator.openAlbumInfo(((ALBUMLIST)object2).albumId);
                    return h0;
                }
                if(!(((w0)object0) instanceof v0)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                String s13 = ((ALBUMLIST)object2).albumId;
                if(s13 != null) {
                    s = s13;
                }
                ((Oc.o)object3).c(s, ((Oc.o)object3).getMenuId(), ((LICENSE2TYPE)object1).statsElements);
                return h0;
            }
            case 15: {
                q.g(((O.w)object0), "$this$MelonLazyRow");
                ((j)(((O.w)object0))).u(((List)object2).size(), new Ld.p(21, new F(27), ((List)object2)), new K(((List)object2), 22), new b(0xBEF78951, new p2(((List)object2), ((b0)object3), ((k)object1), 4), true));
                return h0;
            }
            case 16: {
                q.g(((O.w)object0), "$this$MelonLazyColumn");
                ((j)(((O.w)object0))).u(((List)object2).size(), new Ld.p(22, new Uc.a(0), ((List)object2)), new K(((List)object2), 23), new b(0xBEF78951, new p2(((List)object2), ((Uc.j.a)object3), ((b0)object1), 5), true));
                return h0;
            }
            case 17: {
                q.g(((q8.j)object0), "$this$tiaraViewLogBuilder");
                ((q8.j)object0).c(new Mc.y(27, ((q8.j)object0), ((Uc.q)object2)));
                ((q8.j)object0).d(new Bd.F(((q8.j)object0), ((Builder)object3), ((Uc.q)object2), ((String)object1), 5));
                return h0;
            }
            case 18: {
                q.g(((StringBuilder)object0), "$this$buildInfo");
                ((StringBuilder)object0).append("onPreparedMediaItem() " + ((Nb.z0)object2).a());
                Cb.i.a(((StringBuilder)object0), "mediaItem: " + U4.F.D(((E)object3)) + ", " + ((E)object3).a);
                Cb.i.a(((StringBuilder)object0), "analytics source: " + ((ac.w)object1).b.m);
                return h0;
            }
            case 19: {
                ((a0)object2).c(-1);
                ((b0)object1).setValue(Boolean.FALSE);
                if(!(MelonFragmentManager.getInstance().getCurrentFragment() instanceof Uc.j.a) || ((Boolean)object0).booleanValue()) {
                    e0 e00 = new e0(true, false);
                    ((Vc.a0)object3).d.invoke(e00);
                }
                return h0;
            }
            case 20: {
                q.g(((Drawable)object0), "drawable");
                BuildersKt__Builders_commonKt.launch$default(((CoroutineScope)object2), null, null, new M(((Drawable)object0), ((k)object3), ((String)object1), null), 3, null);
                return h0;
            }
            case 21: {
                q.g(((O.w)object0), "$this$MelonLazyRow");
                if(((RECNTSONGINFO)object3) != null) {
                    String s14 = ((RECNTSONGINFO)object3).recntSongCount;
                    int v = 0;
                    if(s14 != null) {
                        try {
                            v = Integer.parseInt(s14);
                        }
                        catch(NumberFormatException unused_ex) {
                        }
                    }
                    if(v > 0) {
                        String s15 = ((RECNTSONGINFO)object3).recntSongName;
                        z = s15 == null || o.H0(s15) ? false : true;
                    }
                    else {
                        z = false;
                    }
                    if(z) {
                        O.w.a(((O.w)object0), new b(52086931, new a4(6, ((RECNTSONGINFO)object3), ((k)object1)), true));
                    }
                }
                if(((List)object2) != null) {
                    ((j)(((O.w)object0))).u(((List)object2).size(), null, new K(((List)object2), 25), new b(0xBEF78951, new Yc.l(((List)object2), 0, ((k)object1)), true));
                }
                return h0;
            }
            case 22: {
                q.g(((a)object0), "$this$click");
                ((a)object0).a = (String)object2;
                ((a)object0).e = ((Integer)object3) == null ? null : ((Integer)object3).toString();
                ((a)object0).g = (String)object1;
                return h0;
            }
            case 23: {
                q.g(((c)object0), "$this$customProps");
                LinkedHashMap linkedHashMap1 = ((c)object0).a;
                p8.s s16 = ((ad.p)object1).b;
                String s17 = s16 == null ? null : s16.c;
                if(s17 != null) {
                    s = s17;
                }
                linkedHashMap1.put("menuid", s);
                linkedHashMap1.put("toros_page_meta_id", "slot_personal");
                linkedHashMap1.put("toros_file_hash_key", "0647dcc15b20c4f83f");
                linkedHashMap1.put("toros_user_id_type", "app_user_id");
                ((q8.j)object2).getClass();
                ((q8.j)object2).h.addContent(new ViewImpContent[]{((ViewImpContent)object3)}[0]);
                return h0;
            }
            case 24: {
                q.g(((O.w)object0), "$this$MelonLazyRow");
                List list0 = (List)((List)object2).get(((K0)object3).m());
                ((j)(((O.w)object0))).u(list0.size(), new S(20, new Uc.a(22), list0), new X(list0, 7), new b(0xBEF78951, new p2(list0, ((n2)object1), ((K0)object3), 7), true));
                return h0;
            }
            case 25: {
                return SettingMusicAlarmListFragment.AlarmList$lambda$24$lambda$23(((List)object2), ((SettingMusicAlarmListFragment)object3), ((k)object1), ((O.w)object0));
            }
            case 26: {
                q.g(((d)object0), "$this$tiaraEventLogBuilder");
                if(((p8.s)object2) != null) {
                    String s18 = ((p8.s)object2).c;
                    if(s18 != null) {
                        s = s18;
                    }
                }
                ((d)object0).a = s;
                ((d)object0).c(new com.iloen.melon.player.playlist.n(((p8.s)object2), 1));
                new com.iloen.melon.player.playlist.l(((PlaylistMainTiaraLogHelper)object3), 8).invoke(((h)((d)object0).b));
                ((d)object0).b(new p0(12, ((PlaylistMainTiaraLogHelper)object3), ((String)object1)));
                ((d)object0).d(new com.iloen.melon.player.playlist.n(((p8.s)object2), 2));
                return h0;
            }
            case 27: {
                q.g(((c)object0), "$this$customProps");
                LinkedHashMap linkedHashMap2 = ((c)object0).a;
                linkedHashMap2.put("menuid", ((Z)(((pc.d)(((oc.H)object1))))).getMenuId());
                String s19 = (String)((PlaylistMainTiaraLogHelper)object2).h.invoke();
                if(s19 != null) {
                    linkedHashMap2.put("recmd_key", s19);
                }
                String s20 = (String)((PlaylistMainTiaraLogHelper)object2).i.invoke(((Playable)object3));
                if(s20 != null) {
                    linkedHashMap2.put("recmd_offer_timestamp", s20);
                }
                return h0;
            }
            case 28: {
                q.g(((q8.f)object0), "$this$eventMeta");
                ((q8.f)object0).b = ((VideoPlaylistFragment)object2).getString(0x7F130EFE);  // string:tiara_meta_type_mv "영상"
                ((q8.f)object0).a = (String)object3;
                ((q8.f)object0).c = (String)object1;
                return h0;
            }
            default: {
                q.g(((CoverView)object0), "coverView");
                new TemplateImageLoader(new DrawerPlaylistArtistMixTemplateDataBuilder(((CoverView)object0), ((String)object3), ((List)object2), ((String)object1)).build()).load(new O1(((CoverView)object0), 3));
                return h0;
            }
        }
    }
}

