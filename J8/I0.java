package J8;

import Q4.a;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.flexbox.FlexboxLayout;
import com.iloen.melon.fragments.main.common.MainTabTitleView;

public final class i0 implements a {
    public final LinearLayout a;
    public final FlexboxLayout b;
    public final MainTabTitleView c;

    public i0(LinearLayout linearLayout0, FlexboxLayout flexboxLayout0, MainTabTitleView mainTabTitleView0) {
        this.a = linearLayout0;
        this.b = flexboxLayout0;
        this.c = mainTabTitleView0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

