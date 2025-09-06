package gd;

import F8.o;
import J8.W0;
import Q4.a;
import Ud.j;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.compose.ui.platform.ComposeView;
import com.iloen.melon.custom.title.TitleBar;
import com.melon.ui.K4;
import com.melon.ui.o1;
import d3.g;
import ed.f;
import ie.r;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import m0.b;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lgd/s5;", "Lcom/melon/ui/o1;", "Lgd/P5;", "LJ8/W0;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class s5 extends o1 {
    public final r a;

    public s5() {
        this.a = g.Q(new r5(0));
    }

    @Override  // com.melon.ui.J0
    public final a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return W0.a(layoutInflater0);
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return P5.class;
    }

    @Override  // com.melon.ui.c0
    public final boolean isShowTabAndMiniPlayer() {
        return false;
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
        String s = this.getString(0x7F130646);  // string:melondj_dj_subscription_title "DJ 신청하기"
        ((TitleBar)w00.c.c).setTitle(s);
        ((TitleBar)w00.c.c).f(true);
        j j0 = (j)this.a.getValue();
        f f0 = new f(this, 17);
        j.a(j0, ((TitleBar)w00.c.c), f0);
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        W0 w00 = (W0)this.getBinding();
        if(w00 != null) {
            ComposeView composeView0 = w00.b;
            if(k40 instanceof F5) {
                composeView0.setContent(new b(1540832588, new q5(k40, this, 0), true));
                return;
            }
            if(k40 instanceof D5) {
                composeView0.setContent(new b(0x7DFB8EC3, new q5(k40, this, 1), true));
                return;
            }
            if(k40 instanceof E5) {
                composeView0.setContent(new b(0x64158745, new L(k40, 13), true));
            }
        }
    }
}

