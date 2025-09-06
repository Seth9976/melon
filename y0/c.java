package y0;

import android.graphics.Canvas;

public abstract class c {
    public static final Canvas a;

    static {
        c.a = new Canvas();
    }

    public static final Canvas a(q q0) {
        kotlin.jvm.internal.q.e(q0, "null cannot be cast to non-null type androidx.compose.ui.graphics.AndroidCanvas");
        return ((b)q0).a;
    }
}

