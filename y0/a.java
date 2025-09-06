package y0;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.Canvas;

public abstract class a {
    public static BlendMode b() {
        return BlendMode.DST_IN;
    }

    public static BlendModeColorFilter c(int v, BlendMode blendMode0) {
        return new BlendModeColorFilter(v, blendMode0);
    }

    public static void d() {
    }

    public static void e(Canvas canvas0) {
        canvas0.enableZ();
    }

    public static BlendMode g() {
        return BlendMode.SRC_OUT;
    }

    public static void h(Canvas canvas0) {
        canvas0.disableZ();
    }

    public static BlendMode i() {
        return BlendMode.LIGHTEN;
    }

    public static BlendMode j() {
        return BlendMode.COLOR_DODGE;
    }

    public static BlendMode k() {
        return BlendMode.DST_OUT;
    }

    public static BlendMode l() {
        return BlendMode.SRC_ATOP;
    }

    public static BlendMode m() {
        return BlendMode.XOR;
    }

    public static BlendMode n() {
        return BlendMode.PLUS;
    }

    public static BlendMode o() {
        return BlendMode.MODULATE;
    }

    public static BlendMode p() {
        return BlendMode.SCREEN;
    }

    public static BlendMode q() {
        return BlendMode.OVERLAY;
    }

    public static BlendMode r() {
        return BlendMode.DARKEN;
    }
}

