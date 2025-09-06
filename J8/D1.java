package J8;

import Q4.a;
import android.support.v4.view.NonSwipeableViewPager;
import android.view.View;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

public final class d1 implements a {
    public final CoordinatorLayout a;
    public final AppBarLayout b;
    public final View c;
    public final FrameLayout d;
    public final NonSwipeableViewPager e;
    public final FrameLayout f;

    public d1(CoordinatorLayout coordinatorLayout0, AppBarLayout appBarLayout0, View view0, FrameLayout frameLayout0, NonSwipeableViewPager nonSwipeableViewPager0, CoordinatorLayout coordinatorLayout1, FrameLayout frameLayout1) {
        this.a = coordinatorLayout0;
        this.b = appBarLayout0;
        this.c = view0;
        this.d = frameLayout0;
        this.e = nonSwipeableViewPager0;
        this.f = frameLayout1;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

