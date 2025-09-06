package ud;

import com.iloen.melon.fragments.MelonBottomSheetBaseFragment.OnDismissListener;
import com.melon.ui.n0;

public final class y implements OnDismissListener {
    public final C a;

    public y(C c0) {
        this.a = c0;
    }

    @Override  // com.iloen.melon.fragments.MelonBottomSheetBaseFragment$OnDismissListener
    public final void dismiss() {
        n0.performPvDummyLogging$default(((R0)this.a.getViewModel()), "castPlayer", null, 2, null);
    }
}

