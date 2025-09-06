package androidx.window.layout.util;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.view.WindowMetrics;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&J\u0018\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000BÀ\u0006\u0001"}, d2 = {"Landroidx/window/layout/util/DensityCompatHelper;", "", "density", "", "context", "Landroid/content/Context;", "configuration", "Landroid/content/res/Configuration;", "windowMetrics", "Landroid/view/WindowMetrics;", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public interface DensityCompatHelper {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001A\u00020\u0004¨\u0006\u0005"}, d2 = {"Landroidx/window/layout/util/DensityCompatHelper$Companion;", "", "()V", "getInstance", "Landroidx/window/layout/util/DensityCompatHelper;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        static final Companion $$INSTANCE;

        static {
            Companion.$$INSTANCE = new Companion();
        }

        @NotNull
        public final DensityCompatHelper getInstance() {
            return Build.VERSION.SDK_INT >= 34 ? DensityCompatHelperApi34Impl.INSTANCE : DensityCompatHelperBaseImpl.INSTANCE;
        }
    }

    @NotNull
    public static final Companion Companion;

    static {
        DensityCompatHelper.Companion = Companion.$$INSTANCE;
    }

    float density(@NotNull Context arg1);

    float density(@NotNull Configuration arg1, @NotNull WindowMetrics arg2);
}

