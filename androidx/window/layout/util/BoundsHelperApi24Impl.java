package androidx.window.layout.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0016J\u0010\u0010\u0007\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\tH\u0016¨\u0006\n"}, d2 = {"Landroidx/window/layout/util/BoundsHelperApi24Impl;", "Landroidx/window/layout/util/BoundsHelper;", "()V", "currentWindowBounds", "Landroid/graphics/Rect;", "activity", "Landroid/app/Activity;", "maximumWindowBounds", "context", "Landroid/content/Context;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class BoundsHelperApi24Impl implements BoundsHelper {
    @NotNull
    public static final BoundsHelperApi24Impl INSTANCE;

    static {
        BoundsHelperApi24Impl.INSTANCE = new BoundsHelperApi24Impl();
    }

    @Override  // androidx.window.layout.util.BoundsHelper
    @NotNull
    public Rect currentWindowBounds(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        Rect rect0 = new Rect();
        Display display0 = activity0.getWindowManager().getDefaultDisplay();
        display0.getRectSize(rect0);
        if(!ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(activity0)) {
            Point point0 = DisplayHelper.INSTANCE.getRealSizeForDisplay(display0);
            int v = BoundsHelperKt.access$getNavigationBarHeight(activity0);
            int v1 = rect0.bottom;
            if(v1 + v == point0.y) {
                rect0.bottom = v1 + v;
                return rect0;
            }
            int v2 = rect0.right;
            if(v2 + v == point0.x) {
                rect0.right = v2 + v;
            }
        }
        return rect0;
    }

    @Override  // androidx.window.layout.util.BoundsHelper
    @NotNull
    public Rect maximumWindowBounds(@NotNull Context context0) {
        q.g(context0, "context");
        return BoundsHelperApi16Impl.INSTANCE.maximumWindowBounds(context0);
    }
}

