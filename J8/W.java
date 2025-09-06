package J8;

import Q4.a;
import android.view.View;
import android.widget.RelativeLayout;

public final class w implements a {
    public final RelativeLayout a;
    public final View b;
    public final u c;
    public final View d;

    public w(RelativeLayout relativeLayout0, View view0, u u0, View view1) {
        this.a = relativeLayout0;
        this.b = view0;
        this.c = u0;
        this.d = view1;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

