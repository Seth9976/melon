package com.iloen.melon.player.playlist.mixup.composables;

import Ac.L;
import Ac.Z1;
import Ac.p2;
import Ad.j;
import Bd.e;
import Cb.i;
import I6.V;
import O.w;
import U.c0;
import X0.u;
import X0.x;
import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.b1;
import androidx.fragment.app.FragmentActivity;
import b3.E;
import b3.a0;
import cd.X;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.custom.l1;
import com.iloen.melon.net.v6x.response.MainTopNotificationRes.FeedType;
import com.iloen.melon.net.v6x.response.MusicDnaMonthListRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.player.playlist.common.PlaylistCommonSongListComposableKt;
import com.iloen.melon.player.playlist.mixup.MixUpUIItemData.PlayableItem;
import com.iloen.melon.player.playlist.mixup.MixUpUIItemData;
import com.iloen.melon.player.playlist.tiara.MixUpPlaylistTiaraLogHelper;
import com.iloen.melon.popup.G;
import com.iloen.melon.popup.MelonTMPPopup;
import com.iloen.melon.popup.l;
import com.iloen.melon.sns.target.SnsManager.SnsType;
import com.iloen.melon.sns.target.SnsTarget;
import com.iloen.melon.utils.TalkbackUtilKt;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.image.ImageSelector.OnDefaultImageClick;
import com.iloen.melon.utils.image.ImageSelector.Request;
import com.iloen.melon.utils.image.ImageSelector;
import com.iloen.melon.utils.system.ScreenUtils;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.data.Meta.Builder;
import com.kakao.tiara.data.Meta;
import com.melon.net.res.MusicDnaMainMonthlyLogRes;
import com.melon.net.res.SearchMainContentRes.ThemeOffering;
import com.melon.net.res.StreamingPathRes;
import com.melon.playlist.interfaces.PlayableData;
import com.melon.ui.D1;
import com.melon.ui.F1;
import com.melon.ui.I1;
import com.melon.ui.I4;
import com.melon.ui.K1;
import com.melon.ui.P1;
import com.melon.ui.Q1;
import com.melon.ui.S1;
import com.melon.ui.T1;
import com.melon.ui.V1;
import com.melon.ui.d1;
import com.melon.ui.k2;
import com.melon.ui.musicwave.ChannelInfoData;
import com.melon.ui.x1;
import com.melon.ui.z3;
import gc.y;
import gd.M6;
import gd.R6;
import gd.h7;
import gd.y1;
import hd.K;
import hd.O1;
import hd.S0;
import hd.U1;
import hd.Y1;
import hd.m1;
import j5.g;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import jd.N;
import jd.X0;
import jd.u1;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import m8.n;
import pc.t;
import q8.f;
import q8.h;
import rd.B0;
import rd.w0;
import t5.m;
import t9.F;
import td.f0;
import td.k0;
import td.n0;
import we.a;
import we.k;
import we.o;
import y0.M;
import y0.s;
import zd.q0;
import zd.x0;

public final class c implements k {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;

    public c(Context context0, H h0, H h1) {
        this.a = 12;
        super();
        this.c = context0;
        this.b = h0;
        this.d = h1;
    }

    public c(h7 h70, k k0, a a0) {
        this.a = 9;
        super();
        this.c = h70;
        this.d = k0;
        this.b = a0;
    }

