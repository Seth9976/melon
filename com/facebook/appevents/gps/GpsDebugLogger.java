package com.facebook.appevents.gps;

import Ae.f;
import Tf.o;
import android.content.Context;
import android.os.Bundle;
import com.facebook.appevents.InternalAppEventsLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001A\u00020\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000E\u001A\u00020\r2\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\f\u001A\u0004\u0018\u00010\u000B¢\u0006\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0011\u001A\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/facebook/appevents/gps/GpsDebugLogger;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "eventName", "", "isGPSDebugEvent", "(Ljava/lang/String;)Z", "Landroid/os/Bundle;", "parameters", "Lie/H;", "log", "(Ljava/lang/String;Landroid/os/Bundle;)V", "Lcom/facebook/appevents/InternalAppEventsLogger;", "internalAppEventsLogger", "Lcom/facebook/appevents/InternalAppEventsLogger;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class GpsDebugLogger {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000B\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/facebook/appevents/gps/GpsDebugLogger$Companion;", "", "()V", "GPS_PREFIX", "", "LOGGING_SAMPLING_RATE", "", "shouldLog", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String GPS_PREFIX = "gps";
    private static final double LOGGING_SAMPLING_RATE = 0.0001;
    @NotNull
    private final InternalAppEventsLogger internalAppEventsLogger;
    private static final boolean shouldLog;

    static {
        GpsDebugLogger.Companion = new Companion(null);
        GpsDebugLogger.shouldLog = f.b.e().nextDouble() <= 0.0001;
    }

    public GpsDebugLogger(@NotNull Context context0) {
        q.g(context0, "context");
        super();
        this.internalAppEventsLogger = new InternalAppEventsLogger(context0);
    }

    private final boolean isGPSDebugEvent(String s) {
        return s == null ? false : o.v0(s, "gps", false);
    }

    public final void log(@Nullable String s, @Nullable Bundle bundle0) {
        if(GpsDebugLogger.shouldLog && this.isGPSDebugEvent(s)) {
            this.internalAppEventsLogger.logEventImplicitly(s, bundle0);
        }
    }
}

