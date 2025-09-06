package androidx.fragment.app;

import androidx.lifecycle.s;
import java.util.ArrayList;

public abstract class y0 {
    public ArrayList a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public String i;
    public int j;
    public CharSequence k;
    public int l;
    public CharSequence m;
    public ArrayList n;
    public ArrayList o;
    public boolean p;
    public ArrayList q;

    public final void b(x0 x00) {
        this.a.add(x00);
        x00.d = this.b;
        x00.e = this.c;
        x00.f = this.d;
        x00.g = this.e;
    }

    public final void c(String s) {
        if(!this.h) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.g = true;
        this.i = s;
    }

    public abstract a d(I arg1);

    public abstract void e(int arg1, I arg2, String arg3, int arg4);

    public abstract a f(I arg1);

    public final void g(int v, I i0, String s) {
        if(v == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        this.e(v, i0, s, 2);
    }

    public abstract a h(I arg1, s arg2);
}

