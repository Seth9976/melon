package com.iloen.melon.fragments.local;

import Cc.K1;
import E9.w;
import G8.g;
import H8.b;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.l0;
import androidx.lifecycle.f0;
import androidx.lifecycle.y;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.database.core.LocalContentDatabase_Impl;
import com.iloen.melon.eventbus.EventAudioSync.Finish;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.popup.ContextListPopup;
import com.iloen.melon.types.ContextItemInfo.Params;
import com.iloen.melon.types.ContextItemInfo;
import com.iloen.melon.types.ContextItemType;
import com.iloen.melon.utils.ContextListItemBuilder;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import d5.n;
import e.k;
import ie.H;
import java.util.ArrayList;
import java.util.Iterator;
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
import ne.a;
import ob.z;
import oe.c;
import oe.e;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import v9.i;
import zd.M;

@Metadata(d1 = {"\u0000\u00A0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 L2\u00020\u0001:\u0003LMNB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\'\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u000E\u001A\u00020\rH\u0014\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0013\u001A\u00020\u0012H\u0014\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0016\u001A\u00020\u0015H\u0014\u00A2\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\u0006\u0010\u0019\u001A\u00020\u00182\b\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\b\u0010\u001C\u001A\u0004\u0018\u00010\rH\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u001B\u0010#\u001A\u0006\u0012\u0002\b\u00030\"2\u0006\u0010!\u001A\u00020 H\u0014\u00A2\u0006\u0004\b#\u0010$J5\u0010*\u001A\u00020\n2\f\u0010%\u001A\b\u0012\u0002\b\u0003\u0018\u00010\"2\u0006\u0010&\u001A\u00020\u001D2\u0006\u0010(\u001A\u00020\'2\u0006\u0010)\u001A\u00020\'H\u0014\u00A2\u0006\u0004\b*\u0010+J!\u0010/\u001A\u00020\u000F2\u0006\u0010,\u001A\u00020\'2\b\u0010.\u001A\u0004\u0018\u00010-H\u0016\u00A2\u0006\u0004\b/\u00100J\u0017\u00102\u001A\u00020\u000F2\u0006\u00101\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b2\u00103J\u0017\u00106\u001A\u00020\u000F2\u0006\u00105\u001A\u000204H\u0007\u00A2\u0006\u0004\b6\u00107J\u000F\u00108\u001A\u00020\u000FH\u0002\u00A2\u0006\u0004\b8\u0010\u0003J\u0017\u00109\u001A\u00020\u000F2\u0006\u0010)\u001A\u00020\'H\u0002\u00A2\u0006\u0004\b9\u0010:J\"\u0010<\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010;2\u0006\u0010)\u001A\u00020\'H\u0082@\u00A2\u0006\u0004\b<\u0010=J\u0017\u0010>\u001A\u00020\n2\u0006\u0010)\u001A\u00020\'H\u0002\u00A2\u0006\u0004\b>\u0010?J\u0017\u0010@\u001A\u00020\u000F2\u0006\u0010)\u001A\u00020\'H\u0002\u00A2\u0006\u0004\b@\u0010:J\u0017\u0010A\u001A\u00020\u000F2\u0006\u0010)\u001A\u00020\'H\u0002\u00A2\u0006\u0004\bA\u0010:J\u0017\u0010B\u001A\u00020\u000F2\u0006\u0010)\u001A\u00020\'H\u0002\u00A2\u0006\u0004\bB\u0010:J,\u0010F\u001A\u0016\u0012\u0004\u0012\u00020D\u0018\u00010Cj\n\u0012\u0004\u0012\u00020D\u0018\u0001`E2\u0006\u0010)\u001A\u00020\'H\u0082@\u00A2\u0006\u0004\bF\u0010=R\u0016\u0010G\u001A\u00020\'8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010J\u001A\u00020I8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bJ\u0010K\u00A8\u0006O"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentArtistListFragment;", "Lcom/iloen/melon/fragments/local/LocalContentListFragment;", "<init>", "()V", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "getPvDummyLogRequest", "()Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "adapter", "childView", "", "rawPosition", "position", "onRecyclerViewItemClick", "(Landroidx/recyclerview/widget/j0;Landroid/view/View;II)Z", "nResult", "", "clientData", "onRemoveComplete", "(ILjava/lang/Object;)V", "playlistId", "onAddSongsToLocalPlaylist", "(Ljava/lang/String;)V", "Lcom/iloen/melon/eventbus/EventAudioSync$Finish;", "event", "onEventMainThread", "(Lcom/iloen/melon/eventbus/EventAudioSync$Finish;)V", "startQuery", "removeArtist", "(I)V", "", "checkedListString", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setMarkedItem", "(I)Z", "showArtistListPopup", "deleteArtist", "showTrackAddToLocalPlaylistPopup", "Ljava/util/ArrayList;", "Lcom/iloen/melon/playback/Playable;", "Lkotlin/collections/ArrayList;", "getSelectPlayableList", "selectedArtistCount", "I", "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Companion", "LocalArtistAdapter", "ViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LocalContentArtistListFragment extends LocalContentListFragment {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentArtistListFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/local/LocalContentArtistListFragment;", "isFlac", "", "playbackMenuId", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final LocalContentArtistListFragment newInstance(boolean z, @Nullable String s) {
            LocalContentArtistListFragment localContentArtistListFragment0 = new LocalContentArtistListFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putBoolean("argIsFlac", z);
            bundle0.putBoolean("argVisibleWhenActivate", true);
            bundle0.putString("argPlaybackMenuId", s);
            localContentArtistListFragment0.setArguments(bundle0);
            return localContentArtistListFragment0;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\n\u0012\b\u0018\u00010\u0003R\u00020\u00040\u0001B#\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\u0010\u0010\b\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0010\u001A\u00020\u000F2\f\u0010\u000B\u001A\b\u0018\u00010\u0003R\u00020\u00042\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001F\u0010\u0012\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0017\u001A\u00060\u0003R\u00020\u00042\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0016\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentArtistListFragment$LocalArtistAdapter;", "Lcom/iloen/melon/adapters/common/p;", "LH8/b;", "Lcom/iloen/melon/fragments/local/LocalContentArtistListFragment$ViewHolder;", "Lcom/iloen/melon/fragments/local/LocalContentArtistListFragment;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/local/LocalContentArtistListFragment;Landroid/content/Context;Ljava/util/List;)V", "vh", "", "rawPosition", "position", "Lie/H;", "onBindViewImpl", "(Lcom/iloen/melon/fragments/local/LocalContentArtistListFragment$ViewHolder;II)V", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Lcom/iloen/melon/fragments/local/LocalContentArtistListFragment$ViewHolder;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class LocalArtistAdapter extends p {
        public LocalArtistAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return 0;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            this.onBindViewImpl(((ViewHolder)o00), v, v1);
        }

        public void onBindViewImpl(@Nullable ViewHolder localContentArtistListFragment$ViewHolder0, int v, int v1) {
            if(localContentArtistListFragment$ViewHolder0 != null) {
                f f0 = new f(LocalContentArtistListFragment.this, v, 1);
                ViewUtils.setOnClickListener(localContentArtistListFragment$ViewHolder0.itemView, f0);
                j j0 = new j(LocalContentArtistListFragment.this, v1, 0);
                ViewUtils.setOnLongClickListener(localContentArtistListFragment$ViewHolder0.itemView, j0);
                Object object0 = this.getList().get(v1);
                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.database.core.LocalArtistInfo");
                String s = ((b)object0).b;
                if(TextUtils.isEmpty(s) || q.b(s, "<unknown>")) {
                    s = "알 수 없는 아티스트";
                    q.f("알 수 없는 아티스트", "getString(...)");
                }
                localContentArtistListFragment$ViewHolder0.getTitle().setText(s);
                ViewUtils.setTextViewMarquee(localContentArtistListFragment$ViewHolder0.getTitle(), this.isMarqueeNeeded(v1));
                localContentArtistListFragment$ViewHolder0.getTitle().requestLayout();
                localContentArtistListFragment$ViewHolder0.getCount().setText(StringUtils.getFormattedStringNumber(((b)object0).d));
            }
        }

        private static final void onBindViewImpl$lambda$2$lambda$0(LocalContentArtistListFragment localContentArtistListFragment0, int v, View view0) {
            localContentArtistListFragment0.onItemClick(view0, v);
        }

        private static final boolean onBindViewImpl$lambda$2$lambda$1(LocalContentArtistListFragment localContentArtistListFragment0, int v, View view0) {
            if(localContentArtistListFragment0.setMarkedItem(v)) {
                localContentArtistListFragment0.showArtistListPopup(v);
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            return this.onCreateViewHolderImpl(viewGroup0, v);
        }

        @NotNull
        public ViewHolder onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0499, viewGroup0, false);  // layout:listitem_local_playlist
            q.f(view0, "inflate(...)");
            return new ViewHolder(LocalContentArtistListFragment.this, view0);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0017\u0010\u000B\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000B\u0010\b\u001A\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentArtistListFragment$ViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/local/LocalContentArtistListFragment;Landroid/view/View;)V", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "count", "getCount", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ViewHolder extends O0 {
        @NotNull
        private final TextView count;
        @NotNull
        private final TextView title;

        public ViewHolder(@NotNull View view0) {
            q.g(view0, "view");
            LocalContentArtistListFragment.this = localContentArtistListFragment0;
            super(view0);
            View view1 = view0.findViewById(0x7F0A0D34);  // id:tv_title
            q.f(view1, "findViewById(...)");
            this.title = (TextView)view1;
            View view2 = view0.findViewById(0x7F0A0C50);  // id:tv_count
            q.f(view2, "findViewById(...)");
            this.count = (TextView)view2;
        }

        @NotNull
        public final TextView getCount() {
            return this.count;
        }

        @NotNull
        public final TextView getTitle() {
            return this.title;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "LocalContentArtistListFragment";
    @NotNull
    private final CoroutineDispatcher ioDispatcher;
    private int selectedArtistCount;

    static {
        LocalContentArtistListFragment.Companion = new Companion(null);
        LocalContentArtistListFragment.$stable = 8;
    }

    public LocalContentArtistListFragment() {
        this.ioDispatcher = Dispatchers.getIO();
    }

    private final Object checkedListString(int v, Continuation continuation0) {
        com.iloen.melon.fragments.local.LocalContentArtistListFragment.checkedListString.1 localContentArtistListFragment$checkedListString$10;
        if(continuation0 instanceof com.iloen.melon.fragments.local.LocalContentArtistListFragment.checkedListString.1) {
            localContentArtistListFragment$checkedListString$10 = (com.iloen.melon.fragments.local.LocalContentArtistListFragment.checkedListString.1)continuation0;
            int v1 = localContentArtistListFragment$checkedListString$10.label;
            if((v1 & 0x80000000) == 0) {
                localContentArtistListFragment$checkedListString$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    int I$1;
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.checkedListString(0, this);
                    }
                };
            }
            else {
                localContentArtistListFragment$checkedListString$10.label = v1 ^ 0x80000000;
            }
        }
        else {
            localContentArtistListFragment$checkedListString$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                int I$1;
                Object L$0;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.checkedListString(0, this);
                }
            };
        }
        Object object0 = localContentArtistListFragment$checkedListString$10.result;
        a a0 = a.a;
        int v2 = 0;
        switch(localContentArtistListFragment$checkedListString$10.label) {
            case 0: {
                n.D(object0);
                j0 j00 = this.getAdapter();
                if(j00 == null || !(j00 instanceof LocalArtistAdapter)) {
                    return null;
                }
                localContentArtistListFragment$checkedListString$10.L$0 = null;
                localContentArtistListFragment$checkedListString$10.I$0 = v;
                localContentArtistListFragment$checkedListString$10.I$1 = 0;
                localContentArtistListFragment$checkedListString$10.label = 1;
                object0 = this.getSelectPlayableList(v, localContentArtistListFragment$checkedListString$10);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                j0 j01 = (j0)localContentArtistListFragment$checkedListString$10.L$0;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((ArrayList)object0) == null) {
            return null;
        }
        String[] arr_s = new String[((ArrayList)object0).size()];
        Iterator iterator0 = ((ArrayList)object0).iterator();
        while(iterator0.hasNext()) {
            iterator0.next();
            if(v2 >= 0) {
                boolean z = !StorageUtils.isScopedStorage();
                arr_s[v2] = "";
                ++v2;
                continue;
            }
            k.O();
            throw null;
        }
        return arr_s;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new LocalArtistAdapter(this, this.getContext(), null);
    }

    private final void deleteArtist(int v) {
        if(this.isAdded()) {
            j0 j00 = this.mAdapter;
            if(j00 != null && j00 instanceof LocalArtistAdapter) {
                b b0 = (b)((LocalArtistAdapter)j00).getItem(v);
                if(b0 != null) {
                    this.selectedArtistCount = b0.d;
                    l0 l00 = this.getChildFragmentManager();
                    String s = this.getString(0x7F1300CD);  // string:alert_dlg_title_delete_confirm "안내"
                    com.iloen.melon.fragments.local.k k0 = new com.iloen.melon.fragments.local.k(this, v, 1);
                    com.melon.ui.popup.b.x(l00, s, b0.b + "의 모든 파일을 완전히 삭제하시겠습니까?", false, false, null, null, k0, null, null, null, 0xEF8);
                }
            }
        }
    }

    private static final H deleteArtist$lambda$5$lambda$4(LocalContentArtistListFragment localContentArtistListFragment0, int v) {
        localContentArtistListFragment0.removeArtist(v);
        return H.a;
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    @NotNull
    public PvLogDummyReq getPvDummyLogRequest() {
        return this.mIsFlac ? new PvLogDummyReq(this.getContext(), "storageboxSaveFlacArtist") : new PvLogDummyReq(this.getContext(), "storageboxSaveSongArtist");
    }

    private final Object getSelectPlayableList(int v, Continuation continuation0) {
        return BuildersKt__Builders_commonKt.async$default(f0.f(this), Dispatchers.getIO(), null, new we.n(v, null) {
            final int $position;
            int label;

            {
                LocalContentArtistListFragment.this = localContentArtistListFragment0;
                this.$position = v;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalContentArtistListFragment.getSelectPlayableList.result.1(LocalContentArtistListFragment.this, this.$position, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalContentArtistListFragment.getSelectPlayableList.result.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                List list0;
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                n.D(object0);
                j0 j00 = LocalContentArtistListFragment.this.mAdapter;
                if(j00 != null) {
                    int v = this.$position;
                    LocalContentArtistListFragment localContentArtistListFragment0 = LocalContentArtistListFragment.this;
                    if(j00 instanceof LocalArtistAdapter) {
                        b b0 = (b)((LocalArtistAdapter)j00).getItem(v);
                        if(b0 != null) {
                            String s = b0.b;
                            if(s != null) {
                                z6.f f0 = g.a;
                                if(localContentArtistListFragment0.mIsFlac) {
                                    f0.m();
                                    list0 = (List)w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new Ac.g(s, 11));
                                }
                                else {
                                    f0.m();
                                    list0 = (List)w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new Ac.g(s, 14));
                                }
                                f0.m();
                                String s1 = localContentArtistListFragment0.mPlaybackMenuId;
                                q.f(s1, "access$getMPlaybackMenuId$p$s2034420035(...)");
                                return new ArrayList(g.i(s1, list0));
                            }
                        }
                    }
                }
                return null;
            }
        }, 2, null).await(continuation0);
    }

    @NotNull
    public static final LocalContentArtistListFragment newInstance(boolean z, @Nullable String s) {
        return LocalContentArtistListFragment.Companion.newInstance(z, s);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onAddSongsToLocalPlaylist(@NotNull String s) {
        q.g(s, "playlistId");
        LogU.Companion.d("LocalContentArtistListFragment", "onAddSongToPlaylist() playlistId:" + s);
        f0.f(this).a(new we.n(s, null) {
            final String $playlistId;
            int I$0;
            int I$1;
            Object L$0;
            Object L$1;
            Object L$2;
            int label;

            {
                LocalContentArtistListFragment.this = localContentArtistListFragment0;
                this.$playlistId = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalContentArtistListFragment.onAddSongsToLocalPlaylist.1(LocalContentArtistListFragment.this, this.$playlistId, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalContentArtistListFragment.onAddSongsToLocalPlaylist.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                String s1;
                LocalContentArtistListFragment localContentArtistListFragment0;
                a a0 = a.a;
                H h0 = H.a;
                switch(this.label) {
                    case 0: {
                        n.D(object0);
                        j0 j00 = LocalContentArtistListFragment.this.mAdapter;
                        if(j00 != null) {
                            localContentArtistListFragment0 = LocalContentArtistListFragment.this;
                            String s = this.$playlistId;
                            if(j00 instanceof LocalArtistAdapter) {
                                int v = ((LocalArtistAdapter)j00).getWeakMarked();
                                this.L$0 = localContentArtistListFragment0;
                                this.L$1 = s;
                                this.L$2 = null;
                                this.I$0 = 0;
                                this.I$1 = v;
                                this.label = 1;
                                object0 = localContentArtistListFragment0.getSelectPlayableList(v, this);
                                if(object0 == a0) {
                                    return a0;
                                }
                                s1 = s;
                                goto label_26;
                            }
                        }
                        break;
                    }
                    case 1: {
                        j0 j01 = (j0)this.L$2;
                        s1 = (String)this.L$1;
                        localContentArtistListFragment0 = (LocalContentArtistListFragment)this.L$0;
                        n.D(object0);
                    label_26:
                        if(((ArrayList)object0) != null && ((ArrayList)object0).size() != 0) {
                            Integer integer0 = Integer.valueOf(s1);
                            q.f(integer0, "valueOf(...)");
                            localContentArtistListFragment0.addToLocalPlaylist(((ArrayList)object0), integer0.intValue());
                            return h0;
                        }
                        ToastManager.show(0x7F13082B);  // string:playlist_empty "재생 가능한 곡이 없습니다."
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                return h0;
            }
        });
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(this.getActivity()));
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D02B2, viewGroup0, false);  // layout:fragment_local_list
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull Finish eventAudioSync$Finish0) {
        q.g(eventAudioSync$Finish0, "event");
        if(this.isFragmentValid() && eventAudioSync$Finish0.getUpdateCount() > 0) {
            this.startQuery();
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        this.startQuery();
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onRecyclerViewItemClick(@Nullable j0 j00, @NotNull View view0, int v, int v1) {
        q.g(view0, "childView");
        if(!(j00 instanceof LocalArtistAdapter)) {
            LogU.Companion.w("LocalContentArtistListFragment", "onRecyclerViewItemClick() invalid adapter");
            return false;
        }
        if(((LocalArtistAdapter)j00).isInEditMode()) {
            this.deleteArtist(v1);
            return true;
        }
        j0 j01 = this.mAdapter;
        if(j01 instanceof LocalArtistAdapter) {
            q.e(j01, "null cannot be cast to non-null type com.iloen.melon.fragments.local.LocalContentArtistListFragment.LocalArtistAdapter");
            b b0 = (b)((LocalArtistAdapter)j01).getItem(v1);
            if(b0 == null) {
                return false;
            }
            String s = b0.b;
            if(s.length() == 0) {
                return false;
            }
            ParamInfo localContentNewDbBaseFragment$ParamInfo0 = Builder.Companion.newInstance().artist(s).artistId(b0.c).isFlac(this.mIsFlac).build();
            LocalContentArtistSongFragment.Companion.newInstance(localContentNewDbBaseFragment$ParamInfo0, this.mPlaybackMenuId).open();
        }
        return true;
    }

    @Override  // com.iloen.melon.fragments.local.LocalContentListFragment
    public void onRemoveComplete(int v, @Nullable Object object0) {
        this.showProgress(false);
        switch(v) {
            case 1: {
                ToastManager.show(0x7F1302EE);  // string:delete_now_playlist_failed_for_artist "재생중인 곡이 포함된 아티스트는 삭제 할 수 없습니다."
                break;
            }
            case 2: {
                ToastManager.show(0x7F1302EA);  // string:delete_now_multi_failed_for_artist "재생중인곡이 포함된 아티스트를 제외하고 삭제하였습니다."
                break;
            }
            default: {
                ToastManager.showFormatted(0x7F1302F1, new Object[]{StringUtils.getFormattedStringNumber(this.selectedArtistCount)});  // string:deleted_songs_of_arg1 "%1$s곡이 삭제되었습니다."
            }
        }
        this.startFetch("artist::onRemoveComplete");
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
    }

    private final void removeArtist(int v) {
        this.showProgress(true);
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), Dispatchers.getIO(), null, new we.n(v, null) {
            final int $position;
            int label;

            {
                LocalContentArtistListFragment.this = localContentArtistListFragment0;
                this.$position = v;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalContentArtistListFragment.removeArtist.1(LocalContentArtistListFragment.this, this.$position, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalContentArtistListFragment.removeArtist.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        n.D(object0);
                        this.label = 1;
                        object0 = LocalContentArtistListFragment.this.checkedListString(this.$position, this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                LocalContentArtistListFragment.this.removeSongs(((String[])object0));
                return H.a;
            }
        }, 2, null);
    }

    private final boolean setMarkedItem(int v) {
        LocalArtistAdapter localContentArtistListFragment$LocalArtistAdapter0 = (LocalArtistAdapter)this.getAdapter();
        if(localContentArtistListFragment$LocalArtistAdapter0 == null) {
            LogU.Companion.d("LocalContentArtistListFragment", "setMarkedItem() - invalid adapter");
            return false;
        }
        if(localContentArtistListFragment$LocalArtistAdapter0.isInEditMode()) {
            LogU.Companion.d("LocalContentArtistListFragment", "setMarkedItem() - ignore in edit mode");
            return false;
        }
        localContentArtistListFragment$LocalArtistAdapter0.setWeakMarked(v);
        return true;
    }

    private final void showArtistListPopup(int v) {
        LogU.Companion.d("LocalContentArtistListFragment", "showArtistListPopup()");
        if(this.isAdded()) {
            ContextListItemBuilder contextListItemBuilder0 = ContextListItemBuilder.newInstance().add(ContextItemInfo.a(ContextItemType.f)).add(ContextItemInfo.a(ContextItemType.g)).add(ContextItemInfo.a(ContextItemType.n));
            j0 j00 = this.mAdapter;
            if(j00 instanceof LocalArtistAdapter) {
                q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.local.LocalContentArtistListFragment.LocalArtistAdapter");
                b b0 = (b)((LocalArtistAdapter)j00).getItem(v);
                ContextListPopup contextListPopup0 = new ContextListPopup(this.getActivity());
                q.d(b0);
                contextListPopup0.setTitle(b0.b);
                contextListPopup0.setListItems(contextListItemBuilder0.build());
                contextListPopup0.setOnMenuItemClickListener(new com.iloen.melon.fragments.local.i(this, v, 1));
                contextListPopup0.show();
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.fragments.local.LocalContentArtistListFragment$showArtistListPopup$1$1", f = "LocalContentArtistListFragment.kt", l = {0xE1}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.local.LocalContentArtistListFragment.showArtistListPopup.1.1 extends oe.i implements we.n {
            final int $position;
            int I$0;
            Object L$0;
            Object L$1;
            int label;

            public com.iloen.melon.fragments.local.LocalContentArtistListFragment.showArtistListPopup.1.1(LocalContentArtistListFragment localContentArtistListFragment0, int v, Continuation continuation0) {
                LocalContentArtistListFragment.this = localContentArtistListFragment0;
                this.$position = v;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalContentArtistListFragment.showArtistListPopup.1.1(LocalContentArtistListFragment.this, this.$position, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalContentArtistListFragment.showArtistListPopup.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                LocalContentArtistListFragment localContentArtistListFragment1;
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        n.D(object0);
                        j0 j00 = LocalContentArtistListFragment.this.mAdapter;
                        if(j00 != null) {
                            LocalContentArtistListFragment localContentArtistListFragment0 = LocalContentArtistListFragment.this;
                            int v = this.$position;
                            if(j00 instanceof LocalArtistAdapter) {
                                this.L$0 = localContentArtistListFragment0;
                                this.L$1 = null;
                                this.I$0 = 0;
                                this.label = 1;
                                object0 = localContentArtistListFragment0.getSelectPlayableList(v, this);
                                if(object0 == a0) {
                                    return a0;
                                }
                                localContentArtistListFragment1 = localContentArtistListFragment0;
                                goto label_21;
                            }
                        }
                        break;
                    }
                    case 1: {
                        j0 j01 = (j0)this.L$1;
                        localContentArtistListFragment1 = (LocalContentArtistListFragment)this.L$0;
                        n.D(object0);
                    label_21:
                        if(((ArrayList)object0) != null) {
                            localContentArtistListFragment1.playSongs(((ArrayList)object0), true, false);
                        }
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                return H.a;
            }
        }


        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.fragments.local.LocalContentArtistListFragment$showArtistListPopup$1$2", f = "LocalContentArtistListFragment.kt", l = {0xEB}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.local.LocalContentArtistListFragment.showArtistListPopup.1.2 extends oe.i implements we.n {
            final int $position;
            int label;

            public com.iloen.melon.fragments.local.LocalContentArtistListFragment.showArtistListPopup.1.2(LocalContentArtistListFragment localContentArtistListFragment0, int v, Continuation continuation0) {
                LocalContentArtistListFragment.this = localContentArtistListFragment0;
                this.$position = v;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalContentArtistListFragment.showArtistListPopup.1.2(LocalContentArtistListFragment.this, this.$position, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalContentArtistListFragment.showArtistListPopup.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        n.D(object0);
                        z z0 = LocalContentArtistListFragment.this.getPlayerUseCase();
                        this.label = 1;
                        object0 = z0.o(this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                if(((Boolean)object0).booleanValue()) {
                    Bc.h h0 = LocalContentArtistListFragment.this.getPlayerUiHelper();
                    l0 l00 = LocalContentArtistListFragment.this.getChildFragmentManager();
                    q.f(l00, "getChildFragmentManager(...)");
                    h0.e(l00, new com.iloen.melon.fragments.local.k(LocalContentArtistListFragment.this, this.$position, 0));
                    return H.a;
                }
                LocalContentArtistListFragment.this.showTrackAddToLocalPlaylistPopup(this.$position);
                return H.a;

                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
                @e(c = "com.iloen.melon.fragments.local.LocalContentArtistListFragment$showArtistListPopup$1$2$1$1", f = "LocalContentArtistListFragment.kt", l = {0xF0}, m = "invokeSuspend")
                final class com.iloen.melon.fragments.local.LocalContentArtistListFragment.showArtistListPopup.1.2.1.1 extends oe.i implements we.n {
                    final int $position;
                    int label;

                    public com.iloen.melon.fragments.local.LocalContentArtistListFragment.showArtistListPopup.1.2.1.1(LocalContentArtistListFragment localContentArtistListFragment0, int v, Continuation continuation0) {
                        LocalContentArtistListFragment.this = localContentArtistListFragment0;
                        this.$position = v;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.fragments.local.LocalContentArtistListFragment.showArtistListPopup.1.2.1.1(LocalContentArtistListFragment.this, this.$position, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.fragments.local.LocalContentArtistListFragment.showArtistListPopup.1.2.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        a a0 = a.a;
                        switch(this.label) {
                            case 0: {
                                n.D(object0);
                                z z0 = LocalContentArtistListFragment.this.getPlayerUseCase();
                                this.label = 1;
                                if(z0.b(0x7F13090F, this) == a0) {  // string:section_repeat_mode_release_toast "반복재생이 해제되었습니다.\n반복재생은 재생 목록에서 재설정 가능합니다."
                                    return a0;
                                }
                                break;
                            }
                            case 1: {
                                n.D(object0);
                                break;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        LocalContentArtistListFragment.this.showTrackAddToLocalPlaylistPopup(this.$position);
                        return H.a;
                    }
                }

            }

            private static final H invokeSuspend$lambda$0(LocalContentArtistListFragment localContentArtistListFragment0, int v) {
                BuildersKt__Builders_commonKt.launch$default(f0.f(localContentArtistListFragment0), Dispatchers.getMain(), null, new com.iloen.melon.fragments.local.LocalContentArtistListFragment.showArtistListPopup.1.2.1.1(localContentArtistListFragment0, v, null), 2, null);
                return H.a;
            }
        }

    }

    private static final void showArtistListPopup$lambda$3(LocalContentArtistListFragment localContentArtistListFragment0, int v, ContextItemInfo contextItemInfo0, ContextItemType contextItemType0, Params contextItemInfo$Params0) {
        if(ContextItemType.f.equals(contextItemType0)) {
            y y0 = f0.f(localContentArtistListFragment0);
            com.iloen.melon.fragments.local.LocalContentArtistListFragment.showArtistListPopup.1.1 localContentArtistListFragment$showArtistListPopup$1$10 = new com.iloen.melon.fragments.local.LocalContentArtistListFragment.showArtistListPopup.1.1(localContentArtistListFragment0, v, null);
            BuildersKt__Builders_commonKt.launch$default(y0, localContentArtistListFragment0.ioDispatcher, null, localContentArtistListFragment$showArtistListPopup$1$10, 2, null);
            return;
        }
        if(ContextItemType.g.equals(contextItemType0)) {
            BuildersKt__Builders_commonKt.launch$default(f0.f(localContentArtistListFragment0), Dispatchers.getMain(), null, new com.iloen.melon.fragments.local.LocalContentArtistListFragment.showArtistListPopup.1.2(localContentArtistListFragment0, v, null), 2, null);
            return;
        }
        if(ContextItemType.n.equals(contextItemType0)) {
            localContentArtistListFragment0.deleteArtist(v);
        }
    }

    private final void showTrackAddToLocalPlaylistPopup(int v) {
        String s;
        j0 j00 = this.mAdapter;
        if(j00 != null && j00 instanceof LocalArtistAdapter) {
            b b0 = (b)((LocalArtistAdapter)j00).getItem(v);
            if(b0 == null) {
                s = "";
            }
            else {
                s = b0.b;
                if(s == null) {
                    s = "";
                }
            }
            this.showTrackAddToLocalPlaylistPopup(s, new com.iloen.melon.fragments.local.i(this, v, 0));
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.fragments.local.LocalContentArtistListFragment$showTrackAddToLocalPlaylistPopup$1$1$1", f = "LocalContentArtistListFragment.kt", l = {315}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.local.LocalContentArtistListFragment.showTrackAddToLocalPlaylistPopup.1.1.1 extends oe.i implements we.n {
            final int $position;
            int label;

            public com.iloen.melon.fragments.local.LocalContentArtistListFragment.showTrackAddToLocalPlaylistPopup.1.1.1(LocalContentArtistListFragment localContentArtistListFragment0, int v, Continuation continuation0) {
                LocalContentArtistListFragment.this = localContentArtistListFragment0;
                this.$position = v;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalContentArtistListFragment.showTrackAddToLocalPlaylistPopup.1.1.1(LocalContentArtistListFragment.this, this.$position, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalContentArtistListFragment.showTrackAddToLocalPlaylistPopup.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        n.D(object0);
                        this.label = 1;
                        object0 = LocalContentArtistListFragment.this.getSelectPlayableList(this.$position, this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                LocalContentArtistListFragment.this.playSongs(((ArrayList)object0), false, false);
                return H.a;
            }
        }

    }

    private static final void showTrackAddToLocalPlaylistPopup$lambda$7$lambda$6(LocalContentArtistListFragment localContentArtistListFragment0, int v, M m0) {
        if(M.S == m0) {
            BuildersKt__Builders_commonKt.launch$default(f0.f(localContentArtistListFragment0), null, null, new com.iloen.melon.fragments.local.LocalContentArtistListFragment.showTrackAddToLocalPlaylistPopup.1.1.1(localContentArtistListFragment0, v, null), 3, null);
            return;
        }
        if(M.V == m0) {
            localContentArtistListFragment0.showLocalPlaylistPopup();
            return;
        }
        if(M.T == m0) {
            localContentArtistListFragment0.onAddToPlaylist(null);
        }
    }

    private final void startQuery() {
        f0.f(this).a(new we.n(null) {
            int label;

            {
                LocalContentArtistListFragment.this = localContentArtistListFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalContentArtistListFragment.startQuery.1(LocalContentArtistListFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalContentArtistListFragment.startQuery.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        n.D(object0);
                        com.iloen.melon.fragments.local.LocalContentArtistListFragment.startQuery.1.list.1 localContentArtistListFragment$startQuery$1$list$10 = new we.n(null) {
                            int label;

                            {
                                LocalContentArtistListFragment.this = localContentArtistListFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.local.LocalContentArtistListFragment.startQuery.1.list.1(LocalContentArtistListFragment.this, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.local.LocalContentArtistListFragment.startQuery.1.list.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                n.D(object0);
                                z6.f f0 = g.a;
                                if(LocalContentArtistListFragment.this.mIsFlac) {
                                    f0.m();
                                    return (List)w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new H8.g(0));
                                }
                                f0.m();
                                return (List)w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new K1(16));
                            }
                        };
                        this.label = 1;
                        object0 = BuildersKt.withContext(LocalContentArtistListFragment.this.ioDispatcher, localContentArtistListFragment$startQuery$1$list$10, this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                j0 j00 = LocalContentArtistListFragment.this.mAdapter;
                if(j00 != null) {
                    LocalContentArtistListFragment localContentArtistListFragment0 = LocalContentArtistListFragment.this;
                    if(j00 instanceof LocalArtistAdapter) {
                        ((LocalArtistAdapter)j00).clear();
                        ((LocalArtistAdapter)j00).addAll(((List)object0));
                        localContentArtistListFragment0.performFetchCompleteOnlyViews();
                    }
                }
                return H.a;
            }
        });
    }
}

