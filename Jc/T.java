package Jc;

import android.view.View.OnClickListener;
import android.view.View;

public final class t implements View.OnClickListener {
    public final int a;
    public final K b;

    public t(K k0, int v) {
        this.a = v;
        this.b = k0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                this.b.h0.invoke();
                return;
            }
            case 1: {
                this.b.h0.invoke();
                return;
            }
            case 2: {
                this.b.g0.invoke();
                return;
            }
            case 3: {
                this.b.i0.invoke();
                return;
            }
            case 4: {
                this.b.j0.invoke(Boolean.TRUE, Boolean.valueOf(!this.b.Z), this.b);
                return;
            }
            case 5: {
                this.b.j0.invoke(Boolean.FALSE, Boolean.valueOf(!this.b.c0), this.b);
                return;
            }
            case 6: {
                this.b.k0.invoke();
                return;
            }
            default: {
                this.b.k0.invoke();
            }
        }
    }
}

