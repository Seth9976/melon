package androidx.window.layout.util;

import android.content.Context;
import android.content.res.Configuration;
import android.view.WindowMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0016J\u0018\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0016¨\u0006\u000B"}, d2 = {"Landroidx/window/layout/util/DensityCompatHelperBaseImpl;", "Landroidx/window/layout/util/DensityCompatHelper;", "()V", "density", "", "context", "Landroid/content/Context;", "configuration", "Landroid/content/res/Configuration;", "windowMetrics", "Landroid/view/WindowMetrics;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class DensityCompatHelperBaseImpl implements DensityCompatHelper {
    @NotNull
    public static final DensityCompatHelperBaseImpl INSTANCE;

    static {
        DensityCompatHelperBaseImpl.INSTANCE = new DensityCompatHelperBaseImpl();
    }

    @Override  // androidx.window.layout.util.DensityCompatHelper
    public float density(@NotNull Context context0) {
        q.g(context0, "context");
        return context0.getResources().getDisplayMetrics().density;
    }

    @Override  // androidx.window.layout.util.DensityCompatHelper
    public float density(@NotNull Configuration configuration0, @NotNull WindowMetrics windowMetrics0) {
        q.g(configuration0, "configuration");
        q.g(windowMetrics0, "windowMetrics");
        return ((float)configuration0.densityDpi) / 160.0f;
    }
}

