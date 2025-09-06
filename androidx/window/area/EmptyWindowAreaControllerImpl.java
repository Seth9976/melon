package androidx.window.area;

import android.app.Activity;
import android.os.Binder;
import androidx.window.core.ExperimentalWindowApi;
import java.util.concurrent.Executor;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

@ExperimentalWindowApi
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\r\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000EJ/\u0010\u0011\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0018\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00138VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Landroidx/window/area/EmptyWindowAreaControllerImpl;", "Landroidx/window/area/WindowAreaController;", "<init>", "()V", "Landroid/os/Binder;", "token", "Landroid/app/Activity;", "activity", "Ljava/util/concurrent/Executor;", "executor", "Landroidx/window/area/WindowAreaSessionCallback;", "windowAreaSessionCallback", "Lie/H;", "transferActivityToWindowArea", "(Landroid/os/Binder;Landroid/app/Activity;Ljava/util/concurrent/Executor;Landroidx/window/area/WindowAreaSessionCallback;)V", "Landroidx/window/area/WindowAreaPresentationSessionCallback;", "windowAreaPresentationSessionCallback", "presentContentOnWindowArea", "(Landroid/os/Binder;Landroid/app/Activity;Ljava/util/concurrent/Executor;Landroidx/window/area/WindowAreaPresentationSessionCallback;)V", "Lkotlinx/coroutines/flow/Flow;", "", "Landroidx/window/area/WindowAreaInfo;", "getWindowAreaInfos", "()Lkotlinx/coroutines/flow/Flow;", "windowAreaInfos", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class EmptyWindowAreaControllerImpl extends WindowAreaController {
    @Override  // androidx.window.area.WindowAreaController
    @NotNull
    public Flow getWindowAreaInfos() {
        return FlowKt.flowOf(w.a);
    }

    @Override  // androidx.window.area.WindowAreaController
    public void presentContentOnWindowArea(@NotNull Binder binder0, @NotNull Activity activity0, @NotNull Executor executor0, @NotNull WindowAreaPresentationSessionCallback windowAreaPresentationSessionCallback0) {
        q.g(binder0, "token");
        q.g(activity0, "activity");
        q.g(executor0, "executor");
        q.g(windowAreaPresentationSessionCallback0, "windowAreaPresentationSessionCallback");
        windowAreaPresentationSessionCallback0.onSessionEnded(new IllegalStateException("There are no WindowAreas"));
    }

    @Override  // androidx.window.area.WindowAreaController
    public void transferActivityToWindowArea(@NotNull Binder binder0, @NotNull Activity activity0, @NotNull Executor executor0, @NotNull WindowAreaSessionCallback windowAreaSessionCallback0) {
        q.g(binder0, "token");
        q.g(activity0, "activity");
        q.g(executor0, "executor");
        q.g(windowAreaSessionCallback0, "windowAreaSessionCallback");
        windowAreaSessionCallback0.onSessionEnded(new IllegalStateException("There are no WindowAreas"));
    }
}

