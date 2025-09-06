package com.iloen.melon.fragments.detail;

import F8.I;
import H0.b;
import J8.E2;
import J8.e3;
import J8.m0;
import Kc.d0;
import Tf.v;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.adapters.common.a;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.f1;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.OnViewHolderActionListener;
import com.iloen.melon.fragments.comments.CommentLatestList;
import com.iloen.melon.fragments.detail.viewholder.SongListEmptyHolder.SongListEmptyData;
import com.iloen.melon.fragments.detail.viewholder.SongListEmptyHolder;
import com.iloen.melon.net.HttpRequest;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v3x.comments.CmtResViewModel;
import com.iloen.melon.net.v3x.comments.ListCmtRes;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import com.iloen.melon.net.v4x.request.AppBanerListReq;
import com.iloen.melon.net.v4x.request.DjPlaylistPlayLogReq.ParamInfo;
import com.iloen.melon.net.v4x.request.DjPlaylistPlayLogReq;
import com.iloen.melon.net.v4x.request.DjPlaylistScrapLogReq;
import com.iloen.melon.net.v4x.response.AppBanerListRes.RESPONSE.CONTENTSLIST;
import com.iloen.melon.net.v4x.response.AppBanerListRes;
import com.iloen.melon.net.v4x.response.ArtistPlylstSongListRes;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v5x.request.DjBrandBannerReq;
import com.iloen.melon.net.v5x.response.DetailBaseRes.OFFICIALDJSERIESINFO;
import com.iloen.melon.net.v5x.response.DetailBaseRes.PAGE;
import com.iloen.melon.net.v5x.response.DetailBaseRes.PLAYLIST;
import com.iloen.melon.net.v5x.response.DjBrandBannerRes;
import com.iloen.melon.net.v6x.request.DjPlaylistDownloadSongsReq;
import com.iloen.melon.net.v6x.request.DjPlaylistInformReq;
import com.iloen.melon.net.v6x.request.DjPlaylistPlaySongsReq;
import com.iloen.melon.net.v6x.request.DjPlaylistScrapSongsReq;
import com.iloen.melon.net.v6x.request.MelonDjPlaylistListSongReq;
import com.iloen.melon.net.v6x.request.PlaylistInformBaseReq.Params;
import com.iloen.melon.net.v6x.response.DjPlaylistInformRes.RESPONSE.EVENT;
import com.iloen.melon.net.v6x.response.DjPlaylistInformRes;
import com.iloen.melon.net.v6x.response.ForUDetailRes;
import com.iloen.melon.net.v6x.response.MelonDjPlaylistListSongRes.RESPONSE;
import com.iloen.melon.net.v6x.response.MelonDjPlaylistListSongRes;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistListSongRes;
import com.iloen.melon.popup.DjSelectionPopup.DjSelectionPopupData;
import com.iloen.melon.popup.DjSelectionPopup;
import com.iloen.melon.popup.MelonTextPopup;
import com.iloen.melon.popup.PopupHelper;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.model.SharableDJCollection;
import com.iloen.melon.task.ReportService;
import com.iloen.melon.task.request.LikeUpdateAsyncTask.OnJobFinishListener;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.types.StringIds;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.TimeExpiredCache;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.PhotoDetailUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.SongInfoBase;
import com.melon.ui.A1;
import com.melon.ui.F1;
import com.melon.ui.V1;
import com.melon.ui.W1;
import com.melon.ui.a2;
import com.melon.ui.k2;
import d3.g;
import e.k;
import e1.u;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import je.p;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import p8.s;
import v9.i;
import va.e0;
import va.o;
import we.n;
import zd.M;

