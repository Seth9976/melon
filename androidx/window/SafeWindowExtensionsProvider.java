package androidx.window;

import androidx.window.extensions.WindowExtensions;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.reflection.ReflectionUtils;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000F\u001A\u00020\u0010H\u0002J\r\u0010\u0011\u001A\u00020\u0010H\u0000¢\u0006\u0002\b\u0012R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001A\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001A\u0006\u0012\u0002\b\u00030\n8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\fR\u0018\u0010\r\u001A\u0006\u0012\u0002\b\u00030\n8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\f¨\u0006\u0013"}, d2 = {"Landroidx/window/SafeWindowExtensionsProvider;", "", "loader", "Ljava/lang/ClassLoader;", "(Ljava/lang/ClassLoader;)V", "windowExtensions", "Landroidx/window/extensions/WindowExtensions;", "getWindowExtensions", "()Landroidx/window/extensions/WindowExtensions;", "windowExtensionsClass", "Ljava/lang/Class;", "getWindowExtensionsClass$window_release", "()Ljava/lang/Class;", "windowExtensionsProviderClass", "getWindowExtensionsProviderClass", "isWindowExtensionsPresent", "", "isWindowExtensionsValid", "isWindowExtensionsValid$window_release", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class SafeWindowExtensionsProvider {
    @NotNull
    private final ClassLoader loader;

    public SafeWindowExtensionsProvider(@NotNull ClassLoader classLoader0) {
        q.g(classLoader0, "loader");
        super();
        this.loader = classLoader0;
    }

    @Nullable
    public final WindowExtensions getWindowExtensions() {
        try {
            return !this.isWindowExtensionsPresent() || !this.isWindowExtensionsValid$window_release() ? null : WindowExtensionsProvider.getWindowExtensions();
        }
        catch(Exception unused_ex) {
        }
        return null;
    }

    @NotNull
    public final Class getWindowExtensionsClass$window_release() {
        Class class0 = this.loader.loadClass("androidx.window.extensions.WindowExtensions");
        q.f(class0, "loadClass(...)");
        return class0;
    }

    private final Class getWindowExtensionsProviderClass() {
        Class class0 = this.loader.loadClass("androidx.window.extensions.WindowExtensionsProvider");
        q.f(class0, "loadClass(...)");
        return class0;
    }

    private final boolean isWindowExtensionsPresent() {
        androidx.window.SafeWindowExtensionsProvider.isWindowExtensionsPresent.1 safeWindowExtensionsProvider$isWindowExtensionsPresent$10 = new a() {
            {
                SafeWindowExtensionsProvider.this = safeWindowExtensionsProvider0;
                super(0);
            }

            public final Class invoke() {
                Class class0 = SafeWindowExtensionsProvider.this.loader.loadClass("androidx.window.extensions.WindowExtensionsProvider");
                q.f(class0, "loadClass(...)");
                return class0;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        return ReflectionUtils.INSTANCE.checkIsPresent$window_release(safeWindowExtensionsProvider$isWindowExtensionsPresent$10);
    }

    // 去混淆评级： 低(20)
    public final boolean isWindowExtensionsValid$window_release() {
        return this.isWindowExtensionsPresent() && ReflectionUtils.validateReflection$window_release("WindowExtensionsProvider#getWindowExtensions is not valid", new a() {
            {
                SafeWindowExtensionsProvider.this = safeWindowExtensionsProvider0;
                super(0);
            }

            public final Boolean invoke() {
                Method method0 = SafeWindowExtensionsProvider.this.getWindowExtensionsProviderClass().getDeclaredMethod("getWindowExtensions", null);
                Class class0 = SafeWindowExtensionsProvider.this.getWindowExtensionsClass$window_release();
                q.d(method0);
                return !ReflectionUtils.INSTANCE.doesReturn$window_release(method0, class0) || !ReflectionUtils.INSTANCE.isPublic$window_release(method0) ? false : true;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
    }
}

