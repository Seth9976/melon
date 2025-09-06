package com.iloen.melon.player.video;

import Cb.i;
import Pc.e;
import U4.F;
import Ub.v;
import android.content.Context;
import android.graphics.Rect;
import android.util.Rational;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.o;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.response.MelonTvVdoGetMvProgInfoRes.RESPONSE.PROG;
import com.iloen.melon.net.v4x.response.MelonTvVdoGetMvProgInfoRes.RESPONSE;
import com.iloen.melon.net.v6x.response.LiveDetailRes.Response.Live;
import com.iloen.melon.net.v6x.response.LiveDetailRes.Response;
import com.iloen.melon.net.v6x.response.LiveDetailRes;
import com.iloen.melon.net.v6x.response.VodDetailRes.Response.Magazine.MagazineList;
import com.iloen.melon.net.v6x.response.VodDetailRes.Response.Mv;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.sns.model.SharableLive;
import com.iloen.melon.sns.model.ShareLinkData;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.kakaoent.leonplayer.core.LeonPlayer;
import com.kakaoent.leonplayer.core.model.data.player.LeonVideoProfile;
import com.melon.ui.popup.b;
import com.melon.ui.popup.context.more.ExtraProperties.CheckedItemInfo;
import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import gc.G;
import gc.l;
import ie.H;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import q8.a;
import q8.f;
import q8.h;
import we.k;
import zd.A;
import zd.M;
import zd.Q;
import zd.o0;
import zd.x;

public final class s implements k {
    public final int a;
    public final Object b;
    public final Object c;

