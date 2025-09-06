package androidx.window.area;

import android.os.Build.VERSION;
import androidx.window.SafeWindowExtensionsProvider;
import androidx.window.area.reflectionguard.WindowAreaComponentValidator;
import androidx.window.core.ExtensionsUtil;
import androidx.window.extensions.WindowExtensions;
import androidx.window.extensions.area.WindowAreaComponent;
import androidx.window.reflection.ReflectionUtils;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0011\u001A\u00020\u0001H\u0002R\u0018\u0010\u0005\u001A\u0006\u0012\u0002\b\u00030\u00068BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001A\u0006\u0012\u0002\b\u00030\u00068BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\bR\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000B\u001A\u0004\u0018\u00010\f8F¢\u0006\u0006\u001A\u0004\b\r\u0010\u000ER\u0018\u0010\u000F\u001A\u0006\u0012\u0002\b\u00030\u00068BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\bR\u0010\u0010\u0011\u001A\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/window/area/SafeWindowAreaComponentProvider;", "", "loader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "extensionWindowAreaPresentationClass", "Ljava/lang/Class;", "getExtensionWindowAreaPresentationClass", "()Ljava/lang/Class;", "extensionWindowAreaStatusClass", "getExtensionWindowAreaStatusClass", "windowAreaComponent", "Landroidx/window/extensions/area/WindowAreaComponent;", "getWindowAreaComponent", "()Landroidx/window/extensions/area/WindowAreaComponent;", "windowAreaComponentClass", "getWindowAreaComponentClass", "windowExtensions", "Landroidx/window/extensions/WindowExtensions;", "isWindowAreaProviderValid", "", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class SafeWindowAreaComponentProvider {
    @NotNull
    private final ClassLoader loader;
    @Nullable
    private final WindowExtensions windowExtensions;

    public SafeWindowAreaComponentProvider(@NotNull ClassLoader classLoader0) {
        q.g(classLoader0, "loader");
        super();
        this.loader = classLoader0;
        this.windowExtensions = new SafeWindowExtensionsProvider(classLoader0).getWindowExtensions();
    }

    private final Class getExtensionWindowAreaPresentationClass() {
        Class class0 = this.loader.loadClass("androidx.window.extensions.area.ExtensionWindowAreaPresentation");
        q.f(class0, "loadClass(...)");
        return class0;
    }

    private final Class getExtensionWindowAreaStatusClass() {
        Class class0 = this.loader.loadClass("androidx.window.extensions.area.ExtensionWindowAreaStatus");
        q.f(class0, "loadClass(...)");
        return class0;
    }

    @Nullable
    public final WindowAreaComponent getWindowAreaComponent() {
        try {
            if(this.windowExtensions != null && this.isWindowAreaProviderValid(this.windowExtensions) && Build.VERSION.SDK_INT >= 29) {
                Class class0 = this.getWindowAreaComponentClass();
                return !WindowAreaComponentValidator.INSTANCE.isWindowAreaComponentValid$window_release(class0, ExtensionsUtil.INSTANCE.getSafeVendorApiLevel()) || !WindowAreaComponentValidator.INSTANCE.isExtensionWindowAreaStatusValid$window_release(this.getExtensionWindowAreaStatusClass(), ExtensionsUtil.INSTANCE.getSafeVendorApiLevel()) || !WindowAreaComponentValidator.INSTANCE.isExtensionWindowAreaPresentationValid$window_release(this.getExtensionWindowAreaPresentationClass(), ExtensionsUtil.INSTANCE.getSafeVendorApiLevel()) ? null : this.windowExtensions.getWindowAreaComponent();
            }
        }
        catch(Throwable unused_ex) {
        }
        return null;
    }

    private final Class getWindowAreaComponentClass() {
        Class class0 = this.loader.loadClass("androidx.window.extensions.area.WindowAreaComponent");
        q.f(class0, "loadClass(...)");
        return class0;
    }

    private final boolean isWindowAreaProviderValid(Object object0) {
        return ReflectionUtils.validateReflection$window_release("WindowExtensions#getWindowAreaComponent is not valid", new a(this) {
            final Object $windowExtensions;

            {
                this.$windowExtensions = object0;
                SafeWindowAreaComponentProvider.this = safeWindowAreaComponentProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = this.$windowExtensions.getClass().getMethod("getWindowAreaComponent", null);
                q.d(method0);
                return !ReflectionUtils.INSTANCE.isPublic$window_release(method0) || !ReflectionUtils.INSTANCE.doesReturn$window_release(method0, SafeWindowAreaComponentProvider.this.getWindowAreaComponentClass()) ? false : true;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }
}

