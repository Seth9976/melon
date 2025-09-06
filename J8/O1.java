package J8;

import Q4.a;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;

public final class o1 implements a {
    public final ConstraintLayout a;
    public final ViewPager2 b;

    public o1(ConstraintLayout constraintLayout0, ViewPager2 viewPager20) {
        this.a = constraintLayout0;
        this.b = viewPager20;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

