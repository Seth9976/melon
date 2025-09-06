package com.iloen.melon.player.video;

import Ac.V2;
import Ce.e;
import Hd.F0;
import J8.J3;
import P4.a;
import Tf.v;
import U8.s;
import a9.f;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import androidx.recyclerview.widget.w0;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.RecyclerViewWithEmptyView;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.comments.CmtListFragment.Param;
import com.iloen.melon.fragments.comments.VideoCommentActionImpl;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v3x.comments.CmtResViewModel;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummRes.result.CMTCONTSSUMM;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummRes.result;
import com.iloen.melon.net.v4x.request.UserActionsReq.Params;
import com.iloen.melon.net.v4x.request.UserActionsReq;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v6x.response.VodDetailRes.Response.Concert.Ticket;
import com.iloen.melon.net.v6x.response.VodDetailRes.Response.Magazine.MagazineList;
import com.iloen.melon.net.v6x.response.VodDetailRes.Response.RecmMv.Mv;
import com.iloen.melon.net.v6x.response.VodDetailRes.Response;
import com.iloen.melon.net.v6x.response.VodDetailRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.player.playlist.VideoPlaylistFragment;
import com.iloen.melon.popup.ContextListPopup;
import com.iloen.melon.task.request.LikeUpdateAsyncTask.OnJobFinishListener;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.FamilyAppHelper;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.Meta.Builder;
import com.melon.net.res.common.ArtistsInfoBase;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.net.res.common.SongInfoBase;
import d3.g;
import e.k;
import e1.b;
import e1.m;
import i.n.i.b.a.s.e.M3;
import ie.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import je.p;
import kc.d3;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import ob.z;
import oc.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.h;
import v8.i;
import v9.c;
import we.n;

