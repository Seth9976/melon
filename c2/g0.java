package c2;

import P2.a;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import androidx.datastore.preferences.protobuf.m;
import java.util.List;
import x9.c;

public final class g0 extends k0 {
    public static final PathInterpolator e;
    public static final a f;
    public static final DecelerateInterpolator g;
    public static final AccelerateInterpolator h;

    static {
        g0.e = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);
        g0.f = new a(0);
        g0.g = new DecelerateInterpolator(1.5f);
        g0.h = new AccelerateInterpolator(1.5f);
    }

    public static void f(View view0, l0 l00) {
        m m0 = g0.k(view0);
        if(m0 == null) {
        label_4:
            if(view0 instanceof ViewGroup) {
                for(int v = 0; v < ((ViewGroup)view0).getChildCount(); ++v) {
                    g0.f(((ViewGroup)view0).getChildAt(v), l00);
                }
            }
        }
        else {
            m0.d(l00);
            if(m0.a != 0) {
                goto label_4;
            }
        }
    }

    public static void g(View view0, l0 l00, B0 b00, boolean z) {
        m m0 = g0.k(view0);
        if(m0 != null) {
            m0.b = b00;
            if(!z) {
                m0.e(l00);
                z = m0.a == 0;
            }
        }
        if(view0 instanceof ViewGroup) {
            for(int v = 0; v < ((ViewGroup)view0).getChildCount(); ++v) {
                g0.g(((ViewGroup)view0).getChildAt(v), l00, b00, z);
            }
        }
    }

    public static void h(View view0, B0 b00, List list0) {
        m m0 = g0.k(view0);
        if(m0 == null) {
        label_4:
            if(view0 instanceof ViewGroup) {
                for(int v = 0; v < ((ViewGroup)view0).getChildCount(); ++v) {
                    g0.h(((ViewGroup)view0).getChildAt(v), b00, list0);
                }
            }
        }
        else {
            b00 = m0.f(b00, list0);
            if(m0.a != 0) {
                goto label_4;
            }
        }
    }

    public static void i(View view0, l0 l00, c c0) {
        m m0 = g0.k(view0);
        if(m0 == null) {
        label_4:
            if(view0 instanceof ViewGroup) {
                for(int v = 0; v < ((ViewGroup)view0).getChildCount(); ++v) {
                    g0.i(((ViewGroup)view0).getChildAt(v), l00, c0);
                }
            }
        }
        else {
            m0.g(l00, c0);
            if(m0.a != 0) {
                goto label_4;
            }
        }
    }

    public static WindowInsets j(View view0, WindowInsets windowInsets0) {
        return view0.getTag(0x7F0A0B2A) == null ? view0.onApplyWindowInsets(windowInsets0) : windowInsets0;  // id:tag_on_apply_window_listener
    }

    public static m k(View view0) {
        Object object0 = view0.getTag(0x7F0A0B37);  // id:tag_window_insets_animation_callback
        return object0 instanceof f0 ? ((f0)object0).a : null;
    }
}

