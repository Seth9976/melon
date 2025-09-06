package J8;

import Q4.a;
import android.view.View;
import android.widget.LinearLayout;
import com.iloen.melon.fragments.main.common.MainTabTitleView;

public final class l0 implements a {
    public final LinearLayout a;
    public final MainTabTitleView b;

    public l0(LinearLayout linearLayout0, MainTabTitleView mainTabTitleView0) {
        this.a = linearLayout0;
        this.b = mainTabTitleView0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

