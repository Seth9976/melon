package N4;

import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.view.View;

public class j0 extends L {
    public static boolean u = true;
    public static boolean v = true;
    public static boolean w = true;
    public static boolean x = true;
    public static boolean y = true;

    @Override  // N4.L
    public void k(View view0, int v) {
        if(Build.VERSION.SDK_INT == 28) {
            super.k(view0, v);
            return;
        }
        if(j0.y) {
            try {
                i0.a(view0, v);
            }
            catch(NoSuchMethodError unused_ex) {
                j0.y = false;
            }
        }
    }

    public void m(View view0, Matrix matrix0) {
        if(j0.u) {
            try {
                g0.a(view0, matrix0);
            }
            catch(NoSuchMethodError unused_ex) {
                j0.u = false;
            }
        }
    }

    public void n(View view0, int v, int v1, int v2, int v3) {
        if(j0.x) {
            try {
                h0.a(view0, v, v1, v2, v3);
            }
            catch(NoSuchMethodError unused_ex) {
                j0.x = false;
            }
        }
    }

    public void o(View view0, Matrix matrix0) {
        if(j0.v) {
            try {
                g0.b(view0, matrix0);
            }
            catch(NoSuchMethodError unused_ex) {
                j0.v = false;
            }
        }
    }

    public void p(View view0, Matrix matrix0) {
        if(j0.w) {
            try {
                g0.c(view0, matrix0);
            }
            catch(NoSuchMethodError unused_ex) {
                j0.w = false;
            }
        }
    }
}

