package com.iloen.melon.player.playlist.drawernew;

import Bd.F;
import M6.B;
import Na.a;
import Pc.d;
import Pc.e;
import Ya.g;
import android.os.Bundle;
import androidx.lifecycle.f0;
import com.android.volley.VolleyError;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v6x.response.DjSmartPlaylistListRes.RESPONSE.DJPLAYLISTLIST;
import com.iloen.melon.net.v6x.response.DjSmartPlaylistListRes;
import com.iloen.melon.net.v6x.response.MyMusicLikePlaylistRes.RESPONSE.LIKEPLYLSTLIST;
import com.iloen.melon.net.v6x.response.MyMusicLikePlaylistRes;
import com.iloen.melon.net.v6x.response.MyMusicRecentPlaylistRes.RESPONSE.RECNTPLYLSTLIST;
import com.iloen.melon.net.v6x.response.MyMusicRecentPlaylistRes;
import com.iloen.melon.net.v6x.response.MyMusicSmartPlaylistListRes.RESPONSE.PLAYLISTLIST;
import com.iloen.melon.net.v6x.response.MyMusicSmartPlaylistListRes;
import com.iloen.melon.net.v6x.response.ResponseV6Res;
import com.iloen.melon.playback.playlist.add.AddAction.AddPlay;
import com.iloen.melon.playback.playlist.add.AddAction;
import com.iloen.melon.playback.playlist.add.AddFailType.SectionRepeatInterrupt;
import com.iloen.melon.playback.playlist.add.AddResult.Failure;
import com.iloen.melon.playback.playlist.add.AddResult.Success;
import com.iloen.melon.playback.playlist.add.AddResult;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import com.iloen.melon.player.playlist.DrawerPlaylistTabInfo;
import com.iloen.melon.player.playlist.common.PlaylistCommonUiEvent.ShowSelectionRepeatInterruptPopup;
import com.iloen.melon.player.playlist.common.h;
import com.iloen.melon.player.playlist.drawernew.model.DrawerAlyac;
import com.iloen.melon.player.playlist.drawernew.model.DrawerPlytMapper;
import com.iloen.melon.player.playlist.drawernew.model.DrawerPlytTab;
import com.iloen.melon.player.playlist.drawernew.model.DrawerPlytWrapper;
import com.iloen.melon.player.playlist.tiara.DrawerPlaylistTiaraLogHelper;
import com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.ui.K4;
import com.melon.ui.f1;
import com.melon.ui.g1;
import com.melon.ui.k1;
import com.melon.ui.n0;
import d5.n;
import h7.u0;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.m;
import ie.o;
import ie.p;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import je.w;
import k9.j;
import kc.d3;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.guava.ListenableFutureKt;
import mb.k;
import ob.z;
import oe.c;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e0;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 B2\u00020\u0001:\u0001BB9\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\b\u0012\u0006\u0010\u000B\u001A\u00020\n\u0012\u0006\u0010\r\u001A\u00020\f¢\u0006\u0004\b\u000E\u0010\u000FJ\u0018\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0011\u001A\u00020\u0010H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001A\u00020\u00122\u0006\u0010\u0016\u001A\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001B\u001A\u00020\u00122\u0006\u0010\u001A\u001A\u00020\u0019H\u0014¢\u0006\u0004\b\u001B\u0010\u001CR#\u0010$\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001F0\u001E0\u001D8\u0006¢\u0006\f\n\u0004\b \u0010!\u001A\u0004\b\"\u0010#R\u001D\u0010(\u001A\b\u0012\u0004\u0012\u00020%0\u001D8\u0006¢\u0006\f\n\u0004\b&\u0010!\u001A\u0004\b\'\u0010#R\u001D\u0010,\u001A\b\u0012\u0004\u0012\u00020)0\u001D8\u0006¢\u0006\f\n\u0004\b*\u0010!\u001A\u0004\b+\u0010#R\u001D\u0010/\u001A\b\u0012\u0004\u0012\u00020)0\u001D8\u0006¢\u0006\f\n\u0004\b-\u0010!\u001A\u0004\b.\u0010#R\u001D\u00105\u001A\b\u0012\u0004\u0012\u0002000\u001E8\u0006¢\u0006\f\n\u0004\b1\u00102\u001A\u0004\b3\u00104R\"\u00108\u001A\u00020%8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b6\u00107\u001A\u0004\b8\u00109\"\u0004\b:\u0010;R\u0017\u0010A\u001A\u00020<8\u0006¢\u0006\f\n\u0004\b=\u0010>\u001A\u0004\b?\u0010@¨\u0006C"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerFragmentViewModel;", "Lcom/melon/ui/k1;", "LYa/g;", "useCase", "Lmb/k;", "loginUseCase", "Lkc/s2;", "playlistManager", "Lk8/a;", "dialogManage", "Lob/z;", "playerUseCase", "LPc/d;", "stringProvider", "<init>", "(LYa/g;Lmb/k;Lkc/s2;Lk8/a;Lob/z;LPc/d;)V", "Lcom/melon/ui/g1;", "type", "Lie/H;", "onFetchStart", "(Lcom/melon/ui/g1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;", "drawerPlaylistInfo", "playPlaylist", "(Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;)V", "LPc/e;", "userEvent", "onUserEvent", "(LPc/e;)V", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/iloen/melon/player/playlist/drawernew/model/DrawerPlytWrapper;", "h", "Lkotlinx/coroutines/flow/StateFlow;", "getDrawerPlytListListUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "drawerPlytListListUiState", "", "j", "getShowProgressForIdle", "showProgressForIdle", "", "l", "getSelectedAlyacKey", "selectedAlyacKey", "n", "getDrawerPlytViewType", "drawerPlytViewType", "Lcom/iloen/melon/player/playlist/drawernew/model/DrawerAlyac;", "o", "Ljava/util/List;", "getAlyacList", "()Ljava/util/List;", "alyacList", "p", "Z", "isBottomSheet", "()Z", "setBottomSheet", "(Z)V", "Lcom/iloen/melon/player/playlist/tiara/DrawerPlaylistTiaraLogHelper;", "q", "Lcom/iloen/melon/player/playlist/tiara/DrawerPlaylistTiaraLogHelper;", "getTiaraLogHelper", "()Lcom/iloen/melon/player/playlist/tiara/DrawerPlaylistTiaraLogHelper;", "tiaraLogHelper", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DrawerFragmentViewModel extends k1 {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerFragmentViewModel$Companion;", "", "", "TAG", "Ljava/lang/String;", "EXTRA_PLYT_TAB", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[a.values().length];
            try {
                arr_v[0] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public final g a;
    public final k b;
    public final s2 c;
    public final k8.a d;
    public final z e;
    public final LogU f;
    public final MutableStateFlow g;
    public final StateFlow h;
    public final MutableStateFlow i;
    public final StateFlow j;
    public final Flow k;
    public final StateFlow l;
    public final Flow m;
    public final StateFlow n;
    public final ArrayList o;
    public boolean p;
    public final DrawerPlaylistTiaraLogHelper q;

    static {
        DrawerFragmentViewModel.Companion = new Companion(null);
        DrawerFragmentViewModel.$stable = 8;
    }

    @Inject
    public DrawerFragmentViewModel(@NotNull g g0, @NotNull k k0, @NotNull s2 s20, @NotNull k8.a a0, @NotNull z z0, @NotNull d d0) {
        q.g(g0, "useCase");
        q.g(k0, "loginUseCase");
        q.g(s20, "playlistManager");
        q.g(a0, "dialogManage");
        q.g(z0, "playerUseCase");
        q.g(d0, "stringProvider");
        super();
        this.a = g0;
        this.b = k0;
        this.c = s20;
        this.d = a0;
        this.e = z0;
        this.f = com.iloen.melon.utils.log.LogU.Companion.create$default(LogU.Companion, "DrawerFragmentViewModel", false, Category.UI, 2, null);
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(w.a);
        this.g = mutableStateFlow0;
        this.h = FlowKt.asStateFlow(mutableStateFlow0);
        MutableStateFlow mutableStateFlow1 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.i = mutableStateFlow1;
        this.j = FlowKt.asStateFlow(mutableStateFlow1);
        Flow flow0 = FlowKt.onEach(new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel.special..inlined.map.1.2 drawerFragmentViewModel$special$$inlined$map$1$20 = new FlowCollector() {
                    @Override  // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object object0, Continuation continuation0) {
                        com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel.special..inlined.map.1.2.1 drawerFragmentViewModel$special$$inlined$map$1$2$10;
                        if(continuation0 instanceof com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel.special..inlined.map.1.2.1) {
                            drawerFragmentViewModel$special$$inlined$map$1$2$10 = (com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel.special..inlined.map.1.2.1)continuation0;
                            int v = drawerFragmentViewModel$special$$inlined$map$1$2$10.w;
                            if((v & 0x80000000) == 0) {
                                drawerFragmentViewModel$special$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                    public Object r;
                                    public int w;

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        this.r = object0;
                                        this.w |= 0x80000000;
                                        return continuation0.emit(null, this);
                                    }
                                };
                            }
                            else {
                                drawerFragmentViewModel$special$$inlined$map$1$2$10.w = v ^ 0x80000000;
                            }
                        }
                        else {
                            drawerFragmentViewModel$special$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                public Object r;
                                public int w;

                                @Override  // oe.a
                                public final Object invokeSuspend(Object object0) {
                                    this.r = object0;
                                    this.w |= 0x80000000;
                                    return continuation0.emit(null, this);
                                }
                            };
                        }
                        Object object1 = drawerFragmentViewModel$special$$inlined$map$1$2$10.r;
                        ne.a a0 = ne.a.a;
                        switch(drawerFragmentViewModel$special$$inlined$map$1$2$10.w) {
                            case 0: {
                                n.D(object1);
                                String s = (String)object0;
                                if(q.b(s, "DJ") && !((e0)this.b.b).j().getIsDj()) {
                                    s = "MADE_BY_ME";
                                }
                                drawerFragmentViewModel$special$$inlined$map$1$2$10.w = 1;
                                return this.b.emit(s, drawerFragmentViewModel$special$$inlined$map$1$2$10) == a0 ? a0 : H.a;
                            }
                            case 1: {
                                n.D(object1);
                                return H.a;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                };
                Object object0 = this.collect(drawerFragmentViewModel$special$$inlined$map$1$20, continuation0);
                return object0 == ne.a.a ? object0 : H.a;
            }
        }, new we.n(null) {
            public Object r;
            public final DrawerFragmentViewModel w;

            {
                this.w = drawerFragmentViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel._selectedTab.2(this.w, continuation0);
                continuation1.r = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((String)object0), ((Continuation)object1));
            }

            public final Object invoke(String s, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel._selectedTab.2)this.create(s, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                String s = (String)this.r;
                n.D(object0);
                LogU.debug$default(DrawerFragmentViewModel.access$getLog$p(this.w), "selectedTab: " + s, null, false, 6, null);
                return H.a;
            }
        });
        this.k = flow0;
        this.l = FlowKt.stateIn(flow0, f0.h(this), kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, null), "");
        Flow flow1 = DrawerPlaylistPreferencesRepository.INSTANCE.getViewMode();
        this.m = flow1;
        this.n = FlowKt.stateIn(flow1, f0.h(this), kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, null), "LIST");
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(new m("", "MADE_BY_ME"));
        if(((e0)k0).j().getIsDj()) {
            arrayList0.add(new m("", "DJ"));
        }
        arrayList0.add(new m("", "LIKE"));
        arrayList0.add(new m("", "RECENT"));
        ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
        for(Object object0: arrayList0) {
            arrayList1.add(new DrawerAlyac(((String)((m)object0).a), ((String)((m)object0).b)));
        }
        this.o = arrayList1;
        this.q = new DrawerPlaylistTiaraLogHelper(d0);
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new we.n(null) {
            public int r;
            public final DrawerFragmentViewModel w;

            {
                this.w = drawerFragmentViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        n.D(object0);
                        Flow flow0 = DrawerFragmentViewModel.access$getPlayerUseCase$p(this.w).h();
                        com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel.1.1 drawerFragmentViewModel$1$10 = new we.n(null) {
                            public boolean r;
                            public final DrawerFragmentViewModel w;

                            {
                                this.w = drawerFragmentViewModel0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel.1.1(this.w, continuation0);
                                continuation1.r = ((Boolean)object0).booleanValue();
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                            }

                            public final Object invoke(boolean z, Continuation continuation0) {
                                return ((com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel.1.1)this.create(Boolean.valueOf(z), continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                boolean z = this.r;
                                n.D(object0);
                                DrawerFragmentViewModel drawerFragmentViewModel0 = this.w;
                                Iterable iterable0 = (Iterable)drawerFragmentViewModel0.getDrawerPlytListListUiState().getValue();
                                ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
                                for(Object object1: iterable0) {
                                    DrawerPlytWrapper drawerPlytWrapper0 = (DrawerPlytWrapper)object1;
                                    if(drawerPlytWrapper0.isSelect()) {
                                        boolean z1 = ((d3)drawerFragmentViewModel0.c).j() != null;
                                        drawerPlytWrapper0 = DrawerPlytWrapper.copy$default(drawerPlytWrapper0, 0, null, null, null, null, false, false, z, false, false, null, null, 0xE7F, null);
                                    }
                                    arrayList0.add(drawerPlytWrapper0);
                                }
                                DrawerFragmentViewModel.access$updateDrawerPlytListListUiState(drawerFragmentViewModel0, arrayList0, "playbackState change: " + z);
                                return H.a;
                            }
                        };
                        this.r = 1;
                        return FlowKt.collectLatest(flow0, drawerFragmentViewModel$1$10, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 3, null);
    }

    public static final Object access$fetchDrawerPlytList(DrawerFragmentViewModel drawerFragmentViewModel0, String s, Continuation continuation0) {
        return drawerFragmentViewModel0.c(s, continuation0);
    }

    public static final k8.a access$getDialogManage$p(DrawerFragmentViewModel drawerFragmentViewModel0) {
        return drawerFragmentViewModel0.d;
    }

    public static final LogU access$getLog$p(DrawerFragmentViewModel drawerFragmentViewModel0) {
        return drawerFragmentViewModel0.f;
    }

    public static final MutableStateFlow access$get_showProgressForIdle$p(DrawerFragmentViewModel drawerFragmentViewModel0) {
        return drawerFragmentViewModel0.i;
    }

    public static final Object access$requestPlay(DrawerFragmentViewModel drawerFragmentViewModel0, AddAction addAction0, DrawerPlaylistInfo drawerPlaylistInfo0, Continuation continuation0) {
        drawerFragmentViewModel0.getClass();
        return u0.j(drawerFragmentViewModel0, null, new DrawerFragmentViewModel.requestPlay.2(drawerFragmentViewModel0, addAction0, drawerPlaylistInfo0, null), 3).await(continuation0);
    }

    public static final void access$updateDrawerPlytListListUiState(DrawerFragmentViewModel drawerFragmentViewModel0, List list0, String s) {
        drawerFragmentViewModel0.e(s, list0);
    }

    public static final void access$updateUiState(DrawerFragmentViewModel drawerFragmentViewModel0, we.k k0) {
        drawerFragmentViewModel0.updateUiState(k0);
    }

    public final Object c(String s, Continuation continuation0) {
        String s2;
        DrawerPlaylistInfo drawerPlaylistInfo1;
        ResponseV6Res responseV6Res1;
        DrawerFragmentViewModel drawerFragmentViewModel0;
        ResponseV6Res responseV6Res0;
        String s1;
        DrawerFragmentViewModel.fetchDrawerPlytList.1 drawerFragmentViewModel$fetchDrawerPlytList$10;
        if(continuation0 instanceof DrawerFragmentViewModel.fetchDrawerPlytList.1) {
            drawerFragmentViewModel$fetchDrawerPlytList$10 = (DrawerFragmentViewModel.fetchDrawerPlytList.1)continuation0;
            int v = drawerFragmentViewModel$fetchDrawerPlytList$10.M;
            if((v & 0x80000000) == 0) {
                drawerFragmentViewModel$fetchDrawerPlytList$10 = new DrawerFragmentViewModel.fetchDrawerPlytList.1(this, continuation0);
            }
            else {
                drawerFragmentViewModel$fetchDrawerPlytList$10.M = v ^ 0x80000000;
            }
        }
        else {
            drawerFragmentViewModel$fetchDrawerPlytList$10 = new DrawerFragmentViewModel.fetchDrawerPlytList.1(this, continuation0);
        }
        Object object0 = drawerFragmentViewModel$fetchDrawerPlytList$10.G;
        ne.a a0 = ne.a.a;
        s2 s20 = this.c;
        H h0 = H.a;
        K4 k40 = null;
    alab1:
        switch(drawerFragmentViewModel$fetchDrawerPlytList$10.M) {
            case 0: {
                n.D(object0);
                this.updateUiState(new h(5));
                B b0 = ((d3)s20).l();
                s1 = s;
                drawerFragmentViewModel$fetchDrawerPlytList$10.r = s1;
                drawerFragmentViewModel$fetchDrawerPlytList$10.M = 1;
                object0 = ListenableFutureKt.await(b0, drawerFragmentViewModel$fetchDrawerPlytList$10);
                if(object0 != a0) {
                    goto label_27;
                }
                return a0;
            }
            case 1: {
                s1 = drawerFragmentViewModel$fetchDrawerPlytList$10.r;
                n.D(object0);
            label_27:
                DrawerPlaylistInfo drawerPlaylistInfo0 = ((nc.u0)(((nc.a)object0))).I().g;
                if(j.b()) {
                    switch(s1) {
                        case "LIKE": {
                            responseV6Res0 = (ResponseV6Res)k9.h.e(k9.g.d, MyMusicLikePlaylistRes.class, null);
                            break;
                        }
                        case "MADE_BY_ME": {
                            responseV6Res0 = (ResponseV6Res)k9.h.e(k9.g.e, MyMusicSmartPlaylistListRes.class, null);
                            break;
                        }
                        case "RECENT": {
                            responseV6Res0 = (ResponseV6Res)k9.h.e(k9.g.c, MyMusicRecentPlaylistRes.class, null);
                            break;
                        }
                        default: {
                            responseV6Res0 = (ResponseV6Res)k9.h.e(k9.g.f, DjSmartPlaylistListRes.class, null);
                        }
                    }
                    if(responseV6Res0 == null) {
                        goto label_50;
                    }
                    else {
                        B b1 = ((d3)s20).l();
                        drawerFragmentViewModel$fetchDrawerPlytList$10.r = null;
                        drawerFragmentViewModel$fetchDrawerPlytList$10.w = null;
                        drawerFragmentViewModel$fetchDrawerPlytList$10.B = this;
                        drawerFragmentViewModel$fetchDrawerPlytList$10.D = s1;
                        drawerFragmentViewModel$fetchDrawerPlytList$10.E = responseV6Res0;
                        drawerFragmentViewModel$fetchDrawerPlytList$10.M = 2;
                        object0 = ListenableFutureKt.await(b1, drawerFragmentViewModel$fetchDrawerPlytList$10);
                        if(object0 != a0) {
                            drawerFragmentViewModel0 = this;
                            responseV6Res1 = responseV6Res0;
                            this.updateUiState(new f(0, this, drawerFragmentViewModel0.d(s1, responseV6Res1, ((nc.u0)(((nc.a)object0))).I().g)));
                            return h0;
                        }
                    }
                }
                else {
                label_50:
                    g g0 = this.a;
                    switch(s1) {
                        case "LIKE": {
                            drawerFragmentViewModel$fetchDrawerPlytList$10.r = s1;
                            drawerFragmentViewModel$fetchDrawerPlytList$10.w = drawerPlaylistInfo0;
                            drawerFragmentViewModel$fetchDrawerPlytList$10.M = 4;
                            Object object4 = g0.b(drawerFragmentViewModel$fetchDrawerPlytList$10);
                            if(object4 != a0) {
                                drawerPlaylistInfo1 = drawerPlaylistInfo0;
                                object0 = object4;
                                s2 = s1;
                                break alab1;
                            }
                            break;
                        }
                        case "MADE_BY_ME": {
                            drawerFragmentViewModel$fetchDrawerPlytList$10.r = s1;
                            drawerFragmentViewModel$fetchDrawerPlytList$10.w = drawerPlaylistInfo0;
                            drawerFragmentViewModel$fetchDrawerPlytList$10.M = 5;
                            Object object3 = g0.d("all", "DSPLY_ORDER", drawerFragmentViewModel$fetchDrawerPlytList$10);
                            if(object3 != a0) {
                                drawerPlaylistInfo1 = drawerPlaylistInfo0;
                                object0 = object3;
                                s2 = s1;
                                break alab1;
                            }
                            break;
                        }
                        case "RECENT": {
                            drawerFragmentViewModel$fetchDrawerPlytList$10.r = s1;
                            drawerFragmentViewModel$fetchDrawerPlytList$10.w = drawerPlaylistInfo0;
                            drawerFragmentViewModel$fetchDrawerPlytList$10.M = 3;
                            Object object2 = g0.c(drawerFragmentViewModel$fetchDrawerPlytList$10);
                            if(object2 != a0) {
                                drawerPlaylistInfo1 = drawerPlaylistInfo0;
                                object0 = object2;
                                s2 = s1;
                                break alab1;
                            }
                            break;
                        }
                        default: {
                            drawerFragmentViewModel$fetchDrawerPlytList$10.r = s1;
                            drawerFragmentViewModel$fetchDrawerPlytList$10.w = drawerPlaylistInfo0;
                            drawerFragmentViewModel$fetchDrawerPlytList$10.M = 6;
                            Object object1 = g0.a("all", "UDT", drawerFragmentViewModel$fetchDrawerPlytList$10);
                            if(object1 != a0) {
                                drawerPlaylistInfo1 = drawerPlaylistInfo0;
                                object0 = object1;
                                s2 = s1;
                                break alab1;
                            }
                        }
                    }
                }
                return a0;
            }
            case 2: {
                responseV6Res1 = drawerFragmentViewModel$fetchDrawerPlytList$10.E;
                s1 = drawerFragmentViewModel$fetchDrawerPlytList$10.D;
                drawerFragmentViewModel0 = drawerFragmentViewModel$fetchDrawerPlytList$10.B;
                n.D(object0);
                this.updateUiState(new f(0, this, drawerFragmentViewModel0.d(s1, responseV6Res1, ((nc.u0)(((nc.a)object0))).I().g)));
                return h0;
            }
            case 3: {
                drawerPlaylistInfo1 = drawerFragmentViewModel$fetchDrawerPlytList$10.w;
                s2 = drawerFragmentViewModel$fetchDrawerPlytList$10.r;
                n.D(object0);
                break;
            }
            case 4: {
                drawerPlaylistInfo1 = drawerFragmentViewModel$fetchDrawerPlytList$10.w;
                s2 = drawerFragmentViewModel$fetchDrawerPlytList$10.r;
                n.D(object0);
                break;
            }
            case 5: {
                drawerPlaylistInfo1 = drawerFragmentViewModel$fetchDrawerPlytList$10.w;
                s2 = drawerFragmentViewModel$fetchDrawerPlytList$10.r;
                n.D(object0);
                break;
            }
            case 6: {
                drawerPlaylistInfo1 = drawerFragmentViewModel$fetchDrawerPlytList$10.w;
                s2 = drawerFragmentViewModel$fetchDrawerPlytList$10.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((Na.f)object0) instanceof Na.d && ((Na.d)(((Na.f)object0))).a instanceof CancellationException) {
            LogU.debug$default(this.f, "fetchDrawerPlytList() canceled.", null, false, 6, null);
            return h0;
        }
        F f0 = new F(this, s2, ((Na.f)object0).b(), drawerPlaylistInfo1, 9);
        if(WhenMappings.$EnumSwitchMapping$0[((Na.f)object0).getResult().ordinal()] == 1) {
            HttpResponse httpResponse0 = ((Na.f)object0).b();
            if(httpResponse0 != null) {
                k40 = (K4)f0.invoke(this.getResult(httpResponse0));
            }
        }
        else {
            k40 = this.handleDefaultHttpResponseResult(((Na.f)object0), f0);
        }
        if(k40 != null) {
            this.updateUiState(new com.iloen.melon.player.playlist.drawernew.d(k40, 2));
        }
        return h0;
    }

    public final List d(String s, HttpResponse httpResponse0, DrawerPlaylistInfo drawerPlaylistInfo0) {
        if(httpResponse0 == null) {
            return w.a;
        }
        boolean z = this.e.n();
        boolean z1 = ((d3)this.c).j() == null;
        String s1 = drawerPlaylistInfo0 == null ? null : drawerPlaylistInfo0.getContsId();
        if(s1 == null) {
            s1 = "";
        }
        String s2 = drawerPlaylistInfo0 == null ? null : drawerPlaylistInfo0.getSeedContsId();
        if(s2 == null) {
            s2 = "";
        }
        switch(s) {
            case "LIKE": {
                ArrayList arrayList3 = ((MyMusicLikePlaylistRes)httpResponse0).response.likePlaylistList;
                q.f(arrayList3, "likePlaylistList");
                List list3 = new ArrayList(je.q.Q(10, arrayList3));
                for(Object object3: arrayList3) {
                    String s5 = ((LIKEPLYLSTLIST)object3).contentId;
                    if(s5.length() == 0) {
                        s5 = "PlaylistSeqLike";
                    }
                    String s6 = ((LIKEPLYLSTLIST)object3).seedContentId;
                    if(s6 == null) {
                        s6 = "";
                    }
                    s1.equals(s5);
                    s2.equals(s6);
                    ((ArrayList)list3).add(DrawerPlytMapper.INSTANCE.likeToDrawerPlytListListItemUiState(((LIKEPLYLSTLIST)object3), z, false));
                }
                return list3;
            }
            case "MADE_BY_ME": {
                ArrayList arrayList2 = ((MyMusicSmartPlaylistListRes)httpResponse0).response.playlistList;
                q.f(arrayList2, "playlistList");
                List list2 = new ArrayList(je.q.Q(10, arrayList2));
                for(Object object2: arrayList2) {
                    q.d(((PLAYLISTLIST)object2));
                    s1.equals(((PLAYLISTLIST)object2).plylstseq);
                    ((ArrayList)list2).add(DrawerPlytMapper.INSTANCE.madeByMeToDrawerPlytListListItemUiState(((PLAYLISTLIST)object2), z, false));
                }
                return list2;
            }
            case "RECENT": {
                ArrayList arrayList1 = ((MyMusicRecentPlaylistRes)httpResponse0).response.recentPlaylistList;
                q.f(arrayList1, "recentPlaylistList");
                List list1 = new ArrayList(je.q.Q(10, arrayList1));
                for(Object object1: arrayList1) {
                    String s3 = ((RECNTPLYLSTLIST)object1).contentId;
                    if(s3.length() == 0) {
                        s3 = "PlaylistSeqRecent";
                    }
                    String s4 = ((RECNTPLYLSTLIST)object1).seedContentId;
                    if(s4 == null) {
                        s4 = "";
                    }
                    s1.equals(s3);
                    s2.equals(s4);
                    ((ArrayList)list1).add(DrawerPlytMapper.INSTANCE.recentToDrawerPlytListListItemUiState(((RECNTPLYLSTLIST)object1), z, false));
                }
                return list1;
            }
            default: {
                ArrayList arrayList0 = ((DjSmartPlaylistListRes)httpResponse0).response.djPlaylistList;
                q.f(arrayList0, "djPlaylistList");
                List list0 = new ArrayList(je.q.Q(10, arrayList0));
                for(Object object0: arrayList0) {
                    q.d(((DJPLAYLISTLIST)object0));
                    s1.equals(((DJPLAYLISTLIST)object0).plylstseq);
                    ((ArrayList)list0).add(DrawerPlytMapper.INSTANCE.djToDrawerPlytListListItemUiState(((DJPLAYLISTLIST)object0), z, false));
                }
                return list0;
            }
        }
    }

    public final void e(String s, List list0) {
        LogU.debug$default(this.f, "updateDrawerPlytListListUiState() fromCall: " + s, null, false, 6, null);
        this.g.setValue(list0);
    }

    @NotNull
    public final List getAlyacList() {
        return this.o;
    }

    @NotNull
    public final StateFlow getDrawerPlytListListUiState() {
        return this.h;
    }

    @NotNull
    public final StateFlow getDrawerPlytViewType() {
        return this.n;
    }

    @NotNull
    public final StateFlow getSelectedAlyacKey() {
        return this.l;
    }

    @NotNull
    public final StateFlow getShowProgressForIdle() {
        return this.j;
    }

    @NotNull
    public final DrawerPlaylistTiaraLogHelper getTiaraLogHelper() {
        return this.q;
    }

    public final boolean isBottomSheet() {
        return this.p;
    }

    @Override  // com.melon.ui.k1
    @Nullable
    public Object onFetchStart(@NotNull g1 g10, @NotNull Continuation continuation0) {
        String s;
        boolean z1;
        boolean z;
        com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel.onFetchStart.1 drawerFragmentViewModel$onFetchStart$10;
        if(continuation0 instanceof com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel.onFetchStart.1) {
            drawerFragmentViewModel$onFetchStart$10 = (com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel.onFetchStart.1)continuation0;
            int v = drawerFragmentViewModel$onFetchStart$10.E;
            if((v & 0x80000000) == 0) {
                drawerFragmentViewModel$onFetchStart$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    public Object B;
                    public int E;
                    public g1 r;
                    public boolean w;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.B = object0;
                        this.E |= 0x80000000;
                        return continuation0.onFetchStart(null, this);
                    }
                };
            }
            else {
                drawerFragmentViewModel$onFetchStart$10.E = v ^ 0x80000000;
            }
        }
        else {
            drawerFragmentViewModel$onFetchStart$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                public Object B;
                public int E;
                public g1 r;
                public boolean w;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.B = object0;
                    this.E |= 0x80000000;
                    return continuation0.onFetchStart(null, this);
                }
            };
        }
        Object object0 = drawerFragmentViewModel$onFetchStart$10.B;
        ne.a a0 = ne.a.a;
        H h0 = H.a;
        switch(drawerFragmentViewModel$onFetchStart$10.E) {
            case 0: {
                n.D(object0);
                drawerFragmentViewModel$onFetchStart$10.r = g10;
                drawerFragmentViewModel$onFetchStart$10.E = 1;
                object0 = ((e0)this.b).o(drawerFragmentViewModel$onFetchStart$10);
                if(object0 != a0) {
                label_34:
                    z1 = ((Boolean)object0).booleanValue();
                    if(!z1) {
                        this.updateUiState(new h(6));
                        return h0;
                    }
                    Flow flow0 = this.k;
                    if(g10 instanceof f1) {
                        Bundle bundle0 = ((f1)g10).a;
                        if(bundle0 == null) {
                        label_44:
                            drawerFragmentViewModel$onFetchStart$10.r = null;
                            drawerFragmentViewModel$onFetchStart$10.w = true;
                            drawerFragmentViewModel$onFetchStart$10.E = 2;
                            Object object1 = FlowKt.first(flow0, drawerFragmentViewModel$onFetchStart$10);
                            if(object1 != a0) {
                                z1 = true;
                                s = (String)object1;
                                goto label_59;
                            }
                        }
                        else {
                            s = bundle0.getString("EXTRA_PLYT_TAB");
                            if(s == null) {
                                goto label_44;
                            }
                            else {
                                goto label_59;
                            }
                        }
                    }
                    else {
                        drawerFragmentViewModel$onFetchStart$10.r = null;
                        drawerFragmentViewModel$onFetchStart$10.w = true;
                        drawerFragmentViewModel$onFetchStart$10.E = 3;
                        Object object2 = FlowKt.first(flow0, drawerFragmentViewModel$onFetchStart$10);
                        if(object2 != a0) {
                            z1 = true;
                            s = (String)object2;
                        label_59:
                            drawerFragmentViewModel$onFetchStart$10.r = null;
                            drawerFragmentViewModel$onFetchStart$10.w = z1;
                            drawerFragmentViewModel$onFetchStart$10.E = 4;
                            if(this.c(s, drawerFragmentViewModel$onFetchStart$10) != a0) {
                                return h0;
                            }
                        }
                    }
                }
                break;
            }
            case 1: {
                g10 = drawerFragmentViewModel$onFetchStart$10.r;
                n.D(object0);
                goto label_34;
            }
            case 2: {
                z = drawerFragmentViewModel$onFetchStart$10.w;
                n.D(object0);
                z1 = z;
                s = (String)object0;
                goto label_59;
            }
            case 3: {
                z = drawerFragmentViewModel$onFetchStart$10.w;
                n.D(object0);
                z1 = z;
                s = (String)object0;
                goto label_59;
            }
            case 4: {
                n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }

    @Override  // com.melon.ui.k1
    public void onUserEvent(@NotNull e e0) {
        q.g(e0, "userEvent");
        super.onUserEvent(e0);
        if(e0 instanceof OnToggleViewMode) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new we.n(null) {
                public final DrawerFragmentViewModel B;
                public String r;
                public int w;

                {
                    this.B = drawerFragmentViewModel0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel.onUserEvent.1(this.B, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel.onUserEvent.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    String s1;
                    ne.a a0 = ne.a.a;
                    DrawerFragmentViewModel drawerFragmentViewModel0 = this.B;
                    switch(this.w) {
                        case 0: {
                            n.D(object0);
                            this.w = 1;
                            object0 = FlowKt.first(drawerFragmentViewModel0.m, this);
                            if(object0 == a0) {
                                return a0;
                            }
                            goto label_10;
                        }
                        case 1: {
                            n.D(object0);
                        label_10:
                            String s = q.b(((String)object0), "LIST") ? "GRID" : "LIST";
                            this.r = (String)object0;
                            this.w = 2;
                            if(DrawerPlaylistPreferencesRepository.INSTANCE.updateViewMode(s, this) == a0) {
                                return a0;
                            }
                            s1 = (String)object0;
                            break;
                        }
                        case 2: {
                            s1 = this.r;
                            n.D(object0);
                            break;
                        }
                        default: {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                    }
                    boolean z = !q.b(s1, "LIST");
                    drawerFragmentViewModel0.getTiaraLogHelper().sendSubMenuClickLog(false, "");
                    return H.a;
                }
            }, 3, null);
            return;
        }
        DrawerPlaylistTiaraLogHelper drawerPlaylistTiaraLogHelper0 = this.q;
        if(e0 instanceof OnClickAlyac) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new we.n(this, null) {
                public final DrawerFragmentViewModel B;
                public int r;
                public final e w;

                {
                    this.w = e0;
                    this.B = drawerFragmentViewModel0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel.onUserEvent.2(this.w, this.B, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel.onUserEvent.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    ne.a a0 = ne.a.a;
                    switch(this.r) {
                        case 0: {
                            n.D(object0);
                            String s = ((OnClickAlyac)this.w).getAlyac();
                            this.r = 1;
                            if(DrawerPlaylistPreferencesRepository.INSTANCE.updateLastTab(s, this) == a0) {
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
                    String s1 = (String)this.B.getSelectedAlyacKey().getValue();
                    String s2 = DrawerPlytTab.Companion.getPvDummyLogActionFromAlyacKey(s1);
                    n0.performPvDummyLogging$default(this.B, s2, null, 2, null);
                    return H.a;
                }
            }, 3, null);
            Bundle bundle0 = new Bundle();
            bundle0.putString("EXTRA_PLYT_TAB", ((OnClickAlyac)e0).getAlyac());
            k1.startFetch$default(this, true, bundle0, null, 4, null);
            boolean z = this.p;
            String s = (String)this.l.getValue();
            drawerPlaylistTiaraLogHelper0.sendSubMenuClickLog(z, DrawerPlytTab.Companion.getAlyacName(s));
            return;
        }
        if(e0 instanceof OnClickPlay) {
            DrawerPlaylistInfo drawerPlaylistInfo0 = ((OnClickPlay)e0).getDrawerPlaylistInfo();
            this.playPlaylist(drawerPlaylistInfo0);
            drawerPlaylistTiaraLogHelper0.sendPlayClickLog(this.p, !drawerPlaylistInfo0.isRecentOrLike(), drawerPlaylistInfo0);
            return;
        }
        if(e0 instanceof OnClickItem) {
            DrawerPlaylistInfo drawerPlaylistInfo1 = ((OnClickItem)e0).getDrawerPlaylistInfo();
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new DrawerFragmentViewModel.openPlaylist.1(this, drawerPlaylistInfo1, null), 3, null);
            drawerPlaylistTiaraLogHelper0.sendPlaylistClickLog(this.p, !drawerPlaylistInfo1.isRecentOrLike(), drawerPlaylistInfo1);
        }
    }

    public final void playPlaylist(@NotNull DrawerPlaylistInfo drawerPlaylistInfo0) {
        q.g(drawerPlaylistInfo0, "drawerPlaylistInfo");
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new we.n(drawerPlaylistInfo0, null) {
            public AddPlay B;
            public int D;
            public int E;
            public Object G;
            public final DrawerFragmentViewModel I;
            public final DrawerPlaylistInfo M;
            public DrawerFragmentViewModel r;
            public DrawerPlaylistInfo w;

            {
                this.I = drawerFragmentViewModel0;
                this.M = drawerPlaylistInfo0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel.playPlaylist.1(this.I, this.M, continuation0);
                continuation1.G = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel.playPlaylist.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                o o0;
                DrawerFragmentViewModel drawerFragmentViewModel2;
                int v;
                CoroutineScope coroutineScope0 = (CoroutineScope)this.G;
                ne.a a0 = ne.a.a;
                H h0 = H.a;
                boolean z = true;
                switch(this.E) {
                    case 0: {
                        n.D(object0);
                        DrawerFragmentViewModel drawerFragmentViewModel0 = this.I;
                        DrawerPlaylistInfo drawerPlaylistInfo0 = this.M;
                        try {
                            AddPlay addAction$AddPlay0 = new AddPlay(false);
                            this.G = null;
                            this.r = drawerFragmentViewModel0;
                            this.w = drawerPlaylistInfo0;
                            this.B = addAction$AddPlay0;
                            this.D = 0;
                            this.E = 1;
                            Object object1 = DrawerFragmentViewModel.access$requestPlay(drawerFragmentViewModel0, addAction$AddPlay0, drawerPlaylistInfo0, this);
                            if(object1 == a0) {
                                return a0;
                            }
                            DrawerFragmentViewModel drawerFragmentViewModel1 = drawerFragmentViewModel0;
                            object0 = object1;
                            v = 0;
                            goto label_27;
                        label_22:
                            v = this.D;
                            addAction$AddPlay0 = this.B;
                            drawerPlaylistInfo0 = this.w;
                            drawerFragmentViewModel1 = this.r;
                            n.D(object0);
                        label_27:
                            ((AddResult)object0).handleToast(addAction$AddPlay0);
                            if(((AddResult)object0) instanceof Success) {
                                B b0 = ((d3)drawerFragmentViewModel1.c).l();
                                this.G = null;
                                this.r = drawerFragmentViewModel1;
                                this.w = null;
                                this.B = null;
                                this.D = v;
                                this.E = 2;
                                object0 = ListenableFutureKt.await(b0, this);
                                if(object0 == a0) {
                                    return a0;
                                }
                                drawerFragmentViewModel2 = drawerFragmentViewModel1;
                                goto label_53;
                            }
                            else {
                                if(!(((AddResult)object0) instanceof Failure)) {
                                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                }
                                if(q.b(((Failure)(((AddResult)object0))).getType(), SectionRepeatInterrupt.INSTANCE)) {
                                    drawerFragmentViewModel1.sendUiEvent(new ShowSelectionRepeatInterruptPopup(new com.iloen.melon.player.playlist.drawernew.g(drawerFragmentViewModel1, drawerPlaylistInfo0, 0)));
                                    return h0;
                                }
                                drawerFragmentViewModel2 = drawerFragmentViewModel1;
                                z = false;
                            }
                            goto label_55;
                        }
                        catch(Throwable throwable0) {
                            break;
                        }
                    }
                    case 1: {
                        goto label_22;
                    }
                    case 2: {
                        v = this.D;
                        AddResult addResult0 = (AddResult)this.B;
                        CoroutineScope coroutineScope1 = (CoroutineScope)this.w;
                        drawerFragmentViewModel2 = this.r;
                        try {
                            n.D(object0);
                        label_53:
                            if(e.k.y(((oc.H)object0))) {
                                z = false;
                            }
                        label_55:
                            if(z) {
                                B b1 = ((d3)drawerFragmentViewModel2.c).l();
                                this.G = null;
                                this.r = drawerFragmentViewModel2;
                                this.w = null;
                                this.B = null;
                                this.D = v;
                                this.E = 3;
                                object0 = ListenableFutureKt.await(b1, this);
                                if(object0 == a0) {
                                    return a0;
                                }
                                drawerFragmentViewModel2.sendUiEvent(new OnOpenDrawerSongPlaylist(new DrawerPlaylistTabInfo(((nc.a)object0))));
                            }
                            else {
                                drawerFragmentViewModel2.sendUiEvent(OnFailOpenDrawerSmartPlaylist.INSTANCE);
                            }
                            o0 = h0;
                            goto label_79;
                        }
                        catch(Throwable throwable0) {
                            break;
                        }
                    }
                    case 3: {
                        AddResult addResult1 = (AddResult)this.B;
                        CoroutineScope coroutineScope2 = (CoroutineScope)this.w;
                        DrawerFragmentViewModel drawerFragmentViewModel3 = this.r;
                        try {
                            n.D(object0);
                            drawerFragmentViewModel3.sendUiEvent(new OnOpenDrawerSongPlaylist(new DrawerPlaylistTabInfo(((nc.a)object0))));
                            o0 = h0;
                            goto label_79;
                        }
                        catch(Throwable throwable0) {
                        }
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                o0 = n.t(throwable0);
            label_79:
                Throwable throwable1 = p.a(o0);
                if(throwable1 != null && throwable1 instanceof VolleyError) {
                    ToastManager.show(throwable1.getMessage());
                }
                return h0;

                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
                @oe.e(c = "com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel$playPlaylist$1$1$canPlay$1$1", f = "DrawerFragmentViewModel.kt", l = {494}, m = "invokeSuspend")
                final class com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel.playPlaylist.1.1.canPlay.1.1 extends i implements we.n {
                    public final DrawerPlaylistInfo B;
                    public int r;
                    public final DrawerFragmentViewModel w;

                    public com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel.playPlaylist.1.1.canPlay.1.1(DrawerFragmentViewModel drawerFragmentViewModel0, DrawerPlaylistInfo drawerPlaylistInfo0, Continuation continuation0) {
                        this.w = drawerFragmentViewModel0;
                        this.B = drawerPlaylistInfo0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel.playPlaylist.1.1.canPlay.1.1(this.w, this.B, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.player.playlist.drawernew.DrawerFragmentViewModel.playPlaylist.1.1.canPlay.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        ne.a a0 = ne.a.a;
                        DrawerFragmentViewModel drawerFragmentViewModel0 = this.w;
                        switch(this.r) {
                            case 0: {
                                n.D(object0);
                                this.r = 1;
                                if(drawerFragmentViewModel0.e.b(0x7F13090F, this) == a0) {  // string:section_repeat_mode_release_toast "반복재생이 해제되었습니다.\n반복재생은 재생 목록에서 재설정 가능합니다."
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
                        drawerFragmentViewModel0.playPlaylist(this.B);
                        return H.a;
                    }
                }

            }
        }, 3, null);
    }

    public final void setBottomSheet(boolean z) {
        this.p = z;
    }
}