@Metadata(d1 = {"\u0000\u008C\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0002>?B\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\b\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\tH\u0017\u00A2\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000EH\u0014\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0013\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001A\u00020\u000B2\u0006\u0010\u0016\u001A\u00020\u0015H\u0014\u00A2\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u001A\u001A\u00020\u00192\b\u0010\u001C\u001A\u0004\u0018\u00010\u001B2\b\u0010\u001D\u001A\u0004\u0018\u00010\u0015H\u0016\u00A2\u0006\u0004\b\u001F\u0010 J\u000F\u0010!\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b!\u0010\u0004J!\u0010#\u001A\u00020\u000B2\u0006\u0010\"\u001A\u00020\u001E2\b\u0010\u001D\u001A\u0004\u0018\u00010\u0015H\u0016\u00A2\u0006\u0004\b#\u0010$J-\u0010*\u001A\u00020\u00052\b\u0010&\u001A\u0004\u0018\u00010%2\b\u0010(\u001A\u0004\u0018\u00010\'2\b\u0010)\u001A\u0004\u0018\u00010\u0012H\u0014\u00A2\u0006\u0004\b*\u0010+J\u000F\u0010-\u001A\u00020,H\u0014\u00A2\u0006\u0004\b-\u0010.J\u001B\u00102\u001A\u0006\u0012\u0002\b\u0003012\u0006\u00100\u001A\u00020/H\u0014\u00A2\u0006\u0004\b2\u00103J\u001F\u00107\u001A\u00020\u000B2\u0006\u00104\u001A\u00020,2\u0006\u00106\u001A\u000205H\u0016\u00A2\u0006\u0004\b7\u00108R\u001B\u0010=\u001A\u0002098FX\u0086\u0084\u0002\u00A2\u0006\f\n\u0004\b:\u0010;\u001A\u0004\b\u0010\u0010<\u00A8\u0006@"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "La9/f;", "<init>", "()V", "", "shouldIgnoreSetUIOnForegroundEvent", "()Z", "shouldShowMiniPlayer", "Landroid/content/res/Configuration;", "newConfig", "Lie/H;", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Lv8/a;", "Lcom/iloen/melon/net/v6x/response/VodDetailRes;", "getViewModel", "()Lv8/a;", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onDestroyView", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "recyclerView", "", "positions", "onReadyToFetchPartially", "(Landroidx/recyclerview/widget/RecyclerView;[I)V", "Lcom/iloen/melon/player/video/VideoInfoViewModel;", "b", "Lie/j;", "()Lcom/iloen/melon/player/video/VideoInfoViewModel;", "viewModel", "Companion", "VideoInfoClickListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoInfoFragment extends MetaContentBaseFragment implements f {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoFragment$Companion;", "", "Lcom/iloen/melon/player/video/VideoInfoFragment;", "newInstance", "()Lcom/iloen/melon/player/video/VideoInfoFragment;", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final VideoInfoFragment newInstance() {
            VideoInfoFragment videoInfoFragment0 = new VideoInfoFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putBoolean("argHasPersonalizedContent", true);
            videoInfoFragment0.setArguments(bundle0);
            return videoInfoFragment0;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n¨\u0006\u000BÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoFragment$VideoInfoClickListener;", "Lcom/iloen/melon/player/video/VideoInfoAdapter$CommonClickListener;", "Lcom/iloen/melon/player/video/VideoInfoAdapter$InfoClickListener;", "Lcom/iloen/melon/player/video/VideoInfoAdapter$BannerClickListener;", "Lcom/iloen/melon/player/video/VideoInfoAdapter$ArtistClickListener;", "Lcom/iloen/melon/player/video/VideoInfoAdapter$SongClickListener;", "Lcom/iloen/melon/player/video/VideoInfoAdapter$MoreClickListener;", "Lcom/iloen/melon/player/video/VideoInfoAdapter$DjClickListener;", "Lcom/iloen/melon/player/video/VideoInfoAdapter$MagazineClickListener;", "Lcom/iloen/melon/player/video/VideoInfoAdapter$ConcertClickListener;", "Lcom/iloen/melon/player/video/VideoInfoAdapter$EtcClickListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface VideoInfoClickListener extends ArtistClickListener, BannerClickListener, CommonClickListener, ConcertClickListener, DjClickListener, EtcClickListener, InfoClickListener, MagazineClickListener, MoreClickListener, SongClickListener {
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[h.values().length];
            try {
                arr_v[3] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[0] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[1] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[2] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[4] = 5;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public final LogU a;
    public final r b;
    public final r c;
    public final r d;
    public J3 e;
    public final com.iloen.melon.player.video.VideoInfoFragment.listener.1 f;

    static {
        VideoInfoFragment.Companion = new Companion(null);
        VideoInfoFragment.$stable = 8;
    }

    public VideoInfoFragment() {
        this.a = com.iloen.melon.utils.log.LogU.Companion.create$default(LogU.Companion, "VideoInfoFragment", false, Category.UI, 2, null);
        this.b = g.Q(new A(this, 1));
        this.c = g.Q(new A(this, 2));
        this.d = g.Q(new A(this, 0));
        this.f = new VideoInfoClickListener() {
            public final VideoInfoFragment a;

            {
                this.a = videoInfoFragment0;
            }

            @Override  // com.iloen.melon.player.video.VideoInfoAdapter$CommonClickListener
            public void onArtist(ArrayList arrayList0, boolean z, String s, int v) {
                q.g(s, "source");
                if(arrayList0 != null && !arrayList0.isEmpty()) {
                    Object object0 = arrayList0.get(0);
                    q.f(object0, "get(...)");
                    VideoInfoFragment videoInfoFragment0 = this.a;
                    if(((ArtistsInfoBase)object0).isBrand()) {
                        Navigator.openUserMain(((ArtistsInfoBase)object0).getArtistId());
                    }
                    else if(z) {
                        videoInfoFragment0.showArtistInfoPage(((ArtistsInfoBase)arrayList0.get(0)).getArtistId());
                    }
                    else {
                        videoInfoFragment0.showArtistInfoPage(arrayList0);
                    }
                    if(VideoInfoFragment.access$getMMelonTiaraProperty$p$s-1421613799(videoInfoFragment0) != null) {
                        m.F(new Oc.m(videoInfoFragment0, s, v, arrayList0, 8)).track();
                    }
                }
            }

            @Override  // com.iloen.melon.player.video.VideoInfoAdapter$ArtistClickListener
            public void onArtistFan(View view0, ArtistsInfoBase artistsInfoBase0, int v) {
                q.g(view0, "view");
                q.g(artistsInfoBase0, "data");
                if("Y".equals("N")) {
                    return;
                }
                String s = this.a.getMenuId();
                com.iloen.melon.player.video.VideoInfoFragment.listener.1.onArtistFan.1 videoInfoFragment$listener$1$onArtistFan$10 = new OnJobFinishListener() {
                    public final View a;
                    public final VideoInfoFragment b;
                    public final int c;
                    public final ArtistsInfoBase d;

                    {
                        View view0 = this.a;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        VideoInfoFragment videoInfoFragment0 = v;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        int v = artistsInfoBase0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        this.a = view0;
                        this.b = videoInfoFragment0;
                        this.c = v;
                        this.d = artistsInfoBase0;
                    }

                    @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
                    public void onJobComplete(String s, int v, boolean z) {
                        q.g(s, "errorMsg");
                        this.a.setEnabled(true);
                        this.a.setClickable(true);
                        VideoInfoFragment videoInfoFragment0 = this.b;
                        if(!videoInfoFragment0.isFragmentValid()) {
                            return;
                        }
                        if(s.length() > 0) {
                            return;
                        }
                        j0 j00 = VideoInfoFragment.access$getRecyclerView(videoInfoFragment0).getAdapter();
                        if(j00 instanceof VideoInfoAdapter) {
                            int v1 = this.c;
                            if(((VideoInfoAdapter)j00).getItemViewType(v1) == 5) {
                                Object object0 = ((VideoInfoAdapter)j00).getList().get(v1);
                                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoViewModel.WrappedData");
                                Object object1 = ((WrappedData)object0).getData();
                                q.e(object1, "null cannot be cast to non-null type com.melon.net.res.common.ArtistsInfoBase");
                                ((ArtistsInfoBase)object1).setFanYn("Y");
                                ((VideoInfoAdapter)j00).notifyItemChanged(v1);
                            }
                        }
                        VideoInfoFragment.access$showRecommendContentsPopup(videoInfoFragment0, this.d.getArtistId(), "C");
                    }

                    @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
                    public void onStartAsyncTask() {
                        this.a.setEnabled(false);
                        this.a.setClickable(false);
                    }
                };
                VideoInfoFragment.access$updateFan(this.a, artistsInfoBase0.getArtistId(), "N10006", true, s, videoInfoFragment$listener$1$onArtistFan$10);
            }

            @Override  // com.iloen.melon.player.video.VideoInfoAdapter$BannerClickListener
            public void onBanner(String s, String s1) {
                q.g(s, "id");
                q.g(s1, "url");
                VideoInfoFragment videoInfoFragment0 = this.a;
                if(VideoInfoFragment.access$getMMelonTiaraProperty$p$s-1421613799(videoInfoFragment0) == null) {
                    return;
                }
                m.F(new E(videoInfoFragment0, s1, s, 0)).track();
            }

            @Override  // com.iloen.melon.player.video.VideoInfoAdapter$ConcertClickListener
            public void onConcertItem(Ticket vodDetailRes$Response$Concert$Ticket0) {
                q.g(vodDetailRes$Response$Concert$Ticket0, "data");
                MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
                melonLinkInfo0.c = vodDetailRes$Response$Concert$Ticket0.appSchemaUrl;
                melonLinkInfo0.b = vodDetailRes$Response$Concert$Ticket0.linkurl;
                melonLinkInfo0.a = vodDetailRes$Response$Concert$Ticket0.linktype;
                FamilyAppHelper.getFamilyApp(v9.f.a).openApp(melonLinkInfo0);
                VideoInfoFragment videoInfoFragment0 = this.a;
                if(VideoInfoFragment.access$getMMelonTiaraProperty$p$s-1421613799(videoInfoFragment0) == null) {
                    return;
                }
                m.F(new I(videoInfoFragment0, vodDetailRes$Response$Concert$Ticket0)).track();
            }

            @Override  // com.iloen.melon.player.video.VideoInfoAdapter$EtcClickListener
            public void onContentsMore() {
                Navigator.openMelonTvMain();
            }

            @Override  // com.iloen.melon.player.video.VideoInfoAdapter$DjClickListener
            public void onDjItem(DjPlayListInfoBase djPlayListInfoBase0, int v) {
                q.g(djPlayListInfoBase0, "data");
                Navigator.openDjPlaylistDetail(djPlayListInfoBase0.plylstseq);
                VideoInfoFragment videoInfoFragment0 = this.a;
                if(VideoInfoFragment.access$getMMelonTiaraProperty$p$s-1421613799(videoInfoFragment0) == null) {
                    return;
                }
                m.F(new P(videoInfoFragment0, v, djPlayListInfoBase0, 0)).track();
            }

            @Override  // com.iloen.melon.player.video.VideoInfoAdapter$DjClickListener
            public void onDjPlay(DjPlayListInfoBase djPlayListInfoBase0, int v) {
                q.g(djPlayListInfoBase0, "data");
                VideoInfoFragment videoInfoFragment0 = this.a;
                VideoInfoFragment.access$playPlaylist(videoInfoFragment0, djPlayListInfoBase0.plylstseq, djPlayListInfoBase0.contsTypeCode, videoInfoFragment0.getMenuId(), djPlayListInfoBase0.statsElements);
                if(VideoInfoFragment.access$getMMelonTiaraProperty$p$s-1421613799(videoInfoFragment0) == null) {
                    return;
                }
                m.F(new P(videoInfoFragment0, v, djPlayListInfoBase0, 1)).track();
            }

            @Override  // com.iloen.melon.player.video.VideoInfoAdapter$InfoClickListener
            public void onInfoComment(result informCmtContsSummRes$result0) {
                String s2;
                q.g(informCmtContsSummRes$result0, "informCmtResult");
                int v = -1;
                String s = StringUtils.getCountString((informCmtContsSummRes$result0.cmtContsSumm == null ? -1 : informCmtContsSummRes$result0.cmtContsSumm.chnlSeq), -1);
                CMTCONTSSUMM informCmtContsSummRes$result$CMTCONTSSUMM0 = informCmtContsSummRes$result0.cmtContsSumm;
                String s1 = "";
                if(informCmtContsSummRes$result$CMTCONTSSUMM0 == null) {
                    s2 = "";
                }
                else {
                    s2 = informCmtContsSummRes$result$CMTCONTSSUMM0.contsRefValue;
                    if(s2 == null) {
                        s2 = "";
                    }
                }
                Param cmtListFragment$Param0 = new Param();
                Integer integer0 = v.t0(s);
                if(integer0 != null) {
                    v = (int)integer0;
                }
                cmtListFragment$Param0.chnlSeq = v;
                cmtListFragment$Param0.contsRefValue = s2;
                cmtListFragment$Param0.theme = c.c;
                cmtListFragment$Param0.showTitle = true;
                VideoInfoFragment videoInfoFragment0 = this.a;
                if(videoInfoFragment0.getContext() != null) {
                    s1 = "댓글";
                }
                cmtListFragment$Param0.headerTitle = s1;
                cmtListFragment$Param0.cacheKeyOfTargetPage = videoInfoFragment0.getCacheKey();
                int v1 = cmtListFragment$Param0.chnlSeq;
                String s3 = cmtListFragment$Param0.contsRefValue;
                q.f(s3, "contsRefValue");
                V2.a(s3, null, v1, false, 12).m(videoInfoFragment0.getParentFragment());
                if(VideoInfoFragment.access$getMMelonTiaraProperty$p$s-1421613799(videoInfoFragment0) == null) {
                    return;
                }
                m.F(new B(videoInfoFragment0, 19)).track();
            }

            @Override  // com.iloen.melon.player.video.VideoInfoAdapter$InfoClickListener
            public void onInfoDownload(Playable playable0) {
                if(playable0 != null) {
                    playable0.setDownloadOrigin(1);
                }
                VideoInfoFragment videoInfoFragment0 = this.a;
                videoInfoFragment0.downloadMv("1000000550", playable0);
                if(VideoInfoFragment.access$getMMelonTiaraProperty$p$s-1421613799(videoInfoFragment0) == null) {
                    return;
                }
                m.F(new N(videoInfoFragment0, 4)).track();
            }

            @Override  // com.iloen.melon.player.video.VideoInfoAdapter$InfoClickListener
            public void onInfoLike(View view0, String s, boolean z) {
                q.g(view0, "view");
                q.g(s, "contsTypeCode");
                String s1 = this.a.getViewModel().getMvId();
                String s2 = this.a.getMenuId();
                com.iloen.melon.player.video.VideoInfoFragment.listener.1.onInfoLike.1 videoInfoFragment$listener$1$onInfoLike$10 = new OnJobFinishListener() {
                    public final View a;
                    public final VideoInfoFragment b;

                    {
                        View view0 = this.a;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        this.a = view0;
                        this.b = videoInfoFragment0;
                    }

                    @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
                    public void onJobComplete(String s, int v, boolean z) {
                        q.g(s, "errorMsg");
                        VideoInfoFragment videoInfoFragment0 = this.b;
                        LogU.debug$default(VideoInfoFragment.access$getLog$p(videoInfoFragment0), "onJobComplete() isLike : " + z + ", sumCount : " + v, null, false, 6, null);
                        this.a.setEnabled(true);
                        this.a.setClickable(true);
                        if(videoInfoFragment0.isFragmentValid() && s.length() <= 0) {
                            VideoInfoFragment.access$updateMvItem(videoInfoFragment0, new s(z, v, 2));
                            if(VideoInfoFragment.access$getMMelonTiaraProperty$p$s-1421613799(videoInfoFragment0) != null) {
                                m.F(new Q(videoInfoFragment0, z, 0)).track();
                            }
                        }
                    }

                    @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
                    public void onStartAsyncTask() {
                        this.a.setEnabled(false);
                        this.a.setClickable(false);
                    }
                };
                VideoInfoFragment.access$updateLike(this.a, s1, s, !z, s2, videoInfoFragment$listener$1$onInfoLike$10);
            }

            @Override  // com.iloen.melon.player.video.VideoInfoAdapter$InfoClickListener
            public void onInfoShare(Playable playable0) {
                VideoInfoFragment videoInfoFragment0 = this.a;
                videoInfoFragment0.showSNSListPopup(playable0);
                if(VideoInfoFragment.access$getMMelonTiaraProperty$p$s-1421613799(videoInfoFragment0) == null) {
                    return;
                }
                m.F(new L(videoInfoFragment0, 17)).track();
            }

            @Override  // com.iloen.melon.player.video.VideoInfoAdapter$MagazineClickListener
            public void onMagazineItem(MagazineList vodDetailRes$Response$Magazine$MagazineList0, int v) {
                q.g(vodDetailRes$Response$Magazine$MagazineList0, "data");
                MelonLinkExecutor.open(MelonLinkInfo.b(vodDetailRes$Response$Magazine$MagazineList0.link));
                VideoInfoFragment videoInfoFragment0 = this.a;
                if(VideoInfoFragment.access$getMMelonTiaraProperty$p$s-1421613799(videoInfoFragment0) == null) {
                    return;
                }
                m.F(new F0(videoInfoFragment0, v, vodDetailRes$Response$Magazine$MagazineList0, 13)).track();
            }

            @Override  // com.iloen.melon.player.video.VideoInfoAdapter$MoreClickListener
            public void onMore(Object object0, int v) {
                q.g(object0, "any");
                VideoInfoFragment videoInfoFragment0 = this.a;
                j0 j00 = videoInfoFragment0.mAdapter;
                q.e(j00, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoAdapter");
                int v1 = ((WrappedData)object0).getMoreType();
                LogU.debug$default(videoInfoFragment0.a, "onMore() moreType : " + v1 + ", position : " + v, null, false, 6, null);
                H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                h0.a = "";
                int v2 = 0;
                if(v1 == 1) {
                    if(videoInfoFragment0.getContext() != null) {
                        Object object9 = ((WrappedData)object0).getData();
                        q.e(object9, "null cannot be cast to non-null type java.util.ArrayList<com.iloen.melon.net.v6x.response.VodDetailRes.Response.RecmMv.Mv>");
                        List list2 = p.f0(4, ((ArrayList)object9));
                        int v5 = list2.size();
                        e e0 = a.C(a.K(0, v5), 2);
                        int v6 = e0.a;
                        int v7 = e0.b;
                        int v8 = e0.c;
                        if(v8 > 0 && v6 <= v7 || v8 < 0 && v7 <= v6) {
                            while(true) {
                                ArrayList arrayList4 = new ArrayList();
                                Object object10 = list2.get(v6);
                                Mv vodDetailRes$Response$RecmMv$Mv0 = v6 + 1 >= v5 ? null : ((Mv)list2.get(v6 + 1));
                                ((Mv)object10).index = v6 + 5;
                                arrayList4.add(((Mv)object10));
                                if(vodDetailRes$Response$RecmMv$Mv0 != null) {
                                    vodDetailRes$Response$RecmMv$Mv0.index = v6 + 6;
                                    arrayList4.add(vodDetailRes$Response$RecmMv$Mv0);
                                }
                                WrappedData videoInfoViewModel$WrappedData2 = new WrappedData(3, arrayList4);
                                videoInfoViewModel$WrappedData2.setFirstItem(false);
                                ((VideoInfoAdapter)j00).add(v, videoInfoViewModel$WrappedData2);
                                ++v;
                                if(v6 == v7) {
                                    break;
                                }
                                v6 += v8;
                            }
                        }
                        List list3 = ((VideoInfoAdapter)j00).getList();
                        q.f(list3, "getList(...)");
                        ArrayList arrayList5 = new ArrayList();
                        for(Object object11: list3) {
                            q.e(object11, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoViewModel.WrappedData");
                            if(((WrappedData)object11).getViewType() == 6 && ((WrappedData)object11).getMoreType() == 1) {
                                arrayList5.add(object11);
                            }
                        }
                        for(int v9 = arrayList5.size() - 1; v9 >= 0; --v9) {
                            Object object12 = arrayList5.get(v9);
                            q.e(object12, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoViewModel.WrappedData");
                            ((VideoInfoAdapter)j00).remove(((WrappedData)object12));
                        }
                    }
                    String s2 = videoInfoFragment0.getString(0x7F130E0C);  // string:tiara_common_layer1_recommend_video_slot "추천영상 슬롯"
                    q.f(s2, "getString(...)");
                    h0.a = s2;
                }
                else {
                    switch(v1) {
                        case 2: {
                            Object object1 = ((WrappedData)object0).getData();
                            q.e(object1, "null cannot be cast to non-null type java.util.ArrayList<com.melon.net.res.common.ArtistsInfoBase>");
                            Iterable iterable0 = p.f0(3, ((ArrayList)object1));
                            ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
                            for(Object object2: iterable0) {
                                if(v2 >= 0) {
                                    WrappedData videoInfoViewModel$WrappedData0 = new WrappedData(5, ((ArtistsInfoBase)object2));
                                    videoInfoViewModel$WrappedData0.setIndex(v2 + 4);
                                    arrayList0.add(videoInfoViewModel$WrappedData0);
                                    ++v2;
                                    continue;
                                }
                                k.O();
                                throw null;
                            }
                            ((VideoInfoAdapter)j00).addAll(v, arrayList0);
                            List list0 = ((VideoInfoAdapter)j00).getList();
                            q.f(list0, "getList(...)");
                            ArrayList arrayList1 = new ArrayList();
                            for(Object object3: list0) {
                                q.e(object3, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoViewModel.WrappedData");
                                if(((WrappedData)object3).getViewType() == 6 && ((WrappedData)object3).getMoreType() == 2) {
                                    arrayList1.add(object3);
                                }
                            }
                            for(int v3 = arrayList1.size() - 1; v3 >= 0; --v3) {
                                Object object4 = arrayList1.get(v3);
                                q.e(object4, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoViewModel.WrappedData");
                                ((VideoInfoAdapter)j00).remove(((WrappedData)object4));
                            }
                            String s = videoInfoFragment0.getString(0x7F130E0D);  // string:tiara_common_layer1_relative_artist "연관아티스트"
                            q.f(s, "getString(...)");
                            h0.a = s;
                            break;
                        }
                        case 3: {
                            Object object5 = ((WrappedData)object0).getData();
                            q.e(object5, "null cannot be cast to non-null type java.util.ArrayList<com.melon.net.res.common.SongInfoBase>");
                            Iterable iterable1 = p.f0(3, ((ArrayList)object5));
                            ArrayList arrayList2 = new ArrayList(je.q.Q(10, iterable1));
                            for(Object object6: iterable1) {
                                if(v2 >= 0) {
                                    WrappedData videoInfoViewModel$WrappedData1 = new WrappedData(7, ((SongInfoBase)object6));
                                    videoInfoViewModel$WrappedData1.setIndex(v2 + 4);
                                    arrayList2.add(videoInfoViewModel$WrappedData1);
                                    ++v2;
                                    continue;
                                }
                                k.O();
                                throw null;
                            }
                            ((VideoInfoAdapter)j00).addAll(v, arrayList2);
                            List list1 = ((VideoInfoAdapter)j00).getList();
                            q.f(list1, "getList(...)");
                            ArrayList arrayList3 = new ArrayList();
                            for(Object object7: list1) {
                                q.e(object7, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoViewModel.WrappedData");
                                if(((WrappedData)object7).getViewType() == 6 && ((WrappedData)object7).getMoreType() == 3) {
                                    arrayList3.add(object7);
                                }
                            }
                            for(int v4 = arrayList3.size() - 1; v4 >= 0; --v4) {
                                Object object8 = arrayList3.get(v4);
                                q.e(object8, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoViewModel.WrappedData");
                                ((VideoInfoAdapter)j00).remove(((WrappedData)object8));
                            }
                            String s1 = videoInfoFragment0.getString(0x7F130E0E);  // string:tiara_common_layer1_relative_song "연관곡"
                            q.f(s1, "getString(...)");
                            h0.a = s1;
                        }
                    }
                }
                if(videoInfoFragment0.mMelonTiaraProperty == null) {
                    return;
                }
                m.F(new G(videoInfoFragment0, h0)).track();
            }

            @Override  // com.iloen.melon.player.video.VideoInfoAdapter$InfoClickListener
            public void onMoreDesc() {
                VideoInfoFragment videoInfoFragment0 = this.a;
                if(VideoInfoFragment.access$getMMelonTiaraProperty$p$s-1421613799(videoInfoFragment0) == null) {
                    return;
                }
                m.F(new B(videoInfoFragment0, 18)).track();
            }

            @Override  // com.iloen.melon.player.video.VideoInfoAdapter$CommonClickListener
            public void onPlayMv(String s, String s1, int v) {
                q.g(s, "mvId");
                q.g(s1, "mvName");
                VideoInfoFragment videoInfoFragment0 = this.a;
                videoInfoFragment0.playMvById(s, videoInfoFragment0.getMenuId());
                if(VideoInfoFragment.access$getMMelonTiaraProperty$p$s-1421613799(videoInfoFragment0) == null) {
                    return;
                }
                m.F(new Oc.m(videoInfoFragment0, v, s, s1, 7)).track();
            }

            @Override  // com.iloen.melon.player.video.VideoInfoAdapter$CommonClickListener
            public void onProgram(String s, String s1) {
                q.g(s, "progSeq");
                q.g(s1, "progName");
                Navigator.INSTANCE.openMelonTvProgram(s);
                VideoInfoFragment videoInfoFragment0 = this.a;
                if(VideoInfoFragment.access$getMMelonTiaraProperty$p$s-1421613799(videoInfoFragment0) == null) {
                    return;
                }
                m.F(new E(videoInfoFragment0, s, s1, 1)).track();
            }

            @Override  // com.iloen.melon.player.video.VideoInfoAdapter$SongClickListener
            public void onSongAlbum(String s, int v) {
                q.g(s, "albumId");
                Navigator.openAlbumInfo(s);
                VideoInfoFragment videoInfoFragment0 = this.a;
                if(VideoInfoFragment.access$getMMelonTiaraProperty$p$s-1421613799(videoInfoFragment0) == null) {
                    return;
                }
                m.F(new F(videoInfoFragment0, v, s)).track();
            }

            @Override  // com.iloen.melon.player.video.VideoInfoAdapter$SongClickListener
            public void onSongInfo(SongInfoBase songInfoBase0, int v) {
                q.g(songInfoBase0, "song");
                VideoInfoFragment videoInfoFragment0 = this.a;
                videoInfoFragment0.showContextPopupSong(Playable.from(songInfoBase0, videoInfoFragment0.getMenuId(), null));
                if(videoInfoFragment0.mMelonTiaraProperty == null) {
                    return;
                }
                m.F(new com.iloen.melon.player.video.H(videoInfoFragment0, v, songInfoBase0, 0)).track();
            }

            @Override  // com.iloen.melon.player.video.VideoInfoAdapter$SongClickListener
            public void onSongPlay(SongInfoBase songInfoBase0, int v) {
                q.g(songInfoBase0, "song");
                VideoInfoFragment videoInfoFragment0 = this.a;
                videoInfoFragment0.playSong(Playable.from(songInfoBase0, videoInfoFragment0.getMenuId(), null), true, true);
                if(videoInfoFragment0.mMelonTiaraProperty == null) {
                    return;
                }
                m.F(new com.iloen.melon.player.video.H(videoInfoFragment0, v, songInfoBase0, 1)).track();
            }
        };
    }

    public static final z access$getPlayerUseCase(VideoInfoFragment videoInfoFragment0) {
        return (z)videoInfoFragment0.d.getValue();
    }

    public static final RecyclerView access$getRecyclerView(VideoInfoFragment videoInfoFragment0) {
        return videoInfoFragment0.getRecyclerView();
    }

    public static final VideoViewModel access$getVideoViewModel(VideoInfoFragment videoInfoFragment0) {
        return (VideoViewModel)videoInfoFragment0.c.getValue();
    }

    public static final void access$onUpdatedMetadata(VideoInfoFragment videoInfoFragment0, int v) {
        if(v != 3) {
            videoInfoFragment0.getClass();
            return;
        }
        RecyclerView recyclerView0 = videoInfoFragment0.getRecyclerView();
        if(recyclerView0 != null) {
            recyclerView0.stopScroll();
        }
        j0 j00 = videoInfoFragment0.getAdapter();
        if(j00 != null) {
            j00.notifyDataSetChanged();
        }
    }

    public static final void access$playPlaylist(VideoInfoFragment videoInfoFragment0, String s, String s1, String s2, StatsElementsBase statsElementsBase0) {
        videoInfoFragment0.playPlaylist(s, s1, s2, statsElementsBase0);
    }

    public static final void access$showRecommendContentsPopup(VideoInfoFragment videoInfoFragment0, String s, String s1) {
        videoInfoFragment0.showRecommendContentsPopup(s, s1);
    }

    public static final void access$updateFan(VideoInfoFragment videoInfoFragment0, String s, String s1, boolean z, String s2, OnJobFinishListener likeUpdateAsyncTask$OnJobFinishListener0) {
        videoInfoFragment0.updateFan(s, s1, z, s2, likeUpdateAsyncTask$OnJobFinishListener0);
    }

    public static final void access$updateLike(VideoInfoFragment videoInfoFragment0, String s, String s1, boolean z, String s2, OnJobFinishListener likeUpdateAsyncTask$OnJobFinishListener0) {
        videoInfoFragment0.updateLike(s, s1, z, s2, likeUpdateAsyncTask$OnJobFinishListener0);
    }

    public static final void access$updateLocalInfo(VideoInfoFragment videoInfoFragment0, Playable playable0) {
        List list0 = (List)videoInfoFragment0.getViewModel().getList().getValue();
        if(list0 != null) {
            list0.clear();
        }
        j0 j00 = videoInfoFragment0.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoAdapter");
        ((VideoInfoAdapter)j00).clear();
        ((VideoInfoAdapter)j00).add(new WrappedData(0, (playable0 == null ? null : "")));
        ((VideoInfoAdapter)j00).notifyDataSetChanged();
    }

    public static final void access$updateMvItem(VideoInfoFragment videoInfoFragment0, we.k k0) {
        videoInfoFragment0.k0(k0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        FragmentActivity fragmentActivity0 = this.requireActivity();
        q.f(fragmentActivity0, "requireActivity(...)");
        VideoCommentActionImpl videoCommentActionImpl0 = new VideoCommentActionImpl(fragmentActivity0, this);
        return new VideoInfoAdapter(context0, null, this.f, videoCommentActionImpl0);
    }

    public static void d0(VideoInfoFragment videoInfoFragment0) {
        androidx.fragment.app.I i0 = videoInfoFragment0.getParentFragment();
        if(i0 instanceof a9.a) {
            ((a9.a)i0).addFragment(VideoPlaylistFragment.Companion.newInstance());
        }
        if(videoInfoFragment0.mMelonTiaraProperty == null) {
            return;
        }
        m.F(new B(videoInfoFragment0, 0)).track();
    }

    public static void e0(VideoInfoFragment videoInfoFragment0, i i0) {
        String s3;
        String s2;
        String s;
        Object object0 = i0.c;
        switch(WhenMappings.$EnumSwitchMapping$0[i0.a.ordinal()]) {
            case 1: {
                J3 j32 = videoInfoFragment0.e;
                q.d(j32);
                ViewUtils.showWhen(j32.e, true);
                videoInfoFragment0.hideEmptyAndErrorView();
                return;
            }
            case 2: {
                J3 j31 = videoInfoFragment0.e;
                q.d(j31);
                ViewUtils.showWhen(j31.e, false);
                if(((VodDetailRes)object0) == null) {
                    s = "9999999999";
                }
                else {
                    s = ((VodDetailRes)object0).getMenuId();
                    if(s == null) {
                        s = "9999999999";
                    }
                }
                videoInfoFragment0.mMenuId = s;
                String s1 = null;
                if(((VodDetailRes)object0) == null) {
                    s2 = null;
                }
                else {
                    Response vodDetailRes$Response0 = ((VodDetailRes)object0).response;
                    s2 = vodDetailRes$Response0 == null ? null : vodDetailRes$Response0.section;
                }
                if(((VodDetailRes)object0) == null) {
                    s3 = null;
                }
                else {
                    Response vodDetailRes$Response1 = ((VodDetailRes)object0).response;
                    s3 = vodDetailRes$Response1 == null ? null : vodDetailRes$Response1.page;
                }
                Builder meta$Builder0 = new Builder().id((videoInfoFragment0.getViewModel().getCurrentPlayable() == null ? null : ""));
                if(videoInfoFragment0.getViewModel().getCurrentPlayable() != null) {
                    s1 = "";
                }
                videoInfoFragment0.mMelonTiaraProperty = new p8.s(s2, s3, s, meta$Builder0.name(s1).type(videoInfoFragment0.getString(0x7F130EFE)).build());  // string:tiara_meta_type_mv "영상"
                videoInfoFragment0.onFetchSuccessUI(i0);
                return;
            }
            case 3: 
            case 4: {
                J3 j30 = videoInfoFragment0.e;
                q.d(j30);
                ViewUtils.showWhen(j30.e, false);
                j0 j00 = videoInfoFragment0.mAdapter;
                q.e(j00, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoAdapter");
                ((VideoInfoAdapter)j00).clear();
                ((VideoInfoAdapter)j00).notifyDataSetChanged();
                videoInfoFragment0.onFetchErrorUI(i0);
                return;
            }
            case 5: {
                return;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    public static String f0(VideoInfoFragment videoInfoFragment0) {
        return videoInfoFragment0.mMelonTiaraProperty.b;
    }

    public static String g0(VideoInfoFragment videoInfoFragment0) {
        return videoInfoFragment0.mMelonTiaraProperty.a;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return this.getViewModel().getCacheKey();
    }

    @NotNull
    public final VideoInfoViewModel getViewModel() {
        return (VideoInfoViewModel)this.b.getValue();
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    @NotNull
    public v8.a getViewModel() {
        return this.getViewModel();
    }

    public static void h0(VideoInfoFragment videoInfoFragment0, WrappedData videoInfoViewModel$WrappedData0) {
        Collection collection0 = (Collection)videoInfoFragment0.getViewModel().getList().getValue();
        if(collection0 != null && !collection0.isEmpty()) {
            j0 j00 = videoInfoFragment0.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoAdapter");
            Object object0 = videoInfoViewModel$WrappedData0.getData();
            q.e(object0, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoViewModel.CommentData");
            ((VideoInfoAdapter)j00).setLoadPgnRes(((CommentData)object0).getLoadPgnRes());
            ((VideoInfoAdapter)j00).setListCmtRes(((CommentData)object0).getListCmtRes());
            CmtResViewModel cmtResViewModel0 = ((VideoInfoAdapter)j00).getCmtResViewModel(((CommentData)object0).getLoadPgnRes(), ((CommentData)object0).getListCmtRes());
            if(cmtResViewModel0.result.cmtlist.isEmpty()) {
                AdapterInViewHolder.Row adapterInViewHolder$Row1 = AdapterInViewHolder.Row.create(12, ie.H.a);
                int v1 = ((VideoInfoAdapter)j00).getCount();
                WrappedData videoInfoViewModel$WrappedData2 = new WrappedData(12, videoInfoViewModel$WrappedData0.getData());
                videoInfoViewModel$WrappedData2.setCmtEmptyRes(adapterInViewHolder$Row1);
                ((VideoInfoAdapter)j00).add(v1 - 1, videoInfoViewModel$WrappedData2);
            }
            else {
                AdapterInViewHolder.Row adapterInViewHolder$Row0 = AdapterInViewHolder.Row.create(11, cmtResViewModel0);
                int v = ((VideoInfoAdapter)j00).getCount();
                WrappedData videoInfoViewModel$WrappedData1 = new WrappedData(11, videoInfoViewModel$WrappedData0.getData());
                videoInfoViewModel$WrappedData1.setCmtRes(adapterInViewHolder$Row0);
                ((VideoInfoAdapter)j00).add(v - 1, videoInfoViewModel$WrappedData1);
            }
            ((VideoInfoAdapter)j00).notifyItemChanged(((VideoInfoAdapter)j00).getCount() - 1);
        }
    }

    public static String i0(VideoInfoFragment videoInfoFragment0) {
        String s = videoInfoFragment0.mMelonTiaraProperty.c;
        return s == null ? "" : s;
    }

    public static final void j0(VideoInfoFragment videoInfoFragment0, List list0) {
        if(list0 != null && !list0.isEmpty()) {
            j0 j00 = videoInfoFragment0.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoAdapter");
            ((VideoInfoAdapter)j00).clear();
            ((VideoInfoAdapter)j00).addAll(list0);
            ((VideoInfoAdapter)j00).notifyItemRangeChanged(0, list0.size());
            w0 w00 = videoInfoFragment0.getRecyclerView().getLayoutManager();
            if(w00 != null) {
                w00.scrollToPosition(0);
            }
            videoInfoFragment0.performFetchCompleteOnlyViews();
            D d0 = videoInfoFragment0.getViewLifecycleOwner();
            q.f(d0, "getViewLifecycleOwner(...)");
            f0.f(d0).b(new com.iloen.melon.player.video.VideoInfoFragment.onCreateView.3.2(videoInfoFragment0, null));
        }
    }

    public final void k0(we.k k0) {
        j0 j00 = this.getRecyclerView().getAdapter();
        if(j00 instanceof VideoInfoAdapter) {
            Ce.f f0 = a.K(0, ((VideoInfoAdapter)j00).getCount()).b();
            while(f0.c) {
                int v = f0.nextInt();
                if(((VideoInfoAdapter)j00).getItemViewType(v) == 1) {
                    Object object0 = ((VideoInfoAdapter)j00).getList().get(v);
                    q.e(object0, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoViewModel.WrappedData");
                    k0.invoke(((WrappedData)object0));
                    ((VideoInfoAdapter)j00).notifyItemChanged(v);
                }
            }
        }
    }

    public final void l0(String s) {
        LogU.info$default(this.a, "updateNextRecommendMv() reason : " + s, null, false, 6, null);
        w w0 = ((d3)this.playlistManager).q(PlaylistId.VOD);
        if(w0 != null) {
            ArrayList arrayList0 = b.B(w0.getState());
            if(arrayList0.size() <= 1) {
                J3 j30 = this.e;
                q.d(j30);
                j30.d.setVisibility(8);
                return;
            }
            J3 j31 = this.e;
            q.d(j31);
            j31.d.setVisibility(0);
            if(((Playable)p.n0(w0.p(), arrayList0)) != null) {
                J3 j32 = this.e;
                q.d(j32);
                j32.g.setText("");
                j32.g.setSelected(true);
            }
        }
    }

    @NotNull
    public static final VideoInfoFragment newInstance() {
        return VideoInfoFragment.Companion.newInstance();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @SuppressLint({"NotifyDataSetChanged"})
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        this.getAdapter().notifyDataSetChanged();
        if(this.getRetainedDialog() != null && this.getRetainedDialog() instanceof ContextListPopup) {
            Dialog dialog0 = this.getRetainedDialog();
            q.e(dialog0, "null cannot be cast to non-null type com.iloen.melon.popup.ContextListPopup");
            if(q.b(((ContextListPopup)dialog0).getTitle(), this.getString(0x7F1300DB)) && this.getRetainedDialog().isShowing()) {  // string:alert_dlg_title_snslist "공유하기"
                this.getRetainedDialog().dismiss();
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        J3 j30 = this.e;
        q.d(j30);
        LinearLayoutManager linearLayoutManager0 = new LinearLayoutManager(j30.f.getContext());
        j30.f.setLayoutManager(linearLayoutManager0);
        j30.f.setAdapter(this.mAdapter);
        j30.f.setHasFixedSize(false);
        com.iloen.melon.player.video.VideoInfoFragment.onCreateRecyclerView.1.1 videoInfoFragment$onCreateRecyclerView$1$10 = new r0() {
            public final RecyclerViewWithEmptyView a;

            {
                this.a = recyclerViewWithEmptyView0;
            }

            @Override  // androidx.recyclerview.widget.r0
            public void getItemOffsets(Rect rect0, View view0, RecyclerView recyclerView0, K0 k00) {
                int v1;
                q.g(rect0, "outRect");
                q.g(view0, "view");
                q.g(recyclerView0, "parent");
                q.g(k00, "state");
                int v = recyclerView0.getChildAdapterPosition(view0);
                j0 j00 = recyclerView0.getAdapter();
                q.e(j00, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoAdapter");
                Context context0 = this.a.getContext();
                if(context0 != null) {
                    switch(((VideoInfoAdapter)j00).getItemViewType(v)) {
                        case 8: {
                            v1 = ScreenUtils.dipToPixel(context0, 4.0f);
                            break;
                        }
                        case 6: 
                        case 7: 
                        case 11: 
                        case 12: {
                            v1 = 0;
                            break;
                        }
                        default: {
                            v1 = ScreenUtils.dipToPixel(context0, 20.0f);
                        }
                    }
                    rect0.left = v1;
                    rect0.right = v1;
                }
            }
        };
        j30.f.addItemDecoration(videoInfoFragment$onCreateRecyclerView$1$10);
        return j30.f;
    }

    @Override  // androidx.fragment.app.I
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        f0.f(d0).b(new n(null) {
            public int r;
            public final VideoInfoFragment w;

            {
                this.w = videoInfoFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoInfoFragment.onCreateView.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoInfoFragment.onCreateView.1)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        StateFlow stateFlow0 = VideoInfoFragment.access$getVideoViewModel(this.w).getCurrentVideoPlayable();
                        com.iloen.melon.player.video.VideoInfoFragment.onCreateView.1.1 videoInfoFragment$onCreateView$1$10 = new n(null) {
                            public Object r;
                            public final VideoInfoFragment w;

                            {
                                this.w = videoInfoFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.player.video.VideoInfoFragment.onCreateView.1.1(this.w, continuation0);
                                continuation1.r = object0;
                                return continuation1;
                            }

                            public final Object invoke(Playable playable0, Continuation continuation0) {
                                return ((com.iloen.melon.player.video.VideoInfoFragment.onCreateView.1.1)this.create(playable0, continuation0)).invokeSuspend(ie.H.a);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((Playable)object0), ((Continuation)object1));
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                Playable playable0 = (Playable)this.r;
                                d5.n.D(object0);
                                VideoInfoFragment videoInfoFragment0 = this.w;
                                LogU.info$default(videoInfoFragment0.a, "onCreateView() mv id : " + (playable0 == null ? null : ""), null, false, 6, null);
                                ie.H h0 = ie.H.a;
                                if(playable0 != null && playable0.isTypeOfMv()) {
                                    if(playable0.isOriginLocal()) {
                                        videoInfoFragment0.getViewModel().setCurrentPlayable(playable0);
                                        VideoInfoFragment.access$updateLocalInfo(videoInfoFragment0, playable0);
                                        return h0;
                                    }
                                    if(!playable0.equals(videoInfoFragment0.getViewModel().getCurrentPlayable())) {
                                        List list0 = (List)videoInfoFragment0.getViewModel().getList().getValue();
                                        if(list0 != null) {
                                            list0.clear();
                                        }
                                        j0 j00 = videoInfoFragment0.mAdapter;
                                        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoAdapter");
                                        ((VideoInfoAdapter)j00).clear();
                                        ((VideoInfoAdapter)j00).notifyDataSetChanged();
                                        LogU.info$default(videoInfoFragment0.a, "onCreateView() playable != viewModel.currentPlayable", null, false, 6, null);
                                        videoInfoFragment0.getViewModel().setCurrentPlayable(playable0);
                                        videoInfoFragment0.getViewModel().clearCache();
                                        videoInfoFragment0.l0("videoViewModel.currentPlayable collect");
                                        return h0;
                                    }
                                    LogU.info$default(videoInfoFragment0.a, "onCreateView() playable == viewModel.currentPlayable", null, false, 6, null);
                                    videoInfoFragment0.getViewModel().request(v9.i.b);
                                }
                                return h0;
                            }
                        };
                        this.r = 1;
                        return FlowKt.collectLatest(stateFlow0, videoInfoFragment$onCreateView$1$10, this) == a0 ? a0 : ie.H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return ie.H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        });
        this.getViewModel().getResponse().observe(this.getViewLifecycleOwner(), new VideoInfoFragment.sam.androidx_lifecycle_Observer.0(new B(this, 6)));
        this.getViewModel().getList().observe(this.getViewLifecycleOwner(), new VideoInfoFragment.sam.androidx_lifecycle_Observer.0(new B(this, 7)));
        this.getViewModel().getCommentList().observe(this.getViewLifecycleOwner(), new VideoInfoFragment.sam.androidx_lifecycle_Observer.0(new B(this, 8)));
        this.getViewModel().getInformCmtContsSumm().observe(this.getViewLifecycleOwner(), new VideoInfoFragment.sam.androidx_lifecycle_Observer.0(new B(this, 9)));
        this.getViewModel().getLike().observe(this.getViewLifecycleOwner(), new VideoInfoFragment.sam.androidx_lifecycle_Observer.0(new B(this, 10)));
        View view0 = this.getLayoutInflater().inflate(0x7F0D08E4, viewGroup0, false);  // layout:video_info_layout
        int v = 0x7F0A0118;  // id:bottom_container
        View view1 = De.I.C(view0, 0x7F0A0118);  // id:bottom_container
        if(((RelativeLayout)view1) != null && ((RelativeLayout)De.I.C(view0, 0x7F0A042C)) != null) {  // id:empty_or_error_layout
            v = 0x7F0A066B;  // id:iv_playlist
            View view2 = De.I.C(view0, 0x7F0A066B);  // id:iv_playlist
            if(((ImageView)view2) != null) {
                v = 0x7F0A08B2;  // id:next_mv_layout
                View view3 = De.I.C(view0, 0x7F0A08B2);  // id:next_mv_layout
                if(((LinearLayoutCompat)view3) != null) {
                    v = 0x7F0A097E;  // id:progress
                    View view4 = De.I.C(view0, 0x7F0A097E);  // id:progress
                    if(((ProgressBar)view4) != null) {
                        v = 0x7F0A09D1;  // id:recycler_view
                        View view5 = De.I.C(view0, 0x7F0A09D1);  // id:recycler_view
                        if(((RecyclerViewWithEmptyView)view5) != null) {
                            v = 0x7F0A0CCB;  // id:tv_next_mv
                            View view6 = De.I.C(view0, 0x7F0A0CCB);  // id:tv_next_mv
                            if(((MelonTextView)view6) != null && ((MelonTextView)De.I.C(view0, 0x7F0A0CCC)) != null) {  // id:tv_next_mv_title
                                this.e = new J3(((ConstraintLayout)view0), ((RelativeLayout)view1), ((ImageView)view2), ((LinearLayoutCompat)view3), ((ProgressBar)view4), ((RecyclerViewWithEmptyView)view5), ((MelonTextView)view6));
                                q.f(((ConstraintLayout)view0), "getRoot(...)");
                                return (ConstraintLayout)view0;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @oe.e(c = "com.iloen.melon.player.video.VideoInfoFragment$onCreateView$3$2", f = "VideoInfoFragment.kt", l = {0x100}, m = "invokeSuspend")
        final class com.iloen.melon.player.video.VideoInfoFragment.onCreateView.3.2 extends oe.i implements n {
            public final VideoInfoFragment B;
            public int r;
            public Object w;

            public com.iloen.melon.player.video.VideoInfoFragment.onCreateView.3.2(VideoInfoFragment videoInfoFragment0, Continuation continuation0) {
                this.B = videoInfoFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.player.video.VideoInfoFragment.onCreateView.3.2(this.B, continuation0);
                continuation1.w = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoInfoFragment.onCreateView.3.2)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        VideoInfoViewModel videoInfoViewModel0 = this.B.getViewModel();
                        String s = this.B.getViewModel().getMvId();
                        this.w = null;
                        this.r = 1;
                        return videoInfoViewModel0.requestLike(s, coroutineScope0, this) == a0 ? a0 : ie.H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return ie.H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }

    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onDestroyView() {
        super.onDestroyView();
        this.e = null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable v9.i i0, @Nullable v9.h h0, @Nullable String s) {
        if(q.b((h0 == null ? null : h0.a), "RETRY_FROM_NETWORK_ERROR")) {
            this.getViewModel().changeDataSet();
        }
        return false;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onReadyToFetchPartially(@NotNull RecyclerView recyclerView0, @NotNull int[] arr_v) {
        q.g(recyclerView0, "recyclerView");
        q.g(arr_v, "positions");
        if(this.isLoginUser()) {
            j0 j00 = recyclerView0.getAdapter();
            if(j00 instanceof VideoInfoAdapter && arr_v.length > 0) {
                ArrayList arrayList0 = new ArrayList();
                StringBuilder stringBuilder0 = new StringBuilder();
                for(int v = 0; v < arr_v.length; ++v) {
                    int v1 = arr_v[v];
                    if(((VideoInfoAdapter)j00).getItemViewType(v1) == 5) {
                        arrayList0.add(v1);
                        try {
                            WrappedData videoInfoViewModel$WrappedData0 = (WrappedData)((VideoInfoAdapter)j00).getItem(v1);
                            if(videoInfoViewModel$WrappedData0 != null) {
                                Object object0 = videoInfoViewModel$WrappedData0.getData();
                                q.e(object0, "null cannot be cast to non-null type com.melon.net.res.common.ArtistsInfoBase");
                                stringBuilder0.append(((ArtistsInfoBase)object0).getArtistId());
                                stringBuilder0.append(",");
                            }
                        }
                        catch(Exception unused_ex) {
                        }
                    }
                }
                int v2 = stringBuilder0.length();
                if(v2 != 0) {
                    stringBuilder0.setLength(v2 - 1);
                    Params userActionsReq$Params0 = new Params();
                    userActionsReq$Params0.fields = "fan";
                    userActionsReq$Params0.contsTypeCode = "N10006";
                    userActionsReq$Params0.contsId = stringBuilder0.toString();
                    RequestBuilder.newInstance(new UserActionsReq(this.getContext(), userActionsReq$Params0)).tag(this.getRequestTag()).listener(new C(this, arrayList0, ((VideoInfoAdapter)j00))).errorListener(new com.iloen.melon.player.video.D(this)).request();
                }
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        J3 j30 = this.e;
        q.d(j30);
        this.mEmptyView = j30.a.findViewById(0x7F0A042C);  // id:empty_or_error_layout
        RecyclerView recyclerView0 = this.getRecyclerView();
        q.e(recyclerView0, "null cannot be cast to non-null type com.iloen.melon.custom.RecyclerViewWithEmptyView");
        ((RecyclerViewWithEmptyView)recyclerView0).setEmptyView(this.mEmptyView);
        Context context0 = this.getContext();
        if(context0 != null) {
            J3 j31 = this.e;
            q.d(j31);
            int v = ColorUtils.getColor(context0, 0x7F06016D);  // color:gray900s
            j31.c.setColorFilter(v);
        }
        J3 j32 = this.e;
        q.d(j32);
        com.iloen.melon.player.video.v v1 = new com.iloen.melon.player.video.v(this, 3);
        j32.b.setOnClickListener(v1);
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(null) {
            public int r;
            public final VideoInfoFragment w;

            {
                this.w = videoInfoFragment0;
                super(2, continuation0);
            }

            public static final Object access$invokeSuspend$onUpdatedMetadata(VideoInfoFragment videoInfoFragment0, int v, Continuation continuation0) {
                VideoInfoFragment.access$onUpdatedMetadata(videoInfoFragment0, v);
                return ie.H.a;
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoInfoFragment.onViewCreated.3(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoInfoFragment.onViewCreated.3)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        Flow flow0 = FlowKt.distinctUntilChanged(new Flow() {
                            @Override  // kotlinx.coroutines.flow.Flow
                            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                                com.iloen.melon.player.video.VideoInfoFragment.onViewCreated.3.invokeSuspend..inlined.map.1.2 videoInfoFragment$onViewCreated$3$invokeSuspend$$inlined$map$1$20 = new FlowCollector() {
                                    @Override  // kotlinx.coroutines.flow.FlowCollector
                                    public final Object emit(Object object0, Continuation continuation0) {
                                        com.iloen.melon.player.video.VideoInfoFragment.onViewCreated.3.invokeSuspend..inlined.map.1.2.1 videoInfoFragment$onViewCreated$3$invokeSuspend$$inlined$map$1$2$10;
                                        if(continuation0 instanceof com.iloen.melon.player.video.VideoInfoFragment.onViewCreated.3.invokeSuspend..inlined.map.1.2.1) {
                                            videoInfoFragment$onViewCreated$3$invokeSuspend$$inlined$map$1$2$10 = (com.iloen.melon.player.video.VideoInfoFragment.onViewCreated.3.invokeSuspend..inlined.map.1.2.1)continuation0;
                                            int v = videoInfoFragment$onViewCreated$3$invokeSuspend$$inlined$map$1$2$10.w;
                                            if((v & 0x80000000) == 0) {
                                                videoInfoFragment$onViewCreated$3$invokeSuspend$$inlined$map$1$2$10 = new oe.c(/*ERROR_MISSING_ARG_1/*) {
                                                    public Object r;
                                                    public int w;

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        this.r = object0;
                                                        this.w |= 0x80000000;
                                                        return continuation0.emit(null, this);
                                                    }
                                                };
                                            }
                                            else {
                                                videoInfoFragment$onViewCreated$3$invokeSuspend$$inlined$map$1$2$10.w = v ^ 0x80000000;
                                            }
                                        }
                                        else {
                                            videoInfoFragment$onViewCreated$3$invokeSuspend$$inlined$map$1$2$10 = new oe.c(/*ERROR_MISSING_ARG_1/*) {
                                                public Object r;
                                                public int w;

                                                @Override  // oe.a
                                                public final Object invokeSuspend(Object object0) {
                                                    this.r = object0;
                                                    this.w |= 0x80000000;
                                                    return continuation0.emit(null, this);
                                                }
                                            };
                                        }
                                        Object object1 = videoInfoFragment$onViewCreated$3$invokeSuspend$$inlined$map$1$2$10.r;
                                        ne.a a0 = ne.a.a;
                                        switch(videoInfoFragment$onViewCreated$3$invokeSuspend$$inlined$map$1$2$10.w) {
                                            case 0: {
                                                d5.n.D(object1);
                                                videoInfoFragment$onViewCreated$3$invokeSuspend$$inlined$map$1$2$10.w = 1;
                                                return this.a.emit(new Integer(((fc.a)object0).a), videoInfoFragment$onViewCreated$3$invokeSuspend$$inlined$map$1$2$10) == a0 ? a0 : ie.H.a;
                                            }
                                            case 1: {
                                                d5.n.D(object1);
                                                return ie.H.a;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                    }
                                };
                                Object object0 = this.a.collect(videoInfoFragment$onViewCreated$3$invokeSuspend$$inlined$map$1$20, continuation0);
                                return object0 == ne.a.a ? object0 : ie.H.a;
                            }
                        });
                        com.iloen.melon.player.video.VideoInfoFragment.onViewCreated.3.2 videoInfoFragment$onViewCreated$3$20 = new n(4, VideoInfoFragment.class, this.w, "onUpdatedMetadata", "onUpdatedMetadata(I)V") {  // 初始化器: Lkotlin/jvm/internal/a;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                            public final Object invoke(int v, Continuation continuation0) {
                                return com.iloen.melon.player.video.VideoInfoFragment.onViewCreated.3.access$invokeSuspend$onUpdatedMetadata(((VideoInfoFragment)this.receiver), v, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((Number)object0).intValue(), ((Continuation)object1));
                            }
                        };
                        this.r = 1;
                        return FlowKt.collectLatest(flow0, videoInfoFragment$onViewCreated$3$20, this) == a0 ? a0 : ie.H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return ie.H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 3, null);
        this.l0("onViewCreated");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean shouldIgnoreSetUIOnForegroundEvent() {
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }
}