    public c(Object object0, Object object1, Object object2, int v) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        this.d = object2;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        ie.H h0 = ie.H.a;
        Object object1 = this.d;
        Object object2 = this.c;
        Object object3 = this.b;
        switch(this.a) {
            case 0: {
                q.g(((x)object0), "$this$clearAndSetSemantics");
                MixUpUIItemData mixUpUIItemData0 = (MixUpUIItemData)((a)object3).invoke();
                PlayableItem mixUpUIItemData$PlayableItem0 = mixUpUIItemData0 instanceof PlayableItem ? ((PlayableItem)mixUpUIItemData0) : null;
                if(mixUpUIItemData$PlayableItem0 != null) {
                    PlayableData playableData0 = mixUpUIItemData$PlayableItem0.getPlayableData();
                    PlaylistCommonSongListComposableKt.setSongItemSemantics(((x)object0), ((Context)object2), ((PlayableItem)mixUpUIItemData0).isCurrent(), ((PlayableItem)mixUpUIItemData0).isCurrentPlaylist(), ((PlayableItem)mixUpUIItemData0).isPlaying(), "", l1.n("", "getSongName(...)", playableData0.a, "getArtistNames(...)"), ((PlayableItem)mixUpUIItemData0).isSelected(), new d(((SongListClickListener)object1), mixUpUIItemData0, 1), new b(((SongListClickListener)object1), mixUpUIItemData0, playableData0.a, 2), new b(((SongListClickListener)object1), mixUpUIItemData0, playableData0.a, 3), new Z1(((SongListClickListener)object1), mixUpUIItemData0, playableData0, 19), new b(((SongListClickListener)object1), mixUpUIItemData0, playableData0.a, 4), new b(((SongListClickListener)object1), mixUpUIItemData0, playableData0.a, 0));
                }
                return h0;
            }
            case 1: {
                ((Integer)object0).getClass();
                if(((o)object3) != null) {
                    ((o)object3).invoke(((Number)((b0)object2).getValue()).intValue(), ((Number)((b0)object1).getValue()).intValue(), ((Integer)object0));
                }
                return h0;
            }
            case 2: {
                q.g(((q8.d)object0), "$this$tiaraEventLogBuilder");
                com.iloen.melon.fragments.mymusic.dna.d d0 = new com.iloen.melon.fragments.mymusic.dna.d(29);
                ((h)((q8.d)object0).b).a(d0);
                ((q8.d)object0).c(new com.iloen.melon.player.playlist.common.h(22));
                ((q8.d)object0).b(new l(3, ((String)object3), ((String)object2)));
                ((q8.d)object0).k(new G(((MelonTMPPopup)object1), 0));
                ((q8.d)object0).d(new G(((MelonTMPPopup)object1), 1));
                return h0;
            }
            case 3: {
                if(((j)object0) instanceof Ad.c) {
                    ((Request)object2).h = 7000;
                    ((ImageSelector)object3).e(((ImageSelector)object3).a(), ((Request)object2));
                    return null;
                }
                if(((j)object0) instanceof Ad.a) {
                    ((Request)object2).h = 7001;
                    ((ImageSelector)object3).c(((ImageSelector)object3).a(), ((Request)object2));
                    return null;
                }
                if(((j)object0) instanceof Ad.b && ((OnDefaultImageClick)object1) != null) {
                    ((OnDefaultImageClick)object1).onDefaultImageClick();
                    return null;
                }
                return null;
            }
            case 4: {
                q.g(((f)object0), "$this$eventMeta");
                ((f)object0).a = (String)object2;
                ((f)object0).b = p8.b.a("");
                if(((String)object3) != null) {
                    ((f)object0).f = (String)object3;
                }
                return h0;
            }
            case 5: {
                String s = (String)object2;
                q.g(((f)object0), "$this$eventMeta");
                if(FeedType.DNA == ((FeedType)object3)) {
                    s = "";
                }
                ((f)object0).a = s;
                ((f)object0).b = (String)object1;
                return h0;
            }
            case 6: {
                q.g(((Drawable)object0), "drawable");
                q.g(((Context)object2), "context");
                ((b0)object3).setValue(new s((((ThemeOffering)object1) == null || Tf.o.H0("") ? M.c(ColorUtils.getColor(((Context)object2), 0x7F060145)) : M.c(ColorUtils.getColorFromHexStr("")))));  // color:gray050s
                return h0;
            }
            case 7: {
                q.g(((StringBuilder)object0), "$this$buildDebug");
                ((StringBuilder)object0).append("getStreamingInfo()");
                i.a(((StringBuilder)object0), "DeliveryPath: " + ((Va.a)object3));
                i.a(((StringBuilder)object0), "StreamPathQuery: " + ((Va.b)object2));
                i.a(((StringBuilder)object0), "GetPathInfo: " + ((StreamingPathRes)object1).getResponse().getPathInfo());
                i.a(((StringBuilder)object0), "ContentsInfo: " + ((StreamingPathRes)object1).getResponse().getContentsInfoList());
                return h0;
            }
            case 8: {
                q.g(((androidx.media3.common.d)object0), "$this$updateStateAndInvalidate");
                V v0 = ((y)object3).s0().b();
                q.f(v0, "getPlaylist(...)");
                ArrayList arrayList0 = new ArrayList(je.q.Q(10, v0));
                for(Object object4: v0) {
                    b3.b0 b00 = (b3.b0)object4;
                    if(q.b(b00.c, ((E)object2))) {
                        a0 a00 = b00.c();
                        a00.c = (E)object1;
                        b00 = new b3.b0(a00);
                    }
                    arrayList0.add(b00);
                }
                ((androidx.media3.common.d)object0).b(arrayList0);
                return (androidx.media3.common.d)object0;
            }
            case 9: {
                q.g(((w)object0), "$this$MelonLazyColumn");
                X x0 = new X(((h7)object2).d, 28);
                m0.b b0 = new m0.b(0xBEF78951, new R6(((h7)object2).d, ((k)object1), ((a)object3), ((h7)object2), 0), true);
                ((O.j)(((w)object0))).u(((h7)object2).d.size(), null, x0, b0);
                return h0;
            }
            case 10: {
                q.g(((w)object0), "$this$MelonLazyRow");
                ArrayList arrayList1 = ((S0)object3).a.order;
                q.f(arrayList1, "order");
                ((O.j)(((w)object0))).u(arrayList1.size(), new y1(14, new M6(5), arrayList1), new hd.w(arrayList1, 2), new m0.b(0xBEF78951, new R6(arrayList1, ((S0)object3), ((Context)object2), ((k)object1)), true));
                return h0;
            }
            case 11: {
                q.g(((w)object0), "$this$MelonLazyRow");
                ((O.j)(((w)object0))).u(((List)object3).size(), new y1(12, new M6(4), ((List)object3)), new X(((List)object3), 29), new m0.b(0xBEF78951, new p2(((List)object3), ((Context)object2), ((k)object1), 9), true));
                return h0;
            }
            case 12: {
                q.g(((x)object0), "$this$semantics");
                u.h(((x)object0), TalkbackUtilKt.getPlayableTalkbackInfo(((Context)object2), ((String)((H)object3).a), ((String)((H)object1).a)));
                u.k(((x)object0), 0);
                return h0;
            }
            case 13: {
                return m1.c(((m1)object3), ((MusicDnaMainMonthlyLogRes)object2), ((MusicDnaMonthListRes)object1), ((d1)object0));
            }
            case 14: {
                return O1.c(((O1)object3), ((MusicDnaMonthListRes)object2), ((MusicDnaMonthListRes)object1), ((d1)object0));
            }
            case 15: {
                q.g(((k2)object0), "clickEvent");
                if(((k2)object0) instanceof K1) {
                    int v1 = ((K1)(((k2)object0))).b.a.ordinal();
                    if(v1 != 52) {
                        switch(v1) {
                            case 39: {
                                FragmentActivity fragmentActivity0 = ((Y1)object1).getActivity();
                                x0.v(((K)(((I4)object2))).a, fragmentActivity0, SnsManager.SnsType.e);
                                return h0;
                            }
                            case 40: 
                            case 41: {
                                FragmentActivity fragmentActivity1 = ((Y1)object1).getActivity();
                                x0.s(((K)(((I4)object2))).a, fragmentActivity1);
                                return h0;
                            }
                            case 43: {
                                FragmentActivity fragmentActivity2 = ((Y1)object1).getActivity();
                                x0.v(((K)(((I4)object2))).a, fragmentActivity2, SnsManager.SnsType.g);
                                t.E(F.a.B(SnsManager.SnsType.g), ((K)(((I4)object2))).a);
                                return h0;
                            }
                            case 44: {
                                FragmentActivity fragmentActivity3 = ((Y1)object1).getActivity();
                                x0.w(((K)(((I4)object2))).a, fragmentActivity3);
                                return h0;
                            }
                            case 45: {
                                FragmentActivity fragmentActivity4 = ((Y1)object1).getActivity();
                                x0.t(((K)(((I4)object2))).a, fragmentActivity4);
                                return h0;
                            }
                            default: {
                                return h0;
                            }
                        }
                    }
                    String s1 = ((x0)object3).u();
                    SnsTarget snsTarget0 = F.a.B(SnsManager.SnsType.h);
                    q.f(snsTarget0, "getSnsTarget(...)");
                    ((Y1)object1).sendUserEvent(new z3(s1, ((K)(((I4)object2))).a, snsTarget0));
                }
                return h0;
            }
            case 16: {
                q.g(((w)object0), "$this$MelonLazyColumn");
                ((O.j)(((w)object0))).u(((ArrayList)object3).size(), null, new F.s(28, ((ArrayList)object3)), new m0.b(0xBEF78951, new L(19, ((ArrayList)object3), ((id.o)object2)), true));
                if(((Boolean)((b1)object1).getValue()).booleanValue()) {
                    w.a(((w)object0), new m0.b(1377949105, new e(((id.o)object2), 21), true));
                }
                return h0;
            }
            case 17: {
                g g0 = (g)object0;
                if(g0 instanceof j5.e) {
                    g0 = (j5.e)g0;
                    if(((C0.c)object3) != null) {
                        g0.getClass();
                        return new j5.e(((C0.c)object3));
                    }
                }
                else if(g0 instanceof j5.d) {
                    g0 = (j5.d)g0;
                    t5.f f0 = g0.b;
                    if(f0.c instanceof m) {
                        if(((C0.c)object2) != null) {
                            return new j5.d(((C0.c)object2), f0);
                        }
                    }
                    else if(((C0.c)object1) != null) {
                        return new j5.d(((C0.c)object1), f0);
                    }
                }
                return g0;
            }
            case 18: {
                X0 x00 = (X0)object2;
                Builder meta$Builder0 = new Builder();
                String s2 = ((ChannelInfoData)object3).a;
                Builder meta$Builder1 = meta$Builder0.id(((ChannelInfoData)object3).e).type(x00.getString(0x7F130EFD));  // string:tiara_meta_type_music_wave "뮤직웨이브"
                String s3 = ((ChannelInfoData)object3).b;
                Meta meta0 = meta$Builder1.name(s3).build();
                q.f(meta0, "build(...)");
                if(((k2)object0) instanceof I1) {
                    p8.f f1 = ((u1)x00.getViewModel()).f();
                    if(f1 != null) {
                        f1.a = x00.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
                        f1.y = x00.getString(0x7F130F7D);  // string:tiara_music_wave_channel_detail_click_layer1_more "채널 더보기"
                        f1.F = x00.getString(0x7F130F50);  // string:tiara_music_wave_channel_detail_click_copy_bookmark "북마크"
                        f1.b0 = meta0;
                        f1.a().track();
                    }
                }
                else if(((k2)object0) instanceof com.melon.ui.Z1) {
                    p8.f f2 = ((u1)x00.getViewModel()).f();
                    if(f2 != null) {
                        f2.a = x00.getString(0x7F130DD1);  // string:tiara_common_action_name_share "공유"
                        f2.d = ActionKind.Share;
                        f2.y = x00.getString(0x7F130F7D);  // string:tiara_music_wave_channel_detail_click_layer1_more "채널 더보기"
                        f2.F = x00.getString(0x7F130F6F);  // string:tiara_music_wave_channel_detail_click_copy_share "채널 공유하기"
                        f2.b0 = meta0;
                        f2.a().track();
                    }
                }
                else if(((k2)object0) instanceof F1) {
                    p8.f f3 = ((u1)x00.getViewModel()).f();
                    if(f3 != null) {
                        f3.a = x00.getString(0x7F130DC2);  // string:tiara_common_action_buy "구매하기"
                        f3.d = ActionKind.Purchase;
                        f3.y = x00.getString(0x7F130F7D);  // string:tiara_music_wave_channel_detail_click_layer1_more "채널 더보기"
                        f3.F = x00.getString(0x7F130F58);  // string:tiara_music_wave_channel_detail_click_copy_download_all "플레이리스트 전체 다운로드"
                        f3.b0 = meta0;
                        f3.a().track();
                    }
                }
                else if(((k2)object0) instanceof V1) {
                    p8.f f4 = ((u1)x00.getViewModel()).f();
                    if(f4 != null) {
                        f4.a = x00.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
                        f4.y = x00.getString(0x7F130F7D);  // string:tiara_music_wave_channel_detail_click_layer1_more "채널 더보기"
                        f4.F = x00.getString(0x7F130F69);  // string:tiara_music_wave_channel_detail_click_copy_put_all "플레이리스트 전체 담기"
                        f4.b0 = meta0;
                        f4.a().track();
                    }
                }
                else if(((k2)object0) instanceof com.melon.ui.O1) {
                    p8.f f5 = ((u1)x00.getViewModel()).f();
                    if(f5 != null) {
                        f5.a = x00.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
                        f5.y = x00.getString(0x7F130F7D);  // string:tiara_music_wave_channel_detail_click_layer1_more "채널 더보기"
                        f5.F = x00.getString(0x7F130F56);  // string:tiara_music_wave_channel_detail_click_copy_delete "내 채널 삭제"
                        f5.b0 = meta0;
                        f5.a().track();
                    }
                }
                else if(((k2)object0) instanceof P1) {
                    p8.f f6 = ((u1)x00.getViewModel()).f();
                    if(f6 != null) {
                        f6.a = x00.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f6.y = x00.getString(0x7F130F7D);  // string:tiara_music_wave_channel_detail_click_layer1_more "채널 더보기"
                        f6.F = x00.getString(0x7F130F59);  // string:tiara_music_wave_channel_detail_click_copy_edit "내 채널 편집"
                        f6.b0 = meta0;
                        f6.a().track();
                    }
                }
                else if(((k2)object0) instanceof Q1) {
                    p8.f f7 = ((u1)x00.getViewModel()).f();
                    if(f7 != null) {
                        f7.a = x00.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
                        f7.y = x00.getString(0x7F130F7D);  // string:tiara_music_wave_channel_detail_click_layer1_more "채널 더보기"
                        f7.F = x00.getString(0x7F130F5C);  // string:tiara_music_wave_channel_detail_click_copy_host_message "호스트 메시지 등록"
                        f7.d = ActionKind.ClickContent;
                        f7.b0 = meta0;
                        f7.a().track();
                    }
                }
                else if(((k2)object0) instanceof x1) {
                    p8.f f8 = ((u1)x00.getViewModel()).f();
                    if(f8 != null) {
                        f8.a = x00.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f8.d = ActionKind.ClickContent;
                        f8.y = x00.getString(0x7F130F7D);  // string:tiara_music_wave_channel_detail_click_layer1_more "채널 더보기"
                        f8.F = x00.getString(0x7F130F4F);  // string:tiara_music_wave_channel_detail_click_copy_artist_info "아티스트 채널로 이동"
                        Builder meta$Builder2 = new Builder();
                        meta$Builder2.id(s2);
                        meta$Builder2.type(x00.getString(0x7F130EF1));  // string:tiara_meta_type_artist "아티스트"
                        meta$Builder2.name(((ChannelInfoData)object3).h);
                        f8.b0 = meta$Builder2.build();
                        f8.a().track();
                    }
                }
                else if(((k2)object0) instanceof D1 || ((k2)object0) instanceof S1) {
                    p8.f f10 = ((u1)x00.getViewModel()).f();
                    if(f10 != null) {
                        f10.a = x00.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f10.d = ActionKind.ClickContent;
                        f10.y = x00.getString(0x7F130F7D);  // string:tiara_music_wave_channel_detail_click_layer1_more "채널 더보기"
                        f10.F = x00.getString(0x7F130F66);  // string:tiara_music_wave_channel_detail_click_copy_playlist_info "플레이리스트 상세로 이동"
                        Builder meta$Builder4 = new Builder();
                        meta$Builder4.id(s2);
                        meta$Builder4.type(x00.getString(0x7F130EFF));  // string:tiara_meta_type_playlist "일반플레이리스트"
                        meta$Builder4.name(s3);
                        f10.b0 = meta$Builder4.build();
                        f10.a().track();
                    }
                }
                else if(((k2)object0) instanceof T1) {
                    p8.f f9 = ((u1)x00.getViewModel()).f();
                    if(f9 != null) {
                        f9.a = x00.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f9.d = ActionKind.ClickContent;
                        f9.y = x00.getString(0x7F130F7D);  // string:tiara_music_wave_channel_detail_click_layer1_more "채널 더보기"
                        f9.F = x00.getString(0x7F130F67);  // string:tiara_music_wave_channel_detail_click_copy_program_info "스테이션 프로그램 상세로 이동"
                        Builder meta$Builder3 = new Builder();
                        meta$Builder3.id(s2);
                        meta$Builder3.type(x00.getString(0x7F130F03));  // string:tiara_meta_type_station "스테이션"
                        meta$Builder3.name(s3);
                        f9.b0 = meta$Builder3.build();
                        f9.a().track();
                    }
                }
                U1 u10 = new U1(1, x00, X0.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 17);
                q.g(((k2)object0), "event");
                x00.d.x(x00, u10, ((q0)object1), ((k2)object0));
                return h0;
            }
            case 19: {
                q.g(((c0)object0), "$this$KeyboardActions");
                if(Tf.o.e1(((String)((b0)object1).getValue())).toString().length() > 0) {
                    ((a)object3).invoke();
                    ((a)object2).invoke();
                }
                return h0;
            }
            case 20: {
                ((b0)object3).setValue(((Boolean)object0));
                p8.g g1 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
                g1.b = "뮤직웨이브";
                g1.c = "뮤직웨이브_채널상세";
                g1.I = "1000003041";
                g1.a = "선택";
                g1.y = "채팅";
                g1.F = ((Boolean)object0).booleanValue() ? "아티스트채팅접기" : "아티스트채팅펼치기";
                g1.c0 = new Builder().id(((N)object1).X).type("뮤직웨이브").name(((N)object1).a).build();
                g1.b0 = new Builder().id(((N)object1).X).type("뮤직웨이브").name(((N)object1).a).build();
                g1.a().track();
                return h0;
            }
            case 21: {
                q.g(((A8.j)object0), "kakaoAuthType");
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new n(((mb.f)object3), ((BaseActivity)object2), ((A8.j)object0), ((m8.o)object1), null), 3, null);
                return h0;
            }
            case 22: {
                q.g(((A8.j)object0), "kakaoAuthType");
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new m8.l(((mb.f)object3), ((BaseActivity)object2), ((A8.j)object0), ((m8.m)object1), null), 3, null);
                return h0;
            }
            case 23: {
                String s4 = (String)object2;
                q.g(((q8.c)object0), "$this$customProps");
                LinkedHashMap linkedHashMap0 = ((q8.c)object0).a;
                String s5 = ((Playable)object3) == null ? null : "";
                if(s5 == null) {
                    s5 = "";
                }
                linkedHashMap0.put("focus_song_id", s5);
                if(s4 == null) {
                    s4 = "";
                }
                linkedHashMap0.put("focus_song_timestamp", s4);
                String s6 = (String)((MixUpPlaylistTiaraLogHelper)object1).c.invoke();
                if(s6 == null) {
                    s6 = "";
                }
                linkedHashMap0.put("focus_song_ordnum", s6);
                return h0;
            }
            case 24: {
                q.g(((q8.c)object0), "$this$customProps");
                LinkedHashMap linkedHashMap1 = ((q8.c)object0).a;
                String s7 = (String)((MixUpPlaylistTiaraLogHelper)object3).h.invoke();
                if(s7 != null) {
                    linkedHashMap1.put("recmd_key", s7);
                }
                String s8 = (String)((MixUpPlaylistTiaraLogHelper)object3).i.invoke(((Playable)object2));
                if(s8 != null) {
                    linkedHashMap1.put("recmd_offer_timestamp", s8);
                }
                String s9 = ((od.a)object1) == null ? null : e1.m.G(((od.a)object1));
                if(s9 == null) {
                    s9 = "";
                }
                linkedHashMap1.put("Rangecode", s9);
                return h0;
            }
            case 25: {
                q.g(((q8.c)object0), "$this$customProps");
                LinkedHashMap linkedHashMap2 = ((q8.c)object0).a;
                linkedHashMap2.put("next_ordnum", ((String)object3));
                String s10 = ((od.a)object2) == null ? null : e1.m.G(((od.a)object2));
                if(s10 == null) {
                    s10 = "";
                }
                linkedHashMap2.put("next_range_menu_id", s10);
                String s11 = ((od.a)object1) == null ? null : e1.m.G(((od.a)object1));
                if(s11 == null) {
                    s11 = "";
                }
                linkedHashMap2.put("Rangecode", s11);
                return h0;
            }
            case 26: {
                G4.a a0 = (G4.a)object0;
                q.g(((List)object2), "cIdList");
                q.g(((String)object1), "cType");
                for(Object object5: ((List)object2)) {
                    ((Integer)E9.w.N(((androidx.room.H)((o9.b)object3).a), false, true, new Nb.i(((String)object5), ((String)object1), 5))).getClass();
                }
                return h0;
            }
            case 27: {
                ((K0)(((androidx.compose.runtime.a0)object3))).n(ScreenUtils.getStatusBarHeight(((Context)object2)));
                ((b0)object1).setValue(((r1.l)object0));
                return h0;
            }
            case 28: {
                q.g(((q8.d)object0), "$this$tiaraEventLogBuilder");
                Playable playable0 = (Playable)((B0)object3).b.invoke();
                ((B0)object3).b(((q8.d)object0), ActionKind.ClickContent, playable0);
                ((h)((q8.d)object0).b).a = ((B0)object3).a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                ((q8.d)object0).b(new w0(((B0)object3), 19));
                ((q8.d)object0).e(new Nb.i(((String)object2), ((String)object1), 6));
                return h0;
            }
            default: {
                q.g(((q8.d)object0), "$this$tiaraEventLogBuilder");
                ((n0)object3).b(((q8.d)object0), ActionKind.PlayMusic, ((Playable)object2));
                ((h)((q8.d)object0).b).a = ((n0)object3).a(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
                ((q8.d)object0).b(new k0(((n0)object3), 16));
                ((q8.d)object0).e(new hd.i(((pc.l1)object1), 22));
                ((q8.d)object0).e(new f0(18, ((Playable)object2)));
                q8.c c0 = new q8.c();
                c0.b(new m9.d(6));
                ((LinkedHashMap)((q8.d)object0).g).putAll(c0.a);
                return h0;
            }
        }
    }
}

