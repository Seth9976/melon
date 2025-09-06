package androidx.window.area;

import androidx.window.core.ExperimentalWindowApi;
import androidx.window.extensions.area.WindowAreaComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@ExperimentalWindowApi
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\t¨\u0006\n"}, d2 = {"Landroidx/window/area/RearDisplaySessionImpl;", "Landroidx/window/area/WindowAreaSession;", "Landroidx/window/extensions/area/WindowAreaComponent;", "windowAreaComponent", "<init>", "(Landroidx/window/extensions/area/WindowAreaComponent;)V", "Lie/H;", "close", "()V", "Landroidx/window/extensions/area/WindowAreaComponent;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class RearDisplaySessionImpl implements WindowAreaSession {
    @NotNull
    private final WindowAreaComponent windowAreaComponent;

    public RearDisplaySessionImpl(@NotNull WindowAreaComponent windowAreaComponent0) {
        q.g(windowAreaComponent0, "windowAreaComponent");
        super();
        this.windowAreaComponent = windowAreaComponent0;
    }

    @Override  // androidx.window.area.WindowAreaSession
    public void close() {
        this.windowAreaComponent.endRearDisplaySession();
    }
}

