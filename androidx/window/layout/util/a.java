package androidx.window.layout.util;

import android.graphics.ImageDecoder.Source;
import android.graphics.ImageDecoder;
import android.text.StaticLayout.Builder;
import android.view.DisplayCutout;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.iloen.melon.custom.MelonTextView;

public abstract class a {
    public static int A(DisplayCutout displayCutout0) {
        return displayCutout0.getSafeInsetBottom();
    }

    public static void B(ImageDecoder imageDecoder0) {
        imageDecoder0.setMemorySizePolicy(0);
    }

    public static int C(DisplayCutout displayCutout0) {
        return displayCutout0.getSafeInsetRight();
    }

    public static ImageDecoder.Source g(Object object0) [...] // Inlined contents

    public static void m(ImageDecoder imageDecoder0) {
        imageDecoder0.setAllocator(3);
    }

    public static void p(StaticLayout.Builder staticLayout$Builder0) {
        staticLayout$Builder0.setUseLineSpacingFromFallbacks(true);
    }

    public static void q(BottomAppBar bottomAppBar0) {
        bottomAppBar0.setOutlineAmbientShadowColor(0);
    }

    public static void r(MelonTextView melonTextView0) {
        melonTextView0.setAccessibilityHeading(true);
    }

    public static int w(DisplayCutout displayCutout0) {
        return displayCutout0.getSafeInsetLeft();
    }

    public static void x(ImageDecoder imageDecoder0) {
        imageDecoder0.setAllocator(1);
    }

    public static void z(BottomAppBar bottomAppBar0) {
        bottomAppBar0.setOutlineSpotShadowColor(0);
    }
}

