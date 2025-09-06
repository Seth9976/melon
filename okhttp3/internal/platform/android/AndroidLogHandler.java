package okhttp3.internal.platform.android;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\u0003J\u000F\u0010\n\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u0003¨\u0006\u000B"}, d2 = {"Lokhttp3/internal/platform/android/AndroidLogHandler;", "Ljava/util/logging/Handler;", "<init>", "()V", "Ljava/util/logging/LogRecord;", "record", "Lie/H;", "publish", "(Ljava/util/logging/LogRecord;)V", "flush", "close", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AndroidLogHandler extends Handler {
    @NotNull
    public static final AndroidLogHandler INSTANCE;

    static {
        AndroidLogHandler.INSTANCE = new AndroidLogHandler();
    }

    @Override
    public void close() {
    }

    @Override
    public void flush() {
    }

    @Override
    public void publish(@NotNull LogRecord logRecord0) {
        q.g(logRecord0, "record");
        String s = logRecord0.getLoggerName();
        q.f(s, "record.loggerName");
        int v = AndroidLogKt.access$getAndroidLevel(logRecord0);
        String s1 = logRecord0.getMessage();
        q.f(s1, "record.message");
        Throwable throwable0 = logRecord0.getThrown();
        AndroidLog.INSTANCE.androidLog$okhttp(s, v, s1, throwable0);
    }
}

