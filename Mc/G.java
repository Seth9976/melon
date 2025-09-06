package Mc;

import Ac.A2;
import Ac.U2;
import Ac.X3;
import Ac.X;
import Ac.i2;
import Ac.m2;
import Cc.N1;
import Cc.e0;
import Dd.J;
import De.I;
import F8.p;
import Hc.k;
import Hd.F;
import J8.b1;
import M.p0;
import P0.h;
import P0.i;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import coil.request.ImageRequest.Builder;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.iloen.melon.custom.f1;
import com.iloen.melon.net.v4x.request.UaLogDummyReq;
import com.iloen.melon.popup.GenreAllPopup;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.a;
import com.melon.ui.b;
import com.melon.ui.e;
import com.melon.ui.x4;
import e1.y;
import ie.r;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import p8.O;
import r0.n;
import u1.j;
import wc.u;
import y0.M;
import y0.s;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"LMc/g;", "Lcom/melon/ui/o1;", "LOc/k;", "LJ8/b1;", "Lcom/melon/ui/a;", "<init>", "()V", "Mc/c", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class g extends N implements a {
    public final e d;
    public GenreAllPopup e;
    public c f;
    public p g;
    public final r h;
    public f1 i;

    public g() {
        this.d = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.h = d3.g.Q(new k(11));
        this.i = f1.b;
    }

    @Override  // com.melon.ui.c0
    public final f1 getInsetHandlingType() {
        return this.i;
    }

    @Override  // com.melon.ui.J0
    public final Q4.a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D02AF, null, false);  // layout:fragment_genre_detail_pager
        int v = 0x7F0A00AB;  // id:appbar_layout
        View view1 = I.C(view0, 0x7F0A00AB);  // id:appbar_layout
        if(((AppBarLayout)view1) != null) {
            v = 0x7F0A02DD;  // id:collapsing_toolbar_layout
            View view2 = I.C(view0, 0x7F0A02DD);  // id:collapsing_toolbar_layout
            if(((CollapsingToolbarLayout)view2) != null) {
                v = 0x7F0A0309;  // id:compose_view
                View view3 = I.C(view0, 0x7F0A0309);  // id:compose_view
                if(((ComposeView)view3) != null) {
                    v = 0x7F0A030B;  // id:compose_view_collapsable
                    View view4 = I.C(view0, 0x7F0A030B);  // id:compose_view_collapsable
                    if(((ComposeView)view4) != null) {
                        v = 0x7F0A030C;  // id:compose_view_pin
                        View view5 = I.C(view0, 0x7F0A030C);  // id:compose_view_pin
                        if(((ComposeView)view5) != null && ((CoordinatorLayout)I.C(view0, 0x7F0A0348)) != null) {  // id:coordinator_layout
                            return new b1(((FrameLayout)view0), ((AppBarLayout)view1), ((CollapsingToolbarLayout)view2), ((ComposeView)view3), ((ComposeView)view4), ((ComposeView)view5));
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return Oc.k.class;
    }

    @Override  // com.melon.ui.a
    public final void handleAddPlayUiEvent(l0 l00, b b0, Context context0, we.k k0, CoroutineScope coroutineScope0) {
        q.g(b0, "event");
        q.g(coroutineScope0, "coroutineScope");
        this.d.handleAddPlayUiEvent(l00, b0, context0, k0, coroutineScope0);
    }

    public final void n(r0.q q0, Oc.g g0, we.k k0, l l0, int v) {
        q.g(k0, "onPageSelected");
        ((androidx.compose.runtime.p)l0).c0(0x5109015E);
        int v1 = (((androidx.compose.runtime.p)l0).i(g0) ? 0x20 : 16) | v | (((androidx.compose.runtime.p)l0).i(k0) ? 0x100 : 0x80) | (((androidx.compose.runtime.p)l0).i(this) ? 0x800 : 0x400);
        int v2 = 0;
        if(((androidx.compose.runtime.p)l0).Q(v1 & 1, (v1 & 0x493) != 1170)) {
            r0.q q1 = q0.then(d.c);
            boolean z = ((androidx.compose.runtime.p)l0).i(this);
            boolean z1 = ((androidx.compose.runtime.p)l0).i(g0);
            if((v1 & 0x380) == 0x100) {
                v2 = 1;
            }
            i2 i20 = ((androidx.compose.runtime.p)l0).N();
            V v3 = androidx.compose.runtime.k.a;
            if((z | z1 | v2) != 0 || i20 == v3) {
                i20 = new i2(this, g0, k0, 2);
                ((androidx.compose.runtime.p)l0).l0(i20);
            }
            boolean z2 = ((androidx.compose.runtime.p)l0).i(g0);
            A2 a20 = ((androidx.compose.runtime.p)l0).N();
            if(z2 || a20 == v3) {
                a20 = new A2(g0, 28);
                ((androidx.compose.runtime.p)l0).l0(a20);
            }
            j.a(i20, q1, a20, ((androidx.compose.runtime.p)l0), 0, 0);
        }
        else {
            ((androidx.compose.runtime.p)l0).T();
        }
        n0 n00 = ((androidx.compose.runtime.p)l0).t();
        if(n00 != null) {
            n00.d = new U2(this, q0, g0, k0, v, 13);
        }
    }

    public final void o(l l0, int v) {
        b0 b04;
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(0x50B2C3B9);
        int v1 = v | (p0.i(this) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            b0 b00 = w.f(((Oc.k)this.getViewModel()).e, p0);
            b0 b01 = w.f(((Oc.k)this.getViewModel()).f, p0);
            b0 b02 = w.f(((Oc.k)this.getViewModel()).g, p0);
            b0 b03 = w.f(((Oc.k)this.getViewModel()).h, p0);
            if(((Boolean)b02.getValue()).booleanValue()) {
                p0.a0(0xF220F4E9);
            }
            else {
                p0.a0(0xF30DE750);
                n n0 = n.a;
                r0.q q0 = d.h(d.f(n0, 1.0f), 190.0f);
                long v2 = e0.T(p0, 0x7F0604AA);  // color:white000s_support_high_contrast
                u u0 = M.a;
                r0.q q1 = androidx.compose.foundation.q.f(q0, v2, u0);
                N0.M m0 = M.p.d(r0.d.a, false);
                int v3 = p0.P;
                i0 i00 = p0.m();
                r0.q q2 = r0.a.d(p0, q1);
                P0.k.y.getClass();
                i i0 = P0.j.b;
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                h h0 = P0.j.f;
                w.x(p0, m0, h0);
                h h1 = P0.j.e;
                w.x(p0, i00, h1);
                h h2 = P0.j.g;
                if(p0.O) {
                    b04 = b01;
                    A7.d.q(v3, p0, v3, h2);
                }
                else {
                    b04 = b01;
                    if(!q.b(p0.N(), v3)) {
                        A7.d.q(v3, p0, v3, h2);
                    }
                }
                h h3 = P0.j.d;
                w.x(p0, q2, h3);
                if(((Boolean)b02.getValue()).booleanValue() || !((Boolean)b03.getValue()).booleanValue()) {
                    p0.a0(0xE30428A);
                }
                else {
                    p0.a0(0xF219BF6);
                    r0.q q3 = d.f(n0, 1.0f);
                    ImageRequest.Builder imageRequest$Builder0 = new ImageRequest.Builder(((Context)p0.k(AndroidCompositionLocals_androidKt.b)));
                    imageRequest$Builder0.c = b04.getValue();
                    j5.n.b(imageRequest$Builder0.a(), null, q3, null, N0.j.b, null, p0, 0x1801B0, 0xFB8);
                    long v4 = e0.T(p0, 0x7F060158);  // color:gray400e_30
                    M.p.a(androidx.compose.foundation.q.f(d.c, v4, u0), p0, 0);
                    r0.i i1 = r0.d.h;
                    androidx.compose.foundation.layout.b b0 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false));
                    r0.q q4 = r0.a.a(androidx.compose.foundation.layout.a.n(b0.a(n0, i1), 0.0f, 0.0f, 0.0f, 63.0f, 7), new X(this, 9));
                    p0 p00 = M.n0.a(M.j.a, r0.d.k, p0, 0x30);
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
                    w.x(p0, p00, h0);
                    w.x(p0, i01, h1);
                    if(p0.O || !q.b(p0.N(), v5)) {
                        A7.d.q(v5, p0, v5, h2);
                    }
                    w.x(p0, q5, h3);
                    N1.b(((String)b00.getValue()), null, e0.T(p0, 0x7F0604A1), 28.0f, y.i, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C00, 0, 0x1FFD2);  // color:white000e
                    M.c.d(p0, d.q(n0, 4.0f));
                    androidx.compose.foundation.q.c(I.Q(0x7F08044B, p0, 6), null, d.o(n0, 21.0f, 19.0f), null, null, 0.0f, null, p0, 0x1B0, 120);  // drawable:ic_genre_top_arrow
                    p0.p(true);
                    M.p.a(androidx.compose.foundation.q.e(d.h(d.f(b0.a(n0, i1), 1.0f), 60.0f), u.f(e.k.A(new s[]{new s(s.f), new s(s.c(e0.T(p0, 0x7F0604AA), 0.7f))}), 0.0f, 0.0f, 14), null, 6), p0, 0);  // color:white000s_support_high_contrast
                    M.p.a(androidx.compose.foundation.q.e(d.h(d.f(b0.a(n0, i1), 1.0f), 80.0f), u.f(e.k.A(new s[]{new s(s.f), new s(e0.T(p0, 0x7F0604AA))}), 0.0f, 0.0f, 14), null, 6), p0, 0);  // color:white000s_support_high_contrast
                }
                p0.p(false);
                p0.p(true);
            }
            p0.p(false);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Mc.a(this, v);
        }
    }

    @Override  // com.melon.ui.J0
    public final void onConfigurationChanged(Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        GenreAllPopup genreAllPopup0 = this.e;
        if(genreAllPopup0 != null) {
            genreAllPopup0.dismiss();
        }
    }

    @Override  // com.melon.ui.o1
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.requireArguments();
            q.f(bundle0, "requireArguments(...)");
        }
        Oc.k k0 = (Oc.k)this.getViewModel();
        String s = bundle0.getString("argGenreCode", "");
        q.f(s, "getString(...)");
        k0.getClass();
        k0.d = s;
    }

    @Override  // com.melon.ui.J0
    public final void onUiEvent(I4 i40) {
        q.g(i40, "event");
        if(i40 instanceof x4) {
            this.sendUserEvent(new com.melon.ui.i(((x4)i40).a, ((x4)i40).b));
            return;
        }
        if(i40 instanceof b) {
            l0 l00 = this.getChildFragmentManager();
            q.f(l00, "getChildFragmentManager(...)");
            a.f(this, l00, ((b)i40), this.getContext(), new Kc.c(1, this, g.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 8));
            return;
        }
        super.onUiEvent(i40);
    }

    @Override  // com.melon.ui.J0
    public final void onViewCreated(View view0, Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        b1 b10 = (b1)this.getBinding();
        if(b10 == null) {
            return;
        }
        int v = ScreenUtils.getStatusBarHeight(this.getContext());
        int v1 = ScreenUtils.dipToPixel(this.getContext(), 56.0f);
        b10.c.setMinimumHeight(v1 + v);
        m0.b b0 = new m0.b(0xFABDCA38, new Mc.a(this, 0, 0), true);
        b10.e.setContent(b0);
        m0.b b1 = new m0.b(0x7A7B816F, new Mc.a(this, 1, 0), true);
        b10.f.setContent(b1);
        F f0 = new F(this, 1);
        b10.b.a(f0);
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new f(this, null), 3, null);
    }

    public final void p(Ud.j j0, l l0, int v) {
        q.g(j0, "titleBarEventHelper");
        androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)l0;
        p0.c0(1532554520);
        int v1 = (p0.i(j0) ? 0x20 : 16) | v | (p0.i(this) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            b0 b00 = w.f(((Oc.k)this.getViewModel()).e, p0);
            b0 b01 = w.f(((Oc.k)this.getViewModel()).g, p0);
            b0 b02 = w.f(((Oc.k)this.getViewModel()).h, p0);
            long v2 = e0.T(p0, (((Boolean)b01.getValue()).booleanValue() ? 0x7F0604AA : 0x7F06048A));  // color:white000s_support_high_contrast
            n n0 = n.a;
            u u0 = M.a;
            r0.q q0 = androidx.compose.foundation.q.f(n0, v2, u0);
            M.y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v3 = p0.P;
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
            w.x(p0, y0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            w.x(p0, q1, P0.j.d);
            if(((Boolean)b02.getValue()).booleanValue()) {
                p0.a0(405358283);
                boolean z = p0.i(this);
                boolean z1 = p0.g(b00);
                boolean z2 = p0.i(j0);
                m2 m20 = p0.N();
                V v4 = androidx.compose.runtime.k.a;
                if((z | z1 | z2) != 0 || m20 == v4) {
                    m20 = new m2(this, b00, j0, 13);
                    p0.l0(m20);
                }
                r0.q q2 = d.f(d.h(androidx.compose.foundation.q.f(androidx.compose.foundation.layout.a.n(n0, 0.0f, e0.Z(p0, ScreenUtils.getStatusBarHeight(((Context)p0.k(AndroidCompositionLocals_androidKt.b)))), 0.0f, 0.0f, 13), e0.T(p0, 0x7F06048A), u0), 56.0f), 1.0f);  // color:transparent
                boolean z3 = p0.g(b00);
                boolean z4 = p0.g(b01);
                J j1 = p0.N();
                if(z3 || z4 || j1 == v4) {
                    j1 = new J(28, b00, b01);
                    p0.l0(j1);
                }
                androidx.compose.ui.viewinterop.a.a(m20, q2, j1, p0, 0, 0);
            }
            else {
                p0.a0(0x175F2940);
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Gd.p(this, j0, v, 21);
        }
    }

    public final void q() {
        switch(NetUtils.checkDataNetwork()) {
            case 2: 
            case 3: {
                ToastManager.show(0x7F1303DA);  // string:error_network_connectivity_toast "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해주세요."
                return;
            }
            default: {
                FragmentActivity fragmentActivity0 = this.getActivity();
                if(fragmentActivity0 != null) {
                    GenreAllPopup genreAllPopup0 = new GenreAllPopup(fragmentActivity0, ((Oc.k)this.getViewModel()).d, false);
                    this.e = genreAllPopup0;
                    genreAllPopup0.setOnActionListener(new X3(fragmentActivity0, 8));
                    GenreAllPopup genreAllPopup1 = this.e;
                    if(genreAllPopup1 != null) {
                        genreAllPopup1.show();
                    }
                }
                O.a(new UaLogDummyReq(this.getContext(), "genrePopupMenuView"));
            }
        }
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        b1 b10 = (b1)this.getBinding();
        if(b10 == null) {
            return;
        }
        m0.b b0 = new m0.b(-1789735006, new Gd.p(20, k40, this), true);
        b10.d.setContent(b0);
    }

    @Override  // com.melon.ui.c0
    public final void setInsetHandlingType(f1 f10) {
        q.g(f10, "<set-?>");
        this.i = f10;
    }
}

