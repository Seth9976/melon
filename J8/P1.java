package J8;

import Q4.a;
import android.view.View;
import android.widget.RelativeLayout;

public final class p1 implements a {
    public final RelativeLayout a;
    public final b b;

    public p1(RelativeLayout relativeLayout0, b b0) {
        this.a = relativeLayout0;
        this.b = b0;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

