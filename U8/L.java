package U8;

import Ac.T0;
import Ac.X;
import Ac.a4;
import Cc.N0;
import Cc.N1;
import Cc.T3;
import Cc.Y;
import Cc.c1;
import Cc.e0;
import H0.e;
import Hd.F0;
import J0.H;
import J8.V0;
import M.c;
import M.j;
import M.p0;
import M.y;
import O.F;
import P0.h;
import P0.i;
import Q4.a;
import U4.x;
import android.content.Context;
import android.view.LayoutInflater;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.fragment.app.I;
import com.iloen.melon.popup.EqualizerCancelConfirmPopup;
import com.iloen.melon.userstore.MelonDb;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.k3;
import com.melon.ui.o3;
import com.melon.ui.p3;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import ob.z;
import r0.n;
import wc.u;
import we.k;
import y0.s;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"LU8/l;", "Lcom/melon/ui/J0;", "LU8/w;", "LJ8/V0;", "Lcom/melon/ui/k3;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class l extends M implements k3 {
    public final p3 d;
    public final LogU e;
    public z f;
    public boolean g;

    public l() {
        this.d = new p3();  // 初始化器: Ljava/lang/Object;-><init>()V
        LogU logU0 = new LogU("EqualizerSettingFragment");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(false);
        this.e = logU0;
    }

    @Override  // com.melon.ui.c0
    public final String getFragmentTag() {
        return "EqualizerSettingFragment";
    }

    @Override  // com.melon.ui.J0
    public final a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return V0.a(layoutInflater0, null);
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return w.class;
    }

    @Override  // com.melon.ui.k3
    public final void handlePutPopupUiEvent(o3 o30, I i0, we.a a0, k k0, boolean z, we.a a1) {
        q.g(o30, "event");
        q.g(i0, "fragment");
        this.d.handlePutPopupUiEvent(o30, i0, a0, k0, z, null);
    }

    @Override  // com.melon.ui.c0
    public final boolean isBringToFrontFragment() {
        return true;
    }

    @Override  // com.melon.ui.c0
    public final boolean isScreenLandscapeSupported() {
        return this.g;
    }

    @Override  // com.melon.ui.c0
    public final boolean isShowTabAndMiniPlayer() {
        return false;
    }

    public final void n(r r0, androidx.compose.runtime.l l0, int v) {
        p p0 = (p)l0;
        p0.c0(-395790289);
        int v1 = (p0.i(r0) ? 4 : 2) | v | (p0.i(this) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.layout.a.l(d.c(d.f(n0, 1.0f), 1.0f), 20.0f, 0.0f, 2);
            y y0 = M.w.a(j.c, r0.d.m, p0, 0);
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
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            r0.q q2 = x.r(1.0f, d.f(n0, 1.0f), true);
            N0.M m0 = M.p.d(r0.d.a, false);
            int v3 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            androidx.compose.runtime.w.x(p0, q3, h3);
            r0.q q4 = d.c(d.f(n0, 1.0f), 1.0f);
            c.a((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q4, r0.d.e), null, false, m0.c.e(0x84DCF901, p0, new a4(4, this, r0)), p0, 0xC00, 6);
            p0.p(true);
            boolean z = r0.c;
            String s = e.Y(p0, 0x7F130399);  // string:eq_ai_mode_genius "지니어스 모드"
            String s1 = e.Y(p0, 0x7F13039A);  // string:eq_ai_mode_genius_desc "AI 마스터가 재생 중인 음원의 특성에 따라 최적화된 음향효과를 적용합니다."
            boolean z1 = p0.i(this);
            U8.c c0 = p0.N();
            V v4 = androidx.compose.runtime.k.a;
            if(z1 || c0 == v4) {
                c0 = new U8.c(this, 0);
                p0.l0(c0);
            }
            U8.p.g(z, s, s1, c0, p0, 0xC00);
            c.d(p0, d.h(n0, 18.0f));
            boolean z2 = r0.d;
            String s2 = e.Y(p0, 0x7F130397);  // string:eq_ai_mode_ambient "앰비언트 모드"
            String s3 = e.Y(p0, 0x7F130398);  // string:eq_ai_mode_ambient_desc "지니어스 모드에 공간 음향효과를 더해 콘서트장에 온 듯한 입체적 사운드를 제공합니다."
            boolean z3 = p0.i(this);
            U8.c c1 = p0.N();
            if(z3 || c1 == v4) {
                c1 = new U8.c(this, 1);
                p0.l0(c1);
            }
            U8.p.g(z2, s2, s3, c1, p0, 0xC00);
            A7.d.v(n0, 24.0f, p0, true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new U8.b(this, r0, v, 1);
        }
    }

    public final void o(List list0, int v, boolean z, k k0, k k1, androidx.compose.runtime.l l0, int v1, int v2) {
        k k4;
        b0 b01;
        k k3;
        k k2;
        p p0 = (p)l0;
        p0.c0(0x2CF54819);
        int v3 = (v1 & 6) == 0 ? (p0.i(list0) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v3 |= (p0.e(v) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v3 |= (p0.h(z) ? 0x100 : 0x80);
        }
        if((v1 & 0xC00) == 0) {
            v3 |= (p0.i(k0) ? 0x800 : 0x400);
        }
        if((v2 & 16) != 0) {
            v3 |= 0x6000;
            k2 = k1;
        }
        else if((v1 & 0x6000) == 0) {
            k2 = k1;
            v3 |= (p0.i(k2) ? 0x4000 : 0x2000);
        }
        else {
            k2 = k1;
        }
        if(p0.Q(v3 & 1, (v3 & 9363) != 9362)) {
            if((v2 & 16) != 0) {
                k2 = null;
            }
            b0 b00 = p0.N();
            V v4 = androidx.compose.runtime.k.a;
            if(b00 == v4) {
                int v5 = 0;
                Iterator iterator0 = list0.iterator();
                while(true) {
                    if(!iterator0.hasNext()) {
                        v5 = -1;
                        break;
                    }
                    Object object0 = iterator0.next();
                    if(((y8.i)object0).a() == v) {
                        break;
                    }
                    ++v5;
                }
                b00 = x.d(v5, p0);
            }
            F f0 = O.I.a(0, 0, 3, p0);
            CoroutineScope coroutineScope0 = p0.N();
            if(coroutineScope0 == v4) {
                coroutineScope0 = J.i(p0);
                p0.l0(coroutineScope0);
            }
            N0.M m0 = M.p.d(r0.d.a, false);
            int v6 = p0.P;
            i0 i00 = p0.m();
            n n0 = n.a;
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
            androidx.compose.runtime.w.x(p0, m0, P0.j.f);
            androidx.compose.runtime.w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h0);
            }
            androidx.compose.runtime.w.x(p0, q0, P0.j.d);
            FillElement fillElement0 = d.c;
            boolean z1 = p0.i(list0);
            f f1 = p0.N();
            if((((v3 & 0x380) == 0x100 ? 1 : 0) | (z1 | (v3 & 0x70) == 0x20 | ((0xE000 & v3) == 0x4000 ? 1 : 0) | ((v3 & 0x1C00) == 0x800 ? 1 : 0))) != 0 || f1 == v4) {
                k3 = k2;
                b01 = b00;
                f f2 = new f(list0, v, b01, k3, k0, z);
                p0.l0(f2);
                f1 = f2;
            }
            else {
                k3 = k2;
                b01 = b00;
            }
            c1.o(fillElement0, f0, null, false, null, null, null, false, f1, p0, 6, 0xFC);
            if(f0.d()) {
                p0.a0(0x369CFC70);
                r0.q q1 = androidx.compose.foundation.q.e(d.h(d.f(n0, 1.0f), 60.0f), u.f(e.k.A(new s[]{new s(e0.T(p0, 0x7F06048A)), new s(e0.T(p0, 0x7F0604AA))}), 0.0f, 0.0f, 14), null, 6);  // color:transparent
                M.p.a((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q1, r0.d.h), p0, 0);
            }
            else {
                p0.a0(0x34A8856F);
            }
            p0.p(false);
            p0.p(true);
            boolean z2 = p0.i(coroutineScope0);
            boolean z3 = p0.g(f0);
            U8.j j0 = p0.N();
            if(z2 || z3 || j0 == v4) {
                j0 = new U8.j(b01, coroutineScope0, f0, null);
                p0.l0(j0);
            }
            J.d(p0, list0, j0);
            k4 = k3;
        }
        else {
            p0.T();
            k4 = k2;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new T0(this, list0, v, z, k0, k4, v1, v2);
        }
    }

    @Override  // com.melon.ui.c0
    public final boolean onBackPressed() {
        if(((Boolean)((w)this.getViewModel()).b.getValue()).booleanValue()) {
            U8.c c0 = new U8.c(this, 2);
            String s = this.getString(0x7F13039B);  // string:eq_close_confirm_message "저장하지 않은 변경사항이 있습니다. 닫으시겠습니까?"
            q.f(s, "getString(...)");
            this.r(s, c0);
            return true;
        }
        return super.onBackPressed();
    }

    @Override  // com.melon.ui.c0
    public final void onDestroy() {
        if(((Boolean)((w)this.getViewModel()).b.getValue()).booleanValue()) {
            ((w)this.getViewModel()).f();
        }
        super.onDestroy();
    }

    @Override  // com.melon.ui.c0
    public final void onForeground() {
        super.onForeground();
        com.melon.ui.n0.performPvLoggingOnForeground$default(this.getViewModel(), "playerEQ10Band", null, 2, null);
    }

    @Override  // com.melon.ui.c0
    public final void onStop() {
        if(((Boolean)((w)this.getViewModel()).b.getValue()).booleanValue()) {
            z z0 = this.f;
            if(z0 == null) {
                q.m("playerUseCase");
                throw null;
            }
            else if(!z0.n()) {
                ((w)this.getViewModel()).f();
                ((w)this.getViewModel()).g(false);
            }
        }
        super.onStop();
    }

    @Override  // com.melon.ui.J0
    public final void onUiEvent(I4 i40) {
        List list0;
        q.g(i40, "event");
        LogU.info$default(this.e, "onUiEvent: " + i40, null, false, 6, null);
        if(i40 instanceof U8.u) {
            Object object0 = ((w)this.getViewModel()).getUiState().getValue();
            q.e(object0, "null cannot be cast to non-null type com.iloen.melon.equalizer.EqualizerSettingUiState");
            Context context0 = this.requireContext();
            q.f(context0, "requireContext(...)");
            EqualizerCancelConfirmPopup equalizerCancelConfirmPopup0 = new EqualizerCancelConfirmPopup(context0, ((r)object0).h);
            equalizerCancelConfirmPopup0.setOnRefreshListener(new g(this, 0));
            equalizerCancelConfirmPopup0.show();
            ((w)this.getViewModel()).trackTiaraEventLog(new U8.a(this, 8));
            return;
        }
        if(i40 instanceof v) {
            ((w)this.getViewModel()).getClass();
            int v = e1.b.F().c;
            MelonDb melonDb0 = w9.a.a.h();
            if(melonDb0 == null) {
                list0 = je.w.a;
            }
            else {
                list0 = melonDb0.fetchUserEqualizer();
                melonDb0.close();
                if(list0 == null) {
                    list0 = je.w.a;
                }
            }
            Object object1 = null;
            for(Object object2: list0) {
                if(((K)object2).b == v) {
                    object1 = object2;
                    break;
                }
            }
            if(((K)object1) != null) {
                Object object3 = ((w)this.getViewModel()).getUiState().getValue();
                q.e(object3, "null cannot be cast to non-null type com.iloen.melon.equalizer.EqualizerSettingUiState");
                q.g(((r)object3).h, "<set-?>");
                ((K)object1).e = ((r)object3).h;
                Context context1 = this.requireContext();
                q.f(context1, "requireContext(...)");
                EqualizerCancelConfirmPopup equalizerCancelConfirmPopup1 = new EqualizerCancelConfirmPopup(context1, ((K)object1), 1);
                equalizerCancelConfirmPopup1.setOnRefreshListener(new g(this, 1));
                equalizerCancelConfirmPopup1.show();
            }
            ((w)this.getViewModel()).trackTiaraEventLog(new U8.a(this, 9));
            return;
        }
        if(i40 instanceof t) {
            ((w)this.getViewModel()).f();
            ((w)this.getViewModel()).g(false);
            ((w)this.getViewModel()).getClass();
            y8.l.a.d();
            ((w)this.getViewModel()).trackTiaraEventLog(new U8.a(this, 10));
            return;
        }
        super.onUiEvent(i40);
    }

    public final void p(r r0, androidx.compose.runtime.l l0, int v) {
        List list3;
        n n1;
        p p0 = (p)l0;
        p0.c0(0x7BF7E8B1);
        int v1 = v | (p0.i(r0) ? 4 : 2) | (p0.i(this) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            n n0 = n.a;
            r0.q q0 = d.c(d.f(n0, 1.0f), 1.0f);
            y y0 = M.w.a(j.c, r0.d.m, p0, 0);
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
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            r0.q q2 = d.f(d.t(n0, 3), 1.0f);
            r0.i i1 = r0.d.a;
            N0.M m0 = M.p.d(i1, false);
            int v3 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            androidx.compose.runtime.w.x(p0, q3, h3);
            r0.q q4 = d.f(d.h(n0, 212.0f), 1.0f);
            androidx.compose.foundation.q.c(De.I.Q(0x7F080632, p0, 6), this.getString(0x7F130B50), q4, null, null, 0.0f, null, p0, 0x180, 120);  // drawable:img_eq_fader_bg
            float[] arr_f = r0.h;
            boolean z = r0.c || r0.d;
            r0.q q5 = d.f(d.h(androidx.compose.foundation.layout.a.n(n0, 0.0f, 12.0f, 0.0f, 0.0f, 13), 212.0f), 1.0f);
            N0.M m1 = M.p.d(i1, false);
            int v4 = p0.P;
            i0 i02 = p0.m();
            r0.q q6 = r0.a.d(p0, q5);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m1, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            androidx.compose.runtime.w.x(p0, q6, h3);
            if(z) {
                p0.a0(915090599);
                r0.q q7 = androidx.compose.foundation.layout.a.n(n0, 16.0f, 6.0f, 16.0f, 0.0f, 8);
                p0 p00 = M.n0.a(j.a, r0.d.j, p0, 0);
                int v5 = p0.P;
                i0 i03 = p0.m();
                r0.q q8 = r0.a.d(p0, q7);
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(p0, p00, h0);
                androidx.compose.runtime.w.x(p0, i03, h1);
                if(p0.O || !q.b(p0.N(), v5)) {
                    A7.d.q(v5, p0, v5, h2);
                }
                androidx.compose.runtime.w.x(p0, q8, h3);
                n1 = n0;
                N1.b(va.e.h(e.Y(p0, 0x7F130394), "  "), null, e0.T(p0, 0x7F060163), 12.0f, e1.y.h, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C00, 0, 0x1FFD2);  // string:eq_ai_apply_desc "EQ 자동 적용 중"
                N1.b(e.Y(p0, 0x7F130395), null, e0.T(p0, 0x7F06015D), 12.0f, e1.y.f, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C00, 0, 0x1FFD2);  // string:eq_ai_apply_desc2 "직접 설정 시, AI 마스터가 해제됩니다."
                p0.p(true);
            }
            else {
                n1 = n0;
                p0.a0(0x35291B13);
            }
            p0.p(false);
            List list0 = je.n.x0(arr_f);
            boolean z1 = p0.i(this);
            C8.a a0 = p0.N();
            V v6 = androidx.compose.runtime.k.a;
            if(z1 || a0 == v6) {
                a0 = new C8.a(this, 23);
                p0.l0(a0);
            }
            boolean z2 = p0.i(this);
            boolean z3 = p0.i(arr_f);
            Dc.i i2 = p0.N();
            if(z2 || z3 || i2 == v6) {
                i2 = new Dc.i(15, this, arr_f);
                p0.l0(i2);
            }
            U8.p.a(list0, z, a0, i2, p0, 0);
            p0.p(true);
            p0.p(true);
            c.d(p0, d.h(n1, 20.0f));
            int v7 = r0.f;
            List list1 = e.k.A(new String[]{e.Y(p0, 0x7F1303A6), e.Y(p0, 0x7F1303A8)});  // string:eq_preset "프리셋"
            boolean z4 = p0.i(this);
            U8.a a1 = p0.N();
            if(z4 || a1 == v6) {
                a1 = new U8.a(this, 2);
                p0.l0(a1);
            }
            U8.p.e(list1, v7, a1, p0, 0);
            LayoutWeightElement layoutWeightElement0 = new LayoutWeightElement(1.0f, true);
            N0.M m2 = M.p.d(i1, false);
            int v8 = p0.P;
            i0 i04 = p0.m();
            r0.q q9 = r0.a.d(p0, layoutWeightElement0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m2, h0);
            androidx.compose.runtime.w.x(p0, i04, h1);
            if(p0.O || !q.b(p0.N(), v8)) {
                A7.d.q(v8, p0, v8, h2);
            }
            androidx.compose.runtime.w.x(p0, q9, h3);
            int v9 = -1;
            y8.k k0 = null;
            if(v7 == 0) {
                p0.a0(0x9D0C881);
                List list2 = je.n.z0(y8.r.b);
                ((w)this.getViewModel()).getClass();
                y8.k k1 = e1.b.F();
                if(k1.b == 7) {
                    k0 = k1;
                }
                if(k0 != null) {
                    v9 = k0.c;
                }
                boolean z5 = ((Boolean)androidx.compose.runtime.w.f(((w)this.getViewModel()).b, p0).getValue()).booleanValue();
                boolean z6 = p0.i(list2);
                boolean z7 = p0.i(this);
                U8.d d0 = p0.N();
                if(z6 || z7 || d0 == v6) {
                    d0 = new U8.d(list2, this, 0);
                    p0.l0(d0);
                }
                this.o(list2, v9, z5, d0, null, p0, v1 << 12 & 0x70000, 16);
            }
            else {
                p0.a0(0x9E4E0EE);
                ((w)this.getViewModel()).getClass();
                MelonDb melonDb0 = w9.a.a.h();
                if(melonDb0 == null) {
                    list3 = je.w.a;
                }
                else {
                    list3 = melonDb0.fetchUserEqualizer();
                    melonDb0.close();
                    if(list3 == null) {
                        list3 = je.w.a;
                    }
                }
                if(list3.isEmpty()) {
                    p0.a0(0x9E522AF);
                    r0.q q10 = d.f(n1, 1.0f);
                    r0.q q11 = (b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q10, r0.d.e);
                    N1.b(e.Y(p0, 0x7F1303A5), q11, e0.T(p0, 0x7F060163), 15.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FDF0);  // string:eq_no_item "저장된 마이 EQ가 없습니다."
                }
                else {
                    p0.a0(0x9ED7A4B);
                    ((w)this.getViewModel()).getClass();
                    y8.k k2 = e1.b.F();
                    if(k2.b == 6) {
                        k0 = k2;
                    }
                    if(k0 != null) {
                        v9 = k0.c;
                    }
                    boolean z8 = ((Boolean)androidx.compose.runtime.w.f(((w)this.getViewModel()).b, p0).getValue()).booleanValue();
                    boolean z9 = p0.i(list3);
                    boolean z10 = p0.i(this);
                    U8.d d1 = p0.N();
                    if(z9 || z10 || d1 == v6) {
                        d1 = new U8.d(list3, this, 1);
                        p0.l0(d1);
                    }
                    boolean z11 = p0.i(list3);
                    boolean z12 = p0.i(this);
                    boolean z13 = p0.e(v9);
                    F0 f00 = p0.N();
                    if((z11 | z12 | z13) != 0 || f00 == v6) {
                        f00 = new F0(list3, this, v9, 6);
                        p0.l0(f00);
                    }
                    this.o(list3, v9, z8, d1, f00, p0, 0x70000 & v1 << 12, 0);
                }
                p0.p(false);
            }
            p0.p(false);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new U8.b(this, r0, v, 2);
        }
    }

    public final void q(r r0, androidx.compose.runtime.l l0, int v) {
        h h5;
        i i1;
        h h4;
        p p0 = (p)l0;
        p0.c0(900543448);
        int v1 = v | (p0.i(r0) ? 4 : 2) | (p0.i(this) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            N0.M m0 = M.p.d(r0.d.a, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            n n0 = n.a;
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
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, m0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q0, h3);
            r0.q q1 = d.c(d.f(n0, 1.0f), 1.0f);
            long v3 = e0.T(p0, 0x7F0604AA);  // color:white000s_support_high_contrast
            u u0 = y0.M.a;
            r0.q q2 = androidx.compose.foundation.q.f(q1, v3, u0);
            r0.g g0 = r0.d.m;
            y y0 = M.w.a(j.c, g0, p0, 0);
            int v4 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            p0.e0();
            M.d d0 = j.c;
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(!p0.O && q.b(p0.N(), v4)) {
                h4 = h2;
            }
            else {
                h4 = h2;
                A7.d.q(v4, p0, v4, h4);
            }
            androidx.compose.runtime.w.x(p0, q3, h3);
            r0.q q4 = androidx.compose.foundation.layout.a.n(d.h(d.f(n0, 1.0f), 82.0f), 20.0f, 0.0f, 20.0f, 0.0f, 10);
            p0 p00 = M.n0.a(j.g, r0.d.k, p0, 54);
            int v5 = p0.P;
            i0 i02 = p0.m();
            r0.q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h4);
            }
            androidx.compose.runtime.w.x(p0, q5, h3);
            r0.q q6 = d.u(n0, 3);
            String s = e.Y(p0, 0x7F130392);  // string:eq "EQ"
            long v6 = e0.T(p0, 0x7F06016D);  // color:gray900s
            l1.k k0 = new l1.k(5);
            N1.b(s, q6, v6, 22.0f, e1.y.i, null, 0L, k0, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C30, 0, 0x1FDD0);
            r0.q q7 = d.h(d.q(n0, 56.0f), 24.0f);
            boolean z = r0.a;
            boolean z1 = p0.i(this);
            U8.a a0 = p0.N();
            V v7 = androidx.compose.runtime.k.a;
            if(z1 || a0 == v7) {
                a0 = new U8.a(this, 0);
                p0.l0(a0);
            }
            U8.p.c(q7, z, a0, 0, 0, p0, 6);
            p0.p(true);
            r0.q q8 = e0.Q(new LayoutWeightElement(1.0f, true), z);
            q.g(q8, "<this>");
            if(!z) {
                q8 = H.a(q8, ie.H.a, Y.a);
            }
            y y1 = M.w.a(d0, g0, p0, 0);
            int v8 = p0.P;
            i0 i03 = p0.m();
            r0.q q9 = r0.a.d(p0, q8);
            p0.e0();
            if(p0.O) {
                i1 = i0;
                p0.l(i1);
            }
            else {
                i1 = i0;
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y1, h0);
            androidx.compose.runtime.w.x(p0, i03, h1);
            if(!p0.O && q.b(p0.N(), v8)) {
                h5 = h4;
            }
            else {
                h5 = h4;
                A7.d.q(v8, p0, v8, h5);
            }
            androidx.compose.runtime.w.x(p0, q9, h3);
            int v9 = r0.b;
            String s1 = e.Y(p0, 0x7F130E8F);  // string:tiara_eq_click_copy_aimaster "AI Master"
            N0 n00 = new N0(Cc.T0.b, s1, 0x7F080633, 0x7F080634);  // drawable:img_eq_logo_default
            String s2 = e.Y(p0, 0x7F13039C);  // string:eq_custom_setting "EQ 직접 설정"
            List list0 = e.k.A(new N0[]{n00, new N0(Cc.T0.a, s2, -1, -1)});
            boolean z2 = p0.i(this);
            U8.a a1 = p0.N();
            if(z2 || a1 == v7) {
                a1 = new U8.a(this, 1);
                p0.l0(a1);
            }
            e0.z(list0, v9, a1, p0, 0);
            if(v9 == 0) {
                p0.a0(0x8F6F1A17);
                this.n(r0, p0, v1 & 0x7E);
            }
            else {
                p0.a0(0x8F703CD6);
                this.p(r0, p0, v1 & 0x7E);
            }
            p0.p(false);
            p0.p(true);
            M.p.a(androidx.compose.foundation.q.f(d.h(d.f(androidx.compose.foundation.layout.a.l(n0, 20.0f, 0.0f, 2), 1.0f), 0.5f), e0.T(p0, 0x7F06014A), u0), p0, 0);  // color:gray100a
            r0.q q10 = r0.a.a(d.h(d.f(n0, 1.0f), 49.0f), new X(this, 18));
            y y2 = M.w.a(j.e, g0, p0, 6);
            int v10 = p0.P;
            i0 i04 = p0.m();
            r0.q q11 = r0.a.d(p0, q10);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y2, h0);
            androidx.compose.runtime.w.x(p0, i04, h1);
            if(p0.O || !q.b(p0.N(), v10)) {
                A7.d.q(v10, p0, v10, h5);
            }
            androidx.compose.runtime.w.x(p0, q11, h3);
            r0.q q12 = d.t(x.s(n0, 14.5f, p0, n0, 1.0f), 3);
            String s3 = e.Y(p0, 0x7F1301D2);  // string:close "닫기"
            long v11 = e0.T(p0, 0x7F060169);  // color:gray850s
            l1.k k1 = new l1.k(3);
            N1.b(s3, q12, v11, 16.0f, e1.y.f, null, 0L, k1, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C30, 0, 0x1FDD0);
            c.d(p0, d.h(n0, 15.0f));
            p0.p(true);
            p0.p(true);
            T3.a(d.h((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, r0.d.h), 51.0f), r0.j, 0.0f, p0, 0, 4);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n01 = p0.t();
        if(n01 != null) {
            n01.d = new U8.b(this, r0, v, 0);
        }
    }

    public final void r(String s, we.a a0) {
        com.melon.ui.popup.b.x(this.getChildFragmentManager(), this.getString(0x7F1300D0), s, false, false, null, null, new Dc.i(14, this, a0), null, null, null, 0xEF0);  // string:alert_dlg_title_info "안내"
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        V0 v00 = (V0)this.getBinding();
        if(v00 != null) {
            m0.b b0 = new m0.b(0x90BC9A79, new Nc.Y(15, k40, this), true);
            v00.b.setContent(b0);
        }
    }

    @Override  // com.melon.ui.c0
    public final void setScreenLandscapeSupported(boolean z) {
        this.g = z;
    }

    @Override  // com.melon.ui.k3
    public final void showContextMenuAddTo(I i0, String s, List list0, we.a a0, k k0, boolean z, String s1) {
        q.g(i0, "fragment");
        q.g(s, "menuId");
        q.g(list0, "playableList");
        q.g(k0, "sendUserEvent");
        this.d.showContextMenuAddTo(i0, s, list0, a0, k0, z, "");
    }
}

