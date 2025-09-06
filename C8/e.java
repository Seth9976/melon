package C8;

import Cb.i;
import Cc.l3;
import N0.Z;
import N0.a0;
import Nb.h0;
import Nc.J;
import Oc.g;
import U4.F;
import Uc.p;
import Vb.o0;
import X0.c;
import X0.u;
import X0.x;
import android.view.View;
import androidx.compose.runtime.b1;
import androidx.media3.session.f0;
import androidx.media3.session.w0;
import cd.C2;
import cd.D2;
import cd.E2;
import cd.F2;
import cd.G2;
import cd.Q2;
import cd.R2;
import cd.S2;
import cd.T2;
import com.iloen.melon.drm.CollectionRulesDcf;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.WEEKLYDJ.CONTENTS;
import com.iloen.melon.net.v6x.response.MainTopNotificationRes.FeedType;
import com.iloen.melon.playback.playlist.db.PlaylistDao_Impl;
import com.iloen.melon.player.playlist.VideoPlaylistFragment;
import com.iloen.melon.player.video.VideoMiniPlayer;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.preference.MusicTabPrefsHelper;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.data.Meta.Builder;
import com.melon.net.res.SearchMainContentRes.ArchivingThemeItem;
import com.melon.net.res.VoiceAlarm.AlbumDto;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.ui.K4;
import dd.T;
import dd.W;
import ed.F0;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.LinkedHashMap;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import ld.b;
import p8.f;
import q8.a;
import we.k;

public final class e implements k {
    public final int a;
    public final int b;
    public final Object c;

    public e(int v, h0 h00, f0 f00, w0 w00) {
        this.a = 3;
        super();
        this.b = v;
        this.c = h00;
    }

    public e(int v, Object object0, int v1) {
        this.a = v1;
        this.b = v;
        this.c = object0;
        super();
    }

