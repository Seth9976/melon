package yc;

import android.view.View.OnClickListener;
import android.view.View;
import we.k;

public final class f implements View.OnClickListener {
    public final int a;
    public final k b;

    public f(int v, k k0) {
        this.a = v;
        this.b = k0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            k k0 = this.b;
            if(k0 != null) {
                k0.invoke(q.a);
            }
            return;
        }
        k k1 = this.b;
        if(k1 != null) {
            k1.invoke(o.a);
        }
    }
}

