package c2;

import N4.z;
import Q1.c;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.collection.V;
import androidx.lifecycle.b;

public class D0 extends c {
    public final WindowInsetsController i;
    public final b j;
    public final Window k;

    public D0(Window window0, b b0) {
        this(h0.k(window0), b0);
        this.k = window0;
    }

    public D0(WindowInsetsController windowInsetsController0, b b0) {
        new V(0);
        this.i = windowInsetsController0;
        this.j = b0;
    }

    @Override  // Q1.c
    public final void G(int v) {
        ((z)this.j.b).c();
        this.i.hide(v & -9);
    }

    @Override  // Q1.c
    public boolean H() {
        h0.p(this.i);
        return (h0.c(this.i) & 8) != 0;
    }

    @Override  // Q1.c
    public final void P(boolean z) {
        Window window0 = this.k;
        if(z) {
            if(window0 != null) {
                this.b0(16);
            }
            h0.A(this.i);
            return;
        }
        if(window0 != null) {
            this.c0(16);
        }
        h0.C(this.i);
    }

    @Override  // Q1.c
    public final void Q(boolean z) {
        Window window0 = this.k;
        if(z) {
            if(window0 != null) {
                this.b0(0x2000);
            }
            h0.w(this.i);
            return;
        }
        if(window0 != null) {
            this.c0(0x2000);
        }
        h0.y(this.i);
    }

    @Override  // Q1.c
    public void S() {
        Window window0 = this.k;
        if(window0 != null) {
            window0.getDecorView().setTag(356039078, 2);
            this.c0(0x800);
            this.b0(0x1000);
            return;
        }
        h0.u(this.i);
    }

    @Override  // Q1.c
    public final void U(int v) {
        if((v & 8) != 0) {
            ((z)this.j.b).d();
        }
        this.i.show(v & -9);
    }

    public final void b0(int v) {
        View view0 = this.k.getDecorView();
        view0.setSystemUiVisibility(v | view0.getSystemUiVisibility());
    }

    public final void c0(int v) {
        View view0 = this.k.getDecorView();
        view0.setSystemUiVisibility(~v & view0.getSystemUiVisibility());
    }
}

