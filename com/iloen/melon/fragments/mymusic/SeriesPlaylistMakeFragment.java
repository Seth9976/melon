package com.iloen.melon.fragments.mymusic;

import B.a;
import B9.u;
import De.I;
import E9.w;
import F8.K;
import F8.o;
import H0.e;
import J8.O2;
import J8.P2;
import J8.Q1;
import J8.Q2;
import J8.R2;
import J8.b;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.constants.MelonLimits.TextLimit;
import com.iloen.melon.custom.MelonEditText;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v4x.request.PlaylistUploadRepntImgBaseReq.Params;
import com.iloen.melon.net.v4x.response.PlaylistUploadRepntImgRes;
import com.iloen.melon.net.v5x.request.DjSeriesCreateReq;
import com.iloen.melon.net.v5x.request.DjSeriesDeleteReq;
import com.iloen.melon.net.v5x.request.DjSeriesModifyReq;
import com.iloen.melon.net.v5x.response.DjSeriesCreateRes;
import com.iloen.melon.net.v5x.response.DjSeriesDeleteRes;
import com.iloen.melon.net.v5x.response.DjSeriesModifyRes;
import com.iloen.melon.net.v6x.request.DjSeriesInformReq;
import com.iloen.melon.net.v6x.request.SeriesPlaylistUploadDjRepntImgReq;
import com.iloen.melon.net.v6x.response.DjSeriesInformRes.RESPONSE.SERIESPLAYLIST;
import com.iloen.melon.net.v6x.response.DjSeriesInformRes.RESPONSE;
import com.iloen.melon.net.v6x.response.DjSeriesInformRes;
import com.iloen.melon.popup.MelonTextPopup;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.TimeExpiredCache;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.dragdrop.MelonItemTouchHelper.ItemMoveListener;
import com.iloen.melon.utils.dragdrop.MelonItemTouchHelper;
import com.iloen.melon.utils.dragdrop.scroll.ScrollStrategyBase.ScrollSpeed;
import com.iloen.melon.utils.image.ImageSelector.ImageSelectorListener;
import com.iloen.melon.utils.image.ImageSelector.Request;
import com.iloen.melon.utils.image.ImageSelector;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.net.res.common.DjPlayListInfoBase;
import e.k;
import ie.H;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import v9.i;
import we.n;