    public s(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        String s3;
        Playable playable1;
        ShareLinkData shareLinkData0;
        int v = 0;
        String s = "";
        Object object1 = null;
        boolean z = true;
        H h0 = H.a;
        Object object2 = this.c;
        Object object3 = this.b;
        switch(this.a) {
            case 0: {
                LinearLayout linearLayout0 = ((InfoViewHolder)object3).getBinding().e;
                if(((int)(((Integer)object0))) != 1 && !((Mv)object2).isOpen) {
                    v = 1;
                }
                ViewUtils.showWhen(linearLayout0, ((boolean)v));
                return h0;
            }
            case 1: {
                VideoMoreFragment videoMoreBottomSheetFragment$VideoMoreFragment0 = (VideoMoreFragment)object2;
                LiveViewModel liveViewModel0 = videoMoreBottomSheetFragment$VideoMoreFragment0.d;
                q.g(((e)object0), "userEvent");
                if(((e)object0) instanceof A) {
                    Playable playable0 = ((Q)object3) instanceof o0 ? ((o0)(((Q)object3))).y() : null;
                    switch(((A)(((e)object0))).b.a.ordinal()) {
                        case 5: {
                            videoMoreBottomSheetFragment$VideoMoreFragment0.downloadMv("1000000550", playable0);
                            videoMoreBottomSheetFragment$VideoMoreFragment0.d0();
                            return h0;
                        }
                        case 11: {
                            RESPONSE melonTvVdoGetMvProgInfoRes$RESPONSE0 = videoMoreBottomSheetFragment$VideoMoreFragment0.f;
                            if(melonTvVdoGetMvProgInfoRes$RESPONSE0 == null) {
                            label_39:
                                MelonBaseFragment melonBaseFragment1 = videoMoreBottomSheetFragment$VideoMoreFragment0.e0();
                                if(melonBaseFragment1 != null) {
                                    melonBaseFragment1.showArtistInfoPage(playable0);
                                }
                            }
                            else {
                                if(melonTvVdoGetMvProgInfoRes$RESPONSE0.isBrandDj) {
                                    Navigator.openUserMain(melonTvVdoGetMvProgInfoRes$RESPONSE0.brandKey);
                                    object1 = h0;
                                }
                                else {
                                    MelonBaseFragment melonBaseFragment0 = videoMoreBottomSheetFragment$VideoMoreFragment0.e0();
                                    if(melonBaseFragment0 != null) {
                                        melonBaseFragment0.showArtistInfoPage(playable0);
                                        object1 = h0;
                                    }
                                }
                                if(object1 == null) {
                                    goto label_39;
                                }
                            }
                            videoMoreBottomSheetFragment$VideoMoreFragment0.d0();
                            return h0;
                        }
                        case 38: {
                            if(playable0 == null || !playable0.isLiveContent()) {
                                playable1 = playable0;
                            }
                            else {
                                LiveDetailRes liveDetailRes0 = (LiveDetailRes)liveViewModel0.getLiveRes().getValue();
                                if(liveDetailRes0 == null) {
                                    shareLinkData0 = null;
                                }
                                else {
                                    Response liveDetailRes$Response0 = liveDetailRes0.response;
                                    shareLinkData0 = liveDetailRes$Response0 == null ? null : liveDetailRes$Response0.snsInfo;
                                }
                                LiveDetailRes liveDetailRes1 = (LiveDetailRes)liveViewModel0.getLiveRes().getValue();
                                if(liveDetailRes1 != null) {
                                    Response liveDetailRes$Response1 = liveDetailRes1.response;
                                    if(liveDetailRes$Response1 != null) {
                                        Live liveDetailRes$Response$Live0 = liveDetailRes$Response1.live;
                                        if(liveDetailRes$Response$Live0 != null) {
                                            object1 = liveDetailRes$Response$Live0.artistList;
                                        }
                                    }
                                }
                                String s1 = ProtocolUtils.getArtistNames(((List)object1));
                                if(s1 == null) {
                                    s1 = "";
                                }
                                SharableLive.CREATOR.getClass();
                                q.f("", "getLiveSeq(...)");
                                q.f("", "getLiveTitle(...)");
                                q.f("", "getAlbumImg(...)");
                                playable1 = new SharableLive();  // 初始化器: Ljava/lang/Object;-><init>()V
                                playable1.a = "";
                                playable1.b = "";
                                playable1.d = s1;
                                playable1.e = "";
                                playable1.f = shareLinkData0;
                            }
                            if(playable0 != null && playable0.isLiveContent()) {
                                MelonBaseFragment melonBaseFragment2 = videoMoreBottomSheetFragment$VideoMoreFragment0.e0();
                                if(melonBaseFragment2 != null) {
                                    melonBaseFragment2.showSNSListPopup(playable1);
                                }
                                videoMoreBottomSheetFragment$VideoMoreFragment0.d0();
                                return h0;
                            }
                            if(playable0 == null) {
                                s3 = "";
                            }
                            else {
                                ContsTypeCode contsTypeCode0 = playable0.getContsTypeCode();
                                if(contsTypeCode0 == null) {
                                    s3 = "";
                                }
                                else {
                                    String s2 = contsTypeCode0.code();
                                    s3 = s2 == null ? "" : s2;
                                }
                            }
                            boolean z1 = playable0 != null && playable0.isTypeOfMv();
                            BuildersKt__Builders_commonKt.launch$default(videoMoreBottomSheetFragment$VideoMoreFragment0, null, null, new VideoMoreBottomSheetFragment.VideoMoreFragment.renderUi.1.1.1.1.1(videoMoreBottomSheetFragment$VideoMoreFragment0, s3, "", playable0, playable1, null), 3, null);
                            return h0;
                        }
                        case 106: {
                            Context context0 = videoMoreBottomSheetFragment$VideoMoreFragment0.requireContext();
                            q.f(context0, "requireContext(...)");
                            G g0 = F.x(context0).a().i;
                            if(g0 != null) {
                                ArrayList arrayList0 = new ArrayList();
                                MelonBottomSheetItem melonBottomSheetItem0 = x.E0;
                                String s5 = videoMoreBottomSheetFragment$VideoMoreFragment0.getString(0x7F1302A1);  // string:ctx_setting_quality "화질 설정"
                                q.f(s5, "getString(...)");
                                LeonPlayer leonPlayer0 = ((l)g0).f;
                                if(leonPlayer0.getCurrentVideoProfile() != null) {
                                    z = false;
                                }
                                arrayList0.add(MelonBottomSheetItem.a(melonBottomSheetItem0, false, new CheckedItemInfo(0, s5, z), 0x1F));
                                LeonVideoProfile leonVideoProfile0 = leonPlayer0.getCurrentVideoProfile();
                                for(Object object4: leonPlayer0.getCurrentVideoProfiles()) {
                                    if(v >= 0) {
                                        arrayList0.add(new MelonBottomSheetItem(M.G1, -1, null, ((LeonVideoProfile)object4).getSimpleName(), new CheckedItemInfo(v + 1, ((LeonVideoProfile)object4).getSimpleName(), q.b((leonVideoProfile0 == null ? null : leonVideoProfile0.getId()), ((LeonVideoProfile)object4).getId())), 20));
                                        ++v;
                                        continue;
                                    }
                                    e.k.O();
                                    throw null;
                                }
                                FragmentActivity fragmentActivity0 = videoMoreBottomSheetFragment$VideoMoreFragment0.getActivity();
                                if(fragmentActivity0 != null) {
                                    object1 = fragmentActivity0.getSupportFragmentManager();
                                }
                                String s6 = videoMoreBottomSheetFragment$VideoMoreFragment0.getString(0x7F130A00);  // string:setting_video_quality "화질 설정"
                                q.f(s6, "getString(...)");
                                b.u(((l0)object1), s6, arrayList0, new com.iloen.melon.player.video.o0(g0, 3));
                                videoMoreBottomSheetFragment$VideoMoreFragment0.d0();
                                return h0;
                            }
                            break;
                        }
                        case 107: {
                            Response liveDetailRes$Response2 = videoMoreBottomSheetFragment$VideoMoreFragment0.g;
                            if(liveDetailRes$Response2 != null) {
                                Live liveDetailRes$Response$Live1 = liveDetailRes$Response2.live;
                                if(liveDetailRes$Response$Live1 != null) {
                                    object1 = liveDetailRes$Response$Live1.artistList;
                                }
                            }
                            if(object1 != null && !((Collection)object1).isEmpty()) {
                                MelonBaseFragment melonBaseFragment3 = videoMoreBottomSheetFragment$VideoMoreFragment0.e0();
                                if(melonBaseFragment3 != null) {
                                    melonBaseFragment3.showMultiArtistPopup(((ArrayList)object1), new VideoMoreBottomSheetFragment.VideoMoreFragment.renderUi.1.1.1.1.4(), false, true, videoMoreBottomSheetFragment$VideoMoreFragment0.getString(0x7F13022F), null);  // 初始化器: Ljava/lang/Object;-><init>()V
                                }
                                videoMoreBottomSheetFragment$VideoMoreFragment0.d0();
                                return h0;
                            }
                            break;
                        }
                        case 108: {
                            Navigator navigator0 = Navigator.INSTANCE;
                            RESPONSE melonTvVdoGetMvProgInfoRes$RESPONSE1 = videoMoreBottomSheetFragment$VideoMoreFragment0.f;
                            if(melonTvVdoGetMvProgInfoRes$RESPONSE1 != null) {
                                PROG melonTvVdoGetMvProgInfoRes$RESPONSE$PROG0 = melonTvVdoGetMvProgInfoRes$RESPONSE1.prog;
                                if(melonTvVdoGetMvProgInfoRes$RESPONSE$PROG0 != null) {
                                    String s4 = melonTvVdoGetMvProgInfoRes$RESPONSE$PROG0.progSeq;
                                    if(s4 != null) {
                                        s = s4;
                                    }
                                }
                            }
                            navigator0.openMelonTvProgram(s);
                            videoMoreBottomSheetFragment$VideoMoreFragment0.d0();
                            return h0;
                        }
                        case 110: {
                            liveViewModel0.getLivePreviewSubscribeManager().toggleSubscribeAsync();
                            return h0;
                        }
                        default: {
                            return h0;
                        }
                    }
                }
                else if(((e)object0) instanceof zd.G) {
                    M m0 = ((zd.G)(((e)object0))).b.a;
                    if(m0 == M.t1) {
                        v v1 = (v)videoMoreBottomSheetFragment$VideoMoreFragment0.vodRepeatManager;
                        boolean z2 = v1.b();
                        v1.d(!z2);
                        ToastManager.show((z2 ? 0x7F131074 : 0x7F131075));  // string:toast_video_repeat_off "현재 비디오 반복 재생을 취소합니다."
                        return h0;
                    }
                    if(m0 == M.C1) {
                        liveViewModel0.getLivePreviewSubscribeManager().toggleSubscribeAsync();
                    }
                }
                return h0;
            }
            case 2: {
                q.g(((q8.b)object0), "$this$common");
                ((q8.b)object0).a = ((VideoChatFragment)object3).getString(0x7F131035);  // string:tiara_video_player_section "영상플레이어"
                ((q8.b)object0).b = ((VideoChatFragment)object3).getString(0x7F131031);  // string:tiara_video_player_page_live_onair "영상플레이어_LIVE"
                ((q8.b)object0).c = (ActionKind)object2;
                return h0;
            }
            case 3: {
                q.g(((f)object0), "$this$eventMeta");
                ((f)object0).a = ((MagazineList)object3).mStorySeq;
                ((f)object0).b = ((VideoInfoFragment)object2).getString(0x7F130EFB);  // string:tiara_meta_type_magazine "매거진"
                return h0;
            }
            case 4: {
                q.g(((f)object0), "$this$eventMeta");
                ((f)object0).a = (String)object3;
                ((f)object0).c = (String)object2;
                return h0;
            }
            case 5: {
                q.g(((f)object0), "$this$eventMeta");
                ((f)object0).a = "";
                ((f)object0).b = ((VideoInfoFragment)object2).getString(0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
                ((f)object0).c = ProtocolUtils.getArtistNames(((ArrayList)object3));
                return h0;
            }
            case 6: {
                q.g(((StringBuilder)object0), "$this$buildDebug");
                ((StringBuilder)object0).append("getPictureInPictureParams() Ratio: " + ((Rational)object3));
                int v2 = ((Rect)object2).left;
                int v3 = ((Rect)object2).top;
                int v4 = ((Rect)object2).right;
                int v5 = ((Rect)object2).bottom;
                StringBuilder stringBuilder0 = o.t(v2, v3, "visibleRect(left=", ", top=", ", right=");
                stringBuilder0.append(v4);
                stringBuilder0.append(", bottom=");
                stringBuilder0.append(v5);
                stringBuilder0.append(")");
                i.a(((StringBuilder)object0), stringBuilder0.toString());
                i.a(((StringBuilder)object0), "width=" + ((Rect)object2).width() + ", height=" + ((Rect)object2).height());
                return h0;
            }
            case 7: {
                q.g(((h)object0), "$this$track");
                String s7 = ((VideoMiniPlayer)object3).getContext().getResources().getString((((TiaraLogType)object2) == TiaraLogType.PLAY_VIDEO ? 0x7F130DCC : 0x7F130DC9));  // string:tiara_common_action_name_play_video "영상재생"
                if(s7 != null) {
                    s = s7;
                }
                ((h)object0).a = s;
                return h0;
            }
            case 8: {
                q.g(((f)object0), "$this$pageMeta");
                ((f)object0).b = ((VideoPlayerFragmentBase)object3).getString(0x7F130EFE);  // string:tiara_meta_type_mv "영상"
                ((f)object0).a = "";
                ((f)object0).c = "";
                return h0;
            }
            case 9: {
                VideoPlayerLiveFragment.r0(((VideoPlayerLiveFragment)object3), null, ((com.iloen.melon.net.v6x.response.LiveTimedMetaSongRes.RESPONSE)object0), ((View)object2), 1);
                return h0;
            }
            case 10: {
                q.g(((q8.b)object0), "$this$common");
                ((q8.b)object0).a = ((SongListFragment)object2).getString(0x7F131035);  // string:tiara_video_player_section "영상플레이어"
                ((q8.b)object0).b = ((SongListFragment)object2).getString(0x7F131031);  // string:tiara_video_player_page_live_onair "영상플레이어_LIVE"
                if(((ActionKind)object3) != null) {
                    ((q8.b)object0).c = (ActionKind)object3;
                }
                return h0;
            }
            case 11: {
                q.g(((a)object0), "$this$click");
                ((a)object0).a = ((SongListFragment)object2).getString(0x7F130D45);  // string:tiara_click_copy_live_song_list "선곡표"
                if(((String)object3).length() > 0) {
                    ((a)object0).g = (String)object3;
                }
                return h0;
            }
            default: {
                q.g(((f)object0), "$this$pageMeta");
                ((f)object0).b = ((SongListFragment)object3).getString(0x7F130EFE);  // string:tiara_meta_type_mv "영상"
                ((f)object0).a = "";
                ((f)object0).c = "";
                return h0;
            }
        }
    }
}

