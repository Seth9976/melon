package J8;

import Q4.a;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

public final class v2 implements a {
    public final RelativeLayout a;
    public final RelativeLayout b;
    public final ToggleButton c;
    public final ToggleButton d;
    public final ToggleButton e;
    public final ToggleButton f;
    public final ToggleButton g;
    public final ToggleButton h;
    public final RelativeLayout i;
    public final RelativeLayout j;
    public final RelativeLayout k;
    public final x l;

    public v2(RelativeLayout relativeLayout0, RelativeLayout relativeLayout1, ToggleButton toggleButton0, ToggleButton toggleButton1, ToggleButton toggleButton2, ToggleButton toggleButton3, ToggleButton toggleButton4, ToggleButton toggleButton5, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, x x0) {
        this.a = relativeLayout0;
        this.b = relativeLayout1;
        this.c = toggleButton0;
        this.d = toggleButton1;
        this.e = toggleButton2;
        this.f = toggleButton3;
        this.g = toggleButton4;
        this.h = toggleButton5;
        this.i = relativeLayout2;
        this.j = relativeLayout3;
        this.k = relativeLayout4;
        this.l = x0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

