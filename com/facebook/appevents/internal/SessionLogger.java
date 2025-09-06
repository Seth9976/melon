package com.facebook.appevents.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger.FlushBehavior;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.Logger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\b\u001A\u0004\u0018\u00010\u00042\u0006\u0010\n\u001A\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010\b\u001A\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u0017\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0014\u001A\u00020\u0013H\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u001C\u0010\u0019\u001A\n \u0018*\u0004\u0018\u00010\u00040\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001AR\u0014\u0010\u001C\u001A\u00020\u001B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001C\u0010\u001D¨\u0006\u001E"}, d2 = {"Lcom/facebook/appevents/internal/SessionLogger;", "", "<init>", "()V", "", "activityName", "Lcom/facebook/appevents/internal/SourceApplicationInfo;", "sourceApplicationInfo", "appId", "Landroid/content/Context;", "context", "Lie/H;", "logActivateApp", "(Ljava/lang/String;Lcom/facebook/appevents/internal/SourceApplicationInfo;Ljava/lang/String;Landroid/content/Context;)V", "Lcom/facebook/appevents/internal/SessionInfo;", "sessionInfo", "logDeactivateApp", "(Ljava/lang/String;Lcom/facebook/appevents/internal/SessionInfo;Ljava/lang/String;)V", "logClockSkewEvent", "", "timeBetweenSessions", "", "getQuantaIndex", "(J)I", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "", "INACTIVE_SECONDS_QUANTA", "[J", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class SessionLogger {
    @NotNull
    private static final long[] INACTIVE_SECONDS_QUANTA;
    @NotNull
    public static final SessionLogger INSTANCE;
    private static final String TAG;

    static {
        SessionLogger.INSTANCE = new SessionLogger();
        SessionLogger.TAG = SessionLogger.class.getCanonicalName();
        SessionLogger.INACTIVE_SECONDS_QUANTA = new long[]{300000L, 900000L, 1800000L, 3600000L, 21600000L, 43200000L, 86400000L, 172800000L, 259200000L, 604800000L, 1209600000L, 1814400000L, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};
    }

    public static final int getQuantaIndex(long v) {
        Class class0 = SessionLogger.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return 0;
        }
        int v1;
        for(v1 = 0; true; ++v1) {
            try {
                if(v1 >= SessionLogger.INACTIVE_SECONDS_QUANTA.length || SessionLogger.INACTIVE_SECONDS_QUANTA[v1] >= v) {
                    break;
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, class0);
                return 0;
            }
        }
        return v1;
    }

    public static final void logActivateApp(@NotNull String s, @Nullable SourceApplicationInfo sourceApplicationInfo0, @Nullable String s1, @NotNull Context context0) {
        String s2;
        Class class0 = SessionLogger.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                q.g(s, "activityName");
                q.g(context0, "context");
                if(sourceApplicationInfo0 == null) {
                    s2 = "Unclassified";
                }
                else {
                    s2 = sourceApplicationInfo0.toString();
                    if(s2 == null) {
                        s2 = "Unclassified";
                    }
                }
                Bundle bundle0 = new Bundle();
                bundle0.putString("fb_mobile_launch_source", s2);
                InternalAppEventsLogger internalAppEventsLogger0 = InternalAppEventsLogger.Companion.createInstance(s, s1, null);
                internalAppEventsLogger0.logEvent("fb_mobile_activate_app", bundle0);
                if(InternalAppEventsLogger.Companion.getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
                    internalAppEventsLogger0.flush();
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    private final void logClockSkewEvent() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            q.d(SessionLogger.TAG);
            Logger.Companion.log(LoggingBehavior.APP_EVENTS, SessionLogger.TAG, "Clock skew detected");
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public static final void logDeactivateApp(@NotNull String s, @Nullable SessionInfo sessionInfo0, @Nullable String s1) {
        String s2;
        long v1;
        Class class0 = SessionLogger.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                q.g(s, "activityName");
                if(sessionInfo0 != null) {
                    Long long0 = sessionInfo0.getDiskRestoreTime();
                    long v = 0L;
                    if(long0 == null) {
                        Long long1 = sessionInfo0.getSessionLastEventTime();
                        v1 = -(long1 == null ? 0L : ((long)long1));
                    }
                    else {
                        v1 = (long)long0;
                    }
                    if(v1 < 0L) {
                        SessionLogger.INSTANCE.logClockSkewEvent();
                        v1 = 0L;
                    }
                    long v2 = sessionInfo0.getSessionLength();
                    if(v2 < 0L) {
                        SessionLogger.INSTANCE.logClockSkewEvent();
                        v2 = 0L;
                    }
                    Bundle bundle0 = new Bundle();
                    bundle0.putInt("fb_mobile_app_interruptions", sessionInfo0.getInterruptionCount());
                    bundle0.putString("fb_mobile_time_between_sessions", String.format(Locale.ROOT, "session_quanta_%d", Arrays.copyOf(new Object[]{SessionLogger.getQuantaIndex(v1)}, 1)));
                    SourceApplicationInfo sourceApplicationInfo0 = sessionInfo0.getSourceApplicationInfo();
                    if(sourceApplicationInfo0 == null) {
                        s2 = "Unclassified";
                    }
                    else {
                        s2 = sourceApplicationInfo0.toString();
                        if(s2 == null) {
                            s2 = "Unclassified";
                        }
                    }
                    bundle0.putString("fb_mobile_launch_source", s2);
                    Long long2 = sessionInfo0.getSessionLastEventTime();
                    if(long2 != null) {
                        v = (long)long2;
                    }
                    bundle0.putLong("_logTime", v / 1000L);
                    InternalAppEventsLogger.Companion.createInstance(s, s1, null).logEvent("fb_mobile_deactivate_app", ((double)v2) / 1000.0, bundle0);
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }
}

