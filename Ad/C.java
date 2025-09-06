package ad;

import android.view.View.OnClickListener;
import android.view.View;
import we.k;

public final class c implements View.OnClickListener {
    public final int a;
    public final w b;
    public final int c;

    public c(w w0, int v, int v1) {
        this.a = v1;
        this.b = w0;
        this.c = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                x x0 = new x(this.c);
                ((t)this.b).b.invoke(x0);
                return;
            }
            case 1: {
                x x1 = new x(this.c);
                ((s)this.b).b.invoke(x1);
                return;
            }
            default: {
                k k0 = ((v)this.b).b;
                if(k0 != null) {
                    k0.invoke(new x(this.c));
                }
            }
        }
    }
}

