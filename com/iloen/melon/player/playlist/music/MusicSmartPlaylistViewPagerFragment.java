package com.iloen.melon.player.playlist.music;

import De.d;
import H8.i;
import S2.c;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.lifecycle.s;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.player.playlist.MusicPlaylistTabContent;
import com.iloen.melon.player.playlist.PlaylistSharedViewModel;
import com.iloen.melon.player.playlist.search.PlaylistSearchFragment;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;
import we.n;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/player/playlist/music/MusicSmartPlaylistViewPagerFragment;", "Lcom/iloen/melon/player/playlist/PlaylistViewPagerBaseFragment;", "<init>", "()V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroidx/fragment/app/I;", "getCurrentFragment", "()Landroidx/fragment/app/I;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicSmartPlaylistViewPagerFragment extends Hilt_MusicSmartPlaylistViewPagerFragment {
    public static final int $stable = 8;
    public final i f;

    public MusicSmartPlaylistViewPagerFragment() {
        d d0 = I.a.b(PlaylistSharedViewModel.class);
        com.iloen.melon.player.playlist.music.MusicSmartPlaylistViewPagerFragment.special..inlined.activityViewModels.default.1 musicSmartPlaylistViewPagerFragment$special$$inlined$activityViewModels$default$10 = new a() {
            public final androidx.fragment.app.I f;

            {
                this.f = i0;
                super(0);
            }

            @NotNull
            public final q0 invoke() {
                return this.f.requireActivity().getViewModelStore();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        com.iloen.melon.player.playlist.music.MusicSmartPlaylistViewPagerFragment.special..inlined.activityViewModels.default.2 musicSmartPlaylistViewPagerFragment$special$$inlined$activityViewModels$default$20 = new a(this) {
            public final a f;
            public final androidx.fragment.app.I g;

            {
                this.f = a0;
                this.g = i0;
                super(0);
            }

            @NotNull
            public final c invoke() {
                a a0 = this.f;
                if(a0 != null) {
                    c c0 = (c)a0.invoke();
                    return c0 == null ? this.g.requireActivity().getDefaultViewModelCreationExtras() : c0;
                }
                return this.g.requireActivity().getDefaultViewModelCreationExtras();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        this.f = new i(d0, musicSmartPlaylistViewPagerFragment$special$$inlined$activityViewModels$default$10, new a() {
            public final androidx.fragment.app.I f;

            {
                this.f = i0;
                super(0);
            }

            @NotNull
            public final o0 invoke() {
                return this.f.requireActivity().getDefaultViewModelProviderFactory();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }, musicSmartPlaylistViewPagerFragment$special$$inlined$activityViewModels$default$20);
    }

    public static final PlaylistSharedViewModel access$getSharedViewModel(MusicSmartPlaylistViewPagerFragment musicSmartPlaylistViewPagerFragment0) {
        return (PlaylistSharedViewModel)musicSmartPlaylistViewPagerFragment0.f.getValue();
    }

    public static final void access$setMusicPlaylistFragment(MusicSmartPlaylistViewPagerFragment musicSmartPlaylistViewPagerFragment0) {
        l0 l00 = musicSmartPlaylistViewPagerFragment0.getChildFragmentManager();
        androidx.fragment.app.a a0 = com.iloen.melon.utils.a.f(l00, "getChildFragmentManager(...)", l00);
        a0.g(0x7F0A0578, MusicPlaylistFragment.Companion.newInstance(), null);  // id:info_fragment
        a0.l(true, true);
    }

    public static final void access$setMusicPlaylistSearchFragment(MusicSmartPlaylistViewPagerFragment musicSmartPlaylistViewPagerFragment0) {
        l0 l00 = musicSmartPlaylistViewPagerFragment0.getChildFragmentManager();
        androidx.fragment.app.a a0 = com.iloen.melon.utils.a.f(l00, "getChildFragmentManager(...)", l00);
        a0.g(0x7F0A0578, PlaylistSearchFragment.Companion.newInstance(PlaylistId.MUSIC), null);  // id:info_fragment
        a0.l(true, true);
    }

    public static final void access$setSmartPlaylistFragment(MusicSmartPlaylistViewPagerFragment musicSmartPlaylistViewPagerFragment0) {
        l0 l00 = musicSmartPlaylistViewPagerFragment0.getChildFragmentManager();
        androidx.fragment.app.a a0 = com.iloen.melon.utils.a.f(l00, "getChildFragmentManager(...)", l00);
        a0.g(0x7F0A0578, SmartPlaylistFragment.Companion.newInstance(), null);  // id:info_fragment
        a0.l(true, true);
    }

    public static final void access$setSmartPlaylistSearchFragment(MusicSmartPlaylistViewPagerFragment musicSmartPlaylistViewPagerFragment0) {
        l0 l00 = musicSmartPlaylistViewPagerFragment0.getChildFragmentManager();
        androidx.fragment.app.a a0 = com.iloen.melon.utils.a.f(l00, "getChildFragmentManager(...)", l00);
        a0.g(0x7F0A0578, PlaylistSearchFragment.Companion.newInstance(PlaylistId.SMART), null);  // id:info_fragment
        a0.l(true, true);
    }

    @Override  // com.iloen.melon.fragments.IFragmentContainer
    @Nullable
    public androidx.fragment.app.I getCurrentFragment() {
        return this.getChildFragmentManager().D(0x7F0A0578);  // id:info_fragment
    }

    @Override  // androidx.fragment.app.I
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(null) {
            public int r;
            public final MusicSmartPlaylistViewPagerFragment w;

            {
                this.w = musicSmartPlaylistViewPagerFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.music.MusicSmartPlaylistViewPagerFragment.onViewCreated.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.music.MusicSmartPlaylistViewPagerFragment.onViewCreated.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.player.playlist.music.MusicSmartPlaylistViewPagerFragment.onViewCreated.1.1 musicSmartPlaylistViewPagerFragment$onViewCreated$1$10 = new n(null) {
                            public int r;
                            public final MusicSmartPlaylistViewPagerFragment w;

                            {
                                this.w = musicSmartPlaylistViewPagerFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.playlist.music.MusicSmartPlaylistViewPagerFragment.onViewCreated.1.1(this.w, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.playlist.music.MusicSmartPlaylistViewPagerFragment.onViewCreated.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                MusicSmartPlaylistViewPagerFragment musicSmartPlaylistViewPagerFragment0 = this.w;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        PlaylistSharedViewModel playlistSharedViewModel0 = MusicSmartPlaylistViewPagerFragment.access$getSharedViewModel(musicSmartPlaylistViewPagerFragment0);
                                        this.r = 1;
                                        if(playlistSharedViewModel0.updateMusicTabContentToDefault(this) == a0) {
                                            return a0;
                                        }
                                        break;
                                    }
                                    case 1: {
                                        d5.n.D(object0);
                                        break;
                                    }
                                    case 2: {
                                        d5.n.D(object0);
                                        return H.a;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                                SharedFlow sharedFlow0 = MusicSmartPlaylistViewPagerFragment.access$getSharedViewModel(musicSmartPlaylistViewPagerFragment0).getMusicTabContent();
                                com.iloen.melon.player.playlist.music.MusicSmartPlaylistViewPagerFragment.onViewCreated.1.1.1 musicSmartPlaylistViewPagerFragment$onViewCreated$1$1$10 = new n(null) {
                                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
                                    public static final class WhenMappings {
                                        public static final int[] $EnumSwitchMapping$0;

                                        static {
                                            int[] arr_v = new int[MusicPlaylistTabContent.values().length];
                                            try {
                                                arr_v[MusicPlaylistTabContent.SONG_LIST_MUSIC.ordinal()] = 1;
                                            }
                                            catch(NoSuchFieldError unused_ex) {
                                            }
                                            try {
                                                arr_v[MusicPlaylistTabContent.SONG_LIST_SMART.ordinal()] = 2;
                                            }
                                            catch(NoSuchFieldError unused_ex) {
                                            }
                                            try {
                                                arr_v[MusicPlaylistTabContent.SEARCH_MUSIC.ordinal()] = 3;
                                            }
                                            catch(NoSuchFieldError unused_ex) {
                                            }
                                            try {
                                                arr_v[MusicPlaylistTabContent.SEARCH_SMART.ordinal()] = 4;
                                            }
                                            catch(NoSuchFieldError unused_ex) {
                                            }
                                            WhenMappings.$EnumSwitchMapping$0 = arr_v;
                                        }
                                    }

                                    public Object r;
                                    public final MusicSmartPlaylistViewPagerFragment w;

                                    {
                                        this.w = musicSmartPlaylistViewPagerFragment0;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        Continuation continuation1 = new com.iloen.melon.player.playlist.music.MusicSmartPlaylistViewPagerFragment.onViewCreated.1.1.1(this.w, continuation0);
                                        continuation1.r = object0;
                                        return continuation1;
                                    }

                                    public final Object invoke(MusicPlaylistTabContent musicPlaylistTabContent0, Continuation continuation0) {
                                        return ((com.iloen.melon.player.playlist.music.MusicSmartPlaylistViewPagerFragment.onViewCreated.1.1.1)this.create(musicPlaylistTabContent0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((MusicPlaylistTabContent)object0), ((Continuation)object1));
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        MusicPlaylistTabContent musicPlaylistTabContent0 = (MusicPlaylistTabContent)this.r;
                                        d5.n.D(object0);
                                        MusicSmartPlaylistViewPagerFragment musicSmartPlaylistViewPagerFragment0 = this.w;
                                        switch(WhenMappings.$EnumSwitchMapping$0[musicPlaylistTabContent0.ordinal()]) {
                                            case 1: {
                                                MusicSmartPlaylistViewPagerFragment.access$setMusicPlaylistFragment(musicSmartPlaylistViewPagerFragment0);
                                                return H.a;
                                            }
                                            case 2: {
                                                MusicSmartPlaylistViewPagerFragment.access$setSmartPlaylistFragment(musicSmartPlaylistViewPagerFragment0);
                                                return H.a;
                                            }
                                            case 3: {
                                                MusicSmartPlaylistViewPagerFragment.access$setMusicPlaylistSearchFragment(musicSmartPlaylistViewPagerFragment0);
                                                return H.a;
                                            }
                                            case 4: {
                                                MusicSmartPlaylistViewPagerFragment.access$setSmartPlaylistSearchFragment(musicSmartPlaylistViewPagerFragment0);
                                                return H.a;
                                            }
                                            default: {
                                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                            }
                                        }
                                    }
                                };
                                this.r = 2;
                                return FlowKt.collectLatest(sharedFlow0, musicSmartPlaylistViewPagerFragment$onViewCreated$1$1$10, this) == a0 ? a0 : H.a;
                            }
                        };
                        this.r = 1;
                        return f0.j(this.w, s.d, musicSmartPlaylistViewPagerFragment$onViewCreated$1$10, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 3, null);
    }
}

