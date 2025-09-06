package androidx.window.layout.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.WindowManager;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0016J\u0010\u0010\u0007\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\tH\u0016¨\u0006\n"}, d2 = {"Landroidx/window/layout/util/BoundsHelperApi30Impl;", "Landroidx/window/layout/util/BoundsHelper;", "()V", "currentWindowBounds", "Landroid/graphics/Rect;", "activity", "Landroid/app/Activity;", "maximumWindowBounds", "context", "Landroid/content/Context;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class BoundsHelperApi30Impl implements BoundsHelper {
    @NotNull
    public static final BoundsHelperApi30Impl INSTANCE;

    static {
        BoundsHelperApi30Impl.INSTANCE = new BoundsHelperApi30Impl();
    }

    @Override  // androidx.window.layout.util.BoundsHelper
    @NotNull
    public Rect currentWindowBounds(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        Rect rect0 = ((WindowManager)activity0.getSystemService(WindowManager.class)).getCurrentWindowMetrics().getBounds();
        q.f(rect0, "getBounds(...)");
        return rect0;
    }

    @Override  // androidx.window.layout.util.BoundsHelper
    @NotNull
    public Rect maximumWindowBounds(@NotNull Context context0) {
        q.g(context0, "context");
        Rect rect0 = ((WindowManager)context0.getSystemService(WindowManager.class)).getMaximumWindowMetrics().getBounds();
        q.f(rect0, "getBounds(...)");
        return rect0;
    }
}

