package androidx.window.layout.util;

import android.graphics.Point;
import android.view.Display;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006¨\u0006\u0007"}, d2 = {"Landroidx/window/layout/util/DisplayHelper;", "", "()V", "getRealSizeForDisplay", "Landroid/graphics/Point;", "display", "Landroid/view/Display;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class DisplayHelper {
    @NotNull
    public static final DisplayHelper INSTANCE;

    static {
        DisplayHelper.INSTANCE = new DisplayHelper();
    }

    @NotNull
    public final Point getRealSizeForDisplay(@NotNull Display display0) {
        q.g(display0, "display");
        Point point0 = new Point();
        display0.getRealSize(point0);
        return point0;
    }
}

