package J8;

import Q4.a;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.iloen.melon.fragments.main.common.MainTabTitleView;

public final class u0 implements a {
    public final ConstraintLayout a;
    public final MainTabTitleView b;
    public final RecyclerView c;

    public u0(ConstraintLayout constraintLayout0, MainTabTitleView mainTabTitleView0, RecyclerView recyclerView0) {
        this.a = constraintLayout0;
        this.b = mainTabTitleView0;
        this.c = recyclerView0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

