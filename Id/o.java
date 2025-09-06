package id;

import Cc.N1;
import Cc.c1;
import Cc.e0;
import Hd.B;
import J8.W0;
import M.y;
import N0.M;
import P0.h;
import P0.i;
import P0.j;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.E;
import androidx.compose.runtime.V;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.fragment.app.l0;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.player.playlist.mixup.composables.c;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.a;
import com.melon.ui.e;
import d3.g;
import ed.D;
import gd.T7;
import gd.r5;
import hd.U1;
import ie.r;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import r0.n;
import we.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t²\u0006\f\u0010\b\u001A\u00020\u00078\nX\u008A\u0084\u0002"}, d2 = {"Lid/o;", "Lcom/melon/ui/o1;", "Lid/w;", "LJ8/W0;", "Lcom/melon/ui/a;", "<init>", "()V", "", "isDeleteButtonShow", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class o extends b implements a {
    public final e d;
    public final r e;

    public o() {
        this.d = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        new LogU("MusicSearchHistoryFragment").setCategory(Category.UI);
        this.e = g.Q(new r5(9));
    }

    @Override  // com.melon.ui.o1
    public final String getPvDummyLogAction() {
        return "searchMusicResultRecord";
    }

    @Override  // com.melon.ui.J0
    public final Q4.a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return W0.a(layoutInflater0);
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return w.class;
    }

    @Override  // com.melon.ui.a
    public final void handleAddPlayUiEvent(l0 l00, com.melon.ui.b b0, Context context0, k k0, CoroutineScope coroutineScope0) {
        q.g(b0, "event");
        q.g(coroutineScope0, "coroutineScope");
        this.d.handleAddPlayUiEvent(l00, b0, context0, k0, coroutineScope0);
    }

    @Override  // com.melon.ui.c0
    public final boolean isShowTabAndMiniPlayer() {
        return false;
    }

    public final void n(ArrayList arrayList0, l l0, int v) {
        ((p)l0).c0(0x4AAF3697);
        int v1 = (((p)l0).i(arrayList0) ? 4 : 2) | v | (((p)l0).i(this) ? 0x20 : 16);
        if(((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            E e0 = ((p)l0).N();
            V v2 = androidx.compose.runtime.k.a;
            if(e0 == v2) {
                e0 = androidx.compose.runtime.w.i(new B(2, arrayList0));
                ((p)l0).l0(e0);
            }
            FillElement fillElement0 = d.c;
            boolean z = ((p)l0).i(arrayList0);
            boolean z1 = ((p)l0).i(this);
            c c0 = ((p)l0).N();
            if(z || z1 || c0 == v2) {
                c0 = new c(arrayList0, this, e0, 16);
                ((p)l0).l0(c0);
            }
            c1.o(fillElement0, null, null, false, null, null, null, false, c0, ((p)l0), 6, 0xFE);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new T7(this, arrayList0, v, 11);
        }
    }

    public final void o(we.a a0, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(-898012643);
        int v1 = (p0.i(a0) ? 4 : 2) | v | (p0.i(this) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            n n0 = n.a;
            r0.q q0 = d.h(d.f(n0, 1.0f), 77.0f);
            M m0 = M.p.d(r0.d.b, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = j.f;
            androidx.compose.runtime.w.x(p0, m0, h0);
            h h1 = j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v3 = p0.P;
            i0 i01 = p0.m();
            r0.q q2 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            androidx.compose.runtime.w.x(p0, q2, h3);
            M.c.d(p0, d.h(n0, 11.0f));
            r0.q q3 = d.h(d.q(n0, 157.0f), 35.0f);
            androidx.compose.foundation.y y1 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F060152), 0.5f);  // color:gray200a
            T.d d0 = T.e.b(100.0f);
            r0.q q4 = d.t(r0.a.a(androidx.compose.foundation.q.j(q3, y1.a, y1.b, d0), new D(12, a0)), 2);
            String s = this.getString(0x7F1302E6);  // string:delete_all "전체 삭제"
            q.f(s, "getString(...)");
            N1.b(s, q4, e0.T(p0, 0x7F060165), 15.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FDF0);  // color:gray800s
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new T7(this, a0, v, 12);
        }
    }

    @Override  // com.melon.ui.J0
    public final void onUiEvent(I4 i40) {
        q.g(i40, "event");
        if(i40 instanceof com.melon.ui.b) {
            l0 l00 = this.getChildFragmentManager();
            q.f(l00, "getChildFragmentManager(...)");
            a.f(this, l00, ((com.melon.ui.b)i40), this.getContext(), new U1(1, this, o.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 6));
            return;
        }
        super.onUiEvent(i40);
    }

    @Override  // com.melon.ui.J0
    public final void onViewCreated(View view0, Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        W0 w00 = (W0)this.getBinding();
        if(w00 == null) {
            return;
        }
        F8.o o0 = B.a.s(1);
        ((TitleBar)w00.c.c).a(o0);
        ((TitleBar)w00.c.c).setTitle("검색 기록");
        ((TitleBar)w00.c.c).f(true);
        Ud.j j0 = (Ud.j)this.e.getValue();
        m m0 = new m(this, 0);
        Ud.j.a(j0, ((TitleBar)w00.c.c), m0);
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        W0 w00 = (W0)this.getBinding();
        if(w00 != null) {
            s s0 = k40 instanceof s ? ((s)k40) : null;
            if(s0 != null) {
                m0.b b0 = new m0.b(0x98138123, new T7(10, s0, this), true);
                w00.b.setContent(b0);
            }
        }
    }
}

