package androidx.window.layout.adapter;

import android.content.Context;
import androidx.window.RequiresWindowSdkExtension;
import b2.a;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001J-\u0010\n\u001A\u00020\t2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00042\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H&¢\u0006\u0004\b\n\u0010\u000BJ\u001D\u0010\f\u001A\u00020\t2\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H&¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0017¢\u0006\u0004\b\u000F\u0010\u0010R \u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00120\u00118gX§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0013\u0010\u0014ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Landroidx/window/layout/adapter/WindowBackend;", "", "Landroid/content/Context;", "context", "Ljava/util/concurrent/Executor;", "executor", "Lb2/a;", "Landroidx/window/layout/WindowLayoutInfo;", "callback", "Lie/H;", "registerLayoutChangeCallback", "(Landroid/content/Context;Ljava/util/concurrent/Executor;Lb2/a;)V", "unregisterLayoutChangeCallback", "(Lb2/a;)V", "", "hasRegisteredListeners", "()Z", "", "Landroidx/window/layout/SupportedPosture;", "getSupportedPostures", "()Ljava/util/List;", "getSupportedPostures$annotations", "()V", "supportedPostures", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public interface WindowBackend {
    @RequiresWindowSdkExtension(version = 6)
    @NotNull
    List getSupportedPostures();

    @RequiresWindowSdkExtension(version = 6)
    static void getSupportedPostures$annotations() {
    }

    default boolean hasRegisteredListeners() {
        return false;
    }

    void registerLayoutChangeCallback(@NotNull Context arg1, @NotNull Executor arg2, @NotNull a arg3);

    void unregisterLayoutChangeCallback(@NotNull a arg1);
}

