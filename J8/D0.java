package J8;

import Q4.a;
import android.view.View;
import android.widget.LinearLayout;

public final class d0 implements a {
    public final LinearLayout a;
    public final LinearLayout b;

    public d0(LinearLayout linearLayout0, LinearLayout linearLayout1) {
        this.a = linearLayout0;
        this.b = linearLayout1;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

