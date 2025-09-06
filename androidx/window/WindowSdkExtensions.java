package androidx.window;

import Ce.g;
import U4.x;
import androidx.window.core.ExtensionsUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001A\u00020\u00062\b\b\u0001\u0010\u0005\u001A\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\nH\u0000¢\u0006\u0004\b\u0007\u0010\fR\u001A\u0010\r\u001A\u00020\u00048WX\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0012"}, d2 = {"Landroidx/window/WindowSdkExtensions;", "", "<init>", "()V", "", "version", "Lie/H;", "requireExtensionVersion$window_release", "(I)V", "requireExtensionVersion", "LCe/g;", "range", "(LCe/g;)V", "extensionVersion", "I", "getExtensionVersion", "()I", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public abstract class WindowSdkExtensions {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\f\u001A\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\u0003R\u0016\u0010\r\u001A\u00020\u00078\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Landroidx/window/WindowSdkExtensions$Companion;", "", "<init>", "()V", "Landroidx/window/WindowSdkExtensions;", "getInstance", "()Landroidx/window/WindowSdkExtensions;", "Landroidx/window/WindowSdkExtensionsDecorator;", "overridingDecorator", "Lie/H;", "overrideDecorator", "(Landroidx/window/WindowSdkExtensionsDecorator;)V", "reset", "decorator", "Landroidx/window/WindowSdkExtensionsDecorator;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final WindowSdkExtensions getInstance() {
            return WindowSdkExtensions.decorator.decorate(new androidx.window.WindowSdkExtensions.Companion.getInstance.1());

            @Metadata(d1 = {"\u0000\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"androidx/window/WindowSdkExtensions$Companion$getInstance$1", "Landroidx/window/WindowSdkExtensions;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
            public final class androidx.window.WindowSdkExtensions.Companion.getInstance.1 extends WindowSdkExtensions {
            }

        }

        public final void overrideDecorator(@NotNull WindowSdkExtensionsDecorator windowSdkExtensionsDecorator0) {
            q.g(windowSdkExtensionsDecorator0, "overridingDecorator");
            WindowSdkExtensions.decorator = windowSdkExtensionsDecorator0;
        }

        public final void reset() {
            WindowSdkExtensions.decorator = EmptyDecoratorWindowSdk.INSTANCE;
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private static WindowSdkExtensionsDecorator decorator;
    private final int extensionVersion;

    static {
        WindowSdkExtensions.Companion = new Companion(null);
        WindowSdkExtensions.decorator = EmptyDecoratorWindowSdk.INSTANCE;
    }

    public WindowSdkExtensions() {
        this.extensionVersion = ExtensionsUtil.INSTANCE.getSafeVendorApiLevel();
    }

    public int getExtensionVersion() {
        return this.extensionVersion;
    }

    @NotNull
    public static final WindowSdkExtensions getInstance() {
        return WindowSdkExtensions.Companion.getInstance();
    }

    public final void requireExtensionVersion$window_release(int v) {
        if(this.getExtensionVersion() >= v) {
            return;
        }
        StringBuilder stringBuilder0 = x.n(v, "This API requires extension version ", ", but the device is on ");
        stringBuilder0.append(this.getExtensionVersion());
        throw new UnsupportedOperationException(stringBuilder0.toString());
    }

    public final void requireExtensionVersion$window_release(@NotNull g g0) {
        q.g(g0, "range");
        int v = this.getExtensionVersion();
        if(g0.a > v || v > g0.b) {
            throw new UnsupportedOperationException("This API requires extension version " + g0 + ", but the device is on " + this.getExtensionVersion());
        }
    }
}

