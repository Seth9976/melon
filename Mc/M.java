package Mc;

import Cc.c1;
import E9.h;
import J8.V0;
import M.j0;
import O.F;
import Oc.c;
import Oc.o;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.fragment.app.l0;
import com.iloen.melon.custom.f1;
import com.iloen.melon.utils.system.ScreenUtils;
import com.melon.ui.A4;
import com.melon.ui.B4;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.a;
import com.melon.ui.b;
import com.melon.ui.e;
import com.melon.ui.n;
import com.melon.ui.w4;
import com.melon.ui.y4;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import we.k;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"LMc/m;", "Lcom/melon/ui/o1;", "LOc/o;", "LJ8/V0;", "Lcom/melon/ui/a;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class m extends O implements a {
    public final e d;
    public f1 e;

    public m() {
        this.d = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.e = f1.b;
    }

    @Override  // com.melon.ui.c0
    public final f1 getInsetHandlingType() {
        return this.e;
    }

    @Override  // com.melon.ui.J0
    public final Q4.a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return V0.a(layoutInflater0, null);
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return o.class;
    }

    @Override  // com.melon.ui.a
    public final void handleAddPlayUiEvent(l0 l00, b b0, Context context0, k k0, CoroutineScope coroutineScope0) {
        q.g(b0, "event");
        q.g(coroutineScope0, "coroutineScope");
        this.d.handleAddPlayUiEvent(l00, b0, context0, k0, coroutineScope0);
    }

    public final void n(r0.q q0, c c0, F f0, boolean z, boolean z1, l l0, int v) {
        ((p)l0).c0(1267983580);
        int v1 = v | (((p)l0).g(q0) ? 4 : 2) | (((p)l0).i(c0) ? 0x20 : 16) | (((p)l0).g(f0) ? 0x100 : 0x80) | (((p)l0).h(z) ? 0x800 : 0x400) | (((p)l0).h(z1) ? 0x4000 : 0x2000);
        int v2 = 0;
        if(((p)l0).Q(v1 & 1, (v1 & 9363) != 9362)) {
            j0 j00 = androidx.compose.foundation.layout.a.c(0.0f, 19.0f, 0.0f, h.t(((p)l0), 0x7F070058), 5);  // dimen:bottom_tab_plus_miniplayer_height
            boolean z2 = ((p)l0).i(c0);
            if((0xE000 & v1) == 0x4000) {
                v2 = 1;
            }
            Mc.k k0 = ((p)l0).N();
            if(((v1 & 0x1C00) == 0x800 | z2 | v2) != 0 || k0 == androidx.compose.runtime.k.a) {
                k0 = new Mc.k(c0, z, z1);
                ((p)l0).l0(k0);
            }
            c1.o(q0, f0, j00, false, null, null, null, false, k0, ((p)l0), v1 & 14 | v1 >> 3 & 0x70, 0xF8);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new Cc.k(this, q0, c0, f0, z, z1, v);
        }
    }

    @Override  // com.melon.ui.J0
    public final void onConfigurationChanged(Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        this.renderUi(((K4)((o)this.getViewModel()).getUiState().getValue()));
    }

    @Override  // com.melon.ui.o1
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.requireArguments();
            q.f(bundle0, "requireArguments(...)");
        }
        o o0 = (o)this.getViewModel();
        String s = bundle0.getString("argGenreCode", "");
        q.f(s, "getString(...)");
        o0.getClass();
        o0.c = s;
    }

    @Override  // com.melon.ui.c0
    public final void onSaveInstanceState(Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argGenreCode", ((o)this.getViewModel()).f());
    }

    @Override  // com.melon.ui.J0
    public final void onUiEvent(I4 i40) {
        q.g(i40, "event");
        if(i40 instanceof B4) {
            this.sendUserEvent(new n(((B4)i40).a, ((B4)i40).b, false, false, null, 0x7C));
            return;
        }
        if(i40 instanceof y4) {
            this.sendUserEvent(new com.melon.ui.k(((y4)i40).a, ((y4)i40).b, ((y4)i40).c, 0x20));
            return;
        }
        if(i40 instanceof w4) {
            this.sendUserEvent(new com.melon.ui.h(((w4)i40).a, ((w4)i40).b, ((w4)i40).c, 0x30));
            return;
        }
        if(i40 instanceof A4) {
            this.sendUserEvent(new com.melon.ui.m(((A4)i40).a, ((A4)i40).b, ((A4)i40).c, null, 0x30));
            return;
        }
        if(i40 instanceof b) {
            l0 l00 = this.getChildFragmentManager();
            q.f(l00, "getChildFragmentManager(...)");
            a.f(this, l00, ((b)i40), this.getContext(), new Kc.c(1, this, m.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 9));
            return;
        }
        super.onUiEvent(i40);
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        boolean z = ScreenUtils.isTablet(this.getContext());
        boolean z1 = ScreenUtils.isOrientationPortrait(this.getContext());
        V0 v00 = (V0)this.getBinding();
        if(v00 != null) {
            m0.b b0 = new m0.b(0xF20920A1, new i(v00.b, k40, this, z, z1), true);
            v00.b.setContent(b0);
        }
    }

    @Override  // com.melon.ui.c0
    public final void setInsetHandlingType(f1 f10) {
        q.g(f10, "<set-?>");
        this.e = f10;
    }
}

