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
import dd.v;
import ed.f;
import ie.r;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import m0.b;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lgd/w0;", "Lcom/melon/ui/o1;", "Lgd/F0;", "LJ8/W0;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class w0 extends o1 {
    public final r a;

    public w0() {
        this.a = g.Q(new v(18));
    }

    @Override  // com.melon.ui.J0
    public final a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return W0.a(layoutInflater0);
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return F0.class;
    }

    @Override  // com.melon.ui.o1
    public final void onCreate(Bundle bundle0) {
        String s1;
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.getArguments();
        }
        F0 f00 = (F0)this.getViewModel();
        String s = "";
        if(bundle0 == null) {
            s1 = "";
        }
        else {
            s1 = bundle0.getString("argBrandDjKey");
            if(s1 == null) {
                s1 = "";
            }
        }
        f00.getClass();
        f00.c = s1;
        F0 f01 = (F0)this.getViewModel();
        if(bundle0 != null) {
            String s2 = bundle0.getString("argBrandTitle");
            if(s2 != null) {
                s = s2;
            }
        }
        f01.getClass();
        f01.d = s;
    }

    @Override  // com.melon.ui.c0
    public final void onSaveInstanceState(Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        String s = ((F0)this.getViewModel()).c;
        if(s != null) {
            bundle0.putString("argBrandDjKey", s);
            String s1 = ((F0)this.getViewModel()).d;
            if(s1 != null) {
                bundle0.putString("argBrandTitle", s1);
                return;
            }
            q.m("brandDjTitle");
            throw null;
        }
        q.m("brandDjKey");
        throw null;
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
        String s = this.getString(0x7F13064B);  // string:melondj_magazine "매거진"
        ((TitleBar)w00.c.c).setTitle(s);
        j j0 = (j)this.a.getValue();
        f f0 = new f(this, 7);
        j.a(j0, ((TitleBar)w00.c.c), f0);
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        W0 w00 = (W0)this.getBinding();
        if(w00 != null) {
            ComposeView composeView0 = w00.b;
            if(k40 instanceof B0) {
                composeView0.setContent(new b(-1791601402, new v0(k40, this, 0), true));
                return;
            }
            if(k40 instanceof z0) {
                composeView0.setContent(new b(0xBF8C24BD, new v0(k40, this, 1), true));
                return;
            }
            if(k40 instanceof A0) {
                composeView0.setContent(new b(0x870A04BF, new L(k40, 2), true));
            }
        }
    }
}

