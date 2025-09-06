package Jc;

import android.view.View.OnClickListener;
import android.view.View;
import we.n;

public final class r0 implements View.OnClickListener {
    public final int a;
    public final X b;
    public final int c;

    public r0(X x0, int v, int v1) {
        this.a = v1;
        this.b = x0;
        this.c = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                X x1 = this.b;
                n n1 = x1.B;
                if(n1 != null) {
                    n1.invoke(x1, this.c);
                }
                return;
            }
            case 1: {
                X x2 = this.b;
                n n2 = x2.E;
                if(n2 != null) {
                    n2.invoke(x2, this.c);
                }
                return;
            }
            case 2: {
                X x3 = this.b;
                n n3 = x3.G;
                if(n3 != null) {
                    n3.invoke(x3, this.c);
                }
                return;
            }
            default: {
                X x0 = this.b;
                n n0 = x0.I;
                if(n0 != null) {
                    n0.invoke(x0, this.c);
                }
            }
        }
    }
}

