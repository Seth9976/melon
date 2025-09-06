package com.iloen.melon.fragments.local;

import Ac.g;
import E9.w;
import F8.B;
import F8.m;
import F8.o;
import G8.i;
import H8.t;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.l0;
import androidx.lifecycle.f0;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonLimits.TextLimit;
import com.iloen.melon.custom.DetailLinearLayoutManager;
import com.iloen.melon.custom.FilterLayout;
import com.iloen.melon.custom.MelonEditText;
import com.iloen.melon.custom.S;
import com.iloen.melon.custom.ToolBar.ToolBarItem;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.database.core.LocalPlaylistDatabase_Impl;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.FilenameUtils;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.dragdrop.MelonItemTouchHelper.ItemMoveListener;
import com.iloen.melon.utils.dragdrop.MelonItemTouchHelper;
import com.iloen.melon.utils.dragdrop.scroll.ScrollStrategyBase.ScrollSpeed;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.MusicUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.InputMethodUtils;
import com.iloen.melon.utils.ui.ViewUtils;
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
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.e;
import we.n;

@Metadata(d1 = {"\u0000\u008A\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 C2\u00020\u0001:\u0002CDB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\u0007\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0007\u0010\u0006J!\u0010\r\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0016\u00A2\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u000F\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0003J\u000F\u0010\u0011\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0003J\u001B\u0010\u0017\u001A\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010\u0015\u001A\u00020\u0014H\u0014\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u000F\u0010\u001A\u001A\u00020\u0019H\u0014\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0011\u0010\u001C\u001A\u0004\u0018\u00010\bH\u0014\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u000F\u0010\u001E\u001A\u00020\u0010H\u0014\u00A2\u0006\u0004\b\u001E\u0010\u0012J\u000F\u0010\u001F\u001A\u00020\u0010H\u0014\u00A2\u0006\u0004\b\u001F\u0010\u0012J\u0011\u0010!\u001A\u0004\u0018\u00010 H\u0014\u00A2\u0006\u0004\b!\u0010\"J!\u0010&\u001A\u00020\f2\b\u0010$\u001A\u0004\u0018\u00010#2\u0006\u0010%\u001A\u00020\u0010H\u0014\u00A2\u0006\u0004\b&\u0010\'J\u0017\u0010)\u001A\u00020\f2\u0006\u0010(\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b)\u0010*J\u000F\u0010+\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b+\u0010\u0006J\u0017\u0010.\u001A\u00020\u00042\u0006\u0010-\u001A\u00020,H\u0002\u00A2\u0006\u0004\b.\u0010/J\u000F\u00100\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b0\u0010\u0006R\u0016\u00102\u001A\u0002018\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001A\u0002048\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b5\u00106R\u0018\u00107\u001A\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010:\u001A\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001A\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b=\u0010>R\u001E\u0010A\u001A\n\u0012\u0004\u0012\u00020@\u0018\u00010?8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bA\u0010B\u00A8\u0006E"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalPlaylistDetailEditFragment;", "Lcom/iloen/melon/fragments/local/LocalContentNewDbBaseFragment;", "<init>", "()V", "", "shouldShowMiniPlayer", "()Z", "isRecyclerViewBelowTitleBar", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onPause", "", "getLocalTrackType", "()I", "startQuery", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "buildParallaxHeaderView", "()Landroid/view/View;", "getParallaxHeaderHeight", "getParallaxFixedHeight", "Lcom/iloen/melon/custom/ToolBar;", "buildToolBar", "()Lcom/iloen/melon/custom/ToolBar;", "Lcom/iloen/melon/custom/ToolBar$ToolBarItem;", "item", "itemId", "onToolBarClick", "(Lcom/iloen/melon/custom/ToolBar$ToolBarItem;I)V", "isVisible", "setAllCheckButtonVisibility", "(Z)V", "checkIfPossibleEdit", "", "playlistName", "isAlreadyExistPlaylist", "(Ljava/lang/String;)Z", "isCreateNonSelectorPopup", "Lcom/iloen/melon/utils/dragdrop/MelonItemTouchHelper;", "melonItemTouchHelper", "Lcom/iloen/melon/utils/dragdrop/MelonItemTouchHelper;", "Lcom/iloen/melon/custom/FilterLayout;", "filterLayout", "Lcom/iloen/melon/custom/FilterLayout;", "modifyPlaylistLayout", "Landroid/view/View;", "Lcom/iloen/melon/custom/MelonEditText;", "inputEt", "Lcom/iloen/melon/custom/MelonEditText;", "Landroid/widget/ImageView;", "clearIv", "Landroid/widget/ImageView;", "", "LH8/t;", "localPlaylistSongs", "Ljava/util/List;", "Companion", "LocalPlaylistDetailSongAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LocalPlaylistDetailEditFragment extends LocalContentNewDbBaseFragment {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalPlaylistDetailEditFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/local/LocalPlaylistDetailEditFragment;", "playlistId", "", "playlistName", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final LocalPlaylistDetailEditFragment newInstance(long v, @NotNull String s) {
            q.g(s, "playlistName");
            LocalPlaylistDetailEditFragment localPlaylistDetailEditFragment0 = new LocalPlaylistDetailEditFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putLong("playlistid", v);
            bundle0.putString("playlistname", s);
            localPlaylistDetailEditFragment0.setArguments(bundle0);
            return localPlaylistDetailEditFragment0;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u0011\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\u000B\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\bH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\u0010\u001A\u00020\u00032\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0014\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u00032\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001A\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalPlaylistDetailEditFragment$LocalPlaylistDetailSongAdapter;", "Lcom/iloen/melon/fragments/local/LocalContentNewDbBaseFragment$LocalContentBaseSongAdapter;", "Lcom/iloen/melon/playback/Playable;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "<init>", "(Lcom/iloen/melon/fragments/local/LocalPlaylistDetailEditFragment;Landroid/content/Context;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "PLAYLIST", "I", "ViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class LocalPlaylistDetailSongAdapter extends LocalContentBaseSongAdapter {
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0019\u0010\u000B\u001A\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u000B\u0010\b\u001A\u0004\b\f\u0010\nR\u0017\u0010\r\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\b\u001A\u0004\b\u000E\u0010\nR\u0017\u0010\u000F\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000F\u0010\b\u001A\u0004\b\u0010\u0010\nR\u0017\u0010\u0012\u001A\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001A\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001A\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0018\u001A\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001A\u0004\b\u0019\u0010\u0015R\u0017\u0010\u001A\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001A\u0010\b\u001A\u0004\b\u001B\u0010\nR\u0017\u0010\u001C\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001C\u0010\b\u001A\u0004\b\u001D\u0010\nR\u0017\u0010\u001E\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001E\u0010\b\u001A\u0004\b\u001F\u0010\n¨\u0006 "}, d2 = {"Lcom/iloen/melon/fragments/local/LocalPlaylistDetailEditFragment$LocalPlaylistDetailSongAdapter$ViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/local/LocalPlaylistDetailEditFragment$LocalPlaylistDetailSongAdapter;Landroid/view/View;)V", "Landroid/widget/ImageView;", "defaultThumbnail", "Landroid/widget/ImageView;", "getDefaultThumbnail", "()Landroid/widget/ImageView;", "thumbnail", "getThumbnail", "listDcf", "getListDcf", "listMp3", "getListMp3", "Landroid/widget/TextView;", "listFlac", "Landroid/widget/TextView;", "getListFlac", "()Landroid/widget/TextView;", "titleText", "getTitleText", "artistText", "getArtistText", "moveImage", "getMoveImage", "btnPlay", "getBtnPlay", "btnInfo", "getBtnInfo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ViewHolder extends O0 {
            @NotNull
            private final TextView artistText;
            @NotNull
            private final ImageView btnInfo;
            @NotNull
            private final ImageView btnPlay;
            @NotNull
            private final ImageView defaultThumbnail;
            @NotNull
            private final ImageView listDcf;
            @NotNull
            private final TextView listFlac;
            @NotNull
            private final ImageView listMp3;
            @NotNull
            private final ImageView moveImage;
            @Nullable
            private final ImageView thumbnail;
            @NotNull
            private final TextView titleText;

            public ViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                LocalPlaylistDetailSongAdapter.this = localPlaylistDetailEditFragment$LocalPlaylistDetailSongAdapter0;
                super(view0);
                Context context0 = view0.getContext();
                View view1 = view0.findViewById(0x7F0A069E);  // id:iv_thumb_default
                q.f(view1, "findViewById(...)");
                this.defaultThumbnail = (ImageView)view1;
                ViewUtils.setDefaultImage(((ImageView)view1), ScreenUtils.dipToPixel(context0, 48.0f));
                this.thumbnail = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
                View view2 = view0.findViewById(0x7F0A063E);  // id:iv_list_dcf
                q.f(view2, "findViewById(...)");
                this.listDcf = (ImageView)view2;
                View view3 = view0.findViewById(0x7F0A0643);  // id:iv_list_mp3
                q.f(view3, "findViewById(...)");
                this.listMp3 = (ImageView)view3;
                View view4 = view0.findViewById(0x7F0A063F);  // id:iv_list_flac
                q.f(view4, "findViewById(...)");
                this.listFlac = (TextView)view4;
                View view5 = view0.findViewById(0x7F0A0D34);  // id:tv_title
                q.f(view5, "findViewById(...)");
                this.titleText = (TextView)view5;
                View view6 = view0.findViewById(0x7F0A0C12);  // id:tv_artist
                q.f(view6, "findViewById(...)");
                this.artistText = (TextView)view6;
                View view7 = view0.findViewById(0x7F0A0651);  // id:iv_move
                q.f(view7, "findViewById(...)");
                this.moveImage = (ImageView)view7;
                View view8 = view0.findViewById(0x7F0A0182);  // id:btn_play
                q.f(view8, "findViewById(...)");
                this.btnPlay = (ImageView)view8;
                View view9 = view0.findViewById(0x7F0A0169);  // id:btn_info
                q.f(view9, "findViewById(...)");
                this.btnInfo = (ImageView)view9;
            }

            @NotNull
            public final TextView getArtistText() {
                return this.artistText;
            }

            @NotNull
            public final ImageView getBtnInfo() {
                return this.btnInfo;
            }

            @NotNull
            public final ImageView getBtnPlay() {
                return this.btnPlay;
            }

            @NotNull
            public final ImageView getDefaultThumbnail() {
                return this.defaultThumbnail;
            }

            @NotNull
            public final ImageView getListDcf() {
                return this.listDcf;
            }

            @NotNull
            public final TextView getListFlac() {
                return this.listFlac;
            }

            @NotNull
            public final ImageView getListMp3() {
                return this.listMp3;
            }

            @NotNull
            public final ImageView getMoveImage() {
                return this.moveImage;
            }

            @Nullable
            public final ImageView getThumbnail() {
                return this.thumbnail;
            }

            @NotNull
            public final TextView getTitleText() {
                return this.titleText;
            }
        }

        private final int PLAYLIST;

        public LocalPlaylistDetailSongAdapter(@Nullable Context context0) {
            super(context0, null);
            this.PLAYLIST = 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.PLAYLIST;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            q.e(o00, "null cannot be cast to non-null type com.iloen.melon.fragments.local.LocalPlaylistDetailEditFragment.LocalPlaylistDetailSongAdapter.ViewHolder");
            f f0 = new f(LocalPlaylistDetailEditFragment.this, v, 4);
            ViewUtils.setOnClickListener(((ViewHolder)o00).itemView, f0);
            if(this.isMarked(v1)) {
                int v2 = ColorUtils.getColor(this.getContext(), 0x7F060199);  // color:list_item_marked
                ((ViewHolder)o00).itemView.setBackgroundColor(v2);
            }
            else {
                int v3 = ColorUtils.getColor(this.getContext(), 0x7F06048A);  // color:transparent
                ((ViewHolder)o00).itemView.setBackgroundColor(v3);
            }
            Playable playable0 = (Playable)this.getItem(v1);
            boolean z = true;
            ViewUtils.hideWhen(((ViewHolder)o00).getBtnPlay(), true);
            ViewUtils.hideWhen(((ViewHolder)o00).getBtnInfo(), true);
            ViewUtils.showWhen(((ViewHolder)o00).getMoveImage(), true);
            int v4 = FilenameUtils.getFileType("");
            ViewUtils.showWhen(((ViewHolder)o00).getListDcf(), 0x402 == v4);
            ViewUtils.showWhen(((ViewHolder)o00).getListFlac(), 0x202 == v4);
            ImageView imageView0 = ((ViewHolder)o00).getListMp3();
            if(0x402 == v4 || 0x202 == v4) {
                z = false;
            }
            ViewUtils.showWhen(imageView0, z);
            String s = null;
            String s1 = playable0 == null ? null : "";
            TextView textView0 = ((ViewHolder)o00).getTitleText();
            if(TextUtils.isEmpty(s1)) {
                s1 = "";
            }
            textView0.setText(s1);
            ViewUtils.setTextViewMarquee(((ViewHolder)o00).getTitleText(), this.isMarqueeNeeded(v1));
            if(playable0 != null) {
                s = "";
            }
            ((ViewHolder)o00).getArtistText().setText((TextUtils.isEmpty(s) ? "" : s));
            if(((ViewHolder)o00).getThumbnail() != null) {
                StorageUtils.isScopedStorage();
                String s2 = z6.f.i(s, "", "");
                ImageView imageView1 = ((ViewHolder)o00).getThumbnail();
                LocalPlaylistDetailEditFragment.this.showAlbumImage(imageView1, "", (playable0 == null ? 0L : playable0.getMediaStoreAlbumId()), s2);
            }
        }

        private static final void onBindViewImpl$lambda$0(LocalPlaylistDetailEditFragment localPlaylistDetailEditFragment0, int v, View view0) {
            localPlaylistDetailEditFragment0.onItemClick(view0, v);
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D04A8, viewGroup0, false);  // layout:listitem_song
            q.f(view0, "inflate(...)");
            return new ViewHolder(this, view0);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "LocalPlaylistDetailEditFragment";
    @Nullable
    private ImageView clearIv;
    private FilterLayout filterLayout;
    @Nullable
    private MelonEditText inputEt;
    @Nullable
    private List localPlaylistSongs;
    private MelonItemTouchHelper melonItemTouchHelper;
    @Nullable
    private View modifyPlaylistLayout;

    static {
        LocalPlaylistDetailEditFragment.Companion = new Companion(null);
        LocalPlaylistDetailEditFragment.$stable = 8;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    @Nullable
    public View buildParallaxHeaderView() {
        return LayoutInflater.from(this.getContext()).inflate(0x7F0D04BF, null, false);  // layout:local_playlist_edit_header
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public ToolBar buildToolBar() {
        View view0 = this.findViewById(0x7F0A0BC6);  // id:toolbar_layout
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.ToolBar");
        return ToolBar.f(((ToolBar)view0), 507);
    }

    private final boolean checkIfPossibleEdit() {
        String s = String.valueOf((this.inputEt == null ? null : this.inputEt.getText()));
        int v = s.length() - 1;
        int v1 = 0;
        boolean z = false;
        while(v1 <= v) {
            boolean z1 = q.h(s.charAt((z ? v : v1)), 0x20) <= 0;
            if(z) {
                if(!z1) {
                    break;
                }
                --v;
            }
            else if(z1) {
                ++v1;
            }
            else {
                z = true;
            }
        }
        String s1 = s.subSequence(v1, v + 1).toString();
        if(TextUtils.isEmpty(s1)) {
            ToastManager.show(this.getString(0x7F13034F));  // string:djplaylist_alert_input_title "제목을 입력해주세요."
            return false;
        }
        if(!q.b(this.getPlaylistName(), s1)) {
            if(this.isAlreadyExistPlaylist(s1)) {
                ToastManager.show(this.getString(0x7F1300A8));  // string:alert_dlg_body_local_playlist_equal_name "같은 이름의 로컬 플레이리스트가 있습니다.\n다시 입력해 
                                                                // 주세요."
                return false;
            }
            if(MusicUtils.renamePlaylist(this.getContext(), this.getPlaylistId(), s1)) {
                ToastManager.showShort(0x7F13083A);  // string:playlist_renamed_message "로컬 플레이리스트명이 변경되었습니다."
            }
            else {
                ToastManager.showShort(0x7F130839);  // string:playlist_renamed_fail_message "플레이리스트 이름 변경이 실패하였습니다."
            }
        }
        InputMethodUtils.hideInputMethod(this.getContext(), this.inputEt);
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new LocalPlaylistDetailSongAdapter(this, this.getContext());
        ((j)j00).setListContentType(1);
        ((j)j00).setMarkedMode(true);
        e e0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        e0.d = -1;
        e0.e = -1;
        e0.g = -1;
        e0.i = -1;
        e0.k = -1;
        e0.l = -1;
        e0.f = this.getString(0x7F130509);  // string:localplaylist_edit_empty_text "수록곡이 없습니다."
        ((p)j00).setEmptyViewInfo(e0);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment
    public int getLocalTrackType() {
        return 4;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxFixedHeight() {
        return ScreenUtils.dipToPixel(this.getContext(), 57.0f);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxHeaderHeight() {
        return ScreenUtils.dipToPixel(this.getContext(), 113.0f);
    }

    private final boolean isAlreadyExistPlaylist(String s) {
        if(!TextUtils.isEmpty(s)) {
            i.a.f();
            q.g(s, "playlistName");
            return ((int)(((Integer)w.N(((LocalPlaylistDatabase_Impl)i.a().a), true, false, new g(s, 22))))) > 0;
        }
        return false;
    }

    private final boolean isCreateNonSelectorPopup() {
        j0 j00 = this.getAdapter();
        if(j00 != null && ((LocalPlaylistDetailSongAdapter)j00).getMarkedCount() == 0) {
            String s = this.getString(0x7F1300A4);  // string:alert_dlg_body_delete_song_select_content "곡을 선택해 주세요."
            q.f(s, "getString(...)");
            l0 l00 = this.getChildFragmentManager();
            String s1 = this.getString(0x7F1300CD);  // string:alert_dlg_title_delete_confirm "안내"
            b.d(b.a, l00, s1, s, false, false, false, null, null, null, null, null, 2040);
            return true;
        }
        return false;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public boolean isRecyclerViewBelowTitleBar() {
        return true;
    }

    @NotNull
    public static final LocalPlaylistDetailEditFragment newInstance(long v, @NotNull String s) {
        return LocalPlaylistDetailEditFragment.Companion.newInstance(v, s);
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

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onPause() {
        super.onPause();
        this.setSelectAllWithToolbar(false);
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onToolBarClick(@Nullable ToolBarItem toolBar$ToolBarItem0, int v) {
        if(16 == v && !this.isCreateNonSelectorPopup()) {
            this.setDelType(1);
            this.showDeleteConfirmPopup(false);
        }
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        View view1 = view0.findViewById(0x7F0A0810);  // id:modify_playlist_layout
        this.modifyPlaylistLayout = view1;
        boolean z = false;
        ViewUtils.setOnClickListener(view1, new v(this, 0));
        MelonEditText melonEditText0 = (MelonEditText)view0.findViewById(0x7F0A0583);  // id:input_et
        this.inputEt = melonEditText0;
        if(melonEditText0 != null) {
            melonEditText0.setTextLimit(MelonLimits.TextLimit.e);
        }
        MelonEditText melonEditText1 = this.inputEt;
        if(melonEditText1 != null) {
            melonEditText1.setText(this.getPlaylistName());
        }
        MelonEditText melonEditText2 = this.inputEt;
        if(melonEditText2 != null) {
            melonEditText2.setSelection((TextUtils.isEmpty(this.getPlaylistName()) ? 0 : this.getPlaylistName().length()));
        }
        MelonEditText melonEditText3 = this.inputEt;
        if(melonEditText3 != null) {
            melonEditText3.postDelayed(() -> {
                MelonEditText melonEditText0 = this.inputEt;
                if(melonEditText0 != null) {
                    melonEditText0.requestFocus();
                }
            }, 50L);
        }
        MelonEditText melonEditText4 = this.inputEt;
        if(melonEditText4 != null) {
            melonEditText4.addTextChangedListener(new TextWatcher() {
                @Override  // android.text.TextWatcher
                public void afterTextChanged(Editable editable0) {
                    q.g(editable0, "s");
                }

                @Override  // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
                    q.g(charSequence0, "s");
                }

                @Override  // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
                    q.g(charSequence0, "s");
                    boolean z = TextUtils.isEmpty(charSequence0.toString());
                    ViewUtils.showWhen(LocalPlaylistDetailEditFragment.this.clearIv, !z);
                }
            });
        }
        ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A02C1);  // id:clear_iv
        this.clearIv = imageView0;
        ViewUtils.setOnClickListener(imageView0, new v(this, 1));
        View view2 = view0.findViewById(0x7F0A0BAD);  // id:titlebar
        q.f(view2, "findViewById(...)");
        F8.p p0 = new F8.p(1);
        B b0 = new B();  // 初始化器: Ljava/lang/Object;-><init>()V
        b0.c = new v(this, 2);
        o[] arr_o = {p0, new m(2, false), b0};
        Editable editable0 = null;
        o o0 = null;
        for(int v = 0; v < 3; ++v) {
            o o1 = arr_o[v];
            if(o0 == null) {
                o0 = o1;
            }
            else {
                o0.g(o1);
            }
        }
        q.d(o0);
        ((TitleBar)view2).a(o0);
        ((TitleBar)view2).setTitle(this.getString(0x7F131044));  // string:title_local_playlist_edit "로컬 플레이리스트 편집"
        ((TitleBar)view2).f(true);
        MelonItemTouchHelper melonItemTouchHelper0 = new MelonItemTouchHelper(this.mRecyclerView);
        this.melonItemTouchHelper = melonItemTouchHelper0;
        melonItemTouchHelper0.setAutoScrollSpeed(ScrollSpeed.SCROLL_SPEED_MIDDLE);
        MelonItemTouchHelper melonItemTouchHelper1 = this.melonItemTouchHelper;
        if(melonItemTouchHelper1 != null) {
            melonItemTouchHelper1.setFloatingAlpha(0.8f);
            MelonItemTouchHelper melonItemTouchHelper2 = this.melonItemTouchHelper;
            if(melonItemTouchHelper2 != null) {
                melonItemTouchHelper2.setFloatingBgColor(ColorUtils.getColor(this.getContext(), 0x7F060195));  // color:item_floating_bg
                MelonItemTouchHelper melonItemTouchHelper3 = this.melonItemTouchHelper;
                if(melonItemTouchHelper3 != null) {
                    melonItemTouchHelper3.setViewHandleId(0x7F0A0651);  // id:iv_move
                    MelonItemTouchHelper melonItemTouchHelper4 = this.melonItemTouchHelper;
                    if(melonItemTouchHelper4 != null) {
                        melonItemTouchHelper4.setOnItemMovedListener(new ItemMoveListener() {
                            @Override  // com.iloen.melon.utils.dragdrop.MelonItemTouchHelper$ItemMoveListener
                            public boolean onItemCheckEnable(int v) {
                                return true;
                            }

                            @Override  // com.iloen.melon.utils.dragdrop.MelonItemTouchHelper$ItemMoveListener
                            public void onItemMoved(int v, int v1) {
                                int v11;
                                int v7;
                                int v3;
                                int v2 = 0;
                                if(v != v1) {
                                    if(LocalPlaylistDetailEditFragment.this.mAdapter instanceof LocalPlaylistDetailSongAdapter) {
                                        j0 j00 = LocalPlaylistDetailEditFragment.this.mAdapter;
                                        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.local.LocalPlaylistDetailEditFragment.LocalPlaylistDetailSongAdapter");
                                        v3 = ((LocalPlaylistDetailSongAdapter)j00).getHeaderCount();
                                        ((LocalPlaylistDetailSongAdapter)j00).getItem(1);
                                    }
                                    else {
                                        v3 = 0;
                                    }
                                    int v4 = -1;
                                    if(v > v1) {
                                        int v5 = v - v3;
                                        int v6 = v1 - v3;
                                        if(v6 > 0) {
                                            v2 = v6;
                                        }
                                        if(v5 != v2) {
                                            List list0 = LocalPlaylistDetailEditFragment.this.localPlaylistSongs;
                                            if(list0 == null) {
                                                v7 = -1;
                                            }
                                            else {
                                                t t0 = (t)list0.get(v5);
                                                v7 = t0 == null ? -1 : t0.m;
                                            }
                                            List list1 = LocalPlaylistDetailEditFragment.this.localPlaylistSongs;
                                            if(list1 != null) {
                                                t t1 = (t)list1.get(v2);
                                                if(t1 != null) {
                                                    v4 = t1.m;
                                                }
                                            }
                                            MusicUtils.movePlaylist("UP", LocalPlaylistDetailEditFragment.this.getPlaylistId(), v7, v4);
                                            LocalPlaylistDetailEditFragment.this.startFetch("onItemMoved()");
                                        }
                                    }
                                    else {
                                        int v8 = v - v3;
                                        int v9 = v1 - v3;
                                        int v10 = LocalPlaylistDetailEditFragment.this.getItemCount();
                                        if(1 <= v10 && v10 <= v9) {
                                            v9 = LocalPlaylistDetailEditFragment.this.getItemCount() - 1;
                                        }
                                        String s = LocalPlaylistDetailEditFragment.this.getTAG();
                                        LogU.Companion.d(s, "DOWN : realFrom : " + v8 + ", realTo : " + v9);
                                        if(v8 != v9) {
                                            List list2 = LocalPlaylistDetailEditFragment.this.localPlaylistSongs;
                                            if(list2 == null) {
                                                v11 = -1;
                                            }
                                            else {
                                                t t2 = (t)list2.get(v8);
                                                v11 = t2 == null ? -1 : t2.m;
                                            }
                                            List list3 = LocalPlaylistDetailEditFragment.this.localPlaylistSongs;
                                            if(list3 != null) {
                                                t t3 = (t)list3.get(v9);
                                                if(t3 != null) {
                                                    v4 = t3.m;
                                                }
                                            }
                                            MusicUtils.movePlaylist("DOWN", LocalPlaylistDetailEditFragment.this.getPlaylistId(), v11, v4);
                                            LocalPlaylistDetailEditFragment.this.startFetch("onItemMoved()");
                                        }
                                    }
                                }
                            }
                        });
                        View view3 = view0.findViewById(0x7F0A049E);  // id:filter_layout
                        q.f(view3, "findViewById(...)");
                        this.filterLayout = (FilterLayout)view3;
                        ImageView imageView1 = this.clearIv;
                        MelonEditText melonEditText5 = this.inputEt;
                        if(melonEditText5 != null) {
                            editable0 = melonEditText5.getText();
                        }
                        ViewUtils.showWhen(imageView1, !TextUtils.isEmpty(String.valueOf(editable0)));
                        if(this.getItemCount() > 0) {
                            z = true;
                        }
                        this.setAllCheckButtonVisibility(z);
                        return;
                    }
                    q.m("melonItemTouchHelper");
                    throw null;
                }
                q.m("melonItemTouchHelper");
                throw null;
            }
            q.m("melonItemTouchHelper");
            throw null;
        }
        q.m("melonItemTouchHelper");
        throw null;
    }

    private static final void onViewCreated$lambda$0(LocalPlaylistDetailEditFragment localPlaylistDetailEditFragment0, View view0) {
        ViewUtils.hideWhen(localPlaylistDetailEditFragment0.modifyPlaylistLayout, true);
        InputMethodUtils.showInputMethod(localPlaylistDetailEditFragment0.getContext(), localPlaylistDetailEditFragment0.inputEt);
    }

    // 检测为 Lambda 实现
    private static final void onViewCreated$lambda$1(LocalPlaylistDetailEditFragment localPlaylistDetailEditFragment0) [...]

    private static final void onViewCreated$lambda$2(LocalPlaylistDetailEditFragment localPlaylistDetailEditFragment0, View view0) {
        MelonEditText melonEditText0 = localPlaylistDetailEditFragment0.inputEt;
        if(melonEditText0 != null) {
            melonEditText0.setText("");
        }
    }

    private static final void onViewCreated$lambda$3(LocalPlaylistDetailEditFragment localPlaylistDetailEditFragment0, View view0) {
        if(localPlaylistDetailEditFragment0.checkIfPossibleEdit()) {
            localPlaylistDetailEditFragment0.performBackPress();
        }
    }

    private final void setAllCheckButtonVisibility(boolean z) {
        if(z) {
            FilterLayout filterLayout0 = this.filterLayout;
            if(filterLayout0 != null) {
                filterLayout0.setOnCheckedListener(new com.iloen.melon.fragments.local.p(this, 3));
                FilterLayout filterLayout1 = this.filterLayout;
                if(filterLayout1 != null) {
                    filterLayout1.setCheckButtonText(this.getString(0x7F130914));  // string:select_all "전체선택"
                    return;
                }
                q.m("filterLayout");
                throw null;
            }
            q.m("filterLayout");
            throw null;
        }
        FilterLayout filterLayout2 = this.filterLayout;
        if(filterLayout2 != null) {
            filterLayout2.setOnCheckedListener(null);
            FilterLayout filterLayout3 = this.filterLayout;
            if(filterLayout3 != null) {
                filterLayout3.setLeftButton(null);
                FilterLayout filterLayout4 = this.filterLayout;
                if(filterLayout4 != null) {
                    filterLayout4.setCheckButtonText("");
                    return;
                }
                q.m("filterLayout");
                throw null;
            }
            q.m("filterLayout");
            throw null;
        }
        q.m("filterLayout");
        throw null;
    }

    private static final void setAllCheckButtonVisibility$lambda$4(LocalPlaylistDetailEditFragment localPlaylistDetailEditFragment0, S s0, boolean z) {
        localPlaylistDetailEditFragment0.toggleSelectAll();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }

    @Override  // com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment
    public void startQuery() {
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new n(null) {
            int label;

            {
                LocalPlaylistDetailEditFragment.this = localPlaylistDetailEditFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalPlaylistDetailEditFragment.startQuery.1(LocalPlaylistDetailEditFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalPlaylistDetailEditFragment.startQuery.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.fragments.local.LocalPlaylistDetailEditFragment.startQuery.1.playableList.1 localPlaylistDetailEditFragment$startQuery$1$playableList$10 = new n(null) {
                            int label;

                            {
                                LocalPlaylistDetailEditFragment.this = localPlaylistDetailEditFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.local.LocalPlaylistDetailEditFragment.startQuery.1.playableList.1(LocalPlaylistDetailEditFragment.this, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.local.LocalPlaylistDetailEditFragment.startQuery.1.playableList.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                a a0 = a.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        i.a.f();
                                        List list0 = i.b(LocalPlaylistDetailEditFragment.this.getPlaylistId());
                                        LocalPlaylistDetailEditFragment.this.localPlaylistSongs = list0;
                                        i.a.f();
                                        String s = LocalPlaylistDetailEditFragment.this.mPlaybackMenuId;
                                        q.f(s, "access$getMPlaybackMenuId$p$s-977443192(...)");
                                        this.label = 1;
                                        ArrayList arrayList0 = i.d(s, LocalPlaylistDetailEditFragment.this.localPlaylistSongs);
                                        return arrayList0 == a0 ? a0 : arrayList0;
                                    }
                                    case 1: {
                                        d5.n.D(object0);
                                        return object0;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                            }
                        };
                        this.label = 1;
                        object0 = BuildersKt.withContext(LocalPlaylistDetailEditFragment.this.getIoDispatcher(), localPlaylistDetailEditFragment$startQuery$1$playableList$10, this);
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
                j0 j00 = LocalPlaylistDetailEditFragment.this.mAdapter;
                if(j00 != null) {
                    LocalPlaylistDetailEditFragment localPlaylistDetailEditFragment0 = LocalPlaylistDetailEditFragment.this;
                    if(j00 instanceof LocalPlaylistDetailSongAdapter) {
                        localPlaylistDetailEditFragment0.dismissProgressDialog();
                        ((LocalPlaylistDetailSongAdapter)j00).clear();
                        ((LocalPlaylistDetailSongAdapter)j00).addAll(((ArrayList)object0));
                        localPlaylistDetailEditFragment0.performFetchCompleteOnlyViews();
                        localPlaylistDetailEditFragment0.setAllCheckButtonVisibility(((boolean)((((ArrayList)object0) == null || ((ArrayList)object0).isEmpty() ? 1 : 0) ^ 1)));
                    }
                }
                return H.a;
            }
        }, 3, null);
    }
}

