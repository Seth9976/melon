package J8;

import Q4.a;
import android.view.View;
import android.widget.FrameLayout;
import androidx.compose.ui.platform.ComposeView;
import com.google.android.material.appbar.AppBarLayout;

public final class p2 implements a {
    public final FrameLayout a;
    public final AppBarLayout b;
    public final ComposeView c;
    public final b d;

    public p2(FrameLayout frameLayout0, AppBarLayout appBarLayout0, ComposeView composeView0, b b0) {
        this.a = frameLayout0;
        this.b = appBarLayout0;
        this.c = composeView0;
        this.d = b0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

