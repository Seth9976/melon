package ld;

import Ac.X2;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import Cc.r0;
import Dd.k1;
import H8.i;
import J8.V0;
import Jc.A;
import Ld.v;
import M.j0;
import M.n0;
import M.p0;
import M.q0;
import M.y;
import Mc.u;
import O.F;
import Q0.t0;
import R6.c;
import R6.d;
import Ub.s;
import X.k;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.popup.InstantPlayPopup;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.ui.A4;
import com.melon.ui.B4;
import com.melon.ui.F4;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.M2;
import com.melon.ui.e;
import com.melon.ui.k3;
import com.melon.ui.m2;
import com.melon.ui.o3;
import com.melon.ui.o4;
import com.melon.ui.p3;
import com.melon.ui.u4;
import com.melon.ui.v4;
import com.melon.ui.x3;
import com.melon.ui.x4;
import d3.g;
import e.b;
import gd.R7;
import gd.k4;
import i.n.i.b.a.s.e.M3;
import ie.j;
import java.util.ArrayList;
import java.util.List;
import jd.N2;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import r0.n;
import we.o;
import y0.M;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\bB\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lld/m;", "Lcom/melon/ui/o1;", "Lld/x;", "LJ8/V0;", "Lcom/melon/ui/a;", "", "Lcom/melon/ui/k3;", "Lcom/melon/ui/M2;", "Lcom/melon/ui/o4;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class m extends a implements M2, com.melon.ui.a, k3, o4 {
    public final e d;
    public final c e;
    public final p3 f;
    public final d g;
    public final i h;
    public final b i;

    public m() {
        this.d = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.e = new c(26);
        this.f = new p3();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.g = new d(25);
        k k0 = new k(new h(this, 0), 22);
        j j0 = g.P(ie.k.c, k0);
        De.d d0 = I.a.b(ld.c.class);
        u u0 = new u(j0, 8);
        u u1 = new u(j0, 9);
        this.h = new i(d0, u0, new k4(9, this, j0), u1);
        this.i = H0.e.T(this, new N2(1, this, m.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 10));
        LogU logU0 = new LogU("NewSongFragment");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
    }

    public final void SongItem(Kd.g g0, int v, l l0, int v1) {
        V v11;
        P0.h h5;
        P0.i i2;
        q.g(g0, "item");
        boolean z = g0.N;
        p p0 = (p)l0;
        p0.c0(0x7129A5A1);
        int v2 = (v1 & 6) == 0 ? (p0.i(g0) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (p0.e(v) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v2 |= (p0.i(this) ? 0x100 : 0x80);
        }
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            Context context0 = this.requireContext();
            q.f(context0, "requireContext(...)");
            String s = context0.getString((z ? 0x7F130C79 : 0x7F130C40));  // string:talkback_unselect "선택 해제"
            q.f(s, "getString(...)");
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 60.0f);
            boolean z1 = p0.i(this);
            boolean z2 = p0.i(g0);
            ld.i i0 = p0.N();
            V v3 = androidx.compose.runtime.k.a;
            if((z1 | z2 | ((v2 & 0x70) == 0x20 ? 1 : 0)) != 0 || i0 == v3) {
                i0 = new ld.i(this, g0, v, 0);
                p0.l0(i0);
            }
            r0.q q1 = androidx.compose.foundation.q.f(r0.a.a(q0, new k1(s, i0, g0, this, v)), e0.T(p0, (z ? 0x7F060199 : 0x7F06048A)), M.a);  // color:list_item_marked
            boolean z3 = p0.i(g0);
            boolean z4 = p0.i(context0);
            boolean z5 = p0.g(s);
            boolean z6 = p0.i(this);
            v v4 = p0.N();
            if((z3 | z4 | z5 | z6 | ((v2 & 0x70) == 0x20 ? 1 : 0)) != 0 || v4 == v3) {
                v v5 = new v(g0, context0, s, this, v);
                p0.l0(v5);
                v4 = v5;
            }
            r0.q q2 = X0.n.b(q1, v4);
            if(!g0.i) {
                q2 = e2.a.r(q2, 0.3f);
            }
            M.b b0 = M.j.a;
            p0 p00 = n0.a(b0, r0.d.j, p0, 0);
            int v6 = p0.P;
            i0 i00 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            P0.i i1 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            P0.h h0 = P0.j.f;
            w.x(p0, p00, h0);
            P0.h h1 = P0.j.e;
            w.x(p0, i00, h1);
            P0.h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            P0.h h3 = P0.j.d;
            w.x(p0, q3, h3);
            M.c.d(p0, androidx.compose.foundation.layout.d.q(n0, 16.0f));
            r0.q q4 = q0.a(androidx.compose.foundation.layout.d.c(n0, 1.0f), 1.0f);
            p0 p01 = n0.a(b0, r0.d.k, p0, 0x30);
            int v7 = p0.P;
            r0.h h4 = r0.d.k;
            i0 i01 = p0.m();
            r0.q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, p01, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h2);
            }
            w.x(p0, q5, h3);
            r0.q q6 = r0.a.a(e0.K(androidx.compose.foundation.layout.d.q(androidx.compose.foundation.layout.d.h(n0, 44.0f), 44.0f)), new X2(this, g0, v, 16));
            r0.b.c(q6, g0.f, 44.0f, null, 0L, null, false, false, p0, 0x6000180, 0xF8);
            M.c.d(p0, androidx.compose.foundation.layout.d.q(n0, 12.0f));
            r0.q q7 = androidx.compose.foundation.layout.d.t(androidx.compose.foundation.layout.d.f(n0, 1.0f), 3);
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v8 = p0.P;
            i0 i02 = p0.m();
            r0.q q8 = r0.a.d(p0, q7);
            p0.e0();
            if(p0.O) {
                i2 = i1;
                p0.l(i2);
            }
            else {
                i2 = i1;
                p0.o0();
            }
            w.x(p0, y0, h0);
            w.x(p0, i02, h1);
            if(!p0.O && q.b(p0.N(), v8)) {
                h5 = h2;
            }
            else {
                h5 = h2;
                A7.d.q(v8, p0, v8, h5);
            }
            w.x(p0, q8, h3);
            p0 p02 = n0.a(b0, h4, p0, 0x30);
            int v9 = p0.P;
            i0 i03 = p0.m();
            r0.q q9 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i2);
            }
            else {
                p0.o0();
            }
            w.x(p0, p02, h0);
            w.x(p0, i03, h1);
            if(p0.O || !q.b(p0.N(), v9)) {
                A7.d.q(v9, p0, v9, h5);
            }
            w.x(p0, q9, h3);
            c1.b(g0.h, false, false, g0.m, g0.l, false, p0, 0, 982);
            r0.q q10 = q0.a(n0, 1.0f);
            if(g0.M) {
                q10 = androidx.compose.foundation.q.h(q10, 0, 0, null, 0.0f, 62);
            }
            long v10 = e0.T(p0, 0x7F06016D);  // color:gray900s
            N1.b(g0.b, q10, v10, 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);
            p0.p(true);
            M.c.d(p0, androidx.compose.foundation.layout.d.h(n0, 4.0f));
            N1.b((g0.G == null ? "" : g0.G), null, e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F2);  // color:gray600s_support_high_contrast
            p0.p(true);
            p0.p(true);
            boolean z7 = g0.i;
            boolean z8 = p0.i(this);
            boolean z9 = p0.i(g0);
            ld.i i3 = p0.N();
            if((z8 | z9 | ((v2 & 0x70) == 0x20 ? 1 : 0)) == 0) {
                v11 = v3;
                if(i3 == v11) {
                    i3 = new ld.i(this, g0, v, 1);
                    p0.l0(i3);
                }
            }
            else {
                v11 = v3;
                i3 = new ld.i(this, g0, v, 1);
                p0.l0(i3);
            }
            boolean z10 = p0.i(this);
            boolean z11 = p0.i(g0);
            ld.i i4 = p0.N();
            if((z10 | z11 | ((v2 & 0x70) == 0x20 ? 1 : 0)) != 0 || i4 == v11) {
                i4 = new ld.i(this, g0, v, 2);
                p0.l0(i4);
            }
            c1.Q(z7, false, 0L, i3, i4, p0, 0, 6);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Nc.p(this, g0, v, v1, 25);
        }
    }

    @Override  // com.melon.ui.J0
    public final Q4.a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return V0.a(layoutInflater0, null);
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return x.class;
    }

    @Override  // com.melon.ui.a
    public final void handleAddPlayUiEvent(l0 l00, com.melon.ui.b b0, Context context0, we.k k0, CoroutineScope coroutineScope0) {
        q.g(b0, "event");
        q.g(coroutineScope0, "coroutineScope");
        this.d.handleAddPlayUiEvent(l00, b0, context0, k0, coroutineScope0);
    }

    @Override  // com.melon.ui.M2
    public final void handleMorePopupUiEvent(m2 m20, androidx.fragment.app.I i0, o o0) {
        q.g(m20, "event");
        q.g(i0, "fragment");
        this.g.handleMorePopupUiEvent(m20, i0, null);
    }

    @Override  // com.melon.ui.k3
    public final void handlePutPopupUiEvent(o3 o30, androidx.fragment.app.I i0, we.a a0, we.k k0, boolean z, we.a a1) {
        q.g(o30, "event");
        q.g(i0, "fragment");
        this.f.handlePutPopupUiEvent(o30, i0, a0, k0, z, null);
    }

    public final void n(ld.q q0, LayoutWeightElement layoutWeightElement0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0x97587271);
        int v1 = v | (p0.i(q0) ? 4 : 2) | (p0.g(layoutWeightElement0) ? 0x20 : 16) | (p0.i(this) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            float f = E9.h.t(p0, 0x7F070057);  // dimen:bottom_tab_height
            float f1 = E9.h.t(p0, 0x7F070315);  // dimen:mini_player_height
            F f2 = O.I.a(0, 0, 3, p0);
            j0 j00 = androidx.compose.foundation.layout.a.c(0.0f, 0.0f, 0.0f, f1 + f, 7);
            boolean z = p0.i(q0);
            boolean z1 = p0.i(this);
            R7 r70 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(z || z1 || r70 == v2) {
                r70 = new R7(24, q0, this);
                p0.l0(r70);
            }
            c1.o(layoutWeightElement0, f2, j00, false, null, null, null, false, r70, p0, v1 >> 3 & 14, 0xF8);
            boolean z2 = p0.g(f2);
            boolean z3 = p0.i(this);
            ld.l l1 = p0.N();
            if(z2 || z3 || l1 == v2) {
                l1 = new ld.l(f2, this, null);
                p0.l0(l1);
            }
            J.d(p0, Boolean.TRUE, l1);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Id.h(this, q0, layoutWeightElement0, v, 27);
        }
    }

    @Override  // com.melon.ui.o1
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.requireArguments();
            q.f(bundle0, "requireArguments(...)");
        }
        x x0 = (x)this.getViewModel();
        x0.j = bundle0.getInt("argFilterType", 0);
    }

    @Override  // com.melon.ui.c0
    public final void onPause() {
        super.onPause();
        ((x)this.getViewModel()).selectAll(false);
    }

    @Override  // com.melon.ui.c0
    public final void onSaveInstanceState(Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putInt("argFilterType", ((x)this.getViewModel()).j);
    }

    @Override  // com.melon.ui.J0
    public final void onUiEvent(I4 i40) {
        q.g(i40, "event");
        if(i40 instanceof com.melon.ui.e0) {
            ld.c c0 = (ld.c)this.h.getValue();
            c0.h = ((com.melon.ui.e0)i40).a;
            return;
        }
        if(i40 instanceof A4) {
            h h0 = new h(this, 2);
            this.sendUserEvent(new com.melon.ui.m(((A4)i40).a, ((A4)i40).b, ((A4)i40).c, h0, 0x20));
            return;
        }
        if(i40 instanceof x4) {
            this.sendUserEvent(new com.melon.ui.i(((x4)i40).a, ((x4)i40).b));
            if(((x4)i40).c) {
                ((x)this.getViewModel()).selectAll(false);
            }
            return;
        }
        if(i40 instanceof F4) {
            String s = ((x)this.getViewModel()).getMenuId();
            N2 n20 = new N2(1, this, m.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 6);
            this.g.A(((F4)i40).a, this, s, n20);
            return;
        }
        if(i40 instanceof B4) {
            h h1 = new h(this, 3);
            this.sendUserEvent(new com.melon.ui.n(((B4)i40).a, ((B4)i40).b, false, false, h1, 92));
            return;
        }
        if(i40 instanceof u4) {
            Navigator.openUrl("", ((u4)i40).a, OpenType.FullScreen, ((u4)i40).b);
            return;
        }
        if(i40 instanceof v4) {
            ArrayList arrayList0 = E9.h.W(((v4)i40).b);
            ArrayList arrayList1 = E9.h.W(((v4)i40).c);
            Navigator.openPresentSongSendFragment(((v4)i40).a, arrayList0, arrayList1);
            return;
        }
        if(i40 instanceof x3) {
            FragmentActivity fragmentActivity0 = this.getActivity();
            ((x)this.getViewModel()).getClass();
            boolean z = ((va.e0)va.o.a()).m();
            N2 n21 = new N2(1, this, m.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 7);
            this.e.getClass();
            c.h(((x3)i40), this, fragmentActivity0, z, this.i, n21);
            return;
        }
        if(i40 instanceof o3) {
            k3.d(this, ((o3)i40), this, new h(this, 4), new N2(1, this, m.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 8), false, 0x30);
            return;
        }
        if(i40 instanceof m2) {
            this.handleMorePopupUiEvent(((m2)i40), this, null);
            return;
        }
        if(i40 instanceof com.melon.ui.b) {
            l0 l00 = this.getChildFragmentManager();
            q.f(l00, "getChildFragmentManager(...)");
            com.melon.ui.a.f(this, l00, ((com.melon.ui.b)i40), this.getContext(), new N2(1, this, m.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 9));
            return;
        }
        if(i40 instanceof A) {
            MelonAppBase.Companion.getClass();
            if(!t.a().isCarConnected()) {
                Context context0 = this.requireContext();
                q.f(context0, "requireContext(...)");
                Context context1 = context0.getApplicationContext();
                q.d(context1);
                if(!((Ub.t)(((s)((k8.o)(((Ma.m)com.google.firebase.b.B(context1, Ma.m.class)))).z.get()))).f()) {
                    InstantPlayPopup instantPlayPopup0 = new InstantPlayPopup(((A)i40).a);
                    l0 l01 = this.getChildFragmentManager();
                    q.f(l01, "getChildFragmentManager(...)");
                    instantPlayPopup0.show(l01, "InstantPlayPopup");
                    return;
                }
            }
            ToastManager.show(Cb.i.k(this, 0x7F1304B4));  // string:instant_play_other_device "기기 연동 중 상태에서는 해당 기능을 지원하지 않습니다."
            return;
        }
        super.onUiEvent(i40);
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        int v;
        boolean z;
        q.g(k40, "uiState");
        if(k40 instanceof r) {
            V0 v00 = (V0)this.getBinding();
            if(v00 != null) {
                ComposeView composeView0 = v00.b;
                if(((r)k40) instanceof ld.p) {
                    z = ((ld.p)k40).a;
                }
                else if(((r)k40) instanceof ld.o) {
                    z = ((ld.o)k40).a;
                }
                else if(((r)k40) instanceof ld.q) {
                    z = ((ld.q)k40).a;
                }
                else {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                if(((r)k40) instanceof ld.p) {
                    v = ((ld.p)k40).b;
                }
                else if(((r)k40) instanceof ld.o) {
                    v = ((ld.o)k40).b;
                }
                else if(((r)k40) instanceof ld.q) {
                    v = ((ld.q)k40).b;
                }
                else {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                composeView0.setViewCompositionStrategy(t0.d);
                composeView0.setContent(new m0.b(0x3B0748C0, new Rc.c(v, 4, k40, this, z), true));
            }
        }
    }

    @Override  // com.melon.ui.k3
    public final void showContextMenuAddTo(androidx.fragment.app.I i0, String s, List list0, we.a a0, we.k k0, boolean z, String s1) {
        q.g(i0, "fragment");
        q.g(s, "menuId");
        q.g(list0, "playableList");
        q.g(k0, "sendUserEvent");
        this.f.showContextMenuAddTo(i0, s, list0, a0, k0, z, "");
    }
}

