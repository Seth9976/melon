package com.iloen.melon.fragments.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.o;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.FilterDropDownView;
import com.iloen.melon.custom.SearchBarView;
import com.iloen.melon.custom.SortingBarView;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.MelonError;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.MyMusicDeleteBanSongReq.Params;
import com.iloen.melon.net.v4x.request.MyMusicDeleteBanSongReq;
import com.iloen.melon.net.v4x.request.SettingGnrMenuReq;
import com.iloen.melon.net.v4x.response.MyMusicDeleteBanSongRes;
import com.iloen.melon.net.v4x.response.SettingGnrMenuRes.RESPONSE.GNRMENULIST.GNRLIST;
import com.iloen.melon.net.v4x.response.SettingGnrMenuRes.RESPONSE.GNRMENULIST;
import com.iloen.melon.net.v4x.response.SettingGnrMenuRes;
import com.iloen.melon.net.v6x.request.BanListBannedSongReq;
import com.iloen.melon.net.v6x.response.BanListBannedSongRes.RESPONSE.LISTSONG;
import com.iloen.melon.net.v6x.response.BanListBannedSongRes.RESPONSE;
import com.iloen.melon.net.v6x.response.BanListBannedSongRes;
import com.iloen.melon.popup.CommonFilterPopup;
import com.iloen.melon.userstore.entity.ExcludedArtistEntity;
import com.iloen.melon.userstore.utils.UserDataSyncTask;
import com.iloen.melon.utils.TimeExpiredCache;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.ExcludedArtistHolder;
import com.melon.net.res.common.SongInfoBase;
import d3.g;
import e1.u;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import k8.b;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.e;
import va.e0;
import we.n;
import z9.F;
import z9.i;
import z9.j;
import z9.k;

