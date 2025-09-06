package gd;

import F8.o;
import J8.W0;
import Ud.j;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.l0;
import com.iloen.melon.custom.title.TitleBar;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.a;
import com.melon.ui.b;
import com.melon.ui.e;
import com.melon.ui.o1;
import d3.g;
import dd.v;
import ed.f;
import ie.r;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import we.k;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lgd/p2;", "Lcom/melon/ui/o1;", "Lgd/y2;", "LJ8/W0;", "Lcom/melon/ui/a;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class p2 extends o1 implements a {
    public final e a;
    public final r b;

    public p2() {
        this.a = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.b = g.Q(new v(23));
    }

    @Override  // com.melon.ui.J0
    public final Q4.a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return W0.a(layoutInflater0);
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return y2.class;
    }

    @Override  // com.melon.ui.a
    public final void handleAddPlayUiEvent(l0 l00, b b0, Context context0, k k0, CoroutineScope coroutineScope0) {
        q.g(b0, "event");
        q.g(coroutineScope0, "coroutineScope");
        this.a.handleAddPlayUiEvent(l00, b0, context0, k0, coroutineScope0);
    }

    @Override  // com.melon.ui.o1
    public final void onCreate(Bundle bundle0) {
        String s1;
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.getArguments();
        }
        y2 y20 = (y2)this.getViewModel();
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
        y20.getClass();
        y20.e = s1;
        y2 y21 = (y2)this.getViewModel();
        if(bundle0 != null) {
            String s2 = bundle0.getString("argBrandTitle");
            if(s2 != null) {
                s = s2;
            }
        }
        y21.getClass();
        y21.f = s;
    }

    @Override  // com.melon.ui.c0
    public final void onSaveInstanceState(Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        String s = ((y2)this.getViewModel()).e;
        if(s != null) {
            bundle0.putString("argBrandDjKey", s);
            String s1 = ((y2)this.getViewModel()).f;
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
        if(i40 instanceof b) {
            l0 l00 = this.getChildFragmentManager();
            q.f(l00, "getChildFragmentManager(...)");
            a.f(this, l00, ((b)i40), this.getContext(), new Z0(1, this, p2.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 19));
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
        String s = this.getString(0x7F1310EE);  // string:video "비디오"
        ((TitleBar)w00.c.c).setTitle(s);
        j j0 = (j)this.b.getValue();
        f f0 = new f(this, 11);
        j.a(j0, ((TitleBar)w00.c.c), f0);
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        W0 w00 = (W0)this.getBinding();
        if(w00 != null) {
            ComposeView composeView0 = w00.b;
            if(k40 instanceof u2) {
                composeView0.setContent(new m0.b(-623671906, new o2(k40, this, 0), true));
                return;
            }
            if(k40 instanceof s2) {
                composeView0.setContent(new m0.b(0x2ED12A95, new o2(k40, this, 1), true));
                return;
            }
            if(k40 instanceof t2) {
                composeView0.setContent(new m0.b(0x622FB417, new L(k40, 7), true));
            }
        }
    }
}

