package androidx.window.core;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\b\u001A\u00020\u00072\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/window/core/AndroidLogger;", "Landroidx/window/core/Logger;", "<init>", "()V", "", "tag", "message", "Lie/H;", "debug", "(Ljava/lang/String;Ljava/lang/String;)V", "window_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class AndroidLogger implements Logger {
    @NotNull
    public static final AndroidLogger INSTANCE;

    static {
        AndroidLogger.INSTANCE = new AndroidLogger();
    }

    @Override  // androidx.window.core.Logger
    public void debug(@NotNull String s, @NotNull String s1) {
        q.g(s, "tag");
        q.g(s1, "message");
        Log.d(s, s1);
    }
}

