package N4;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import c2.B;
import java.lang.reflect.Method;

public class z implements w {
    public final View a;
    public static Class b;
    public static boolean c;
    public static Method d;
    public static boolean e;
    public static Method f;
    public static boolean g;

    public z(View view0) {
        this.a = view0;
        super();
    }

    @Override  // N4.w
    public void a(ViewGroup viewGroup0, View view0) {
    }

    public static void b() {
        if(!z.c) {
            try {
                z.b = Class.forName("android.view.GhostView");
            }
            catch(ClassNotFoundException classNotFoundException0) {
                Log.i("GhostViewApi21", "Failed to retrieve GhostView class", classNotFoundException0);
            }
            z.c = true;
        }
    }

    public void c() {
        View view0 = this.a;
        if(view0 != null) {
            ((InputMethodManager)view0.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view0.getWindowToken(), 0);
        }
    }

    public void d() {
        View view1;
        View view0 = this.a;
        if(view0 != null) {
            if(view0.isInEditMode() || view0.onCheckIsTextEditor()) {
                view0.requestFocus();
                view1 = view0;
            }
            else {
                view1 = view0.getRootView().findFocus();
            }
            if(view1 == null) {
                view1 = view0.getRootView().findViewById(0x1020002);
            }
            if(view1 != null && view1.hasWindowFocus()) {
                view1.post(new B(view1, 0));
            }
        }
    }

    @Override  // N4.w
    public void setVisibility(int v) {
        this.a.setVisibility(v);
    }
}

