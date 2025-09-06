package androidx.window.layout.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.WindowManager;
import androidx.window.core.Bounds;
import androidx.window.layout.WindowMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0016J\u0018\u0010\u0003\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u0007\u001A\u00020\bH\u0016J\u0018\u0010\u000B\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u0007\u001A\u00020\bH\u0016J\u0018\u0010\f\u001A\u00020\u00042\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H\u0016¨\u0006\u0011"}, d2 = {"Landroidx/window/layout/util/WindowMetricsCompatHelperApi30Impl;", "Landroidx/window/layout/util/WindowMetricsCompatHelper;", "()V", "currentWindowMetrics", "Landroidx/window/layout/WindowMetrics;", "activity", "Landroid/app/Activity;", "densityCompatHelper", "Landroidx/window/layout/util/DensityCompatHelper;", "context", "Landroid/content/Context;", "maximumWindowMetrics", "translateWindowMetrics", "windowMetrics", "Landroid/view/WindowMetrics;", "density", "", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class WindowMetricsCompatHelperApi30Impl implements WindowMetricsCompatHelper {
    @NotNull
    public static final WindowMetricsCompatHelperApi30Impl INSTANCE;

    static {
        WindowMetricsCompatHelperApi30Impl.INSTANCE = new WindowMetricsCompatHelperApi30Impl();
    }

    @Override  // androidx.window.layout.util.WindowMetricsCompatHelper
    @NotNull
    public WindowMetrics currentWindowMetrics(@NotNull Activity activity0, @NotNull DensityCompatHelper densityCompatHelper0) {
        q.g(activity0, "activity");
        q.g(densityCompatHelper0, "densityCompatHelper");
        return new WindowMetrics(new Bounds(BoundsHelper.Companion.getInstance().currentWindowBounds(activity0)), densityCompatHelper0.density(activity0));
    }

    @Override  // androidx.window.layout.util.WindowMetricsCompatHelper
    @NotNull
    public WindowMetrics currentWindowMetrics(@NotNull Context context0, @NotNull DensityCompatHelper densityCompatHelper0) {
        q.g(context0, "context");
        q.g(densityCompatHelper0, "densityCompatHelper");
        WindowManager windowManager0 = (WindowManager)context0.getSystemService(WindowManager.class);
        float f = context0.getResources().getDisplayMetrics().density;
        Rect rect0 = windowManager0.getCurrentWindowMetrics().getBounds();
        q.f(rect0, "getBounds(...)");
        return new WindowMetrics(rect0, f);
    }

    @Override  // androidx.window.layout.util.WindowMetricsCompatHelper
    @NotNull
    public WindowMetrics maximumWindowMetrics(@NotNull Context context0, @NotNull DensityCompatHelper densityCompatHelper0) {
        q.g(context0, "context");
        q.g(densityCompatHelper0, "densityCompatHelper");
        return new WindowMetrics(new Bounds(BoundsHelper.Companion.getInstance().maximumWindowBounds(context0)), densityCompatHelper0.density(context0));
    }

    @Override  // androidx.window.layout.util.WindowMetricsCompatHelper
    @NotNull
    public WindowMetrics translateWindowMetrics(@NotNull android.view.WindowMetrics windowMetrics0, float f) {
        q.g(windowMetrics0, "windowMetrics");
        Rect rect0 = windowMetrics0.getBounds();
        q.f(rect0, "getBounds(...)");
        return new WindowMetrics(rect0, f);
    }
}

