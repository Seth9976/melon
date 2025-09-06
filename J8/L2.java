package J8;

import Q4.a;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.compose.ui.platform.ComposeView;
import com.google.android.material.appbar.AppBarLayout;

public final class l2 implements a {
    public final FrameLayout a;
    public final View b;
    public final AppBarLayout c;
    public final ComposeView d;
    public final LinearLayoutCompat e;
    public final FrameLayout f;
    public final View g;
    public final b h;

    public l2(FrameLayout frameLayout0, View view0, AppBarLayout appBarLayout0, ComposeView composeView0, LinearLayoutCompat linearLayoutCompat0, FrameLayout frameLayout1, View view1, b b0) {
        this.a = frameLayout0;
        this.b = view0;
        this.c = appBarLayout0;
        this.d = composeView0;
        this.e = linearLayoutCompat0;
        this.f = frameLayout1;
        this.g = view1;
        this.h = b0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