@Metadata(d1 = {"\u0000\u00E7\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B*\u0001e\b\u0007\u0018\u0000 u2\u00020\u00012\u00020\u0002:\u0004uvwxB\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000E\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u000E\u0010\fJ\u0019\u0010\u0010\u001A\u00020\n2\b\u0010\u000F\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b\u0010\u0010\fJ-\u0010\u0016\u001A\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001A\u00020\u00112\b\u0010\u0014\u001A\u0004\u0018\u00010\u00132\b\u0010\u000F\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0019\u001A\u00020\n2\u0006\u0010\u0018\u001A\u00020\u00152\b\u0010\u000F\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u000F\u0010\u001B\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u001B\u0010\u0004J-\u0010\"\u001A\u00020!2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C2\b\u0010\u001F\u001A\u0004\u0018\u00010\u001E2\b\u0010 \u001A\u0004\u0018\u00010\u0005H\u0014\u00A2\u0006\u0004\b\"\u0010#J\u001B\u0010\'\u001A\u0006\u0012\u0002\b\u00030&2\u0006\u0010%\u001A\u00020$H\u0014\u00A2\u0006\u0004\b\'\u0010(J\u000F\u0010*\u001A\u00020)H\u0014\u00A2\u0006\u0004\b*\u0010+J\u0011\u0010-\u001A\u0004\u0018\u00010,H\u0014\u00A2\u0006\u0004\b-\u0010.J!\u00103\u001A\u00020\n2\b\u00100\u001A\u0004\u0018\u00010/2\u0006\u00102\u001A\u000201H\u0014\u00A2\u0006\u0004\b3\u00104J\u0017\u00106\u001A\u00020\n2\u0006\u00105\u001A\u00020!H\u0014\u00A2\u0006\u0004\b6\u00107J\u0017\u00109\u001A\u00020\n2\u0006\u00108\u001A\u00020!H\u0014\u00A2\u0006\u0004\b9\u00107J)\u0010>\u001A\u00020\n2\b\u0010;\u001A\u0004\u0018\u00010:2\u0006\u0010<\u001A\u0002012\u0006\u0010=\u001A\u00020!H\u0014\u00A2\u0006\u0004\b>\u0010?J\u000F\u0010@\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b@\u0010\u0004J\u000F\u0010A\u001A\u00020\nH\u0002\u00A2\u0006\u0004\bA\u0010\u0004J\u000F\u0010B\u001A\u00020\nH\u0002\u00A2\u0006\u0004\bB\u0010\u0004J\u000F\u0010C\u001A\u00020\nH\u0002\u00A2\u0006\u0004\bC\u0010\u0004J\u000F\u0010D\u001A\u00020\nH\u0002\u00A2\u0006\u0004\bD\u0010\u0004J\u0017\u0010G\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010F0EH\u0002\u00A2\u0006\u0004\bG\u0010HJ\u000F\u0010I\u001A\u00020\u0005H\u0002\u00A2\u0006\u0004\bI\u0010\u0007R\u0018\u0010K\u001A\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bK\u0010LR\u001A\u0010N\u001A\u00060MR\u00020\u00008\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010Q\u001A\u00020P8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010T\u001A\u00020S8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010V\u001A\u00020P8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bV\u0010RR\u0016\u0010X\u001A\u00020W8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bX\u0010YR*\u0010]\u001A\u0016\u0012\u0004\u0012\u00020[\u0018\u00010Zj\n\u0012\u0004\u0012\u00020[\u0018\u0001`\\8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010_\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010a\u001A\u00020!8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010c\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bc\u0010`R\u0018\u0010d\u001A\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bd\u0010`R\u0014\u0010f\u001A\u00020e8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010i\u001A\u00020h8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bi\u0010jR\u0014\u0010l\u001A\u00020k8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bl\u0010mR\u0014\u0010q\u001A\u00020n8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\bo\u0010pR\u0014\u0010t\u001A\u00020J8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\br\u0010s\u00A8\u0006y"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/SeriesPlaylistMakeFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "savedInstanceState", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroy", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lcom/iloen/melon/custom/ToolBar;", "buildToolBar", "()Lcom/iloen/melon/custom/ToolBar;", "Lcom/iloen/melon/custom/ToolBar$ToolBarItem;", "item", "", "itemId", "onToolBarClick", "(Lcom/iloen/melon/custom/ToolBar$ToolBarItem;I)V", "enabled", "setSelectAll", "(Z)V", "show", "updateToolBar", "", "adapter", "position", "ignoreBar", "setItemMarkWithBars", "(Ljava/lang/Object;IZ)V", "initTitleBar", "requestDjSeriesCreate", "requestDjSeriesDelete", "requestDjSeriesModify", "initSeriesPlaylist", "Lkotlinx/coroutines/Deferred;", "Lcom/iloen/melon/net/v6x/response/DjSeriesInformRes;", "requestDjSeriesInformAsync", "()Lkotlinx/coroutines/Deferred;", "getPlaylistSeqList", "LJ8/R2;", "_binding", "LJ8/R2;", "Lcom/iloen/melon/fragments/mymusic/SeriesPlaylistMakeFragment$InnerPlaylistAdapter;", "innerAdapter", "Lcom/iloen/melon/fragments/mymusic/SeriesPlaylistMakeFragment$InnerPlaylistAdapter;", "Landroid/widget/ImageView;", "initCoverThumb", "Landroid/widget/ImageView;", "Lcom/iloen/melon/custom/MelonImageView;", "coverThumb", "Lcom/iloen/melon/custom/MelonImageView;", "ivCamera", "Lcom/iloen/melon/custom/MelonEditText;", "etTitle", "Lcom/iloen/melon/custom/MelonEditText;", "Ljava/util/ArrayList;", "Lcom/melon/net/res/common/DjPlayListInfoBase;", "Lkotlin/collections/ArrayList;", "djPlaylist", "Ljava/util/ArrayList;", "seriesSeq", "Ljava/lang/String;", "isCreateMode", "Z", "seriesTitle", "repntImg", "com/iloen/melon/fragments/mymusic/SeriesPlaylistMakeFragment$imageSelectorListener$1", "imageSelectorListener", "Lcom/iloen/melon/fragments/mymusic/SeriesPlaylistMakeFragment$imageSelectorListener$1;", "Lcom/iloen/melon/utils/image/ImageSelector;", "imageSelector", "Lcom/iloen/melon/utils/image/ImageSelector;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "mainExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lme/i;", "getCoroutineContext", "()Lme/i;", "coroutineContext", "getBinding", "()LJ8/R2;", "binding", "Companion", "SeriesPlaylistMakeAdapter", "InnerPlaylistAdapter", "ServerDataWrapper", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SeriesPlaylistMakeFragment extends MetaContentBaseFragment implements CoroutineScope {
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u0011H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/SeriesPlaylistMakeFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_SERIES_SEQ", "ARG_IS_CREATE", "ARG_REPNT_IMG_URL", "VIEW_TYPE_COVER", "", "VIEW_TYPE_EDIT", "VIEW_TYPE_PLAYLIST", "newInstance", "Lcom/iloen/melon/fragments/mymusic/SeriesPlaylistMakeFragment;", "seriesSeq", "isCreateMode", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SeriesPlaylistMakeFragment newInstance(@NotNull String s, boolean z) {
            q.g(s, "seriesSeq");
            SeriesPlaylistMakeFragment seriesPlaylistMakeFragment0 = new SeriesPlaylistMakeFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argSeriesSeq", s);
            bundle0.putBoolean("argIsCreate", z);
            seriesPlaylistMakeFragment0.setArguments(bundle0);
            return seriesPlaylistMakeFragment0;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0002¢\u0006\u0004\b\u000E\u0010\u000FJ\u001F\u0010\u0012\u001A\u00020\n2\u0006\u0010\u0010\u001A\u00020\n2\u0006\u0010\u0011\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001F\u0010\u0017\u001A\u00020\u00032\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0016\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u001A\u001A\u00020\r2\b\u0010\u0019\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001A\u00020\n2\u0006\u0010\u0011\u001A\u00020\nH\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ\r\u0010\u001C\u001A\u00020\r¢\u0006\u0004\b\u001C\u0010\u001DJ\u0017\u0010\u001F\u001A\u00020\r2\b\u0010\u001E\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001F\u0010 R\u0014\u0010!\u001A\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/SeriesPlaylistMakeFragment$InnerPlaylistAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/melon/net/res/common/DjPlayListInfoBase;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/mymusic/SeriesPlaylistMakeFragment;Landroid/content/Context;Ljava/util/List;)V", "", "rawFrom", "rawTo", "Lie/H;", "dragNDrop", "(II)V", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "initTouchHelper", "()V", "data", "updateCoverThumb", "(Lcom/melon/net/res/common/DjPlayListInfoBase;)V", "VIEW_TYPE_PLAYLIST_ITEM", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class InnerPlaylistAdapter extends p {
        private final int VIEW_TYPE_PLAYLIST_ITEM;

        public InnerPlaylistAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
        }

        public static void a(SeriesPlaylistMakeFragment seriesPlaylistMakeFragment0, int v, View view0) {
            InnerPlaylistAdapter.onBindViewImpl$lambda$1$lambda$0(seriesPlaylistMakeFragment0, v, view0);
        }

        private final void dragNDrop(int v, int v1) {
            int v2 = this.getItemPositionFromList(v);
            int v3 = this.getItemPositionFromList(v1);
            if(v3 >= 0 && v3 <= this.getItemCount() - 1) {
                DjPlayListInfoBase djPlayListInfoBase0 = (DjPlayListInfoBase)this.getItem(v2);
                if(djPlayListInfoBase0 != null) {
                    this.remove(v2);
                    this.add(v3, djPlayListInfoBase0);
                }
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.VIEW_TYPE_PLAYLIST_ITEM;
        }

        public final void initTouchHelper() {
            j0 j00 = SeriesPlaylistMakeFragment.this.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.SeriesPlaylistMakeFragment.SeriesPlaylistMakeAdapter");
            MelonItemTouchHelper melonItemTouchHelper0 = new MelonItemTouchHelper(((SeriesPlaylistMakeAdapter)j00).getInnerRecyclerView());
            melonItemTouchHelper0.setAutoScrollSpeed(ScrollSpeed.SCROLL_SPEED_MIDDLE);
            melonItemTouchHelper0.setFloatingAlpha(0.8f);
            melonItemTouchHelper0.setFloatingBgColor(ColorUtils.getColor(this.getContext(), 0x7F060195));  // color:item_floating_bg
            melonItemTouchHelper0.setViewHandleId(0x7F0A0651);  // id:iv_move
            melonItemTouchHelper0.setOnItemMovedListener(new ItemMoveListener() {
                @Override  // com.iloen.melon.utils.dragdrop.MelonItemTouchHelper$ItemMoveListener
                public boolean onItemCheckEnable(int v) {
                    return true;
                }

                @Override  // com.iloen.melon.utils.dragdrop.MelonItemTouchHelper$ItemMoveListener
                public void onItemMoved(int v, int v1) {
                    SeriesPlaylistMakeFragment.this.setSelectAll(false);
                    LogU.Companion.d("SeriesPlaylistMakeFragment", "from : " + v + ", to : " + v1);
                    if(v != v1) {
                        InnerPlaylistAdapter seriesPlaylistMakeFragment$InnerPlaylistAdapter0 = SeriesPlaylistMakeFragment.this.innerAdapter;
                        if(seriesPlaylistMakeFragment$InnerPlaylistAdapter0 == null) {
                            q.m("innerAdapter");
                            throw null;
                        }
                        int v2 = seriesPlaylistMakeFragment$InnerPlaylistAdapter0.getCount();
                        if(v1 > v2 - 1) {
                            v1 = v2 - 1;
                        }
                        InnerPlaylistAdapter seriesPlaylistMakeFragment$InnerPlaylistAdapter1 = SeriesPlaylistMakeFragment.this.innerAdapter;
                        if(seriesPlaylistMakeFragment$InnerPlaylistAdapter1 == null) {
                            q.m("innerAdapter");
                            throw null;
                        }
                        DjPlayListInfoBase djPlayListInfoBase0 = (DjPlayListInfoBase)seriesPlaylistMakeFragment$InnerPlaylistAdapter1.getItem(v);
                        InnerPlaylistAdapter seriesPlaylistMakeFragment$InnerPlaylistAdapter2 = SeriesPlaylistMakeFragment.this.innerAdapter;
                        if(seriesPlaylistMakeFragment$InnerPlaylistAdapter2 == null) {
                            q.m("innerAdapter");
                            throw null;
                        }
                        if(djPlayListInfoBase0 != null && ((DjPlayListInfoBase)seriesPlaylistMakeFragment$InnerPlaylistAdapter2.getItem(v1)) != null) {
                            InnerPlaylistAdapter seriesPlaylistMakeFragment$InnerPlaylistAdapter3 = SeriesPlaylistMakeFragment.this.innerAdapter;
                            if(seriesPlaylistMakeFragment$InnerPlaylistAdapter3 == null) {
                                q.m("innerAdapter");
                                throw null;
                            }
                            seriesPlaylistMakeFragment$InnerPlaylistAdapter3.dragNDrop(v, v1);
                            ArrayList arrayList0 = new ArrayList();
                            InnerPlaylistAdapter seriesPlaylistMakeFragment$InnerPlaylistAdapter4 = SeriesPlaylistMakeFragment.this.innerAdapter;
                            if(seriesPlaylistMakeFragment$InnerPlaylistAdapter4 == null) {
                                q.m("innerAdapter");
                                throw null;
                            }
                            List list0 = seriesPlaylistMakeFragment$InnerPlaylistAdapter4.getList();
                            q.d(list0);
                            for(Object object0: list0) {
                                if(object0 instanceof DjPlayListInfoBase) {
                                    arrayList0.add(object0);
                                }
                            }
                            SeriesPlaylistMakeFragment.this.djPlaylist = arrayList0;
                            if(v1 == 0 || v == 0) {
                                InnerPlaylistAdapter seriesPlaylistMakeFragment$InnerPlaylistAdapter5 = SeriesPlaylistMakeFragment.this.innerAdapter;
                                if(seriesPlaylistMakeFragment$InnerPlaylistAdapter5 != null) {
                                    if(seriesPlaylistMakeFragment$InnerPlaylistAdapter5.getCount() > 0) {
                                        InnerPlaylistAdapter seriesPlaylistMakeFragment$InnerPlaylistAdapter6 = SeriesPlaylistMakeFragment.this.innerAdapter;
                                        if(seriesPlaylistMakeFragment$InnerPlaylistAdapter6 != null) {
                                            InnerPlaylistAdapter seriesPlaylistMakeFragment$InnerPlaylistAdapter7 = SeriesPlaylistMakeFragment.this.innerAdapter;
                                            if(seriesPlaylistMakeFragment$InnerPlaylistAdapter7 != null) {
                                                seriesPlaylistMakeFragment$InnerPlaylistAdapter6.updateCoverThumb(((DjPlayListInfoBase)seriesPlaylistMakeFragment$InnerPlaylistAdapter7.getItem(0)));
                                                return;
                                            }
                                            q.m("innerAdapter");
                                            throw null;
                                        }
                                        q.m("innerAdapter");
                                        throw null;
                                    }
                                    InnerPlaylistAdapter seriesPlaylistMakeFragment$InnerPlaylistAdapter8 = SeriesPlaylistMakeFragment.this.innerAdapter;
                                    if(seriesPlaylistMakeFragment$InnerPlaylistAdapter8 != null) {
                                        seriesPlaylistMakeFragment$InnerPlaylistAdapter8.updateCoverThumb(null);
                                        return;
                                    }
                                    q.m("innerAdapter");
                                    throw null;
                                }
                                q.m("innerAdapter");
                                throw null;
                            }
                        }
                    }
                }
            });
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            if(o00 instanceof u) {
                SeriesPlaylistMakeFragment seriesPlaylistMakeFragment0 = SeriesPlaylistMakeFragment.this;
                DjPlayListInfoBase djPlayListInfoBase0 = (DjPlayListInfoBase)this.getItem(v1);
                ((u)o00).c(djPlayListInfoBase0, v1, null, true);
                RelativeLayout relativeLayout0 = (RelativeLayout)((u)o00).a.b;
                MelonTextView melonTextView0 = ((Q1)((u)o00).a.f).k;
                ((ImageView)((u)o00).a.e).setVisibility(0);
                melonTextView0.setVisibility(0);
                q.f("%s곡", "getString(...)");
                l1.D(new Object[]{djPlayListInfoBase0.songcnt}, 1, "%s곡", melonTextView0);
                if(this.isMarked(v1)) {
                    relativeLayout0.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F060199));  // color:list_item_marked
                }
                else {
                    relativeLayout0.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F06048A));  // color:transparent
                }
                relativeLayout0.setOnClickListener(new J(seriesPlaylistMakeFragment0, v1, 4));
            }
        }

        private static final void onBindViewImpl$lambda$1$lambda$0(SeriesPlaylistMakeFragment seriesPlaylistMakeFragment0, int v, View view0) {
            seriesPlaylistMakeFragment0.onItemClick(view0, v);
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            return e.P(viewGroup0, B9.q.d);
        }

        public final void updateCoverThumb(@Nullable DjPlayListInfoBase djPlayListInfoBase0) {
            if(SeriesPlaylistMakeFragment.this.repntImg != null) {
                return;
            }
            if(SeriesPlaylistMakeFragment.this.coverThumb != null) {
                if(djPlayListInfoBase0 != null) {
                    ImageView imageView0 = SeriesPlaylistMakeFragment.this.initCoverThumb;
                    if(imageView0 != null) {
                        imageView0.setVisibility(8);
                        MelonImageView melonImageView0 = SeriesPlaylistMakeFragment.this.coverThumb;
                        if(melonImageView0 != null) {
                            RequestBuilder requestBuilder0 = Glide.with(melonImageView0).load(djPlayListInfoBase0.thumbimg);
                            MelonImageView melonImageView1 = SeriesPlaylistMakeFragment.this.coverThumb;
                            if(melonImageView1 != null) {
                                q.d(requestBuilder0.into(melonImageView1));
                                return;
                            }
                            q.m("coverThumb");
                            throw null;
                        }
                        q.m("coverThumb");
                        throw null;
                    }
                    q.m("initCoverThumb");
                    throw null;
                }
                ImageView imageView1 = SeriesPlaylistMakeFragment.this.initCoverThumb;
                if(imageView1 != null) {
                    imageView1.setVisibility(0);
                    MelonImageView melonImageView2 = SeriesPlaylistMakeFragment.this.coverThumb;
                    if(melonImageView2 != null) {
                        melonImageView2.setImageDrawable(null);
                        return;
                    }
                    q.m("coverThumb");
                    throw null;
                }
                q.m("initCoverThumb");
                throw null;
            }
            LogU.Companion.d("SeriesPlaylistMakeFragment", "updateCoverThumb - coverThumb not initialize");
        }
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u0012\u0012\b\u0012\u00060\u0002R\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0003)*+B#\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0012\u0010\b\u001A\u000E\u0012\b\u0012\u00060\u0002R\u00020\u0003\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u0004\u0018\u00010\u000B¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0015\u001A\u00020\u00142\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u001F\u0010\u001A\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0019\u001A\u00020\u0017H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ!\u0010\u001F\u001A\u00020\u00042\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C2\u0006\u0010\u001E\u001A\u00020\u0017H\u0016¢\u0006\u0004\b\u001F\u0010 J)\u0010#\u001A\u00020\"2\b\u0010!\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0019\u001A\u00020\u0017H\u0016¢\u0006\u0004\b#\u0010$R\u0014\u0010%\u001A\u00020\u00178\u0002X\u0082D¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010\'\u001A\u0004\u0018\u00010\u000B8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\'\u0010(¨\u0006,"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/SeriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/fragments/mymusic/SeriesPlaylistMakeFragment$ServerDataWrapper;", "Lcom/iloen/melon/fragments/mymusic/SeriesPlaylistMakeFragment;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/mymusic/SeriesPlaylistMakeFragment;Landroid/content/Context;Ljava/util/List;)V", "Landroidx/recyclerview/widget/RecyclerView;", "getInnerRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "TITLE_TEXT_COUNT_LIMIT", "I", "innerRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "CoverViewHolder", "SeriesEditMenuViewHolder", "PlaylistListViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class SeriesPlaylistMakeAdapter extends p {
        @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u000B\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/SeriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter$CoverViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/O2;", "binding", "<init>", "(Lcom/iloen/melon/fragments/mymusic/SeriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter;LJ8/O2;)V", "", "thumbImg", "Lie/H;", "bindItem", "(Ljava/lang/String;)V", "bind", "LJ8/O2;", "getBind", "()LJ8/O2;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class CoverViewHolder extends O0 {
            @NotNull
            private final O2 bind;

            public CoverViewHolder(@NotNull O2 o20) {
                q.g(o20, "binding");
                SeriesPlaylistMakeAdapter.this = seriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter0;
                super(o20.a);
                this.bind = o20;
                q.f(o20.b, "ivAlbumInitCover");
                SeriesPlaylistMakeFragment.this.initCoverThumb = o20.b;
                q.f(o20.c, "ivAlbumThumb");
                SeriesPlaylistMakeFragment.this.coverThumb = o20.c;
                q.f(o20.d, "ivCamera");
                SeriesPlaylistMakeFragment.this.ivCamera = o20.d;
            }

            public final void bindItem(@NotNull String s) {
                q.g(s, "thumbImg");
                LogU.Companion.d("SeriesPlaylistMakeFragment", "thumbImg:" + s);
                if(s.length() == 0) {
                    ImageView imageView0 = SeriesPlaylistMakeFragment.this.initCoverThumb;
                    if(imageView0 != null) {
                        imageView0.setVisibility(0);
                        goto label_16;
                    }
                    q.m("initCoverThumb");
                    throw null;
                }
                ImageView imageView1 = SeriesPlaylistMakeFragment.this.initCoverThumb;
                if(imageView1 != null) {
                    imageView1.setVisibility(8);
                    RequestBuilder requestBuilder0 = Glide.with(SeriesPlaylistMakeAdapter.this.getContext()).load(s);
                    MelonImageView melonImageView0 = SeriesPlaylistMakeFragment.this.coverThumb;
                    if(melonImageView0 != null) {
                        q.d(requestBuilder0.into(melonImageView0));
                    label_16:
                        ImageView imageView2 = SeriesPlaylistMakeFragment.this.ivCamera;
                        if(imageView2 != null) {
                            imageView2.setOnClickListener(new k0(SeriesPlaylistMakeFragment.this, 0));
                            return;
                        }
                        q.m("ivCamera");
                        throw null;
                    }
                    q.m("coverThumb");
                    throw null;
                }
                q.m("initCoverThumb");
                throw null;
            }

            public static void bindItem$default(CoverViewHolder seriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter$CoverViewHolder0, String s, int v, Object object0) {
                if((v & 1) != 0) {
                    s = "";
                }
                seriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter$CoverViewHolder0.bindItem(s);
            }

            private static final void bindItem$lambda$0(SeriesPlaylistMakeFragment seriesPlaylistMakeFragment0, View view0) {
                LogU.Companion.d("SeriesPlaylistMakeFragment", "ivCamera is clicked");
                seriesPlaylistMakeFragment0.imageSelector.startSelector(Request.newNormalImage(null));
            }

            @NotNull
            public final O2 getBind() {
                return this.bind;
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\u000B\u001A\u00020\n2\u0016\u0010\t\u001A\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0004\b\u000B\u0010\fR\u0017\u0010\r\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/SeriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter$PlaylistListViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/Q2;", "binding", "<init>", "(Lcom/iloen/melon/fragments/mymusic/SeriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter;LJ8/Q2;)V", "Ljava/util/ArrayList;", "Lcom/melon/net/res/common/DjPlayListInfoBase;", "Lkotlin/collections/ArrayList;", "list", "Lie/H;", "bindItem", "(Ljava/util/ArrayList;)V", "bind", "LJ8/Q2;", "getBind", "()LJ8/Q2;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class PlaylistListViewHolder extends O0 {
            @NotNull
            private final Q2 bind;

            public PlaylistListViewHolder(@NotNull Q2 q20) {
                q.g(q20, "binding");
                RecyclerView recyclerView0 = q20.b;
                SeriesPlaylistMakeAdapter.this = seriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter0;
                super(q20.a);
                this.bind = q20;
                Context context0 = seriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter0.getContext();
                InnerPlaylistAdapter seriesPlaylistMakeFragment$InnerPlaylistAdapter0 = new InnerPlaylistAdapter(SeriesPlaylistMakeFragment.this, context0, null);
                SeriesPlaylistMakeFragment.this.innerAdapter = seriesPlaylistMakeFragment$InnerPlaylistAdapter0;
                InnerPlaylistAdapter seriesPlaylistMakeFragment$InnerPlaylistAdapter1 = SeriesPlaylistMakeFragment.this.innerAdapter;
                if(seriesPlaylistMakeFragment$InnerPlaylistAdapter1 != null) {
                    seriesPlaylistMakeFragment$InnerPlaylistAdapter1.setMarkedMode(true);
                    InnerPlaylistAdapter seriesPlaylistMakeFragment$InnerPlaylistAdapter2 = SeriesPlaylistMakeFragment.this.innerAdapter;
                    if(seriesPlaylistMakeFragment$InnerPlaylistAdapter2 != null) {
                        seriesPlaylistMakeFragment$InnerPlaylistAdapter2.setListContentType(4);
                        seriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter0.innerRecyclerView = recyclerView0;
                        recyclerView0.setLayoutManager(new LinearLayoutManager(1, false));
                        recyclerView0.setHasFixedSize(true);
                        recyclerView0.setNestedScrollingEnabled(false);
                        InnerPlaylistAdapter seriesPlaylistMakeFragment$InnerPlaylistAdapter3 = SeriesPlaylistMakeFragment.this.innerAdapter;
                        if(seriesPlaylistMakeFragment$InnerPlaylistAdapter3 != null) {
                            recyclerView0.setAdapter(seriesPlaylistMakeFragment$InnerPlaylistAdapter3);
                            InnerPlaylistAdapter seriesPlaylistMakeFragment$InnerPlaylistAdapter4 = SeriesPlaylistMakeFragment.this.innerAdapter;
                            if(seriesPlaylistMakeFragment$InnerPlaylistAdapter4 != null) {
                                seriesPlaylistMakeFragment$InnerPlaylistAdapter4.initTouchHelper();
                                return;
                            }
                            q.m("innerAdapter");
                            throw null;
                        }
                        q.m("innerAdapter");
                        throw null;
                    }
                    q.m("innerAdapter");
                    throw null;
                }
                q.m("innerAdapter");
                throw null;
            }

            public final void bindItem(@NotNull ArrayList arrayList0) {
                q.g(arrayList0, "list");
                InnerPlaylistAdapter seriesPlaylistMakeFragment$InnerPlaylistAdapter0 = SeriesPlaylistMakeFragment.this.innerAdapter;
                if(seriesPlaylistMakeFragment$InnerPlaylistAdapter0 != null) {
                    if(seriesPlaylistMakeFragment$InnerPlaylistAdapter0.getCount() > 0) {
                        return;
                    }
                    InnerPlaylistAdapter seriesPlaylistMakeFragment$InnerPlaylistAdapter1 = SeriesPlaylistMakeFragment.this.innerAdapter;
                    if(seriesPlaylistMakeFragment$InnerPlaylistAdapter1 != null) {
                        seriesPlaylistMakeFragment$InnerPlaylistAdapter1.addAll(arrayList0);
                        return;
                    }
                    q.m("innerAdapter");
                    throw null;
                }
                q.m("innerAdapter");
                throw null;
            }

            @NotNull
            public final Q2 getBind() {
                return this.bind;
            }
        }

        @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u000B\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/SeriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter$SeriesEditMenuViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/P2;", "binding", "<init>", "(Lcom/iloen/melon/fragments/mymusic/SeriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter;LJ8/P2;)V", "", "title", "Lie/H;", "bindItem", "(Ljava/lang/String;)V", "bind", "LJ8/P2;", "getBind", "()LJ8/P2;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class SeriesEditMenuViewHolder extends O0 {
            @NotNull
            private final P2 bind;

            public SeriesEditMenuViewHolder(@NotNull P2 p20) {
                q.g(p20, "binding");
                SeriesPlaylistMakeAdapter.this = seriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter0;
                super(p20.a);
                this.bind = p20;
                q.f(p20.c, "etInputTitle");
                SeriesPlaylistMakeFragment.this.etTitle = p20.c;
            }

            public final void bindItem(@NotNull String s) {
                q.g(s, "title");
                if(s.length() != 0) {
                    this.bind.c.setText(s);
                }
                MelonLimits.TextLimit melonLimits$TextLimit0 = w.I(SeriesPlaylistMakeAdapter.this.TITLE_TEXT_COUNT_LIMIT);
                this.bind.c.setTextLimit(melonLimits$TextLimit0);
                l0 l00 = new l0(this, s, SeriesPlaylistMakeAdapter.this);
                this.bind.c.setOnFocusChangeListener(l00);
                com.iloen.melon.fragments.mymusic.SeriesPlaylistMakeFragment.SeriesPlaylistMakeAdapter.SeriesEditMenuViewHolder.bindItem.2 seriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter$SeriesEditMenuViewHolder$bindItem$20 = new TextWatcher() {
                    @Override  // android.text.TextWatcher
                    public void afterTextChanged(Editable editable0) {
                        q.g(editable0, "s");
                        SeriesPlaylistMakeFragment.this.seriesTitle = editable0.toString();
                    }

                    @Override  // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
                        q.g(charSequence0, "s");
                    }

                    @Override  // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
                        q.g(charSequence0, "s");
                        if(charSequence0.length() > 0) {
                            SeriesPlaylistMakeAdapter.this.getBind().d.setVisibility(0);
                        }
                        int v3 = charSequence0.length();
                        SeriesPlaylistMakeAdapter.this.getBind().d.setText(v3 + "/" + SeriesPlaylistMakeFragment.this.TITLE_TEXT_COUNT_LIMIT);
                        SeriesPlaylistMakeFragment.this.seriesTitle = charSequence0.toString();
                    }
                };
                this.bind.c.setTextWatcher(seriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter$SeriesEditMenuViewHolder$bindItem$20);
                k0 k00 = new k0(SeriesPlaylistMakeFragment.this, 1);
                this.bind.b.setOnClickListener(k00);
            }

            public static void bindItem$default(SeriesEditMenuViewHolder seriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter$SeriesEditMenuViewHolder0, String s, int v, Object object0) {
                if((v & 1) != 0) {
                    s = "";
                }
                seriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter$SeriesEditMenuViewHolder0.bindItem(s);
            }

            private static final void bindItem$lambda$0(SeriesEditMenuViewHolder seriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter$SeriesEditMenuViewHolder0, String s, SeriesPlaylistMakeAdapter seriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter0, View view0, boolean z) {
                if(z) {
                    seriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter$SeriesEditMenuViewHolder0.bind.d.setVisibility(0);
                    seriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter$SeriesEditMenuViewHolder0.bind.d.setText(s.length() + "/" + seriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter0.TITLE_TEXT_COUNT_LIMIT);
                    int v = ColorUtils.getColor(seriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter0.getContext(), 0x7F06016D);  // color:gray900s
                    seriesPlaylistMakeFragment$SeriesPlaylistMakeAdapter$SeriesEditMenuViewHolder0.bind.e.setBackgroundColor(v);
                }
            }

            private static final void bindItem$lambda$1(SeriesPlaylistMakeFragment seriesPlaylistMakeFragment0, View view0) {
                String s = seriesPlaylistMakeFragment0.getPlaylistSeqList();
                LogU.Companion.d("SeriesPlaylistMakeFragment", "SeriesEditMenuViewHolder()getPlaylistSeq - " + s);
                ArrayList arrayList0 = seriesPlaylistMakeFragment0.djPlaylist;
                if(arrayList0 != null && !arrayList0.isEmpty()) {
                    SeriesDjPlaylist.getInstance().setDjPlaylistList(seriesPlaylistMakeFragment0.djPlaylist);
                }
                Navigator.open(SeriesDjPlaylistSelectFragment.newInstance(seriesPlaylistMakeFragment0.getPlaylistSeqList(), seriesPlaylistMakeFragment0.seriesSeq));
            }

            @NotNull
            public final P2 getBind() {
                return this.bind;
            }
        }

        private final int TITLE_TEXT_COUNT_LIMIT;
        @Nullable
        private RecyclerView innerRecyclerView;

        public SeriesPlaylistMakeAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            SeriesPlaylistMakeFragment.this = seriesPlaylistMakeFragment0;
            super(context0, list0);
            this.TITLE_TEXT_COUNT_LIMIT = 40;
        }

        @Nullable
        public final RecyclerView getInnerRecyclerView() {
            return this.innerRecyclerView;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return ((ServerDataWrapper)this.getItem(v1)).getViewType();
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(@Nullable String s, @Nullable i i0, @Nullable HttpResponse httpResponse0) {
            if(httpResponse0 instanceof DjSeriesInformRes) {
                RESPONSE djSeriesInformRes$RESPONSE0 = ((DjSeriesInformRes)httpResponse0).response;
                if(djSeriesInformRes$RESPONSE0 != null) {
                    this.setMenuId(djSeriesInformRes$RESPONSE0.menuId);
                    this.updateModifiedTime(s);
                    SERIESPLAYLIST djSeriesInformRes$RESPONSE$SERIESPLAYLIST0 = djSeriesInformRes$RESPONSE0.seriesPlaylist;
                    String s1 = SeriesPlaylistMakeFragment.this.repntImg;
                    String s2 = "";
                    if(s1 == null) {
                        s1 = djSeriesInformRes$RESPONSE$SERIESPLAYLIST0 == null || (djSeriesInformRes$RESPONSE$SERIESPLAYLIST0.thumbImg == null || djSeriesInformRes$RESPONSE$SERIESPLAYLIST0.thumbImg.length() != 0) ? djSeriesInformRes$RESPONSE$SERIESPLAYLIST0.thumbImg : "";
                    }
                    SeriesPlaylistMakeFragment.this.repntImg = s1;
                    ServerDataWrapper seriesPlaylistMakeFragment$ServerDataWrapper0 = new ServerDataWrapper(SeriesPlaylistMakeFragment.this);
                    seriesPlaylistMakeFragment$ServerDataWrapper0.setViewType(0);
                    q.d(s1);
                    seriesPlaylistMakeFragment$ServerDataWrapper0.setCoverImg(s1);
                    this.add(seriesPlaylistMakeFragment$ServerDataWrapper0);
                    SeriesPlaylistMakeFragment seriesPlaylistMakeFragment0 = SeriesPlaylistMakeFragment.this;
                    if(djSeriesInformRes$RESPONSE$SERIESPLAYLIST0 != null) {
                        String s3 = djSeriesInformRes$RESPONSE$SERIESPLAYLIST0.plylstTitle;
                        if(s3 != null) {
                            s2 = s3;
                        }
                    }
                    seriesPlaylistMakeFragment0.seriesTitle = s2;
                    ServerDataWrapper seriesPlaylistMakeFragment$ServerDataWrapper1 = new ServerDataWrapper(SeriesPlaylistMakeFragment.this);
                    seriesPlaylistMakeFragment$ServerDataWrapper1.setViewType(1);
                    seriesPlaylistMakeFragment$ServerDataWrapper1.setTitle(SeriesPlaylistMakeFragment.this.seriesTitle);
                    this.add(seriesPlaylistMakeFragment$ServerDataWrapper1);
                    SeriesPlaylistMakeFragment.this.djPlaylist = djSeriesInformRes$RESPONSE$SERIESPLAYLIST0 == null ? null : djSeriesInformRes$RESPONSE$SERIESPLAYLIST0.djPlaylistList;
                    ArrayList arrayList0 = SeriesPlaylistMakeFragment.this.djPlaylist;
                    if(arrayList0 != null) {
                        ServerDataWrapper seriesPlaylistMakeFragment$ServerDataWrapper2 = new ServerDataWrapper(SeriesPlaylistMakeFragment.this);
                        seriesPlaylistMakeFragment$ServerDataWrapper2.setViewType(2);
                        seriesPlaylistMakeFragment$ServerDataWrapper2.setPlaylistList(arrayList0);
                        this.add(seriesPlaylistMakeFragment$ServerDataWrapper2);
                    }
                }
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            if(o00 instanceof CoverViewHolder) {
                String s = SeriesPlaylistMakeFragment.this.repntImg;
                String s1 = s == null || s.length() == 0 ? ((ServerDataWrapper)this.getItem(v1)).getCoverImg() : SeriesPlaylistMakeFragment.this.repntImg;
                if(s1 == null) {
                    s1 = "";
                }
                ((CoverViewHolder)o00).bindItem(s1);
                return;
            }
            if(o00 instanceof SeriesEditMenuViewHolder) {
                ((SeriesEditMenuViewHolder)o00).bindItem(((ServerDataWrapper)this.getItem(v1)).getTitle());
                return;
            }
            if(o00 instanceof PlaylistListViewHolder) {
                ((PlaylistListViewHolder)o00).bindItem(((ServerDataWrapper)this.getItem(v1)).getPlaylistList());
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            switch(v) {
                case 0: {
                    return new CoverViewHolder(this, O2.a(LayoutInflater.from(this.getContext()), viewGroup0));
                }
                case 1: {
                    View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D081D, viewGroup0, false);  // layout:series_make_edit_menu
                    int v1 = 0x7F0A0181;  // id:btn_open_playlist
                    View view1 = I.C(view0, 0x7F0A0181);  // id:btn_open_playlist
                    if(((MelonTextView)view1) != null) {
                        v1 = 0x7F0A0453;  // id:et_input_title
                        View view2 = I.C(view0, 0x7F0A0453);  // id:et_input_title
                        if(((MelonEditText)view2) != null) {
                            v1 = 0x7F0A0D40;  // id:tv_title_text_count
                            View view3 = I.C(view0, 0x7F0A0D40);  // id:tv_title_text_count
                            if(((MelonTextView)view3) != null) {
                                v1 = 0x7F0A0D6E;  // id:underline_title
                                View view4 = I.C(view0, 0x7F0A0D6E);  // id:underline_title
                                if(view4 != null) {
                                    return new SeriesEditMenuViewHolder(this, new P2(((LinearLayout)view0), ((MelonTextView)view1), ((MelonEditText)view2), ((MelonTextView)view3), view4));
                                }
                            }
                        }
                    }
                    throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
                }
                case 2: {
                    View view5 = LayoutInflater.from(this.getContext()).inflate(0x7F0D081E, viewGroup0, false);  // layout:series_playlist_list
                    RecyclerView recyclerView0 = (RecyclerView)I.C(view5, 0x7F0A0580);  // id:inner_recycler_view
                    if(recyclerView0 == null) {
                        throw new NullPointerException("Missing required view with ID: " + view5.getResources().getResourceName(0x7F0A0580));  // id:inner_recycler_view
                    }
                    return new PlaylistListViewHolder(this, new Q2(((RelativeLayout)view5), recyclerView0));
                }
                default: {
                    return new CoverViewHolder(this, O2.a(LayoutInflater.from(this.getContext()), viewGroup0));
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001A\u0010\n\u001A\u00020\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0010\u001A\u00020\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000FR*\u0010\u0013\u001A\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001A¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/SeriesPlaylistMakeFragment$ServerDataWrapper;", "", "<init>", "(Lcom/iloen/melon/fragments/mymusic/SeriesPlaylistMakeFragment;)V", "viewType", "", "getViewType", "()I", "setViewType", "(I)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "coverImg", "getCoverImg", "setCoverImg", "playlistList", "Ljava/util/ArrayList;", "Lcom/melon/net/res/common/DjPlayListInfoBase;", "Lkotlin/collections/ArrayList;", "getPlaylistList", "()Ljava/util/ArrayList;", "setPlaylistList", "(Ljava/util/ArrayList;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ServerDataWrapper {
        @NotNull
        private String coverImg;
        public ArrayList playlistList;
        @NotNull
        private String title;
        private int viewType;

        public ServerDataWrapper() {
            this.viewType = -1;
            this.title = "";
            this.coverImg = "";
        }

        @NotNull
        public final String getCoverImg() {
            return this.coverImg;
        }

        @NotNull
        public final ArrayList getPlaylistList() {
            ArrayList arrayList0 = this.playlistList;
            if(arrayList0 != null) {
                return arrayList0;
            }
            q.m("playlistList");
            throw null;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public final int getViewType() {
            return this.viewType;
        }

        public final void setCoverImg(@NotNull String s) {
            q.g(s, "<set-?>");
            this.coverImg = s;
        }

        public final void setPlaylistList(@NotNull ArrayList arrayList0) {
            q.g(arrayList0, "<set-?>");
            this.playlistList = arrayList0;
        }

        public final void setTitle(@NotNull String s) {
            q.g(s, "<set-?>");
            this.title = s;
        }

        public final void setViewType(int v) {
            this.viewType = v;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_IS_CREATE = "argIsCreate";
    @NotNull
    private static final String ARG_REPNT_IMG_URL = "argRepntImgUrl";
    @NotNull
    private static final String ARG_SERIES_SEQ = "argSeriesSeq";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "SeriesPlaylistMakeFragment";
    public static final int VIEW_TYPE_COVER = 0;
    public static final int VIEW_TYPE_EDIT = 1;
    public static final int VIEW_TYPE_PLAYLIST = 2;
    @Nullable
    private R2 _binding;
    private MelonImageView coverThumb;
    @Nullable
    private ArrayList djPlaylist;
    private MelonEditText etTitle;
    @NotNull
    private final ImageSelector imageSelector;
    @NotNull
    private final com.iloen.melon.fragments.mymusic.SeriesPlaylistMakeFragment.imageSelectorListener.1 imageSelectorListener;
    private ImageView initCoverThumb;
    private InnerPlaylistAdapter innerAdapter;
    private boolean isCreateMode;
    private ImageView ivCamera;
    @NotNull
    private final CoroutineExceptionHandler mainExceptionHandler;
    @Nullable
    private String repntImg;
    @NotNull
    private String seriesSeq;
    @NotNull
    private String seriesTitle;

    static {
        SeriesPlaylistMakeFragment.Companion = new Companion(null);
        SeriesPlaylistMakeFragment.$stable = 8;
    }

    public SeriesPlaylistMakeFragment() {
        this.seriesSeq = "";
        this.seriesTitle = "";
        com.iloen.melon.fragments.mymusic.SeriesPlaylistMakeFragment.imageSelectorListener.1 seriesPlaylistMakeFragment$imageSelectorListener$10 = new ImageSelectorListener() {
            @Override  // com.iloen.melon.utils.image.ImageSelector$ImageSelectorListener
            public void onFinishBackgroundLoading() {
            }

            @Override  // com.iloen.melon.utils.image.ImageSelector$ImageSelectorListener
            public void onImageSelectorCanceled(ImageSelector imageSelector0, Request imageSelector$Request0) {
            }

            @Override  // com.iloen.melon.utils.image.ImageSelector$ImageSelectorListener
            public void onImageSelectorComplete(ImageSelector imageSelector0, Request imageSelector$Request0, Uri uri0) {
                if(uri0 != null && !q.b(Uri.EMPTY, uri0)) {
                    String s = uri0.getPath();
                    if(s != null) {
                        File file0 = new File(s);
                        if(!file0.exists()) {
                            LogU.Companion.e("SeriesPlaylistMakeFragment", "imageSelectorListener file doesn\'t exist : " + file0);
                            return;
                        }
                        SeriesPlaylistMakeFragment.this.showProgress(true);
                        com.iloen.melon.net.RequestBuilder.newInstance(new SeriesPlaylistUploadDjRepntImgReq(SeriesPlaylistMakeFragment.this.getContext(), new Params())).tag("SeriesPlaylistMakeFragment").file("imgFile", file0).listener(new com.iloen.melon.fragments.mymusic.j0(SeriesPlaylistMakeFragment.this, 4)).errorListener(new com.iloen.melon.fragments.mymusic.j0(SeriesPlaylistMakeFragment.this, 5)).request();
                    }
                }
            }

            private static final void onImageSelectorComplete$lambda$0(SeriesPlaylistMakeFragment seriesPlaylistMakeFragment0, PlaylistUploadRepntImgRes playlistUploadRepntImgRes0) {
                seriesPlaylistMakeFragment0.showProgress(false);
                if(playlistUploadRepntImgRes0.isSuccessful()) {
                    com.iloen.melon.net.v4x.response.PlaylistUpdateRepntImgBaseRes.RESPONSE playlistUpdateRepntImgBaseRes$RESPONSE0 = playlistUploadRepntImgRes0.response;
                    if(playlistUpdateRepntImgBaseRes$RESPONSE0 != null) {
                        SeriesPlaylistMakeFragment.access$setRepntImg$p(seriesPlaylistMakeFragment0, playlistUpdateRepntImgBaseRes$RESPONSE0.repntImg);
                        if(SeriesPlaylistMakeFragment.access$getCoverThumb$p(seriesPlaylistMakeFragment0) != null) {
                            ImageView imageView0 = SeriesPlaylistMakeFragment.access$getInitCoverThumb$p(seriesPlaylistMakeFragment0);
                            if(imageView0 != null) {
                                imageView0.setVisibility(8);
                                MelonImageView melonImageView0 = SeriesPlaylistMakeFragment.access$getCoverThumb$p(seriesPlaylistMakeFragment0);
                                if(melonImageView0 != null) {
                                    RequestBuilder requestBuilder0 = Glide.with(melonImageView0).load(SeriesPlaylistMakeFragment.access$getRepntImg$p(seriesPlaylistMakeFragment0));
                                    MelonImageView melonImageView1 = SeriesPlaylistMakeFragment.access$getCoverThumb$p(seriesPlaylistMakeFragment0);
                                    if(melonImageView1 != null) {
                                        requestBuilder0.into(melonImageView1);
                                        return;
                                    }
                                    q.m("coverThumb");
                                    throw null;
                                }
                                q.m("coverThumb");
                                throw null;
                            }
                            q.m("initCoverThumb");
                            throw null;
                        }
                        LogU.Companion.d("SeriesPlaylistMakeFragment", "imageSelectorListener coverThumb not initialize");
                    }
                }
            }

            private static final void onImageSelectorComplete$lambda$1(SeriesPlaylistMakeFragment seriesPlaylistMakeFragment0, VolleyError volleyError0) {
                LogU.Companion.e("SeriesPlaylistMakeFragment", "imageSelectorListener " + volleyError0);
                seriesPlaylistMakeFragment0.showProgress(false);
                ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            }

            @Override  // com.iloen.melon.utils.image.ImageSelector$ImageSelectorListener
            public void onStartBackgroundLoading() {
            }
        };
        this.imageSelectorListener = seriesPlaylistMakeFragment$imageSelectorListener$10;
        this.imageSelector = new ImageSelector(this, seriesPlaylistMakeFragment$imageSelectorListener$10);
        this.mainExceptionHandler = new CoroutineExceptionHandler(this) {
            @Override  // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(me.i i0, Throwable throwable0) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new com.iloen.melon.fragments.mymusic.SeriesPlaylistMakeFragment.mainExceptionHandler.1.1(throwable0, SeriesPlaylistMakeFragment.this, null), 3, null);
            }
        };

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @oe.e(c = "com.iloen.melon.fragments.mymusic.SeriesPlaylistMakeFragment$mainExceptionHandler$1$1", f = "SeriesPlaylistMakeFragment.kt", l = {}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.mymusic.SeriesPlaylistMakeFragment.mainExceptionHandler.1.1 extends oe.i implements n {
            final Throwable $throwable;
            int label;

            public com.iloen.melon.fragments.mymusic.SeriesPlaylistMakeFragment.mainExceptionHandler.1.1(Throwable throwable0, SeriesPlaylistMakeFragment seriesPlaylistMakeFragment0, Continuation continuation0) {
                this.$throwable = throwable0;
                SeriesPlaylistMakeFragment.this = seriesPlaylistMakeFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.mymusic.SeriesPlaylistMakeFragment.mainExceptionHandler.1.1(this.$throwable, SeriesPlaylistMakeFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.mymusic.SeriesPlaylistMakeFragment.mainExceptionHandler.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                Throwable throwable0 = this.$throwable;
                if(throwable0 instanceof VolleyError) {
                    Y.w("mainExceptionHandler message = ", throwable0.getMessage(), LogU.Companion, "SeriesPlaylistMakeFragment");
                    SeriesPlaylistMakeFragment.access$getMResponseErrorListener$p$s1775900295(SeriesPlaylistMakeFragment.this).onErrorResponse(((VolleyError)this.$throwable));
                }
                return H.a;
            }
        }

    }

    public static final ErrorListener access$getMResponseErrorListener$p$s1775900295(SeriesPlaylistMakeFragment seriesPlaylistMakeFragment0) {
        return seriesPlaylistMakeFragment0.mResponseErrorListener;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public ToolBar buildToolBar() {
        View view0 = this.findViewById(0x7F0A0BC6);  // id:toolbar_layout
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.ToolBar");
        return ToolBar.f(((ToolBar)view0), 507);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new SeriesPlaylistMakeAdapter(this, context0, null);
        ((j)j00).setMarkedMode(true);
        ((j)j00).setListContentType(4);
        return j00;
    }

    private final R2 getBinding() {
        R2 r20 = this._binding;
        q.d(r20);
        return r20;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        if(!TextUtils.isEmpty(this.seriesSeq)) {
            String s = MelonContentUris.j0.buildUpon().appendQueryParameter("seriesSeq", this.seriesSeq).build().toString();
            q.d(s);
            return s;
        }
        return "";
    }

    @Override  // kotlinx.coroutines.CoroutineScope
    @NotNull
    public me.i getCoroutineContext() {
        return Dispatchers.getIO();
    }

    private final String getPlaylistSeqList() {
        InnerPlaylistAdapter seriesPlaylistMakeFragment$InnerPlaylistAdapter0 = this.innerAdapter;
        if(seriesPlaylistMakeFragment$InnerPlaylistAdapter0 != null) {
            Collection collection0 = seriesPlaylistMakeFragment$InnerPlaylistAdapter0.getList();
            if(collection0 != null && !collection0.isEmpty()) {
                InnerPlaylistAdapter seriesPlaylistMakeFragment$InnerPlaylistAdapter1 = this.innerAdapter;
                if(seriesPlaylistMakeFragment$InnerPlaylistAdapter1 != null) {
                    List list0 = seriesPlaylistMakeFragment$InnerPlaylistAdapter1.getList();
                    StringBuilder stringBuilder0 = new StringBuilder();
                    int v = list0.size();
                    for(int v1 = 0; v1 < v; ++v1) {
                        Object object0 = list0.get(v1);
                        if(object0 instanceof DjPlayListInfoBase) {
                            stringBuilder0.append(((DjPlayListInfoBase)object0).plylstseq);
                            if(v1 != v - 1) {
                                stringBuilder0.append(",");
                            }
                        }
                    }
                    String s = stringBuilder0.toString();
                    q.f(s, "toString(...)");
                    return s;
                }
                q.m("innerAdapter");
                throw null;
            }
        }
        return "";
    }

    private final void initSeriesPlaylist() {
        SeriesDjPlaylist.getInstance().setDjPlaylistList(null);
    }

    private final void initTitleBar() {
        this.setTitleBar(((TitleBar)this.getBinding().c.c));
        this.setTitleBarCommonButtonEventListener(this.getTitleBar());
        K k0 = new K(1, false);
        k0.c = new k0(this, 2);
        TitleBar titleBar0 = this.getTitleBar();
        o o0 = a.s(7);
        o0.g(k0);
        titleBar0.a(o0);
        TitleBar titleBar1 = this.getTitleBar();
        String s = null;
        if(!this.isCreateMode) {
            if(this.getContext() != null) {
                s = "시리즈 플레이리스트 편집";
            }
        }
        else if(this.getContext() != null) {
            s = "시리즈 플레이리스트 만들기";
        }
        titleBar1.setTitle(s);
    }

    private static final void initTitleBar$lambda$4(SeriesPlaylistMakeFragment seriesPlaylistMakeFragment0, View view0) {
        if(seriesPlaylistMakeFragment0.isCreateMode) {
            seriesPlaylistMakeFragment0.requestDjSeriesCreate();
            return;
        }
        InnerPlaylistAdapter seriesPlaylistMakeFragment$InnerPlaylistAdapter0 = seriesPlaylistMakeFragment0.innerAdapter;
        if(seriesPlaylistMakeFragment$InnerPlaylistAdapter0 == null) {
            ArrayList arrayList0 = seriesPlaylistMakeFragment0.djPlaylist;
            if(arrayList0 == null) {
                arrayList0 = je.w.a;
            }
            StringBuilder stringBuilder0 = new StringBuilder();
            int v = arrayList0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                DjPlayListInfoBase djPlayListInfoBase0 = (DjPlayListInfoBase)arrayList0.get(v1);
                if(djPlayListInfoBase0 != null) {
                    stringBuilder0.append(djPlayListInfoBase0.plylstseq);
                    if(v1 != v - 1) {
                        stringBuilder0.append(",");
                    }
                }
            }
            String s = stringBuilder0.toString();
            q.f(s, "toString(...)");
            com.iloen.melon.net.RequestBuilder.newInstance(new DjSeriesModifyReq(seriesPlaylistMakeFragment0.getContext(), seriesPlaylistMakeFragment0.seriesTitle, s, seriesPlaylistMakeFragment0.seriesSeq, seriesPlaylistMakeFragment0.repntImg)).tag("SeriesPlaylistMakeFragment").listener(new com.iloen.melon.fragments.mymusic.j0(seriesPlaylistMakeFragment0, 0)).errorListener(seriesPlaylistMakeFragment0.mResponseErrorListener).request();
            return;
        }
        if(seriesPlaylistMakeFragment$InnerPlaylistAdapter0.getCount() == 0) {
            MelonTextPopup melonTextPopup0 = new MelonTextPopup(seriesPlaylistMakeFragment0.getActivity());
            melonTextPopup0.setTitleName(seriesPlaylistMakeFragment0.getString(0x7F1300D0));  // string:alert_dlg_title_info "안내"
            melonTextPopup0.setBodyMsg(seriesPlaylistMakeFragment0.getString(0x7F13065D));  // string:melondj_series_delete_message "담겨있는 모든 플레이리스트를 제외하면 시리즈 플레이리스트가 삭제됩니다. 시리즈 
                                                                                            // 플레이리스트를 삭제하시겠습니까?"
            melonTextPopup0.setPopupOnClickListener(new m(seriesPlaylistMakeFragment0, 1));
            melonTextPopup0.show();
            return;
        }
        seriesPlaylistMakeFragment0.requestDjSeriesModify();
    }

    private static final void initTitleBar$lambda$4$lambda$1(SeriesPlaylistMakeFragment seriesPlaylistMakeFragment0, Object object0) {
        if(object0 instanceof DjSeriesModifyRes && seriesPlaylistMakeFragment0.isFragmentValid() && ((DjSeriesModifyRes)object0).isSuccessful()) {
            TimeExpiredCache.getInstance().removeLike(MelonContentUris.X.toString());
            TimeExpiredCache.getInstance().removeLike(MelonContentUris.Y.toString());
            TimeExpiredCache.getInstance().removeLike(MelonContentUris.i0.toString());
            seriesPlaylistMakeFragment0.performBackPress();
        }
    }

    private static final void initTitleBar$lambda$4$lambda$3$lambda$2(SeriesPlaylistMakeFragment seriesPlaylistMakeFragment0, DialogInterface dialogInterface0, int v) {
        if(v == -1) {
            seriesPlaylistMakeFragment0.requestDjSeriesDelete();
        }
    }

    @NotNull
    public static final SeriesPlaylistMakeFragment newInstance(@NotNull String s, boolean z) {
        return SeriesPlaylistMakeFragment.Companion.newInstance(s, z);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        this.initSeriesPlaylist();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        R2 r20 = this.getBinding();
        q.f(r20.b, "recyclerView");
        LinearLayoutManager linearLayoutManager0 = new LinearLayoutManager(r20.b.getContext());
        r20.b.setLayoutManager(linearLayoutManager0);
        r20.b.setAdapter(this.mAdapter);
        r20.b.setHasFixedSize(false);
        return r20.b;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D081F, viewGroup0, false);  // layout:series_playlist_make
        int v = 0x7F0A09D1;  // id:recycler_view
        RecyclerView recyclerView0 = (RecyclerView)I.C(view0, 0x7F0A09D1);  // id:recycler_view
        if(recyclerView0 != null) {
            v = 0x7F0A0BD5;  // id:top_titlebar
            View view1 = I.C(view0, 0x7F0A0BD5);  // id:top_titlebar
            if(view1 != null) {
                this._binding = new R2(((RelativeLayout)view0), recyclerView0, new b(((TitleBar)view1), ((TitleBar)view1), 12));
                return this.getBinding().a;
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        String s1;
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.SeriesPlaylistMakeFragment.SeriesPlaylistMakeAdapter");
        if(i.b.equals(i0)) {
            ((SeriesPlaylistMakeAdapter)j00).clear();
        }
        SeriesDjPlaylist seriesDjPlaylist0 = SeriesDjPlaylist.getInstance();
        this.djPlaylist = seriesDjPlaylist0 == null ? null : seriesDjPlaylist0.getDjPlaylistList();
        if(this.seriesSeq.length() == 0 || this.djPlaylist != null && !this.djPlaylist.isEmpty()) {
            InnerPlaylistAdapter seriesPlaylistMakeFragment$InnerPlaylistAdapter0 = this.innerAdapter;
            if(seriesPlaylistMakeFragment$InnerPlaylistAdapter0 != null) {
                seriesPlaylistMakeFragment$InnerPlaylistAdapter0.clear();
            }
            ServerDataWrapper seriesPlaylistMakeFragment$ServerDataWrapper0 = new ServerDataWrapper(this);
            seriesPlaylistMakeFragment$ServerDataWrapper0.setViewType(0);
            ArrayList arrayList0 = this.djPlaylist;
            if(arrayList0 == null) {
                s1 = "";
            }
            else {
                DjPlayListInfoBase djPlayListInfoBase0 = (DjPlayListInfoBase)arrayList0.get(0);
                if(djPlayListInfoBase0 == null) {
                    s1 = "";
                }
                else {
                    s1 = djPlayListInfoBase0.thumbimg;
                    if(s1 == null) {
                        s1 = "";
                    }
                }
            }
            seriesPlaylistMakeFragment$ServerDataWrapper0.setCoverImg(s1);
            ((SeriesPlaylistMakeAdapter)j00).add(seriesPlaylistMakeFragment$ServerDataWrapper0);
            ServerDataWrapper seriesPlaylistMakeFragment$ServerDataWrapper1 = new ServerDataWrapper(this);
            seriesPlaylistMakeFragment$ServerDataWrapper1.setViewType(1);
            seriesPlaylistMakeFragment$ServerDataWrapper1.setTitle(this.seriesTitle);
            ((SeriesPlaylistMakeAdapter)j00).add(seriesPlaylistMakeFragment$ServerDataWrapper1);
            ArrayList arrayList1 = this.djPlaylist;
            if(arrayList1 != null) {
                ServerDataWrapper seriesPlaylistMakeFragment$ServerDataWrapper2 = new ServerDataWrapper(this);
                seriesPlaylistMakeFragment$ServerDataWrapper2.setViewType(2);
                seriesPlaylistMakeFragment$ServerDataWrapper2.setPlaylistList(arrayList1);
                ((SeriesPlaylistMakeAdapter)j00).add(seriesPlaylistMakeFragment$ServerDataWrapper2);
            }
            return false;
        }
        com.iloen.melon.fragments.mymusic.SeriesPlaylistMakeFragment.onFetchStart.4 seriesPlaylistMakeFragment$onFetchStart$40 = new n(i0, null) {
            final i $type;
            Object L$0;
            Object L$1;
            int label;

            {
                SeriesPlaylistMakeFragment.this = seriesPlaylistMakeFragment0;
                this.$type = i0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.mymusic.SeriesPlaylistMakeFragment.onFetchStart.4(SeriesPlaylistMakeFragment.this, this.$type, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.mymusic.SeriesPlaylistMakeFragment.onFetchStart.4)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        Deferred deferred0 = SeriesPlaylistMakeFragment.this.requestDjSeriesInformAsync();
                        this.label = 1;
                        object0 = deferred0.await(this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        break;
                    }
                    case 2: {
                        me.i i0 = (me.i)this.L$1;
                        DjSeriesInformRes djSeriesInformRes0 = (DjSeriesInformRes)this.L$0;
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                me.i i1 = Dispatchers.getMain().plus(SeriesPlaylistMakeFragment.this.mainExceptionHandler);
                com.iloen.melon.fragments.mymusic.SeriesPlaylistMakeFragment.onFetchStart.4.1 seriesPlaylistMakeFragment$onFetchStart$4$10 = new n(((DjSeriesInformRes)object0), this.$type, null) {
                    final DjSeriesInformRes $djSeriesInformRes;
                    final i $type;
                    int label;

                    {
                        SeriesPlaylistMakeFragment.this = seriesPlaylistMakeFragment0;
                        this.$djSeriesInformRes = djSeriesInformRes0;
                        this.$type = i0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.fragments.mymusic.SeriesPlaylistMakeFragment.onFetchStart.4.1(SeriesPlaylistMakeFragment.this, this.$djSeriesInformRes, this.$type, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.fragments.mymusic.SeriesPlaylistMakeFragment.onFetchStart.4.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        if(this.label != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        d5.n.D(object0);
                        boolean z = SeriesPlaylistMakeFragment.this.prepareFetchComplete(this.$djSeriesInformRes);
                        H h0 = H.a;
                        if(!z) {
                            return h0;
                        }
                        SeriesPlaylistMakeFragment.this.performFetchComplete(this.$type, this.$djSeriesInformRes);
                        return h0;
                    }
                };
                this.L$0 = null;
                this.L$1 = null;
                this.label = 2;
                return BuildersKt.withContext(i1, seriesPlaylistMakeFragment$onFetchStart$4$10, this) == a0 ? a0 : H.a;
            }
        };
        BuildersKt__Builders_commonKt.launch$default(this, this.mainExceptionHandler, null, seriesPlaylistMakeFragment$onFetchStart$40, 2, null);
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        this.seriesSeq = l1.g(bundle0, "inState", "argSeriesSeq", "", "getString(...)");
        this.repntImg = bundle0.getString("argRepntImgUrl", null);
        this.isCreateMode = bundle0.getBoolean("argIsCreate");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argSeriesSeq", this.seriesSeq);
        bundle0.putString("argRepntImgUrl", this.repntImg);
        bundle0.putBoolean("argIsCreate", this.isCreateMode);
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onToolBarClick(@Nullable ToolBarItem toolBar$ToolBarItem0, int v) {
        if(16 == v) {
            InnerPlaylistAdapter seriesPlaylistMakeFragment$InnerPlaylistAdapter0 = this.innerAdapter;
            if(seriesPlaylistMakeFragment$InnerPlaylistAdapter0 != null) {
                if(seriesPlaylistMakeFragment$InnerPlaylistAdapter0.getMarkedCount() < 1) {
                    String s = this.getString(0x7F130091);  // string:alert_dlg_body_delete_playlist_select_content "플레이리스트를 선택해 주세요."
                    q.f(s, "getString(...)");
                    androidx.fragment.app.l0 l00 = this.getChildFragmentManager();
                    String s1 = this.getString(0x7F1300CD);  // string:alert_dlg_title_delete_confirm "안내"
                    com.melon.ui.popup.b.d(com.melon.ui.popup.b.a, l00, s1, s, false, false, false, null, null, null, null, null, 2040);
                    return;
                }
                List list0 = seriesPlaylistMakeFragment$InnerPlaylistAdapter0.getMarkedItems();
                q.d(list0);
                int v1 = 0;
                for(Object object0: list0) {
                    DjPlayListInfoBase djPlayListInfoBase0 = null;
                    if(v1 >= 0) {
                        seriesPlaylistMakeFragment$InnerPlaylistAdapter0.remove(((int)(((Integer)object0))) - v1);
                        ArrayList arrayList0 = this.djPlaylist;
                        if(arrayList0 != null) {
                            DjPlayListInfoBase djPlayListInfoBase1 = (DjPlayListInfoBase)arrayList0.remove(((int)(((Integer)object0))) - v1);
                        }
                        if(((int)(((Integer)object0))) - v1 == 0) {
                            if(this.djPlaylist == null || this.djPlaylist.isEmpty()) {
                                this.initSeriesPlaylist();
                                InnerPlaylistAdapter seriesPlaylistMakeFragment$InnerPlaylistAdapter2 = this.innerAdapter;
                                if(seriesPlaylistMakeFragment$InnerPlaylistAdapter2 != null) {
                                    seriesPlaylistMakeFragment$InnerPlaylistAdapter2.updateCoverThumb(null);
                                    this.hideToolBar();
                                    ++v1;
                                    continue;
                                }
                            }
                            else {
                                InnerPlaylistAdapter seriesPlaylistMakeFragment$InnerPlaylistAdapter1 = this.innerAdapter;
                                if(seriesPlaylistMakeFragment$InnerPlaylistAdapter1 != null) {
                                    ArrayList arrayList1 = this.djPlaylist;
                                    if(arrayList1 != null) {
                                        djPlayListInfoBase0 = (DjPlayListInfoBase)arrayList1.get(0);
                                    }
                                    seriesPlaylistMakeFragment$InnerPlaylistAdapter1.updateCoverThumb(djPlayListInfoBase0);
                                    ++v1;
                                    continue;
                                }
                            }
                            q.m("innerAdapter");
                            throw null;
                        }
                        ++v1;
                        continue;
                    }
                    k.O();
                    throw null;
                }
                this.setSelectAll(false);
            }
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.initTitleBar();
    }

    private final void requestDjSeriesCreate() {
        com.iloen.melon.net.RequestBuilder.newInstance(new DjSeriesCreateReq(this.getContext(), this.seriesTitle, this.getPlaylistSeqList(), this.seriesSeq, this.repntImg)).tag("SeriesPlaylistMakeFragment").listener(new com.iloen.melon.fragments.mymusic.j0(this, 3)).errorListener(this.mResponseErrorListener).request();
    }

    private static final void requestDjSeriesCreate$lambda$5(SeriesPlaylistMakeFragment seriesPlaylistMakeFragment0, Object object0) {
        if(object0 instanceof DjSeriesCreateRes && seriesPlaylistMakeFragment0.isFragmentValid() && ((DjSeriesCreateRes)object0).isSuccessful()) {
            TimeExpiredCache.getInstance().removeLike(MelonContentUris.X.toString());
            TimeExpiredCache.getInstance().removeLike(MelonContentUris.Y.toString());
            TimeExpiredCache.getInstance().removeLike(MelonContentUris.i0.toString());
            seriesPlaylistMakeFragment0.performBackPress();
        }
    }

    private final void requestDjSeriesDelete() {
        com.iloen.melon.net.RequestBuilder.newInstance(new DjSeriesDeleteReq(this.getContext(), this.seriesSeq)).tag("SeriesPlaylistMakeFragment").listener(new com.iloen.melon.fragments.mymusic.j0(this, 1)).errorListener(new W(17)).request();
    }

    private static final void requestDjSeriesDelete$lambda$6(SeriesPlaylistMakeFragment seriesPlaylistMakeFragment0, Object object0) {
        if(object0 instanceof DjSeriesDeleteRes && seriesPlaylistMakeFragment0.isFragmentValid() && ((DjSeriesDeleteRes)object0).isSuccessful()) {
            TimeExpiredCache.getInstance().removeLike(MelonContentUris.X.toString());
            TimeExpiredCache.getInstance().removeLike(MelonContentUris.Y.toString());
            TimeExpiredCache.getInstance().removeLike(MelonContentUris.i0.toString());
            seriesPlaylistMakeFragment0.performBackPress();
        }
    }

    private static final void requestDjSeriesDelete$lambda$7(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    private final Deferred requestDjSeriesInformAsync() {
        return BuildersKt__Builders_commonKt.async$default(this, null, null, new n(null) {
            int label;

            {
                SeriesPlaylistMakeFragment.this = seriesPlaylistMakeFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.mymusic.SeriesPlaylistMakeFragment.requestDjSeriesInformAsync.1(SeriesPlaylistMakeFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.mymusic.SeriesPlaylistMakeFragment.requestDjSeriesInformAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                RequestFuture requestFuture0 = RequestFuture.newFuture();
                HttpResponse httpResponse0 = com.iloen.melon.net.RequestBuilder.newInstance(new DjSeriesInformReq(SeriesPlaylistMakeFragment.this.getContext(), SeriesPlaylistMakeFragment.this.seriesSeq, SeriesPlaylistMakeFragment.this.isCreateMode)).tag("SeriesPlaylistMakeFragment").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.DjSeriesInformRes");
                return (DjSeriesInformRes)httpResponse0;
            }
        }, 3, null);
    }

    private final void requestDjSeriesModify() {
        com.iloen.melon.net.RequestBuilder.newInstance(new DjSeriesModifyReq(this.getContext(), this.seriesTitle, this.getPlaylistSeqList(), this.seriesSeq, this.repntImg)).tag("SeriesPlaylistMakeFragment").listener(new com.iloen.melon.fragments.mymusic.j0(this, 2)).errorListener(this.mResponseErrorListener).request();
    }

    private static final void requestDjSeriesModify$lambda$8(SeriesPlaylistMakeFragment seriesPlaylistMakeFragment0, Object object0) {
        if(object0 instanceof DjSeriesModifyRes && seriesPlaylistMakeFragment0.isFragmentValid() && ((DjSeriesModifyRes)object0).isSuccessful()) {
            TimeExpiredCache.getInstance().removeLike(MelonContentUris.X.toString());
            TimeExpiredCache.getInstance().removeLike(MelonContentUris.Y.toString());
            TimeExpiredCache.getInstance().removeLike(MelonContentUris.i0.toString());
            seriesPlaylistMakeFragment0.performBackPress();
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void setItemMarkWithBars(@Nullable Object object0, int v, boolean z) {
        InnerPlaylistAdapter seriesPlaylistMakeFragment$InnerPlaylistAdapter0 = this.innerAdapter;
        if(seriesPlaylistMakeFragment$InnerPlaylistAdapter0 != null) {
            super.setItemMarkWithBars(seriesPlaylistMakeFragment$InnerPlaylistAdapter0, v, z);
            return;
        }
        q.m("innerAdapter");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void setSelectAll(boolean z) {
        if(this.innerAdapter == null || this.innerAdapter.getCount() == 0) {
            return;
        }
        if(z) {
            InnerPlaylistAdapter seriesPlaylistMakeFragment$InnerPlaylistAdapter0 = this.innerAdapter;
            if(seriesPlaylistMakeFragment$InnerPlaylistAdapter0 != null) {
                seriesPlaylistMakeFragment$InnerPlaylistAdapter0.setMarkedAll();
                return;
            }
            q.m("innerAdapter");
            throw null;
        }
        this.hideToolBar();
        InnerPlaylistAdapter seriesPlaylistMakeFragment$InnerPlaylistAdapter1 = this.innerAdapter;
        if(seriesPlaylistMakeFragment$InnerPlaylistAdapter1 != null) {
            seriesPlaylistMakeFragment$InnerPlaylistAdapter1.setUnmarkedAll();
            return;
        }
        q.m("innerAdapter");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void updateToolBar(boolean z) {
        ToolBar toolBar0 = this.mToolBar;
        if(toolBar0 != null) {
            InnerPlaylistAdapter seriesPlaylistMakeFragment$InnerPlaylistAdapter0 = this.innerAdapter;
            if(seriesPlaylistMakeFragment$InnerPlaylistAdapter0 != null) {
                boolean z1 = toolBar0 == null ? false : toolBar0.k;
                if(z) {
                    if(toolBar0 != null) {
                        int v = seriesPlaylistMakeFragment$InnerPlaylistAdapter0.getMarkedCount();
                        if(v > 0) {
                            this.mToolBar.l(v);
                        }
                        else {
                            this.mToolBar.d();
                        }
                    }
                    if(!z1) {
                        this.showToolBar();
                    }
                }
                else {
                    if(toolBar0 != null) {
                        toolBar0.d();
                    }
                    if(!z1) {
                        this.hideToolBar();
                    }
                }
            }
        }
    }
}

