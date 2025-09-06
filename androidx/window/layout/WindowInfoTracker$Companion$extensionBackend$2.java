package androidx.window.layout;

import androidx.window.core.ConsumerAdapter;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.layout.adapter.WindowBackend;
import androidx.window.layout.adapter.extensions.ExtensionWindowBackend;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import we.a;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/window/layout/adapter/WindowBackend;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 0x30)
final class WindowInfoTracker.Companion.extensionBackend.2 extends r implements a {
    public static final WindowInfoTracker.Companion.extensionBackend.2 INSTANCE;

    static {
        WindowInfoTracker.Companion.extensionBackend.2.INSTANCE = new WindowInfoTracker.Companion.extensionBackend.2();
    }

    public WindowInfoTracker.Companion.extensionBackend.2() {
        super(0);
    }

    public final WindowBackend invoke() {
        try {
            ClassLoader classLoader0 = WindowInfoTracker.class.getClassLoader();
            SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider0 = classLoader0 == null ? null : new SafeWindowLayoutComponentProvider(classLoader0, new ConsumerAdapter(classLoader0));
            if(safeWindowLayoutComponentProvider0 != null) {
                WindowLayoutComponent windowLayoutComponent0 = safeWindowLayoutComponentProvider0.getWindowLayoutComponent();
                if(windowLayoutComponent0 != null) {
                    q.d(classLoader0);
                    ConsumerAdapter consumerAdapter0 = new ConsumerAdapter(classLoader0);
                    return ExtensionWindowBackend.Companion.newInstance(windowLayoutComponent0, consumerAdapter0);
                }
            }
        }
        catch(Throwable unused_ex) {
        }
        return null;
    }

    @Override  // we.a
    public Object invoke() {
        return this.invoke();
    }
}

