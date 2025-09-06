package com.iloen.melon.fragments.local;

import E9.h;
import G8.i;
import H8.s;
import android.annotation.SuppressLint;
import android.app.RecoverableSecurityException;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.f0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonLimits.TextLimit;
import com.iloen.melon.custom.MelonEditText;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.popup.ContextListPopup;
import com.iloen.melon.types.ContextItemInfo.Params;
import com.iloen.melon.types.ContextItemInfo;
import com.iloen.melon.types.ContextItemType;
import com.iloen.melon.utils.ContextListItemBuilder;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.dragdrop.MelonItemTouchHelper.ItemMoveListener;
import com.iloen.melon.utils.dragdrop.MelonItemTouchHelper;
import com.iloen.melon.utils.dragdrop.scroll.ScrollStrategyBase.ScrollSpeed;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.MusicUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.InputMethodUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import e9.a;
import ie.H;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.e;
import we.n;

@Metadata(d1 = {"\u0000\u00BA\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 ]2\u00020\u00012\u00020\u0002:\u0002]^B\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001A\u0004\u0018\u00010\u0005H\u0014\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b\u000B\u0010\fJ-\u0010\u0013\u001A\u0004\u0018\u00010\u00122\u0006\u0010\u000E\u001A\u00020\r2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\b\u0010\u0011\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001A\u00020\n2\u0006\u0010\u0015\u001A\u00020\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u001B\u0010\u001B\u001A\u0006\u0012\u0002\b\u00030\u001A2\u0006\u0010\u0019\u001A\u00020\u0018H\u0014\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001E\u001A\u00020\u001DH\u0014\u00A2\u0006\u0004\b\u001E\u0010\u001FJ-\u0010\'\u001A\u00020&2\b\u0010!\u001A\u0004\u0018\u00010 2\b\u0010#\u001A\u0004\u0018\u00010\"2\b\u0010%\u001A\u0004\u0018\u00010$H\u0014\u00A2\u0006\u0004\b\'\u0010(J\u001F\u0010+\u001A\u00020\n2\u0006\u0010)\u001A\u00020&2\u0006\u0010*\u001A\u00020&H\u0014\u00A2\u0006\u0004\b+\u0010,J!\u00101\u001A\u00020\n2\u0006\u0010.\u001A\u00020-2\b\u00100\u001A\u0004\u0018\u00010/H\u0016\u00A2\u0006\u0004\b1\u00102J\u0019\u00104\u001A\u00020\n2\b\u00103\u001A\u0004\u0018\u00010$H\u0014\u00A2\u0006\u0004\b4\u00105J\u000F\u00106\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b6\u0010\u0004J\u0019\u00109\u001A\u00020&2\b\u00108\u001A\u0004\u0018\u000107H\u0002\u00A2\u0006\u0004\b9\u0010:J \u0010>\u001A\n\u0012\u0004\u0012\u00020=\u0018\u00010<2\u0006\u0010;\u001A\u00020-H\u0082@\u00A2\u0006\u0004\b>\u0010?J\u0017\u0010@\u001A\u00020\n2\u0006\u0010;\u001A\u00020-H\u0002\u00A2\u0006\u0004\b@\u0010AJ\'\u0010E\u001A\u00020\n2\u0016\u0010D\u001A\u0012\u0012\u0004\u0012\u0002070Bj\b\u0012\u0004\u0012\u000207`CH\u0002\u00A2\u0006\u0004\bE\u0010FJ\u001F\u0010I\u001A\u00020\n2\u0006\u00103\u001A\u00020G2\u0006\u0010H\u001A\u00020$H\u0002\u00A2\u0006\u0004\bI\u0010JJ\u001F\u0010K\u001A\u00020\n2\u0006\u00103\u001A\u00020G2\u0006\u0010H\u001A\u00020$H\u0002\u00A2\u0006\u0004\bK\u0010JJ\u000F\u0010L\u001A\u00020&H\u0002\u00A2\u0006\u0004\bL\u0010MJ\u0011\u0010N\u001A\u0004\u0018\u00010$H\u0003\u00A2\u0006\u0004\bN\u0010OR\u0016\u0010Q\u001A\u00020P8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001A\u00020\u00128\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010V\u001A\u00020U8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010X\u001A\u00020-8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010[\u001A\u00020Z8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b[\u0010\\\u00A8\u0006_"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalPlaylistFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "Le9/a;", "<init>", "()V", "Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "getPvDummyLogRequest", "()Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "isEditMode", "isDoneUserAction", "onEditButtonClick", "(ZZ)V", "", "nResult", "", "clientData", "onRemoveComplete", "(ILjava/lang/Object;)V", "playlistId", "onAddSongsToLocalPlaylist", "(Ljava/lang/String;)V", "onDestroyView", "Lcom/iloen/melon/playback/Playable;", "playable", "isAvailableItem", "(Lcom/iloen/melon/playback/Playable;)Z", "position", "", "LH8/t;", "getCheckedPlaylistSongs", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showLocalPlaylistPopup", "(I)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "playableList", "checkAndPlaySongs", "(Ljava/util/ArrayList;)V", "", "playlistName", "deletePlaylist", "(JLjava/lang/String;)V", "removePlaylist", "handleCreatingBar", "()Z", "makeDefaultPlaylistName", "()Ljava/lang/String;", "Lcom/iloen/melon/custom/MelonEditText;", "editText", "Lcom/iloen/melon/custom/MelonEditText;", "newCoverLayout", "Landroid/view/View;", "Lcom/iloen/melon/utils/dragdrop/MelonItemTouchHelper;", "melonItemTouchHelper", "Lcom/iloen/melon/utils/dragdrop/MelonItemTouchHelper;", "selectedPlaylistSongsCount", "I", "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Companion", "LocalPlaylistAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LocalPlaylistFragment extends MetaContentBaseFragment implements a {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001A\u00020\u0007H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalPlaylistFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/local/LocalPlaylistFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final LocalPlaylistFragment newInstance() {
            LocalPlaylistFragment localPlaylistFragment0 = new LocalPlaylistFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argPlaybackMenuId", "1000000350");
            localPlaylistFragment0.setArguments(bundle0);
            return localPlaylistFragment0;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0003\u001C\u001D\u001EB\u0011\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u001F\u0010\r\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0012\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0016\u001A\u00020\u00152\b\u0010\u0014\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u000B\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001A\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001A\u001A\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001A\u0010\u0019R\u0014\u0010\u001B\u001A\u00020\b8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001B\u0010\u0019¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalPlaylistFragment$LocalPlaylistAdapter;", "Lcom/iloen/melon/adapters/common/p;", "LH8/s;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "<init>", "(Lcom/iloen/melon/fragments/local/LocalPlaylistFragment;Landroid/content/Context;)V", "", "getHeaderViewItemCount", "()I", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_HEADER_NOTICE", "I", "VIEW_TYPE_HEADER", "VIEW_TYPE_DATA", "HeaderViewHolder", "DataViewHolder", "NoticeViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class LocalPlaylistAdapter extends p {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\tR\u0017\u0010\u000B\u001A\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000ER\u0017\u0010\u000F\u001A\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000F\u0010\f\u001A\u0004\b\u0010\u0010\u000ER\u0017\u0010\u0011\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0007\u001A\u0004\b\u0012\u0010\tR\u0017\u0010\u0013\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0007\u001A\u0004\b\u0014\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalPlaylistFragment$LocalPlaylistAdapter$DataViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/local/LocalPlaylistFragment$LocalPlaylistAdapter;Landroid/view/View;)V", "layout", "Landroid/view/View;", "getLayout", "()Landroid/view/View;", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "count", "getCount", "btnTrash", "getBtnTrash", "btnMove", "getBtnMove", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class DataViewHolder extends O0 {
            @NotNull
            private final View btnMove;
            @NotNull
            private final View btnTrash;
            @NotNull
            private final TextView count;
            @NotNull
            private final View layout;
            @NotNull
            private final TextView title;

            public DataViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                LocalPlaylistAdapter.this = localPlaylistFragment$LocalPlaylistAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0DF5);  // id:wrapper_layout
                q.f(view1, "findViewById(...)");
                this.layout = view1;
                View view2 = view0.findViewById(0x7F0A0D34);  // id:tv_title
                q.f(view2, "findViewById(...)");
                this.title = (TextView)view2;
                View view3 = view0.findViewById(0x7F0A0C50);  // id:tv_count
                q.f(view3, "findViewById(...)");
                this.count = (TextView)view3;
                View view4 = view0.findViewById(0x7F0A01C2);  // id:btn_trash
                q.f(view4, "findViewById(...)");
                this.btnTrash = view4;
                View view5 = view0.findViewById(0x7F0A017B);  // id:btn_move
                q.f(view5, "findViewById(...)");
                this.btnMove = view5;
            }

            @NotNull
            public final View getBtnMove() {
                return this.btnMove;
            }

            @NotNull
            public final View getBtnTrash() {
                return this.btnTrash;
            }

            @NotNull
            public final TextView getCount() {
                return this.count;
            }

            @NotNull
            public final View getLayout() {
                return this.layout;
            }

            @NotNull
            public final TextView getTitle() {
                return this.title;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0017\u0010\f\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000FR\u0017\u0010\u0010\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001A\u0004\b\u0015\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalPlaylistFragment$LocalPlaylistAdapter$HeaderViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/local/LocalPlaylistFragment$LocalPlaylistAdapter;Landroid/view/View;)V", "Landroid/widget/ImageView;", "clearIv", "Landroid/widget/ImageView;", "getClearIv", "()Landroid/widget/ImageView;", "Landroid/widget/TextView;", "doneTv", "Landroid/widget/TextView;", "getDoneTv", "()Landroid/widget/TextView;", "editBtnLayout", "Landroid/view/View;", "getEditBtnLayout", "()Landroid/view/View;", "creatingListLayout", "getCreatingListLayout", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class HeaderViewHolder extends O0 {
            @NotNull
            private final ImageView clearIv;
            @NotNull
            private final View creatingListLayout;
            @NotNull
            private final TextView doneTv;
            @NotNull
            private final View editBtnLayout;

            public HeaderViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                LocalPlaylistAdapter.this = localPlaylistFragment$LocalPlaylistAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A02C1);  // id:clear_iv
                q.f(view1, "findViewById(...)");
                this.clearIv = (ImageView)view1;
                View view2 = view0.findViewById(0x7F0A03E0);  // id:done_tv
                q.f(view2, "findViewById(...)");
                this.doneTv = (TextView)view2;
                View view3 = view0.findViewById(0x7F0A040B);  // id:edit_btn_layout
                q.f(view3, "findViewById(...)");
                this.editBtnLayout = view3;
                View view4 = view0.findViewById(0x7F0A035E);  // id:creating_list_layout
                q.f(view4, "findViewById(...)");
                this.creatingListLayout = view4;
                View view5 = view0.findViewById(0x7F0A0583);  // id:input_et
                q.f(view5, "findViewById(...)");
                LocalPlaylistFragment.this.editText = (MelonEditText)view5;
                MelonEditText melonEditText0 = LocalPlaylistFragment.this.editText;
                if(melonEditText0 != null) {
                    melonEditText0.setTextLimit(MelonLimits.TextLimit.e);
                    MelonEditText melonEditText1 = LocalPlaylistFragment.this.editText;
                    if(melonEditText1 != null) {
                        melonEditText1.addTextChangedListener(new TextWatcher() {
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
                                ViewUtils.hideWhen(HeaderViewHolder.this.getClearIv(), z);
                            }
                        });
                        ViewUtils.setOnClickListener(((ImageView)view1), new F(LocalPlaylistFragment.this, 2));
                        View view6 = view0.findViewById(0x7F0A08AC);  // id:new_cover_layout
                        q.f(view6, "findViewById(...)");
                        LocalPlaylistFragment.this.newCoverLayout = view6;
                        return;
                    }
                    q.m("editText");
                    throw null;
                }
                q.m("editText");
                throw null;
            }

            private static final void _init_$lambda$0(LocalPlaylistFragment localPlaylistFragment0, View view0) {
                MelonEditText melonEditText0 = localPlaylistFragment0.editText;
                if(melonEditText0 != null) {
                    melonEditText0.setText("");
                    return;
                }
                q.m("editText");
                throw null;
            }

            public static void a(LocalPlaylistFragment localPlaylistFragment0, View view0) {
                HeaderViewHolder._init_$lambda$0(localPlaylistFragment0, view0);
            }

            @NotNull
            public final ImageView getClearIv() {
                return this.clearIv;
            }

            @NotNull
            public final View getCreatingListLayout() {
                return this.creatingListLayout;
            }

            @NotNull
            public final TextView getDoneTv() {
                return this.doneTv;
            }

            @NotNull
            public final View getEditBtnLayout() {
                return this.editBtnLayout;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalPlaylistFragment$LocalPlaylistAdapter$NoticeViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/local/LocalPlaylistFragment$LocalPlaylistAdapter;Landroid/view/View;)V", "Landroid/widget/TextView;", "textNotice", "Landroid/widget/TextView;", "getTextNotice", "()Landroid/widget/TextView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class NoticeViewHolder extends O0 {
            @NotNull
            private final TextView textNotice;

            public NoticeViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                LocalPlaylistAdapter.this = localPlaylistFragment$LocalPlaylistAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0B5B);  // id:text_notice
                q.f(view1, "findViewById(...)");
                this.textNotice = (TextView)view1;
            }

            @NotNull
            public final TextView getTextNotice() {
                return this.textNotice;
            }
        }

        private final int VIEW_TYPE_DATA;
        private final int VIEW_TYPE_HEADER;
        private final int VIEW_TYPE_HEADER_NOTICE;

        public LocalPlaylistAdapter(@Nullable Context context0) {
            super(context0, null);
            this.VIEW_TYPE_HEADER_NOTICE = 1;
            this.VIEW_TYPE_HEADER = 2;
            this.VIEW_TYPE_DATA = 3;
        }

        public static void a(LocalPlaylistFragment localPlaylistFragment0, LocalPlaylistAdapter localPlaylistFragment$LocalPlaylistAdapter0, View view0) {
            LocalPlaylistAdapter.onBindViewImpl$lambda$8$lambda$3(localPlaylistFragment0, localPlaylistFragment$LocalPlaylistAdapter0, view0);
        }

        // 检测为 Lambda 实现
        public static void b(boolean z, LocalPlaylistFragment localPlaylistFragment0, long v, String s, View view0) [...]

        public static void c(LocalPlaylistFragment localPlaylistFragment0, View view0) {
            LocalPlaylistAdapter.onBindViewImpl$lambda$8$lambda$1(localPlaylistFragment0, view0);
        }

        // 检测为 Lambda 实现
        public static void d(LocalPlaylistAdapter localPlaylistFragment$LocalPlaylistAdapter0, LocalPlaylistFragment localPlaylistFragment0, long v, View view0) [...]

        public static void e(LocalPlaylistFragment localPlaylistFragment0, View view0) {
            LocalPlaylistAdapter.onBindViewImpl$lambda$8$lambda$4(localPlaylistFragment0, view0);
        }

        public static boolean f(LocalPlaylistAdapter localPlaylistFragment$LocalPlaylistAdapter0, LocalPlaylistFragment localPlaylistFragment0, int v, View view0) {
            return LocalPlaylistAdapter.onBindViewImpl$lambda$8$lambda$7(localPlaylistFragment$LocalPlaylistAdapter0, localPlaylistFragment0, v, view0);
        }

        // 检测为 Lambda 实现
        public static void g(LocalPlaylistFragment localPlaylistFragment0, LocalPlaylistAdapter localPlaylistFragment$LocalPlaylistAdapter0) [...]

        // 去混淆评级： 低(20)
        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return this.isInEditMode() ? 0 : 2;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            if(this.getHeaderViewItemCount() > 0 && v == this.getAvailableHeaderPosition()) {
                return this.VIEW_TYPE_HEADER_NOTICE;
            }
            return this.getHeaderViewItemCount() <= 1 || v != this.getAvailableHeaderPosition() + 1 ? this.VIEW_TYPE_DATA : this.VIEW_TYPE_HEADER;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            if(o00 != null) {
                LocalPlaylistFragment localPlaylistFragment0 = LocalPlaylistFragment.this;
                int v2 = o00.getItemViewType();
                if(v2 == this.VIEW_TYPE_HEADER) {
                    ViewUtils.setOnClickListener(((HeaderViewHolder)o00).getDoneTv(), new F(localPlaylistFragment0, 0));
                    ViewUtils.setOnClickListener(((HeaderViewHolder)o00).getCreatingListLayout(), new g(localPlaylistFragment0, this, 2));
                    ViewUtils.setOnClickListener(((HeaderViewHolder)o00).getEditBtnLayout(), new F(localPlaylistFragment0, 1));
                    return;
                }
                if(v2 == this.VIEW_TYPE_DATA) {
                    s s0 = (s)this.getItem(v1);
                    if(s0 != null) {
                        long v3 = s0.a;
                        String s1 = s0.b;
                        ((DataViewHolder)o00).getTitle().setText((TextUtils.isEmpty(s1) ? "" : s1));
                        ((DataViewHolder)o00).getTitle().requestLayout();
                        ((DataViewHolder)o00).getCount().setText(StringUtils.getFormattedStringNumber(s0.f));
                        boolean z = this.isInEditMode();
                        ViewUtils.showWhen(((DataViewHolder)o00).getBtnTrash(), z);
                        ViewUtils.showWhen(((DataViewHolder)o00).getBtnMove(), z);
                        ViewUtils.setOnClickListener(((DataViewHolder)o00).getBtnTrash(), (View view0) -> LocalPlaylistAdapter.onBindViewImpl$lambda$8$lambda$5(z, localPlaylistFragment0, v3, s1, view0));
                        ViewUtils.setOnClickListener(((DataViewHolder)o00).getLayout(), (View view0) -> LocalPlaylistAdapter.onBindViewImpl$lambda$8$lambda$6(this, localPlaylistFragment0, v3, view0));
                        ViewUtils.setOnLongClickListener(((DataViewHolder)o00).getLayout(), new b(this, localPlaylistFragment0, v1));
                    }
                }
            }
        }

        private static final void onBindViewImpl$lambda$8$lambda$1(LocalPlaylistFragment localPlaylistFragment0, View view0) {
            MelonEditText melonEditText0 = localPlaylistFragment0.editText;
            if(melonEditText0 != null) {
                String s = String.valueOf(melonEditText0.getText());
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
                    ToastManager.show(localPlaylistFragment0.getString(0x7F13034F));  // string:djplaylist_alert_input_title "제목을 입력해주세요."
                    return;
                }
                localPlaylistFragment0.onLocalPlaylistAddPopupOk(s1);
                return;
            }
            q.m("editText");
            throw null;
        }

        private static final void onBindViewImpl$lambda$8$lambda$3(LocalPlaylistFragment localPlaylistFragment0, LocalPlaylistAdapter localPlaylistFragment$LocalPlaylistAdapter0, View view0) {
            if(localPlaylistFragment0.handleCreatingBar()) {
                return;
            }
            View view1 = localPlaylistFragment0.newCoverLayout;
            if(view1 != null) {
                ViewUtils.hideWhen(view1, true);
                MelonEditText melonEditText0 = localPlaylistFragment0.editText;
                if(melonEditText0 != null) {
                    melonEditText0.setText(LocalPlaylistFragment.access$makeDefaultPlaylistName(localPlaylistFragment0));
                    MelonEditText melonEditText1 = localPlaylistFragment0.editText;
                    if(melonEditText1 != null) {
                        MelonEditText melonEditText2 = localPlaylistFragment0.editText;
                        if(melonEditText2 != null) {
                            melonEditText1.setSelection(String.valueOf(melonEditText2.getText()).length());
                            MelonEditText melonEditText3 = localPlaylistFragment0.editText;
                            if(melonEditText3 != null) {
                                melonEditText3.postDelayed(() -> LocalPlaylistAdapter.onBindViewImpl$lambda$8$lambda$3$lambda$2(localPlaylistFragment0, localPlaylistFragment$LocalPlaylistAdapter0), 50L);
                                return;
                            }
                            q.m("editText");
                            throw null;
                        }
                        q.m("editText");
                        throw null;
                    }
                    q.m("editText");
                    throw null;
                }
                q.m("editText");
                throw null;
            }
            q.m("newCoverLayout");
            throw null;
        }

        private static final void onBindViewImpl$lambda$8$lambda$3$lambda$2(LocalPlaylistFragment localPlaylistFragment0, LocalPlaylistAdapter localPlaylistFragment$LocalPlaylistAdapter0) {
            MelonEditText melonEditText0 = localPlaylistFragment0.editText;
            if(melonEditText0 != null) {
                melonEditText0.requestFocus();
                Context context0 = localPlaylistFragment$LocalPlaylistAdapter0.getContext();
                MelonEditText melonEditText1 = localPlaylistFragment0.editText;
                if(melonEditText1 != null) {
                    InputMethodUtils.showInputMethod(context0, melonEditText1);
                    return;
                }
                q.m("editText");
                throw null;
            }
            q.m("editText");
            throw null;
        }

        private static final void onBindViewImpl$lambda$8$lambda$4(LocalPlaylistFragment localPlaylistFragment0, View view0) {
            localPlaylistFragment0.setEditMode(true, localPlaylistFragment0.getString(0x7F131044));  // string:title_local_playlist_edit "로컬 플레이리스트 편집"
        }

        private static final void onBindViewImpl$lambda$8$lambda$5(boolean z, LocalPlaylistFragment localPlaylistFragment0, long v, String s, View view0) {
            if(z) {
                localPlaylistFragment0.deletePlaylist(v, s);
            }
        }

        private static final void onBindViewImpl$lambda$8$lambda$6(LocalPlaylistAdapter localPlaylistFragment$LocalPlaylistAdapter0, LocalPlaylistFragment localPlaylistFragment0, long v, View view0) {
            if(!localPlaylistFragment$LocalPlaylistAdapter0.isInEditMode()) {
                Context context0 = localPlaylistFragment$LocalPlaylistAdapter0.getContext();
                MelonEditText melonEditText0 = localPlaylistFragment0.editText;
                if(melonEditText0 != null) {
                    InputMethodUtils.hideInputMethod(context0, melonEditText0);
                    LocalPlaylistDetailFragment.Companion.newInstance(v).open();
                    return;
                }
                q.m("editText");
                throw null;
            }
        }

        private static final boolean onBindViewImpl$lambda$8$lambda$7(LocalPlaylistAdapter localPlaylistFragment$LocalPlaylistAdapter0, LocalPlaylistFragment localPlaylistFragment0, int v, View view0) {
            if(!localPlaylistFragment$LocalPlaylistAdapter0.isInEditMode()) {
                localPlaylistFragment0.showLocalPlaylistPopup(v);
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            if(v == this.VIEW_TYPE_HEADER_NOTICE) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D04C1, viewGroup0, false);  // layout:local_playlist_header_notice
                q.f(view0, "inflate(...)");
                return new NoticeViewHolder(this, view0);
            }
            if(v == this.VIEW_TYPE_HEADER) {
                View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D04C0, viewGroup0, false);  // layout:local_playlist_header
                q.f(view1, "inflate(...)");
                return new HeaderViewHolder(this, view1);
            }
            View view2 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0499, viewGroup0, false);  // layout:listitem_local_playlist
            q.f(view2, "inflate(...)");
            return new DataViewHolder(this, view2);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "LocalPlaylistFragment";
    private MelonEditText editText;
    @NotNull
    private final CoroutineDispatcher ioDispatcher;
    private MelonItemTouchHelper melonItemTouchHelper;
    private View newCoverLayout;
    private int selectedPlaylistSongsCount;

    static {
        LocalPlaylistFragment.Companion = new Companion(null);
        LocalPlaylistFragment.$stable = 8;
    }

    public LocalPlaylistFragment() {
        this.ioDispatcher = Dispatchers.getIO();
    }

    // 去混淆评级： 低(20)
    public static final String access$makeDefaultPlaylistName(LocalPlaylistFragment localPlaylistFragment0) {
        return "2025.09.06 11:30";
    }

    private final void checkAndPlaySongs(ArrayList arrayList0) {
        ArrayList arrayList1 = new ArrayList();
        for(Object object0: arrayList0) {
            if(this.isAvailableItem(((Playable)object0))) {
                arrayList1.add(object0);
            }
        }
        if(!arrayList1.isEmpty()) {
            this.playSongs(h.W(arrayList1), true, false, false);
            return;
        }
        ToastManager.show(0x7F13082B);  // string:playlist_empty "재생 가능한 곡이 없습니다."
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new LocalPlaylistAdapter(this, context0);
        ((j)j00).setMarkedMode(false);
        ((j)j00).setEditMode(false);
        ((p)j00).setHeaderParallaxEnabled(true);
        String s = this.getString(0x7F13038C);  // string:empty_local_content_list "로컬 플레이리스트 목록이 없습니다."
        q.f(s, "getString(...)");
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

    public static H d0(LocalPlaylistFragment localPlaylistFragment0, long v, String s) {
        return LocalPlaylistFragment.deletePlaylist$lambda$2(localPlaylistFragment0, v, s);
    }

    private final void deletePlaylist(long v, String s) {
        if(!this.isAdded()) {
            return;
        }
        String s1 = this.getString(0x7F13008E);  // string:alert_dlg_body_delete_playlist "%s 을(를) 삭제 하시겠습니까?\n삭제한 로컬 플레이리스트는 복구할 수 
                                                 // 없습니다."
        q.f(s1, "getString(...)");
        String s2 = String.format(s1, Arrays.copyOf(new Object[]{s}, 1));
        com.melon.ui.popup.b.x(this.getChildFragmentManager(), this.getString(0x7F1300CD), s2, false, false, null, null, new J(this, v, s, 1), null, null, null, 0xEF8);  // string:alert_dlg_title_delete_confirm "안내"
    }

    private static final H deletePlaylist$lambda$2(LocalPlaylistFragment localPlaylistFragment0, long v, String s) {
        localPlaylistFragment0.removePlaylist(v, s);
        return H.a;
    }

    private final Object getCheckedPlaylistSongs(int v, Continuation continuation0) {
        return BuildersKt.withContext(Dispatchers.getIO(), new n(v, null) {
            final int $position;
            int label;

            {
                LocalPlaylistFragment.this = localPlaylistFragment0;
                this.$position = v;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalPlaylistFragment.getCheckedPlaylistSongs.2(LocalPlaylistFragment.this, this.$position, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalPlaylistFragment.getCheckedPlaylistSongs.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                j0 j00 = LocalPlaylistFragment.this.mAdapter;
                if(j00 != null) {
                    int v = this.$position;
                    if(j00 instanceof LocalPlaylistAdapter) {
                        s s0 = (s)((LocalPlaylistAdapter)j00).getItem(v);
                        i.a.f();
                        return i.b(s0.a);
                    }
                }
                return null;
            }
        }, continuation0);
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    @Nullable
    public PvLogDummyReq getPvDummyLogRequest() {
        return this.isEditMode() ? null : new PvLogDummyReq(this.getContext(), "storageboxLocalplaylist");
    }

    private final boolean handleCreatingBar() {
        if(!"mounted".equals(Environment.getExternalStorageState())) {
            ToastManager.showShort(0x7F1308DE);  // string:sdcard_donot_add_playlist "내장 메모리가 사용 중일때 플레이리스트를 생성할 수 없습니다."
            return true;
        }
        return false;
    }

    private final boolean isAvailableItem(Playable playable0) {
        return playable0 != null && !playable0.isTypeOfEdu();
    }

    @SuppressLint({"SimpleDateFormat"})
    private final String makeDefaultPlaylistName() [...] // 潜在的解密器

    @NotNull
    public static final LocalPlaylistFragment newInstance() {
        return LocalPlaylistFragment.Companion.newInstance();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onAddSongsToLocalPlaylist(@Nullable String s) {
        this.startFetch("add local playlist");
        View view0 = this.newCoverLayout;
        if(view0 != null) {
            ViewUtils.showWhen(view0, true);
            ToastManager.show(0x7F13050A);  // string:localplaylist_new_create "로컬 플레이리스트가 생성되었습니다."
            Context context0 = this.getContext();
            MelonEditText melonEditText0 = this.editText;
            if(melonEditText0 != null) {
                InputMethodUtils.hideInputMethod(context0, melonEditText0);
                return;
            }
            q.m("editText");
            throw null;
        }
        q.m("newCoverLayout");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(this.getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D02B3, viewGroup0, false);  // layout:fragment_local_playlist
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onDestroyView() {
        Context context0 = this.getContext();
        MelonEditText melonEditText0 = this.editText;
        if(melonEditText0 != null) {
            InputMethodUtils.hideInputMethod(context0, melonEditText0);
            super.onDestroyView();
            return;
        }
        q.m("editText");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onEditButtonClick(boolean z, boolean z1) {
        if(!z) {
            this.showMiniPlayer(true);
            this.setScrollBottomMargin(this.shouldShowMiniPlayer());
        }
        j0 j00 = this.mAdapter;
        if(j00 != null) {
            j00.notifyDataSetChanged();
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable v9.i i0, @Nullable v9.h h0, @Nullable String s) {
        f0.f(this).a(new n(null) {
            int label;

            {
                LocalPlaylistFragment.this = localPlaylistFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalPlaylistFragment.onFetchStart.1(LocalPlaylistFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalPlaylistFragment.onFetchStart.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.fragments.local.LocalPlaylistFragment.onFetchStart.1.playlistList.1 localPlaylistFragment$onFetchStart$1$playlistList$10 = new n() {
                            int label;

                            {
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.local.LocalPlaylistFragment.onFetchStart.1.playlistList.1(continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.local.LocalPlaylistFragment.onFetchStart.1.playlistList.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                i.a.f();
                                return i.c();
                            }
                        };
                        this.label = 1;
                        object0 = BuildersKt.withContext(Dispatchers.getIO(), localPlaylistFragment$onFetchStart$1$playlistList$10, this);
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
                j0 j00 = LocalPlaylistFragment.this.mAdapter;
                if(j00 != null) {
                    LocalPlaylistFragment localPlaylistFragment0 = LocalPlaylistFragment.this;
                    localPlaylistFragment0.showProgress(false);
                    localPlaylistFragment0.dismissProgressDialog();
                    if(j00 instanceof LocalPlaylistAdapter) {
                        ((LocalPlaylistAdapter)j00).clear();
                        ((LocalPlaylistAdapter)j00).addAll(((List)object0));
                        ((LocalPlaylistAdapter)j00).notifyDataSetChanged();
                        localPlaylistFragment0.performFetchCompleteOnlyViews();
                    }
                }
                return H.a;
            }
        });
        return true;
    }

    @Override  // e9.a
    public void onRemoveComplete(int v, @Nullable Object object0) {
        this.startFetch("removePlaylist");
        if(object0 instanceof String) {
            ToastManager.showFormatted(0x7F130822, new Object[]{object0});  // string:playlist_arg1_deleted "%1$s이(가) 삭제되었습니다."
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
    }

    @Override  // e9.a
    public void onThrowRecoverableSecurityException(@NotNull RecoverableSecurityException recoverableSecurityException0) {
        q.g(recoverableSecurityException0, "exception");
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(B.a.s(1));
            titleBar0.setTitle(this.getString(0x7F131043));  // string:title_local_playlist "로컬 플레이리스트"
            titleBar0.f(true);
        }
        MelonItemTouchHelper melonItemTouchHelper0 = new MelonItemTouchHelper(this.mRecyclerView);
        this.melonItemTouchHelper = melonItemTouchHelper0;
        melonItemTouchHelper0.setAutoScrollSpeed(ScrollSpeed.SCROLL_SPEED_MIDDLE);
        MelonItemTouchHelper melonItemTouchHelper1 = this.melonItemTouchHelper;
        if(melonItemTouchHelper1 != null) {
            melonItemTouchHelper1.setFloatingAlpha(0.8f);
            MelonItemTouchHelper melonItemTouchHelper2 = this.melonItemTouchHelper;
            if(melonItemTouchHelper2 != null) {
                melonItemTouchHelper2.setViewHandleId(0x7F0A017B);  // id:btn_move
                MelonItemTouchHelper melonItemTouchHelper3 = this.melonItemTouchHelper;
                if(melonItemTouchHelper3 != null) {
                    melonItemTouchHelper3.setFloatingBgColor(ColorUtils.getColor(this.getContext(), 0x7F060195));  // color:item_floating_bg
                    MelonItemTouchHelper melonItemTouchHelper4 = this.melonItemTouchHelper;
                    if(melonItemTouchHelper4 != null) {
                        melonItemTouchHelper4.setOnItemMovedListener(new ItemMoveListener() {
                            @Override  // com.iloen.melon.utils.dragdrop.MelonItemTouchHelper$ItemMoveListener
                            public boolean onItemCheckEnable(int v) {
                                return true;
                            }

                            @Override  // com.iloen.melon.utils.dragdrop.MelonItemTouchHelper$ItemMoveListener
                            public void onItemMoved(int v, int v1) {
                                int v12;
                                int v8;
                                int v4;
                                int v3;
                                LocalPlaylistAdapter localPlaylistFragment$LocalPlaylistAdapter0;
                                int v2 = 0;
                                com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
                                logU$Companion0.d("LocalPlaylistFragment", "onItemMoved() from : " + v + ", to : " + v1);
                                if(v != v1) {
                                    if(LocalPlaylistFragment.this.mAdapter instanceof LocalPlaylistAdapter) {
                                        j0 j00 = LocalPlaylistFragment.this.mAdapter;
                                        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.local.LocalPlaylistFragment.LocalPlaylistAdapter");
                                        localPlaylistFragment$LocalPlaylistAdapter0 = (LocalPlaylistAdapter)j00;
                                        v3 = localPlaylistFragment$LocalPlaylistAdapter0.getHeaderCount();
                                        v4 = localPlaylistFragment$LocalPlaylistAdapter0.getFooterCount();
                                    }
                                    else {
                                        localPlaylistFragment$LocalPlaylistAdapter0 = null;
                                        v3 = 0;
                                        v4 = 0;
                                    }
                                    logU$Companion0.d("LocalPlaylistFragment", "headerCount : " + v3);
                                    logU$Companion0.d("LocalPlaylistFragment", "footerCount : " + v4);
                                    int v5 = -1;
                                    if(v > v1) {
                                        int v6 = v - v3;
                                        int v7 = v1 - v3;
                                        if(v7 > 0) {
                                            v2 = v7;
                                        }
                                        logU$Companion0.d("LocalPlaylistFragment", "UP : realFrom : " + v6 + ", realTo : " + v2);
                                        if(v6 != v2) {
                                            if(localPlaylistFragment$LocalPlaylistAdapter0 == null) {
                                                v8 = -1;
                                            }
                                            else {
                                                s s0 = (s)localPlaylistFragment$LocalPlaylistAdapter0.getItem(v6);
                                                v8 = s0 == null ? -1 : s0.e;
                                            }
                                            if(localPlaylistFragment$LocalPlaylistAdapter0 != null) {
                                                s s1 = (s)localPlaylistFragment$LocalPlaylistAdapter0.getItem(v2);
                                                if(s1 != null) {
                                                    v5 = s1.e;
                                                }
                                            }
                                            MusicUtils.moveLocalPlaylist("UP", v8, v5);
                                            LocalPlaylistFragment.this.startFetch("onItemMoved()");
                                        }
                                    }
                                    else {
                                        int v9 = v - v3;
                                        int v10 = v1 - v3;
                                        int v11 = LocalPlaylistFragment.this.getItemCount();
                                        if(1 <= v11 && v11 <= v10) {
                                            v10 = LocalPlaylistFragment.this.getItemCount() - 1;
                                        }
                                        if(v9 != v10) {
                                            logU$Companion0.d("LocalPlaylistFragment", "DOWN : realFrom : " + v9 + ", realTo : " + v10);
                                            if(localPlaylistFragment$LocalPlaylistAdapter0 == null) {
                                                v12 = -1;
                                            }
                                            else {
                                                s s2 = (s)localPlaylistFragment$LocalPlaylistAdapter0.getItem(v9);
                                                v12 = s2 == null ? -1 : s2.e;
                                            }
                                            if(localPlaylistFragment$LocalPlaylistAdapter0 != null) {
                                                s s3 = (s)localPlaylistFragment$LocalPlaylistAdapter0.getItem(v10);
                                                if(s3 != null) {
                                                    v5 = s3.e;
                                                }
                                            }
                                            MusicUtils.moveLocalPlaylist("DOWN", v12, v5);
                                            LocalPlaylistFragment.this.startFetch("onItemMoved()");
                                        }
                                    }
                                }
                            }
                        });
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

    private final void removePlaylist(long v, String s) {
        com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
        logU$Companion0.d("LocalPlaylistFragment", "removePlaylist() playlistId:" + v + " , playlistName : " + s);
        if(v < 0L) {
            logU$Companion0.w("LocalPlaylistFragment", "removePlaylist() invalid parameter");
            return;
        }
        f0.f(this).a(new n(v, s, null) {
            final long $playlistId;
            final String $playlistName;
            int label;

            {
                LocalPlaylistFragment.this = localPlaylistFragment0;
                this.$playlistId = v;
                this.$playlistName = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalPlaylistFragment.removePlaylist.1(LocalPlaylistFragment.this, this.$playlistId, this.$playlistName, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalPlaylistFragment.removePlaylist.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                Context context0 = LocalPlaylistFragment.this.getContext();
                H h0 = H.a;
                if(context0 == null) {
                    return h0;
                }
                e9.b b0 = new e9.b(context0, LocalPlaylistFragment.this);
                b0.d = 1;
                b0.a(new String[]{String.valueOf(this.$playlistId)}, this.$playlistName);
                return h0;
            }
        });
    }

    private final void showLocalPlaylistPopup(int v) {
        LogU.Companion.d("LocalPlaylistFragment", "showLocalPlaylistPopup()");
        if(this.isAdded()) {
            j0 j00 = this.mAdapter;
            if(j00 != null && j00 instanceof LocalPlaylistAdapter) {
                f0.f(this).a(new n(v, j00, null) {
                    final j0 $adapter;
                    final int $position;
                    int label;

                    {
                        LocalPlaylistFragment.this = localPlaylistFragment0;
                        this.$position = v;
                        this.$adapter = j00;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.fragments.local.LocalPlaylistFragment.showLocalPlaylistPopup.1.1(LocalPlaylistFragment.this, this.$position, this.$adapter, continuation0);
                    }

                    // 检测为 Lambda 实现
                    public static void d(List list0, LocalPlaylistFragment localPlaylistFragment0, String s, long v, ContextItemInfo contextItemInfo0, ContextItemType contextItemType0, Params contextItemInfo$Params0) [...]

                    public static H e(LocalPlaylistFragment localPlaylistFragment0, long v, String s) {
                        return com.iloen.melon.fragments.local.LocalPlaylistFragment.showLocalPlaylistPopup.1.1.invokeSuspend$lambda$1$lambda$0(localPlaylistFragment0, v, s);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.fragments.local.LocalPlaylistFragment.showLocalPlaylistPopup.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        ne.a a0 = ne.a.a;
                        switch(this.label) {
                            case 0: {
                                d5.n.D(object0);
                                this.label = 1;
                                object0 = LocalPlaylistFragment.this.getCheckedPlaylistSongs(this.$position, this);
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
                        LocalPlaylistFragment.this.selectedPlaylistSongsCount = ((List)object0) == null ? 0 : ((List)object0).size();
                        s s0 = (s)((LocalPlaylistAdapter)this.$adapter).getItem(this.$position);
                        long v = s0.a;
                        String s1 = s0.b;
                        ContextListItemBuilder contextListItemBuilder0 = ContextListItemBuilder.newInstance().add(ContextItemInfo.a(ContextItemType.f)).add(ContextItemInfo.a(ContextItemType.n)).add(ContextItemInfo.a(ContextItemType.L));
                        ContextListPopup contextListPopup0 = new ContextListPopup(LocalPlaylistFragment.this.getActivity());
                        contextListPopup0.setTitle(s1);
                        contextListPopup0.setListItems(contextListItemBuilder0.build());
                        contextListPopup0.setOnMenuItemClickListener((ContextItemInfo contextItemInfo0, ContextItemType contextItemType0, Params contextItemInfo$Params0) -> com.iloen.melon.fragments.local.LocalPlaylistFragment.showLocalPlaylistPopup.1.1.invokeSuspend$lambda$1(((List)object0), LocalPlaylistFragment.this, s1, v, contextItemInfo0, contextItemType0, contextItemInfo$Params0));
                        contextListPopup0.show();
                        return H.a;

                        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
                        @oe.e(c = "com.iloen.melon.fragments.local.LocalPlaylistFragment$showLocalPlaylistPopup$1$1$1$1", f = "LocalPlaylistFragment.kt", l = {279}, m = "invokeSuspend")
                        final class com.iloen.melon.fragments.local.LocalPlaylistFragment.showLocalPlaylistPopup.1.1.1.1 extends oe.i implements n {
                            final long $playlistId;
                            int label;

                            public com.iloen.melon.fragments.local.LocalPlaylistFragment.showLocalPlaylistPopup.1.1.1.1(LocalPlaylistFragment localPlaylistFragment0, long v, Continuation continuation0) {
                                LocalPlaylistFragment.this = localPlaylistFragment0;
                                this.$playlistId = v;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.local.LocalPlaylistFragment.showLocalPlaylistPopup.1.1.1.1(LocalPlaylistFragment.this, this.$playlistId, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.local.LocalPlaylistFragment.showLocalPlaylistPopup.1.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        com.iloen.melon.fragments.local.LocalPlaylistFragment.showLocalPlaylistPopup.1.1.1.1.playableList.1 localPlaylistFragment$showLocalPlaylistPopup$1$1$1$1$playableList$10 = new n(LocalPlaylistFragment.this, null) {
                                            final long $playlistId;
                                            Object L$0;
                                            Object L$1;
                                            int label;

                                            {
                                                this.$playlistId = v;
                                                LocalPlaylistFragment.this = localPlaylistFragment0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                return new com.iloen.melon.fragments.local.LocalPlaylistFragment.showLocalPlaylistPopup.1.1.1.1.playableList.1(this.$playlistId, LocalPlaylistFragment.this, continuation0);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                            }

                                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                return ((com.iloen.melon.fragments.local.LocalPlaylistFragment.showLocalPlaylistPopup.1.1.1.1.playableList.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                ne.a a0 = ne.a.a;
                                                switch(this.label) {
                                                    case 0: {
                                                        d5.n.D(object0);
                                                        i.a.f();
                                                        List list0 = i.b(this.$playlistId);
                                                        String s = LocalPlaylistFragment.this.mPlaybackMenuId;
                                                        q.f(s, "access$getMPlaybackMenuId$p$s-842853459(...)");
                                                        this.L$0 = null;
                                                        this.L$1 = null;
                                                        this.label = 1;
                                                        ArrayList arrayList0 = i.d(s, list0);
                                                        return arrayList0 == a0 ? a0 : arrayList0;
                                                    }
                                                    case 1: {
                                                        List list1 = (List)this.L$1;
                                                        i i0 = (i)this.L$0;
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
                                        object0 = BuildersKt.withContext(LocalPlaylistFragment.this.ioDispatcher, localPlaylistFragment$showLocalPlaylistPopup$1$1$1$1$playableList$10, this);
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
                                LocalPlaylistFragment.this.checkAndPlaySongs(((ArrayList)object0));
                                return H.a;
                            }
                        }

                    }

                    private static final void invokeSuspend$lambda$1(List list0, LocalPlaylistFragment localPlaylistFragment0, String s, long v, ContextItemInfo contextItemInfo0, ContextItemType contextItemType0, Params contextItemInfo$Params0) {
                        if(ContextItemType.f.equals(contextItemType0)) {
                            if(list0 != null && !list0.isEmpty()) {
                                BuildersKt__Builders_commonKt.launch$default(f0.f(localPlaylistFragment0), null, null, new com.iloen.melon.fragments.local.LocalPlaylistFragment.showLocalPlaylistPopup.1.1.1.1(localPlaylistFragment0, v, null), 3, null);
                                return;
                            }
                            ToastManager.show(0x7F13082B);  // string:playlist_empty "재생 가능한 곡이 없습니다."
                            return;
                        }
                        if(ContextItemType.n.equals(contextItemType0)) {
                            String s1 = localPlaylistFragment0.getString(0x7F13008E);  // string:alert_dlg_body_delete_playlist "%s 을(를) 삭제 하시겠습니까?\n삭제한 로컬 플레이리스트는 복구할 수 
                                                                                       // 없습니다."
                            q.f(s1, "getString(...)");
                            com.melon.ui.popup.b.x(localPlaylistFragment0.getChildFragmentManager(), localPlaylistFragment0.getString(0x7F1300CD), String.format(s1, Arrays.copyOf(new Object[]{s}, 1)), false, false, null, null, new J(localPlaylistFragment0, v, s, 0), null, null, null, 0xEF8);  // string:alert_dlg_title_delete_confirm "안내"
                            return;
                        }
                        if(ContextItemType.L.equals(contextItemType0)) {
                            LocalPlaylistDetailEditFragment.Companion.newInstance(v, s).open();
                        }
                    }

                    private static final H invokeSuspend$lambda$1$lambda$0(LocalPlaylistFragment localPlaylistFragment0, long v, String s) {
                        localPlaylistFragment0.removePlaylist(v, s);
                        return H.a;
                    }
                });
            }
        }
    }
}

