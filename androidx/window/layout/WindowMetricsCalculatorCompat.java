package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import androidx.window.layout.util.DensityCompatHelper;
import androidx.window.layout.util.WindowMetricsCompatHelper;
import e.k;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0016J\u0010\u0010\u000B\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u0010H\u0016J\u0010\u0010\u0011\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EH\u0016J\u0010\u0010\u0011\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u0010H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0005\u001A\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Landroidx/window/layout/WindowMetricsCalculatorCompat;", "Landroidx/window/layout/WindowMetricsCalculator;", "densityCompatHelper", "Landroidx/window/layout/util/DensityCompatHelper;", "(Landroidx/window/layout/util/DensityCompatHelper;)V", "insetsTypeMasks", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getInsetsTypeMasks$window_release", "()Ljava/util/ArrayList;", "computeCurrentWindowMetrics", "Landroidx/window/layout/WindowMetrics;", "activity", "Landroid/app/Activity;", "context", "Landroid/content/Context;", "computeMaximumWindowMetrics", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class WindowMetricsCalculatorCompat implements WindowMetricsCalculator {
    @NotNull
    private final DensityCompatHelper densityCompatHelper;
    @NotNull
    private final ArrayList insetsTypeMasks;

    public WindowMetricsCalculatorCompat() {
        this(null, 1, null);
    }

    public WindowMetricsCalculatorCompat(@NotNull DensityCompatHelper densityCompatHelper0) {
        q.g(densityCompatHelper0, "densityCompatHelper");
        super();
        this.densityCompatHelper = densityCompatHelper0;
        this.insetsTypeMasks = k.e(new Integer[]{1, 2, 4, 8, 16, 0x20, 0x40, 0x80});
    }

    public WindowMetricsCalculatorCompat(DensityCompatHelper densityCompatHelper0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            densityCompatHelper0 = DensityCompatHelper.Companion.getInstance();
        }
        this(densityCompatHelper0);
    }

    @Override  // androidx.window.layout.WindowMetricsCalculator
    @NotNull
    public WindowMetrics computeCurrentWindowMetrics(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        return WindowMetricsCompatHelper.Companion.getInstance().currentWindowMetrics(activity0, this.densityCompatHelper);
    }

    @Override  // androidx.window.layout.WindowMetricsCalculator
    @NotNull
    public WindowMetrics computeCurrentWindowMetrics(@NotNull Context context0) {
        q.g(context0, "context");
        return WindowMetricsCompatHelper.Companion.getInstance().currentWindowMetrics(context0, this.densityCompatHelper);
    }

    @Override  // androidx.window.layout.WindowMetricsCalculator
    @NotNull
    public WindowMetrics computeMaximumWindowMetrics(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        return WindowMetricsCompatHelper.Companion.getInstance().maximumWindowMetrics(activity0, this.densityCompatHelper);
    }

    @Override  // androidx.window.layout.WindowMetricsCalculator
    @NotNull
    public WindowMetrics computeMaximumWindowMetrics(@NotNull Context context0) {
        q.g(context0, "context");
        return WindowMetricsCompatHelper.Companion.getInstance().maximumWindowMetrics(context0, this.densityCompatHelper);
    }

    @NotNull
    public final ArrayList getInsetsTypeMasks$window_release() {
        return this.insetsTypeMasks;
    }
}

