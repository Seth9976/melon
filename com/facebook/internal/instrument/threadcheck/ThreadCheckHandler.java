package com.facebook.internal.instrument.threadcheck;

import android.os.Looper;
import android.util.Log;
import com.facebook.internal.instrument.InstrumentData.Builder;
import com.facebook.internal.instrument.InstrumentData.Type;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J+\u0010\u000B\u001A\u00020\u00042\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\bH\u0007¢\u0006\u0004\b\u000B\u0010\fJ+\u0010\r\u001A\u00020\u00042\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\bH\u0007¢\u0006\u0004\b\r\u0010\fJ3\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\b2\n\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\bH\u0002¢\u0006\u0004\b\u000F\u0010\u0010R\u001C\u0010\u0012\u001A\n \u0011*\u0004\u0018\u00010\b0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001A\u00020\u00148\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/facebook/internal/instrument/threadcheck/ThreadCheckHandler;", "", "<init>", "()V", "Lie/H;", "enable", "Ljava/lang/Class;", "clazz", "", "methodName", "methodDesc", "uiThreadViolationDetected", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)V", "workerThreadViolationDetected", "annotation", "log", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)V", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "", "enabled", "Z", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ThreadCheckHandler {
    @NotNull
    public static final ThreadCheckHandler INSTANCE;
    private static final String TAG;
    private static boolean enabled;

    static {
        ThreadCheckHandler.INSTANCE = new ThreadCheckHandler();
        ThreadCheckHandler.TAG = ThreadCheckHandler.class.getCanonicalName();
    }

    public static final void enable() {
        ThreadCheckHandler.enabled = true;
    }

    private final void log(String s, Class class0, String s1, String s2) {
        if(!ThreadCheckHandler.enabled) {
            return;
        }
        String s3 = String.format(Locale.US, "%s annotation violation detected in %s.%s%s. Current looper is %s and main looper is %s.", Arrays.copyOf(new Object[]{s, class0.getName(), s1, s2, Looper.myLooper(), Looper.getMainLooper()}, 6));
        Exception exception0 = new Exception();
        Log.e(ThreadCheckHandler.TAG, s3, exception0);
        Builder.build(exception0, Type.ThreadCheck).save();
    }

    public static final void uiThreadViolationDetected(@NotNull Class class0, @NotNull String s, @NotNull String s1) {
        q.g(class0, "clazz");
        q.g(s, "methodName");
        q.g(s1, "methodDesc");
        ThreadCheckHandler.INSTANCE.log("@UiThread", class0, s, s1);
    }

    public static final void workerThreadViolationDetected(@NotNull Class class0, @NotNull String s, @NotNull String s1) {
        q.g(class0, "clazz");
        q.g(s, "methodName");
        q.g(s1, "methodDesc");
        ThreadCheckHandler.INSTANCE.log("@WorkerThread", class0, s, s1);
    }
}

