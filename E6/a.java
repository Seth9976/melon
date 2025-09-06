package e6;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public abstract class a {
    public static final LinearInterpolator a;
    public static final P2.a b;
    public static final P2.a c;
    public static final P2.a d;
    public static final DecelerateInterpolator e;

    static {
        a.a = new LinearInterpolator();
        a.b = new P2.a(1);
        a.c = new P2.a(0);
        a.d = new P2.a(P2.a.e);  // 初始化器: LP2/b;-><init>([F)V
        a.e = new DecelerateInterpolator();
    }

    public static float a(float f, float f1, float f2) {
        return (f1 - f) * f2 + f;
    }

    public static float b(float f, float f1, float f2, float f3, float f4) {
        if(f4 <= f2) {
            return f;
        }
        return f4 >= f3 ? f1 : a.a(f, f1, (f4 - f2) / (f3 - f2));
    }

    public static int c(int v, int v1, float f) {
        return Math.round(f * ((float)(v1 - v))) + v;
    }
}

