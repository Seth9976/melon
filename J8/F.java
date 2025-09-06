package J8;

import Q4.a;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.iloen.melon.fragments.main.common.MainTabTitleView;

public final class f implements a {
    public final LinearLayout a;
    public final MainTabTitleView b;
    public final RecyclerView c;

    public f(LinearLayout linearLayout0, RecyclerView recyclerView0, MainTabTitleView mainTabTitleView0) {
        this.a = linearLayout0;
        this.b = mainTabTitleView0;
        this.c = recyclerView0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

