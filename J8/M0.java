package J8;

import Q4.a;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public final class m0 implements a {
    public final FrameLayout a;
    public final AppBarLayout b;
    public final n0 c;
    public final View d;
    public final CollapsingToolbarLayout e;
    public final FrameLayout f;
    public final x g;
    public final b h;
    public final b i;
    public final RecyclerView j;
    public final LinearLayout k;

    public m0(FrameLayout frameLayout0, AppBarLayout appBarLayout0, n0 n00, View view0, CollapsingToolbarLayout collapsingToolbarLayout0, FrameLayout frameLayout1, x x0, b b0, b b1, RecyclerView recyclerView0, LinearLayout linearLayout0) {
        this.a = frameLayout0;
        this.b = appBarLayout0;
        this.c = n00;
        this.d = view0;
        this.e = collapsingToolbarLayout0;
        this.f = frameLayout1;
        this.g = x0;
        this.h = b0;
        this.i = b1;
        this.j = recyclerView0;
        this.k = linearLayout0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

