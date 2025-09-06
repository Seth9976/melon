package J8;

import Q4.a;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.iloen.melon.fragments.main.common.MainTabTitleView;

public final class o implements a {
    public final LinearLayout a;
    public final RecyclerView b;
    public final MainTabTitleView c;

    public o(LinearLayout linearLayout0, RecyclerView recyclerView0, MainTabTitleView mainTabTitleView0) {
        this.a = linearLayout0;
        this.b = recyclerView0;
        this.c = mainTabTitleView0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

