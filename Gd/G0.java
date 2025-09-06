package gd;

import J8.V0;
import Q4.a;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.compose.ui.platform.ComposeView;
import com.melon.ui.K4;
import com.melon.ui.o1;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import m0.b;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lgd/g0;", "Lcom/melon/ui/o1;", "Lgd/u0;", "LJ8/V0;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class g0 extends o1 {
    @Override  // com.melon.ui.J0
    public final a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return V0.a(layoutInflater0, null);
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return u0.class;
    }

    @Override  // com.melon.ui.o1
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.requireArguments();
            q.f(bundle0, "requireArguments(...)");
        }
        u0 u00 = (u0)this.getViewModel();
        String s = bundle0.getString("argBrandDjKey");
        String s1 = "";
        if(s == null) {
            s = "";
        }
        u00.getClass();
        u00.g = s;
        u0 u01 = (u0)this.getViewModel();
        String s2 = bundle0.getString("argBrandTitle");
        if(s2 != null) {
            s1 = s2;
        }
        u01.getClass();
        u01.h = s1;
    }

    @Override  // com.melon.ui.c0
    public final void onSaveInstanceState(Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argBrandDjKey", ((u0)this.getViewModel()).g);
        bundle0.putString("argBrandTitle", ((u0)this.getViewModel()).h);
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        V0 v00 = (V0)this.getBinding();
        if(v00 != null) {
            ComposeView composeView0 = v00.b;
            if(k40 instanceof l0) {
                composeView0.setContent(new b(0x52F76B86, new f0(k40, this, 0), true));
                return;
            }
            if(k40 instanceof j0) {
                composeView0.setContent(new b(0x17B860BD, new f0(k40, this, 1), true));
                return;
            }
            if(k40 instanceof k0) {
                composeView0.setContent(new b(0xE6C4DBF, new L(k40, 1), true));
            }
        }
    }
}

