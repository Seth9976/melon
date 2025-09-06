package androidx.window.area;

import android.content.Context;
import android.view.View;
import android.view.Window;
import androidx.window.area.utils.PresentationWindowCompatUtils;
import androidx.window.core.ExperimentalWindowApi;
import androidx.window.extensions.area.ExtensionWindowAreaPresentation;
import androidx.window.extensions.area.WindowAreaComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalWindowApi
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u000F\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u001A\u0010\u0014\u001A\u00020\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\u0017R\u001C\u0010\u0019\u001A\u0004\u0018\u00010\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001C¨\u0006\u001D"}, d2 = {"Landroidx/window/area/RearDisplayPresentationSessionPresenterImpl;", "Landroidx/window/area/WindowAreaSessionPresenter;", "Landroidx/window/extensions/area/WindowAreaComponent;", "windowAreaComponent", "Landroidx/window/extensions/area/ExtensionWindowAreaPresentation;", "presentation", "", "vendorApiLevel", "<init>", "(Landroidx/window/extensions/area/WindowAreaComponent;Landroidx/window/extensions/area/ExtensionWindowAreaPresentation;I)V", "Landroid/view/View;", "view", "Lie/H;", "setContentView", "(Landroid/view/View;)V", "close", "()V", "Landroidx/window/extensions/area/WindowAreaComponent;", "Landroidx/window/extensions/area/ExtensionWindowAreaPresentation;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/view/Window;", "window", "Landroid/view/Window;", "getWindow", "()Landroid/view/Window;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class RearDisplayPresentationSessionPresenterImpl implements WindowAreaSessionPresenter {
    @NotNull
    private final Context context;
    @NotNull
    private final ExtensionWindowAreaPresentation presentation;
    @Nullable
    private final Window window;
    @NotNull
    private final WindowAreaComponent windowAreaComponent;

    public RearDisplayPresentationSessionPresenterImpl(@NotNull WindowAreaComponent windowAreaComponent0, @NotNull ExtensionWindowAreaPresentation extensionWindowAreaPresentation0, int v) {
        q.g(windowAreaComponent0, "windowAreaComponent");
        q.g(extensionWindowAreaPresentation0, "presentation");
        super();
        this.windowAreaComponent = windowAreaComponent0;
        this.presentation = extensionWindowAreaPresentation0;
        Context context0 = extensionWindowAreaPresentation0.getPresentationContext();
        q.f(context0, "getPresentationContext(...)");
        this.context = context0;
        this.window = v < 4 ? PresentationWindowCompatUtils.INSTANCE.getWindowBeforeVendorApiLevel4(extensionWindowAreaPresentation0) : extensionWindowAreaPresentation0.getWindow();
    }

    @Override  // androidx.window.area.WindowAreaSession
    public void close() {
        this.windowAreaComponent.endRearDisplayPresentationSession();
    }

    @Override  // androidx.window.area.WindowAreaSessionPresenter
    @NotNull
    public Context getContext() {
        return this.context;
    }

    @Override  // androidx.window.area.WindowAreaSessionPresenter
    @Nullable
    public Window getWindow() {
        return this.window;
    }

    @Override  // androidx.window.area.WindowAreaSessionPresenter
    public void setContentView(@NotNull View view0) {
        q.g(view0, "view");
        this.presentation.setPresentationView(view0);
    }
}

