package Lc;

import Ac.U;
import Cc.c1;
import Dd.J;
import F8.o;
import Hc.k;
import J8.W0;
import Q4.a;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.K4;
import com.melon.ui.o1;
import d3.g;
import ie.r;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import m0.b;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"LLc/j;", "Lcom/melon/ui/o1;", "LLc/t;", "LJ8/W0;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class j extends u {
    public final r d;

    public j() {
        new LogU("DownloadManagerFragment").setCategory(Category.UI);
        this.d = g.Q(new k(8));
    }

    @Override  // com.melon.ui.J0
    public final a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return W0.a(layoutInflater0);
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return t.class;
    }

    @Override  // com.melon.ui.c0
    public final boolean isShowTabAndMiniPlayer() {
        return false;
    }

    public final void n(ArrayList arrayList0, l l0, int v) {
        ((p)l0).c0(0x28016316);
        int v1 = (((p)l0).i(arrayList0) ? 4 : 2) | v | (((p)l0).i(this) ? 0x20 : 16);
        if(((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            FillElement fillElement0 = d.c;
            boolean z = ((p)l0).i(arrayList0);
            boolean z1 = ((p)l0).i(this);
            J j0 = ((p)l0).N();
            if(z || z1 || j0 == androidx.compose.runtime.k.a) {
                j0 = new J(25, arrayList0, this);
                ((p)l0).l0(j0);
            }
            c1.o(fillElement0, null, null, false, null, null, null, false, j0, ((p)l0), 6, 0xFE);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new Gd.p(this, arrayList0, v, 15);
        }
    }

    @Override  // com.melon.ui.c0
    public final void onResume() {
        super.onResume();
        o1.loadPage$default(this, true, null, 2, null);
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
        String s = this.getString(0x7F131045);  // string:title_menu_download_manager "다운로드 관리자"
        ((TitleBar)w00.c.c).setTitle(s);
        ((TitleBar)w00.c.c).f(true);
        Ud.j j0 = (Ud.j)this.d.getValue();
        U u0 = new U(this, 24);
        Ud.j.a(j0, ((TitleBar)w00.c.c), u0);
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new i(this, null), 3, null);
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        W0 w00 = (W0)this.getBinding();
        if(w00 == null) {
            return;
        }
        b b0 = new b(1049478339, new Gd.p(14, k40, this), true);
        w00.b.setContent(b0);
    }
}

