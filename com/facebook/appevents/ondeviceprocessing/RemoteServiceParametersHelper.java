package com.facebook.appevents.ondeviceprocessing;

import android.os.Bundle;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.List;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0006\u001A\u0004\u0018\u00010\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u00042\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\fH\u0007J\u001E\u0010\u000E\u001A\u00020\u000F2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\n\u001A\u00020\u0004H\u0002J\u0010\u0010\u0010\u001A\u00020\u00112\u0006\u0010\n\u001A\u00020\u0004H\u0002R\u0016\u0010\u0003\u001A\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/appevents/ondeviceprocessing/RemoteServiceParametersHelper;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "buildEventsBundle", "Landroid/os/Bundle;", "eventType", "Lcom/facebook/appevents/ondeviceprocessing/RemoteServiceWrapper$EventType;", "applicationId", "appEvents", "", "Lcom/facebook/appevents/AppEvent;", "buildEventsJson", "Lorg/json/JSONArray;", "includeImplicitEvents", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class RemoteServiceParametersHelper {
    @NotNull
    public static final RemoteServiceParametersHelper INSTANCE;
    private static final String TAG;

    static {
        RemoteServiceParametersHelper.INSTANCE = new RemoteServiceParametersHelper();
        RemoteServiceParametersHelper.TAG = "RemoteServiceWrapper";
    }

    @Nullable
    public static final Bundle buildEventsBundle(@NotNull EventType remoteServiceWrapper$EventType0, @NotNull String s, @NotNull List list0) {
        Class class0 = RemoteServiceParametersHelper.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(remoteServiceWrapper$EventType0, "eventType");
            q.g(s, "applicationId");
            q.g(list0, "appEvents");
            Bundle bundle0 = new Bundle();
            bundle0.putString("event", remoteServiceWrapper$EventType0.toString());
            bundle0.putString("app_id", s);
            if(EventType.CUSTOM_APP_EVENTS == remoteServiceWrapper$EventType0) {
                JSONArray jSONArray0 = RemoteServiceParametersHelper.INSTANCE.buildEventsJson(list0, s);
                if(jSONArray0.length() == 0) {
                    return null;
                }
                bundle0.putString("custom_events", jSONArray0.toString());
                return bundle0;
            }
            return bundle0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    private final JSONArray buildEventsJson(List list0, String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            JSONArray jSONArray0 = new JSONArray();
            ArrayList arrayList0 = p.Q0(list0);
            EventDeactivationManager.processEvents(arrayList0);
            boolean z = this.includeImplicitEvents(s);
            for(Object object0: arrayList0) {
                AppEvent appEvent0 = (AppEvent)object0;
                if(!appEvent0.isImplicit() || z) {
                    jSONArray0.put(appEvent0.getJsonObject());
                }
            }
            return jSONArray0;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return null;
    }

    private final boolean includeImplicitEvents(String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            FetchedAppSettings fetchedAppSettings0 = FetchedAppSettingsManager.queryAppSettings(s, false);
            return fetchedAppSettings0 == null ? false : fetchedAppSettings0.supportsImplicitLogging();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return false;
        }
    }
}

