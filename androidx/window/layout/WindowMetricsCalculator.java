package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import androidx.window.core.Bounds;
import androidx.window.layout.util.WindowMetricsCompatHelper;
import ie.l;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&J\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0010\u0010\b\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&J\u0010\u0010\b\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0007H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Landroidx/window/layout/WindowMetricsCalculator;", "", "computeCurrentWindowMetrics", "Landroidx/window/layout/WindowMetrics;", "activity", "Landroid/app/Activity;", "context", "Landroid/content/Context;", "computeMaximumWindowMetrics", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public interface WindowMetricsCalculator {
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\f\u001A\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\u0003J\u001F\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u000FH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0019\u001A\u00020\u00112\u0006\u0010\u0016\u001A\u00020\u0015H\u0000¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u001B\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001A8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001B\u0010\u001CR\u0014\u0010\u001E\u001A\u00020\u001D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001E\u0010\u001F¨\u0006 "}, d2 = {"Landroidx/window/layout/WindowMetricsCalculator$Companion;", "", "<init>", "()V", "Landroidx/window/layout/WindowMetricsCalculator;", "getOrCreate", "()Landroidx/window/layout/WindowMetricsCalculator;", "Landroidx/window/layout/WindowMetricsCalculatorDecorator;", "overridingDecorator", "Lie/H;", "overrideDecorator", "(Landroidx/window/layout/WindowMetricsCalculatorDecorator;)V", "reset", "Landroid/view/WindowMetrics;", "windowMetrics", "", "density", "Landroidx/window/layout/WindowMetrics;", "translateWindowMetrics$window_release", "(Landroid/view/WindowMetrics;F)Landroidx/window/layout/WindowMetrics;", "translateWindowMetrics", "Landroid/util/DisplayMetrics;", "displayMetrics", "fromDisplayMetrics$window_release", "(Landroid/util/DisplayMetrics;)Landroidx/window/layout/WindowMetrics;", "fromDisplayMetrics", "Lkotlin/Function1;", "decorator", "Lwe/k;", "Landroidx/window/layout/WindowMetricsCalculatorCompat;", "windowMetricsCalculatorCompat", "Landroidx/window/layout/WindowMetricsCalculatorCompat;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        static final Companion $$INSTANCE;
        @NotNull
        private static k decorator;
        @NotNull
        private static final WindowMetricsCalculatorCompat windowMetricsCalculatorCompat;

        static {
            Companion.$$INSTANCE = new Companion();
            Companion.decorator = WindowMetricsCalculator.Companion.decorator.1.INSTANCE;
            Companion.windowMetricsCalculatorCompat = new WindowMetricsCalculatorCompat(null, 1, null);
        }

        @NotNull
        public final WindowMetrics fromDisplayMetrics$window_release(@NotNull DisplayMetrics displayMetrics0) {
            q.g(displayMetrics0, "displayMetrics");
            return new WindowMetrics(new Bounds(0, 0, displayMetrics0.widthPixels, displayMetrics0.heightPixels), displayMetrics0.density);
        }

        @NotNull
        public final WindowMetricsCalculator getOrCreate() {
            return (WindowMetricsCalculator)Companion.decorator.invoke(Companion.windowMetricsCalculatorCompat);
        }

        public final void overrideDecorator(@NotNull WindowMetricsCalculatorDecorator windowMetricsCalculatorDecorator0) {
            q.g(windowMetricsCalculatorDecorator0, "overridingDecorator");
            Companion.decorator = new k() {
                {
                    super(1, 0, WindowMetricsCalculatorDecorator.class, object0, "decorate", "decorate(Landroidx/window/layout/WindowMetricsCalculator;)Landroidx/window/layout/WindowMetricsCalculator;");
                }

                public final WindowMetricsCalculator invoke(WindowMetricsCalculator windowMetricsCalculator0) {
                    q.g(windowMetricsCalculator0, "p0");
                    return ((WindowMetricsCalculatorDecorator)this.receiver).decorate(windowMetricsCalculator0);
                }

                @Override  // we.k
                public Object invoke(Object object0) {
                    return this.invoke(((WindowMetricsCalculator)object0));
                }
            };
        }

        public final void reset() {
            Companion.decorator = androidx.window.layout.WindowMetricsCalculator.Companion.reset.1.INSTANCE;

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/window/layout/WindowMetricsCalculator;", "it", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
            final class androidx.window.layout.WindowMetricsCalculator.Companion.reset.1 extends r implements k {
                public static final androidx.window.layout.WindowMetricsCalculator.Companion.reset.1 INSTANCE;

                static {
                    androidx.window.layout.WindowMetricsCalculator.Companion.reset.1.INSTANCE = new androidx.window.layout.WindowMetricsCalculator.Companion.reset.1();
                }

                public androidx.window.layout.WindowMetricsCalculator.Companion.reset.1() {
                    super(1);
                }

                public final WindowMetricsCalculator invoke(WindowMetricsCalculator windowMetricsCalculator0) {
                    q.g(windowMetricsCalculator0, "it");
                    return windowMetricsCalculator0;
                }

                @Override  // we.k
                public Object invoke(Object object0) {
                    return this.invoke(((WindowMetricsCalculator)object0));
                }
            }

        }

        @NotNull
        public final WindowMetrics translateWindowMetrics$window_release(@NotNull android.view.WindowMetrics windowMetrics0, float f) {
            q.g(windowMetrics0, "windowMetrics");
            return WindowMetricsCompatHelper.Companion.getInstance().translateWindowMetrics(windowMetrics0, f);
        }
    }

    @NotNull
    public static final Companion Companion;

    static {
        WindowMetricsCalculator.Companion = Companion.$$INSTANCE;
    }

    @NotNull
    WindowMetrics computeCurrentWindowMetrics(@NotNull Activity arg1);

    @NotNull
    default WindowMetrics computeCurrentWindowMetrics(@NotNull Context context0) {
        q.g(context0, "context");
        throw new l("Must override computeCurrentWindowMetrics(context) and provide an implementation.");  // 初始化器: Ljava/lang/Error;-><init>(Ljava/lang/String;)V
    }

    @NotNull
    WindowMetrics computeMaximumWindowMetrics(@NotNull Activity arg1);

    @NotNull
    default WindowMetrics computeMaximumWindowMetrics(@NotNull Context context0) {
        q.g(context0, "context");
        throw new l("Must override computeMaximumWindowMetrics(context) and provide an implementation.");  // 初始化器: Ljava/lang/Error;-><init>(Ljava/lang/String;)V
    }

    @NotNull
    static WindowMetricsCalculator getOrCreate() {
        return WindowMetricsCalculator.Companion.getOrCreate();
    }

    static void overrideDecorator(@NotNull WindowMetricsCalculatorDecorator windowMetricsCalculatorDecorator0) {
        WindowMetricsCalculator.Companion.overrideDecorator(windowMetricsCalculatorDecorator0);
    }

    static void reset() {
        WindowMetricsCalculator.Companion.reset();
    }
}

