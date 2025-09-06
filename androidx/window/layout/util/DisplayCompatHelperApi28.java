package androidx.window.layout.util;

import android.view.DisplayCutout;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006J\u000E\u0010\u0007\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006J\u000E\u0010\b\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006J\u000E\u0010\t\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006¨\u0006\n"}, d2 = {"Landroidx/window/layout/util/DisplayCompatHelperApi28;", "", "()V", "safeInsetBottom", "", "displayCutout", "Landroid/view/DisplayCutout;", "safeInsetLeft", "safeInsetRight", "safeInsetTop", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class DisplayCompatHelperApi28 {
    @NotNull
    public static final DisplayCompatHelperApi28 INSTANCE;

    static {
        DisplayCompatHelperApi28.INSTANCE = new DisplayCompatHelperApi28();
    }

    public final int safeInsetBottom(@NotNull DisplayCutout displayCutout0) {
        q.g(displayCutout0, "displayCutout");
        return a.A(displayCutout0);
    }

    public final int safeInsetLeft(@NotNull DisplayCutout displayCutout0) {
        q.g(displayCutout0, "displayCutout");
        return a.w(displayCutout0);
    }

    public final int safeInsetRight(@NotNull DisplayCutout displayCutout0) {
        q.g(displayCutout0, "displayCutout");
        return a.C(displayCutout0);
    }

    public final int safeInsetTop(@NotNull DisplayCutout displayCutout0) {
        q.g(displayCutout0, "displayCutout");
        return a.b(displayCutout0);
    }
}

