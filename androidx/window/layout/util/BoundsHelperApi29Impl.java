package androidx.window.layout.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0017J\u0010\u0010\u0007\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\tH\u0016¨\u0006\n"}, d2 = {"Landroidx/window/layout/util/BoundsHelperApi29Impl;", "Landroidx/window/layout/util/BoundsHelper;", "()V", "currentWindowBounds", "Landroid/graphics/Rect;", "activity", "Landroid/app/Activity;", "maximumWindowBounds", "context", "Landroid/content/Context;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class BoundsHelperApi29Impl implements BoundsHelper {
    @NotNull
    public static final BoundsHelperApi29Impl INSTANCE;

    static {
        BoundsHelperApi29Impl.INSTANCE = new BoundsHelperApi29Impl();
    }

    @Override  // androidx.window.layout.util.BoundsHelper
    @SuppressLint({"BanUncheckedReflection", "BlockedPrivateApi"})
    @NotNull
    public Rect currentWindowBounds(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        Configuration configuration0 = activity0.getResources().getConfiguration();
        boolean z = true;
        try {
            Field field0 = Configuration.class.getDeclaredField("windowConfiguration");
            field0.setAccessible(true);
            Object object0 = field0.get(configuration0);
            Object object1 = object0.getClass().getDeclaredMethod("getBounds", null).invoke(object0, null);
            q.e(object1, "null cannot be cast to non-null type android.graphics.Rect");
            return new Rect(((Rect)object1));
        }
        catch(Exception exception0) {
            if(!((exception0 instanceof NoSuchFieldException ? true : exception0 instanceof NoSuchMethodException) ? true : exception0 instanceof IllegalAccessException)) {
                z = exception0 instanceof InvocationTargetException;
            }
            if(!z) {
                throw exception0;
            }
            Log.w("BoundsHelper", exception0);
            return BoundsHelperApi28Impl.INSTANCE.currentWindowBounds(activity0);
        }
    }

    @Override  // androidx.window.layout.util.BoundsHelper
    @NotNull
    public Rect maximumWindowBounds(@NotNull Context context0) {
        q.g(context0, "context");
        return BoundsHelperApi28Impl.INSTANCE.maximumWindowBounds(context0);
    }
}

