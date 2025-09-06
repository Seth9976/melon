package vd;

import Nc.f;
import android.view.View.OnClickListener;
import android.view.View;

public final class t implements View.OnClickListener {
    public final int a;
    public final v b;

    public t(v v0, int v1) {
        this.a = v1;
        this.b = v0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                this.b.dismissNow();
                return;
            }
            case 1: {
                this.b.getClass();
                this.b.dismissNow();
                return;
            }
            default: {
                v v0 = this.b;
                f f0 = v0.k;
                if(f0 != null) {
                    f0.invoke();
                }
                v0.dismissNow();
            }
        }
    }
}

