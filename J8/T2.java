package J8;

import Q4.a;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

public final class t2 implements a {
    public final RelativeLayout a;
    public final ToggleButton b;
    public final RelativeLayout c;
    public final x d;
    public final View e;

    public t2(RelativeLayout relativeLayout0, ToggleButton toggleButton0, RelativeLayout relativeLayout1, x x0, View view0) {
        this.a = relativeLayout0;
        this.b = toggleButton0;
        this.c = relativeLayout1;
        this.d = x0;
        this.e = view0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

