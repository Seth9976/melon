package com.iloen.melon.fragments.searchandadd;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.Listener;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.l1;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.LikeListSongBaseReq.Params;
import com.iloen.melon.net.v4x.request.MyMusicPlaylistInsertLikeListSongReq;
import com.iloen.melon.net.v4x.response.LikeListSongBaseRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.popup.BottomSingleFilterListPopup;
import d3.g;
import e1.u;
import ie.H;
import ie.j;
import java.util.ArrayList;
import java.util.List;
import je.n;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import o9.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import v9.i;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 *2\u00020\u0001:\u0002*+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000BJ\u0019\u0010\u000E\u001A\u00020\t2\b\u0010\r\u001A\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\'\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\u0004H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001B\u0010\u001B\u001A\u0006\u0012\u0002\b\u00030\u001A2\u0006\u0010\u0019\u001A\u00020\u0018H\u0014¢\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001D\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u001D\u0010\u0006R?\u0010$\u001A&\u0012\f\u0012\n \u001F*\u0004\u0018\u00010\u00040\u0004 \u001F*\u0012\u0012\u000E\b\u0001\u0012\n \u001F*\u0004\u0018\u00010\u00040\u00040\u001E0\u001E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001A\u0004\b\"\u0010#R\u001B\u0010)\u001A\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010!\u001A\u0004\b\'\u0010(¨\u0006,"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddLikeFragment;", "Lcom/iloen/melon/fragments/searchandadd/SearchAndAddBaseFragment;", "<init>", "()V", "", "getOrderByValue", "()Ljava/lang/String;", "Landroid/widget/TextView;", "tvToggleButton", "Lie/H;", "showContextPopupSort", "(Landroid/widget/TextView;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "getCacheKey", "", "kotlin.jvm.PlatformType", "filterNameList$delegate", "Lie/j;", "getFilterNameList", "()[Ljava/lang/String;", "filterNameList", "Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchViewModel;", "playlistSearchViewModel$delegate", "getPlaylistSearchViewModel", "()Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchViewModel;", "playlistSearchViewModel", "Companion", "SearchAndAddSongLikeAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistSearchAndAddLikeFragment extends SearchAndAddBaseFragment {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001A\u00020\tH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddLikeFragment$Companion;", "", "<init>", "()V", "TAG", "", "PAGE_SIZE", "", "newInstance", "Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddLikeFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final PlaylistSearchAndAddLikeFragment newInstance() {
            PlaylistSearchAndAddLikeFragment playlistSearchAndAddLikeFragment0 = new PlaylistSearchAndAddLikeFragment();
            playlistSearchAndAddLikeFragment0.setArguments(new Bundle());
            return playlistSearchAndAddLikeFragment0;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001:\u0001\u001BB#\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\u0010\u0010\u0006\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\f\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\u000B\u001A\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\tH\u0014¢\u0006\u0004\b\u000E\u0010\u000FJ\u001F\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0019\u001A\u00020\u00182\b\u0010\u0017\u001A\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001A¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddLikeFragment$SearchAndAddSongLikeAdapter;", "Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddAdapter;", "Landroid/content/Context;", "context", "", "Lcom/melon/net/res/common/SongInfoBase;", "list", "<init>", "(Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddLikeFragment;Landroid/content/Context;Ljava/util/List;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "getHeaderViewItemCount", "()I", "Landroid/view/ViewGroup;", "parent", "viewType", "Landroidx/recyclerview/widget/O0;", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "Lcom/iloen/melon/playback/Playable;", "playable", "Lie/H;", "onInstantPlayShow", "(Lcom/iloen/melon/playback/Playable;)V", "ToggleFilterHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class SearchAndAddSongLikeAdapter extends PlaylistSearchAndAddAdapter {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddLikeFragment$SearchAndAddSongLikeAdapter$ToggleFilterHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddLikeFragment$SearchAndAddSongLikeAdapter;Landroid/view/View;)V", "Landroid/widget/TextView;", "tvToggleButton", "Landroid/widget/TextView;", "getTvToggleButton", "()Landroid/widget/TextView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ToggleFilterHolder extends O0 {
            @NotNull
            private final TextView tvToggleButton;

            public ToggleFilterHolder(@NotNull View view0) {
                q.g(view0, "view");
                SearchAndAddSongLikeAdapter.this = playlistSearchAndAddLikeFragment$SearchAndAddSongLikeAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0D42);  // id:tv_toggle_button
                q.f(view1, "findViewById(...)");
                this.tvToggleButton = (TextView)view1;
                ((TextView)view1).setOnClickListener(new d(PlaylistSearchAndAddLikeFragment.this, 0));
                String[] arr_s = PlaylistSearchAndAddLikeFragment.this.getFilterNameList();
                ((TextView)view1).setText(arr_s[PlaylistSearchAndAddLikeFragment.this.mSortType]);
            }

            private static final void _init_$lambda$0(PlaylistSearchAndAddLikeFragment playlistSearchAndAddLikeFragment0, View view0) {
                q.e(view0, "null cannot be cast to non-null type android.widget.TextView");
                playlistSearchAndAddLikeFragment0.showContextPopupSort(((TextView)view0));
            }

            @NotNull
            public final TextView getTvToggleButton() {
                return this.tvToggleButton;
            }
        }

        public SearchAndAddSongLikeAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0, playlistSearchAndAddLikeFragment0.getPlaylistSearchViewModel());
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return !this.getList().isEmpty();
        }

        @Override  // com.iloen.melon.fragments.searchandadd.PlaylistSearchAndAddAdapter
        public int getItemViewTypeImpl(int v, int v1) {
            return this.getHeaderViewItemCount() <= 0 || v != this.getAvailableHeaderPosition() ? 1 : 0;
        }

        @Override  // com.iloen.melon.fragments.searchandadd.PlaylistSearchAndAddAdapter
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            if(v == 0) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0275, viewGroup0, false);  // layout:filter_playlist_search_toggle
                q.f(view0, "inflate(...)");
                return new ToggleFilterHolder(this, view0);
            }
            return super.onCreateViewHolderImpl(viewGroup0, v);
        }

        @Override  // com.iloen.melon.fragments.searchandadd.PlaylistSearchAndAddAdapter
        public void onInstantPlayShow(@Nullable Playable playable0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int PAGE_SIZE = 100;
    @NotNull
    private static final String TAG = "SongLikeSearchAndAddFragment";
    @NotNull
    private final j filterNameList$delegate;
    @NotNull
    private final j playlistSearchViewModel$delegate;

    static {
        PlaylistSearchAndAddLikeFragment.Companion = new Companion(null);
        PlaylistSearchAndAddLikeFragment.$stable = 8;
    }

    public PlaylistSearchAndAddLikeFragment() {
        this.filterNameList$delegate = g.Q(new c(this, 0));
        this.playlistSearchViewModel$delegate = g.Q(new c(this, 1));
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new SearchAndAddSongLikeAdapter(this, context0, null);
    }

    private static final String[] filterNameList_delegate$lambda$0(PlaylistSearchAndAddLikeFragment playlistSearchAndAddLikeFragment0) {
        return playlistSearchAndAddLikeFragment0.getResources().getStringArray(0x7F03003C);  // array:sortingbar_like_renewal
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.f(MelonContentUris.i.buildUpon().appendPath("songLike"), "orderBy", this.getOrderByValue(), "toString(...)");
    }

    private final String[] getFilterNameList() {
        return (String[])this.filterNameList$delegate.getValue();
    }

    private final String getOrderByValue() {
        int v = this.mSortType;
        if(v == 0) {
            return "NEW";
        }
        return v == 1 ? "ARTIST" : "ALPHABET";
    }

    private final PlaylistSearchViewModel getPlaylistSearchViewModel() {
        return (PlaylistSearchViewModel)this.playlistSearchViewModel$delegate.getValue();
    }

    @NotNull
    public static final PlaylistSearchAndAddLikeFragment newInstance() {
        return PlaylistSearchAndAddLikeFragment.Companion.newInstance();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        this.getPlaylistSearchViewModel().getSongList().observe(this.requireActivity(), new PlaylistSearchAndAddLikeFragment.sam.androidx_lifecycle_Observer.0(new a(this, 0)));
    }

    private static final H onCreate$lambda$2(PlaylistSearchAndAddLikeFragment playlistSearchAndAddLikeFragment0, ArrayList arrayList0) {
        j0 j00 = playlistSearchAndAddLikeFragment0.getAdapter();
        if(j00 != null) {
            j00.notifyDataSetChanged();
        }
        return H.a;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull h h0, @NotNull String s) {
        int v;
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        if(i.c.equals(i0)) {
            p p0 = this.getMelonArrayAdapter();
            v = (p0 == null ? 0 : p0.getCount()) + 1;
        }
        else {
            this.clearData();
            v = 1;
        }
        Params likeListSongBaseReq$Params0 = new Params();
        likeListSongBaseReq$Params0.startIndex = v;
        likeListSongBaseReq$Params0.pageSize = 100;
        likeListSongBaseReq$Params0.targetMemberKey = u.v(((e0)o.a()).j());
        likeListSongBaseReq$Params0.orderBy = this.getOrderByValue();
        RequestBuilder.newInstance(new MyMusicPlaylistInsertLikeListSongReq(this.getContext(), likeListSongBaseReq$Params0)).tag("SongLikeSearchAndAddFragment").listener(new Listener() {
            public void onResponse(LikeListSongBaseRes likeListSongBaseRes0) {
                if(!i0.prepareFetchComplete(likeListSongBaseRes0)) {
                    return;
                }
                i0.performFetchComplete(this.$type, likeListSongBaseRes0);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((LikeListSongBaseRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final PlaylistSearchViewModel playlistSearchViewModel_delegate$lambda$1(PlaylistSearchAndAddLikeFragment playlistSearchAndAddLikeFragment0) {
        FragmentActivity fragmentActivity0 = playlistSearchAndAddLikeFragment0.requireActivity();
        q.f(fragmentActivity0, "requireActivity(...)");
        q0 q00 = fragmentActivity0.getViewModelStore();
        o0 o00 = fragmentActivity0.getDefaultViewModelProviderFactory();
        S2.c c0 = fragmentActivity0.getDefaultViewModelCreationExtras();
        q.g(q00, "store");
        q.g(o00, "factory");
        b b0 = com.iloen.melon.utils.a.p(c0, "defaultCreationExtras", q00, o00, c0);
        De.d d0 = df.d.y(PlaylistSearchViewModel.class);
        String s = d0.l();
        if(s == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (PlaylistSearchViewModel)b0.s(d0, "androidx.lifecycle.ViewModelProvider.DefaultKey:" + s);
    }

    private final void showContextPopupSort(TextView textView0) {
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 == null || this.isRetainedPopupShowing()) {
            return;
        }
        BottomSingleFilterListPopup bottomSingleFilterListPopup0 = new BottomSingleFilterListPopup(fragmentActivity0);
        bottomSingleFilterListPopup0.setTitle(0x7F1307D1);  // string:order_by "정렬"
        bottomSingleFilterListPopup0.setFilterItem(n.z0(this.getFilterNameList()), this.mSortType);
        bottomSingleFilterListPopup0.setFilterListener(new com.iloen.melon.fragments.searchandadd.b(this, textView0, 0));
        bottomSingleFilterListPopup0.setOnDismissListener(this.mDialogDismissListener);
        this.mRetainDialog = bottomSingleFilterListPopup0;
        bottomSingleFilterListPopup0.show();
    }

    private static final void showContextPopupSort$lambda$3(PlaylistSearchAndAddLikeFragment playlistSearchAndAddLikeFragment0, TextView textView0, int v) {
        if(v == playlistSearchAndAddLikeFragment0.mSortType) {
            return;
        }
        playlistSearchAndAddLikeFragment0.mSortType = v;
        String[] arr_s = playlistSearchAndAddLikeFragment0.getFilterNameList();
        textView0.setText(arr_s[playlistSearchAndAddLikeFragment0.mSortType]);
        playlistSearchAndAddLikeFragment0.startFetch("sorting");
    }
}

