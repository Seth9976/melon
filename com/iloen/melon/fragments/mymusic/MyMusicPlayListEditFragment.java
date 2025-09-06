package com.iloen.melon.fragments.mymusic;

import B9.u;
import F8.C;
import F8.m;
import H0.e;
import J8.J0;
import J8.Q1;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventPlaylist.EventDeleteSong;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.HttpResponse.Notification;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v4x.request.MyMusicPlaylistUpdateOrderReq;
import com.iloen.melon.net.v4x.response.MyMusicPlaylistUpdateOrderRes;
import com.iloen.melon.net.v6x.request.CleanIsBlackReq;
import com.iloen.melon.net.v6x.request.DjPlaylistDeleteReq;
import com.iloen.melon.net.v6x.request.DjPlaylistListV6Req;
import com.iloen.melon.net.v6x.request.DjPlaylistUpdateOrderReq.Params;
import com.iloen.melon.net.v6x.request.DjPlaylistUpdateOrderReq;
import com.iloen.melon.net.v6x.request.MyMusicPlaylistDeleteReq;
import com.iloen.melon.net.v6x.request.MyMusicPlaylistListV6Req;
import com.iloen.melon.net.v6x.response.CleanIsBlackRes;
import com.iloen.melon.net.v6x.response.DjPlaylistListV6Res.RESPONSE.PLAYLIST;
import com.iloen.melon.net.v6x.response.DjPlaylistListV6Res;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistListV6Res.RESPONSE;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistListV6Res;
import com.iloen.melon.utils.TimeExpiredCache;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.dragdrop.DragSortHeaderFooterAdapter;
import com.iloen.melon.utils.dragdrop.MelonItemTouchHelper.ItemMoveListener;
import com.iloen.melon.utils.dragdrop.MelonItemTouchHelper;
import com.iloen.melon.utils.dragdrop.scroll.ScrollStrategyBase.ScrollSpeed;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.ui.popup.b;
import ie.H;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import v9.i;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0007\u0018\u0000 W2\u00020\u0001:\u0002WXB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\u0007\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0007\u0010\u0006J\u000F\u0010\t\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\u000BH\u0014\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u0011\u0010\u000FJ-\u0010\u0018\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0013\u001A\u00020\u00122\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\b\u0010\u0016\u001A\u0004\u0018\u00010\u000BH\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001B\u001A\u00020\r2\u0006\u0010\u001A\u001A\u00020\u00172\b\u0010\u0016\u001A\u0004\u0018\u00010\u000BH\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\'\u0010\"\u001A\u00020\u00042\u0006\u0010\u001E\u001A\u00020\u001D2\u0006\u0010 \u001A\u00020\u001F2\u0006\u0010!\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b\"\u0010#J\u001B\u0010\'\u001A\u0006\u0012\u0002\b\u00030&2\u0006\u0010%\u001A\u00020$H\u0014\u00A2\u0006\u0004\b\'\u0010(J\u000F\u0010*\u001A\u00020)H\u0014\u00A2\u0006\u0004\b*\u0010+J\u000F\u0010-\u001A\u00020,H\u0014\u00A2\u0006\u0004\b-\u0010.J\u001F\u00103\u001A\u00020\r2\u0006\u00100\u001A\u00020/2\u0006\u00102\u001A\u000201H\u0014\u00A2\u0006\u0004\b3\u00104J\u001F\u00107\u001A\u00020\r2\u0006\u00105\u001A\u00020\u00042\u0006\u00106\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b7\u00108J\u000F\u00109\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b9\u0010\u0006J#\u0010<\u001A\u00020\r2\u0006\u0010\u001E\u001A\u00020\u001D2\n\u0010;\u001A\u00060:R\u00020\u0000H\u0002\u00A2\u0006\u0004\b<\u0010=J#\u0010>\u001A\u00020\r2\u0006\u0010\u001E\u001A\u00020\u001D2\n\u0010;\u001A\u00060:R\u00020\u0000H\u0002\u00A2\u0006\u0004\b>\u0010=J\u001F\u0010B\u001A\u00020\r2\u0006\u0010@\u001A\u00020?2\u0006\u0010A\u001A\u00020?H\u0002\u00A2\u0006\u0004\bB\u0010CJ\u000F\u0010D\u001A\u00020\rH\u0002\u00A2\u0006\u0004\bD\u0010\u0003J\u000F\u0010E\u001A\u00020\rH\u0002\u00A2\u0006\u0004\bE\u0010\u0003J\u000F\u0010F\u001A\u00020\rH\u0002\u00A2\u0006\u0004\bF\u0010\u0003J\u0017\u0010H\u001A\u00020\r2\u0006\u0010G\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\bH\u0010IR\u0016\u0010J\u001A\u0002018\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010L\u001A\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010O\u001A\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010Q\u001A\u0002018\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bQ\u0010KR\u0016\u0010R\u001A\u0002018\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bR\u0010KR\u0016\u0010S\u001A\u0002018\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bS\u0010KR\u0014\u0010T\u001A\u00020\u00048BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bT\u0010\u0006R\u0014\u0010V\u001A\u00020\b8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bU\u0010\n\u00A8\u0006Y"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicPlayListEditFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "", "shouldShowMiniPlayer", "()Z", "hasScrolledLine", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lcom/iloen/melon/custom/ToolBar;", "buildToolBar", "()Lcom/iloen/melon/custom/ToolBar;", "Lcom/iloen/melon/custom/ToolBar$ToolBarItem;", "item", "", "itemId", "onToolBarClick", "(Lcom/iloen/melon/custom/ToolBar$ToolBarItem;I)V", "isEditMode", "isDoneUserAction", "onEditButtonClick", "(ZZ)V", "onBackPressed", "Lcom/iloen/melon/fragments/mymusic/MyMusicPlayListEditFragment$PlayListAdapter;", "adapter", "requestPlayList", "(Lv9/i;Lcom/iloen/melon/fragments/mymusic/MyMusicPlayListEditFragment$PlayListAdapter;)V", "requestDjPlayList", "Lcom/iloen/melon/net/v4x/common/ArtistPlayListInfoBase;", "fromData", "toData", "requestChangeOrder", "(Lcom/iloen/melon/net/v4x/common/ArtistPlayListInfoBase;Lcom/iloen/melon/net/v4x/common/ArtistPlayListInfoBase;)V", "revertOrder", "deletePlaylist", "deleteRequest", "show", "showToolbar", "(Z)V", "djType", "I", "playListCacheKey", "Ljava/lang/String;", "Lcom/iloen/melon/utils/dragdrop/MelonItemTouchHelper;", "melonItemTouchHelper", "Lcom/iloen/melon/utils/dragdrop/MelonItemTouchHelper;", "preTo", "preFrom", "multiDeleteMax", "isDj", "getTitleText", "titleText", "Companion", "PlayListAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MyMusicPlayListEditFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00072\b\u0010\u0010\u001A\u0004\u0018\u00010\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicPlayListEditFragment$Companion;", "", "<init>", "()V", "TAG", "", "DEFAULT_MULTI_DELETE_MAX_COUNT", "", "ARG_DJ_TYPE", "ARG_CACHE_KEY", "DJ_TYPE_NONE", "DJ_TYPE_DJ", "DJ_TYPE_POWER_DJ", "newInstance", "Lcom/iloen/melon/fragments/mymusic/MyMusicPlayListEditFragment;", "djType", "cacheKey", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MyMusicPlayListEditFragment newInstance(int v, @Nullable String s) {
            MyMusicPlayListEditFragment myMusicPlayListEditFragment0 = new MyMusicPlayListEditFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putInt("argDjType", v);
            bundle0.putString("argCacheKey", s);
            myMusicPlayListEditFragment0.setArguments(bundle0);
            return myMusicPlayListEditFragment0;
        }
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B#\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\u0010\u0010\b\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0007\u00A2\u0006\u0004\b\t\u0010\nJ\'\u0010\u0012\u001A\u00020\u00112\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u000FH\u0014\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u001F\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0016\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u001F\u0010\u001B\u001A\u00020\u00142\u0006\u0010\u001A\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u001F\u0010 \u001A\u00020\u00032\u0006\u0010\u001E\u001A\u00020\u001D2\u0006\u0010\u001F\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b \u0010!J\'\u0010#\u001A\u00020\u00172\u0006\u0010\"\u001A\u00020\u00032\u0006\u0010\u001A\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b#\u0010$J\u001D\u0010\'\u001A\u00020\u00172\u0006\u0010%\u001A\u00020\u00142\u0006\u0010&\u001A\u00020\u0014\u00A2\u0006\u0004\b\'\u0010(J\u000F\u0010)\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b)\u0010*J\u000F\u0010+\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b+\u0010*J\u000F\u0010,\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b,\u0010-J\u000F\u0010.\u001A\u00020\u0014H\u0016\u00A2\u0006\u0004\b.\u0010-J\u0011\u00100\u001A\u0004\u0018\u00010/H\u0016\u00A2\u0006\u0004\b0\u00101J\u0011\u00102\u001A\u0004\u0018\u00010/H\u0016\u00A2\u0006\u0004\b2\u00101R\u0014\u00103\u001A\u00020\u00148\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b3\u00104\u00A8\u00065"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicPlayListEditFragment$PlayListAdapter;", "Lcom/iloen/melon/adapters/common/p;", "", "Landroidx/recyclerview/widget/O0;", "Lcom/iloen/melon/utils/dragdrop/DragSortHeaderFooterAdapter;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicPlayListEditFragment;Landroid/content/Context;Ljava/util/List;)V", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "", "position", "marked", "Lie/H;", "setMarked", "(IZ)V", "rawPosition", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "rawFrom", "rawTo", "dragNDrop", "(II)V", "hasDragSortHeaderView", "()Z", "hasDragSortFooterView", "getDragSortHeaderViewPosition", "()I", "getDragSortFooterViewPosition", "Landroid/view/View;", "getDragSortHeaderView", "()Landroid/view/View;", "getDragSortFooterView", "VIEW_TYPE_PLAYLIST_EDIT", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class PlayListAdapter extends p implements DragSortHeaderFooterAdapter {
        private final int VIEW_TYPE_PLAYLIST_EDIT;

        public PlayListAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
            this.VIEW_TYPE_PLAYLIST_EDIT = 1;
        }

        public static void a(MyMusicPlayListEditFragment myMusicPlayListEditFragment0, int v, View view0) {
            PlayListAdapter.onBindViewImpl$lambda$0(myMusicPlayListEditFragment0, v, view0);
        }

        public final void dragNDrop(int v, int v1) {
            int v2 = this.getItemPositionFromList(v);
            int v3 = this.getItemPositionFromList(v1);
            if(v3 >= 0 && v3 <= this.getItemCount() - 1) {
                Object object0 = this.getItem(v2);
                ArtistPlayListInfoBase artistPlayListInfoBase0 = object0 instanceof ArtistPlayListInfoBase ? ((ArtistPlayListInfoBase)object0) : null;
                if(artistPlayListInfoBase0 != null) {
                    MyMusicPlayListEditFragment.this.preFrom = v2;
                    MyMusicPlayListEditFragment.this.preTo = v3;
                    this.remove(v2);
                    this.add(v3, artistPlayListInfoBase0);
                    this.notifyDataSetChanged();
                }
            }
        }

        @Override  // com.iloen.melon.utils.dragdrop.DragSortHeaderFooterAdapter
        @Nullable
        public View getDragSortFooterView() {
            return null;
        }

        @Override  // com.iloen.melon.utils.dragdrop.DragSortHeaderFooterAdapter
        public int getDragSortFooterViewPosition() {
            return this.getItemCount() - 1;
        }

        @Override  // com.iloen.melon.utils.dragdrop.DragSortHeaderFooterAdapter
        @Nullable
        public View getDragSortHeaderView() {
            return null;
        }

        @Override  // com.iloen.melon.utils.dragdrop.DragSortHeaderFooterAdapter
        public int getDragSortHeaderViewPosition() {
            return -1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.VIEW_TYPE_PLAYLIST_EDIT;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(@NotNull String s, @NotNull i i0, @NotNull HttpResponse httpResponse0) {
            q.g(s, "key");
            q.g(i0, "type");
            q.g(httpResponse0, "response");
            ArrayList arrayList0 = null;
            if(httpResponse0 instanceof MyMusicPlaylistListV6Res) {
                RESPONSE myMusicPlaylistListV6Res$RESPONSE0 = ((MyMusicPlaylistListV6Res)httpResponse0).response;
                if(myMusicPlaylistListV6Res$RESPONSE0 != null) {
                    arrayList0 = myMusicPlaylistListV6Res$RESPONSE0.playlistList;
                }
            }
            else if(httpResponse0 instanceof DjPlaylistListV6Res) {
                com.iloen.melon.net.v6x.response.DjPlaylistListV6Res.RESPONSE djPlaylistListV6Res$RESPONSE0 = ((DjPlaylistListV6Res)httpResponse0).response;
                if(djPlaylistListV6Res$RESPONSE0 != null) {
                    arrayList0 = djPlaylistListV6Res$RESPONSE0.djPlaylists;
                }
            }
            MyMusicPlayListEditFragment.this.showToolbar(arrayList0 != null && !arrayList0.isEmpty());
            return false;
        }

        @Override  // com.iloen.melon.utils.dragdrop.DragSortHeaderFooterAdapter
        public boolean hasDragSortFooterView() {
            return false;
        }

        @Override  // com.iloen.melon.utils.dragdrop.DragSortHeaderFooterAdapter
        public boolean hasDragSortHeaderView() {
            return false;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            Object object0 = this.getItem(v1);
            J0 j00 = ((u)o00).a;
            MelonTextView melonTextView0 = ((Q1)j00.f).k;
            if(object0 instanceof PLAYLIST && q.b(((PLAYLIST)object0).playlistTypeCode, "M20005")) {
                ((u)o00).c(((DjPlayListInfoBase)object0), v1, null, false);
                ((RelativeLayout)j00.g).setVisibility(0);
                ((Q1)j00.f).j.setVisibility(0);
                ((Q1)j00.f).f.setVisibility(8);
                melonTextView0.setVisibility(0);
                melonTextView0.setText(MyMusicPlayListEditFragment.this.getString(0x7F130921, new Object[]{((PLAYLIST)object0).plyLstCnt}));  // string:series_playlist_count "%s개"
            }
            else if(object0 instanceof ArtistPlayListInfoBase) {
                ((u)o00).b(((ArtistPlayListInfoBase)object0), v1, null);
                melonTextView0.setVisibility(0);
                melonTextView0.setText(MyMusicPlayListEditFragment.this.getString(0x7F13083B, new Object[]{((ArtistPlayListInfoBase)object0).songcnt}));  // string:playlist_song_count "%s곡"
            }
            if(this.isMarked(v1)) {
                int v2 = ColorUtils.getColor(this.getContext(), 0x7F060199);  // color:list_item_marked
                ((u)o00).itemView.setBackgroundColor(v2);
            }
            else {
                int v3 = ColorUtils.getColor(this.getContext(), 0x7F06048A);  // color:transparent
                ((u)o00).itemView.setBackgroundColor(v3);
            }
            ((ImageView)j00.e).setVisibility(0);
            J j0 = new J(MyMusicPlayListEditFragment.this, v, 3);
            ViewUtils.setOnClickListener(((u)o00).itemView, j0);
        }

        private static final void onBindViewImpl$lambda$0(MyMusicPlayListEditFragment myMusicPlayListEditFragment0, int v, View view0) {
            myMusicPlayListEditFragment0.onItemClick(view0, v);
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            return e.P(viewGroup0, B9.q.d);
        }

        @Override  // com.iloen.melon.adapters.common.j
        public void setMarked(int v, boolean z) {
            if(MyMusicPlayListEditFragment.this.getActivity() == null) {
                return;
            }
            ArtistPlayListInfoBase artistPlayListInfoBase0 = (ArtistPlayListInfoBase)this.getItem(v);
            if(artistPlayListInfoBase0 == null) {
                LogU.Companion.d("MyMusicPlayListEditFragment", "setMarked() - data is null.");
                return;
            }
            b b0 = b.a;
            if(MyMusicPlayListEditFragment.this.isDj()) {
                if("Y".equals(artistPlayListInfoBase0.fameregyn)) {
                    b.d(b0, MyMusicPlayListEditFragment.this.getChildFragmentManager(), MyMusicPlayListEditFragment.this.getString(0x7F1300D0), MyMusicPlayListEditFragment.this.getString(0x7F130087), false, false, false, null, null, null, null, null, 2040);  // string:alert_dlg_title_info "안내"
                    return;
                }
                if(q.b("N10074", artistPlayListInfoBase0.contsTypeCode)) {
                    b.d(b0, MyMusicPlayListEditFragment.this.getChildFragmentManager(), MyMusicPlayListEditFragment.this.getString(0x7F1300D0), MyMusicPlayListEditFragment.this.getString(0x7F1300A3), false, false, false, null, null, null, null, null, 2040);  // string:alert_dlg_title_info "안내"
                    return;
                }
            }
            int v1 = MyMusicPlayListEditFragment.this.multiDeleteMax;
            if(z && this.getMarkedCount() >= v1) {
                b.d(b0, MyMusicPlayListEditFragment.this.getChildFragmentManager(), MyMusicPlayListEditFragment.this.getString(0x7F1300D0), MyMusicPlayListEditFragment.this.getString(0x7F13008A, new Object[]{v1}), false, false, false, null, null, null, null, null, 2040);  // string:alert_dlg_title_info "안내"
                return;
            }
            super.setMarked(v, z);
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_CACHE_KEY = "argCacheKey";
    @NotNull
    private static final String ARG_DJ_TYPE = "argDjType";
    @NotNull
    public static final Companion Companion = null;
    private static final int DEFAULT_MULTI_DELETE_MAX_COUNT = 10;
    public static final int DJ_TYPE_DJ = 1;
    public static final int DJ_TYPE_NONE = 0;
    public static final int DJ_TYPE_POWER_DJ = 2;
    @NotNull
    private static final String TAG = "MyMusicPlayListEditFragment";
    private int djType;
    @Nullable
    private MelonItemTouchHelper melonItemTouchHelper;
    private int multiDeleteMax;
    @Nullable
    private String playListCacheKey;
    private int preFrom;
    private int preTo;

    static {
        MyMusicPlayListEditFragment.Companion = new Companion(null);
        MyMusicPlayListEditFragment.$stable = 8;
    }

    public MyMusicPlayListEditFragment() {
        this.playListCacheKey = "";
        this.preTo = -1;
        this.preFrom = -1;
        this.multiDeleteMax = 10;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public ToolBar buildToolBar() {
        View view0 = this.findViewById(0x7F0A0BC6);  // id:toolbar_layout
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.ToolBar");
        ToolBar toolBar0 = ToolBar.f(((ToolBar)view0), 507);
        q.f(toolBar0, "initLayoutType(...)");
        return toolBar0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new PlayListAdapter(this, context0, null);
        ((j)j00).setListContentType(4);
        ((j)j00).setMarkedMode(true);
        ((j)j00).setEditMode(true);
        return j00;
    }

    private final void deletePlaylist() {
        String s3;
        String s = null;
        PlayListAdapter myMusicPlayListEditFragment$PlayListAdapter0 = this.mAdapter instanceof PlayListAdapter ? ((PlayListAdapter)this.mAdapter) : null;
        if(myMusicPlayListEditFragment$PlayListAdapter0 != null) {
            ArrayList arrayList0 = this.getMarkedList(false).d;
            int v = arrayList0.size();
            if(v <= 0) {
                l0 l00 = this.getChildFragmentManager();
                String s1 = this.getTitleText();
                if(this.getContext() != null) {
                    s = "삭제할 플레이리스트를 선택해 주세요.";
                }
                b.d(b.a, l00, s1, s, false, false, false, null, null, null, null, null, 2040);
                return;
            }
            if(v == 1) {
                Object object0 = arrayList0.get(0);
                q.f(object0, "get(...)");
                ArtistPlayListInfoBase artistPlayListInfoBase0 = (ArtistPlayListInfoBase)myMusicPlayListEditFragment$PlayListAdapter0.getItem(((Number)object0).intValue());
                String s2 = this.getString(0x7F1300A0);  // string:alert_dlg_body_delete_sel_name_playlist "%1$s을(를) 삭제하시겠습니까?\n삭제한 플레이리스트는 
                                                         // 복구할 수 없습니다."
                q.f(s2, "getString(...)");
                if(artistPlayListInfoBase0 != null) {
                    s = artistPlayListInfoBase0.plylsttitle;
                }
                s3 = String.format(s2, Arrays.copyOf(new Object[]{s}, 1));
            }
            else {
                String s4 = this.getString(0x7F1300A1);  // string:alert_dlg_body_delete_sel_playlist "플레이리스트 %1$d개를 삭제 하시겠습니까?\n삭제한 플레이리스트는 
                                                         // 복구할 수 없습니다."
                q.f(s4, "getString(...)");
                s3 = String.format(s4, Arrays.copyOf(new Object[]{v}, 1));
            }
            b.x(this.getChildFragmentManager(), this.getTitleText(), s3, false, false, null, null, new k(this, 3), null, null, null, 0xEF8);
        }
    }

    private static final H deletePlaylist$lambda$14(MyMusicPlayListEditFragment myMusicPlayListEditFragment0) {
        myMusicPlayListEditFragment0.deleteRequest();
        return H.a;
    }

    private final void deleteRequest() {
        LogU.Companion.i("MyMusicPlayListEditFragment", "deleteRequest()");
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.MyMusicPlayListEditFragment.PlayListAdapter");
        ArrayList arrayList0 = this.getMarkedList(false).d;
        if((arrayList0 == null ? 0 : arrayList0.size()) <= 0) {
            return;
        }
        q.d(arrayList0);
        ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
        for(Object object0: arrayList0) {
            q.d(((Integer)object0));
            Object object1 = ((PlayListAdapter)j00).getItem(((int)(((Integer)object0))));
            String s = null;
            ArtistPlayListInfoBase artistPlayListInfoBase0 = object1 instanceof ArtistPlayListInfoBase ? ((ArtistPlayListInfoBase)object1) : null;
            if(artistPlayListInfoBase0 != null) {
                s = artistPlayListInfoBase0.plylstseq;
            }
            arrayList1.add(s);
        }
        ArrayList arrayList2 = new ArrayList();
        for(Object object2: arrayList1) {
            if(((String)object2) != null && ((String)object2).length() != 0) {
                arrayList2.add(object2);
            }
        }
        String s1 = je.p.q0(arrayList2, ",", null, null, null, 62);
        DjPlaylistDeleteReq djPlaylistDeleteReq0 = this.isDj() ? new DjPlaylistDeleteReq(this.getContext(), s1) : new MyMusicPlaylistDeleteReq(this.getContext(), s1);
        RequestBuilder.newInstance(djPlaylistDeleteReq0).tag(this.getRequestTag()).listener(new E(this, arrayList0, ((PlayListAdapter)j00), 4)).errorListener(new W(11)).request();
    }

    private static final void deleteRequest$lambda$19(MyMusicPlayListEditFragment myMusicPlayListEditFragment0, List list0, PlayListAdapter myMusicPlayListEditFragment$PlayListAdapter0, Object object0) {
        q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.HttpResponse");
        if(myMusicPlayListEditFragment0.isFragmentValid()) {
            Cb.j.b(((HttpResponse)object0).notification, false, 3);
            if(Cb.j.d(((HttpResponse)object0))) {
                q.d(list0);
                for(int v = list0.size() - 1; v >= 0; --v) {
                    Integer integer0 = (Integer)list0.get(v);
                    q.d(integer0);
                    Object object1 = myMusicPlayListEditFragment$PlayListAdapter0.getItem(((int)integer0));
                    ArtistPlayListInfoBase artistPlayListInfoBase0 = object1 instanceof ArtistPlayListInfoBase ? ((ArtistPlayListInfoBase)object1) : null;
                    if(artistPlayListInfoBase0 != null) {
                        EventBusHelper.post(new EventDeleteSong(artistPlayListInfoBase0.plylstseq, null));
                    }
                }
                myMusicPlayListEditFragment0.startFetch("delete items");
            }
        }
    }

    private static final void deleteRequest$lambda$20(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.b0.toString();
        q.f(s, "toString(...)");
        return s;
    }

    private final String getTitleText() {
        if(this.getContext() == null) {
            return "";
        }
        switch(this.djType) {
            case 1: {
                String s1 = this.getString(0x7F13076D);  // string:mymusic_djplaylist_edit "DJ플레이리스트 편집"
                q.f(s1, "getString(...)");
                return s1;
            }
            case 2: {
                String s2 = this.getString(0x7F13077B);  // string:mymusic_powerdjplaylist_edit "전체 편집"
                q.f(s2, "getString(...)");
                return s2;
            }
            default: {
                String s = this.getString(0x7F130779);  // string:mymusic_playlist_edit "플레이리스트 편집"
                q.f(s, "getString(...)");
                return s;
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean hasScrolledLine() {
        return true;
    }

    public static void i0(MyMusicPlayListEditFragment myMusicPlayListEditFragment0, List list0, PlayListAdapter myMusicPlayListEditFragment$PlayListAdapter0, Object object0) {
        MyMusicPlayListEditFragment.deleteRequest$lambda$19(myMusicPlayListEditFragment0, list0, myMusicPlayListEditFragment$PlayListAdapter0, object0);
    }

    private final boolean isDj() {
        return this.djType != 0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onBackPressed() {
        TimeExpiredCache.getInstance().remove(this.playListCacheKey);
        return super.onBackPressed();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(this.getActivity()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        int v = ScreenUtils.dipToPixel(((RecyclerView)view0).getContext(), 10.0f);
        ((RecyclerView)view0).setPadding(((RecyclerView)view0).getPaddingLeft(), v, ((RecyclerView)view0).getPaddingRight(), ((RecyclerView)view0).getPaddingBottom());
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D0565, viewGroup0, false);  // layout:mymusic_like_edit
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onEditButtonClick(boolean z, boolean z1) {
        this.performBackPress();
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        String s1 = this.isDj() ? "DJPLAYLIST" : "PLAYLIST";
        RequestBuilder.newInstance(new CleanIsBlackReq(this.getContext(), s1, "")).tag(this.getRequestTag()).listener(new Y(this, i0, 0)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$4(MyMusicPlayListEditFragment myMusicPlayListEditFragment0, i i0, Object object0) {
        q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.CleanIsBlackRes");
        if(myMusicPlayListEditFragment0.isFragmentValid()) {
            Cb.j.b(((CleanIsBlackRes)object0).notification, false, 3);
            if(Cb.j.d(((HttpResponse)object0))) {
                j0 j00 = myMusicPlayListEditFragment0.mAdapter;
                q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.MyMusicPlayListEditFragment.PlayListAdapter");
                if(i.b.equals(i0)) {
                    ((PlayListAdapter)j00).clear(false);
                }
                if(myMusicPlayListEditFragment0.isDj()) {
                    myMusicPlayListEditFragment0.requestDjPlayList(i0, ((PlayListAdapter)j00));
                    return;
                }
                myMusicPlayListEditFragment0.requestPlayList(i0, ((PlayListAdapter)j00));
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        this.djType = bundle0.getInt("argDjType", 0);
        this.playListCacheKey = bundle0.getString("argCacheKey");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putInt("argDjType", this.djType);
        bundle0.putString("argCacheKey", this.playListCacheKey);
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onToolBarClick(@NotNull ToolBarItem toolBar$ToolBarItem0, int v) {
        q.g(toolBar$ToolBarItem0, "item");
        if(16 == v) {
            if(!this.isLoginUser()) {
                ToastManager.showShort(0x7F1308D1);  // string:retry_after_login "로그인 후 이용해 주세요."
                return;
            }
            this.deletePlaylist();
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            m m0 = new m(2, false);
            C c0 = new C();  // 初始化器: Ljava/lang/Object;-><init>()V
            c0.c = new w(this, 3);
            m0.g(c0);
            titleBar0.a(m0);
            titleBar0.setTitle(this.getTitleText());
        }
        MelonItemTouchHelper melonItemTouchHelper0 = new MelonItemTouchHelper(this.mRecyclerView);
        this.melonItemTouchHelper = melonItemTouchHelper0;
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
                if(v != v1) {
                    j0 j00 = MyMusicPlayListEditFragment.this.mAdapter;
                    q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.MyMusicPlayListEditFragment.PlayListAdapter");
                    int v2 = ((PlayListAdapter)j00).getCount();
                    if(v1 > v2 - 1) {
                        v1 = v2 - 1;
                    }
                    ArtistPlayListInfoBase artistPlayListInfoBase0 = (ArtistPlayListInfoBase)((PlayListAdapter)j00).getItem(v);
                    ArtistPlayListInfoBase artistPlayListInfoBase1 = (ArtistPlayListInfoBase)((PlayListAdapter)j00).getItem(v1);
                    if(artistPlayListInfoBase0 != null && artistPlayListInfoBase1 != null) {
                        ((PlayListAdapter)j00).dragNDrop(v, v1);
                        MyMusicPlayListEditFragment.this.requestChangeOrder(artistPlayListInfoBase0, artistPlayListInfoBase1);
                    }
                }
            }
        });
    }

    private static final void onViewCreated$lambda$1$lambda$0(MyMusicPlayListEditFragment myMusicPlayListEditFragment0, View view0) {
        myMusicPlayListEditFragment0.performBackPress();
        TimeExpiredCache.getInstance().remove(myMusicPlayListEditFragment0.playListCacheKey);
    }

    private final void requestChangeOrder(ArtistPlayListInfoBase artistPlayListInfoBase0, ArtistPlayListInfoBase artistPlayListInfoBase1) {
        DjPlaylistUpdateOrderReq djPlaylistUpdateOrderReq0;
        String s = artistPlayListInfoBase0.dsplyorder;
        String s1 = artistPlayListInfoBase1.dsplyorder;
        if(this.isDj()) {
            Params djPlaylistUpdateOrderReq$Params0 = new Params();
            djPlaylistUpdateOrderReq$Params0.moveDsplyOrder = s;
            djPlaylistUpdateOrderReq$Params0.endDsplyOrder = s1;
            djPlaylistUpdateOrderReq$Params0.movePlylstSeq = artistPlayListInfoBase0.plylstseq;
            djPlaylistUpdateOrderReq0 = new DjPlaylistUpdateOrderReq(this.getContext(), djPlaylistUpdateOrderReq$Params0);
        }
        else {
            com.iloen.melon.net.v4x.request.MyMusicPlaylistUpdateOrderReq.Params myMusicPlaylistUpdateOrderReq$Params0 = new com.iloen.melon.net.v4x.request.MyMusicPlaylistUpdateOrderReq.Params();
            myMusicPlaylistUpdateOrderReq$Params0.moveDsplyOrder = s;
            myMusicPlaylistUpdateOrderReq$Params0.endDsplyOrder = s1;
            myMusicPlaylistUpdateOrderReq$Params0.movePlylstSeq = artistPlayListInfoBase0.plylstseq;
            myMusicPlaylistUpdateOrderReq$Params0.plylstTypeCode = "M20001";
            djPlaylistUpdateOrderReq0 = new MyMusicPlaylistUpdateOrderReq(this.getContext(), myMusicPlaylistUpdateOrderReq$Params0);
        }
        RequestBuilder.newInstance(djPlaylistUpdateOrderReq0).tag(this.getRequestTag()).listener(new X(this)).errorListener(new X(this)).request();
    }

    private static final void requestChangeOrder$lambda$10(MyMusicPlayListEditFragment myMusicPlayListEditFragment0, MyMusicPlaylistUpdateOrderRes myMusicPlaylistUpdateOrderRes0) {
        if(myMusicPlayListEditFragment0.isFragmentValid()) {
            if(myMusicPlaylistUpdateOrderRes0 == null) {
                myMusicPlayListEditFragment0.startFetch("normal playlist refresh");
                return;
            }
            Notification httpResponse$Notification0 = myMusicPlaylistUpdateOrderRes0.notification;
            if(httpResponse$Notification0 != null) {
                Cb.j.b(httpResponse$Notification0, false, 3);
            }
            if(Cb.j.d(myMusicPlaylistUpdateOrderRes0)) {
                myMusicPlayListEditFragment0.startFetch("normal playlist refresh");
                return;
            }
        }
        myMusicPlayListEditFragment0.revertOrder();
    }

    private static final void requestChangeOrder$lambda$11(MyMusicPlayListEditFragment myMusicPlayListEditFragment0, VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
        myMusicPlayListEditFragment0.revertOrder();
    }

    private final void requestDjPlayList(i i0, PlayListAdapter myMusicPlayListEditFragment$PlayListAdapter0) {
        com.iloen.melon.net.v6x.request.DjPlaylistListV6Req.Params djPlaylistListV6Req$Params0 = new com.iloen.melon.net.v6x.request.DjPlaylistListV6Req.Params();
        djPlaylistListV6Req$Params0.startIndex = i.b.equals(i0) ? 1 : myMusicPlayListEditFragment$PlayListAdapter0.getCount() + 1;
        djPlaylistListV6Req$Params0.pageSize = 100;
        djPlaylistListV6Req$Params0.sortBy = "DSP";
        djPlaylistListV6Req$Params0.targetMemberKey = e1.u.v(((e0)o.a()).j());
        djPlaylistListV6Req$Params0.plylstTypeCode = "all";
        djPlaylistListV6Req$Params0.mode = "all";
        RequestBuilder.newInstance(new DjPlaylistListV6Req(this.getContext(), djPlaylistListV6Req$Params0)).tag(this.getRequestTag()).listener(new Y(this, i0, 2)).errorListener(this.mResponseErrorListener).request();
    }

    private static final void requestDjPlayList$lambda$8(MyMusicPlayListEditFragment myMusicPlayListEditFragment0, i i0, DjPlaylistListV6Res djPlaylistListV6Res0) {
        if(myMusicPlayListEditFragment0.prepareFetchComplete(djPlaylistListV6Res0) && (djPlaylistListV6Res0 == null ? null : djPlaylistListV6Res0.response) != null) {
            myMusicPlayListEditFragment0.multiDeleteMax = djPlaylistListV6Res0.response.multiDelMaxCnt;
            myMusicPlayListEditFragment0.performFetchComplete(i0, djPlaylistListV6Res0);
            return;
        }
        myMusicPlayListEditFragment0.showToolbar(false);
    }

    private final void requestPlayList(i i0, PlayListAdapter myMusicPlayListEditFragment$PlayListAdapter0) {
        com.iloen.melon.net.v6x.request.MyMusicPlaylistListV6Req.Params myMusicPlaylistListV6Req$Params0 = new com.iloen.melon.net.v6x.request.MyMusicPlaylistListV6Req.Params();
        myMusicPlaylistListV6Req$Params0.startIndex = i.b.equals(i0) ? 1 : myMusicPlayListEditFragment$PlayListAdapter0.getCount() + 1;
        myMusicPlaylistListV6Req$Params0.pageSize = 100;
        myMusicPlaylistListV6Req$Params0.orderBy = "DSPLY_ORDER";
        myMusicPlaylistListV6Req$Params0.targetMemberKey = e1.u.v(((e0)o.a()).j());
        myMusicPlaylistListV6Req$Params0.plylstTypeCode = "M20001";
        myMusicPlaylistListV6Req$Params0.mode = "all";
        RequestBuilder.newInstance(new MyMusicPlaylistListV6Req(this.getContext(), myMusicPlaylistListV6Req$Params0)).tag(this.getRequestTag()).listener(new Y(this, i0, 1)).errorListener(this.mResponseErrorListener).request();
    }

    private static final void requestPlayList$lambda$6(MyMusicPlayListEditFragment myMusicPlayListEditFragment0, i i0, MyMusicPlaylistListV6Res myMusicPlaylistListV6Res0) {
        if(myMusicPlayListEditFragment0.prepareFetchComplete(myMusicPlaylistListV6Res0) && (myMusicPlaylistListV6Res0 == null ? null : myMusicPlaylistListV6Res0.response) != null) {
            myMusicPlayListEditFragment0.multiDeleteMax = myMusicPlaylistListV6Res0.response.multiDelMaxCnt;
            myMusicPlayListEditFragment0.performFetchComplete(i0, myMusicPlaylistListV6Res0);
            return;
        }
        myMusicPlayListEditFragment0.showToolbar(false);
    }

    private final void revertOrder() {
        if(this.preTo != -1 && this.preFrom != -1) {
            j0 j00 = this.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.MyMusicPlayListEditFragment.PlayListAdapter");
            ((PlayListAdapter)j00).dragNDrop(this.preTo, this.preFrom);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }

    private final void showToolbar(boolean z) {
        l1.B("showToolbar() - show : ", z, LogU.Companion, "MyMusicPlayListEditFragment");
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
}

