package gd;

import H8.i;
import J8.V0;
import Mc.u;
import R6.c;
import R6.d;
import X.k;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.M2;
import com.melon.ui.a;
import com.melon.ui.e;
import com.melon.ui.m2;
import com.melon.ui.x3;
import d3.g;
import e.b;
import ed.f;
import ie.j;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import va.e0;
import we.o;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u0006B\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lgd/l4;", "Lcom/melon/ui/o1;", "Lgd/B4;", "LJ8/V0;", "Lcom/melon/ui/a;", "Lcom/melon/ui/M2;", "", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class l4 extends D implements M2, a {
    public final e d;
    public final d e;
    public final c f;
    public final LogU g;
    public final i h;
    public final b i;

    public l4() {
        this.d = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.e = new d(25);
        this.f = new c(26);
        LogU logU0 = new LogU("MelonDjPopularPlaylistFragment");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.g = logU0;
        k k0 = new k(new f(this, 15), 17);
        j j0 = g.P(ie.k.c, k0);
        De.d d0 = I.a.b(i4.class);
        u u0 = new u(j0, 4);
        u u1 = new u(j0, 5);
        this.h = new i(d0, u0, new k4(0, this, j0), u1);
        this.i = H0.e.T(this, new j3(1, this, l4.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 21));
    }

    @Override  // com.melon.ui.J0
    public final Q4.a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return V0.a(layoutInflater0, null);
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return B4.class;
    }

    @Override  // com.melon.ui.a
    public final void handleAddPlayUiEvent(l0 l00, com.melon.ui.b b0, Context context0, we.k k0, CoroutineScope coroutineScope0) {
        q.g(b0, "event");
        q.g(coroutineScope0, "coroutineScope");
        this.d.handleAddPlayUiEvent(l00, b0, context0, k0, coroutineScope0);
    }

    @Override  // com.melon.ui.M2
    public final void handleMorePopupUiEvent(m2 m20, androidx.fragment.app.I i0, o o0) {
        q.g(m20, "event");
        q.g(i0, "fragment");
        this.e.handleMorePopupUiEvent(m20, i0, null);
    }

    @Override  // com.melon.ui.o1
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.getArguments();
        }
        if(bundle0 != null) {
            B4 b40 = (B4)this.getViewModel();
            String s = bundle0.getString("argSortType", "D");
            q.f(s, "getString(...)");
            b40.getClass();
            b40.g = s;
        }
    }

    @Override  // com.melon.ui.c0
    public final void onSaveInstanceState(Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        String s = va.e.b("onSaveInstanceState() sortType: ", ((B4)this.getViewModel()).g);
        LogU.debug$default(this.g, s, null, false, 6, null);
        bundle0.putString("argSortType", ((B4)this.getViewModel()).g);
    }

    @Override  // com.melon.ui.J0
    public final void onUiEvent(I4 i40) {
        q.g(i40, "event");
        if(i40 instanceof s4) {
            String s = ((B4)this.getViewModel()).getMenuId();
            String s1 = e1.u.v(((e0)((B4)this.getViewModel()).b).j());
            zd.q q0 = new zd.q(((s4)i40).a, ((s4)i40).b, ((s4)i40).c, ((s4)i40).d, ((s4)i40).e, ((s4)i40).f, s, ((s4)i40).g, ((s4)i40).h, s1, ((s4)i40).i, true);
            l l0 = new l(19, this, q0);
            this.e.z(this, q0, l0);
            return;
        }
        if(i40 instanceof com.melon.ui.e0) {
            ((i4)this.h.getValue()).f.put(((B4)this.getViewModel()).g, ((com.melon.ui.e0)i40).a);
            return;
        }
        if(i40 instanceof com.melon.ui.b) {
            l0 l00 = this.getChildFragmentManager();
            q.f(l00, "getChildFragmentManager(...)");
            a.f(this, l00, ((com.melon.ui.b)i40), this.getContext(), new j3(1, this, l4.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 18));
            return;
        }
        if(i40 instanceof x3) {
            FragmentActivity fragmentActivity0 = this.getActivity();
            ((B4)this.getViewModel()).getClass();
            boolean z = ((e0)va.o.a()).m();
            j3 j30 = new j3(1, this, l4.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 19);
            this.f.getClass();
            c.h(((x3)i40), this, fragmentActivity0, z, this.i, j30);
            return;
        }
        super.onUiEvent(i40);
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        V0 v00 = (V0)this.getBinding();
        if(v00 != null) {
            ComposeView composeView0 = v00.b;
            String s = "renderUi() uiState: " + Cb.i.o(k40);
            LogU.info$default(this.g, s, null, false, 6, null);
            if(k40 instanceof v4) {
                B4 b40 = (B4)this.getViewModel();
                androidx.lifecycle.D d0 = this.getViewLifecycleOwner();
                q.f(d0, "getViewLifecycleOwner(...)");
                composeView0.setViewCompositionStrategy(new I7.c(d0));
                composeView0.setContent(new m0.b(0x47F049D4, new j4(k40, this, 0), true));
                return;
            }
            if(k40 instanceof t4) {
                composeView0.setContent(new m0.b(-1300010755, new j4(k40, this, 1), true));
                return;
            }
            if(k40 instanceof u4) {
                composeView0.setContent(new m0.b(0xC82D77FF, new L(k40, 11), true));
            }
        }
    }
}

