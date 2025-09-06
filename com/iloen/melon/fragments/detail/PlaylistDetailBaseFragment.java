package com.iloen.melon.fragments.detail;

import F8.G;
import F8.I;
import F8.m;
import F8.o;
import J8.E2;
import J8.n0;
import Tf.v;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.session.W0;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import com.android.volley.VolleyError;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.adapters.common.a;
import com.iloen.melon.custom.CheckableImageView;
import com.iloen.melon.custom.CheckableTextView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.BottomBtnClickListener;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.BottomBtnData;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.BottomBtnInfo;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.DetailAdapter;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.OnViewHolderActionListener;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment;
import com.iloen.melon.fragments.detail.viewholder.AlbumMagazineHolder;
import com.iloen.melon.fragments.detail.viewholder.DetailCommentItemHolder;
import com.iloen.melon.fragments.detail.viewholder.EmptyCommentHolder;
import com.iloen.melon.fragments.detail.viewholder.MagazineHolder;
import com.iloen.melon.fragments.detail.viewholder.PlaylistBannerHolder;
import com.iloen.melon.fragments.detail.viewholder.PlaylistBrandPlaylistHolder;
import com.iloen.melon.fragments.detail.viewholder.PlaylistBrandStationHolder;
import com.iloen.melon.fragments.detail.viewholder.PlaylistHolder;
import com.iloen.melon.fragments.detail.viewholder.PlaylistMixHolder;
import com.iloen.melon.fragments.detail.viewholder.PlaylistRelationContentHolder;
import com.iloen.melon.fragments.detail.viewholder.PlaylistRelationPlaylistHolder;
import com.iloen.melon.fragments.detail.viewholder.PlaylistSeriesPlaylistHolder;
import com.iloen.melon.fragments.detail.viewholder.PlaylistTagHolder;
import com.iloen.melon.fragments.detail.viewholder.SongListEmptyHolder.SongListEmptyData;
import com.iloen.melon.fragments.detail.viewholder.SongListEmptyHolder;
import com.iloen.melon.fragments.detail.viewholder.SongListFooterHolder;
import com.iloen.melon.fragments.detail.viewholder.SongListHeaderHolder.HeaderData;
import com.iloen.melon.fragments.detail.viewholder.SongListHeaderHolder;
import com.iloen.melon.fragments.detail.viewholder.StationHolder;
import com.iloen.melon.net.HttpRequest;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummRes.result.CMTCONTSSUMM;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummRes.result;
import com.iloen.melon.net.v3x.comments.InformCmtContsSummRes;
import com.iloen.melon.net.v3x.comments.ListCmtRes;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.request.UaLogDummyReq;
import com.iloen.melon.net.v4x.response.ArtistPlylstSongListRes;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v5x.response.DetailBaseRes.PAGE;
import com.iloen.melon.net.v5x.response.DjBrandBannerRes;
import com.iloen.melon.net.v6x.request.CleanIsBlackReq;
import com.iloen.melon.net.v6x.request.ForuPlayReq;
import com.iloen.melon.net.v6x.request.MyMusicPlaylistDownloadListSongReq;
import com.iloen.melon.net.v6x.request.MyMusicPlaylistPlayListSongReq;
import com.iloen.melon.net.v6x.request.MyMusicPlaylistScrapListSongReq;
import com.iloen.melon.net.v6x.response.CleanIsBlackRes;
import com.iloen.melon.net.v6x.response.DjPlaylistInformRes;
import com.iloen.melon.net.v6x.response.ForUDetailRes;
import com.iloen.melon.net.v6x.response.ForuPlayRes.RESPONSE.FORUSONG;
import com.iloen.melon.net.v6x.response.ForuPlayRes;
import com.iloen.melon.net.v6x.response.MelonDjPlaylistListSongRes.RESPONSE;
import com.iloen.melon.net.v6x.response.MelonDjPlaylistListSongRes;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistListSongRes;
import com.iloen.melon.net.v6x.response.PlaylistListSongBaseRes.RESPONSE.SONGLIST;
import com.iloen.melon.net.v6x.response.PlaylistListSongBaseRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.add.AddAction.Add;
import com.iloen.melon.playback.playlist.add.AddServerContent;
import com.iloen.melon.playback.playlist.add.AddToPlaylistUIHelperKt;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.Playlist;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.SongInfoBase;
import d3.g;
import e.k;
import e1.u;
import ie.j;
import java.util.ArrayList;
import java.util.List;
import je.p;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.O;
import p8.f;
import pc.R0;
import v9.h;
import v9.i;
import va.e0;
import va.e;
import zd.M;