    public e(Object object0, int v, int v1) {
        this.a = v1;
        this.c = object0;
        this.b = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        String s;
        boolean z = true;
        H h0 = H.a;
        int v = this.b;
        Object object1 = this.c;
        switch(this.a) {
            case 0: {
                q.g(((x)object0), "$this$semantics");
                u.k(((x)object0), 0);
                u.g(((x)object0), new c(0, 1, v, 1));
                if(((Number)((b1)object1).getValue()).intValue() != v) {
                    z = false;
                }
                u.l(((x)object0), z);
                return h0;
            }
            case 1: {
                q.g(((androidx.compose.runtime.H)object0), "$this$DisposableEffect");
                return new l3(((View)object1), v);
            }
            case 2: {
                q.g(((f)object0), "$this$trackTiaraEventLog");
                ((f)object0).a = "";
                ((f)object0).d = ActionKind.ClickContent;
                ((f)object0).y = "";
                ((f)object0).F = ((AlbumDto)object1).getAlbumName();
                ((f)object0).C = String.valueOf(v);
                ((f)object0).b0 = new Builder().id(((AlbumDto)object1).getAlbumId()).type("").name(((AlbumDto)object1).getAlbumName()).build();
                return (f)object0;
            }
            case 3: {
                q.g(((StringBuilder)object0), "$this$buildDebug");
                ((StringBuilder)object0).append("onPlayerCommandRequest() playerCommand: " + F.Z(v));
                ((h0)object1).getClass();
                return h0;
            }
            case 4: {
                q.g(((K4)object0), "it");
                q.g(((g)object1).b.b, "genreDetailAlyacUiStateList");
                J j0 = new J(v, ((g)object1).b.b);
                q.g(((g)object1).a, "genreDetailMixUpButtonUiState");
                return new g(((g)object1).a, j0);
            }
            case 5: {
                q.g(((StringBuilder)object0), "$this$buildDebug");
                ((StringBuilder)object0).append("seekToNextOrPrevious()");
                ((o0)object1).F.getClass();
                i.a(((StringBuilder)object0), "skipCount: " + v + ", maxCount: 3");
                i.a(((StringBuilder)object0), "latestSeekCommand: " + F.Z(((o0)object1).N.get()));
                return h0;
            }
            case 6: {
                return PlaylistDao_Impl.w(((PlaylistDao_Impl)object1), v, ((Continuation)object0));
            }
            case 7: {
                q.g(((a)object0), "$this$click");
                ((a)object0).a = ((VideoPlaylistFragment)object1).getString(0x7F130E07);  // string:tiara_common_layer1_playlist_video "재생목록"
                ((a)object0).e = String.valueOf(v);
                return h0;
            }
            case 8: {
                q.g(((Z)object0), "$this$layout");
                ((Z)object0).d(((a0)object1), 0, v, 0.0f);
                return h0;
            }
            case 9: {
                q.g(((a)object0), "$this$click");
                ((a)object0).a = "컨트롤뷰";
                ((a)object0).g = ((VideoMiniPlayer)object1).getContext().getResources().getString(v);
                return h0;
            }
            case 10: {
                q.g(((StringBuilder)object0), "$this$buildDebug");
                ((StringBuilder)object0).append("extendDueDateImpl()");
                i.a(((StringBuilder)object0), "Prev Count: " + v);
                i.a(((StringBuilder)object0), "After Count: " + ((CollectionRulesDcf)object1).f);
                return h0;
            }
            case 11: {
                q.g(((G2)object0), "userEvent");
                if(((G2)object0) instanceof E2) {
                    MelonLinkExecutor.open(MelonLinkInfo.b(((E2)(((G2)object0))).a));
                    FeedType mainTopNotificationRes$FeedType0 = ((E2)(((G2)object0))).b;
                    String s1 = ((E2)(((G2)object0))).c;
                    ((T)object1).getClass();
                    String s2 = T.p(mainTopNotificationRes$FeedType0);
                    p p0 = dd.H.c(((T)object1), ActionKind.ClickContent, null, 0, 0, null, false, null, 0, null, 0x3FE);
                    a a0 = (a)p0.d;
                    if(a0 == null) {
                        a a1 = new a();  // 初始化器: Lcom/kakao/tiara/data/Click$Builder;-><init>()V
                        a1.g = s2;
                        p0.d = a1;
                    }
                    else {
                        a0.g = s2;
                    }
                    p0.e(new com.iloen.melon.player.playlist.mixup.composables.c(mainTopNotificationRes$FeedType0, s1, s2, 5));
                    p0.p().track();
                    return h0;
                }
                if(((G2)object0) instanceof D2) {
                    MusicTabPrefsHelper.INSTANCE.putTopNotification(((D2)(((G2)object0))).a);
                    ((T)object1).q(((D2)(((G2)object0))).b);
                    return h0;
                }
                if(((G2)object0) instanceof C2) {
                    MusicTabPrefsHelper.INSTANCE.putTopNotificationBadge(((C2)(((G2)object0))).a);
                    ((T)object1).q(((C2)(((G2)object0))).b);
                    return h0;
                }
                if(!(((G2)object0) instanceof F2)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                ((T)object1).getClass();
                String s3 = T.p(((F2)(((G2)object0))).c);
                dd.H.a(((T)object1), ((F2)(((G2)object0))).a, this.b, (((F2)(((G2)object0))).c == FeedType.DNA ? "" : ((F2)(((G2)object0))).b), s3, null, null, null, 0, null, 0x7E0);
                return h0;
            }
            case 12: {
                q.g(((T2)object0), "userEvent");
                int v1 = this.b;
                String s4 = "";
                String s5 = null;
                if(((T2)object0) instanceof Q2) {
                    MelonLinkExecutor.open(MelonLinkInfo.b(((Q2)(((T2)object0))).a.a));
                    CONTENTS mainMusicRes$RESPONSE$WEEKLYDJ$CONTENTS0 = ((Q2)(((T2)object0))).a.a;
                    String s6 = mainMusicRes$RESPONSE$WEEKLYDJ$CONTENTS0 == null ? null : mainMusicRes$RESPONSE$WEEKLYDJ$CONTENTS0.getMemberNickName();
                    if(s6 == null) {
                        s6 = "";
                    }
                    ((W)object1).getClass();
                    p p1 = dd.H.c(((W)object1), ActionKind.ClickContent, null, 0, v1, null, false, null, 0, null, 0x3F6);
                    LinkedHashMap linkedHashMap0 = (LinkedHashMap)p1.g;
                    q8.c c0 = new q8.c();
                    StatsElementsBase statsElementsBase0 = ((W)object1).f;
                    if(statsElementsBase0 != null) {
                        s5 = statsElementsBase0.impressionId;
                    }
                    if(s5 != null) {
                        s4 = s5;
                    }
                    c0.a.put("toros_banner_imp_id", s4);
                    linkedHashMap0.putAll(c0.a);
                    q8.f f0 = (q8.f)p1.e;
                    if(f0 == null) {
                        q8.f f1 = new q8.f();  // 初始化器: Ljava/lang/Object;-><init>()V
                        f1.h = s6;
                        p1.e = f1;
                    }
                    else {
                        f0.h = s6;
                    }
                    p1.p().track();
                    return h0;
                }
                if(((T2)object0) instanceof S2) {
                    CONTENTS mainMusicRes$RESPONSE$WEEKLYDJ$CONTENTS1 = ((S2)(((T2)object0))).a.a;
                    if(mainMusicRes$RESPONSE$WEEKLYDJ$CONTENTS1 == null) {
                        return h0;
                    }
                    DjPlayListInfoBase djPlayListInfoBase0 = mainMusicRes$RESPONSE$WEEKLYDJ$CONTENTS1.getPlaylist();
                    if(djPlayListInfoBase0 != null) {
                        s5 = djPlayListInfoBase0.plylstseq;
                    }
                    if(s5 != null) {
                        s4 = s5;
                    }
                    Navigator.openDjPlaylistDetail(s4);
                    ((W)object1).p(mainMusicRes$RESPONSE$WEEKLYDJ$CONTENTS1, ActionKind.ClickContent, v1);
                    return h0;
                }
                if(!(((T2)object0) instanceof R2)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                CONTENTS mainMusicRes$RESPONSE$WEEKLYDJ$CONTENTS2 = ((R2)(((T2)object0))).a.a;
                if(mainMusicRes$RESPONSE$WEEKLYDJ$CONTENTS2 != null) {
                    DjPlayListInfoBase djPlayListInfoBase1 = mainMusicRes$RESPONSE$WEEKLYDJ$CONTENTS2.getPlaylist();
                    if(djPlayListInfoBase1 != null) {
                        s5 = djPlayListInfoBase1.plylstseq;
                    }
                    if(s5 != null) {
                        s4 = s5;
                    }
                    ((W)object1).g(s4);
                    ((W)object1).p(mainMusicRes$RESPONSE$WEEKLYDJ$CONTENTS2, ActionKind.PlayMusic, v1);
                }
                return h0;
            }
            case 13: {
                F0.h(((F0)object1), v, ((ArchivingThemeItem)object0));
                return h0;
            }
            default: {
                q.g(((a)object0), "$this$click");
                ((a)object0).a = ((b)object1).getString(0x7F130EB8);  // string:tiara_gnb_layer1_gnb "GNB"
                ((a)object0).b = ((b)object1).getString(0x7F130E2F);  // string:tiara_common_layer2_move_page "페이지이동"
                switch(v) {
                    case 0: {
                        s = ((b)object1).getString(0x7F130F8F);  // string:tiara_new_music_pager_music "최신곡"
                        q.f(s, "getString(...)");
                        break;
                    }
                    case 1: {
                        s = ((b)object1).getString(0x7F130F8E);  // string:tiara_new_music_pager_album "최신앨범"
                        q.f(s, "getString(...)");
                        break;
                    }
                    default: {
                        s = ((b)object1).getString(0x7F130F90);  // string:tiara_new_music_pager_mv "뮤직비디오"
                        q.f(s, "getString(...)");
                    }
                }
                ((a)object0).g = s;
                return h0;
            }
        }
    }
}

