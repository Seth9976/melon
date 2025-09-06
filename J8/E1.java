package J8;

import Q4.a;
import android.view.View;
import android.widget.FrameLayout;
import androidx.compose.ui.platform.ComposeView;
import androidx.viewpager2.widget.ViewPager2;

public final class e1 implements a {
    public final FrameLayout a;
    public final ComposeView b;
    public final ViewPager2 c;
    public final ComposeView d;

    public e1(FrameLayout frameLayout0, ComposeView composeView0, ViewPager2 viewPager20, ComposeView composeView1) {
        this.a = frameLayout0;
        this.b = composeView0;
        this.c = viewPager20;
        this.d = composeView1;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

