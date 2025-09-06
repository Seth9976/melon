package androidx.window.layout.adapter.extensions;

import A3.l;
import android.content.Context;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.layout.adapter.WindowBackend;
import b2.a;
import java.util.List;
import java.util.concurrent.Executor;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001D\u0010\u000E\u001A\u00020\u000B2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Landroidx/window/layout/adapter/extensions/ExtensionWindowBackendApi0;", "Landroidx/window/layout/adapter/WindowBackend;", "<init>", "()V", "Landroid/content/Context;", "context", "Ljava/util/concurrent/Executor;", "executor", "Lb2/a;", "Landroidx/window/layout/WindowLayoutInfo;", "callback", "Lie/H;", "registerLayoutChangeCallback", "(Landroid/content/Context;Ljava/util/concurrent/Executor;Lb2/a;)V", "unregisterLayoutChangeCallback", "(Lb2/a;)V", "", "Landroidx/window/layout/SupportedPosture;", "getSupportedPostures", "()Ljava/util/List;", "supportedPostures", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class ExtensionWindowBackendApi0 implements WindowBackend {
    @Override  // androidx.window.layout.adapter.WindowBackend
    @NotNull
    public List getSupportedPostures() {
        throw new UnsupportedOperationException("supportedPostures is only supported on Window SDK 6.");
    }

    @Override  // androidx.window.layout.adapter.WindowBackend
    public void registerLayoutChangeCallback(@NotNull Context context0, @NotNull Executor executor0, @NotNull a a0) {
        q.g(context0, "context");
        q.g(executor0, "executor");
        q.g(a0, "callback");
        executor0.execute(new l(a0, 25));
    }

    private static final void registerLayoutChangeCallback$lambda$0(a a0) {
        a0.accept(new WindowLayoutInfo(w.a));
    }

    @Override  // androidx.window.layout.adapter.WindowBackend
    public void unregisterLayoutChangeCallback(@NotNull a a0) {
        q.g(a0, "callback");
    }
}

