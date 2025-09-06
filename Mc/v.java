package Mc;

import Ac.U2;
import B2.o;
import Cc.c1;
import E9.h;
import H8.i;
import J8.V0;
import Jc.A;
import M.j0;
import Nc.E0;
import O.F;
import Oc.r;
import Oc.x;
import Q0.t0;
import R6.c;
import R6.d;
import Ub.s;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.f1;
import com.iloen.melon.popup.InstantPlayPopup;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.ui.A4;
import com.melon.ui.B4;
import com.melon.ui.F4;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.M2;
import com.melon.ui.a;
import com.melon.ui.e;
import com.melon.ui.k3;
import com.melon.ui.m2;
import com.melon.ui.m;
import com.melon.ui.o3;
import com.melon.ui.p3;
import com.melon.ui.u4;
import com.melon.ui.v4;
import com.melon.ui.x3;
import com.melon.ui.x4;
import d3.g;
import e.b;
import ie.j;
import ie.k;
import java.util.ArrayList;
import java.util.List;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import r0.n;
import va.e0;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"LMc/v;", "Lcom/melon/ui/o1;", "LOc/x;", "LJ8/V0;", "", "Lcom/melon/ui/k3;", "Lcom/melon/ui/M2;", "Lcom/melon/ui/a;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class v extends P implements M2, a, k3 {
    public final c d;
    public final p3 e;
    public final d f;
    public final e g;
    public f1 h;
    public final i i;
    public final b j;

    public v() {
        this.d = new c(26);
        this.e = new p3();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.f = new d(25);
        this.g = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.h = f1.b;
        o o0 = new o(new Mc.o(this, 3), 12);
        j j0 = g.P(k.c, o0);
        De.d d0 = I.a.b(Oc.k.class);
        u u0 = new u(j0, 0);
        u u1 = new u(j0, 1);
        this.i = new i(d0, u0, new G.g(3, this, j0), u1);
        this.j = H0.e.T(this, new Kc.c(1, this, v.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 14));
    }

    @Override  // com.melon.ui.c0
    public final f1 getInsetHandlingType() {
        return this.h;
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
        this.g.handleAddPlayUiEvent(l00, b0, context0, k0, coroutineScope0);
    }

    @Override  // com.melon.ui.M2
    public final void handleMorePopupUiEvent(m2 m20, androidx.fragment.app.I i0, we.o o0) {
        q.g(m20, "event");
        q.g(i0, "fragment");
        this.f.handleMorePopupUiEvent(m20, i0, null);
    }

    @Override  // com.melon.ui.k3
    public final void handlePutPopupUiEvent(o3 o30, androidx.fragment.app.I i0, we.a a0, we.k k0, boolean z, we.a a1) {
        q.g(o30, "event");
        q.g(i0, "fragment");
        this.e.handlePutPopupUiEvent(o30, i0, a0, k0, z, null);
    }

    public final void n(r0.q q0, r r0, F f0, l l0, int v) {
        ((p)l0).c0(0x67409F04);
        int v1 = v | (((p)l0).g(q0) ? 4 : 2) | (((p)l0).i(r0) ? 0x20 : 16) | (((p)l0).g(f0) ? 0x100 : 0x80);
        if(((p)l0).Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            float f1 = h.t(((p)l0), 0x7F070057);  // dimen:bottom_tab_height
            j0 j00 = androidx.compose.foundation.layout.a.c(0.0f, 0.0f, 0.0f, h.t(((p)l0), 0x7F070315) + f1, 7);  // dimen:mini_player_height
            boolean z = ((p)l0).i(r0);
            Mc.q q1 = ((p)l0).N();
            if(z || q1 == androidx.compose.runtime.k.a) {
                q1 = new Mc.q(r0, 0);
                ((p)l0).l0(q1);
            }
            c1.o(q0, f0, j00, false, null, null, null, false, q1, ((p)l0), v1 & 14 | v1 >> 3 & 0x70, 0xF8);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new U2(this, q0, r0, f0, v, 14);
        }
    }

    public final void o(E0 e00, l l0, int v) {
        ((p)l0).c0(-232345950);
        int v1 = (((p)l0).i(e00) ? 0x20 : 16) | v;
        if(((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            B.a.a(n.a, e00, ((p)l0), v1 & 0x7E);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new Gd.p(this, e00, v, 23);
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
        String s = bundle0.getString("argGenreCode", "");
        q.f(s, "getString(...)");
        x0.getClass();
        x0.i = s;
        String s1 = bundle0.getString("argSortType", "POP");
        q.f(s1, "getString(...)");
        x0.j = s1;
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
        String s = ((x)this.getViewModel()).i;
        if(s != null) {
            bundle0.putString("argGenreCode", s);
            bundle0.putString("argSortType", ((x)this.getViewModel()).j);
            return;
        }
        q.m("genreCode");
        throw null;
    }

    @Override  // com.melon.ui.J0
    public final void onUiEvent(I4 i40) {
        q.g(i40, "event");
        if(i40 instanceof A4) {
            Mc.o o0 = new Mc.o(this, 0);
            this.sendUserEvent(new m(((A4)i40).a, ((A4)i40).b, ((A4)i40).c, o0, 0x20));
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
            Kc.c c0 = new Kc.c(1, this, v.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 10);
            this.f.A(((F4)i40).a, this, s, c0);
            return;
        }
        if(i40 instanceof B4) {
            Mc.o o1 = new Mc.o(this, 1);
            this.sendUserEvent(new com.melon.ui.n(((B4)i40).a, ((B4)i40).b, false, false, o1, 92));
            return;
        }
        if(i40 instanceof u4) {
            Navigator.openUrl("", ((u4)i40).a, OpenType.FullScreen, ((u4)i40).b);
            return;
        }
        if(i40 instanceof v4) {
            ArrayList arrayList0 = h.W(((v4)i40).b);
            ArrayList arrayList1 = h.W(((v4)i40).c);
            Navigator.openPresentSongSendFragment(((v4)i40).a, arrayList0, arrayList1);
            return;
        }
        if(i40 instanceof x3) {
            FragmentActivity fragmentActivity0 = this.getActivity();
            ((x)this.getViewModel()).getClass();
            boolean z = ((e0)va.o.a()).m();
            Kc.c c1 = new Kc.c(1, this, v.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 11);
            this.d.getClass();
            c.h(((x3)i40), this, fragmentActivity0, z, this.j, c1);
            return;
        }
        if(i40 instanceof o3) {
            k3.d(this, ((o3)i40), this, new Mc.o(this, 2), new Kc.c(1, this, v.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 12), false, 0x30);
            return;
        }
        if(i40 instanceof m2) {
            this.handleMorePopupUiEvent(((m2)i40), this, null);
            return;
        }
        if(i40 instanceof com.melon.ui.b) {
            l0 l00 = this.getChildFragmentManager();
            q.f(l00, "getChildFragmentManager(...)");
            a.f(this, l00, ((com.melon.ui.b)i40), this.getContext(), new Kc.c(1, this, v.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 13));
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
        q.g(k40, "uiState");
        V0 v00 = (V0)this.getBinding();
        if(v00 != null) {
            v00.b.setViewCompositionStrategy(t0.d);
            m0.b b0 = new m0.b(-1700338303, new Mc.p(k40, this, 0), true);
            v00.b.setContent(b0);
        }
    }

    @Override  // com.melon.ui.c0
    public final void setInsetHandlingType(f1 f10) {
        q.g(f10, "<set-?>");
        this.h = f10;
    }

    @Override  // com.melon.ui.k3
    public final void showContextMenuAddTo(androidx.fragment.app.I i0, String s, List list0, we.a a0, we.k k0, boolean z, String s1) {
        q.g(i0, "fragment");
        q.g(s, "menuId");
        q.g(list0, "playableList");
        q.g(k0, "sendUserEvent");
        this.e.showContextMenuAddTo(i0, s, list0, a0, k0, z, "");
    }
}

