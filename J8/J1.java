package J8;

import Q4.a;
import android.view.View;
import android.widget.FrameLayout;
import androidx.compose.ui.platform.ComposeView;
import com.google.android.material.appbar.AppBarLayout;

public final class j1 implements a {
    public final FrameLayout a;
    public final AppBarLayout b;
    public final ComposeView c;
    public final ComposeView d;
    public final ComposeView e;

    public j1(FrameLayout frameLayout0, AppBarLayout appBarLayout0, ComposeView composeView0, ComposeView composeView1, ComposeView composeView2) {
        this.a = frameLayout0;
        this.b = appBarLayout0;
        this.c = composeView0;
        this.d = composeView1;
        this.e = composeView2;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

