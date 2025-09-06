package androidx.window.area;

import androidx.window.core.ExperimentalWindowApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalWindowApi
@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001A\u00020\u00042\b\u0010\b\u001A\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000BÀ\u0006\u0001"}, d2 = {"Landroidx/window/area/WindowAreaSessionCallback;", "", "Landroidx/window/area/WindowAreaSession;", "session", "Lie/H;", "onSessionStarted", "(Landroidx/window/area/WindowAreaSession;)V", "", "t", "onSessionEnded", "(Ljava/lang/Throwable;)V", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public interface WindowAreaSessionCallback {
    void onSessionEnded(@Nullable Throwable arg1);

    void onSessionStarted(@NotNull WindowAreaSession arg1);
}

