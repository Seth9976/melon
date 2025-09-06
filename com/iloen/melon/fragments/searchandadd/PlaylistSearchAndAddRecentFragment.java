package com.iloen.melon.fragments.searchandadd;

import De.d;
import S2.c;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.Listener;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v5x.request.MyMusicRecentListSongRecntReq;
import com.iloen.melon.net.v5x.request.RecentListSongRecntBaseReq.Params;
import com.iloen.melon.net.v5x.response.RecentListSongRecntResBase;
import com.iloen.melon.playback.Playable;
import d3.g;
import e1.u;
import ie.H;
import ie.j;
import java.util.ArrayList;
import java.util.List;
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

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u001F2\u00020\u0001:\u0002\u001F B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\'\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\rH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u001B\u0010\u0015\u001A\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010\u0013\u001A\u00020\u0012H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000F\u0010\u0017\u001A\u00020\rH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001B\u0010\u001E\u001A\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u001D¨\u0006!"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddRecentFragment;", "Lcom/iloen/melon/fragments/searchandadd/SearchAndAddBaseFragment;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "getCacheKey", "()Ljava/lang/String;", "Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchViewModel;", "playlistSearchViewModel$delegate", "Lie/j;", "getPlaylistSearchViewModel", "()Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchViewModel;", "playlistSearchViewModel", "Companion", "SearchAndAddSongRecentAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistSearchAndAddRecentFragment extends SearchAndAddBaseFragment {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001A\u00020\u0007H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddRecentFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddRecentFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final PlaylistSearchAndAddRecentFragment newInstance() {
            return new PlaylistSearchAndAddRecentFragment();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\u0010\u0010\u0006\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001A\u00020\u000B2\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddRecentFragment$SearchAndAddSongRecentAdapter;", "Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddAdapter;", "Landroid/content/Context;", "context", "", "Lcom/melon/net/res/common/SongInfoBase;", "list", "<init>", "(Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddRecentFragment;Landroid/content/Context;Ljava/util/List;)V", "Lcom/iloen/melon/playback/Playable;", "playable", "Lie/H;", "onInstantPlayShow", "(Lcom/iloen/melon/playback/Playable;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class SearchAndAddSongRecentAdapter extends PlaylistSearchAndAddAdapter {
        public SearchAndAddSongRecentAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0, playlistSearchAndAddRecentFragment0.getPlaylistSearchViewModel());
        }

        @Override  // com.iloen.melon.fragments.searchandadd.PlaylistSearchAndAddAdapter
        public void onInstantPlayShow(@Nullable Playable playable0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "PlaylistSearchAndAddRecentFragment";
    @NotNull
    private final j playlistSearchViewModel$delegate;

    static {
        PlaylistSearchAndAddRecentFragment.Companion = new Companion(null);
        PlaylistSearchAndAddRecentFragment.$stable = 8;
    }

    public PlaylistSearchAndAddRecentFragment() {
        this.playlistSearchViewModel$delegate = g.Q(new e(this, 1));
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new SearchAndAddSongRecentAdapter(this, context0, null);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.i.buildUpon().appendPath("songRecent").build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    private final PlaylistSearchViewModel getPlaylistSearchViewModel() {
        return (PlaylistSearchViewModel)this.playlistSearchViewModel$delegate.getValue();
    }

    @NotNull
    public static final PlaylistSearchAndAddRecentFragment newInstance() {
        return PlaylistSearchAndAddRecentFragment.Companion.newInstance();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        this.getPlaylistSearchViewModel().getSongList().observe(this.requireActivity(), new PlaylistSearchAndAddRecentFragment.sam.androidx_lifecycle_Observer.0(new a(this, 2)));
    }

    private static final H onCreate$lambda$1(PlaylistSearchAndAddRecentFragment playlistSearchAndAddRecentFragment0, ArrayList arrayList0) {
        j0 j00 = playlistSearchAndAddRecentFragment0.getAdapter();
        if(j00 != null) {
            j00.notifyDataSetChanged();
        }
        return H.a;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        if(i.b.equals(i0)) {
            this.clearData();
        }
        Params recentListSongRecntBaseReq$Params0 = new Params();
        recentListSongRecntBaseReq$Params0.targetMemberKey = u.v(((e0)o.a()).j());
        RequestBuilder.newInstance(new MyMusicRecentListSongRecntReq(this.getContext(), recentListSongRecntBaseReq$Params0)).tag("PlaylistSearchAndAddRecentFragment").listener(new Listener() {
            public void onResponse(RecentListSongRecntResBase recentListSongRecntResBase0) {
                if(!i0.prepareFetchComplete(recentListSongRecntResBase0)) {
                    return;
                }
                i0.performFetchComplete(this.$type, recentListSongRecntResBase0);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((RecentListSongRecntResBase)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final PlaylistSearchViewModel playlistSearchViewModel_delegate$lambda$0(PlaylistSearchAndAddRecentFragment playlistSearchAndAddRecentFragment0) {
        FragmentActivity fragmentActivity0 = playlistSearchAndAddRecentFragment0.requireActivity();
        q.f(fragmentActivity0, "requireActivity(...)");
        q0 q00 = fragmentActivity0.getViewModelStore();
        o0 o00 = fragmentActivity0.getDefaultViewModelProviderFactory();
        c c0 = fragmentActivity0.getDefaultViewModelCreationExtras();
        q.g(q00, "store");
        q.g(o00, "factory");
        b b0 = com.iloen.melon.utils.a.p(c0, "defaultCreationExtras", q00, o00, c0);
        d d0 = df.d.y(PlaylistSearchViewModel.class);
        String s = d0.l();
        if(s == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (PlaylistSearchViewModel)b0.s(d0, "androidx.lifecycle.ViewModelProvider.DefaultKey:" + s);
    }
}

