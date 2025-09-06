package com.facebook.appevents.internal;

import android.content.Context;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import ie.m;
import java.util.Iterator;
import java.util.Map;
import je.C;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u00052\b\u0010\n\u001A\u0004\u0018\u00010\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u00062\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H\u0007R\u001A\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/appevents/internal/AppEventsLoggerUtility;", "", "()V", "API_ACTIVITY_TYPE_TO_STRING", "", "Lcom/facebook/appevents/internal/AppEventsLoggerUtility$GraphAPIActivityType;", "", "getJSONObjectForGraphAPICall", "Lorg/json/JSONObject;", "activityType", "attributionIdentifiers", "Lcom/facebook/internal/AttributionIdentifiers;", "anonymousAppDeviceGUID", "limitEventUsage", "", "context", "Landroid/content/Context;", "GraphAPIActivityType", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AppEventsLoggerUtility {
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/appevents/internal/AppEventsLoggerUtility$GraphAPIActivityType;", "", "(Ljava/lang/String;I)V", "MOBILE_INSTALL_EVENT", "CUSTOM_APP_EVENTS", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum GraphAPIActivityType {
        MOBILE_INSTALL_EVENT,
        CUSTOM_APP_EVENTS;

        private static final GraphAPIActivityType[] $values() [...] // Inlined contents
    }

    @NotNull
    private static final Map API_ACTIVITY_TYPE_TO_STRING;
    @NotNull
    public static final AppEventsLoggerUtility INSTANCE;

    static {
        AppEventsLoggerUtility.INSTANCE = new AppEventsLoggerUtility();
        AppEventsLoggerUtility.API_ACTIVITY_TYPE_TO_STRING = C.R(new m[]{new m(GraphAPIActivityType.MOBILE_INSTALL_EVENT, "MOBILE_APP_INSTALL"), new m(GraphAPIActivityType.CUSTOM_APP_EVENTS, "CUSTOM_APP_EVENTS")});
    }

    @NotNull
    public static final JSONObject getJSONObjectForGraphAPICall(@NotNull GraphAPIActivityType appEventsLoggerUtility$GraphAPIActivityType0, @Nullable AttributionIdentifiers attributionIdentifiers0, @Nullable String s, boolean z, @NotNull Context context0) {
        q.g(appEventsLoggerUtility$GraphAPIActivityType0, "activityType");
        q.g(context0, "context");
        JSONObject jSONObject0 = new JSONObject();
        jSONObject0.put("event", AppEventsLoggerUtility.API_ACTIVITY_TYPE_TO_STRING.get(appEventsLoggerUtility$GraphAPIActivityType0));
        String s1 = AppEventsLogger.Companion.getUserID();
        if(s1 != null) {
            jSONObject0.put("app_user_id", s1);
        }
        Utility.setAppEventAttributionParameters(jSONObject0, attributionIdentifiers0, s, z, context0);
        try {
            Utility.setAppEventExtendedDeviceInfoParameters(jSONObject0, context0);
        }
        catch(Exception exception0) {
            Logger.Companion.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Fetching extended device info parameters failed: \'%s\'", new Object[]{exception0.toString()});
        }
        JSONObject jSONObject1 = Utility.getDataProcessingOptions();
        if(jSONObject1 != null) {
            Iterator iterator0 = jSONObject1.keys();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                jSONObject0.put(((String)object0), jSONObject1.get(((String)object0)));
            }
        }
        jSONObject0.put("application_package_name", "com.iloen.melon");
        return jSONObject0;
    }
}

