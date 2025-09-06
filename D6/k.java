package D6;

import android.view.View.OnLayoutChangeListener;
import android.view.View;

public final class k implements View.OnLayoutChangeListener {
    public final View a;
    public final l b;

    public k(l l0, View view0) {
        this.b = l0;
        this.a = view0;
    }

    @Override  // android.view.View$OnLayoutChangeListener
    public final void onLayoutChange(View view0, int v, int v1, int v2, int v3, int v4, int v5, int v6, int v7) {
        View view1 = this.a;
        if(view1.getVisibility() == 0) {
            this.b.c(view1);
        }
    }
}

