package com.iloen.melon.fragments.musicmessage;

import B.a;
import W5.e;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.media3.session.H0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.MusicMessageListBanUserReq.Params;
import com.iloen.melon.net.v4x.request.MusicMessageListBanUserReq;
import com.iloen.melon.net.v4x.response.MusicMessageListBanUserRes.RESPONSE.USERLIST;
import com.iloen.melon.net.v4x.response.MusicMessageListBanUserRes;
import com.iloen.melon.net.v6x.request.MusicMessageDeleteBanUserReq;
import com.iloen.melon.net.v6x.response.MusicMessageDeleteBanUserRes;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import e1.u;
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

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u0000 82\u00020\u0001:\u000289B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001A\u00020\u00062\b\u0010\t\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\n\u0010\bJ+\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\f\u001A\u00020\u000B2\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\b\u0010\t\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001A\u00020\u00062\u0006\u0010\u0012\u001A\u00020\u000F2\b\u0010\t\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0016\u001A\u00020\u0015H\u0014\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u001B\u0010\u001B\u001A\u0006\u0012\u0002\b\u00030\u001A2\u0006\u0010\u0019\u001A\u00020\u0018H\u0014\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001E\u001A\u00020\u001DH\u0014\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u000F\u0010!\u001A\u00020 H\u0016\u00A2\u0006\u0004\b!\u0010\"J\u000F\u0010#\u001A\u00020\u0015H\u0016\u00A2\u0006\u0004\b#\u0010\u0017J\'\u0010)\u001A\u00020\u00152\u0006\u0010%\u001A\u00020$2\u0006\u0010\'\u001A\u00020&2\u0006\u0010(\u001A\u00020 H\u0014\u00A2\u0006\u0004\b)\u0010*J\r\u0010+\u001A\u00020\u0006\u00A2\u0006\u0004\b+\u0010\u0003J\u001F\u00100\u001A\u0014\u0012\u0004\u0012\u00020-\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.0,\u00A2\u0006\u0004\b0\u00101J%\u00106\u001A\u00020\u00062\u0006\u00103\u001A\u0002022\u0006\u00104\u001A\u0002022\u0006\u00105\u001A\u00020/\u00A2\u0006\u0004\b6\u00107\u00A8\u0006:"}, d2 = {"Lcom/iloen/melon/fragments/musicmessage/MusicMessageBlockListFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "savedInstanceState", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "hasScrolledLine", "()Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "", "getCacheKey", "()Ljava/lang/String;", "shouldShowMiniPlayer", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "clearData", "Lcom/iloen/melon/adapters/common/p;", "", "Lcom/iloen/melon/fragments/musicmessage/MusicMessageBaseViewHolder;", "Lcom/iloen/melon/net/v4x/response/MusicMessageListBanUserRes$RESPONSE$USERLIST;", "getMelonArrayAdapter", "()Lcom/iloen/melon/adapters/common/p;", "", "adapterposition", "dataposition", "item", "unblockUser", "(IILcom/iloen/melon/net/v4x/response/MusicMessageListBanUserRes$RESPONSE$USERLIST;)V", "Companion", "MusicMessageBlockListAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicMessageBlockListFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001A\u00020\tR\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/musicmessage/MusicMessageBlockListFragment$Companion;", "", "<init>", "()V", "TAG", "", "ROW_COUNT", "", "newInstance", "Lcom/iloen/melon/fragments/musicmessage/MusicMessageBlockListFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MusicMessageBlockListFragment newInstance() {
            MusicMessageBlockListFragment musicMessageBlockListFragment0 = new MusicMessageBlockListFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argMemberKey", u.v(((e0)o.a()).j()));
            bundle0.putBoolean("argIsLoginRequired", true);
            musicMessageBlockListFragment0.setArguments(bundle0);
            return musicMessageBlockListFragment0;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0014¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\u000F\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J%\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u0018\u001A\u00020\u00172\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\r\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/fragments/musicmessage/MusicMessageBlockListFragment$MusicMessageBlockListAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v4x/response/MusicMessageListBanUserRes$RESPONSE$USERLIST;", "Lcom/iloen/melon/fragments/musicmessage/MusicMessageBaseViewHolder;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/musicmessage/MusicMessageBlockListFragment;Landroid/content/Context;Ljava/util/List;)V", "", "getHeaderViewItemCount", "()I", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Lcom/iloen/melon/fragments/musicmessage/MusicMessageBaseViewHolder;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Lcom/iloen/melon/fragments/musicmessage/MusicMessageBaseViewHolder;II)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class MusicMessageBlockListAdapter extends p {
        public MusicMessageBlockListAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            MusicMessageBlockListFragment.this = musicMessageBlockListFragment0;
            super(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return 0;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return 0;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            this.onBindViewImpl(((MusicMessageBaseViewHolder)o00), v, v1);
        }

        public void onBindViewImpl(@NotNull MusicMessageBaseViewHolder musicMessageBaseViewHolder0, int v, int v1) {
            q.g(musicMessageBaseViewHolder0, "viewHolder");
            Object object0 = this.getItem(v1);
            q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v4x.response.MusicMessageListBanUserRes.RESPONSE.USERLIST");
            musicMessageBaseViewHolder0.bindView(((USERLIST)object0), v, v1);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            return this.onCreateViewHolderImpl(viewGroup0, v);
        }

        @NotNull
        public MusicMessageBaseViewHolder onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            View view0 = this.mInflater.inflate(0x7F0D04B9, viewGroup0, false);  // layout:listitem_user
            q.f(view0, "inflate(...)");
            return new MusicMessageBlockListViewHolder(view0, MusicMessageBlockListFragment.this);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    public static final int ROW_COUNT = 30;
    @NotNull
    public static final String TAG = "MusicMessageBlockListFragment";

    static {
        MusicMessageBlockListFragment.Companion = new Companion(null);
        MusicMessageBlockListFragment.$stable = 8;
    }

    public final void clearData() {
        this.getMelonArrayAdapter().clear(false);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new MusicMessageBlockListAdapter(this, context0, null);
    }

    public static void d0(MusicMessageBlockListFragment musicMessageBlockListFragment0, USERLIST musicMessageListBanUserRes$RESPONSE$USERLIST0, int v, MusicMessageDeleteBanUserRes musicMessageDeleteBanUserRes0) {
        MusicMessageBlockListFragment.unblockUser$lambda$5(musicMessageBlockListFragment0, musicMessageListBanUserRes$RESPONSE$USERLIST0, v, musicMessageDeleteBanUserRes0);
    }

    public static void e0(MusicMessageBlockListFragment musicMessageBlockListFragment0, i i0, MusicMessageListBanUserRes musicMessageListBanUserRes0) {
        MusicMessageBlockListFragment.onFetchStart$lambda$3(musicMessageBlockListFragment0, i0, musicMessageListBanUserRes0);
    }

    public static void f0(VolleyError volleyError0) {
        MusicMessageBlockListFragment.unblockUser$lambda$6(volleyError0);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.f(MelonContentUris.G.buildUpon().appendPath("musicMessageBlock"), "userKey", this.mUserKey, "toString(...)");
    }

    @NotNull
    public final p getMelonArrayAdapter() {
        j0 j00 = this.getAdapter();
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.adapters.common.MelonArrayAdapter<kotlin.Any, com.iloen.melon.fragments.musicmessage.MusicMessageBaseViewHolder<com.iloen.melon.net.v4x.response.MusicMessageListBanUserRes.RESPONSE.USERLIST>>");
        return (p)j00;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean hasScrolledLine() {
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(@Nullable Bundle bundle0) {
        LogU.Companion.d("MusicMessageBlockListFragment", "onCreate()");
        super.onCreate(bundle0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(this.getActivity()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D02B9, viewGroup0, false);  // layout:fragment_musicmessage_block_list
        q.f(view0, "inflate(...)");
        return view0;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull h h0, @NotNull String s) {
        int v;
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        LogU.Companion.d("MusicMessageBlockListFragment", "onFetchStart reason: " + s);
        if(i.c.equals(i0)) {
            v = this.getMelonArrayAdapter().getCount() + 1;
        }
        else {
            this.clearData();
            v = 1;
        }
        Params musicMessageListBanUserReq$Params0 = new Params();
        musicMessageListBanUserReq$Params0.startIndex = v;
        musicMessageListBanUserReq$Params0.pageSize = 30;
        RequestBuilder.newInstance(new MusicMessageListBanUserReq(this.getContext(), musicMessageListBanUserReq$Params0)).tag("MusicMessageBlockListFragment").listener(new H0(10, this, i0)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$3(MusicMessageBlockListFragment musicMessageBlockListFragment0, i i0, MusicMessageListBanUserRes musicMessageListBanUserRes0) {
        if(!musicMessageBlockListFragment0.prepareFetchComplete(musicMessageListBanUserRes0)) {
            return;
        }
        musicMessageBlockListFragment0.performFetchComplete(i0, musicMessageListBanUserRes0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(a.s(1));
            titleBar0.setTitle("차단 목록 관리");
            titleBar0.f(false);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }

    public final void unblockUser(int v, int v1, @NotNull USERLIST musicMessageListBanUserRes$RESPONSE$USERLIST0) {
        q.g(musicMessageListBanUserRes$RESPONSE$USERLIST0, "item");
        StringBuilder stringBuilder0 = androidx.appcompat.app.o.t(v, v1, "unblockUser adapterposition: ", " ", " ");
        stringBuilder0.append(v1);
        LogU.Companion.d("MusicMessageBlockListFragment", stringBuilder0.toString());
        if(musicMessageListBanUserRes$RESPONSE$USERLIST0.memberkey == null) {
            return;
        }
        com.iloen.melon.net.v6x.request.MusicMessageDeleteBanUserReq.Params musicMessageDeleteBanUserReq$Params0 = new com.iloen.melon.net.v6x.request.MusicMessageDeleteBanUserReq.Params();
        musicMessageDeleteBanUserReq$Params0.memberKeyBan = musicMessageListBanUserRes$RESPONSE$USERLIST0.memberkey;
        RequestBuilder.newInstance(new MusicMessageDeleteBanUserReq(this.getContext(), musicMessageDeleteBanUserReq$Params0)).tag("MusicMessageBlockListFragment").listener(new e(this, musicMessageListBanUserRes$RESPONSE$USERLIST0, v, 6)).errorListener(new com.google.android.exoplayer2.upstream.cache.a(25)).request();
    }

    private static final void unblockUser$lambda$5(MusicMessageBlockListFragment musicMessageBlockListFragment0, USERLIST musicMessageListBanUserRes$RESPONSE$USERLIST0, int v, MusicMessageDeleteBanUserRes musicMessageDeleteBanUserRes0) {
        if(musicMessageDeleteBanUserRes0 != null && musicMessageDeleteBanUserRes0.isSuccessful() && musicMessageBlockListFragment0.isFragmentValid()) {
            musicMessageBlockListFragment0.getMelonArrayAdapter().remove(musicMessageListBanUserRes$RESPONSE$USERLIST0);
            musicMessageBlockListFragment0.getMelonArrayAdapter().notifyItemRemoved(v);
            musicMessageBlockListFragment0.getMelonArrayAdapter().notifyItemRangeChanged(v, musicMessageBlockListFragment0.getMelonArrayAdapter().getCount());
            if(musicMessageBlockListFragment0.getMelonArrayAdapter().getCount() == 0) {
                musicMessageBlockListFragment0.startFetch();
            }
        }
    }

    private static final void unblockUser$lambda$6(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }
}

