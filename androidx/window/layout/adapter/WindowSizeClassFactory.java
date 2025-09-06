package androidx.window.layout.adapter;

import androidx.window.core.layout.WindowSizeClass;
import androidx.window.core.layout.WindowSizeClassSelectors;
import androidx.window.layout.WindowMetrics;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0018\u0010\u0000\u001A\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0003\u001A\u00020\u0004¨\u0006\u0005"}, d2 = {"computeWindowSizeClass", "Landroidx/window/core/layout/WindowSizeClass;", "", "windowMetrics", "Landroidx/window/layout/WindowMetrics;", "window_release"}, k = 2, mv = {1, 9, 0}, xi = 0x30)
public final class WindowSizeClassFactory {
    @NotNull
    public static final WindowSizeClass computeWindowSizeClass(@NotNull Set set0, @NotNull WindowMetrics windowMetrics0) {
        q.g(set0, "<this>");
        q.g(windowMetrics0, "windowMetrics");
        return WindowSizeClassSelectors.computeWindowSizeClass(set0, windowMetrics0.getWidthDp(), windowMetrics0.getHeightDp());
    }
}

