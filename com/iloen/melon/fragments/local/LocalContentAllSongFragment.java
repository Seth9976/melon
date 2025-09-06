package com.iloen.melon.fragments.local;

import Cc.K1;
import E9.w;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import androidx.fragment.app.l0;
import androidx.lifecycle.f0;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.custom.DetailLinearLayoutManager;
import com.iloen.melon.custom.FilterLayout;
import com.iloen.melon.custom.L;
import com.iloen.melon.custom.S;
import com.iloen.melon.custom.SortingBarView;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.database.core.LocalContentDatabase_Impl;
import com.iloen.melon.net.v4x.request.OrderByPvLogDummyReq.OrderBy;
import com.iloen.melon.net.v4x.request.OrderByPvLogDummyReq;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.FilenameUtils;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.SongHolder;
import com.melon.ui.popup.b;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import ob.z;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.e;
import we.n;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 N2\u00020\u0001:\u0002ONB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b\n\u0010\u000BJ!\u0010\u000F\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\f2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0014\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\u0011H\u0014\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0017\u001A\u00020\u0016H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u000F\u0010\u0019\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u0019\u0010\u0003J\u000F\u0010\u001A\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u001A\u0010\u0003J\u001B\u0010\u001E\u001A\u0006\u0012\u0002\b\u00030\u001D2\u0006\u0010\u001C\u001A\u00020\u001BH\u0014\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u000F\u0010!\u001A\u00020 H\u0014\u00A2\u0006\u0004\b!\u0010\"J\u000F\u0010#\u001A\u00020\fH\u0014\u00A2\u0006\u0004\b#\u0010$J\u000F\u0010%\u001A\u00020\u0016H\u0014\u00A2\u0006\u0004\b%\u0010\u0018J\u000F\u0010&\u001A\u00020\u0016H\u0014\u00A2\u0006\u0004\b&\u0010\u0018J\u000F\u0010(\u001A\u00020\'H\u0014\u00A2\u0006\u0004\b(\u0010)J\u001F\u0010-\u001A\u00020\t2\u0006\u0010+\u001A\u00020*2\u0006\u0010,\u001A\u00020\u0016H\u0014\u00A2\u0006\u0004\b-\u0010.J\u0017\u00100\u001A\u00020\t2\u0006\u0010/\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b0\u00101J\u001F\u00103\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u00102\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b3\u0010\u0015J\u000F\u00104\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b4\u0010\u0003R\u001A\u00106\u001A\u0002058\u0016X\u0096D\u00A2\u0006\f\n\u0004\b6\u00107\u001A\u0004\b8\u00109R\u0014\u0010:\u001A\u00020\u00168\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010<\u001A\u00020\u00168\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b<\u0010;R\u0016\u0010=\u001A\u00020\u00168\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b=\u0010;R\u0018\u0010?\u001A\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010B\u001A\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010D\u001A\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001A\u00020\u00118\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001A\u00020\u00118\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bH\u0010GR\u0016\u0010J\u001A\u00020I8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010L\u001A\u00020\u00118BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bL\u0010M\u00A8\u0006P"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentAllSongFragment;", "Lcom/iloen/melon/fragments/local/LocalContentNewDbBaseFragment;", "<init>", "()V", "Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "getPvDummyLogRequest", "()Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "isEditMode", "isDoneUserAction", "onEditButtonClick", "(ZZ)V", "", "getLocalTrackType", "()I", "onPause", "startQuery", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "buildParallaxHeaderView", "()Landroid/view/View;", "getParallaxHeaderHeight", "getParallaxFixedHeight", "Lcom/iloen/melon/custom/ToolBar;", "buildToolBar", "()Lcom/iloen/melon/custom/ToolBar;", "Lcom/iloen/melon/custom/ToolBar$ToolBarItem;", "item", "itemId", "onToolBarClick", "(Lcom/iloen/melon/custom/ToolBar$ToolBarItem;I)V", "isVisible", "setAllCheckButtonVisibility", "(Z)V", "isExistData", "setEditModeVisibility", "setEdit", "", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "SORT_LASTEST", "I", "SORT_ALPHABETIC", "currentSortIndex", "Lcom/iloen/melon/custom/SortingBarView;", "sortingBarView", "Lcom/iloen/melon/custom/SortingBarView;", "Lcom/iloen/melon/custom/FilterLayout;", "filterLayout", "Lcom/iloen/melon/custom/FilterLayout;", "underline", "Landroid/view/View;", "isSortingBarAndFilterVisible", "Z", "editMode", "Lcom/iloen/melon/net/v4x/request/OrderByPvLogDummyReq$OrderBy;", "orderBy", "Lcom/iloen/melon/net/v4x/request/OrderByPvLogDummyReq$OrderBy;", "isCreateNonSelectorPopup", "()Z", "Companion", "LocalContentAllSongAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LocalContentAllSongFragment extends LocalContentNewDbBaseFragment {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\tH\u0007¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentAllSongFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/local/LocalContentAllSongFragment;", "isFlac", "", "playbackMenuId", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final LocalContentAllSongFragment newInstance(boolean z, @Nullable String s) {
            LocalContentAllSongFragment localContentAllSongFragment0 = new LocalContentAllSongFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putBoolean("argIsFlac", z);
            bundle0.putBoolean("argVisibleWhenActivate", true);
            bundle0.putString("argPlaybackMenuId", s);
            localContentAllSongFragment0.setArguments(bundle0);
            return localContentAllSongFragment0;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B#\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u0010\u0010\u0007\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\r\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0012\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0014\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u0019\u001A\u00020\u00152\b\u0010\u0018\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0019\u0010\u001AR\u0014\u0010\u001B\u001A\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001B\u0010\u001C¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentAllSongFragment$LocalContentAllSongAdapter;", "Lcom/iloen/melon/fragments/local/LocalContentNewDbBaseFragment$LocalContentBaseSongAdapter;", "Lcom/iloen/melon/playback/Playable;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/local/LocalContentAllSongFragment;Landroid/content/Context;Ljava/util/List;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "holder", "Lie/H;", "onViewRecycled", "(Landroidx/recyclerview/widget/O0;)V", "viewHolder", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_SONG", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class LocalContentAllSongAdapter extends LocalContentBaseSongAdapter {
        private final int VIEW_TYPE_SONG;

        public LocalContentAllSongAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
            this.VIEW_TYPE_SONG = 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.VIEW_TYPE_SONG;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            q.e(o00, "null cannot be cast to non-null type com.iloen.melon.viewholders.SongHolder");
            Playable playable0 = (Playable)this.getItem(v1);
            if(playable0 == null) {
                return;
            }
            ViewUtils.setOnClickListener(((SongHolder)o00).rootView, new f(LocalContentAllSongFragment.this, v, 0));
            if(this.isMarked(v1)) {
                ((SongHolder)o00).rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F060199));  // color:list_item_marked
            }
            else {
                ((SongHolder)o00).rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F06048A));  // color:transparent
            }
            ViewUtils.hideWhen(((SongHolder)o00).btnPlay, this.isInEditMode());
            ViewUtils.setOnClickListener(((SongHolder)o00).btnPlay, new g(LocalContentAllSongFragment.this, playable0, 0));
            ViewUtils.hideWhen(((SongHolder)o00).btnInfo, this.isInEditMode());
            int v2 = FilenameUtils.getFileType("");
            boolean z = false;
            ViewUtils.showWhen(((SongHolder)o00).listDcfIv, 0x402 == v2);
            ViewUtils.showWhen(((SongHolder)o00).listFlacTv, 0x202 == v2);
            ImageView imageView0 = ((SongHolder)o00).listMp3Iv;
            if(0x402 != v2 && 0x202 != v2) {
                z = true;
            }
            ViewUtils.showWhen(imageView0, z);
            if(((SongHolder)o00).thumbnailIv != null) {
                long v3 = playable0.getMediaStoreAlbumId();
                if(StorageUtils.isScopedStorage()) {
                    q.d("");
                }
                else {
                    q.d("");
                }
                LocalContentAllSongFragment.this.showAlbumImage(((SongHolder)o00).thumbnailIv, "", v3, "");
            }
            ViewUtils.setOnClickListener(((SongHolder)o00).btnInfo, new g(LocalContentAllSongFragment.this, playable0, 1));
            ViewUtils.setOnLongClickListener(((SongHolder)o00).rootView, new h(LocalContentAllSongFragment.this, playable0, 0));
            ((SongHolder)o00).titleTv.setText("");
            ViewUtils.setTextViewMarquee(((SongHolder)o00).titleTv, this.isMarqueeNeeded(v1));
            ((SongHolder)o00).artistTv.setText("");
        }

        private static final void onBindViewImpl$lambda$0(LocalContentAllSongFragment localContentAllSongFragment0, int v, View view0) {
            localContentAllSongFragment0.onItemClick(view0, v);
        }

        private static final void onBindViewImpl$lambda$1(LocalContentAllSongFragment localContentAllSongFragment0, Playable playable0, View view0) {
            localContentAllSongFragment0.playSong(Playable.copyValueOf(playable0), true);
        }

        private static final void onBindViewImpl$lambda$2(LocalContentAllSongFragment localContentAllSongFragment0, Playable playable0, View view0) {
            localContentAllSongFragment0.showMoreContextPopup(playable0);
        }

        private static final boolean onBindViewImpl$lambda$3(LocalContentAllSongFragment localContentAllSongFragment0, Playable playable0, View view0) {
            localContentAllSongFragment0.showMoreContextPopup(playable0);
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            return new SongHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D04A8, viewGroup0, false));  // layout:listitem_song
        }

        @Override  // androidx.recyclerview.widget.j0
        public void onViewRecycled(@NotNull O0 o00) {
            q.g(o00, "holder");
            super.onViewRecycled(o00);
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    private final int SORT_ALPHABETIC;
    private final int SORT_LASTEST;
    @NotNull
    private final String TAG;
    private int currentSortIndex;
    private boolean editMode;
    @Nullable
    private FilterLayout filterLayout;
    private boolean isSortingBarAndFilterVisible;
    @NotNull
    private OrderBy orderBy;
    @Nullable
    private SortingBarView sortingBarView;
    @Nullable
    private View underline;

    static {
        LocalContentAllSongFragment.Companion = new Companion(null);
        LocalContentAllSongFragment.$stable = 8;
    }

    public LocalContentAllSongFragment() {
        this.TAG = "LocalContentAllSongFragment";
        this.SORT_ALPHABETIC = 1;
        this.currentSortIndex = this.SORT_LASTEST;
        this.orderBy = OrderBy.DOWNLOAD;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    @NotNull
    public View buildParallaxHeaderView() {
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D084E, null, false);  // layout:sortbar_barefilter_standalone
        q.f(view0, "inflate(...)");
        return view0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public ToolBar buildToolBar() {
        View view0 = this.findViewById(0x7F0A0BC6);  // id:toolbar_layout
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.ToolBar");
        ToolBar toolBar0 = ToolBar.f(((ToolBar)view0), 102);
        q.f(toolBar0, "initLayoutType(...)");
        return toolBar0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new LocalContentAllSongAdapter(this, this.getContext(), null);
        ((j)j00).setListContentType(1);
        ((j)j00).setMarkedMode(true);
        String s = this.getString(0x7F130500);  // string:local_empty_song "저장한 곡 목록이 없습니다."
        q.f(s, "getString(...)");
        if(this.mIsFlac) {
            s = this.getString(0x7F1304FF);  // string:local_empty_flac "저장한 FLAC 목록이 없습니다."
            q.f(s, "getString(...)");
        }
        e e0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        e0.d = -1;
        e0.e = -1;
        e0.g = -1;
        e0.i = -1;
        e0.k = -1;
        e0.l = -1;
        e0.f = s;
        ((p)j00).setEmptyViewInfo(e0);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment
    public int getLocalTrackType() {
        return 0;
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxFixedHeight() {
        return this.isSortingBarAndFilterVisible ? ScreenUtils.dipToPixel(this.getContext(), 51.0f) : 0;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxHeaderHeight() {
        if(this.isSortingBarAndFilterVisible) {
            return this.editMode ? ScreenUtils.dipToPixel(this.getContext(), 51.0f) : ScreenUtils.dipToPixel(this.getContext(), 97.0f);
        }
        return 0;
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    @NotNull
    public PvLogDummyReq getPvDummyLogRequest() {
        return this.mIsFlac ? new OrderByPvLogDummyReq(this.getContext(), "storageboxSaveFlacAll", this.orderBy) : new OrderByPvLogDummyReq(this.getContext(), "storageboxSaveSongAll", this.orderBy);
    }

    @Override  // com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment
    @NotNull
    public String getTAG() {
        return this.TAG;
    }

    private final boolean isCreateNonSelectorPopup() {
        j0 j00 = this.getAdapter();
        q.f(j00, "getAdapter(...)");
        if(j00 instanceof LocalContentAllSongAdapter && ((LocalContentAllSongAdapter)j00).getMarkedCount() == 0) {
            String s = this.getString(0x7F1300A4);  // string:alert_dlg_body_delete_song_select_content "곡을 선택해 주세요."
            q.f(s, "getString(...)");
            l0 l00 = this.getChildFragmentManager();
            String s1 = this.getString(0x7F1300CD);  // string:alert_dlg_title_delete_confirm "안내"
            b.d(b.a, l00, s1, s, false, false, false, null, null, null, null, null, 2040);
            return true;
        }
        return false;
    }

    @NotNull
    public static final LocalContentAllSongFragment newInstance(boolean z, @Nullable String s) {
        return LocalContentAllSongFragment.Companion.newInstance(z, s);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setLayoutManager(new DetailLinearLayoutManager(this.getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onEditButtonClick(boolean z, boolean z1) {
        this.editMode = z;
        boolean z2 = false;
        if(z) {
            if(this.getItemCount() > 0) {
                z2 = true;
            }
            this.setEditModeVisibility(true, z2);
        }
        else {
            if(this.getItemCount() > 0) {
                z2 = true;
            }
            this.setAllCheckButtonVisibility(z2);
        }
        ToolBar.c(this.mToolBar, (z ? 507 : 102));
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onPause() {
        super.onPause();
        this.setSelectAllWithToolbar(false);
    }

    @Override  // com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        super.onRestoreInstanceState(bundle0);
        this.mIsFlac = bundle0.getBoolean("argIsFlac");
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onToolBarClick(@NotNull ToolBarItem toolBar$ToolBarItem0, int v) {
        q.g(toolBar$ToolBarItem0, "item");
        if(this.getContentAdapter() == null) {
            LogU.Companion.w(this.getTAG(), "onToolBarClick() invalid adapter");
            return;
        }
        if(v == 0) {
            BuildersKt__Builders_commonKt.launch$default(f0.f(this), Dispatchers.getMain(), null, new n(null) {
                int label;

                {
                    LocalContentAllSongFragment.this = localContentAllSongFragment0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.fragments.local.LocalContentAllSongFragment.onToolBarClick.1(LocalContentAllSongFragment.this, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.fragments.local.LocalContentAllSongFragment.onToolBarClick.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    a a0 = a.a;
                    switch(this.label) {
                        case 0: {
                            d5.n.D(object0);
                            z z0 = LocalContentAllSongFragment.this.getPlayerUseCase();
                            this.label = 1;
                            object0 = z0.o(this);
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
                    if(((Boolean)object0).booleanValue()) {
                        Bc.h h0 = LocalContentAllSongFragment.this.getPlayerUiHelper();
                        l0 l00 = LocalContentAllSongFragment.this.getChildFragmentManager();
                        q.f(l00, "getChildFragmentManager(...)");
                        h0.e(l00, new c(LocalContentAllSongFragment.this, 1));
                        return H.a;
                    }
                    LocalContentAllSongFragment.this.playSongs(false, true, false);
                    LocalContentAllSongFragment.this.setSelectAllWithToolbar(false);
                    return H.a;

                    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
                    @oe.e(c = "com.iloen.melon.fragments.local.LocalContentAllSongFragment$onToolBarClick$1$1$1", f = "LocalContentAllSongFragment.kt", l = {324}, m = "invokeSuspend")
                    final class com.iloen.melon.fragments.local.LocalContentAllSongFragment.onToolBarClick.1.1.1 extends i implements n {
                        int label;

                        public com.iloen.melon.fragments.local.LocalContentAllSongFragment.onToolBarClick.1.1.1(LocalContentAllSongFragment localContentAllSongFragment0, Continuation continuation0) {
                            LocalContentAllSongFragment.this = localContentAllSongFragment0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.fragments.local.LocalContentAllSongFragment.onToolBarClick.1.1.1(LocalContentAllSongFragment.this, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.fragments.local.LocalContentAllSongFragment.onToolBarClick.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            a a0 = a.a;
                            switch(this.label) {
                                case 0: {
                                    d5.n.D(object0);
                                    z z0 = LocalContentAllSongFragment.this.getPlayerUseCase();
                                    this.label = 1;
                                    if(z0.b(0x7F13090F, this) == a0) {  // string:section_repeat_mode_release_toast "반복재생이 해제되었습니다.\n반복재생은 재생 목록에서 재설정 가능합니다."
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
                            LocalContentAllSongFragment.this.playSongs(false, true, false);
                            LocalContentAllSongFragment.this.setSelectAllWithToolbar(false);
                            return H.a;
                        }
                    }

                }

                private static final H invokeSuspend$lambda$0(LocalContentAllSongFragment localContentAllSongFragment0) {
                    BuildersKt__Builders_commonKt.launch$default(f0.f(localContentAllSongFragment0), Dispatchers.getMain(), null, new com.iloen.melon.fragments.local.LocalContentAllSongFragment.onToolBarClick.1.1.1(localContentAllSongFragment0, null), 2, null);
                    return H.a;
                }
            }, 2, null);
            return;
        }
        if(2 == v) {
            this.showTrackAddToLocalPlaylistPopup("담기");
            return;
        }
        if(16 == v && !this.isCreateNonSelectorPopup()) {
            this.setDelType(1);
            this.showDeleteConfirmPopup(false);
        }
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.setVisibility(8);
        }
        View view1 = this.findViewById(0x7F0A0AB8);  // id:sort_bar
        q.e(view1, "null cannot be cast to non-null type com.iloen.melon.custom.SortingBarView");
        this.sortingBarView = (SortingBarView)view1;
        ((SortingBarView)view1).setButtonWidth(ScreenUtils.dipToPixel(((SortingBarView)view1).getContext(), 110.0f));
        ((SortingBarView)view1).setItems(((SortingBarView)view1).getResources().getStringArray(0x7F030030));  // array:sorting_bar_local_song
        ((SortingBarView)view1).setSelection(this.currentSortIndex);
        ((SortingBarView)view1).setOnSortSelectionListener(new com.iloen.melon.fragments.local.e(this, 3));
        View view2 = view0.findViewById(0x7F0A049E);  // id:filter_layout
        q.e(view2, "null cannot be cast to non-null type com.iloen.melon.custom.FilterLayout");
        this.filterLayout = (FilterLayout)view2;
        View view3 = view0.findViewById(0x7F0A0D6B);  // id:underline
        this.underline = view3;
        boolean z = true;
        ViewUtils.hideWhen(view3, true);
        if(this.editMode) {
            if(this.getItemCount() <= 0) {
                z = false;
            }
            this.setEditModeVisibility(true, z);
            return;
        }
        if(this.getItemCount() <= 0) {
            z = false;
        }
        this.setAllCheckButtonVisibility(z);
    }

    private static final void onViewCreated$lambda$1$lambda$0(LocalContentAllSongFragment localContentAllSongFragment0, int v) {
        if(localContentAllSongFragment0.currentSortIndex == v) {
            return;
        }
        localContentAllSongFragment0.currentSortIndex = v;
        localContentAllSongFragment0.orderBy = v == localContentAllSongFragment0.SORT_LASTEST ? OrderBy.DOWNLOAD : OrderBy.KOREAN;
        localContentAllSongFragment0.performPvDummyLog(localContentAllSongFragment0.getPvDummyLogRequest());
        localContentAllSongFragment0.startFetch("filter change");
    }

    private final void setAllCheckButtonVisibility(boolean z) {
        if(!this.isFragmentValid()) {
            LogU.Companion.d(this.getTAG(), "setAllCheckButtonVisibility invaild fragment");
            return;
        }
        SortingBarView sortingBarView0 = this.sortingBarView;
        if(sortingBarView0 != null && this.filterLayout != null && this.underline != null) {
            this.isSortingBarAndFilterVisible = z;
            ViewUtils.showWhen(sortingBarView0, z);
            ViewUtils.showWhen(this.filterLayout, z);
            if(z) {
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.filterLayout == null ? null : this.filterLayout.getLayoutParams();
                q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                ((LinearLayout.LayoutParams)viewGroup$LayoutParams0).topMargin = 0;
                ((LinearLayout.LayoutParams)viewGroup$LayoutParams0).bottomMargin = ScreenUtils.dipToPixel(this.getContext(), 12.0f);
                FilterLayout filterLayout0 = this.filterLayout;
                if(filterLayout0 != null) {
                    filterLayout0.setLayoutParams(((LinearLayout.LayoutParams)viewGroup$LayoutParams0));
                }
            }
            SortingBarView sortingBarView1 = this.sortingBarView;
            if(sortingBarView1 != null) {
                com.iloen.melon.fragments.local.e e0 = new com.iloen.melon.fragments.local.e(this, 4);
                sortingBarView1.c(L.f, e0);
            }
            FilterLayout filterLayout1 = this.filterLayout;
            if(filterLayout1 != null) {
                filterLayout1.setOnCheckedListener(new com.iloen.melon.fragments.local.e(this, 5));
                com.iloen.melon.fragments.local.e e1 = new com.iloen.melon.fragments.local.e(this, 6);
                filterLayout1.c(L.b, e1);
            }
            this.updateParallaxHeaderView();
            return;
        }
        LogU.Companion.d(this.getTAG(), "setAllCheckButtonVisibility invaild view");
    }

    private static final void setAllCheckButtonVisibility$lambda$2(LocalContentAllSongFragment localContentAllSongFragment0, View view0) {
        localContentAllSongFragment0.setEdit();
    }

    private static final void setAllCheckButtonVisibility$lambda$6$lambda$3(LocalContentAllSongFragment localContentAllSongFragment0, S s0, boolean z) {
        localContentAllSongFragment0.toggleSelectAll();
    }

    private static final void setAllCheckButtonVisibility$lambda$6$lambda$5(LocalContentAllSongFragment localContentAllSongFragment0, View view0) {
        j0 j00 = localContentAllSongFragment0.mAdapter;
        if(j00 != null && j00 instanceof LocalContentAllSongAdapter) {
            localContentAllSongFragment0.playSongs(new ArrayList(((LocalContentAllSongAdapter)j00).getPlayableListForPlay()), true, false, false);
        }
    }

    private final void setEdit() {
        String s = this.getString(0x7F1304FD);  // string:local_content_song_edit "저장한 곡 편집"
        q.f(s, "getString(...)");
        if(this.mIsFlac) {
            s = this.getString(0x7F1304FB);  // string:local_content_flac_edit "저장한 FLAC 편집"
            q.f(s, "getString(...)");
        }
        this.setEditMode(true, s);
    }

    private final void setEditModeVisibility(boolean z, boolean z1) {
        if(!this.isFragmentValid()) {
            LogU.Companion.d(this.getTAG(), "setEditModeVisibility invaild fragment");
            return;
        }
        SortingBarView sortingBarView0 = this.sortingBarView;
        if(sortingBarView0 != null && this.filterLayout != null && this.underline != null) {
            this.isSortingBarAndFilterVisible = z || z1;
            ViewUtils.hideWhen(sortingBarView0, z);
            ViewUtils.showWhen(this.filterLayout, z1);
            SortingBarView sortingBarView1 = this.sortingBarView;
            if(sortingBarView1 != null) {
                com.iloen.melon.fragments.local.e e0 = new com.iloen.melon.fragments.local.e(this, 0);
                sortingBarView1.c(L.f, e0);
            }
            FilterLayout filterLayout0 = this.filterLayout;
            if(filterLayout0 != null) {
                filterLayout0.setOnCheckedListener(new com.iloen.melon.fragments.local.e(this, 1));
            }
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.filterLayout == null ? null : this.filterLayout.getLayoutParams();
            q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            if(z) {
                ((LinearLayout.LayoutParams)viewGroup$LayoutParams0).topMargin = ScreenUtils.dipToPixel(this.getContext(), 15.0f);
                ((LinearLayout.LayoutParams)viewGroup$LayoutParams0).bottomMargin = ScreenUtils.dipToPixel(this.getContext(), 6.0f);
                FilterLayout filterLayout1 = this.filterLayout;
                if(filterLayout1 != null) {
                    filterLayout1.setRightLayout(null);
                }
                FilterLayout filterLayout2 = this.filterLayout;
                if(filterLayout2 != null) {
                    filterLayout2.setCheckButtonText(this.getString(0x7F130914));  // string:select_all "전체선택"
                }
            }
            else {
                ((LinearLayout.LayoutParams)viewGroup$LayoutParams0).topMargin = 0;
                ((LinearLayout.LayoutParams)viewGroup$LayoutParams0).bottomMargin = ScreenUtils.dipToPixel(this.getContext(), 12.0f);
                FilterLayout filterLayout3 = this.filterLayout;
                if(filterLayout3 != null) {
                    com.iloen.melon.fragments.local.e e1 = new com.iloen.melon.fragments.local.e(this, 2);
                    filterLayout3.c(L.b, e1);
                }
                FilterLayout filterLayout4 = this.filterLayout;
                if(filterLayout4 != null) {
                    filterLayout4.setCheckButtonText("");
                }
            }
            FilterLayout filterLayout5 = this.filterLayout;
            if(filterLayout5 != null) {
                filterLayout5.setLayoutParams(((LinearLayout.LayoutParams)viewGroup$LayoutParams0));
            }
            this.updateParallaxHeaderView();
            return;
        }
        LogU.Companion.d(this.getTAG(), "setEditModeVisibility invaild view");
    }

    private static final void setEditModeVisibility$lambda$10(LocalContentAllSongFragment localContentAllSongFragment0, View view0) {
        j0 j00 = localContentAllSongFragment0.mAdapter;
        if(j00 != null && j00 instanceof LocalContentAllSongAdapter) {
            localContentAllSongFragment0.playSongs(new ArrayList(((LocalContentAllSongAdapter)j00).getPlayableListForPlay()), true, true, false);
        }
    }

    private static final void setEditModeVisibility$lambda$7(LocalContentAllSongFragment localContentAllSongFragment0, View view0) {
        localContentAllSongFragment0.setEdit();
    }

    private static final void setEditModeVisibility$lambda$8(LocalContentAllSongFragment localContentAllSongFragment0, S s0, boolean z) {
        localContentAllSongFragment0.toggleSelectAll();
    }

    @Override  // com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment
    public void startQuery() {
        LogU.Companion.d(this.getTAG(), "startQuery");
        f0.f(this).b(new n(null) {
            int I$0;
            Object L$0;
            int label;

            {
                LocalContentAllSongFragment.this = localContentAllSongFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalContentAllSongFragment.startQuery.1(LocalContentAllSongFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalContentAllSongFragment.startQuery.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                int v;
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        View view0 = LocalContentAllSongFragment.this.mEmptyView;
                        v = 0;
                        if(view0 != null) {
                            view0.setVisibility(0);
                        }
                        if(LocalContentAllSongFragment.this.orderBy != OrderBy.DOWNLOAD) {
                            v = 1;
                        }
                        com.iloen.melon.fragments.local.LocalContentAllSongFragment.startQuery.1.playableList.1 localContentAllSongFragment$startQuery$1$playableList$10 = new n(((boolean)v), null) {
                            final boolean $isAlphabetOrder;
                            int label;

                            {
                                LocalContentAllSongFragment.this = localContentAllSongFragment0;
                                this.$isAlphabetOrder = z;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.local.LocalContentAllSongFragment.startQuery.1.playableList.1(LocalContentAllSongFragment.this, this.$isAlphabetOrder, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.local.LocalContentAllSongFragment.startQuery.1.playableList.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                List list0;
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                z6.f f0 = G8.g.a;
                                if(!LocalContentAllSongFragment.this.mIsFlac) {
                                    if(this.$isAlphabetOrder) {
                                        f0.m();
                                        list0 = (List)w.N(((LocalContentDatabase_Impl)G8.g.g().b), true, false, new K1(28));
                                    }
                                    else {
                                        f0.m();
                                        list0 = (List)w.N(((LocalContentDatabase_Impl)G8.g.g().b), true, false, new K1(13));
                                    }
                                }
                                else if(this.$isAlphabetOrder) {
                                    f0.m();
                                    list0 = (List)w.N(((LocalContentDatabase_Impl)G8.g.g().b), true, false, new K1(20));
                                }
                                else {
                                    f0.m();
                                    list0 = (List)w.N(((LocalContentDatabase_Impl)G8.g.g().b), true, false, new K1(14));
                                }
                                f0.m();
                                String s = LocalContentAllSongFragment.this.mPlaybackMenuId;
                                q.f(s, "access$getMPlaybackMenuId$p$s-1843995080(...)");
                                return G8.g.i(s, list0);
                            }
                        };
                        this.I$0 = v;
                        this.label = 1;
                        object0 = BuildersKt.withContext(Dispatchers.getIO(), localContentAllSongFragment$startQuery$1$playableList$10, this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        v = this.I$0;
                        d5.n.D(object0);
                        break;
                    }
                    case 2: {
                        List list0 = (List)this.L$0;
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                com.iloen.melon.fragments.local.LocalContentAllSongFragment.startQuery.1.1 localContentAllSongFragment$startQuery$1$10 = new n(((List)object0), null) {
                    final List $playableList;
                    int label;

                    {
                        LocalContentAllSongFragment.this = localContentAllSongFragment0;
                        this.$playableList = list0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.fragments.local.LocalContentAllSongFragment.startQuery.1.1(LocalContentAllSongFragment.this, this.$playableList, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.fragments.local.LocalContentAllSongFragment.startQuery.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        if(this.label != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        d5.n.D(object0);
                        j0 j00 = LocalContentAllSongFragment.this.mAdapter;
                        if(j00 != null) {
                            LocalContentAllSongFragment localContentAllSongFragment0 = LocalContentAllSongFragment.this;
                            List list0 = this.$playableList;
                            if(j00 instanceof LocalContentAllSongAdapter) {
                                localContentAllSongFragment0.setSelectAllWithToolbar(false);
                                ((LocalContentAllSongAdapter)j00).clear();
                                ((LocalContentAllSongAdapter)j00).addAll(list0);
                                localContentAllSongFragment0.setAllCheckButtonVisibility(true);
                                localContentAllSongFragment0.performFetchCompleteOnlyViews();
                            }
                        }
                        boolean z = this.$playableList.isEmpty();
                        if(LocalContentAllSongFragment.this.editMode) {
                            LocalContentAllSongFragment.this.setEditModeVisibility(LocalContentAllSongFragment.this.editMode, !z);
                            return H.a;
                        }
                        LocalContentAllSongFragment.this.setAllCheckButtonVisibility(!z);
                        return H.a;
                    }
                };
                this.L$0 = null;
                this.I$0 = v;
                this.label = 2;
                return BuildersKt.withContext(LocalContentAllSongFragment.this.getMainDispatcher(), localContentAllSongFragment$startQuery$1$10, this) == a0 ? a0 : H.a;
            }
        });
    }
}

