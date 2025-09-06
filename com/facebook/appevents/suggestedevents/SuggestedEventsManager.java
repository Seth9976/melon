package com.facebook.appevents.suggestedevents;

import A5.a;
import android.app.Activity;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.ml.ModelManager.Task;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import jeb.synthetic.FIN;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0012\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000EH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000EH\u0001¢\u0006\u0004\b\u0013\u0010\u0011J\u0019\u0010\u0018\u001A\u00020\u00042\b\u0010\u0015\u001A\u0004\u0018\u00010\u000EH\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001A\u001A\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001A\u0010\u001BR\u001A\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u000E0\u001C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001D\u0010\u001ER\u001A\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u000E0\u001C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001F\u0010\u001ER\u0014\u0010 \u001A\u00020\u000E8\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001A\u00020\u000E8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010!¨\u0006#"}, d2 = {"Lcom/facebook/appevents/suggestedevents/SuggestedEventsManager;", "", "<init>", "()V", "Lie/H;", "enable", "initialize", "Landroid/app/Activity;", "activity", "trackActivity", "(Landroid/app/Activity;)V", "", "isEnabled", "()Z", "", "event", "isProductionEvents$facebook_core_release", "(Ljava/lang/String;)Z", "isProductionEvents", "isEligibleEvents$facebook_core_release", "isEligibleEvents", "rawSuggestedEventSetting", "populateEventsFromRawJsonString$facebook_core_release", "(Ljava/lang/String;)V", "populateEventsFromRawJsonString", "Ljava/util/concurrent/atomic/AtomicBoolean;", "enabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "productionEvents", "Ljava/util/Set;", "eligibleEvents", "PRODUCTION_EVENTS_KEY", "Ljava/lang/String;", "ELIGIBLE_EVENTS_KEY", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class SuggestedEventsManager {
    @NotNull
    private static final String ELIGIBLE_EVENTS_KEY = "eligible_for_prediction_events";
    @NotNull
    public static final SuggestedEventsManager INSTANCE = null;
    @NotNull
    private static final String PRODUCTION_EVENTS_KEY = "production_events";
    @NotNull
    private static final Set eligibleEvents;
    @NotNull
    private static final AtomicBoolean enabled;
    @NotNull
    private static final Set productionEvents;

    static {
        SuggestedEventsManager.INSTANCE = new SuggestedEventsManager();
        SuggestedEventsManager.enabled = new AtomicBoolean(false);
        SuggestedEventsManager.productionEvents = new LinkedHashSet();
        SuggestedEventsManager.eligibleEvents = new LinkedHashSet();
    }

    public static final void enable() {
        Class class0 = SuggestedEventsManager.class;
        __monitor_enter(class0);
        int v = FIN.finallyOpen$NT();
        if(CrashShieldHandler.isObjectCrashing(SuggestedEventsManager.class)) {
            FIN.finallyCodeBegin$NT(v);
            __monitor_exit(class0);
            FIN.finallyCodeEnd$NT(v);
            return;
        }
        try {
            FacebookSdk.getExecutor().execute(new a(4));
            FIN.finallyExec$NT(v);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, SuggestedEventsManager.class);
            FIN.finallyExec$NT(v);
        }
    }

    private static final void enable$lambda$0() {
        Class class0 = SuggestedEventsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                AtomicBoolean atomicBoolean0 = SuggestedEventsManager.enabled;
                if(!atomicBoolean0.get()) {
                    atomicBoolean0.set(true);
                    SuggestedEventsManager.INSTANCE.initialize();
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    private final void initialize() {
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                FetchedAppSettings fetchedAppSettings0 = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                if(fetchedAppSettings0 != null) {
                    String s = fetchedAppSettings0.getSuggestedEventsSetting();
                    if(s != null) {
                        this.populateEventsFromRawJsonString$facebook_core_release(s);
                        if(!SuggestedEventsManager.productionEvents.isEmpty() || !SuggestedEventsManager.eligibleEvents.isEmpty()) {
                            File file0 = ModelManager.getRuleFile(Task.MTML_APP_EVENT_PREDICTION);
                            if(file0 != null) {
                                FeatureExtractor.initialize(file0);
                                Activity activity0 = ActivityLifecycleTracker.getCurrentActivity();
                                if(activity0 != null) {
                                    SuggestedEventsManager.trackActivity(activity0);
                                    return;
                                }
                            }
                        }
                    }
                }
                return;
            }
            catch(Exception unused_ex) {
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public static final boolean isEligibleEvents$facebook_core_release(@NotNull String s) {
        Class class0 = SuggestedEventsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return false;
        }
        try {
            q.g(s, "event");
            return SuggestedEventsManager.eligibleEvents.contains(s);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return false;
        }
    }

    public static final boolean isEnabled() {
        Class class0 = SuggestedEventsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return false;
        }
        try {
            return SuggestedEventsManager.enabled.get();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return false;
        }
    }

    public static final boolean isProductionEvents$facebook_core_release(@NotNull String s) {
        Class class0 = SuggestedEventsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return false;
        }
        try {
            q.g(s, "event");
            return SuggestedEventsManager.productionEvents.contains(s);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return false;
        }
    }

    public final void populateEventsFromRawJsonString$facebook_core_release(@Nullable String s) {
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                JSONObject jSONObject0 = new JSONObject(s);
                if(jSONObject0.has("production_events")) {
                    JSONArray jSONArray0 = jSONObject0.getJSONArray("production_events");
                    int v1 = jSONArray0.length();
                    for(int v2 = 0; v2 < v1; ++v2) {
                        String s1 = jSONArray0.getString(v2);
                        q.f(s1, "jsonArray.getString(i)");
                        SuggestedEventsManager.productionEvents.add(s1);
                    }
                }
                if(jSONObject0.has("eligible_for_prediction_events")) {
                    JSONArray jSONArray1 = jSONObject0.getJSONArray("eligible_for_prediction_events");
                    int v3 = jSONArray1.length();
                    for(int v = 0; true; ++v) {
                    label_16:
                        if(v >= v3) {
                            break;
                        }
                        String s2 = jSONArray1.getString(v);
                        q.f(s2, "jsonArray.getString(i)");
                        SuggestedEventsManager.eligibleEvents.add(s2);
                    }
                }
                return;
            }
            catch(Exception unused_ex) {
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
            if(true) {
                return;
            }
            goto label_16;
        }
    }

    public static final void trackActivity(@NotNull Activity activity0) {
        Class class0 = SuggestedEventsManager.class;
        if(!CrashShieldHandler.isObjectCrashing(class0)) {
            try {
                q.g(activity0, "activity");
                try {
                    if(SuggestedEventsManager.enabled.get() && FeatureExtractor.isInitialized() && (!SuggestedEventsManager.productionEvents.isEmpty() || !SuggestedEventsManager.eligibleEvents.isEmpty())) {
                        ViewObserver.Companion.startTrackingActivity(activity0);
                        return;
                    }
                    ViewObserver.Companion.stopTrackingActivity(activity0);
                }
                catch(Exception unused_ex) {
                }
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }
}

