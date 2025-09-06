package com.iloen.melon.player.video;

import Ad.n;
import Cb.k;
import De.I;
import J8.A3;
import J8.B3;
import J8.C3;
import J8.D3;
import J8.E3;
import J8.F3;
import J8.G3;
import J8.H3;
import J8.I3;
import J8.N;
import J8.e3;
import J8.f3;
import J8.x;
import J8.y3;
import J8.z3;
import Tf.o;
import a.a;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.O0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.adapters.common.q;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.CheckableImageView;
import com.iloen.melon.custom.CheckableTextView;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.RecommenderView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.artistchannel.viewholder.c;
import com.iloen.melon.fragments.comments.CmtListFragment.Param;
import com.iloen.melon.fragments.comments.VideoCommentActionImpl;
import com.iloen.melon.fragments.detail.viewholder.DetailCommentItemHolder;
import com.iloen.melon.fragments.detail.viewholder.EmptyCommentHolder;
import com.iloen.melon.net.v3x.comments.CmtResViewModel;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummRes.result.CMTCONTSSUMM;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummRes.result;
import com.iloen.melon.net.v3x.comments.ListCmtRes;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v6x.response.PromotionContentsBannerRes.RESPONSE.Banner;
import com.iloen.melon.net.v6x.response.VodDetailRes.Response.Concert.Ticket;
import com.iloen.melon.net.v6x.response.VodDetailRes.Response.Magazine.MagazineList;
import com.iloen.melon.net.v6x.response.VodDetailRes.Response.RecmMv.Mv;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.DjPlaylistNewHolder;
import com.iloen.melon.viewholders.SongHolder;
import com.melon.net.res.common.ArtistsInfoBase;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;

