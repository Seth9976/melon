package yc;

import J8.V0;
import R6.c;
import R6.d;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import androidx.fragment.app.l0;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.ResourceUtilsKt;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import com.melon.ui.A4;
import com.melon.ui.F4;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.M2;
import com.melon.ui.a;
import com.melon.ui.e;
import com.melon.ui.i;
import com.melon.ui.k3;
import com.melon.ui.m2;
import com.melon.ui.m;
import com.melon.ui.o1;
import com.melon.ui.o3;
import com.melon.ui.p3;
import com.melon.ui.x3;
import com.melon.ui.x4;
import java.util.List;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import va.e0;
import we.k;
import we.o;
import xc.j;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lyc/b;", "Lcom/melon/ui/o1;", "Lyc/E;", "LJ8/V0;", "Lcom/melon/ui/a;", "Lcom/melon/ui/k3;", "Lcom/melon/ui/M2;", "", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class b extends o1 implements M2, a, k3 {
    public final e a;
    public final p3 b;
    public final d c;
    public final c d;
    public final e.b e;
    public static final float f;

    static {
        MelonAppBase.Companion.getClass();
        b.f = ((float)ScreenUtils.getScreenHeight(t.a().getContext())) - ResourceUtilsKt.getDimension(0x7F070058) - ((float)ViewUtilsKt.dpToPx(60));  // dimen:bottom_tab_plus_miniplayer_height
    }

    public b() {
        this.a = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.b = new p3();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.c = new d(25);
        this.d = new c(26);
        this.e = H0.e.T(this, new yc.a(1, this, b.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 4));
    }

    @Override  // com.melon.ui.J0
    public final Q4.a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return V0.a(layoutInflater0, null);
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return E.class;
    }

    @Override  // com.melon.ui.a
    public final void handleAddPlayUiEvent(l0 l00, com.melon.ui.b b0, Context context0, k k0, CoroutineScope coroutineScope0) {
        q.g(b0, "event");
        q.g(coroutineScope0, "coroutineScope");
        this.a.handleAddPlayUiEvent(l00, b0, context0, k0, coroutineScope0);
    }

    @Override  // com.melon.ui.M2
    public final void handleMorePopupUiEvent(m2 m20, I i0, o o0) {
        q.g(m20, "event");
        q.g(i0, "fragment");
        this.c.handleMorePopupUiEvent(m20, i0, null);
    }

    @Override  // com.melon.ui.k3
    public final void handlePutPopupUiEvent(o3 o30, I i0, we.a a0, k k0, boolean z, we.a a1) {
        q.g(o30, "event");
        q.g(i0, "fragment");
        this.b.handlePutPopupUiEvent(o30, i0, a0, k0, z, null);
    }

    @Override  // com.melon.ui.o1
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        Bundle bundle1 = this.getArguments();
        if(bundle1 != null) {
            String s = bundle1.getString("graph_type");
            if(s != null) {
                E e0 = (E)this.getViewModel();
                e0.f = !s.equals("1h");
            }
        }
    }

    @Override  // com.melon.ui.J0
    public final void onUiEvent(I4 i40) {
        q.g(i40, "event");
        if(i40 instanceof com.melon.ui.b) {
            l0 l00 = this.getChildFragmentManager();
            q.f(l00, "getChildFragmentManager(...)");
            a.f(this, l00, ((com.melon.ui.b)i40), this.getContext(), new j(1, this, b.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 29));
            return;
        }
        if(i40 instanceof A4) {
            this.sendUserEvent(new m(((A4)i40).a, ((A4)i40).b, null, null, 0x30));
            return;
        }
        if(i40 instanceof x4) {
            this.sendUserEvent(new i(((x4)i40).a, ((x4)i40).b));
            return;
        }
        if(i40 instanceof F4) {
            String s = ((E)this.getViewModel()).getMenuId();
            yc.a a0 = new yc.a(1, this, b.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 0);
            this.c.A(((F4)i40).a, this, s, a0);
            return;
        }
        if(i40 instanceof o3) {
            k3.d(this, ((o3)i40), this, null, new yc.a(1, this, b.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 1), false, 0x30);
            return;
        }
        if(i40 instanceof x3) {
            FragmentActivity fragmentActivity0 = this.getActivity();
            boolean z = ((e0)va.o.a()).m();
            yc.a a1 = new yc.a(1, this, b.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 2);
            this.d.getClass();
            c.h(((x3)i40), this, fragmentActivity0, z, this.e, a1);
            return;
        }
        if(i40 instanceof m2) {
            this.handleMorePopupUiEvent(((m2)i40), this, null);
            return;
        }
        super.onUiEvent(i40);
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        V0 v00 = (V0)this.getBinding();
        if(v00 == null) {
            return;
        }
        ComposeView composeView0 = v00.b;
        if(Build.VERSION.SDK_INT <= 27) {
            composeView0.setLayerType(1, null);
        }
        composeView0.setContent(new m0.b(0x95BD940F, new xc.q(3, k40, this), true));
    }

    @Override  // com.melon.ui.k3
    public final void showContextMenuAddTo(I i0, String s, List list0, we.a a0, k k0, boolean z, String s1) {
        q.g(i0, "fragment");
        q.g(s, "menuId");
        q.g(list0, "playableList");
        q.g(k0, "sendUserEvent");
        this.b.showContextMenuAddTo(i0, s, list0, a0, k0, z, "");
    }
}

