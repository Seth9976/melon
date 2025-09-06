package c2;

import android.graphics.Insets;
import android.view.WindowInsetsAnimation.Bounds;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;

public abstract class h0 {
    public static void A(WindowInsetsController windowInsetsController0) {
        windowInsetsController0.setSystemBarsAppearance(16, 16);
    }

    public static int B() {
        return 0x40;
    }

    public static void C(WindowInsetsController windowInsetsController0) {
        windowInsetsController0.setSystemBarsAppearance(0, 16);
    }

    public static int D() {
        return 0x80;
    }

    public static int b() {
        return 1;
    }

    public static int c(WindowInsetsController windowInsetsController0) {
        return windowInsetsController0.getSystemBarsAppearance();
    }

    public static WindowInsetsAnimation.Bounds h(Insets insets0, Insets insets1) {
        return new WindowInsetsAnimation.Bounds(insets0, insets1);
    }

    public static WindowInsetsAnimation i(int v, Interpolator interpolator0, long v1) {
        return new WindowInsetsAnimation(v, interpolator0, v1);
    }

    public static WindowInsetsAnimation j(Object object0) {
        return (WindowInsetsAnimation)object0;
    }

    public static void p(WindowInsetsController windowInsetsController0) {
        windowInsetsController0.setSystemBarsAppearance(0, 0);
    }

    public static int s() {
        return 2;
    }

    public static void u(WindowInsetsController windowInsetsController0) {
        windowInsetsController0.setSystemBarsBehavior(2);
    }

    public static int v() {
        return 4;
    }

    public static void w(WindowInsetsController windowInsetsController0) {
        windowInsetsController0.setSystemBarsAppearance(8, 8);
    }

    public static int x() {
        return 16;
    }

    public static void y(WindowInsetsController windowInsetsController0) {
        windowInsetsController0.setSystemBarsAppearance(0, 8);
    }

    public static int z() {
        return 0x20;
    }
}

