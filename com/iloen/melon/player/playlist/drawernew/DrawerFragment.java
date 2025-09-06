package com.iloen.melon.player.playlist.drawernew;

import Bc.h;
import Cc.B1;
import Cc.c1;
import De.d;
import H8.i;
import J8.V0;
import M.p0;
import N0.M;
import P0.j;
import S2.c;
import android.content.Context;
import android.view.LayoutInflater;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.runtime.V;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.fragment.app.l0;
import androidx.lifecycle.f0;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import bd.F;
import com.iloen.melon.custom.f1;
import com.iloen.melon.custom.l1;
import com.iloen.melon.player.playlist.DrawerPlaylistTabInfo;
import com.iloen.melon.player.playlist.PlaylistSharedViewModel;
import com.iloen.melon.player.playlist.PlaylistTab;
import com.iloen.melon.player.playlist.common.PlaylistCommonUiEvent.ShowSelectionRepeatInterruptPopup;
import com.iloen.melon.player.playlist.drawernew.composable.DrawerAlyacListKt;
import com.iloen.melon.player.playlist.drawernew.composable.DrawerPlytListKt;
import com.iloen.melon.player.playlist.drawernew.model.DrawerPlytTab;
import com.iloen.melon.utils.network.NetUtils;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.a;
import com.melon.ui.b;
import com.melon.ui.e0;
import com.melon.ui.e;
import ie.H;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r0.n;
import we.k;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0007\u0018\u0000 :2\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001:B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001A\u00020\u00102\u0006\u0010\u0014\u001A\u00020\u0013H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000F\u0010\u0017\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0006J\u000F\u0010\u0019\u001A\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001AJF\u0010%\u001A\u00020\u00102\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u000F\u001A\u00020\u001D2\b\u0010\u001F\u001A\u0004\u0018\u00010\u001E2\u0012\u0010\"\u001A\u000E\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00100 2\u0006\u0010$\u001A\u00020#H\u0096\u0001¢\u0006\u0004\b%\u0010&R\"\u0010(\u001A\u00020\'8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b(\u0010)\u001A\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00105\u001A\u00020.8\u0016@\u0016X\u0096\u000E¢\u0006\u0012\n\u0004\b/\u00100\u001A\u0004\b1\u00102\"\u0004\b3\u00104R\u001A\u00107\u001A\u0002068\u0016X\u0096D¢\u0006\f\n\u0004\b7\u00108\u001A\u0004\b7\u00109¨\u0006;"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerFragment;", "Lcom/melon/ui/o1;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerFragmentViewModel;", "LJ8/V0;", "Lcom/melon/ui/a;", "<init>", "()V", "Ljava/lang/Class;", "getViewModelClass", "()Ljava/lang/Class;", "Landroid/view/LayoutInflater;", "inflater", "getViewBinding", "(Landroid/view/LayoutInflater;)LJ8/V0;", "Lcom/melon/ui/I4;", "event", "Lie/H;", "onUiEvent", "(Lcom/melon/ui/I4;)V", "Lcom/melon/ui/K4;", "uiState", "renderUi", "(Lcom/melon/ui/K4;)V", "onResume", "", "getPvDummyLogAction", "()Ljava/lang/String;", "Landroidx/fragment/app/l0;", "fragmentManager", "Lcom/melon/ui/b;", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "LPc/e;", "sendUserEvent", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "handleAddPlayUiEvent", "(Landroidx/fragment/app/l0;Lcom/melon/ui/b;Landroid/content/Context;Lwe/k;Lkotlinx/coroutines/CoroutineScope;)V", "LBc/h;", "playerUiHelper", "LBc/h;", "getPlayerUiHelper", "()LBc/h;", "setPlayerUiHelper", "(LBc/h;)V", "Lcom/iloen/melon/custom/f1;", "f", "Lcom/iloen/melon/custom/f1;", "getInsetHandlingType", "()Lcom/iloen/melon/custom/f1;", "setInsetHandlingType", "(Lcom/iloen/melon/custom/f1;)V", "insetHandlingType", "", "isShowTabAndMiniPlayer", "Z", "()Z", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DrawerFragment extends Hilt_DrawerFragment implements a {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerFragment$Companion;", "", "Lcom/iloen/melon/player/playlist/drawernew/DrawerFragment;", "newInstance", "()Lcom/iloen/melon/player/playlist/drawernew/DrawerFragment;", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final DrawerFragment newInstance() {
            return new DrawerFragment();
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public final e d;
    public final i e;
    public f1 f;
    @Inject
    public h playerUiHelper;

    static {
        DrawerFragment.Companion = new Companion(null);
        DrawerFragment.$stable = 8;
    }

    public DrawerFragment() {
        this.d = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        d d0 = I.a.b(PlaylistSharedViewModel.class);
        com.iloen.melon.player.playlist.drawernew.DrawerFragment.special..inlined.activityViewModels.default.1 drawerFragment$special$$inlined$activityViewModels$default$10 = new we.a() {
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
        com.iloen.melon.player.playlist.drawernew.DrawerFragment.special..inlined.activityViewModels.default.2 drawerFragment$special$$inlined$activityViewModels$default$20 = new we.a(this) {
            public final we.a f;
            public final androidx.fragment.app.I g;

            {
                this.f = a0;
                this.g = i0;
                super(0);
            }

            @NotNull
            public final c invoke() {
                we.a a0 = this.f;
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
        this.e = new i(d0, drawerFragment$special$$inlined$activityViewModels$default$10, new we.a() {
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
        }, drawerFragment$special$$inlined$activityViewModels$default$20);
        this.f = f1.b;
    }

    public static final PlaylistSharedViewModel access$getSharedViewModel(DrawerFragment drawerFragment0) {
        return (PlaylistSharedViewModel)drawerFragment0.e.getValue();
    }

    @Override  // com.melon.ui.c0
    @NotNull
    public f1 getInsetHandlingType() {
        return this.f;
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

    @Override  // com.melon.ui.o1
    @NotNull
    public String getPvDummyLogAction() {
        String s = (String)((DrawerFragmentViewModel)this.getViewModel()).getSelectedAlyacKey().getValue();
        return DrawerPlytTab.Companion.getPvDummyLogActionFromAlyacKey(s);
    }

    @NotNull
    public V0 getViewBinding(@NotNull LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return V0.a(layoutInflater0, null);
    }

    @Override  // com.melon.ui.J0
    public Q4.a getViewBinding(LayoutInflater layoutInflater0) {
        return this.getViewBinding(layoutInflater0);
    }

    @Override  // com.melon.ui.J0
    @NotNull
    public Class getViewModelClass() {
        return DrawerFragmentViewModel.class;
    }

    @Override  // com.melon.ui.a
    public void handleAddPlayUiEvent(@NotNull l0 l00, @NotNull b b0, @Nullable Context context0, @NotNull k k0, @NotNull CoroutineScope coroutineScope0) {
        q.g(l00, "fragmentManager");
        q.g(b0, "event");
        q.g(k0, "sendUserEvent");
        q.g(coroutineScope0, "coroutineScope");
        this.d.handleAddPlayUiEvent(l00, b0, context0, k0, coroutineScope0);
    }

    @Override  // com.melon.ui.c0
    public boolean isShowTabAndMiniPlayer() {
        return false;
    }

    public final void n(r0.q q0, List list0, boolean z, String s, String s1, k k0, k k1, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0xFEBD7CBC);
        int v1 = v | (p0.g(q0) ? 4 : 2) | (p0.i(list0) ? 0x20 : 16) | (p0.h(z) ? 0x100 : 0x80) | (p0.g(s) ? 0x800 : 0x400) | (p0.g(s1) ? 0x4000 : 0x2000) | (p0.i(k0) ? 0x20000 : 0x10000) | (p0.i(k1) ? 0x100000 : 0x80000);
        if(p0.Q(v1 & 1, (0x92493 & v1) != 0x92492)) {
            M m0 = M.p.d(r0.d.a, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, j.f);
            w.x(p0, i00, j.e);
            P0.h h0 = j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q1, j.d);
            FillElement fillElement0 = androidx.compose.foundation.layout.d.c;
            DrawerPlytListKt.DrawerPlytPlyt(fillElement0, list0, s, false, NetUtils.isConnected(), s1, k0, k1, p0, v1 & 0x70 | 0xC06 | v1 >> 3 & 0x380 | 0x70000 & v1 << 3 | 0x380000 & v1 << 3 | v1 << 3 & 0x1C00000, 0);
            if(z) {
                p0.a0(0x1489151D);
                c1.H(r0.a.a(fillElement0, new DrawerFragment.Body.lambda.24..inlined.noRippleClickable-YQRRFTQ.default.1(true, null, 0)), 0L, p0, 0x30, 0);
            }
            else {
                p0.a0(0x13D1B700);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new B1(this, q0, list0, z, s, s1, k0, k1, v);
        }
    }

    public final void o(r0.q q0, List list0, String s, String s1, k k0, we.a a0, l l0, int v) {
        int v4;
        String s2;
        p p0 = (p)l0;
        p0.c0(0x418A6FEE);
        int v1 = v | (p0.g(q0) ? 4 : 2) | (p0.i(list0) ? 0x20 : 16) | (p0.g(s) ? 0x100 : 0x80) | (p0.g(s1) ? 0x800 : 0x400) | (p0.i(k0) ? 0x4000 : 0x2000) | (p0.i(a0) ? 0x20000 : 0x10000);
        if(p0.Q(v1 & 1, (74899 & v1) != 74898)) {
            r0.q q1 = androidx.compose.foundation.layout.a.n(q0, 20.0f, 0.0f, 4.0f, 0.0f, 10);
            p0 p00 = M.n0.a(M.j.a, r0.d.j, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            P0.i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            P0.h h0 = j.f;
            w.x(p0, p00, h0);
            P0.h h1 = j.e;
            w.x(p0, i00, h1);
            P0.h h2 = j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            P0.h h3 = j.d;
            w.x(p0, q2, h3);
            LayoutWeightElement layoutWeightElement0 = new LayoutWeightElement(1.0f, true);
            com.iloen.melon.player.playlist.drawernew.d d0 = p0.N();
            V v3 = androidx.compose.runtime.k.a;
            if((0xE000 & v1) == 0x4000 || d0 == v3) {
                d0 = new com.iloen.melon.player.playlist.drawernew.d(k0, 1);
                p0.l0(d0);
            }
            DrawerAlyacListKt.DrawerAlyacList(layoutWeightElement0, list0, s, false, d0, p0, v1 & 0x380 | (v1 & 0x70 | 0xC00), 0);
            if(q.b(s1, "LIST")) {
                s2 = l1.h(p0, 0x725DE33E, 0x7F130B3E, p0, false);  // string:talkback_gridview_mode "그리드 형태로 보기"
                v4 = 0x7F080187;  // drawable:btn_cpplaylist_view_list_on
            }
            else {
                s2 = l1.h(p0, 0x7260F5DE, 0x7F130B66, p0, false);  // string:talkback_listview_mode "리스트 형태로 보기"
                v4 = 0x7F080186;  // drawable:btn_cpplaylist_view_grid_on
            }
            n n0 = n.a;
            r0.q q3 = r0.a.a(androidx.compose.foundation.layout.d.o(n0, 48.0f, 42.0f), new DrawerFragment.Header.lambda.21..inlined.noRippleClickable-YQRRFTQ.default.1(true, null, 0, a0));
            com.iloen.melon.player.playlist.common.h h4 = p0.N();
            if(h4 == v3) {
                h4 = new com.iloen.melon.player.playlist.common.h(4);
                p0.l0(h4);
            }
            r0.q q4 = X0.n.c(q3, false, h4);
            M m0 = M.p.d(r0.d.e, false);
            int v5 = p0.P;
            i0 i01 = p0.m();
            r0.q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            w.x(p0, q5, h3);
            c1.n(androidx.compose.foundation.layout.d.q(n0, 28.0f), v4, s2, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 6, 0, 0x7FF8);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new F(this, q0, list0, s, s1, k0, a0, v);
        }
    }

    @Override  // com.melon.ui.c0
    public void onResume() {
        super.onResume();
        if(this.isVisible()) {
            ((PlaylistSharedViewModel)this.e.getValue()).updateControllerVisibility(true);
            ((DrawerFragmentViewModel)this.getViewModel()).setBottomSheet(false);
        }
    }

    @Override  // com.melon.ui.J0
    public void onUiEvent(@NotNull I4 i40) {
        q.g(i40, "event");
        if(i40 instanceof e0) {
            ((PlaylistSharedViewModel)this.e.getValue()).updateTiaraProperty(PlaylistTab.DRAWER, ((e0)i40).a);
            ((DrawerFragmentViewModel)this.getViewModel()).getTiaraLogHelper().updateTiaraPropertyToLogHelper(((e0)i40).a);
            return;
        }
        if(i40 instanceof OnOpenDrawerSongPlaylist) {
            BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new we.n(i40, null) {
                public final I4 B;
                public int r;
                public final DrawerFragment w;

                {
                    this.w = drawerFragment0;
                    this.B = i40;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.player.playlist.drawernew.DrawerFragment.onUiEvent.1(this.w, this.B, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.player.playlist.drawernew.DrawerFragment.onUiEvent.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    ne.a a0 = ne.a.a;
                    switch(this.r) {
                        case 0: {
                            d5.n.D(object0);
                            PlaylistSharedViewModel playlistSharedViewModel0 = DrawerFragment.access$getSharedViewModel(this.w);
                            DrawerPlaylistTabInfo drawerPlaylistTabInfo0 = ((OnOpenDrawerSongPlaylist)this.B).getPlaylistTabInfo();
                            this.r = 1;
                            return playlistSharedViewModel0.updateDrawerTabContentToSongWithTabInfo(drawerPlaylistTabInfo0, this) == a0 ? a0 : H.a;
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
            return;
        }
        if(i40 instanceof ShowSelectionRepeatInterruptPopup) {
            h h0 = this.getPlayerUiHelper();
            l0 l00 = this.getChildFragmentManager();
            q.f(l00, "getChildFragmentManager(...)");
            h0.e(l00, ((ShowSelectionRepeatInterruptPopup)i40).getOkAction());
        }
    }

    @Override  // com.melon.ui.J0
    public void renderUi(@NotNull K4 k40) {
        q.g(k40, "uiState");
        V0 v00 = (V0)this.getBinding();
        if(v00 == null) {
            return;
        }
        m0.b b0 = new m0.b(0xD3890BF6, new com.iloen.melon.player.playlist.drawernew.a(this, k40, 2), true);
        v00.b.setContent(b0);
    }

    @Override  // com.melon.ui.c0
    public void setInsetHandlingType(@NotNull f1 f10) {
        q.g(f10, "<set-?>");
        this.f = f10;
    }

    public final void setPlayerUiHelper(@NotNull h h0) {
        q.g(h0, "<set-?>");
        this.playerUiHelper = h0;
    }
}

