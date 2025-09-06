package androidx.window.layout.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.WindowManager;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0016J\u0010\u0010\u0007\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\tH\u0016¨\u0006\n"}, d2 = {"Landroidx/window/layout/util/BoundsHelperApi16Impl;", "Landroidx/window/layout/util/BoundsHelper;", "()V", "currentWindowBounds", "Landroid/graphics/Rect;", "activity", "Landroid/app/Activity;", "maximumWindowBounds", "context", "Landroid/content/Context;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class BoundsHelperApi16Impl implements BoundsHelper {
    @NotNull
    public static final BoundsHelperApi16Impl INSTANCE;

    static {
        BoundsHelperApi16Impl.INSTANCE = new BoundsHelperApi16Impl();
    }

    @Override  // androidx.window.layout.util.BoundsHelper
    @NotNull
    public Rect currentWindowBounds(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        Display display0 = activity0.getWindowManager().getDefaultDisplay();
        q.d(display0);
        Point point0 = DisplayHelper.INSTANCE.getRealSizeForDisplay(display0);
        Rect rect0 = new Rect();
        int v = point0.x;
        if(v != 0) {
            int v1 = point0.y;
            if(v1 != 0) {
                rect0.right = v;
                rect0.bottom = v1;
                return rect0;
            }
        }
        display0.getRectSize(rect0);
        return rect0;
    }

    @Override  // androidx.window.layout.util.BoundsHelper
    @NotNull
    public Rect maximumWindowBounds(@NotNull Context context0) {
        q.g(context0, "context");
        Object object0 = context0.getSystemService("window");
        q.e(object0, "null cannot be cast to non-null type android.view.WindowManager");
        Display display0 = ((WindowManager)object0).getDefaultDisplay();
        q.d(display0);
        Point point0 = DisplayHelper.INSTANCE.getRealSizeForDisplay(display0);
        return new Rect(0, 0, point0.x, point0.y);
    }
}

