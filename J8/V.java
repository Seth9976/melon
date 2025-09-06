package J8;

import Q4.a;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.compose.ui.platform.ComposeView;

public final class v implements a {
    public final RelativeLayout a;
    public final u b;
    public final ComposeView c;
    public final ComposeView d;
    public final ProgressBar e;
    public final ComposeView f;
    public final b g;

    public v(RelativeLayout relativeLayout0, u u0, ComposeView composeView0, ComposeView composeView1, ProgressBar progressBar0, ComposeView composeView2, b b0) {
        this.a = relativeLayout0;
        this.b = u0;
        this.c = composeView0;
        this.d = composeView1;
        this.e = progressBar0;
        this.f = composeView2;
        this.g = b0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

