package com.iloen.melon.fragments.searchandadd;

import De.d;
import Gd.f;
import M6.B;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.j0;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.SongHolder;
import com.melon.playlist.interfaces.PlayableData;
import d3.g;
import d5.n;
import e.k;
import e1.b;
import ie.j;
import java.util.ArrayList;
import java.util.List;
import kc.B2;
import kc.d3;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oc.H;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.i;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0082@¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\'\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0012\u001A\u00020\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u001B\u0010\u0019\u001A\u0006\u0012\u0002\b\u00030\u00182\u0006\u0010\u0017\u001A\u00020\u0016H\u0014¢\u0006\u0004\b\u0019\u0010\u001AR\u001B\u0010 \u001A\u00020\u001B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\u001F¨\u0006#"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddSongListFragment;", "Lcom/iloen/melon/fragments/searchandadd/SearchAndAddBaseFragment;", "<init>", "()V", "", "Lcom/melon/playlist/interfaces/PlayableData;", "fetchNowplayingData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchViewModel;", "playlistSearchViewModel$delegate", "Lie/j;", "getPlaylistSearchViewModel", "()Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchViewModel;", "playlistSearchViewModel", "Companion", "SearchAndAddNowPlayingSongAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistSearchAndAddSongListFragment extends SearchAndAddBaseFragment {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001A\u00020\tR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddSongListFragment$Companion;", "", "<init>", "()V", "TAG", "", "VIEW_TYPE_ITEM", "", "newInstance", "Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddSongListFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final PlaylistSearchAndAddSongListFragment newInstance() {
            return new PlaylistSearchAndAddSongListFragment();
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B!\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\r\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0012\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0011\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\'\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0014\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddSongListFragment$SearchAndAddNowPlayingSongAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/melon/playlist/interfaces/PlayableData;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddSongListFragment;Landroid/content/Context;Ljava/util/List;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "SearchSongHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class SearchAndAddNowPlayingSongAdapter extends p {
        @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001A\u0010\u0006\u001A\u00020\u0007X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u001A\u0010\f\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddSongListFragment$SearchAndAddNowPlayingSongAdapter$SearchSongHolder;", "Lcom/iloen/melon/viewholders/SongHolder;", "view", "Landroid/view/View;", "<init>", "(Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddSongListFragment$SearchAndAddNowPlayingSongAdapter;Landroid/view/View;)V", "ivAddBtn", "Landroid/widget/ImageView;", "getIvAddBtn", "()Landroid/widget/ImageView;", "setIvAddBtn", "(Landroid/widget/ImageView;)V", "ivPlayHighlight", "getIvPlayHighlight", "()Landroid/view/View;", "setIvPlayHighlight", "(Landroid/view/View;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class SearchSongHolder extends SongHolder {
            @NotNull
            private ImageView ivAddBtn;
            @NotNull
            private View ivPlayHighlight;

            public SearchSongHolder(@NotNull View view0) {
                q.g(view0, "view");
                SearchAndAddNowPlayingSongAdapter.this = playlistSearchAndAddSongListFragment$SearchAndAddNowPlayingSongAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A05E2);  // id:iv_add_btn
                q.f(view1, "findViewById(...)");
                this.ivAddBtn = (ImageView)view1;
                View view2 = view0.findViewById(0x7F0A0661);  // id:iv_play_highlight
                q.f(view2, "findViewById(...)");
                this.ivPlayHighlight = view2;
            }

            @NotNull
            public final ImageView getIvAddBtn() {
                return this.ivAddBtn;
            }

            @NotNull
            public final View getIvPlayHighlight() {
                return this.ivPlayHighlight;
            }

            public final void setIvAddBtn(@NotNull ImageView imageView0) {
                q.g(imageView0, "<set-?>");
                this.ivAddBtn = imageView0;
            }

            public final void setIvPlayHighlight(@NotNull View view0) {
                q.g(view0, "<set-?>");
                this.ivPlayHighlight = view0;
            }
        }

        public SearchAndAddNowPlayingSongAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
        }

        public static void c(View view0) {
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return 0;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            if(o00.getItemViewType() == 0 && o00 instanceof SearchSongHolder) {
                PlayableData playableData0 = (PlayableData)this.getItem(v1);
                Playable playable0 = playableData0.a;
                boolean z = playable0.isService();
                ViewUtils.setEnable(o00.itemView, z);
                if(playable0.isService()) {
                    PlaylistSearchViewModel playlistSearchViewModel0 = PlaylistSearchAndAddSongListFragment.this.getPlaylistSearchViewModel();
                    q.f("", "getSongidString(...)");
                    ((SearchSongHolder)o00).getIvAddBtn().setImageResource((playlistSearchViewModel0.containsSongId("") ? 0x7F0800E0 : 0x7F0800DF));  // drawable:btn_add_24_on
                    ViewUtils.setOnClickListener(((SearchSongHolder)o00).getIvAddBtn(), new h(PlaylistSearchAndAddSongListFragment.this, playable0, this, v1, 2));
                }
                else {
                    f f0 = new f(10);
                    ViewUtils.setOnClickListener(o00.itemView, f0);
                    int v2 = ColorUtils.getColor(this.getContext(), 0x7F06048A);  // color:transparent
                    o00.itemView.setBackgroundColor(v2);
                }
                ImageView imageView0 = ((SearchSongHolder)o00).thumbnailIv;
                if(imageView0 != null) {
                    Glide.with(imageView0.getContext()).load(playableData0.m).into(((SearchSongHolder)o00).thumbnailIv);
                }
                ViewUtils.setOnClickListener(((SearchSongHolder)o00).getIvPlayHighlight(), new com.iloen.melon.fragments.searchandadd.f(4, PlaylistSearchAndAddSongListFragment.this, playable0));
                ((SearchSongHolder)o00).titleTv.setText("");
                ((SearchSongHolder)o00).artistTv.setText("");
                ViewUtils.showWhen(((SearchSongHolder)o00).list19Iv, playable0.isAdult());
                ViewUtils.showWhen(((SearchSongHolder)o00).listFreeIv, playable0.isFree());
                ViewUtils.showWhen(((SearchSongHolder)o00).listHoldbackIv, playable0.isHoldback());
            }
        }

        private static final void onBindViewImpl$lambda$0(PlaylistSearchAndAddSongListFragment playlistSearchAndAddSongListFragment0, Playable playable0, SearchAndAddNowPlayingSongAdapter playlistSearchAndAddSongListFragment$SearchAndAddNowPlayingSongAdapter0, int v, View view0) {
            PlaylistSearchViewModel playlistSearchViewModel0 = playlistSearchAndAddSongListFragment0.getPlaylistSearchViewModel();
            q.f("", "getSongidString(...)");
            if(playlistSearchViewModel0.containsSongId("")) {
                PlaylistSearchViewModel playlistSearchViewModel1 = playlistSearchAndAddSongListFragment0.getPlaylistSearchViewModel();
                q.f("", "getSongidString(...)");
                playlistSearchViewModel1.removeSong("");
            }
            else {
                PlaylistSearchViewModel playlistSearchViewModel2 = playlistSearchAndAddSongListFragment0.getPlaylistSearchViewModel();
                q.f("", "getSongidString(...)");
                if(!playlistSearchViewModel2.addSong("")) {
                    ToastManager.show(playlistSearchAndAddSongListFragment0.getPlaylistSearchViewModel().getOverSelectMessage());
                }
            }
            playlistSearchAndAddSongListFragment$SearchAndAddNowPlayingSongAdapter0.notifyItemChanged(v);
        }

        private static final void onBindViewImpl$lambda$1(View view0) {
        }

        private static final void onBindViewImpl$lambda$2(PlaylistSearchAndAddSongListFragment playlistSearchAndAddSongListFragment0, Playable playable0, View view0) {
            playlistSearchAndAddSongListFragment0.showInstantPlayPopup(playable0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            View view0 = this.mInflater.inflate(0x7F0D04A9, viewGroup0, false);  // layout:listitem_song_dj_search
            q.f(view0, "inflate(...)");
            return new SearchSongHolder(this, view0);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "PlaylistSearchAndAddSongListFragment";
    private static final int VIEW_TYPE_ITEM;
    @NotNull
    private final j playlistSearchViewModel$delegate;

    static {
        PlaylistSearchAndAddSongListFragment.Companion = new Companion(null);
        PlaylistSearchAndAddSongListFragment.$stable = 8;
    }

    public PlaylistSearchAndAddSongListFragment() {
        this.playlistSearchViewModel$delegate = g.Q(new e(this, 2));
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new SearchAndAddNowPlayingSongAdapter(this, context0, null);
        ((p)j00).setErrorViewResId(0x7F0D002A);  // layout:adapter_network_error_view_search
        v9.e e0 = new v9.e();  // 初始化器: Ljava/lang/Object;-><init>()V
        e0.d = -1;
        e0.e = -1;
        e0.g = -1;
        e0.i = -1;
        e0.k = -1;
        e0.l = -1;
        e0.f = this.getString(0x7F130827);  // string:playlist_edit_playlist_song_list_empty "재생목록 곡이 없습니다."
        ((p)j00).setEmptyViewResId(0x7F0D0022);  // layout:adapter_empty_view
        ((p)j00).setEmptyViewInfo(e0);
        return j00;
    }

    private final Object fetchNowplayingData(Continuation continuation0) {
        com.iloen.melon.fragments.searchandadd.PlaylistSearchAndAddSongListFragment.fetchNowplayingData.1 playlistSearchAndAddSongListFragment$fetchNowplayingData$10;
        if(continuation0 instanceof com.iloen.melon.fragments.searchandadd.PlaylistSearchAndAddSongListFragment.fetchNowplayingData.1) {
            playlistSearchAndAddSongListFragment$fetchNowplayingData$10 = (com.iloen.melon.fragments.searchandadd.PlaylistSearchAndAddSongListFragment.fetchNowplayingData.1)continuation0;
            int v = playlistSearchAndAddSongListFragment$fetchNowplayingData$10.label;
            if((v & 0x80000000) == 0) {
                playlistSearchAndAddSongListFragment$fetchNowplayingData$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.fetchNowplayingData(this);
                    }
                };
            }
            else {
                playlistSearchAndAddSongListFragment$fetchNowplayingData$10.label = v ^ 0x80000000;
            }
        }
        else {
            playlistSearchAndAddSongListFragment$fetchNowplayingData$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.fetchNowplayingData(this);
                }
            };
        }
        Object object0 = playlistSearchAndAddSongListFragment$fetchNowplayingData$10.result;
        a a0 = a.a;
        switch(playlistSearchAndAddSongListFragment$fetchNowplayingData$10.label) {
            case 0: {
                n.D(object0);
                LogU.Companion.v("PlaylistSearchAndAddSongListFragment", "fetchNowplayingData()");
                B b0 = ListenableFutureKt.future$default(((d3)this.playlistManager).b, null, null, new B2(((d3)this.playlistManager), null), 3, null);
                playlistSearchAndAddSongListFragment$fetchNowplayingData$10.label = 1;
                object0 = ListenableFutureKt.await(b0, playlistSearchAndAddSongListFragment$fetchNowplayingData$10);
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
        if(!k.y(((H)object0))) {
            for(Object object1: b.B(((H)object0).getState())) {
                ((Playable)object1).setService(true);
                ((Playable)object1).toSong();
            }
            return b.w(((H)object0).getState());
        }
        return null;
    }

    private final PlaylistSearchViewModel getPlaylistSearchViewModel() {
        return (PlaylistSearchViewModel)this.playlistSearchViewModel$delegate.getValue();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        this.getPlaylistSearchViewModel().getSongList().observe(this.requireActivity(), new PlaylistSearchAndAddSongListFragment.sam.androidx_lifecycle_Observer.0(new com.iloen.melon.fragments.searchandadd.a(this, 3)));
    }

    private static final ie.H onCreate$lambda$1(PlaylistSearchAndAddSongListFragment playlistSearchAndAddSongListFragment0, ArrayList arrayList0) {
        j0 j00 = playlistSearchAndAddSongListFragment0.getAdapter();
        if(j00 != null) {
            j00.notifyDataSetChanged();
        }
        return ie.H.a;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull v9.h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        p p0 = this.getMelonArrayAdapter();
        if(p0 != null) {
            p0.clear();
        }
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), Dispatchers.getIO(), null, new we.n(null) {
            Object L$0;
            int label;

            {
                PlaylistSearchAndAddSongListFragment.this = playlistSearchAndAddSongListFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.searchandadd.PlaylistSearchAndAddSongListFragment.onFetchStart.1(PlaylistSearchAndAddSongListFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.searchandadd.PlaylistSearchAndAddSongListFragment.onFetchStart.1)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        n.D(object0);
                        this.label = 1;
                        object0 = PlaylistSearchAndAddSongListFragment.this.fetchNowplayingData(this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        n.D(object0);
                        break;
                    }
                    case 2: {
                        List list0 = (List)this.L$0;
                        n.D(object0);
                        return ie.H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                com.iloen.melon.fragments.searchandadd.PlaylistSearchAndAddSongListFragment.onFetchStart.1.1 playlistSearchAndAddSongListFragment$onFetchStart$1$10 = new we.n(PlaylistSearchAndAddSongListFragment.this, null) {
                    final List $data;
                    int label;

                    {
                        this.$data = list0;
                        PlaylistSearchAndAddSongListFragment.this = playlistSearchAndAddSongListFragment0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.fragments.searchandadd.PlaylistSearchAndAddSongListFragment.onFetchStart.1.1(this.$data, PlaylistSearchAndAddSongListFragment.this, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.fragments.searchandadd.PlaylistSearchAndAddSongListFragment.onFetchStart.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        if(this.label != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        n.D(object0);
                        if(this.$data != null && !this.$data.isEmpty()) {
                            PlaylistSearchAndAddSongListFragment.this.hideEmptyAndErrorView();
                        }
                        j0 j00 = PlaylistSearchAndAddSongListFragment.this.getAdapter();
                        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.searchandadd.PlaylistSearchAndAddSongListFragment.SearchAndAddNowPlayingSongAdapter");
                        ((SearchAndAddNowPlayingSongAdapter)j00).addAll(this.$data);
                        return ie.H.a;
                    }
                };
                this.L$0 = null;
                this.label = 2;
                return BuildersKt.withContext(Dispatchers.getMain(), playlistSearchAndAddSongListFragment$onFetchStart$1$10, this) == a0 ? a0 : ie.H.a;
            }
        }, 2, null);
        return false;
    }

    private static final PlaylistSearchViewModel playlistSearchViewModel_delegate$lambda$0(PlaylistSearchAndAddSongListFragment playlistSearchAndAddSongListFragment0) {
        FragmentActivity fragmentActivity0 = playlistSearchAndAddSongListFragment0.requireActivity();
        q.f(fragmentActivity0, "requireActivity(...)");
        q0 q00 = fragmentActivity0.getViewModelStore();
        o0 o00 = fragmentActivity0.getDefaultViewModelProviderFactory();
        S2.c c0 = fragmentActivity0.getDefaultViewModelCreationExtras();
        q.g(q00, "store");
        q.g(o00, "factory");
        o9.b b0 = com.iloen.melon.utils.a.p(c0, "defaultCreationExtras", q00, o00, c0);
        d d0 = df.d.y(PlaylistSearchViewModel.class);
        String s = d0.l();
        if(s == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (PlaylistSearchViewModel)b0.s(d0, "androidx.lifecycle.ViewModelProvider.DefaultKey:" + s);
    }
}

