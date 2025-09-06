package com.iloen.melon.fragments.local;

import android.content.Context;
import android.database.Cursor;
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
import com.iloen.melon.custom.DetailLinearLayoutManager;
import com.iloen.melon.custom.FilterLayout;
import com.iloen.melon.custom.L;
import com.iloen.melon.custom.S;
import com.iloen.melon.custom.SortingBarView;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.title.TitleBar;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import ob.z;
import oe.e;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\'\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0002HGB\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0014\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000E\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u000E\u0010\fJ!\u0010\u0012\u001A\u00020\n2\u0006\u0010\u0010\u001A\u00020\u000F2\b\u0010\u0011\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001A\u00020\n2\u0006\u0010\u0014\u001A\u00020\u0005H\u0004\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u001F\u0010\u0019\u001A\u00020\n2\u0006\u0010\u0017\u001A\u00020\u00052\u0006\u0010\u0018\u001A\u00020\u0005H\u0004\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u001F\u0010\u001C\u001A\u00020\n2\u0006\u0010\u0017\u001A\u00020\u00052\u0006\u0010\u001B\u001A\u00020\u0005H\u0014\u00A2\u0006\u0004\b\u001C\u0010\u001AJ\u000F\u0010\u001D\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u001D\u0010\u0004J\u001B\u0010!\u001A\u0006\u0012\u0002\b\u00030 2\u0006\u0010\u001F\u001A\u00020\u001EH\u0014\u00A2\u0006\u0004\b!\u0010\"J\u000F\u0010$\u001A\u00020#H\u0014\u00A2\u0006\u0004\b$\u0010%J\u000F\u0010&\u001A\u00020\u000FH\u0014\u00A2\u0006\u0004\b&\u0010\'J\u000F\u0010)\u001A\u00020(H\u0014\u00A2\u0006\u0004\b)\u0010*J\u000F\u0010+\u001A\u00020(H\u0014\u00A2\u0006\u0004\b+\u0010*J\u000F\u0010-\u001A\u00020,H\u0014\u00A2\u0006\u0004\b-\u0010.J\u001F\u00102\u001A\u00020\n2\u0006\u00100\u001A\u00020/2\u0006\u00101\u001A\u00020(H\u0014\u00A2\u0006\u0004\b2\u00103J\u000F\u00104\u001A\u00020\nH\u0014\u00A2\u0006\u0004\b4\u0010\u0004J\u001B\u00108\u001A\u0004\u0018\u0001072\b\u00106\u001A\u0004\u0018\u000105H\u0004\u00A2\u0006\u0004\b8\u00109R\u0018\u0010;\u001A\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010>\u001A\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010@\u001A\u0004\u0018\u00010\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b@\u0010AR\"\u0010B\u001A\u00020\u00058\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\bB\u0010C\u001A\u0004\bD\u0010\u0007\"\u0004\bE\u0010\u0016R\u0014\u0010F\u001A\u00020\u00058BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bF\u0010\u0007\u00A8\u0006I"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentBaseUIFragment;", "Lcom/iloen/melon/fragments/local/LocalContentNewDbBaseFragment;", "Le9/a;", "<init>", "()V", "", "isRecyclerViewBelowTitleBar", "()Z", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/View;", "view", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "isVisible", "setAllCheckButtonVisibility", "(Z)V", "isEditMode", "isExistData", "setEditModeVisibility", "(ZZ)V", "isDoneUserAction", "onEditButtonClick", "onPause", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "buildParallaxHeaderView", "()Landroid/view/View;", "", "getParallaxHeaderHeight", "()I", "getParallaxFixedHeight", "Lcom/iloen/melon/custom/ToolBar;", "buildToolBar", "()Lcom/iloen/melon/custom/ToolBar;", "Lcom/iloen/melon/custom/ToolBar$ToolBarItem;", "item", "itemId", "onToolBarClick", "(Lcom/iloen/melon/custom/ToolBar$ToolBarItem;I)V", "onAddSongsToLocalPlaylist", "Lv9/h;", "param", "Landroid/database/Cursor;", "fetchData", "(Lv9/h;)Landroid/database/Cursor;", "Lcom/iloen/melon/custom/SortingBarView;", "sortingBarView", "Lcom/iloen/melon/custom/SortingBarView;", "Lcom/iloen/melon/custom/FilterLayout;", "filterLayout", "Lcom/iloen/melon/custom/FilterLayout;", "underline", "Landroid/view/View;", "editMode", "Z", "getEditMode", "setEditMode", "isCreateNonSelectorPopup", "Companion", "LocalSongAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class LocalContentBaseUIFragment extends LocalContentNewDbBaseFragment {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentBaseUIFragment$Companion;", "", "<init>", "()V", "TAG", "", "SONG", "", "EDU", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B+\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u0010\u0010\u0007\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0006\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u000E\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\bH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ!\u0010\u0013\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0017\u001A\u00020\u00162\b\u0010\u0015\u001A\u0004\u0018\u00010\u00032\u0006\u0010\f\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001A\u001A\u00020\u00198\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001A\u0010\u001BR\u0016\u0010\t\u001A\u00020\b8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\t\u0010\u001C¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentBaseUIFragment$LocalSongAdapter;", "Lcom/iloen/melon/fragments/local/LocalContentNewDbBaseFragment$LocalContentBaseSongAdapter;", "Lcom/iloen/melon/playback/Playable;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "", "mAdapterType", "<init>", "(Lcom/iloen/melon/fragments/local/LocalContentBaseUIFragment;Landroid/content/Context;Ljava/util/List;I)V", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "", "TAG", "Ljava/lang/String;", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class LocalSongAdapter extends LocalContentBaseSongAdapter {
        @NotNull
        private final String TAG;
        private int mAdapterType;

        public LocalSongAdapter(@Nullable Context context0, @Nullable List list0, int v) {
            super(context0, list0);
            this.TAG = "LocalSongAdapter";
            this.mAdapterType = v;
        }

        public static void c(LocalContentBaseUIFragment localContentBaseUIFragment0, Playable playable0, View view0) {
            LocalSongAdapter.onBindViewImpl$lambda$2(playable0, localContentBaseUIFragment0, view0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.mAdapterType;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            q.e(o00, "null cannot be cast to non-null type com.iloen.melon.viewholders.SongHolder");
            boolean z = true;
            if(this.mAdapterType == 7) {
                ViewUtils.hideWhen(((SongHolder)o00).thumbContainer, true);
                ViewUtils.hideWhen(((SongHolder)o00).chartLayout, true);
            }
            ViewUtils.setOnClickListener(((SongHolder)o00).rootView, new f(LocalContentBaseUIFragment.this, v, 5));
            if(this.isMarked(v1)) {
                ((SongHolder)o00).rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F060199));  // color:list_item_marked
            }
            else {
                ((SongHolder)o00).rootView.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F06048A));  // color:transparent
            }
            Playable playable0 = (Playable)this.getItem(v1);
            ViewUtils.setOnLongClickListener(((SongHolder)o00).rootView, new h(LocalContentBaseUIFragment.this, playable0, 1));
            ViewUtils.hideWhen(((SongHolder)o00).btnPlay, this.isInEditMode());
            ViewUtils.setOnClickListener(((SongHolder)o00).btnPlay, new m(playable0, LocalContentBaseUIFragment.this));
            ViewUtils.hideWhen(((SongHolder)o00).btnInfo, this.isInEditMode());
            ViewUtils.setOnClickListener(((SongHolder)o00).btnInfo, new m(LocalContentBaseUIFragment.this, playable0));
            q.d(playable0);
            int v2 = FilenameUtils.getFileType("");
            ViewUtils.showWhen(((SongHolder)o00).listDcfIv, 0x402 == v2);
            ViewUtils.showWhen(((SongHolder)o00).listFlacTv, 0x202 == v2);
            ImageView imageView0 = ((SongHolder)o00).listMp3Iv;
            if(0x402 == v2 || 0x202 == v2) {
                z = false;
            }
            ViewUtils.showWhen(imageView0, z);
            if(((SongHolder)o00).thumbnailIv != null) {
                boolean z1 = !StorageUtils.isScopedStorage();
                ImageView imageView1 = ((SongHolder)o00).thumbnailIv;
                q.d("");
                LocalContentBaseUIFragment.this.showAlbumImage(imageView1, "", playable0.getMediaStoreAlbumId(), "");
            }
            ((SongHolder)o00).titleTv.setText("");
            ViewUtils.setTextViewMarquee(((SongHolder)o00).titleTv, this.isMarqueeNeeded(v1));
            ((SongHolder)o00).artistTv.setText("");
        }

        private static final void onBindViewImpl$lambda$0(LocalContentBaseUIFragment localContentBaseUIFragment0, int v, View view0) {
            localContentBaseUIFragment0.onItemClick(view0, v);
        }

        private static final boolean onBindViewImpl$lambda$1(LocalContentBaseUIFragment localContentBaseUIFragment0, Playable playable0, View view0) {
            localContentBaseUIFragment0.showMoreContextPopup(playable0);
            return true;
        }

        private static final void onBindViewImpl$lambda$2(Playable playable0, LocalContentBaseUIFragment localContentBaseUIFragment0, View view0) {
            q.d(playable0);
            playable0.setMenuid(localContentBaseUIFragment0.mPlaybackMenuId);
            localContentBaseUIFragment0.playSong(Playable.copyValueOf(playable0), true);
        }

        private static final void onBindViewImpl$lambda$3(LocalContentBaseUIFragment localContentBaseUIFragment0, Playable playable0, View view0) {
            localContentBaseUIFragment0.showMoreContextPopup(playable0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        @Nullable
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            return new SongHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D04A8, viewGroup0, false));  // layout:listitem_song
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    public static final int EDU = 2;
    public static final int SONG = 0;
    @NotNull
    private static final String TAG = "LocalContentBaseUIFragment";
    private boolean editMode;
    @Nullable
    private FilterLayout filterLayout;
    @Nullable
    private SortingBarView sortingBarView;
    @Nullable
    private View underline;

    static {
        LocalContentBaseUIFragment.Companion = new Companion(null);
        LocalContentBaseUIFragment.$stable = 8;
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
        j0 j00 = new LocalSongAdapter(this, this.getContext(), null, 0);
        ((j)j00).setListContentType(1);
        ((j)j00).setMarkedMode(true);
        return j00;
    }

    @Nullable
    public final Cursor fetchData(@Nullable v9.h h0) {
        return null;
    }

    public final boolean getEditMode() {
        return this.editMode;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxFixedHeight() {
        return ScreenUtils.dipToPixel(this.getContext(), 52.0f);
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxHeaderHeight() {
        return this.editMode ? ScreenUtils.dipToPixel(this.getContext(), 52.0f) : ScreenUtils.dipToPixel(this.getContext(), 97.0f);
    }

    private final boolean isCreateNonSelectorPopup() {
        j0 j00 = this.getAdapter();
        if(j00 != null && ((LocalSongAdapter)j00).getMarkedCount() == 0) {
            l0 l00 = this.getChildFragmentManager();
            String s = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
            String s1 = this.getString(0x7F1300A4);  // string:alert_dlg_body_delete_song_select_content "곡을 선택해 주세요."
            b.d(b.a, l00, s, s1, false, false, false, null, null, null, null, null, 2040);
            return true;
        }
        return false;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public boolean isRecyclerViewBelowTitleBar() {
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onAddSongsToLocalPlaylist() {
        if(this.isAdded()) {
            j0 j00 = this.getAdapter();
            if(j00 != null) {
                ((LocalSongAdapter)j00).notifyDataSetChanged();
            }
        }
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
        this.updateParallaxHeaderView();
        boolean z2 = false;
        if(z) {
            if(this.getItemCount() > 0) {
                z2 = true;
            }
            this.setEditModeVisibility(true, z2);
        }
        else if(this.getItemCount() > 0) {
            this.setAllCheckButtonVisibility(true);
        }
        else if(z1) {
            this.performBackPress();
        }
        else {
            this.setAllCheckButtonVisibility(false);
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
    }

    @Override  // com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onToolBarClick(@NotNull ToolBarItem toolBar$ToolBarItem0, int v) {
        q.g(toolBar$ToolBarItem0, "item");
        if(this.getContentAdapter() == null) {
            LogU.Companion.w("LocalContentBaseUIFragment", "onToolBarClick() invalid adapter");
            return;
        }
        if(v == 0) {
            BuildersKt__Builders_commonKt.launch$default(f0.f(this), Dispatchers.getMain(), null, new n(null) {
                int label;

                {
                    LocalContentBaseUIFragment.this = localContentBaseUIFragment0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.fragments.local.LocalContentBaseUIFragment.onToolBarClick.1(LocalContentBaseUIFragment.this, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.fragments.local.LocalContentBaseUIFragment.onToolBarClick.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    a a0 = a.a;
                    switch(this.label) {
                        case 0: {
                            d5.n.D(object0);
                            z z0 = LocalContentBaseUIFragment.this.getPlayerUseCase();
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
                        Bc.h h0 = LocalContentBaseUIFragment.this.getPlayerUiHelper();
                        l0 l00 = LocalContentBaseUIFragment.this.getChildFragmentManager();
                        q.f(l00, "getChildFragmentManager(...)");
                        h0.e(l00, new c(LocalContentBaseUIFragment.this, 2));
                        return H.a;
                    }
                    LocalContentBaseUIFragment.this.playSongs(false, true, false);
                    LocalContentBaseUIFragment.this.setSelectAllWithToolbar(false);
                    return H.a;

                    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
                    @e(c = "com.iloen.melon.fragments.local.LocalContentBaseUIFragment$onToolBarClick$1$1$1", f = "LocalContentBaseUIFragment.kt", l = {0xFE}, m = "invokeSuspend")
                    final class com.iloen.melon.fragments.local.LocalContentBaseUIFragment.onToolBarClick.1.1.1 extends i implements n {
                        int label;

                        public com.iloen.melon.fragments.local.LocalContentBaseUIFragment.onToolBarClick.1.1.1(LocalContentBaseUIFragment localContentBaseUIFragment0, Continuation continuation0) {
                            LocalContentBaseUIFragment.this = localContentBaseUIFragment0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.fragments.local.LocalContentBaseUIFragment.onToolBarClick.1.1.1(LocalContentBaseUIFragment.this, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.fragments.local.LocalContentBaseUIFragment.onToolBarClick.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            a a0 = a.a;
                            switch(this.label) {
                                case 0: {
                                    d5.n.D(object0);
                                    z z0 = LocalContentBaseUIFragment.this.getPlayerUseCase();
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
                            LocalContentBaseUIFragment.this.playSongs(false, true, false);
                            LocalContentBaseUIFragment.this.setSelectAllWithToolbar(false);
                            return H.a;
                        }
                    }

                }

                private static final H invokeSuspend$lambda$0(LocalContentBaseUIFragment localContentBaseUIFragment0) {
                    BuildersKt__Builders_commonKt.launch$default(f0.f(localContentBaseUIFragment0), Dispatchers.getMain(), null, new com.iloen.melon.fragments.local.LocalContentBaseUIFragment.onToolBarClick.1.1.1(localContentBaseUIFragment0, null), 2, null);
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
            titleBar0.a(B.a.s(1));
            titleBar0.setTitle(this.mTitle);
            titleBar0.f(true);
        }
        SortingBarView sortingBarView0 = (SortingBarView)view0.findViewById(0x7F0A0AB8);  // id:sort_bar
        this.sortingBarView = sortingBarView0;
        if(sortingBarView0 != null) {
            ViewUtils.showWhen(sortingBarView0.a, false);
        }
        this.filterLayout = (FilterLayout)view0.findViewById(0x7F0A049E);  // id:filter_layout
        View view1 = view0.findViewById(0x7F0A0D6B);  // id:underline
        this.underline = view1;
        ViewUtils.hideWhen(view1, true);
    }

    public final void setAllCheckButtonVisibility(boolean z) {
        if(!this.isFragmentValid()) {
            return;
        }
        ViewUtils.showWhen(this.sortingBarView, z);
        ViewUtils.showWhen(this.filterLayout, z);
        if(z) {
            FilterLayout filterLayout0 = this.filterLayout;
            q.d(filterLayout0);
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = filterLayout0.getLayoutParams();
            q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams)viewGroup$LayoutParams0).topMargin = 0;
            ((LinearLayout.LayoutParams)viewGroup$LayoutParams0).bottomMargin = ScreenUtils.dipToPixel(this.getContext(), 12.0f);
            FilterLayout filterLayout1 = this.filterLayout;
            q.d(filterLayout1);
            filterLayout1.setLayoutParams(((LinearLayout.LayoutParams)viewGroup$LayoutParams0));
        }
        SortingBarView sortingBarView0 = this.sortingBarView;
        q.d(sortingBarView0);
        l l0 = new l(this, 3);
        sortingBarView0.c(L.f, l0);
        FilterLayout filterLayout2 = this.filterLayout;
        q.d(filterLayout2);
        filterLayout2.setOnCheckedListener(new l(this, 4));
        FilterLayout filterLayout3 = this.filterLayout;
        q.d(filterLayout3);
        l l1 = new l(this, 5);
        filterLayout3.c(L.b, l1);
    }

    private static final void setAllCheckButtonVisibility$lambda$0(LocalContentBaseUIFragment localContentBaseUIFragment0, View view0) {
        localContentBaseUIFragment0.setEditMode(true, localContentBaseUIFragment0.getString(0x7F1304FE, new Object[]{localContentBaseUIFragment0.mTitle}));  // string:local_content_title_edit "%1$s 편집"
    }

    private static final void setAllCheckButtonVisibility$lambda$1(LocalContentBaseUIFragment localContentBaseUIFragment0, S s0, boolean z) {
        localContentBaseUIFragment0.toggleSelectAll();
    }

    private static final void setAllCheckButtonVisibility$lambda$2(LocalContentBaseUIFragment localContentBaseUIFragment0, View view0) {
        if(localContentBaseUIFragment0.mAdapter instanceof LocalSongAdapter) {
            j0 j00 = localContentBaseUIFragment0.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.local.LocalContentBaseUIFragment.LocalSongAdapter");
            localContentBaseUIFragment0.playSongs(new ArrayList(((LocalSongAdapter)j00).getPlayableListForPlay()), true, false, false);
        }
    }

    public final void setEditMode(boolean z) {
        this.editMode = z;
    }

    public final void setEditModeVisibility(boolean z, boolean z1) {
        ViewUtils.hideWhen(this.sortingBarView, z);
        ViewUtils.showWhen(this.filterLayout, z1);
        SortingBarView sortingBarView0 = this.sortingBarView;
        q.d(sortingBarView0);
        l l0 = new l(this, 0);
        sortingBarView0.c(L.f, l0);
        FilterLayout filterLayout0 = this.filterLayout;
        q.d(filterLayout0);
        filterLayout0.setOnCheckedListener(new l(this, 1));
        FilterLayout filterLayout1 = this.filterLayout;
        q.d(filterLayout1);
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = filterLayout1.getLayoutParams();
        q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        if(z) {
            ((LinearLayout.LayoutParams)viewGroup$LayoutParams0).topMargin = ScreenUtils.dipToPixel(this.getContext(), 15.0f);
            ((LinearLayout.LayoutParams)viewGroup$LayoutParams0).bottomMargin = ScreenUtils.dipToPixel(this.getContext(), 6.0f);
            FilterLayout filterLayout2 = this.filterLayout;
            q.d(filterLayout2);
            filterLayout2.setRightLayout(null);
            FilterLayout filterLayout3 = this.filterLayout;
            q.d(filterLayout3);
            filterLayout3.setCheckButtonText(this.getString(0x7F130914));  // string:select_all "전체선택"
        }
        else {
            ((LinearLayout.LayoutParams)viewGroup$LayoutParams0).topMargin = 0;
            ((LinearLayout.LayoutParams)viewGroup$LayoutParams0).bottomMargin = ScreenUtils.dipToPixel(this.getContext(), 12.0f);
            FilterLayout filterLayout4 = this.filterLayout;
            q.d(filterLayout4);
            l l1 = new l(this, 2);
            filterLayout4.c(L.b, l1);
            FilterLayout filterLayout5 = this.filterLayout;
            q.d(filterLayout5);
            filterLayout5.setCheckButtonText("");
        }
        FilterLayout filterLayout6 = this.filterLayout;
        q.d(filterLayout6);
        filterLayout6.setLayoutParams(((LinearLayout.LayoutParams)viewGroup$LayoutParams0));
    }

    private static final void setEditModeVisibility$lambda$3(LocalContentBaseUIFragment localContentBaseUIFragment0, View view0) {
        localContentBaseUIFragment0.setEditMode(true, localContentBaseUIFragment0.getString(0x7F1304FD));  // string:local_content_song_edit "저장한 곡 편집"
    }

    private static final void setEditModeVisibility$lambda$4(LocalContentBaseUIFragment localContentBaseUIFragment0, S s0, boolean z) {
        localContentBaseUIFragment0.toggleSelectAll();
    }

    private static final void setEditModeVisibility$lambda$5(LocalContentBaseUIFragment localContentBaseUIFragment0, View view0) {
        if(localContentBaseUIFragment0.mAdapter instanceof LocalSongAdapter) {
            j0 j00 = localContentBaseUIFragment0.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.local.LocalContentBaseUIFragment.LocalSongAdapter");
            localContentBaseUIFragment0.playSongs(new ArrayList(((LocalSongAdapter)j00).getPlayableListForPlay()), true, false, false);
        }
    }
}

