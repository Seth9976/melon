package xc;

import Ac.v2;
import Cc.N1;
import Cc.T3;
import Cc.U3;
import Cc.c1;
import Hc.P;
import Ic.r;
import Ic.z;
import J8.A;
import Jc.B;
import Jc.K;
import Jc.X;
import Jc.e0;
import M.Y;
import M.i0;
import M.p0;
import M.y;
import O.F;
import P0.h;
import P0.j;
import R6.c;
import R6.d;
import a1.U;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.VerticalAlignElement;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import androidx.fragment.app.l0;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.constants.CType;
import com.iloen.melon.custom.f1;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.comments.CommentActionImplKt;
import com.iloen.melon.net.v3x.comments.LoadPgnRes.result;
import com.iloen.melon.net.v3x.comments.LoadPgnRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.popup.InstantPlayPopup;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.net.res.v3.CommentConfig;
import com.melon.ui.A4;
import com.melon.ui.B4;
import com.melon.ui.C4;
import com.melon.ui.F4;
import com.melon.ui.G4;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.M2;
import com.melon.ui.a;
import com.melon.ui.e;
import com.melon.ui.k3;
import com.melon.ui.m2;
import com.melon.ui.m;
import com.melon.ui.o1;
import com.melon.ui.o3;
import com.melon.ui.p3;
import com.melon.ui.u4;
import com.melon.ui.v4;
import com.melon.ui.x3;
import com.melon.ui.x4;
import com.melon.ui.z4;
import d5.f;
import gd.T7;
import i.n.i.b.a.s.e.M3;
import java.util.ArrayList;
import java.util.List;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import m0.b;
import md.i;
import r0.n;
import td.L;
import td.z1;
import wc.u;
import wc.x;
import we.o;
import y0.M;
import y0.s;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\bB\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lxc/k;", "Lcom/melon/ui/o1;", "Lwc/x;", "LJ8/A;", "Lmd/i;", "", "Lcom/melon/ui/k3;", "Lcom/melon/ui/M2;", "Lcom/melon/ui/a;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class k extends o1 implements M2, a, k3, i {
    public final c a;
    public final p3 b;
    public final d c;
    public final e d;
    public f1 e;

    public k() {
        this.a = new c(26);
        this.b = new p3();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.c = new d(25);
        this.d = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.e = f1.b;
    }

    @Override  // md.i
    public final nd.a b() {
        b b0 = new b(0x3DCA1CA0, new xc.c(this, 4), true);
        b b1 = new b(0xB6E1B302, new g(this, 1), true);
        b b2 = new b(0x1ACC4EFF, new xc.c(this, 5), true);
        b b3 = new b(0x64426CFA, new xc.c(this, 6), true);
        nd.a a0 = new nd.a();
        a0.b = nd.b.b;
        a0.c = 0;
        a0.d = 350;
        a0.e = 0;
        a0.f = null;
        a0.g = b0;
        a0.h = null;
        a0.i = b1;
        a0.j = b3;
        a0.k = null;
        a0.l = b2;
        return a0;
    }

    @Override  // com.melon.ui.c0
    public final f1 getInsetHandlingType() {
        return this.e;
    }

    @Override  // com.melon.ui.J0
    public final Q4.a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return A.a(layoutInflater0);
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
    public final void handleMorePopupUiEvent(m2 m20, I i0, o o0) {
        q.g(m20, "event");
        q.g(i0, "fragment");
        this.c.handleMorePopupUiEvent(m20, i0, o0);
    }

    @Override  // com.melon.ui.k3
    public final void handlePutPopupUiEvent(o3 o30, I i0, we.a a0, we.k k0, boolean z, we.a a1) {
        q.g(o30, "event");
        q.g(i0, "fragment");
        this.b.handlePutPopupUiEvent(o30, i0, a0, k0, z, null);
    }

    public final void m(i0 i00, F f0, l l0, int v) {
        q.g(i00, "contentPadding");
        q.g(f0, "lazyListState");
        ((p)l0).c0(70888273);
        int v1 = (v & 6) == 0 ? (((p)l0).g(i00) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (((p)l0).g(f0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (((p)l0).i(this) ? 0x100 : 0x80);
        }
        if(((p)l0).Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            b0 b00 = B.a.r(((x)this.getViewModel()).getUiState(), ((p)l0), 0);
            if(b00.getValue() instanceof z) {
                ((p)l0).a0(0xB30CAF4A);
                Object object0 = b00.getValue();
                q.e(object0, "null cannot be cast to non-null type com.melon.ui.detail.album.AlbumDetailUiState.Screen");
                ArrayList arrayList0 = new ArrayList();
                H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                for(Object object1: ((z)object0).b) {
                    e0 e00 = (e0)object1;
                    if(e00 instanceof X) {
                        String s = ((X)e00).r;
                        Playable playable0 = ((X)e00).a;
                        String s1 = ((X)e00).g;
                        String s2 = ((X)e00).o;
                        q.f("", "getPstime(...)");
                        q.f(CType.SONG, "SONG");
                        arrayList0.add(new Kd.g((s == null ? "" : s), (s1 == null ? "" : s1), "", "", (s2 == null ? "" : s2), (s2 == null ? "" : s2), null, false, false, false, false, false, false, false, "", CType.SONG, false, false, false, "", null, ((X)e00).M, 0x1F80));
                    }
                    else if(e00 instanceof B) {
                        h0.a = e00;
                    }
                }
                Bd.F f1 = new Bd.F(arrayList0, ((z)object0), this, h0, 21);
                ye.a.i(androidx.compose.foundation.layout.d.c, f0, i00, false, null, null, null, false, null, f1, ((p)l0), v1 & 0x70 | 6 | v1 << 6 & 0x380, 504);
            }
            else {
                ((p)l0).a0(0xB1EF0951);
            }
            ((p)l0).p(false);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new Ac.e(this, i00, f0, v, 23);
        }
    }

    public final void n(l l0, int v) {
        V v15;
        P p2;
        V v13;
        Y y2;
        h h10;
        P0.i i5;
        h h8;
        P0.i i4;
        h h7;
        P0.i i3;
        h h5;
        P0.i i2;
        h h3;
        p p0 = (p)l0;
        p0.c0(0x8DCD8C5);
        int v1 = v | (p0.i(this) ? 4 : 2);
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            b0 b00 = B.a.r(((x)this.getViewModel()).getUiState(), p0, 0);
            Object object0 = B.a.r(((x)this.getViewModel()).c().g, p0, 0).getValue();
            Hc.x x0 = object0 instanceof Hc.x ? ((Hc.x)object0) : null;
            Object object1 = B.a.r(((x)this.getViewModel()).d, p0, 0).getValue();
            P p1 = object1 instanceof P ? ((P)object1) : null;
            float f = ((Number)B.a.r(((x)this.getViewModel()).C, p0, 0).getValue()).floatValue();
            if(b00.getValue() instanceof z) {
                p0.a0(0x5C397F03);
                Object object2 = b00.getValue();
                q.e(object2, "null cannot be cast to non-null type com.melon.ui.detail.album.AlbumDetailUiState.Screen");
                ye.a.C(((Context)p0.k(AndroidCompositionLocals_androidKt.b)), ((z)object2).a.a.e);
                String s = ((z)object2).a.a.a;
                String s1 = ((z)object2).a.a.d;
                String s2 = ((z)object2).a.l;
                String s3 = ((Ic.o)je.p.k0(((z)object2).a.a.e)).c;
                ArrayList arrayList0 = ((z)object2).a.a.e;
                FillElement fillElement0 = androidx.compose.foundation.layout.d.c;
                long v2 = Cc.e0.T(p0, 0x7F0604AA);  // color:white000s_support_high_contrast
                u u0 = M.a;
                r0.q q0 = androidx.compose.foundation.q.f(fillElement0, v2, u0);
                N0.M m0 = M.p.d(r0.d.a, false);
                int v3 = p0.P;
                String s4 = ((z)object2).a.a.c;
                androidx.compose.runtime.i0 i00 = p0.m();
                r0.q q1 = r0.a.d(p0, q0);
                P0.k.y.getClass();
                r0.i i0 = r0.d.a;
                P0.i i1 = j.b;
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                w.x(p0, m0, j.f);
                h h0 = j.e;
                w.x(p0, i00, h0);
                h h1 = j.g;
                h h2 = j.f;
                if(p0.O) {
                    h3 = h0;
                    A7.d.q(v3, p0, v3, h1);
                }
                else {
                    h3 = h0;
                    if(!q.b(p0.N(), v3)) {
                        A7.d.q(v3, p0, v3, h1);
                    }
                }
                w.x(p0, q1, j.d);
                M.p.a(r0.a.e(androidx.compose.foundation.q.f(e2.a.r(fillElement0, f), Cc.e0.T(p0, 0x7F0604AA), u0), 3.0f), p0, 0);  // color:white000s_support_high_contrast
                h h4 = j.d;
                c1.n(fillElement0, s4, null, N0.j.b, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0xC06, 0, 0x7FF4);
                n n0 = n.a;
                r0.q q2 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.f(n0, 1.0f), 170.0f);
                androidx.compose.foundation.layout.b b0 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false));
                M.p.a(androidx.compose.foundation.q.e(b0.a(q2, r0.d.h), u.f(e.k.A(new s[]{new s(Cc.e0.T(p0, 0x7F06048A)), new s(Cc.e0.T(p0, 0x7F0604AA))}), 0.0f, 0.0f, 14), null, 6), p0, 0);  // color:transparent
                r0.q q3 = androidx.compose.foundation.layout.a.n(fillElement0, 20.0f, 0.0f, 20.0f, 0.0f, 10);
                N0.M m1 = M.p.d(i0, false);
                int v4 = p0.P;
                androidx.compose.runtime.i0 i01 = p0.m();
                r0.q q4 = r0.a.d(p0, q3);
                p0.e0();
                if(p0.O) {
                    i2 = i1;
                    p0.l(i2);
                }
                else {
                    i2 = i1;
                    p0.o0();
                }
                w.x(p0, m1, h2);
                w.x(p0, i01, h3);
                if(!p0.O && q.b(p0.N(), v4)) {
                    h5 = h1;
                }
                else {
                    h5 = h1;
                    A7.d.q(v4, p0, v4, h5);
                }
                w.x(p0, q4, h4);
                r0.q q5 = b0.a(n0, r0.d.g);
                y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
                int v5 = p0.P;
                androidx.compose.runtime.i0 i02 = p0.m();
                r0.q q6 = r0.a.d(p0, q5);
                p0.e0();
                if(p0.O) {
                    p0.l(i2);
                }
                else {
                    p0.o0();
                }
                w.x(p0, y0, h2);
                w.x(p0, i02, h3);
                if(p0.O || !q.b(p0.N(), v5)) {
                    A7.d.q(v5, p0, v5, h5);
                }
                w.x(p0, q6, h4);
                N1.b(s, null, Cc.e0.T(p0, 0x7F0604A0), 20.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, new U(0L, 0L, e1.y.i, null, 0L, null, 0, 0L, 0xFFFFFB), p0, 0xC00, 0x180C30, 0xD7F2);  // color:white
                r0.q q7 = U4.x.s(n0, 4.0f, p0, n0, 1.0f);
                M.b b1 = M.j.a;
                r0.h h6 = r0.d.j;
                p0 p00 = M.n0.a(b1, h6, p0, 0);
                int v6 = p0.P;
                androidx.compose.runtime.i0 i03 = p0.m();
                r0.q q8 = r0.a.d(p0, q7);
                p0.e0();
                if(p0.O) {
                    i3 = i2;
                    p0.l(i3);
                }
                else {
                    i3 = i2;
                    p0.o0();
                }
                w.x(p0, p00, h2);
                w.x(p0, i03, h3);
                if(!p0.O && q.b(p0.N(), v6)) {
                    h7 = h5;
                }
                else {
                    h7 = h5;
                    A7.d.q(v6, p0, v6, h7);
                }
                w.x(p0, q8, h4);
                N1.b(s1, null, Cc.e0.T(p0, 0x7F0604A0), 13.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // color:white
                N1.b(s2, null, A7.d.g(n0, 6.0f, p0, 0x7F0604A0, p0), 13.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // color:white
                M.c.d(p0, androidx.compose.foundation.layout.d.q(n0, 6.0f));
                M.c.d(p0, androidx.compose.foundation.layout.d.h(n0, 6.0f));
                N1.b("83명", null, Cc.e0.T(p0, 0x7F0604A0), 13.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC06, 0, 0x1FFF2);  // color:white
                p0.p(true);
                r0.q q9 = U4.x.s(n0, 8.0f, p0, n0, 1.0f);
                p0 p01 = M.n0.a(b1, h6, p0, 0);
                int v7 = p0.P;
                androidx.compose.runtime.i0 i04 = p0.m();
                r0.q q10 = r0.a.d(p0, q9);
                p0.e0();
                if(p0.O) {
                    i4 = i3;
                    p0.l(i4);
                }
                else {
                    i4 = i3;
                    p0.o0();
                }
                w.x(p0, p01, h2);
                w.x(p0, i04, h3);
                if(!p0.O && q.b(p0.N(), v7)) {
                    h8 = h7;
                }
                else {
                    h8 = h7;
                    A7.d.q(v7, p0, v7, h8);
                }
                w.x(p0, q10, h4);
                r0.q q11 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n0, 26.0f), 26.0f);
                r0.h h9 = r0.d.k;
                r0.q q12 = Cc.e0.J(d5.n.o(H0.b.r(h9, q11), T.e.a));
                boolean z = p0.i(this);
                boolean z1 = p0.i(arrayList0);
                z1 z10 = p0.N();
                V v8 = androidx.compose.runtime.k.a;
                if(z || z1 || z10 == v8) {
                    z10 = new z1(5, this, arrayList0);
                    p0.l0(z10);
                }
                c1.n(androidx.compose.foundation.q.n(q12, null, z10, 7), s3, null, N0.j.c, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0xC00, 0, 0x7FF4);
                long v9 = A7.d.g(n0, 6.0f, p0, 0x7F0604A0, p0);  // color:white
                N1.b("83명", new VerticalAlignElement(h9), v9, 13.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC06, 0, 0x1FFF0);
                l1.y(p0, true, n0, 20.0f, p0);
                r0.q q13 = androidx.compose.foundation.layout.d.f(n0, 1.0f);
                p0 p02 = M.n0.a(M.j.g, h9, p0, 54);
                int v10 = p0.P;
                androidx.compose.runtime.i0 i05 = p0.m();
                r0.q q14 = r0.a.d(p0, q13);
                p0.e0();
                if(p0.O) {
                    i5 = i4;
                    p0.l(i5);
                }
                else {
                    i5 = i4;
                    p0.o0();
                }
                w.x(p0, p02, h2);
                w.x(p0, i05, h3);
                if(!p0.O && q.b(p0.N(), v10)) {
                    h10 = h8;
                }
                else {
                    h10 = h8;
                    A7.d.q(v10, p0, v10, h10);
                }
                w.x(p0, q14, h4);
                Y y1 = Y.a;
                r0.q q15 = androidx.compose.foundation.layout.a.p(n0, y1);
                p0 p03 = M.n0.a(b1, h6, p0, 0);
                int v11 = p0.P;
                androidx.compose.runtime.i0 i06 = p0.m();
                r0.q q16 = r0.a.d(p0, q15);
                p0.e0();
                if(p0.O) {
                    p0.l(i5);
                }
                else {
                    p0.o0();
                }
                w.x(p0, p03, h2);
                w.x(p0, i06, h3);
                if(p0.O || !q.b(p0.N(), v11)) {
                    A7.d.q(v11, p0, v11, h10);
                }
                w.x(p0, q16, h4);
                int v12 = p1 == null || !p1.b ? 0x7F080148 : 0x7F08014B;  // drawable:btn_common_like_22_off
                r0.q q17 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n0, 22.0f), 22.0f);
                boolean z2 = p0.i(this);
                xc.b b2 = p0.N();
                if(z2) {
                    y2 = y1;
                    v13 = v8;
                label_203:
                    p2 = p1;
                    b2 = new xc.b(this, 0);
                    p0.l0(b2);
                }
                else {
                    y2 = y1;
                    v13 = v8;
                    if(b2 == v13) {
                        goto label_203;
                    }
                    else {
                        p2 = p1;
                    }
                }
                c1.n(androidx.compose.foundation.q.n(q17, null, b2, 7), v12, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x6000, 0, 0x7FEC);
                M.c.d(p0, androidx.compose.foundation.layout.d.q(n0, 3.0f));
                long v14 = Cc.e0.T(p0, 0x7F0604A0);  // color:white
                N1.b(String.valueOf((p2 == null ? null : p2.a)), new VerticalAlignElement(h9), v14, 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);
                M.c.d(p0, androidx.compose.foundation.layout.d.q(n0, 3.0f));
                r0.q q18 = androidx.compose.foundation.layout.a.p(n0, y2);
                boolean z3 = p0.g(x0);
                boolean z4 = p0.i(this);
                z1 z11 = p0.N();
                if(z3 || z4) {
                    v15 = v13;
                    z11 = new z1(6, x0, this);
                    p0.l0(z11);
                }
                else {
                    v15 = v13;
                    if(z11 == v15) {
                        z11 = new z1(6, x0, this);
                        p0.l0(z11);
                    }
                }
                r0.q q19 = androidx.compose.foundation.q.n(q18, null, z11, 7);
                p0 p04 = M.n0.a(b1, h6, p0, 0);
                int v16 = p0.P;
                androidx.compose.runtime.i0 i07 = p0.m();
                r0.q q20 = r0.a.d(p0, q19);
                p0.e0();
                if(p0.O) {
                    p0.l(i5);
                }
                else {
                    p0.o0();
                }
                w.x(p0, p04, h2);
                w.x(p0, i07, h3);
                if(p0.O || !q.b(p0.N(), v16)) {
                    A7.d.q(v16, p0, v16, h10);
                }
                w.x(p0, q20, h4);
                c1.n(H0.b.r(h9, androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n0, 22.0f), 22.0f)), 0x7F08012B, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x6030, 0, 0x7FEC);  // drawable:btn_common_comment_22
                M.c.d(p0, androidx.compose.foundation.layout.d.q(n0, 3.0f));
                long v17 = Cc.e0.T(p0, 0x7F0604A0);  // color:white
                N1.b((x0 == null ? "" : String.valueOf((x0 == null ? null : x0.a))), new VerticalAlignElement(h9), v17, 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);
                p0.p(true);
                p0.p(true);
                r0.q q21 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n0, 22.0f), 22.0f);
                boolean z5 = p0.i(((z)object2));
                boolean z6 = p0.i(this);
                z1 z12 = p0.N();
                if(z5 || z6 || z12 == v15) {
                    z12 = new z1(7, ((z)object2), this);
                    p0.l0(z12);
                }
                c1.n(androidx.compose.foundation.q.n(q21, null, z12, 7), 0x7F080175, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x6030, 0, 0x7FEC);  // drawable:btn_common_share_22
                l1.y(p0, true, n0, 20.0f, p0);
                p0.p(true);
                p0.p(true);
                p0.p(true);
            }
            else {
                p0.a0(0x5BBAA35D);
            }
            p0.p(false);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new xc.c(this, v, 0);
        }
    }

    public final void o(l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0x725624B5);
        int v1 = (p0.i(this) ? 4 : 2) | v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            b0 b00 = B.a.r(((x)this.getViewModel()).getUiState(), p0, 0);
            if(b00.getValue() instanceof z) {
                p0.a0(0x769C66F8);
                Object object0 = b00.getValue();
                q.e(object0, "null cannot be cast to non-null type com.melon.ui.detail.album.AlbumDetailUiState.Screen");
                U3 u30 = ((z)object0).e;
                if(u30 == null) {
                    p0.a0(1990026997);
                }
                else {
                    p0.a0(1990026998);
                    N0.M m0 = M.p.d(r0.d.a, false);
                    int v2 = p0.P;
                    androidx.compose.runtime.i0 i00 = p0.m();
                    r0.q q0 = r0.a.d(p0, androidx.compose.foundation.layout.d.c);
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
                    h h0 = j.g;
                    if(p0.O || !q.b(p0.N(), v2)) {
                        A7.d.q(v2, p0, v2, h0);
                    }
                    w.x(p0, q0, j.d);
                    T3.a((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n.a, r0.d.h), u30, 0.0f, p0, 0, 4);
                    p0.p(true);
                }
                p0.p(false);
                Object object1 = b00.getValue();
                q.e(object1, "null cannot be cast to non-null type com.melon.ui.detail.album.AlbumDetailUiState.Screen");
                U3 u31 = ((z)object1).e;
                Integer integer0 = u31 == null ? null : u31.d;
                q.d(integer0);
                De.I.V(this, ((int)integer0) <= 0, true);
            }
            else {
                p0.a0(1966920621);
            }
            p0.p(false);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new xc.c(this, v, 1);
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
        String s = bundle0.getString("argAlbumId", "");
        q.f(s, "getString(...)");
        x0.getClass();
        x0.s = s;
        x x1 = (x)this.getViewModel();
        x1.t = bundle0.getBoolean("argAutoPlay", false);
    }

    @Override  // com.melon.ui.c0
    public final void onSaveInstanceState(Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argAlbumId", ((x)this.getViewModel()).p());
        bundle0.putBoolean("argAutoPlay", ((x)this.getViewModel()).t);
    }

    @Override  // com.melon.ui.J0
    public final void onUiEvent(I4 i40) {
        String s = "";
        K k0 = null;
        q.g(i40, "event");
        if(i40 instanceof x3) {
            FragmentActivity fragmentActivity0 = this.getActivity();
            boolean z = ((x)this.getViewModel()).isLoginUser();
            this.a.getClass();
            L l0 = new L(1, this, k.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 29);
            this.a.getClass();
            c.h(((x3)i40), this, fragmentActivity0, z, null, l0);
            return;
        }
        if(i40 instanceof o3) {
            k3.d(this, ((o3)i40), this, new xc.i(0, this, k.class, "unselectAll", "unselectAll()V", 0, 0), new xc.j(1, this, k.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 0), false, 0x30);
            return;
        }
        if(i40 instanceof m2) {
            this.handleMorePopupUiEvent(((m2)i40), this, new xc.a(this, 0));
            return;
        }
        if(i40 instanceof com.melon.ui.b) {
            l0 l00 = this.getChildFragmentManager();
            q.f(l00, "getChildFragmentManager(...)");
            a.f(this, l00, ((com.melon.ui.b)i40), this.getContext(), new xc.j(1, this, k.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 1));
            return;
        }
        if(i40 instanceof G4) {
            com.melon.ui.popup.b.k(this.getContext(), this.getParentFragmentManager(), 28);
            return;
        }
        if(i40 instanceof A4) {
            this.sendUserEvent(new m(((A4)i40).a, ((A4)i40).b, null, null, 0x30));
            return;
        }
        if(i40 instanceof x4) {
            this.sendUserEvent(new com.melon.ui.i(((x4)i40).a, ((x4)i40).b));
            if(!((x4)i40).c) {
                return;
            }
            ((x)this.getViewModel()).y(false);
            return;
        }
        if(i40 instanceof C4) {
            this.sendUserEvent(new com.melon.ui.o(((C4)i40).a, "1000000563", null, 36));
            return;
        }
        if(i40 instanceof F4) {
            String s1 = ((x)this.getViewModel()).getMenuId();
            xc.j j0 = new xc.j(1, this, k.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 2);
            this.c.A(((F4)i40).a, this, s1, j0);
            return;
        }
        if(i40 instanceof z4) {
            this.sendUserEvent(new com.melon.ui.l(((z4)i40).a, ((z4)i40).b, null, 28));
            return;
        }
        if(i40 instanceof Jc.A) {
            Ub.s s2 = (Ub.s)((k8.o)(((Ma.m)k8.Y.g(MelonAppBase.Companion, "context", Ma.m.class)))).z.get();
            if(!t.a().isCarConnected() && !((Ub.t)s2).f()) {
                InstantPlayPopup instantPlayPopup0 = new InstantPlayPopup(((Jc.A)i40).a);
                l0 l01 = this.getChildFragmentManager();
                q.f(l01, "getChildFragmentManager(...)");
                instantPlayPopup0.show(l01, "InstantPlayPopup");
                return;
            }
            ToastManager.show(Cb.i.k(this, 0x7F1304B4));  // string:instant_play_other_device "기기 연동 중 상태에서는 해당 기능을 지원하지 않습니다."
            return;
        }
        if(i40 instanceof Jc.y) {
            this.sendUserEvent(new com.melon.ui.h(((Jc.y)i40).a, ((Jc.y)i40).b, null, 60));
            return;
        }
        if(i40 instanceof Jc.z) {
            this.sendUserEvent(new com.melon.ui.h(((Jc.z)i40).a, ((Jc.z)i40).b, null, 60));
            return;
        }
        if(i40 instanceof Jc.i) {
            if(((Jc.i)i40) instanceof Jc.g) {
                Object object0 = je.p.n0(((Jc.g)(((Jc.i)i40))).a, ((Jc.g)(((Jc.i)i40))).b);
                if(object0 instanceof K) {
                    k0 = (K)object0;
                }
                if(k0 == null) {
                    return;
                }
                boolean z1 = k0.k;
                LoadPgnRes loadPgnRes0 = ((Jc.g)(((Jc.i)i40))).c;
                FragmentActivity fragmentActivity1 = this.getActivity();
                if(fragmentActivity1 == null) {
                    return;
                }
                if(z1) {
                    String[] arr_s = fragmentActivity1.getResources().getStringArray(0x7F030019);  // array:more_popup_comment_my
                    q.f(arr_s, "getStringArray(...)");
                    je.n.z0(arr_s);
                }
                else {
                    new ArrayList().add("신고하기");
                }
                q.d((k0.w ? "팬톡" : "댓글"));
                com.melon.ui.popup.b.o(this.getChildFragmentManager(), new zd.k(z1, false), new xc.e(fragmentActivity1, this, k0, loadPgnRes0, 0), 12);
                return;
            }
            if(((Jc.i)i40) instanceof Jc.e) {
                int v = ((Jc.e)(((Jc.i)i40))).a;
                String s3 = ((Jc.e)(((Jc.i)i40))).b;
                if(s3 != null) {
                    s = s3;
                }
                result loadPgnRes$result0 = ((Jc.e)(((Jc.i)i40))).c.result;
                q.f(loadPgnRes$result0, "result");
                CommentConfig commentConfig0 = CommentActionImplKt.toUiModel(loadPgnRes$result0);
                q.g(commentConfig0, "config");
                v2 v20 = new v2();
                v20.setArguments(f.j(new ie.m[]{new ie.m("key_cmt_seq", ((Jc.e)(((Jc.i)i40))).d), new ie.m("key_channel_seq", v), new ie.m("key_content_ref_value", s), new ie.m("key_cmt_config", commentConfig0)}));
                v20.m(this.getParentFragment());
                return;
            }
            if(((Jc.i)i40) instanceof Jc.h) {
                com.melon.ui.popup.b.x(this.getChildFragmentManager(), this.getString(0x7F130798), this.getString(0x7F1301DE), false, false, null, null, new xc.h(this, ((Jc.i)i40)), null, null, null, 0xEF8);  // string:notice "알림"
                return;
            }
            if(!(((Jc.i)i40) instanceof Jc.f)) {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            l0 l02 = this.getChildFragmentManager();
            String s4 = this.getString(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            String s5 = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
            xc.h h0 = new xc.h(((Jc.i)i40), this);
            com.melon.ui.popup.b.d(com.melon.ui.popup.b.a, l02, s4, s5, false, false, false, null, null, null, null, h0, 0x3F8);
            return;
        }
        if(i40 instanceof B4) {
            xc.b b0 = new xc.b(this, 1);
            this.sendUserEvent(new com.melon.ui.n(((B4)i40).a, ((B4)i40).b, false, ((B4)i40).c, b0, 0x40));
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
        if(i40 instanceof x4) {
            if(((x4)i40).c) {
                ((x)this.getViewModel()).y(false);
            }
            return;
        }
        super.onUiEvent(i40);
    }

    public final void p(l l0, int v) {
        p p0 = (p)l0;
        p0.c0(2078907986);
        int v1 = (p0.i(this) ? 4 : 2) | v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            b0 b00 = B.a.r(((x)this.getViewModel()).getUiState(), p0, 0);
            if(b00.getValue() instanceof r) {
                p0.a0(-680422986);
                long v2 = Cc.e0.T(p0, 0x7F0604AA);  // color:white000s_support_high_contrast
                r0.q q0 = androidx.compose.foundation.q.f(androidx.compose.foundation.layout.d.c, v2, M.a);
                N0.M m0 = M.p.d(r0.d.a, false);
                int v3 = p0.P;
                androidx.compose.runtime.i0 i00 = p0.m();
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
                h h0 = j.g;
                if(p0.O || !q.b(p0.N(), v3)) {
                    A7.d.q(v3, p0, v3, h0);
                }
                w.x(p0, q1, j.d);
                Object object0 = b00.getValue();
                q.e(object0, "null cannot be cast to non-null type com.melon.ui.detail.album.AlbumDetailUiState.Error");
                c1.w(((r)object0).a, null, null, 0.0f, 0.0f, p0, 0, 30);
                p0.p(true);
            }
            else {
                p0.a0(0xD606DDB0);
            }
            p0.p(false);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new xc.c(this, v, 2);
        }
    }

    public final void q(l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0x78902A80);
        int v1 = v | (p0.i(this) ? 4 : 2);
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.layout.a.n(n0, 20.0f, 30.0f, 0.0f, 0.0f, 12);
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v2 = p0.P;
            androidx.compose.runtime.i0 i00 = p0.m();
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
            h h0 = j.f;
            w.x(p0, y0, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = j.d;
            w.x(p0, q1, h3);
            r0.q q2 = androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.f(n0, 1.0f), 0.0f, 0.0f, 0.0f, 10.0f, 7);
            p0 p00 = M.n0.a(M.j.a, r0.d.j, p0, 0);
            int v3 = p0.P;
            androidx.compose.runtime.i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            w.x(p0, q3, h3);
            N1.b("[Album2] - RowColumn 스크롤 테스트 섹션", null, 0L, 20.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C06, 0, 0x1FFD6);
            p0.p(true);
            boolean z = p0.i(this);
            xc.d d0 = p0.N();
            if(z || d0 == androidx.compose.runtime.k.a) {
                d0 = new xc.d(this, 1);
                p0.l0(d0);
            }
            ye.a.j(null, null, null, null, null, null, false, null, d0, p0, 0, 0x1FF);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new xc.c(this, v, 3);
        }
    }

    public final void r(int v, l l0, int v1) {
        p p0 = (p)l0;
        p0.c0(0x6C1FE048);
        int v2 = (v1 & 6) == 0 ? v1 | (p0.e(v) ? 4 : 2) : v1;
        if(p0.Q(v2 & 1, (v2 & 3) != 2)) {
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n0, 160.0f), 205.0f), (v <= 0 ? 0.0f : 8.0f), 0.0f, 0.0f, 0.0f, 14);
            p8.e e0 = p0.N();
            if(e0 == androidx.compose.runtime.k.a) {
                e0 = new p8.e(25);
                p0.l0(e0);
            }
            r0.q q1 = androidx.compose.foundation.q.f(androidx.compose.foundation.q.n(q0, null, e0, 7), Cc.e0.T(p0, 0x7F0604AA), M.a);  // color:white000s_support_high_contrast
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v3 = p0.P;
            androidx.compose.runtime.i0 i00 = p0.m();
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
            w.x(p0, y0, j.f);
            w.x(p0, i00, j.e);
            h h0 = j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            w.x(p0, q2, j.d);
            c1.n(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n0, 160.0f), 160.0f), "https://search.pstatic.net/common/?src=http%3A%2F%2Fimgnews.naver.net%2Fimage%2F5164%2F2015%2F05%2F18%2F3ddbd620468eb1ae2080d339dac8ffd9171715_99_20150518171904.jpg&type=sc960_832", null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 54, 0, 0x7FFC);
            N1.b(("\'마음\' 앨범[" + v + "]"), androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.h(n0, 18.0f), 0.0f, 3.0f, 0.0f, 0.0f, 13), 0L, 0.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30, 0, 0x1FFFC);
            N1.b("아이유", androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.h(n0, 17.0f), 0.0f, 2.0f, 0.0f, 0.0f, 13), Cc.e0.T(p0, 0x7F060149), 0.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 54, 0, 0x1FFF8);  // color:gray080e
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Id.f(this, v, v1, 4);
        }
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
    }

    public final void s(B b0, l l0, int v) {
        h h8;
        P0.i i4;
        h h7;
        P0.i i3;
        h h6;
        P0.i i2;
        h h5;
        P0.i i1;
        q.g(b0, "albumInfoUiState");
        p p0 = (p)l0;
        p0.c0(2070755315);
        int v1 = v | (p0.i(b0) ? 4 : 2) | (p0.i(this) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.layout.a.m(n0, 20.0f, 20.0f, 20.0f, 20.0f);
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v2 = p0.P;
            androidx.compose.runtime.i0 i00 = p0.m();
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
            h h0 = j.f;
            w.x(p0, y0, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = j.d;
            w.x(p0, q1, h3);
            r0.q q2 = androidx.compose.foundation.layout.d.f(n0, 1.0f);
            M.b b1 = M.j.a;
            r0.h h4 = r0.d.j;
            p0 p00 = M.n0.a(b1, h4, p0, 0);
            int v3 = p0.P;
            androidx.compose.runtime.i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            w.x(p0, q3, h3);
            String s = this.getString(0x7F130064);  // string:album_detail_title_album_introduce "앨범 소개"
            q.f(s, "getString(...)");
            N1.b(s, null, 0L, 20.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C00, 0, 0x1FFD6);
            p0.p(true);
            r0.q q4 = androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.f(n0, 1.0f), 0.0f, 8.0f, 0.0f, 0.0f, 13);
            p0 p01 = M.n0.a(b1, h4, p0, 0);
            int v4 = p0.P;
            androidx.compose.runtime.i0 i02 = p0.m();
            r0.q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                i1 = i0;
                p0.l(i1);
            }
            else {
                i1 = i0;
                p0.o0();
            }
            w.x(p0, p01, h0);
            w.x(p0, i02, h1);
            if(!p0.O && q.b(p0.N(), v4)) {
                h5 = h2;
            }
            else {
                h5 = h2;
                A7.d.q(v4, p0, v4, h5);
            }
            w.x(p0, q5, h3);
            String s1 = this.getString(0x7F130066);  // string:album_detail_title_album_type "유형"
            q.f(s1, "getString(...)");
            N1.b(s1, null, 0L, 0.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0, 0, 0x1FFFE);
            M.c.d(p0, androidx.compose.foundation.layout.d.q(n0, 10.0f));
            String s2 = b0.a;
            String s3 = "";
            if(s2 == null) {
                s2 = "";
            }
            N1.b(s2, null, 0L, 0.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0, 0, 0x1FFFE);
            p0.p(true);
            r0.q q6 = androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.f(n0, 1.0f), 0.0f, 8.0f, 0.0f, 0.0f, 13);
            p0 p02 = M.n0.a(b1, h4, p0, 0);
            int v5 = p0.P;
            androidx.compose.runtime.i0 i03 = p0.m();
            r0.q q7 = r0.a.d(p0, q6);
            p0.e0();
            if(p0.O) {
                i2 = i1;
                p0.l(i2);
            }
            else {
                i2 = i1;
                p0.o0();
            }
            w.x(p0, p02, h0);
            w.x(p0, i03, h1);
            if(!p0.O && q.b(p0.N(), v5)) {
                h6 = h5;
            }
            else {
                h6 = h5;
                A7.d.q(v5, p0, v5, h6);
            }
            w.x(p0, q7, h3);
            String s4 = this.getString(0x7F130069);  // string:album_detail_title_genre "장르"
            q.f(s4, "getString(...)");
            N1.b(s4, null, 0L, 0.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0, 0, 0x1FFFE);
            M.c.d(p0, androidx.compose.foundation.layout.d.q(n0, 10.0f));
            N1.b((b0.b == null ? "" : b0.b), null, 0L, 0.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0, 0, 0x1FFFE);
            p0.p(true);
            r0.q q8 = androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.f(n0, 1.0f), 0.0f, 8.0f, 0.0f, 0.0f, 13);
            p0 p03 = M.n0.a(b1, h4, p0, 0);
            int v6 = p0.P;
            androidx.compose.runtime.i0 i04 = p0.m();
            r0.q q9 = r0.a.d(p0, q8);
            p0.e0();
            if(p0.O) {
                i3 = i2;
                p0.l(i3);
            }
            else {
                i3 = i2;
                p0.o0();
            }
            w.x(p0, p03, h0);
            w.x(p0, i04, h1);
            if(!p0.O && q.b(p0.N(), v6)) {
                h7 = h6;
            }
            else {
                h7 = h6;
                A7.d.q(v6, p0, v6, h7);
            }
            w.x(p0, q9, h3);
            String s5 = this.getString(0x7F130068);  // string:album_detail_title_date "발매일"
            q.f(s5, "getString(...)");
            N1.b(s5, null, 0L, 0.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0, 0, 0x1FFFE);
            M.c.d(p0, androidx.compose.foundation.layout.d.q(n0, 10.0f));
            N1.b((b0.c == null ? "" : b0.c), null, 0L, 0.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0, 0, 0x1FFFE);
            p0.p(true);
            r0.q q10 = androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.f(n0, 1.0f), 0.0f, 8.0f, 0.0f, 0.0f, 13);
            p0 p04 = M.n0.a(b1, h4, p0, 0);
            int v7 = p0.P;
            androidx.compose.runtime.i0 i05 = p0.m();
            r0.q q11 = r0.a.d(p0, q10);
            p0.e0();
            if(p0.O) {
                i4 = i3;
                p0.l(i4);
            }
            else {
                i4 = i3;
                p0.o0();
            }
            w.x(p0, p04, h0);
            w.x(p0, i05, h1);
            if(!p0.O && q.b(p0.N(), v7)) {
                h8 = h7;
            }
            else {
                h8 = h7;
                A7.d.q(v7, p0, v7, h8);
            }
            w.x(p0, q11, h3);
            String s6 = this.getString(0x7F13006C);  // string:album_detail_title_publisher "발매사"
            q.f(s6, "getString(...)");
            N1.b(s6, null, 0L, 0.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0, 0, 0x1FFFE);
            M.c.d(p0, androidx.compose.foundation.layout.d.q(n0, 10.0f));
            N1.b((b0.d == null ? "" : b0.d), null, 0L, 0.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0, 0, 0x1FFFE);
            p0.p(true);
            r0.q q12 = androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.f(n0, 1.0f), 0.0f, 8.0f, 0.0f, 0.0f, 13);
            p0 p05 = M.n0.a(b1, h4, p0, 0);
            int v8 = p0.P;
            androidx.compose.runtime.i0 i06 = p0.m();
            r0.q q13 = r0.a.d(p0, q12);
            p0.e0();
            if(p0.O) {
                p0.l(i4);
            }
            else {
                p0.o0();
            }
            w.x(p0, p05, h0);
            w.x(p0, i06, h1);
            if(p0.O || !q.b(p0.N(), v8)) {
                A7.d.q(v8, p0, v8, h8);
            }
            w.x(p0, q13, h3);
            String s7 = this.getString(0x7F130062);  // string:album_detail_title_agency "기획사"
            q.f(s7, "getString(...)");
            N1.b(s7, null, 0L, 0.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0, 0, 0x1FFFE);
            M.c.d(p0, androidx.compose.foundation.layout.d.q(n0, 10.0f));
            String s8 = b0.e;
            if(s8 != null) {
                s3 = s8;
            }
            N1.b(s3, null, 0L, 0.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0, 0, 0x1FFFE);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new T7(this, b0, v, 29);
        }
    }

    @Override  // com.melon.ui.c0
    public final void setInsetHandlingType(f1 f10) {
        q.g(f10, "<set-?>");
        this.e = f10;
    }

    @Override  // com.melon.ui.k3
    public final void showContextMenuAddTo(I i0, String s, List list0, we.a a0, we.k k0, boolean z, String s1) {
        q.g(i0, "fragment");
        q.g(s, "menuId");
        q.g(list0, "playableList");
        q.g(k0, "sendUserEvent");
        this.b.showContextMenuAddTo(i0, s, list0, a0, k0, z, "");
    }
}

