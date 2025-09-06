package androidx.window.layout.adapter.extensions;

import android.content.Context;
import androidx.window.RequiresWindowSdkExtension;
import androidx.window.core.ConsumerAdapter;
import androidx.window.core.ExtensionsUtil;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.layout.adapter.WindowBackend;
import b2.a;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001A2\u00020\u0001:\u0001\u001AB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005H\u0097\u0001¢\u0006\u0004\b\u0006\u0010\u0007J.\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\fH\u0096\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001E\u0010\u0012\u001A\u00020\u000F2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\r0\fH\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0002\u001A\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0014R\u001A\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00160\u00158WX\u0097\u0005¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018¨\u0006\u001B"}, d2 = {"Landroidx/window/layout/adapter/extensions/ExtensionWindowBackend;", "Landroidx/window/layout/adapter/WindowBackend;", "backend", "<init>", "(Landroidx/window/layout/adapter/WindowBackend;)V", "", "hasRegisteredListeners", "()Z", "Landroid/content/Context;", "context", "Ljava/util/concurrent/Executor;", "executor", "Lb2/a;", "Landroidx/window/layout/WindowLayoutInfo;", "callback", "Lie/H;", "registerLayoutChangeCallback", "(Landroid/content/Context;Ljava/util/concurrent/Executor;Lb2/a;)V", "unregisterLayoutChangeCallback", "(Lb2/a;)V", "Landroidx/window/layout/adapter/WindowBackend;", "", "Landroidx/window/layout/SupportedPosture;", "getSupportedPostures", "()Ljava/util/List;", "supportedPostures", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ExtensionWindowBackend implements WindowBackend {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b¨\u0006\t"}, d2 = {"Landroidx/window/layout/adapter/extensions/ExtensionWindowBackend$Companion;", "", "()V", "newInstance", "Landroidx/window/layout/adapter/WindowBackend;", "component", "Landroidx/window/extensions/layout/WindowLayoutComponent;", "adapter", "Landroidx/window/core/ConsumerAdapter;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final WindowBackend newInstance(@NotNull WindowLayoutComponent windowLayoutComponent0, @NotNull ConsumerAdapter consumerAdapter0) {
            q.g(windowLayoutComponent0, "component");
            q.g(consumerAdapter0, "adapter");
            int v = ExtensionsUtil.INSTANCE.getSafeVendorApiLevel();
            if(v >= 6) {
                return new ExtensionWindowBackendApi6(windowLayoutComponent0, consumerAdapter0);
            }
            if(v >= 2) {
                return new ExtensionWindowBackendApi2(windowLayoutComponent0, consumerAdapter0);
            }
            return v == 1 ? new ExtensionWindowBackendApi1(windowLayoutComponent0, consumerAdapter0) : new ExtensionWindowBackendApi0();
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final WindowBackend backend;

    static {
        ExtensionWindowBackend.Companion = new Companion(null);
    }

    public ExtensionWindowBackend(@NotNull WindowBackend windowBackend0) {
        q.g(windowBackend0, "backend");
        super();
        this.backend = windowBackend0;
    }

    @Override  // androidx.window.layout.adapter.WindowBackend
    @RequiresWindowSdkExtension(version = 6)
    @NotNull
    public List getSupportedPostures() {
        return this.backend.getSupportedPostures();
    }

    @Override  // androidx.window.layout.adapter.WindowBackend
    public boolean hasRegisteredListeners() {
        return this.backend.hasRegisteredListeners();
    }

    @Override  // androidx.window.layout.adapter.WindowBackend
    public void registerLayoutChangeCallback(@NotNull Context context0, @NotNull Executor executor0, @NotNull a a0) {
        q.g(context0, "context");
        q.g(executor0, "executor");
        q.g(a0, "callback");
        this.backend.registerLayoutChangeCallback(context0, executor0, a0);
    }

    @Override  // androidx.window.layout.adapter.WindowBackend
    public void unregisterLayoutChangeCallback(@NotNull a a0) {
        q.g(a0, "callback");
        this.backend.unregisterLayoutChangeCallback(a0);
    }
}

