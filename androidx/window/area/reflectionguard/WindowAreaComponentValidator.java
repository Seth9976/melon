package androidx.window.area.reflectionguard;

import androidx.window.extensions.area.ExtensionWindowAreaPresentation;
import androidx.window.reflection.ReflectionUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001A\u00020\u00042\n\u0010\u0005\u001A\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0000¢\u0006\u0002\b\tJ!\u0010\n\u001A\u00020\u00042\n\u0010\u000B\u001A\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0000¢\u0006\u0002\b\fJ!\u0010\r\u001A\u00020\u00042\n\u0010\u000E\u001A\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0000¢\u0006\u0002\b\u000F¨\u0006\u0010"}, d2 = {"Landroidx/window/area/reflectionguard/WindowAreaComponentValidator;", "", "()V", "isExtensionWindowAreaPresentationValid", "", "extensionWindowAreaPresentation", "Ljava/lang/Class;", "apiLevel", "", "isExtensionWindowAreaPresentationValid$window_release", "isExtensionWindowAreaStatusValid", "extensionWindowAreaStatus", "isExtensionWindowAreaStatusValid$window_release", "isWindowAreaComponentValid", "windowAreaComponent", "isWindowAreaComponentValid$window_release", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class WindowAreaComponentValidator {
    @NotNull
    public static final WindowAreaComponentValidator INSTANCE;

    static {
        WindowAreaComponentValidator.INSTANCE = new WindowAreaComponentValidator();
    }

    public final boolean isExtensionWindowAreaPresentationValid$window_release(@NotNull Class class0, int v) {
        q.g(class0, "extensionWindowAreaPresentation");
        return v > 2 ? ReflectionUtils.INSTANCE.validateImplementation$window_release(class0, ExtensionWindowAreaPresentation.class) : false;
    }

    public final boolean isExtensionWindowAreaStatusValid$window_release(@NotNull Class class0, int v) {
        q.g(class0, "extensionWindowAreaStatus");
        return v > 2 ? ReflectionUtils.INSTANCE.validateImplementation$window_release(class0, ExtensionWindowAreaStatusRequirements.class) : false;
    }

    public final boolean isWindowAreaComponentValid$window_release(@NotNull Class class0, int v) {
        q.g(class0, "windowAreaComponent");
        return v > 2 ? ReflectionUtils.INSTANCE.validateImplementation$window_release(class0, WindowAreaComponentApi3Requirements.class) : false;
    }
}

