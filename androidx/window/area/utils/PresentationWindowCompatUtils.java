package androidx.window.area.utils;

import android.annotation.SuppressLint;
import android.view.Window;
import androidx.window.extensions.area.ExtensionWindowAreaPresentation;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0007J\u0012\u0010\u0007\u001A\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001A\u00020\u0006H\u0002¨\u0006\t"}, d2 = {"Landroidx/window/area/utils/PresentationWindowCompatUtils;", "", "()V", "getWindowBeforeVendorApiLevel4", "Landroid/view/Window;", "extensionPresentation", "Landroidx/window/extensions/area/ExtensionWindowAreaPresentation;", "getWindowMethod", "Ljava/lang/reflect/Method;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class PresentationWindowCompatUtils {
    @NotNull
    public static final PresentationWindowCompatUtils INSTANCE;

    static {
        PresentationWindowCompatUtils.INSTANCE = new PresentationWindowCompatUtils();
    }

    @SuppressLint({"BanUncheckedReflection"})
    @Nullable
    public final Window getWindowBeforeVendorApiLevel4(@NotNull ExtensionWindowAreaPresentation extensionWindowAreaPresentation0) {
        q.g(extensionWindowAreaPresentation0, "extensionPresentation");
        Method method0 = this.getWindowMethod(extensionWindowAreaPresentation0);
        return method0 == null ? null : ((Window)method0.invoke(extensionWindowAreaPresentation0, null));
    }

    private final Method getWindowMethod(ExtensionWindowAreaPresentation extensionWindowAreaPresentation0) {
        Method[] arr_method = extensionWindowAreaPresentation0.getClass().getMethods();
        q.f(arr_method, "getMethods(...)");
        for(int v = 0; true; ++v) {
            String s = null;
            if(v >= arr_method.length) {
                break;
            }
            Method method0 = arr_method[v];
            if(method0 != null) {
                s = method0.getName();
            }
            if(q.b(s, "getWindow") && q.b(method0.getReturnType(), Window.class)) {
                return method0;
            }
        }
        return null;
    }
}

