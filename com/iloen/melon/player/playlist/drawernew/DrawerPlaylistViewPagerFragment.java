package com.iloen.melon.player.playlist.drawernew;

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
import com.iloen.melon.player.playlist.DrawerPlaylistTabContent;
import com.iloen.melon.player.playlist.PlaylistSharedViewModel;
import com.iloen.melon.player.playlist.search.PlaylistSearchFragment;
import i.n.i.b.a.s.e.M3;
import ie.H;
import javax.inject.Inject;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.C;
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

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016¢\u0006\u0004\b\f\u0010\rR\"\u0010\u000F\u001A\u00020\u000E8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerPlaylistViewPagerFragment;", "Lcom/iloen/melon/player/playlist/PlaylistViewPagerBaseFragment;", "<init>", "()V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroidx/fragment/app/I;", "getCurrentFragment", "()Landroidx/fragment/app/I;", "Lkc/s2;", "playlistManager", "Lkc/s2;", "getPlaylistManager", "()Lkc/s2;", "setPlaylistManager", "(Lkc/s2;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DrawerPlaylistViewPagerFragment extends Hilt_DrawerPlaylistViewPagerFragment {
    public static final int $stable = 8;
    public final i f;
    @Inject
    public s2 playlistManager;

    public DrawerPlaylistViewPagerFragment() {
        d d0 = I.a.b(PlaylistSharedViewModel.class);
        com.iloen.melon.player.playlist.drawernew.DrawerPlaylistViewPagerFragment.special..inlined.activityViewModels.default.1 drawerPlaylistViewPagerFragment$special$$inlined$activityViewModels$default$10 = new a() {
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
        com.iloen.melon.player.playlist.drawernew.DrawerPlaylistViewPagerFragment.special..inlined.activityViewModels.default.2 drawerPlaylistViewPagerFragment$special$$inlined$activityViewModels$default$20 = new a(this) {
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
        this.f = new i(d0, drawerPlaylistViewPagerFragment$special$$inlined$activityViewModels$default$10, new a() {
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
        }, drawerPlaylistViewPagerFragment$special$$inlined$activityViewModels$default$20);
    }

    public static final PlaylistSharedViewModel access$getSharedViewModel(DrawerPlaylistViewPagerFragment drawerPlaylistViewPagerFragment0) {
        return (PlaylistSharedViewModel)drawerPlaylistViewPagerFragment0.f.getValue();
    }

    public static final void access$setPlaylistListFragment(DrawerPlaylistViewPagerFragment drawerPlaylistViewPagerFragment0) {
        l0 l00 = drawerPlaylistViewPagerFragment0.getChildFragmentManager();
        androidx.fragment.app.a a0 = com.iloen.melon.utils.a.f(l00, "getChildFragmentManager(...)", l00);
        a0.g(0x7F0A0578, DrawerFragment.Companion.newInstance(), null);  // id:info_fragment
        a0.l(true, true);
    }

    public static final void access$setPlaylistSongFragment(DrawerPlaylistViewPagerFragment drawerPlaylistViewPagerFragment0) {
        l0 l00 = drawerPlaylistViewPagerFragment0.getChildFragmentManager();
        androidx.fragment.app.a a0 = com.iloen.melon.utils.a.f(l00, "getChildFragmentManager(...)", l00);
        a0.g(0x7F0A0578, DrawerSongFragment.Companion.newInstance(), "DrawerSongFragment");  // id:info_fragment
        a0.l(true, true);
    }

    public static final void access$setSearchFragment(DrawerPlaylistViewPagerFragment drawerPlaylistViewPagerFragment0) {
        l0 l00 = drawerPlaylistViewPagerFragment0.getChildFragmentManager();
        androidx.fragment.app.a a0 = com.iloen.melon.utils.a.f(l00, "getChildFragmentManager(...)", l00);
        a0.g(0x7F0A0578, PlaylistSearchFragment.Companion.newInstance(PlaylistId.DRAWER), null);  // id:info_fragment
        a0.l(true, true);
    }

    @Override  // com.iloen.melon.fragments.IFragmentContainer
    @Nullable
    public androidx.fragment.app.I getCurrentFragment() {
        return this.getChildFragmentManager().D(0x7F0A0578);  // id:info_fragment
    }

    @NotNull
    public final s2 getPlaylistManager() {
        s2 s20 = this.playlistManager;
        if(s20 != null) {
            return s20;
        }
        q.m("playlistManager");
        throw null;
    }

    @Override  // androidx.fragment.app.I
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(null) {
            public int r;
            public final DrawerPlaylistViewPagerFragment w;

            {
                this.w = drawerPlaylistViewPagerFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.drawernew.DrawerPlaylistViewPagerFragment.onViewCreated.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.drawernew.DrawerPlaylistViewPagerFragment.onViewCreated.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.player.playlist.drawernew.DrawerPlaylistViewPagerFragment.onViewCreated.1.1 drawerPlaylistViewPagerFragment$onViewCreated$1$10 = new n(null) {
                            public int r;
                            public final DrawerPlaylistViewPagerFragment w;

                            {
                                this.w = drawerPlaylistViewPagerFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.playlist.drawernew.DrawerPlaylistViewPagerFragment.onViewCreated.1.1(this.w, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.playlist.drawernew.DrawerPlaylistViewPagerFragment.onViewCreated.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                DrawerPlaylistViewPagerFragment drawerPlaylistViewPagerFragment0 = this.w;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        PlaylistSharedViewModel playlistSharedViewModel0 = DrawerPlaylistViewPagerFragment.access$getSharedViewModel(drawerPlaylistViewPagerFragment0);
                                        this.r = 1;
                                        if(playlistSharedViewModel0.updateDrawerTabDataToDefault(this) == a0) {
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
                                C c0 = new C();  // 初始化器: Ljava/lang/Object;-><init>()V
                                c0.a = true;
                                SharedFlow sharedFlow0 = DrawerPlaylistViewPagerFragment.access$getSharedViewModel(drawerPlaylistViewPagerFragment0).getDrawerTabContent();
                                com.iloen.melon.player.playlist.drawernew.DrawerPlaylistViewPagerFragment.onViewCreated.1.1.1 drawerPlaylistViewPagerFragment$onViewCreated$1$1$10 = new n(c0, null) {
                                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
                                    public static final class WhenMappings {
                                        public static final int[] $EnumSwitchMapping$0;

                                        static {
                                            int[] arr_v = new int[DrawerPlaylistTabContent.values().length];
                                            try {
                                                arr_v[DrawerPlaylistTabContent.PLAYLIST_LIST.ordinal()] = 1;
                                            }
                                            catch(NoSuchFieldError unused_ex) {
                                            }
                                            try {
                                                arr_v[DrawerPlaylistTabContent.SONG_LIST.ordinal()] = 2;
                                            }
                                            catch(NoSuchFieldError unused_ex) {
                                            }
                                            try {
                                                arr_v[DrawerPlaylistTabContent.SEARCH.ordinal()] = 3;
                                            }
                                            catch(NoSuchFieldError unused_ex) {
                                            }
                                            WhenMappings.$EnumSwitchMapping$0 = arr_v;
                                        }
                                    }

                                    public final C B;
                                    public Object r;
                                    public final DrawerPlaylistViewPagerFragment w;

                                    {
                                        this.w = drawerPlaylistViewPagerFragment0;
                                        this.B = c0;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        Continuation continuation1 = new com.iloen.melon.player.playlist.drawernew.DrawerPlaylistViewPagerFragment.onViewCreated.1.1.1(this.w, this.B, continuation0);
                                        continuation1.r = object0;
                                        return continuation1;
                                    }

                                    public final Object invoke(DrawerPlaylistTabContent drawerPlaylistTabContent0, Continuation continuation0) {
                                        return ((com.iloen.melon.player.playlist.drawernew.DrawerPlaylistViewPagerFragment.onViewCreated.1.1.1)this.create(drawerPlaylistTabContent0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((DrawerPlaylistTabContent)object0), ((Continuation)object1));
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        DrawerPlaylistTabContent drawerPlaylistTabContent0 = (DrawerPlaylistTabContent)this.r;
                                        d5.n.D(object0);
                                        C c0 = this.B;
                                        DrawerPlaylistViewPagerFragment drawerPlaylistViewPagerFragment0 = this.w;
                                        switch(WhenMappings.$EnumSwitchMapping$0[drawerPlaylistTabContent0.ordinal()]) {
                                            case 1: {
                                                DrawerPlaylistViewPagerFragment.access$setPlaylistListFragment(drawerPlaylistViewPagerFragment0);
                                                break;
                                            }
                                            case 2: {
                                                if(c0.a) {
                                                    androidx.fragment.app.I i0 = drawerPlaylistViewPagerFragment0.getChildFragmentManager().E("DrawerSongFragment");
                                                    if(i0 == null) {
                                                        DrawerPlaylistViewPagerFragment.access$setPlaylistSongFragment(drawerPlaylistViewPagerFragment0);
                                                    }
                                                    else {
                                                        ((DrawerSongFragment)i0).updateFragment();
                                                    }
                                                }
                                                else {
                                                    DrawerPlaylistViewPagerFragment.access$setPlaylistSongFragment(drawerPlaylistViewPagerFragment0);
                                                }
                                                break;
                                            }
                                            case 3: {
                                                DrawerPlaylistViewPagerFragment.access$setSearchFragment(drawerPlaylistViewPagerFragment0);
                                                break;
                                            }
                                            default: {
                                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                            }
                                        }
                                        c0.a = false;
                                        return H.a;
                                    }
                                };
                                this.r = 2;
                                return FlowKt.collectLatest(sharedFlow0, drawerPlaylistViewPagerFragment$onViewCreated$1$1$10, this) == a0 ? a0 : H.a;
                            }
                        };
                        this.r = 1;
                        return f0.j(this.w, s.d, drawerPlaylistViewPagerFragment$onViewCreated$1$10, this) == a0 ? a0 : H.a;
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

    public final void setPlaylistManager(@NotNull s2 s20) {
        q.g(s20, "<set-?>");
        this.playlistManager = s20;
    }
}

