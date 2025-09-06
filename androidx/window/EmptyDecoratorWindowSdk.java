package androidx.window;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Landroidx/window/EmptyDecoratorWindowSdk;", "Landroidx/window/WindowSdkExtensionsDecorator;", "()V", "decorate", "Landroidx/window/WindowSdkExtensions;", "windowSdkExtensions", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class EmptyDecoratorWindowSdk implements WindowSdkExtensionsDecorator {
    @NotNull
    public static final EmptyDecoratorWindowSdk INSTANCE;

    static {
        EmptyDecoratorWindowSdk.INSTANCE = new EmptyDecoratorWindowSdk();
    }

    @Override  // androidx.window.WindowSdkExtensionsDecorator
    @NotNull
    public WindowSdkExtensions decorate(@NotNull WindowSdkExtensions windowSdkExtensions0) {
        q.g(windowSdkExtensions0, "windowSdkExtensions");
        return windowSdkExtensions0;
    }
}

