package androidx.window.layout.adapter.extensions;

import androidx.window.RequiresWindowSdkExtension;
import androidx.window.core.ConsumerAdapter;
import androidx.window.extensions.layout.SupportedWindowFeatures;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@RequiresWindowSdkExtension(version = 6)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001A\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Landroidx/window/layout/adapter/extensions/ExtensionWindowBackendApi6;", "Landroidx/window/layout/adapter/extensions/ExtensionWindowBackendApi2;", "component", "Landroidx/window/extensions/layout/WindowLayoutComponent;", "adapter", "Landroidx/window/core/ConsumerAdapter;", "(Landroidx/window/extensions/layout/WindowLayoutComponent;Landroidx/window/core/ConsumerAdapter;)V", "supportedPostures", "", "Landroidx/window/layout/SupportedPosture;", "getSupportedPostures", "()Ljava/util/List;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ExtensionWindowBackendApi6 extends ExtensionWindowBackendApi2 {
    public ExtensionWindowBackendApi6(@NotNull WindowLayoutComponent windowLayoutComponent0, @NotNull ConsumerAdapter consumerAdapter0) {
        q.g(windowLayoutComponent0, "component");
        q.g(consumerAdapter0, "adapter");
        super(windowLayoutComponent0, consumerAdapter0);
    }

    @Override  // androidx.window.layout.adapter.extensions.ExtensionWindowBackendApi1
    @NotNull
    public List getSupportedPostures() {
        SupportedWindowFeatures supportedWindowFeatures0 = this.getComponent().getSupportedWindowFeatures();
        q.f(supportedWindowFeatures0, "getSupportedWindowFeatures(...)");
        return ExtensionsWindowLayoutInfoAdapter.INSTANCE.translate$window_release(supportedWindowFeatures0);
    }
}

