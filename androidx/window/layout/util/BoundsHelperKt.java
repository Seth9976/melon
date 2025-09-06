package androidx.window.layout.util;

import B0.q;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0017\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001A\u001F\u0010\n\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000B\u001A\u0019\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\r\u001A\u00020\fH\u0003¢\u0006\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroid/content/Context;", "context", "", "getNavigationBarHeight", "(Landroid/content/Context;)I", "Landroid/app/Activity;", "activity", "Landroid/graphics/Rect;", "bounds", "Lie/H;", "getRectSizeFromDisplay", "(Landroid/app/Activity;Landroid/graphics/Rect;)V", "Landroid/view/Display;", "display", "Landroid/view/DisplayCutout;", "getCutoutForDisplay", "(Landroid/view/Display;)Landroid/view/DisplayCutout;", "window_release"}, k = 2, mv = {1, 9, 0}, xi = 0x30)
public final class BoundsHelperKt {
    @SuppressLint({"BanUncheckedReflection"})
    private static final DisplayCutout getCutoutForDisplay(Display display0) {
        boolean z = true;
        try {
            Constructor constructor0 = Class.forName("android.view.DisplayInfo").getConstructor(null);
            constructor0.setAccessible(true);
            Object object0 = constructor0.newInstance(null);
            Method method0 = display0.getClass().getDeclaredMethod("getDisplayInfo", object0.getClass());
            method0.setAccessible(true);
            method0.invoke(display0, object0);
            Field field0 = object0.getClass().getDeclaredField("displayCutout");
            field0.setAccessible(true);
            Object object1 = field0.get(object0);
            return q.D(object1) ? ((DisplayCutout)object1) : null;
        }
        catch(Exception exception0) {
            if(!((((exception0 instanceof ClassNotFoundException ? true : exception0 instanceof NoSuchMethodException) ? true : exception0 instanceof NoSuchFieldException) ? true : exception0 instanceof IllegalAccessException) ? true : exception0 instanceof InvocationTargetException)) {
                z = exception0 instanceof InstantiationException;
            }
            if(!z) {
                throw exception0;
            }
            Log.w("BoundsHelper", exception0);
            return null;
        }
    }

    private static final int getNavigationBarHeight(Context context0) {
        Resources resources0 = context0.getResources();
        int v = resources0.getIdentifier("navigation_bar_height", "dimen", "android");
        return v <= 0 ? 0 : resources0.getDimensionPixelSize(v);
    }

    private static final void getRectSizeFromDisplay(Activity activity0, Rect rect0) {
        activity0.getWindowManager().getDefaultDisplay().getRectSize(rect0);
    }
}

