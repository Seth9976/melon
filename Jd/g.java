package jd;

import Cc.N1;
import Cc.e0;
import J8.V0;
import M.n0;
import M.p0;
import Nc.C1;
import P0.h;
import P0.i;
import P0.k;
import Q4.a;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import com.iloen.melon.net.v6x.response.EventPopupUiModel;
import com.melon.ui.J0;
import com.melon.ui.K4;
import e1.y;
import gd.T7;
import kotlin.jvm.internal.q;
import m0.b;
import r0.n;

public final class g extends J0 {
    public final EventPopupUiModel a;

    public g(EventPopupUiModel eventPopupUiModel0) {
        q.g(eventPopupUiModel0, "event");
        super();
        this.a = eventPopupUiModel0;
    }

    @Override  // com.melon.ui.c0
    public final boolean getShouldIgnoreForegroundEvent() {
        return true;
    }

    @Override  // com.melon.ui.c0
    public final boolean getShouldIgnoreSetOrientation() {
        return true;
    }

    @Override  // com.melon.ui.J0
    public final a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return V0.a(layoutInflater0, null);
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return j.class;
    }

    @Override  // com.melon.ui.c0
    public final boolean isShowTabAndMiniPlayer() {
        return false;
    }

    public final void m(String s, l l0, int v) {
        q.g(s, "caution");
        p p0 = (p)l0;
        p0.c0(-1219993304);
        int v1 = v | (p0.g(s) ? 4 : 2) | (p0.i(this) ? 0x20 : 16);
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            r0.q q0 = d.f(n.a, 1.0f);
            p0 p00 = n0.a(M.j.a, r0.d.j, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            k.y.getClass();
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
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q1, P0.j.d);
            String s1 = this.getString(0x7F13085C);  // string:precautions_dot "ㆍ"
            q.f(s1, "getString(...)");
            N1.b(s1, null, e0.T(p0, 0x7F060166), 13.0f, null, null, 0L, null, 20.0f, 0, false, 0, 0, null, null, p0, 0xC00, 6, 0x1FBF2);  // color:gray801s
            N1.b(s, null, e0.T(p0, 0x7F060166), 13.0f, null, null, 0L, null, 20.0f, 0, false, 0, 0, null, null, p0, v1 & 14 | 0xC00, 6, 0x1FBF2);  // color:gray801s
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new T7(this, s, v, 14);
        }
    }

    public final void n(String s, String s1, int v, l l0, int v1, int v2) {
        int v6;
        q.g(s1, "value");
        p p0 = (p)l0;
        p0.c0(2122566301);
        int v3 = (p0.g(s) ? 4 : 2) | v1 | (p0.g(s1) ? 0x20 : 16);
        if((v2 & 4) != 0) {
            v3 |= 0x180;
        }
        else if((v1 & 0x180) == 0) {
            v3 |= (p0.e(v) ? 0x100 : 0x80);
        }
        if(p0.Q(v3 & 1, (v3 & 0x93) != 0x92)) {
            int v4 = (v2 & 4) == 0 ? v : 1;
            n n0 = n.a;
            r0.q q0 = d.f(n0, 1.0f);
            p0 p00 = n0.a(M.j.a, r0.d.j, p0, 0);
            int v5 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            k.y.getClass();
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
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h0);
            }
            w.x(p0, q1, P0.j.d);
            N1.b(s, null, e0.T(p0, 0x7F06016D), 14.0f, y.i, null, 0L, null, 23.0f, 2, false, v4, 0, null, null, p0, v3 & 14 | 0x30C00, v3 << 3 & 0x1C00 | 54, 0x1D3D2);  // color:gray900s
            N1.b(s1, null, A7.d.g(n0, 12.0f, p0, 0x7F060165, p0), 14.0f, null, null, 0L, null, 23.0f, 0, false, 0, 0, null, null, p0, v3 >> 3 & 14 | 0xC00, 6, 0x1FBF2);  // color:gray800s
            p0.p(true);
            v6 = v4;
        }
        else {
            p0.T();
            v6 = v;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new C1(this, s, s1, v6, v1, v2);
        }
    }

    @Override  // com.melon.ui.J0
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        j j0 = (j)this.getViewModel();
        j0.getClass();
        q.g(this.a, "uiModel");
        j0.updateUiState(new hd.i(this.a, 8));
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        if(k40 instanceof jd.i) {
            V0 v00 = (V0)this.getBinding();
            if(v00 != null) {
                b b0 = new b(0x5D45C69C, new T7(13, this, k40), true);
                v00.b.setContent(b0);
            }
        }
    }

    @Override  // com.melon.ui.c0
    public final void setShouldIgnoreForegroundEvent(boolean z) {
    }

    @Override  // com.melon.ui.c0
    public final void setShouldIgnoreSetOrientation(boolean z) {
    }
}

