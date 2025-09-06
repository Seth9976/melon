package gd;

import F8.o;
import H0.e;
import J8.W0;
import Q4.a;
import Ud.j;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import cd.V2;
import com.iloen.melon.custom.title.TitleBar;
import com.melon.ui.I4;
import com.melon.ui.J0;
import com.melon.ui.K4;
import d3.g;
import ed.f;
import ie.r;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import m0.b;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lgd/w5;", "Lcom/melon/ui/J0;", "Lgd/C5;", "LJ8/W0;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class w5 extends J0 {
    public final r a;

    public w5() {
        this.a = g.Q(new r5(1));
    }

    @Override  // com.melon.ui.J0
    public final a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return W0.a(layoutInflater0);
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return C5.class;
    }

    @Override  // com.melon.ui.c0
    public final boolean isShowTabAndMiniPlayer() {
        return false;
    }

    @Override  // com.melon.ui.J0
    public final void onUiEvent(I4 i40) {
        q.g(i40, "event");
        if(i40 instanceof x5) {
            e.w(this);
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
        o o0 = B.a.s(1);
        ((TitleBar)w00.c.c).a(o0);
        String s = this.getString(0x7F130632);  // string:melondj_dj_subscription_result "DJ 신청 결과보기"
        ((TitleBar)w00.c.c).setTitle(s);
        ((TitleBar)w00.c.c).f(true);
        j j0 = (j)this.a.getValue();
        f f0 = new f(this, 18);
        j.a(j0, ((TitleBar)w00.c.c), f0);
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        W0 w00 = (W0)this.getBinding();
        if(w00 != null && k40 instanceof y5) {
            b b0 = new b(0x2E0558E6, new V2(this, 10), true);
            w00.b.setContent(b0);
        }
    }
}

