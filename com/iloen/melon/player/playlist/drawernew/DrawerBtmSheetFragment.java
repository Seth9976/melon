package com.iloen.melon.player.playlist.drawernew;

import Ac.U2;
import Bc.h;
import Cc.N1;
import Cc.e0;
import Cc.t0;
import H0.e;
import J8.V0;
import M.j;
import M.p0;
import M.y;
import N0.M;
import P0.i;
import Q4.a;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.s;
import com.iloen.melon.custom.L0;
import com.iloen.melon.player.playlist.DrawerPlaylistTabInfo;
import com.iloen.melon.player.playlist.common.PlaylistCommonUiEvent.ShowSelectionRepeatInterruptPopup;
import com.iloen.melon.player.playlist.drawernew.composable.DrawerAlyacListKt;
import com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt;
import com.iloen.melon.player.playlist.drawernew.model.DrawerPlytTab;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.X0;
import ie.H;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 ,2\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001,B!\u0012\u0018\u0010\b\u001A\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00020\u000BH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u000EH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0016\u001A\u00020\u00072\u0006\u0010\u0013\u001A\u00020\u00122\b\u0010\u0015\u001A\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001A\u00020\u00072\b\u0010\u0015\u001A\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001C\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u001C\u0010\u001BJ\u0017\u0010\u001F\u001A\u00020\u00072\u0006\u0010\u001E\u001A\u00020\u001DH\u0016¢\u0006\u0004\b\u001F\u0010 J\u0017\u0010#\u001A\u00020\u00072\u0006\u0010\"\u001A\u00020!H\u0014¢\u0006\u0004\b#\u0010$R\"\u0010&\u001A\u00020%8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b&\u0010\'\u001A\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerBtmSheetFragment;", "Lcom/melon/ui/w0;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerFragmentViewModel;", "LJ8/V0;", "Lkotlin/Function2;", "Lcom/iloen/melon/player/playlist/DrawerPlaylistTabInfo;", "", "Lie/H;", "onSuccessOpenAction", "<init>", "(Lwe/n;)V", "Ljava/lang/Class;", "getViewModelClass", "()Ljava/lang/Class;", "Landroid/view/LayoutInflater;", "inflater", "getViewBinding", "(Landroid/view/LayoutInflater;)LJ8/V0;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onResume", "Lcom/melon/ui/I4;", "event", "onUiEvent", "(Lcom/melon/ui/I4;)V", "Lcom/melon/ui/K4;", "uiState", "renderUi", "(Lcom/melon/ui/K4;)V", "LBc/h;", "playerUiHelper", "LBc/h;", "getPlayerUiHelper", "()LBc/h;", "setPlayerUiHelper", "(LBc/h;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DrawerBtmSheetFragment extends Hilt_DrawerBtmSheetFragment {
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\'\u0010\b\u001A\u00020\u00072\u0018\u0010\u0006\u001A\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000B\u001A\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerBtmSheetFragment$Companion;", "", "Lkotlin/Function2;", "Lcom/iloen/melon/player/playlist/DrawerPlaylistTabInfo;", "", "Lie/H;", "onSuccessOpenAction", "Lcom/iloen/melon/player/playlist/drawernew/DrawerBtmSheetFragment;", "newInstance", "(Lwe/n;)Lcom/iloen/melon/player/playlist/drawernew/DrawerBtmSheetFragment;", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final DrawerBtmSheetFragment newInstance(@NotNull n n0) {
            q.g(n0, "onSuccessOpenAction");
            return new DrawerBtmSheetFragment(n0);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "DrawerBtmSheetFragment";
    public final n i;
    public boolean j;
    @Inject
    public h playerUiHelper;

    static {
        DrawerBtmSheetFragment.Companion = new Companion(null);
        DrawerBtmSheetFragment.$stable = 8;
    }

    public DrawerBtmSheetFragment(@NotNull n n0) {
        q.g(n0, "onSuccessOpenAction");
        super();
        this.i = n0;
    }

    public static final DrawerFragmentViewModel access$getViewModel(DrawerBtmSheetFragment drawerBtmSheetFragment0) {
        return (DrawerFragmentViewModel)drawerBtmSheetFragment0.getViewModel();
    }

    @NotNull
    public final h getPlayerUiHelper() {
        h h0 = this.playerUiHelper;
        if(h0 != null) {
            return h0;
        }
        q.m("playerUiHelper");
        throw null;
    }

    @NotNull
    public V0 getViewBinding(@NotNull LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return V0.a(layoutInflater0, null);
    }

    @Override  // com.melon.ui.w0
    public a getViewBinding(LayoutInflater layoutInflater0) {
        return this.getViewBinding(layoutInflater0);
    }

    @Override  // com.melon.ui.w0
    @NotNull
    public Class getViewModelClass() {
        return DrawerFragmentViewModel.class;
    }

    public final void n(List list0, String s, k k0, k k1, l l0, int v) {
        ((p)l0).c0(0x20B6D2E4);
        int v1 = v | (((p)l0).i(list0) ? 4 : 2) | (((p)l0).g(s) ? 0x20 : 16) | (((p)l0).i(k0) ? 0x100 : 0x80) | (((p)l0).i(k1) ? 0x800 : 0x400);
        if(((p)l0).Q(v1 & 1, (v1 & 0x493) != 1170)) {
            DrawerPlytListKt.DrawerPlytPlyt(null, list0, "LIST", true, NetUtils.isConnected(), s, k0, k1, ((p)l0), v1 << 3 & 0x70 | 0xD80 | 0x70000 & v1 << 12 | 0x380000 & v1 << 12 | v1 << 12 & 0x1C00000, 1);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new t0(this, list0, s, k0, k1, v);
        }
    }

    public final void o(l l0, int v) {
        ((p)l0).c0(0x10EA9BAF);
        if(((p)l0).Q(v & 1, (v & 1) != 0)) {
            String s = e.Y(((p)l0), 0x7F13037B);  // string:drawer_playlist_list_popup "음악서랍 목록"
            long v1 = e0.T(((p)l0), 0x7F06016D);  // color:gray900s
            r0.q q0 = androidx.compose.foundation.layout.a.n(d.h(r0.n.a, 57.0f), 20.0f, 18.0f, 48.0f, 0.0f, 8);
            com.iloen.melon.player.playlist.common.h h0 = ((p)l0).N();
            if(h0 == androidx.compose.runtime.k.a) {
                h0 = new com.iloen.melon.player.playlist.common.h(1);
                ((p)l0).l0(h0);
            }
            N1.b(s, X0.n.c(q0, false, h0), v1, 18.0f, null, null, 0L, null, 0.0f, 0, false, 1, 0, null, null, ((p)l0), 0xC00, 0xC00, 0x1DFF0);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.drawernew.k(this, v);
        }
    }

    @Override  // com.melon.ui.w0
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        L0 l00 = e.G(this);
        if(l00 != null) {
            ((DrawerFragmentViewModel)this.getViewModel()).registerProgressUpdater(l00);
        }
    }

    @Override  // androidx.fragment.app.I
    public void onResume() {
        super.onResume();
        ((DrawerFragmentViewModel)this.getViewModel()).setBottomSheet(true);
    }

    @Override  // com.melon.ui.Y
    public void onStart() {
        super.onStart();
        this.sendUserEvent(new X0(false, null));
        Dialog dialog0 = this.getDialog();
        if(dialog0 != null) {
            Window window0 = dialog0.getWindow();
            if(window0 != null) {
                WindowManager.LayoutParams windowManager$LayoutParams0 = window0.getAttributes();
                windowManager$LayoutParams0.gravity = 80;
                windowManager$LayoutParams0.width = -1;
                windowManager$LayoutParams0.height = (int)(((float)ScreenUtils.getScreenHeight(window0.getContext())) * 0.7f);
                windowManager$LayoutParams0.windowAnimations = 0x7F140189;  // style:MelonDialogAnimation
                window0.setBackgroundDrawableResource(0x7F06048A);  // color:transparent
            }
        }
    }

    @Override  // com.melon.ui.w0
    public void onUiEvent(@NotNull I4 i40) {
        q.g(i40, "event");
        if(i40 instanceof com.melon.ui.e0) {
            ((DrawerFragmentViewModel)this.getViewModel()).getTiaraLogHelper().updateTiaraPropertyToLogHelper(((com.melon.ui.e0)i40).a);
            return;
        }
        if(i40 instanceof OnOpenDrawerSongPlaylist) {
            DrawerPlaylistTabInfo drawerPlaylistTabInfo0 = ((OnOpenDrawerSongPlaylist)i40).getPlaylistTabInfo();
            this.i.invoke(drawerPlaylistTabInfo0, Boolean.TRUE);
            return;
        }
        if(i40 instanceof OnFailOpenDrawerSmartPlaylist) {
            this.dismiss();
            return;
        }
        if(i40 instanceof ShowSelectionRepeatInterruptPopup) {
            h h0 = this.getPlayerUiHelper();
            l0 l00 = this.getChildFragmentManager();
            q.f(l00, "getChildFragmentManager(...)");
            h0.e(l00, ((ShowSelectionRepeatInterruptPopup)i40).getOkAction());
        }
    }

    @Override  // com.melon.ui.w0
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(null) {
            public int r;
            public final DrawerBtmSheetFragment w;

            {
                this.w = drawerBtmSheetFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.drawernew.DrawerBtmSheetFragment.onViewCreated.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.drawernew.DrawerBtmSheetFragment.onViewCreated.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.player.playlist.drawernew.DrawerBtmSheetFragment.onViewCreated.1.1 drawerBtmSheetFragment$onViewCreated$1$10 = new n(null) {
                            public int r;
                            public final DrawerBtmSheetFragment w;

                            {
                                this.w = drawerBtmSheetFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.player.playlist.drawernew.DrawerBtmSheetFragment.onViewCreated.1.1(this.w, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.player.playlist.drawernew.DrawerBtmSheetFragment.onViewCreated.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.r) {
                                    case 0: {
                                        d5.n.D(object0);
                                        com.iloen.melon.player.playlist.drawernew.DrawerBtmSheetFragment.onViewCreated.1.1.invokeSuspend..inlined.filter.1 drawerBtmSheetFragment$onViewCreated$1$1$invokeSuspend$$inlined$filter$10 = new Flow() {
                                            @Override  // kotlinx.coroutines.flow.Flow
                                            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                                                com.iloen.melon.player.playlist.drawernew.DrawerBtmSheetFragment.onViewCreated.1.1.invokeSuspend..inlined.filter.1.2 drawerBtmSheetFragment$onViewCreated$1$1$invokeSuspend$$inlined$filter$1$20 = new FlowCollector() {
                                                    @Override  // kotlinx.coroutines.flow.FlowCollector
                                                    public final Object emit(Object object0, Continuation continuation0) {
                                                        com.iloen.melon.player.playlist.drawernew.DrawerBtmSheetFragment.onViewCreated.1.1.invokeSuspend..inlined.filter.1.2.1 drawerBtmSheetFragment$onViewCreated$1$1$invokeSuspend$$inlined$filter$1$2$10;
                                                        if(continuation0 instanceof com.iloen.melon.player.playlist.drawernew.DrawerBtmSheetFragment.onViewCreated.1.1.invokeSuspend..inlined.filter.1.2.1) {
                                                            drawerBtmSheetFragment$onViewCreated$1$1$invokeSuspend$$inlined$filter$1$2$10 = (com.iloen.melon.player.playlist.drawernew.DrawerBtmSheetFragment.onViewCreated.1.1.invokeSuspend..inlined.filter.1.2.1)continuation0;
                                                            int v = drawerBtmSheetFragment$onViewCreated$1$1$invokeSuspend$$inlined$filter$1$2$10.w;
                                                            if((v & 0x80000000) == 0) {
                                                                drawerBtmSheetFragment$onViewCreated$1$1$invokeSuspend$$inlined$filter$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                                                drawerBtmSheetFragment$onViewCreated$1$1$invokeSuspend$$inlined$filter$1$2$10.w = v ^ 0x80000000;
                                                            }
                                                        }
                                                        else {
                                                            drawerBtmSheetFragment$onViewCreated$1$1$invokeSuspend$$inlined$filter$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                                        Object object1 = drawerBtmSheetFragment$onViewCreated$1$1$invokeSuspend$$inlined$filter$1$2$10.r;
                                                        ne.a a0 = ne.a.a;
                                                        switch(drawerBtmSheetFragment$onViewCreated$1$1$invokeSuspend$$inlined$filter$1$2$10.w) {
                                                            case 0: {
                                                                d5.n.D(object1);
                                                                if(((String)object0).length() > 0) {
                                                                    drawerBtmSheetFragment$onViewCreated$1$1$invokeSuspend$$inlined$filter$1$2$10.w = 1;
                                                                    if(this.a.emit(object0, drawerBtmSheetFragment$onViewCreated$1$1$invokeSuspend$$inlined$filter$1$2$10) == a0) {
                                                                        return a0;
                                                                    }
                                                                }
                                                                return H.a;
                                                            }
                                                            case 1: {
                                                                d5.n.D(object1);
                                                                return H.a;
                                                            }
                                                            default: {
                                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                            }
                                                        }
                                                    }
                                                };
                                                Object object0 = this.a.collect(drawerBtmSheetFragment$onViewCreated$1$1$invokeSuspend$$inlined$filter$1$20, continuation0);
                                                return object0 == ne.a.a ? object0 : H.a;
                                            }
                                        };
                                        com.iloen.melon.player.playlist.drawernew.DrawerBtmSheetFragment.onViewCreated.1.1.2 drawerBtmSheetFragment$onViewCreated$1$1$20 = new n(null) {
                                            public Object r;
                                            public final DrawerBtmSheetFragment w;

                                            {
                                                this.w = drawerBtmSheetFragment0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                Continuation continuation1 = new com.iloen.melon.player.playlist.drawernew.DrawerBtmSheetFragment.onViewCreated.1.1.2(this.w, continuation0);
                                                continuation1.r = object0;
                                                return continuation1;
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((String)object0), ((Continuation)object1));
                                            }

                                            public final Object invoke(String s, Continuation continuation0) {
                                                return ((com.iloen.melon.player.playlist.drawernew.DrawerBtmSheetFragment.onViewCreated.1.1.2)this.create(s, continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                String s = (String)this.r;
                                                d5.n.D(object0);
                                                DrawerBtmSheetFragment drawerBtmSheetFragment0 = this.w;
                                                if(!drawerBtmSheetFragment0.j) {
                                                    com.melon.ui.n0.performPvDummyLogging$default(DrawerBtmSheetFragment.access$getViewModel(drawerBtmSheetFragment0), DrawerPlytTab.Companion.getPvDummyLogActionFromAlyacKey(s), null, 2, null);
                                                    drawerBtmSheetFragment0.j = true;
                                                }
                                                return H.a;
                                            }
                                        };
                                        this.r = 1;
                                        return FlowKt.collectLatest(drawerBtmSheetFragment$onViewCreated$1$1$invokeSuspend$$inlined$filter$10, drawerBtmSheetFragment$onViewCreated$1$1$20, this) == a0 ? a0 : H.a;
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
                        };
                        this.r = 1;
                        return f0.j(this.w, s.d, drawerBtmSheetFragment$onViewCreated$1$10, this) == a0 ? a0 : H.a;
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

    public final void p(int v, l l0, String s, List list0, k k0) {
        p p0 = (p)l0;
        p0.c0(0x5F062786);
        int v1 = v | (p0.i(list0) ? 4 : 2) | (p0.g(s) ? 0x20 : 16) | (p0.i(k0) ? 0x100 : 0x80);
        boolean z = false;
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            r0.q q0 = androidx.compose.foundation.layout.a.n(r0.n.a, 20.0f, 0.0f, 20.0f, 0.0f, 10);
            p0 p00 = M.n0.a(j.a, r0.d.j, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, P0.j.f);
            w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q1, P0.j.d);
            LayoutWeightElement layoutWeightElement0 = new LayoutWeightElement(1.0f, true);
            if((v1 & 0x380) == 0x100) {
                z = true;
            }
            com.iloen.melon.player.playlist.drawernew.d d0 = p0.N();
            if(z || d0 == androidx.compose.runtime.k.a) {
                d0 = new com.iloen.melon.player.playlist.drawernew.d(k0, 0);
                p0.l0(d0);
            }
            DrawerAlyacListKt.DrawerAlyacList(layoutWeightElement0, list0, s, true, d0, p0, v1 << 3 & 0x70 | 0xC00 | v1 << 3 & 0x380, 0);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new U2(this, list0, s, k0, v, 22);
        }
    }

    public final void q(we.a a0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0x38B1E517);
        int v1 = (p0.i(a0) ? 4 : 2) | v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            y y0 = M.w.a(j.c, r0.d.m, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.n n0 = r0.n.a;
            r0.q q0 = r0.a.d(p0, n0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            P0.h h0 = P0.j.f;
            w.x(p0, y0, h0);
            P0.h h1 = P0.j.e;
            w.x(p0, i00, h1);
            P0.h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            P0.h h3 = P0.j.d;
            w.x(p0, q0, h3);
            e0.m(p0, 0);
            r0.q q1 = d.h(d.f(r0.a.a(n0, new DrawerBtmSheetFragment.Tail.lambda.27..inlined.noRippleClickable-YQRRFTQ.default.1(true, null, 0, a0)), 1.0f), E9.h.t(p0, 0x7F0700A2));  // dimen:common_filter_footer_height
            M m0 = M.p.d(r0.d.a, false);
            int v3 = p0.P;
            i0 i01 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            w.x(p0, q2, h3);
            String s = e.Y(p0, 0x7F1301D2);  // string:close "닫기"
            long v4 = e0.T(p0, 0x7F060169);  // color:gray850s
            N1.b(s, (b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, r0.d.e), v4, 16.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.drawernew.a(this, a0, v);
        }
    }

    @Override  // com.melon.ui.w0
    public void renderUi(@NotNull K4 k40) {
        q.g(k40, "uiState");
        V0 v00 = (V0)this.getBinding();
        if(v00 == null) {
            return;
        }
        m0.b b0 = new m0.b(0xEFF1F42E, new com.iloen.melon.player.playlist.drawernew.a(this, k40, 0), true);
        v00.b.setContent(b0);
    }

    public final void setPlayerUiHelper(@NotNull h h0) {
        q.g(h0, "<set-?>");
        this.playerUiHelper = h0;
    }
}

