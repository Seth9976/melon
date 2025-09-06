package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import androidx.window.RequiresWindowSdkExtension;
import androidx.window.WindowSdkExtensions;
import androidx.window.layout.adapter.WindowBackend;
import androidx.window.layout.adapter.sidecar.SidecarWindowBackend;
import d3.g;
import ie.j;
import ie.l;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J\u0016\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\u0006\u0010\f\u001A\u00020\rH&J\u0016\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016R \u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00038WX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001A\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Landroidx/window/layout/WindowInfoTracker;", "", "supportedPostures", "", "Landroidx/window/layout/SupportedPosture;", "getSupportedPostures$annotations", "()V", "getSupportedPostures", "()Ljava/util/List;", "windowLayoutInfo", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/window/layout/WindowLayoutInfo;", "activity", "Landroid/app/Activity;", "context", "Landroid/content/Context;", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public interface WindowInfoTracker {
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\u000BH\u0007¢\u0006\u0004\b\u000E\u0010\u0003R\u0014\u0010\u0010\u001A\u00020\u000F8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001A\u0004\u0018\u00010\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R#\u0010\u001B\u001A\u0004\u0018\u00010\u00158@X\u0080\u0084\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u001A\u0010\u0003\u001A\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001C\u001A\u00020\t8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001C\u0010\u001D¨\u0006\u001E"}, d2 = {"Landroidx/window/layout/WindowInfoTracker$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroidx/window/layout/WindowInfoTracker;", "getOrCreate", "(Landroid/content/Context;)Landroidx/window/layout/WindowInfoTracker;", "Landroidx/window/layout/WindowInfoTrackerDecorator;", "overridingDecorator", "Lie/H;", "overrideDecorator", "(Landroidx/window/layout/WindowInfoTrackerDecorator;)V", "reset", "", "DEBUG", "Z", "", "TAG", "Ljava/lang/String;", "Landroidx/window/layout/adapter/WindowBackend;", "extensionBackend$delegate", "Lie/j;", "getExtensionBackend$window_release", "()Landroidx/window/layout/adapter/WindowBackend;", "getExtensionBackend$window_release$annotations", "extensionBackend", "decorator", "Landroidx/window/layout/WindowInfoTrackerDecorator;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        static final Companion $$INSTANCE;
        private static final boolean DEBUG;
        @Nullable
        private static final String TAG;
        @NotNull
        private static WindowInfoTrackerDecorator decorator;
        @NotNull
        private static final j extensionBackend$delegate;

        static {
            Companion.$$INSTANCE = new Companion();
            Companion.TAG = I.a.b(WindowInfoTracker.class).m();
            Companion.extensionBackend$delegate = g.Q(WindowInfoTracker.Companion.extensionBackend.2.INSTANCE);
            Companion.decorator = EmptyDecorator.INSTANCE;
        }

        public static final boolean access$getDEBUG$p() [...] // 潜在的解密器

        public static final String access$getTAG$p() {
            return Companion.TAG;
        }

        @Nullable
        public final WindowBackend getExtensionBackend$window_release() {
            return (WindowBackend)Companion.extensionBackend$delegate.getValue();
        }

        public static void getExtensionBackend$window_release$annotations() {
        }

        @NotNull
        public final WindowInfoTracker getOrCreate(@NotNull Context context0) {
            q.g(context0, "context");
            WindowBackend windowBackend0 = this.getExtensionBackend$window_release();
            if(windowBackend0 == null) {
                windowBackend0 = SidecarWindowBackend.Companion.getInstance(context0);
            }
            WindowInfoTrackerImpl windowInfoTrackerImpl0 = new WindowInfoTrackerImpl(new WindowMetricsCalculatorCompat(null, 1, null), windowBackend0, WindowSdkExtensions.Companion.getInstance());
            return Companion.decorator.decorate(windowInfoTrackerImpl0);
        }

        public final void overrideDecorator(@NotNull WindowInfoTrackerDecorator windowInfoTrackerDecorator0) {
            q.g(windowInfoTrackerDecorator0, "overridingDecorator");
            Companion.decorator = windowInfoTrackerDecorator0;
        }

        public final void reset() {
            Companion.decorator = EmptyDecorator.INSTANCE;
        }
    }

    @NotNull
    public static final Companion Companion;

    static {
        WindowInfoTracker.Companion = Companion.$$INSTANCE;
    }

    @NotNull
    static WindowInfoTracker getOrCreate(@NotNull Context context0) {
        return WindowInfoTracker.Companion.getOrCreate(context0);
    }

    @RequiresWindowSdkExtension(version = 6)
    @NotNull
    default List getSupportedPostures() {
        throw new l("Method was not implemented.");  // 初始化器: Ljava/lang/Error;-><init>(Ljava/lang/String;)V
    }

    @RequiresWindowSdkExtension(version = 6)
    static void getSupportedPostures$annotations() {
    }

    static void overrideDecorator(@NotNull WindowInfoTrackerDecorator windowInfoTrackerDecorator0) {
        WindowInfoTracker.Companion.overrideDecorator(windowInfoTrackerDecorator0);
    }

    static void reset() {
        WindowInfoTracker.Companion.reset();
    }

    @NotNull
    Flow windowLayoutInfo(@NotNull Activity arg1);

    @NotNull
    default Flow windowLayoutInfo(@NotNull Context context0) {
        q.g(context0, "context");
        Flow flow0 = null;
        Activity activity0 = context0 instanceof Activity ? ((Activity)context0) : null;
        if(activity0 != null) {
            flow0 = this.windowLayoutInfo(activity0);
        }
        if(flow0 == null) {
            throw new l("Must override windowLayoutInfo(context) and provide an implementation.");  // 初始化器: Ljava/lang/Error;-><init>(Ljava/lang/String;)V
        }
        return flow0;
    }
}

