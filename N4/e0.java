package N4;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;

public abstract class e0 {
    public static final j0 a;
    public static final b b;
    public static final b c;

    static {
        e0.a = Build.VERSION.SDK_INT >= 29 ? new k0() : new j0();  // 初始化器: Ljava/lang/Object;-><init>()V / 初始化器: Ljava/lang/Object;-><init>()V
        e0.b = new b("translationAlpha", 8, Float.class);
        e0.c = new b("clipBounds", 9, Rect.class);
    }

    public static void a(View view0, int v, int v1, int v2, int v3) {
        e0.a.n(view0, v, v1, v2, v3);
    }

    public static void b(View view0, float f) {
        e0.a.j(view0, f);
    }

    public static void c(View view0, int v) {
        e0.a.k(view0, v);
    }
}

