package androidx.window.layout.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0017J\u0010\u0010\u0007\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\tH\u0016¨\u0006\n"}, d2 = {"Landroidx/window/layout/util/BoundsHelperApi28Impl;", "Landroidx/window/layout/util/BoundsHelper;", "()V", "currentWindowBounds", "Landroid/graphics/Rect;", "activity", "Landroid/app/Activity;", "maximumWindowBounds", "context", "Landroid/content/Context;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class BoundsHelperApi28Impl implements BoundsHelper {
    @NotNull
    public static final BoundsHelperApi28Impl INSTANCE;

    static {
        BoundsHelperApi28Impl.INSTANCE = new BoundsHelperApi28Impl();
    }

    @Override  // androidx.window.layout.util.BoundsHelper
    @SuppressLint({"BanUncheckedReflection", "BlockedPrivateApi"})
    @NotNull
    public Rect currentWindowBounds(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        Rect rect0 = new Rect();
        Configuration configuration0 = activity0.getResources().getConfiguration();
        boolean z = true;
        try {
            Field field0 = Configuration.class.getDeclaredField("windowConfiguration");
            field0.setAccessible(true);
            Object object0 = field0.get(configuration0);
            if(ActivityCompatHelperApi24.INSTANCE.isInMultiWindowMode(activity0)) {
                Object object1 = object0.getClass().getDeclaredMethod("getBounds", null).invoke(object0, null);
                q.e(object1, "null cannot be cast to non-null type android.graphics.Rect");
                rect0.set(((Rect)object1));
            }
            else {
                Object object2 = object0.getClass().getDeclaredMethod("getAppBounds", null).invoke(object0, null);
                q.e(object2, "null cannot be cast to non-null type android.graphics.Rect");
                rect0.set(((Rect)object2));
                goto label_24;
            label_17:
                if(!((exception0 instanceof NoSuchFieldException ? true : exception0 instanceof NoSuchMethodException) ? true : exception0 instanceof IllegalAccessException)) {
                    goto label_18;
                }
                goto label_19;
            }
            goto label_24;
        }
        catch(Exception exception0) {
            goto label_17;
        }
    label_18:
        z = exception0 instanceof InvocationTargetException;
    label_19:
        if(z) {
            Log.w("BoundsHelper", exception0);
            BoundsHelperKt.getRectSizeFromDisplay(activity0, rect0);
        }
        else {
            throw exception0;
        }
    label_24:
        Display display0 = activity0.getWindowManager().getDefaultDisplay();
        Point point0 = new Point();
        display0.getRealSize(point0);
        ActivityCompatHelperApi24 activityCompatHelperApi240 = ActivityCompatHelperApi24.INSTANCE;
        if(!activityCompatHelperApi240.isInMultiWindowMode(activity0)) {
            int v = BoundsHelperKt.getNavigationBarHeight(activity0);
            int v1 = rect0.bottom;
            if(v1 + v == point0.y) {
                rect0.bottom = v1 + v;
            }
            else {
                int v2 = rect0.right;
                if(v2 + v == point0.x) {
                    rect0.right = v2 + v;
                }
                else if(rect0.left == v) {
                    rect0.left = 0;
                }
            }
        }
        if((rect0.width() < point0.x || rect0.height() < point0.y) && !activityCompatHelperApi240.isInMultiWindowMode(activity0)) {
            DisplayCutout displayCutout0 = BoundsHelperKt.getCutoutForDisplay(display0);
            if(displayCutout0 != null) {
                DisplayCompatHelperApi28 displayCompatHelperApi280 = DisplayCompatHelperApi28.INSTANCE;
                if(rect0.left == displayCompatHelperApi280.safeInsetLeft(displayCutout0)) {
                    rect0.left = 0;
                }
                if(point0.x - rect0.right == displayCompatHelperApi280.safeInsetRight(displayCutout0)) {
                    int v3 = rect0.right;
                    rect0.right = displayCompatHelperApi280.safeInsetRight(displayCutout0) + v3;
                }
                if(rect0.top == displayCompatHelperApi280.safeInsetTop(displayCutout0)) {
                    rect0.top = 0;
                }
                if(point0.y - rect0.bottom == displayCompatHelperApi280.safeInsetBottom(displayCutout0)) {
                    int v4 = rect0.bottom;
                    rect0.bottom = displayCompatHelperApi280.safeInsetBottom(displayCutout0) + v4;
                }
            }
        }
        return rect0;
    }

    @Override  // androidx.window.layout.util.BoundsHelper
    @NotNull
    public Rect maximumWindowBounds(@NotNull Context context0) {
        q.g(context0, "context");
        return BoundsHelperApi24Impl.INSTANCE.maximumWindowBounds(context0);
    }
}

