package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import com.facebook.GraphRequest;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.internal.AppEventsLoggerUtility.GraphAPIActivityType;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FeatureManager.Feature;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jeb.synthetic.FIN;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\r\b\u0001\u0018\u0000 02\u00020\u0001:\u00010B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J?\u0010\u0014\u001A\u00020\u00132\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\u000E2\u0006\u0010\u0012\u001A\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001A\u00020\u00132\u0006\u0010\u0017\u001A\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001B\u001A\u00020\u00132\u0006\u0010\u001A\u001A\u00020\u0011¢\u0006\u0004\b\u001B\u0010\u001CJ-\u0010\u0014\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\u001D\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u001EJ\u001B\u0010 \u001A\u00020\u00132\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00160\u001F¢\u0006\u0004\b \u0010!R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\"R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010#R\u001C\u0010%\u001A\b\u0012\u0004\u0012\u00020\u00160$8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b%\u0010&R\u001A\u0010\'\u001A\b\u0012\u0004\u0012\u00020\u00160$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\'\u0010&R\u0016\u0010(\u001A\u00020\f8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b(\u0010)R\u0011\u0010,\u001A\u00020\f8F¢\u0006\u0006\u001A\u0004\b*\u0010+R\u0017\u0010/\u001A\b\u0012\u0004\u0012\u00020\u00160\u001F8F¢\u0006\u0006\u001A\u0004\b-\u0010.¨\u00061"}, d2 = {"Lcom/facebook/appevents/SessionEventsState;", "", "Lcom/facebook/internal/AttributionIdentifiers;", "attributionIdentifiers", "", "anonymousAppDeviceGUID", "<init>", "(Lcom/facebook/internal/AttributionIdentifiers;Ljava/lang/String;)V", "Lcom/facebook/GraphRequest;", "request", "Landroid/content/Context;", "applicationContext", "", "numSkipped", "Lorg/json/JSONArray;", "events", "operationalParameters", "", "limitEventUsage", "Lie/H;", "populateRequest", "(Lcom/facebook/GraphRequest;Landroid/content/Context;ILorg/json/JSONArray;Lorg/json/JSONArray;Z)V", "Lcom/facebook/appevents/AppEvent;", "event", "addEvent", "(Lcom/facebook/appevents/AppEvent;)V", "moveToAccumulated", "clearInFlightAndStats", "(Z)V", "includeImplicitEvents", "(Lcom/facebook/GraphRequest;Landroid/content/Context;ZZ)I", "", "accumulatePersistedEvents", "(Ljava/util/List;)V", "Lcom/facebook/internal/AttributionIdentifiers;", "Ljava/lang/String;", "", "accumulatedEvents", "Ljava/util/List;", "inFlightEvents", "numSkippedEventsDueToFullBuffer", "I", "getAccumulatedEventCount", "()I", "accumulatedEventCount", "getEventsToPersist", "()Ljava/util/List;", "eventsToPersist", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class SessionEventsState {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001A\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/SessionEventsState$Companion;", "", "()V", "MAX_ACCUMULATED_LOG_EVENTS", "", "TAG", "", "kotlin.jvm.PlatformType", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion;
    private static final int MAX_ACCUMULATED_LOG_EVENTS;
    private static final String TAG;
    @NotNull
    private List accumulatedEvents;
    @NotNull
    private final String anonymousAppDeviceGUID;
    @NotNull
    private final AttributionIdentifiers attributionIdentifiers;
    @NotNull
    private final List inFlightEvents;
    private int numSkippedEventsDueToFullBuffer;

    static {
        SessionEventsState.Companion = new Companion(null);
        SessionEventsState.TAG = "SessionEventsState";
        SessionEventsState.MAX_ACCUMULATED_LOG_EVENTS = 1000;
    }

    public SessionEventsState(@NotNull AttributionIdentifiers attributionIdentifiers0, @NotNull String s) {
        q.g(attributionIdentifiers0, "attributionIdentifiers");
        q.g(s, "anonymousAppDeviceGUID");
        super();
        this.attributionIdentifiers = attributionIdentifiers0;
        this.anonymousAppDeviceGUID = s;
        this.accumulatedEvents = new ArrayList();
        this.inFlightEvents = new ArrayList();
    }

    public final void accumulatePersistedEvents(@NotNull List list0) {
        __monitor_enter(this);
        int v = FIN.finallyOpen$NT();
        if(CrashShieldHandler.isObjectCrashing(this)) {
            FIN.finallyCodeBegin$NT(v);
            __monitor_exit(this);
            FIN.finallyCodeEnd$NT(v);
            return;
        }
        try {
            q.g(list0, "events");
            this.accumulatedEvents.addAll(list0);
            FIN.finallyExec$NT(v);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            FIN.finallyExec$NT(v);
        }
    }

    public final void addEvent(@NotNull AppEvent appEvent0) {
        synchronized(this) {
            if(CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                q.g(appEvent0, "event");
                if(this.accumulatedEvents.size() + this.inFlightEvents.size() >= SessionEventsState.MAX_ACCUMULATED_LOG_EVENTS) {
                    ++this.numSkippedEventsDueToFullBuffer;
                }
                else {
                    this.accumulatedEvents.add(appEvent0);
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
            }
        }
    }

    public final void clearInFlightAndStats(boolean z) {
        synchronized(this) {
            if(CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                if(z) {
                    this.accumulatedEvents.addAll(this.inFlightEvents);
                }
                this.inFlightEvents.clear();
                this.numSkippedEventsDueToFullBuffer = 0;
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    public final int getAccumulatedEventCount() {
        __monitor_enter(this);
        int v = FIN.finallyOpen$NT();
        if(CrashShieldHandler.isObjectCrashing(this)) {
            FIN.finallyCodeBegin$NT(v);
            __monitor_exit(this);
            FIN.finallyCodeEnd$NT(v);
            return 0;
        }
        try {
            int v1 = this.accumulatedEvents.size();
            FIN.finallyExec$NT(v);
            return v1;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            FIN.finallyExec$NT(v);
            return 0;
        }
    }

    @NotNull
    public final List getEventsToPersist() {
        __monitor_enter(this);
        int v = FIN.finallyOpen$NT();
        if(CrashShieldHandler.isObjectCrashing(this)) {
            FIN.finallyCodeBegin$NT(v);
            __monitor_exit(this);
            FIN.finallyCodeEnd$NT(v);
            return null;
        }
        try {
            List list0 = this.accumulatedEvents;
            this.accumulatedEvents = new ArrayList();
            FIN.finallyExec$NT(v);
            return list0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            FIN.finallyExec$NT(v);
            return null;
        }
    }

    private final void populateRequest(GraphRequest graphRequest0, Context context0, int v, JSONArray jSONArray0, JSONArray jSONArray1, boolean z) {
        JSONObject jSONObject0;
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                try {
                    jSONObject0 = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(GraphAPIActivityType.CUSTOM_APP_EVENTS, this.attributionIdentifiers, this.anonymousAppDeviceGUID, z, context0);
                    if(this.numSkippedEventsDueToFullBuffer > 0) {
                        jSONObject0.put("num_skipped_events", v);
                    }
                }
                catch(JSONException unused_ex) {
                    jSONObject0 = new JSONObject();
                }
                graphRequest0.setGraphObject(jSONObject0);
                Bundle bundle0 = graphRequest0.getParameters();
                String s = jSONArray0.toString();
                q.f(s, "events.toString()");
                bundle0.putString("custom_events", s);
                if(FeatureManager.isEnabled(Feature.IapLoggingLib5To7)) {
                    bundle0.putString("operational_parameters", jSONArray1.toString());
                }
                graphRequest0.setTag(s);
                graphRequest0.setParameters(bundle0);
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
            }
        }
    }

    public final int populateRequest(@NotNull GraphRequest graphRequest0, @NotNull Context context0, boolean z, boolean z1) {
        Throwable throwable4;
        Throwable throwable2;
        Iterator iterator0;
        JSONArray jSONArray1;
        JSONArray jSONArray0;
        int v;
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            q.g(graphRequest0, "request");
            q.g(context0, "applicationContext");
            __monitor_enter(this);
            try {
                v = this.numSkippedEventsDueToFullBuffer;
                EventDeactivationManager.processEvents(this.accumulatedEvents);
                this.inFlightEvents.addAll(this.accumulatedEvents);
                this.accumulatedEvents.clear();
                jSONArray0 = new JSONArray();
                jSONArray1 = new JSONArray();
                iterator0 = this.inFlightEvents.iterator();
                while(true) {
                label_12:
                    if(!iterator0.hasNext()) {
                        if(jSONArray0.length() == 0) {
                            break;
                        }
                        goto label_23;
                    }
                    goto label_26;
                }
            }
            catch(Throwable throwable1) {
                throwable2 = throwable1;
                __monitor_exit(this);
                throw throwable2;
            }
            try {
                __monitor_exit(this);
                return 0;
            }
            catch(Throwable throwable3) {
                throwable4 = throwable3;
                goto label_38;
            }
        label_23:
            __monitor_exit(this);
            this.populateRequest(graphRequest0, context0, v, jSONArray0, jSONArray1, z1);
            return jSONArray0.length();
            try {
            label_26:
                Object object0 = iterator0.next();
                AppEvent appEvent0 = (AppEvent)object0;
                if(!z && appEvent0.isImplicit()) {
                    goto label_12;
                }
                jSONArray0.put(appEvent0.getJsonObject());
                jSONArray1.put(appEvent0.getOperationalJsonObject());
                goto label_12;
            }
            catch(Throwable throwable5) {
                throwable2 = throwable5;
            }
            __monitor_exit(this);
            throw throwable2;
        }
        catch(Throwable throwable0) {
            throwable4 = throwable0;
        }
    label_38:
        CrashShieldHandler.handleThrowable(throwable4, this);
        return 0;
    }
}

