package com.iloen.melon.fragments;

import A7.d;
import Ad.n;
import Cc.N1;
import Cc.U;
import Cc.e0;
import J8.J0;
import J8.a3;
import J8.f3;
import J8.h2;
import J8.m0;
import Jc.t0;
import K.m;
import M.j;
import M.n0;
import M.p0;
import M.y;
import P0.k;
import Q0.k0;
import U4.x;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.I;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.media3.session.W0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import c2.Y;
import com.android.volley.toolbox.RequestFuture;
import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout.Behavior;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.e;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.adapters.common.s;
import com.iloen.melon.custom.CheckableImageView;
import com.iloen.melon.custom.CheckableTextView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.RecommenderView;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.f1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.eventbus.EventComment;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistAlbumHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistArtistNoteHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistBannerHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistDailyReportHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistFanCmtShareHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistGroupHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistHighlightHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistInfoHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistMelonHallHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistMixUpHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistPhotoGridHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistPhotoLinearHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistSongListHeaderHolder;
import com.iloen.melon.fragments.artistchannel.viewholder.ArtistTopicHolder;
import com.iloen.melon.fragments.comments.BbsParam;
import com.iloen.melon.fragments.comments.CmtListFragment.Param;
import com.iloen.melon.fragments.comments.CmtPositionInfo;
import com.iloen.melon.fragments.comments.CommentActionImpl;
import com.iloen.melon.fragments.comments.CommentData;
import com.iloen.melon.fragments.comments.CommentLatestList;
import com.iloen.melon.fragments.comments.CommentViewModel;
import com.iloen.melon.fragments.comments.DetailCommentActionImpl;
import com.iloen.melon.fragments.detail.viewholder.AlbumHolder;
import com.iloen.melon.fragments.detail.viewholder.ArtistNoteHolder;
import com.iloen.melon.fragments.detail.viewholder.CDTitleHolder;
import com.iloen.melon.fragments.detail.viewholder.CreditHolder;
import com.iloen.melon.fragments.detail.viewholder.DetailCommentItemHolder;
import com.iloen.melon.fragments.detail.viewholder.DetailCommonContentsHolder;
import com.iloen.melon.fragments.detail.viewholder.EmptyCommentHolder;
import com.iloen.melon.fragments.detail.viewholder.LyricHolder;
import com.iloen.melon.fragments.detail.viewholder.MagazineHolder;
import com.iloen.melon.fragments.detail.viewholder.MelonTabTitleHolder;
import com.iloen.melon.fragments.detail.viewholder.OtherSongHolder;
import com.iloen.melon.fragments.detail.viewholder.PhotoHolder;
import com.iloen.melon.fragments.detail.viewholder.PlaylistBannerHolder;
import com.iloen.melon.fragments.detail.viewholder.PlaylistHolder;
import com.iloen.melon.fragments.detail.viewholder.PlaylistMixHolder;
import com.iloen.melon.fragments.detail.viewholder.PlaylistRelationContentHolder;
import com.iloen.melon.fragments.detail.viewholder.PlaylistTagHolder;
import com.iloen.melon.fragments.detail.viewholder.SongHistoryHolder;
import com.iloen.melon.fragments.detail.viewholder.SongListEmptyHolder;
import com.iloen.melon.fragments.detail.viewholder.SongListEtcHolder;
import com.iloen.melon.fragments.detail.viewholder.SongListFooterHolder;
import com.iloen.melon.fragments.detail.viewholder.SongListHeaderHolder;
import com.iloen.melon.fragments.detail.viewholder.StReportHolder;
import com.iloen.melon.fragments.detail.viewholder.StationHolder;
import com.iloen.melon.fragments.detail.viewholder.TicketHolder;
import com.iloen.melon.fragments.detail.viewholder.VideoHolder;
import com.iloen.melon.fragments.main.common.OnImpLogListener;
import com.iloen.melon.fragments.main.common.TabItemViewHolder;
import com.iloen.melon.fragments.main.common.ViewableCheckViewHolder.OnStateChangeListener;
import com.iloen.melon.fragments.main.common.ViewableCheckViewHolderForMelonBase;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList;
import com.iloen.melon.net.v3x.comments.CmtResViewModel;
import com.iloen.melon.net.v3x.comments.CmtSharedTypeRes.CmtListBase.CMTINFO;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummRes.result.CMTCONTSSUMM;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummRes;
import com.iloen.melon.net.v3x.comments.ListCmtRes.result.CMTLIST;
import com.iloen.melon.net.v3x.comments.ListCmtRes;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.MyMusicLikeInformContentsLikeReq.Params;
import com.iloen.melon.net.v4x.request.MyMusicLikeInformContentsLikeReq;
import com.iloen.melon.net.v4x.request.UaLogDummyReq;
import com.iloen.melon.net.v4x.request.UserActionsReq;
import com.iloen.melon.net.v4x.response.MyMusicLikeInformContentsLikeRes.RESPONSE;
import com.iloen.melon.net.v4x.response.MyMusicLikeInformContentsLikeRes;
import com.iloen.melon.net.v4x.response.UserActionsRes.Response;
import com.iloen.melon.net.v4x.response.UserActionsRes;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.FOOTER;
import com.iloen.melon.net.v6x.request.MyMusicPlaylistPlayListSongReq;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistPlayListSongRes;
import com.iloen.melon.net.v6x.response.PlaylistListSongBaseRes.RESPONSE.SONGLIST;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.task.request.LikeUpdateAsyncTask.OnJobFinishListener;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.types.Song;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.CompatUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.MelonDetailInfoUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import com.kakao.tiara.data.ContentList;
import com.kakao.tiara.data.ViewImpContent.Builder;
import com.kakao.tiara.data.ViewImpContent;
import com.melon.net.res.common.SongInfoBase;
import ie.H;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import je.w;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.O;
import pe.a;
import pe.b;
import v9.i;
import we.o;

