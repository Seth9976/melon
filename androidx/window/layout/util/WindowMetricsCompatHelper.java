package androidx.window.layout.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import androidx.window.layout.WindowMetrics;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b`\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J\u0018\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H&J\u0018\u0010\u0002\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u0007H&J\u0018\u0010\n\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u0007H&J\u0018\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Landroidx/window/layout/util/WindowMetricsCompatHelper;", "", "currentWindowMetrics", "Landroidx/window/layout/WindowMetrics;", "activity", "Landroid/app/Activity;", "densityCompatHelper", "Landroidx/window/layout/util/DensityCompatHelper;", "context", "Landroid/content/Context;", "maximumWindowMetrics", "translateWindowMetrics", "windowMetrics", "Landroid/view/WindowMetrics;", "density", "", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public interface WindowMetricsCompatHelper {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001A\u00020\u0004¨\u0006\u0005"}, d2 = {"Landroidx/window/layout/util/WindowMetricsCompatHelper$Companion;", "", "()V", "getInstance", "Landroidx/window/layout/util/WindowMetricsCompatHelper;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        static final Companion $$INSTANCE;

        static {
            Companion.$$INSTANCE = new Companion();
        }

        @NotNull
        public final WindowMetricsCompatHelper getInstance() {
            int v = Build.VERSION.SDK_INT;
            if(v >= 34) {
                return WindowMetricsCompatHelperApi34Impl.INSTANCE;
            }
            return v >= 30 ? WindowMetricsCompatHelperApi30Impl.INSTANCE : WindowMetricsCompatHelperBaseImpl.INSTANCE;
        }
    }

    @NotNull
    public static final Companion Companion;

    static {
        WindowMetricsCompatHelper.Companion = Companion.$$INSTANCE;
    }

    @NotNull
    WindowMetrics currentWindowMetrics(@NotNull Activity arg1, @NotNull DensityCompatHelper arg2);

    @NotNull
    WindowMetrics currentWindowMetrics(@NotNull Context arg1, @NotNull DensityCompatHelper arg2);

    @NotNull
    WindowMetrics maximumWindowMetrics(@NotNull Context arg1, @NotNull DensityCompatHelper arg2);

    @NotNull
    WindowMetrics translateWindowMetrics(@NotNull android.view.WindowMetrics arg1, float arg2);
}

