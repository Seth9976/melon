package gd;

import J8.W0;
import R6.c;
import R6.d;
import Ud.j;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import androidx.fragment.app.l0;
import com.iloen.melon.custom.title.TitleBar;
import com.melon.ui.H4;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.M2;
import com.melon.ui.a;
import com.melon.ui.e;
import com.melon.ui.m2;
import com.melon.ui.o1;
import com.melon.ui.x3;
import d3.g;
import dd.v;
import e.b;
import e1.u;
import ie.r;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import va.e0;
import we.k;
import we.o;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u0006B\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lgd/k3;", "Lcom/melon/ui/o1;", "Lgd/E3;", "LJ8/W0;", "Lcom/melon/ui/M2;", "Lcom/melon/ui/a;", "", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class k3 extends o1 implements M2, a {
    public final d a;
    public final e b;
    public final c c;
    public final b d;
    public final r e;

    public k3() {
        this.a = new d(25);
        this.b = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.c = new c(26);
        this.d = H0.e.T(this, new j3(1, this, k3.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 4));
        this.e = g.Q(new v(25));
    }

    @Override  // com.melon.ui.J0
    public final Q4.a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return W0.a(layoutInflater0);
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return E3.class;
    }

    @Override  // com.melon.ui.a
    public final void handleAddPlayUiEvent(l0 l00, com.melon.ui.b b0, Context context0, k k0, CoroutineScope coroutineScope0) {
        q.g(b0, "event");
        q.g(coroutineScope0, "coroutineScope");
        this.b.handleAddPlayUiEvent(l00, b0, context0, k0, coroutineScope0);
    }

    @Override  // com.melon.ui.M2
    public final void handleMorePopupUiEvent(m2 m20, I i0, o o0) {
        q.g(m20, "event");
        q.g(i0, "fragment");
        this.a.handleMorePopupUiEvent(m20, i0, null);
    }

    @Override  // com.melon.ui.o1
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.getArguments();
        }
        E3 e30 = (E3)this.getViewModel();
        e30.g = bundle0 == null ? 0 : bundle0.getInt("argSortType", 0);
    }

    @Override  // com.melon.ui.c0
    public final void onSaveInstanceState(Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putInt("argSortType", ((E3)this.getViewModel()).g);
    }

    @Override  // com.melon.ui.J0
    public final void onUiEvent(I4 i40) {
        q.g(i40, "event");
        if(i40 instanceof H4) {
            l0 l00 = this.getChildFragmentManager();
            String s = this.getString(0x7F1307D1);  // string:order_by "정렬"
            q.f(s, "getString(...)");
            l l0 = new l(12, this, i40);
            com.melon.ui.popup.b.g(l00, s, true, ((H4)i40).b, ((H4)i40).a, l0);
            return;
        }
        if(i40 instanceof s3) {
            String s1 = ((E3)this.getViewModel()).getMenuId();
            String s2 = u.v(((e0)((E3)this.getViewModel()).f).j());
            zd.q q0 = new zd.q(((s3)i40).a, ((s3)i40).b, ((s3)i40).c, ((s3)i40).d, ((s3)i40).e, ((s3)i40).f, s1, ((s3)i40).g, ((s3)i40).h, s2, ((s3)i40).i, ((s3)i40).j);
            l l1 = new l(13, this, q0);
            this.a.z(this, q0, l1);
            return;
        }
        if(i40 instanceof x3) {
            FragmentActivity fragmentActivity0 = this.getActivity();
            boolean z = ((e0)((E3)this.getViewModel()).f).m();
            j3 j30 = new j3(1, this, k3.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 0);
            this.c.getClass();
            c.h(((x3)i40), this, fragmentActivity0, z, this.d, j30);
            return;
        }
        if(i40 instanceof com.melon.ui.b) {
            l0 l01 = this.getChildFragmentManager();
            q.f(l01, "getChildFragmentManager(...)");
            a.f(this, l01, ((com.melon.ui.b)i40), this.getContext(), new j3(1, this, k3.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 1));
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
        String s = this.getString(0x7F13064E);  // string:melondj_melgun_djplaylist "플레이리스트"
        ((TitleBar)w00.c.c).setTitle(s);
        j j0 = (j)this.e.getValue();
        h3 h30 = new h3(this, 0);
        j.a(j0, ((TitleBar)w00.c.c), h30);
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        W0 w00 = (W0)this.getBinding();
        if(w00 != null) {
            ComposeView composeView0 = w00.b;
            if(k40 instanceof v3) {
                composeView0.setContent(new m0.b(0x68CD7D86, new i3(k40, this, 0), true));
                return;
            }
            if(k40 instanceof t3) {
                composeView0.setContent(new m0.b(0xC0CFA63D, new i3(k40, this, 1), true));
                return;
            }
            if(k40 instanceof u3) {
                composeView0.setContent(new m0.b(0xC4F6643F, new L(k40, 9), true));
            }
        }
    }
}

