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
import com.melon.ui.G4;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.o1;
import com.melon.ui.popup.b;
import d3.g;
import dd.v;
import ed.f;
import ie.r;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lgd/c1;", "Lcom/melon/ui/o1;", "Lgd/r1;", "LJ8/W0;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class c1 extends o1 {
    public final r a;

    public c1() {
        this.a = g.Q(new v(20));
    }

    @Override  // com.melon.ui.J0
    public final a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return W0.a(layoutInflater0);
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return r1.class;
    }

    @Override  // com.melon.ui.o1
    public final void onCreate(Bundle bundle0) {
        String s1;
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.getArguments();
        }
        r1 r10 = (r1)this.getViewModel();
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
        r10.getClass();
        r10.g = s1;
        r1 r11 = (r1)this.getViewModel();
        if(bundle0 != null) {
            String s2 = bundle0.getString("argBrandTitle");
            if(s2 != null) {
                s = s2;
            }
        }
        r11.getClass();
        r11.h = s;
    }

    @Override  // com.melon.ui.c0
    public final void onSaveInstanceState(Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        String s = ((r1)this.getViewModel()).g;
        if(s != null) {
            bundle0.putString("argBrandDjKey", s);
            String s1 = ((r1)this.getViewModel()).h;
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
    public final void onUiEvent(I4 i40) {
        q.g(i40, "event");
        if(i40 instanceof G4) {
            b.k(this.getContext(), this.getParentFragmentManager(), 16);
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
        String s = this.getString(0x7F130171);  // string:artist_recommend "추천 아티스트"
        ((TitleBar)w00.c.c).setTitle(s);
        j j0 = (j)this.a.getValue();
        f f0 = new f(this, 8);
        j.a(j0, ((TitleBar)w00.c.c), f0);
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        W0 w00 = (W0)this.getBinding();
        if(w00 != null) {
            ComposeView composeView0 = w00.b;
            if(k40 instanceof i1) {
                composeView0.setContent(new m0.b(-1586618802, new b1(k40, this, 0), true));
                return;
            }
            if(k40 instanceof g1) {
                composeView0.setContent(new m0.b(0x39C6A1C5, new b1(k40, this, 1), true));
                return;
            }
            if(k40 instanceof h1) {
                composeView0.setContent(new m0.b(0x53335647, new L(k40, 4), true));
            }
        }
    }
}

