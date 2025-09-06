package td;

import Ac.i0;
import Bc.h;
import Cc.x2;
import De.I;
import J8.h1;
import R6.c;
import R6.d;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.M;
import androidx.lifecycle.f0;
import androidx.viewpager.widget.ViewPager;
import com.iloen.melon.custom.P0;
import com.iloen.melon.custom.f1;
import com.iloen.melon.custom.n;
import com.iloen.melon.fragments.detail.viewholder.p;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.player.playlist.common.PlaylistCommonUiEvent.ShowSelectionRepeatInterruptPopup;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.G4;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.M2;
import com.melon.ui.a;
import com.melon.ui.e;
import com.melon.ui.k3;
import com.melon.ui.m2;
import com.melon.ui.n0;
import com.melon.ui.o3;
import com.melon.ui.p3;
import com.melon.ui.playermusic.PlayerMoreView;
import com.melon.ui.x3;
import d3.g;
import d9.j;
import ie.r;
import java.util.List;
import kc.d3;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import pc.Z;
import t9.B;
import we.k;
import we.o;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\u0010²\u0006\u000E\u0010\f\u001A\u00020\u000B8\n@\nX\u008A\u008E\u0002²\u0006\u001A\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000E0\r8\n@\nX\u008A\u008E\u0002"}, d2 = {"Ltd/b0;", "Lcom/melon/ui/J0;", "Ltd/t1;", "LJ8/h1;", "Lcom/melon/ui/a;", "Lcom/melon/ui/k3;", "Lcom/melon/ui/M2;", "", "<init>", "()V", "td/z", "", "firstLyricExpandState", "Lie/m;", "", "smallAlbumPosition", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class b0 extends b implements M2, a, k3 {
    public final r B;
    public f1 D;
    public final e.b E;
    public final P0 G;
    public final e d;
    public final p3 e;
    public final d f;
    public final c g;
    public final LogU h;
    public x2 i;
    public h j;
    public final MutableStateFlow k;
    public final r l;
    public final boolean m;
    public z n;
    public int o;
    public final MutableStateFlow r;
    public final MutableStateFlow w;

    public b0() {
        this.d = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.e = new p3();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.f = new d(25);
        this.g = new c(26);
        this.h = new LogU("MusicPlayerFragment");
        this.k = StateFlowKt.MutableStateFlow(null);
        this.l = g.Q(new x(this, 16));
        this.m = MelonSettingInfo.isLowMemoryMode();
        this.o = -1;
        this.r = StateFlowKt.MutableStateFlow(0);
        this.w = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.B = g.Q(new p8.e(14));
        this.D = f1.b;
        this.E = H0.e.T(this, new L(1, this, b0.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 6));
        this.G = new P0(this, 3);
    }

    @Override  // com.melon.ui.c0
    public final boolean excludingTagArguments() {
        return true;
    }

    @Override  // com.melon.ui.c0
    public final f1 getInsetHandlingType() {
        return this.D;
    }

    @Override  // com.melon.ui.J0
    public final Q4.a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D02BB, null, false);  // layout:fragment_musicplayer_frame
        int v = 0x7F0A03FE;  // id:dummy_view
        View view1 = I.C(view0, 0x7F0A03FE);  // id:dummy_view
        if(view1 != null && ((FrameLayout)I.C(view0, 0x7F0A07CB)) != null) {  // id:main_player
            v = 0x7F0A07CC;  // id:main_player_compose_view
            View view2 = I.C(view0, 0x7F0A07CC);  // id:main_player_compose_view
            if(((ComposeView)view2) != null) {
                v = 0x7F0A07F0;  // id:media_pager
                View view3 = I.C(view0, 0x7F0A07F0);  // id:media_pager
                if(((ViewPager)view3) != null) {
                    v = 0x7F0A081E;  // id:more_view
                    View view4 = I.C(view0, 0x7F0A081E);  // id:more_view
                    if(((PlayerMoreView)view4) != null) {
                        v = 0x7F0A0922;  // id:player_bg_compose_view
                        View view5 = I.C(view0, 0x7F0A0922);  // id:player_bg_compose_view
                        if(((ComposeView)view5) != null) {
                            return new h1(((FrameLayout)view0), view1, ((ComposeView)view2), ((ViewPager)view3), ((PlayerMoreView)view4), ((ComposeView)view5));
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return t1.class;
    }

    @Override  // com.melon.ui.a
    public final void handleAddPlayUiEvent(l0 l00, com.melon.ui.b b0, Context context0, k k0, CoroutineScope coroutineScope0) {
        q.g(b0, "event");
        q.g(coroutineScope0, "coroutineScope");
        this.d.handleAddPlayUiEvent(l00, b0, context0, k0, coroutineScope0);
    }

    @Override  // com.melon.ui.M2
    public final void handleMorePopupUiEvent(m2 m20, androidx.fragment.app.I i0, o o0) {
        q.g(m20, "event");
        q.g(i0, "fragment");
        this.f.handleMorePopupUiEvent(m20, i0, null);
    }

    @Override  // com.melon.ui.k3
    public final void handlePutPopupUiEvent(o3 o30, androidx.fragment.app.I i0, we.a a0, k k0, boolean z, we.a a1) {
        q.g(o30, "event");
        q.g(i0, "fragment");
        this.e.handlePutPopupUiEvent(o30, i0, a0, k0, z, null);
    }

    @Override  // com.melon.ui.c0
    public final boolean isBringToFrontFragment() {
        return true;
    }

    @Override  // com.melon.ui.c0
    public final boolean isPlayerFragment() {
        return true;
    }

    @Override  // com.melon.ui.c0
    public final boolean isShowTabAndMiniPlayer() {
        return false;
    }

    public static final g0 n(b0 b00) {
        return (g0)((t1)b00.getViewModel()).I.getValue();
    }

    public static final void o(b0 b00) {
        h1 h10 = (h1)b00.getBinding();
        if(h10 != null) {
            int v = ((t1)b00.getViewModel()).h() ? 0 : 4;
            h10.d.setVisibility(v);
        }
    }

    @Override  // com.melon.ui.J0
    public final void onConfigurationChanged(Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        ((t1)this.getViewModel()).B.setValue(Boolean.FALSE);
    }

    @Override  // com.melon.ui.J0
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.requireArguments();
            q.f(bundle0, "requireArguments(...)");
        }
        this.o = bundle0.getInt("argCurrentPagePosition", -1);
    }

    @Override  // com.melon.ui.c0
    public final void onForeground() {
        super.onForeground();
        if(this.isFragmentVisible()) {
            t1 t10 = (t1)this.getViewModel();
            n0.performPvLoggingOnForeground$default(t10, t10.e(), null, 2, null);
        }
    }

    @Override  // com.melon.ui.c0
    public final void onNewArguments(Bundle bundle0) {
        super.onNewArguments(bundle0);
        Integer integer0 = bundle0 == null ? null : bundle0.getInt("arg_display_type", 0);
        if(integer0 != null && ((int)integer0) == 2) {
            t1 t10 = (t1)this.getViewModel();
            ((d9.h)t10.v.getValue()).b();
            t10.D.setValue(Boolean.TRUE);
            return;
        }
        ((t1)this.getViewModel()).D.setValue(Boolean.FALSE);
    }

    @Override  // com.melon.ui.c0
    public final void onPause() {
        super.onPause();
        t1 t10 = (t1)this.getViewModel();
        ((d9.h)t10.v.getValue()).k.removeObserver(((M)t10.K.getValue()));
        j.d("NewMusicPlayerViewModel");
    }

    @Override  // com.melon.ui.c0
    public final void onResume() {
        super.onResume();
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new T(this, null), 3, null);
        ((t1)this.getViewModel()).j();
        t1 t10 = (t1)this.getViewModel();
        t10.getClass();
        d9.h h0 = j.b("NewMusicPlayerViewModel");
        MutableStateFlow mutableStateFlow0 = t10.v;
        if(mutableStateFlow0.getValue() != h0) {
            mutableStateFlow0.setValue(h0);
        }
        ((d9.h)mutableStateFlow0.getValue()).k.observeForever(((M)t10.K.getValue()));
    }

    @Override  // com.melon.ui.c0
    public final void onSaveInstanceState(Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putInt("argCurrentPagePosition", this.o);
    }

    @Override  // com.melon.ui.c0
    public final void onStop() {
        super.onStop();
        this.q().a();
    }

    @Override  // com.melon.ui.J0
    public final void onUiEvent(I4 i40) {
        q.g(i40, "event");
        if(i40 instanceof o0) {
            k3.c(this, this, ((t1)this.getViewModel()).getMenuId(), e.k.z(((o0)i40).a), null, new L(1, this, b0.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 1), ((o0)i40).b, 72);
            return;
        }
        if(i40 instanceof ShowSelectionRepeatInterruptPopup) {
            com.melon.ui.popup.b.s(this.getContext(), this.getChildFragmentManager(), ((ShowSelectionRepeatInterruptPopup)i40).getOkAction(), null);
            return;
        }
        if(i40 instanceof G4) {
            com.melon.ui.popup.b.k(this.getContext(), this.getParentFragmentManager(), 28);
            return;
        }
        if(i40 instanceof com.melon.ui.b) {
            l0 l00 = this.getChildFragmentManager();
            q.f(l00, "getChildFragmentManager(...)");
            a.f(this, l00, ((com.melon.ui.b)i40), this.getContext(), new L(1, this, b0.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 2));
            return;
        }
        if(i40 instanceof o3) {
            k3.d(this, ((o3)i40), this, new p8.e(24), new L(1, this, b0.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 3), true, 0x20);
            return;
        }
        if(i40 instanceof m2) {
            this.handleMorePopupUiEvent(((m2)i40), this, null);
            return;
        }
        if(i40 instanceof x3) {
            FragmentActivity fragmentActivity0 = this.getActivity();
            boolean z = ((t1)this.getViewModel()).isLoginUser();
            L l0 = new L(1, this, b0.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 4);
            this.g.getClass();
            c.h(((x3)i40), this, fragmentActivity0, z, this.E, l0);
            return;
        }
        super.onUiEvent(i40);
    }

    @Override  // com.melon.ui.J0
    public final void onViewCreated(View view0, Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), Dispatchers.getMain(), null, new W(this, null), 2, null);
        h1 h10 = (h1)this.getBinding();
        if(h10 != null) {
            m0.b b0 = new m0.b(0xAF7E6B02, new w(this, 0), true);
            h10.f.setContent(b0);
        }
        h1 h11 = (h1)this.getBinding();
        if(h11 != null) {
            m0.b b1 = new m0.b(0x5F42FDF9, new w(this, 3), true);
            h11.c.setContent(b1);
        }
        h1 h12 = (h1)this.getBinding();
        if(h12 != null) {
            ViewPager viewPager0 = h12.d;
            if(this.n == null) {
                l0 l00 = this.getChildFragmentManager();
                q.f(l00, "getChildFragmentManager(...)");
                this.n = new z(this, l00);
            }
            if(!q.b(viewPager0.getAdapter(), this.n)) {
                viewPager0.setOffscreenPageLimit(1);
                viewPager0.setAdapter(this.n);
                viewPager0.setPageTransformer(true, new B(1));
                viewPager0.clearOnPageChangeListeners();
                viewPager0.addOnPageChangeListener(new i0(this, 4));
                int v = this.o;
                if(v <= 0) {
                    z z0 = this.n;
                    if(z0 == null) {
                        v = 0;
                    }
                    else {
                        n n0 = z0.g;
                        v = n0 == null ? 0 : n0.b(0, viewPager0.getCurrentItem());
                    }
                }
                LogU.debug$default(this.h, "initPager() selectedTab=" + v + ", currentPlayPosition=" + this.o, null, false, 6, null);
                viewPager0.setCurrentItem(v, false);
            }
            D d1 = this.getViewLifecycleOwner();
            q.f(d1, "getViewLifecycleOwner(...)");
            BuildersKt__Builders_commonKt.launch$default(f0.f(d1), null, null, new P(this, null), 3, null);
        }
        h1 h13 = (h1)this.getBinding();
        if(h13 != null) {
            D d2 = this.getViewLifecycleOwner();
            q.f(d2, "getViewLifecycleOwner(...)");
            BuildersKt__Builders_commonKt.launch$default(f0.f(d2), null, null, new C(this, h13, null), 3, null);
            D d3 = this.getViewLifecycleOwner();
            q.f(d3, "getViewLifecycleOwner(...)");
            BuildersKt__Builders_commonKt.launch$default(f0.f(d3), null, null, new G(h13.e, null, this), 3, null);
            D d4 = this.getViewLifecycleOwner();
            q.f(d4, "getViewLifecycleOwner(...)");
            BuildersKt__Builders_commonKt.launch$default(f0.f(d4), null, null, new K(h13.e, null, this), 3, null);
            td.M m0 = new td.M(this);
            h13.e.setOnEventListener(m0);
            p p0 = new p(this, 15);
            h13.e.getBinding().g.setOnClickListener(p0);
        }
        h1 h14 = (h1)this.getBinding();
        if(h14 != null) {
            h14.c.addOnLayoutChangeListener(this.G);
        }
    }

    public final td.n0 p() {
        return ((t1)this.getViewModel()).f();
    }

    public final M1 q() {
        return (M1)((t1)this.getViewModel()).J.getValue();
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
    }

    @Override  // com.melon.ui.c0
    public final void setInsetHandlingType(f1 f10) {
        q.g(f10, "<set-?>");
        this.D = f10;
    }

    @Override  // com.melon.ui.c0
    public final boolean shouldOnResume() {
        t1 t10 = (t1)this.getViewModel();
        oc.w w0 = ((d3)t10.c).k();
        if(w0 != null) {
            PlaylistId playlistId0 = w0.getId();
            if(!e.k.A(new PlaylistId[]{PlaylistId.MUSIC, PlaylistId.SMART, PlaylistId.DRAWER, PlaylistId.MIX_UP}).contains(playlistId0)) {
                LogU.debug$default(t10.m, "shouldOnResume - not valid playlistId", null, false, 6, null);
                return false;
            }
            if(w0 instanceof pc.d && !t10.i(((Z)(((pc.d)w0))).m())) {
                LogU.debug$default(t10.m, "shouldOnResume - not valid MixUpPlaylistState", null, false, 6, null);
                return false;
            }
            if(e1.b.D(w0.getState())) {
                LogU.debug$default(t10.m, "shouldOnResume - playlist is empty", null, false, 6, null);
                return false;
            }
        }
        return true;
    }

    @Override  // com.melon.ui.k3
    public final void showContextMenuAddTo(androidx.fragment.app.I i0, String s, List list0, we.a a0, k k0, boolean z, String s1) {
        q.g(i0, "fragment");
        q.g(s, "menuId");
        q.g(list0, "playableList");
        q.g(k0, "sendUserEvent");
        this.e.showContextMenuAddTo(i0, s, list0, a0, k0, z, "");
    }
}

