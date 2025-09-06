package androidx.window.area;

import android.app.Activity;
import android.os.Binder;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.window.core.BuildConfig;
import androidx.window.core.ExperimentalWindowApi;
import androidx.window.core.ExtensionsUtil;
import androidx.window.core.VerificationMode;
import androidx.window.extensions.area.WindowAreaComponent;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalWindowApi
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\'\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\r\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH&¢\u0006\u0004\b\r\u0010\u000EJ/\u0010\u0011\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\u000FH&¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0018\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00138&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017¨\u0006\u001A"}, d2 = {"Landroidx/window/area/WindowAreaController;", "", "<init>", "()V", "Landroid/os/Binder;", "token", "Landroid/app/Activity;", "activity", "Ljava/util/concurrent/Executor;", "executor", "Landroidx/window/area/WindowAreaSessionCallback;", "windowAreaSessionCallback", "Lie/H;", "transferActivityToWindowArea", "(Landroid/os/Binder;Landroid/app/Activity;Ljava/util/concurrent/Executor;Landroidx/window/area/WindowAreaSessionCallback;)V", "Landroidx/window/area/WindowAreaPresentationSessionCallback;", "windowAreaPresentationSessionCallback", "presentContentOnWindowArea", "(Landroid/os/Binder;Landroid/app/Activity;Ljava/util/concurrent/Executor;Landroidx/window/area/WindowAreaPresentationSessionCallback;)V", "Lkotlinx/coroutines/flow/Flow;", "", "Landroidx/window/area/WindowAreaInfo;", "getWindowAreaInfos", "()Lkotlinx/coroutines/flow/Flow;", "windowAreaInfos", "Companion", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public abstract class WindowAreaController {
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\f\u001A\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\u0003R\u0016\u0010\u000E\u001A\u0004\u0018\u00010\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000E\u0010\u000FR\u0016\u0010\u0010\u001A\u00020\u00078\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/window/area/WindowAreaController$Companion;", "", "<init>", "()V", "Landroidx/window/area/WindowAreaController;", "getOrCreate", "()Landroidx/window/area/WindowAreaController;", "Landroidx/window/area/WindowAreaControllerDecorator;", "overridingDecorator", "Lie/H;", "overrideDecorator", "(Landroidx/window/area/WindowAreaControllerDecorator;)V", "reset", "", "TAG", "Ljava/lang/String;", "decorator", "Landroidx/window/area/WindowAreaControllerDecorator;", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final WindowAreaController getOrCreate() {
            WindowAreaComponent windowAreaComponent0 = null;
            ClassLoader classLoader0 = Companion.class.getClassLoader();
            if(classLoader0 != null) {
                try {
                    windowAreaComponent0 = new SafeWindowAreaComponentProvider(classLoader0).getWindowAreaComponent();
                }
                catch(Throwable unused_ex) {
                    if(BuildConfig.INSTANCE.getVerificationMode() == VerificationMode.LOG) {
                        Log.d(WindowAreaController.access$getTAG$cp(), "Failed to load WindowExtensions");
                    }
                }
            }
            if(Build.VERSION.SDK_INT > 29 && windowAreaComponent0 != null && ExtensionsUtil.INSTANCE.getSafeVendorApiLevel() >= 3) {
                q.d(windowAreaComponent0);
                return WindowAreaController.decorator.decorate(new WindowAreaControllerImpl(windowAreaComponent0));
            }
            return WindowAreaController.decorator.decorate(new EmptyWindowAreaControllerImpl());
        }

        public final void overrideDecorator(@NotNull WindowAreaControllerDecorator windowAreaControllerDecorator0) {
            q.g(windowAreaControllerDecorator0, "overridingDecorator");
            WindowAreaController.decorator = windowAreaControllerDecorator0;
        }

        public final void reset() {
            WindowAreaController.decorator = EmptyDecorator.INSTANCE;
        }
    }

    @NotNull
    public static final Companion Companion;
    @Nullable
    private static final String TAG;
    @NotNull
    private static WindowAreaControllerDecorator decorator;

    static {
        WindowAreaController.Companion = new Companion(null);
        WindowAreaController.TAG = I.a.b(WindowAreaController.class).m();
        WindowAreaController.decorator = EmptyDecorator.INSTANCE;
    }

    public static final String access$getTAG$cp() {
        return WindowAreaController.TAG;
    }

    @NotNull
    public static final WindowAreaController getOrCreate() {
        return WindowAreaController.Companion.getOrCreate();
    }

    @NotNull
    public abstract Flow getWindowAreaInfos();

    public static final void overrideDecorator(@NotNull WindowAreaControllerDecorator windowAreaControllerDecorator0) {
        WindowAreaController.Companion.overrideDecorator(windowAreaControllerDecorator0);
    }

    public abstract void presentContentOnWindowArea(@NotNull Binder arg1, @NotNull Activity arg2, @NotNull Executor arg3, @NotNull WindowAreaPresentationSessionCallback arg4);

    public static final void reset() {
        WindowAreaController.Companion.reset();
    }

    public abstract void transferActivityToWindowArea(@NotNull Binder arg1, @NotNull Activity arg2, @NotNull Executor arg3, @NotNull WindowAreaSessionCallback arg4);
}

