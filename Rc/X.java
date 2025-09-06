package Rc;

import B0.s;
import J8.V0;
import Q4.a;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowInsetsController;
import c2.h0;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.melon.ui.K4;
import com.melon.ui.o1;
import d9.h;
import d9.j;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.MutableStateFlow;
import m0.b;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"LRc/x;", "Lcom/melon/ui/o1;", "LRc/t0;", "LJ8/V0;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class x extends o1 {
    public final LogU a;

    public x() {
        LogU logU0 = new LogU("LockScreenPlayerFragment");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.a = logU0;
    }

    @Override  // com.melon.ui.J0
    public final a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return V0.a(layoutInflater0, null);
    }

    @Override  // com.melon.ui.J0
    public final Class getViewModelClass() {
        return t0.class;
    }

    @Override  // com.melon.ui.J0
    public final void onConfigurationChanged(Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        this.renderUi(((K4)((t0)this.getViewModel()).getUiState().getValue()));
    }

    @Override  // com.melon.ui.c0
    public final void onPause() {
        super.onPause();
        ((t0)this.getViewModel()).getClass();
        j.d("LockScreenViewModel");
    }

    @Override  // com.melon.ui.c0
    public final void onResume() {
        super.onResume();
        t0 t00 = (t0)this.getViewModel();
        t00.getClass();
        h h0 = j.b("LockScreenViewModel");
        MutableStateFlow mutableStateFlow0 = t00.t;
        if(mutableStateFlow0.getValue() != h0) {
            mutableStateFlow0.setValue(h0);
        }
        View view0 = this.getView();
        if(view0 != null) {
            WindowInsetsController windowInsetsController0 = view0.getWindowInsetsController();
            if(windowInsetsController0 != null) {
                windowInsetsController0.hide(h0.s());
                s.s(windowInsetsController0);
            }
        }
    }

    @Override  // com.melon.ui.J0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        if(!(k40 instanceof O)) {
            LogU.info$default(this.a, "uiState is not LockScreenUiState : " + k40, null, false, 6, null);
            return;
        }
        LogU.info$default(this.a, "uiState is LockScreenUiState : " + k40, null, false, 6, null);
        MutableStateFlow mutableStateFlow0 = ((t0)this.getViewModel()).u;
        boolean z = q.b(((O)k40).a, M.e);
        this.setScreenLandscapeSupported(!z);
        boolean z1 = z || ScreenUtils.isOrientationPortrait(this.getContext()) || q.b(((O)k40).a, N.e) && ScreenUtils.isTablet(this.getContext());
        V0 v00 = (V0)this.getBinding();
        if(v00 != null) {
            b b0 = new b(0x11001B0D, new w(k40, mutableStateFlow0, this, z1), true);
            v00.b.setContent(b0);
        }
    }
}

