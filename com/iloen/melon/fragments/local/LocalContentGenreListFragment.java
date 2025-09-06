package com.iloen.melon.fragments.local;

import Cc.K1;
import E9.w;
import G8.g;
import H8.l;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.l0;
import androidx.lifecycle.f0;
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

@Metadata(d1 = {"\u0000\u00A8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0003QRSB\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0014\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b\u000B\u0010\fJ-\u0010\u0013\u001A\u0004\u0018\u00010\u00122\u0006\u0010\u000E\u001A\u00020\r2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\b\u0010\u0011\u001A\u0004\u0018\u00010\bH\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u001B\u0010\u0018\u001A\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u0016\u001A\u00020\u0015H\u0014\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001B\u001A\u00020\u001AH\u0014\u00A2\u0006\u0004\b\u001B\u0010\u001CJ5\u0010#\u001A\u00020\"2\f\u0010\u001D\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u00172\u0006\u0010\u001E\u001A\u00020\u00122\u0006\u0010 \u001A\u00020\u001F2\u0006\u0010!\u001A\u00020\u001FH\u0014\u00A2\u0006\u0004\b#\u0010$J-\u0010+\u001A\u00020\"2\b\u0010&\u001A\u0004\u0018\u00010%2\b\u0010(\u001A\u0004\u0018\u00010\'2\b\u0010*\u001A\u0004\u0018\u00010)H\u0014\u00A2\u0006\u0004\b+\u0010,J!\u00100\u001A\u00020\n2\u0006\u0010-\u001A\u00020\u001F2\b\u0010/\u001A\u0004\u0018\u00010.H\u0016\u00A2\u0006\u0004\b0\u00101J\"\u00103\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010)\u0018\u0001022\u0006\u0010!\u001A\u00020\u001FH\u0086@\u00A2\u0006\u0004\b3\u00104J\u0017\u00106\u001A\u00020\n2\u0006\u00105\u001A\u00020)H\u0016\u00A2\u0006\u0004\b6\u00107J\u0017\u0010:\u001A\u00020\n2\u0006\u00109\u001A\u000208H\u0007\u00A2\u0006\u0004\b:\u0010;J\u000F\u0010<\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b<\u0010\u0004J\u0017\u0010=\u001A\u00020\n2\u0006\u0010!\u001A\u00020\u001FH\u0002\u00A2\u0006\u0004\b=\u0010>J\u0017\u0010?\u001A\u00020\"2\u0006\u0010!\u001A\u00020\u001FH\u0002\u00A2\u0006\u0004\b?\u0010@J\u001F\u0010C\u001A\u00020\n2\u0006\u0010!\u001A\u00020\u001F2\u0006\u0010B\u001A\u00020AH\u0002\u00A2\u0006\u0004\bC\u0010DJ \u0010G\u001A\n\u0012\u0004\u0012\u00020F\u0018\u00010E2\u0006\u0010!\u001A\u00020\u001FH\u0082@\u00A2\u0006\u0004\bG\u00104J \u0010I\u001A\n\u0012\u0004\u0012\u00020H\u0018\u00010E2\u0006\u0010!\u001A\u00020\u001FH\u0082@\u00A2\u0006\u0004\bI\u00104J\u0017\u0010J\u001A\u00020\n2\u0006\u0010!\u001A\u00020\u001FH\u0002\u00A2\u0006\u0004\bJ\u0010>J\u0017\u0010K\u001A\u00020\n2\u0006\u0010!\u001A\u00020\u001FH\u0002\u00A2\u0006\u0004\bK\u0010>R\u0014\u0010L\u001A\u00020)8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010N\u001A\u00020)8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bN\u0010MR\u0016\u0010O\u001A\u00020\u001F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bO\u0010P\u00A8\u0006T"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentGenreListFragment;", "Lcom/iloen/melon/fragments/local/LocalContentListFragment;", "Le9/a;", "<init>", "()V", "Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "getPvDummyLogRequest", "()Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "adapter", "childView", "", "rawPosition", "position", "", "onRecyclerViewItemClick", "(Landroidx/recyclerview/widget/j0;Landroid/view/View;II)Z", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "nResult", "", "clientData", "onRemoveComplete", "(ILjava/lang/Object;)V", "", "checkedListString", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "playlistId", "onAddSongsToLocalPlaylist", "(Ljava/lang/String;)V", "Lcom/iloen/melon/eventbus/EventAudioSync$Finish;", "event", "onEventMainThread", "(Lcom/iloen/melon/eventbus/EventAudioSync$Finish;)V", "startQuery", "removeGenre", "(I)V", "setMarkedItem", "(I)Z", "LH8/l;", "item", "showContextListPopup", "(ILH8/l;)V", "", "Lcom/iloen/melon/playback/Playable;", "getPlayableList", "LH8/k;", "getEntityList", "deleteGenre", "showTrackAddToLocalPlaylistPopup", "TAG", "Ljava/lang/String;", "mGenreTitle", "mSelectedGenreCount", "I", "Companion", "LocalGenreAdapter", "ViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LocalContentGenreListFragment extends LocalContentListFragment {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\tH\u0007¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentGenreListFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/local/LocalContentGenreListFragment;", "isFlac", "", "playbackMenuId", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final LocalContentGenreListFragment newInstance(boolean z, @Nullable String s) {
            LocalContentGenreListFragment localContentGenreListFragment0 = new LocalContentGenreListFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putBoolean("argIsFlac", z);
            bundle0.putBoolean("argVisibleWhenActivate", true);
            bundle0.putString("argPlaybackMenuId", s);
            localContentGenreListFragment0.setArguments(bundle0);
            return localContentGenreListFragment0;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0018\u00010\u0003R\u00020\u00040\u0001B\u0011\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\f\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0011\u001A\u00060\u0003R\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0015\u001A\u00020\u00142\f\u0010\u0013\u001A\b\u0018\u00010\u0003R\u00020\u00042\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentGenreListFragment$LocalGenreAdapter;", "Lcom/iloen/melon/adapters/common/p;", "LH8/l;", "Lcom/iloen/melon/fragments/local/LocalContentGenreListFragment$ViewHolder;", "Lcom/iloen/melon/fragments/local/LocalContentGenreListFragment;", "Landroid/content/Context;", "context", "<init>", "(Lcom/iloen/melon/fragments/local/LocalContentGenreListFragment;Landroid/content/Context;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Lcom/iloen/melon/fragments/local/LocalContentGenreListFragment$ViewHolder;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Lcom/iloen/melon/fragments/local/LocalContentGenreListFragment$ViewHolder;II)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class LocalGenreAdapter extends p {
        public LocalGenreAdapter(@Nullable Context context0) {
            super(context0, null);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return 0;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            this.onBindViewImpl(((ViewHolder)o00), v, v1);
        }

        public void onBindViewImpl(@Nullable ViewHolder localContentGenreListFragment$ViewHolder0, int v, int v1) {
            if(localContentGenreListFragment$ViewHolder0 != null) {
                l l0 = (l)this.getItem(v1);
                f f0 = new f(LocalContentGenreListFragment.this, v, 2);
                ViewUtils.setOnClickListener(localContentGenreListFragment$ViewHolder0.itemView, f0);
                b b0 = new b(LocalContentGenreListFragment.this, v, l0, 1);
                ViewUtils.setOnLongClickListener(localContentGenreListFragment$ViewHolder0.itemView, b0);
                String s = l0.b;
                if(TextUtils.isEmpty(s)) {
                    localContentGenreListFragment$ViewHolder0.getTitle().setText("");
                }
                else if("Pop".equals(s)) {
                    localContentGenreListFragment$ViewHolder0.getTitle().setText("POP");
                }
                else {
                    localContentGenreListFragment$ViewHolder0.getTitle().setText(s);
                }
                ViewUtils.setTextViewMarquee(localContentGenreListFragment$ViewHolder0.getTitle(), this.isMarqueeNeeded(v1));
                localContentGenreListFragment$ViewHolder0.getTitle().requestLayout();
                localContentGenreListFragment$ViewHolder0.getCount().setText(StringUtils.getFormattedStringNumber(l0.d));
            }
        }

        private static final void onBindViewImpl$lambda$2$lambda$0(LocalContentGenreListFragment localContentGenreListFragment0, int v, View view0) {
            localContentGenreListFragment0.onItemClick(view0, v);
        }

        private static final boolean onBindViewImpl$lambda$2$lambda$1(LocalContentGenreListFragment localContentGenreListFragment0, int v, l l0, View view0) {
            if(localContentGenreListFragment0.setMarkedItem(v)) {
                q.d(l0);
                localContentGenreListFragment0.showContextListPopup(v, l0);
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
            return new ViewHolder(LocalContentGenreListFragment.this, view0);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0017\u0010\u000B\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000B\u0010\b\u001A\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentGenreListFragment$ViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/local/LocalContentGenreListFragment;Landroid/view/View;)V", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "count", "getCount", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ViewHolder extends O0 {
        @NotNull
        private final TextView count;
        @NotNull
        private final TextView title;

        public ViewHolder(@NotNull View view0) {
            q.g(view0, "view");
            LocalContentGenreListFragment.this = localContentGenreListFragment0;
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

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String TAG;
    @NotNull
    private String mGenreTitle;
    private int mSelectedGenreCount;

    static {
        LocalContentGenreListFragment.Companion = new Companion(null);
        LocalContentGenreListFragment.$stable = 8;
    }

    public LocalContentGenreListFragment() {
        this.TAG = "LocalContentGenreListFragment";
        this.mGenreTitle = "";
    }

    @Nullable
    public final Object checkedListString(int v, @NotNull Continuation continuation0) {
        com.iloen.melon.fragments.local.LocalContentGenreListFragment.checkedListString.1 localContentGenreListFragment$checkedListString$10;
        if(continuation0 instanceof com.iloen.melon.fragments.local.LocalContentGenreListFragment.checkedListString.1) {
            localContentGenreListFragment$checkedListString$10 = (com.iloen.melon.fragments.local.LocalContentGenreListFragment.checkedListString.1)continuation0;
            int v1 = localContentGenreListFragment$checkedListString$10.label;
            if((v1 & 0x80000000) == 0) {
                localContentGenreListFragment$checkedListString$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
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
                localContentGenreListFragment$checkedListString$10.label = v1 ^ 0x80000000;
            }
        }
        else {
            localContentGenreListFragment$checkedListString$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
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
        Object object0 = localContentGenreListFragment$checkedListString$10.result;
        a a0 = a.a;
        switch(localContentGenreListFragment$checkedListString$10.label) {
            case 0: {
                n.D(object0);
                localContentGenreListFragment$checkedListString$10.I$0 = v;
                localContentGenreListFragment$checkedListString$10.label = 1;
                object0 = this.getPlayableList(v, localContentGenreListFragment$checkedListString$10);
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
        int v2 = 0;
        String[] arr_s = new String[(((List)object0) == null ? 0 : ((List)object0).size())];
        if(((List)object0) != null) {
            Iterator iterator0 = ((List)object0).iterator();
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
        }
        return arr_s;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new LocalGenreAdapter(this, this.getContext());
    }

    private final void deleteGenre(int v) {
        if(this.isAdded()) {
            j0 j00 = this.mAdapter;
            if(j00 != null && j00 instanceof LocalGenreAdapter) {
                l l0 = (l)((LocalGenreAdapter)j00).getItem(v);
                if(l0 != null) {
                    this.mGenreTitle = l0.b;
                    l0 l00 = this.getChildFragmentManager();
                    String s = this.getString(0x7F1300CD);  // string:alert_dlg_title_delete_confirm "안내"
                    o o0 = new o(this, v, 1);
                    com.melon.ui.popup.b.x(l00, s, l0.b + "의 모든 파일을 완전히 삭제하시겠습니까?", false, false, null, null, o0, null, null, null, 0xEF8);
                }
            }
        }
    }

    private static final H deleteGenre$lambda$3$lambda$2(LocalContentGenreListFragment localContentGenreListFragment0, int v) {
        localContentGenreListFragment0.removeGenre(v);
        return H.a;
    }

    private final Object getEntityList(int v, Continuation continuation0) {
        return BuildersKt.withContext(Dispatchers.getIO(), new we.n(v, null) {
            final int $position;
            int label;

            {
                LocalContentGenreListFragment.this = localContentGenreListFragment0;
                this.$position = v;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalContentGenreListFragment.getEntityList.2(LocalContentGenreListFragment.this, this.$position, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalContentGenreListFragment.getEntityList.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                n.D(object0);
                j0 j00 = LocalContentGenreListFragment.this.mAdapter;
                if(j00 != null) {
                    int v = this.$position;
                    LocalContentGenreListFragment localContentGenreListFragment0 = LocalContentGenreListFragment.this;
                    if(j00 instanceof LocalGenreAdapter) {
                        l l0 = (l)((LocalGenreAdapter)j00).getItem(v);
                        z6.f f0 = g.a;
                        if(localContentGenreListFragment0.mIsFlac) {
                            f0.m();
                            q.g(l0.b, "genre");
                            return (List)w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new Ac.g(l0.b, 21));
                        }
                        f0.m();
                        q.g(l0.b, "genre");
                        return (List)w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new Ac.g(l0.b, 17));
                    }
                }
                return null;
            }
        }, continuation0);
    }

    private final Object getPlayableList(int v, Continuation continuation0) {
        return BuildersKt.withContext(Dispatchers.getIO(), new we.n(v, null) {
            final int $position;
            int label;

            {
                LocalContentGenreListFragment.this = localContentGenreListFragment0;
                this.$position = v;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalContentGenreListFragment.getPlayableList.2(LocalContentGenreListFragment.this, this.$position, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalContentGenreListFragment.getPlayableList.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        n.D(object0);
                        this.label = 1;
                        object0 = LocalContentGenreListFragment.this.getEntityList(this.$position, this);
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
                if(((List)object0) == null) {
                    return null;
                }
                g.a.m();
                String s = LocalContentGenreListFragment.this.mPlaybackMenuId;
                q.f(s, "access$getMPlaybackMenuId$p$s1471396131(...)");
                return g.i(s, ((List)object0));
            }
        }, continuation0);
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    @NotNull
    public PvLogDummyReq getPvDummyLogRequest() {
        return this.mIsFlac ? new PvLogDummyReq(this.getContext(), "storageboxSaveFlacGenre") : new PvLogDummyReq(this.getContext(), "storageboxSaveSongGenre");
    }

    @NotNull
    public static final LocalContentGenreListFragment newInstance(boolean z, @Nullable String s) {
        return LocalContentGenreListFragment.Companion.newInstance(z, s);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onAddSongsToLocalPlaylist(@NotNull String s) {
        q.g(s, "playlistId");
        LogU.Companion.d(this.TAG, "onAddSongToPlaylist() playlistId:" + s);
        f0.f(this).a(new we.n(s, null) {
            final String $playlistId;
            int I$0;
            int I$1;
            Object L$0;
            Object L$1;
            Object L$2;
            int label;

            {
                LocalContentGenreListFragment.this = localContentGenreListFragment0;
                this.$playlistId = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalContentGenreListFragment.onAddSongsToLocalPlaylist.1(LocalContentGenreListFragment.this, this.$playlistId, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalContentGenreListFragment.onAddSongsToLocalPlaylist.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                String s1;
                LocalContentGenreListFragment localContentGenreListFragment0;
                a a0 = a.a;
                H h0 = H.a;
                switch(this.label) {
                    case 0: {
                        n.D(object0);
                        j0 j00 = LocalContentGenreListFragment.this.mAdapter;
                        if(j00 != null) {
                            localContentGenreListFragment0 = LocalContentGenreListFragment.this;
                            String s = this.$playlistId;
                            if(j00 instanceof LocalGenreAdapter) {
                                int v = ((LocalGenreAdapter)j00).getWeakMarked();
                                this.L$0 = localContentGenreListFragment0;
                                this.L$1 = s;
                                this.L$2 = null;
                                this.I$0 = 0;
                                this.I$1 = v;
                                this.label = 1;
                                object0 = localContentGenreListFragment0.getPlayableList(v, this);
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
                        localContentGenreListFragment0 = (LocalContentGenreListFragment)this.L$0;
                        n.D(object0);
                    label_26:
                        if(((List)object0) != null && !((List)object0).isEmpty()) {
                            ArrayList arrayList0 = new ArrayList(((List)object0));
                            Integer integer0 = Integer.valueOf(s1);
                            q.f(integer0, "valueOf(...)");
                            localContentGenreListFragment0.addToLocalPlaylist(arrayList0, integer0.intValue());
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
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        this.startQuery();
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onRecyclerViewItemClick(@Nullable j0 j00, @NotNull View view0, int v, int v1) {
        q.g(view0, "childView");
        if(!(j00 instanceof LocalGenreAdapter)) {
            LogU.Companion.w(this.TAG, "onRecyclerViewItemClick() invalid adapter");
            return false;
        }
        if(((LocalGenreAdapter)j00).isInEditMode()) {
            this.deleteGenre(v1);
            return true;
        }
        String s = ((l)((LocalGenreAdapter)j00).getItem(v1)).b;
        ParamInfo localContentNewDbBaseFragment$ParamInfo0 = Builder.Companion.newInstance().genre(s).isFlac(this.mIsFlac).build();
        LocalContentGenreSongFragment.Companion.newInstance(localContentNewDbBaseFragment$ParamInfo0, this.mPlaybackMenuId).open();
        return true;
    }

    @Override  // com.iloen.melon.fragments.local.LocalContentListFragment
    public void onRemoveComplete(int v, @Nullable Object object0) {
        this.showProgress(false);
        this.setSelectAllWithToolbar(false);
        LocalGenreAdapter localContentGenreListFragment$LocalGenreAdapter0 = (LocalGenreAdapter)this.getAdapter();
        if(localContentGenreListFragment$LocalGenreAdapter0 != null) {
            localContentGenreListFragment$LocalGenreAdapter0.notifyDataSetChanged();
            switch(v) {
                case 1: {
                    ToastManager.show(0x7F1302EF);  // string:delete_now_playlist_failed_for_genre "재생중인 곡이 포함된 장르는 삭제 할 수 없습니다."
                    break;
                }
                case 2: {
                    ToastManager.show(0x7F1302EB);  // string:delete_now_multi_failed_for_genre "재생중인곡이 포함된 장르를 제외하고 삭제하였습니다."
                    break;
                }
                default: {
                    ToastManager.showFormatted(0x7F1302F1, new Object[]{StringUtils.getFormattedStringNumber(this.mSelectedGenreCount)});  // string:deleted_songs_of_arg1 "%1$s곡이 삭제되었습니다."
                }
            }
            this.startFetch("genre::onRemoveComplete");
            return;
        }
        LogU.Companion.d(this.TAG, "RemoveComplete() invalid adapter");
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
    }

    private final void removeGenre(int v) {
        this.showProgress(true);
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), Dispatchers.getIO(), null, new we.n(v, null) {
            final int $position;
            int label;

            {
                LocalContentGenreListFragment.this = localContentGenreListFragment0;
                this.$position = v;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalContentGenreListFragment.removeGenre.1(LocalContentGenreListFragment.this, this.$position, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalContentGenreListFragment.removeGenre.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        n.D(object0);
                        this.label = 1;
                        object0 = LocalContentGenreListFragment.this.checkedListString(this.$position, this);
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
                LocalContentGenreListFragment.this.removeSongs(((String[])object0));
                return H.a;
            }
        }, 2, null);
    }

    private final boolean setMarkedItem(int v) {
        LocalGenreAdapter localContentGenreListFragment$LocalGenreAdapter0 = (LocalGenreAdapter)this.getAdapter();
        if(localContentGenreListFragment$LocalGenreAdapter0 == null) {
            LogU.Companion.d(this.TAG, "setMarkedItem() - invalid adapter");
            return false;
        }
        if(localContentGenreListFragment$LocalGenreAdapter0.isInEditMode()) {
            LogU.Companion.d(this.TAG, "setMarkedItem() - ignore in edit mode");
            return false;
        }
        localContentGenreListFragment$LocalGenreAdapter0.setWeakMarked(v);
        return true;
    }

    private final void showContextListPopup(int v, l l0) {
        LogU.Companion.d(this.TAG, "showContextListPopup()");
        if(!this.isAdded()) {
            return;
        }
        this.mGenreTitle = l0.b;
        this.mSelectedGenreCount = l0.d;
        ContextListItemBuilder contextListItemBuilder0 = ContextListItemBuilder.newInstance().add(ContextItemInfo.a(ContextItemType.f)).add(ContextItemInfo.a(ContextItemType.g)).add(ContextItemInfo.a(ContextItemType.n));
        ContextListPopup contextListPopup0 = new ContextListPopup(this.getActivity());
        contextListPopup0.setTitle(this.mGenreTitle);
        contextListPopup0.setListItems(contextListItemBuilder0.build());
        contextListPopup0.setOnMenuItemClickListener(new com.iloen.melon.fragments.local.n(this, v));
        contextListPopup0.show();

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.fragments.local.LocalContentGenreListFragment$showContextListPopup$1$1", f = "LocalContentGenreListFragment.kt", l = {0xE2}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.local.LocalContentGenreListFragment.showContextListPopup.1.1 extends oe.i implements we.n {
            final int $position;
            int label;

            public com.iloen.melon.fragments.local.LocalContentGenreListFragment.showContextListPopup.1.1(LocalContentGenreListFragment localContentGenreListFragment0, int v, Continuation continuation0) {
                LocalContentGenreListFragment.this = localContentGenreListFragment0;
                this.$position = v;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalContentGenreListFragment.showContextListPopup.1.1(LocalContentGenreListFragment.this, this.$position, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalContentGenreListFragment.showContextListPopup.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        n.D(object0);
                        this.label = 1;
                        object0 = LocalContentGenreListFragment.this.getPlayableList(this.$position, this);
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
                if(((List)object0) != null) {
                    ArrayList arrayList0 = new ArrayList(((List)object0));
                    LocalContentGenreListFragment.this.playSongs(arrayList0, true, false, false);
                }
                return H.a;
            }
        }


        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.fragments.local.LocalContentGenreListFragment$showContextListPopup$1$2", f = "LocalContentGenreListFragment.kt", l = {0xEA}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.local.LocalContentGenreListFragment.showContextListPopup.1.2 extends oe.i implements we.n {
            final int $position;
            int label;

            public com.iloen.melon.fragments.local.LocalContentGenreListFragment.showContextListPopup.1.2(LocalContentGenreListFragment localContentGenreListFragment0, int v, Continuation continuation0) {
                LocalContentGenreListFragment.this = localContentGenreListFragment0;
                this.$position = v;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalContentGenreListFragment.showContextListPopup.1.2(LocalContentGenreListFragment.this, this.$position, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalContentGenreListFragment.showContextListPopup.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        n.D(object0);
                        z z0 = LocalContentGenreListFragment.this.getPlayerUseCase();
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
                    Bc.h h0 = LocalContentGenreListFragment.this.getPlayerUiHelper();
                    l0 l00 = LocalContentGenreListFragment.this.getChildFragmentManager();
                    q.f(l00, "getChildFragmentManager(...)");
                    h0.e(l00, new o(LocalContentGenreListFragment.this, this.$position, 0));
                    return H.a;
                }
                LocalContentGenreListFragment.this.showTrackAddToLocalPlaylistPopup(this.$position);
                return H.a;

                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
                @e(c = "com.iloen.melon.fragments.local.LocalContentGenreListFragment$showContextListPopup$1$2$1$1", f = "LocalContentGenreListFragment.kt", l = {0xEF}, m = "invokeSuspend")
                final class com.iloen.melon.fragments.local.LocalContentGenreListFragment.showContextListPopup.1.2.1.1 extends oe.i implements we.n {
                    final int $position;
                    int label;

                    public com.iloen.melon.fragments.local.LocalContentGenreListFragment.showContextListPopup.1.2.1.1(LocalContentGenreListFragment localContentGenreListFragment0, int v, Continuation continuation0) {
                        LocalContentGenreListFragment.this = localContentGenreListFragment0;
                        this.$position = v;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.fragments.local.LocalContentGenreListFragment.showContextListPopup.1.2.1.1(LocalContentGenreListFragment.this, this.$position, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.fragments.local.LocalContentGenreListFragment.showContextListPopup.1.2.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        a a0 = a.a;
                        switch(this.label) {
                            case 0: {
                                n.D(object0);
                                z z0 = LocalContentGenreListFragment.this.getPlayerUseCase();
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
                        LocalContentGenreListFragment.this.showTrackAddToLocalPlaylistPopup(this.$position);
                        return H.a;
                    }
                }

            }

            private static final H invokeSuspend$lambda$0(LocalContentGenreListFragment localContentGenreListFragment0, int v) {
                BuildersKt__Builders_commonKt.launch$default(f0.f(localContentGenreListFragment0), Dispatchers.getMain(), null, new com.iloen.melon.fragments.local.LocalContentGenreListFragment.showContextListPopup.1.2.1.1(localContentGenreListFragment0, v, null), 2, null);
                return H.a;
            }
        }

    }

    private static final void showContextListPopup$lambda$1(LocalContentGenreListFragment localContentGenreListFragment0, int v, ContextItemInfo contextItemInfo0, ContextItemType contextItemType0, Params contextItemInfo$Params0) {
        if(ContextItemType.f.equals(contextItemType0)) {
            f0.f(localContentGenreListFragment0).a(new com.iloen.melon.fragments.local.LocalContentGenreListFragment.showContextListPopup.1.1(localContentGenreListFragment0, v, null));
            return;
        }
        if(ContextItemType.g.equals(contextItemType0)) {
            BuildersKt__Builders_commonKt.launch$default(f0.f(localContentGenreListFragment0), Dispatchers.getMain(), null, new com.iloen.melon.fragments.local.LocalContentGenreListFragment.showContextListPopup.1.2(localContentGenreListFragment0, v, null), 2, null);
            return;
        }
        if(ContextItemType.n.equals(contextItemType0)) {
            localContentGenreListFragment0.deleteGenre(v);
        }
    }

    private final void showTrackAddToLocalPlaylistPopup(int v) {
        j0 j00 = this.mAdapter;
        if(j00 != null && j00 instanceof LocalGenreAdapter) {
            this.mGenreTitle = ((l)((LocalGenreAdapter)j00).getItem(v)).b;
        }
        this.showTrackAddToLocalPlaylistPopup(this.mGenreTitle, new com.iloen.melon.fragments.local.n(this, v));

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.fragments.local.LocalContentGenreListFragment$showTrackAddToLocalPlaylistPopup$2$1", f = "LocalContentGenreListFragment.kt", l = {329}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.local.LocalContentGenreListFragment.showTrackAddToLocalPlaylistPopup.2.1 extends oe.i implements we.n {
            final int $position;
            int label;

            public com.iloen.melon.fragments.local.LocalContentGenreListFragment.showTrackAddToLocalPlaylistPopup.2.1(LocalContentGenreListFragment localContentGenreListFragment0, int v, Continuation continuation0) {
                LocalContentGenreListFragment.this = localContentGenreListFragment0;
                this.$position = v;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalContentGenreListFragment.showTrackAddToLocalPlaylistPopup.2.1(LocalContentGenreListFragment.this, this.$position, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalContentGenreListFragment.showTrackAddToLocalPlaylistPopup.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        n.D(object0);
                        this.label = 1;
                        object0 = LocalContentGenreListFragment.this.getPlayableList(this.$position, this);
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
                if(((List)object0) != null) {
                    ArrayList arrayList0 = new ArrayList(((List)object0));
                    LocalContentGenreListFragment.this.playSongs(arrayList0, false, false, false);
                }
                return H.a;
            }
        }

    }

    private static final void showTrackAddToLocalPlaylistPopup$lambda$5(LocalContentGenreListFragment localContentGenreListFragment0, int v, M m0) {
        if(M.S == m0) {
            f0.f(localContentGenreListFragment0).a(new com.iloen.melon.fragments.local.LocalContentGenreListFragment.showTrackAddToLocalPlaylistPopup.2.1(localContentGenreListFragment0, v, null));
            return;
        }
        if(M.V == m0) {
            localContentGenreListFragment0.showLocalPlaylistPopup();
            return;
        }
        if(M.T == m0) {
            localContentGenreListFragment0.onAddToPlaylist(null);
        }
    }

    private final void startQuery() {
        f0.f(this).a(new we.n(null) {
            int label;

            {
                LocalContentGenreListFragment.this = localContentGenreListFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalContentGenreListFragment.startQuery.1(LocalContentGenreListFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalContentGenreListFragment.startQuery.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        n.D(object0);
                        com.iloen.melon.fragments.local.LocalContentGenreListFragment.startQuery.1.list.1 localContentGenreListFragment$startQuery$1$list$10 = new we.n(null) {
                            int label;

                            {
                                LocalContentGenreListFragment.this = localContentGenreListFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.local.LocalContentGenreListFragment.startQuery.1.list.1(LocalContentGenreListFragment.this, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.local.LocalContentGenreListFragment.startQuery.1.list.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                n.D(object0);
                                z6.f f0 = g.a;
                                if(LocalContentGenreListFragment.this.mIsFlac) {
                                    f0.m();
                                    return (List)w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new K1(15));
                                }
                                f0.m();
                                return (List)w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new K1(17));
                            }
                        };
                        this.label = 1;
                        object0 = BuildersKt.withContext(Dispatchers.getIO(), localContentGenreListFragment$startQuery$1$list$10, this);
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
                j0 j00 = LocalContentGenreListFragment.this.mAdapter;
                if(j00 != null) {
                    LocalContentGenreListFragment localContentGenreListFragment0 = LocalContentGenreListFragment.this;
                    if(j00 instanceof LocalGenreAdapter) {
                        ((LocalGenreAdapter)j00).clear();
                        ((LocalGenreAdapter)j00).addAll(((List)object0));
                        localContentGenreListFragment0.performFetchCompleteOnlyViews();
                    }
                }
                return H.a;
            }
        });
    }
}