@Metadata(d1 = {"\u0000\u00A8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 _2\u00020\u0001:\u0004_`abB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\r\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\r\u0010\u000BJ-\u0010\u0014\u001A\u0004\u0018\u00010\u00132\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\b\u0010\u0012\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001A\u00020\t2\u0006\u0010\u0016\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001A\u001A\u0004\u0018\u00010\u0019H\u0014\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u001B\u0010\u001F\u001A\u0006\u0012\u0002\b\u00030\u001E2\u0006\u0010\u001D\u001A\u00020\u001CH\u0014\u00A2\u0006\u0004\b\u001F\u0010 J\u0011\u0010\"\u001A\u0004\u0018\u00010!H\u0014\u00A2\u0006\u0004\b\"\u0010#J!\u0010\'\u001A\u00020\t2\b\u0010%\u001A\u0004\u0018\u00010$2\u0006\u0010&\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\'\u0010(J-\u00100\u001A\u00020/2\b\u0010*\u001A\u0004\u0018\u00010)2\b\u0010,\u001A\u0004\u0018\u00010+2\b\u0010.\u001A\u0004\u0018\u00010-H\u0014\u00A2\u0006\u0004\b0\u00101J\u000F\u00102\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b2\u0010\u0003J\u000F\u00104\u001A\u000203H\u0002\u00A2\u0006\u0004\b4\u00105J\u0017\u00107\u001A\u00020\t2\u0006\u00106\u001A\u00020/H\u0002\u00A2\u0006\u0004\b7\u00108J\u0017\u0010:\u001A\u00020\t2\u0006\u00109\u001A\u00020/H\u0002\u00A2\u0006\u0004\b:\u00108J\u0019\u0010;\u001A\u00020/2\b\u0010*\u001A\u0004\u0018\u00010)H\u0002\u00A2\u0006\u0004\b;\u0010<J\u0019\u0010=\u001A\u00020/2\b\u0010*\u001A\u0004\u0018\u00010)H\u0002\u00A2\u0006\u0004\b=\u0010<J\u0019\u0010>\u001A\u00020/2\b\u0010*\u001A\u0004\u0018\u00010)H\u0002\u00A2\u0006\u0004\b>\u0010<J\u0017\u0010@\u001A\u00020\t2\u0006\u0010?\u001A\u00020-H\u0002\u00A2\u0006\u0004\b@\u0010AJ\u0019\u0010C\u001A\u00020\t2\b\u0010B\u001A\u0004\u0018\u00010-H\u0002\u00A2\u0006\u0004\bC\u0010AR\u0016\u0010D\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bF\u0010ER\u0016\u0010H\u001A\u00020G8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010K\u001A\u00020J8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010N\u001A\u00020M8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bN\u0010OR?\u0010V\u001A&\u0012\f\u0012\n Q*\u0004\u0018\u00010-0- Q*\u0012\u0012\u000E\b\u0001\u0012\n Q*\u0004\u0018\u00010-0-0P0P8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\bR\u0010S\u001A\u0004\bT\u0010UR?\u0010Y\u001A&\u0012\f\u0012\n Q*\u0004\u0018\u00010-0- Q*\u0012\u0012\u000E\b\u0001\u0012\n Q*\u0004\u0018\u00010-0-0P0P8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\bW\u0010S\u001A\u0004\bX\u0010UR\u001F\u0010^\u001A\u00060ZR\u00020\u00008BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b[\u0010S\u001A\u0004\b\\\u0010]\u00A8\u0006c"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingBannedContentsFragment;", "Lcom/iloen/melon/fragments/settings/SettingBaseFragment;", "<init>", "()V", "", "getTitleResId", "()I", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Lcom/iloen/melon/custom/ToolBar;", "buildToolBar", "()Lcom/iloen/melon/custom/ToolBar;", "Lcom/iloen/melon/custom/ToolBar$ToolBarItem;", "item", "itemId", "onToolBarClick", "(Lcom/iloen/melon/custom/ToolBar$ToolBarItem;I)V", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "updateUI", "Landroidx/recyclerview/widget/GridLayoutManager;", "getGridLayoutManager", "()Landroidx/recyclerview/widget/GridLayoutManager;", "show", "showToolbar", "(Z)V", "condition", "showSearchBar", "requesBannedSongList", "(Lv9/i;)Z", "requestBannedArtist", "requestGnrMenu", "menuId", "deleteBanSongList", "(Ljava/lang/String;)V", "errorMessage", "performError", "currentSortIndex", "I", "currentFilterIndex", "Landroid/widget/TextView;", "tvBannedExPlain", "Landroid/widget/TextView;", "Lcom/iloen/melon/custom/SortingBarView;", "sortingBarView", "Lcom/iloen/melon/custom/SortingBarView;", "Lcom/iloen/melon/custom/FilterDropDownView;", "filterDropDownView", "Lcom/iloen/melon/custom/FilterDropDownView;", "", "kotlin.jvm.PlatformType", "arrayBannedExplain$delegate", "Lie/j;", "getArrayBannedExplain", "()[Ljava/lang/String;", "arrayBannedExplain", "arrayFilterText$delegate", "getArrayFilterText", "arrayFilterText", "Lcom/iloen/melon/fragments/settings/SettingBannedContentsFragment$GenreItemDecoration;", "itemDecoration$delegate", "getItemDecoration", "()Lcom/iloen/melon/fragments/settings/SettingBannedContentsFragment$GenreItemDecoration;", "itemDecoration", "Companion", "BannedContentsAdapter", "GenreInfo", "GenreItemDecoration", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SettingBannedContentsFragment extends SettingBaseFragment {
    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00042345B!\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\nH\u0003¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000F\u001A\u00020\u000EH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001B\u0010\u0015\u001A\u00020\u00102\n\u0010\u000F\u001A\u00060\u0013R\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001B\u0010\u0017\u001A\u00020\u00102\n\u0010\u000F\u001A\u00060\u0013R\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J-\u0010\u001E\u001A\u00020\u001D2\b\u0010\u0018\u001A\u0004\u0018\u00010\n2\b\u0010\u001A\u001A\u0004\u0018\u00010\u00192\b\u0010\u001C\u001A\u0004\u0018\u00010\u001BH\u0014¢\u0006\u0004\b\u001E\u0010\u001FJ\u001F\u0010#\u001A\u00020\u00102\u0006\u0010!\u001A\u00020 2\u0006\u0010\"\u001A\u00020\u001DH\u0016¢\u0006\u0004\b#\u0010$J\u000F\u0010%\u001A\u00020 H\u0014¢\u0006\u0004\b%\u0010&J\u001F\u0010(\u001A\u00020 2\u0006\u0010\'\u001A\u00020 2\u0006\u0010!\u001A\u00020 H\u0016¢\u0006\u0004\b(\u0010)J#\u0010-\u001A\u0004\u0018\u00010\u00032\b\u0010+\u001A\u0004\u0018\u00010*2\u0006\u0010,\u001A\u00020 H\u0016¢\u0006\u0004\b-\u0010.J)\u00100\u001A\u00020\u00102\b\u0010/\u001A\u0004\u0018\u00010\u00032\u0006\u0010\'\u001A\u00020 2\u0006\u0010!\u001A\u00020 H\u0016¢\u0006\u0004\b0\u00101¨\u00066"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingBannedContentsFragment$BannedContentsAdapter;", "Lcom/iloen/melon/adapters/common/p;", "", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/settings/SettingBannedContentsFragment;Landroid/content/Context;Ljava/util/List;)V", "", "serverDate", "parseFromServerDate", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/iloen/melon/userstore/entity/ExcludedArtistEntity;", "item", "Lie/H;", "deleteBannedArtist", "(Lcom/iloen/melon/userstore/entity/ExcludedArtistEntity;)V", "Lcom/iloen/melon/fragments/settings/SettingBannedContentsFragment$GenreInfo;", "Lcom/iloen/melon/fragments/settings/SettingBannedContentsFragment;", "deleteBannedGenre", "(Lcom/iloen/melon/fragments/settings/SettingBannedContentsFragment$GenreInfo;)V", "insertBannedGenre", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "", "position", "marked", "setMarked", "(IZ)V", "getHeaderViewItemCount", "()I", "rawPosition", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "vh", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "BannedSongHolder", "CountHeaderView", "GnrTitleView", "GnrMenuView", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class BannedContentsAdapter extends p {
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\tR\u0017\u0010\u000B\u001A\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000ER\u0017\u0010\u000F\u001A\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000F\u0010\f\u001A\u0004\b\u0010\u0010\u000ER\u0017\u0010\u0011\u001A\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\f\u001A\u0004\b\u0012\u0010\u000ER\u0017\u0010\u0014\u001A\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001A\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001A\u0004\b\u0019\u0010\u0017R\u0017\u0010\u001A\u001A\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u001A\u0010\u0015\u001A\u0004\b\u001B\u0010\u0017R\u0017\u0010\u001C\u001A\u00020\n8\u0006¢\u0006\f\n\u0004\b\u001C\u0010\f\u001A\u0004\b\u001D\u0010\u000E¨\u0006\u001E"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingBannedContentsFragment$BannedContentsAdapter$BannedSongHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/settings/SettingBannedContentsFragment$BannedContentsAdapter;Landroid/view/View;)V", "thumbContainer", "Landroid/view/View;", "getThumbContainer", "()Landroid/view/View;", "Landroid/widget/ImageView;", "thumbnailIv", "Landroid/widget/ImageView;", "getThumbnailIv", "()Landroid/widget/ImageView;", "defaultThumbnailIv", "getDefaultThumbnailIv", "list19Iv", "getList19Iv", "Landroid/widget/TextView;", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "artistTv", "getArtistTv", "datetimeTv", "getDatetimeTv", "checkIv", "getCheckIv", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class BannedSongHolder extends O0 {
            @NotNull
            private final TextView artistTv;
            @NotNull
            private final ImageView checkIv;
            @NotNull
            private final TextView datetimeTv;
            @NotNull
            private final ImageView defaultThumbnailIv;
            @NotNull
            private final ImageView list19Iv;
            @NotNull
            private final View thumbContainer;
            @NotNull
            private final ImageView thumbnailIv;
            @NotNull
            private final TextView titleTv;

            public BannedSongHolder(@NotNull View view0) {
                q.g(view0, "view");
                BannedContentsAdapter.this = settingBannedContentsFragment$BannedContentsAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0B72);  // id:thumb_container
                q.f(view1, "findViewById(...)");
                this.thumbContainer = view1;
                View view2 = view1.findViewById(0x7F0A069A);  // id:iv_thumb
                q.e(view2, "null cannot be cast to non-null type android.widget.ImageView");
                this.thumbnailIv = (ImageView)view2;
                View view3 = view1.findViewById(0x7F0A069E);  // id:iv_thumb_default
                q.e(view3, "null cannot be cast to non-null type android.widget.ImageView");
                this.defaultThumbnailIv = (ImageView)view3;
                View view4 = view0.findViewById(0x7F0A063B);  // id:iv_list_19
                q.e(view4, "null cannot be cast to non-null type android.widget.ImageView");
                this.list19Iv = (ImageView)view4;
                View view5 = view0.findViewById(0x7F0A0D34);  // id:tv_title
                q.e(view5, "null cannot be cast to non-null type android.widget.TextView");
                this.titleTv = (TextView)view5;
                View view6 = view0.findViewById(0x7F0A0C12);  // id:tv_artist
                q.e(view6, "null cannot be cast to non-null type android.widget.TextView");
                this.artistTv = (TextView)view6;
                View view7 = view0.findViewById(0x7F0A0C5A);  // id:tv_datetime
                q.e(view7, "null cannot be cast to non-null type android.widget.TextView");
                this.datetimeTv = (TextView)view7;
                View view8 = view0.findViewById(0x7F0A0610);  // id:iv_check
                q.e(view8, "null cannot be cast to non-null type android.widget.ImageView");
                this.checkIv = (ImageView)view8;
                ViewUtils.setDefaultImage(((ImageView)view3), settingBannedContentsFragment$BannedContentsAdapter0.getContext().getResources().getDimensionPixelSize(0x7F07045E));  // dimen:thumb_width_song
            }

            @NotNull
            public final TextView getArtistTv() {
                return this.artistTv;
            }

            @NotNull
            public final ImageView getCheckIv() {
                return this.checkIv;
            }

            @NotNull
            public final TextView getDatetimeTv() {
                return this.datetimeTv;
            }

            @NotNull
            public final ImageView getDefaultThumbnailIv() {
                return this.defaultThumbnailIv;
            }

            @NotNull
            public final ImageView getList19Iv() {
                return this.list19Iv;
            }

            @NotNull
            public final View getThumbContainer() {
                return this.thumbContainer;
            }

            @NotNull
            public final ImageView getThumbnailIv() {
                return this.thumbnailIv;
            }

            @NotNull
            public final TextView getTitleTv() {
                return this.titleTv;
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0017\u0010\u000B\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000B\u0010\b\u001A\u0004\b\f\u0010\nR\u0017\u0010\u000E\u001A\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000E\u0010\u000F\u001A\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0012\u0010\b\u001A\u0004\b\u0013\u0010\nR$\u0010\u0015\u001A\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001A¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingBannedContentsFragment$BannedContentsAdapter$CountHeaderView;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/settings/SettingBannedContentsFragment$BannedContentsAdapter;Landroid/view/View;)V", "Landroid/widget/TextView;", "tvTitle", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "tvCount", "getTvCount", "Landroid/widget/LinearLayout;", "layoutUpdateDate", "Landroid/widget/LinearLayout;", "getLayoutUpdateDate", "()Landroid/widget/LinearLayout;", "tvUpdateDate", "getTvUpdateDate", "Lkotlinx/coroutines/Job;", "asyncDataUpdateJob", "Lkotlinx/coroutines/Job;", "getAsyncDataUpdateJob", "()Lkotlinx/coroutines/Job;", "setAsyncDataUpdateJob", "(Lkotlinx/coroutines/Job;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class CountHeaderView extends O0 {
            @Nullable
            private Job asyncDataUpdateJob;
            @NotNull
            private final LinearLayout layoutUpdateDate;
            @NotNull
            private final TextView tvCount;
            @NotNull
            private final TextView tvTitle;
            @NotNull
            private final TextView tvUpdateDate;

            public CountHeaderView(@NotNull View view0) {
                q.g(view0, "view");
                BannedContentsAdapter.this = settingBannedContentsFragment$BannedContentsAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0D34);  // id:tv_title
                q.f(view1, "findViewById(...)");
                this.tvTitle = (TextView)view1;
                View view2 = view0.findViewById(0x7F0A0C50);  // id:tv_count
                q.f(view2, "findViewById(...)");
                this.tvCount = (TextView)view2;
                View view3 = view0.findViewById(0x7F0A0753);  // id:layout_update_date
                q.f(view3, "findViewById(...)");
                this.layoutUpdateDate = (LinearLayout)view3;
                View view4 = view0.findViewById(0x7F0A0D4C);  // id:tv_update_date
                q.f(view4, "findViewById(...)");
                this.tvUpdateDate = (TextView)view4;
            }

            @Nullable
            public final Job getAsyncDataUpdateJob() {
                return this.asyncDataUpdateJob;
            }

            @NotNull
            public final LinearLayout getLayoutUpdateDate() {
                return this.layoutUpdateDate;
            }

            @NotNull
            public final TextView getTvCount() {
                return this.tvCount;
            }

            @NotNull
            public final TextView getTvTitle() {
                return this.tvTitle;
            }

            @NotNull
            public final TextView getTvUpdateDate() {
                return this.tvUpdateDate;
            }

            public final void setAsyncDataUpdateJob(@Nullable Job job0) {
                this.asyncDataUpdateJob = job0;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0017\u0010\u000B\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000ER$\u0010\u0010\u001A\u0004\u0018\u00010\u000F8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingBannedContentsFragment$BannedContentsAdapter$GnrMenuView;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/settings/SettingBannedContentsFragment$BannedContentsAdapter;Landroid/view/View;)V", "Landroid/widget/TextView;", "tvTitle", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "btnCheck", "Landroid/view/View;", "getBtnCheck", "()Landroid/view/View;", "Lkotlinx/coroutines/Job;", "asyncDataUpdateJob", "Lkotlinx/coroutines/Job;", "getAsyncDataUpdateJob", "()Lkotlinx/coroutines/Job;", "setAsyncDataUpdateJob", "(Lkotlinx/coroutines/Job;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class GnrMenuView extends O0 {
            @Nullable
            private Job asyncDataUpdateJob;
            @NotNull
            private final View btnCheck;
            @NotNull
            private final TextView tvTitle;

            public GnrMenuView(@NotNull View view0) {
                q.g(view0, "view");
                BannedContentsAdapter.this = settingBannedContentsFragment$BannedContentsAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0C86);  // id:tv_genre_name
                q.f(view1, "findViewById(...)");
                this.tvTitle = (TextView)view1;
                View view2 = view0.findViewById(0x7F0A0709);  // id:layout_check_state
                q.f(view2, "findViewById(...)");
                this.btnCheck = view2;
                ViewUtils.hideWhen(view2, true);
            }

            @Nullable
            public final Job getAsyncDataUpdateJob() {
                return this.asyncDataUpdateJob;
            }

            @NotNull
            public final View getBtnCheck() {
                return this.btnCheck;
            }

            @NotNull
            public final TextView getTvTitle() {
                return this.tvTitle;
            }

            public final void setAsyncDataUpdateJob(@Nullable Job job0) {
                this.asyncDataUpdateJob = job0;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingBannedContentsFragment$BannedContentsAdapter$GnrTitleView;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/settings/SettingBannedContentsFragment$BannedContentsAdapter;Landroid/view/View;)V", "Landroid/widget/TextView;", "tvTitle", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class GnrTitleView extends O0 {
            @NotNull
            private final TextView tvTitle;

            public GnrTitleView(@NotNull View view0) {
                q.g(view0, "view");
                BannedContentsAdapter.this = settingBannedContentsFragment$BannedContentsAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0D34);  // id:tv_title
                q.f(view1, "findViewById(...)");
                this.tvTitle = (TextView)view1;
            }

            @NotNull
            public final TextView getTvTitle() {
                return this.tvTitle;
            }
        }

        public BannedContentsAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
            this.setEmptyViewResId(0x7F0D0022);  // layout:adapter_empty_view
            e e0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
            e0.d = -1;
            e0.e = -1;
            e0.g = -1;
            e0.i = -1;
            e0.k = -1;
            e0.l = -1;
            e0.f = settingBannedContentsFragment0.getString((settingBannedContentsFragment0.currentSortIndex == 1 ? 0x7F130960 : 0x7F130969));  // string:setting_banned_contents_artist_empty_message "추가된 아티스트가 없습니다."
            this.setEmptyViewInfo(e0);
        }

        private final void deleteBannedArtist(ExcludedArtistEntity excludedArtistEntity0) {
            D d0 = SettingBannedContentsFragment.this.getViewLifecycleOwner();
            q.f(d0, "getViewLifecycleOwner(...)");
            BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(excludedArtistEntity0, null) {
                final ExcludedArtistEntity $item;
                int label;

                {
                    SettingBannedContentsFragment.this = settingBannedContentsFragment0;
                    this.$item = excludedArtistEntity0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.fragments.settings.SettingBannedContentsFragment.BannedContentsAdapter.deleteBannedArtist.1(SettingBannedContentsFragment.this, this.$item, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.fragments.settings.SettingBannedContentsFragment.BannedContentsAdapter.deleteBannedArtist.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    a a0 = a.a;
                    switch(this.label) {
                        case 0: {
                            d5.n.D(object0);
                            LogU.Companion.d("SettingBannedContentsFragment", "deleteBannedArtist()");
                            ((b)SettingBannedContentsFragment.this.blockingProgressDialogManage).a("SettingBannedContentsFragment", true);
                            this.label = 1;
                            object0 = F.q(1002, this.$item.b, this.$item.e, this);
                            if(object0 == a0) {
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
                    boolean z = SettingBannedContentsFragment.this.isFragmentValid();
                    H h0 = H.a;
                    if(!z) {
                        return h0;
                    }
                    ((b)SettingBannedContentsFragment.this.blockingProgressDialogManage).a("SettingBannedContentsFragment", false);
                    if(((k)object0) instanceof j) {
                        ToastManager.show(0x7F13095F);  // string:setting_banned_contents_artist_delete_success "1명의 아티스트를 추천(재생) 콘텐츠에 다시 추가합니다."
                        SettingBannedContentsFragment.this.startFetch("refresh page");
                        return h0;
                    }
                    if(!(((k)object0) instanceof i)) {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                    ToastManager.show(((i)(((k)object0))).a);
                    return h0;
                }
            }, 3, null);
        }

        private final void deleteBannedGenre(GenreInfo settingBannedContentsFragment$GenreInfo0) {
            D d0 = SettingBannedContentsFragment.this.getViewLifecycleOwner();
            q.f(d0, "getViewLifecycleOwner(...)");
            BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(SettingBannedContentsFragment.this, this, null) {
                final GenreInfo $item;
                int label;

                {
                    this.$item = settingBannedContentsFragment$GenreInfo0;
                    SettingBannedContentsFragment.this = settingBannedContentsFragment0;
                    BannedContentsAdapter.this = settingBannedContentsFragment$BannedContentsAdapter0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.fragments.settings.SettingBannedContentsFragment.BannedContentsAdapter.deleteBannedGenre.1(this.$item, SettingBannedContentsFragment.this, BannedContentsAdapter.this, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.fragments.settings.SettingBannedContentsFragment.BannedContentsAdapter.deleteBannedGenre.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    a a0 = a.a;
                    switch(this.label) {
                        case 0: {
                            d5.n.D(object0);
                            LogU.Companion.d("SettingBannedContentsFragment", o.o("deleteBannedGenre() ", this.$item.getGenreName(), " : ", this.$item.getCode()));
                            ((b)SettingBannedContentsFragment.this.blockingProgressDialogManage).a("SettingBannedContentsFragment", true);
                            this.label = 1;
                            object0 = F.r(1002, this.$item.getCode(), this);
                            if(object0 == a0) {
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
                    if(((k)object0) instanceof i) {
                        LogU.Companion.d("SettingBannedContentsFragment", "deleteBannedGenre#onFinishUpdateData() error: " + ((k)object0) + ".error");
                    }
                    boolean z = SettingBannedContentsFragment.this.isFragmentValid();
                    H h0 = H.a;
                    if(!z) {
                        return h0;
                    }
                    ((b)SettingBannedContentsFragment.this.blockingProgressDialogManage).a("SettingBannedContentsFragment", false);
                    BannedContentsAdapter.this.notifyDataSetChanged();
                    return h0;
                }
            }, 3, null);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return SettingBannedContentsFragment.this.currentSortIndex != 0 || this.getCount() <= 0 ? 0 : 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            switch(SettingBannedContentsFragment.this.currentSortIndex) {
                case 0: {
                    return this.getHeaderViewItemCount() <= 0 || v != this.getAvailableHeaderPosition() ? 2 : 1;
                }
                case 1: {
                    return this.getItem(v1) instanceof String ? 11 : 12;
                }
                case 2: {
                    Object object0 = this.getItem(v1);
                    GenreInfo settingBannedContentsFragment$GenreInfo0 = object0 instanceof GenreInfo ? ((GenreInfo)object0) : null;
                    return settingBannedContentsFragment$GenreInfo0 == null || !settingBannedContentsFragment$GenreInfo0.isGroupTitle() ? 22 : 21;
                }
                default: {
                    return 0;
                }
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(@Nullable String s, @Nullable v9.i i0, @Nullable HttpResponse httpResponse0) {
            int v1;
            if(httpResponse0 instanceof BanListBannedSongRes) {
                if(((BanListBannedSongRes)httpResponse0).response != null) {
                    this.setMenuId(((BanListBannedSongRes)httpResponse0).getMenuId());
                    this.updateModifiedTime(this.getCacheKey());
                    this.setHasMore(((BanListBannedSongRes)httpResponse0).hasMore());
                    Collection collection0 = ((BanListBannedSongRes)httpResponse0).getItems();
                    if(collection0 != null) {
                        SettingBannedContentsFragment.this.showToolbar(!collection0.isEmpty());
                        for(Object object0: collection0) {
                            ((LISTSONG)object0).canService = true;
                            this.add(((LISTSONG)object0));
                        }
                    }
                }
                return true;
            }
            if(httpResponse0 instanceof SettingGnrMenuRes) {
                ArrayList arrayList0 = new ArrayList();
                Iterator iterator1 = ((SettingGnrMenuRes)httpResponse0).getItems().iterator();
                int v;
                for(v = -1; true; v = v3) {
                    v1 = 2;
                    if(!iterator1.hasNext()) {
                        break;
                    }
                    Object object1 = iterator1.next();
                    String s1 = ((GNRMENULIST)object1).menuName;
                    q.f(s1, "menuName");
                    String s2 = ((GNRMENULIST)object1).gnrMenuSeq;
                    q.f(s2, "gnrMenuSeq");
                    arrayList0.add(new GenreInfo(SettingBannedContentsFragment.this, true, s1, s2, -1));
                    Iterator iterator2 = ((GNRMENULIST)object1).gnrList.iterator();
                    q.f(iterator2, "iterator(...)");
                    int v2 = 0;
                    while(true) {
                        int v3 = v2;
                        if(!iterator2.hasNext()) {
                            break;
                        }
                        Object object2 = iterator2.next();
                        String s3 = ((GNRLIST)object2).gnrName;
                        q.f(s3, "gnrName");
                        String s4 = ((GNRLIST)object2).gnrCode;
                        q.f(s4, "gnrCode");
                        v2 = v3 + 1;
                        arrayList0.add(new GenreInfo(SettingBannedContentsFragment.this, false, s3, s4, v3));
                    }
                }
                if(v > 0) {
                    if(v % 2 != 0) {
                        v1 = v % 2;
                    }
                    if(1 <= v1) {
                        for(int v4 = 1; true; ++v4) {
                            ((GenreInfo)com.iloen.melon.utils.a.i(v4, arrayList0)).setLastRow(true);
                            if(v4 == v1) {
                                break;
                            }
                        }
                    }
                }
                this.addAll(arrayList0);
                return true;
            }
            return super.handleResponse(s, i0, httpResponse0);
        }

        private final void insertBannedGenre(GenreInfo settingBannedContentsFragment$GenreInfo0) {
            D d0 = SettingBannedContentsFragment.this.getViewLifecycleOwner();
            q.f(d0, "getViewLifecycleOwner(...)");
            BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(SettingBannedContentsFragment.this, this, null) {
                final GenreInfo $item;
                int label;

                {
                    this.$item = settingBannedContentsFragment$GenreInfo0;
                    SettingBannedContentsFragment.this = settingBannedContentsFragment0;
                    BannedContentsAdapter.this = settingBannedContentsFragment$BannedContentsAdapter0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.fragments.settings.SettingBannedContentsFragment.BannedContentsAdapter.insertBannedGenre.1(this.$item, SettingBannedContentsFragment.this, BannedContentsAdapter.this, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.fragments.settings.SettingBannedContentsFragment.BannedContentsAdapter.insertBannedGenre.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    a a0 = a.a;
                    H h0 = H.a;
                    switch(this.label) {
                        case 0: {
                            d5.n.D(object0);
                            LogU.Companion.d("SettingBannedContentsFragment", o.o("insertBannedGenre() ", this.$item.getGenreName(), " : ", this.$item.getCode()));
                            this.label = 1;
                            object0 = F.a.h(this);
                            if(object0 == a0) {
                                return a0;
                            }
                            goto label_11;
                        }
                        case 1: {
                            d5.n.D(object0);
                        label_11:
                            if(((Number)object0).intValue() >= 3) {
                                ToastManager.show(0x7F130968);  // string:setting_banned_contents_genre_limit "최대 3개까지 가능합니다. 선택한 장르 취소 후 다시 시도해주세요."
                                return h0;
                            }
                            ((b)SettingBannedContentsFragment.this.blockingProgressDialogManage).a("SettingBannedContentsFragment", true);
                            this.label = 2;
                            object0 = F.r(1001, this.$item.getCode(), this);
                            if(object0 == a0) {
                                return a0;
                            }
                            goto label_20;
                        }
                        case 2: {
                            break;
                        }
                        default: {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                    }
                    d5.n.D(object0);
                label_20:
                    if(((k)object0) instanceof i) {
                        LogU.Companion.d("SettingBannedContentsFragment", "insertBannedGenre#onFinishUpdateData() error: " + ((k)object0) + ".error");
                    }
                    if(!SettingBannedContentsFragment.this.isFragmentValid()) {
                        return h0;
                    }
                    ((b)SettingBannedContentsFragment.this.blockingProgressDialogManage).a("SettingBannedContentsFragment", false);
                    BannedContentsAdapter.this.notifyDataSetChanged();
                    return h0;
                }
            }, 3, null);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            String s;
            BanListBannedSongRes banListBannedSongRes0 = null;
            if(o00 instanceof CountHeaderView) {
                if(((CountHeaderView)o00).getItemViewType() == 1) {
                    ((CountHeaderView)o00).getTvTitle().setText(SettingBannedContentsFragment.this.getString(0x7F13096A));  // string:setting_banned_contents_song_header_title "제외 곡"
                    TextView textView0 = ((CountHeaderView)o00).getTvCount();
                    HttpResponse httpResponse0 = this.getResponse();
                    if(httpResponse0 instanceof BanListBannedSongRes) {
                        banListBannedSongRes0 = (BanListBannedSongRes)httpResponse0;
                    }
                    if(banListBannedSongRes0 == null) {
                        s = String.valueOf(this.getCount());
                    }
                    else {
                        RESPONSE banListBannedSongRes$RESPONSE0 = banListBannedSongRes0.response;
                        if(banListBannedSongRes$RESPONSE0 == null) {
                            s = String.valueOf(this.getCount());
                        }
                        else {
                            s = banListBannedSongRes$RESPONSE0.totalCount;
                            if(s == null) {
                                s = String.valueOf(this.getCount());
                            }
                        }
                    }
                    textView0.setText(s);
                    ((CountHeaderView)o00).getLayoutUpdateDate().setVisibility(8);
                    return;
                }
                ((CountHeaderView)o00).getTvTitle().setText(SettingBannedContentsFragment.this.getString(0x7F130961));  // string:setting_banned_contents_artist_header_title "제외 아티스트"
                Job job0 = ((CountHeaderView)o00).getAsyncDataUpdateJob();
                if(job0 != null) {
                    DefaultImpls.cancel$default(job0, null, 1, null);
                }
                D d0 = SettingBannedContentsFragment.this.getViewLifecycleOwner();
                q.f(d0, "getViewLifecycleOwner(...)");
                ((CountHeaderView)o00).setAsyncDataUpdateJob(BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(null) {
                    final O0 $vh;
                    int label;

                    {
                        this.$vh = o00;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.fragments.settings.SettingBannedContentsFragment.BannedContentsAdapter.onBindViewImpl.1(this.$vh, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.fragments.settings.SettingBannedContentsFragment.BannedContentsAdapter.onBindViewImpl.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        a a0 = a.a;
                        switch(this.label) {
                            case 0: {
                                d5.n.D(object0);
                                this.label = 1;
                                object0 = F.a.f(this);
                                if(object0 == a0) {
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
                        ((CountHeaderView)this.$vh).getTvCount().setText(String.valueOf(((Number)object0).intValue()));
                        return H.a;
                    }
                }, 3, null));
                ((CountHeaderView)o00).getLayoutUpdateDate().setVisibility(0);
                Object object0 = this.getItem(v1);
                if(object0 instanceof String) {
                    banListBannedSongRes0 = (String)object0;
                }
                if(banListBannedSongRes0 != null) {
                    ((CountHeaderView)o00).getTvUpdateDate().setText(this.parseFromServerDate(((String)banListBannedSongRes0)));
                }
                ((CountHeaderView)o00).getLayoutUpdateDate().setOnClickListener(new l(SettingBannedContentsFragment.this, 0));
                return;
            }
            if(o00 instanceof BannedSongHolder) {
                Object object1 = this.getItem(v1);
                if(object1 instanceof LISTSONG) {
                    banListBannedSongRes0 = (LISTSONG)object1;
                }
                if(banListBannedSongRes0 != null) {
                    SettingBannedContentsFragment settingBannedContentsFragment0 = SettingBannedContentsFragment.this;
                    Glide.with(((BannedSongHolder)o00).getThumbnailIv().getContext()).load(banListBannedSongRes0.albumImg).into(((BannedSongHolder)o00).getThumbnailIv());
                    ((BannedSongHolder)o00).getTitleTv().setText(banListBannedSongRes0.songName);
                    ((BannedSongHolder)o00).getArtistTv().setText(ProtocolUtils.getArtistNames(banListBannedSongRes0.artistList));
                    ((BannedSongHolder)o00).getDatetimeTv().setText(banListBannedSongRes0.exceptDate);
                    ViewUtils.showWhen(((BannedSongHolder)o00).getList19Iv(), banListBannedSongRes0.isAdult);
                    if(this.isMarked(v1)) {
                        int v2 = ColorUtils.getColor(this.getContext(), 0x7F060199);  // color:list_item_marked
                        ((BannedSongHolder)o00).itemView.setBackgroundColor(v2);
                        ((BannedSongHolder)o00).getCheckIv().setImageResource(0x7F080122);  // drawable:btn_common_check_01_s
                    }
                    else {
                        int v3 = ColorUtils.getColor(this.getContext(), 0x7F06048A);  // color:transparent
                        ((BannedSongHolder)o00).itemView.setBackgroundColor(v3);
                        ((BannedSongHolder)o00).getCheckIv().setImageResource(0x7F080120);  // drawable:btn_common_check_01_n
                    }
                    m m0 = new m(settingBannedContentsFragment0, v);
                    ViewUtils.setOnClickListener(((BannedSongHolder)o00).itemView, m0);
                }
            }
            else if(o00 instanceof ExcludedArtistHolder) {
                Object object2 = this.getItem(v1);
                if(object2 instanceof ExcludedArtistEntity) {
                    banListBannedSongRes0 = (ExcludedArtistEntity)object2;
                }
                if(banListBannedSongRes0 != null) {
                    Glide.with(this.getContext()).load(banListBannedSongRes0.d).apply(RequestOptions.circleCropTransform()).into(((ExcludedArtistHolder)o00).thumbIv);
                    TextView textView1 = ((ExcludedArtistHolder)o00).artistNameTv;
                    if(textView1 != null) {
                        textView1.setText(banListBannedSongRes0.c);
                    }
                    TextView textView2 = ((ExcludedArtistHolder)o00).artistNewsTv;
                    if(textView2 != null) {
                        textView2.setText(banListBannedSongRes0.g);
                    }
                    ViewUtils.hideWhen(((ExcludedArtistHolder)o00).friendshipLayout, true);
                    TextView textView3 = ((ExcludedArtistHolder)o00).a;
                    if(textView3 != null) {
                        ViewUtils.showWhen(textView3, true);
                        textView3.setText(0x7F13095E);  // string:setting_banned_contents_artist_delete "삭제"
                        ViewUtils.setOnClickListener(textView3, new com.iloen.melon.fragments.settings.n(textView3, this, v1, ((ExcludedArtistEntity)banListBannedSongRes0)));
                    }
                }
            }
            else if(o00 instanceof GnrTitleView) {
                Object object3 = this.getItem(v1);
                if(object3 instanceof GenreInfo) {
                    banListBannedSongRes0 = (GenreInfo)object3;
                }
                if(banListBannedSongRes0 != null) {
                    ((GnrTitleView)o00).getTvTitle().setText(((GenreInfo)banListBannedSongRes0).getGenreName());
                }
            }
            else if(o00 instanceof GnrMenuView) {
                Object object4 = this.getItem(v1);
                GenreInfo settingBannedContentsFragment$GenreInfo0 = object4 instanceof GenreInfo ? ((GenreInfo)object4) : null;
                if(settingBannedContentsFragment$GenreInfo0 != null) {
                    SettingBannedContentsFragment settingBannedContentsFragment1 = SettingBannedContentsFragment.this;
                    ((GnrMenuView)o00).getTvTitle().setText(settingBannedContentsFragment$GenreInfo0.getGenreName());
                    Job job1 = ((GnrMenuView)o00).getAsyncDataUpdateJob();
                    if(job1 != null) {
                        DefaultImpls.cancel$default(job1, null, 1, null);
                    }
                    D d1 = settingBannedContentsFragment1.getViewLifecycleOwner();
                    q.f(d1, "getViewLifecycleOwner(...)");
                    ((GnrMenuView)o00).setAsyncDataUpdateJob(BuildersKt__Builders_commonKt.launch$default(f0.f(d1), null, null, new n(((GnrMenuView)o00), this, null) {
                        final GenreInfo $item;
                        final GnrMenuView $this_apply;
                        int label;

                        {
                            this.$item = settingBannedContentsFragment$GenreInfo0;
                            this.$this_apply = settingBannedContentsFragment$BannedContentsAdapter$GnrMenuView0;
                            BannedContentsAdapter.this = settingBannedContentsFragment$BannedContentsAdapter0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.fragments.settings.SettingBannedContentsFragment.BannedContentsAdapter.onBindViewImpl.7.1.1(this.$item, this.$this_apply, BannedContentsAdapter.this, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.fragments.settings.SettingBannedContentsFragment.BannedContentsAdapter.onBindViewImpl.7.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            a a0 = a.a;
                            switch(this.label) {
                                case 0: {
                                    d5.n.D(object0);
                                    this.label = 1;
                                    object0 = F.a.c(this.$item.getCode(), this);
                                    if(object0 == a0) {
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
                            boolean z = ((Boolean)object0).booleanValue();
                            this.$this_apply.getTvTitle().setSelected(z);
                            ViewUtils.showWhen(this.$this_apply.getBtnCheck(), z);
                            com.iloen.melon.fragments.settings.o o0 = new com.iloen.melon.fragments.settings.o(z, BannedContentsAdapter.this, this.$item);
                            ViewUtils.setOnClickListener(this.$this_apply.itemView, o0);
                            return H.a;
                        }

                        private static final void invokeSuspend$lambda$0(boolean z, BannedContentsAdapter settingBannedContentsFragment$BannedContentsAdapter0, GenreInfo settingBannedContentsFragment$GenreInfo0, View view0) {
                            if(z) {
                                settingBannedContentsFragment$BannedContentsAdapter0.deleteBannedGenre(settingBannedContentsFragment$GenreInfo0);
                                return;
                            }
                            settingBannedContentsFragment$BannedContentsAdapter0.insertBannedGenre(settingBannedContentsFragment$GenreInfo0);
                        }
                    }, 3, null));
                }
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
            @oe.e(c = "com.iloen.melon.fragments.settings.SettingBannedContentsFragment$BannedContentsAdapter$onBindViewImpl$3$1", f = "SettingBannedContentsFragment.kt", l = {690}, m = "invokeSuspend")
            final class com.iloen.melon.fragments.settings.SettingBannedContentsFragment.BannedContentsAdapter.onBindViewImpl.3.1 extends oe.i implements n {
                int label;

                public com.iloen.melon.fragments.settings.SettingBannedContentsFragment.BannedContentsAdapter.onBindViewImpl.3.1(SettingBannedContentsFragment settingBannedContentsFragment0, Continuation continuation0) {
                    SettingBannedContentsFragment.this = settingBannedContentsFragment0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.fragments.settings.SettingBannedContentsFragment.BannedContentsAdapter.onBindViewImpl.3.1(SettingBannedContentsFragment.this, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.fragments.settings.SettingBannedContentsFragment.BannedContentsAdapter.onBindViewImpl.3.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    a a0 = a.a;
                    switch(this.label) {
                        case 0: {
                            d5.n.D(object0);
                            ((b)SettingBannedContentsFragment.this.blockingProgressDialogManage).a("SettingBannedContentsFragment", true);
                            this.label = 1;
                            if(F.a.e(1000, "updateClick", this) == a0) {
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
                    ((b)SettingBannedContentsFragment.this.blockingProgressDialogManage).a("SettingBannedContentsFragment", false);
                    SettingBannedContentsFragment.this.startFetch("refresh page");
                    return H.a;
                }
            }

        }

        private static final void onBindViewImpl$lambda$10$lambda$9$lambda$8$lambda$7(TextView textView0, BannedContentsAdapter settingBannedContentsFragment$BannedContentsAdapter0, int v, ExcludedArtistEntity excludedArtistEntity0, View view0) {
            ViewUtils.hideWhen(textView0, true);
            settingBannedContentsFragment$BannedContentsAdapter0.notifyItemChanged(v);
            settingBannedContentsFragment$BannedContentsAdapter0.deleteBannedArtist(excludedArtistEntity0);
        }

        private static final void onBindViewImpl$lambda$3(SettingBannedContentsFragment settingBannedContentsFragment0, View view0) {
            D d0 = settingBannedContentsFragment0.getViewLifecycleOwner();
            q.f(d0, "getViewLifecycleOwner(...)");
            BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new com.iloen.melon.fragments.settings.SettingBannedContentsFragment.BannedContentsAdapter.onBindViewImpl.3.1(settingBannedContentsFragment0, null), 3, null);
        }

        private static final void onBindViewImpl$lambda$6$lambda$5$lambda$4(SettingBannedContentsFragment settingBannedContentsFragment0, int v, View view0) {
            settingBannedContentsFragment0.onItemClick(view0, v);
        }

        @Override  // com.iloen.melon.adapters.common.p
        @Nullable
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            switch(v) {
                case 1: {
                    View view4 = LayoutInflater.from(this.getContext()).inflate(0x7F0D046A, viewGroup0, false);  // layout:listitem_banned_contents_header
                    q.f(view4, "inflate(...)");
                    return new CountHeaderView(this, view4);
                }
                case 2: {
                    View view3 = LayoutInflater.from(this.getContext()).inflate(0x7F0D046B, viewGroup0, false);  // layout:listitem_banned_song
                    q.f(view3, "inflate(...)");
                    return new BannedSongHolder(this, view3);
                }
                case 11: {
                    View view2 = LayoutInflater.from(this.getContext()).inflate(0x7F0D046A, viewGroup0, false);  // layout:listitem_banned_contents_header
                    q.f(view2, "inflate(...)");
                    return new CountHeaderView(this, view2);
                }
                case 12: {
                    return new ExcludedArtistHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D0456, viewGroup0, false));  // layout:listitem_artist
                }
                case 21: {
                    View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0826, viewGroup0, false);  // layout:setting_banned_genre_title
                    q.f(view1, "inflate(...)");
                    return new GnrTitleView(this, view1);
                }
                case 22: {
                    View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0825, viewGroup0, false);  // layout:setting_banned_genre_item
                    q.f(view0, "inflate(...)");
                    return new GnrMenuView(this, view0);
                }
                default: {
                    return null;
                }
            }
        }

        @SuppressLint({"SimpleDateFormat"})
        private final String parseFromServerDate(String s) {
            if(s.length() == 0) {
                return "";
            }
            Date date0 = new SimpleDateFormat("yyyyMMddHHmmss").parse(s);
            if(date0 != null) {
                String s1 = new SimpleDateFormat("yyyy.MM.dd HH:mm").format(date0);
                q.f(s1, "format(...)");
                return s1;
            }
            return "";
        }

        @Override  // com.iloen.melon.adapters.common.j
        public void setMarked(int v, boolean z) {
            if(z && this.getMarkedCount() >= 20) {
                l0 l00 = SettingBannedContentsFragment.this.getChildFragmentManager();
                String s = SettingBannedContentsFragment.this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                String s1 = SettingBannedContentsFragment.this.getString(0x7F1300B8, new Object[]{20});  // string:alert_dlg_body_recommend_ban_overcount "다시 추천 받기는 한번에 최대 %1$d곡까지 가능합니다."
                com.melon.ui.popup.b.d(com.melon.ui.popup.b.a, l00, s, s1, false, false, false, null, null, null, null, null, 2040);
                return;
            }
            super.setMarked(v, z);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0017\u001A\u00020\u0018H\u0007J\u0010\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\tH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingBannedContentsFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_SORT_INDEX", "ARG_FILTER_INDEX", "SORT_TYPE_SONG", "", "SORT_TYPE_ARTIST", "SORT_TYPE_GENRE", "FILTER_NEW", "FILTER_ALPHABET", "FILTER_ARTIST", "VIEW_TYPE_SONG_HEADER", "VIEW_TYPE_SONG_LIST", "VIEW_TYPE_ARTIST_HEADER", "VIEW_TYPE_ARTIST_LIST", "VIEW_TYPE_GNR_TITLE", "VIEW_TYPE_GNR_MENU", "SPAN_SIZE_1", "SPAN_SIZE_2", "newInstance", "Lcom/iloen/melon/fragments/settings/SettingBannedContentsFragment;", "sort", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SettingBannedContentsFragment newInstance() {
            return new SettingBannedContentsFragment();
        }

        @NotNull
        public final SettingBannedContentsFragment newInstance(int v) {
            SettingBannedContentsFragment settingBannedContentsFragment0 = new SettingBannedContentsFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putInt("argSortIndex", v);
            settingBannedContentsFragment0.setArguments(bundle0);
            return settingBannedContentsFragment0;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0082\u0004\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\rR\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u001A\u0010\u0011\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u000B\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingBannedContentsFragment$GenreInfo;", "", "isGroupTitle", "", "genreName", "", "code", "subColumn", "", "<init>", "(Lcom/iloen/melon/fragments/settings/SettingBannedContentsFragment;ZLjava/lang/String;Ljava/lang/String;I)V", "()Z", "getGenreName", "()Ljava/lang/String;", "getCode", "getSubColumn", "()I", "isLastRow", "setLastRow", "(Z)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class GenreInfo {
        @NotNull
        private final String code;
        @NotNull
        private final String genreName;
        private final boolean isGroupTitle;
        private boolean isLastRow;
        private final int subColumn;

        public GenreInfo(boolean z, @NotNull String s, @NotNull String s1, int v) {
            q.g(s, "genreName");
            q.g(s1, "code");
            SettingBannedContentsFragment.this = settingBannedContentsFragment0;
            super();
            this.isGroupTitle = z;
            this.genreName = s;
            this.code = s1;
            this.subColumn = v;
        }

        @NotNull
        public final String getCode() {
            return this.code;
        }

        @NotNull
        public final String getGenreName() {
            return this.genreName;
        }

        public final int getSubColumn() {
            return this.subColumn;
        }

        public final boolean isGroupTitle() {
            return this.isGroupTitle;
        }

        public final boolean isLastRow() {
            return this.isLastRow;
        }

        public final void setLastRow(boolean z) {
            this.isLastRow = z;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\r\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000ER\u001B\u0010\u0014\u001A\u00020\u000F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013R\u001B\u0010\u0017\u001A\u00020\u000F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001A\u0004\b\u0016\u0010\u0013R\u001B\u0010\u001A\u001A\u00020\u000F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001A\u0004\b\u0019\u0010\u0013¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingBannedContentsFragment$GenreItemDecoration;", "Landroidx/recyclerview/widget/r0;", "<init>", "(Lcom/iloen/melon/fragments/settings/SettingBannedContentsFragment;)V", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/K0;", "state", "Lie/H;", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/K0;)V", "", "spacingPixel$delegate", "Lie/j;", "getSpacingPixel", "()I", "spacingPixel", "lastBottomSpacingPixel$delegate", "getLastBottomSpacingPixel", "lastBottomSpacingPixel", "leftRightEdgeMarginPixel$delegate", "getLeftRightEdgeMarginPixel", "leftRightEdgeMarginPixel", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class GenreItemDecoration extends r0 {
        @NotNull
        private final ie.j lastBottomSpacingPixel$delegate;
        @NotNull
        private final ie.j leftRightEdgeMarginPixel$delegate;
        @NotNull
        private final ie.j spacingPixel$delegate;

        public GenreItemDecoration() {
            this.spacingPixel$delegate = g.Q(new com.iloen.melon.fragments.settings.p(settingBannedContentsFragment0, 0));
            this.lastBottomSpacingPixel$delegate = g.Q(new com.iloen.melon.fragments.settings.p(settingBannedContentsFragment0, 1));
            this.leftRightEdgeMarginPixel$delegate = g.Q(new com.iloen.melon.fragments.settings.p(settingBannedContentsFragment0, 2));
        }

        @Override  // androidx.recyclerview.widget.r0
        public void getItemOffsets(@NotNull Rect rect0, @NotNull View view0, @NotNull RecyclerView recyclerView0, @NotNull K0 k00) {
            q.g(rect0, "outRect");
            q.g(view0, "view");
            q.g(recyclerView0, "parent");
            q.g(k00, "state");
            int v = recyclerView0.getChildAdapterPosition(view0);
            int v1 = SettingBannedContentsFragment.this.getAdapter().getItemViewType(v);
            j0 j00 = SettingBannedContentsFragment.this.getAdapter();
            GenreInfo settingBannedContentsFragment$GenreInfo0 = null;
            BannedContentsAdapter settingBannedContentsFragment$BannedContentsAdapter0 = j00 instanceof BannedContentsAdapter ? ((BannedContentsAdapter)j00) : null;
            Object object0 = settingBannedContentsFragment$BannedContentsAdapter0 == null ? null : settingBannedContentsFragment$BannedContentsAdapter0.getItem(v);
            if(object0 instanceof GenreInfo) {
                settingBannedContentsFragment$GenreInfo0 = (GenreInfo)object0;
            }
            switch(v1) {
                case 21: {
                    rect0.top = v == 0 ? 0 : ScreenUtils.dipToPixel(SettingBannedContentsFragment.this.getContext(), 15.0f);
                    return;
                }
                case 22: {
                    rect0.top = this.getSpacingPixel();
                    rect0.bottom = settingBannedContentsFragment$GenreInfo0 == null || !settingBannedContentsFragment$GenreInfo0.isLastRow() ? this.getSpacingPixel() : this.getLastBottomSpacingPixel();
                    switch((settingBannedContentsFragment$GenreInfo0 == null ? -1 : settingBannedContentsFragment$GenreInfo0.getSubColumn()) % 2) {
                        case 0: {
                            rect0.left = this.getLeftRightEdgeMarginPixel();
                            rect0.right = this.getSpacingPixel();
                            return;
                        }
                        case 1: {
                            rect0.left = this.getSpacingPixel();
                            rect0.right = this.getLeftRightEdgeMarginPixel();
                            return;
                        }
                        default: {
                            rect0.left = this.getSpacingPixel();
                            rect0.right = this.getSpacingPixel();
                        }
                    }
                }
            }
        }

        private final int getLastBottomSpacingPixel() {
            return ((Number)this.lastBottomSpacingPixel$delegate.getValue()).intValue();
        }

        private final int getLeftRightEdgeMarginPixel() {
            return ((Number)this.leftRightEdgeMarginPixel$delegate.getValue()).intValue();
        }

        private final int getSpacingPixel() {
            return ((Number)this.spacingPixel$delegate.getValue()).intValue();
        }

        private static final int lastBottomSpacingPixel_delegate$lambda$1(SettingBannedContentsFragment settingBannedContentsFragment0) {
            return ScreenUtils.dipToPixel(settingBannedContentsFragment0.getContext(), 16.0f);
        }

        private static final int leftRightEdgeMarginPixel_delegate$lambda$2(SettingBannedContentsFragment settingBannedContentsFragment0) {
            return ScreenUtils.dipToPixel(settingBannedContentsFragment0.getContext(), 16.0f);
        }

        private static final int spacingPixel_delegate$lambda$0(SettingBannedContentsFragment settingBannedContentsFragment0) {
            return ScreenUtils.dipToPixel(settingBannedContentsFragment0.getContext(), 5.0f);
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_FILTER_INDEX = "argFilterIndex";
    @NotNull
    private static final String ARG_SORT_INDEX = "argSortIndex";
    @NotNull
    public static final Companion Companion = null;
    private static final int FILTER_ALPHABET = 1;
    private static final int FILTER_ARTIST = 2;
    private static final int FILTER_NEW = 0;
    public static final int SORT_TYPE_ARTIST = 1;
    public static final int SORT_TYPE_GENRE = 2;
    public static final int SORT_TYPE_SONG = 0;
    private static final int SPAN_SIZE_1 = 1;
    private static final int SPAN_SIZE_2 = 2;
    @NotNull
    private static final String TAG = "SettingBannedContentsFragment";
    private static final int VIEW_TYPE_ARTIST_HEADER = 11;
    private static final int VIEW_TYPE_ARTIST_LIST = 12;
    private static final int VIEW_TYPE_GNR_MENU = 22;
    private static final int VIEW_TYPE_GNR_TITLE = 21;
    private static final int VIEW_TYPE_SONG_HEADER = 1;
    private static final int VIEW_TYPE_SONG_LIST = 2;
    @NotNull
    private final ie.j arrayBannedExplain$delegate;
    @NotNull
    private final ie.j arrayFilterText$delegate;
    private int currentFilterIndex;
    private int currentSortIndex;
    private FilterDropDownView filterDropDownView;
    @NotNull
    private final ie.j itemDecoration$delegate;
    private SortingBarView sortingBarView;
    private TextView tvBannedExPlain;

    static {
        SettingBannedContentsFragment.Companion = new Companion(null);
        SettingBannedContentsFragment.$stable = 8;
    }

    public SettingBannedContentsFragment() {
        this.arrayBannedExplain$delegate = g.Q(new com.iloen.melon.fragments.settings.p(this, 5));
        this.arrayFilterText$delegate = g.Q(new com.iloen.melon.fragments.settings.p(this, 3));
        this.itemDecoration$delegate = g.Q(new com.iloen.melon.fragments.settings.p(this, 4));
    }

    public static void T(VolleyError volleyError0) {
        SettingBannedContentsFragment.deleteBanSongList$lambda$35(volleyError0);
    }

    private static final String[] arrayBannedExplain_delegate$lambda$0(SettingBannedContentsFragment settingBannedContentsFragment0) {
        return settingBannedContentsFragment0.getResources().getStringArray(0x7F030006);  // array:banned_contents_explain
    }

    private static final String[] arrayFilterText_delegate$lambda$1(SettingBannedContentsFragment settingBannedContentsFragment0) {
        return settingBannedContentsFragment0.getResources().getStringArray(0x7F030007);  // array:banned_contents_song_filter
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public ToolBar buildToolBar() {
        View view0 = this.findViewById(0x7F0A0BC6);  // id:toolbar_layout
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.ToolBar");
        return ToolBar.f(((ToolBar)view0), 508);
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new BannedContentsAdapter(this, context0, null);
    }

    private final void deleteBanSongList(String s) {
        v9.m m0 = this.getMarkedList(false);
        if(m0 != null && !m0.a) {
            j0 j00 = this.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.settings.SettingBannedContentsFragment.BannedContentsAdapter");
            ArrayList arrayList0 = new ArrayList();
            arrayList0.addAll(m0.d);
            if(!arrayList0.isEmpty()) {
                Iterator iterator0 = arrayList0.iterator();
                q.f(iterator0, "iterator(...)");
                String s1;
                for(s1 = ""; iterator0.hasNext(); s1 = va.e.c(s1, ((SongInfoBase)object1).songId, ",")) {
                    Object object0 = iterator0.next();
                    q.f(object0, "next(...)");
                    Object object1 = ((BannedContentsAdapter)j00).getItem(((Number)object0).intValue());
                    q.e(object1, "null cannot be cast to non-null type com.melon.net.res.common.SongInfoBase");
                }
                if(s1.length() > 0) {
                    s1 = s1.substring(0, s1.length() - 1);
                    q.f(s1, "substring(...)");
                }
                LogU.Companion.d("SettingBannedContentsFragment", "deleteBanList() songIds: " + s1);
                Params myMusicDeleteBanSongReq$Params0 = new Params();
                myMusicDeleteBanSongReq$Params0.songId = s1;
                myMusicDeleteBanSongReq$Params0.menuId = s;
                myMusicDeleteBanSongReq$Params0.reasonContsTypeCode = "N10001";
                RequestBuilder.newInstance(new MyMusicDeleteBanSongReq(this.getContext(), myMusicDeleteBanSongReq$Params0)).tag("SettingBannedContentsFragment").listener(new h(this)).errorListener(new com.iloen.melon.fragments.musicmessage.e(10)).request();
            }
        }
    }

    private static final void deleteBanSongList$lambda$34(SettingBannedContentsFragment settingBannedContentsFragment0, MyMusicDeleteBanSongRes myMusicDeleteBanSongRes0) {
        if(settingBannedContentsFragment0.isFragmentValid() && myMusicDeleteBanSongRes0 != null && myMusicDeleteBanSongRes0.isSuccessful()) {
            TimeExpiredCache.getInstance().remove(MelonContentUris.n.toString());
            settingBannedContentsFragment0.startFetch("all data delete");
        }
    }

    private static final void deleteBanSongList$lambda$35(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    private final String[] getArrayBannedExplain() {
        return (String[])this.arrayBannedExplain$delegate.getValue();
    }

    private final String[] getArrayFilterText() {
        return (String[])this.arrayFilterText$delegate.getValue();
    }

    private final GridLayoutManager getGridLayoutManager() {
        GridLayoutManager gridLayoutManager0 = new GridLayoutManager(this.getContext(), 2);
        gridLayoutManager0.g = new androidx.recyclerview.widget.H() {
            @Override  // androidx.recyclerview.widget.H
            public int getSpanSize(int v) {
                return SettingBannedContentsFragment.this.getAdapter().getItemViewType(v) == 22 ? 1 : 2;
            }
        };
        return gridLayoutManager0;
    }

    private final GenreItemDecoration getItemDecoration() {
        return (GenreItemDecoration)this.itemDecoration$delegate.getValue();
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public int getTitleResId() {
        return 0x7F13096B;  // string:setting_banned_contents_title "제외 콘텐츠 관리"
    }

    private static final GenreItemDecoration itemDecoration_delegate$lambda$2(SettingBannedContentsFragment settingBannedContentsFragment0) {
        return new GenreItemDecoration(settingBannedContentsFragment0);
    }

    @NotNull
    public static final SettingBannedContentsFragment newInstance() {
        return SettingBannedContentsFragment.Companion.newInstance();
    }

    @NotNull
    public static final SettingBannedContentsFragment newInstance(int v) {
        return SettingBannedContentsFragment.Companion.newInstance(v);
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    @Nullable
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        RecyclerView recyclerView0 = view0 instanceof RecyclerView ? ((RecyclerView)view0) : null;
        if(recyclerView0 != null) {
            LinearLayoutManager linearLayoutManager0 = this.currentSortIndex == 2 ? this.getGridLayoutManager() : new LinearLayoutManager(recyclerView0.getContext());
            recyclerView0.setLayoutManager(linearLayoutManager0);
            recyclerView0.setHasFixedSize(true);
            if(this.currentSortIndex == 2) {
                recyclerView0.addItemDecoration(this.getItemDecoration());
            }
            else {
                recyclerView0.removeItemDecoration(this.getItemDecoration());
            }
            recyclerView0.setAdapter(this.mAdapter);
            return recyclerView0;
        }
        return null;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D0824, viewGroup0, false);  // layout:setting_banned_contents
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public boolean onFetchStart(@Nullable v9.i i0, @Nullable v9.h h0, @Nullable String s) {
        switch(this.currentSortIndex) {
            case 0: {
                return this.requesBannedSongList(i0);
            }
            case 1: {
                return this.requestBannedArtist(i0);
            }
            case 2: {
                return this.requestGnrMenu(i0);
            }
            default: {
                BannedContentsAdapter settingBannedContentsFragment$BannedContentsAdapter0 = this.mAdapter instanceof BannedContentsAdapter ? ((BannedContentsAdapter)this.mAdapter) : null;
                if(!q.b(i0, v9.i.b)) {
                    i0 = null;
                }
                if(i0 != null && settingBannedContentsFragment$BannedContentsAdapter0 != null) {
                    settingBannedContentsFragment$BannedContentsAdapter0.clear();
                }
                return false;
            }
        }
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        this.currentSortIndex = bundle0.getInt("argSortIndex", 0);
        this.currentFilterIndex = bundle0.getInt("argFilterIndex", 0);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putInt("argSortIndex", this.currentSortIndex);
        bundle0.putInt("argFilterIndex", this.currentFilterIndex);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onToolBarClick(@Nullable ToolBarItem toolBar$ToolBarItem0, int v) {
        if(21 == v) {
            if(!this.isLoginUser()) {
                ToastManager.showShort(0x7F1308D1);  // string:retry_after_login "로그인 후 이용해 주세요."
                return;
            }
            BannedContentsAdapter settingBannedContentsFragment$BannedContentsAdapter0 = this.mAdapter instanceof BannedContentsAdapter ? ((BannedContentsAdapter)this.mAdapter) : null;
            if(settingBannedContentsFragment$BannedContentsAdapter0 != null) {
                int v1 = this.getMarkedList(false).d.size();
                if(v1 <= 0) {
                    String s = this.getString(0x7F1300A4);  // string:alert_dlg_body_delete_song_select_content "곡을 선택해 주세요."
                    q.f(s, "getString(...)");
                    l0 l00 = this.getChildFragmentManager();
                    String s1 = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                    com.melon.ui.popup.b.d(com.melon.ui.popup.b.a, l00, s1, s, false, false, false, null, null, null, null, null, 2040);
                    return;
                }
                String s2 = this.getString(0x7F1300B7);  // string:alert_dlg_body_recommend "%1$d곡을 다시 추천 받으시겠습니까?"
                q.f(s2, "getString(...)");
                String s3 = String.format(s2, Arrays.copyOf(new Object[]{v1}, 1));
                com.melon.ui.popup.b.x(this.getChildFragmentManager(), this.getString(0x7F1300D0), s3, false, false, null, null, new com.iloen.melon.fragments.settings.j(0, this, settingBannedContentsFragment$BannedContentsAdapter0), null, null, null, 0xEF8);  // string:alert_dlg_title_info "안내"
            }
        }
    }

    private static final H onToolBarClick$lambda$15$lambda$14(SettingBannedContentsFragment settingBannedContentsFragment0, BannedContentsAdapter settingBannedContentsFragment$BannedContentsAdapter0) {
        String s = settingBannedContentsFragment$BannedContentsAdapter0.getMenuId();
        q.f(s, "getMenuId(...)");
        settingBannedContentsFragment0.deleteBanSongList(s);
        return H.a;
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        View view1 = view0.findViewById(0x7F0A0C1F);  // id:tv_banned_explain
        q.f(view1, "findViewById(...)");
        this.tvBannedExPlain = (TextView)view1;
        String[] arr_s = this.getArrayBannedExplain();
        ((TextView)view1).setText(arr_s[this.currentSortIndex]);
        View view2 = view0.findViewById(0x7F0A0AB8);  // id:sort_bar
        q.f(view2, "findViewById(...)");
        this.sortingBarView = (SortingBarView)view2;
        ((SortingBarView)view2).setSelection(this.currentSortIndex);
        ((SortingBarView)view2).setOnSortSelectionListener(new h(this));
        View view3 = view0.findViewById(0x7F0A04AA);  // id:filterdropdown
        q.f(view3, "findViewById(...)");
        this.filterDropDownView = (FilterDropDownView)view3;
        String[] arr_s1 = this.getArrayFilterText();
        ((FilterDropDownView)view3).setText(arr_s1[this.currentFilterIndex]);
        ((FilterDropDownView)view3).setOnDropDownListener(new h(this));
        View view4 = this.findViewById(0x7F0A0585);  // id:input_text
        EditText editText0 = view4 instanceof EditText ? ((EditText)view4) : null;
        if(editText0 != null) {
            editText0.setFocusable(false);
            editText0.setClickable(true);
            ViewUtils.setOnClickListener(editText0, new l(this, 1));
        }
        this.showSearchBar(false);
        this.updateUI();

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @oe.e(c = "com.iloen.melon.fragments.settings.SettingBannedContentsFragment$onViewCreated$3$1$1", f = "SettingBannedContentsFragment.kt", l = {203}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.settings.SettingBannedContentsFragment.onViewCreated.3.1.1 extends oe.i implements n {
            int label;

            public com.iloen.melon.fragments.settings.SettingBannedContentsFragment.onViewCreated.3.1.1(Continuation continuation0) {
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.settings.SettingBannedContentsFragment.onViewCreated.3.1.1(continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.settings.SettingBannedContentsFragment.onViewCreated.3.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        this.label = 1;
                        object0 = F.a.f(this);
                        if(object0 == a0) {
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
                H h0 = H.a;
                if(((Number)object0).intValue() >= 100) {
                    ToastManager.show(0x7F130962);  // string:setting_banned_contents_artist_limit "100명까지 제외 가능합니다. 제외한 아티스트 삭제 후 시도해주세요."
                    return h0;
                }
                SettingExcludedArtistSearchFragment.Companion.newInstance().open();
                return h0;
            }
        }

    }

    private static final void onViewCreated$lambda$10$lambda$9(SettingBannedContentsFragment settingBannedContentsFragment0, FilterDropDownView filterDropDownView0) {
        if(!settingBannedContentsFragment0.isRetainedPopupShowing()) {
            com.iloen.melon.popup.CommonFilterPopup.Companion commonFilterPopup$Companion0 = CommonFilterPopup.Companion;
            String[] arr_s = settingBannedContentsFragment0.getArrayFilterText();
            ArrayList arrayList0 = new ArrayList(arr_s.length);
            for(int v = 0; v < arr_s.length; ++v) {
                String s = arr_s[v];
                v9.j j0 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
                j0.b = s;
                arrayList0.add(j0);
            }
            CommonFilterPopup commonFilterPopup0 = com.iloen.melon.popup.CommonFilterPopup.Companion.newInstance$default(commonFilterPopup$Companion0, 0x7F1307D1, "LIST_TYPE_DEPTH_ONE_BASIC", je.p.P0(arrayList0), settingBannedContentsFragment0.currentFilterIndex, 0, 0, new com.iloen.melon.fragments.settings.i(settingBannedContentsFragment0), 0x30, null);  // string:order_by "정렬"
            FragmentActivity fragmentActivity0 = settingBannedContentsFragment0.getActivity();
            if(fragmentActivity0 != null) {
                l0 l00 = fragmentActivity0.getSupportFragmentManager();
                if(l00 != null) {
                    commonFilterPopup0.setDismissFragment(settingBannedContentsFragment0);
                    commonFilterPopup0.show(l00, "ComposeBottomSheet");
                }
            }
        }
    }

    private static final H onViewCreated$lambda$10$lambda$9$lambda$7(SettingBannedContentsFragment settingBannedContentsFragment0, int v, int v1, int v2) {
        H h0 = H.a;
        if(settingBannedContentsFragment0.currentFilterIndex == v) {
            return h0;
        }
        settingBannedContentsFragment0.currentFilterIndex = v;
        FilterDropDownView filterDropDownView0 = settingBannedContentsFragment0.filterDropDownView;
        if(filterDropDownView0 != null) {
            String[] arr_s = settingBannedContentsFragment0.getArrayFilterText();
            filterDropDownView0.setText(arr_s[settingBannedContentsFragment0.currentFilterIndex]);
            settingBannedContentsFragment0.startFetch("change filter");
            return h0;
        }
        q.m("filterDropDownView");
        throw null;
    }

    private static final void onViewCreated$lambda$12$lambda$11(SettingBannedContentsFragment settingBannedContentsFragment0, View view0) {
        D d0 = settingBannedContentsFragment0.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new com.iloen.melon.fragments.settings.SettingBannedContentsFragment.onViewCreated.3.1.1(null), 3, null);
    }

    private static final void onViewCreated$lambda$4$lambda$3(SettingBannedContentsFragment settingBannedContentsFragment0, int v) {
        if(settingBannedContentsFragment0.currentSortIndex == v) {
            return;
        }
        settingBannedContentsFragment0.currentSortIndex = v;
        settingBannedContentsFragment0.updateUI();
        settingBannedContentsFragment0.startFetch("change sortbar");
    }

    private final void performError(String s) {
        VolleyError volleyError0 = NetUtils.isConnected() ? MelonError.fromServerMessage(s) : MelonError.HTTP_CONNECTION_ERROR;
        this.performFetchError(volleyError0);
    }

    private final boolean requesBannedSongList(v9.i i0) {
        String s1;
        com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
        String s = i0 == null ? "Unknown type" : i0;
        logU$Companion0.d("SettingBannedContentsFragment", "requesBannedSongList() - type : " + s);
        v9.i i1 = null;
        BannedContentsAdapter settingBannedContentsFragment$BannedContentsAdapter0 = this.mAdapter instanceof BannedContentsAdapter ? ((BannedContentsAdapter)this.mAdapter) : null;
        if(q.b(i0, v9.i.b)) {
            i1 = i0;
        }
        if(i1 != null && settingBannedContentsFragment$BannedContentsAdapter0 != null) {
            settingBannedContentsFragment$BannedContentsAdapter0.clear();
        }
        com.iloen.melon.net.v6x.request.BanListBannedSongReq.Params banListBannedSongReq$Params0 = new com.iloen.melon.net.v6x.request.BanListBannedSongReq.Params();
        banListBannedSongReq$Params0.startIndex = (settingBannedContentsFragment$BannedContentsAdapter0 == null ? 0 : settingBannedContentsFragment$BannedContentsAdapter0.getCount()) + 1;
        banListBannedSongReq$Params0.pageSize = 100;
        switch(this.currentFilterIndex) {
            case 1: {
                s1 = "ALPHABET";
                break;
            }
            case 2: {
                s1 = "ARTIST";
                break;
            }
            default: {
                s1 = "NEW";
            }
        }
        banListBannedSongReq$Params0.orderBy = s1;
        RequestBuilder.newInstance(new BanListBannedSongReq(this.getContext(), banListBannedSongReq$Params0)).tag("SettingBannedContentsFragment").listener(new com.iloen.melon.fragments.settings.k(this, i0, 0)).errorListener(new h(this)).request();
        return true;
    }

    private static final void requesBannedSongList$lambda$25(SettingBannedContentsFragment settingBannedContentsFragment0, v9.i i0, BanListBannedSongRes banListBannedSongRes0) {
        int v;
        boolean z = true;
        if(!settingBannedContentsFragment0.prepareFetchComplete(banListBannedSongRes0)) {
            FilterDropDownView filterDropDownView0 = settingBannedContentsFragment0.filterDropDownView;
            if(filterDropDownView0 != null) {
                ViewUtils.hideWhen(filterDropDownView0, true);
                settingBannedContentsFragment0.showToolbar(false);
                return;
            }
            q.m("filterDropDownView");
            throw null;
        }
        FilterDropDownView filterDropDownView1 = settingBannedContentsFragment0.filterDropDownView;
        if(filterDropDownView1 != null) {
            if(banListBannedSongRes0 == null) {
                v = 0;
            }
            else {
                Collection collection0 = banListBannedSongRes0.getItems();
                v = collection0 == null ? 0 : collection0.size();
            }
            if(v <= 0) {
                z = false;
            }
            ViewUtils.showWhen(filterDropDownView1, z);
            settingBannedContentsFragment0.performFetchComplete(i0, banListBannedSongRes0);
            return;
        }
        q.m("filterDropDownView");
        throw null;
    }

    private static final void requesBannedSongList$lambda$26(SettingBannedContentsFragment settingBannedContentsFragment0, VolleyError volleyError0) {
        FilterDropDownView filterDropDownView0 = settingBannedContentsFragment0.filterDropDownView;
        if(filterDropDownView0 != null) {
            ViewUtils.hideWhen(filterDropDownView0, true);
            settingBannedContentsFragment0.performFetchError(volleyError0);
            return;
        }
        q.m("filterDropDownView");
        throw null;
    }

    private final boolean requestBannedArtist(v9.i i0) {
        com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
        String s = i0 == null ? "Unknown type" : i0;
        logU$Companion0.d("SettingBannedContentsFragment", "requestBannedArtist() - type : " + s);
        BannedContentsAdapter settingBannedContentsFragment$BannedContentsAdapter0 = this.mAdapter instanceof BannedContentsAdapter ? ((BannedContentsAdapter)this.mAdapter) : null;
        if(!q.b(i0, v9.i.b)) {
            i0 = null;
        }
        if(i0 != null && settingBannedContentsFragment$BannedContentsAdapter0 != null) {
            settingBannedContentsFragment$BannedContentsAdapter0.clear();
        }
        String s1 = u.v(((e0)va.o.a()).j());
        if(!u.o(s1)) {
            s1 = null;
        }
        if(s1 == null) {
            return false;
        }
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(settingBannedContentsFragment$BannedContentsAdapter0, null) {
            final BannedContentsAdapter $adapter;
            Object L$0;
            Object L$1;
            int label;

            {
                SettingBannedContentsFragment.this = settingBannedContentsFragment0;
                this.$adapter = settingBannedContentsFragment$BannedContentsAdapter0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.settings.SettingBannedContentsFragment.requestBannedArtist.4(SettingBannedContentsFragment.this, this.$adapter, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.settings.SettingBannedContentsFragment.requestBannedArtist.4)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                String s1;
                UserDataSyncTask userDataSyncTask1;
                k k0;
                a a0 = a.a;
                H h0 = H.a;
                HttpResponse httpResponse0 = null;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        this.label = 1;
                        object0 = F.a.m("requestBannedArtist", this);
                        if(object0 == a0) {
                            return a0;
                        }
                        goto label_11;
                    }
                    case 1: {
                        d5.n.D(object0);
                    label_11:
                        k0 = (k)object0;
                        j j0 = k0 instanceof j ? ((j)k0) : null;
                        UserDataSyncTask userDataSyncTask0 = j0 == null ? null : j0.a;
                        if(!SettingBannedContentsFragment.this.isFragmentValid()) {
                            return h0;
                        }
                        this.L$0 = k0;
                        this.L$1 = userDataSyncTask0;
                        this.label = 2;
                        Object object1 = F.a.g(this);
                        if(object1 == a0) {
                            return a0;
                        }
                        userDataSyncTask1 = userDataSyncTask0;
                        object0 = object1;
                        break;
                    }
                    case 2: {
                        userDataSyncTask1 = (UserDataSyncTask)this.L$1;
                        k0 = (k)this.L$0;
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                String s = "";
                BannedContentsAdapter settingBannedContentsFragment$BannedContentsAdapter0 = this.$adapter;
                if(settingBannedContentsFragment$BannedContentsAdapter0 != null) {
                    if(!((List)object0).isEmpty()) {
                        if(userDataSyncTask1 == null) {
                            s1 = null;
                        }
                        else {
                            s1 = userDataSyncTask1.c;
                            if(s1 == null) {
                                s1 = "";
                            }
                        }
                        settingBannedContentsFragment$BannedContentsAdapter0.add(s1, false);
                        for(Object object2: ((List)object0)) {
                            settingBannedContentsFragment$BannedContentsAdapter0.add(((ExcludedArtistEntity)object2), false);
                        }
                    }
                    if(userDataSyncTask1 == null) {
                        s = null;
                    }
                    else {
                        String s2 = userDataSyncTask1.d;
                        if(s2 != null) {
                            s = s2;
                        }
                    }
                    settingBannedContentsFragment$BannedContentsAdapter0.setMenuId(s);
                }
                if(!SettingBannedContentsFragment.this.isFragmentValid()) {
                    return h0;
                }
                if(userDataSyncTask1 != null) {
                    httpResponse0 = userDataSyncTask1.e;
                }
                if(httpResponse0 != null) {
                    SettingBannedContentsFragment.this.performLogging(userDataSyncTask1.e);
                }
                if(SettingBannedContentsFragment.this.currentSortIndex == 1) {
                    BannedContentsAdapter settingBannedContentsFragment$BannedContentsAdapter1 = this.$adapter;
                    if(settingBannedContentsFragment$BannedContentsAdapter1 != null) {
                        settingBannedContentsFragment$BannedContentsAdapter1.notifyDataSetChanged();
                    }
                }
                if(k0 instanceof j) {
                    SettingBannedContentsFragment.this.showSearchBar(true);
                    SettingBannedContentsFragment.this.performFetchCompleteOnlyViews();
                    return h0;
                }
                if(!(k0 instanceof i)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                SettingBannedContentsFragment.this.showSearchBar(false);
                SettingBannedContentsFragment.this.performError(((i)k0).a);
                return h0;
            }
        }, 3, null);
        return true;
    }

    private final boolean requestGnrMenu(v9.i i0) {
        com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
        String s = i0 == null ? "Unknown type" : i0;
        logU$Companion0.d("SettingBannedContentsFragment", "requestGnrMenu() - type : " + s);
        BannedContentsAdapter settingBannedContentsFragment$BannedContentsAdapter0 = this.mAdapter instanceof BannedContentsAdapter ? ((BannedContentsAdapter)this.mAdapter) : null;
        if((q.b(i0, v9.i.b) ? i0 : null) != null && settingBannedContentsFragment$BannedContentsAdapter0 != null) {
            settingBannedContentsFragment$BannedContentsAdapter0.clear();
        }
        RequestBuilder.newInstance(new SettingGnrMenuReq(this.getContext())).tag("SettingBannedContentsFragment").listener(new com.iloen.melon.fragments.settings.k(this, i0, 1)).errorListener(this.mResponseErrorListener).request();
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(settingBannedContentsFragment$BannedContentsAdapter0, null) {
            final BannedContentsAdapter $adapter;
            int label;

            {
                SettingBannedContentsFragment.this = settingBannedContentsFragment0;
                this.$adapter = settingBannedContentsFragment$BannedContentsAdapter0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.settings.SettingBannedContentsFragment.requestGnrMenu.4(SettingBannedContentsFragment.this, this.$adapter, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.settings.SettingBannedContentsFragment.requestGnrMenu.4)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        this.label = 1;
                        if(F.a.n("requestGnrMenu", this) == a0) {
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
                if(SettingBannedContentsFragment.this.currentSortIndex == 2) {
                    BannedContentsAdapter settingBannedContentsFragment$BannedContentsAdapter0 = this.$adapter;
                    if(settingBannedContentsFragment$BannedContentsAdapter0 != null) {
                        settingBannedContentsFragment$BannedContentsAdapter0.notifyDataSetChanged();
                    }
                }
                return H.a;
            }
        }, 3, null);
        return true;
    }

    private static final void requestGnrMenu$lambda$32(SettingBannedContentsFragment settingBannedContentsFragment0, v9.i i0, SettingGnrMenuRes settingGnrMenuRes0) {
        if(!settingBannedContentsFragment0.prepareFetchComplete(settingGnrMenuRes0)) {
            return;
        }
        settingBannedContentsFragment0.performFetchComplete(i0, settingGnrMenuRes0);
    }

    private final void showSearchBar(boolean z) {
        View view0 = this.findViewById(0x7F0A0A36);  // id:search_bar
        SearchBarView searchBarView0 = view0 instanceof SearchBarView ? ((SearchBarView)view0) : null;
        if(searchBarView0 != null) {
            ViewUtils.showWhen(searchBarView0, z);
        }
    }

    private final void showToolbar(boolean z) {
        ToolBar toolBar0 = this.mToolBar;
        if(toolBar0 != null) {
            if(z) {
                this.showToolBar();
                this.mToolBar.i(true);
                return;
            }
            toolBar0.i(false);
            this.hideToolBar();
        }
    }

    private final void updateUI() {
        TextView textView0 = this.tvBannedExPlain;
        BannedContentsAdapter settingBannedContentsFragment$BannedContentsAdapter0 = null;
        if(textView0 != null) {
            String[] arr_s = this.getArrayBannedExplain();
            textView0.setText(arr_s[this.currentSortIndex]);
            boolean z = false;
            ViewUtils.showWhen(this.findViewById(0x7F0A049B), this.currentSortIndex == 0);  // id:filter_container
            ViewUtils.showWhen(this.findViewById(0x7F0A0A37), this.currentSortIndex == 1);  // id:search_bar_container
            ViewUtils.showWhen(this.findViewById(0x7F0A04E6), this.currentSortIndex == 2);  // id:gap
            if(this.currentSortIndex != 0) {
                this.showToolbar(false);
            }
            j0 j00 = this.mAdapter;
            if(j00 instanceof BannedContentsAdapter) {
                settingBannedContentsFragment$BannedContentsAdapter0 = (BannedContentsAdapter)j00;
            }
            if(settingBannedContentsFragment$BannedContentsAdapter0 != null) {
                int v = this.currentSortIndex == 1 ? 0x7F130960 : 0x7F130969;  // string:setting_banned_contents_artist_empty_message "추가된 아티스트가 없습니다."
                e e0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
                e0.d = -1;
                e0.e = -1;
                e0.g = -1;
                e0.i = -1;
                e0.k = -1;
                e0.l = -1;
                e0.f = this.getString(v);
                settingBannedContentsFragment$BannedContentsAdapter0.setEmptyViewInfo(e0);
                if(this.currentSortIndex == 0) {
                    z = true;
                }
                settingBannedContentsFragment$BannedContentsAdapter0.setMarkedMode(z);
            }
            RecyclerView recyclerView0 = this.mRecyclerView;
            LinearLayoutManager linearLayoutManager0 = this.currentSortIndex == 2 ? this.getGridLayoutManager() : new LinearLayoutManager(this.getContext());
            recyclerView0.setLayoutManager(linearLayoutManager0);
            if(this.currentSortIndex == 2) {
                this.mRecyclerView.addItemDecoration(this.getItemDecoration());
                return;
            }
            this.mRecyclerView.removeItemDecoration(this.getItemDecoration());
            return;
        }
        q.m("tvBannedExPlain");
        throw null;
    }
}

