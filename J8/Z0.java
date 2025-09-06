package J8;

import Q4.a;
import android.view.View;
import android.widget.LinearLayout;
import com.iloen.melon.fragments.main.common.MainTabTitleView;

public final class z0 implements a {
    public final LinearLayout a;
    public final LinearLayout b;
    public final MainTabTitleView c;

    public z0(LinearLayout linearLayout0, LinearLayout linearLayout1, MainTabTitleView mainTabTitleView0) {
        this.a = linearLayout0;
        this.b = linearLayout1;
        this.c = mainTabTitleView0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

