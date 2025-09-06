package Jc;

import android.view.View.OnClickListener;
import android.view.View;
import we.n;

public final class o0 implements View.OnClickListener {
    public final int a;
    public final S b;
    public final int c;

    public o0(S s0, int v, int v1) {
        this.a = v1;
        this.b = s0;
        this.c = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            S s0 = this.b;
            n n0 = s0.f;
            if(n0 != null) {
                n0.invoke(s0, this.c);
            }
            return;
        }
        S s1 = this.b;
        n n1 = s1.g;
        if(n1 != null) {
            n1.invoke(s1, this.c);
        }
    }
}

