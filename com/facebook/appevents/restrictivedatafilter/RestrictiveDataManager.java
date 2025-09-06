package com.facebook.appevents.restrictivedatafilter;

import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001%B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ-\u0010\r\u001A\u00020\u00042\u0014\u0010\f\u001A\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000B2\u0006\u0010\b\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\r\u0010\u000EJ!\u0010\u0010\u001A\u0004\u0018\u00010\u00072\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001A\u00020\u00122\u0006\u0010\b\u001A\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001A\u00020\u00128\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001C\u0010\u0018\u001A\n \u0017*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001A\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u001B0\u001A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001C\u0010\u001DR\u001A\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u00070\u001E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001F\u0010 R\u0014\u0010!\u001A\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u0019R\u0014\u0010\"\u001A\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u0019R\u0014\u0010#\u001A\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\u0019R\u0014\u0010$\u001A\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010\u0019¨\u0006&"}, d2 = {"Lcom/facebook/appevents/restrictivedatafilter/RestrictiveDataManager;", "", "<init>", "()V", "Lie/H;", "enable", "initialize", "", "eventName", "processEvent", "(Ljava/lang/String;)Ljava/lang/String;", "", "parameters", "processParameters", "(Ljava/util/Map;Ljava/lang/String;)V", "paramKey", "getMatchedRuleType", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "isRestrictedEvent", "(Ljava/lang/String;)Z", "enabled", "Z", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "", "Lcom/facebook/appevents/restrictivedatafilter/RestrictiveDataManager$RestrictiveParamFilter;", "restrictiveParamFilters", "Ljava/util/List;", "", "restrictedEvents", "Ljava/util/Set;", "REPLACEMENT_STRING", "PROCESS_EVENT_NAME", "RESTRICTIVE_PARAM", "RESTRICTIVE_PARAM_KEY", "RestrictiveParamFilter", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class RestrictiveDataManager {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010$\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0014\u0010\u0004\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005¢\u0006\u0002\u0010\u0006R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\u0004\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/facebook/appevents/restrictivedatafilter/RestrictiveDataManager$RestrictiveParamFilter;", "", "eventName", "", "restrictiveParams", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getEventName", "()Ljava/lang/String;", "setEventName", "(Ljava/lang/String;)V", "getRestrictiveParams", "()Ljava/util/Map;", "setRestrictiveParams", "(Ljava/util/Map;)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class RestrictiveParamFilter {
        @NotNull
        private String eventName;
        @NotNull
        private Map restrictiveParams;

        public RestrictiveParamFilter(@NotNull String s, @NotNull Map map0) {
            q.g(s, "eventName");
            q.g(map0, "restrictiveParams");
            super();
            this.eventName = s;
            this.restrictiveParams = map0;
        }

        @NotNull
        public final String getEventName() {
            return this.eventName;
        }

        @NotNull
        public final Map getRestrictiveParams() {
            return this.restrictiveParams;
        }

        public final void setEventName(@NotNull String s) {
            q.g(s, "<set-?>");
            this.eventName = s;
        }

        public final void setRestrictiveParams(@NotNull Map map0) {
            q.g(map0, "<set-?>");
            this.restrictiveParams = map0;
        }
    }

    @NotNull
    public static final RestrictiveDataManager INSTANCE = null;
    @NotNull
    private static final String PROCESS_EVENT_NAME = "process_event_name";
    @NotNull
    private static final String REPLACEMENT_STRING = "_removed_";
    @NotNull
    private static final String RESTRICTIVE_PARAM = "restrictive_param";
    @NotNull
    private static final String RESTRICTIVE_PARAM_KEY = "_restrictedParams";
    private static final String TAG;
    private static boolean enabled;
    @NotNull
    private static final Set restrictedEvents;
    @NotNull
    private static final List restrictiveParamFilters;

    static {
        RestrictiveDataManager.INSTANCE = new RestrictiveDataManager();
        RestrictiveDataManager.TAG = RestrictiveDataManager.class.getCanonicalName();
        RestrictiveDataManager.restrictiveParamFilters = new ArrayList();
        RestrictiveDataManager.restrictedEvents = new CopyOnWriteArraySet();
    }

    public static final void enable() {
        Class class0 = RestrictiveDataManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            RestrictiveDataManager.enabled = true;
            RestrictiveDataManager.INSTANCE.initialize();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    private final String getMatchedRuleType(String s, String s1) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            try {
                Iterator iterator0 = new ArrayList(RestrictiveDataManager.restrictiveParamFilters).iterator();
            alab1:
                while(true) {
                label_3:
                    if(!iterator0.hasNext()) {
                        return null;
                    }
                    Object object0 = iterator0.next();
                    RestrictiveParamFilter restrictiveDataManager$RestrictiveParamFilter0 = (RestrictiveParamFilter)object0;
                    if(restrictiveDataManager$RestrictiveParamFilter0 != null && q.b(s, restrictiveDataManager$RestrictiveParamFilter0.getEventName())) {
                        Iterator iterator1 = restrictiveDataManager$RestrictiveParamFilter0.getRestrictiveParams().keySet().iterator();
                        while(true) {
                            if(!iterator1.hasNext()) {
                                break alab1;
                            }
                            Object object1 = iterator1.next();
                            String s2 = (String)object1;
                            if(!q.b(s1, s2)) {
                                continue;
                            }
                            return (String)restrictiveDataManager$RestrictiveParamFilter0.getRestrictiveParams().get(s2);
                        }
                    }
                }
            }
            catch(Exception exception0) {
                Log.w(RestrictiveDataManager.TAG, "getMatchedRuleType failed", exception0);
                return null;
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
        goto label_3;
    }

    private final void initialize() {
        if(!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                FetchedAppSettings fetchedAppSettings0 = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                if(fetchedAppSettings0 != null) {
                    String s = fetchedAppSettings0.getRestrictiveDataSetting();
                    if(s != null) {
                        if(s.length() == 0) {
                            return;
                        }
                        JSONObject jSONObject0 = new JSONObject(s);
                        RestrictiveDataManager.restrictiveParamFilters.clear();
                        RestrictiveDataManager.restrictedEvents.clear();
                        Iterator iterator0 = jSONObject0.keys();
                        while(true) {
                            if(!iterator0.hasNext()) {
                                break;
                            }
                            Object object0 = iterator0.next();
                            String s1 = (String)object0;
                            JSONObject jSONObject1 = jSONObject0.getJSONObject(s1);
                            if(jSONObject1 != null) {
                                JSONObject jSONObject2 = jSONObject1.optJSONObject("restrictive_param");
                                q.f(s1, "key");
                                RestrictiveParamFilter restrictiveDataManager$RestrictiveParamFilter0 = new RestrictiveParamFilter(s1, new HashMap());
                                if(jSONObject2 != null) {
                                    restrictiveDataManager$RestrictiveParamFilter0.setRestrictiveParams(Utility.convertJSONObjectToStringMap(jSONObject2));
                                    RestrictiveDataManager.restrictiveParamFilters.add(restrictiveDataManager$RestrictiveParamFilter0);
                                }
                                if(jSONObject1.has("process_event_name")) {
                                    RestrictiveDataManager.restrictedEvents.add(restrictiveDataManager$RestrictiveParamFilter0.getEventName());
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

    private final boolean isRestrictedEvent(String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return RestrictiveDataManager.restrictedEvents.contains(s);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return false;
        }
    }

    @NotNull
    public static final String processEvent(@NotNull String s) {
        Class class0 = RestrictiveDataManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(s, "eventName");
            return RestrictiveDataManager.enabled && RestrictiveDataManager.INSTANCE.isRestrictedEvent(s) ? "_removed_" : s;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    public static final void processParameters(@NotNull Map map0, @NotNull String s) {
        Class class0 = RestrictiveDataManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                q.g(map0, "parameters");
                q.g(s, "eventName");
                if(RestrictiveDataManager.enabled) {
                    HashMap hashMap0 = new HashMap();
                    for(Object object0: new ArrayList(map0.keySet())) {
                        String s1 = (String)object0;
                        String s2 = RestrictiveDataManager.INSTANCE.getMatchedRuleType(s, s1);
                        if(s2 != null) {
                            hashMap0.put(s1, s2);
                            map0.remove(s1);
                        }
                    }
                    if(!hashMap0.isEmpty()) {
                        try {
                            JSONObject jSONObject0 = new JSONObject();
                            for(Object object1: hashMap0.entrySet()) {
                                jSONObject0.put(((String)((Map.Entry)object1).getKey()), ((String)((Map.Entry)object1).getValue()));
                            }
                            map0.put("_restrictedParams", jSONObject0.toString());
                        }
                        catch(JSONException unused_ex) {
                        }
                    }
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
    }
}