@Metadata(d1 = {"\u0000\u00B4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b2\b\u0007\u0018\u0000 \u008D\u00012\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:.\u008D\u0001\u008E\u0001\u008F\u0001\u0090\u0001\u0091\u0001\u0092\u0001\u0093\u0001\u0094\u0001\u0095\u0001\u0096\u0001\u0097\u0001\u0098\u0001\u0099\u0001\u009A\u0001\u009B\u0001\u009C\u0001\u009D\u0001\u009E\u0001\u009F\u0001\u00A0\u0001\u00A1\u0001\u00A2\u0001\u00A3\u0001B1\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007\u0012\b\u0010\n\u001A\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001A\u00020\u000B\u00A2\u0006\u0004\b\r\u0010\u000EJ!\u0010\u0014\u001A\u00020\u00132\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0017\u001A\u00020\u0016H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u001F\u0010\u001C\u001A\u00020\u00032\u0006\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u001B\u001A\u00020\u0016H\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001DJ)\u0010\"\u001A\u00020!2\b\u0010\u001E\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u001F\u001A\u00020\u00162\u0006\u0010 \u001A\u00020\u0016H\u0016\u00A2\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001A\u00020\u00162\u0006\u0010 \u001A\u00020\u0016H\u0016\u00A2\u0006\u0004\b$\u0010%J\u001A\u0010(\u001A\u00020!2\b\u0010\'\u001A\u0004\u0018\u00010&H\u0096\u0001\u00A2\u0006\u0004\b(\u0010)J\u001A\u0010+\u001A\u00020!2\b\u0010*\u001A\u0004\u0018\u00010&H\u0096\u0001\u00A2\u0006\u0004\b+\u0010)J$\u0010.\u001A\u00020!2\b\u0010,\u001A\u0004\u0018\u00010&2\b\u0010-\u001A\u0004\u0018\u00010&H\u0096\u0001\u00A2\u0006\u0004\b.\u0010/J\u001A\u00101\u001A\u00020!2\b\u00100\u001A\u0004\u0018\u00010&H\u0096\u0001\u00A2\u0006\u0004\b1\u0010)J\u0018\u00102\u001A\u00020!2\u0006\u0010*\u001A\u00020&H\u0096\u0001\u00A2\u0006\u0004\b2\u0010)J\u0018\u00105\u001A\u00020!2\u0006\u00104\u001A\u000203H\u0096\u0001\u00A2\u0006\u0004\b5\u00106J\u0010\u00107\u001A\u00020!H\u0096\u0001\u00A2\u0006\u0004\b7\u00108J\u0010\u00109\u001A\u000203H\u0096\u0001\u00A2\u0006\u0004\b9\u0010:J\u0010\u0010;\u001A\u00020!H\u0096\u0001\u00A2\u0006\u0004\b;\u00108J \u0010>\u001A\u00020!2\u0006\u0010<\u001A\u00020&2\u0006\u0010=\u001A\u000203H\u0096\u0001\u00A2\u0006\u0004\b>\u0010?J\u0010\u0010@\u001A\u00020!H\u0096\u0001\u00A2\u0006\u0004\b@\u00108J\u0010\u0010A\u001A\u000203H\u0096\u0001\u00A2\u0006\u0004\bA\u0010:J\u0010\u0010B\u001A\u00020!H\u0096\u0001\u00A2\u0006\u0004\bB\u00108J\u0010\u0010C\u001A\u00020!H\u0096\u0001\u00A2\u0006\u0004\bC\u00108J.\u0010H\u001A\u00020!2\b\u0010D\u001A\u0004\u0018\u00010&2\b\u0010E\u001A\u0004\u0018\u00010&2\b\u0010G\u001A\u0004\u0018\u00010FH\u0096\u0001\u00A2\u0006\u0004\bH\u0010IJ\u0018\u0010J\u001A\u00020!2\u0006\u0010 \u001A\u00020\u0016H\u0096\u0001\u00A2\u0006\u0004\bJ\u0010KJ\u0018\u0010L\u001A\u00020!2\u0006\u0010\'\u001A\u00020&H\u0096\u0001\u00A2\u0006\u0004\bL\u0010)J\u001A\u0010M\u001A\u00020!2\b\u00100\u001A\u0004\u0018\u00010&H\u0096\u0001\u00A2\u0006\u0004\bM\u0010)J\u001A\u0010P\u001A\u00020!2\b\u0010O\u001A\u0004\u0018\u00010NH\u0096\u0001\u00A2\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001A\u00020!H\u0096\u0001\u00A2\u0006\u0004\bR\u00108J \u0010W\u001A\u00020!2\u0006\u0010T\u001A\u00020S2\u0006\u0010V\u001A\u00020UH\u0096\u0001\u00A2\u0006\u0004\bW\u0010XJ\u0012\u0010Z\u001A\u0004\u0018\u00010YH\u0096\u0001\u00A2\u0006\u0004\bZ\u0010[J\u0018\u0010^\u001A\u00020!2\u0006\u0010]\u001A\u00020\\H\u0096\u0001\u00A2\u0006\u0004\b^\u0010_J\u0010\u0010`\u001A\u00020!H\u0096\u0001\u00A2\u0006\u0004\b`\u00108J0\u0010e\u001A\u00020!2\u0016\u0010c\u001A\u0012\u0012\u0004\u0012\u00020N0aj\b\u0012\u0004\u0012\u00020N`b2\u0006\u0010d\u001A\u000203H\u0096\u0001\u00A2\u0006\u0004\be\u0010fJ0\u0010i\u001A\u00020!2\u0006\u0010D\u001A\u00020&2\u0006\u0010-\u001A\u00020&2\u0006\u0010g\u001A\u0002032\u0006\u0010h\u001A\u00020\u0016H\u0096\u0001\u00A2\u0006\u0004\bi\u0010jJ\u0010\u0010k\u001A\u00020!H\u0096\u0001\u00A2\u0006\u0004\bk\u00108J\u0018\u0010k\u001A\u00020!2\u0006\u0010m\u001A\u00020lH\u0096\u0001\u00A2\u0006\u0004\bk\u0010nJ8\u0010t\u001A\u00020!2\u0006\u0010o\u001A\u00020\u00162\u0006\u0010p\u001A\u00020\u00162\u0006\u0010q\u001A\u0002032\u0006\u0010]\u001A\u00020U2\u0006\u0010s\u001A\u00020rH\u0096\u0001\u00A2\u0006\u0004\bt\u0010uJ \u0010v\u001A\u00020!2\u0006\u0010o\u001A\u00020\u00162\u0006\u0010p\u001A\u00020\u0016H\u0096\u0001\u00A2\u0006\u0004\bv\u0010wJ\u0010\u0010x\u001A\u00020!H\u0096\u0001\u00A2\u0006\u0004\bx\u00108J \u0010y\u001A\u00020!2\u0006\u0010o\u001A\u00020\u00162\u0006\u0010p\u001A\u00020\u0016H\u0096\u0001\u00A2\u0006\u0004\by\u0010wJ \u0010z\u001A\u00020!2\u0006\u0010o\u001A\u00020\u00162\u0006\u0010p\u001A\u00020\u0016H\u0096\u0001\u00A2\u0006\u0004\bz\u0010wJ \u0010{\u001A\u00020!2\u0006\u0010o\u001A\u00020\u00162\u0006\u0010p\u001A\u00020\u0016H\u0096\u0001\u00A2\u0006\u0004\b{\u0010wJ \u0010|\u001A\u00020!2\u0006\u0010o\u001A\u00020\u00162\u0006\u0010p\u001A\u00020\u0016H\u0096\u0001\u00A2\u0006\u0004\b|\u0010wJ1\u0010\u007F\u001A\u00020!2\u0006\u0010o\u001A\u00020\u00162\u0006\u0010p\u001A\u00020\u00162\u0006\u0010}\u001A\u0002032\u0006\u0010~\u001A\u000203H\u0096\u0001\u00A2\u0006\u0005\b\u007F\u0010\u0080\u0001R*\u0010\u0010\u001A\u0004\u0018\u00010\u000F8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001A\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R*\u0010\u0012\u001A\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0018\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001A\u0006\b\u0089\u0001\u0010\u008A\u0001\"\u0006\b\u008B\u0001\u0010\u008C\u0001\u00A8\u0006\u00A4\u0001"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoAdapter;", "Lcom/iloen/melon/adapters/common/q;", "Lcom/iloen/melon/player/video/VideoInfoViewModel$WrappedData;", "Landroidx/recyclerview/widget/O0;", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "Landroid/content/Context;", "ctx", "", "list", "Lcom/iloen/melon/player/video/VideoInfoFragment$VideoInfoClickListener;", "listener", "Lcom/iloen/melon/fragments/comments/VideoCommentActionImpl;", "videoCommentActionImpl", "<init>", "(Landroid/content/Context;Ljava/util/List;Lcom/iloen/melon/player/video/VideoInfoFragment$VideoInfoClickListener;Lcom/iloen/melon/fragments/comments/VideoCommentActionImpl;)V", "Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;", "loadPgnRes", "Lcom/iloen/melon/net/v3x/comments/ListCmtRes;", "listCmtRes", "Lcom/iloen/melon/net/v3x/comments/CmtResViewModel;", "getCmtResViewModel", "(Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;Lcom/iloen/melon/net/v3x/comments/ListCmtRes;)Lcom/iloen/melon/net/v3x/comments/CmtResViewModel;", "", "getCount", "()I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "rawPosition", "position", "Lie/H;", "onBindViewHolder", "(Landroidx/recyclerview/widget/O0;II)V", "getItemViewType", "(I)I", "", "songId", "onPlaySongListener", "(Ljava/lang/String;)V", "albumId", "onPlayAlbumListener", "plylstSeq", "contsTypeCode", "onPlayDjPlaylistListener", "(Ljava/lang/String;Ljava/lang/String;)V", "castSeq", "onPlayRadioCast", "onAlbumPlayListener", "", "isCheck", "onAllSelectListener", "(Z)V", "onPlayArtistMixUp", "()V", "onCheckLoginListener", "()Z", "onShowNoFanPopupListener", "artistId", "isFan", "onRequestFanListener", "(Ljava/lang/String;Z)V", "onShowSharePopupListener", "onSongListMore", "onSongListViewAll", "onSongListFooterRemoveCheck", "contsId", "songIds", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "statsElementsBase", "onPlayForUSongListener", "(Ljava/lang/String;Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "onMoveToScoll", "(I)V", "onLyricUpdateMsgListener", "onOpenCastEpisodeDetailView", "Lcom/iloen/melon/playback/Playable;", "playable", "onPlayBtnListener", "(Lcom/iloen/melon/playback/Playable;)V", "onDownloadSong", "Lcom/iloen/melon/custom/CheckableImageView;", "btnLiked", "Landroid/widget/TextView;", "cntLiked", "onLikedListener", "(Lcom/iloen/melon/custom/CheckableImageView;Landroid/widget/TextView;)V", "Lp8/f;", "onTiaraEventBuilder", "()Lp8/f;", "Lcom/iloen/melon/custom/CheckableTextView;", "view", "onSetBtnAll", "(Lcom/iloen/melon/custom/CheckableTextView;)V", "onPerformBackPress", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "playableList", "nowPlay", "onPlaySongsListener", "(Ljava/util/ArrayList;Z)V", "isLike", "itemPosition", "onItemLikeListener", "(Ljava/lang/String;Ljava/lang/String;ZI)V", "onOpenCommentListView", "Lcom/iloen/melon/fragments/comments/CmtListFragment$Param;", "param", "(Lcom/iloen/melon/fragments/comments/CmtListFragment$Param;)V", "adapterPos", "dataPos", "recom", "Lcom/iloen/melon/custom/RecommenderView;", "recommenderView", "onCommentRecommendListener", "(IIZLandroid/widget/TextView;Lcom/iloen/melon/custom/RecommenderView;)V", "onOpenUserView", "(II)V", "onOpenCommentWriteView", "onOpenAdCommentView", "onOpenCommentEditView", "onCommentRemoveListener", "onCommentReportListener", "isEditable", "isFanTalk", "onShowContextPopupCommentMore", "(IIZZ)V", "d", "Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;", "getLoadPgnRes", "()Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;", "setLoadPgnRes", "(Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;)V", "e", "Lcom/iloen/melon/net/v3x/comments/ListCmtRes;", "getListCmtRes", "()Lcom/iloen/melon/net/v3x/comments/ListCmtRes;", "setListCmtRes", "(Lcom/iloen/melon/net/v3x/comments/ListCmtRes;)V", "Companion", "LocalViewHolder", "InfoViewHolder", "BannerViewHolder", "RecommendVideoViewHolder", "TitleViewHolder", "ArtistViewHolder", "MoreViewHolder", "MagazineViewHolder", "TicketViewHolder", "ContentsEmptyViewHolder", "BottomViewHolder", "CommonClickListener", "InfoClickListener", "BannerClickListener", "ArtistClickListener", "SongClickListener", "MoreClickListener", "DjClickListener", "MagazineClickListener", "ConcertClickListener", "EtcClickListener", "MoreType", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoInfoAdapter extends q implements OnViewHolderActionBaseListener {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\'\u0010\t\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000BÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoAdapter$ArtistClickListener;", "", "Landroid/view/View;", "view", "Lcom/melon/net/res/common/ArtistsInfoBase;", "data", "", "position", "Lie/H;", "onArtistFan", "(Landroid/view/View;Lcom/melon/net/res/common/ArtistsInfoBase;I)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface ArtistClickListener {
        void onArtistFan(@NotNull View arg1, @NotNull ArtistsInfoBase arg2, int arg3);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\n\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoAdapter$ArtistViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/y3;", "_binding", "<init>", "(Lcom/iloen/melon/player/video/VideoInfoAdapter;LJ8/y3;)V", "a", "LJ8/y3;", "getBinding", "()LJ8/y3;", "binding", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ArtistViewHolder extends O0 {
        public final y3 a;

        public ArtistViewHolder(@NotNull y3 y30) {
            kotlin.jvm.internal.q.g(y30, "_binding");
            super(y30.a);
            this.a = y30;
            int v = ScreenUtils.dipToPixel(videoInfoAdapter0.a, 58.0f);
            ViewUtils.setDefaultImage(y30.c.c, v, true);
        }

        @NotNull
        public final y3 getBinding() {
            return this.a;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001F\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoAdapter$BannerClickListener;", "", "", "id", "url", "Lie/H;", "onBanner", "(Ljava/lang/String;Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface BannerClickListener {
        void onBanner(@NotNull String arg1, @NotNull String arg2);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\n\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoAdapter$BannerViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/z3;", "_binding", "<init>", "(Lcom/iloen/melon/player/video/VideoInfoAdapter;LJ8/z3;)V", "a", "LJ8/z3;", "getBinding", "()LJ8/z3;", "binding", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class BannerViewHolder extends O0 {
        public final z3 a;

        public BannerViewHolder(@NotNull z3 z30) {
            kotlin.jvm.internal.q.g(z30, "_binding");
            super(z30.a);
            this.a = z30;
        }

        @NotNull
        public final z3 getBinding() {
            return this.a;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoAdapter$BottomViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/A3;", "_binding", "<init>", "(Lcom/iloen/melon/player/video/VideoInfoAdapter;LJ8/A3;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class BottomViewHolder extends O0 {
        public BottomViewHolder(@NotNull A3 a30) {
            kotlin.jvm.internal.q.g(a30, "_binding");
            super(a30.a);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\bf\u0018\u00002\u00020\u0001JM\u0010\r\u001A\u00020\f2\u001E\u0010\u0005\u001A\u001A\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002j\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u0001`\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u00062\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\nH&¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0011\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\bH&¢\u0006\u0004\b\u0011\u0010\u0012J\'\u0010\u0015\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\b2\u0006\u0010\u0014\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoAdapter$CommonClickListener;", "", "Ljava/util/ArrayList;", "Lcom/melon/net/res/common/ArtistsInfoBase;", "Lkotlin/collections/ArrayList;", "artistList", "", "isSingleArtist", "", "source", "", "orderNum", "Lie/H;", "onArtist", "(Ljava/util/ArrayList;ZLjava/lang/String;I)V", "progSeq", "progName", "onProgram", "(Ljava/lang/String;Ljava/lang/String;)V", "mvId", "mvName", "onPlayMv", "(Ljava/lang/String;Ljava/lang/String;I)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface CommonClickListener {
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public static final class DefaultImpls {
            public static void onArtist$default(CommonClickListener videoInfoAdapter$CommonClickListener0, ArrayList arrayList0, boolean z, String s, int v, int v1, Object object0) {
                CommonClickListener.onArtist$default(videoInfoAdapter$CommonClickListener0, arrayList0, z, s, v, v1, object0);
            }
        }

        void onArtist(@Nullable ArrayList arg1, boolean arg2, @NotNull String arg3, int arg4);

        static void onArtist$default(CommonClickListener videoInfoAdapter$CommonClickListener0, ArrayList arrayList0, boolean z, String s, int v, int v1, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onArtist");
            }
            if((v1 & 2) != 0) {
                z = false;
            }
            if((v1 & 4) != 0) {
                s = "FROM_INFO";
            }
            if((v1 & 8) != 0) {
                v = 0;
            }
            videoInfoAdapter$CommonClickListener0.onArtist(arrayList0, z, s, v);
        }

        void onPlayMv(@NotNull String arg1, @NotNull String arg2, int arg3);

        void onProgram(@NotNull String arg1, @NotNull String arg2);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000B\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000B\u0010\u0007R\u0014\u0010\f\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000E\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000E\u0010\u0007R\u0014\u0010\u000F\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000F\u0010\u0007R\u0014\u0010\u0010\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0007R\u0014\u0010\u0011\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0007R\u0014\u0010\u0013\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0007R\u0014\u0010\u0014\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0007R\u0014\u0010\u0015\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0007R\u0014\u0010\u0016\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoAdapter$Companion;", "", "", "TAG", "Ljava/lang/String;", "", "VIEW_TYPE_NONE", "I", "VIEW_TYPE_LOCAL", "VIEW_TYPE_INFO", "VIEW_TYPE_BANNER", "VIEW_TYPE_RECOMMEND_VIDEO", "VIEW_TYPE_TITLE", "VIEW_TYPE_ARTIST", "VIEW_TYPE_MORE", "VIEW_TYPE_SONG", "VIEW_TYPE_DJ_PLAYLIST", "VIEW_TYPE_MAGAZINE", "VIEW_TYPE_TICKET", "VIEW_TYPE_COMMENT", "VIEW_TYPE_COMMENT_EMPTY", "VIEW_TYPE_CONTENT_EMPTY", "VIEW_TYPE_BOTTOM", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoAdapter$ConcertClickListener;", "", "Lcom/iloen/melon/net/v6x/response/VodDetailRes$Response$Concert$Ticket;", "data", "Lie/H;", "onConcertItem", "(Lcom/iloen/melon/net/v6x/response/VodDetailRes$Response$Concert$Ticket;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface ConcertClickListener {
        void onConcertItem(@NotNull Ticket arg1);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\n\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoAdapter$ContentsEmptyViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/B3;", "_binding", "<init>", "(Lcom/iloen/melon/player/video/VideoInfoAdapter;LJ8/B3;)V", "a", "LJ8/B3;", "getBinding", "()LJ8/B3;", "binding", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ContentsEmptyViewHolder extends O0 {
        public final B3 a;

        public ContentsEmptyViewHolder(@NotNull B3 b30) {
            kotlin.jvm.internal.q.g(b30, "_binding");
            super(b30.a);
            this.a = b30;
        }

        @NotNull
        public final B3 getBinding() {
            return this.a;
        }
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\t\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\t\u0010\b¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoAdapter$DjClickListener;", "", "Lcom/melon/net/res/common/DjPlayListInfoBase;", "data", "", "orderNum", "Lie/H;", "onDjItem", "(Lcom/melon/net/res/common/DjPlayListInfoBase;I)V", "onDjPlay", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface DjClickListener {
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.player.video.VideoInfoAdapter.DjClickListener.DefaultImpls {
            public static void onDjItem$default(DjClickListener videoInfoAdapter$DjClickListener0, DjPlayListInfoBase djPlayListInfoBase0, int v, int v1, Object object0) {
                DjClickListener.onDjItem$default(videoInfoAdapter$DjClickListener0, djPlayListInfoBase0, v, v1, object0);
            }

            public static void onDjPlay$default(DjClickListener videoInfoAdapter$DjClickListener0, DjPlayListInfoBase djPlayListInfoBase0, int v, int v1, Object object0) {
                DjClickListener.onDjPlay$default(videoInfoAdapter$DjClickListener0, djPlayListInfoBase0, v, v1, object0);
            }
        }

        void onDjItem(@NotNull DjPlayListInfoBase arg1, int arg2);

        static void onDjItem$default(DjClickListener videoInfoAdapter$DjClickListener0, DjPlayListInfoBase djPlayListInfoBase0, int v, int v1, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onDjItem");
            }
            if((v1 & 2) != 0) {
                v = 0;
            }
            videoInfoAdapter$DjClickListener0.onDjItem(djPlayListInfoBase0, v);
        }

        void onDjPlay(@NotNull DjPlayListInfoBase arg1, int arg2);

        static void onDjPlay$default(DjClickListener videoInfoAdapter$DjClickListener0, DjPlayListInfoBase djPlayListInfoBase0, int v, int v1, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onDjPlay");
            }
            if((v1 & 2) != 0) {
                v = 0;
            }
            videoInfoAdapter$DjClickListener0.onDjPlay(djPlayListInfoBase0, v);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoAdapter$EtcClickListener;", "", "Lie/H;", "onContentsMore", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface EtcClickListener {
        void onContentsMore();
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\'\u0010\u000B\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\tH&¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000F\u001A\u00020\u00022\u0006\u0010\u000E\u001A\u00020\rH&¢\u0006\u0004\b\u000F\u0010\u0010J\u0019\u0010\u0013\u001A\u00020\u00022\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001A\u00020\u00022\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b\u0015\u0010\u0014¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoAdapter$InfoClickListener;", "", "Lie/H;", "onMoreDesc", "()V", "Landroid/view/View;", "view", "", "contsTypeCode", "", "isLike", "onInfoLike", "(Landroid/view/View;Ljava/lang/String;Z)V", "Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes$result;", "informCmtResult", "onInfoComment", "(Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes$result;)V", "Lcom/iloen/melon/playback/Playable;", "playable", "onInfoDownload", "(Lcom/iloen/melon/playback/Playable;)V", "onInfoShare", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface InfoClickListener {
        void onInfoComment(@NotNull result arg1);

        void onInfoDownload(@Nullable Playable arg1);

        void onInfoLike(@NotNull View arg1, @NotNull String arg2, boolean arg3);

        void onInfoShare(@Nullable Playable arg1);

        void onMoreDesc();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\n\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoAdapter$InfoViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/C3;", "_binding", "<init>", "(Lcom/iloen/melon/player/video/VideoInfoAdapter;LJ8/C3;)V", "a", "LJ8/C3;", "getBinding", "()LJ8/C3;", "binding", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class InfoViewHolder extends O0 {
        public final C3 a;

        public InfoViewHolder(@NotNull C3 c30) {
            kotlin.jvm.internal.q.g(c30, "_binding");
            super(c30.a);
            this.a = c30;
            int v = ScreenUtils.dipToPixel(videoInfoAdapter0.a, 32.0f);
            ViewUtils.setDefaultImage(c30.j.c, v, true);
            int v1 = ScreenUtils.dipToPixel(videoInfoAdapter0.a, 32.0f);
            ViewUtils.setDefaultImage(c30.k.c, v1, true);
            int v2 = ScreenUtils.dipToPixel(videoInfoAdapter0.a, 32.0f);
            ViewUtils.setDefaultImage(c30.l.c, v2, true);
        }

        @NotNull
        public final C3 getBinding() {
            return this.a;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\n\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoAdapter$LocalViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/D3;", "_binding", "<init>", "(Lcom/iloen/melon/player/video/VideoInfoAdapter;LJ8/D3;)V", "a", "LJ8/D3;", "getBinding", "()LJ8/D3;", "binding", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class LocalViewHolder extends O0 {
        public final D3 a;

        public LocalViewHolder(@NotNull D3 d30) {
            kotlin.jvm.internal.q.g(d30, "_binding");
            super(d30.a);
            this.a = d30;
        }

        @NotNull
        public final D3 getBinding() {
            return this.a;
        }
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoAdapter$MagazineClickListener;", "", "Lcom/iloen/melon/net/v6x/response/VodDetailRes$Response$Magazine$MagazineList;", "data", "", "orderNum", "Lie/H;", "onMagazineItem", "(Lcom/iloen/melon/net/v6x/response/VodDetailRes$Response$Magazine$MagazineList;I)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface MagazineClickListener {
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.player.video.VideoInfoAdapter.MagazineClickListener.DefaultImpls {
            public static void onMagazineItem$default(MagazineClickListener videoInfoAdapter$MagazineClickListener0, MagazineList vodDetailRes$Response$Magazine$MagazineList0, int v, int v1, Object object0) {
                MagazineClickListener.onMagazineItem$default(videoInfoAdapter$MagazineClickListener0, vodDetailRes$Response$Magazine$MagazineList0, v, v1, object0);
            }
        }

        void onMagazineItem(@NotNull MagazineList arg1, int arg2);

        static void onMagazineItem$default(MagazineClickListener videoInfoAdapter$MagazineClickListener0, MagazineList vodDetailRes$Response$Magazine$MagazineList0, int v, int v1, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onMagazineItem");
            }
            if((v1 & 2) != 0) {
                v = 0;
            }
            videoInfoAdapter$MagazineClickListener0.onMagazineItem(vodDetailRes$Response$Magazine$MagazineList0, v);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\n\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoAdapter$MagazineViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/E3;", "_binding", "<init>", "(Lcom/iloen/melon/player/video/VideoInfoAdapter;LJ8/E3;)V", "a", "LJ8/E3;", "getBinding", "()LJ8/E3;", "binding", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class MagazineViewHolder extends O0 {
        public final E3 a;

        public MagazineViewHolder(@NotNull E3 e30) {
            kotlin.jvm.internal.q.g(e30, "_binding");
            super(e30.a);
            this.a = e30;
            int v = ScreenUtils.dipToPixel(videoInfoAdapter0.a, 84.0f);
            ViewUtils.setDefaultImage(e30.c.b, v);
        }

        @NotNull
        public final E3 getBinding() {
            return this.a;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001F\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoAdapter$MoreClickListener;", "", "any", "", "position", "Lie/H;", "onMore", "(Ljava/lang/Object;I)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface MoreClickListener {
        void onMore(@NotNull Object arg1, int arg2);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoAdapter$MoreType;", "", "", "MV", "I", "ARTIST", "SONG", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class MoreType {
        public static final int $stable = 0;
        public static final int ARTIST = 2;
        @NotNull
        public static final MoreType INSTANCE = null;
        public static final int MV = 1;
        public static final int SONG = 3;

        static {
            MoreType.INSTANCE = new MoreType();  // 初始化器: Ljava/lang/Object;-><init>()V
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\n\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoAdapter$MoreViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/F3;", "_binding", "<init>", "(Lcom/iloen/melon/player/video/VideoInfoAdapter;LJ8/F3;)V", "a", "LJ8/F3;", "getBinding", "()LJ8/F3;", "binding", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class MoreViewHolder extends O0 {
        public final F3 a;

        public MoreViewHolder(@NotNull F3 f30) {
            kotlin.jvm.internal.q.g(f30, "_binding");
            super(f30.a);
            this.a = f30;
        }

        @NotNull
        public final F3 getBinding() {
            return this.a;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\n\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoAdapter$RecommendVideoViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/G3;", "_binding", "<init>", "(Lcom/iloen/melon/player/video/VideoInfoAdapter;LJ8/G3;)V", "a", "LJ8/G3;", "getBinding", "()LJ8/G3;", "binding", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class RecommendVideoViewHolder extends O0 {
        public final G3 a;

        public RecommendVideoViewHolder(@NotNull G3 g30) {
            kotlin.jvm.internal.q.g(g30, "_binding");
            super(g30.a);
            this.a = g30;
            int v = ScreenUtils.dipToPixel(videoInfoAdapter0.a, 36.0f);
            ViewUtils.setDefaultImage(((e3)g30.f.g).c, v, true);
            int v1 = ScreenUtils.dipToPixel(videoInfoAdapter0.a, 36.0f);
            ViewUtils.setDefaultImage(((e3)g30.g.g).c, v1, true);
            int v2 = ScreenUtils.dipToPixel(videoInfoAdapter0.a, 36.0f);
            ViewUtils.setDefaultImage(((e3)g30.c.g).c, v2, true);
            int v3 = ScreenUtils.dipToPixel(videoInfoAdapter0.a, 36.0f);
            ViewUtils.setDefaultImage(((e3)g30.d.g).c, v3, true);
        }

        @NotNull
        public final G3 getBinding() {
            return this.a;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000B\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t2\b\b\u0002\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u000B\u0010\fJ!\u0010\r\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t2\b\b\u0002\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\r\u0010\f¨\u0006\u000EÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoAdapter$SongClickListener;", "", "", "albumId", "", "orderNum", "Lie/H;", "onSongAlbum", "(Ljava/lang/String;I)V", "Lcom/melon/net/res/common/SongInfoBase;", "song", "onSongPlay", "(Lcom/melon/net/res/common/SongInfoBase;I)V", "onSongInfo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface SongClickListener {
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.player.video.VideoInfoAdapter.SongClickListener.DefaultImpls {
            public static void onSongAlbum$default(SongClickListener videoInfoAdapter$SongClickListener0, String s, int v, int v1, Object object0) {
                SongClickListener.onSongAlbum$default(videoInfoAdapter$SongClickListener0, s, v, v1, object0);
            }

            public static void onSongInfo$default(SongClickListener videoInfoAdapter$SongClickListener0, SongInfoBase songInfoBase0, int v, int v1, Object object0) {
                SongClickListener.onSongInfo$default(videoInfoAdapter$SongClickListener0, songInfoBase0, v, v1, object0);
            }

            public static void onSongPlay$default(SongClickListener videoInfoAdapter$SongClickListener0, SongInfoBase songInfoBase0, int v, int v1, Object object0) {
                SongClickListener.onSongPlay$default(videoInfoAdapter$SongClickListener0, songInfoBase0, v, v1, object0);
            }
        }

        void onSongAlbum(@NotNull String arg1, int arg2);

        static void onSongAlbum$default(SongClickListener videoInfoAdapter$SongClickListener0, String s, int v, int v1, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSongAlbum");
            }
            if((v1 & 2) != 0) {
                v = 0;
            }
            videoInfoAdapter$SongClickListener0.onSongAlbum(s, v);
        }

        void onSongInfo(@NotNull SongInfoBase arg1, int arg2);

        static void onSongInfo$default(SongClickListener videoInfoAdapter$SongClickListener0, SongInfoBase songInfoBase0, int v, int v1, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSongInfo");
            }
            if((v1 & 2) != 0) {
                v = 0;
            }
            videoInfoAdapter$SongClickListener0.onSongInfo(songInfoBase0, v);
        }

        void onSongPlay(@NotNull SongInfoBase arg1, int arg2);

        static void onSongPlay$default(SongClickListener videoInfoAdapter$SongClickListener0, SongInfoBase songInfoBase0, int v, int v1, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSongPlay");
            }
            if((v1 & 2) != 0) {
                v = 0;
            }
            videoInfoAdapter$SongClickListener0.onSongPlay(songInfoBase0, v);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\n\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoAdapter$TicketViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/H3;", "_binding", "<init>", "(Lcom/iloen/melon/player/video/VideoInfoAdapter;LJ8/H3;)V", "a", "LJ8/H3;", "getBinding", "()LJ8/H3;", "binding", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class TicketViewHolder extends O0 {
        public final H3 a;

        public TicketViewHolder(@NotNull H3 h30) {
            kotlin.jvm.internal.q.g(h30, "_binding");
            super(h30.a);
            this.a = h30;
            int v = ScreenUtils.dipToPixel(videoInfoAdapter0.a, 78.0f);
            ViewUtils.setDefaultImage(h30.d.b, v);
        }

        @NotNull
        public final H3 getBinding() {
            return this.a;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\n\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/player/video/VideoInfoAdapter$TitleViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/I3;", "_binding", "<init>", "(Lcom/iloen/melon/player/video/VideoInfoAdapter;LJ8/I3;)V", "a", "LJ8/I3;", "getBinding", "()LJ8/I3;", "binding", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class TitleViewHolder extends O0 {
        public final I3 a;

        public TitleViewHolder(@NotNull I3 i30) {
            kotlin.jvm.internal.q.g(i30, "_binding");
            super(i30.a);
            this.a = i30;
        }

        @NotNull
        public final I3 getBinding() {
            return this.a;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    public static final int VIEW_TYPE_ARTIST = 5;
    public static final int VIEW_TYPE_BANNER = 2;
    public static final int VIEW_TYPE_BOTTOM = 14;
    public static final int VIEW_TYPE_COMMENT = 11;
    public static final int VIEW_TYPE_COMMENT_EMPTY = 12;
    public static final int VIEW_TYPE_CONTENT_EMPTY = 13;
    public static final int VIEW_TYPE_DJ_PLAYLIST = 8;
    public static final int VIEW_TYPE_INFO = 1;
    public static final int VIEW_TYPE_LOCAL = 0;
    public static final int VIEW_TYPE_MAGAZINE = 9;
    public static final int VIEW_TYPE_MORE = 6;
    public static final int VIEW_TYPE_NONE = -1;
    public static final int VIEW_TYPE_RECOMMEND_VIDEO = 3;
    public static final int VIEW_TYPE_SONG = 7;
    public static final int VIEW_TYPE_TICKET = 10;
    public static final int VIEW_TYPE_TITLE = 4;
    public final Context a;
    public final VideoInfoClickListener b;
    public final VideoCommentActionImpl c;
    public LoadPgnRes d;
    public ListCmtRes e;

    static {
        VideoInfoAdapter.Companion = new Companion(null);
        VideoInfoAdapter.$stable = 8;
    }

    public VideoInfoAdapter(@NotNull Context context0, @Nullable List list0, @Nullable VideoInfoClickListener videoInfoFragment$VideoInfoClickListener0, @NotNull VideoCommentActionImpl videoCommentActionImpl0) {
        kotlin.jvm.internal.q.g(context0, "ctx");
        kotlin.jvm.internal.q.g(videoCommentActionImpl0, "videoCommentActionImpl");
        super(context0, list0);
        this.a = context0;
        this.b = videoInfoFragment$VideoInfoClickListener0;
        this.c = videoCommentActionImpl0;
    }

    public final void a(N n0, Mv vodDetailRes$Response$RecmMv$Mv0) {
        MelonTextView melonTextView0 = (MelonTextView)n0.h;
        MelonTextView melonTextView1 = n0.c;
        BorderImageView borderImageView0 = ((e3)n0.g).b;
        FrameLayout frameLayout0 = ((e3)n0.g).a;
        ViewUtils.showWhen(n0.b, vodDetailRes$Response$RecmMv$Mv0.isAdult);
        Context context0 = this.a;
        Glide.with(context0).load(vodDetailRes$Response$RecmMv$Mv0.mv169Img).into(((MelonImageView)((x)n0.f).d));
        MelonTextView melonTextView2 = (MelonTextView)n0.i;
        String s = vodDetailRes$Response$RecmMv$Mv0.playTime;
        String s1 = "";
        if(s == null) {
            s = "";
        }
        melonTextView2.setText(k.f(s));
        String s2 = null;
        frameLayout0.setOnClickListener(null);
        if(vodDetailRes$Response$RecmMv$Mv0.program != null) {
            Glide.with(context0).load(vodDetailRes$Response$RecmMv$Mv0.program.progThumbImageUrl).apply(RequestOptions.circleCropTransform()).into(borderImageView0);
            melonTextView1.setText(vodDetailRes$Response$RecmMv$Mv0.program.progName);
            melonTextView1.requestLayout();
            frameLayout0.setOnClickListener(new com.iloen.melon.player.video.x(this, vodDetailRes$Response$RecmMv$Mv0, 0));
        }
        else if(vodDetailRes$Response$RecmMv$Mv0.artistList != null && !vodDetailRes$Response$RecmMv$Mv0.artistList.isEmpty()) {
            RequestManager requestManager0 = Glide.with(context0);
            ArrayList arrayList0 = vodDetailRes$Response$RecmMv$Mv0.artistList;
            if(arrayList0 != null) {
                ArtistsInfoBase artistsInfoBase0 = (ArtistsInfoBase)arrayList0.get(0);
                if(artistsInfoBase0 != null) {
                    s2 = artistsInfoBase0.getArtistImg();
                }
            }
            if(s2 == null) {
                s2 = "";
            }
            requestManager0.load(s2).apply(RequestOptions.circleCropTransform()).into(borderImageView0);
            melonTextView1.setText(ProtocolUtils.getArtistNames(vodDetailRes$Response$RecmMv$Mv0.artistList));
            melonTextView1.requestLayout();
            frameLayout0.setOnClickListener(new com.iloen.melon.player.video.x(this, vodDetailRes$Response$RecmMv$Mv0, 1));
        }
        com.iloen.melon.player.video.x x0 = new com.iloen.melon.player.video.x(this, vodDetailRes$Response$RecmMv$Mv0, 2);
        ((RelativeLayout)n0.e).setOnClickListener(x0);
        ((MelonTextView)n0.j).setText(vodDetailRes$Response$RecmMv$Mv0.mvName);
        n0.d.setText(vodDetailRes$Response$RecmMv$Mv0.issueDate);
        String s3 = vodDetailRes$Response$RecmMv$Mv0.viewCnt;
        if(s3 != null) {
            s1 = s3;
        }
        melonTextView0.setText(k.a(context0, s1));
        a.O(melonTextView0, ColorUtils.getColor(context0, 0x7F060160));  // color:gray600s_support_high_contrast
    }

    @NotNull
    public final CmtResViewModel getCmtResViewModel(@Nullable LoadPgnRes loadPgnRes0, @Nullable ListCmtRes listCmtRes0) {
        return this.c.getCmtResViewModel(loadPgnRes0, listCmtRes0);
    }

    @Override  // com.iloen.melon.adapters.common.y
    public int getCount() {
        return this.getList().size();
    }

    @Override  // androidx.recyclerview.widget.j0
    public int getItemViewType(int v) {
        WrappedData videoInfoViewModel$WrappedData0 = (WrappedData)this.getItem(v);
        return videoInfoViewModel$WrappedData0 == null ? -1 : videoInfoViewModel$WrappedData0.getViewType();
    }

    @Nullable
    public final ListCmtRes getListCmtRes() {
        return this.e;
    }

    @Nullable
    public final LoadPgnRes getLoadPgnRes() {
        return this.d;
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onAlbumPlayListener(@NotNull String s) {
        kotlin.jvm.internal.q.g(s, "albumId");
        this.c.onAlbumPlayListener(s);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onAllSelectListener(boolean z) {
        this.c.onAllSelectListener(z);
    }

    @Override  // com.iloen.melon.adapters.common.y
    public void onBindViewHolder(@Nullable O0 o00, int v, int v1) {
        boolean z2;
        boolean z1;
        int v4;
        Integer integer0 = o00 == null ? null : o00.getItemViewType();
        if(integer0 != null && ((int)integer0) == 0) {
            kotlin.jvm.internal.q.e(o00, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoAdapter.LocalViewHolder");
            Object object0 = this.getItem(v1);
            kotlin.jvm.internal.q.e(object0, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoViewModel.WrappedData");
            Object object1 = ((WrappedData)object0).getData();
            kotlin.jvm.internal.q.e(object1, "null cannot be cast to non-null type kotlin.String");
            ((LocalViewHolder)o00).getBinding().b.setText(((String)object1));
            return;
        }
        String s = null;
        int v2 = 8;
        Context context0 = this.a;
        if(integer0 != null && ((int)integer0) == 1) {
            kotlin.jvm.internal.q.e(o00, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoAdapter.InfoViewHolder");
            InfoViewHolder videoInfoAdapter$InfoViewHolder0 = (InfoViewHolder)o00;
            Object object2 = this.getItem(v1);
            kotlin.jvm.internal.q.e(object2, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoViewModel.WrappedData");
            Object object3 = ((WrappedData)object2).getData();
            kotlin.jvm.internal.q.e(object3, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.VodDetailRes.Response.Mv");
            ViewUtils.showWhen(videoInfoAdapter$InfoViewHolder0.getBinding().f, ((com.iloen.melon.net.v6x.response.VodDetailRes.Response.Mv)object3).isAdult);
            videoInfoAdapter$InfoViewHolder0.getBinding().u.setText(((com.iloen.melon.net.v6x.response.VodDetailRes.Response.Mv)object3).mvName);
            videoInfoAdapter$InfoViewHolder0.getBinding().o.setText(((com.iloen.melon.net.v6x.response.VodDetailRes.Response.Mv)object3).issueDate);
            MelonTextView melonTextView0 = videoInfoAdapter$InfoViewHolder0.getBinding().s;
            String s1 = ((com.iloen.melon.net.v6x.response.VodDetailRes.Response.Mv)object3).viewCnt;
            if(s1 == null) {
                s1 = "";
            }
            melonTextView0.setText(k.a(context0, s1));
            String s2 = ((com.iloen.melon.net.v6x.response.VodDetailRes.Response.Mv)object3).cheerfulCnt;
            kotlin.jvm.internal.q.f(s2, "cheerfulCnt");
            String s3 = k.a(context0, s2);
            videoInfoAdapter$InfoViewHolder0.getBinding().t.setText(s3);
            String s4 = ((com.iloen.melon.net.v6x.response.VodDetailRes.Response.Mv)object3).cheerfulCnt;
            kotlin.jvm.internal.q.f(s4, "cheerfulCnt");
            ViewUtils.showWhen(videoInfoAdapter$InfoViewHolder0.getBinding().t, s4.length() > 0);
            videoInfoAdapter$InfoViewHolder0.getBinding().j.a.setVisibility(8);
            videoInfoAdapter$InfoViewHolder0.getBinding().k.a.setVisibility(8);
            videoInfoAdapter$InfoViewHolder0.getBinding().l.a.setVisibility(8);
            if(((com.iloen.melon.net.v6x.response.VodDetailRes.Response.Mv)object3).program == null) {
                ArrayList arrayList0 = ((com.iloen.melon.net.v6x.response.VodDetailRes.Response.Mv)object3).artistList;
                int v3 = arrayList0 == null ? 0 : arrayList0.size();
                if(v3 > 0) {
                    ArtistsInfoBase artistsInfoBase0 = arrayList0 == null ? null : ((ArtistsInfoBase)arrayList0.get(0));
                    videoInfoAdapter$InfoViewHolder0.getBinding().j.a.setVisibility(0);
                    RequestManager requestManager0 = Glide.with(context0);
                    String s5 = artistsInfoBase0 == null ? null : artistsInfoBase0.getArtistImg();
                    if(s5 == null) {
                        s5 = "";
                    }
                    requestManager0.load(s5).apply(RequestOptions.circleCropTransform()).into(videoInfoAdapter$InfoViewHolder0.getBinding().j.b);
                }
                if(v3 > 1) {
                    ArtistsInfoBase artistsInfoBase1 = arrayList0 == null ? null : ((ArtistsInfoBase)arrayList0.get(1));
                    videoInfoAdapter$InfoViewHolder0.getBinding().k.a.setVisibility(0);
                    RequestManager requestManager1 = Glide.with(context0);
                    String s6 = artistsInfoBase1 == null ? null : artistsInfoBase1.getArtistImg();
                    if(s6 == null) {
                        s6 = "";
                    }
                    requestManager1.load(s6).apply(RequestOptions.circleCropTransform()).into(videoInfoAdapter$InfoViewHolder0.getBinding().k.b);
                }
                if(v3 > 2) {
                    ArtistsInfoBase artistsInfoBase2 = arrayList0 == null ? null : ((ArtistsInfoBase)arrayList0.get(2));
                    videoInfoAdapter$InfoViewHolder0.getBinding().l.a.setVisibility(0);
                    RequestManager requestManager2 = Glide.with(context0);
                    String s7 = artistsInfoBase2 == null ? null : artistsInfoBase2.getArtistImg();
                    if(s7 == null) {
                        s7 = "";
                    }
                    requestManager2.load(s7).apply(RequestOptions.circleCropTransform()).into(videoInfoAdapter$InfoViewHolder0.getBinding().l.b);
                }
                if(v3 > 2) {
                    videoInfoAdapter$InfoViewHolder0.getBinding().q.setVisibility(0);
                    List list0 = arrayList0 == null ? null : p.K0(2, arrayList0);
                    videoInfoAdapter$InfoViewHolder0.getBinding().m.setText(ProtocolUtils.getArtistNames(list0));
                    kotlin.jvm.internal.q.f("외 %d명", "getString(...)");
                    l1.D(new Object[]{((int)(v3 - 2))}, 1, "외 %d명", videoInfoAdapter$InfoViewHolder0.getBinding().q);
                }
                else {
                    videoInfoAdapter$InfoViewHolder0.getBinding().q.setVisibility(8);
                    String s8 = ProtocolUtils.getArtistNames(arrayList0);
                    videoInfoAdapter$InfoViewHolder0.getBinding().m.setText(s8);
                }
                for(Object object5: e.k.e(new View[]{videoInfoAdapter$InfoViewHolder0.getBinding().b, videoInfoAdapter$InfoViewHolder0.getBinding().m})) {
                    ((View)object5).setOnClickListener(new l(4, this, arrayList0));
                }
            }
            else {
                videoInfoAdapter$InfoViewHolder0.getBinding().j.a.setVisibility(0);
                Glide.with(context0).load(((com.iloen.melon.net.v6x.response.VodDetailRes.Response.Mv)object3).program.progThumbImageUrl).apply(RequestOptions.circleCropTransform()).into(videoInfoAdapter$InfoViewHolder0.getBinding().j.b);
                videoInfoAdapter$InfoViewHolder0.getBinding().m.setText(((com.iloen.melon.net.v6x.response.VodDetailRes.Response.Mv)object3).program.progName);
                for(Object object4: e.k.e(new View[]{videoInfoAdapter$InfoViewHolder0.getBinding().b, videoInfoAdapter$InfoViewHolder0.getBinding().m})) {
                    ((View)object4).setOnClickListener(new l(2, this, ((com.iloen.melon.net.v6x.response.VodDetailRes.Response.Mv)object3)));
                }
            }
            String s9 = ((com.iloen.melon.net.v6x.response.VodDetailRes.Response.Mv)object3).getMvDesc();
            String s10 = s9 == null ? null : o.e1(s9).toString();
            if(s10 == null) {
                s10 = "";
            }
            ViewUtils.hideWhen(videoInfoAdapter$InfoViewHolder0.getBinding().d, s10.length() == 0);
            videoInfoAdapter$InfoViewHolder0.getBinding().p.setText(s10);
            if(((com.iloen.melon.net.v6x.response.VodDetailRes.Response.Mv)object3).isOpen) {
                videoInfoAdapter$InfoViewHolder0.getBinding().p.setMaxLines(0x7FFFFFFF);
            }
            else {
                videoInfoAdapter$InfoViewHolder0.getBinding().p.setMaxLines(1);
            }
            s s11 = new s(0, videoInfoAdapter$InfoViewHolder0, ((com.iloen.melon.net.v6x.response.VodDetailRes.Response.Mv)object3));
            a.C(videoInfoAdapter$InfoViewHolder0.getBinding().p, s11);
            t t0 = new t(0, ((com.iloen.melon.net.v6x.response.VodDetailRes.Response.Mv)object3), videoInfoAdapter$InfoViewHolder0, this);
            videoInfoAdapter$InfoViewHolder0.getBinding().e.setOnClickListener(t0);
            boolean z = ((WrappedData)object2).isLike();
            videoInfoAdapter$InfoViewHolder0.getBinding().r.setCompoundDrawablesWithIntrinsicBounds((z ? 0x7F08014B : 0x7F080148), 0, 0, 0);  // drawable:btn_common_like_22_on
            String s12 = k.a(context0, "0");
            videoInfoAdapter$InfoViewHolder0.getBinding().r.setText(s12);
            c c0 = new c(this, ((com.iloen.melon.net.v6x.response.VodDetailRes.Response.Mv)object3), z);
            videoInfoAdapter$InfoViewHolder0.getBinding().r.setOnClickListener(c0);
            result informCmtContsSummRes$result0 = ((WrappedData)object2).getInformCmtResult();
            if(informCmtContsSummRes$result0 == null) {
                v4 = 0;
            }
            else {
                CMTCONTSSUMM informCmtContsSummRes$result$CMTCONTSSUMM0 = informCmtContsSummRes$result0.cmtContsSumm;
                v4 = informCmtContsSummRes$result$CMTCONTSSUMM0 == null ? 0 : informCmtContsSummRes$result$CMTCONTSSUMM0.validCmtCnt;
            }
            if(informCmtContsSummRes$result0 == null) {
                z1 = false;
            }
            else {
                CMTCONTSSUMM informCmtContsSummRes$result$CMTCONTSSUMM1 = informCmtContsSummRes$result0.cmtContsSumm;
                z1 = informCmtContsSummRes$result$CMTCONTSSUMM1 == null ? false : informCmtContsSummRes$result$CMTCONTSSUMM1.hotFlag;
            }
            if(informCmtContsSummRes$result0 == null) {
                z2 = false;
            }
            else {
                CMTCONTSSUMM informCmtContsSummRes$result$CMTCONTSSUMM2 = informCmtContsSummRes$result0.cmtContsSumm;
                z2 = informCmtContsSummRes$result$CMTCONTSSUMM2 == null ? false : informCmtContsSummRes$result$CMTCONTSSUMM2.newFlag;
            }
            if(z1) {
                videoInfoAdapter$InfoViewHolder0.getBinding().n.setCompoundDrawablesWithIntrinsicBounds(0x7F0803F3, 0, 0, 0);  // drawable:ic_common_hot_24
                int v5 = ScreenUtils.dipToPixel(context0, 2.0f);
                videoInfoAdapter$InfoViewHolder0.getBinding().n.setCompoundDrawablePadding(v5);
            }
            else {
                videoInfoAdapter$InfoViewHolder0.getBinding().n.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                videoInfoAdapter$InfoViewHolder0.getBinding().n.setCompoundDrawablePadding(0);
            }
            String s13 = k.a(context0, String.valueOf(v4));
            videoInfoAdapter$InfoViewHolder0.getBinding().n.setText(s13);
            View view0 = videoInfoAdapter$InfoViewHolder0.getBinding().h;
            if(z2) {
                v2 = 0;
            }
            view0.setVisibility(v2);
            if(informCmtContsSummRes$result0 == null) {
                videoInfoAdapter$InfoViewHolder0.getBinding().c.setOnClickListener(null);
            }
            else {
                l l0 = new l(5, this, informCmtContsSummRes$result0);
                videoInfoAdapter$InfoViewHolder0.getBinding().c.setOnClickListener(l0);
            }
            Object object6 = this.getItem(v1);
            kotlin.jvm.internal.q.e(object6, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoViewModel.WrappedData");
            Playable playable0 = ((WrappedData)object6).getPlayable();
            if(playable0 == null || !playable0.isDownload() || playable0.hasLocalFile()) {
                videoInfoAdapter$InfoViewHolder0.getBinding().g.setAlpha(0.3f);
                videoInfoAdapter$InfoViewHolder0.getBinding().g.setOnClickListener(null);
            }
            else {
                videoInfoAdapter$InfoViewHolder0.getBinding().g.setAlpha(1.0f);
                u u0 = new u(this, playable0, 0);
                videoInfoAdapter$InfoViewHolder0.getBinding().g.setOnClickListener(u0);
            }
            String s14 = playable0 == null ? null : "";
            if(s14 != null && s14.length() != 0 && !kotlin.jvm.internal.q.b((playable0 == null ? null : ""), "-1")) {
                videoInfoAdapter$InfoViewHolder0.getBinding().i.setAlpha(1.0f);
                u u1 = new u(this, playable0, 1);
                videoInfoAdapter$InfoViewHolder0.getBinding().i.setOnClickListener(u1);
                return;
            }
            videoInfoAdapter$InfoViewHolder0.getBinding().i.setAlpha(0.3f);
            videoInfoAdapter$InfoViewHolder0.getBinding().i.setOnClickListener(null);
            return;
        }
        if(integer0 != null && ((int)integer0) == 2) {
            kotlin.jvm.internal.q.e(o00, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoAdapter.BannerViewHolder");
            Object object7 = this.getItem(v1);
            kotlin.jvm.internal.q.e(object7, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoViewModel.WrappedData");
            Object object8 = ((WrappedData)object7).getData();
            kotlin.jvm.internal.q.e(object8, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.PromotionContentsBannerRes.RESPONSE.Banner");
            Banner promotionContentsBannerRes$RESPONSE$Banner0 = (Banner)object8;
            LogU.Companion.d("VideoInfoAdapter", "bgColor : -1");
            int v6 = -1;
            if(promotionContentsBannerRes$RESPONSE$Banner0.bgColor != null && promotionContentsBannerRes$RESPONSE$Banner0.bgColor.length() != 0 && promotionContentsBannerRes$RESPONSE$Banner0.bgColor.length() == 6) {
                try {
                    v6 = ColorUtils.getColorFromHexStr(String.format("#%s", Arrays.copyOf(new Object[]{promotionContentsBannerRes$RESPONSE$Banner0.bgColor}, 1)));
                }
                catch(Exception unused_ex) {
                }
            }
            MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
            melonLinkInfo0.a = promotionContentsBannerRes$RESPONSE$Banner0.linktype;
            melonLinkInfo0.b = promotionContentsBannerRes$RESPONSE$Banner0.linkurl;
            melonLinkInfo0.c = promotionContentsBannerRes$RESPONSE$Banner0.scheme;
            Glide.with(context0).load(promotionContentsBannerRes$RESPONSE$Banner0.imgUrl).apply(RequestOptions.noAnimation()).into(((BannerViewHolder)o00).getBinding().b);
            if(v6 == -1) {
                v6 = ColorUtils.getColor(context0, 0x7F06002C);  // color:bg_banner
            }
            ((BannerViewHolder)o00).getBinding().b.getBackground().setTint(v6);
            z3 z30 = ((BannerViewHolder)o00).getBinding();
            t t1 = new t(melonLinkInfo0, this, promotionContentsBannerRes$RESPONSE$Banner0);
            z30.b.setOnClickListener(t1);
            String s15 = promotionContentsBannerRes$RESPONSE$Banner0.imgAltText == null || !o.H0(promotionContentsBannerRes$RESPONSE$Banner0.imgAltText) != 1 ? "이벤트 배너" : promotionContentsBannerRes$RESPONSE$Banner0.imgAltText;
            ViewUtils.setContentDescriptionWithButtonClassName(((BannerViewHolder)o00).getBinding().b, s15);
            return;
        }
        if(integer0 == null || ((int)integer0) != 3) {
            if(integer0 != null && ((int)integer0) == 4) {
                kotlin.jvm.internal.q.e(o00, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoAdapter.TitleViewHolder");
                Object object16 = this.getItem(v1);
                kotlin.jvm.internal.q.e(object16, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoViewModel.WrappedData");
                Object object17 = ((WrappedData)object16).getData();
                kotlin.jvm.internal.q.e(object17, "null cannot be cast to non-null type kotlin.String");
                ((TitleViewHolder)o00).getBinding().b.setText(((String)object17));
                return;
            }
            if(integer0 != null && ((int)integer0) == 5) {
                kotlin.jvm.internal.q.e(o00, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoAdapter.ArtistViewHolder");
                Object object18 = this.getItem(v1);
                kotlin.jvm.internal.q.e(object18, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoViewModel.WrappedData");
                Object object19 = ((WrappedData)object18).getData();
                kotlin.jvm.internal.q.e(object19, "null cannot be cast to non-null type com.melon.net.res.common.ArtistsInfoBase");
                int v7 = ((WrappedData)object18).getIndex();
                Glide.with(context0).load(((ArtistsInfoBase)object19).getArtistImg()).apply(RequestOptions.circleCropTransform()).into(((ArtistViewHolder)o00).getBinding().c.b);
                ((ArtistViewHolder)o00).getBinding().d.setText(((ArtistsInfoBase)object19).getArtistName());
                ((ArtistViewHolder)o00).getBinding().b.setImageResource((kotlin.jvm.internal.q.b("N", "Y") ? 0x7F08013E : 0x7F08013C));  // drawable:btn_common_fan_22_on
                y3 y30 = ((ArtistViewHolder)o00).getBinding();
                w w0 = new w(this, v7, ((ArtistsInfoBase)object19));
                y30.a.setOnClickListener(w0);
                if(kotlin.jvm.internal.q.b("N", "Y")) {
                    y3 y31 = ((ArtistViewHolder)o00).getBinding();
                    v v8 = new v(((ArtistViewHolder)o00), 0);
                    y31.b.setOnClickListener(v8);
                    return;
                }
                y3 y32 = ((ArtistViewHolder)o00).getBinding();
                w w1 = new w(this, ((ArtistsInfoBase)object19), v1);
                y32.b.setOnClickListener(w1);
                return;
            }
            if(integer0 != null && ((int)integer0) == 6) {
                kotlin.jvm.internal.q.e(o00, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoAdapter.MoreViewHolder");
                Object object20 = this.getItem(v1);
                kotlin.jvm.internal.q.e(object20, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoViewModel.WrappedData");
                ViewGroup.LayoutParams viewGroup$LayoutParams3 = ((MoreViewHolder)o00).getBinding().b.getLayoutParams();
                kotlin.jvm.internal.q.e(viewGroup$LayoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams3).topMargin = ((WrappedData)object20).getMoreType() == 1 ? ScreenUtils.dipToPixel(context0, 12.0f) : 0;
                ((MoreViewHolder)o00).getBinding().b.setLayoutParams(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams3));
                F3 f30 = ((MoreViewHolder)o00).getBinding();
                n n0 = new n(this, ((WrappedData)object20), v1, 15);
                f30.a.setOnClickListener(n0);
                return;
            }
            if(integer0 != null && ((int)integer0) == 7) {
                kotlin.jvm.internal.q.e(o00, "null cannot be cast to non-null type com.iloen.melon.viewholders.SongHolder");
                Object object21 = this.getItem(v1);
                kotlin.jvm.internal.q.e(object21, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoViewModel.WrappedData");
                Object object22 = ((WrappedData)object21).getData();
                kotlin.jvm.internal.q.e(object22, "null cannot be cast to non-null type com.melon.net.res.common.SongInfoBase");
                int v9 = ((WrappedData)object21).getIndex();
                boolean z4 = ((SongInfoBase)object22).canService;
                ViewUtils.setEnable(((SongHolder)o00).wrapperLayout, z4);
                Glide.with(context0).load(((SongInfoBase)object22).albumImg).into(((SongHolder)o00).thumbnailIv);
                if(z4) {
                    int v10 = ColorUtils.getColor(context0, 0x7F06048A);  // color:transparent
                    ((SongHolder)o00).itemView.setBackgroundColor(v10);
                }
                else {
                    int v11 = ColorUtils.getColor(context0, 0x7F06048A);  // color:transparent
                    ((SongHolder)o00).itemView.setBackgroundColor(v11);
                }
                ViewUtils.setOnClickListener(((SongHolder)o00).thumbContainer, new y(this, ((SongInfoBase)object22), v9, 0));
                ViewUtils.showWhen(((SongHolder)o00).btnPlay, z4);
                ViewUtils.setOnClickListener(((SongHolder)o00).btnPlay, new y(this, ((SongInfoBase)object22), v9, 1));
                ViewUtils.setOnClickListener(((SongHolder)o00).btnInfo, new y(this, ((SongInfoBase)object22), v9, 2));
                ((SongHolder)o00).titleTv.setText(((SongInfoBase)object22).songName);
                ((SongHolder)o00).artistTv.setText(ProtocolUtils.getArtistNames(((SongInfoBase)object22).artistList));
                ViewUtils.showWhen(((SongHolder)o00).listTitleIv, ((SongInfoBase)object22).isTitleSong);
                ViewUtils.showWhen(((SongHolder)o00).list19Iv, ((SongInfoBase)object22).isAdult);
                ViewUtils.showWhen(((SongHolder)o00).listHotIv, ((SongInfoBase)object22).isHitSong);
                ViewUtils.showWhen(((SongHolder)o00).listFreeIv, ((SongInfoBase)object22).isFree);
                return;
            }
            if(integer0 != null && ((int)integer0) == 8) {
                kotlin.jvm.internal.q.e(o00, "null cannot be cast to non-null type com.iloen.melon.viewholders.DjPlaylistNewHolder");
                Object object23 = this.getItem(v1);
                kotlin.jvm.internal.q.e(object23, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoViewModel.WrappedData");
                Object object24 = ((WrappedData)object23).getData();
                kotlin.jvm.internal.q.e(object24, "null cannot be cast to non-null type com.melon.net.res.common.DjPlayListInfoBase");
                int v12 = ((WrappedData)object23).getIndex();
                ((DjPlaylistNewHolder)o00).likeTv.setVisibility(8);
                ((DjPlaylistNewHolder)o00).tagContainer.setVisibility(8);
                Glide.with(context0).load(((DjPlayListInfoBase)object24).thumbimg).into(((DjPlaylistNewHolder)o00).thumbIv);
                ((DjPlaylistNewHolder)o00).titleTv.setText(((DjPlayListInfoBase)object24).plylsttitle);
                ((DjPlaylistNewHolder)o00).artistTv.setText(((DjPlayListInfoBase)object24).ownernickname);
                ((DjPlaylistNewHolder)o00).artistTv.requestLayout();
                z z5 = new z(this, ((DjPlayListInfoBase)object24), v12, 0);
                ((DjPlaylistNewHolder)o00).itemView.setOnClickListener(z5);
                ((DjPlaylistNewHolder)o00).playIv.setOnClickListener(new z(this, ((DjPlayListInfoBase)object24), v12, 1));
                return;
            }
            if(integer0 != null && ((int)integer0) == 9) {
                kotlin.jvm.internal.q.e(o00, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoAdapter.MagazineViewHolder");
                Object object25 = this.getItem(v1);
                kotlin.jvm.internal.q.e(object25, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoViewModel.WrappedData");
                Object object26 = ((WrappedData)object25).getData();
                kotlin.jvm.internal.q.e(object26, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.VodDetailRes.Response.Magazine.MagazineList");
                int v13 = ((WrappedData)object25).getIndex();
                Glide.with(context0).load(((MagazineList)object26).listImg).into(((MagazineViewHolder)o00).getBinding().c.b);
                ((MagazineViewHolder)o00).getBinding().d.setText(((MagazineList)object26).mStoryTitle);
                ((MagazineViewHolder)o00).getBinding().b.setText(((MagazineList)object26).catteName);
                E3 e30 = ((MagazineViewHolder)o00).getBinding();
                n n1 = new n(this, ((MagazineList)object26), v13, 16);
                e30.a.setOnClickListener(n1);
                return;
            }
            if(integer0 != null && ((int)integer0) == 10) {
                kotlin.jvm.internal.q.e(o00, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoAdapter.TicketViewHolder");
                Object object27 = this.getItem(v1);
                kotlin.jvm.internal.q.e(object27, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoViewModel.WrappedData");
                Object object28 = ((WrappedData)object27).getData();
                kotlin.jvm.internal.q.e(object28, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.VodDetailRes.Response.Concert.Ticket");
                Glide.with(context0).load(((Ticket)object28).posterImg).into(((TicketViewHolder)o00).getBinding().d.b);
                ((TicketViewHolder)o00).getBinding().e.setText(((Ticket)object28).title);
                ((TicketViewHolder)o00).getBinding().c.setText(((Ticket)object28).placeName);
                MelonTextView melonTextView1 = ((TicketViewHolder)o00).getBinding().b;
                String s16 = ((Ticket)object28).startDt;
                if(s16 != null) {
                    s = s16 + " ~ ";
                }
                melonTextView1.setText(s + ((Ticket)object28).endDt);
                H3 h30 = ((TicketViewHolder)o00).getBinding();
                l l1 = new l(3, this, ((Ticket)object28));
                h30.a.setOnClickListener(l1);
                return;
            }
            if(integer0 != null && ((int)integer0) == 11) {
                kotlin.jvm.internal.q.e(o00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.viewholder.DetailCommentItemHolder");
                Object object29 = this.getItem(v1);
                kotlin.jvm.internal.q.e(object29, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoViewModel.WrappedData");
                AdapterInViewHolder.Row adapterInViewHolder$Row0 = ((WrappedData)object29).getCmtRes();
                if(adapterInViewHolder$Row0 != null) {
                    ((DetailCommentItemHolder)o00).onBindView(adapterInViewHolder$Row0);
                }
            }
            else if(integer0 != null && ((int)integer0) == 12) {
                kotlin.jvm.internal.q.e(o00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.viewholder.EmptyCommentHolder");
                Object object30 = this.getItem(v1);
                kotlin.jvm.internal.q.e(object30, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoViewModel.WrappedData");
                AdapterInViewHolder.Row adapterInViewHolder$Row1 = ((WrappedData)object30).getCmtEmptyRes();
                if(adapterInViewHolder$Row1 != null) {
                    ((EmptyCommentHolder)o00).onBindView(adapterInViewHolder$Row1);
                }
            }
            else if(integer0 != null && ((int)integer0) == 13) {
                kotlin.jvm.internal.q.e(o00, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoAdapter.ContentsEmptyViewHolder");
                B3 b30 = ((ContentsEmptyViewHolder)o00).getBinding();
                v v14 = new v(this, 2);
                b30.b.setOnClickListener(v14);
            }
        }
        else {
            kotlin.jvm.internal.q.e(o00, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoAdapter.RecommendVideoViewHolder");
            RecommendVideoViewHolder videoInfoAdapter$RecommendVideoViewHolder0 = (RecommendVideoViewHolder)o00;
            Object object9 = this.getItem(v1);
            kotlin.jvm.internal.q.e(object9, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoViewModel.WrappedData");
            Object object10 = ((WrappedData)object9).getData();
            kotlin.jvm.internal.q.e(object10, "null cannot be cast to non-null type java.util.ArrayList<com.iloen.melon.net.v6x.response.VodDetailRes.Response.RecmMv.Mv>");
            boolean z3 = ((WrappedData)object9).isFirstItem();
            videoInfoAdapter$RecommendVideoViewHolder0.getBinding().e.setVisibility(8);
            videoInfoAdapter$RecommendVideoViewHolder0.getBinding().b.setVisibility(8);
            if(!ScreenUtils.isTablet(context0) || !ScreenUtils.isOrientationPortrait(context0)) {
                videoInfoAdapter$RecommendVideoViewHolder0.getBinding().e.setVisibility(0);
                ((RelativeLayout)videoInfoAdapter$RecommendVideoViewHolder0.getBinding().f.e).setVisibility(8);
                ((RelativeLayout)videoInfoAdapter$RecommendVideoViewHolder0.getBinding().g.e).setVisibility(8);
                if(((ArrayList)object10).size() > 0) {
                    ((RelativeLayout)videoInfoAdapter$RecommendVideoViewHolder0.getBinding().f.e).setVisibility(0);
                    ViewGroup.LayoutParams viewGroup$LayoutParams1 = ((RelativeLayout)videoInfoAdapter$RecommendVideoViewHolder0.getBinding().f.e).getLayoutParams();
                    kotlin.jvm.internal.q.e(viewGroup$LayoutParams1, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams1).topMargin = z3 ? ScreenUtils.dipToPixel(context0, 40.0f) : ScreenUtils.dipToPixel(context0, 24.0f);
                    ((RelativeLayout)videoInfoAdapter$RecommendVideoViewHolder0.getBinding().f.e).setLayoutParams(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams1));
                    Object object13 = ((ArrayList)object10).get(0);
                    kotlin.jvm.internal.q.f(object13, "get(...)");
                    this.a(videoInfoAdapter$RecommendVideoViewHolder0.getBinding().f, ((Mv)object13));
                }
                if(((ArrayList)object10).size() > 1) {
                    if(((Mv)((ArrayList)object10).get(1)).index == 4) {
                        List list1 = this.getList();
                        kotlin.jvm.internal.q.f(list1, "getList(...)");
                        if(!(list1 instanceof Collection) || !list1.isEmpty()) {
                            for(Object object14: list1) {
                                kotlin.jvm.internal.q.e(object14, "null cannot be cast to non-null type com.iloen.melon.player.video.VideoInfoViewModel.WrappedData");
                                if(((WrappedData)object14).getViewType() == 6 && ((WrappedData)object14).getMoreType() == 1) {
                                    return;
                                }
                                if(false) {
                                    break;
                                }
                            }
                        }
                    }
                    ((RelativeLayout)videoInfoAdapter$RecommendVideoViewHolder0.getBinding().g.e).setVisibility(0);
                    ViewGroup.LayoutParams viewGroup$LayoutParams2 = ((RelativeLayout)videoInfoAdapter$RecommendVideoViewHolder0.getBinding().g.e).getLayoutParams();
                    kotlin.jvm.internal.q.e(viewGroup$LayoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams2).topMargin = ScreenUtils.dipToPixel(context0, 24.0f);
                    ((RelativeLayout)videoInfoAdapter$RecommendVideoViewHolder0.getBinding().g.e).setLayoutParams(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams2));
                    Object object15 = ((ArrayList)object10).get(1);
                    kotlin.jvm.internal.q.f(object15, "get(...)");
                    this.a(videoInfoAdapter$RecommendVideoViewHolder0.getBinding().g, ((Mv)object15));
                }
            }
            else {
                videoInfoAdapter$RecommendVideoViewHolder0.getBinding().b.setVisibility(0);
                ((RelativeLayout)videoInfoAdapter$RecommendVideoViewHolder0.getBinding().c.e).setVisibility(4);
                ((RelativeLayout)videoInfoAdapter$RecommendVideoViewHolder0.getBinding().d.e).setVisibility(4);
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = videoInfoAdapter$RecommendVideoViewHolder0.getBinding().b.getLayoutParams();
                kotlin.jvm.internal.q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).topMargin = z3 ? ScreenUtils.dipToPixel(context0, 40.0f) : ScreenUtils.dipToPixel(context0, 24.0f);
                videoInfoAdapter$RecommendVideoViewHolder0.getBinding().b.setLayoutParams(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0));
                if(((ArrayList)object10).size() > 0) {
                    ((RelativeLayout)videoInfoAdapter$RecommendVideoViewHolder0.getBinding().c.e).setVisibility(0);
                    Object object11 = ((ArrayList)object10).get(0);
                    kotlin.jvm.internal.q.f(object11, "get(...)");
                    this.a(videoInfoAdapter$RecommendVideoViewHolder0.getBinding().c, ((Mv)object11));
                }
                if(((ArrayList)object10).size() > 1) {
                    ((RelativeLayout)videoInfoAdapter$RecommendVideoViewHolder0.getBinding().d.e).setVisibility(0);
                    Object object12 = ((ArrayList)object10).get(1);
                    kotlin.jvm.internal.q.f(object12, "get(...)");
                    this.a(videoInfoAdapter$RecommendVideoViewHolder0.getBinding().d, ((Mv)object12));
                }
            }
        }
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public boolean onCheckLoginListener() {
        return this.c.onCheckLoginListener();
    }

    @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
    public void onCommentRecommendListener(int v, int v1, boolean z, @NotNull TextView textView0, @NotNull RecommenderView recommenderView0) {
        kotlin.jvm.internal.q.g(textView0, "view");
        kotlin.jvm.internal.q.g(recommenderView0, "recommenderView");
        this.c.onCommentRecommendListener(v, v1, z, textView0, recommenderView0);
    }

    @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
    public void onCommentRemoveListener(int v, int v1) {
        this.c.onCommentRemoveListener(v, v1);
    }

    @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
    public void onCommentReportListener(int v, int v1) {
        this.c.onCommentReportListener(v, v1);
    }

    @Override  // androidx.recyclerview.widget.j0
    @NotNull
    public O0 onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
        kotlin.jvm.internal.q.g(viewGroup0, "parent");
        int v1 = 0x7F0A0B8D;  // id:title
        int v2 = 0x7F0A0D34;  // id:tv_title
        int v3 = 0x7F0A0B79;  // id:thumb_layout
        Context context0 = this.a;
        switch(v) {
            case 0: {
                View view0 = LayoutInflater.from(context0).inflate(0x7F0D08DD, viewGroup0, false);  // layout:video_info_item_local
                MelonTextView melonTextView0 = (MelonTextView)I.C(view0, 0x7F0A0D34);  // id:tv_title
                if(melonTextView0 == null) {
                    throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(0x7F0A0D34));  // id:tv_title
                }
                return new LocalViewHolder(this, new D3(((ConstraintLayout)view0), melonTextView0));
            }
            case 1: {
                return new InfoViewHolder(this, C3.a(LayoutInflater.from(context0), viewGroup0));
            }
            case 2: {
                View view1 = LayoutInflater.from(context0).inflate(0x7F0D08D9, viewGroup0, false);  // layout:video_info_item_banner
                MelonImageView melonImageView0 = (MelonImageView)I.C(view1, 0x7F0A05FA);  // id:iv_banner
                if(melonImageView0 == null) {
                    throw new NullPointerException("Missing required view with ID: " + view1.getResources().getResourceName(0x7F0A05FA));  // id:iv_banner
                }
                return new BannerViewHolder(this, new z3(((ConstraintLayout)view1), melonImageView0));
            }
            case 3: {
                View view2 = LayoutInflater.from(context0).inflate(0x7F0D08E1, viewGroup0, false);  // layout:video_info_item_recommend_video_layout
                int v4 = 0x7F0A0539;  // id:horizontal_layout
                View view3 = I.C(view2, 0x7F0A0539);  // id:horizontal_layout
                if(((LinearLayoutCompat)view3) != null) {
                    v4 = 0x7F0A053A;  // id:horizontal_layout1
                    View view4 = I.C(view2, 0x7F0A053A);  // id:horizontal_layout1
                    if(view4 != null) {
                        N n0 = N.b(view4);
                        v4 = 0x7F0A053B;  // id:horizontal_layout2
                        View view5 = I.C(view2, 0x7F0A053B);  // id:horizontal_layout2
                        if(view5 != null) {
                            N n1 = N.b(view5);
                            v4 = 0x7F0A0DA6;  // id:vertical_layout
                            View view6 = I.C(view2, 0x7F0A0DA6);  // id:vertical_layout
                            if(((LinearLayoutCompat)view6) != null) {
                                v4 = 0x7F0A0DA7;  // id:vertical_layout1
                                View view7 = I.C(view2, 0x7F0A0DA7);  // id:vertical_layout1
                                if(view7 != null) {
                                    N n2 = N.b(view7);
                                    v4 = 0x7F0A0DA8;  // id:vertical_layout2
                                    View view8 = I.C(view2, 0x7F0A0DA8);  // id:vertical_layout2
                                    if(view8 != null) {
                                        return new RecommendVideoViewHolder(this, new G3(((FrameLayout)view2), ((LinearLayoutCompat)view3), n0, n1, ((LinearLayoutCompat)view6), n2, N.b(view8)));
                                    }
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: " + view2.getResources().getResourceName(v4));
            }
            case 4: {
                View view9 = LayoutInflater.from(context0).inflate(0x7F0D08E3, viewGroup0, false);  // layout:video_info_item_title
                MelonTextView melonTextView1 = (MelonTextView)I.C(view9, 0x7F0A0D34);  // id:tv_title
                if(melonTextView1 == null) {
                    throw new NullPointerException("Missing required view with ID: " + view9.getResources().getResourceName(0x7F0A0D34));  // id:tv_title
                }
                return new TitleViewHolder(this, new I3(((RelativeLayout)view9), melonTextView1));
            }
            case 5: {
                View view10 = LayoutInflater.from(context0).inflate(0x7F0D08D8, viewGroup0, false);  // layout:video_info_item_artist
                ImageView imageView0 = (ImageView)I.C(view10, 0x7F0A062D);  // id:iv_fan
                if(imageView0 == null) {
                    v3 = 0x7F0A062D;  // id:iv_fan
                }
                else {
                    View view11 = I.C(view10, 0x7F0A0B79);  // id:thumb_layout
                    if(view11 != null) {
                        e3 e30 = e3.a(view11);
                        v3 = 0x7F0A0C16;  // id:tv_artist_name
                        MelonTextView melonTextView2 = (MelonTextView)I.C(view10, 0x7F0A0C16);  // id:tv_artist_name
                        if(melonTextView2 != null) {
                            return new ArtistViewHolder(this, new y3(((RelativeLayout)view10), imageView0, e30, melonTextView2));
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: " + view10.getResources().getResourceName(v3));
            }
            case 6: {
                View view12 = LayoutInflater.from(context0).inflate(0x7F0D08DF, viewGroup0, false);  // layout:video_info_item_more
                MelonTextView melonTextView3 = (MelonTextView)I.C(view12, 0x7F0A0D34);  // id:tv_title
                if(melonTextView3 != null) {
                    v2 = 0x7F0A0D6B;  // id:underline
                    View view13 = I.C(view12, 0x7F0A0D6B);  // id:underline
                    if(view13 != null) {
                        return new MoreViewHolder(this, new F3(((RelativeLayout)view12), melonTextView3, view13));
                    }
                }
                throw new NullPointerException("Missing required view with ID: " + view12.getResources().getResourceName(v2));
            }
            case 7: {
                return new SongHolder(LayoutInflater.from(context0).inflate(0x7F0D04AE, viewGroup0, false));  // layout:listitem_song_new
            }
            case 8: {
                return new DjPlaylistNewHolder(LayoutInflater.from(context0).inflate(0x7F0D048E, viewGroup0, false));  // layout:listitem_djplaylist_new
            }
            case 9: {
                View view14 = LayoutInflater.from(context0).inflate(0x7F0D08DE, viewGroup0, false);  // layout:video_info_item_magazine
                MelonTextView melonTextView4 = (MelonTextView)I.C(view14, 0x7F0A00B8);  // id:artist_name
                if(melonTextView4 == null) {
                    v1 = 0x7F0A00B8;  // id:artist_name
                }
                else {
                    View view15 = I.C(view14, 0x7F0A0B79);  // id:thumb_layout
                    if(view15 == null) {
                        v1 = 0x7F0A0B79;  // id:thumb_layout
                    }
                    else {
                        f3 f30 = f3.a(view15);
                        MelonTextView melonTextView5 = (MelonTextView)I.C(view14, 0x7F0A0B8D);  // id:title
                        if(melonTextView5 != null) {
                            return new MagazineViewHolder(this, new E3(((RelativeLayout)view14), melonTextView4, f30, melonTextView5));
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: " + view14.getResources().getResourceName(v1));
            }
            case 10: {
                View view16 = LayoutInflater.from(context0).inflate(0x7F0D08E2, viewGroup0, false);  // layout:video_info_item_ticket
                View view17 = I.C(view16, 0x7F0A037A);  // id:date
                if(((MelonTextView)view17) == null) {
                    v1 = 0x7F0A037A;  // id:date
                }
                else {
                    View view18 = I.C(view16, 0x7F0A07A5);  // id:location_name
                    if(((MelonTextView)view18) == null) {
                        v1 = 0x7F0A07A5;  // id:location_name
                    }
                    else {
                        View view19 = I.C(view16, 0x7F0A0B79);  // id:thumb_layout
                        if(view19 == null) {
                            v1 = 0x7F0A0B79;  // id:thumb_layout
                        }
                        else {
                            f3 f31 = f3.a(view19);
                            View view20 = I.C(view16, 0x7F0A0B8D);  // id:title
                            if(((MelonTextView)view20) != null) {
                                return new TicketViewHolder(this, new H3(((RelativeLayout)view16), ((MelonTextView)view17), ((MelonTextView)view18), f31, ((MelonTextView)view20)));
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: " + view16.getResources().getResourceName(v1));
            }
            case 11: {
                O0 o00 = DetailCommentItemHolder.Companion.newInstance(viewGroup0, this.c);
                kotlin.jvm.internal.q.f("댓글", "getString(...)");
                ((DetailCommentItemHolder)o00).setCustomTitleText("댓글");
                return o00;
            }
            case 12: {
                O0 o01 = com.iloen.melon.fragments.detail.viewholder.EmptyCommentHolder.Companion.newInstance$default(EmptyCommentHolder.Companion, viewGroup0, this.c, false, 4, null);
                kotlin.jvm.internal.q.f("댓글", "getString(...)");
                ((EmptyCommentHolder)o01).setTitleText("댓글");
                return o01;
            }
            case 13: {
                View view21 = LayoutInflater.from(context0).inflate(0x7F0D08DB, viewGroup0, false);  // layout:video_info_item_contents_empty
                MelonTextView melonTextView6 = (MelonTextView)I.C(view21, 0x7F0A0CBB);  // id:tv_more_video
                if(melonTextView6 == null || ((MelonTextView)I.C(view21, 0x7F0A0CCE)) == null) {  // id:tv_no_contents
                    throw new NullPointerException("Missing required view with ID: " + view21.getResources().getResourceName(0x7F0A0CBB));  // id:tv_more_video
                }
                return new ContentsEmptyViewHolder(this, new B3(((RelativeLayout)view21), melonTextView6));
            }
            case 14: {
                View view22 = LayoutInflater.from(context0).inflate(0x7F0D08DA, viewGroup0, false);  // layout:video_info_item_bottom
                if(view22 == null) {
                    throw new NullPointerException("rootView");
                }
                return new BottomViewHolder(this, new A3(((FrameLayout)view22)));
            }
            default: {
                return new InfoViewHolder(this, C3.a(LayoutInflater.from(context0), viewGroup0));
            }
        }
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onDownloadSong() {
        this.c.onDownloadSong();
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onItemLikeListener(@NotNull String s, @NotNull String s1, boolean z, int v) {
        kotlin.jvm.internal.q.g(s, "contsId");
        kotlin.jvm.internal.q.g(s1, "contsTypeCode");
        this.c.onItemLikeListener(s, s1, z, v);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onLikedListener(@NotNull CheckableImageView checkableImageView0, @NotNull TextView textView0) {
        kotlin.jvm.internal.q.g(checkableImageView0, "btnLiked");
        kotlin.jvm.internal.q.g(textView0, "cntLiked");
        this.c.onLikedListener(checkableImageView0, textView0);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onLyricUpdateMsgListener(@NotNull String s) {
        kotlin.jvm.internal.q.g(s, "songId");
        this.c.onLyricUpdateMsgListener(s);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onMoveToScoll(int v) {
        this.c.onMoveToScoll(v);
    }

    @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
    public void onOpenAdCommentView(int v, int v1) {
        this.c.onOpenAdCommentView(v, v1);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onOpenCastEpisodeDetailView(@Nullable String s) {
        this.c.onOpenCastEpisodeDetailView(s);
    }

    @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
    public void onOpenCommentEditView(int v, int v1) {
        this.c.onOpenCommentEditView(v, v1);
    }

    @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
    public void onOpenCommentListView() {
        this.c.onOpenCommentListView();
    }

    @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
    public void onOpenCommentListView(@NotNull Param cmtListFragment$Param0) {
        kotlin.jvm.internal.q.g(cmtListFragment$Param0, "param");
        this.c.onOpenCommentListView(cmtListFragment$Param0);
    }

    @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
    public void onOpenCommentWriteView() {
        this.c.onOpenCommentWriteView();
    }

    @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
    public void onOpenUserView(int v, int v1) {
        this.c.onOpenUserView(v, v1);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onPerformBackPress() {
        this.c.onPerformBackPress();
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onPlayAlbumListener(@Nullable String s) {
        this.c.onPlayAlbumListener(s);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onPlayArtistMixUp() {
        this.c.onPlayArtistMixUp();
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onPlayBtnListener(@Nullable Playable playable0) {
        this.c.onPlayBtnListener(playable0);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onPlayDjPlaylistListener(@Nullable String s, @Nullable String s1) {
        this.c.onPlayDjPlaylistListener(s, s1);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onPlayForUSongListener(@Nullable String s, @Nullable String s1, @Nullable StatsElementsBase statsElementsBase0) {
        this.c.onPlayForUSongListener(s, s1, statsElementsBase0);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onPlayRadioCast(@Nullable String s) {
        this.c.onPlayRadioCast(s);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onPlaySongListener(@Nullable String s) {
        this.c.onPlaySongListener(s);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onPlaySongsListener(@NotNull ArrayList arrayList0, boolean z) {
        kotlin.jvm.internal.q.g(arrayList0, "playableList");
        this.c.onPlaySongsListener(arrayList0, z);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onRequestFanListener(@NotNull String s, boolean z) {
        kotlin.jvm.internal.q.g(s, "artistId");
        this.c.onRequestFanListener(s, z);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onSetBtnAll(@NotNull CheckableTextView checkableTextView0) {
        kotlin.jvm.internal.q.g(checkableTextView0, "view");
        this.c.onSetBtnAll(checkableTextView0);
    }

    @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
    public void onShowContextPopupCommentMore(int v, int v1, boolean z, boolean z1) {
        this.c.onShowContextPopupCommentMore(v, v1, z, z1);
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onShowNoFanPopupListener() {
        this.c.onShowNoFanPopupListener();
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onShowSharePopupListener() {
        this.c.onShowSharePopupListener();
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onSongListFooterRemoveCheck() {
        this.c.onSongListFooterRemoveCheck();
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public boolean onSongListMore() {
        return this.c.onSongListMore();
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    public void onSongListViewAll() {
        this.c.onSongListViewAll();
    }

    @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
    @Nullable
    public f onTiaraEventBuilder() {
        return this.c.onTiaraEventBuilder();
    }

    public final void setListCmtRes(@Nullable ListCmtRes listCmtRes0) {
        this.e = listCmtRes0;
    }

    public final void setLoadPgnRes(@Nullable LoadPgnRes loadPgnRes0) {
        this.d = loadPgnRes0;
    }
}