@Metadata(d1 = {"\u0000\u00F4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u0099\u00012\u00020\u0001:\u0004\u0099\u0001\u009A\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\u0007\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000F\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\rH\u0014\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0012\u001A\u00020\n2\u0006\u0010\u0011\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0010J\u000F\u0010\u0014\u001A\u00020\u0013H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001A\u00020\n2\u0006\u0010\u0017\u001A\u00020\u0016H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001B\u001A\u00020\u001AH\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ!\u0010 \u001A\u00020\n2\u0006\u0010\u001E\u001A\u00020\u001D2\b\u0010\u001F\u001A\u0004\u0018\u00010\rH\u0016\u00A2\u0006\u0004\b \u0010!J\u001B\u0010%\u001A\u0006\u0012\u0002\b\u00030$2\u0006\u0010#\u001A\u00020\"H\u0014\u00A2\u0006\u0004\b%\u0010&J\u000F\u0010\'\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\'\u0010\u0003J\u000F\u0010(\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b(\u0010\u0003J\u0017\u0010+\u001A\u00020\n2\u0006\u0010*\u001A\u00020)H\u0016\u00A2\u0006\u0004\b+\u0010,J-\u00102\u001A\u00020\u00162\b\u0010.\u001A\u0004\u0018\u00010-2\b\u00100\u001A\u0004\u0018\u00010/2\b\u00101\u001A\u0004\u0018\u00010\u0004H\u0014\u00A2\u0006\u0004\b2\u00103J!\u00107\u001A\u00020\n2\b\u00105\u001A\u0004\u0018\u0001042\u0006\u00106\u001A\u00020)H\u0014\u00A2\u0006\u0004\b7\u00108J\u000F\u00109\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b9\u0010\u0003J\u000F\u0010;\u001A\u0004\u0018\u00010:\u00A2\u0006\u0004\b;\u0010<J\u001A\u0010>\u001A\u00020\n2\b\u0010=\u001A\u0004\u0018\u00010:H\u0086@\u00A2\u0006\u0004\b>\u0010?J\u000F\u0010@\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b@\u0010\u0006J\u0017\u0010B\u001A\n A*\u0004\u0018\u00010\u00040\u0004H\u0016\u00A2\u0006\u0004\bB\u0010\u0006J\u000F\u0010C\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\bC\u0010\u0006J\u0011\u0010E\u001A\u0004\u0018\u00010DH\u0014\u00A2\u0006\u0004\bE\u0010FJ\u000F\u0010G\u001A\u00020\nH\u0016\u00A2\u0006\u0004\bG\u0010\u0003J\u0017\u0010J\u001A\n\u0012\u0004\u0012\u00020I\u0018\u00010HH\u0016\u00A2\u0006\u0004\bJ\u0010KJ\u000F\u0010L\u001A\u00020\nH\u0016\u00A2\u0006\u0004\bL\u0010\u0003J\u000F\u0010M\u001A\u00020\nH\u0016\u00A2\u0006\u0004\bM\u0010\u0003J\u000F\u0010N\u001A\u00020\nH\u0016\u00A2\u0006\u0004\bN\u0010\u0003J\u001D\u0010Q\u001A\u00020\n2\u0006\u0010O\u001A\u00020\u00042\u0006\u0010P\u001A\u00020\u0016\u00A2\u0006\u0004\bQ\u0010RJ\u001B\u0010U\u001A\u0006\u0012\u0002\b\u00030T2\u0006\u0010.\u001A\u00020SH\u0016\u00A2\u0006\u0004\bU\u0010VJ}\u0010c\u001A\u00020\n2\b\u0010X\u001A\u0004\u0018\u00010W2\b\u0010Y\u001A\u0004\u0018\u00010\u00042\b\u0010Z\u001A\u0004\u0018\u00010\u00042\b\u0010[\u001A\u0004\u0018\u00010\u00042\b\u0010\\\u001A\u0004\u0018\u00010)2\b\u0010]\u001A\u0004\u0018\u00010\u00042\b\u0010^\u001A\u0004\u0018\u00010\u00042\b\u0010_\u001A\u0004\u0018\u00010\u00042\b\u0010`\u001A\u0004\u0018\u00010\u00042\b\u0010a\u001A\u0004\u0018\u00010\u00042\b\u0010b\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\bc\u0010dJ\u0011\u0010f\u001A\u0004\u0018\u00010eH\u0016\u00A2\u0006\u0004\bf\u0010gJ\u001F\u0010l\u001A\u00020\n2\u0006\u0010i\u001A\u00020h2\u0006\u0010k\u001A\u00020jH\u0016\u00A2\u0006\u0004\bl\u0010mJ\u0019\u0010n\u001A\u00020\n2\b\u0010=\u001A\u0004\u0018\u00010:H\u0002\u00A2\u0006\u0004\bn\u0010oJ\u0019\u0010q\u001A\u0004\u0018\u00010:2\u0006\u0010p\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\bq\u0010rJ\u0019\u0010t\u001A\u0004\u0018\u00010s2\u0006\u0010p\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\bt\u0010uJ!\u0010y\u001A\u0004\u0018\u00010x2\u0006\u0010v\u001A\u00020\u00042\u0006\u0010w\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\by\u0010zJ\u0011\u0010|\u001A\u0004\u0018\u00010{H\u0002\u00A2\u0006\u0004\b|\u0010}J\u000F\u0010~\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b~\u0010\u0003R\u0017\u0010\u007F\u001A\u00020\u001D8\u0002@\u0002X\u0082.\u00A2\u0006\u0007\n\u0005\b\u007F\u0010\u0080\u0001R\u0019\u0010\u0081\u0001\u001A\u00020\u001D8\u0002@\u0002X\u0082.\u00A2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0080\u0001R\u0019\u0010\u0082\u0001\u001A\u00020\u00168\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0019\u0010\u0084\u0001\u001A\u00020\u00168\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0083\u0001R\u001A\u0010\u0086\u0001\u001A\u00030\u0085\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0019\u0010\u0088\u0001\u001A\u00020)8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001F\u0010\u008A\u0001\u001A\u00020\u00168\u0016X\u0096D\u00A2\u0006\u0010\n\u0006\b\u008A\u0001\u0010\u0083\u0001\u001A\u0006\b\u008A\u0001\u0010\u008B\u0001R\u001C\u0010\u008D\u0001\u001A\u0005\u0018\u00010\u008C\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u008D\u0001\u0010\u008E\u0001R\u0018\u0010\u0090\u0001\u001A\u00030\u008F\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001B\u0010\u0092\u0001\u001A\u0004\u0018\u00010s8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0018\u0010\u0094\u0001\u001A\u00030\u008F\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0091\u0001R\u0018\u0010\u0098\u0001\u001A\u00030\u0095\u00018VX\u0096\u0004\u00A2\u0006\b\u001A\u0006\b\u0096\u0001\u0010\u0097\u0001\u00A8\u0006\u009B\u0001"}, d2 = {"Lcom/iloen/melon/fragments/detail/DjPlaylistDetailFragment;", "Lcom/iloen/melon/fragments/detail/PlaylistDetailBaseFragment;", "<init>", "()V", "", "getCacheKey", "()Ljava/lang/String;", "getDetailCacheKey", "Landroid/content/res/Configuration;", "newConfig", "Lie/H;", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/os/Bundle;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Lcom/iloen/melon/custom/f1;", "getInsetHandlingType", "()Lcom/iloen/melon/custom/f1;", "", "isVisible", "onFragmentVisibilityChanged", "(Z)V", "LQ4/a;", "onCreateHeaderLayout", "()LQ4/a;", "Landroid/view/View;", "view", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "onAppBarCollapsed", "onAppBarExpended", "", "offset", "onAppBarScrolling", "(I)V", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Lcom/iloen/melon/custom/ToolBar$ToolBarItem;", "item", "itemId", "onToolBarClick", "(Lcom/iloen/melon/custom/ToolBar$ToolBarItem;I)V", "updateHeaderView", "Lcom/iloen/melon/net/v6x/response/DjPlaylistInformRes;", "fetchDetailCacheData", "()Lcom/iloen/melon/net/v6x/response/DjPlaylistInformRes;", "response", "drawHeaderView", "(Lcom/iloen/melon/net/v6x/response/DjPlaylistInformRes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContsId", "kotlin.jvm.PlatformType", "getContsTypeCode", "getPageMetaType", "Lcom/iloen/melon/sns/model/Sharable;", "getSNSSharable", "()Lcom/iloen/melon/sns/model/Sharable;", "removeDetailCache", "", "Lcom/melon/net/res/common/SongInfoBase;", "getAllSongList", "()Ljava/util/List;", "openProfile", "onFriendStatusChanged", "showContextPopupPlaylistDetail", "memberKey", "isFriend", "follow", "(Ljava/lang/String;Z)V", "Lzd/M;", "Lcom/iloen/melon/net/HttpRequest;", "getPlaylistSongListRequest", "(Lzd/M;)Lcom/iloen/melon/net/HttpRequest;", "Lcom/kakao/tiara/data/ActionKind;", "actionKind", "actionName", "clickLayer1", "clickCopy", "ordNum", "image", "eventMetaId", "eventMetaType", "eventMetaName", "eventMetaAuthor", "propsLikeType", "itemClickLog", "(Lcom/kakao/tiara/data/ActionKind;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lp8/f;", "getTiaraEventBuilder", "()Lp8/f;", "Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;", "loadPgnRes", "Lcom/iloen/melon/net/v3x/comments/ListCmtRes;", "listCmtRes", "updateCommentListView", "(Lcom/iloen/melon/net/v3x/comments/LoadPgnRes;Lcom/iloen/melon/net/v3x/comments/ListCmtRes;)V", "initLayout", "(Lcom/iloen/melon/net/v6x/response/DjPlaylistInformRes;)V", "playlistSeq", "requestPlaylistInfo", "(Ljava/lang/String;)Lcom/iloen/melon/net/v6x/response/DjPlaylistInformRes;", "Lcom/iloen/melon/net/v6x/response/MelonDjPlaylistListSongRes;", "requestSongList", "(Ljava/lang/String;)Lcom/iloen/melon/net/v6x/response/MelonDjPlaylistListSongRes;", "bannerType", "brandDjKey", "Lcom/iloen/melon/net/v5x/response/DjBrandBannerRes;", "requestMiddleBanner", "(Ljava/lang/String;Ljava/lang/String;)Lcom/iloen/melon/net/v5x/response/DjBrandBannerRes;", "Lcom/iloen/melon/net/v4x/response/AppBanerListRes;", "requestTopBanner", "()Lcom/iloen/melon/net/v4x/response/AppBanerListRes;", "updateStatusBar", "titleLayout", "Landroid/view/View;", "bottomDivider", "isSpecial", "Z", "isAppBarCollapsed", "", "alpha", "F", "headerHeight", "I", "isDj", "()Z", "LKc/d0;", "playlistEventBottomSheet", "LKc/d0;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "mainExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "songRes", "Lcom/iloen/melon/net/v6x/response/MelonDjPlaylistListSongRes;", "subExceptionHandler", "Lme/i;", "getCoroutineContext", "()Lme/i;", "coroutineContext", "Companion", "DjPlaylistDetailAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DjPlaylistDetailFragment extends Hilt_DjPlaylistDetailFragment {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u0005H\u0007J\u0018\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/detail/DjPlaylistDetailFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_IS_APPBAR_COLLAPSED", "newInstance", "Lcom/iloen/melon/fragments/detail/DjPlaylistDetailFragment;", "playlistSeq", "showSnsPopup", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final DjPlaylistDetailFragment newInstance(@NotNull String s) {
            q.g(s, "playlistSeq");
            DjPlaylistDetailFragment djPlaylistDetailFragment0 = new DjPlaylistDetailFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argItemId", s);
            djPlaylistDetailFragment0.setArguments(bundle0);
            return djPlaylistDetailFragment0;
        }

        @NotNull
        public final DjPlaylistDetailFragment newInstance(@NotNull String s, boolean z) {
            q.g(s, "playlistSeq");
            DjPlaylistDetailFragment djPlaylistDetailFragment0 = new DjPlaylistDetailFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argItemId", s);
            bundle0.putBoolean("argVisibleSnsPopup", z);
            djPlaylistDetailFragment0.setArguments(bundle0);
            return djPlaylistDetailFragment0;
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\'\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0007\u001A\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\'\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000EH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u0014\u001A\u00020\u00132\n\u0010\u0017\u001A\u00060\u0015R\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001A¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/fragments/detail/DjPlaylistDetailFragment$DjPlaylistDetailAdapter;", "Lcom/iloen/melon/fragments/detail/PlaylistDetailBaseFragment$PlaylistDetailAdapter;", "Lcom/iloen/melon/fragments/detail/PlaylistDetailBaseFragment;", "Landroid/content/Context;", "context", "", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "list", "<init>", "(Lcom/iloen/melon/fragments/detail/DjPlaylistDetailFragment;Landroid/content/Context;Ljava/util/List;)V", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "Landroid/view/ViewGroup;", "parent", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;", "Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/detail/viewholder/SongListEmptyHolder;", "getSongListEmptyHolder", "(Landroid/view/ViewGroup;Lcom/iloen/melon/fragments/DetailSongMetaContentBaseFragment$OnViewHolderActionListener;)Lcom/iloen/melon/fragments/detail/viewholder/SongListEmptyHolder;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class DjPlaylistDetailAdapter extends PlaylistDetailAdapter {
        public DjPlaylistDetailAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
        }

        @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment$PlaylistDetailAdapter
        @NotNull
        public SongListEmptyHolder getSongListEmptyHolder(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionListener detailSongMetaContentBaseFragment$OnViewHolderActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailSongMetaContentBaseFragment$OnViewHolderActionListener0, "onViewHolderActionListener");
            return SongListEmptyHolder.Companion.newInstance(viewGroup0, detailSongMetaContentBaseFragment$OnViewHolderActionListener0);
        }

        @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment$PlaylistDetailAdapter
        public boolean handleResponse(@NotNull String s, @NotNull i i0, @NotNull HttpResponse httpResponse0) {
            q.g(s, "key");
            q.g(i0, "type");
            q.g(httpResponse0, "response");
            DjPlaylistDetailFragment.this.getHeaderData().setTotPlayTime(DjPlaylistDetailFragment.this.getTotalPlayTime());
            DjPlaylistDetailFragment.this.getHeaderData().setTotSongCnt(DjPlaylistDetailFragment.this.getTotalSongCount());
            if(httpResponse0 instanceof MelonDjPlaylistListSongRes) {
                RESPONSE melonDjPlaylistListSongRes$RESPONSE0 = ((MelonDjPlaylistListSongRes)httpResponse0).response;
                if(melonDjPlaylistListSongRes$RESPONSE0 != null) {
                    StatsElementsBase statsElementsBase0 = ((MelonDjPlaylistListSongRes)httpResponse0).getStatsElements();
                    DjPlaylistDetailFragment.this.setStatsElementsBase(statsElementsBase0);
                    DjPlaylistDetailFragment.this.setSongList(melonDjPlaylistListSongRes$RESPONSE0.songList);
                    List list0 = DjPlaylistDetailFragment.this.getSongList();
                    DjPlaylistDetailFragment.this.setSongCount((list0 == null ? 0 : list0.size()));
                    goto label_13;
                }
            }
            else {
            label_13:
                if(httpResponse0 instanceof ArtistPlylstSongListRes) {
                    com.iloen.melon.net.v4x.response.ArtistPlylstSongListRes.RESPONSE artistPlylstSongListRes$RESPONSE0 = ((ArtistPlylstSongListRes)httpResponse0).response;
                    if(artistPlylstSongListRes$RESPONSE0 != null) {
                        StatsElementsBase statsElementsBase1 = ((ArtistPlylstSongListRes)httpResponse0).getStatsElements();
                        DjPlaylistDetailFragment.this.setStatsElementsBase(statsElementsBase1);
                        DjPlaylistDetailFragment.this.setSongList(artistPlylstSongListRes$RESPONSE0.songList);
                        List list1 = DjPlaylistDetailFragment.this.getSongList();
                        DjPlaylistDetailFragment.this.setSongCount((list1 == null ? 0 : list1.size()));
                        goto label_21;
                    }
                }
                else {
                label_21:
                    if(httpResponse0 instanceof MyMusicPlaylistListSongRes) {
                        com.iloen.melon.net.v6x.response.MyMusicPlaylistListSongRes.RESPONSE myMusicPlaylistListSongRes$RESPONSE0 = ((MyMusicPlaylistListSongRes)httpResponse0).response;
                        if(myMusicPlaylistListSongRes$RESPONSE0 != null) {
                            StatsElementsBase statsElementsBase2 = ((MyMusicPlaylistListSongRes)httpResponse0).getStatsElements();
                            DjPlaylistDetailFragment.this.setStatsElementsBase(statsElementsBase2);
                            DjPlaylistDetailFragment.this.setSongList(myMusicPlaylistListSongRes$RESPONSE0.songList);
                            List list2 = DjPlaylistDetailFragment.this.getSongList();
                            DjPlaylistDetailFragment.this.setSongCount((list2 == null ? 0 : list2.size()));
                            goto label_29;
                        }
                    }
                    else {
                    label_29:
                        if(httpResponse0 instanceof ForUDetailRes) {
                            com.iloen.melon.net.v6x.response.ForUDetailRes.RESPONSE forUDetailRes$RESPONSE0 = ((ForUDetailRes)httpResponse0).response;
                            if(forUDetailRes$RESPONSE0 != null) {
                                DjPlaylistDetailFragment.this.setStatsElementsBase(((ForUDetailRes)httpResponse0).getStatsElements());
                                DjPlaylistDetailFragment.this.setSongList(forUDetailRes$RESPONSE0.list);
                                List list3 = DjPlaylistDetailFragment.this.getSongList();
                                DjPlaylistDetailFragment.this.setSongCount((list3 == null ? 0 : list3.size()));
                                goto label_36;
                            }
                        }
                        else {
                        label_36:
                            DjPlaylistDetailFragment.this.showWhenSongListHeader(DjPlaylistDetailFragment.this.getSongCount() > 0);
                            this.setHasMore(false);
                            this.setMenuId(DjPlaylistDetailFragment.this.mMenuId);
                            this.setStatsElements(DjPlaylistDetailFragment.this.getStatsElementsBase());
                            this.updateModifiedTime(s);
                            List list4 = DjPlaylistDetailFragment.this.getSongList();
                            if(list4 != null) {
                                DjPlaylistDetailFragment djPlaylistDetailFragment0 = DjPlaylistDetailFragment.this;
                                for(Object object0: list4) {
                                    if(object0 instanceof SongInfoBase && ((SongInfoBase)object0).canService) {
                                        djPlaylistDetailFragment0.setSongListAvailable(true);
                                    }
                                }
                            }
                            ArrayList arrayList0 = null;
                            if(DjPlaylistDetailFragment.this.getSongCount() <= 0 || !(httpResponse0 instanceof MelonDjPlaylistListSongRes) && !(httpResponse0 instanceof ArtistPlylstSongListRes) && !(httpResponse0 instanceof MyMusicPlaylistListSongRes) && !(httpResponse0 instanceof ForUDetailRes)) {
                                this.add(AdapterInViewHolder.Row.create(51, new SongListEmptyData(null, false, 3, null), this.getMenuId()));
                            }
                            else {
                                ArrayList arrayList1 = new ArrayList();
                                List list5 = DjPlaylistDetailFragment.this.getSongList();
                                if(list5 != null) {
                                    DjPlaylistDetailFragment djPlaylistDetailFragment1 = DjPlaylistDetailFragment.this;
                                    int v = 0;
                                    for(Object object1: list5) {
                                        if(v >= 0) {
                                            if(v < 100) {
                                                a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                                                a0.a = 1;
                                                a0.b = object1;
                                                a0.c = djPlaylistDetailFragment1.mMenuId;
                                                l1.z(a0, arrayList1);
                                            }
                                            ++v;
                                            continue;
                                        }
                                        k.O();
                                        throw null;
                                    }
                                }
                                Integer integer0 = v.t0(v.p0(DjPlaylistDetailFragment.this.getTotalSongCount(), ",", ""));
                                if((integer0 == null ? 0 : ((int)integer0)) > 100) {
                                    a a1 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                                    a1.a = 35;
                                    PAGE detailBaseRes$PAGE0 = new PAGE();
                                    detailBaseRes$PAGE0.isEnd = true;
                                    a1.b = detailBaseRes$PAGE0;
                                    a1.c = DjPlaylistDetailFragment.this.mMenuId;
                                    l1.z(a1, arrayList1);
                                }
                                this.addAll(arrayList1);
                            }
                            if(DjPlaylistDetailFragment.this.getDjPlaylistInfoRes() != null) {
                                ArrayList arrayList2 = new ArrayList();
                                DjPlaylistInformRes djPlaylistInformRes0 = DjPlaylistDetailFragment.this.getDjPlaylistInfoRes();
                                if(djPlaylistInformRes0 != null) {
                                    com.iloen.melon.net.v6x.response.DjPlaylistInformRes.RESPONSE djPlaylistInformRes$RESPONSE0 = djPlaylistInformRes0.response;
                                    if(djPlaylistInformRes$RESPONSE0 != null) {
                                        if(djPlaylistInformRes$RESPONSE0.menuId != null && djPlaylistInformRes$RESPONSE0.menuId.length() > 0) {
                                            DjPlaylistDetailFragment.this.mMenuId = djPlaylistInformRes$RESPONSE0.menuId;
                                        }
                                        DjBrandBannerRes djBrandBannerRes0 = DjPlaylistDetailFragment.this.getMiddleBannerRes();
                                        if(djBrandBannerRes0 != null && (djBrandBannerRes0.response != null && (djBrandBannerRes0.response.bannerList != null && !djBrandBannerRes0.response.bannerList.isEmpty() == 1))) {
                                            a a2 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                                            a2.a = 36;
                                            DjBrandBannerRes djBrandBannerRes1 = DjPlaylistDetailFragment.this.getMiddleBannerRes();
                                            if(djBrandBannerRes1 != null) {
                                                com.iloen.melon.net.v5x.response.DjBrandBannerRes.RESPONSE djBrandBannerRes$RESPONSE0 = djBrandBannerRes1.response;
                                                if(djBrandBannerRes$RESPONSE0 != null) {
                                                    arrayList0 = djBrandBannerRes$RESPONSE0.bannerList;
                                                }
                                            }
                                            a2.b = arrayList0;
                                            a2.c = DjPlaylistDetailFragment.this.mMenuId;
                                            l1.z(a2, arrayList2);
                                        }
                                        if(djPlaylistInformRes$RESPONSE0.tagList != null && !djPlaylistInformRes$RESPONSE0.tagList.isEmpty() == 1) {
                                            a a3 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                                            a3.a = 18;
                                            a3.b = djPlaylistInformRes$RESPONSE0.tagList;
                                            a3.e = DjPlaylistDetailFragment.this.getPlaylistSeq();
                                            a3.c = DjPlaylistDetailFragment.this.mMenuId;
                                            l1.z(a3, arrayList2);
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
                                            a4.c = DjPlaylistDetailFragment.this.mMenuId;
                                            l1.z(a4, arrayList2);
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
                                            a5.c = DjPlaylistDetailFragment.this.mMenuId;
                                            l1.z(a5, arrayList2);
                                        }
                                        if(djPlaylistInformRes$RESPONSE0.seriesPlaylists != null && !djPlaylistInformRes$RESPONSE0.seriesPlaylists.isEmpty() == 1) {
                                            a a6 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                                            a6.a = 28;
                                            List list8 = djPlaylistInformRes$RESPONSE0.seriesPlaylists;
                                            q.f(list8, "seriesPlaylists");
                                            a6.b = p.K0(3, list8);
                                            a6.e = djPlaylistInformRes$RESPONSE0.djplaylist.getSeriesPlylstSeq();
                                            a6.g = djPlaylistInformRes$RESPONSE0.seriesPlaylists.size() > 3;
                                            a6.c = DjPlaylistDetailFragment.this.mMenuId;
                                            l1.z(a6, arrayList2);
                                        }
                                        if(djPlaylistInformRes$RESPONSE0.relationPlaylists != null && !djPlaylistInformRes$RESPONSE0.relationPlaylists.isEmpty() == 1) {
                                            a a7 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                                            a7.a = 29;
                                            List list9 = djPlaylistInformRes$RESPONSE0.relationPlaylists;
                                            q.f(list9, "relationPlaylists");
                                            a7.b = p.K0(3, list9);
                                            a7.e = DjPlaylistDetailFragment.this.getPlaylistSeq();
                                            a7.c = DjPlaylistDetailFragment.this.mMenuId;
                                            l1.z(a7, arrayList2);
                                        }
                                        if(djPlaylistInformRes$RESPONSE0.relationContentList != null && !djPlaylistInformRes$RESPONSE0.relationContentList.isEmpty() == 1) {
                                            a a8 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
                                            a8.a = 19;
                                            List list10 = djPlaylistInformRes$RESPONSE0.relationContentList;
                                            q.f(list10, "relationContentList");
                                            a8.b = p.K0(3, list10);
                                            a8.e = DjPlaylistDetailFragment.this.getPlaylistSeq();
                                            a8.c = DjPlaylistDetailFragment.this.mMenuId;
                                            l1.z(a8, arrayList2);
                                        }
                                        this.addAll(arrayList2);
                                        this.setCommentPosition(this.getCount());
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return true;
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
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final String ARG_IS_APPBAR_COLLAPSED = "ARG_IS_APPBAR_COLLAPSED";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "DjPlaylistDetailFragment";
    private float alpha;
    private View bottomDivider;
    private int headerHeight;
    private boolean isAppBarCollapsed;
    private final boolean isDj;
    private boolean isSpecial;
    @NotNull
    private final CoroutineExceptionHandler mainExceptionHandler;
    @Nullable
    private d0 playlistEventBottomSheet;
    @Nullable
    private MelonDjPlaylistListSongRes songRes;
    @NotNull
    private final CoroutineExceptionHandler subExceptionHandler;
    private View titleLayout;

    static {
        DjPlaylistDetailFragment.Companion = new Companion(null);
        DjPlaylistDetailFragment.$stable = 8;
    }

    public DjPlaylistDetailFragment() {
        this.headerHeight = -1;
        this.isDj = true;
        this.mainExceptionHandler = new CoroutineExceptionHandler(this) {
            @Override  // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(me.i i0, Throwable throwable0) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.mainExceptionHandler.1.1(throwable0, DjPlaylistDetailFragment.this, null), 3, null);
            }
        };
        this.subExceptionHandler = new CoroutineExceptionHandler(/*ERROR_MISSING_ARG_0/*) {
            @Override  // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(me.i i0, Throwable throwable0) {
                LogU.Companion.d("DjPlaylistDetailFragment", "subExceptionHandler = " + throwable0);
            }
        };

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.fragments.detail.DjPlaylistDetailFragment$mainExceptionHandler$1$1", f = "DjPlaylistDetailFragment.kt", l = {}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.mainExceptionHandler.1.1 extends oe.i implements n {
            final Throwable $throwable;
            int label;

            public com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.mainExceptionHandler.1.1(Throwable throwable0, DjPlaylistDetailFragment djPlaylistDetailFragment0, Continuation continuation0) {
                this.$throwable = throwable0;
                DjPlaylistDetailFragment.this = djPlaylistDetailFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.mainExceptionHandler.1.1(this.$throwable, DjPlaylistDetailFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.mainExceptionHandler.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                if(this.$throwable instanceof VolleyError) {
                    DjPlaylistDetailFragment.this.showNetworkErrorHeaderView(true);
                    DjPlaylistDetailFragment.access$getMResponseErrorListener$p$s1820805241(DjPlaylistDetailFragment.this).onErrorResponse(((VolleyError)this.$throwable));
                }
                return H.a;
            }
        }

    }

    public static void D0(DjPlaylistDetailFragment djPlaylistDetailFragment0, PLAYLIST detailBaseRes$PLAYLIST0, View view0) {
        DjPlaylistDetailFragment.drawHeaderView$lambda$25$lambda$15(detailBaseRes$PLAYLIST0, djPlaylistDetailFragment0, view0);
    }

    public static void J0(DjPlaylistDetailFragment djPlaylistDetailFragment0, PLAYLIST detailBaseRes$PLAYLIST0, View view0) {
        DjPlaylistDetailFragment.drawHeaderView$lambda$25$lambda$18(detailBaseRes$PLAYLIST0, djPlaylistDetailFragment0, view0);
    }

    public static void L0(DjPlaylistDetailFragment djPlaylistDetailFragment0, PLAYLIST detailBaseRes$PLAYLIST0, View view0) {
        DjPlaylistDetailFragment.drawHeaderView$lambda$25$lambda$4(detailBaseRes$PLAYLIST0, djPlaylistDetailFragment0, view0);
    }

    public static final ErrorListener access$getMResponseErrorListener$p$s1820805241(DjPlaylistDetailFragment djPlaylistDetailFragment0) {
        return djPlaylistDetailFragment0.mResponseErrorListener;
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        this.setDetailAdapter(new DjPlaylistDetailAdapter(this, context0, null));
        this.getDetailAdapter().setMarkedMode(true);
        this.getDetailAdapter().setListContentType(1);
        return this.getDetailAdapter();
    }

    @Nullable
    public final Object drawHeaderView(@Nullable DjPlaylistInformRes djPlaylistInformRes0, @NotNull Continuation continuation0) {
        String s2;
        com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.drawHeaderView.1 djPlaylistDetailFragment$drawHeaderView$11;
        ne.a a1;
        H h1;
        com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.drawHeaderView.1 djPlaylistDetailFragment$drawHeaderView$10;
        if(continuation0 instanceof com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.drawHeaderView.1) {
            djPlaylistDetailFragment$drawHeaderView$10 = (com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.drawHeaderView.1)continuation0;
            int v = djPlaylistDetailFragment$drawHeaderView$10.label;
            if((v & 0x80000000) == 0) {
                djPlaylistDetailFragment$drawHeaderView$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.drawHeaderView(null, this);
                    }
                };
            }
            else {
                djPlaylistDetailFragment$drawHeaderView$10.label = v ^ 0x80000000;
            }
        }
        else {
            djPlaylistDetailFragment$drawHeaderView$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.drawHeaderView(null, this);
                }
            };
        }
        Object object0 = djPlaylistDetailFragment$drawHeaderView$10.result;
        ne.a a0 = ne.a.a;
        H h0 = H.a;
        switch(djPlaylistDetailFragment$drawHeaderView$10.label) {
            case 0: {
                d5.n.D(object0);
                if(!this.isFragmentValid()) {
                    return h0;
                }
                this.initLayout(djPlaylistInformRes0);
                if(djPlaylistInformRes0 == null) {
                    return h0;
                }
                com.iloen.melon.net.v6x.response.DjPlaylistInformRes.RESPONSE djPlaylistInformRes$RESPONSE0 = djPlaylistInformRes0.response;
                if(djPlaylistInformRes$RESPONSE0 == null) {
                    return h0;
                }
                PLAYLIST detailBaseRes$PLAYLIST0 = djPlaylistInformRes$RESPONSE0.djplaylist;
                if(detailBaseRes$PLAYLIST0 == null) {
                    return h0;
                }
                AppBanerListRes appBanerListRes0 = djPlaylistInformRes$RESPONSE0.appBanerListRes;
                EVENT djPlaylistInformRes$RESPONSE$EVENT0 = djPlaylistInformRes$RESPONSE0.event;
                E2 e20 = this.getPlaylistDetailHeaderBinding();
                if(e20 == null) {
                    djPlaylistDetailFragment$drawHeaderView$11 = djPlaylistDetailFragment$drawHeaderView$10;
                    a1 = a0;
                    h1 = h0;
                }
                else {
                    MelonTextView melonTextView0 = e20.H;
                    e3 e30 = e20.M;
                    FrameLayout frameLayout0 = e20.t;
                    h1 = h0;
                    a1 = a0;
                    djPlaylistDetailFragment$drawHeaderView$11 = djPlaylistDetailFragment$drawHeaderView$10;
                    e3 e31 = e20.N;
                    ImageView imageView0 = e20.A;
                    MelonTextView melonTextView1 = e20.P;
                    ImageView imageView1 = e20.b;
                    MelonImageView melonImageView0 = e20.J.b;
                    LinearLayout linearLayout0 = e20.v;
                    FrameLayout frameLayout1 = e20.c;
                    LinearLayout linearLayout1 = e20.u;
                    LinearLayoutCompat linearLayoutCompat0 = e20.s;
                    LinearLayout linearLayout2 = e20.q;
                    LinearLayoutCompat linearLayoutCompat1 = e20.G;
                    MelonTextView melonTextView2 = e20.o;
                    e20.K.setVisibility(0);
                    String s = detailBaseRes$PLAYLIST0.playTime;
                    q.f(s, "playTime");
                    this.setTotalPlayTime(s);
                    this.setTotalSongCount((detailBaseRes$PLAYLIST0.songcnt == null ? "" : detailBaseRes$PLAYLIST0.songcnt));
                    if(!((e0)o.a()).m() || !u.v(((e0)o.a()).j()).equals(detailBaseRes$PLAYLIST0.memberKey)) {
                        frameLayout0.setVisibility(0);
                        ViewUtils.hideWhen(linearLayout1, detailBaseRes$PLAYLIST0.isFriend);
                        ViewUtils.showWhen(linearLayout0, detailBaseRes$PLAYLIST0.isFriend);
                        ViewUtils.setContentDescriptionWithButtonClassName(linearLayout1, this.getString(0x7F130441));  // string:follow "팔로우"
                        ViewUtils.setContentDescriptionWithButtonClassName(linearLayout0, this.getString(0x7F130BEC));  // string:talkback_playlist_make_following_cancel "팔로잉 취소"
                        m m0 = new m(detailBaseRes$PLAYLIST0, this, 0);
                        linearLayout1.setOnClickListener(m0);
                        linearLayout0.setOnClickListener(m0);
                    }
                    else {
                        frameLayout0.setVisibility(8);
                    }
                    String s1 = detailBaseRes$PLAYLIST0.memberKey;
                    q.f("DJPLAYLIST", "SERVICE_CODE_DJPLAYLIST");
                    this.setTitleBar(s1, "DJPLAYLIST", "M20002");
                    if(this.isSpecial) {
                        RequestManager requestManager0 = Glide.with(melonImageView0);
                        com.iloen.melon.net.v6x.response.DjPlaylistInformRes.RESPONSE djPlaylistInformRes$RESPONSE1 = djPlaylistInformRes0.response;
                        if(djPlaylistInformRes$RESPONSE1 == null) {
                            s2 = null;
                        }
                        else {
                            PLAYLIST detailBaseRes$PLAYLIST1 = djPlaylistInformRes$RESPONSE1.djplaylist;
                            s2 = detailBaseRes$PLAYLIST1 == null ? null : detailBaseRes$PLAYLIST1.webpImgUrl;
                        }
                        requestManager0.load(s2).into(melonImageView0);
                    }
                    else {
                        Glide.with(melonImageView0).load(detailBaseRes$PLAYLIST0.thumbImgUrl).into(melonImageView0);
                    }
                    if(detailBaseRes$PLAYLIST0.thumbImgUrl != null && detailBaseRes$PLAYLIST0.thumbImgUrl.length() > 0) {
                        ViewUtils.setContentDescriptionWithButtonClassName(melonImageView0, this.getString(0x7F130BFB));  // string:talkback_playlist_thumb_cover "플레이리스트 커버 크게보기"
                        melonImageView0.setOnClickListener(new m(this, detailBaseRes$PLAYLIST0, 1));
                    }
                    int v1 = ScreenUtils.dipToPixel(this.getContext(), 32.0f);
                    ViewUtils.setDefaultImage(e30.c, v1, true);
                    Glide.with(e30.b).load(detailBaseRes$PLAYLIST0.getOwnermypageimg()).apply(RequestOptions.circleCropTransform()).into(e30.b);
                    if(detailBaseRes$PLAYLIST0.withOfficialSeries) {
                        ViewUtils.showWhen(melonTextView1, true);
                        ViewUtils.setText(melonTextView1, detailBaseRes$PLAYLIST0.getWithOfficialSeriesTitle());
                        melonTextView1.setOnClickListener(new m(this, detailBaseRes$PLAYLIST0, 2));
                        ViewUtils.showWhen(e31.a, true);
                        int v2 = ScreenUtils.dipToPixel(this.getContext(), 32.0f);
                        ViewUtils.setDefaultImage(e31.c, v2, true);
                        Glide.with(e31.b).load((detailBaseRes$PLAYLIST0.officialDjSeriesInfo == null ? null : detailBaseRes$PLAYLIST0.officialDjSeriesInfo.myPageImg)).apply(RequestOptions.circleCropTransform()).into(e31.b);
                    }
                    this.setTitleText((detailBaseRes$PLAYLIST0.plylsttitle == null ? "" : detailBaseRes$PLAYLIST0.plylsttitle));
                    e20.I.setText(this.getTitleText());
                    melonTextView0.setText(detailBaseRes$PLAYLIST0.memberNickname);
                    e20.x.setText(detailBaseRes$PLAYLIST0.updtDateStr);
                    if(this.getLikeCount() < 0) {
                        this.setLikeCount(this.likeCountToInt(detailBaseRes$PLAYLIST0.likecnt));
                        this.setLike(detailBaseRes$PLAYLIST0.isLike);
                    }
                    if(!this.isSpecial || djPlaylistInformRes$RESPONSE$EVENT0 == null) {
                        linearLayout2.setVisibility(8);
                    }
                    else {
                        linearLayout2.setVisibility(0);
                        e20.O.setText(djPlaylistInformRes$RESPONSE$EVENT0.eventTitle);
                        GradientDrawable gradientDrawable0 = new GradientDrawable();
                        String s3 = ScreenUtils.isDarkMode(this.getContext()) ? djPlaylistInformRes$RESPONSE$EVENT0.btnColorDark : djPlaylistInformRes$RESPONSE$EVENT0.btnColorLight;
                        q.d(s3);
                        P4.a.B(gradientDrawable0, s3, ScreenUtils.dipToPixel(this.getContext(), 4.0f));
                        linearLayout2.setBackground(gradientDrawable0);
                        linearLayout2.setOnClickListener(new h(1, this, djPlaylistInformRes$RESPONSE$EVENT0));
                    }
                    this.updateLikeView();
                    int v3 = ResourceUtils.getDjIconColorId(detailBaseRes$PLAYLIST0.memberDjIconType);
                    if(v3 > -1) {
                        melonTextView2.setVisibility(0);
                        melonTextView2.setTextColor(ColorUtils.getColor(this.getContext(), v3));
                    }
                    else {
                        melonTextView2.setVisibility(8);
                    }
                    ViewUtils.showWhen(e20.p, detailBaseRes$PLAYLIST0.isOfficial);
                    if(detailBaseRes$PLAYLIST0.plylstDesc != null && detailBaseRes$PLAYLIST0.plylstDesc.length() > 0) {
                        String s4 = detailBaseRes$PLAYLIST0.plylstDesc;
                        q.f(s4, "plylstDesc");
                        this.setDescText(s4, e20);
                    }
                    String s5 = this.getString(0x7F130AD8) + ":" + (g.M(detailBaseRes$PLAYLIST0.getMemberDjType()) ? this.getString(0x7F130335) : "") + detailBaseRes$PLAYLIST0.memberNickname + (detailBaseRes$PLAYLIST0.isOfficial ? va.e.b(",", this.getString(0x7F130BF4)) : "") + "," + this.getString(0x7F130ADE);  // string:talkback_author "제작자"
                    q.f(s5, "toString(...)");
                    ViewUtils.setContentDescriptionWithButtonClassName(linearLayoutCompat1, s5);
                    melonTextView0.setOnClickListener(new m(detailBaseRes$PLAYLIST0, this, 3));
                    linearLayoutCompat1.setOnClickListener(new m(detailBaseRes$PLAYLIST0, this, 4));
                    com.iloen.melon.fragments.detail.k k0 = new com.iloen.melon.fragments.detail.k(this, 1);
                    e20.f.setOnClickListener(k0);
                    com.iloen.melon.fragments.detail.k k1 = new com.iloen.melon.fragments.detail.k(this, 2);
                    ViewUtils.setOnClickListener(e20.E, k1);
                    linearLayoutCompat0.setVisibility(8);
                    if(detailBaseRes$PLAYLIST0.isFame) {
                        linearLayoutCompat0.setVisibility(0);
                        e20.r.setText(detailBaseRes$PLAYLIST0.plyLstFameStr);
                    }
                    e20.g.setText(String.valueOf(this.getCommentCount()));
                    frameLayout1.setVisibility(8);
                    if(appBanerListRes0 != null) {
                        com.iloen.melon.net.v4x.response.AppBanerListRes.RESPONSE appBanerListRes$RESPONSE0 = appBanerListRes0.response;
                        if(appBanerListRes$RESPONSE0 != null) {
                            ArrayList arrayList0 = appBanerListRes$RESPONSE0.contentsList;
                            if(arrayList0 != null) {
                                CONTENTSLIST appBanerListRes$RESPONSE$CONTENTSLIST0 = (CONTENTSLIST)p.n0(0, arrayList0);
                                if(appBanerListRes$RESPONSE$CONTENTSLIST0 != null && djPlaylistInformRes$RESPONSE$EVENT0 == null) {
                                    frameLayout1.setVisibility(0);
                                    MelonLinkInfo melonLinkInfo0 = MelonLinkInfo.a(appBanerListRes$RESPONSE$CONTENTSLIST0, appBanerListRes$RESPONSE$CONTENTSLIST0.menuId);
                                    imageView1.setOnClickListener(new h(2, melonLinkInfo0, this));
                                    RequestOptions requestOptions0 = RequestOptions.bitmapTransform(new MultiTransformation(new Transformation[]{new he.e(ScreenUtils.dipToPixel(this.getContext(), 4.0f), RoundedCornersTransformation.CornerType.ALL)}));
                                    q.f(requestOptions0, "bitmapTransform(...)");
                                    Context context0 = this.getContext();
                                    if(context0 != null) {
                                        Glide.with(context0).asBitmap().load(appBanerListRes$RESPONSE$CONTENTSLIST0.imgurl).apply(requestOptions0).into(imageView1);
                                    }
                                    imageView0.setVisibility(8);
                                    if(!TextUtils.isEmpty(appBanerListRes$RESPONSE$CONTENTSLIST0.bgcolor)) {
                                        imageView0.setImageTintList(new ColorStateList(new int[][]{new int[0]}, new int[]{melonLinkInfo0.l}));
                                        imageView0.setVisibility(0);
                                    }
                                }
                            }
                        }
                    }
                    com.iloen.melon.fragments.detail.k k2 = new com.iloen.melon.fragments.detail.k(this, 0);
                    e20.B.setOnClickListener(k2);
                    this.onAppBarScrolling(this.getAppBarOffset());
                    e20.a.requestLayout();
                }
                if(this.isLoginUser()) {
                    djPlaylistDetailFragment$drawHeaderView$11.L$0 = null;
                    djPlaylistDetailFragment$drawHeaderView$11.L$1 = null;
                    djPlaylistDetailFragment$drawHeaderView$11.L$2 = null;
                    djPlaylistDetailFragment$drawHeaderView$11.L$3 = null;
                    djPlaylistDetailFragment$drawHeaderView$11.label = 1;
                    if(this.getUserActionsFromServerAndUpdateUi(djPlaylistDetailFragment$drawHeaderView$11) == a1) {
                        return a1;
                    }
                }
                break;
            }
            case 1: {
                EVENT djPlaylistInformRes$RESPONSE$EVENT1 = (EVENT)djPlaylistDetailFragment$drawHeaderView$10.L$3;
                AppBanerListRes appBanerListRes1 = (AppBanerListRes)djPlaylistDetailFragment$drawHeaderView$10.L$2;
                PLAYLIST detailBaseRes$PLAYLIST2 = (PLAYLIST)djPlaylistDetailFragment$drawHeaderView$10.L$1;
                DjPlaylistInformRes djPlaylistInformRes1 = (DjPlaylistInformRes)djPlaylistDetailFragment$drawHeaderView$10.L$0;
                d5.n.D(object0);
                h1 = h0;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        this.setSongListHeader();
        return h1;
    }

    private static final void drawHeaderView$lambda$25$lambda$13(DjPlaylistDetailFragment djPlaylistDetailFragment0, EVENT djPlaylistInformRes$RESPONSE$EVENT0, View view0) {
        FragmentActivity fragmentActivity0 = djPlaylistDetailFragment0.getActivity();
        if(fragmentActivity0 != null && fragmentActivity0.getSupportFragmentManager() != null) {
            d0 d00 = djPlaylistDetailFragment0.playlistEventBottomSheet;
            if(d00 != null) {
                d00.dismiss();
            }
            q8.e e0 = new q8.e(djPlaylistDetailFragment0.getContsId(), djPlaylistDetailFragment0.getString(0x7F130E6B), djPlaylistDetailFragment0.getTitleText(), null, null, null, null, null);  // string:tiara_djplaylist_meta_type "DJ플레이리스트"
            s s0 = djPlaylistDetailFragment0.mMelonTiaraProperty;
            q.f(s0, "mMelonTiaraProperty");
            d0 d01 = new d0(djPlaylistDetailFragment0.getPlaylistSeq(), djPlaylistInformRes$RESPONSE$EVENT0, s0, e0);
            FragmentActivity fragmentActivity1 = djPlaylistDetailFragment0.getActivity();
            if(fragmentActivity1 != null) {
                l0 l00 = fragmentActivity1.getSupportFragmentManager();
                if(l00 != null) {
                    d01.show(l00, "PlaylistEventBottomSheetFragment");
                }
            }
            djPlaylistDetailFragment0.playlistEventBottomSheet = d01;
            PlaylistDetailBaseFragment.itemClickLog$default(djPlaylistDetailFragment0, null, djPlaylistDetailFragment0.getString(0x7F130DC9), djPlaylistDetailFragment0.getString(0x7F130DF5), djPlaylistDetailFragment0.getString(0x7F130D29), null, null, djPlaylistInformRes$RESPONSE$EVENT0.refeventId, djPlaylistDetailFragment0.getString(0x7F130EF8), djPlaylistInformRes$RESPONSE$EVENT0.eventTitle, null, null, 0x630, null);  // string:tiara_common_action_name_move_page "페이지이동"
        }
    }

    private static final void drawHeaderView$lambda$25$lambda$15(PLAYLIST detailBaseRes$PLAYLIST0, DjPlaylistDetailFragment djPlaylistDetailFragment0, View view0) {
        Navigator.openUserMain(detailBaseRes$PLAYLIST0.memberKey);
        djPlaylistDetailFragment0.itemClickLog(null, djPlaylistDetailFragment0.getString(0x7F130DC9), djPlaylistDetailFragment0.getString(0x7F130DF5), djPlaylistDetailFragment0.getString(0x7F130E61));  // string:tiara_common_action_name_move_page "페이지이동"
    }

    private static final void drawHeaderView$lambda$25$lambda$18(PLAYLIST detailBaseRes$PLAYLIST0, DjPlaylistDetailFragment djPlaylistDetailFragment0, View view0) {
        String s5;
        String s4;
        if(detailBaseRes$PLAYLIST0.withOfficialSeries) {
            if(!djPlaylistDetailFragment0.isRetainedPopupShowing()) {
                com.iloen.melon.popup.DjSelectionPopup.Companion djSelectionPopup$Companion0 = DjSelectionPopup.Companion;
                String s = detailBaseRes$PLAYLIST0.getOwnermypageimg();
                String s1 = "";
                if(s == null) {
                    s = "";
                }
                String s2 = detailBaseRes$PLAYLIST0.memberNickname;
                q.f(s2, "memberNickname");
                String s3 = detailBaseRes$PLAYLIST0.memberKey;
                q.f(s3, "memberKey");
                DjSelectionPopupData djSelectionPopup$DjSelectionPopupData0 = new DjSelectionPopupData(s, s2, s3);
                OFFICIALDJSERIESINFO detailBaseRes$OFFICIALDJSERIESINFO0 = detailBaseRes$PLAYLIST0.officialDjSeriesInfo;
                if(detailBaseRes$OFFICIALDJSERIESINFO0 == null) {
                    s4 = "";
                }
                else {
                    s4 = detailBaseRes$OFFICIALDJSERIESINFO0.myPageImg;
                    if(s4 == null) {
                        s4 = "";
                    }
                }
                if(detailBaseRes$OFFICIALDJSERIESINFO0 == null) {
                    s5 = "";
                }
                else {
                    s5 = detailBaseRes$OFFICIALDJSERIESINFO0.memberNickname;
                    if(s5 == null) {
                        s5 = "";
                    }
                }
                if(detailBaseRes$OFFICIALDJSERIESINFO0 != null) {
                    String s6 = detailBaseRes$OFFICIALDJSERIESINFO0.memberKey;
                    if(s6 != null) {
                        s1 = s6;
                    }
                }
                DjSelectionPopup djSelectionPopup0 = djSelectionPopup$Companion0.newInstance(k.A(new DjSelectionPopupData[]{djSelectionPopup$DjSelectionPopupData0, new DjSelectionPopupData(s4, s5, s1)}), new j(djPlaylistDetailFragment0, 0));
                FragmentActivity fragmentActivity0 = djPlaylistDetailFragment0.getActivity();
                if(fragmentActivity0 != null) {
                    l0 l00 = fragmentActivity0.getSupportFragmentManager();
                    if(l00 != null) {
                        djPlaylistDetailFragment0.itemClickLog(null, djPlaylistDetailFragment0.getString(0x7F130DC9), djPlaylistDetailFragment0.getString(0x7F130DF5), djPlaylistDetailFragment0.getString(0x7F130E5C));  // string:tiara_common_action_name_move_page "페이지이동"
                        djSelectionPopup0.setDismissFragment(djPlaylistDetailFragment0);
                        djSelectionPopup0.show(l00, "DjSelectionPopup");
                    }
                }
            }
            return;
        }
        TimeExpiredCache.getInstance().remove(djPlaylistDetailFragment0.getCacheKey());
        Navigator.openUserMain(detailBaseRes$PLAYLIST0.memberKey);
        djPlaylistDetailFragment0.itemClickLog(null, djPlaylistDetailFragment0.getString(0x7F130DC9), djPlaylistDetailFragment0.getString(0x7F130DF5), djPlaylistDetailFragment0.getString(0x7F130E61));  // string:tiara_common_action_name_move_page "페이지이동"
    }

    private static final H drawHeaderView$lambda$25$lambda$18$lambda$16(DjPlaylistDetailFragment djPlaylistDetailFragment0, DjSelectionPopupData djSelectionPopup$DjSelectionPopupData0) {
        q.g(djSelectionPopup$DjSelectionPopupData0, "selectedDj");
        TimeExpiredCache.getInstance().remove(djPlaylistDetailFragment0.getCacheKey());
        Navigator.openUserMain("");
        return H.a;
    }

    private static final void drawHeaderView$lambda$25$lambda$19(DjPlaylistDetailFragment djPlaylistDetailFragment0, View view0) {
        djPlaylistDetailFragment0.showSNSListPopup(djPlaylistDetailFragment0.getSNSSharable());
    }

    private static final void drawHeaderView$lambda$25$lambda$20(DjPlaylistDetailFragment djPlaylistDetailFragment0, View view0) {
        String s = djPlaylistDetailFragment0.getString(0x7F130DC8);  // string:tiara_common_action_name_like "좋아요"
        String s1 = djPlaylistDetailFragment0.getString(0x7F130DF5);  // string:tiara_common_layer1_introduce "소개"
        String s2 = djPlaylistDetailFragment0.getString(0x7F130D41);  // string:tiara_click_copy_like "좋아요"
        PlaylistDetailBaseFragment.itemClickLog$default(djPlaylistDetailFragment0, ActionKind.Like, s, s1, null, null, null, null, null, null, s2, djPlaylistDetailFragment0.getString((djPlaylistDetailFragment0.isLike() ? 0x7F130FCC : 0x7F130FCD)), 504, null);  // string:tiara_props_dislike "dislike"
        View view1 = view0.findViewById(0x7F0A076B);  // id:liked_cnt
        q.f(view1, "findViewById(...)");
        djPlaylistDetailFragment0.updateLikeInfo(view1);
    }

    private static final void drawHeaderView$lambda$25$lambda$23$lambda$21(MelonLinkInfo melonLinkInfo0, DjPlaylistDetailFragment djPlaylistDetailFragment0, View view0) {
        if(melonLinkInfo0 != null) {
            MelonLinkExecutor.open(melonLinkInfo0);
            djPlaylistDetailFragment0.itemClickLog(null, djPlaylistDetailFragment0.getString(0x7F130DC9), djPlaylistDetailFragment0.getString(0x7F130DF5), djPlaylistDetailFragment0.getString(0x7F130D06));  // string:tiara_common_action_name_move_page "페이지이동"
        }
    }

    private static final void drawHeaderView$lambda$25$lambda$24(DjPlaylistDetailFragment djPlaylistDetailFragment0, View view0) {
        djPlaylistDetailFragment0.getOnViewHolderActionListener().onOpenCommentListView();
        djPlaylistDetailFragment0.itemClickLog(null, djPlaylistDetailFragment0.getString(0x7F130DC9), djPlaylistDetailFragment0.getString(0x7F130DF5), djPlaylistDetailFragment0.getString(0x7F130D14));  // string:tiara_common_action_name_move_page "페이지이동"
    }

    private static final void drawHeaderView$lambda$25$lambda$4(PLAYLIST detailBaseRes$PLAYLIST0, DjPlaylistDetailFragment djPlaylistDetailFragment0, View view0) {
        if(detailBaseRes$PLAYLIST0.isFriend) {
            MelonTextPopup melonTextPopup0 = PopupHelper.showTwoButtonPopup(djPlaylistDetailFragment0.getActivity(), null, djPlaylistDetailFragment0.getString(0x7F130330, new Object[]{detailBaseRes$PLAYLIST0.memberNickname}), djPlaylistDetailFragment0.getString(0x7F130331), djPlaylistDetailFragment0.getString(0x7F130332), new l(djPlaylistDetailFragment0, detailBaseRes$PLAYLIST0));  // string:dj_playlist_delete_confirm_message "%1$s님 팔로우를 취소하시겠습니까?"
            melonTextPopup0.setOnDismissListener(djPlaylistDetailFragment0.mDialogDismissListener);
            djPlaylistDetailFragment0.mRetainDialog = melonTextPopup0;
            melonTextPopup0.show();
            return;
        }
        String s = detailBaseRes$PLAYLIST0.memberKey;
        q.f(s, "memberKey");
        djPlaylistDetailFragment0.follow(s, detailBaseRes$PLAYLIST0.isFriend);
    }

    private static final void drawHeaderView$lambda$25$lambda$4$lambda$3(DjPlaylistDetailFragment djPlaylistDetailFragment0, PLAYLIST detailBaseRes$PLAYLIST0, DialogInterface dialogInterface0, int v) {
        if(v == -1) {
            String s = detailBaseRes$PLAYLIST0.memberKey;
            q.f(s, "memberKey");
            djPlaylistDetailFragment0.follow(s, detailBaseRes$PLAYLIST0.isFriend);
        }
    }

    private static final void drawHeaderView$lambda$25$lambda$6(DjPlaylistDetailFragment djPlaylistDetailFragment0, PLAYLIST detailBaseRes$PLAYLIST0, View view0) {
        if(!djPlaylistDetailFragment0.isSpecial) {
            String s = va.e.c(detailBaseRes$PLAYLIST0.plylsttitle, ",", djPlaylistDetailFragment0.getString(0x7F130AED));  // string:talkback_common_cover "커버"
            String s1 = detailBaseRes$PLAYLIST0.thumbImgUrl;
            String s2 = PhotoDetailUtils.INSTANCE.convertToAccessibilityDesc(s);
            Navigator.INSTANCE.openPhotoUrlWithTitle(s1, s2);
        }
    }

    private static final void drawHeaderView$lambda$25$lambda$8(DjPlaylistDetailFragment djPlaylistDetailFragment0, PLAYLIST detailBaseRes$PLAYLIST0, View view0) {
        PlaylistDetailBaseFragment.itemClickLog$default(djPlaylistDetailFragment0, null, djPlaylistDetailFragment0.getString(0x7F130DC9), djPlaylistDetailFragment0.getString(0x7F130DF5), djPlaylistDetailFragment0.getString(0x7F130E62), null, null, (detailBaseRes$PLAYLIST0.officialDjSeriesInfo == null ? null : detailBaseRes$PLAYLIST0.officialDjSeriesInfo.plylstSeq), null, null, null, null, 0x7B0, null);  // string:tiara_common_action_name_move_page "페이지이동"
        Navigator.INSTANCE.openSeriesFolderDetail(detailBaseRes$PLAYLIST0.getSeriesPlylstSeq());
    }

    @Nullable
    public final DjPlaylistInformRes fetchDetailCacheData() {
        Cursor cursor0 = com.iloen.melon.responsecache.a.f(this.getContext(), this.getDetailCacheKey());
        if(cursor0 == null) {
            return null;
        }
        DjPlaylistInformRes djPlaylistInformRes0 = (DjPlaylistInformRes)com.iloen.melon.responsecache.a.d(cursor0, DjPlaylistInformRes.class);
        if(!cursor0.isClosed()) {
            cursor0.close();
        }
        return djPlaylistInformRes0 == null ? null : djPlaylistInformRes0;
    }

    public final void follow(@NotNull String s, boolean z) {
        q.g(s, "memberKey");
        if(StringIds.a(s, StringIds.i)) {
            this.updateLike("-1", "N10022", !z, this.getMenuId(), new OnJobFinishListener() {
                @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
                public void onJobComplete(String s, int v, boolean z) {
                    q.g(s, "errorMsg");
                    if(DjPlaylistDetailFragment.this.isFragmentValid() && TextUtils.isEmpty(s)) {
                        DjPlaylistDetailFragment.this.onFriendStatusChanged();
                        DjPlaylistDetailFragment.this.removeDetailCache();
                    }
                }

                @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
                public void onStartAsyncTask() {
                }
            });
            return;
        }
        this.addOrDeleteFriend(s, this.getMenuId(), !z, new X8.a() {
            @Override  // X8.a
            public void onJobComplete(String s) {
                if(DjPlaylistDetailFragment.this.isFragmentValid() && TextUtils.isEmpty(s)) {
                    DjPlaylistDetailFragment.this.onFriendStatusChanged();
                    DjPlaylistDetailFragment.this.removeDetailCache();
                }
            }
        });
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @Nullable
    public List getAllSongList() {
        MelonDjPlaylistListSongRes melonDjPlaylistListSongRes0 = this.songRes;
        if(melonDjPlaylistListSongRes0 != null) {
            RESPONSE melonDjPlaylistListSongRes$RESPONSE0 = melonDjPlaylistListSongRes0.response;
            if(melonDjPlaylistListSongRes$RESPONSE0 != null) {
                return melonDjPlaylistListSongRes$RESPONSE0.songList;
            }
        }
        return null;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.O0.buildUpon().appendPath(this.getPlaylistSeq()).build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    @NotNull
    public String getContsId() {
        return this.getPlaylistSeq();
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public String getContsTypeCode() {
        return "N10009";
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    @NotNull
    public me.i getCoroutineContext() {
        return Dispatchers.getIO();
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    @NotNull
    public String getDetailCacheKey() {
        String s = MelonContentUris.P0.buildUpon().appendPath(this.getPlaylistSeq()).build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @NotNull
    public f1 getInsetHandlingType() {
        return f1.b;
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    @NotNull
    public String getPageMetaType() {
        String s = this.getString(0x7F130E6B);  // string:tiara_djplaylist_meta_type "DJ플레이리스트"
        q.f(s, "getString(...)");
        return s;
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    @NotNull
    public HttpRequest getPlaylistSongListRequest(@NotNull M m0) {
        q.g(m0, "type");
        switch(WhenMappings.$EnumSwitchMapping$0[m0.ordinal()]) {
            case 1: {
                return new DjPlaylistDownloadSongsReq(this.getContext(), this.getContsId());
            }
            case 2: {
                return new DjPlaylistScrapSongsReq(this.getContext(), this.getContsId());
            }
            default: {
                return new DjPlaylistPlaySongsReq(this.getContext(), this.getContsId());
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @Nullable
    public Sharable getSNSSharable() {
        PLAYLIST detailBaseRes$PLAYLIST0;
        Sharable sharable0 = null;
        if(!TextUtils.isEmpty(this.getPlaylistSeq())) {
            DjPlaylistInformRes djPlaylistInformRes0 = this.getDjPlaylistInfoRes();
            if(djPlaylistInformRes0 == null) {
                detailBaseRes$PLAYLIST0 = null;
            }
            else {
                com.iloen.melon.net.v6x.response.DjPlaylistInformRes.RESPONSE djPlaylistInformRes$RESPONSE0 = djPlaylistInformRes0.response;
                detailBaseRes$PLAYLIST0 = djPlaylistInformRes$RESPONSE0 == null ? null : djPlaylistInformRes$RESPONSE0.djplaylist;
            }
            if(detailBaseRes$PLAYLIST0 != null) {
                DjPlaylistInformRes djPlaylistInformRes1 = this.getDjPlaylistInfoRes();
                if(djPlaylistInformRes1 != null) {
                    com.iloen.melon.net.v6x.response.DjPlaylistInformRes.RESPONSE djPlaylistInformRes$RESPONSE1 = djPlaylistInformRes1.response;
                    if(djPlaylistInformRes$RESPONSE1 != null) {
                        sharable0 = djPlaylistInformRes$RESPONSE1.djplaylist;
                    }
                }
                com.iloen.melon.sns.model.c c0 = new com.iloen.melon.sns.model.c();  // 初始化器: Ljava/lang/Object;-><init>()V
                c0.a = sharable0.plylstseq;
                c0.b = sharable0.plylsttitle;
                c0.c = sharable0.memberNickname;
                c0.d = sharable0.memberKey;
                c0.e = sharable0.songcnt;
                c0.h = sharable0.adminOpenYn;
                c0.f = sharable0.thumbImgUrl;
                c0.g = sharable0.thumbImgUrl;
                c0.i = sharable0.updtDateStr;
                return new SharableDJCollection(c0);
            }
        }
        return null;
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    @Nullable
    public f getTiaraEventBuilder() {
        String s = null;
        if(this.mMelonTiaraProperty == null) {
            return null;
        }
        f f0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
        s s1 = this.mMelonTiaraProperty;
        f0.b = s1 == null ? null : s1.a;
        if(s1 != null) {
            s = s1.b;
        }
        f0.c = s;
        f0.o = this.getContsId();
        f0.p = this.getString(0x7F130E6B);  // string:tiara_djplaylist_meta_type "DJ플레이리스트"
        f0.q = this.getTitleText();
        f0.I = this.getMenuId();
        return f0;
    }

    private final void initLayout(DjPlaylistInformRes djPlaylistInformRes0) {
        int v1;
        boolean z1;
        E2 e20 = this.getPlaylistDetailHeaderBinding();
        if(e20 != null) {
            ConstraintLayout constraintLayout0 = e20.C;
            MelonTextView melonTextView0 = e20.I;
            FrameLayout frameLayout0 = e20.K;
            boolean z = ScreenUtils.isOrientationPortrait(this.getContext());
            if(z) {
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = frameLayout0.getLayoutParams();
                q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                float f = (float)ScreenUtils.getStatusBarHeight(this.getContext());
                float f1 = this.getResources().getDimension(0x7F070418) + f;  // dimen:playlist_titlebar_height
                ((FrameLayout.LayoutParams)viewGroup$LayoutParams0).setMargins(0, ((int)f1), 0, 0);
                float f2 = f1 + ((float)ScreenUtils.dipToPixel(this.getContext(), 175.0f));
                ViewGroup.LayoutParams viewGroup$LayoutParams1 = melonTextView0.getLayoutParams();
                q.e(viewGroup$LayoutParams1, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ((LayoutParams)viewGroup$LayoutParams1).setMargins(((LayoutParams)viewGroup$LayoutParams1).leftMargin, ((int)f2), ((LayoutParams)viewGroup$LayoutParams1).rightMargin, ((LayoutParams)viewGroup$LayoutParams1).bottomMargin);
            }
            else {
                ViewGroup.LayoutParams viewGroup$LayoutParams2 = frameLayout0.getLayoutParams();
                q.e(viewGroup$LayoutParams2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                float f3 = (float)ScreenUtils.getStatusBarHeight(this.getContext());
                int v = (int)(this.getResources().getDimension(0x7F070418) + f3);  // dimen:playlist_titlebar_height
                ((FrameLayout.LayoutParams)viewGroup$LayoutParams2).setMargins(((FrameLayout.LayoutParams)viewGroup$LayoutParams2).leftMargin, v, ((FrameLayout.LayoutParams)viewGroup$LayoutParams2).rightMargin, ((FrameLayout.LayoutParams)viewGroup$LayoutParams2).bottomMargin);
                ViewGroup.LayoutParams viewGroup$LayoutParams3 = melonTextView0.getLayoutParams();
                q.e(viewGroup$LayoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ((LayoutParams)viewGroup$LayoutParams3).setMargins(((LayoutParams)viewGroup$LayoutParams3).leftMargin, v, ((LayoutParams)viewGroup$LayoutParams3).rightMargin, ((LayoutParams)viewGroup$LayoutParams3).bottomMargin);
            }
            if(djPlaylistInformRes0 == null) {
                z1 = false;
            }
            else {
                com.iloen.melon.net.v6x.response.DjPlaylistInformRes.RESPONSE djPlaylistInformRes$RESPONSE0 = djPlaylistInformRes0.response;
                if(djPlaylistInformRes$RESPONSE0 == null) {
                    z1 = false;
                }
                else {
                    PLAYLIST detailBaseRes$PLAYLIST0 = djPlaylistInformRes$RESPONSE0.djplaylist;
                    if(detailBaseRes$PLAYLIST0 == null) {
                        z1 = false;
                    }
                    else {
                        Boolean boolean0 = detailBaseRes$PLAYLIST0.isWebp;
                        z1 = boolean0 == null ? false : boolean0.booleanValue();
                    }
                }
            }
            this.isSpecial = z1;
            if(z1) {
                View view0 = frameLayout0.findViewById(0x7F0A069E);  // id:iv_thumb_default
                if(view0 != null) {
                    view0.setVisibility(8);
                }
                Context context0 = this.getContext();
                if(context0 == null) {
                    v1 = 0;
                }
                else {
                    Resources resources0 = context0.getResources();
                    v1 = resources0 == null ? 0 : ((int)resources0.getDimension(0x7F0700E3));  // dimen:detail_list_padding_left_right
                }
                if(z) {
                    int v2 = ScreenUtils.getScreenWidth(this.getContext());
                    ViewGroup.LayoutParams viewGroup$LayoutParams4 = frameLayout0.getLayoutParams();
                    q.e(viewGroup$LayoutParams4, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                    ((FrameLayout.LayoutParams)viewGroup$LayoutParams4).width = v2;
                    ((FrameLayout.LayoutParams)viewGroup$LayoutParams4).height = v2;
                    frameLayout0.setLayoutParams(((FrameLayout.LayoutParams)viewGroup$LayoutParams4));
                    ((FrameLayout.LayoutParams)viewGroup$LayoutParams4).setMargins(0, 0, 0, 0);
                    ViewGroup.LayoutParams viewGroup$LayoutParams5 = melonTextView0.getLayoutParams();
                    q.e(viewGroup$LayoutParams5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    ((LayoutParams)viewGroup$LayoutParams5).setMargins(0, ((int)(((float)v2) * 0.8f)), 0, 0);
                    ViewGroup.LayoutParams viewGroup$LayoutParams6 = constraintLayout0.getLayoutParams();
                    q.e(viewGroup$LayoutParams6, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                    ((FrameLayout.LayoutParams)viewGroup$LayoutParams6).setMargins(v1, 0, v1, 0);
                }
                else {
                    boolean z2 = ScreenUtils.isTablet(this.getContext());
                    int v3 = ScreenUtils.getScreenWidth(this.getContext());
                    int v4 = ScreenUtils.dipToPixel(this.getContext(), (z2 ? 360.0f : 340.0f));
                    ViewGroup.LayoutParams viewGroup$LayoutParams7 = frameLayout0.getLayoutParams();
                    q.e(viewGroup$LayoutParams7, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                    ((FrameLayout.LayoutParams)viewGroup$LayoutParams7).width = v3;
                    ((FrameLayout.LayoutParams)viewGroup$LayoutParams7).height = v4;
                    frameLayout0.setLayoutParams(((FrameLayout.LayoutParams)viewGroup$LayoutParams7));
                    ((FrameLayout.LayoutParams)viewGroup$LayoutParams7).setMargins(0, 0, 0, 0);
                    ViewGroup.LayoutParams viewGroup$LayoutParams8 = melonTextView0.getLayoutParams();
                    q.e(viewGroup$LayoutParams8, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    ((LayoutParams)viewGroup$LayoutParams8).setMargins(0, ((int)(((float)v4) * 0.6f)), 0, 0);
                    ViewGroup.LayoutParams viewGroup$LayoutParams9 = constraintLayout0.getLayoutParams();
                    q.e(viewGroup$LayoutParams9, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    ((LinearLayout.LayoutParams)viewGroup$LayoutParams9).setMargins(v1, 0, ScreenUtils.dipToPixel(this.getContext(), 12.0f), 0);
                    q.f(constraintLayout0, "layoutContent");
                    constraintLayout0.setPadding(0, 0, 0, 0);
                }
                e20.D.setVisibility(0);
                this.getTitleBar().setBackgroundColor(0);
                return;
            }
            this.updateStatusBar();
            this.getTitleBar().setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F0604AA));  // color:white000s_support_high_contrast
        }
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public boolean isDj() {
        return this.isDj;
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void itemClickLog(@Nullable ActionKind actionKind0, @Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable Integer integer0, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8) {
        p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
        g0.d = actionKind0;
        g0.a = s;
        s s9 = this.mMelonTiaraProperty;
        String s10 = null;
        g0.b = s9 == null ? null : s9.a;
        if(s9 != null) {
            s10 = s9.b;
        }
        g0.c = s10;
        g0.y = s1;
        g0.F = s2;
        g0.o = this.getContsId();
        g0.p = this.getString(0x7F130E6B);  // string:tiara_djplaylist_meta_type "DJ플레이리스트"
        g0.q = this.getTitleText();
        g0.e = s4;
        g0.f = s5;
        g0.g = s6;
        g0.I = this.getMenuId();
        g0.U = s8;
        if(integer0 != null) {
            g0.c(((int)integer0));
        }
        g0.a().track();
    }

    @NotNull
    public static final DjPlaylistDetailFragment newInstance(@NotNull String s) {
        return DjPlaylistDetailFragment.Companion.newInstance(s);
    }

    @NotNull
    public static final DjPlaylistDetailFragment newInstance(@NotNull String s, boolean z) {
        return DjPlaylistDetailFragment.Companion.newInstance(s, z);
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void onAppBarCollapsed() {
        this.isAppBarCollapsed = true;
        if(!this.isSpecial) {
            super.onAppBarCollapsed();
            return;
        }
        this.getTitleBar().f(false);
        FrameLayout frameLayout0 = this.getDetailHeader();
        if(frameLayout0 != null) {
            frameLayout0.setVisibility(4);
        }
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void onAppBarExpended() {
        this.isAppBarCollapsed = false;
        if(!this.isSpecial) {
            super.onAppBarExpended();
            return;
        }
        FrameLayout frameLayout0 = this.getDetailHeader();
        if(frameLayout0 != null) {
            frameLayout0.setVisibility(0);
        }
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void onAppBarScrolling(int v) {
        String s;
        float f2;
        int v2;
        int v1;
        if(this.isSpecial) {
            if(this.getHeaderBindingBase() != null) {
                float f = (float)Math.abs(v);
                if(this.headerHeight < 0) {
                    Q4.a a0 = this.getHeaderBindingBase();
                    if(a0 != null) {
                        View view0 = a0.getRoot();
                        if(view0 != null) {
                            view0.measure(0, 0);
                        }
                    }
                    Q4.a a1 = this.getHeaderBindingBase();
                    if(a1 == null) {
                        v1 = 0;
                    }
                    else {
                        View view1 = a1.getRoot();
                        v1 = view1 == null ? 0 : view1.getMeasuredHeight();
                    }
                    this.headerHeight = v1;
                }
                else {
                    Q4.a a2 = this.getHeaderBindingBase();
                    if(a2 == null) {
                        v2 = 0;
                    }
                    else {
                        View view2 = a2.getRoot();
                        v2 = view2 == null ? 0 : view2.getHeight();
                    }
                    this.headerHeight = v2;
                }
                int v3 = this.headerHeight;
                int v4 = ScreenUtils.dipToPixel(this.getContext(), 260.0f);
                int v5 = ScreenUtils.getStatusBarHeight(this.getContext());
                int v6 = this.getCollapseToolbarHeight();
                int v7 = ScreenUtils.getStatusBarHeight(this.getContext());
                float f1 = (float)(v3 - v4 - v5);
                if(Float.compare(f, f1) >= 0) {
                    f2 = (f - f1) / ((float)(v7 + v6));
                    if(f2 > 1.0f) {
                        f2 = 1.0f;
                    }
                    if(f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                }
                else {
                    f2 = 0.0f;
                }
                this.alpha = 1.0f - f2 * 5.0f < 0.0f ? 0.0f : 1.0f - f2 * 5.0f;
                E2 e20 = this.getPlaylistDetailHeaderBinding();
                if(e20 != null) {
                    MelonTextView melonTextView0 = e20.I;
                    if(melonTextView0 != null) {
                        melonTextView0.setAlpha(this.alpha);
                    }
                }
                E2 e21 = this.getPlaylistDetailHeaderBinding();
                if(e21 != null) {
                    MelonTextView melonTextView1 = e21.x;
                    if(melonTextView1 != null) {
                        melonTextView1.setAlpha(this.alpha);
                    }
                }
                E2 e22 = this.getPlaylistDetailHeaderBinding();
                if(e22 != null) {
                    View view3 = e22.h;
                    if(view3 != null) {
                        view3.setAlpha(1.0f - this.alpha);
                    }
                }
                boolean z = ScreenUtils.isDarkMode(this.getContext());
                if(Float.compare(this.alpha, 0.0f) <= 0) {
                    int v8 = ColorUtils.getColor(this.getContext(), 0x7F0604AA);  // color:white000s_support_high_contrast
                    TitleBar titleBar0 = this.getTitleBar();
                    DjPlaylistInformRes djPlaylistInformRes0 = this.getDjPlaylistInfoRes();
                    if(djPlaylistInformRes0 == null) {
                        s = null;
                    }
                    else {
                        com.iloen.melon.net.v6x.response.DjPlaylistInformRes.RESPONSE djPlaylistInformRes$RESPONSE0 = djPlaylistInformRes0.response;
                        if(djPlaylistInformRes$RESPONSE0 == null) {
                            s = null;
                        }
                        else {
                            PLAYLIST detailBaseRes$PLAYLIST0 = djPlaylistInformRes$RESPONSE0.djplaylist;
                            s = detailBaseRes$PLAYLIST0 == null ? null : detailBaseRes$PLAYLIST0.plylsttitle;
                        }
                    }
                    titleBar0.setTitle(s);
                    this.getTitleBar().setBackgroundColor(v8);
                    F8.p p0 = this.getBackButton();
                    if(p0 != null) {
                        p0.j(1);
                    }
                    I i0 = this.getMoreButton();
                    if(i0 != null) {
                        i0.j(1);
                    }
                    FragmentActivity fragmentActivity0 = this.getActivity();
                    ScreenUtils.setAppearanceLightStatusBars((fragmentActivity0 == null ? null : fragmentActivity0.getWindow()), !z);
                    View view4 = this.titleLayout;
                    if(view4 == null) {
                        q.m("titleLayout");
                        throw null;
                    }
                    view4.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F06047D));  // color:status_bar_bg
                    if(!this.isAppBarCollapsed) {
                        this.getTitleBar().f(true);
                        return;
                    }
                }
                else {
                    this.getTitleBar().setTitle("");
                    this.getTitleBar().setBackgroundColor(0);
                    this.getTitleBar().f(false);
                    FragmentActivity fragmentActivity1 = this.getActivity();
                    ScreenUtils.setAppearanceLightStatusBars((fragmentActivity1 == null ? null : fragmentActivity1.getWindow()), false);
                    View view5 = this.titleLayout;
                    if(view5 == null) {
                        q.m("titleLayout");
                        throw null;
                    }
                    view5.setBackgroundColor(0);
                    F8.p p1 = this.getBackButton();
                    if(p1 != null) {
                        p1.j(((int)z));
                    }
                    I i1 = this.getMoreButton();
                    if(i1 != null) {
                        i1.j(((int)z));
                        return;
                    }
                }
            }
            return;
        }
        super.onAppBarScrolling(v);
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        this.headerHeight = -1;
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    @NotNull
    public Q4.a onCreateHeaderLayout() {
        return E2.a(LayoutInflater.from(this.getContext()));
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable v9.h h0, @Nullable String s) {
        this.setFetchStart(true);
        BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO().plus(this.mainExceptionHandler), null, new n(i0, null) {
            final i $type;
            int label;

            {
                DjPlaylistDetailFragment.this = djPlaylistDetailFragment0;
                this.$type = i0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.onFetchStart.1(DjPlaylistDetailFragment.this, this.$type, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.onFetchStart.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.onFetchStart.1.1 djPlaylistDetailFragment$onFetchStart$1$10 = new n(this.$type, null) {
                            final i $type;
                            private Object L$0;
                            Object L$1;
                            Object L$2;
                            Object L$3;
                            Object L$4;
                            Object L$5;
                            Object L$6;
                            Object L$7;
                            int label;

                            {
                                DjPlaylistDetailFragment.this = djPlaylistDetailFragment0;
                                this.$type = i0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.onFetchStart.1.1(DjPlaylistDetailFragment.this, this.$type, continuation0);
                                continuation1.L$0 = object0;
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.onFetchStart.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                kotlin.jvm.internal.H h7;
                                kotlin.jvm.internal.H h6;
                                kotlin.jvm.internal.H h11;
                                kotlin.jvm.internal.H h10;
                                String s;
                                PLAYLIST detailBaseRes$PLAYLIST3;
                                CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                                ne.a a0 = ne.a.a;
                                switch(this.label) {
                                    case 0: {
                                        h11 = b.p(object0);
                                        h10 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
                                        Job job13 = BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new n(null) {
                                            int label;

                                            {
                                                DjPlaylistDetailFragment.this = djPlaylistDetailFragment0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                return new com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.onFetchStart.1.1.playlistInfoJob.1(DjPlaylistDetailFragment.this, continuation0);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                            }

                                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                return ((com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.onFetchStart.1.1.playlistInfoJob.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                if(this.label != 0) {
                                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                }
                                                d5.n.D(object0);
                                                DjPlaylistInformRes djPlaylistInformRes0 = DjPlaylistDetailFragment.this.requestPlaylistInfo(DjPlaylistDetailFragment.this.getPlaylistSeq());
                                                DjPlaylistDetailFragment.this.setDjPlaylistInfoRes(djPlaylistInformRes0);
                                                return H.a;
                                            }
                                        }, 3, null);
                                        Job job14 = BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new n(DjPlaylistDetailFragment.this, null) {
                                            final kotlin.jvm.internal.H $playlistSongRes;
                                            int label;

                                            {
                                                this.$playlistSongRes = h0;
                                                DjPlaylistDetailFragment.this = djPlaylistDetailFragment0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                return new com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.onFetchStart.1.1.playlistSongJob.1(this.$playlistSongRes, DjPlaylistDetailFragment.this, continuation0);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                            }

                                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                return ((com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.onFetchStart.1.1.playlistSongJob.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                if(this.label != 0) {
                                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                }
                                                d5.n.D(object0);
                                                this.$playlistSongRes.a = DjPlaylistDetailFragment.this.requestSongList(DjPlaylistDetailFragment.this.getPlaylistSeq());
                                                return H.a;
                                            }
                                        }, 3, null);
                                        com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.onFetchStart.1.1.topBannerJob.1 djPlaylistDetailFragment$onFetchStart$1$1$topBannerJob$10 = new n(DjPlaylistDetailFragment.this, null) {
                                            final kotlin.jvm.internal.H $topBannerRes;
                                            int label;

                                            {
                                                this.$topBannerRes = h0;
                                                DjPlaylistDetailFragment.this = djPlaylistDetailFragment0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                return new com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.onFetchStart.1.1.topBannerJob.1(this.$topBannerRes, DjPlaylistDetailFragment.this, continuation0);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                            }

                                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                return ((com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.onFetchStart.1.1.topBannerJob.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                if(this.label != 0) {
                                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                }
                                                d5.n.D(object0);
                                                this.$topBannerRes.a = DjPlaylistDetailFragment.this.requestTopBanner();
                                                return H.a;
                                            }
                                        };
                                        Job[] arr_job = {job13, job14, BuildersKt__Builders_commonKt.launch$default(coroutineScope0, DjPlaylistDetailFragment.this.subExceptionHandler, null, djPlaylistDetailFragment$onFetchStart$1$1$topBannerJob$10, 2, null)};
                                        this.L$0 = coroutineScope0;
                                        this.L$1 = h11;
                                        this.L$2 = h10;
                                        this.L$3 = null;
                                        this.L$4 = null;
                                        this.L$5 = null;
                                        this.label = 1;
                                        if(AwaitKt.joinAll(arr_job, this) != a0) {
                                        label_55:
                                            DjPlaylistInformRes djPlaylistInformRes0 = DjPlaylistDetailFragment.this.getDjPlaylistInfoRes();
                                            if(djPlaylistInformRes0 == null) {
                                                detailBaseRes$PLAYLIST3 = null;
                                            }
                                            else {
                                                com.iloen.melon.net.v6x.response.DjPlaylistInformRes.RESPONSE djPlaylistInformRes$RESPONSE0 = djPlaylistInformRes0.response;
                                                detailBaseRes$PLAYLIST3 = djPlaylistInformRes$RESPONSE0 == null ? null : djPlaylistInformRes$RESPONSE0.djplaylist;
                                            }
                                            DjPlaylistDetailFragment djPlaylistDetailFragment0 = DjPlaylistDetailFragment.this;
                                            if(detailBaseRes$PLAYLIST3 == null) {
                                                s = "";
                                            }
                                            else {
                                                s = detailBaseRes$PLAYLIST3.memberKey;
                                                if(s == null) {
                                                    s = "";
                                                }
                                            }
                                            djPlaylistDetailFragment0.setOwnerMemberKey(s);
                                            if("PARTNER".equals((detailBaseRes$PLAYLIST3 == null ? null : detailBaseRes$PLAYLIST3.getMemberDjType()))) {
                                                DjPlaylistDetailFragment.this.setBrandDj(true);
                                                com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.onFetchStart.1.1.middleBannerJob.1 djPlaylistDetailFragment$onFetchStart$1$1$middleBannerJob$10 = new n(detailBaseRes$PLAYLIST3, null) {
                                                    final PLAYLIST $playlist;
                                                    int label;

                                                    {
                                                        DjPlaylistDetailFragment.this = djPlaylistDetailFragment0;
                                                        this.$playlist = detailBaseRes$PLAYLIST0;
                                                        super(2, continuation0);
                                                    }

                                                    @Override  // oe.a
                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                        return new com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.onFetchStart.1.1.middleBannerJob.1(DjPlaylistDetailFragment.this, this.$playlist, continuation0);
                                                    }

                                                    @Override  // we.n
                                                    public Object invoke(Object object0, Object object1) {
                                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                    }

                                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                        return ((com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.onFetchStart.1.1.middleBannerJob.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                    }

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        if(this.label != 0) {
                                                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                        }
                                                        d5.n.D(object0);
                                                        q.f("MM_PLYLST_PTDJ", "getValue(...)");
                                                        String s = this.$playlist.memberKey;
                                                        q.f(s, "memberKey");
                                                        DjBrandBannerRes djBrandBannerRes0 = DjPlaylistDetailFragment.this.requestMiddleBanner("MM_PLYLST_PTDJ", s);
                                                        DjPlaylistDetailFragment.this.setMiddleBannerRes(djBrandBannerRes0);
                                                        return H.a;
                                                    }
                                                };
                                                Job[] arr_job1 = {BuildersKt__Builders_commonKt.launch$default(coroutineScope0, DjPlaylistDetailFragment.this.subExceptionHandler, null, djPlaylistDetailFragment$onFetchStart$1$1$middleBannerJob$10, 2, null)};
                                                this.L$0 = null;
                                                this.L$1 = h11;
                                                this.L$2 = h10;
                                                this.L$3 = null;
                                                this.L$4 = null;
                                                this.L$5 = null;
                                                this.L$6 = null;
                                                this.L$7 = null;
                                                this.label = 2;
                                                if(AwaitKt.joinAll(arr_job1, this) != a0) {
                                                    h6 = h10;
                                                    h7 = h11;
                                                    goto label_91;
                                                }
                                            }
                                            else {
                                                h6 = h10;
                                                h7 = h11;
                                            label_91:
                                                DjPlaylistInformRes djPlaylistInformRes1 = DjPlaylistDetailFragment.this.getDjPlaylistInfoRes();
                                                if(djPlaylistInformRes1 == null || !djPlaylistInformRes1.isSuccessful()) {
                                                    DjPlaylistDetailFragment.this.setFetchStart(false);
                                                    return H.a;
                                                }
                                                me.i i1 = Dispatchers.getMain().plus(DjPlaylistDetailFragment.this.mainExceptionHandler);
                                                com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.onFetchStart.1.1.1 djPlaylistDetailFragment$onFetchStart$1$1$10 = new n(DjPlaylistDetailFragment.this, h6, this.$type, null) {
                                                    final kotlin.jvm.internal.H $playlistSongRes;
                                                    final kotlin.jvm.internal.H $topBannerRes;
                                                    final i $type;
                                                    int label;

                                                    {
                                                        this.$playlistSongRes = h0;
                                                        DjPlaylistDetailFragment.this = djPlaylistDetailFragment0;
                                                        this.$topBannerRes = h1;
                                                        this.$type = i0;
                                                        super(2, continuation0);
                                                    }

                                                    @Override  // oe.a
                                                    public final Continuation create(Object object0, Continuation continuation0) {
                                                        return new com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.onFetchStart.1.1.1(this.$playlistSongRes, DjPlaylistDetailFragment.this, this.$topBannerRes, this.$type, continuation0);
                                                    }

                                                    @Override  // we.n
                                                    public Object invoke(Object object0, Object object1) {
                                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                    }

                                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                        return ((com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.onFetchStart.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                    }

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        String s5;
                                                        String s3;
                                                        String s2;
                                                        String s1;
                                                        int v;
                                                        ne.a a0 = ne.a.a;
                                                        switch(this.label) {
                                                            case 0: {
                                                                d5.n.D(object0);
                                                                MelonDjPlaylistListSongRes melonDjPlaylistListSongRes0 = (MelonDjPlaylistListSongRes)this.$playlistSongRes.a;
                                                                if((melonDjPlaylistListSongRes0 == null ? null : melonDjPlaylistListSongRes0.response) == null) {
                                                                    DjPlaylistInformRes djPlaylistInformRes0 = DjPlaylistDetailFragment.this.getDjPlaylistInfoRes();
                                                                    if(djPlaylistInformRes0 == null) {
                                                                        v = -1;
                                                                    }
                                                                    else {
                                                                        com.iloen.melon.net.v6x.response.DjPlaylistInformRes.RESPONSE djPlaylistInformRes$RESPONSE0 = djPlaylistInformRes0.response;
                                                                        if(djPlaylistInformRes$RESPONSE0 == null) {
                                                                            v = -1;
                                                                        }
                                                                        else {
                                                                            PLAYLIST detailBaseRes$PLAYLIST0 = djPlaylistInformRes$RESPONSE0.djplaylist;
                                                                            if(detailBaseRes$PLAYLIST0 == null) {
                                                                                v = -1;
                                                                            }
                                                                            else {
                                                                                String s = detailBaseRes$PLAYLIST0.songcnt;
                                                                                if(s == null) {
                                                                                    v = -1;
                                                                                }
                                                                                else {
                                                                                    Integer integer0 = v.t0(s);
                                                                                    v = integer0 == null ? -1 : ((int)integer0);
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    if(v == 0) {
                                                                        MelonDjPlaylistListSongRes melonDjPlaylistListSongRes1 = (MelonDjPlaylistListSongRes)this.$playlistSongRes.a;
                                                                        if(melonDjPlaylistListSongRes1 != null) {
                                                                            melonDjPlaylistListSongRes1.notification = null;
                                                                        }
                                                                        if(melonDjPlaylistListSongRes1 != null) {
                                                                            melonDjPlaylistListSongRes1.response = new RESPONSE();
                                                                        }
                                                                    }
                                                                }
                                                                DjPlaylistDetailFragment.this.songRes = (MelonDjPlaylistListSongRes)this.$playlistSongRes.a;
                                                                DjPlaylistDetailFragment.this.mMenuId = DjPlaylistDetailFragment.this.getDjPlaylistInfoRes() == null ? null : "";
                                                                DjPlaylistDetailFragment djPlaylistDetailFragment0 = DjPlaylistDetailFragment.this;
                                                                DjPlaylistInformRes djPlaylistInformRes1 = djPlaylistDetailFragment0.getDjPlaylistInfoRes();
                                                                if(djPlaylistInformRes1 == null) {
                                                                    s1 = null;
                                                                }
                                                                else {
                                                                    com.iloen.melon.net.v6x.response.DjPlaylistInformRes.RESPONSE djPlaylistInformRes$RESPONSE1 = djPlaylistInformRes1.response;
                                                                    s1 = djPlaylistInformRes$RESPONSE1 == null ? null : djPlaylistInformRes$RESPONSE1.section;
                                                                }
                                                                DjPlaylistInformRes djPlaylistInformRes2 = DjPlaylistDetailFragment.this.getDjPlaylistInfoRes();
                                                                if(djPlaylistInformRes2 == null) {
                                                                    s2 = null;
                                                                }
                                                                else {
                                                                    com.iloen.melon.net.v6x.response.DjPlaylistInformRes.RESPONSE djPlaylistInformRes$RESPONSE2 = djPlaylistInformRes2.response;
                                                                    s2 = djPlaylistInformRes$RESPONSE2 == null ? null : djPlaylistInformRes$RESPONSE2.page;
                                                                }
                                                                DjPlaylistInformRes djPlaylistInformRes3 = DjPlaylistDetailFragment.this.getDjPlaylistInfoRes();
                                                                if(djPlaylistInformRes3 == null) {
                                                                    s3 = null;
                                                                }
                                                                else {
                                                                    com.iloen.melon.net.v6x.response.DjPlaylistInformRes.RESPONSE djPlaylistInformRes$RESPONSE3 = djPlaylistInformRes3.response;
                                                                    s3 = djPlaylistInformRes$RESPONSE3 == null ? null : djPlaylistInformRes$RESPONSE3.menuId;
                                                                }
                                                                djPlaylistDetailFragment0.mMelonTiaraProperty = new s(s1, s2, s3, null);
                                                                DjPlaylistInformRes djPlaylistInformRes4 = DjPlaylistDetailFragment.this.getDjPlaylistInfoRes();
                                                                if(djPlaylistInformRes4 != null) {
                                                                    com.iloen.melon.net.v6x.response.DjPlaylistInformRes.RESPONSE djPlaylistInformRes$RESPONSE4 = djPlaylistInformRes4.response;
                                                                    if(djPlaylistInformRes$RESPONSE4 != null) {
                                                                        djPlaylistInformRes$RESPONSE4.appBanerListRes = (AppBanerListRes)this.$topBannerRes.a;
                                                                    }
                                                                }
                                                                Context context0 = DjPlaylistDetailFragment.this.getContext();
                                                                String s4 = DjPlaylistDetailFragment.this.getDetailCacheKey();
                                                                com.iloen.melon.responsecache.a.a(context0, DjPlaylistDetailFragment.this.getDjPlaylistInfoRes(), s4);
                                                                this.label = 1;
                                                                if(DjPlaylistDetailFragment.this.drawHeaderView(DjPlaylistDetailFragment.this.getDjPlaylistInfoRes(), this) == a0) {
                                                                    return a0;
                                                                }
                                                                break;
                                                            }
                                                            case 1: {
                                                                d5.n.D(object0);
                                                                break;
                                                            }
                                                            default: {
                                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                            }
                                                        }
                                                        DjPlaylistDetailFragment djPlaylistDetailFragment1 = DjPlaylistDetailFragment.this;
                                                        DjPlaylistInformRes djPlaylistInformRes5 = djPlaylistDetailFragment1.getDjPlaylistInfoRes();
                                                        if(djPlaylistInformRes5 == null) {
                                                            s5 = "";
                                                        }
                                                        else {
                                                            com.iloen.melon.net.v6x.response.DjPlaylistInformRes.RESPONSE djPlaylistInformRes$RESPONSE5 = djPlaylistInformRes5.response;
                                                            if(djPlaylistInformRes$RESPONSE5 == null) {
                                                                s5 = "";
                                                            }
                                                            else {
                                                                s5 = djPlaylistInformRes$RESPONSE5.bbsChannelSeq;
                                                                if(s5 == null) {
                                                                    s5 = "";
                                                                }
                                                            }
                                                        }
                                                        djPlaylistDetailFragment1.setBbsChannelSeq(s5);
                                                        boolean z = DjPlaylistDetailFragment.this.prepareFetchComplete(((HttpResponse)this.$playlistSongRes.a));
                                                        H h0 = H.a;
                                                        if(!z) {
                                                            return h0;
                                                        }
                                                        DjPlaylistDetailFragment.this.performFetchComplete(this.$type, ((HttpResponse)this.$playlistSongRes.a));
                                                        return h0;
                                                    }
                                                };
                                                this.L$0 = null;
                                                this.L$1 = null;
                                                this.L$2 = null;
                                                this.L$3 = null;
                                                this.L$4 = null;
                                                this.L$5 = null;
                                                this.L$6 = null;
                                                this.L$7 = null;
                                                this.label = 3;
                                                if(BuildersKt.withContext(i1, djPlaylistDetailFragment$onFetchStart$1$1$10, this) != a0) {
                                                label_105:
                                                    me.i i2 = Dispatchers.getMain().plus(DjPlaylistDetailFragment.this.subExceptionHandler);
                                                    com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.onFetchStart.1.1.2 djPlaylistDetailFragment$onFetchStart$1$1$20 = new n(null) {
                                                        int label;

                                                        {
                                                            DjPlaylistDetailFragment.this = djPlaylistDetailFragment0;
                                                            super(2, continuation0);
                                                        }

                                                        @Override  // oe.a
                                                        public final Continuation create(Object object0, Continuation continuation0) {
                                                            return new com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.onFetchStart.1.1.2(DjPlaylistDetailFragment.this, continuation0);
                                                        }

                                                        @Override  // we.n
                                                        public Object invoke(Object object0, Object object1) {
                                                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                        }

                                                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                            return ((com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.onFetchStart.1.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                        }

                                                        @Override  // oe.a
                                                        public final Object invokeSuspend(Object object0) {
                                                            if(this.label != 0) {
                                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                            }
                                                            d5.n.D(object0);
                                                            String s = DjPlaylistDetailFragment.this.getContsId();
                                                            CommentLatestList.requestCommentApis$default(DjPlaylistDetailFragment.this, DjPlaylistDetailFragment.this.getBbsChannelSeq(), s, false, 4, null);
                                                            return H.a;
                                                        }
                                                    };
                                                    this.L$0 = null;
                                                    this.L$1 = null;
                                                    this.L$2 = null;
                                                    this.L$3 = null;
                                                    this.L$4 = null;
                                                    this.L$5 = null;
                                                    this.L$6 = null;
                                                    this.L$7 = null;
                                                    this.label = 4;
                                                    if(BuildersKt.withContext(i2, djPlaylistDetailFragment$onFetchStart$1$1$20, this) != a0) {
                                                        DjPlaylistDetailFragment.this.setFetchStart(false);
                                                        return H.a;
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                    }
                                    case 1: {
                                        Job job10 = (Job)this.L$5;
                                        Job job11 = (Job)this.L$4;
                                        Job job12 = (Job)this.L$3;
                                        kotlin.jvm.internal.H h8 = (kotlin.jvm.internal.H)this.L$2;
                                        kotlin.jvm.internal.H h9 = (kotlin.jvm.internal.H)this.L$1;
                                        d5.n.D(object0);
                                        h10 = h8;
                                        h11 = h9;
                                        goto label_55;
                                    }
                                    case 2: {
                                        Job job6 = (Job)this.L$7;
                                        PLAYLIST detailBaseRes$PLAYLIST2 = (PLAYLIST)this.L$6;
                                        Job job7 = (Job)this.L$5;
                                        Job job8 = (Job)this.L$4;
                                        Job job9 = (Job)this.L$3;
                                        kotlin.jvm.internal.H h4 = (kotlin.jvm.internal.H)this.L$2;
                                        kotlin.jvm.internal.H h5 = (kotlin.jvm.internal.H)this.L$1;
                                        d5.n.D(object0);
                                        h6 = h4;
                                        h7 = h5;
                                        goto label_91;
                                    }
                                    case 3: {
                                        PLAYLIST detailBaseRes$PLAYLIST1 = (PLAYLIST)this.L$6;
                                        Job job3 = (Job)this.L$5;
                                        Job job4 = (Job)this.L$4;
                                        Job job5 = (Job)this.L$3;
                                        kotlin.jvm.internal.H h2 = (kotlin.jvm.internal.H)this.L$2;
                                        kotlin.jvm.internal.H h3 = (kotlin.jvm.internal.H)this.L$1;
                                        d5.n.D(object0);
                                        goto label_105;
                                    }
                                    case 4: {
                                        me.i i0 = (me.i)this.L$7;
                                        PLAYLIST detailBaseRes$PLAYLIST0 = (PLAYLIST)this.L$6;
                                        Job job0 = (Job)this.L$5;
                                        Job job1 = (Job)this.L$4;
                                        Job job2 = (Job)this.L$3;
                                        kotlin.jvm.internal.H h0 = (kotlin.jvm.internal.H)this.L$2;
                                        kotlin.jvm.internal.H h1 = (kotlin.jvm.internal.H)this.L$1;
                                        d5.n.D(object0);
                                        DjPlaylistDetailFragment.this.setFetchStart(false);
                                        return H.a;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                                return a0;
                            }
                        };
                        this.label = 1;
                        return SupervisorKt.supervisorScope(djPlaylistDetailFragment$onFetchStart$1$10, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 2, null);
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onFragmentVisibilityChanged(boolean z) {
        super.onFragmentVisibilityChanged(z);
        if(z) {
            this.updateStatusBar();
        }
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void onFriendStatusChanged() {
        DjPlaylistInformRes djPlaylistInformRes0 = this.getDjPlaylistInfoRes();
        if(djPlaylistInformRes0 != null) {
            com.iloen.melon.net.v6x.response.DjPlaylistInformRes.RESPONSE djPlaylistInformRes$RESPONSE0 = djPlaylistInformRes0.response;
            if(djPlaylistInformRes$RESPONSE0 != null) {
                PLAYLIST detailBaseRes$PLAYLIST0 = djPlaylistInformRes$RESPONSE0.djplaylist;
                if(detailBaseRes$PLAYLIST0 != null) {
                    E2 e20 = this.getPlaylistDetailHeaderBinding();
                    if(e20 != null) {
                        int v = !detailBaseRes$PLAYLIST0.isFriend;
                        detailBaseRes$PLAYLIST0.isFriend = v;
                        ViewUtils.hideWhen(e20.u, ((boolean)v));
                        ViewUtils.showWhen(e20.v, detailBaseRes$PLAYLIST0.isFriend);
                    }
                }
            }
        }
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        super.onRestoreInstanceState(bundle0);
        String s = bundle0.getString("argItemId", "");
        q.f(s, "getString(...)");
        this.setPlaylistSeq(s);
        this.isAppBarCollapsed = bundle0.getBoolean("ARG_IS_APPBAR_COLLAPSED");
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argItemId", this.getPlaylistSeq());
        bundle0.putBoolean("ARG_IS_APPBAR_COLLAPSED", this.isAppBarCollapsed);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void onToolBarClick(@Nullable ToolBarItem toolBar$ToolBarItem0, int v) {
        super.onToolBarClick(toolBar$ToolBarItem0, v);
        if(v == 0) {
            Context context0 = this.getContext();
            ParamInfo djPlaylistPlayLogReq$ParamInfo0 = new ParamInfo();
            djPlaylistPlayLogReq$ParamInfo0.plylstSeq = this.getPlaylistSeq();
            ReportService.sendLogging(new DjPlaylistPlayLogReq(context0, djPlaylistPlayLogReq$ParamInfo0));
        }
        if(2 == v) {
            Context context1 = this.getContext();
            com.iloen.melon.net.v4x.request.DjPlaylistScrapLogReq.ParamInfo djPlaylistScrapLogReq$ParamInfo0 = new com.iloen.melon.net.v4x.request.DjPlaylistScrapLogReq.ParamInfo();
            djPlaylistScrapLogReq$ParamInfo0.plylstSeq = this.getPlaylistSeq();
            ReportService.sendLogging(new DjPlaylistScrapLogReq(context1, djPlaylistScrapLogReq$ParamInfo0));
        }
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        Q4.a a0 = this.getHeaderBindingBase();
        q.e(a0, "null cannot be cast to non-null type com.iloen.melon.databinding.PlaylistDetailHeaderBinding");
        this.setPlaylistDetailHeaderBinding(((E2)a0));
        m0 m00 = this.getBinding();
        q.f(m00.k, "titleLayout");
        this.titleLayout = m00.k;
        int v = ColorUtils.getColor(this.getContext(), 0x7F06047D);  // color:status_bar_bg
        m00.k.setBackgroundColor(v);
        m0 m01 = this.getBinding();
        q.f(m01.d, "bottomDivider");
        this.bottomDivider = m01.d;
        m01.d.setVisibility(8);
        E2 e20 = this.getPlaylistDetailHeaderBinding();
        if(e20 != null) {
            FrameLayout frameLayout0 = e20.K;
            if(frameLayout0 != null) {
                frameLayout0.setVisibility(8);
            }
        }
        this.initLayout(null);
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void openProfile() {
        PLAYLIST detailBaseRes$PLAYLIST0;
        DjPlaylistInformRes djPlaylistInformRes0 = this.getDjPlaylistInfoRes();
        String s = null;
        if(djPlaylistInformRes0 == null) {
            detailBaseRes$PLAYLIST0 = null;
        }
        else {
            com.iloen.melon.net.v6x.response.DjPlaylistInformRes.RESPONSE djPlaylistInformRes$RESPONSE0 = djPlaylistInformRes0.response;
            detailBaseRes$PLAYLIST0 = djPlaylistInformRes$RESPONSE0 == null ? null : djPlaylistInformRes$RESPONSE0.djplaylist;
        }
        TimeExpiredCache.getInstance().remove(this.getCacheKey());
        if(detailBaseRes$PLAYLIST0 != null) {
            s = detailBaseRes$PLAYLIST0.memberKey;
        }
        Navigator.openUserMain(s);
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void removeDetailCache() {
        TimeExpiredCache.getInstance().remove(this.getDetailCacheKey());
    }

    private final DjBrandBannerRes requestMiddleBanner(String s, String s1) {
        RequestFuture requestFuture0 = RequestFuture.newFuture();
        return (DjBrandBannerRes)RequestBuilder.newInstance(new DjBrandBannerReq(this.getContext(), s, s1)).tag("PlaylistDetailBaseFragment").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
    }

    private final DjPlaylistInformRes requestPlaylistInfo(String s) {
        Params playlistInformBaseReq$Params0 = new Params();
        playlistInformBaseReq$Params0.plylstSeq = s;
        playlistInformBaseReq$Params0.mode = "INFORM";
        RequestFuture requestFuture0 = RequestFuture.newFuture();
        return (DjPlaylistInformRes)RequestBuilder.newInstance(new DjPlaylistInformReq(this.getContext(), playlistInformBaseReq$Params0)).tag("PlaylistDetailBaseFragment").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
    }

    private final MelonDjPlaylistListSongRes requestSongList(String s) {
        RequestFuture requestFuture0 = RequestFuture.newFuture();
        com.iloen.melon.net.v6x.request.PlaylistListSongBaseReq.Params playlistListSongBaseReq$Params0 = new com.iloen.melon.net.v6x.request.PlaylistListSongBaseReq.Params();
        playlistListSongBaseReq$Params0.plylstSeq = s;
        playlistListSongBaseReq$Params0.pageSize = 100;
        playlistListSongBaseReq$Params0.mode = "inform";
        return (MelonDjPlaylistListSongRes)RequestBuilder.newInstance(new MelonDjPlaylistListSongReq(this.getContext(), playlistListSongBaseReq$Params0)).tag("PlaylistDetailBaseFragment").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
    }

    private final AppBanerListRes requestTopBanner() {
        com.iloen.melon.net.v4x.request.AppBanerListReq.ParamInfo appBanerListReq$ParamInfo0 = new com.iloen.melon.net.v4x.request.AppBanerListReq.ParamInfo();
        appBanerListReq$ParamInfo0.bannerType = "MM_PROMO_DTL";
        appBanerListReq$ParamInfo0.contsType = "N10009";
        appBanerListReq$ParamInfo0.contsId = this.getPlaylistSeq();
        appBanerListReq$ParamInfo0.rowsCnt = "1";
        RequestFuture requestFuture0 = RequestFuture.newFuture();
        return (AppBanerListRes)RequestBuilder.newInstance(new AppBanerListReq(this.getContext(), appBanerListReq$ParamInfo0, 0)).tag("PlaylistDetailBaseFragment").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void showContextPopupPlaylistDetail() {
        if(this.isAdded() && this.isPossiblePopupShow()) {
            this.setSelectAllWithToolbar(false);
            DjPlaylistInformRes djPlaylistInformRes0 = this.getDjPlaylistInfoRes();
            if(djPlaylistInformRes0 != null) {
                com.iloen.melon.net.v6x.response.DjPlaylistInformRes.RESPONSE djPlaylistInformRes$RESPONSE0 = djPlaylistInformRes0.response;
                if(djPlaylistInformRes$RESPONSE0 != null) {
                    PLAYLIST detailBaseRes$PLAYLIST0 = djPlaylistInformRes$RESPONSE0.djplaylist;
                    if(detailBaseRes$PLAYLIST0 != null) {
                        com.melon.ui.popup.b.o(this.getChildFragmentManager(), new zd.p(detailBaseRes$PLAYLIST0, detailBaseRes$PLAYLIST0.memberNickname, detailBaseRes$PLAYLIST0.thumbImgUrl), new j(this, 1), 12);
                    }
                }
            }
        }
    }

    private static final H showContextPopupPlaylistDetail$lambda$28$lambda$27(DjPlaylistDetailFragment djPlaylistDetailFragment0, k2 k20) {
        q.g(k20, "moreListPopupOnEvent");
        H h0 = H.a;
        if(k20 instanceof A1) {
            djPlaylistDetailFragment0.openProfile();
            return h0;
        }
        if(k20 instanceof a2) {
            djPlaylistDetailFragment0.showSNSListPopup(djPlaylistDetailFragment0.getSNSSharable());
            return h0;
        }
        if(k20 instanceof F1) {
            if(djPlaylistDetailFragment0.getSongCount() < 1) {
                ToastManager.show(0x7F13036E);  // string:download_available_empty "다운로드 가능한 곡이 없습니다."
                return h0;
            }
            djPlaylistDetailFragment0.contextMenuCheckSongList(M.g);
            return h0;
        }
        if(k20 instanceof V1) {
            if(djPlaylistDetailFragment0.getSongCount() < 1) {
                ToastManager.show(0x7F130023);  // string:add_available_empty "담기 가능한 곡이 없습니다."
                return h0;
            }
            djPlaylistDetailFragment0.contextMenuCheckSongList(M.i);
            return h0;
        }
        if(k20 instanceof W1) {
            if(!djPlaylistDetailFragment0.isLoginUser()) {
                djPlaylistDetailFragment0.showLoginPopup();
                return h0;
            }
            MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
            melonLinkInfo0.b = MelonLinkExecutor.getCleanReportUrl(djPlaylistDetailFragment0.getCleanServiceCode(), djPlaylistDetailFragment0.getContsId());
            melonLinkInfo0.a = "PA";
            MelonLinkExecutor.open(melonLinkInfo0);
        }
        return h0;
    }

    @Override  // com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment
    public void updateCommentListView(@NotNull LoadPgnRes loadPgnRes0, @NotNull ListCmtRes listCmtRes0) {
        q.g(loadPgnRes0, "loadPgnRes");
        q.g(listCmtRes0, "listCmtRes");
        j0 j00 = this.getAdapter();
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.PlaylistDetailBaseFragment.PlaylistDetailAdapter");
        CmtResViewModel cmtResViewModel0 = this.getCmtResViewModel(loadPgnRes0, listCmtRes0);
        ArrayList arrayList0 = cmtResViewModel0.result.cmtlist;
        q.f(arrayList0, "cmtlist");
        if(arrayList0.isEmpty()) {
            ((PlaylistDetailAdapter)j00).add(AdapterInViewHolder.Row.create(44, H.a));
        }
        else {
            ((PlaylistDetailAdapter)j00).add(AdapterInViewHolder.Row.create(9, cmtResViewModel0));
        }
        ((PlaylistDetailAdapter)j00).notifyItemChanged(((PlaylistDetailAdapter)j00).getItemCount() - 1);
    }

    @Override  // com.iloen.melon.fragments.DetailSongMetaContentBaseFragment
    public void updateHeaderView() {
        BuildersKt__Builders_commonKt.launch$default(this, SupervisorKt.SupervisorJob$default(null, 1, null), null, new n(null) {
            int label;

            {
                DjPlaylistDetailFragment.this = djPlaylistDetailFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.updateHeaderView.1(DjPlaylistDetailFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.updateHeaderView.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        me.i i0 = Dispatchers.getMain().plus(DjPlaylistDetailFragment.this.mainExceptionHandler);
                        com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.updateHeaderView.1.1 djPlaylistDetailFragment$updateHeaderView$1$10 = new n(null) {
                            int label;

                            {
                                DjPlaylistDetailFragment.this = djPlaylistDetailFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.updateHeaderView.1.1(DjPlaylistDetailFragment.this, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.detail.DjPlaylistDetailFragment.updateHeaderView.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        DjPlaylistInformRes djPlaylistInformRes0 = DjPlaylistDetailFragment.this.fetchDetailCacheData();
                                        DjPlaylistDetailFragment.this.setDjPlaylistInfoRes(djPlaylistInformRes0);
                                        this.label = 1;
                                        return DjPlaylistDetailFragment.this.drawHeaderView(DjPlaylistDetailFragment.this.getDjPlaylistInfoRes(), this) == a0 ? a0 : H.a;
                                    }
                                    case 1: {
                                        d5.n.D(object0);
                                        return H.a;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                            }
                        };
                        this.label = 1;
                        return BuildersKt.withContext(i0, djPlaylistDetailFragment$updateHeaderView$1$10, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 2, null);
    }

    private final void updateStatusBar() {
        Window window0 = null;
        if(this.isFragmentVisible) {
            if(this.isSpecial) {
                boolean z = ScreenUtils.isDarkMode(this.getContext());
                if(this.alpha <= 0.0f) {
                    FragmentActivity fragmentActivity0 = this.getActivity();
                    if(fragmentActivity0 != null) {
                        window0 = fragmentActivity0.getWindow();
                    }
                    ScreenUtils.setAppearanceLightStatusBars(window0, !z);
                    return;
                }
                FragmentActivity fragmentActivity1 = this.getActivity();
                if(fragmentActivity1 != null) {
                    window0 = fragmentActivity1.getWindow();
                }
                ScreenUtils.setAppearanceLightStatusBars(window0, false);
                return;
            }
            FragmentActivity fragmentActivity2 = this.getActivity();
            if(fragmentActivity2 != null) {
                window0 = fragmentActivity2.getWindow();
            }
            ScreenUtils.setAppearanceLightStatusBars(window0, !ScreenUtils.isDarkMode(this.getContext()));
        }
    }
}

