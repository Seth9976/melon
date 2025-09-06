package com.facebook.appevents;

import A5.a;
import W2.b;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import b.l;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.cloudbridge.AppEventsCAPIManager;
import com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00C1\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b\b\u0010\tJ\u001F\u0010\u000E\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0007\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0015\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\n0\u0010H\u0007\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b\u0013\u0010\tJ!\u0010\u0017\u001A\u0004\u0018\u00010\u00162\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0015\u001A\u00020\u0014H\u0007\u00A2\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u001B0\u001A2\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0019\u001A\u00020\u0016H\u0007\u00A2\u0006\u0004\b\u001C\u0010\u001DJ1\u0010#\u001A\u0004\u0018\u00010\u001B2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\u001F\u001A\u00020\u001E2\u0006\u0010!\u001A\u00020 2\u0006\u0010\"\u001A\u00020\u0016H\u0007\u00A2\u0006\u0004\b#\u0010$J7\u0010(\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010%\u001A\u00020\u001B2\u0006\u0010\'\u001A\u00020&2\u0006\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\"\u001A\u00020\u0016H\u0007\u00A2\u0006\u0004\b(\u0010)R\u001C\u0010,\u001A\n +*\u0004\u0018\u00010*0*8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001A\u00020.8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001A\u00020.8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b1\u00100R\u0014\u00102\u001A\u00020.8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b2\u00100R\u0016\u0010\u0015\u001A\u00020\u00148\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u0015\u00103R\u001C\u00105\u001A\n +*\u0004\u0018\u000104048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b5\u00106R\u001C\u00108\u001A\b\u0012\u0002\b\u0003\u0018\u0001078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010;\u001A\u00020:8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b;\u0010<\u00A8\u0006="}, d2 = {"Lcom/facebook/appevents/AppEventQueue;", "", "<init>", "()V", "Lie/H;", "persistToDisk", "Lcom/facebook/appevents/FlushReason;", "reason", "flush", "(Lcom/facebook/appevents/FlushReason;)V", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "accessTokenAppId", "Lcom/facebook/appevents/AppEvent;", "appEvent", "add", "(Lcom/facebook/appevents/AccessTokenAppIdPair;Lcom/facebook/appevents/AppEvent;)V", "", "getKeySet", "()Ljava/util/Set;", "flushAndWait", "Lcom/facebook/appevents/AppEventCollection;", "appEventCollection", "Lcom/facebook/appevents/FlushStatistics;", "sendEventsToServer", "(Lcom/facebook/appevents/FlushReason;Lcom/facebook/appevents/AppEventCollection;)Lcom/facebook/appevents/FlushStatistics;", "flushResults", "", "Lcom/facebook/GraphRequest;", "buildRequests", "(Lcom/facebook/appevents/AppEventCollection;Lcom/facebook/appevents/FlushStatistics;)Ljava/util/List;", "Lcom/facebook/appevents/SessionEventsState;", "appEvents", "", "limitEventUsage", "flushState", "buildRequestForSession", "(Lcom/facebook/appevents/AccessTokenAppIdPair;Lcom/facebook/appevents/SessionEventsState;ZLcom/facebook/appevents/FlushStatistics;)Lcom/facebook/GraphRequest;", "request", "Lcom/facebook/GraphResponse;", "response", "handleResponse", "(Lcom/facebook/appevents/AccessTokenAppIdPair;Lcom/facebook/GraphRequest;Lcom/facebook/GraphResponse;Lcom/facebook/appevents/SessionEventsState;Lcom/facebook/appevents/FlushStatistics;)V", "", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "", "NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER", "I", "FLUSH_PERIOD_IN_SECONDS", "NO_CONNECTIVITY_ERROR_CODE", "Lcom/facebook/appevents/AppEventCollection;", "Ljava/util/concurrent/ScheduledExecutorService;", "singleThreadExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "Ljava/util/concurrent/ScheduledFuture;", "scheduledFuture", "Ljava/util/concurrent/ScheduledFuture;", "Ljava/lang/Runnable;", "flushRunnable", "Ljava/lang/Runnable;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AppEventQueue {
    private static final int FLUSH_PERIOD_IN_SECONDS = 15;
    @NotNull
    public static final AppEventQueue INSTANCE = null;
    private static final int NO_CONNECTIVITY_ERROR_CODE = -1;
    private static final int NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER;
    private static final String TAG;
    @NotNull
    private static volatile AppEventCollection appEventCollection;
    @NotNull
    private static final Runnable flushRunnable;
    @Nullable
    private static ScheduledFuture scheduledFuture;
    private static final ScheduledExecutorService singleThreadExecutor;

    static {
        AppEventQueue.INSTANCE = new AppEventQueue();
        AppEventQueue.TAG = "com.facebook.appevents.AppEventQueue";
        AppEventQueue.NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER = 100;
        AppEventQueue.appEventCollection = new AppEventCollection();
        AppEventQueue.singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
        AppEventQueue.flushRunnable = new a(11);
    }

    public static void a(AccessTokenAppIdPair accessTokenAppIdPair0, SessionEventsState sessionEventsState0) {
        AppEventQueue.handleResponse$lambda$5(accessTokenAppIdPair0, sessionEventsState0);
    }

    public static final void add(@NotNull AccessTokenAppIdPair accessTokenAppIdPair0, @NotNull AppEvent appEvent0) {
        Class class0 = AppEventQueue.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            q.g(accessTokenAppIdPair0, "accessTokenAppId");
            q.g(appEvent0, "appEvent");
            l l0 = new l(6, accessTokenAppIdPair0, appEvent0);
            AppEventQueue.singleThreadExecutor.execute(l0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    private static final void add$lambda$3(AccessTokenAppIdPair accessTokenAppIdPair0, AppEvent appEvent0) {
        Class class0 = AppEventQueue.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                q.g(accessTokenAppIdPair0, "$accessTokenAppId");
                q.g(appEvent0, "$appEvent");
                AppEventQueue.appEventCollection.addEvent(accessTokenAppIdPair0, appEvent0);
                if(AppEventsLogger.Companion.getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY && AppEventQueue.appEventCollection.getEventCount() > AppEventQueue.NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER) {
                    AppEventQueue.flushAndWait(FlushReason.EVENT_THRESHOLD);
                    return;
                }
                if(AppEventQueue.scheduledFuture == null) {
                    AppEventQueue.scheduledFuture = AppEventQueue.singleThreadExecutor.schedule(AppEventQueue.flushRunnable, 15L, TimeUnit.SECONDS);
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    @Nullable
    public static final GraphRequest buildRequestForSession(@NotNull AccessTokenAppIdPair accessTokenAppIdPair0, @NotNull SessionEventsState sessionEventsState0, boolean z, @NotNull FlushStatistics flushStatistics0) {
        Class class0 = AppEventQueue.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        else {
            try {
                q.g(accessTokenAppIdPair0, "accessTokenAppId");
                q.g(sessionEventsState0, "appEvents");
                q.g(flushStatistics0, "flushState");
                String s = accessTokenAppIdPair0.getApplicationId();
                boolean z1 = false;
                FetchedAppSettings fetchedAppSettings0 = FetchedAppSettingsManager.queryAppSettings(s, false);
                String s1 = String.format("%s/activities", Arrays.copyOf(new Object[]{s}, 1));
                GraphRequest graphRequest0 = GraphRequest.Companion.newPostRequest(null, s1, null, null);
                graphRequest0.setForceApplicationRequest(true);
                Bundle bundle0 = graphRequest0.getParameters() == null ? new Bundle() : graphRequest0.getParameters();
                bundle0.putString("access_token", accessTokenAppIdPair0.getAccessTokenString());
                String s2 = InternalAppEventsLogger.Companion.getPushNotificationsRegistrationId();
                if(s2 != null) {
                    bundle0.putString("device_token", s2);
                }
                String s3 = AppEventsLoggerImpl.Companion.getInstallReferrer();
                if(s3 != null) {
                    bundle0.putString("install_referrer", s3);
                }
                graphRequest0.setParameters(bundle0);
                if(fetchedAppSettings0 != null) {
                    z1 = fetchedAppSettings0.supportsImplicitLogging();
                }
                int v = sessionEventsState0.populateRequest(graphRequest0, FacebookSdk.getApplicationContext(), z1, z);
                if(v != 0) {
                    flushStatistics0.setNumEvents(flushStatistics0.getNumEvents() + v);
                    graphRequest0.setCallback(new com.facebook.a(accessTokenAppIdPair0, graphRequest0, sessionEventsState0, flushStatistics0, 1));
                    return graphRequest0;
                }
                return null;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }

    private static final void buildRequestForSession$lambda$4(AccessTokenAppIdPair accessTokenAppIdPair0, GraphRequest graphRequest0, SessionEventsState sessionEventsState0, FlushStatistics flushStatistics0, GraphResponse graphResponse0) {
        Class class0 = AppEventQueue.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            q.g(accessTokenAppIdPair0, "$accessTokenAppId");
            q.g(graphRequest0, "$postRequest");
            q.g(sessionEventsState0, "$appEvents");
            q.g(flushStatistics0, "$flushState");
            q.g(graphResponse0, "response");
            AppEventQueue.handleResponse(accessTokenAppIdPair0, graphRequest0, graphResponse0, sessionEventsState0, flushStatistics0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    @NotNull
    public static final List buildRequests(@NotNull AppEventCollection appEventCollection0, @NotNull FlushStatistics flushStatistics0) {
        Class class0 = AppEventQueue.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(appEventCollection0, "appEventCollection");
            q.g(flushStatistics0, "flushResults");
            boolean z = FacebookSdk.getLimitEventAndDataUsage(FacebookSdk.getApplicationContext());
            List list0 = new ArrayList();
            for(Object object0: appEventCollection0.keySet()) {
                SessionEventsState sessionEventsState0 = appEventCollection0.get(((AccessTokenAppIdPair)object0));
                if(sessionEventsState0 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                GraphRequest graphRequest0 = AppEventQueue.buildRequestForSession(((AccessTokenAppIdPair)object0), sessionEventsState0, z, flushStatistics0);
                if(graphRequest0 != null) {
                    ((ArrayList)list0).add(graphRequest0);
                    if(AppEventsCAPIManager.INSTANCE.isEnabled$facebook_core_release()) {
                        AppEventsConversionsAPITransformerWebRequests.transformGraphRequestAndSendToCAPIGEndPoint(graphRequest0);
                    }
                }
            }
            return list0;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }

    public static void d(AccessTokenAppIdPair accessTokenAppIdPair0, AppEvent appEvent0) {
        AppEventQueue.add$lambda$3(accessTokenAppIdPair0, appEvent0);
    }

    public static void e(AccessTokenAppIdPair accessTokenAppIdPair0, GraphRequest graphRequest0, SessionEventsState sessionEventsState0, FlushStatistics flushStatistics0, GraphResponse graphResponse0) {
        AppEventQueue.buildRequestForSession$lambda$4(accessTokenAppIdPair0, graphRequest0, sessionEventsState0, flushStatistics0, graphResponse0);
    }

    public static final void flush(@NotNull FlushReason flushReason0) {
        Class class0 = AppEventQueue.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            q.g(flushReason0, "reason");
            A3.l l0 = new A3.l(flushReason0, 29);
            AppEventQueue.singleThreadExecutor.execute(l0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    private static final void flush$lambda$2(FlushReason flushReason0) {
        Class class0 = AppEventQueue.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            q.g(flushReason0, "$reason");
            AppEventQueue.flushAndWait(flushReason0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void flushAndWait(@NotNull FlushReason flushReason0) {
        FlushStatistics flushStatistics0;
        Class class0 = AppEventQueue.class;
        if(!CrashShieldHandler.isObjectCrashing(class0)) {
            try {
                q.g(flushReason0, "reason");
                PersistedEvents persistedEvents0 = AppEventDiskStore.readAndClearStore();
                AppEventQueue.appEventCollection.addPersistedEvents(persistedEvents0);
                try {
                    flushStatistics0 = AppEventQueue.sendEventsToServer(flushReason0, AppEventQueue.appEventCollection);
                }
                catch(Exception exception0) {
                    Log.w("com.facebook.appevents.AppEventQueue", "Caught unexpected exception while flushing app events: ", exception0);
                    return;
                }
                if(flushStatistics0 != null) {
                    Intent intent0 = new Intent("com.facebook.sdk.APP_EVENTS_FLUSHED");
                    intent0.putExtra("com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED", flushStatistics0.getNumEvents());
                    intent0.putExtra("com.facebook.sdk.APP_EVENTS_FLUSH_RESULT", flushStatistics0.getResult());
                    b.a(FacebookSdk.getApplicationContext()).c(intent0);
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    private static final void flushRunnable$lambda$0() {
        Class class0 = AppEventQueue.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                AppEventQueue.scheduledFuture = null;
                if(AppEventsLogger.Companion.getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
                    AppEventQueue.flushAndWait(FlushReason.TIMER);
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    @NotNull
    public static final Set getKeySet() {
        Class class0 = AppEventQueue.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            return AppEventQueue.appEventCollection.keySet();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    public static final void handleResponse(@NotNull AccessTokenAppIdPair accessTokenAppIdPair0, @NotNull GraphRequest graphRequest0, @NotNull GraphResponse graphResponse0, @NotNull SessionEventsState sessionEventsState0, @NotNull FlushStatistics flushStatistics0) {
        String s2;
        Class class0 = AppEventQueue.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                q.g(accessTokenAppIdPair0, "accessTokenAppId");
                q.g(graphRequest0, "request");
                q.g(graphResponse0, "response");
                q.g(sessionEventsState0, "appEvents");
                q.g(flushStatistics0, "flushState");
                FacebookRequestError facebookRequestError0 = graphResponse0.getError();
                String s = "Success";
                FlushResult flushResult0 = FlushResult.SUCCESS;
                if(facebookRequestError0 != null) {
                    if(facebookRequestError0.getErrorCode() == -1) {
                        s = "Failed: No Connectivity";
                        flushResult0 = FlushResult.NO_CONNECTIVITY;
                    }
                    else {
                        s = String.format("Failed:\n  Response: %s\n  Error %s", Arrays.copyOf(new Object[]{graphResponse0.toString(), facebookRequestError0.toString()}, 2));
                        flushResult0 = FlushResult.SERVER_ERROR;
                    }
                }
                if(FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.APP_EVENTS)) {
                    String s1 = (String)graphRequest0.getTag();
                    try {
                        s2 = new JSONArray(s1).toString(2);
                        q.f(s2, "{\n            val jsonAr…y.toString(2)\n          }");
                    }
                    catch(JSONException unused_ex) {
                        s2 = "<Can\'t encode events for debug logging>";
                    }
                    q.f("com.facebook.appevents.AppEventQueue", "TAG");
                    Logger.Companion.log(LoggingBehavior.APP_EVENTS, "com.facebook.appevents.AppEventQueue", "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", new Object[]{String.valueOf(graphRequest0.getGraphObject()), s, s2});
                }
                sessionEventsState0.clearInFlightAndStats(facebookRequestError0 != null);
                FlushResult flushResult1 = FlushResult.NO_CONNECTIVITY;
                if(flushResult0 == flushResult1) {
                    FacebookSdk.getExecutor().execute(new l(7, accessTokenAppIdPair0, sessionEventsState0));
                }
                if(flushResult0 != FlushResult.SUCCESS && flushStatistics0.getResult() != flushResult1) {
                    flushStatistics0.setResult(flushResult0);
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    private static final void handleResponse$lambda$5(AccessTokenAppIdPair accessTokenAppIdPair0, SessionEventsState sessionEventsState0) {
        Class class0 = AppEventQueue.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            q.g(accessTokenAppIdPair0, "$accessTokenAppId");
            q.g(sessionEventsState0, "$appEvents");
            AppEventStore.persistEvents(accessTokenAppIdPair0, sessionEventsState0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void persistToDisk() {
        Class class0 = AppEventQueue.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            a a0 = new a(10);
            AppEventQueue.singleThreadExecutor.execute(a0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    private static final void persistToDisk$lambda$1() {
        Class class0 = AppEventQueue.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            AppEventStore.persistEvents(AppEventQueue.appEventCollection);
            AppEventQueue.appEventCollection = new AppEventCollection();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    @Nullable
    public static final FlushStatistics sendEventsToServer(@NotNull FlushReason flushReason0, @NotNull AppEventCollection appEventCollection0) {
        Class class0 = AppEventQueue.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(flushReason0, "reason");
            q.g(appEventCollection0, "appEventCollection");
            FlushStatistics flushStatistics0 = new FlushStatistics();
            List list0 = AppEventQueue.buildRequests(appEventCollection0, flushStatistics0);
            if(!list0.isEmpty()) {
                q.f("com.facebook.appevents.AppEventQueue", "TAG");
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, "com.facebook.appevents.AppEventQueue", "Flushing %d events due to %s.", new Object[]{flushStatistics0.getNumEvents(), flushReason0.toString()});
                for(Object object0: list0) {
                    ((GraphRequest)object0).executeAndWait();
                }
                return flushStatistics0;
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
        return null;
    }
}

