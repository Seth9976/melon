package androidx.window.area;

import android.content.Context;
import android.view.View;
import android.view.Window;
import androidx.window.core.ExperimentalWindowApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalWindowApi
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001A\u00020\u00078&X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0016\u0010\u000E\u001A\u0004\u0018\u00010\u000B8&X¦\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000FÀ\u0006\u0001"}, d2 = {"Landroidx/window/area/WindowAreaSessionPresenter;", "Landroidx/window/area/WindowAreaSession;", "Landroid/view/View;", "view", "Lie/H;", "setContentView", "(Landroid/view/View;)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/view/Window;", "getWindow", "()Landroid/view/Window;", "window", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public interface WindowAreaSessionPresenter extends WindowAreaSession {
    @NotNull
    Context getContext();

    @Nullable
    Window getWindow();

    void setContentView(@NotNull View arg1);
}

