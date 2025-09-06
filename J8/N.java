package J8;

import Q4.a;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import com.iloen.melon.fragments.main.common.MainTabTitleView;

public final class n implements a {
    public final LinearLayout a;
    public final GridLayout b;
    public final MainTabTitleView c;

    public n(LinearLayout linearLayout0, GridLayout gridLayout0, MainTabTitleView mainTabTitleView0) {
        this.a = linearLayout0;
        this.b = gridLayout0;
        this.c = mainTabTitleView0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