@Metadata(d1 = {"\u0000\u00A4\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001B\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001B\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u0000 \u00A6\u00022\u00020\u00012\u00020\u0002:\u0006\u00A6\u0002\u00A7\u0002\u00A8\u0002B\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0006\u0010\u0004J\u000F\u0010\u0007\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\n\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\n\u0010\u000BJ!\u0010\u0010\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0004J\u0017\u0010\u0015\u001A\u00020\u00052\u0006\u0010\u0014\u001A\u00020\u0013H\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001A\u00020\u00052\u0006\u0010\u0017\u001A\u00020\u000EH\u0014\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001B\u001A\u00020\u00052\u0006\u0010\u001A\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b\u001B\u0010\u0019J\u0011\u0010\u001D\u001A\u0004\u0018\u00010\u001CH\u0016\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010 \u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\b \u0010!J\u001B\u0010%\u001A\u0006\u0012\u0002\b\u00030$2\u0006\u0010#\u001A\u00020\"H\u0014\u00A2\u0006\u0004\b%\u0010&J\u0011\u0010(\u001A\u0004\u0018\u00010\'H\u0014\u00A2\u0006\u0004\b(\u0010)J-\u00101\u001A\u0002002\b\u0010+\u001A\u0004\u0018\u00010*2\b\u0010-\u001A\u0004\u0018\u00010,2\b\u0010/\u001A\u0004\u0018\u00010.H\u0014\u00A2\u0006\u0004\b1\u00102J\'\u00106\u001A\u00020\u00052\b\u00103\u001A\u0004\u0018\u00010.2\u0006\u00104\u001A\u00020.2\u0006\u00105\u001A\u00020.\u00A2\u0006\u0004\b6\u00107J\u001D\u0010:\u001A\u00020\u00052\u0006\u00108\u001A\u00020.2\u0006\u00109\u001A\u00020\u001C\u00A2\u0006\u0004\b:\u0010;J\'\u0010:\u001A\u00020\u00052\u0006\u00108\u001A\u00020.2\b\u0010=\u001A\u0004\u0018\u00010<2\u0006\u00109\u001A\u00020\u001C\u00A2\u0006\u0004\b:\u0010>J3\u0010:\u001A\u00020\u00052\b\u0010@\u001A\u0004\u0018\u00010?2\u0006\u0010A\u001A\u00020.2\b\u0010=\u001A\u0004\u0018\u00010<2\u0006\u0010B\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b:\u0010CJ;\u0010:\u001A\u00020\u00052\b\u0010@\u001A\u0004\u0018\u00010?2\u0006\u0010A\u001A\u00020.2\b\u0010=\u001A\u0004\u0018\u00010<2\u0006\u0010B\u001A\u00020\b2\u0006\u0010D\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b:\u0010EJ\u000F\u0010F\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\bF\u0010\u0004J\u000F\u0010G\u001A\u00020.H\u0016\u00A2\u0006\u0004\bG\u0010HJ\u000F\u0010I\u001A\u00020.H\u0016\u00A2\u0006\u0004\bI\u0010HJ\u000F\u0010J\u001A\u00020.H\u0016\u00A2\u0006\u0004\bJ\u0010HJ\r\u0010K\u001A\u00020\u0005\u00A2\u0006\u0004\bK\u0010\u0004J!\u0010K\u001A\u00020\u00052\b\u0010L\u001A\u0004\u0018\u00010\b2\u0006\u0010M\u001A\u000200H\u0016\u00A2\u0006\u0004\bK\u0010NJ\u0013\u0010P\u001A\u00060OR\u00020\u0001H\u0016\u00A2\u0006\u0004\bP\u0010QJ5\u0010W\u001A\u00020\u00052\b\u0010R\u001A\u0004\u0018\u00010.2\b\u0010S\u001A\u0004\u0018\u00010.2\b\u0010T\u001A\u0004\u0018\u00010.2\b\u0010V\u001A\u0004\u0018\u00010U\u00A2\u0006\u0004\bW\u0010XJ\u000F\u0010Y\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\bY\u0010\u0004J\r\u0010Z\u001A\u00020.\u00A2\u0006\u0004\bZ\u0010HJ\u000F\u0010[\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b[\u0010\u0004J\u000F\u0010\\\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\\\u0010\u0004J\u000F\u0010]\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b]\u0010\u0004J\u0017\u0010_\u001A\u00020\b2\b\u0010^\u001A\u0004\u0018\u00010.\u00A2\u0006\u0004\b_\u0010`J\r\u0010a\u001A\u00020\u0005\u00A2\u0006\u0004\ba\u0010\u0004J\u0015\u0010c\u001A\u00020\u00052\u0006\u0010b\u001A\u000200\u00A2\u0006\u0004\bc\u0010dJ\u0017\u0010e\u001A\u00020\u00052\u0006\u0010b\u001A\u000200H\u0014\u00A2\u0006\u0004\be\u0010dJ\u0019\u0010h\u001A\u00020\u00052\b\u0010g\u001A\u0004\u0018\u00010fH\u0016\u00A2\u0006\u0004\bh\u0010iJ\u001F\u0010n\u001A\u00020\u00052\u0006\u0010k\u001A\u00020j2\u0006\u0010m\u001A\u00020lH\u0016\u00A2\u0006\u0004\bn\u0010oJ\u001D\u0010r\u001A\u00020\u00052\u0006\u0010p\u001A\u00020.2\u0006\u0010q\u001A\u000200\u00A2\u0006\u0004\br\u0010sJ\u001B\u0010v\u001A\u0006\u0012\u0002\b\u00030u2\u0006\u0010+\u001A\u00020tH\u0016\u00A2\u0006\u0004\bv\u0010wJ\u0017\u0010x\u001A\u00020\u00052\u0006\u0010+\u001A\u00020tH\u0016\u00A2\u0006\u0004\bx\u0010yJ\u0015\u0010{\u001A\u00020\u00052\u0006\u0010z\u001A\u000200\u00A2\u0006\u0004\b{\u0010dJ;\u0010\u0081\u0001\u001A\u00020\u00052\b\u0010}\u001A\u0004\u0018\u00010|2\b\u0010~\u001A\u0004\u0018\u00010.2\b\u0010\u007F\u001A\u0004\u0018\u00010.2\t\u0010\u0080\u0001\u001A\u0004\u0018\u00010.H\u0016\u00A2\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u009E\u0001\u0010\u0081\u0001\u001A\u00020\u00052\n\b\u0002\u0010}\u001A\u0004\u0018\u00010|2\n\b\u0002\u0010~\u001A\u0004\u0018\u00010.2\n\b\u0002\u0010\u007F\u001A\u0004\u0018\u00010.2\u000B\b\u0002\u0010\u0080\u0001\u001A\u0004\u0018\u00010.2\u000B\b\u0002\u0010\u0083\u0001\u001A\u0004\u0018\u00010\b2\u000B\b\u0002\u0010\u0084\u0001\u001A\u0004\u0018\u00010.2\u000B\b\u0002\u0010\u0085\u0001\u001A\u0004\u0018\u00010.2\u000B\b\u0002\u0010\u0086\u0001\u001A\u0004\u0018\u00010.2\u000B\b\u0002\u0010\u0087\u0001\u001A\u0004\u0018\u00010.2\u000B\b\u0002\u0010\u0088\u0001\u001A\u0004\u0018\u00010.2\u000B\b\u0002\u0010\u0089\u0001\u001A\u0004\u0018\u00010.H\u0016\u00A2\u0006\u0006\b\u0081\u0001\u0010\u008A\u0001J\u0011\u0010\u008B\u0001\u001A\u00020\u0005H\u0016\u00A2\u0006\u0005\b\u008B\u0001\u0010\u0004J\u0011\u0010\u008C\u0001\u001A\u00020\u0005H\u0016\u00A2\u0006\u0005\b\u008C\u0001\u0010\u0004J\u0011\u0010\u008D\u0001\u001A\u00020\u0005H\u0016\u00A2\u0006\u0005\b\u008D\u0001\u0010\u0004J\u0011\u0010\u008E\u0001\u001A\u00020\u0005H\u0016\u00A2\u0006\u0005\b\u008E\u0001\u0010\u0004J\u0011\u0010\u008F\u0001\u001A\u00020\u0005H\u0016\u00A2\u0006\u0005\b\u008F\u0001\u0010\u0004J\u0011\u0010\u0090\u0001\u001A\u00020\u0005H\u0016\u00A2\u0006\u0005\b\u0090\u0001\u0010\u0004J\u0011\u0010\u0091\u0001\u001A\u00020\u0005H\u0016\u00A2\u0006\u0005\b\u0091\u0001\u0010\u0004J\u001D\u0010\u0092\u0001\u001A\u00020\u00052\t\u0010\u0083\u0001\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J?\u0010\u0097\u0001\u001A\u00020\u00052\u0007\u0010\u0083\u0001\u001A\u00020\b2\u0007\u0010\u0084\u0001\u001A\u00020.2\u0007\u0010\u0094\u0001\u001A\u00020.2\u0007\u0010\u0095\u0001\u001A\u00020.2\u0007\u0010\u0096\u0001\u001A\u00020.H\u0016\u00A2\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001JH\u0010\u009A\u0001\u001A\u00020\u00052\u0007\u0010\u0083\u0001\u001A\u00020\b2\u0007\u0010\u0084\u0001\u001A\u00020.2\u0007\u0010\u0094\u0001\u001A\u00020.2\u0007\u0010\u0095\u0001\u001A\u00020.2\u0007\u0010\u0096\u0001\u001A\u00020.2\u0007\u0010\u0099\u0001\u001A\u00020.H\u0016\u00A2\u0006\u0006\b\u009A\u0001\u0010\u009B\u0001J?\u0010\u009C\u0001\u001A\u00020\u00052\u0007\u0010\u0083\u0001\u001A\u00020\b2\u0007\u0010\u0084\u0001\u001A\u00020.2\u0007\u0010\u0094\u0001\u001A\u00020.2\u0007\u0010\u0095\u0001\u001A\u00020.2\u0007\u0010\u0096\u0001\u001A\u00020.H\u0016\u00A2\u0006\u0006\b\u009C\u0001\u0010\u0098\u0001J?\u0010\u009D\u0001\u001A\u00020\u00052\u0007\u0010\u0083\u0001\u001A\u00020\b2\u0007\u0010\u0084\u0001\u001A\u00020.2\u0007\u0010\u0094\u0001\u001A\u00020.2\u0007\u0010\u0095\u0001\u001A\u00020.2\u0007\u0010\u0096\u0001\u001A\u00020.H\u0016\u00A2\u0006\u0006\b\u009D\u0001\u0010\u0098\u0001J\u0015\u0010\u009F\u0001\u001A\u0005\u0018\u00010\u009E\u0001H\u0016\u00A2\u0006\u0006\b\u009F\u0001\u0010\u00A0\u0001J\u0011\u0010\u00A1\u0001\u001A\u00020\u0005H\u0002\u00A2\u0006\u0005\b\u00A1\u0001\u0010\u0004R.\u0010\u00A3\u0001\u001A\u00070\u00A2\u0001R\u00020\u00018\u0006@\u0006X\u0086.\u00A2\u0006\u0018\n\u0006\b\u00A3\u0001\u0010\u00A4\u0001\u001A\u0006\b\u00A5\u0001\u0010\u00A6\u0001\"\u0006\b\u00A7\u0001\u0010\u00A8\u0001R*\u0010\u00A9\u0001\u001A\u0004\u0018\u00010\u001C8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0017\n\u0006\b\u00A9\u0001\u0010\u00AA\u0001\u001A\u0005\b\u00AB\u0001\u0010\u001E\"\u0006\b\u00AC\u0001\u0010\u00AD\u0001R(\u0010\u00AE\u0001\u001A\u00020.8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0017\n\u0006\b\u00AE\u0001\u0010\u00AF\u0001\u001A\u0005\b\u00B0\u0001\u0010H\"\u0006\b\u00B1\u0001\u0010\u00B2\u0001R&\u00103\u001A\u00020.8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0016\n\u0005\b3\u0010\u00AF\u0001\u001A\u0005\b\u00B3\u0001\u0010H\"\u0006\b\u00B4\u0001\u0010\u00B2\u0001R(\u0010\u00B5\u0001\u001A\u00020.8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0017\n\u0006\b\u00B5\u0001\u0010\u00AF\u0001\u001A\u0005\b\u00B6\u0001\u0010H\"\u0006\b\u00B7\u0001\u0010\u00B2\u0001R(\u0010\u00B8\u0001\u001A\u00020.8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0017\n\u0006\b\u00B8\u0001\u0010\u00AF\u0001\u001A\u0005\b\u00B9\u0001\u0010H\"\u0006\b\u00BA\u0001\u0010\u00B2\u0001R(\u0010\u00BB\u0001\u001A\u00020.8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0017\n\u0006\b\u00BB\u0001\u0010\u00AF\u0001\u001A\u0005\b\u00BC\u0001\u0010H\"\u0006\b\u00BD\u0001\u0010\u00B2\u0001R,\u0010\u00BF\u0001\u001A\u0005\u0018\u00010\u00BE\u00018\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0018\n\u0006\b\u00BF\u0001\u0010\u00C0\u0001\u001A\u0006\b\u00C1\u0001\u0010\u00C2\u0001\"\u0006\b\u00C3\u0001\u0010\u00C4\u0001R,\u0010\u00C6\u0001\u001A\u0005\u0018\u00010\u00C5\u00018\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0018\n\u0006\b\u00C6\u0001\u0010\u00C7\u0001\u001A\u0006\b\u00C8\u0001\u0010\u00C9\u0001\"\u0006\b\u00CA\u0001\u0010\u00CB\u0001R(\u0010\u00CC\u0001\u001A\u00020\b8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0017\n\u0006\b\u00CC\u0001\u0010\u00CD\u0001\u001A\u0006\b\u00CE\u0001\u0010\u00CF\u0001\"\u0005\b\u00D0\u0001\u0010\u000BR&\u0010^\u001A\u00020\b8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0016\n\u0005\b^\u0010\u00CD\u0001\u001A\u0006\b\u00D1\u0001\u0010\u00CF\u0001\"\u0005\b\u00D2\u0001\u0010\u000BR%\u0010M\u001A\u0002008\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0015\n\u0005\bM\u0010\u00D3\u0001\u001A\u0005\bM\u0010\u00D4\u0001\"\u0005\b\u00D5\u0001\u0010dR\u001F\u0010\u00D6\u0001\u001A\u0002008\u0016X\u0096D\u00A2\u0006\u0010\n\u0006\b\u00D6\u0001\u0010\u00D3\u0001\u001A\u0006\b\u00D6\u0001\u0010\u00D4\u0001R(\u0010\u00D7\u0001\u001A\u0002008\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0017\n\u0006\b\u00D7\u0001\u0010\u00D3\u0001\u001A\u0006\b\u00D7\u0001\u0010\u00D4\u0001\"\u0005\b\u00D8\u0001\u0010dR(\u0010\u00D9\u0001\u001A\u00020.8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0017\n\u0006\b\u00D9\u0001\u0010\u00AF\u0001\u001A\u0005\b\u00DA\u0001\u0010H\"\u0006\b\u00DB\u0001\u0010\u00B2\u0001R(\u0010\u00DC\u0001\u001A\u0002008\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0017\n\u0006\b\u00DC\u0001\u0010\u00D3\u0001\u001A\u0006\b\u00DC\u0001\u0010\u00D4\u0001\"\u0005\b\u00DD\u0001\u0010dR(\u0010\u00DE\u0001\u001A\u00020\b8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0017\n\u0006\b\u00DE\u0001\u0010\u00CD\u0001\u001A\u0006\b\u00DF\u0001\u0010\u00CF\u0001\"\u0005\b\u00E0\u0001\u0010\u000BR*\u0010\u00E2\u0001\u001A\u00030\u00E1\u00018\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0018\n\u0006\b\u00E2\u0001\u0010\u00E3\u0001\u001A\u0006\b\u00E4\u0001\u0010\u00E5\u0001\"\u0006\b\u00E6\u0001\u0010\u00E7\u0001R)\u0010V\u001A\u0004\u0018\u00010U8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0017\n\u0005\bV\u0010\u00E8\u0001\u001A\u0006\b\u00E9\u0001\u0010\u00EA\u0001\"\u0006\b\u00EB\u0001\u0010\u00EC\u0001R(\u0010\u00ED\u0001\u001A\u00020\b8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0017\n\u0006\b\u00ED\u0001\u0010\u00CD\u0001\u001A\u0006\b\u00EE\u0001\u0010\u00CF\u0001\"\u0005\b\u00EF\u0001\u0010\u000BR(\u0010\u00F0\u0001\u001A\u00020\b8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0017\n\u0006\b\u00F0\u0001\u0010\u00CD\u0001\u001A\u0006\b\u00F1\u0001\u0010\u00CF\u0001\"\u0005\b\u00F2\u0001\u0010\u000BR(\u0010\u00F3\u0001\u001A\u00020\b8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0017\n\u0006\b\u00F3\u0001\u0010\u00CD\u0001\u001A\u0006\b\u00F4\u0001\u0010\u00CF\u0001\"\u0005\b\u00F5\u0001\u0010\u000BR3\u0010\u00F8\u0001\u001A\f\u0012\u0005\u0012\u00030\u00F7\u0001\u0018\u00010\u00F6\u00018\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0018\n\u0006\b\u00F8\u0001\u0010\u00F9\u0001\u001A\u0006\b\u00FA\u0001\u0010\u00FB\u0001\"\u0006\b\u00FC\u0001\u0010\u00FD\u0001R\u0019\u0010\u00FE\u0001\u001A\u00020\b8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u00FE\u0001\u0010\u00CD\u0001R*\u0010\u0080\u0002\u001A\u00030\u00FF\u00018\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0018\n\u0006\b\u0080\u0002\u0010\u0081\u0002\u001A\u0006\b\u0082\u0002\u0010\u0083\u0002\"\u0006\b\u0084\u0002\u0010\u0085\u0002R,\u0010\u0087\u0002\u001A\u0005\u0018\u00010\u0086\u00028\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0018\n\u0006\b\u0087\u0002\u0010\u0088\u0002\u001A\u0006\b\u0089\u0002\u0010\u008A\u0002\"\u0006\b\u008B\u0002\u0010\u008C\u0002R,\u0010\u008E\u0002\u001A\u0005\u0018\u00010\u008D\u00028\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0018\n\u0006\b\u008E\u0002\u0010\u008F\u0002\u001A\u0006\b\u0090\u0002\u0010\u0091\u0002\"\u0006\b\u0092\u0002\u0010\u0093\u0002R!\u0010\u0099\u0002\u001A\u00030\u0094\u00028VX\u0096\u0084\u0002\u00A2\u0006\u0010\n\u0006\b\u0095\u0002\u0010\u0096\u0002\u001A\u0006\b\u0097\u0002\u0010\u0098\u0002R\u0015\u0010\u009B\u0002\u001A\u0004\u0018\u00010\u001F8F\u00A2\u0006\u0007\u001A\u0005\b\u009A\u0002\u0010!R\u0015\u0010\u009F\u0002\u001A\u00030\u009C\u00028F\u00A2\u0006\b\u001A\u0006\b\u009D\u0002\u0010\u009E\u0002R\u0018\u0010\u00A3\u0002\u001A\u00030\u00A0\u00028VX\u0096\u0004\u00A2\u0006\b\u001A\u0006\b\u00A1\u0002\u0010\u00A2\u0002R\u0017\u0010\u00A5\u0002\u001A\u00020\b8VX\u0096\u0004\u00A2\u0006\b\u001A\u0006\b\u00A4\u0002\u0010\u00CF\u0001\u00A8\u0006\u00A9\u0002"}, d2 = {"Lcom/iloen/melon/fragments/detail/PlaylistDetailBaseFragment;", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "Lie/H;", "onAppBarCollapsed", "onAppBarExpended", "", "offset", "onAppBarScrolling", "(I)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "LJ8/E2;", "getHeaderBinding", "()LJ8/E2;", "LQ4/a;", "onCreateHeaderLayout", "()LQ4/a;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "ownerMemberKey", "cleanServiceCode", "playListType", "setTitleBar", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "desc", "headerBinding", "setDescText", "(Ljava/lang/String;LJ8/E2;)V", "Landroid/text/SpannableString;", "spannableText", "(Ljava/lang/String;Landroid/text/SpannableString;LJ8/E2;)V", "Landroid/widget/TextView;", "textView", "text", "maxLine", "(Landroid/widget/TextView;Ljava/lang/String;Landroid/text/SpannableString;I)V", "count", "(Landroid/widget/TextView;Ljava/lang/String;Landroid/text/SpannableString;II)V", "removeDetailCache", "getContsId", "()Ljava/lang/String;", "getContsTypeCode", "getPageMetaType", "updateLikeView", "sumCount", "isLike", "(Ljava/lang/Integer;Z)V", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;", "getOnViewHolderActionListener", "()Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;", "contsId", "songIds", "menuId", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "statsElementsBase", "playForUSong", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "showContextPopupPlaylistDetail", "getCleanServiceCode", "openProfile", "downloadAll", "addAll", "likeCount", "likeCountToInt", "(Ljava/lang/String;)I", "setSongListHeader", "checked", "updateSelectButton", "(Z)V", "updateSelectAllButton", "Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes;", "infoCmtContsRes", "updateCommentCountView", "(Lcom/iloen/melon/net/v3x/comments/InformCmtContsSummRes;)V", "Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;", "loadPgnRes", "Lcom/iloen/melon/net/v3x/comments/ListCmtRes;", "listCmtRes", "updateCommentListView", "(Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;Lcom/iloen/melon/net/v3x/comments/ListCmtRes;)V", "memberKey", "isFriend", "addOrDeleteFriend", "(Ljava/lang/String;Z)V", "Lzd/M;", "Lcom/iloen/melon/net/HttpRequest;", "getPlaylistSongListRequest", "(Lzd/M;)Lcom/iloen/melon/net/HttpRequest;", "contextMenuCheckSongList", "(Lzd/M;)V", "isVisible", "showWhenSongListHeader", "Lcom/kakao/tiara/data/ActionKind;", "actionKind", "actionName", "clickLayer1", "clickCopy", "itemClickLog", "(Lcom/kakao/tiara/data/ActionKind;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ordNum", "image", "eventMetaId", "eventMetaType", "eventMetaName", "eventMetaAuthor", "propsLikeType", "(Lcom/kakao/tiara/data/ActionKind;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onFriendStatusChanged", "moreClickLog", "introduceMoreClickLog", "playAllClickLog", "playShuffleClickLog", "allSelectClickLog", "songListViewAllClickLog", "songListMoreClickLog", "(Ljava/lang/Integer;)V", "metaId", "metaName", "metaAuthor", "songItemClickLog", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "cType", "songPlayClickLog", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "songMoreClickLog", "songThumbClickLog", "Lp8/f;", "getTiaraEventBuilder", "()Lp8/f;", "mixUpPlayClickLog", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$DetailAdapter;", "detailAdapter", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$DetailAdapter;", "getDetailAdapter", "()Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$DetailAdapter;", "setDetailAdapter", "(Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$DetailAdapter;)V", "playlistDetailHeaderBinding", "LJ8/E2;", "getPlaylistDetailHeaderBinding", "setPlaylistDetailHeaderBinding", "(LJ8/E2;)V", "playlistSeq", "Ljava/lang/String;", "getPlaylistSeq", "setPlaylistSeq", "(Ljava/lang/String;)V", "getOwnerMemberKey", "setOwnerMemberKey", "titleText", "getTitleText", "setTitleText", "totalSongCount", "getTotalSongCount", "setTotalSongCount", "totalPlayTime", "getTotalPlayTime", "setTotalPlayTime", "Lcom/iloen/melon/net/v6x/response/DjPlaylistInformRes;", "djPlaylistInfoRes", "Lcom/iloen/melon/net/v6x/response/DjPlaylistInformRes;", "getDjPlaylistInfoRes", "()Lcom/iloen/melon/net/v6x/response/DjPlaylistInformRes;", "setDjPlaylistInfoRes", "(Lcom/iloen/melon/net/v6x/response/DjPlaylistInformRes;)V", "Lcom/iloen/melon/net/v5x/response/DjBrandBannerRes;", "middleBannerRes", "Lcom/iloen/melon/net/v5x/response/DjBrandBannerRes;", "getMiddleBannerRes", "()Lcom/iloen/melon/net/v5x/response/DjBrandBannerRes;", "setMiddleBannerRes", "(Lcom/iloen/melon/net/v5x/response/DjBrandBannerRes;)V", "commentCount", "I", "getCommentCount", "()I", "setCommentCount", "getLikeCount", "setLikeCount", "Z", "()Z", "setLike", "isDj", "isBrandDj", "setBrandDj", "bbsChannelSeq", "getBbsChannelSeq", "setBbsChannelSeq", "isSongListAvailable", "setSongListAvailable", "headerPosition", "getHeaderPosition", "setHeaderPosition", "", "absTranslationY", "F", "getAbsTranslationY", "()F", "setAbsTranslationY", "(F)V", "Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "getStatsElementsBase", "()Lcom/iloen/melon/net/v5x/common/StatsElementsBase;", "setStatsElementsBase", "(Lcom/iloen/melon/net/v5x/common/StatsElementsBase;)V", "songListPage", "getSongListPage", "setSongListPage", "footerPosition", "getFooterPosition", "setFooterPosition", "songCount", "getSongCount", "setSongCount", "", "", "songList", "Ljava/util/List;", "getSongList", "()Ljava/util/List;", "setSongList", "(Ljava/util/List;)V", "statusBarHeight", "Lcom/iloen/melon/fragments/detail/viewholder/SongListHeaderHolder$HeaderData;", "headerData", "Lcom/iloen/melon/fragments/detail/viewholder/SongListHeaderHolder$HeaderData;", "getHeaderData", "()Lcom/iloen/melon/fragments/detail/viewholder/SongListHeaderHolder$HeaderData;", "setHeaderData", "(Lcom/iloen/melon/fragments/detail/viewholder/SongListHeaderHolder$HeaderData;)V", "LF8/p;", "backButton", "LF8/p;", "getBackButton", "()LF8/p;", "setBackButton", "(LF8/p;)V", "LF8/I;", "moreButton", "LF8/I;", "getMoreButton", "()LF8/I;", "setMoreButton", "(LF8/I;)V", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnData;", "bottomBtnData$delegate", "Lie/j;", "getBottomBtnData", "()Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnData;", "bottomBtnData", "getHeaderBindingBase", "headerBindingBase", "LF8/o;", "getTitlebarDetailCommon", "()LF8/o;", "titlebarDetailCommon", "Lme/i;", "getCoroutineContext", "()Lme/i;", "coroutineContext", "getCommentAdapterPosition", "commentAdapterPosition", "Companion", "PlaylistDetailAdapter", "PlaylistItemDecoration", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class PlaylistDetailBaseFragment extends DetailSongMetaContentBaseFragment implements CoroutineScope {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/detail/PlaylistDetailBaseFragment$Companion;", "", "<init>", "()V", "TAG", "", "MAX_SONG_COUNT", "", "CONTENT_ITEM_MAX_COUNT", "ARG_ABS_TRANSLATION_Y", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u00B4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0096\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B)\b\u0000\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0007\u001A\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0006\u0018\u00010\u0005\u00A2\u0006\u0004\b\b\u0010\tJ\'\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000EH\u0014\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0014\u001A\u00020\u0013H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u0017\u001A\u00020\u00162\n\u0010\u0019\u001A\u00060\u0018R\u00020\u0002H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ#\u0010\u001E\u001A\u00020\u001D2\u0006\u0010\u0017\u001A\u00020\u00162\n\u0010\u0019\u001A\u00060\u0018R\u00020\u0002H\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FJ#\u0010!\u001A\u00020 2\u0006\u0010\u0017\u001A\u00020\u00162\n\u0010\u0019\u001A\u00060\u0018R\u00020\u0002H\u0016\u00A2\u0006\u0004\b!\u0010\"J#\u0010$\u001A\u00020#2\u0006\u0010\u0017\u001A\u00020\u00162\n\u0010\u0019\u001A\u00060\u0018R\u00020\u0002H\u0016\u00A2\u0006\u0004\b$\u0010%J#\u0010\'\u001A\u00020&2\u0006\u0010\u0017\u001A\u00020\u00162\n\u0010\u0019\u001A\u00060\u0018R\u00020\u0002H\u0016\u00A2\u0006\u0004\b\'\u0010(J#\u0010)\u001A\u00020&2\u0006\u0010\u0017\u001A\u00020\u00162\n\u0010\u0019\u001A\u00060\u0018R\u00020\u0002H\u0016\u00A2\u0006\u0004\b)\u0010(J#\u0010+\u001A\u00020*2\u0006\u0010\u0017\u001A\u00020\u00162\n\u0010\u0019\u001A\u00060\u0018R\u00020\u0002H\u0016\u00A2\u0006\u0004\b+\u0010,J#\u0010.\u001A\u00020-2\u0006\u0010\u0017\u001A\u00020\u00162\n\u0010\u0019\u001A\u00060\u0018R\u00020\u0002H\u0016\u00A2\u0006\u0004\b.\u0010/J#\u00101\u001A\u0002002\u0006\u0010\u0017\u001A\u00020\u00162\n\u0010\u0019\u001A\u00060\u0018R\u00020\u0002H\u0016\u00A2\u0006\u0004\b1\u00102J#\u00103\u001A\u00020&2\u0006\u0010\u0017\u001A\u00020\u00162\n\u0010\u0019\u001A\u00060\u0018R\u00020\u0002H\u0016\u00A2\u0006\u0004\b3\u0010(J#\u00105\u001A\u0002042\u0006\u0010\u0017\u001A\u00020\u00162\n\u0010\u0019\u001A\u00060\u0018R\u00020\u0002H\u0016\u00A2\u0006\u0004\b5\u00106J%\u00108\u001A\u0004\u0018\u0001072\u0006\u0010\u0017\u001A\u00020\u00162\n\u0010\u0019\u001A\u00060\u0018R\u00020\u0002H\u0016\u00A2\u0006\u0004\b8\u00109J#\u0010;\u001A\u00020:2\u0006\u0010\u0017\u001A\u00020\u00162\n\u0010\u0019\u001A\u00060\u0018R\u00020\u0002H\u0016\u00A2\u0006\u0004\b;\u0010<J%\u0010>\u001A\u0004\u0018\u00010=2\u0006\u0010\u0017\u001A\u00020\u00162\n\u0010\u0019\u001A\u00060\u0018R\u00020\u0002H\u0016\u00A2\u0006\u0004\b>\u0010?R\"\u0010A\u001A\u00020@8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bA\u0010B\u001A\u0004\bC\u0010D\"\u0004\bE\u0010F\u00A8\u0006G"}, d2 = {"Lcom/iloen/melon/fragments/detail/PlaylistDetailBaseFragment$PlaylistDetailAdapter;", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$DetailAdapter;", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment;", "Landroid/content/Context;", "context", "", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "list", "<init>", "(Lcom/iloen/melon/fragments/detail/PlaylistDetailBaseFragment;Landroid/content/Context;Ljava/util/List;)V", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "Lie/H;", "addEmptySongList", "()V", "Landroid/view/ViewGroup;", "parent", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/detail/viewholder/SongListHeaderHolder;", "getSongListHeaderHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/SongListHeaderHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/SongListFooterHolder;", "getSongListFooterHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/SongListFooterHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/MagazineHolder;", "getMagazineHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/MagazineHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/StationHolder;", "getStationHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/StationHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/PlaylistHolder;", "getPlaylistRelationPlaylistHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/PlaylistHolder;", "getPlaylistSeriesPlaylistHolder", "Lcom/iloen/melon/fragments/detail/viewholder/PlaylistRelationContentHolder;", "getPlaylistRelationContentHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/PlaylistRelationContentHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/PlaylistTagHolder;", "getTagHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/PlaylistTagHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/PlaylistBannerHolder;", "getPlaylistBannerHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/PlaylistBannerHolder;", "getPlaylistBrandPlaylistHolder", "Lcom/iloen/melon/fragments/detail/viewholder/PlaylistMixHolder;", "getPlaylistMixHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/PlaylistMixHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailCommentItemHolder;", "getCommentHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/DetailCommentItemHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/EmptyCommentHolder;", "getEmptyCommentHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/EmptyCommentHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/SongListEmptyHolder;", "getSongListEmptyHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/SongListEmptyHolder;", "", "commentPosition", "I", "getCommentPosition", "()I", "setCommentPosition", "(I)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public class PlaylistDetailAdapter extends DetailAdapter {
        private int commentPosition;

        public PlaylistDetailAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
            this.commentPosition = -1;
        }

        public void addEmptySongList() {
            a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
            a0.a = 51;
            a0.b = new SongListEmptyData(null, PlaylistDetailBaseFragment.this.getSongCount() > 1, 1, null);
            a0.c = PlaylistDetailBaseFragment.this.mMenuId;
            this.add(0, new AdapterInViewHolder.Row(a0));
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @Nullable
        public DetailCommentItemHolder getCommentHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return DetailCommentItemHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        public final int getCommentPosition() {
            return this.commentPosition;
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public EmptyCommentHolder getEmptyCommentHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return com.iloen.melon.fragments.detail.viewholder.EmptyCommentHolder.Companion.newInstance$default(EmptyCommentHolder.Companion, viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0, false, 4, null);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public MagazineHolder getMagazineHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return AlbumMagazineHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public PlaylistBannerHolder getPlaylistBannerHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return PlaylistBannerHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public PlaylistHolder getPlaylistBrandPlaylistHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return PlaylistBrandPlaylistHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public PlaylistMixHolder getPlaylistMixHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return PlaylistMixHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public PlaylistRelationContentHolder getPlaylistRelationContentHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return PlaylistRelationContentHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public PlaylistHolder getPlaylistRelationPlaylistHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return PlaylistRelationPlaylistHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public PlaylistHolder getPlaylistSeriesPlaylistHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return PlaylistSeriesPlaylistHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @Nullable
        public SongListEmptyHolder getSongListEmptyHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return SongListEmptyHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public SongListFooterHolder getSongListFooterHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return SongListFooterHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public SongListHeaderHolder getSongListHeaderHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return SongListHeaderHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public StationHolder getStationHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return PlaylistBrandStationHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        @NotNull
        public PlaylistTagHolder getTagHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return PlaylistTagHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$DetailAdapter
        public boolean handleResponse(@NotNull String s, @NotNull i i0, @NotNull HttpResponse httpResponse0) {
            ArrayList arrayList2;
            q.g(s, "key");
            q.g(i0, "type");
            q.g(httpResponse0, "response");
            PlaylistDetailBaseFragment.this.getHeaderData().setTotPlayTime(PlaylistDetailBaseFragment.this.getTotalPlayTime());
            PlaylistDetailBaseFragment.this.getHeaderData().setTotSongCnt(PlaylistDetailBaseFragment.this.getTotalSongCount());
            if(httpResponse0 instanceof MelonDjPlaylistListSongRes) {
                RESPONSE melonDjPlaylistListSongRes$RESPONSE0 = ((MelonDjPlaylistListSongRes)httpResponse0).response;
                if(melonDjPlaylistListSongRes$RESPONSE0 == null) {
                    return true;
                }
                StatsElementsBase statsElementsBase0 = ((MelonDjPlaylistListSongRes)httpResponse0).getStatsElements();
                PlaylistDetailBaseFragment.this.setStatsElementsBase(statsElementsBase0);
                PlaylistDetailBaseFragment.this.setSongList(melonDjPlaylistListSongRes$RESPONSE0.songList);
                List list0 = PlaylistDetailBaseFragment.this.getSongList();
                PlaylistDetailBaseFragment.this.setSongCount((list0 == null ? 0 : list0.size()));
            }
            if(httpResponse0 instanceof ArtistPlylstSongListRes) {
                com.iloen.melon.net.v4x.response.ArtistPlylstSongListRes.RESPONSE artistPlylstSongListRes$RESPONSE0 = ((ArtistPlylstSongListRes)httpResponse0).response;
                if(artistPlylstSongListRes$RESPONSE0 == null) {
                    return true;
                }
                StatsElementsBase statsElementsBase1 = ((ArtistPlylstSongListRes)httpResponse0).getStatsElements();
                PlaylistDetailBaseFragment.this.setStatsElementsBase(statsElementsBase1);
                PlaylistDetailBaseFragment.this.setSongList(artistPlylstSongListRes$RESPONSE0.songList);
                List list1 = PlaylistDetailBaseFragment.this.getSongList();
                PlaylistDetailBaseFragment.this.setSongCount((list1 == null ? 0 : list1.size()));
            }
            if(httpResponse0 instanceof MyMusicPlaylistListSongRes) {
                com.iloen.melon.net.v6x.response.MyMusicPlaylistListSongRes.RESPONSE myMusicPlaylistListSongRes$RESPONSE0 = ((MyMusicPlaylistListSongRes)httpResponse0).response;
                if(myMusicPlaylistListSongRes$RESPONSE0 == null) {
                    return true;
                }
                StatsElementsBase statsElementsBase2 = ((MyMusicPlaylistListSongRes)httpResponse0).getStatsElements();
                PlaylistDetailBaseFragment.this.setStatsElementsBase(statsElementsBase2);
                PlaylistDetailBaseFragment.this.setSongList(myMusicPlaylistListSongRes$RESPONSE0.songList);
                List list2 = PlaylistDetailBaseFragment.this.getSongList();
                PlaylistDetailBaseFragment.this.setSongCount((list2 == null ? 0 : list2.size()));
            }
            if(httpResponse0 instanceof ForUDetailRes) {
                com.iloen.melon.net.v6x.response.ForUDetailRes.RESPONSE forUDetailRes$RESPONSE0 = ((ForUDetailRes)httpResponse0).response;
                if(forUDetailRes$RESPONSE0 == null) {
                    return true;
                }
                PlaylistDetailBaseFragment.this.setSongList(forUDetailRes$RESPONSE0.list);
                List list3 = PlaylistDetailBaseFragment.this.getSongList();
                PlaylistDetailBaseFragment.this.setSongCount((list3 == null ? 0 : list3.size()));
            }
            PlaylistDetailBaseFragment.this.showWhenSongListHeader(PlaylistDetailBaseFragment.this.getSongCount() > 0);
            this.setHasMore(false);
            this.setMenuId(PlaylistDetailBaseFragment.this.mMenuId);
            this.setStatsElements(PlaylistDetailBaseFragment.this.getStatsElementsBase());
            this.updateModifiedTime(s);
            List list4 = PlaylistDetailBaseFragment.this.getSongList();
            if(list4 != null) {
                PlaylistDetailBaseFragment playlistDetailBaseFragment0 = PlaylistDetailBaseFragment.this;
                for(Object object0: list4) {
                    if(object0 instanceof SongInfoBase && ((SongInfoBase)object0).canService) {
                        playlistDetailBaseFragment0.setSongListAvailable(true);
                    }
                }
            }
            if(PlaylistDetailBaseFragment.this.getSongCount() > 0 && (httpResponse0 instanceof MelonDjPlaylistListSongRes || httpResponse0 instanceof ArtistPlylstSongListRes || httpResponse0 instanceof MyMusicPlaylistListSongRes || httpResponse0 instanceof ForUDetailRes)) {
                ArrayList arrayList0 = new ArrayList();
                PlaylistDetailBaseFragment.this.setSongListPage(1);
                List list5 = PlaylistDetailBaseFragment.this.getSongList();
                if(list5 != null) {
                    PlaylistDetailBaseFragment playlistDetailBaseFragment1 = PlaylistDetailBaseFragment.this;
                    int v = 0;
                    for(Object object1: list5) {
                        if(v >= 0) {
                            if(v < 100) {
                                a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                                a0.a = 1;
                                a0.b = object1;
                                a0.c = playlistDetailBaseFragment1.mMenuId;
                                l1.z(a0, arrayList0);
                            }
                            ++v;
                            continue;
                        }
                        k.O();
                        throw null;
                    }
                }
                Integer integer0 = v.t0(v.p0(PlaylistDetailBaseFragment.this.getTotalSongCount(), ",", ""));
                if((integer0 == null ? 0 : ((int)integer0)) > 100) {
                    PlaylistDetailBaseFragment.this.setFooterPosition(arrayList0.size());
                    a a1 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                    a1.a = 35;
                    PAGE detailBaseRes$PAGE0 = new PAGE();
                    detailBaseRes$PAGE0.isEnd = true;
                    a1.b = detailBaseRes$PAGE0;
                    a1.c = PlaylistDetailBaseFragment.this.mMenuId;
                    l1.z(a1, arrayList0);
                }
                this.addAll(arrayList0);
            }
            if(PlaylistDetailBaseFragment.this.getDjPlaylistInfoRes() != null) {
                ArrayList arrayList1 = new ArrayList();
                DjPlaylistInformRes djPlaylistInformRes0 = PlaylistDetailBaseFragment.this.getDjPlaylistInfoRes();
                if(djPlaylistInformRes0 == null) {
                    return true;
                }
                com.iloen.melon.net.v6x.response.DjPlaylistInformRes.RESPONSE djPlaylistInformRes$RESPONSE0 = djPlaylistInformRes0.response;
                if(djPlaylistInformRes$RESPONSE0 == null) {
                    return true;
                }
                if(djPlaylistInformRes$RESPONSE0.menuId != null && djPlaylistInformRes$RESPONSE0.menuId.length() > 0) {
                    PlaylistDetailBaseFragment.this.mMenuId = djPlaylistInformRes$RESPONSE0.menuId;
                }
                DjBrandBannerRes djBrandBannerRes0 = PlaylistDetailBaseFragment.this.getMiddleBannerRes();
                if(djBrandBannerRes0 != null && (djBrandBannerRes0.response != null && (djBrandBannerRes0.response.bannerList != null && !djBrandBannerRes0.response.bannerList.isEmpty() == 1))) {
                    a a2 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                    a2.a = 36;
                    DjBrandBannerRes djBrandBannerRes1 = PlaylistDetailBaseFragment.this.getMiddleBannerRes();
                    if(djBrandBannerRes1 == null) {
                        arrayList2 = null;
                    }
                    else {
                        com.iloen.melon.net.v5x.response.DjBrandBannerRes.RESPONSE djBrandBannerRes$RESPONSE0 = djBrandBannerRes1.response;
                        arrayList2 = djBrandBannerRes$RESPONSE0 == null ? null : djBrandBannerRes$RESPONSE0.bannerList;
                    }
                    a2.b = arrayList2;
                    a2.c = PlaylistDetailBaseFragment.this.mMenuId;
                    l1.z(a2, arrayList1);
                }
                if(djPlaylistInformRes$RESPONSE0.tagList != null && !djPlaylistInformRes$RESPONSE0.tagList.isEmpty() == 1) {
                    a a3 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                    a3.a = 18;
                    a3.b = djPlaylistInformRes$RESPONSE0.tagList;
                    a3.e = PlaylistDetailBaseFragment.this.getPlaylistSeq();
                    a3.c = PlaylistDetailBaseFragment.this.mMenuId;
                    l1.z(a3, arrayList1);
                }
                if(djPlaylistInformRes$RESPONSE0.brandPlaylists != null && !djPlaylistInformRes$RESPONSE0.brandPlaylists.isEmpty() == 1) {
                    a a4 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                    a4.a = 37;
                    List list6 = djPlaylistInformRes$RESPONSE0.brandPlaylists;
                    q.f(list6, "brandPlaylists");
                    a4.b = p.K0(3, list6);
                    a4.e = djPlaylistInformRes$RESPONSE0.djplaylist.memberKey;
                    a4.f = djPlaylistInformRes$RESPONSE0.topMemberNm;
                    a4.g = djPlaylistInformRes$RESPONSE0.brandPlaylists.size() > 3;
                    a4.c = PlaylistDetailBaseFragment.this.mMenuId;
                    l1.z(a4, arrayList1);
                }
                if(djPlaylistInformRes$RESPONSE0.brandStations != null && !djPlaylistInformRes$RESPONSE0.brandStations.isEmpty() == 1) {
                    a a5 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                    a5.a = 7;
                    List list7 = djPlaylistInformRes$RESPONSE0.brandStations;
                    q.f(list7, "brandStations");
                    a5.b = p.K0(3, list7);
                    a5.e = djPlaylistInformRes$RESPONSE0.djplaylist.memberKey;
                    a5.f = djPlaylistInformRes$RESPONSE0.topMemberNm;
                    a5.g = djPlaylistInformRes$RESPONSE0.brandStations.size() > 3;
                    a5.c = PlaylistDetailBaseFragment.this.mMenuId;
                    l1.z(a5, arrayList1);
                }
                if(djPlaylistInformRes$RESPONSE0.seriesPlaylists != null && !djPlaylistInformRes$RESPONSE0.seriesPlaylists.isEmpty() == 1) {
                    a a6 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                    a6.a = 28;
                    List list8 = djPlaylistInformRes$RESPONSE0.seriesPlaylists;
                    q.f(list8, "seriesPlaylists");
                    a6.b = p.K0(3, list8);
                    a6.e = djPlaylistInformRes$RESPONSE0.djplaylist.getSeriesPlylstSeq();
                    a6.g = djPlaylistInformRes$RESPONSE0.seriesPlaylists.size() > 3;
                    a6.c = PlaylistDetailBaseFragment.this.mMenuId;
                    l1.z(a6, arrayList1);
                }
                if(djPlaylistInformRes$RESPONSE0.relationPlaylists != null && !djPlaylistInformRes$RESPONSE0.relationPlaylists.isEmpty() == 1) {
                    a a7 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                    a7.a = 29;
                    List list9 = djPlaylistInformRes$RESPONSE0.relationPlaylists;
                    q.f(list9, "relationPlaylists");
                    a7.b = p.K0(3, list9);
                    a7.e = PlaylistDetailBaseFragment.this.getPlaylistSeq();
                    a7.c = PlaylistDetailBaseFragment.this.mMenuId;
                    l1.z(a7, arrayList1);
                }
                if(djPlaylistInformRes$RESPONSE0.relationContentList != null && !djPlaylistInformRes$RESPONSE0.relationContentList.isEmpty() == 1) {
                    a a8 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                    a8.a = 19;
                    List list10 = djPlaylistInformRes$RESPONSE0.relationContentList;
                    q.f(list10, "relationContentList");
                    a8.b = p.K0(3, list10);
                    a8.e = PlaylistDetailBaseFragment.this.getPlaylistSeq();
                    a8.c = PlaylistDetailBaseFragment.this.mMenuId;
                    l1.z(a8, arrayList1);
                }
                this.addAll(arrayList1);
            }
            if(httpResponse0 instanceof ForUDetailRes) {
                ArrayList arrayList3 = new ArrayList();
                com.iloen.melon.net.v6x.response.ForUDetailRes.RESPONSE forUDetailRes$RESPONSE1 = ((ForUDetailRes)httpResponse0).response;
                if(forUDetailRes$RESPONSE1 == null) {
                    return true;
                }
                if(forUDetailRes$RESPONSE1.list == null || forUDetailRes$RESPONSE1.list.isEmpty()) {
                    a a9 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                    a9.a = 51;
                    a9.b = new SongListEmptyData(null, forUDetailRes$RESPONSE1.tagList != null && !forUDetailRes$RESPONSE1.tagList.isEmpty() == 1 || forUDetailRes$RESPONSE1.listArtistForU != null && !forUDetailRes$RESPONSE1.listArtistForU.isEmpty() == 1, 1, null);
                    a9.c = PlaylistDetailBaseFragment.this.mMenuId;
                    l1.z(a9, arrayList3);
                }
                if(forUDetailRes$RESPONSE1.tagList != null && !forUDetailRes$RESPONSE1.tagList.isEmpty() == 1) {
                    a a10 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                    a10.a = 18;
                    a10.b = forUDetailRes$RESPONSE1.tagList;
                    a10.e = PlaylistDetailBaseFragment.this.getPlaylistSeq();
                    a10.c = PlaylistDetailBaseFragment.this.mMenuId;
                    l1.z(a10, arrayList3);
                }
                if(forUDetailRes$RESPONSE1.listArtistForU != null && !forUDetailRes$RESPONSE1.listArtistForU.isEmpty() == 1) {
                    a a11 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                    a11.a = 40;
                    a11.b = forUDetailRes$RESPONSE1.listArtistForU;
                    a11.c = PlaylistDetailBaseFragment.this.mMenuId;
                    l1.z(a11, arrayList3);
                }
                this.addAll(arrayList3);
            }
            this.commentPosition = this.getCount();
            return true;
        }

        public final void setCommentPosition(int v) {
            this.commentPosition = v;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\r\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/detail/PlaylistDetailBaseFragment$PlaylistItemDecoration;", "Landroidx/recyclerview/widget/r0;", "<init>", "()V", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/K0;", "state", "Lie/H;", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/K0;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class PlaylistItemDecoration extends r0 {
        @Override  // androidx.recyclerview.widget.r0
        public void getItemOffsets(@NotNull Rect rect0, @NotNull View view0, @NotNull RecyclerView recyclerView0, @NotNull K0 k00) {
            q.g(rect0, "outRect");
            q.g(view0, "view");
            q.g(recyclerView0, "parent");
            q.g(k00, "state");
            Context context0 = view0.getContext();
            int v = recyclerView0.getChildAdapterPosition(view0);
            j0 j00 = recyclerView0.getAdapter();
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment.PlaylistDetailAdapter");
            if(v == ((PlaylistDetailAdapter)j00).getItemCount() - 1) {
                rect0.bottom = ScreenUtils.dipToPixel(context0, 40.0f);
            }
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[M.values().length];
            try {
                arr_v[6] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[8] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[1] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[3] = 4;
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

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_ABS_TRANSLATION_Y = "argAbsTranslationY";
    public static final int CONTENT_ITEM_MAX_COUNT = 3;
    @NotNull
    public static final Companion Companion = null;
    public static final int MAX_SONG_COUNT = 100;
    @NotNull
    public static final String TAG = "PlaylistDetailBaseFragment";
    private float absTranslationY;
    @Nullable
    private F8.p backButton;
    @NotNull
    private String bbsChannelSeq;
    @NotNull
    private final j bottomBtnData$delegate;
    private int commentCount;
    public DetailAdapter detailAdapter;
    @Nullable
    private DjPlaylistInformRes djPlaylistInfoRes;
    private int footerPosition;
    @NotNull
    private HeaderData headerData;
    private int headerPosition;
    private boolean isBrandDj;
    private final boolean isDj;
    private boolean isLike;
    private boolean isSongListAvailable;
    private int likeCount;
    @Nullable
    private DjBrandBannerRes middleBannerRes;
    @Nullable
    private I moreButton;
    @NotNull
    private String ownerMemberKey;
    @Nullable
    private E2 playlistDetailHeaderBinding;
    @NotNull
    private String playlistSeq;
    private int songCount;
    @Nullable
    private List songList;
    private int songListPage;
    @Nullable
    private StatsElementsBase statsElementsBase;
    private int statusBarHeight;
    @NotNull
    private String titleText;
    @NotNull
    private String totalPlayTime;
    @NotNull
    private String totalSongCount;

    static {
        PlaylistDetailBaseFragment.Companion = new Companion(null);
        PlaylistDetailBaseFragment.$stable = 8;
    }

    public PlaylistDetailBaseFragment() {
        this.playlistSeq = "";
        this.ownerMemberKey = "";
        this.titleText = "";
        this.totalSongCount = "";
        this.totalPlayTime = "";
        this.likeCount = -1;
        this.bbsChannelSeq = "";
        this.songListPage = 1;
        this.headerData = new HeaderData(null, null, 3, null);
        this.bottomBtnData$delegate = g.Q(new b(this, 5));

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0005\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"com/iloen/melon/fragments/detail/PlaylistDetailBaseFragment$bottomBtnData$2$2", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$BottomBtnClickListener;", "Lie/H;", "onShuffleSongClick", "()V", "onPlayAllSongClick", "onMixUpPlayClick", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment.bottomBtnData.2.2 implements BottomBtnClickListener {
            public com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment.bottomBtnData.2.2(PlaylistDetailBaseFragment playlistDetailBaseFragment0) {
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$BottomBtnClickListener
            public void onAddSongClick() {
                BottomBtnClickListener.super.onAddSongClick();
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$BottomBtnClickListener
            public void onMixUpPlayClick() {
                BottomBtnClickListener.super.onMixUpPlayClick();
                String s = PlaylistDetailBaseFragment.this.getMenuId();
                R0 r00 = new R0(PlaylistDetailBaseFragment.this.getPlaylistSeq(), PlaylistDetailBaseFragment.this.getTitleText(), PlaylistDetailBaseFragment.this.getStatsElementsBase());
                PlaylistDetailBaseFragment.this.playMixUp(s, r00);
                PlaylistDetailBaseFragment.this.mixUpPlayClickLog();
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$BottomBtnClickListener
            public void onPlayAllSongClick() {
                PlaylistDetailBaseFragment.this.contextMenuCheckSongList(M.b);
                PlaylistDetailBaseFragment.access$setSelectAllWithToolbar(PlaylistDetailBaseFragment.this, false);
                PlaylistDetailBaseFragment.this.playAllClickLog();
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$BottomBtnClickListener
            public void onPlaySongClick() {
                BottomBtnClickListener.super.onPlaySongClick();
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$BottomBtnClickListener
            public void onShuffleSongClick() {
                PlaylistDetailBaseFragment.this.contextMenuCheckSongList(M.d);
                PlaylistDetailBaseFragment.access$setSelectAllWithToolbar(PlaylistDetailBaseFragment.this, false);
                PlaylistDetailBaseFragment.this.playShuffleClickLog();
            }
        }

    }

    public static final void access$setSelectAllWithToolbar(PlaylistDetailBaseFragment playlistDetailBaseFragment0, boolean z) {
        playlistDetailBaseFragment0.setSelectAllWithToolbar(z);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void addAll() {
        FragmentActivity fragmentActivity0 = this.getActivity();
        String s = this.getContsId();
        String s1 = this.getMenuId();
        q.f(s1, "getMenuId(...)");
        Playlist playDataForSeverContent$Playlist0 = new Playlist(s, s1, this.statsElementsBase);
        AddToPlaylistUIHelperKt.addPlaylistAndReturnAction$default(fragmentActivity0, new AddServerContent(Add.INSTANCE, false, false, this.blockingProgressDialogManage, playDataForSeverContent$Playlist0, 6, null), false, 2, null);
    }

    public final void addOrDeleteFriend(@NotNull String s, boolean z) {
        q.g(s, "memberKey");
        this.addOrDeleteFriend(s, this.getMenuId(), !z, new X8.a() {
            @Override  // X8.a
            public void onJobComplete(String s) {
                if(PlaylistDetailBaseFragment.this.isFragmentValid() && TextUtils.isEmpty(s)) {
                    PlaylistDetailBaseFragment.this.onFriendStatusChanged();
                    PlaylistDetailBaseFragment.this.removeDetailCache();
                }
            }
        });
    }

    public void allSelectClickLog() {
        this.itemClickLog(null, this.getString(0x7F130DD0), this.getString(0x7F130DFF), this.getString(0x7F130D93));  // string:tiara_common_action_name_select "선택"
    }

    private static final BottomBtnData bottomBtnData_delegate$lambda$2(PlaylistDetailBaseFragment playlistDetailBaseFragment0) {
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(new BottomBtnInfo(10002, 0.0f, null, 4, null));
        if(q.b("N10016", "")) {
            arrayList0.add(new BottomBtnInfo(10001, 0.0f, null, 4, null));
        }
        else {
            arrayList0.add(new BottomBtnInfo(10001, 0.0f, null, 4, null));
            if(playlistDetailBaseFragment0.isDj()) {
                arrayList0.add(new BottomBtnInfo(10004, 0.0f, null, 4, null));
                return new BottomBtnData(11.0f, arrayList0, new com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment.bottomBtnData.2.2(playlistDetailBaseFragment0));
            }
        }
        return new BottomBtnData(11.0f, arrayList0, new com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment.bottomBtnData.2.2(playlistDetailBaseFragment0));
    }

    public void contextMenuCheckSongList(@NotNull M m0) {
        q.g(m0, "type");
        this.showProgress(true);
        RequestBuilder.newInstance(this.getPlaylistSongListRequest(m0)).tag(this.getRequestTag()).listener(new com.iloen.melon.fragments.detail.a(13, this, m0)).errorListener(new E(this, 1)).request();
    }

    private static final void contextMenuCheckSongList$lambda$23(PlaylistDetailBaseFragment playlistDetailBaseFragment0, M m0, PlaylistListSongBaseRes playlistListSongBaseRes0) {
        ArrayList arrayList0;
        boolean z = false;
        playlistDetailBaseFragment0.showProgress(false);
        if(playlistListSongBaseRes0 == null) {
            arrayList0 = null;
        }
        else {
            com.iloen.melon.net.v6x.response.PlaylistListSongBaseRes.RESPONSE playlistListSongBaseRes$RESPONSE0 = playlistListSongBaseRes0.response;
            arrayList0 = playlistListSongBaseRes$RESPONSE0 == null ? null : playlistListSongBaseRes$RESPONSE0.songList;
        }
        if(playlistListSongBaseRes0 != null && playlistListSongBaseRes0.isSuccessful(true) && arrayList0 != null) {
            for(Object object0: arrayList0) {
                if(((SONGLIST)object0).canService) {
                    z = true;
                }
            }
        }
        if(z) {
            switch(m0.ordinal()) {
                case 1: {
                    playlistDetailBaseFragment0.playPlaylist(playlistDetailBaseFragment0.playlistSeq, "", playlistDetailBaseFragment0.getMenuId(), false, false, playlistDetailBaseFragment0.statsElementsBase);
                    break;
                }
                case 3: {
                    playlistDetailBaseFragment0.playPlaylist(playlistDetailBaseFragment0.playlistSeq, "", playlistDetailBaseFragment0.getMenuId(), false, true, playlistDetailBaseFragment0.statsElementsBase);
                    return;
                }
                case 4: {
                    playlistDetailBaseFragment0.playMixUp(playlistDetailBaseFragment0.getMenuId(), new R0(playlistDetailBaseFragment0.playlistSeq, playlistDetailBaseFragment0.titleText, playlistDetailBaseFragment0.statsElementsBase));
                    return;
                }
                case 6: {
                    playlistDetailBaseFragment0.downloadAll();
                    return;
                }
                case 8: {
                    playlistDetailBaseFragment0.showContextMenuAddTo();
                }
            }
        }
    }

    private static final void contextMenuCheckSongList$lambda$24(PlaylistDetailBaseFragment playlistDetailBaseFragment0, VolleyError volleyError0) {
        playlistDetailBaseFragment0.showProgress(false);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        this.setDetailAdapter(new PlaylistDetailAdapter(this, context0, null));
        this.getDetailAdapter().setMarkedMode(true);
        this.getDetailAdapter().setListContentType(1);
        return this.getDetailAdapter();
    }

    public void downloadAll() {
        this.downloadPlaylist(this.getContsId(), this.getMenuId());
    }

    public final float getAbsTranslationY() {
        return this.absTranslationY;
    }

    @Nullable
    public final F8.p getBackButton() {
        return this.backButton;
    }

    @NotNull
    public final String getBbsChannelSeq() {
        return this.bbsChannelSeq;
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public BottomBtnData getBottomBtnData() {
        return (BottomBtnData)this.bottomBtnData$delegate.getValue();
    }

    // 去混淆评级： 低(34)
    @NotNull
    public final String getCleanServiceCode() {
        if(q.b("", "N10009")) {
            q.d("DJPLAYLIST");
            return "DJPLAYLIST";
        }
        if(q.b("", "N10005")) {
            q.d("PLAYLIST");
            return "PLAYLIST";
        }
        return "";
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public int getCommentAdapterPosition() {
        j0 j00 = this.getAdapter();
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment.PlaylistDetailAdapter");
        return ((PlaylistDetailAdapter)j00).getCommentPosition();
    }

    public final int getCommentCount() {
        return this.commentCount;
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public String getContsId() {
        return this.playlistSeq;
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public String getContsTypeCode() [...] // 潜在的解密器

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment, kotlinx.coroutines.CoroutineScope
    @NotNull
    public me.i getCoroutineContext() {
        return Dispatchers.getIO();
    }

    @NotNull
    public final DetailAdapter getDetailAdapter() {
        DetailAdapter detailSongMetaContentBaseFragment$DetailAdapter0 = this.detailAdapter;
        if(detailSongMetaContentBaseFragment$DetailAdapter0 != null) {
            return detailSongMetaContentBaseFragment$DetailAdapter0;
        }
        q.m("detailAdapter");
        throw null;
    }

    @Nullable
    public final DjPlaylistInformRes getDjPlaylistInfoRes() {
        return this.djPlaylistInfoRes;
    }

    public final int getFooterPosition() {
        return this.footerPosition;
    }

    @Nullable
    public E2 getHeaderBinding() {
        Q4.a a0 = this.getHeaderBindingBase();
        q.e(a0, "null cannot be cast to non-null type com.iloen.melon.databinding.PlaylistDetailHeaderBinding");
        return (E2)a0;
    }

    @Nullable
    public final Q4.a getHeaderBindingBase() {
        return this.get_headerBinding();
    }

    @NotNull
    public final HeaderData getHeaderData() {
        return this.headerData;
    }

    public final int getHeaderPosition() {
        return this.headerPosition;
    }

    public final int getLikeCount() {
        return this.likeCount;
    }

    @Nullable
    public final DjBrandBannerRes getMiddleBannerRes() {
        return this.middleBannerRes;
    }

    @Nullable
    public final I getMoreButton() {
        return this.moreButton;
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public OnViewHolderActionListener getOnViewHolderActionListener() {
        return new OnViewHolderActionListener() {
            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$OnViewHolderActionListener
            public void onAllSelectListener(boolean z) {
                PlaylistDetailBaseFragment.this.toggleSelectAll();
                PlaylistDetailBaseFragment.this.allSelectClickLog();
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$OnViewHolderActionListener
            public void onPlayForUSongListener(String s, String s1, StatsElementsBase statsElementsBase0) {
                String s2 = PlaylistDetailBaseFragment.this.getMenuId();
                PlaylistDetailBaseFragment.this.playForUSong(s, s1, s2, statsElementsBase0);
            }

            // 去混淆评级： 低(25)
            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$OnViewHolderActionListener
            public void onSongListViewAll() {
                if(q.b("", "N10005")) {
                    Navigator.open(PlaylistDetailContentsAllSongFragment.Companion.newInstance(PlaylistDetailBaseFragment.this.getPlaylistSeq(), PlaylistDetailBaseFragment.this.getTitleText(), "", ""));
                }
                else if(q.b("", "N10009")) {
                    Navigator.open(DjPlaylistDetailContentsAllSongFragment.Companion.newInstance(PlaylistDetailBaseFragment.this.getPlaylistSeq(), PlaylistDetailBaseFragment.this.getTitleText(), "", ""));
                }
                else if(q.b("", "N10016")) {
                    Navigator.open(ArtistPlaylistDetailContentsAllSongFragment.Companion.newInstance(PlaylistDetailBaseFragment.this.getPlaylistSeq(), PlaylistDetailBaseFragment.this.getTitleText(), "", ""));
                }
                PlaylistDetailBaseFragment.this.songListViewAllClickLog();
            }

            @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment$OnViewHolderActionListener
            public f onTiaraEventBuilder() {
                return PlaylistDetailBaseFragment.this.getTiaraEventBuilder();
            }
        };
    }

    @NotNull
    public final String getOwnerMemberKey() {
        return this.ownerMemberKey;
    }

    @NotNull
    public String getPageMetaType() {
        return "";
    }

    @Nullable
    public final E2 getPlaylistDetailHeaderBinding() {
        return this.playlistDetailHeaderBinding;
    }

    @NotNull
    public final String getPlaylistSeq() {
        return this.playlistSeq;
    }

    @NotNull
    public HttpRequest getPlaylistSongListRequest(@NotNull M m0) {
        q.g(m0, "type");
        switch(m0.ordinal()) {
            case 6: {
                return new MyMusicPlaylistDownloadListSongReq(this.getContext(), this.getContsId());
            }
            case 8: {
                return new MyMusicPlaylistScrapListSongReq(this.getContext(), this.getContsId());
            }
            default: {
                return new MyMusicPlaylistPlayListSongReq(this.getContext(), this.getContsId());
            }
        }
    }

    public final int getSongCount() {
        return this.songCount;
    }

    @Nullable
    public final List getSongList() {
        return this.songList;
    }

    public final int getSongListPage() {
        return this.songListPage;
    }

    @Nullable
    public final StatsElementsBase getStatsElementsBase() {
        return this.statsElementsBase;
    }

    @Nullable
    public f getTiaraEventBuilder() {
        return null;
    }

    @NotNull
    public final String getTitleText() {
        return this.titleText;
    }

    @NotNull
    public final o getTitlebarDetailCommon() {
        F8.p p0 = new F8.p(1);
        this.backButton = p0;
        p0.g(new m(2, false));
        return p0;
    }

    @NotNull
    public final String getTotalPlayTime() {
        return this.totalPlayTime;
    }

    @NotNull
    public final String getTotalSongCount() {
        return this.totalSongCount;
    }

    public void introduceMoreClickLog() {
        this.itemClickLog(null, this.getString(0x7F130DC9), this.getString(0x7F130DF5), this.getString(0x7F130E60));  // string:tiara_common_action_name_move_page "페이지이동"
    }

    public final boolean isBrandDj() {
        return this.isBrandDj;
    }

    public boolean isDj() {
        return this.isDj;
    }

    public final boolean isLike() {
        return this.isLike;
    }

    public final boolean isSongListAvailable() {
        return this.isSongListAvailable;
    }

    public void itemClickLog(@Nullable ActionKind actionKind0, @Nullable String s, @Nullable String s1, @Nullable String s2) {
        PlaylistDetailBaseFragment.itemClickLog$default(this, actionKind0, s, s1, s2, null, null, null, null, null, null, null, 0x400, null);
    }

    public void itemClickLog(@Nullable ActionKind actionKind0, @Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable Integer integer0, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8) {
    }

    public static void itemClickLog$default(PlaylistDetailBaseFragment playlistDetailBaseFragment0, ActionKind actionKind0, String s, String s1, String s2, Integer integer0, String s3, String s4, String s5, String s6, String s7, String s8, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: itemClickLog");
        }
        if((v & 1) != 0) {
            actionKind0 = null;
        }
        if((v & 2) != 0) {
            s = null;
        }
        if((v & 4) != 0) {
            s1 = null;
        }
        if((v & 8) != 0) {
            s2 = null;
        }
        if((v & 16) != 0) {
            integer0 = null;
        }
        if((v & 0x20) != 0) {
            s3 = null;
        }
        if((v & 0x40) != 0) {
            s4 = null;
        }
        if((v & 0x80) != 0) {
            s5 = null;
        }
        if((v & 0x100) != 0) {
            s6 = null;
        }
        if((v & 0x200) != 0) {
            s7 = null;
        }
        if((v & 0x400) != 0) {
            s8 = null;
        }
        playlistDetailBaseFragment0.itemClickLog(actionKind0, s, s1, s2, integer0, s3, s4, s5, s6, s7, s8);
    }

    public final int likeCountToInt(@Nullable String s) {
        if(s != null) {
            Integer integer0 = v.t0(v.p0(s, ",", ""));
            return integer0 == null ? 0 : ((int)integer0);
        }
        return 0;
    }

    private final void mixUpPlayClickLog() {
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
            f0.d = ActionKind.PlayMusic;
            f0.y = this.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
            f0.F = this.getString(0x7F130D53);  // string:tiara_click_copy_mixup "믹스업"
            f0.e = this.getContsId();
            f0.f = Y.i(ContsTypeCode.DJ_PLAYLIST_MIXUP, "code(...)");
            f0.g = this.titleText;
            f0.J = "1000003099";
            f0.a().track();
        }
    }

    public void moreClickLog() {
        this.itemClickLog(null, this.getString(0x7F130DC9), this.getString(0x7F130DF3), this.getString(0x7F130D54));  // string:tiara_common_action_name_move_page "페이지이동"
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onAppBarCollapsed() {
        this.getTitleBar().setTitle(this.titleText);
        this.getTitleBar().f(false);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onAppBarExpended() {
        if(this.absTranslationY <= 0.0f) {
            this.getTitleBar().setTitle("");
            this.getTitleBar().f(true);
        }
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onAppBarScrolling(int v) {
        this.absTranslationY = (float)Math.abs(v);
        float f = 0.0f;
        if(!ScreenUtils.isLandscape(this.getContext()) && !ScreenUtils.isTablet(this.getContext())) {
            float f1 = this.absTranslationY;
            if(f1 > 0.0f) {
                this.getTitleBar().setTitle(this.titleText);
                return;
            }
            if(f1 == 0.0f) {
                this.getTitleBar().setTitle("");
                this.getTitleBar().f(false);
            }
            return;
        }
        E2 e20 = this.playlistDetailHeaderBinding;
        if(e20 != null) {
            MelonTextView melonTextView0 = e20.I;
            if(melonTextView0 != null) {
                f = (float)melonTextView0.getHeight();
            }
        }
        if(this.absTranslationY >= f) {
            this.getTitleBar().setTitle(this.titleText);
            this.getTitleBar().f(true);
            return;
        }
        this.getTitleBar().setTitle("");
        this.getTitleBar().f(false);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        this.playlistDetailHeaderBinding = this.getHeaderBinding();
        if(!com.iloen.melon.responsecache.a.e(300000L, "", this.getContext())) {
            this.updateHeaderView();
            return;
        }
        this.onFetchStart(i.b, null, "");
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public Q4.a onCreateHeaderLayout() {
        return E2.a(LayoutInflater.from(this.getContext()));
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @Nullable
    public RecyclerView onCreateRecyclerView() {
        RecyclerView recyclerView0 = super.onCreateRecyclerView();
        if(recyclerView0 != null) {
            recyclerView0.addItemDecoration(new PlaylistItemDecoration());
            return recyclerView0;
        }
        return null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        return false;
    }

    public void onFriendStatusChanged() {
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        super.onRestoreInstanceState(bundle0);
        this.absTranslationY = bundle0.getFloat("argAbsTranslationY");
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putFloat("argAbsTranslationY", this.absTranslationY);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onStart() {
        super.onStart();
        if(!this.isFetchStart() && !com.iloen.melon.responsecache.a.e(300000L, "", this.getContext())) {
            this.updateHeaderView();
            this.setSelectAllWithToolbar(false);
        }
        this.setFetchStart(false);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.getBinding().d.setVisibility(8);
        this.getBinding().c.g.setVisibility(0);
        this.statusBarHeight = ScreenUtils.getStatusBarHeight(this.getContext());
    }

    public void openProfile() {
    }

    public void playAllClickLog() {
        this.itemClickLog(null, this.getString(0x7F130DCB), this.getString(0x7F130DFF), this.getString(0x7F130CF9));  // string:tiara_common_action_name_play_music "음악재생"
    }

    public final void playForUSong(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable StatsElementsBase statsElementsBase0) {
        this.showProgress(true);
        RequestBuilder.newInstance(new ForuPlayReq(this.getContext(), s, s1)).tag(this.getRequestTag()).listener(new B(this, s2, statsElementsBase0, 1)).errorListener(new E(this, 0)).request();
    }

    private static final void playForUSong$lambda$15(PlaylistDetailBaseFragment playlistDetailBaseFragment0, String s, StatsElementsBase statsElementsBase0, ForuPlayRes foruPlayRes0) {
        playlistDetailBaseFragment0.showProgress(false);
        if(foruPlayRes0 != null && foruPlayRes0.isSuccessful(false) && (foruPlayRes0.response != null && (foruPlayRes0.response.songList != null && !foruPlayRes0.response.songList.isEmpty() == 1))) {
            ArrayList arrayList0 = new ArrayList();
            com.iloen.melon.net.v6x.response.ForuPlayRes.RESPONSE foruPlayRes$RESPONSE0 = foruPlayRes0.response;
            if(foruPlayRes$RESPONSE0 != null) {
                List list0 = foruPlayRes$RESPONSE0.songList;
                if(list0 != null) {
                    for(Object object0: list0) {
                        arrayList0.add(Playable.from(((FORUSONG)object0), s, statsElementsBase0));
                    }
                }
            }
            playlistDetailBaseFragment0.playMixSongs(arrayList0);
        }
    }

    private static final void playForUSong$lambda$16(PlaylistDetailBaseFragment playlistDetailBaseFragment0, VolleyError volleyError0) {
        playlistDetailBaseFragment0.showProgress(false);
    }

    public void playShuffleClickLog() {
        this.itemClickLog(null, this.getString(0x7F130DCB), this.getString(0x7F130DFF), this.getString(0x7F130D9C));  // string:tiara_common_action_name_play_music "음악재생"
    }

    public static void r0(VolleyError volleyError0) {
        PlaylistDetailBaseFragment.setTitleBar$lambda$6$lambda$5(volleyError0);
    }

    public void removeDetailCache() {
    }

    public final void setAbsTranslationY(float f) {
        this.absTranslationY = f;
    }

    public final void setBackButton(@Nullable F8.p p0) {
        this.backButton = p0;
    }

    public final void setBbsChannelSeq(@NotNull String s) {
        q.g(s, "<set-?>");
        this.bbsChannelSeq = s;
    }

    public final void setBrandDj(boolean z) {
        this.isBrandDj = z;
    }

    public final void setCommentCount(int v) {
        this.commentCount = v;
    }

    public void setDescText(@Nullable TextView textView0, @NotNull String s, @Nullable SpannableString spannableString0, int v) {
        q.g(s, "text");
        if(textView0 != null) {
            textView0.setMaxLines(v + 1);
        }
        if(textView0 != null) {
            SpannableString spannableString1 = spannableString0 == null ? s : spannableString0;
            textView0.setText(spannableString1);
        }
        this.setDescText(textView0, s, spannableString0, v, 0);
    }

    public void setDescText(@Nullable TextView textView0, @NotNull String s, @Nullable SpannableString spannableString0, int v, int v1) {
        q.g(s, "text");
        if(v1 > 5) {
            if(textView0 != null) {
                textView0.setMaxLines(v);
            }
        }
        else if(textView0 != null) {
            textView0.post(new W0(textView0, v, this, s, spannableString0, v1, 3));
        }
    }

    public final void setDescText(@NotNull String s, @NotNull E2 e20) {
        q.g(s, "desc");
        q.g(e20, "headerBinding");
        this.setDescText(s, null, e20);
    }

    public final void setDescText(@NotNull String s, @Nullable SpannableString spannableString0, @NotNull E2 e20) {
        String s1;
        SpannableString spannableString1;
        q.g(s, "desc");
        q.g(e20, "headerBinding");
        MelonTextView melonTextView0 = e20.j;
        e20.i.setVisibility(0);
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = e20.i.getLayoutParams();
        q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((LayoutParams)viewGroup$LayoutParams0).Q = 0x7FFFFFFF;
        int v = s.length();
        if(spannableString0 == null) {
            String s2 = e.h(s, this.getString(0x7F130333));  // string:dj_playlist_desc_fold " 접기"
            s1 = s2;
            spannableString1 = new SpannableString(s2);
        }
        else {
            SpannableStringBuilder spannableStringBuilder0 = new SpannableStringBuilder(spannableString0).append(this.getString(0x7F130333));  // string:dj_playlist_desc_fold " 접기"
            q.f(spannableStringBuilder0, "append(...)");
            spannableString1 = SpannableString.valueOf(spannableStringBuilder0);
            s1 = s;
        }
        spannableString1.setSpan(new ForegroundColorSpan(ColorUtils.getColor(this.getContext(), 0x7F06016D)), v, s1.length(), 33);  // color:gray900s
        melonTextView0.setText(spannableString1);
        ViewUtils.setContentDescriptionWithButtonClassName(melonTextView0, melonTextView0.getText());
        T t0 = new T(e20, 4);
        e20.k.setOnClickListener(t0);
        this.setDescText(e20.m, s, spannableString0, 2);
        com.iloen.melon.fragments.detail.h h0 = new com.iloen.melon.fragments.detail.h(3, e20, this);
        e20.n.setOnClickListener(h0);
    }

    private static final void setDescText$lambda$11$lambda$10(E2 e20, PlaylistDetailBaseFragment playlistDetailBaseFragment0, View view0) {
        RelativeLayout relativeLayout0 = e20.k;
        if(e20.l.getVisibility() == 0) {
            e20.n.setVisibility(8);
            relativeLayout0.setVisibility(0);
            relativeLayout0.sendAccessibilityEvent(8);
            playlistDetailBaseFragment0.introduceMoreClickLog();
        }
    }

    private static final void setDescText$lambda$11$lambda$9(E2 e20, View view0) {
        e20.n.setVisibility(0);
        e20.k.setVisibility(8);
        e20.n.sendAccessibilityEvent(8);
    }

    private static final void setDescText$lambda$12(TextView textView0, int v, PlaylistDetailBaseFragment playlistDetailBaseFragment0, String s, SpannableString spannableString0, int v1) {
        try {
            if(textView0.getLineCount() > v) {
                E2 e20 = playlistDetailBaseFragment0.playlistDetailHeaderBinding;
                if(e20 != null) {
                    LinearLayout linearLayout0 = e20.l;
                    if(linearLayout0 != null) {
                        linearLayout0.setVisibility(0);
                    }
                }
                int v2 = textView0.getLayout().getLineEnd(v - 1);
                if(v2 < s.length()) {
                    String s1 = s.substring(0, v2);
                    q.f(s1, "substring(...)");
                    SpannableString spannableString1 = spannableString0 == null ? s1 : spannableString0;
                    textView0.setText(spannableString1);
                    playlistDetailBaseFragment0.setDescText(textView0, s1, spannableString0, v, v1 + 1);
                }
                else {
                    textView0.setMaxLines(v);
                }
            }
            else {
                textView0.setMaxLines(v);
            }
            if(playlistDetailBaseFragment0.playlistDetailHeaderBinding != null && (playlistDetailBaseFragment0.playlistDetailHeaderBinding.l != null && playlistDetailBaseFragment0.playlistDetailHeaderBinding.l.getVisibility() == 0)) {
                return;
            }
            E2 e21 = playlistDetailBaseFragment0.getHeaderBinding();
            if(e21 != null) {
                RelativeLayout relativeLayout0 = e21.n;
                if(relativeLayout0 != null) {
                    relativeLayout0.setClickable(false);
                }
            }
        }
        catch(Exception unused_ex) {
        }
    }

    public final void setDetailAdapter(@NotNull DetailAdapter detailSongMetaContentBaseFragment$DetailAdapter0) {
        q.g(detailSongMetaContentBaseFragment$DetailAdapter0, "<set-?>");
        this.detailAdapter = detailSongMetaContentBaseFragment$DetailAdapter0;
    }

    public final void setDjPlaylistInfoRes(@Nullable DjPlaylistInformRes djPlaylistInformRes0) {
        this.djPlaylistInfoRes = djPlaylistInformRes0;
    }

    public final void setFooterPosition(int v) {
        this.footerPosition = v;
    }

    public final void setHeaderData(@NotNull HeaderData songListHeaderHolder$HeaderData0) {
        q.g(songListHeaderHolder$HeaderData0, "<set-?>");
        this.headerData = songListHeaderHolder$HeaderData0;
    }

    public final void setHeaderPosition(int v) {
        this.headerPosition = v;
    }

    public final void setLike(boolean z) {
        this.isLike = z;
    }

    public final void setLikeCount(int v) {
        this.likeCount = v;
    }

    public final void setMiddleBannerRes(@Nullable DjBrandBannerRes djBrandBannerRes0) {
        this.middleBannerRes = djBrandBannerRes0;
    }

    public final void setMoreButton(@Nullable I i0) {
        this.moreButton = i0;
    }

    public final void setOwnerMemberKey(@NotNull String s) {
        q.g(s, "<set-?>");
        this.ownerMemberKey = s;
    }

    public final void setPlaylistDetailHeaderBinding(@Nullable E2 e20) {
        this.playlistDetailHeaderBinding = e20;
    }

    public final void setPlaylistSeq(@NotNull String s) {
        q.g(s, "<set-?>");
        this.playlistSeq = s;
    }

    public final void setSongCount(int v) {
        this.songCount = v;
    }

    public final void setSongList(@Nullable List list0) {
        this.songList = list0;
    }

    public final void setSongListAvailable(boolean z) {
        this.isSongListAvailable = z;
    }

    public final void setSongListHeader() {
        n0 n00 = this.getBottomButton();
        if(n00 != null) {
            this.updateSelectButton(this.mMarkedAll);
            D d0 = new D(this, 0);
            n00.f.setOnClickListener(d0);
        }
    }

    private static final void setSongListHeader$lambda$18$lambda$17(PlaylistDetailBaseFragment playlistDetailBaseFragment0, View view0) {
        if(playlistDetailBaseFragment0.isSongListAvailable) {
            playlistDetailBaseFragment0.toggleSelectAll();
            playlistDetailBaseFragment0.updateSelectButton(playlistDetailBaseFragment0.mMarkedAll);
            playlistDetailBaseFragment0.allSelectClickLog();
            return;
        }
        ToastManager.show(0x7F131071);  // string:toast_no_selectable_songs "선택 가능한 곡이 없습니다."
    }

    public final void setSongListPage(int v) {
        this.songListPage = v;
    }

    public final void setStatsElementsBase(@Nullable StatsElementsBase statsElementsBase0) {
        this.statsElementsBase = statsElementsBase0;
    }

    public final void setTitleBar(@Nullable String s, @NotNull String s1, @NotNull String s2) {
        q.g(s1, "cleanServiceCode");
        q.g(s2, "playListType");
        if(!((e0)va.o.a()).m() || !u.v(((e0)va.o.a()).j()).equals(s)) {
            String s3 = this.getString(0x7F13104A);  // string:title_playlist "플레이리스트"
            q.f(s3, "getString(...)");
            I i0 = new I(1, s3);
            i0.c = new D(this, 1);
            TitleBar titleBar1 = this.getTitleBar();
            o o1 = this.getTitlebarDetailCommon();
            o1.g(i0);
            titleBar1.a(o1);
            this.moreButton = i0;
        }
        else {
            G g0 = new G();  // 初始化器: Ljava/lang/Object;-><init>()V
            g0.c = new S(this, s1, s2, 2);
            if(this.getTitleBar().i == null) {
                TitleBar titleBar0 = this.getTitleBar();
                o o0 = this.getTitlebarDetailCommon();
                o0.g(g0);
                titleBar0.a(o0);
            }
        }
        this.getTitleBar().setTitle(this.titleText);
    }

    private static final void setTitleBar$lambda$6(PlaylistDetailBaseFragment playlistDetailBaseFragment0, String s, String s1, View view0) {
        RequestBuilder.newInstance(new CleanIsBlackReq(playlistDetailBaseFragment0.getContext(), s, playlistDetailBaseFragment0.playlistSeq)).tag(playlistDetailBaseFragment0.getRequestTag()).listener(new com.iloen.melon.fragments.detail.a(12, playlistDetailBaseFragment0, s1)).errorListener(new com.google.android.exoplayer2.upstream.cache.a(17)).request();
    }

    private static final void setTitleBar$lambda$6$lambda$4(PlaylistDetailBaseFragment playlistDetailBaseFragment0, String s, CleanIsBlackRes cleanIsBlackRes0) {
        if(cleanIsBlackRes0.isSuccessful() && playlistDetailBaseFragment0.isFragmentValid()) {
            Navigator.open(PlaylistMakeFragment.newInstance(playlistDetailBaseFragment0.playlistSeq, s));
        }
    }

    private static final void setTitleBar$lambda$6$lambda$5(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    private static final void setTitleBar$lambda$8$lambda$7(PlaylistDetailBaseFragment playlistDetailBaseFragment0, View view0) {
        playlistDetailBaseFragment0.showContextPopupPlaylistDetail();
        playlistDetailBaseFragment0.moreClickLog();
    }

    public final void setTitleText(@NotNull String s) {
        q.g(s, "<set-?>");
        this.titleText = s;
    }

    public final void setTotalPlayTime(@NotNull String s) {
        q.g(s, "<set-?>");
        this.totalPlayTime = s;
    }

    public final void setTotalSongCount(@NotNull String s) {
        q.g(s, "<set-?>");
        this.totalSongCount = s;
    }

    public void showContextPopupPlaylistDetail() {
    }

    public final void showWhenSongListHeader(boolean z) {
        n0 n00 = this.getBottomButton();
        ViewUtils.showWhen((n00 == null ? null : n00.g), z);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void songItemClickLog(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3) {
        q.g(s, "image");
        q.g(s1, "metaId");
        q.g(s2, "metaName");
        q.g(s3, "metaAuthor");
        String s4 = this.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
        String s5 = this.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
        String s6 = this.getString(0x7F130D95);  // string:tiara_click_copy_select_song "곡선택"
        String s7 = this.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
        PlaylistDetailBaseFragment.itemClickLog$default(this, ActionKind.ClickContent, s4, s5, s6, v, s, s1, s7, s2, s3, null, 0x400, null);
    }

    public void songListMoreClickLog(@Nullable Integer integer0) {
        String s = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        String s1 = this.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
        String s2 = this.getString(0x7F130D55);  // string:tiara_click_copy_more_list "리스트더보기"
        PlaylistDetailBaseFragment.itemClickLog$default(this, ActionKind.ClickContent, s, s1, s2, integer0, null, null, null, null, null, null, 0x400, null);
    }

    public void songListViewAllClickLog() {
        String s = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        String s1 = this.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
        String s2 = this.getString(0x7F130DB1);  // string:tiara_click_copy_view_all "전체보기"
        this.itemClickLog(ActionKind.ClickContent, s, s1, s2);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void songMoreClickLog(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3) {
        q.g(s, "image");
        q.g(s1, "metaId");
        q.g(s2, "metaName");
        q.g(s3, "metaAuthor");
        String s4 = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        String s5 = this.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
        String s6 = this.getString(0x7F130D56);  // string:tiara_click_copy_more_song "곡더보기"
        String s7 = this.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
        PlaylistDetailBaseFragment.itemClickLog$default(this, ActionKind.ClickContent, s4, s5, s6, v, s, s1, s7, s2, s3, null, 0x400, null);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void songPlayClickLog(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4) {
        q.g(s, "image");
        q.g(s1, "metaId");
        q.g(s2, "metaName");
        q.g(s3, "metaAuthor");
        q.g(s4, "cType");
        String s5 = this.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
        String s6 = this.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
        String s7 = this.getString(0x7F130D6A);  // string:tiara_click_copy_play_music "음악재생"
        String s8 = this.getString(0x7F130F01);  // string:tiara_meta_type_song "곡"
        PlaylistDetailBaseFragment.itemClickLog$default(this, ActionKind.PlayMusic, s5, s6, s7, v, s, s1, s8, s2, s3, null, 0x400, null);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void songThumbClickLog(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3) {
        q.g(s, "image");
        q.g(s1, "metaId");
        q.g(s2, "metaName");
        q.g(s3, "metaAuthor");
        String s4 = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        String s5 = this.getString(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
        String s6 = this.getString(0x7F130D57);  // string:tiara_click_copy_move_album "앨범페이지이동"
        String s7 = this.getString(0x7F130EF0);  // string:tiara_meta_type_album "앨범"
        PlaylistDetailBaseFragment.itemClickLog$default(this, ActionKind.ClickContent, s4, s5, s6, v, s, s1, s7, s2, s3, null, 0x400, null);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void updateCommentCountView(@Nullable InformCmtContsSummRes informCmtContsSummRes0) {
        CMTCONTSSUMM informCmtContsSummRes$result$CMTCONTSSUMM0;
        if(this.isFragmentValid()) {
            if(informCmtContsSummRes0 == null) {
                informCmtContsSummRes$result$CMTCONTSSUMM0 = null;
            }
            else {
                result informCmtContsSummRes$result0 = informCmtContsSummRes0.result;
                informCmtContsSummRes$result$CMTCONTSSUMM0 = informCmtContsSummRes$result0 == null ? null : informCmtContsSummRes$result0.cmtContsSumm;
            }
            this.setInformCmt(informCmtContsSummRes$result$CMTCONTSSUMM0);
            CMTCONTSSUMM informCmtContsSummRes$result$CMTCONTSSUMM1 = this.getInformCmt();
            int v = 0;
            int v1 = informCmtContsSummRes$result$CMTCONTSSUMM1 == null ? 0 : informCmtContsSummRes$result$CMTCONTSSUMM1.validCmtCnt;
            this.commentCount = v1;
            E2 e20 = this.playlistDetailHeaderBinding;
            if(e20 != null) {
                String s = this.getString(0x7F130AEA, new Object[]{v1});  // string:talkback_cmt_count "댓글 %1$s개"
                ViewUtils.setContentDescriptionWithButtonClassName(e20.B, s);
                e20.g.setText(String.valueOf(this.commentCount));
                CMTCONTSSUMM informCmtContsSummRes$result$CMTCONTSSUMM2 = this.getInformCmt();
                if(informCmtContsSummRes$result$CMTCONTSSUMM2 != null) {
                    ImageView imageView0 = e20.y;
                    if(imageView0 != null) {
                        imageView0.setVisibility((informCmtContsSummRes$result$CMTCONTSSUMM2.hotFlag ? 0 : 8));
                    }
                    ImageView imageView1 = e20.z;
                    if(imageView1 != null) {
                        if(!informCmtContsSummRes$result$CMTCONTSSUMM2.newFlag) {
                            v = 8;
                        }
                        imageView1.setVisibility(v);
                    }
                }
            }
        }
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void updateCommentListView(@NotNull LoadPgnRes loadPgnRes0, @NotNull ListCmtRes listCmtRes0) {
        q.g(loadPgnRes0, "loadPgnRes");
        q.g(listCmtRes0, "listCmtRes");
    }

    public final void updateLikeView() {
        this.updateLikeView(this.likeCount, this.isLike);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void updateLikeView(@Nullable Integer integer0, boolean z) {
        if(integer0 != null) {
            this.likeCount = (int)integer0;
            this.isLike = z;
        }
        E2 e20 = this.playlistDetailHeaderBinding;
        if(e20 != null) {
            CheckableImageView checkableImageView0 = e20.e;
            String s = null;
            if(integer0 == null) {
                checkableImageView0.setChecked(z);
                Context context1 = this.getContext();
                if(context1 != null) {
                    s = context1.getString((z ? 0x7F130B5C : 0x7F130B5B));  // string:talkback_like_off "좋아요 취소"
                }
                checkableImageView0.setContentDescription(s);
            }
            else {
                String s1 = StringUtils.getCountString(integer0.toString(), 0xF423F);
                LinearLayout linearLayout0 = e20.E;
                Context context0 = this.getContext();
                if(context0 != null) {
                    s = context0.getString((z ? 0x7F130B5E : 0x7F130B61), new Object[]{s1});  // string:talkback_like_off_with_cnt "좋아요, %1$s명, 좋아요 취소하기"
                }
                ViewUtils.setContentDescriptionWithButtonClassName(linearLayout0, s);
                checkableImageView0.setChecked(z);
                e20.F.setText(s1);
                if(z) {
                    this.showRecommendAlbumContentsPopup(this.getContsId());
                    O.a(new UaLogDummyReq(this.getContext(), "recmAlbumLikePopup"));
                }
            }
            this.removeDetailCache();
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void updateSelectAllButton(boolean z) {
        if(!this.isFragmentValid()) {
            return;
        }
        this.updateSelectButton(z);
    }

    public final void updateSelectButton(boolean z) {
        n0 n00 = this.getBottomButton();
        if(n00 != null) {
            CheckableTextView checkableTextView0 = n00.b;
            String s = this.getString(0x7F130071, new Object[]{this.totalSongCount});  // string:album_song_cnt "%s곡"
            n00.i.setText(s);
            n00.j.setText(this.totalPlayTime);
            if(z) {
                checkableTextView0.setText(this.getString(0x7F1310D9));  // string:unselect_selection "선택해제"
                checkableTextView0.setChecked(true);
                return;
            }
            checkableTextView0.setText(this.getString(0x7F130914));  // string:select_all "전체선택"
            checkableTextView0.setChecked(false);
        }
    }

    public static void v0(TextView textView0, int v, PlaylistDetailBaseFragment playlistDetailBaseFragment0, String s, SpannableString spannableString0, int v1) {
        PlaylistDetailBaseFragment.setDescText$lambda$12(textView0, v, playlistDetailBaseFragment0, s, spannableString0, v1);
    }

    public static void y0(PlaylistDetailBaseFragment playlistDetailBaseFragment0, String s, StatsElementsBase statsElementsBase0, ForuPlayRes foruPlayRes0) {
        PlaylistDetailBaseFragment.playForUSong$lambda$15(playlistDetailBaseFragment0, s, statsElementsBase0, foruPlayRes0);
    }
}

