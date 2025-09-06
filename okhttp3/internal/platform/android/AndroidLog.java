package okhttp3.internal.platform.android;

import Tf.o;
import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import je.C;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okhttp3.OkHttpClient;
import okhttp3.internal.SuppressSignatureCheck;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\u000B\u001A\u00020\n2\u0006\u0010\b\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u000B\u0010\fJ1\u0010\u0014\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u00042\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001A\u00020\n¢\u0006\u0004\b\u0015\u0010\u0003R\u0014\u0010\u0016\u001A\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001A\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001A\u0010\u001BR \u0010\u001D\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001D\u0010\u001E¨\u0006\u001F"}, d2 = {"Lokhttp3/internal/platform/android/AndroidLog;", "", "<init>", "()V", "", "loggerName", "loggerTag", "(Ljava/lang/String;)Ljava/lang/String;", "logger", "tag", "Lie/H;", "enableLogging", "(Ljava/lang/String;Ljava/lang/String;)V", "", "logLevel", "message", "", "t", "androidLog$okhttp", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V", "androidLog", "enable", "MAX_LOG_LENGTH", "I", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/logging/Logger;", "configuredLoggers", "Ljava/util/concurrent/CopyOnWriteArraySet;", "", "knownLoggers", "Ljava/util/Map;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
@SuppressSignatureCheck
public final class AndroidLog {
    @NotNull
    public static final AndroidLog INSTANCE = null;
    private static final int MAX_LOG_LENGTH = 4000;
    @NotNull
    private static final CopyOnWriteArraySet configuredLoggers;
    @NotNull
    private static final Map knownLoggers;

    static {
        AndroidLog.INSTANCE = new AndroidLog();
        AndroidLog.configuredLoggers = new CopyOnWriteArraySet();
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        Class class0 = OkHttpClient.class;
        Package package0 = class0.getPackage();
        String s = package0 == null ? null : package0.getName();
        if(s != null) {
            linkedHashMap0.put(s, "OkHttp");
        }
        linkedHashMap0.put(class0.getName(), "okhttp.OkHttpClient");
        linkedHashMap0.put("okhttp3.internal.http2.Http2", "okhttp.Http2");
        linkedHashMap0.put("okhttp3.internal.concurrent.TaskRunner", "okhttp.TaskRunner");
        linkedHashMap0.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        AndroidLog.knownLoggers = C.Z(linkedHashMap0);
    }

    public final void androidLog$okhttp(@NotNull String s, int v, @NotNull String s1, @Nullable Throwable throwable0) {
        q.g(s, "loggerName");
        q.g(s1, "message");
        String s2 = this.loggerTag(s);
        if(Log.isLoggable(s2, v)) {
            if(throwable0 != null) {
                s1 = s1 + '\n' + Log.getStackTraceString(throwable0);
            }
            int v1 = s1.length();
            for(int v2 = 0; v2 < v1; v2 = v4 + 1) {
                int v3 = o.E0(s1, '\n', v2, 4);
                if(v3 == -1) {
                    v3 = v1;
                }
                while(true) {
                    int v4 = Math.min(v3, v2 + 4000);
                    String s3 = s1.substring(v2, v4);
                    q.f(s3, "this as java.lang.String…ing(startIndex, endIndex)");
                    Log.println(v, s2, s3);
                    if(v4 >= v3) {
                        break;
                    }
                    v2 = v4;
                }
            }
        }
    }

    public final void enable() {
        for(Object object0: AndroidLog.knownLoggers.entrySet()) {
            this.enableLogging(((String)((Map.Entry)object0).getKey()), ((String)((Map.Entry)object0).getValue()));
        }
    }

    private final void enableLogging(String s, String s1) {
        Level level0;
        Logger logger0 = Logger.getLogger(s);
        if(AndroidLog.configuredLoggers.add(logger0)) {
            logger0.setUseParentHandlers(false);
            if(Log.isLoggable(s1, 3)) {
                level0 = Level.FINE;
            }
            else {
                level0 = Log.isLoggable(s1, 4) ? Level.INFO : Level.WARNING;
            }
            logger0.setLevel(level0);
            logger0.addHandler(AndroidLogHandler.INSTANCE);
        }
    }

    private final String loggerTag(String s) {
        String s1 = (String)AndroidLog.knownLoggers.get(s);
        return s1 == null ? o.d1(23, s) : s1;
    }
}

