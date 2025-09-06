package com.facebook.appevents.integrity;

import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0003J\u000F\u0010\u0007\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u0017\u0010\n\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u0019\u0010\f\u001A\u0004\u0018\u00010\b2\u0006\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\u000BR\u0016\u0010\u000E\u001A\u00020\r8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u000E\u0010\u000FR2\u0010\u0013\u001A\u001E\u0012\u0004\u0012\u00020\b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0011j\b\u0012\u0004\u0012\u00020\b`\u00120\u00108\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/facebook/appevents/integrity/RedactedEventsManager;", "", "<init>", "()V", "Lie/H;", "enable", "disable", "loadRedactedEvents", "", "eventName", "processEventsRedaction", "(Ljava/lang/String;)Ljava/lang/String;", "getRedactionString", "", "enabled", "Z", "", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "redactedEvents", "Ljava/util/Map;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class RedactedEventsManager {
    @NotNull
    public static final RedactedEventsManager INSTANCE;
    private static boolean enabled;
    @NotNull
    private static Map redactedEvents;

    static {
        RedactedEventsManager.INSTANCE = new RedactedEventsManager();
        RedactedEventsManager.redactedEvents = new HashMap();
    }

    public static final void disable() {
        Class class0 = RedactedEventsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            RedactedEventsManager.enabled = false;
            RedactedEventsManager.redactedEvents = new HashMap();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void enable() {
        Class class0 = RedactedEventsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                RedactedEventsManager.INSTANCE.loadRedactedEvents();
                if(!RedactedEventsManager.redactedEvents.isEmpty()) {
                    RedactedEventsManager.enabled = true;
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }

    private final String getRedactionString(String s) {
        String s1;
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Iterator iterator0 = RedactedEventsManager.redactedEvents.keySet().iterator();
            do {
                if(!iterator0.hasNext()) {
                    return null;
                }
                Object object0 = iterator0.next();
                s1 = (String)object0;
                HashSet hashSet0 = (HashSet)RedactedEventsManager.redactedEvents.get(s1);
            }
            while(hashSet0 == null || !hashSet0.contains(s));
            return s1;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    private final void loadRedactedEvents() {
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                FetchedAppSettings fetchedAppSettings0 = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                if(fetchedAppSettings0 != null) {
                    try {
                        RedactedEventsManager.redactedEvents = new HashMap();
                        JSONArray jSONArray0 = fetchedAppSettings0.getRedactedEvents();
                        if(jSONArray0 != null && jSONArray0.length() != 0) {
                            int v1 = jSONArray0.length();
                            for(int v = 0; v < v1; ++v) {
                                JSONObject jSONObject0 = jSONArray0.getJSONObject(v);
                                if(jSONObject0.has("key") && jSONObject0.has("value")) {
                                    String s = jSONObject0.getString("key");
                                    JSONArray jSONArray1 = jSONObject0.getJSONArray("value");
                                    if(s != null) {
                                        HashSet hashSet0 = Utility.convertJSONArrayToHashSet(jSONArray1);
                                        if(hashSet0 != null) {
                                            RedactedEventsManager.redactedEvents.put(s, hashSet0);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    catch(Exception unused_ex) {
                    }
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, this);
            }
        }
    }

    @NotNull
    public static final String processEventsRedaction(@NotNull String s) {
        Class class0 = RedactedEventsManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(s, "eventName");
            if(!RedactedEventsManager.enabled) {
                return s;
            }
            String s1 = RedactedEventsManager.INSTANCE.getRedactionString(s);
            return s1 == null ? s : s1;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }
}

