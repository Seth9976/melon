package J8;

import Q4.a;
import android.view.View;
import android.widget.FrameLayout;
import androidx.compose.ui.platform.ComposeView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public final class k1 implements a {
    public final FrameLayout a;
    public final AppBarLayout b;
    public final CollapsingToolbarLayout c;
    public final ComposeView d;
    public final ComposeView e;
    public final ComposeView f;
    public final ComposeView g;

    public k1(FrameLayout frameLayout0, AppBarLayout appBarLayout0, CollapsingToolbarLayout collapsingToolbarLayout0, ComposeView composeView0, ComposeView composeView1, ComposeView composeView2, ComposeView composeView3) {
        this.a = frameLayout0;
        this.b = appBarLayout0;
        this.c = collapsingToolbarLayout0;
        this.d = composeView0;
        this.e = composeView1;
        this.f = composeView2;
        this.g = composeView3;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

