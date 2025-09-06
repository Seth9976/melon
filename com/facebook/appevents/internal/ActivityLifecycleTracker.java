package com.facebook.appevents.internal;

import A5.a;
import Tf.o;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.codeless.CodelessManager;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
import com.facebook.internal.FeatureManager.Feature;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00C6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0007\u00A2\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0007\u00A2\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\u000BH\u0007\u00A2\u0006\u0004\b\u000E\u0010\rJ\u0011\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0007\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001A\u00020\b2\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012H\u0007\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00020\u0012H\u0007\u00A2\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0017\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00020\u0012H\u0002\u00A2\u0006\u0004\b\u0017\u0010\u0015J\u0017\u0010\u0018\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00020\u0012H\u0002\u00A2\u0006\u0004\b\u0018\u0010\u0015J\u000F\u0010\u0019\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b\u0019\u0010\u0003J\u0011\u0010\u001A\u001A\u0004\u0018\u00010\u0012H\u0007\u00A2\u0006\u0004\b\u001A\u0010\u001BR\u0014\u0010\u001C\u001A\u00020\u00068\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u001C\u0010\u001DR\u0014\u0010\u001E\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\u001E\u0010\u001DR\u0014\u0010 \u001A\u00020\u001F8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b \u0010!R\u001C\u0010$\u001A\n #*\u0004\u0018\u00010\"0\"8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b$\u0010%R\u001C\u0010&\u001A\n #*\u0004\u0018\u00010\"0\"8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b&\u0010%R\u001C\u0010(\u001A\b\u0012\u0002\b\u0003\u0018\u00010\'8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010*\u001A\u00020\u00018\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001A\u00020,8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00100\u001A\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00103\u001A\u0002028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b3\u00104R\u0018\u0010\u0007\u001A\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u0007\u0010\u001DR\u0016\u00105\u001A\u00020\u001F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b5\u0010!R\u0016\u00107\u001A\u0002068\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b7\u00108R\u001E\u0010:\u001A\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001098\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010<\u001A\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b<\u0010\u001DR\u0014\u0010?\u001A\u0002068BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b=\u0010>\u00A8\u0006@"}, d2 = {"Lcom/facebook/appevents/internal/ActivityLifecycleTracker;", "", "<init>", "()V", "Landroid/app/Application;", "application", "", "appId", "Lie/H;", "startTracking", "(Landroid/app/Application;Ljava/lang/String;)V", "", "isInBackground", "()Z", "isTracking", "Ljava/util/UUID;", "getCurrentSessionGuid", "()Ljava/util/UUID;", "Landroid/app/Activity;", "activity", "onActivityCreated", "(Landroid/app/Activity;)V", "onActivityResumed", "onActivityPaused", "onActivityDestroyed", "cancelCurrentTask", "getCurrentActivity", "()Landroid/app/Activity;", "TAG", "Ljava/lang/String;", "INCORRECT_IMPL_WARNING", "", "INTERRUPTION_THRESHOLD_MILLISECONDS", "J", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "singleThreadExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "iapExecutor", "Ljava/util/concurrent/ScheduledFuture;", "currentFuture", "Ljava/util/concurrent/ScheduledFuture;", "currentFutureLock", "Ljava/lang/Object;", "Ljava/util/concurrent/atomic/AtomicInteger;", "foregroundActivityCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "Lcom/facebook/appevents/internal/SessionInfo;", "currentSession", "Lcom/facebook/appevents/internal/SessionInfo;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "tracking", "Ljava/util/concurrent/atomic/AtomicBoolean;", "currentActivityAppearTime", "", "activityReferences", "I", "Ljava/lang/ref/WeakReference;", "currActivity", "Ljava/lang/ref/WeakReference;", "previousActivityName", "getSessionTimeoutInSeconds", "()I", "sessionTimeoutInSeconds", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ActivityLifecycleTracker {
    @NotNull
    private static final String INCORRECT_IMPL_WARNING = "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application\'s onCreate method";
    @NotNull
    public static final ActivityLifecycleTracker INSTANCE = null;
    private static final long INTERRUPTION_THRESHOLD_MILLISECONDS = 1000L;
    @NotNull
    private static final String TAG;
    private static int activityReferences;
    @Nullable
    private static String appId;
    @Nullable
    private static WeakReference currActivity;
    private static long currentActivityAppearTime;
    @Nullable
    private static volatile ScheduledFuture currentFuture;
    @NotNull
    private static final Object currentFutureLock;
    @Nullable
    private static volatile SessionInfo currentSession;
    @NotNull
    private static final AtomicInteger foregroundActivityCount;
    private static final ScheduledExecutorService iapExecutor;
    @Nullable
    private static String previousActivityName;
    private static final ScheduledExecutorService singleThreadExecutor;
    @NotNull
    private static final AtomicBoolean tracking;

    static {
        ActivityLifecycleTracker.INSTANCE = new ActivityLifecycleTracker();
        ActivityLifecycleTracker.TAG = ActivityLifecycleTracker.class.getCanonicalName() == null ? "com.facebook.appevents.internal.ActivityLifecycleTracker" : ActivityLifecycleTracker.class.getCanonicalName();
        ActivityLifecycleTracker.singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
        ActivityLifecycleTracker.iapExecutor = Executors.newSingleThreadScheduledExecutor();
        ActivityLifecycleTracker.currentFutureLock = new Object();
        ActivityLifecycleTracker.foregroundActivityCount = new AtomicInteger(0);
        ActivityLifecycleTracker.tracking = new AtomicBoolean(false);
    }

    public static final int access$getActivityReferences$p() [...] // 潜在的解密器

    public static void c(boolean z) {
        ActivityLifecycleTracker.startTracking$lambda$0(z);
    }

    private final void cancelCurrentTask() {
        synchronized(ActivityLifecycleTracker.currentFutureLock) {
            if(ActivityLifecycleTracker.currentFuture != null) {
                ScheduledFuture scheduledFuture0 = ActivityLifecycleTracker.currentFuture;
                if(scheduledFuture0 != null) {
                    scheduledFuture0.cancel(false);
                }
            }
            ActivityLifecycleTracker.currentFuture = null;
        }
    }

    @Nullable
    public static final Activity getCurrentActivity() {
        return ActivityLifecycleTracker.currActivity == null ? null : ((Activity)ActivityLifecycleTracker.currActivity.get());
    }

    @Nullable
    public static final UUID getCurrentSessionGuid() {
        if(ActivityLifecycleTracker.currentSession != null) {
            return ActivityLifecycleTracker.currentSession == null ? null : ActivityLifecycleTracker.currentSession.getSessionId();
        }
        return null;
    }

    private final int getSessionTimeoutInSeconds() {
        FetchedAppSettings fetchedAppSettings0 = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        return fetchedAppSettings0 == null ? 60 : fetchedAppSettings0.getSessionTimeoutInSeconds();
    }

    public static final boolean isInBackground() [...] // 潜在的解密器

    public static final boolean isTracking() {
        return ActivityLifecycleTracker.tracking.get();
    }

    public static final void onActivityCreated(@Nullable Activity activity0) {
        a a0 = new a(17);
        ActivityLifecycleTracker.singleThreadExecutor.execute(a0);
    }

    private static final void onActivityCreated$lambda$1() {
        if(ActivityLifecycleTracker.currentSession == null) {
            ActivityLifecycleTracker.currentSession = SessionInfo.Companion.getStoredSessionInfo();
        }
    }

    private final void onActivityDestroyed(Activity activity0) {
        CodelessManager.onActivityDestroyed(activity0);
    }

    private final void onActivityPaused(Activity activity0) {
        AtomicInteger atomicInteger0 = ActivityLifecycleTracker.foregroundActivityCount;
        if(atomicInteger0.decrementAndGet() < 0) {
            atomicInteger0.set(0);
            Log.w(ActivityLifecycleTracker.TAG, "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application\'s onCreate method");
        }
        this.cancelCurrentTask();
        String s = Utility.getActivityName(activity0);
        CodelessManager.onActivityPaused(activity0);
        b b0 = new b(System.currentTimeMillis(), s, 0);
        ActivityLifecycleTracker.singleThreadExecutor.execute(b0);
    }

    private static final void onActivityPaused$lambda$7(long v, String s) {
        q.g(s, "$activityName");
        if(ActivityLifecycleTracker.currentSession == null) {
            ActivityLifecycleTracker.currentSession = new SessionInfo(v, null, null, 4, null);
        }
        SessionInfo sessionInfo0 = ActivityLifecycleTracker.currentSession;
        if(sessionInfo0 != null) {
            sessionInfo0.setSessionLastEventTime(v);
        }
        if(ActivityLifecycleTracker.foregroundActivityCount.get() <= 0) {
            b b0 = new b(v, s, 1);
            synchronized(ActivityLifecycleTracker.currentFutureLock) {
                long v2 = (long)ActivityLifecycleTracker.INSTANCE.getSessionTimeoutInSeconds();
                ActivityLifecycleTracker.currentFuture = ActivityLifecycleTracker.singleThreadExecutor.schedule(b0, v2, TimeUnit.SECONDS);
            }
        }
        AutomaticAnalyticsLogger.logActivityTimeSpentEvent(s, (ActivityLifecycleTracker.currentActivityAppearTime <= 0L ? 0L : (v - ActivityLifecycleTracker.currentActivityAppearTime) / 1000L));
        SessionInfo sessionInfo1 = ActivityLifecycleTracker.currentSession;
        if(sessionInfo1 != null) {
            sessionInfo1.writeSessionToDisk();
        }
    }

    private static final void onActivityPaused$lambda$7$lambda$5(long v, String s) {
        q.g(s, "$activityName");
        if(ActivityLifecycleTracker.currentSession == null) {
            ActivityLifecycleTracker.currentSession = new SessionInfo(v, null, null, 4, null);
        }
        if(ActivityLifecycleTracker.foregroundActivityCount.get() <= 0) {
            SessionLogger.logDeactivateApp(s, ActivityLifecycleTracker.currentSession, ActivityLifecycleTracker.appId);
            SessionInfo.Companion.clearSavedSessionFromDisk();
            ActivityLifecycleTracker.currentSession = null;
        }
        synchronized(ActivityLifecycleTracker.currentFutureLock) {
            ActivityLifecycleTracker.currentFuture = null;
        }
    }

    public static final void onActivityResumed(@NotNull Activity activity0) {
        q.g(activity0, "activity");
        ActivityLifecycleTracker.currActivity = new WeakReference(activity0);
        ActivityLifecycleTracker.foregroundActivityCount.incrementAndGet();
        ActivityLifecycleTracker.INSTANCE.cancelCurrentTask();
        long v = System.currentTimeMillis();
        ActivityLifecycleTracker.currentActivityAppearTime = v;
        String s = Utility.getActivityName(activity0);
        CodelessManager.onActivityResumed(activity0);
        MetadataIndexer.onActivityResumed(activity0);
        SuggestedEventsManager.trackActivity(activity0);
        if(ActivityLifecycleTracker.previousActivityName != null && o.v0(ActivityLifecycleTracker.previousActivityName, "ProxyBillingActivity", false) && !q.b(s, "ProxyBillingActivity")) {
            a a0 = new a(16);
            ActivityLifecycleTracker.iapExecutor.execute(a0);
        }
        com.facebook.appevents.internal.a a1 = new com.facebook.appevents.internal.a(v, s, activity0.getApplicationContext());
        ActivityLifecycleTracker.singleThreadExecutor.execute(a1);
        ActivityLifecycleTracker.previousActivityName = s;
    }

    private static final void onActivityResumed$lambda$2() {
        InAppPurchaseManager.startTracking();
    }

    private static final void onActivityResumed$lambda$3(long v, String s, Context context0) {
        q.g(s, "$activityName");
        Long long0 = ActivityLifecycleTracker.currentSession == null ? null : ActivityLifecycleTracker.currentSession.getSessionLastEventTime();
        if(ActivityLifecycleTracker.currentSession == null) {
            ActivityLifecycleTracker.currentSession = new SessionInfo(v, null, null, 4, null);
            String s1 = ActivityLifecycleTracker.appId;
            q.f(context0, "appContext");
            SessionLogger.logActivateApp(s, null, s1, context0);
        }
        else if(long0 != null) {
            long v1 = v - ((long)long0);
            if(v1 > ((long)(ActivityLifecycleTracker.INSTANCE.getSessionTimeoutInSeconds() * 1000))) {
                SessionLogger.logDeactivateApp(s, ActivityLifecycleTracker.currentSession, ActivityLifecycleTracker.appId);
                String s2 = ActivityLifecycleTracker.appId;
                q.f(context0, "appContext");
                SessionLogger.logActivateApp(s, null, s2, context0);
                ActivityLifecycleTracker.currentSession = new SessionInfo(v, null, null, 4, null);
            }
            else if(v1 > 1000L) {
                SessionInfo sessionInfo0 = ActivityLifecycleTracker.currentSession;
                if(sessionInfo0 != null) {
                    sessionInfo0.incrementInterruptionCount();
                }
            }
        }
        SessionInfo sessionInfo1 = ActivityLifecycleTracker.currentSession;
        if(sessionInfo1 != null) {
            sessionInfo1.setSessionLastEventTime(v);
        }
        SessionInfo sessionInfo2 = ActivityLifecycleTracker.currentSession;
        if(sessionInfo2 != null) {
            sessionInfo2.writeSessionToDisk();
        }
    }

    public static final void startTracking(@NotNull Application application0, @Nullable String s) {
        q.g(application0, "application");
        if(!ActivityLifecycleTracker.tracking.compareAndSet(false, true)) {
            return;
        }
        com.facebook.appevents.b b0 = new com.facebook.appevents.b(6);
        FeatureManager.checkFeature(Feature.CodelessEvents, b0);
        ActivityLifecycleTracker.appId = s;
        application0.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivityCreated(@NotNull Activity activity0, @Nullable Bundle bundle0) {
                q.g(activity0, "activity");
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityCreated");
                ActivityLifecycleTracker.onActivityCreated(activity0);
            }

            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivityDestroyed(@NotNull Activity activity0) {
                q.g(activity0, "activity");
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityDestroyed");
                ActivityLifecycleTracker.INSTANCE.onActivityDestroyed(activity0);
            }

            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivityPaused(@NotNull Activity activity0) {
                q.g(activity0, "activity");
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityPaused");
                ActivityLifecycleTracker.INSTANCE.onActivityPaused(activity0);
            }

            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivityResumed(@NotNull Activity activity0) {
                q.g(activity0, "activity");
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityResumed");
                ActivityLifecycleTracker.onActivityResumed(activity0);
            }

            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(@NotNull Activity activity0, @NotNull Bundle bundle0) {
                q.g(activity0, "activity");
                q.g(bundle0, "outState");
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivitySaveInstanceState");
            }

            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivityStarted(@NotNull Activity activity0) {
                q.g(activity0, "activity");
                ActivityLifecycleTracker.activityReferences = ActivityLifecycleTracker.access$getActivityReferences$p() + 1;
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityStarted");
            }

            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivityStopped(@NotNull Activity activity0) {
                q.g(activity0, "activity");
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityStopped");
                AppEventsLogger.Companion.onContextStop();
                ActivityLifecycleTracker.activityReferences = -1;
            }
        });
    }

    private static final void startTracking$lambda$0(boolean z) {
        if(z) {
            CodelessManager.enable();
            return;
        }
        CodelessManager.disable();
    }
}

