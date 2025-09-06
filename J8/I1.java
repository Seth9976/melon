package J8;

import Q4.a;
import android.support.v4.view.NonSwipeableViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.compose.ui.platform.ComposeView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

public final class i1 implements a {
    public final CoordinatorLayout a;
    public final FrameLayout b;
    public final AppBarLayout c;
    public final FrameLayout d;
    public final ComposeView e;
    public final ComposeView f;
    public final FrameLayout g;
    public final TabLayout h;
    public final HorizontalScrollView i;
    public final NonSwipeableViewPager j;

    public i1(CoordinatorLayout coordinatorLayout0, FrameLayout frameLayout0, AppBarLayout appBarLayout0, FrameLayout frameLayout1, ComposeView composeView0, ComposeView composeView1, FrameLayout frameLayout2, TabLayout tabLayout0, HorizontalScrollView horizontalScrollView0, NonSwipeableViewPager nonSwipeableViewPager0) {
        this.a = coordinatorLayout0;
        this.b = frameLayout0;
        this.c = appBarLayout0;
        this.d = frameLayout1;
        this.e = composeView0;
        this.f = composeView1;
        this.g = frameLayout2;
        this.h = tabLayout0;
        this.i = horizontalScrollView0;
        this.j = nonSwipeableViewPager0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

