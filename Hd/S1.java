package hd;

import Cc.c1;
import F8.o;
import Hd.F0;
import Id.h;
import J8.W0;
import M.j0;
import O.F;
import Ud.j;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.fragment.app.l0;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.B4;
import com.melon.ui.D4;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.a;
import com.melon.ui.b;
import com.melon.ui.e;
import com.melon.ui.n;
import com.melon.ui.w4;
import com.melon.ui.y4;
import d3.g;
import ed.f;
import gd.r5;
import gd.v5;
import ie.r;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import we.k;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lhd/s1;", "Lcom/melon/ui/o1;", "Lhd/O1;", "LJ8/W0;", "Lcom/melon/ui/a;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class s1 extends K0 implements a {
    public final e d;
    public final LogU e;
    public String f;
    public final r g;

    public s1() {
        this.d = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        LogU logU0 = new LogU("MusicDnaMonthlyLogFragment");
        logU0.setCategory(Category.UI);
        this.e = logU0;
        this.f = "";
        this.g = g.Q(new r5(6));
    }

    @Override  // com.melon.ui.J0
    public final Q4.a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return W0.a(layoutInflater0);
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return O1.class;
    }

    @Override  // com.melon.ui.a
    public final void handleAddPlayUiEvent(l0 l00, b b0, Context context0, k k0, CoroutineScope coroutineScope0) {
        q.g(b0, "event");
        q.g(coroutineScope0, "coroutineScope");
        this.d.handleAddPlayUiEvent(l00, b0, context0, k0, coroutineScope0);
    }

    public final void n(F f0, List list0, l l0, int v) {
        ((p)l0).c0(1051283989);
        int v1 = 4;
        int v2 = v | (((p)l0).g(f0) ? 4 : 2) | (((p)l0).i(list0) ? 0x20 : 16) | (((p)l0).i(this) ? 0x100 : 0x80);
        if(((p)l0).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            Context context0 = (Context)((p)l0).k(AndroidCompositionLocals_androidKt.b);
            try {
                DisplayMetrics displayMetrics0 = context0.getResources().getDisplayMetrics();
                if(((int)(((float)displayMetrics0.widthPixels) / displayMetrics0.density)) / 360 >= 1) {
                    v1 = 5;
                }
            }
            catch(Exception unused_ex) {
                v1 = 5;
            }
            Configuration configuration0 = (Configuration)((p)l0).k(AndroidCompositionLocals_androidKt.a);
            LogU.debug$default(this.e, "Body() configuration: " + configuration0, null, true, 2, null);
            FillElement fillElement0 = d.c;
            j0 j00 = androidx.compose.foundation.layout.a.c(0.0f, 0.0f, 0.0f, 118.0f, 7);
            boolean z = ((p)l0).i(list0);
            boolean z1 = ((p)l0).e(v1);
            boolean z2 = ((p)l0).i(this);
            F0 f00 = ((p)l0).N();
            if((z | z1 | z2) != 0 || f00 == androidx.compose.runtime.k.a) {
                f00 = new F0(list0, v1, this, 25);
                ((p)l0).l0(f00);
            }
            c1.o(fillElement0, f0, j00, false, null, null, null, false, f00, ((p)l0), v2 << 3 & 0x70 | 390, 0xF8);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new h(this, f0, list0, v, 25);
        }
    }

    @Override  // com.melon.ui.o1
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.requireArguments();
            q.f(bundle0, "requireArguments(...)");
        }
        O1 o10 = (O1)this.getViewModel();
        String s = bundle0.getString("argMonth");
        if(s == null) {
            s = "";
        }
        o10.getClass();
        o10.f = s;
        O1 o11 = (O1)this.getViewModel();
        o11.g = bundle0.getBoolean("argIncludeShortcuts");
    }

    @Override  // com.melon.ui.c0
    public final void onSaveInstanceState(Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argMonth", ((O1)this.getViewModel()).f);
        bundle0.putBoolean("argIncludeShortcuts", ((O1)this.getViewModel()).g);
    }

    @Override  // com.melon.ui.J0
    public final void onUiEvent(I4 i40) {
        q.g(i40, "event");
        if(i40 instanceof B4) {
            this.sendUserEvent(new n(((B4)i40).a, ((B4)i40).b, false, false, null, 0x7C));
            return;
        }
        if(i40 instanceof w4) {
            this.sendUserEvent(new com.melon.ui.h(((w4)i40).a, ((w4)i40).b, null, 60));
            return;
        }
        if(i40 instanceof y4) {
            this.sendUserEvent(new com.melon.ui.k(((y4)i40).a, ((y4)i40).b, null, 60));
            return;
        }
        if(i40 instanceof D4) {
            this.sendUserEvent(new com.melon.ui.p(((D4)i40).a));
            return;
        }
        if(i40 instanceof b) {
            l0 l00 = this.getChildFragmentManager();
            q.f(l00, "getChildFragmentManager(...)");
            a.f(this, l00, ((b)i40), this.getContext(), new v5(1, this, s1.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 27));
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
        ((TitleBar)w00.c.c).setTitle("월간 로그");
        j j0 = (j)this.g.getValue();
        f f0 = new f(this, 24);
        j.a(j0, ((TitleBar)w00.c.c), f0);
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        W0 w00 = (W0)this.getBinding();
        if(w00 == null) {
            return;
        }
        m0.b b0 = new m0.b(0x8BF9EB4F, new h(k40, this, w00, 24), true);
        w00.b.setContent(b0);
    }
}

