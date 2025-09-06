package com.facebook.appevents.eventdeactivation;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001BB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u001D\u0010\n\u001A\u00020\u00042\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000BJ-\u0010\u0010\u001A\u00020\u00042\u0014\u0010\u000E\u001A\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0006\u0010\u000F\u001A\u00020\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001A\u00020\u00128\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001A\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00150\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001A\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\r0\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001A¨\u0006\u001C"}, d2 = {"Lcom/facebook/appevents/eventdeactivation/EventDeactivationManager;", "", "<init>", "()V", "Lie/H;", "enable", "initialize", "", "Lcom/facebook/appevents/AppEvent;", "events", "processEvents", "(Ljava/util/List;)V", "", "", "parameters", "eventName", "processDeprecatedParameters", "(Ljava/util/Map;Ljava/lang/String;)V", "", "enabled", "Z", "Lcom/facebook/appevents/eventdeactivation/EventDeactivationManager$DeprecatedParamFilter;", "deprecatedParamFilters", "Ljava/util/List;", "", "deprecatedEvents", "Ljava/util/Set;", "DeprecatedParamFilter", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class EventDeactivationManager {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u001B\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006R \u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/facebook/appevents/eventdeactivation/EventDeactivationManager$DeprecatedParamFilter;", "", "eventName", "", "deprecateParams", "", "(Ljava/lang/String;Ljava/util/List;)V", "getDeprecateParams", "()Ljava/util/List;", "setDeprecateParams", "(Ljava/util/List;)V", "getEventName", "()Ljava/lang/String;", "setEventName", "(Ljava/lang/String;)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class DeprecatedParamFilter {
        @NotNull
        private List deprecateParams;
        @NotNull
        private String eventName;

        public DeprecatedParamFilter(@NotNull String s, @NotNull List list0) {
            q.g(s, "eventName");
            q.g(list0, "deprecateParams");
            super();
            this.eventName = s;
            this.deprecateParams = list0;
        }

        @NotNull
        public final List getDeprecateParams() {
            return this.deprecateParams;
        }

        @NotNull
        public final String getEventName() {
            return this.eventName;
        }

        public final void setDeprecateParams(@NotNull List list0) {
            q.g(list0, "<set-?>");
            this.deprecateParams = list0;
        }

        public final void setEventName(@NotNull String s) {
            q.g(s, "<set-?>");
            this.eventName = s;
        }
    }

    @NotNull
    public static final EventDeactivationManager INSTANCE;
    @NotNull
    private static final Set deprecatedEvents;
    @NotNull
    private static final List deprecatedParamFilters;
    private static boolean enabled;

    static {
        EventDeactivationManager.INSTANCE = new EventDeactivationManager();
        EventDeactivationManager.deprecatedParamFilters = new ArrayList();
        EventDeactivationManager.deprecatedEvents = new HashSet();
    }

    public static final void enable() {
        Class class0 = EventDeactivationManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        try {
            EventDeactivationManager.enabled = true;
            EventDeactivationManager.INSTANCE.initialize();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    private final void initialize() {
        synchronized(this) {
            if(CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                FetchedAppSettings fetchedAppSettings0 = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
                if(fetchedAppSettings0 == null) {
                    return;
                }
                String s = fetchedAppSettings0.getRestrictiveDataSetting();
                if(s != null && s.length() > 0) {
                    JSONObject jSONObject0 = new JSONObject(s);
                    EventDeactivationManager.deprecatedParamFilters.clear();
                    Iterator iterator0 = jSONObject0.keys();
                    while(iterator0.hasNext()) {
                        Object object0 = iterator0.next();
                        String s1 = (String)object0;
                        JSONObject jSONObject1 = jSONObject0.getJSONObject(s1);
                        if(jSONObject1 == null) {
                        }
                        else if(jSONObject1.optBoolean("is_deprecated_event")) {
                            q.f(s1, "key");
                            EventDeactivationManager.deprecatedEvents.add(s1);
                        }
                        else {
                            JSONArray jSONArray0 = jSONObject1.optJSONArray("deprecated_param");
                            q.f(s1, "key");
                            DeprecatedParamFilter eventDeactivationManager$DeprecatedParamFilter0 = new DeprecatedParamFilter(s1, new ArrayList());
                            if(jSONArray0 != null) {
                                eventDeactivationManager$DeprecatedParamFilter0.setDeprecateParams(Utility.convertJSONArrayToList(jSONArray0));
                            }
                            EventDeactivationManager.deprecatedParamFilters.add(eventDeactivationManager$DeprecatedParamFilter0);
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

    public static final void processDeprecatedParameters(@NotNull Map map0, @NotNull String s) {
        Class class0 = EventDeactivationManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                q.g(map0, "parameters");
                q.g(s, "eventName");
                if(EventDeactivationManager.enabled) {
                    ArrayList arrayList0 = new ArrayList(map0.keySet());
                    for(Object object0: new ArrayList(EventDeactivationManager.deprecatedParamFilters)) {
                        DeprecatedParamFilter eventDeactivationManager$DeprecatedParamFilter0 = (DeprecatedParamFilter)object0;
                        if(q.b(eventDeactivationManager$DeprecatedParamFilter0.getEventName(), s)) {
                            for(Object object1: arrayList0) {
                                String s1 = (String)object1;
                                if(eventDeactivationManager$DeprecatedParamFilter0.getDeprecateParams().contains(s1)) {
                                    map0.remove(s1);
                                }
                            }
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

    public static final void processEvents(@NotNull List list0) {
        Class class0 = EventDeactivationManager.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return;
        }
        else {
            try {
                q.g(list0, "events");
                if(EventDeactivationManager.enabled) {
                    Iterator iterator0 = list0.iterator();
                    while(iterator0.hasNext()) {
                        Object object0 = iterator0.next();
                        if(EventDeactivationManager.deprecatedEvents.contains(((AppEvent)object0).getName())) {
                            iterator0.remove();
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