@Metadata(d1 = {"\u0000\u0094\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\b\'\u0018\u0000 \u00A5\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0012\u00A5\u0002\u00A6\u0002\u00A7\u0002\u00A8\u0002\u00A9\u0002\u00AA\u0002\u00AB\u0002\u00AC\u0002\u00AD\u0002B\u0007\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\nH\u0014\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0010\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u000EJ-\u0010\u0017\u001A\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001A\u00020\u00112\b\u0010\u0014\u001A\u0004\u0018\u00010\u00132\b\u0010\u0015\u001A\u0004\u0018\u00010\nH\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u000F\u0010\u0019\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\u0019\u0010\u0006J\u000F\u0010\u001A\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\u001A\u0010\u0006J\u000F\u0010\u001B\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\u001B\u0010\u0006J\u000F\u0010\u001C\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\u001C\u0010\u0006J!\u0010\u001E\u001A\u00020\f2\u0006\u0010\u001D\u001A\u00020\u00162\b\u0010\u0015\u001A\u0004\u0018\u00010\nH\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u000F\u0010 \u001A\u00020\fH\u0016\u00A2\u0006\u0004\b \u0010\u0006J\u000F\u0010!\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b!\u0010\u0006J\u0017\u0010$\u001A\u00020\f2\u0006\u0010#\u001A\u00020\"H\u0016\u00A2\u0006\u0004\b$\u0010%J\u000F\u0010&\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b&\u0010\u0006J\u0017\u0010)\u001A\u00020\f2\u0006\u0010(\u001A\u00020\'H\u0016\u00A2\u0006\u0004\b)\u0010*J\u000F\u0010,\u001A\u00020+H\u0014\u00A2\u0006\u0004\b,\u0010-J\u000F\u0010.\u001A\u00020+H\u0014\u00A2\u0006\u0004\b.\u0010-J\u000F\u00100\u001A\u0004\u0018\u00010/\u00A2\u0006\u0004\b0\u00101J\u000F\u00103\u001A\u0004\u0018\u000102\u00A2\u0006\u0004\b3\u00104J\u000F\u00105\u001A\u00020+H\u0014\u00A2\u0006\u0004\b5\u0010-J\u0017\u00107\u001A\u00020\f2\u0006\u00106\u001A\u00020+H\u0016\u00A2\u0006\u0004\b7\u00108J\u0015\u0010:\u001A\u00020\f2\u0006\u00109\u001A\u00020+\u00A2\u0006\u0004\b:\u00108J\u000F\u0010<\u001A\u00020;H\u0016\u00A2\u0006\u0004\b<\u0010=J\u0011\u0010?\u001A\u0004\u0018\u00010>H\u0014\u00A2\u0006\u0004\b?\u0010@J!\u0010D\u001A\u00020\f2\b\u0010B\u001A\u0004\u0018\u00010A2\u0006\u0010C\u001A\u00020;H\u0014\u00A2\u0006\u0004\bD\u0010EJ\u0015\u0010G\u001A\u00020\f2\u0006\u0010F\u001A\u00020;\u00A2\u0006\u0004\bG\u0010HJ\u0011\u0010J\u001A\u0004\u0018\u00010IH\u0014\u00A2\u0006\u0004\bJ\u0010KJ\u000F\u0010L\u001A\u00020\u0007H&\u00A2\u0006\u0004\bL\u0010\tJ\u000F\u0010M\u001A\u00020\u0007H&\u00A2\u0006\u0004\bM\u0010\tJ!\u0010P\u001A\u00020\f2\b\u0010N\u001A\u0004\u0018\u00010;2\u0006\u0010O\u001A\u00020+H&\u00A2\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001A\u00020\fH\u0086@\u00A2\u0006\u0004\bR\u0010SJ\r\u0010T\u001A\u00020\f\u00A2\u0006\u0004\bT\u0010\u0006J\u0015\u0010U\u001A\u00020\f2\u0006\u0010\u001D\u001A\u00020\u0016\u00A2\u0006\u0004\bU\u0010VJ\u0015\u0010W\u001A\u00020\f2\u0006\u0010\u001D\u001A\u00020\u0016\u00A2\u0006\u0004\bW\u0010VJ\u0017\u0010X\u001A\u00020\f2\u0006\u0010O\u001A\u00020+H\u0016\u00A2\u0006\u0004\bX\u00108J\u000F\u0010Z\u001A\u00020YH&\u00A2\u0006\u0004\bZ\u0010[J\u0013\u0010]\u001A\u00060\\R\u00020\u0000H\u0016\u00A2\u0006\u0004\b]\u0010^J!\u0010a\u001A\u00020\f2\b\u0010`\u001A\u0004\u0018\u00010_2\u0006\u0010F\u001A\u00020;H\u0016\u00A2\u0006\u0004\ba\u0010bJ\u000F\u0010c\u001A\u00020\fH&\u00A2\u0006\u0004\bc\u0010\u0006J\u000F\u0010d\u001A\u00020\fH&\u00A2\u0006\u0004\bd\u0010\u0006J\u0017\u0010f\u001A\u00020\f2\u0006\u0010e\u001A\u00020;H\u0016\u00A2\u0006\u0004\bf\u0010HJ\u0019\u0010i\u001A\u00020\f2\b\u0010h\u001A\u0004\u0018\u00010gH&\u00A2\u0006\u0004\bi\u0010jJ\u001F\u0010o\u001A\u00020\f2\u0006\u0010l\u001A\u00020k2\u0006\u0010n\u001A\u00020mH&\u00A2\u0006\u0004\bo\u0010pJ\'\u0010t\u001A\u00020\f2\u0006\u0010q\u001A\u00020\u00072\u0006\u0010r\u001A\u00020\u00072\u0006\u0010s\u001A\u00020+H\u0016\u00A2\u0006\u0004\bt\u0010uJ\u001F\u0010x\u001A\u00020w2\u0006\u0010l\u001A\u00020k2\u0006\u0010v\u001A\u00020mH\u0016\u00A2\u0006\u0004\bx\u0010yJ\u000F\u0010{\u001A\u00020zH\u0016\u00A2\u0006\u0004\b{\u0010|J\u001A\u0010\u007F\u001A\u00020\f2\b\u0010~\u001A\u0004\u0018\u00010}H\u0017\u00A2\u0006\u0005\b\u007F\u0010\u0080\u0001J\u0011\u0010\u0081\u0001\u001A\u00020\fH\u0016\u00A2\u0006\u0005\b\u0081\u0001\u0010\u0006J\u001C\u0010\u0084\u0001\u001A\f\u0012\u0005\u0012\u00030\u0083\u0001\u0018\u00010\u0082\u0001H\u0016\u00A2\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J4\u0010\u0089\u0001\u001A\u000E\u0012\u0007\u0012\u0005\u0018\u00010\u0088\u0001\u0018\u00010\u0082\u00012\t\u0010\u0086\u0001\u001A\u0004\u0018\u00010\u00072\t\u0010\u0087\u0001\u001A\u0004\u0018\u00010\u0007H\u0014\u00A2\u0006\u0006\b\u0089\u0001\u0010\u008A\u0001J\u001E\u0010\u008D\u0001\u001A\u00020\f2\n\u0010\u008C\u0001\u001A\u0005\u0018\u00010\u008B\u0001H\u0014\u00A2\u0006\u0006\b\u008D\u0001\u0010\u008E\u0001J%\u0010\u0092\u0001\u001A\u00020\f2\u0007\u0010\u008F\u0001\u001A\u00020\u00072\b\u0010\u0091\u0001\u001A\u00030\u0090\u0001H\u0016\u00A2\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u001C\u0010\u0096\u0001\u001A\u00020\f2\b\u0010\u0095\u0001\u001A\u00030\u0094\u0001H\u0016\u00A2\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J\u001C\u0010\u0098\u0001\u001A\u00020\f2\b\u0010\u0095\u0001\u001A\u00030\u0094\u0001H\u0016\u00A2\u0006\u0006\b\u0098\u0001\u0010\u0097\u0001J\u0011\u0010\u0099\u0001\u001A\u00020+H\u0016\u00A2\u0006\u0005\b\u0099\u0001\u0010-J\"\u0010\u009C\u0001\u001A\u00020\f2\u0007\u0010\u009A\u0001\u001A\u00020\u00072\u0007\u0010\u009B\u0001\u001A\u00020\u0007\u00A2\u0006\u0006\b\u009C\u0001\u0010\u009D\u0001J\u0015\u0010\u009F\u0001\u001A\u0005\u0018\u00010\u009E\u0001H\u0016\u00A2\u0006\u0006\b\u009F\u0001\u0010\u00A0\u0001J\u0011\u0010\u00A1\u0001\u001A\u00020\u0007H\u0016\u00A2\u0006\u0005\b\u00A1\u0001\u0010\tJ?\u0010\u00A7\u0001\u001A\u00020\f2\u0007\u0010\u00A2\u0001\u001A\u00020;2\u0007\u0010\u00A3\u0001\u001A\u00020\u00072\u0007\u0010\u00A4\u0001\u001A\u00020\u00072\u0007\u0010\u00A5\u0001\u001A\u00020\u00072\u0007\u0010\u00A6\u0001\u001A\u00020\u0007H\u0016\u00A2\u0006\u0006\b\u00A7\u0001\u0010\u00A8\u0001JH\u0010\u00AA\u0001\u001A\u00020\f2\u0007\u0010\u00A2\u0001\u001A\u00020;2\u0007\u0010\u00A3\u0001\u001A\u00020\u00072\u0007\u0010\u00A4\u0001\u001A\u00020\u00072\u0007\u0010\u00A5\u0001\u001A\u00020\u00072\u0007\u0010\u00A6\u0001\u001A\u00020\u00072\u0007\u0010\u00A9\u0001\u001A\u00020\u0007H\u0016\u00A2\u0006\u0006\b\u00AA\u0001\u0010\u00AB\u0001J6\u0010\u00AD\u0001\u001A\u00020\f2\u0007\u0010\u00AC\u0001\u001A\u00020\u00072\u0007\u0010\u00A2\u0001\u001A\u00020;2\u0007\u0010\u00A4\u0001\u001A\u00020\u00072\u0007\u0010\u00A5\u0001\u001A\u00020\u0007H\u0016\u00A2\u0006\u0006\b\u00AD\u0001\u0010\u00AE\u0001J-\u0010\u00AA\u0001\u001A\u00020\f2\u0007\u0010\u00A2\u0001\u001A\u00020;2\u0007\u0010\u00A4\u0001\u001A\u00020\u00072\u0007\u0010\u00A5\u0001\u001A\u00020\u0007H\u0016\u00A2\u0006\u0006\b\u00AA\u0001\u0010\u00AF\u0001J?\u0010\u00B0\u0001\u001A\u00020\f2\u0007\u0010\u00A2\u0001\u001A\u00020;2\u0007\u0010\u00A3\u0001\u001A\u00020\u00072\u0007\u0010\u00A4\u0001\u001A\u00020\u00072\u0007\u0010\u00A5\u0001\u001A\u00020\u00072\u0007\u0010\u00A6\u0001\u001A\u00020\u0007H\u0016\u00A2\u0006\u0006\b\u00B0\u0001\u0010\u00A8\u0001J6\u0010\u00B1\u0001\u001A\u00020\f2\u0007\u0010\u00AC\u0001\u001A\u00020\u00072\u0007\u0010\u00A2\u0001\u001A\u00020;2\u0007\u0010\u00A4\u0001\u001A\u00020\u00072\u0007\u0010\u00A5\u0001\u001A\u00020\u0007H\u0016\u00A2\u0006\u0006\b\u00B1\u0001\u0010\u00AE\u0001J-\u0010\u00B0\u0001\u001A\u00020\f2\u0007\u0010\u00A2\u0001\u001A\u00020;2\u0007\u0010\u00A4\u0001\u001A\u00020\u00072\u0007\u0010\u00A5\u0001\u001A\u00020\u0007H\u0016\u00A2\u0006\u0006\b\u00B0\u0001\u0010\u00AF\u0001J?\u0010\u00B2\u0001\u001A\u00020\f2\u0007\u0010\u00A2\u0001\u001A\u00020;2\u0007\u0010\u00A3\u0001\u001A\u00020\u00072\u0007\u0010\u00A4\u0001\u001A\u00020\u00072\u0007\u0010\u00A5\u0001\u001A\u00020\u00072\u0007\u0010\u00A6\u0001\u001A\u00020\u0007H\u0016\u00A2\u0006\u0006\b\u00B2\u0001\u0010\u00A8\u0001J6\u0010\u00B3\u0001\u001A\u00020\f2\u0007\u0010\u00AC\u0001\u001A\u00020\u00072\u0007\u0010\u00A2\u0001\u001A\u00020;2\u0007\u0010\u00A4\u0001\u001A\u00020\u00072\u0007\u0010\u00A5\u0001\u001A\u00020\u0007H\u0016\u00A2\u0006\u0006\b\u00B3\u0001\u0010\u00AE\u0001J-\u0010\u00B2\u0001\u001A\u00020\f2\u0007\u0010\u00A2\u0001\u001A\u00020;2\u0007\u0010\u00A4\u0001\u001A\u00020\u00072\u0007\u0010\u00A5\u0001\u001A\u00020\u0007H\u0016\u00A2\u0006\u0006\b\u00B2\u0001\u0010\u00AF\u0001J%\u0010\u00B7\u0001\u001A\u00020\f2\b\u0010\u00B5\u0001\u001A\u00030\u00B4\u00012\u0007\u0010\u00B6\u0001\u001A\u00020+H\u0002\u00A2\u0006\u0006\b\u00B7\u0001\u0010\u00B8\u0001J,\u0010\u00BC\u0001\u001A\u00020\f2\u000F\u0010\u00BA\u0001\u001A\n\u0012\u0005\u0012\u00030\u00B9\u00010\u0082\u00012\u0007\u0010\u00BB\u0001\u001A\u00020;H\u0002\u00A2\u0006\u0006\b\u00BC\u0001\u0010\u00BD\u0001J(\u0010\u00C1\u0001\u001A\u00020;2\b\u0010\u00BE\u0001\u001A\u00030\u00B9\u00012\n\u0010\u00C0\u0001\u001A\u0005\u0018\u00010\u00BF\u0001H\u0002\u00A2\u0006\u0006\b\u00C1\u0001\u0010\u00C2\u0001J&\u0010\u00C7\u0001\u001A\f\u0012\u0007\u0012\u0005\u0018\u00010\u00C6\u00010\u00C5\u00012\b\u0010\u00C4\u0001\u001A\u00030\u00C3\u0001H\u0002\u00A2\u0006\u0006\b\u00C7\u0001\u0010\u00C8\u0001J&\u0010\u00CB\u0001\u001A\f\u0012\u0007\u0012\u0005\u0018\u00010\u00CA\u00010\u00C5\u00012\b\u0010\u00C4\u0001\u001A\u00030\u00C9\u0001H\u0002\u00A2\u0006\u0006\b\u00CB\u0001\u0010\u00CC\u0001J\u001E\u0010\u00CF\u0001\u001A\u00020\f2\n\u0010\u00CE\u0001\u001A\u0005\u0018\u00010\u00CD\u0001H\u0002\u00A2\u0006\u0006\b\u00CF\u0001\u0010\u00D0\u0001J\u001D\u0010\u00D2\u0001\u001A\u00020\f2\t\u0010\u00D1\u0001\u001A\u0004\u0018\u00010\u0007H\u0002\u00A2\u0006\u0006\b\u00D2\u0001\u0010\u00D3\u0001J\u001A\u0010\u00D4\u0001\u001A\u00020\f2\u0006\u0010~\u001A\u00020}H\u0002\u00A2\u0006\u0006\b\u00D4\u0001\u0010\u0080\u0001J \u0010\u00D7\u0001\u001A\u0005\u0018\u00010\u00D6\u00012\t\u0010\u00D5\u0001\u001A\u0004\u0018\u00010\u0007H\u0002\u00A2\u0006\u0006\b\u00D7\u0001\u0010\u00D8\u0001J\u0011\u0010\u00D9\u0001\u001A\u00020\fH\u0002\u00A2\u0006\u0005\b\u00D9\u0001\u0010\u0006J\u0011\u0010\u00DA\u0001\u001A\u00020\fH\u0002\u00A2\u0006\u0005\b\u00DA\u0001\u0010\u0006J\u0011\u0010\u00DB\u0001\u001A\u00020\fH\u0002\u00A2\u0006\u0005\b\u00DB\u0001\u0010\u0006J@\u0010\u009C\u0001\u001A\u00020\f2\b\u0010\u00DD\u0001\u001A\u00030\u00DC\u00012\u0007\u0010\u00DE\u0001\u001A\u00020\u00162\u0007\u0010\u00DF\u0001\u001A\u00020\u00072\u0007\u0010\u00E0\u0001\u001A\u00020;2\u0007\u0010\u00E1\u0001\u001A\u00020;H\u0002\u00A2\u0006\u0006\b\u009C\u0001\u0010\u00E2\u0001R\u001C\u0010\u00E4\u0001\u001A\u0005\u0018\u00010\u00E3\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00E4\u0001\u0010\u00E5\u0001R*\u0010\u00E6\u0001\u001A\u0004\u0018\u00010Y8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0017\n\u0006\b\u00E6\u0001\u0010\u00E7\u0001\u001A\u0005\b\u00E8\u0001\u0010[\"\u0006\b\u00E9\u0001\u0010\u00EA\u0001R\u001B\u0010\u00EB\u0001\u001A\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00EB\u0001\u0010\u00EC\u0001R\'\u0010\u00ED\u0001\u001A\u00020;8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0016\n\u0006\b\u00ED\u0001\u0010\u00EE\u0001\u001A\u0005\b\u00EF\u0001\u0010=\"\u0005\b\u00F0\u0001\u0010HR\'\u0010\u00F1\u0001\u001A\u00020+8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0016\n\u0006\b\u00F1\u0001\u0010\u00F2\u0001\u001A\u0005\b\u00F1\u0001\u0010-\"\u0005\b\u00F3\u0001\u00108R\u0019\u0010\u0099\u0001\u001A\u00020+8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0099\u0001\u0010\u00F2\u0001R7\u0010\u00F6\u0001\u001A\"\u0012\u0004\u0012\u00020;\u0012\u0005\u0012\u00030\u0090\u00010\u00F4\u0001j\u0010\u0012\u0004\u0012\u00020;\u0012\u0005\u0012\u00030\u0090\u0001`\u00F5\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00F6\u0001\u0010\u00F7\u0001R+\u0010\u00FA\u0001\u001A\u0016\u0012\u0005\u0012\u00030\u0094\u00010\u00F8\u0001j\n\u0012\u0005\u0012\u00030\u0094\u0001`\u00F9\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u00FA\u0001\u0010\u00FB\u0001R,\u0010\u00FC\u0001\u001A\u0005\u0018\u00010\u00CD\u00018\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0018\n\u0006\b\u00FC\u0001\u0010\u00FD\u0001\u001A\u0006\b\u00FE\u0001\u0010\u00FF\u0001\"\u0006\b\u0080\u0002\u0010\u00D0\u0001R,\u0010\u0082\u0002\u001A\u0005\u0018\u00010\u0081\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0018\n\u0006\b\u0082\u0002\u0010\u0083\u0002\u001A\u0006\b\u0084\u0002\u0010\u0085\u0002\"\u0006\b\u0086\u0002\u0010\u0087\u0002R\u0019\u0010\u0088\u0002\u001A\u00020+8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0088\u0002\u0010\u00F2\u0001R\u0019\u0010\u0089\u0002\u001A\u00020;8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0089\u0002\u0010\u00EE\u0001R\u0019\u0010\u008A\u0002\u001A\u00020;8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u008A\u0002\u0010\u00EE\u0001R\u0019\u0010\u008B\u0002\u001A\u00020;8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u008B\u0002\u0010\u00EE\u0001R,\u0010\u008D\u0002\u001A\u0005\u0018\u00010\u008C\u00028\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0018\n\u0006\b\u008D\u0002\u0010\u008E\u0002\u001A\u0006\b\u008F\u0002\u0010\u0090\u0002\"\u0006\b\u0091\u0002\u0010\u0092\u0002R!\u0010\u0098\u0002\u001A\u00030\u0093\u00028VX\u0096\u0084\u0002\u00A2\u0006\u0010\n\u0006\b\u0094\u0002\u0010\u0095\u0002\u001A\u0006\b\u0096\u0002\u0010\u0097\u0002R\u001F\u0010\u009B\u0002\u001A\u00020z8VX\u0096\u0084\u0002\u00A2\u0006\u000F\n\u0006\b\u0099\u0002\u0010\u0095\u0002\u001A\u0005\b\u009A\u0002\u0010|R=\u0010\u009D\u0002\u001A&\u0012\u0004\u0012\u00020;\u0012\u0005\u0012\u00030\u009C\u0002\u0018\u00010\u00F4\u0001j\u0012\u0012\u0004\u0012\u00020;\u0012\u0005\u0012\u00030\u009C\u0002\u0018\u0001`\u00F5\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u009D\u0002\u0010\u00F7\u0001R\u0015\u0010\u00A0\u0002\u001A\u00030\u00E3\u00018F\u00A2\u0006\b\u001A\u0006\b\u009E\u0002\u0010\u009F\u0002R\u0016\u0010\u00A2\u0002\u001A\u00020;8VX\u0096\u0004\u00A2\u0006\u0007\u001A\u0005\b\u00A1\u0002\u0010=R\u0018\u0010\u00B5\u0001\u001A\u00030\u00B4\u00018&X\u00A6\u0004\u00A2\u0006\b\u001A\u0006\b\u00A3\u0002\u0010\u00A4\u0002\u00A8\u0006\u00AE\u0002"}, d2 = {"Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/iloen/melon/fragments/main/common/OnImpLogListener;", "Lcom/iloen/melon/fragments/comments/CommentLatestList;", "<init>", "()V", "", "getDetailCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onStart", "onStop", "onDestroyView", "onPause", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "registerCommentViewModelObserver", "drawHeader", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "updateHeaderView", "Lv9/i;", "type", "onPreFetchStart", "(Lv9/i;)V", "", "useDrawHeaderWhenConfigurationChange", "()Z", "useBottomButton", "LJ8/n0;", "getBottomButton", "()LJ8/n0;", "Landroid/widget/FrameLayout;", "getDetailHeader", "()Landroid/widget/FrameLayout;", "showSpaceViewBottomButtonParallax", "isVisible", "showNetworkErrorHeaderView", "(Z)V", "isEnable", "bottomButtonEnable", "", "getCollapseToolbarHeight", "()I", "Lcom/iloen/melon/custom/ToolBar;", "buildToolBar", "()Lcom/iloen/melon/custom/ToolBar;", "Lcom/iloen/melon/custom/ToolBar$ToolBarItem;", "item", "itemId", "onToolBarClick", "(Lcom/iloen/melon/custom/ToolBar$ToolBarItem;I)V", "position", "moveToScroll", "(I)V", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "getContsId", "getContsTypeCode", "sumCount", "isLike", "updateLikeView", "(Ljava/lang/Integer;Z)V", "getUserActionsFromServerAndUpdateUi", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLikeCountFromServerInRealTimeAndUpdateUi", "updateLikeInfo", "(Landroid/view/View;)V", "updateLikeInfoForSongAlbumDetail", "likeClickLog", "LQ4/a;", "onCreateHeaderLayout", "()LQ4/a;", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;", "getOnViewHolderActionListener", "()Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;", "Lcom/iloen/melon/playback/Playable;", "playable", "showContextPopupFromSong", "(Lcom/iloen/melon/playback/Playable;I)V", "onAppBarCollapsed", "onAppBarExpended", "offset", "onAppBarScrolling", "Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes;", "infoCmtContsRes", "updateCommentCountView", "(Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes;)V", "Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;", "loadPgnRes", "Lcom/iloen/melon/net/v3x/comments/ListCmtRes;", "listCmtRes", "updateCommentListView", "(Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;Lcom/iloen/melon/net/v3x/comments/ListCmtRes;)V", "bbsChannelSeq", "bbsContsRefValue", "includeCountApi", "requestCommentApis", "(Ljava/lang/String;Ljava/lang/String;Z)V", "cmtRes", "Lcom/iloen/melon/net/v3x/comments/CmtResViewModel;", "getCmtResViewModel", "(Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;Lcom/iloen/melon/net/v3x/comments/ListCmtRes;)Lcom/iloen/melon/net/v3x/comments/CmtResViewModel;", "Lcom/iloen/melon/fragments/comments/CommentActionImpl;", "getCommentActionListener", "()Lcom/iloen/melon/fragments/comments/CommentActionImpl;", "Lcom/iloen/melon/eventbus/EventComment;", "event", "onEventMainThread", "(Lcom/iloen/melon/eventbus/EventComment;)V", "addAll", "", "Lcom/melon/net/res/common/SongInfoBase;", "getAllSongList", "()Ljava/util/List;", "albumId", "albumName", "Lcom/iloen/melon/types/Song;", "onAddSongsToPlaylist", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "", "userData", "onAddToNowPlayingList", "(Ljava/lang/Object;)V", "key", "Lcom/kakao/tiara/data/ViewImpContent;", "viewImpContent", "onImpLogListener", "(Ljava/lang/String;Lcom/kakao/tiara/data/ViewImpContent;)V", "Lcom/iloen/melon/fragments/main/common/ViewableCheckViewHolder$OnStateChangeListener;", "listener", "addOnStateChangeListener", "(Lcom/iloen/melon/fragments/main/common/ViewableCheckViewHolder$OnStateChangeListener;)V", "removeOnStateChangeListener", "isForegroundFragment", "desc", "contsType", "setDescText", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "getStatsElements", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "getTiaraImpArea", "ordNum", "image", "metaId", "metaName", "metaAuthor", "songItemClickLog", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "cType", "songPlayClickLog", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "setNum", "songItemInAlbumClickLog", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "(ILjava/lang/String;Ljava/lang/String;)V", "songMoreClickLog", "songPlayInAlbumClickLog", "songThumbClickLog", "songMoreInAlbumClickLog", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnData;", "bottomBtnData", "showSpaceViewParallax", "initBottomButton", "(Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnData;Z)V", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnInfo;", "bottomBtnInfoList", "spacePixel", "alignBottomBtnViews", "(Ljava/util/List;I)V", "bottomBtnInfo", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnClickListener;", "bottomBtnClickListener", "addBottomBtnView", "(Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnInfo;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnClickListener;)I", "Lcom/iloen/melon/net/v4x/request/UserActionsReq$Params;", "params", "Lkotlinx/coroutines/Deferred;", "Lcom/iloen/melon/net/v4x/response/UserActionsRes;", "requestUserActionAsync", "(Lcom/iloen/melon/net/v4x/request/UserActionsReq$Params;)Lkotlinx/coroutines/Deferred;", "Lcom/iloen/melon/net/v4x/request/MyMusicLikeInformContentsLikeReq$Params;", "Lcom/iloen/melon/net/v4x/response/MyMusicLikeInformContentsLikeRes;", "requestLikeCountFromServerAsync", "(Lcom/iloen/melon/net/v4x/request/MyMusicLikeInformContentsLikeReq$Params;)Lkotlinx/coroutines/Deferred;", "Lcom/iloen/melon/net/v4x/response/UserActionsRes$Response;", "userRes", "updateLikeBtn", "(Lcom/iloen/melon/net/v4x/response/UserActionsRes$Response;)V", "castSeq", "openCastEpisodeDetailView", "(Ljava/lang/String;)V", "updateCommentItem", "playlistSeq", "Lcom/iloen/melon/net/v6x/response/MyMusicPlaylistPlayListSongRes;", "requestStreamGetMyPlaylistInfo", "(Ljava/lang/String;)Lcom/iloen/melon/net/v6x/response/MyMusicPlaylistPlayListSongRes;", "startViewableCheck", "stopViewableCheck", "tiaraViewImpMapFlush", "Landroid/widget/TextView;", "textView", "moreView", "text", "maxLine", "count", "(Landroid/widget/TextView;Landroid/view/View;Ljava/lang/String;II)V", "LJ8/m0;", "_binding", "LJ8/m0;", "_headerBinding", "LQ4/a;", "get_headerBinding", "set_headerBinding", "(LQ4/a;)V", "detailHeaderContainer", "Landroid/widget/FrameLayout;", "appBarOffset", "I", "getAppBarOffset", "setAppBarOffset", "isFetchStart", "Z", "setFetchStart", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "tiaraViewImpMap", "Ljava/util/HashMap;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "onStateChangeListenerHashSet", "Ljava/util/HashSet;", "userActionsRes", "Lcom/iloen/melon/net/v4x/response/UserActionsRes$Response;", "getUserActionsRes", "()Lcom/iloen/melon/net/v4x/response/UserActionsRes$Response;", "setUserActionsRes", "Lcom/iloen/melon/net/v4x/response/MyMusicLikeInformContentsLikeRes$RESPONSE;", "realTimeLikeInfoRes", "Lcom/iloen/melon/net/v4x/response/MyMusicLikeInformContentsLikeRes$RESPONSE;", "getRealTimeLikeInfoRes", "()Lcom/iloen/melon/net/v4x/response/MyMusicLikeInformContentsLikeRes$RESPONSE;", "setRealTimeLikeInfoRes", "(Lcom/iloen/melon/net/v4x/response/MyMusicLikeInformContentsLikeRes$RESPONSE;)V", "isRequestRecmDone", "prevAppBarOffset", "duplicatedOffsetCnt", "prevOrientation", "Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes$result$CMTCONTSSUMM;", "informCmt", "Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes$result$CMTCONTSSUMM;", "getInformCmt", "()Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes$result$CMTCONTSSUMM;", "setInformCmt", "(Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes$result$CMTCONTSSUMM;)V", "Lcom/iloen/melon/fragments/comments/CommentViewModel;", "commentViewModel$delegate", "Lie/j;", "getCommentViewModel", "()Lcom/iloen/melon/fragments/comments/CommentViewModel;", "commentViewModel", "commentActionImpl$delegate", "getCommentActionImpl", "commentActionImpl", "Lcom/iloen/melon/fragments/comments/CmtPositionInfo;", "cmtPositionInfoHashMap", "getBinding", "()LJ8/m0;", "binding", "getCommentAdapterPosition", "commentAdapterPosition", "getBottomBtnData", "()Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnData;", "Companion", "OnViewHolderActionListener", "DetailAdapter", "DetailSongHolder", "AppBarStateChangeListener", "BottomBtnData", "BottomBtnInfo", "BottomBtnClickListener", "FooterHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class DetailSongMetaContentBaseFragment extends MetaContentBaseFragment implements CommentLatestList, OnImpLogListener, CoroutineScope {
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\'\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ#\u0010\r\u001A\u00020\b2\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\u0010\f\u001A\u0004\u0018\u00010\u000BH&¢\u0006\u0004\b\r\u0010\u000ER\u0016\u0010\u000F\u001A\u00020\u000B8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u000F\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$AppBarStateChangeListener;", "Lcom/google/android/material/appbar/e;", "<init>", "()V", "Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout", "", "offset", "Lie/H;", "onOffsetChanged", "(Lcom/google/android/material/appbar/AppBarLayout;I)V", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$AppBarStateChangeListener$State;", "state", "onStateChanged", "(Lcom/google/android/material/appbar/AppBarLayout;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$AppBarStateChangeListener$State;)V", "mCurrentState", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$AppBarStateChangeListener$State;", "State", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static abstract class AppBarStateChangeListener implements e {
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$AppBarStateChangeListener$State;", "", "<init>", "(Ljava/lang/String;I)V", "EXPANDED", "COLLAPSED", "IDLE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static enum State {
            EXPANDED,
            COLLAPSED,
            IDLE;

            private static final a $ENTRIES;
            private static final State[] $VALUES;

            private static final State[] $values() [...] // Inlined contents

            static {
                State.$VALUES = arr_detailSongMetaContentBaseFragment$AppBarStateChangeListener$State;
                q.g(arr_detailSongMetaContentBaseFragment$AppBarStateChangeListener$State, "entries");
                State.$ENTRIES = new b(arr_detailSongMetaContentBaseFragment$AppBarStateChangeListener$State);
            }

            @NotNull
            public static a getEntries() {
                return State.$ENTRIES;
            }
        }

        public static final int $stable = 8;
        @NotNull
        private State mCurrentState;

        public AppBarStateChangeListener() {
            this.mCurrentState = State.IDLE;
        }

        @Override  // com.google.android.material.appbar.e
        public void onOffsetChanged(@NotNull AppBarLayout appBarLayout0, int v) {
            State detailSongMetaContentBaseFragment$AppBarStateChangeListener$State0;
            q.g(appBarLayout0, "appBarLayout");
            if(v == 0) {
                detailSongMetaContentBaseFragment$AppBarStateChangeListener$State0 = State.EXPANDED;
                if(this.mCurrentState != detailSongMetaContentBaseFragment$AppBarStateChangeListener$State0) {
                    this.onStateChanged(appBarLayout0, detailSongMetaContentBaseFragment$AppBarStateChangeListener$State0);
                }
            }
            else if(Math.abs(v) >= appBarLayout0.getTotalScrollRange()) {
                detailSongMetaContentBaseFragment$AppBarStateChangeListener$State0 = State.COLLAPSED;
                if(this.mCurrentState != detailSongMetaContentBaseFragment$AppBarStateChangeListener$State0) {
                    this.onStateChanged(appBarLayout0, detailSongMetaContentBaseFragment$AppBarStateChangeListener$State0);
                }
            }
            else {
                detailSongMetaContentBaseFragment$AppBarStateChangeListener$State0 = State.IDLE;
                if(this.mCurrentState != detailSongMetaContentBaseFragment$AppBarStateChangeListener$State0) {
                    this.onStateChanged(appBarLayout0, detailSongMetaContentBaseFragment$AppBarStateChangeListener$State0);
                }
            }
            this.mCurrentState = detailSongMetaContentBaseFragment$AppBarStateChangeListener$State0;
        }

        public abstract void onStateChanged(@Nullable AppBarLayout arg1, @Nullable State arg2);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0005\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000F\u0010\u0007\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000F\u0010\b\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnClickListener;", "", "Lie/H;", "onPlayAllSongClick", "()V", "onAddSongClick", "onMixUpPlayClick", "onShuffleSongClick", "onPlaySongClick", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface BottomBtnClickListener {
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public static final class DefaultImpls {
            @Deprecated
            public static void onAddSongClick(@NotNull BottomBtnClickListener detailSongMetaContentBaseFragment$BottomBtnClickListener0) {
                detailSongMetaContentBaseFragment$BottomBtnClickListener0.super.onAddSongClick();
            }

            @Deprecated
            public static void onMixUpPlayClick(@NotNull BottomBtnClickListener detailSongMetaContentBaseFragment$BottomBtnClickListener0) {
                detailSongMetaContentBaseFragment$BottomBtnClickListener0.super.onMixUpPlayClick();
            }

            @Deprecated
            public static void onPlayAllSongClick(@NotNull BottomBtnClickListener detailSongMetaContentBaseFragment$BottomBtnClickListener0) {
                detailSongMetaContentBaseFragment$BottomBtnClickListener0.super.onPlayAllSongClick();
            }

            @Deprecated
            public static void onPlaySongClick(@NotNull BottomBtnClickListener detailSongMetaContentBaseFragment$BottomBtnClickListener0) {
                detailSongMetaContentBaseFragment$BottomBtnClickListener0.super.onPlaySongClick();
            }

            @Deprecated
            public static void onShuffleSongClick(@NotNull BottomBtnClickListener detailSongMetaContentBaseFragment$BottomBtnClickListener0) {
                detailSongMetaContentBaseFragment$BottomBtnClickListener0.super.onShuffleSongClick();
            }
        }

        default void onAddSongClick() {
        }

        default void onMixUpPlayClick() {
        }

        default void onPlayAllSongClick() {
        }

        default void onPlaySongClick() {
        }

        default void onShuffleSongClick() {
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0017\u001A\u00020\u0003HÆ\u0003J\u000F\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000B\u0010\u0019\u001A\u0004\u0018\u00010\bHÆ\u0003J/\u0010\u001A\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001B\u001A\u00020\u001C2\b\u0010\u001D\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001E\u001A\u00020\u001FHÖ\u0001J\t\u0010 \u001A\u00020!HÖ\u0001R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER \u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001C\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnData;", "", "spaceBetweenWidth", "", "bottomBtnInfoList", "", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnInfo;", "bottomBtnClickListener", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnClickListener;", "<init>", "(FLjava/util/List;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnClickListener;)V", "getSpaceBetweenWidth", "()F", "setSpaceBetweenWidth", "(F)V", "getBottomBtnInfoList", "()Ljava/util/List;", "setBottomBtnInfoList", "(Ljava/util/List;)V", "getBottomBtnClickListener", "()Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnClickListener;", "setBottomBtnClickListener", "(Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnClickListener;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class BottomBtnData {
        public static final int $stable = 8;
        @Nullable
        private BottomBtnClickListener bottomBtnClickListener;
        @NotNull
        private List bottomBtnInfoList;
        private float spaceBetweenWidth;

        public BottomBtnData() {
            this(0.0f, null, null, 7, null);
        }

        public BottomBtnData(float f, @NotNull List list0, @Nullable BottomBtnClickListener detailSongMetaContentBaseFragment$BottomBtnClickListener0) {
            q.g(list0, "bottomBtnInfoList");
            super();
            this.spaceBetweenWidth = f;
            this.bottomBtnInfoList = list0;
            this.bottomBtnClickListener = detailSongMetaContentBaseFragment$BottomBtnClickListener0;
        }

        public BottomBtnData(float f, List list0, BottomBtnClickListener detailSongMetaContentBaseFragment$BottomBtnClickListener0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                f = 0.0f;
            }
            if((v & 2) != 0) {
                list0 = w.a;
            }
            if((v & 4) != 0) {
                detailSongMetaContentBaseFragment$BottomBtnClickListener0 = null;
            }
            this(f, list0, detailSongMetaContentBaseFragment$BottomBtnClickListener0);
        }

        public final float component1() {
            return this.spaceBetweenWidth;
        }

        @NotNull
        public final List component2() {
            return this.bottomBtnInfoList;
        }

        @Nullable
        public final BottomBtnClickListener component3() {
            return this.bottomBtnClickListener;
        }

        @NotNull
        public final BottomBtnData copy(float f, @NotNull List list0, @Nullable BottomBtnClickListener detailSongMetaContentBaseFragment$BottomBtnClickListener0) {
            q.g(list0, "bottomBtnInfoList");
            return new BottomBtnData(f, list0, detailSongMetaContentBaseFragment$BottomBtnClickListener0);
        }

        public static BottomBtnData copy$default(BottomBtnData detailSongMetaContentBaseFragment$BottomBtnData0, float f, List list0, BottomBtnClickListener detailSongMetaContentBaseFragment$BottomBtnClickListener0, int v, Object object0) {
            if((v & 1) != 0) {
                f = detailSongMetaContentBaseFragment$BottomBtnData0.spaceBetweenWidth;
            }
            if((v & 2) != 0) {
                list0 = detailSongMetaContentBaseFragment$BottomBtnData0.bottomBtnInfoList;
            }
            if((v & 4) != 0) {
                detailSongMetaContentBaseFragment$BottomBtnClickListener0 = detailSongMetaContentBaseFragment$BottomBtnData0.bottomBtnClickListener;
            }
            return detailSongMetaContentBaseFragment$BottomBtnData0.copy(f, list0, detailSongMetaContentBaseFragment$BottomBtnClickListener0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof BottomBtnData)) {
                return false;
            }
            if(Float.compare(this.spaceBetweenWidth, ((BottomBtnData)object0).spaceBetweenWidth) != 0) {
                return false;
            }
            return q.b(this.bottomBtnInfoList, ((BottomBtnData)object0).bottomBtnInfoList) ? q.b(this.bottomBtnClickListener, ((BottomBtnData)object0).bottomBtnClickListener) : false;
        }

        @Nullable
        public final BottomBtnClickListener getBottomBtnClickListener() {
            return this.bottomBtnClickListener;
        }

        @NotNull
        public final List getBottomBtnInfoList() {
            return this.bottomBtnInfoList;
        }

        public final float getSpaceBetweenWidth() {
            return this.spaceBetweenWidth;
        }

        @Override
        public int hashCode() {
            int v = d.d(Float.hashCode(this.spaceBetweenWidth) * 0x1F, 0x1F, this.bottomBtnInfoList);
            return this.bottomBtnClickListener == null ? v : v + this.bottomBtnClickListener.hashCode();
        }

        public final void setBottomBtnClickListener(@Nullable BottomBtnClickListener detailSongMetaContentBaseFragment$BottomBtnClickListener0) {
            this.bottomBtnClickListener = detailSongMetaContentBaseFragment$BottomBtnClickListener0;
        }

        public final void setBottomBtnInfoList(@NotNull List list0) {
            q.g(list0, "<set-?>");
            this.bottomBtnInfoList = list0;
        }

        public final void setSpaceBetweenWidth(float f) {
            this.spaceBetweenWidth = f;
        }

        @Override
        @NotNull
        public String toString() {
            return "BottomBtnData(spaceBetweenWidth=" + this.spaceBetweenWidth + ", bottomBtnInfoList=" + this.bottomBtnInfoList + ", bottomBtnClickListener=" + this.bottomBtnClickListener + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0016\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0019\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001A\u001A\u00020\u0005HÆ\u0003J\u000B\u0010\u001B\u001A\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u001C\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001D\u001A\u00020\u001E2\b\u0010\u001F\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001A\u00020\u0003HÖ\u0001J\t\u0010!\u001A\u00020\u0007HÖ\u0001R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u001C\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001A\u0010\u0016\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u000B\"\u0004\b\u0018\u0010\r¨\u0006\""}, d2 = {"Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnInfo;", "", "btnType", "", "width", "", "text", "", "<init>", "(IFLjava/lang/String;)V", "getBtnType", "()I", "setBtnType", "(I)V", "getWidth", "()F", "setWidth", "(F)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "viewId", "getViewId", "setViewId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class BottomBtnInfo {
        public static final int $stable = 8;
        private int btnType;
        @Nullable
        private String text;
        private int viewId;
        private float width;

        public BottomBtnInfo(int v, float f, @Nullable String s) {
            this.btnType = v;
            this.width = f;
            this.text = s;
            this.viewId = -1;
        }

        public BottomBtnInfo(int v, float f, String s, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v1 & 4) != 0) {
                s = null;
            }
            this(v, f, s);
        }

        public final int component1() {
            return this.btnType;
        }

        public final float component2() {
            return this.width;
        }

        @Nullable
        public final String component3() {
            return this.text;
        }

        @NotNull
        public final BottomBtnInfo copy(int v, float f, @Nullable String s) {
            return new BottomBtnInfo(v, f, s);
        }

        public static BottomBtnInfo copy$default(BottomBtnInfo detailSongMetaContentBaseFragment$BottomBtnInfo0, int v, float f, String s, int v1, Object object0) {
            if((v1 & 1) != 0) {
                v = detailSongMetaContentBaseFragment$BottomBtnInfo0.btnType;
            }
            if((v1 & 2) != 0) {
                f = detailSongMetaContentBaseFragment$BottomBtnInfo0.width;
            }
            if((v1 & 4) != 0) {
                s = detailSongMetaContentBaseFragment$BottomBtnInfo0.text;
            }
            return detailSongMetaContentBaseFragment$BottomBtnInfo0.copy(v, f, s);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof BottomBtnInfo)) {
                return false;
            }
            if(this.btnType != ((BottomBtnInfo)object0).btnType) {
                return false;
            }
            return Float.compare(this.width, ((BottomBtnInfo)object0).width) == 0 ? q.b(this.text, ((BottomBtnInfo)object0).text) : false;
        }

        public final int getBtnType() {
            return this.btnType;
        }

        @Nullable
        public final String getText() {
            return this.text;
        }

        public final int getViewId() {
            return this.viewId;
        }

        public final float getWidth() {
            return this.width;
        }

        @Override
        public int hashCode() {
            int v = d.a(this.width, this.btnType * 0x1F, 0x1F);
            return this.text == null ? v : v + this.text.hashCode();
        }

        public final void setBtnType(int v) {
            this.btnType = v;
        }

        public final void setText(@Nullable String s) {
            this.text = s;
        }

        public final void setViewId(int v) {
            this.viewId = v;
        }

        public final void setWidth(float f) {
            this.width = f;
        }

        @Override
        @NotNull
        public String toString() {
            int v = this.btnType;
            float f = this.width;
            String s = this.text;
            StringBuilder stringBuilder0 = new StringBuilder("BottomBtnInfo(btnType=");
            stringBuilder0.append(v);
            stringBuilder0.append(", width=");
            stringBuilder0.append(f);
            stringBuilder0.append(", text=");
            return x.m(stringBuilder0, s, ")");
        }
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b@\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\bX\u0082T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\bX\u0082T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010%\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010&\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\'\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010(\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010)\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010*\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010+\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010,\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010-\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010.\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010/\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u00100\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u00101\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u00102\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u00103\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u00104\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u00105\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u00106\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u00107\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u00108\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u00109\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010:\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010;\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010<\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010=\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010>\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010?\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010@\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010A\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010B\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010C\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010D\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010E\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010F\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010G\u001A\u00020\bX\u0086T\u00A2\u0006\u0002\n\u0000\u00A8\u0006H"}, d2 = {"Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_APP_BAR_OFFSET", "TALKBACK_ACTION_DEFAULT", "", "TALKBACK_ACTION_SELECT_SONG", "TALKBACK_ACTION_PLAYBACK", "TALKBACK_ACTION_ALBUM_DETAIL", "TALKBACK_ACTION_MENU_MORE", "SONG_MAX_LINE", "ALBUM_MAX_LINE", "VIEW_TYPE_SONG_LIST_HEADER", "VIEW_TYPE_SONG_LIST", "VIEW_TYPE_SONG", "VIEW_TYPE_VIDEO", "VIEW_TYPE_ALBUM", "VIEW_TYPE_MAGAZINE", "VIEW_TYPE_PLAYLIST", "VIEW_TYPE_STATION", "VIEW_TYPE_TICKET", "VIEW_TYPE_COMMENT", "VIEW_TYPE_LYRIC", "VIEW_TYPE_CREDIT", "VIEW_TYPE_REPORT", "VIEW_TYPE_ARTIST_NOTE", "VIEW_TYPE_ALBUM_INTRODUCE", "VIEW_TYPE_ARTIST_INFO", "VIEW_TYPE_ARTIST_GROUP", "VIEW_TYPE_DAILY_REPORT", "VIEW_TYPE_TAG", "VIEW_TYPE_RELATION_CONTENT", "VIEW_TYPE_PHOTO", "VIEW_TYPE_ALBUM_SERIES", "VIEW_TYPE_ALBUM_OTHER", "VIEW_TYPE_ARTIST_ALBUM", "VIEW_TYPE_ARTIST_ARTIST_NOTE", "VIEW_TYPE_ARTIST_PHOTO_LINEAR", "VIEW_TYPE_ARTIST_PHOTO_GRID", "VIEW_TYPE_PLAYLIST_SERIES", "VIEW_TYPE_PLAYLIST_RELATION", "VIEW_TYPE_ARTIST_HIGHLIGHT", "VIEW_TYPE_ARTIST_FAN_CMT_SHARE", "VIEW_TYPE_ARTIST_MIX_UP", "VIEW_TYPE_ARTIST_BANNER", "VIEW_TYPE_ARTIST_DAILY_REPORT", "VIEW_TYPE_SONG_LIST_FOOTER", "VIEW_TYPE_PLAYLIST_BANNER", "VIEW_TYPE_PLAYLIST_BRAND", "VIEW_TYPE_CD_LIST_TITLE", "VIEW_TYPE_PLAYLIST_MIX", "VIEW_TYPE_COMMON_CONTENTS", "VIEW_TYPE_ARTIST_SONG_LIST_HEADER", "VIEW_TYPE_SONG_HISTORY", "VIEW_TYPE_EMPTY_COMMENT", "VIEW_TYPE_STREAMING_REPORT", "VIEW_TYPE_SIMILAR_SONG", "VIEW_TYPE_OTHER_SONG", "VIEW_TYPE_SONG_LIST_ETC", "VIEW_TYPE_MELON_HALL", "VIEW_TYPE_SONG_LIST_EMPTY", "VIEW_TYPE_MELON_TAB_TITLE", "VIEW_TYPE_TOPIC", "VIEW_TYPE_MAGAZINE_LAND", "BOTTOM_BTN_TYPE_ADD_SONG", "BOTTOM_BTN_TYPE_SHUFFLE", "BOTTOM_BTN_TYPE_PLAY_ALL_SONG", "BOTTOM_BTN_TYPE_PLAY_SONG", "BOTTOM_BTN_TYPE_MIX_UP_PLAY", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u00B4\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00A6\u0004\u0018\u00002\u000E\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u0001B)\b\u0000\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0006\u001A\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0002\u0018\u00010\u0005\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001A\u00020\u000B2\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0016\u00A2\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000F\u001A\u00020\u000E\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u001B\u0010\u0014\u001A\u0004\u0018\u00010\u00132\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J\'\u0010\u001C\u001A\u00020\u000B2\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001B\u001A\u00020\u001AH\u0014\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u001F\u0010!\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020\u001E2\u0006\u0010 \u001A\u00020\u001EH\u0016\u00A2\u0006\u0004\b!\u0010\"J!\u0010\'\u001A\u0004\u0018\u00010&2\u0006\u0010$\u001A\u00020#2\u0006\u0010%\u001A\u00020\u001EH\u0016\u00A2\u0006\u0004\b\'\u0010(J)\u0010*\u001A\u00020\u00102\b\u0010)\u001A\u0004\u0018\u00010&2\u0006\u0010\u001F\u001A\u00020\u001E2\u0006\u0010 \u001A\u00020\u001EH\u0016\u00A2\u0006\u0004\b*\u0010+J)\u0010-\u001A\u00020\u000B2\u0006\u0010 \u001A\u00020\u001E2\b\u0010\u0017\u001A\u0004\u0018\u00010\u00162\u0006\u0010,\u001A\u00020\u000BH\u0014\u00A2\u0006\u0004\b-\u0010.J%\u00103\u001A\u0004\u0018\u0001022\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0004\b3\u00104J%\u00106\u001A\u0004\u0018\u0001052\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0004\b6\u00107J%\u00109\u001A\u0004\u0018\u0001082\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0004\b9\u0010:J%\u0010<\u001A\u0004\u0018\u00010;2\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0004\b<\u0010=J%\u0010?\u001A\u0004\u0018\u00010>2\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0004\b?\u0010@J%\u0010B\u001A\u0004\u0018\u00010A2\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0004\bB\u0010CJ%\u0010E\u001A\u0004\u0018\u00010D2\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0004\bE\u0010FJ%\u0010H\u001A\u0004\u0018\u00010G2\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0004\bH\u0010IJ%\u0010K\u001A\u0004\u0018\u00010J2\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0004\bK\u0010LJ%\u0010N\u001A\u0004\u0018\u00010M2\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0004\bN\u0010OJ%\u0010Q\u001A\u0004\u0018\u00010P2\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0004\bQ\u0010RJ%\u0010T\u001A\u0004\u0018\u00010S2\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0004\bT\u0010UJ%\u0010W\u001A\u0004\u0018\u00010V2\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0004\bW\u0010XJ%\u0010Z\u001A\u0004\u0018\u00010Y2\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0004\bZ\u0010[J%\u0010]\u001A\u0004\u0018\u00010\\2\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0004\b]\u0010^J%\u0010`\u001A\u0004\u0018\u00010_2\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0004\b`\u0010aJ%\u0010c\u001A\u0004\u0018\u00010b2\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0004\bc\u0010dJ%\u0010f\u001A\u0004\u0018\u00010e2\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0004\bf\u0010gJ%\u0010h\u001A\u0004\u0018\u00010V2\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0004\bh\u0010XJ%\u0010i\u001A\u0004\u0018\u00010V2\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0004\bi\u0010XJ%\u0010j\u001A\u0004\u0018\u00010V2\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0004\bj\u0010XJ%\u0010l\u001A\u0004\u0018\u00010k2\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0004\bl\u0010mJ%\u0010o\u001A\u0004\u0018\u00010n2\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0004\bo\u0010pJ%\u0010r\u001A\u0004\u0018\u00010q2\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0004\br\u0010sJ%\u0010u\u001A\u0004\u0018\u00010t2\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0004\bu\u0010vJ%\u0010x\u001A\u0004\u0018\u00010w2\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0004\bx\u0010yJ%\u0010{\u001A\u0004\u0018\u00010z2\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0004\b{\u0010|J%\u0010~\u001A\u0004\u0018\u00010}2\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0004\b~\u0010\u007FJ)\u0010\u0081\u0001\u001A\u0005\u0018\u00010\u0080\u00012\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J)\u0010\u0084\u0001\u001A\u0005\u0018\u00010\u0083\u00012\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J)\u0010\u0087\u0001\u001A\u0005\u0018\u00010\u0086\u00012\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J)\u0010\u008A\u0001\u001A\u0005\u0018\u00010\u0089\u00012\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0006\b\u008A\u0001\u0010\u008B\u0001J)\u0010\u008D\u0001\u001A\u0005\u0018\u00010\u008C\u00012\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0006\b\u008D\u0001\u0010\u008E\u0001J)\u0010\u0090\u0001\u001A\u0005\u0018\u00010\u008F\u00012\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J)\u0010\u0093\u0001\u001A\u0005\u0018\u00010\u0092\u00012\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J)\u0010\u0096\u0001\u001A\u0005\u0018\u00010\u0095\u00012\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J)\u0010\u0099\u0001\u001A\u0005\u0018\u00010\u0098\u00012\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0006\b\u0099\u0001\u0010\u009A\u0001J)\u0010\u009C\u0001\u001A\u0005\u0018\u00010\u009B\u00012\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0006\b\u009C\u0001\u0010\u009D\u0001J)\u0010\u009F\u0001\u001A\u0005\u0018\u00010\u009E\u00012\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0006\b\u009F\u0001\u0010\u00A0\u0001J)\u0010\u00A2\u0001\u001A\u0005\u0018\u00010\u00A1\u00012\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0006\b\u00A2\u0001\u0010\u00A3\u0001J)\u0010\u00A5\u0001\u001A\u0005\u0018\u00010\u00A4\u00012\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0006\b\u00A5\u0001\u0010\u00A6\u0001J)\u0010\u00A8\u0001\u001A\u0005\u0018\u00010\u00A7\u00012\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0006\b\u00A8\u0001\u0010\u00A9\u0001J)\u0010\u00AB\u0001\u001A\u0005\u0018\u00010\u00AA\u00012\u0006\u0010$\u001A\u00020#2\n\u00101\u001A\u00060/R\u000200H\u0016\u00A2\u0006\u0006\b\u00AB\u0001\u0010\u00AC\u0001R\u001B\u00101\u001A\u00060/R\u0002008\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0007\n\u0005\b1\u0010\u00AD\u0001R\u001B\u0010\u00AE\u0001\u001A\u0004\u0018\u00010\u000E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00AE\u0001\u0010\u00AF\u0001\u00A8\u0006\u00B0\u0001"}, d2 = {"Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$DetailAdapter;", "Lcom/iloen/melon/adapters/common/b;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment;Landroid/content/Context;Ljava/util/List;)V", "", "any", "", "isDetailSongItem", "(Ljava/lang/Object;)Z", "Lcom/iloen/melon/fragments/main/common/OnImpLogListener;", "listener", "Lie/H;", "setImpLogListener", "(Lcom/iloen/melon/fragments/main/common/OnImpLogListener;)V", "Lcom/melon/net/res/common/SongInfoBase;", "getDetailSongItem", "(Ljava/lang/Object;)Lcom/melon/net/res/common/SongInfoBase;", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "Landroidx/recyclerview/widget/O0;", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "marked", "setMarked", "(ILjava/lang/String;Z)Z", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/detail/viewholder/SongListHeaderHolder;", "getSongListHeaderHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/SongListHeaderHolder;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistSongListHeaderHolder;", "getArtistSongListHeaderHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistSongListHeaderHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailCommonContentsHolder;", "getCommonContentsHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/DetailCommonContentsHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/SongListFooterHolder;", "getSongListFooterHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/SongListFooterHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/CDTitleHolder;", "getCDTitleHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/CDTitleHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/AlbumHolder;", "getAlbumHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/AlbumHolder;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistAlbumHolder;", "getArtistAlbumHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistAlbumHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/VideoHolder;", "getVideoHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/VideoHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/MagazineHolder;", "getMagazineHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/MagazineHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/StationHolder;", "getStationHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/StationHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/TicketHolder;", "getTicketHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/TicketHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/PhotoHolder;", "getPhotoHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/PhotoHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/PlaylistHolder;", "getPlaylistHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/PlaylistHolder;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistArtistNoteHolder;", "getArtistArtistNoteHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistArtistNoteHolder;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistInfoHolder;", "getArtistInfoHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistInfoHolder;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistGroupHolder;", "getArtistGroupHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistGroupHolder;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistPhotoLinearHolder;", "getArtistPhotoLinearHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistPhotoLinearHolder;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistPhotoGridHolder;", "getArtistPhotoGridHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistPhotoGridHolder;", "getPlaylistRelationPlaylistHolder", "getPlaylistBrandPlaylistHolder", "getPlaylistSeriesPlaylistHolder", "Lcom/iloen/melon/fragments/detail/viewholder/PlaylistRelationContentHolder;", "getPlaylistRelationContentHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/PlaylistRelationContentHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/ArtistNoteHolder;", "getArtistNoteHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/ArtistNoteHolder;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistHighlightHolder;", "getArtistHighlightHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistHighlightHolder;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistFanCmtShareHolder;", "getArtistFanCmtShareHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistFanCmtShareHolder;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistMixUpHolder;", "getArtistMixUpHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistMixUpHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailCommentItemHolder;", "getCommentHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/DetailCommentItemHolder;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistBannerHolder;", "getArtistBannerHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistBannerHolder;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistDailyReportHolder;", "getArtistDailyReportHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistDailyReportHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/PlaylistTagHolder;", "getTagHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/PlaylistTagHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/PlaylistBannerHolder;", "getPlaylistBannerHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/PlaylistBannerHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/PlaylistMixHolder;", "getPlaylistMixHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/PlaylistMixHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/LyricHolder;", "getLyricHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/LyricHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/SongHistoryHolder;", "getSongHistoryHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/SongHistoryHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/CreditHolder;", "getCreditHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/CreditHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/StReportHolder;", "getStReportHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/StReportHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/OtherSongHolder;", "getOtherSongHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/OtherSongHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/EmptyCommentHolder;", "getEmptyCommentHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/EmptyCommentHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/SongListEtcHolder;", "getSongListEtcHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/SongListEtcHolder;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistMelonHallHolder;", "getMelonHallHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistMelonHallHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/MelonTabTitleHolder;", "getMelonTabTitleHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/MelonTabTitleHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/SongListEmptyHolder;", "getSongListEmptyHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/SongListEmptyHolder;", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistTopicHolder;", "getArtistTopicHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistTopicHolder;", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;", "impLogListener", "Lcom/iloen/melon/fragments/main/common/OnImpLogListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public abstract class DetailAdapter extends com.iloen.melon.adapters.common.b {
        @Nullable
        private OnImpLogListener impLogListener;
        @NotNull
        private OnViewHolderActionListener onViewHolderActionListener;

        public DetailAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
            this.onViewHolderActionListener = detailSongMetaContentBaseFragment0.getOnViewHolderActionListener();
        }

        public static void f(DetailSongMetaContentBaseFragment detailSongMetaContentBaseFragment0, DetailAdapter detailSongMetaContentBaseFragment$DetailAdapter0, int v, SongInfoBase songInfoBase0, String s, View view0) {
            DetailAdapter.onBindViewImpl$lambda$8$lambda$7$lambda$4$lambda$3(detailSongMetaContentBaseFragment0, songInfoBase0, detailSongMetaContentBaseFragment$DetailAdapter0, v, s, view0);
        }

        @Nullable
        public AlbumHolder getAlbumHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public ArtistAlbumHolder getArtistAlbumHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public ArtistArtistNoteHolder getArtistArtistNoteHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public ArtistBannerHolder getArtistBannerHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public ArtistDailyReportHolder getArtistDailyReportHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public ArtistFanCmtShareHolder getArtistFanCmtShareHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public ArtistGroupHolder getArtistGroupHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public ArtistHighlightHolder getArtistHighlightHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public ArtistInfoHolder getArtistInfoHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public ArtistMixUpHolder getArtistMixUpHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public ArtistNoteHolder getArtistNoteHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public ArtistPhotoGridHolder getArtistPhotoGridHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public ArtistPhotoLinearHolder getArtistPhotoLinearHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public ArtistSongListHeaderHolder getArtistSongListHeaderHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public ArtistTopicHolder getArtistTopicHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public CDTitleHolder getCDTitleHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public DetailCommentItemHolder getCommentHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public DetailCommonContentsHolder getCommonContentsHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public CreditHolder getCreditHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Override  // com.iloen.melon.adapters.common.q
        @Nullable
        public SongInfoBase getDetailSongItem(@Nullable Object object0) {
            if(object0 instanceof AdapterInViewHolder.Row && ((AdapterInViewHolder.Row)object0).getItem() instanceof SongInfoBase) {
                Object object1 = ((AdapterInViewHolder.Row)object0).getItem();
                q.e(object1, "null cannot be cast to non-null type com.melon.net.res.common.SongInfoBase");
                return (SongInfoBase)object1;
            }
            return null;
        }

        @Nullable
        public EmptyCommentHolder getEmptyCommentHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Override  // com.iloen.melon.adapters.common.b
        public int getItemViewTypeImpl(int v, int v1) {
            AdapterInViewHolder.Row adapterInViewHolder$Row0 = (AdapterInViewHolder.Row)this.getItem(v1);
            return adapterInViewHolder$Row0 == null ? this.getItemViewType(v1) : adapterInViewHolder$Row0.getItemViewType();
        }

        @Nullable
        public LyricHolder getLyricHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public MagazineHolder getMagazineHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public ArtistMelonHallHolder getMelonHallHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public MelonTabTitleHolder getMelonTabTitleHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public OtherSongHolder getOtherSongHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public PhotoHolder getPhotoHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public PlaylistBannerHolder getPlaylistBannerHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public PlaylistHolder getPlaylistBrandPlaylistHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public PlaylistHolder getPlaylistHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public PlaylistMixHolder getPlaylistMixHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public PlaylistRelationContentHolder getPlaylistRelationContentHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public PlaylistHolder getPlaylistRelationPlaylistHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public PlaylistHolder getPlaylistSeriesPlaylistHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public SongHistoryHolder getSongHistoryHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public SongListEmptyHolder getSongListEmptyHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public SongListEtcHolder getSongListEtcHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public SongListFooterHolder getSongListFooterHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public SongListHeaderHolder getSongListHeaderHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public StReportHolder getStReportHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public StationHolder getStationHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public PlaylistTagHolder getTagHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public TicketHolder getTicketHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Nullable
        public VideoHolder getVideoHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return null;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(@NotNull String s, @NotNull i i0, @NotNull HttpResponse httpResponse0) {
            q.g(s, "key");
            q.g(i0, "type");
            q.g(httpResponse0, "response");
            return true;
        }

        // 去混淆评级： 低(20)
        @Override  // com.iloen.melon.adapters.common.q
        public boolean isDetailSongItem(@Nullable Object object0) {
            return object0 instanceof AdapterInViewHolder.Row && ((AdapterInViewHolder.Row)object0).getItem() instanceof SongInfoBase;
        }

        @Override  // com.iloen.melon.adapters.common.b
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            FrameLayout frameLayout2;
            ImageView imageView6;
            DetailSongMetaContentBaseFragment detailSongMetaContentBaseFragment1;
            ImageView imageView5;
            FrameLayout frameLayout1;
            f3 f31;
            ImageView imageView4;
            super.onBindViewImpl(o00, v, v1);
            if(o00 instanceof DetailSongHolder) {
                h2 h20 = ((DetailSongHolder)o00).getBind();
                DetailSongMetaContentBaseFragment detailSongMetaContentBaseFragment0 = DetailSongMetaContentBaseFragment.this;
                LinearLayout linearLayout0 = h20.a;
                MelonTextView melonTextView0 = h20.n;
                ImageView imageView0 = h20.b;
                MelonTextView melonTextView1 = h20.m;
                ImageView imageView1 = h20.c;
                f3 f30 = h20.h;
                FrameLayout frameLayout0 = f30.a;
                q.f(linearLayout0, "getRoot(...)");
                AdapterInViewHolder.Row adapterInViewHolder$Row0 = (AdapterInViewHolder.Row)this.getItem(v1);
                String s = adapterInViewHolder$Row0 == null ? null : adapterInViewHolder$Row0.getCdNum();
                AdapterInViewHolder.Row adapterInViewHolder$Row1 = (AdapterInViewHolder.Row)this.getItem(v1);
                Object object0 = adapterInViewHolder$Row1 == null ? null : adapterInViewHolder$Row1.getItem();
                if(((SongInfoBase)object0) == null) {
                    frameLayout2 = frameLayout0;
                    imageView6 = imageView0;
                }
                else {
                    J0 j00 = J0.a(LayoutInflater.from(this.getContext()), h20.a);
                    ImageView imageView2 = j00.d;
                    boolean z = ((SongInfoBase)object0).canService;
                    ImageView imageView3 = (ImageView)j00.b;
                    boolean z1 = q.b(((SongInfoBase)object0).cType, "99");
                    ViewUtils.setEnable(h20.q, z);
                    if(z) {
                        imageView4 = imageView1;
                        f31 = f30;
                        frameLayout1 = frameLayout0;
                        imageView5 = imageView2;
                        detailSongMetaContentBaseFragment1 = detailSongMetaContentBaseFragment0;
                        ViewUtils.setOnClickListener(linearLayout0, new f(detailSongMetaContentBaseFragment1, v, s, v1, ((SongInfoBase)object0)));
                        if(this.isMarked(v1)) {
                            linearLayout0.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F060199));  // color:list_item_marked
                        }
                        else {
                            linearLayout0.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F06048A));  // color:transparent
                        }
                    }
                    else {
                        imageView4 = imageView1;
                        f31 = f30;
                        frameLayout1 = frameLayout0;
                        imageView5 = imageView2;
                        detailSongMetaContentBaseFragment1 = detailSongMetaContentBaseFragment0;
                        ViewUtils.setOnClickListener(linearLayout0, null);
                        linearLayout0.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F06048A));  // color:transparent
                    }
                    ViewUtils.setOnLongClickListener(linearLayout0, (z1 ? null : new g(this, detailSongMetaContentBaseFragment1, v1, ((SongInfoBase)object0))));
                    imageView1 = imageView4;
                    ViewUtils.showWhen(imageView1, z);
                    imageView6 = imageView0;
                    detailSongMetaContentBaseFragment0 = detailSongMetaContentBaseFragment1;
                    ViewUtils.setOnClickListener(imageView1, new h(detailSongMetaContentBaseFragment0, this, v1, ((SongInfoBase)object0), s));
                    ViewUtils.showWhen(imageView6, true);
                    if(z1) {
                        ViewUtils.setEnable(imageView6, false);
                        ViewUtils.setOnClickListener(imageView6, null);
                    }
                    else {
                        ViewUtils.setEnable(imageView6, true);
                        ViewUtils.setOnClickListener(imageView6, new h(detailSongMetaContentBaseFragment0, ((SongInfoBase)object0), this, v1, s));
                    }
                    ViewUtils.setOnClickListener(frameLayout1, (z1 ? null : new n(detailSongMetaContentBaseFragment0, ((SongInfoBase)object0), v1, 6)));
                    ViewUtils.setTextViewMarquee(melonTextView0, this.isMarqueeNeeded(v1));
                    melonTextView0.setText(((SongInfoBase)object0).songName);
                    String s1 = ProtocolUtils.getArtistNames(((SongInfoBase)object0).artistList);
                    h20.j.setText(s1);
                    ViewUtils.showWhen(imageView3, ((SongInfoBase)object0).isTitleSong);
                    ViewUtils.showWhen(j00.c, ((SongInfoBase)object0).isAdult);
                    ViewUtils.showWhen(imageView5, ((SongInfoBase)object0).isHitSong);
                    ViewUtils.showWhen(((ImageView)j00.f), ((SongInfoBase)object0).isFree);
                    ViewUtils.showWhen(((ImageView)j00.g), ((SongInfoBase)object0).isHoldback);
                    String s2 = detailSongMetaContentBaseFragment0.getContsTypeCode();
                    if(q.b(s2, "N10002")) {
                        frameLayout1.setVisibility(8);
                        melonTextView1.setVisibility(0);
                        String s3 = ((SongInfoBase)object0).getTrackNo();
                        melonTextView1.setText(MelonDetailInfoUtils.INSTANCE.getSongTrackNumberFormat(s3));
                        h20.e.setVisibility(8);
                    }
                    else if(q.b(s2, "N10009") || q.b(s2, "N10005") || q.b(s2, "N10016") || q.b(s2, "N10078") || q.b(s2, "N10082") || q.b(s2, "N10006")) {
                        frameLayout1.setVisibility(0);
                        melonTextView1.setVisibility(8);
                        imageView3.setVisibility(8);
                        imageView5.setVisibility(8);
                        q.d(Glide.with(this.getContext()).load(((SongInfoBase)object0).albumImg).into(f31.b));
                    }
                    if(q.b(detailSongMetaContentBaseFragment0.getContsTypeCode(), "N10078")) {
                        frameLayout2 = frameLayout1;
                        ((DetailSongHolder)o00).addAndStartViewableCheck(linearLayout0, 0, new t0(this, detailSongMetaContentBaseFragment0, v1, ((SongInfoBase)object0), 1));
                    }
                    else {
                        frameLayout2 = frameLayout1;
                    }
                }
                frameLayout2.setImportantForAccessibility(2);
                imageView1.setImportantForAccessibility(2);
                imageView6.setImportantForAccessibility(2);
                linearLayout0.setAccessibilityDelegate(new View.AccessibilityDelegate() {
                    @Override  // android.view.View$AccessibilityDelegate
                    public void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
                        q.g(view0, "host");
                        q.g(accessibilityNodeInfo0, "info");
                        super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
                        int v = v1.isMarked(h20) ? 0x7F130C5A : 0x7F130C58;  // string:talkback_songlist_unselect "선택 해제하기"
                        accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000001, this.getString(v)));
                        accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000002, this.getString(0x7F130C59)));  // string:talkback_songlist_song_play "재생"
                        accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000003, this.getString(0x7F130C54)));  // string:talkback_songlist_album_info "앨범 정보"
                        accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000004, this.getString(0x7F130C57)));  // string:talkback_songlist_more_menu "더보기"
                        String s = v1.isMarked(h20) ? va.e.h(this.getString(0x7F130C44), ", ") : "";  // string:talkback_selected "선택됨"
                        String s1 = this.getString(0x7F130C55);  // string:talkback_songlist_container "%1$s, 아티스트 %2$s"
                        q.f(s1, "getString(...)");
                        accessibilityNodeInfo0.setContentDescription(s + String.format(s1, Arrays.copyOf(new Object[]{o00.n.getText(), o00.j.getText()}, 2)));
                        accessibilityNodeInfo0.setHintText(this.getString(0x7F130C56));  // string:talkback_songlist_container_hint "두 번 탭하여 선택하거나 해제할 수 있습니다."
                        accessibilityNodeInfo0.setClassName("android.widget.Button");
                    }

                    @Override  // android.view.View$AccessibilityDelegate
                    public boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
                        q.g(view0, "host");
                        switch(v) {
                            case 100000001: {
                                ((DetailSongHolder)this.$viewHolder).itemView.performClick();
                                return true;
                            }
                            case 100000002: {
                                o00.c.performClick();
                                return true;
                            }
                            case 100000003: {
                                o00.h.a.performClick();
                                return true;
                            }
                            case 100000004: {
                                o00.b.performClick();
                                return true;
                            }
                            default: {
                                return super.performAccessibilityAction(view0, v, bundle0);
                            }
                        }
                    }
                });
            }
        }

        private static final void onBindViewImpl$lambda$8$lambda$7$lambda$0(DetailSongMetaContentBaseFragment detailSongMetaContentBaseFragment0, int v, String s, int v1, SongInfoBase songInfoBase0, View view0) {
            detailSongMetaContentBaseFragment0.onItemClick(view0, v);
            String s1 = "";
            if(s != null) {
                String s2 = songInfoBase0.songId == null ? "" : songInfoBase0.songId;
                String s3 = songInfoBase0.songName;
                if(s3 != null) {
                    s1 = s3;
                }
                detailSongMetaContentBaseFragment0.songItemInAlbumClickLog(s, v1 + 1, s2, s1);
                return;
            }
            detailSongMetaContentBaseFragment0.songItemClickLog(v1 + 1, (songInfoBase0.albumImg == null ? "" : songInfoBase0.albumImg), (songInfoBase0.songId == null ? "" : songInfoBase0.songId), (songInfoBase0.songName == null ? "" : songInfoBase0.songName), songInfoBase0.getArtistNames());
        }

        private static final boolean onBindViewImpl$lambda$8$lambda$7$lambda$1(SongInfoBase songInfoBase0, DetailAdapter detailSongMetaContentBaseFragment$DetailAdapter0, DetailSongMetaContentBaseFragment detailSongMetaContentBaseFragment0, int v, View view0) {
            Playable playable0 = Playable.from(songInfoBase0, detailSongMetaContentBaseFragment$DetailAdapter0.getMenuId(), detailSongMetaContentBaseFragment$DetailAdapter0.getStatsElements());
            if(MelonSettingInfo.isUseInstantPlay()) {
                detailSongMetaContentBaseFragment0.showInstantPlayPopup(playable0);
                return true;
            }
            detailSongMetaContentBaseFragment0.showContextPopupFromSong(playable0, v);
            return true;
        }

        private static final void onBindViewImpl$lambda$8$lambda$7$lambda$2(DetailSongMetaContentBaseFragment detailSongMetaContentBaseFragment0, DetailAdapter detailSongMetaContentBaseFragment$DetailAdapter0, int v, SongInfoBase songInfoBase0, String s, View view0) {
            if(q.b(detailSongMetaContentBaseFragment0.getContsTypeCode(), "N10082")) {
                AdapterInViewHolder.Row adapterInViewHolder$Row0 = (AdapterInViewHolder.Row)detailSongMetaContentBaseFragment$DetailAdapter0.getItem(v);
                String s1 = adapterInViewHolder$Row0 == null ? null : adapterInViewHolder$Row0.getContentId();
                if(s1 != null && s1.length() != 0) {
                    detailSongMetaContentBaseFragment0.playRadioCast(s1, detailSongMetaContentBaseFragment$DetailAdapter0.getMenuId(), songInfoBase0.songId, detailSongMetaContentBaseFragment$DetailAdapter0.getStatsElements());
                }
            }
            else {
                detailSongMetaContentBaseFragment0.playSong(Playable.from(songInfoBase0, detailSongMetaContentBaseFragment$DetailAdapter0.getMenuId(), detailSongMetaContentBaseFragment$DetailAdapter0.getStatsElements()), true);
            }
            String s2 = "";
            if(s != null) {
                String s3 = songInfoBase0.songId == null ? "" : songInfoBase0.songId;
                String s4 = songInfoBase0.songName;
                if(s4 != null) {
                    s2 = s4;
                }
                detailSongMetaContentBaseFragment0.songPlayInAlbumClickLog(s, v + 1, s3, s2);
                return;
            }
            detailSongMetaContentBaseFragment0.songPlayClickLog(v + 1, (songInfoBase0.albumImg == null ? "" : songInfoBase0.albumImg), (songInfoBase0.songId == null ? "" : songInfoBase0.songId), (songInfoBase0.songName == null ? "" : songInfoBase0.songName), songInfoBase0.getArtistNames(), (songInfoBase0.cType == null ? "" : songInfoBase0.cType));
        }

        private static final void onBindViewImpl$lambda$8$lambda$7$lambda$4$lambda$3(DetailSongMetaContentBaseFragment detailSongMetaContentBaseFragment0, SongInfoBase songInfoBase0, DetailAdapter detailSongMetaContentBaseFragment$DetailAdapter0, int v, String s, View view0) {
            detailSongMetaContentBaseFragment0.showContextPopupFromSong(Playable.from(songInfoBase0, detailSongMetaContentBaseFragment$DetailAdapter0.getMenuId(), detailSongMetaContentBaseFragment$DetailAdapter0.getStatsElements()), v);
            String s1 = "";
            if(s != null) {
                String s2 = songInfoBase0.songId == null ? "" : songInfoBase0.songId;
                String s3 = songInfoBase0.songName;
                if(s3 != null) {
                    s1 = s3;
                }
                detailSongMetaContentBaseFragment0.songMoreInAlbumClickLog(s, v + 1, s2, s1);
                return;
            }
            detailSongMetaContentBaseFragment0.songMoreClickLog(v + 1, (songInfoBase0.albumImg == null ? "" : songInfoBase0.albumImg), (songInfoBase0.songId == null ? "" : songInfoBase0.songId), (songInfoBase0.songName == null ? "" : songInfoBase0.songName), songInfoBase0.getArtistNames());
        }

        private static final void onBindViewImpl$lambda$8$lambda$7$lambda$5(DetailSongMetaContentBaseFragment detailSongMetaContentBaseFragment0, SongInfoBase songInfoBase0, int v, View view0) {
            detailSongMetaContentBaseFragment0.showAlbumInfoPage(songInfoBase0);
            detailSongMetaContentBaseFragment0.songThumbClickLog(v + 1, (songInfoBase0.albumImg == null ? "" : songInfoBase0.albumImg), (songInfoBase0.albumId == null ? "" : songInfoBase0.albumId), (songInfoBase0.albumName == null ? "" : songInfoBase0.albumName), songInfoBase0.getArtistNames());
        }

        private static final H onBindViewImpl$lambda$8$lambda$7$lambda$6(DetailAdapter detailSongMetaContentBaseFragment$DetailAdapter0, DetailSongMetaContentBaseFragment detailSongMetaContentBaseFragment0, int v, SongInfoBase songInfoBase0) {
            String s1;
            Builder viewImpContent$Builder0 = new Builder();
            StatsElementsBase statsElementsBase0 = detailSongMetaContentBaseFragment$DetailAdapter0.getStatsElements();
            String s = "";
            if(statsElementsBase0 == null) {
                s1 = "";
            }
            else {
                s1 = statsElementsBase0.impressionId;
                if(s1 == null) {
                    s1 = "";
                }
            }
            Builder viewImpContent$Builder1 = viewImpContent$Builder0.impId(s1);
            StatsElementsBase statsElementsBase1 = detailSongMetaContentBaseFragment$DetailAdapter0.getStatsElements();
            if(statsElementsBase1 != null) {
                String s2 = statsElementsBase1.impressionProvider;
                if(s2 != null) {
                    s = s2;
                }
            }
            StatsElementsBase statsElementsBase2 = detailSongMetaContentBaseFragment$DetailAdapter0.getStatsElements();
            ViewImpContent viewImpContent0 = viewImpContent$Builder1.impProvider(s).impType(detailSongMetaContentBaseFragment0.getString(0x7F130EBC)).impArea((statsElementsBase2 == null ? null : statsElementsBase2.rangeCode)).impOrdNum(String.valueOf(v + 1)).layer1(detailSongMetaContentBaseFragment0.getString(0x7F130DFF)).id(songInfoBase0.songId).type(detailSongMetaContentBaseFragment0.getString(0x7F130A63)).name(songInfoBase0.songName).build();  // string:tiara_imp_imp_type "vimp"
            q.f(viewImpContent0, "build(...)");
            OnImpLogListener onImpLogListener0 = detailSongMetaContentBaseFragment$DetailAdapter0.impLogListener;
            if(onImpLogListener0 != null) {
                onImpLogListener0.onImpLogListener(String.valueOf(v), viewImpContent0);
            }
            return H.a;
        }

        @Override  // com.iloen.melon.adapters.common.p
        @Nullable
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            switch(v) {
                case 0: {
                    return this.getSongListHeaderHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 1: {
                    h2 h20 = h2.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0);
                    return new DetailSongHolder(DetailSongMetaContentBaseFragment.this, h20, this.impLogListener);
                }
                case 3: {
                    return this.getVideoHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 5: {
                    return this.getMagazineHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 6: {
                    return this.getPlaylistHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 7: {
                    return this.getStationHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 8: {
                    return this.getTicketHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 9: {
                    return this.getCommentHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 10: {
                    return this.getLyricHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 11: {
                    return this.getCreditHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 13: {
                    return this.getArtistNoteHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 15: {
                    return this.getArtistInfoHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 16: {
                    return this.getArtistGroupHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 18: {
                    return this.getTagHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 19: {
                    return this.getPlaylistRelationContentHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 20: {
                    return this.getPhotoHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 4: 
                case 22: 
                case 23: {
                    return this.getAlbumHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 24: {
                    return this.getArtistAlbumHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 25: {
                    return this.getArtistArtistNoteHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 26: {
                    return this.getArtistPhotoLinearHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 27: {
                    return this.getArtistPhotoGridHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 28: {
                    return this.getPlaylistSeriesPlaylistHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 29: {
                    return this.getPlaylistRelationPlaylistHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 30: {
                    return this.getArtistHighlightHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 0x1F: {
                    return this.getArtistFanCmtShareHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 0x20: {
                    return this.getArtistMixUpHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 33: {
                    return this.getArtistBannerHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 34: {
                    return this.getArtistDailyReportHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 35: {
                    return this.getSongListFooterHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 36: {
                    return this.getPlaylistBannerHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 37: {
                    return this.getPlaylistBrandPlaylistHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 38: {
                    return this.getCDTitleHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 40: {
                    return this.getPlaylistMixHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 41: {
                    return this.getCommonContentsHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 42: {
                    return this.getArtistSongListHeaderHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 43: {
                    return this.getSongHistoryHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 44: {
                    return this.getEmptyCommentHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 45: {
                    return this.getStReportHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 46: 
                case 0x2F: {
                    return this.getOtherSongHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 0x30: {
                    return this.getSongListEtcHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 50: {
                    return this.getMelonHallHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 51: {
                    return this.getSongListEmptyHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 52: {
                    return this.getMelonTabTitleHolder(viewGroup0, this.onViewHolderActionListener);
                }
                case 53: {
                    return this.getArtistTopicHolder(viewGroup0, this.onViewHolderActionListener);
                }
                default: {
                    return FooterHolder.Companion.newInstance(viewGroup0);
                }
            }
        }

        public final void setImpLogListener(@NotNull OnImpLogListener onImpLogListener0) {
            q.g(onImpLogListener0, "listener");
            this.impLogListener = onImpLogListener0;
        }

        @Override  // com.iloen.melon.adapters.common.q
        public boolean setMarked(int v, @Nullable String s, boolean z) {
            Object object0 = this.getItem(v);
            if(object0 instanceof AdapterInViewHolder.Row && ((AdapterInViewHolder.Row)object0).getItem() instanceof SongInfoBase) {
                Object object1 = ((AdapterInViewHolder.Row)object0).getItem();
                q.e(object1, "null cannot be cast to non-null type com.melon.net.res.common.SongInfoBase");
                boolean z1 = ((SongInfoBase)object1).canService;
                boolean z2 = q.b(((SongInfoBase)object1).cType, "99");
                return (this.mEditMode || z1) && !z2 ? super.setMarked(v, s, z) : false;
            }
            return false;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001A\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\u0012\u001A\u00020\u00102\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u000E\u001A\u00020\r2\u000E\u0010\u0011\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000FH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$DetailSongHolder;", "Lcom/iloen/melon/fragments/main/common/ViewableCheckViewHolderForMelonBase;", "LJ8/h2;", "listitemSongNewBinding", "Lcom/iloen/melon/fragments/main/common/OnImpLogListener;", "onImpLogListener", "<init>", "(Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment;LJ8/h2;Lcom/iloen/melon/fragments/main/common/OnImpLogListener;)V", "Landroidx/fragment/app/I;", "getCurrentFragment", "()Landroidx/fragment/app/I;", "Landroid/view/View;", "targetView", "", "index", "Lkotlin/Function0;", "Lie/H;", "callback", "addAndStartViewableCheck", "(Landroid/view/View;ILwe/a;)V", "bind", "LJ8/h2;", "getBind", "()LJ8/h2;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class DetailSongHolder extends ViewableCheckViewHolderForMelonBase {
        @NotNull
        private final h2 bind;

        public DetailSongHolder(@NotNull h2 h20, @Nullable OnImpLogListener onImpLogListener0) {
            q.g(h20, "listitemSongNewBinding");
            DetailSongMetaContentBaseFragment.this = detailSongMetaContentBaseFragment0;
            LinearLayout linearLayout0 = h20.a;
            q.f(linearLayout0, "getRoot(...)");
            super(linearLayout0);
            this.bind = h20;
            q.f(linearLayout0, "getRoot(...)");
            Context context0 = linearLayout0.getContext();
            if(context0 != null) {
                int v = context0.getResources().getDimensionPixelSize(0x7F07045E);  // dimen:thumb_width_song
                ViewUtils.setDefaultImage(h20.h.c, v);
            }
            linearLayout0.addOnAttachStateChangeListener(this);
            this.setOnImpLogListener(onImpLogListener0);
        }

        @Override  // com.iloen.melon.fragments.main.common.ViewableCheckViewHolder
        public void addAndStartViewableCheck(@Nullable View view0, int v, @Nullable we.a a0) {
            if(this.hasViewableCheck(v)) {
                this.removeAllViewableCheck();
            }
            if(view0 != null && a0 != null) {
                com.iloen.melon.utils.viewable.ViewableCheck.Builder viewableCheck$Builder0 = new com.iloen.melon.utils.viewable.ViewableCheck.Builder(view0);
                viewableCheck$Builder0.setCallback(a0);
                viewableCheck$Builder0.setIgnoreIntersectionChecker(false);
                this.addViewableCheck(v, viewableCheck$Builder0.build());
                if(q.b(this.isForegroundFragment(), Boolean.TRUE)) {
                    this.viewableCheckStart(v);
                }
            }
        }

        @NotNull
        public final h2 getBind() {
            return this.bind;
        }

        @Override  // com.iloen.melon.fragments.main.common.ViewableCheckViewHolder
        @Nullable
        public I getCurrentFragment() {
            return null;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00102\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u0010B\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001D\u0010\n\u001A\u00020\t2\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\r\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u0003H\u0007¢\u0006\u0004\b\r\u0010\u000ER\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000F¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$FooterHolder;", "Lcom/iloen/melon/fragments/main/common/TabItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$FOOTER;", "Landroidx/compose/ui/platform/ComposeView;", "composeView", "<init>", "(Landroidx/compose/ui/platform/ComposeView;)V", "row", "Lie/H;", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "item", "Footer", "(Lcom/iloen/melon/net/v5x/response/MainMusicRes$RESPONSE$FOOTER;Landroidx/compose/runtime/l;I)V", "Landroidx/compose/ui/platform/ComposeView;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class FooterHolder extends TabItemViewHolder {
        @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$FooterHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$FooterHolder;", "parent", "Landroid/view/ViewGroup;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.FooterHolder.Companion {
            private com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.FooterHolder.Companion() {
            }

            public com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.FooterHolder.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public final FooterHolder newInstance(@NotNull ViewGroup viewGroup0) {
                q.g(viewGroup0, "parent");
                Context context0 = viewGroup0.getContext();
                q.f(context0, "getContext(...)");
                return new FooterHolder(new ComposeView(context0, null, 6, 0));
            }
        }

        public static final int $stable = 0;
        @NotNull
        public static final com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.FooterHolder.Companion Companion = null;
        @NotNull
        public static final String TAG = "FooterHolder";
        @NotNull
        private final ComposeView composeView;

        static {
            FooterHolder.Companion = new com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.FooterHolder.Companion(null);
            FooterHolder.$stable = 8;
        }

        public FooterHolder(@NotNull ComposeView composeView0) {
            q.g(composeView0, "composeView");
            super(composeView0);
            this.composeView = composeView0;
            this.itemView.addOnAttachStateChangeListener(this);
        }

        public final void Footer(@NotNull FOOTER mainMusicRes$RESPONSE$FOOTER0, @Nullable l l0, int v) {
            q.g(mainMusicRes$RESPONSE$FOOTER0, "item");
            p p0 = (p)l0;
            p0.c0(-1957897057);
            int v1 = (v & 6) == 0 ? (p0.i(mainMusicRes$RESPONSE$FOOTER0) ? 4 : 2) | v : v;
            if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
                r0.n n0 = r0.n.a;
                r0.q q0 = androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 83.0f), 0.0f, 19.0f, 0.0f, 0.0f, 13);
                y y0 = M.w.a(j.c, r0.d.n, p0, 0x30);
                int v2 = p0.P;
                i0 i00 = p0.m();
                r0.q q1 = r0.a.d(p0, q0);
                k.y.getClass();
                P0.i i0 = P0.j.b;
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                P0.h h0 = P0.j.f;
                androidx.compose.runtime.w.x(p0, y0, h0);
                P0.h h1 = P0.j.e;
                androidx.compose.runtime.w.x(p0, i00, h1);
                P0.h h2 = P0.j.g;
                if(p0.O || !q.b(p0.N(), v2)) {
                    d.q(v2, p0, v2, h2);
                }
                P0.h h3 = P0.j.d;
                androidx.compose.runtime.w.x(p0, q1, h3);
                r0.q q2 = r0.a.a(n0, new o() {
                    @Override  // we.o
                    public Object invoke(Object object0, Object object1, Object object2) {
                        return this.invoke(((r0.q)object0), ((l)object1), ((Number)object2).intValue());
                    }

                    public final r0.q invoke(r0.q q0, l l0, int v) {
                        q.g(q0, "$this$composed");
                        ((p)l0).a0(0x1FF03545);
                        w0.h h0 = (w0.h)((p)l0).k(k0.i);
                        m m0 = ((p)l0).N();
                        if(m0 == androidx.compose.runtime.k.a) {
                            m0 = androidx.appcompat.app.o.d(((p)l0));
                        }
                        X0.i i0 = new X0.i(mainMusicRes$RESPONSE$FOOTER0);
                        com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.FooterHolder.Footer.lambda.5..inlined.noRippleClickable-YQRRFTQ.default.1.1 detailSongMetaContentBaseFragment$FooterHolder$Footer$lambda$5$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new we.a() {
                            @Override  // we.a
                            public Object invoke() {
                                this.invoke();
                                return H.a;
                            }

                            public final void invoke() {
                                w0.h.a(this.$item$inlined);
                                MelonLinkExecutor.open(MelonLinkInfo.b(this.$item$inlined));
                            }
                        };
                        r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, null, 0, i0, detailSongMetaContentBaseFragment$FooterHolder$Footer$lambda$5$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                        ((p)l0).p(false);
                        return q1;
                    }
                });
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
                if(p0.O || !q.b(p0.N(), v3)) {
                    d.q(v3, p0, v3, h2);
                }
                androidx.compose.runtime.w.x(p0, q3, h3);
                String s = mainMusicRes$RESPONSE$FOOTER0.getText1();
                if(s == null) {
                    s = "";
                }
                N1.b(s, null, e0.T(p0, 0x7F060160), 11.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);  // color:gray600s_support_high_contrast
                r0.q q4 = androidx.compose.foundation.layout.d.n(n0, 14.0f);
                androidx.compose.foundation.q.c(De.I.Q(0x7F08008D, p0, 6), null, q4, null, null, 0.0f, new y0.k(e0.T(p0, 0x7F060159), 5), p0, 0x1B0, 56);  // drawable:arrow_common_menu
                p0.p(true);
                N1.b((mainMusicRes$RESPONSE$FOOTER0.getText2() == null ? "" : mainMusicRes$RESPONSE$FOOTER0.getText2()), androidx.compose.foundation.layout.a.n(n0, 0.0f, 7.0f, 0.0f, 0.0f, 13), e0.T(p0, 0x7F06015D), 11.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);  // color:gray500s_support_high_contrast
                p0.p(true);
            }
            else {
                p0.T();
            }
            androidx.compose.runtime.n0 n00 = p0.t();
            if(n00 != null) {
                n00.d = new U(this, mainMusicRes$RESPONSE$FOOTER0, v, 9);
            }
        }

        private static final H Footer$lambda$6(FooterHolder detailSongMetaContentBaseFragment$FooterHolder0, FOOTER mainMusicRes$RESPONSE$FOOTER0, int v, l l0, int v1) {
            detailSongMetaContentBaseFragment$FooterHolder0.Footer(mainMusicRes$RESPONSE$FOOTER0, l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
            return H.a;
        }

        @NotNull
        public static final FooterHolder newInstance(@NotNull ViewGroup viewGroup0) {
            return FooterHolder.Companion.newInstance(viewGroup0);
        }

        public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
            q.g(adapterInViewHolder$Row0, "row");
            super.onBindView(adapterInViewHolder$Row0);
            FOOTER mainMusicRes$RESPONSE$FOOTER0 = (FOOTER)adapterInViewHolder$Row0.getItem();
            if(mainMusicRes$RESPONSE$FOOTER0 != null) {
                m0.b b0 = new m0.b(0x9EB210B1, new com.iloen.melon.fragments.i(this, mainMusicRes$RESPONSE$FOOTER0), true);
                this.composeView.setContent(b0);
            }
        }

        @Override  // com.iloen.melon.fragments.main.common.TabItemViewHolder
        public void onBindView(Object object0) {
            this.onBindView(((AdapterInViewHolder.Row)object0));
        }

        private static final H onBindView$lambda$2$lambda$1$lambda$0(FooterHolder detailSongMetaContentBaseFragment$FooterHolder0, FOOTER mainMusicRes$RESPONSE$FOOTER0, l l0, int v) {
            if(((p)l0).Q(v & 1, (v & 3) != 2)) {
                detailSongMetaContentBaseFragment$FooterHolder0.Footer(mainMusicRes$RESPONSE$FOOTER0, ((p)l0), 0);
                return H.a;
            }
            ((p)l0).T();
            return H.a;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0096\u0004\u0018\u00002\u00020\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001A\u00020\u00062\b\u0010\t\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\n\u0010\bJ#\u0010\r\u001A\u00020\u00062\b\u0010\u000B\u001A\u0004\u0018\u00010\u00042\b\u0010\f\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0019\u0010\u0010\u001A\u00020\u00062\b\u0010\u000F\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u0010\u0010\bJ\u0019\u0010\u0011\u001A\u00020\u00062\b\u0010\u000F\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u0011\u0010\bJ\u000F\u0010\u0012\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0012\u001A\u00020\u00062\u0006\u0010\u0015\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0016J7\u0010 \u001A\u00020\u00062\u0006\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0019\u001A\u00020\u00172\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001F\u001A\u00020\u001EH\u0016\u00A2\u0006\u0004\b \u0010!J\u001F\u0010\"\u001A\u00020\u00062\u0006\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0019\u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\b\"\u0010#J\u000F\u0010$\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b$\u0010\u0013J\u001F\u0010%\u001A\u00020\u00062\u0006\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0019\u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\b%\u0010#J\u001F\u0010&\u001A\u00020\u00062\u0006\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0019\u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\b&\u0010#J\u001F\u0010\'\u001A\u00020\u00062\u0006\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0019\u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\b\'\u0010#J\u001F\u0010(\u001A\u00020\u00062\u0006\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0019\u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\b(\u0010#J/\u0010+\u001A\u00020\u00062\u0006\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0019\u001A\u00020\u00172\u0006\u0010)\u001A\u00020\u001A2\u0006\u0010*\u001A\u00020\u001AH\u0016\u00A2\u0006\u0004\b+\u0010,\u00A8\u0006-"}, d2 = {"Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "<init>", "(Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment;)V", "", "songId", "Lie/H;", "onPlaySongListener", "(Ljava/lang/String;)V", "albumId", "onPlayAlbumListener", "plylstSeq", "contsTypeCode", "onPlayDjPlaylistListener", "(Ljava/lang/String;Ljava/lang/String;)V", "castSeq", "onPlayRadioCast", "onOpenCastEpisodeDetailView", "onOpenCommentListView", "()V", "Lcom/iloen/melon/fragments/comments/CmtListFragment$Param;", "param", "(Lcom/iloen/melon/fragments/comments/CmtListFragment$Param;)V", "", "adapterPos", "dataPos", "", "recom", "Landroid/widget/TextView;", "view", "Lcom/iloen/melon/custom/RecommenderView;", "recommenderView", "onCommentRecommendListener", "(IIZLandroid/widget/TextView;Lcom/iloen/melon/custom/RecommenderView;)V", "onOpenUserView", "(II)V", "onOpenCommentWriteView", "onOpenAdCommentView", "onOpenCommentEditView", "onCommentRemoveListener", "onCommentReportListener", "isEditable", "isFanTalk", "onShowContextPopupCommentMore", "(IIZZ)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public class OnViewHolderActionListener implements OnViewHolderActionBaseListener {
        @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
        public void onAlbumPlayListener(@NotNull String s) {
            OnViewHolderActionBaseListener.super.onAlbumPlayListener(s);
        }

        @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
        public void onAllSelectListener(boolean z) {
            OnViewHolderActionBaseListener.super.onAllSelectListener(z);
        }

        @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
        public boolean onCheckLoginListener() {
            return OnViewHolderActionBaseListener.super.onCheckLoginListener();
        }

        @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
        public void onCommentRecommendListener(int v, int v1, boolean z, @NotNull TextView textView0, @NotNull RecommenderView recommenderView0) {
            q.g(textView0, "view");
            q.g(recommenderView0, "recommenderView");
            DetailSongMetaContentBaseFragment.this.getCommentActionListener().onCommentRecommendListener(v, v1, z, textView0, recommenderView0);
        }

        @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
        public void onCommentRemoveListener(int v, int v1) {
            DetailSongMetaContentBaseFragment.this.getCommentActionListener().onCommentRemoveListener(v, v1);
        }

        @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
        public void onCommentReportListener(int v, int v1) {
            DetailSongMetaContentBaseFragment.this.getCommentActionListener().onCommentReportListener(v, v1);
        }

        @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
        public void onDownloadSong() {
            OnViewHolderActionBaseListener.super.onDownloadSong();
        }

        @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
        public void onItemLikeListener(@NotNull String s, @NotNull String s1, boolean z, int v) {
            OnViewHolderActionBaseListener.super.onItemLikeListener(s, s1, z, v);
        }

        @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
        public void onLikedListener(@NotNull CheckableImageView checkableImageView0, @NotNull TextView textView0) {
            OnViewHolderActionBaseListener.super.onLikedListener(checkableImageView0, textView0);
        }

        @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
        public void onLyricUpdateMsgListener(@NotNull String s) {
            OnViewHolderActionBaseListener.super.onLyricUpdateMsgListener(s);
        }

        @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
        public void onMoveToScoll(int v) {
            OnViewHolderActionBaseListener.super.onMoveToScoll(v);
        }

        @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
        public void onOpenAdCommentView(int v, int v1) {
            DetailSongMetaContentBaseFragment.this.getCommentActionListener().onOpenAdCommentView(v, v1);
        }

        @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
        public void onOpenCastEpisodeDetailView(@Nullable String s) {
            DetailSongMetaContentBaseFragment.this.openCastEpisodeDetailView(s);
        }

        @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
        public void onOpenCommentEditView(int v, int v1) {
            DetailSongMetaContentBaseFragment.this.getCommentActionListener().onOpenCommentEditView(v, v1);
        }

        @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
        public void onOpenCommentListView() {
            CMTCONTSSUMM informCmtContsSummRes$result$CMTCONTSSUMM0 = DetailSongMetaContentBaseFragment.this.getInformCmt();
            if(informCmtContsSummRes$result$CMTCONTSSUMM0 != null && informCmtContsSummRes$result$CMTCONTSSUMM0.newFlag) {
                CMTCONTSSUMM informCmtContsSummRes$result$CMTCONTSSUMM1 = DetailSongMetaContentBaseFragment.this.getInformCmt();
                if(informCmtContsSummRes$result$CMTCONTSSUMM1 != null) {
                    informCmtContsSummRes$result$CMTCONTSSUMM1.newFlag = false;
                }
            }
            DetailSongMetaContentBaseFragment.this.getCommentActionListener().onOpenCommentListView();
        }

        @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
        public void onOpenCommentListView(@NotNull Param cmtListFragment$Param0) {
            q.g(cmtListFragment$Param0, "param");
            CMTCONTSSUMM informCmtContsSummRes$result$CMTCONTSSUMM0 = DetailSongMetaContentBaseFragment.this.getInformCmt();
            if(informCmtContsSummRes$result$CMTCONTSSUMM0 != null && informCmtContsSummRes$result$CMTCONTSSUMM0.newFlag) {
                CMTCONTSSUMM informCmtContsSummRes$result$CMTCONTSSUMM1 = DetailSongMetaContentBaseFragment.this.getInformCmt();
                if(informCmtContsSummRes$result$CMTCONTSSUMM1 != null) {
                    informCmtContsSummRes$result$CMTCONTSSUMM1.newFlag = false;
                }
            }
            DetailSongMetaContentBaseFragment.this.getCommentActionListener().onOpenCommentListView(cmtListFragment$Param0);
        }

        @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
        public void onOpenCommentWriteView() {
            DetailSongMetaContentBaseFragment.this.getCommentActionListener().onOpenCommentWriteView();
        }

        @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
        public void onOpenUserView(int v, int v1) {
            DetailSongMetaContentBaseFragment.this.getCommentActionListener().onOpenUserView(v, v1);
        }

        @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
        public void onPerformBackPress() {
            OnViewHolderActionBaseListener.super.onPerformBackPress();
        }

        @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
        public void onPlayAlbumListener(@Nullable String s) {
            String s1 = DetailSongMetaContentBaseFragment.this.getMenuId();
            DetailSongMetaContentBaseFragment.this.playAlbum(s, s1);
        }

        @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
        public void onPlayArtistMixUp() {
            OnViewHolderActionBaseListener.super.onPlayArtistMixUp();
        }

        @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
        public void onPlayBtnListener(@Nullable Playable playable0) {
            OnViewHolderActionBaseListener.super.onPlayBtnListener(playable0);
        }

        @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
        public void onPlayDjPlaylistListener(@Nullable String s, @Nullable String s1) {
            String s2 = DetailSongMetaContentBaseFragment.this.getMenuId();
            DetailSongMetaContentBaseFragment.this.playPlaylist(s, s1, s2, null);
        }

        @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
        public void onPlayForUSongListener(@Nullable String s, @Nullable String s1, @Nullable StatsElementsBase statsElementsBase0) {
            OnViewHolderActionBaseListener.super.onPlayForUSongListener(s, s1, statsElementsBase0);
        }

        @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
        public void onPlayRadioCast(@Nullable String s) {
            String s1 = DetailSongMetaContentBaseFragment.this.getMenuId();
            DetailSongMetaContentBaseFragment.this.playRadioCast(s, s1, null);
        }

        @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
        public void onPlaySongListener(@Nullable String s) {
            String s1 = DetailSongMetaContentBaseFragment.this.getMenuId();
            DetailSongMetaContentBaseFragment.this.playSong(s, s1);
        }

        @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
        public void onPlaySongsListener(@NotNull ArrayList arrayList0, boolean z) {
            OnViewHolderActionBaseListener.super.onPlaySongsListener(arrayList0, z);
        }

        @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
        public void onRequestFanListener(@NotNull String s, boolean z) {
            OnViewHolderActionBaseListener.super.onRequestFanListener(s, z);
        }

        @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
        public void onSetBtnAll(@NotNull CheckableTextView checkableTextView0) {
            OnViewHolderActionBaseListener.super.onSetBtnAll(checkableTextView0);
        }

        @Override  // com.iloen.melon.fragments.comments.OnCommentActionListener
        public void onShowContextPopupCommentMore(int v, int v1, boolean z, boolean z1) {
            DetailSongMetaContentBaseFragment.this.getCommentActionListener().onShowContextPopupCommentMore(v, v1, z, z1);
        }

        @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
        public void onShowNoFanPopupListener() {
            OnViewHolderActionBaseListener.super.onShowNoFanPopupListener();
        }

        @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
        public void onShowSharePopupListener() {
            OnViewHolderActionBaseListener.super.onShowSharePopupListener();
        }

        @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
        public void onSongListFooterRemoveCheck() {
            OnViewHolderActionBaseListener.super.onSongListFooterRemoveCheck();
        }

        @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
        public boolean onSongListMore() {
            return OnViewHolderActionBaseListener.super.onSongListMore();
        }

        @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
        public void onSongListViewAll() {
            OnViewHolderActionBaseListener.super.onSongListViewAll();
        }

        @Override  // com.iloen.melon.fragments.OnViewHolderActionBaseListener
        @Nullable
        public p8.f onTiaraEventBuilder() {
            return OnViewHolderActionBaseListener.super.onTiaraEventBuilder();
        }
    }

    public static final int $stable = 0;
    private static final int ALBUM_MAX_LINE = 2;
    @NotNull
    public static final String ARG_APP_BAR_OFFSET = "argAppBarOffset";
    public static final int BOTTOM_BTN_TYPE_ADD_SONG = 10000;
    public static final int BOTTOM_BTN_TYPE_MIX_UP_PLAY = 10004;
    public static final int BOTTOM_BTN_TYPE_PLAY_ALL_SONG = 10002;
    public static final int BOTTOM_BTN_TYPE_PLAY_SONG = 10003;
    public static final int BOTTOM_BTN_TYPE_SHUFFLE = 10001;
    @NotNull
    public static final Companion Companion = null;
    private static final int SONG_MAX_LINE = 3;
    @NotNull
    public static final String TAG = "DetailSongMetaContentBaseFragment";
    public static final int TALKBACK_ACTION_ALBUM_DETAIL = 100000003;
    public static final int TALKBACK_ACTION_DEFAULT = 100000000;
    public static final int TALKBACK_ACTION_MENU_MORE = 100000004;
    public static final int TALKBACK_ACTION_PLAYBACK = 100000002;
    public static final int TALKBACK_ACTION_SELECT_SONG = 100000001;
    public static final int VIEW_TYPE_ALBUM = 4;
    public static final int VIEW_TYPE_ALBUM_INTRODUCE = 14;
    public static final int VIEW_TYPE_ALBUM_OTHER = 23;
    public static final int VIEW_TYPE_ALBUM_SERIES = 22;
    public static final int VIEW_TYPE_ARTIST_ALBUM = 24;
    public static final int VIEW_TYPE_ARTIST_ARTIST_NOTE = 25;
    public static final int VIEW_TYPE_ARTIST_BANNER = 33;
    public static final int VIEW_TYPE_ARTIST_DAILY_REPORT = 34;
    public static final int VIEW_TYPE_ARTIST_FAN_CMT_SHARE = 0x1F;
    public static final int VIEW_TYPE_ARTIST_GROUP = 16;
    public static final int VIEW_TYPE_ARTIST_HIGHLIGHT = 30;
    public static final int VIEW_TYPE_ARTIST_INFO = 15;
    public static final int VIEW_TYPE_ARTIST_MIX_UP = 0x20;
    public static final int VIEW_TYPE_ARTIST_NOTE = 13;
    public static final int VIEW_TYPE_ARTIST_PHOTO_GRID = 27;
    public static final int VIEW_TYPE_ARTIST_PHOTO_LINEAR = 26;
    public static final int VIEW_TYPE_ARTIST_SONG_LIST_HEADER = 42;
    public static final int VIEW_TYPE_CD_LIST_TITLE = 38;
    public static final int VIEW_TYPE_COMMENT = 9;
    public static final int VIEW_TYPE_COMMON_CONTENTS = 41;
    public static final int VIEW_TYPE_CREDIT = 11;
    public static final int VIEW_TYPE_DAILY_REPORT = 17;
    public static final int VIEW_TYPE_EMPTY_COMMENT = 44;
    public static final int VIEW_TYPE_LYRIC = 10;
    public static final int VIEW_TYPE_MAGAZINE = 5;
    public static final int VIEW_TYPE_MAGAZINE_LAND = 100;
    public static final int VIEW_TYPE_MELON_HALL = 50;
    public static final int VIEW_TYPE_MELON_TAB_TITLE = 52;
    public static final int VIEW_TYPE_OTHER_SONG = 0x2F;
    public static final int VIEW_TYPE_PHOTO = 20;
    public static final int VIEW_TYPE_PLAYLIST = 6;
    public static final int VIEW_TYPE_PLAYLIST_BANNER = 36;
    public static final int VIEW_TYPE_PLAYLIST_BRAND = 37;
    public static final int VIEW_TYPE_PLAYLIST_MIX = 40;
    public static final int VIEW_TYPE_PLAYLIST_RELATION = 29;
    public static final int VIEW_TYPE_PLAYLIST_SERIES = 28;
    public static final int VIEW_TYPE_RELATION_CONTENT = 19;
    public static final int VIEW_TYPE_REPORT = 12;
    public static final int VIEW_TYPE_SIMILAR_SONG = 46;
    public static final int VIEW_TYPE_SONG = 2;
    public static final int VIEW_TYPE_SONG_HISTORY = 43;
    public static final int VIEW_TYPE_SONG_LIST = 1;
    public static final int VIEW_TYPE_SONG_LIST_EMPTY = 51;
    public static final int VIEW_TYPE_SONG_LIST_ETC = 0x30;
    public static final int VIEW_TYPE_SONG_LIST_FOOTER = 35;
    public static final int VIEW_TYPE_SONG_LIST_HEADER = 0;
    public static final int VIEW_TYPE_STATION = 7;
    public static final int VIEW_TYPE_STREAMING_REPORT = 45;
    public static final int VIEW_TYPE_TAG = 18;
    public static final int VIEW_TYPE_TICKET = 8;
    public static final int VIEW_TYPE_TOPIC = 53;
    public static final int VIEW_TYPE_VIDEO = 3;
    @Nullable
    private m0 _binding;
    @Nullable
    private Q4.a _headerBinding;
    private int appBarOffset;
    @Nullable
    private HashMap cmtPositionInfoHashMap;
    @NotNull
    private final ie.j commentActionImpl$delegate;
    @NotNull
    private final ie.j commentViewModel$delegate;
    @Nullable
    private FrameLayout detailHeaderContainer;
    private int duplicatedOffsetCnt;
    @Nullable
    private CMTCONTSSUMM informCmt;
    private boolean isFetchStart;
    private boolean isForegroundFragment;
    private boolean isRequestRecmDone;
    @NotNull
    private final HashSet onStateChangeListenerHashSet;
    private int prevAppBarOffset;
    private int prevOrientation;
    @Nullable
    private RESPONSE realTimeLikeInfoRes;
    @NotNull
    private final HashMap tiaraViewImpMap;
    @Nullable
    private Response userActionsRes;

    static {
        DetailSongMetaContentBaseFragment.Companion = new Companion(null);
        DetailSongMetaContentBaseFragment.$stable = 8;
    }

    public DetailSongMetaContentBaseFragment() {
        this.tiaraViewImpMap = new HashMap();
        this.onStateChangeListenerHashSet = new HashSet();
        this.isRequestRecmDone = true;
        this.prevAppBarOffset = 0x7FFFFFFF;
        this.commentViewModel$delegate = d3.g.Q(new com.iloen.melon.fragments.b(this, 0));
        this.commentActionImpl$delegate = d3.g.Q(new com.iloen.melon.fragments.b(this, 1));
    }

    public void addAll() {
    }

    private final int addBottomBtnView(BottomBtnInfo detailSongMetaContentBaseFragment$BottomBtnInfo0, BottomBtnClickListener detailSongMetaContentBaseFragment$BottomBtnClickListener0) {
        m0 m00 = this._binding;
        if(m00 != null) {
            View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0442, m00.c.c, false);  // layout:layout_song_meta_bottom_btn_container
            m00.c.c.addView(view0);
            MelonTextView melonTextView0 = (MelonTextView)De.I.C(view0, 0x7F0A0C29);  // id:tv_bottom_button
            if(melonTextView0 == null) {
                throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(0x7F0A0C29));  // id:tv_bottom_button
            }
            ((ConstraintLayout)view0).setId(View.generateViewId());
            boolean z = true;
            boolean z1 = detailSongMetaContentBaseFragment$BottomBtnInfo0.getText() == null;
            int v = 0x7F080405;  // drawable:ic_common_play_01
            switch(detailSongMetaContentBaseFragment$BottomBtnInfo0.getBtnType()) {
                case 10000: {
                    ((ConstraintLayout)view0).setOnClickListener(new c(detailSongMetaContentBaseFragment$BottomBtnClickListener0, 0));
                    if(z1) {
                        detailSongMetaContentBaseFragment$BottomBtnInfo0.setText("담기");
                    }
                    v = 0x7F0803D6;  // drawable:ic_common_add_01
                    z = false;
                    break;
                }
                case 10001: {
                    ((ConstraintLayout)view0).setOnClickListener(new c(detailSongMetaContentBaseFragment$BottomBtnClickListener0, 3));
                    if(z1) {
                        detailSongMetaContentBaseFragment$BottomBtnInfo0.setText("셔플");
                    }
                    v = 0x7F08040E;  // drawable:ic_common_shuffle_01
                    break;
                }
                case 10002: {
                    ((ConstraintLayout)view0).setOnClickListener(new c(detailSongMetaContentBaseFragment$BottomBtnClickListener0, 1));
                    if(z1) {
                        detailSongMetaContentBaseFragment$BottomBtnInfo0.setText("전체");
                    }
                    break;
                }
                case 10003: {
                    ((ConstraintLayout)view0).setOnClickListener(new c(detailSongMetaContentBaseFragment$BottomBtnClickListener0, 4));
                    if(z1) {
                        detailSongMetaContentBaseFragment$BottomBtnInfo0.setText("재생");
                    }
                    break;
                }
                case 10004: {
                    ((ConstraintLayout)view0).setOnClickListener(new c(detailSongMetaContentBaseFragment$BottomBtnClickListener0, 2));
                    if(z1) {
                        detailSongMetaContentBaseFragment$BottomBtnInfo0.setText("믹스업");
                    }
                    v = 0x7F080154;  // drawable:btn_common_mixup_16
                    z = false;
                    break;
                }
                default: {
                    v = -1;
                }
            }
            melonTextView0.setText(detailSongMetaContentBaseFragment$BottomBtnInfo0.getText());
            if(v != -1) {
                melonTextView0.setCompoundDrawablesWithIntrinsicBounds(v, 0, 0, 0);
                String s = detailSongMetaContentBaseFragment$BottomBtnInfo0.getText();
                if(s == null || s.length() == 0) {
                    melonTextView0.setCompoundDrawablePadding(0);
                }
                if(z) {
                    a.a.O(melonTextView0, ColorUtils.getColor(melonTextView0.getContext(), 0x7F06016D));  // color:gray900s
                }
                ViewUtilsKt.setAccessibilityButtonClassName(melonTextView0);
            }
            return ((ConstraintLayout)view0).getId();
        }
        return -1;
    }

    private static final void addBottomBtnView$lambda$10(BottomBtnClickListener detailSongMetaContentBaseFragment$BottomBtnClickListener0, View view0) {
        if(detailSongMetaContentBaseFragment$BottomBtnClickListener0 != null) {
            detailSongMetaContentBaseFragment$BottomBtnClickListener0.onPlayAllSongClick();
        }
    }

    private static final void addBottomBtnView$lambda$11(BottomBtnClickListener detailSongMetaContentBaseFragment$BottomBtnClickListener0, View view0) {
        if(detailSongMetaContentBaseFragment$BottomBtnClickListener0 != null) {
            detailSongMetaContentBaseFragment$BottomBtnClickListener0.onMixUpPlayClick();
        }
    }

    private static final void addBottomBtnView$lambda$12(BottomBtnClickListener detailSongMetaContentBaseFragment$BottomBtnClickListener0, View view0) {
        if(detailSongMetaContentBaseFragment$BottomBtnClickListener0 != null) {
            detailSongMetaContentBaseFragment$BottomBtnClickListener0.onShuffleSongClick();
        }
    }

    private static final void addBottomBtnView$lambda$13(BottomBtnClickListener detailSongMetaContentBaseFragment$BottomBtnClickListener0, View view0) {
        if(detailSongMetaContentBaseFragment$BottomBtnClickListener0 != null) {
            detailSongMetaContentBaseFragment$BottomBtnClickListener0.onPlaySongClick();
        }
    }

    private static final void addBottomBtnView$lambda$9(BottomBtnClickListener detailSongMetaContentBaseFragment$BottomBtnClickListener0, View view0) {
        if(detailSongMetaContentBaseFragment$BottomBtnClickListener0 != null) {
            detailSongMetaContentBaseFragment$BottomBtnClickListener0.onAddSongClick();
        }
    }

    @Override  // com.iloen.melon.fragments.main.common.OnImpLogListener
    public void addOnStateChangeListener(@NotNull OnStateChangeListener viewableCheckViewHolder$OnStateChangeListener0) {
        q.g(viewableCheckViewHolder$OnStateChangeListener0, "listener");
        synchronized(this.onStateChangeListenerHashSet) {
            this.onStateChangeListenerHashSet.add(viewableCheckViewHolder$OnStateChangeListener0);
        }
    }

    private final void alignBottomBtnViews(List list0, int v) {
        m0 m00 = this._binding;
        if(m00 != null) {
            ConstraintLayout constraintLayout0 = m00.c.c;
            androidx.constraintlayout.widget.n n0 = new androidx.constraintlayout.widget.n();
            n0.f(constraintLayout0);
            int v1 = 0;
            for(Object object0: list0) {
                if(v1 >= 0) {
                    int v2 = ((BottomBtnInfo)object0).getViewId();
                    int v3 = v1 == 0 ? 0 : ((BottomBtnInfo)list0.get(v1 - 1)).getViewId();
                    int v4 = v1 == e.k.s(list0) ? 0 : ((BottomBtnInfo)list0.get(v1 + 1)).getViewId();
                    int v5 = 7;
                    int v6 = 7;
                    if(v3 == 0) {
                        v5 = 6;
                    }
                    if(v4 != 0) {
                        v6 = 6;
                    }
                    n0.i(v2, 6, v3, v5, 0);
                    n0.i(v2, 7, v4, v6, (v1 == list0.size() - 1 ? 0 : v));
                    n0.l(v2).e.c = ScreenUtils.dipToPixel(this.getContext(), ((BottomBtnInfo)object0).getWidth());
                    ++v1;
                    continue;
                }
                e.k.O();
                throw null;
            }
            n0.b(constraintLayout0);
        }
    }

    public final void bottomButtonEnable(boolean z) {
        m0 m00 = this._binding;
        if(m00 != null) {
            J8.n0 n00 = m00.c;
            if(n00 != null) {
                ConstraintLayout constraintLayout0 = n00.c;
                if(constraintLayout0 != null) {
                    Y y0 = new Y(constraintLayout0, 0);
                    while(y0.hasNext()) {
                        Object object0 = y0.next();
                        View view0 = (View)object0;
                        View view1 = null;
                        if(!z) {
                            view0.setOnClickListener(null);
                        }
                        ConstraintLayout constraintLayout1 = view0 instanceof ConstraintLayout ? ((ConstraintLayout)view0) : null;
                        if(constraintLayout1 != null) {
                            view1 = constraintLayout1.getChildAt(0);
                        }
                        ViewUtils.setEnable(view1, z);
                    }
                }
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public ToolBar buildToolBar() {
        return ToolBar.f(((ToolBar)this.getBinding().i.c), 1000);
    }

    private static final DetailCommentActionImpl commentActionImpl_delegate$lambda$1(DetailSongMetaContentBaseFragment detailSongMetaContentBaseFragment0) {
        return new DetailCommentActionImpl(detailSongMetaContentBaseFragment0);
    }

    private static final CommentViewModel commentViewModel_delegate$lambda$0(DetailSongMetaContentBaseFragment detailSongMetaContentBaseFragment0) {
        q.g(detailSongMetaContentBaseFragment0, "owner");
        q0 q00 = detailSongMetaContentBaseFragment0.getViewModelStore();
        o0 o00 = detailSongMetaContentBaseFragment0.getDefaultViewModelProviderFactory();
        S2.c c0 = detailSongMetaContentBaseFragment0.getDefaultViewModelCreationExtras();
        q.g(q00, "store");
        q.g(o00, "factory");
        o9.b b0 = com.iloen.melon.utils.a.p(c0, "defaultCreationExtras", q00, o00, c0);
        De.d d0 = df.d.y(CommentViewModel.class);
        String s = d0.l();
        if(s == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (CommentViewModel)b0.s(d0, "androidx.lifecycle.ViewModelProvider.DefaultKey:" + s);
    }

    public static void d0(TextView textView0, int v, View view0, String s, DetailSongMetaContentBaseFragment detailSongMetaContentBaseFragment0, int v1) {
        DetailSongMetaContentBaseFragment.setDescText$lambda$39(textView0, v, view0, s, detailSongMetaContentBaseFragment0, v1);
    }

    public void drawHeader() {
        this.setTitleBar(((TitleBar)this.getBinding().h.c));
        this.setTitleBarCommonButtonEventListener(this.getTitleBar());
        int v = 0;
        boolean z = this.getInsetHandlingType() == f1.b;
        if(z) {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.getTitleBar().getLayoutParams();
            q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).topMargin = ScreenUtils.getStatusBarHeight(this.getContext());
            m0 m00 = this.getBinding();
            int v1 = this.getResources().getDimensionPixelSize(0x7F07046D);  // dimen:top_container_height
            int v2 = ScreenUtils.getStatusBarHeight(this.getContext());
            m00.e.setMinimumHeight(v2 + v1);
            this.getTitleBar().setBackgroundColor(0);
        }
        this._headerBinding = this.onCreateHeaderLayout();
        ViewGroup.LayoutParams viewGroup$LayoutParams1 = this.getBinding().f.getLayoutParams();
        q.e(viewGroup$LayoutParams1, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        if(!z) {
            v = this.getCollapseToolbarHeight();
        }
        ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams1).topMargin = v;
        this.getBinding().f.setLayoutParams(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams1));
        FrameLayout frameLayout0 = this.getBinding().f;
        this.detailHeaderContainer = frameLayout0;
        if(frameLayout0 != null) {
            frameLayout0.removeAllViews();
        }
        FrameLayout frameLayout1 = this.detailHeaderContainer;
        if(frameLayout1 != null) {
            frameLayout1.addView((this._headerBinding == null ? null : this._headerBinding.getRoot()));
        }
    }

    @Nullable
    public List getAllSongList() {
        return null;
    }

    public final int getAppBarOffset() {
        return this.appBarOffset;
    }

    @NotNull
    public final m0 getBinding() {
        m0 m00 = this._binding;
        q.d(m00);
        return m00;
    }

    @NotNull
    public abstract BottomBtnData getBottomBtnData();

    @Nullable
    public final J8.n0 getBottomButton() {
        return this._binding == null ? null : this._binding.c;
    }

    @Override  // com.iloen.melon.fragments.comments.CommentLatestList
    @NotNull
    public CmtResViewModel getCmtResViewModel(@NotNull LoadPgnRes loadPgnRes0, @NotNull ListCmtRes listCmtRes0) {
        q.g(loadPgnRes0, "loadPgnRes");
        q.g(listCmtRes0, "cmtRes");
        return this.getCommentActionImpl().getCmtResViewModel(loadPgnRes0, listCmtRes0);
    }

    public int getCollapseToolbarHeight() {
        Context context0 = this.getContext();
        if(context0 != null) {
            Resources resources0 = context0.getResources();
            return resources0 == null ? 0 : resources0.getDimensionPixelSize(0x7F07046D);  // dimen:top_container_height
        }
        return 0;
    }

    @Override  // com.iloen.melon.fragments.comments.CommentLatestList
    @NotNull
    public CommentActionImpl getCommentActionImpl() {
        return (CommentActionImpl)this.commentActionImpl$delegate.getValue();
    }

    @Override  // com.iloen.melon.fragments.comments.CommentLatestList
    @NotNull
    public CommentActionImpl getCommentActionListener() {
        return this.getCommentActionImpl();
    }

    @Override  // com.iloen.melon.fragments.comments.CommentLatestList
    public int getCommentAdapterPosition() {
        j0 j00 = this.getAdapter();
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.DetailAdapter");
        return ((DetailAdapter)j00).getCount() - 1;
    }

    @Override  // com.iloen.melon.fragments.comments.CommentLatestList
    @NotNull
    public CommentViewModel getCommentViewModel() {
        return (CommentViewModel)this.commentViewModel$delegate.getValue();
    }

    @NotNull
    public abstract String getContsId();

    @NotNull
    public abstract String getContsTypeCode();

    @Override  // kotlinx.coroutines.CoroutineScope
    @NotNull
    public abstract me.i getCoroutineContext();

    @NotNull
    public String getDetailCacheKey() [...] // 潜在的解密器

    @Nullable
    public final FrameLayout getDetailHeader() {
        return this._binding == null ? null : this._binding.f;
    }

    @Nullable
    public final CMTCONTSSUMM getInformCmt() {
        return this.informCmt;
    }

    public final void getLikeCountFromServerInRealTimeAndUpdateUi() {
        BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getMain().plus(new CoroutineExceptionHandler(/*ERROR_MISSING_ARG_0/*) {
            @Override  // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(me.i i0, Throwable throwable0) {
                LogU.Companion.e("DetailSongMetaContentBaseFragment", "getLikeCountFromServerInRealTimeAndUpdateUi() exceptionHandler = " + throwable0);
            }
        }), null, new we.n(null) {
            Object L$0;
            Object L$1;
            int label;

            {
                DetailSongMetaContentBaseFragment.this = detailSongMetaContentBaseFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.getLikeCountFromServerInRealTimeAndUpdateUi.1(DetailSongMetaContentBaseFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.getLikeCountFromServerInRealTimeAndUpdateUi.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        Params myMusicLikeInformContentsLikeReq$Params0 = new Params();
                        myMusicLikeInformContentsLikeReq$Params0.contsId = DetailSongMetaContentBaseFragment.this.getContsId();
                        myMusicLikeInformContentsLikeReq$Params0.contsTypeCode = DetailSongMetaContentBaseFragment.this.getContsTypeCode();
                        myMusicLikeInformContentsLikeReq$Params0.actTypeCode = "N20001";
                        Deferred deferred0 = DetailSongMetaContentBaseFragment.this.requestLikeCountFromServerAsync(myMusicLikeInformContentsLikeReq$Params0);
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 1;
                        object0 = deferred0.await(this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        Deferred deferred1 = (Deferred)this.L$1;
                        Params myMusicLikeInformContentsLikeReq$Params1 = (Params)this.L$0;
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                if(((MyMusicLikeInformContentsLikeRes)object0) != null) {
                    Cb.j.b(((MyMusicLikeInformContentsLikeRes)object0).notification, false, 3);
                    if(Cb.j.d(((MyMusicLikeInformContentsLikeRes)object0))) {
                        RESPONSE myMusicLikeInformContentsLikeRes$RESPONSE0 = ((MyMusicLikeInformContentsLikeRes)object0).response;
                        if(myMusicLikeInformContentsLikeRes$RESPONSE0 != null) {
                            DetailSongMetaContentBaseFragment.this.setRealTimeLikeInfoRes(myMusicLikeInformContentsLikeRes$RESPONSE0);
                            boolean z = ProtocolUtils.parseBoolean(myMusicLikeInformContentsLikeRes$RESPONSE0.likeyn);
                            Integer integer0 = new Integer(ProtocolUtils.parseInt(myMusicLikeInformContentsLikeRes$RESPONSE0.summcnt, 0));
                            DetailSongMetaContentBaseFragment.this.updateLikeView(integer0, z);
                        }
                    }
                }
                return H.a;
            }
        }, 2, null);
    }

    @NotNull
    public OnViewHolderActionListener getOnViewHolderActionListener() {
        return new OnViewHolderActionListener(this);
    }

    @Nullable
    public final RESPONSE getRealTimeLikeInfoRes() {
        return this.realTimeLikeInfoRes;
    }

    @Nullable
    public StatsElementsBase getStatsElements() {
        return null;
    }

    @NotNull
    public String getTiaraImpArea() [...] // 潜在的解密器

    @Nullable
    public final Object getUserActionsFromServerAndUpdateUi(@NotNull Continuation continuation0) {
        BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO().plus(new CoroutineExceptionHandler(/*ERROR_MISSING_ARG_0/*) {
            @Override  // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(me.i i0, Throwable throwable0) {
                LogU.Companion.e("DetailSongMetaContentBaseFragment", "getUserActionsFromServerAndUpdateUi() exceptionHandler = " + throwable0);
            }
        }), null, new we.n(null) {
            int I$0;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;

            {
                DetailSongMetaContentBaseFragment.this = detailSongMetaContentBaseFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.getUserActionsFromServerAndUpdateUi.2(DetailSongMetaContentBaseFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.getUserActionsFromServerAndUpdateUi.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.net.v4x.request.UserActionsReq.Params userActionsReq$Params1 = new com.iloen.melon.net.v4x.request.UserActionsReq.Params();
                        userActionsReq$Params1.fields = "like";
                        userActionsReq$Params1.contsTypeCode = DetailSongMetaContentBaseFragment.this.getContsTypeCode();
                        userActionsReq$Params1.contsId = DetailSongMetaContentBaseFragment.this.getContsId();
                        Deferred deferred1 = DetailSongMetaContentBaseFragment.this.requestUserActionAsync(userActionsReq$Params1);
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 1;
                        object0 = deferred1.await(this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        Deferred deferred2 = (Deferred)this.L$1;
                        com.iloen.melon.net.v4x.request.UserActionsReq.Params userActionsReq$Params2 = (com.iloen.melon.net.v4x.request.UserActionsReq.Params)this.L$0;
                        d5.n.D(object0);
                        break;
                    }
                    case 2: {
                        Response userActionsRes$Response0 = (Response)this.L$3;
                        UserActionsRes userActionsRes0 = (UserActionsRes)this.L$2;
                        Deferred deferred0 = (Deferred)this.L$1;
                        com.iloen.melon.net.v4x.request.UserActionsReq.Params userActionsReq$Params0 = (com.iloen.melon.net.v4x.request.UserActionsReq.Params)this.L$0;
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                if(((UserActionsRes)object0) != null) {
                    Cb.j.b(((UserActionsRes)object0).notification, false, 3);
                    if(Cb.j.d(((UserActionsRes)object0))) {
                        Response userActionsRes$Response1 = ((UserActionsRes)object0).response;
                        if(userActionsRes$Response1 != null) {
                            DetailSongMetaContentBaseFragment.this.setUserActionsRes(userActionsRes$Response1);
                            com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.getUserActionsFromServerAndUpdateUi.2.2.1 detailSongMetaContentBaseFragment$getUserActionsFromServerAndUpdateUi$2$2$10 = new we.n(null) {
                                int label;

                                {
                                    DetailSongMetaContentBaseFragment.this = detailSongMetaContentBaseFragment0;
                                    super(2, continuation0);
                                }

                                @Override  // oe.a
                                public final Continuation create(Object object0, Continuation continuation0) {
                                    return new com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.getUserActionsFromServerAndUpdateUi.2.2.1(DetailSongMetaContentBaseFragment.this, continuation0);
                                }

                                @Override  // we.n
                                public Object invoke(Object object0, Object object1) {
                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                }

                                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                    return ((com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.getUserActionsFromServerAndUpdateUi.2.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                }

                                @Override  // oe.a
                                public final Object invokeSuspend(Object object0) {
                                    if(this.label != 0) {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                    d5.n.D(object0);
                                    DetailSongMetaContentBaseFragment.this.updateLikeBtn(DetailSongMetaContentBaseFragment.this.getUserActionsRes());
                                    return H.a;
                                }
                            };
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.I$0 = 0;
                            this.label = 2;
                            if(BuildersKt.withContext(Dispatchers.getMain(), detailSongMetaContentBaseFragment$getUserActionsFromServerAndUpdateUi$2$2$10, this) == a0) {
                                return a0;
                            }
                        }
                    }
                }
                return H.a;
            }
        }, 2, null);
        return H.a;
    }

    @Nullable
    public final Response getUserActionsRes() {
        return this.userActionsRes;
    }

    @Nullable
    public final Q4.a get_headerBinding() {
        return this._headerBinding;
    }

    private final void initBottomButton(BottomBtnData detailSongMetaContentBaseFragment$BottomBtnData0, boolean z) {
        for(Object object0: detailSongMetaContentBaseFragment$BottomBtnData0.getBottomBtnInfoList()) {
            ((BottomBtnInfo)object0).setViewId(this.addBottomBtnView(((BottomBtnInfo)object0), detailSongMetaContentBaseFragment$BottomBtnData0.getBottomBtnClickListener()));
        }
        this.alignBottomBtnViews(detailSongMetaContentBaseFragment$BottomBtnData0.getBottomBtnInfoList(), ScreenUtils.dipToPixel(this.getContext(), detailSongMetaContentBaseFragment$BottomBtnData0.getSpaceBetweenWidth()));
        m0 m00 = this._binding;
        if(m00 != null) {
            J8.n0 n00 = m00.c;
            if(n00 != null) {
                View view0 = n00.e;
                if(view0 != null) {
                    view0.setVisibility((z ? 0 : 8));
                }
            }
        }
    }

    public final boolean isFetchStart() {
        return this.isFetchStart;
    }

    @Override  // com.iloen.melon.fragments.main.common.OnImpLogListener
    public boolean isForegroundFragment() {
        return this.isForegroundFragment;
    }

    public void likeClickLog(boolean z) {
    }

    public final void moveToScroll(int v) {
        m0 m00 = this._binding;
        if(m00 != null) {
            RecyclerView recyclerView0 = m00.j;
            if(recyclerView0 != null) {
                recyclerView0.scrollToPosition(v);
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    @Nullable
    public List onAddSongsToPlaylist(@Nullable String s, @Nullable String s1) {
        v9.m m0 = this.getMarkedList(false);
        if(m0.a) {
            List list0 = new ArrayList();
            String s2 = this.getContsTypeCode();
            if(q.b(s2, "N10005") || q.b(s2, "N10009") || q.b(s2, "N10016")) {
                MyMusicPlaylistPlayListSongRes myMusicPlaylistPlayListSongRes0 = this.requestStreamGetMyPlaylistInfo(this.getContsId());
                if(myMusicPlaylistPlayListSongRes0 != null) {
                    Cb.j.b(myMusicPlaylistPlayListSongRes0.notification, false, 3);
                    if(Cb.j.d(myMusicPlaylistPlayListSongRes0)) {
                        if(myMusicPlaylistPlayListSongRes0.response == null) {
                            ToastManager.showShort(0x7F130023);  // string:add_available_empty "담기 가능한 곡이 없습니다."
                        }
                        ArrayList arrayList0 = myMusicPlaylistPlayListSongRes0.response.songList;
                        if(arrayList0 == null || arrayList0.isEmpty()) {
                            ToastManager.showShort(0x7F130023);  // string:add_available_empty "담기 가능한 곡이 없습니다."
                        }
                        if(arrayList0 != null) {
                            for(Object object1: arrayList0) {
                                SONGLIST playlistListSongBaseRes$RESPONSE$SONGLIST0 = (SONGLIST)object1;
                                if(playlistListSongBaseRes$RESPONSE$SONGLIST0.canService) {
                                    ((ArrayList)list0).add(Song.a(playlistListSongBaseRes$RESPONSE$SONGLIST0));
                                }
                            }
                        }
                    }
                }
            }
            else {
                List list1 = this.getAllSongList();
                if(list1 != null) {
                    for(Object object0: list1) {
                        ((ArrayList)list0).add(Song.a(((SongInfoBase)object0)));
                    }
                    return list0;
                }
            }
            return list0;
        }
        ArrayList arrayList1 = new ArrayList();
        if(m0.a) {
            List list2 = this.getWeakMarkedList();
            q.f(list2, "getWeakMarkedList(...)");
            arrayList1.addAll(list2);
        }
        else {
            q.f(m0.d, "markedList");
            arrayList1.addAll(m0.d);
        }
        j0 j00 = this.getAdapter();
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.adapters.common.MetaInfoAdapter");
        return ((s)j00).getSongsFromPositionIndices(arrayList1);
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onAddToNowPlayingList(@Nullable Object object0) {
        if(this.getMarkedList(false).a) {
            this.addAll();
            return;
        }
        super.onAddToNowPlayingList(object0);
    }

    public abstract void onAppBarCollapsed();

    public abstract void onAppBarExpended();

    public void onAppBarScrolling(int v) {
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        if(this.useDrawHeaderWhenConfigurationChange()) {
            this._headerBinding = null;
            this.drawHeader();
        }
        if(configuration0.orientation != this.prevOrientation) {
            this.moveToScroll(0);
            this.getBinding().b.setExpanded(true);
        }
        this.prevOrientation = configuration0.orientation;
    }

    @NotNull
    public abstract Q4.a onCreateHeaderLayout();

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public RecyclerView onCreateRecyclerView() {
        DetailAdapter detailSongMetaContentBaseFragment$DetailAdapter0 = this.mAdapter instanceof DetailAdapter ? ((DetailAdapter)this.mAdapter) : null;
        if(detailSongMetaContentBaseFragment$DetailAdapter0 != null) {
            detailSongMetaContentBaseFragment$DetailAdapter0.setImpLogListener(this);
        }
        m0 m00 = this._binding;
        if(m00 != null) {
            RecyclerView recyclerView0 = m00.j;
            if(recyclerView0 != null) {
                recyclerView0.setLayoutManager(new LinearLayoutManager(recyclerView0.getContext()));
                recyclerView0.setAdapter(this.mAdapter);
                recyclerView0.setHasFixedSize(false);
                return recyclerView0;
            }
        }
        return null;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D0226, viewGroup0, false);  // layout:detail_song_base_fragment
        int v = 0x7F0A00AB;  // id:appbar_layout
        View view1 = De.I.C(view0, 0x7F0A00AB);  // id:appbar_layout
        if(((AppBarLayout)view1) != null) {
            v = 0x7F0A0116;  // id:bottom_button
            View view2 = De.I.C(view0, 0x7F0A0116);  // id:bottom_button
            if(view2 != null) {
                int v1 = 0x7F0A01A9;  // id:btn_select_all
                View view3 = De.I.C(view2, 0x7F0A01A9);  // id:btn_select_all
                if(((CheckableTextView)view3) == null || ((RelativeLayout)De.I.C(view2, 0x7F0A034B)) == null) {  // id:count_container
                    throw new NullPointerException("Missing required view with ID: " + view2.getResources().getResourceName(v1));
                }
                v1 = 0x7F0A036E;  // id:ctl_button_container
                View view4 = De.I.C(view2, 0x7F0A036E);  // id:ctl_button_container
                if(((ConstraintLayout)view4) == null) {
                    throw new NullPointerException("Missing required view with ID: " + view2.getResources().getResourceName(v1));
                }
                v1 = 0x7F0A0627;  // id:iv_dot
                View view5 = De.I.C(view2, 0x7F0A0627);  // id:iv_dot
                if(view5 == null) {
                    throw new NullPointerException("Missing required view with ID: " + view2.getResources().getResourceName(v1));
                }
                v1 = 0x7F0A08FF;  // id:parallax_space_view
                View view6 = De.I.C(view2, 0x7F0A08FF);  // id:parallax_space_view
                if(view6 == null) {
                    throw new NullPointerException("Missing required view with ID: " + view2.getResources().getResourceName(v1));
                }
                v1 = 0x7F0A0A58;  // id:select_container
                View view7 = De.I.C(view2, 0x7F0A0A58);  // id:select_container
                if(((RelativeLayout)view7) == null) {
                    throw new NullPointerException("Missing required view with ID: " + view2.getResources().getResourceName(v1));
                }
                v1 = 0x7F0A0AAD;  // id:song_list_header
                View view8 = De.I.C(view2, 0x7F0A0AAD);  // id:song_list_header
                if(((ConstraintLayout)view8) == null) {
                    throw new NullPointerException("Missing required view with ID: " + view2.getResources().getResourceName(v1));
                }
                v1 = 0x7F0A0AC5;  // id:space_view
                View view9 = De.I.C(view2, 0x7F0A0AC5);  // id:space_view
                if(view9 == null) {
                    throw new NullPointerException("Missing required view with ID: " + view2.getResources().getResourceName(v1));
                }
                v1 = 0x7F0A0C9D;  // id:tv_list_cnt
                View view10 = De.I.C(view2, 0x7F0A0C9D);  // id:tv_list_cnt
                if(((MelonTextView)view10) == null) {
                    throw new NullPointerException("Missing required view with ID: " + view2.getResources().getResourceName(v1));
                }
                v1 = 0x7F0A0CA2;  // id:tv_list_play_time
                View view11 = De.I.C(view2, 0x7F0A0CA2);  // id:tv_list_play_time
                if(((MelonTextView)view11) == null) {
                    throw new NullPointerException("Missing required view with ID: " + view2.getResources().getResourceName(v1));
                }
                J8.n0 n00 = new J8.n0(((ConstraintLayout)view2), ((CheckableTextView)view3), ((ConstraintLayout)view4), view5, view6, ((RelativeLayout)view7), ((ConstraintLayout)view8), view9, ((MelonTextView)view10), ((MelonTextView)view11));
                v = 0x7F0A011A;  // id:bottom_divider
                View view12 = De.I.C(view0, 0x7F0A011A);  // id:bottom_divider
                if(view12 != null && ((FrameLayout)De.I.C(view0, 0x7F0A012C)) != null) {  // id:bottom_tab_error_layout_container
                    v = 0x7F0A02DD;  // id:collapsing_toolbar_layout
                    View view13 = De.I.C(view0, 0x7F0A02DD);  // id:collapsing_toolbar_layout
                    if(((CollapsingToolbarLayout)view13) != null && ((CoordinatorLayout)De.I.C(view0, 0x7F0A0348)) != null) {  // id:coordinator_layout
                        v = 0x7F0A03BA;  // id:detail_header
                        View view14 = De.I.C(view0, 0x7F0A03BA);  // id:detail_header
                        if(((FrameLayout)view14) != null) {
                            v = 0x7F0A056A;  // id:include_empty_or_error_layout
                            View view15 = De.I.C(view0, 0x7F0A056A);  // id:include_empty_or_error_layout
                            if(view15 != null) {
                                int v2 = 0x7F0A0567;  // id:include_adapter_empty_view
                                View view16 = De.I.C(view15, 0x7F0A0567);  // id:include_adapter_empty_view
                                if(view16 == null) {
                                    throw new NullPointerException("Missing required view with ID: " + view15.getResources().getResourceName(v2));
                                }
                                J8.a a0 = J8.a.a(view16);
                                View view17 = De.I.C(view15, 0x7F0A0568);  // id:include_adapter_network_error_view
                                if(view17 == null) {
                                    v2 = 0x7F0A0568;  // id:include_adapter_network_error_view
                                    throw new NullPointerException("Missing required view with ID: " + view15.getResources().getResourceName(v2));
                                }
                                J8.x x0 = new J8.x(((RelativeLayout)view15), a0, J8.b.a(view17), 1);
                                v = 0x7F0A056C;  // id:include_titlebar
                                View view18 = De.I.C(view0, 0x7F0A056C);  // id:include_titlebar
                                if(view18 != null) {
                                    J8.b b0 = new J8.b(((TitleBar)view18), ((TitleBar)view18), 12);
                                    v = 0x7F0A056D;  // id:include_toolbar_layout
                                    View view19 = De.I.C(view0, 0x7F0A056D);  // id:include_toolbar_layout
                                    if(view19 != null) {
                                        J8.b b1 = new J8.b(((ToolBar)view19), ((ToolBar)view19), 13);
                                        v = 0x7F0A09D1;  // id:recycler_view
                                        View view20 = De.I.C(view0, 0x7F0A09D1);  // id:recycler_view
                                        if(((RecyclerView)view20) != null) {
                                            v = 0x7F0A0B9E;  // id:title_layout
                                            View view21 = De.I.C(view0, 0x7F0A0B9E);  // id:title_layout
                                            if(((LinearLayout)view21) != null) {
                                                this._binding = new m0(((FrameLayout)view0), ((AppBarLayout)view1), n00, view12, ((CollapsingToolbarLayout)view13), ((FrameLayout)view14), x0, b0, b1, ((RecyclerView)view20), ((LinearLayout)view21));
                                                return this.getBinding().a;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onDestroyView() {
        super.onDestroyView();
        this._headerBinding = null;
        this._binding = null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(@Nullable EventComment eventComment0) {
        if(eventComment0 != null) {
            this.updateCommentItem(eventComment0);
        }
    }

    @Override  // com.iloen.melon.fragments.main.common.OnImpLogListener
    public void onImpLogListener(@NotNull String s, @NotNull ViewImpContent viewImpContent0) {
        q.g(s, "key");
        q.g(viewImpContent0, "viewImpContent");
        synchronized(this.tiaraViewImpMap) {
            Integer integer0 = Integer.parseInt(s);
            ViewImpContent viewImpContent1 = (ViewImpContent)this.tiaraViewImpMap.put(integer0, viewImpContent0);
        }
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onPause() {
        super.onPause();
        this.setSelectAllWithToolbar(false);
        this.duplicatedOffsetCnt = 0;
    }

    public void onPreFetchStart(@NotNull i i0) {
        q.g(i0, "type");
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        this.appBarOffset = bundle0.getInt("argAppBarOffset");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putInt("argAppBarOffset", this.appBarOffset);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onStart() {
        super.onStart();
        this.isForegroundFragment = true;
        this.startViewableCheck();
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onStop() {
        super.onStop();
        this.isForegroundFragment = false;
        this.tiaraViewImpMapFlush();
        this.stopViewableCheck();
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onToolBarClick(@Nullable ToolBarItem toolBar$ToolBarItem0, int v) {
        super.onToolBarClick(toolBar$ToolBarItem0, v);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        int v;
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.drawHeader();
        Context context0 = this.getContext();
        if(context0 == null) {
            v = 0;
        }
        else {
            Resources resources0 = context0.getResources();
            if(resources0 == null) {
                v = 0;
            }
            else {
                Configuration configuration0 = resources0.getConfiguration();
                v = configuration0 == null ? 0 : configuration0.orientation;
            }
        }
        this.prevOrientation = v;
        m0 m00 = this.getBinding();
        q.f(m00.g, "includeEmptyOrErrorLayout");
        int v1 = ColorUtils.getColor(this.getContext(), 0x7F0604A1);  // color:white000e
        ((J8.a)m00.g.c).f.setBackgroundColor(v1);
        int v2 = ColorUtils.getColor(this.getContext(), 0x7F0604A1);  // color:white000e
        ((LinearLayout)((J8.b)m00.g.d).c).setBackgroundColor(v2);
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.getBinding().b.getLayoutParams();
        q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        Behavior appBarLayout$Behavior0 = (Behavior)((androidx.coordinatorlayout.widget.c)viewGroup$LayoutParams0).a;
        if(appBarLayout$Behavior0 != null) {
            appBarLayout$Behavior0.z(this.appBarOffset);
        }
        m0 m01 = this.getBinding();
        com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.onViewCreated.1 detailSongMetaContentBaseFragment$onViewCreated$10 = new AppBarStateChangeListener() {
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
            public static final class WhenMappings {
                public static final int[] $EnumSwitchMapping$0;

                static {
                    int[] arr_v = new int[State.values().length];
                    try {
                        arr_v[State.COLLAPSED.ordinal()] = 1;
                    }
                    catch(NoSuchFieldError unused_ex) {
                    }
                    WhenMappings.$EnumSwitchMapping$0 = arr_v;
                }
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$AppBarStateChangeListener
            public void onOffsetChanged(AppBarLayout appBarLayout0, int v) {
                q.g(appBarLayout0, "appBarLayout");
                super.onOffsetChanged(appBarLayout0, v);
                if(v == DetailSongMetaContentBaseFragment.this.prevAppBarOffset) {
                    ++DetailSongMetaContentBaseFragment.this.duplicatedOffsetCnt;
                }
                else {
                    DetailSongMetaContentBaseFragment.this.duplicatedOffsetCnt = 1;
                }
                if(DetailSongMetaContentBaseFragment.this.duplicatedOffsetCnt > 1) {
                    return;
                }
                DetailSongMetaContentBaseFragment.this.prevAppBarOffset = v;
                DetailSongMetaContentBaseFragment.this.onAppBarScrolling(v);
                DetailSongMetaContentBaseFragment.this.setAppBarOffset(v);
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$AppBarStateChangeListener
            public void onStateChanged(AppBarLayout appBarLayout0, State detailSongMetaContentBaseFragment$AppBarStateChangeListener$State0) {
                if((detailSongMetaContentBaseFragment$AppBarStateChangeListener$State0 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[detailSongMetaContentBaseFragment$AppBarStateChangeListener$State0.ordinal()]) == 1) {
                    DetailSongMetaContentBaseFragment.this.onAppBarCollapsed();
                    return;
                }
                DetailSongMetaContentBaseFragment.this.onAppBarExpended();
            }
        };
        m01.b.a(detailSongMetaContentBaseFragment$onViewCreated$10);
        if(this.useBottomButton()) {
            this.initBottomButton(this.getBottomBtnData(), this.showSpaceViewBottomButtonParallax());
        }
        m0 m02 = this.getBinding();
        q.f(m02.b, "appbarLayout");
        m02.b.setOutlineProvider(null);
        this.registerCommentViewModelObserver();
    }

    private final void openCastEpisodeDetailView(String s) {
        if(s == null || s.length() == 0 || !this.isFragmentValid()) {
            return;
        }
        Navigator.INSTANCE.openCastEpisodeDetail(s);
    }

    @Override  // com.iloen.melon.fragments.comments.CommentLatestList
    public void registerCommentViewModelObserver() {
        this.getCommentViewModel().getInformCmtContsSum().observe(this.getViewLifecycleOwner(), new DetailSongMetaContentBaseFragment.sam.androidx_lifecycle_Observer.0(new com.iloen.melon.fragments.d(this, 0)));
        this.getCommentViewModel().getCommentData().observe(this.getViewLifecycleOwner(), new DetailSongMetaContentBaseFragment.sam.androidx_lifecycle_Observer.0(new com.iloen.melon.fragments.d(this, 1)));
        Q1.c.R(this, "comment_request_key", new com.iloen.melon.fragments.e(this));
    }

    private static final H registerCommentViewModelObserver$lambda$2(DetailSongMetaContentBaseFragment detailSongMetaContentBaseFragment0, InformCmtContsSummRes informCmtContsSummRes0) {
        detailSongMetaContentBaseFragment0.updateCommentCountView(informCmtContsSummRes0);
        return H.a;
    }

    private static final H registerCommentViewModelObserver$lambda$3(DetailSongMetaContentBaseFragment detailSongMetaContentBaseFragment0, CommentData commentData0) {
        detailSongMetaContentBaseFragment0.updateCommentListView(commentData0.getLoadPgnRes(), commentData0.getListCmtRes());
        return H.a;
    }

    private static final H registerCommentViewModelObserver$lambda$4(DetailSongMetaContentBaseFragment detailSongMetaContentBaseFragment0, String s, Bundle bundle0) {
        q.g(s, "<unused var>");
        q.g(bundle0, "bundle");
        EventComment eventComment0 = (EventComment)CompatUtils.getSerializable(bundle0, "data", EventComment.class);
        if(eventComment0 != null) {
            detailSongMetaContentBaseFragment0.updateCommentItem(eventComment0);
        }
        return H.a;
    }

    @Override  // com.iloen.melon.fragments.main.common.OnImpLogListener
    public void removeOnStateChangeListener(@NotNull OnStateChangeListener viewableCheckViewHolder$OnStateChangeListener0) {
        q.g(viewableCheckViewHolder$OnStateChangeListener0, "listener");
        synchronized(this.onStateChangeListenerHashSet) {
            this.onStateChangeListenerHashSet.remove(viewableCheckViewHolder$OnStateChangeListener0);
        }
    }

    @Override  // com.iloen.melon.fragments.comments.CommentLatestList
    public void requestCommentApis(@NotNull String s, @NotNull String s1, boolean z) {
        q.g(s, "bbsChannelSeq");
        q.g(s1, "bbsContsRefValue");
        CommentViewModel commentViewModel0 = this.getCommentViewModel();
        String s2 = this.getRequestTag();
        q.f(s2, "getRequestTag(...)");
        commentViewModel0.initParam(s2, s, s1);
        if(z) {
            this.getCommentViewModel().requestCountAndStatus();
        }
        this.getCommentViewModel().requestList();
    }

    private final Deferred requestLikeCountFromServerAsync(Params myMusicLikeInformContentsLikeReq$Params0) {
        return BuildersKt__Builders_commonKt.async$default(this, null, null, new we.n(myMusicLikeInformContentsLikeReq$Params0, null) {
            final Params $params;
            int label;

            {
                DetailSongMetaContentBaseFragment.this = detailSongMetaContentBaseFragment0;
                this.$params = myMusicLikeInformContentsLikeReq$Params0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.requestLikeCountFromServerAsync.1(DetailSongMetaContentBaseFragment.this, this.$params, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.requestLikeCountFromServerAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                RequestFuture requestFuture0 = RequestFuture.newFuture();
                HttpResponse httpResponse0 = RequestBuilder.newInstance(new MyMusicLikeInformContentsLikeReq(DetailSongMetaContentBaseFragment.this.getContext(), this.$params)).tag(DetailSongMetaContentBaseFragment.this.getRequestTag()).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v4x.response.MyMusicLikeInformContentsLikeRes");
                return (MyMusicLikeInformContentsLikeRes)httpResponse0;
            }
        }, 3, null);
    }

    private final MyMusicPlaylistPlayListSongRes requestStreamGetMyPlaylistInfo(String s) {
        RequestFuture requestFuture0 = RequestFuture.newFuture();
        return (MyMusicPlaylistPlayListSongRes)RequestBuilder.newInstance(new MyMusicPlaylistPlayListSongReq(this.getContext(), s)).tag("DetailSongMetaContentBaseFragment").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
    }

    private final Deferred requestUserActionAsync(com.iloen.melon.net.v4x.request.UserActionsReq.Params userActionsReq$Params0) {
        return BuildersKt__Builders_commonKt.async$default(this, null, null, new we.n(userActionsReq$Params0, null) {
            final com.iloen.melon.net.v4x.request.UserActionsReq.Params $params;
            int label;

            {
                DetailSongMetaContentBaseFragment.this = detailSongMetaContentBaseFragment0;
                this.$params = userActionsReq$Params0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.requestUserActionAsync.1(DetailSongMetaContentBaseFragment.this, this.$params, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.requestUserActionAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                RequestFuture requestFuture0 = RequestFuture.newFuture();
                HttpResponse httpResponse0 = RequestBuilder.newInstance(new UserActionsReq(DetailSongMetaContentBaseFragment.this.getContext(), this.$params)).tag(DetailSongMetaContentBaseFragment.this.getRequestTag()).listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v4x.response.UserActionsRes");
                return (UserActionsRes)httpResponse0;
            }
        }, 3, null);
    }

    public final void setAppBarOffset(int v) {
        this.appBarOffset = v;
    }

    private final void setDescText(TextView textView0, View view0, String s, int v, int v1) {
        if(v1 > 5) {
            textView0.setMaxLines(v);
            return;
        }
        textView0.post(new W0(textView0, v, view0, s, this, v1, 1));
    }

    public final void setDescText(@NotNull String s, @NotNull String s1) {
        q.g(s, "desc");
        q.g(s1, "contsType");
        Q4.a a0 = this._headerBinding;
        if(a0 != null && (a0 instanceof a3 || a0 instanceof J8.d)) {
            View view0 = a0.getRoot().findViewById(0x7F0A03A7);  // id:desc_container
            View view1 = a0.getRoot().findViewById(0x7F0A03AA);  // id:desc_long_container
            View view2 = a0.getRoot().findViewById(0x7F0A03AD);  // id:desc_short_container
            View view3 = a0.getRoot().findViewById(0x7F0A03AB);  // id:desc_more
            MelonTextView melonTextView0 = (MelonTextView)a0.getRoot().findViewById(0x7F0A03A9);  // id:desc_long
            View view4 = a0.getRoot().findViewById(0x7F0A03AC);  // id:desc_short
            ((RelativeLayout)view0).setVisibility(0);
            ((MelonTextView)view4).setText(s);
            melonTextView0.setText(s);
            int v = s1.equals("N10001") ? 3 : 2;
            q.d(((LinearLayout)view3));
            this.setDescText(((MelonTextView)view4), ((LinearLayout)view3), s, v, 0);
            ((RelativeLayout)view2).setOnClickListener(new com.iloen.melon.fragments.a(((LinearLayout)view3), ((RelativeLayout)view0), ((RelativeLayout)view2), ((RelativeLayout)view1), 0));
        }
    }

    private static final void setDescText$lambda$38$lambda$37(LinearLayout linearLayout0, RelativeLayout relativeLayout0, RelativeLayout relativeLayout1, RelativeLayout relativeLayout2, View view0) {
        if(linearLayout0.getVisibility() == 0) {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = relativeLayout0.getLayoutParams();
            q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ((LayoutParams)viewGroup$LayoutParams0).Q = 0x7FFFFFFF;
            relativeLayout1.setVisibility(8);
            relativeLayout2.setVisibility(0);
        }
    }

    private static final void setDescText$lambda$39(TextView textView0, int v, View view0, String s, DetailSongMetaContentBaseFragment detailSongMetaContentBaseFragment0, int v1) {
        try {
            if(textView0.getLineCount() <= v) {
                switch(textView0.getLineCount()) {
                    case 1: {
                        textView0.setLines(1);
                        return;
                    }
                    case 2: {
                        textView0.setLines(2);
                        return;
                    }
                    default: {
                        return;
                    }
                }
            }
            view0.setVisibility(0);
            int v2 = textView0.getLayout().getLineEnd(v - 1);
            if(v2 < s.length()) {
                String s1 = s.substring(0, v2);
                q.f(s1, "substring(...)");
                textView0.setText(s1);
                detailSongMetaContentBaseFragment0.setDescText(textView0, view0, s1, v, v1 + 1);
            }
        }
        catch(Exception unused_ex) {
        }
    }

    public final void setFetchStart(boolean z) {
        this.isFetchStart = z;
    }

    public final void setInformCmt(@Nullable CMTCONTSSUMM informCmtContsSummRes$result$CMTCONTSSUMM0) {
        this.informCmt = informCmtContsSummRes$result$CMTCONTSSUMM0;
    }

    public final void setRealTimeLikeInfoRes(@Nullable RESPONSE myMusicLikeInformContentsLikeRes$RESPONSE0) {
        this.realTimeLikeInfoRes = myMusicLikeInformContentsLikeRes$RESPONSE0;
    }

    public final void setUserActionsRes(@Nullable Response userActionsRes$Response0) {
        this.userActionsRes = userActionsRes$Response0;
    }

    public final void set_headerBinding(@Nullable Q4.a a0) {
        this._headerBinding = a0;
    }

    public void showContextPopupFromSong(@Nullable Playable playable0, int v) {
        this.showContextPopupSong(playable0);
    }

    public void showNetworkErrorHeaderView(boolean z) {
        BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getMain(), null, new we.n(z, null) {
            final boolean $isVisible;
            int label;

            {
                DetailSongMetaContentBaseFragment.this = detailSongMetaContentBaseFragment0;
                this.$isVisible = z;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.showNetworkErrorHeaderView.1(DetailSongMetaContentBaseFragment.this, this.$isVisible, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.showNetworkErrorHeaderView.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                m0 m00 = DetailSongMetaContentBaseFragment.this._binding;
                int v = 0;
                if(m00 != null) {
                    J8.n0 n00 = m00.c;
                    if(n00 != null) {
                        ConstraintLayout constraintLayout0 = n00.a;
                        if(constraintLayout0 != null) {
                            constraintLayout0.setVisibility((this.$isVisible ? 8 : 0));
                        }
                    }
                }
                DetailSongMetaContentBaseFragment.this.getTitleBar().setVisibility((this.$isVisible ? 8 : 0));
                Q4.a a0 = DetailSongMetaContentBaseFragment.this.get_headerBinding();
                if(a0 != null) {
                    View view0 = a0.getRoot();
                    if(view0 != null) {
                        if(this.$isVisible) {
                            v = 8;
                        }
                        view0.setVisibility(v);
                    }
                }
                return H.a;
            }
        }, 2, null);
    }

    public boolean showSpaceViewBottomButtonParallax() {
        return false;
    }

    public void songItemClickLog(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3) {
        q.g(s, "image");
        q.g(s1, "metaId");
        q.g(s2, "metaName");
        q.g(s3, "metaAuthor");
    }

    public void songItemInAlbumClickLog(@NotNull String s, int v, @NotNull String s1, @NotNull String s2) {
        q.g(s, "setNum");
        q.g(s1, "metaId");
        q.g(s2, "metaName");
    }

    public void songMoreClickLog(int v, @NotNull String s, @NotNull String s1) {
        q.g(s, "metaId");
        q.g(s1, "metaName");
    }

    public void songMoreClickLog(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3) {
        q.g(s, "image");
        q.g(s1, "metaId");
        q.g(s2, "metaName");
        q.g(s3, "metaAuthor");
    }

    public void songMoreInAlbumClickLog(@NotNull String s, int v, @NotNull String s1, @NotNull String s2) {
        q.g(s, "setNum");
        q.g(s1, "metaId");
        q.g(s2, "metaName");
    }

    public void songPlayClickLog(int v, @NotNull String s, @NotNull String s1) {
        q.g(s, "metaId");
        q.g(s1, "metaName");
    }

    public void songPlayClickLog(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4) {
        q.g(s, "image");
        q.g(s1, "metaId");
        q.g(s2, "metaName");
        q.g(s3, "metaAuthor");
        q.g(s4, "cType");
    }

    public void songPlayInAlbumClickLog(@NotNull String s, int v, @NotNull String s1, @NotNull String s2) {
        q.g(s, "setNum");
        q.g(s1, "metaId");
        q.g(s2, "metaName");
    }

    public void songThumbClickLog(int v, @NotNull String s, @NotNull String s1) {
        q.g(s, "metaId");
        q.g(s1, "metaName");
    }

    public void songThumbClickLog(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3) {
        q.g(s, "image");
        q.g(s1, "metaId");
        q.g(s2, "metaName");
        q.g(s3, "metaAuthor");
    }

    private final void startViewableCheck() {
        synchronized(this.onStateChangeListenerHashSet) {
            Iterator iterator0 = this.onStateChangeListenerHashSet.iterator();
            q.f(iterator0, "iterator(...)");
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                q.f(object0, "next(...)");
                ((OnStateChangeListener)object0).onStart();
            }
        }
    }

    private final void stopViewableCheck() {
        synchronized(this.onStateChangeListenerHashSet) {
            Iterator iterator0 = this.onStateChangeListenerHashSet.iterator();
            q.f(iterator0, "iterator(...)");
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                q.f(object0, "next(...)");
                ((OnStateChangeListener)object0).onStop();
            }
        }
    }

    private final void tiaraViewImpMapFlush() {
        HashMap hashMap0 = this.tiaraViewImpMap;
        __monitor_enter(hashMap0);
        try {
            if(!this.tiaraViewImpMap.isEmpty()) {
                ContentList contentList0 = new ContentList();
                for(Object object0: this.tiaraViewImpMap.values()) {
                    contentList0.addContent(((ViewImpContent)object0));
                }
                this.tiaraViewImpMap.clear();
                p8.s s0 = this.mMelonTiaraProperty;
                if(s0 != null) {
                    p8.i i0 = new p8.i();  // 初始化器: Lp8/f;-><init>()V
                    i0.b = s0.a;
                    i0.c = s0.b;
                    i0.I = s0.c;
                    i0.Z = contentList0;
                    i0.Q = "";
                    StatsElementsBase statsElementsBase0 = this.getStatsElements();
                    String s1 = null;
                    i0.L = statsElementsBase0 == null ? null : statsElementsBase0.impressionId;
                    StatsElementsBase statsElementsBase1 = this.getStatsElements();
                    if(statsElementsBase1 != null) {
                        s1 = statsElementsBase1.seedContsId;
                    }
                    i0.T = s1;
                    i0.N = "1727140957b6fc5c5a";
                    i0.O = "app_user_id";
                    i0.a().track();
                }
                goto label_32;
            }
            goto label_34;
        }
        catch(Throwable throwable0) {
        }
        __monitor_exit(hashMap0);
        throw throwable0;
    label_32:
        __monitor_exit(hashMap0);
        return;
    label_34:
        __monitor_exit(hashMap0);
    }

    @Override  // com.iloen.melon.fragments.comments.CommentLatestList
    public abstract void updateCommentCountView(@Nullable InformCmtContsSummRes arg1);

    private final void updateCommentItem(EventComment eventComment0) {
        String s = eventComment0.actiontype;
        int v = s.hashCode();
        int v1 = 1;
        if(v != 0xC84C5534) {
            Integer integer0 = null;
            int v2 = 0;
            switch(v) {
                case 0x5A7510F: {
                    if(s.equals("count")) {
                        if(eventComment0.isReplyAdded) {
                            CommentData commentData0 = (CommentData)this.getCommentViewModel().getCommentData().getValue();
                            if(commentData0 != null) {
                                ArrayList arrayList0 = commentData0.getListCmtRes().result.cmtlist;
                                if(arrayList0 != null) {
                                    Iterator iterator0 = arrayList0.iterator();
                                    while(true) {
                                        if(!iterator0.hasNext()) {
                                            v2 = -1;
                                            break;
                                        }
                                        Object object0 = iterator0.next();
                                        if(((CMTLIST)object0).cmtinfo.cmtseq == eventComment0.cmtSeq) {
                                            break;
                                        }
                                        ++v2;
                                    }
                                    integer0 = v2;
                                }
                                if(integer0 != null && ((int)integer0) > -1) {
                                    cmtList cmtResViewModel$result$cmtList0 = this.getCommentActionImpl().getValidCommentInfoAdapterItem(this.getCommentAdapterPosition(), ((int)integer0));
                                    if(cmtResViewModel$result$cmtList0 != null) {
                                        CMTINFO cmtSharedTypeRes$CmtListBase$CMTINFO0 = cmtResViewModel$result$cmtList0.cmtinfo;
                                        int v3 = cmtSharedTypeRes$CmtListBase$CMTINFO0.validadcmtcnt;
                                        if(!eventComment0.isCountAdded) {
                                            v1 = -1;
                                        }
                                        cmtSharedTypeRes$CmtListBase$CMTINFO0.validadcmtcnt = v3 + v1;
                                        this.mAdapter.notifyItemChanged(this.getCommentAdapterPosition());
                                        return;
                                    }
                                }
                            }
                        }
                        else {
                            BbsParam bbsParam0 = this.getCommentViewModel().getParam();
                            if(bbsParam0 != null && eventComment0.chnlSeq == bbsParam0.getBbsChnlSeq() && q.b(eventComment0.contsRefValue, "")) {
                                this.startFetch();
                                return;
                            }
                        }
                    }
                    break;
                }
                case 0x3AF610BC: {
                    if(s.equals("recommend")) {
                        CommentData commentData1 = (CommentData)this.getCommentViewModel().getCommentData().getValue();
                        if(commentData1 != null) {
                            ArrayList arrayList1 = commentData1.getListCmtRes().result.cmtlist;
                            if(arrayList1 != null) {
                                Iterator iterator1 = arrayList1.iterator();
                                while(true) {
                                    if(!iterator1.hasNext()) {
                                        v2 = -1;
                                        break;
                                    }
                                    Object object1 = iterator1.next();
                                    if(((CMTLIST)object1).cmtinfo.cmtseq == eventComment0.cmtSeq) {
                                        break;
                                    }
                                    ++v2;
                                }
                                integer0 = v2;
                            }
                            if(integer0 != null && ((int)integer0) > -1) {
                                cmtList cmtResViewModel$result$cmtList1 = this.getCommentActionImpl().getValidCommentInfoAdapterItem(this.getCommentAdapterPosition(), ((int)integer0));
                                if(cmtResViewModel$result$cmtList1 != null) {
                                    cmtList cmtResViewModel$result$cmtList2 = eventComment0.item;
                                    if(cmtResViewModel$result$cmtList2 != null) {
                                        cmtResViewModel$result$cmtList1.cmtinfo.recmcnt = cmtResViewModel$result$cmtList2.cmtinfo.recmcnt;
                                        cmtResViewModel$result$cmtList1.cmtinfo.memberrecmflag = cmtResViewModel$result$cmtList2.cmtinfo.memberrecmflag;
                                        cmtResViewModel$result$cmtList1.cmtinfo.nonrecmcnt = cmtResViewModel$result$cmtList2.cmtinfo.nonrecmcnt;
                                        cmtResViewModel$result$cmtList1.cmtinfo.membernonrecmflag = cmtResViewModel$result$cmtList2.cmtinfo.membernonrecmflag;
                                        cmtResViewModel$result$cmtList1.recommenderInfo = cmtResViewModel$result$cmtList2.recommenderInfo;
                                    }
                                    this.mAdapter.notifyItemChanged(this.getCommentAdapterPosition());
                                    return;
                                }
                            }
                        }
                    }
                    break;
                }
            }
        }
        else if(s.equals("report")) {
            HashMap hashMap0 = this.cmtPositionInfoHashMap;
            if(hashMap0 != null && hashMap0.containsKey(eventComment0.cmtSeq)) {
                CmtPositionInfo cmtPositionInfo0 = (CmtPositionInfo)hashMap0.get(eventComment0.cmtSeq);
                if(cmtPositionInfo0 != null) {
                    cmtList cmtResViewModel$result$cmtList3 = this.getCommentActionImpl().getValidCommentInfoAdapterItem(cmtPositionInfo0.getAdapterPosition(), cmtPositionInfo0.getDataPosition());
                    if(cmtResViewModel$result$cmtList3 != null) {
                        CMTINFO cmtSharedTypeRes$CmtListBase$CMTINFO1 = cmtResViewModel$result$cmtList3.cmtinfo;
                        if(cmtSharedTypeRes$CmtListBase$CMTINFO1 != null) {
                            cmtSharedTypeRes$CmtListBase$CMTINFO1.memberreprtflag = true;
                        }
                    }
                    this.mAdapter.notifyItemChanged(cmtPositionInfo0.getAdapterPosition());
                    hashMap0.remove(eventComment0.cmtSeq);
                }
            }
        }
    }

    @Override  // com.iloen.melon.fragments.comments.CommentLatestList
    public abstract void updateCommentListView(@NotNull LoadPgnRes arg1, @NotNull ListCmtRes arg2);

    public void updateHeaderView() {
    }

    private final void updateLikeBtn(Response userActionsRes$Response0) {
        this.updateLikeView(null, MelonDetailInfoUtils.getUserActionLikeInfo((userActionsRes$Response0 == null ? null : userActionsRes$Response0.relationList)));
    }

    public final void updateLikeInfo(@NotNull View view0) {
        q.g(view0, "view");
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return;
        }
        Response userActionsRes$Response0 = this.userActionsRes;
        if(userActionsRes$Response0 == null) {
            LogU.Companion.w("DetailSongMetaContentBaseFragment", "updateLikeInfo() >> mLikeInformContentsLikeRes is null");
            return;
        }
        boolean z = MelonDetailInfoUtils.getUserActionLikeInfo((userActionsRes$Response0 == null ? null : userActionsRes$Response0.relationList));
        this.updateLike(this.getContsId(), this.getContsTypeCode(), !z, this.getMenuId(), new OnJobFinishListener() {
            @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
            public void onJobComplete(String s, int v, boolean z) {
                q.g(s, "errorMsg");
                this.setEnabled(true);
                this.setClickable(true);
                if(TextUtils.isEmpty(s) && DetailSongMetaContentBaseFragment.this.isFragmentValid()) {
                    Response userActionsRes$Response0 = DetailSongMetaContentBaseFragment.this.getUserActionsRes();
                    MelonDetailInfoUtils.INSTANCE.setUserActionLikeInfo((userActionsRes$Response0 == null ? null : userActionsRes$Response0.relationList), z);
                    DetailSongMetaContentBaseFragment.this.updateLikeView(v, z);
                    com.iloen.melon.responsecache.a.c(DetailSongMetaContentBaseFragment.this.getContext(), "", true);
                }
            }

            @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
            public void onStartAsyncTask() {
                this.setEnabled(false);
                this.setClickable(false);
            }
        });
    }

    public final void updateLikeInfoForSongAlbumDetail(@NotNull View view0) {
        q.g(view0, "view");
        if(!this.isLoginUser()) {
            this.showLoginPopup();
            return;
        }
        RESPONSE myMusicLikeInformContentsLikeRes$RESPONSE0 = this.realTimeLikeInfoRes;
        if(myMusicLikeInformContentsLikeRes$RESPONSE0 == null) {
            LogU.Companion.w("DetailSongMetaContentBaseFragment", "updateLikeInfoForSongAlbumDetail() >> realTimeLikeInfoRes is null");
            return;
        }
        int v = myMusicLikeInformContentsLikeRes$RESPONSE0 == null ? 0 : !ProtocolUtils.parseBoolean(myMusicLikeInformContentsLikeRes$RESPONSE0.likeyn);
        this.updateLike(this.getContsId(), this.getContsTypeCode(), ((boolean)v), this.getMenuId(), new OnJobFinishListener() {
            @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
            public void onJobComplete(String s, int v, boolean z) {
                q.g(s, "errorMsg");
                this.setEnabled(true);
                this.setClickable(true);
                if(TextUtils.isEmpty(s) && DetailSongMetaContentBaseFragment.this.isFragmentValid()) {
                    RESPONSE myMusicLikeInformContentsLikeRes$RESPONSE0 = DetailSongMetaContentBaseFragment.this.getRealTimeLikeInfoRes();
                    if(myMusicLikeInformContentsLikeRes$RESPONSE0 != null) {
                        myMusicLikeInformContentsLikeRes$RESPONSE0.likeyn = z ? "Y" : "N";
                    }
                    DetailSongMetaContentBaseFragment.this.updateLikeView(v, z);
                    DetailSongMetaContentBaseFragment.this.likeClickLog(z);
                    if(q.b("N10002", DetailSongMetaContentBaseFragment.this.getContsTypeCode()) && z) {
                        String s1 = DetailSongMetaContentBaseFragment.this.getContsId();
                        DetailSongMetaContentBaseFragment.this.showRecommendAlbumContentsPopup(s1);
                        O.a(new UaLogDummyReq(DetailSongMetaContentBaseFragment.this.getContext(), "recmAlbumLikePopup"));
                    }
                }
            }

            @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
            public void onStartAsyncTask() {
                this.setEnabled(false);
                this.setClickable(false);
            }
        });
    }

    public abstract void updateLikeView(@Nullable Integer arg1, boolean arg2);

    public boolean useBottomButton() {
        return true;
    }

    public boolean useDrawHeaderWhenConfigurationChange() {
        return true;
    }
}

