package com.facebook.appevents;

import android.content.Context;
import com.facebook.FacebookSdk;
import com.facebook.internal.AttributionIdentifiers;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001A\u00020\u000B2\b\u0010\n\u001A\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\u001D\u0010\u0011\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\u000F¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00040\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u001A\u0010\u0016\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u000E\u001A\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\u0016\u0010\bR \u0010\u0018\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001D\u001A\u00020\u001A8F¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001C¨\u0006\u001E"}, d2 = {"Lcom/facebook/appevents/AppEventCollection;", "", "<init>", "()V", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "accessTokenAppId", "Lcom/facebook/appevents/SessionEventsState;", "getSessionEventsState", "(Lcom/facebook/appevents/AccessTokenAppIdPair;)Lcom/facebook/appevents/SessionEventsState;", "Lcom/facebook/appevents/PersistedEvents;", "persistedEvents", "Lie/H;", "addPersistedEvents", "(Lcom/facebook/appevents/PersistedEvents;)V", "accessTokenAppIdPair", "Lcom/facebook/appevents/AppEvent;", "appEvent", "addEvent", "(Lcom/facebook/appevents/AccessTokenAppIdPair;Lcom/facebook/appevents/AppEvent;)V", "", "keySet", "()Ljava/util/Set;", "get", "Ljava/util/HashMap;", "stateMap", "Ljava/util/HashMap;", "", "getEventCount", "()I", "eventCount", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AppEventCollection {
    @NotNull
    private final HashMap stateMap;

    public AppEventCollection() {
        this.stateMap = new HashMap();
    }

    public final void addEvent(@NotNull AccessTokenAppIdPair accessTokenAppIdPair0, @NotNull AppEvent appEvent0) {
        synchronized(this) {
            q.g(accessTokenAppIdPair0, "accessTokenAppIdPair");
            q.g(appEvent0, "appEvent");
            SessionEventsState sessionEventsState0 = this.getSessionEventsState(accessTokenAppIdPair0);
            if(sessionEventsState0 != null) {
                sessionEventsState0.addEvent(appEvent0);
            }
        }
    }

    public final void addPersistedEvents(@Nullable PersistedEvents persistedEvents0) {
        synchronized(this) {
            if(persistedEvents0 == null) {
                return;
            }
            for(Object object0: persistedEvents0.entrySet()) {
                Map.Entry map$Entry0 = (Map.Entry)object0;
                SessionEventsState sessionEventsState0 = this.getSessionEventsState(((AccessTokenAppIdPair)map$Entry0.getKey()));
                if(sessionEventsState0 != null) {
                    for(Object object1: ((List)map$Entry0.getValue())) {
                        sessionEventsState0.addEvent(((AppEvent)object1));
                    }
                }
            }
        }
    }

    @Nullable
    public final SessionEventsState get(@NotNull AccessTokenAppIdPair accessTokenAppIdPair0) {
        synchronized(this) {
            q.g(accessTokenAppIdPair0, "accessTokenAppIdPair");
            return (SessionEventsState)this.stateMap.get(accessTokenAppIdPair0);
        }
    }

    public final int getEventCount() {
        synchronized(this) {
            int v1 = 0;
            for(Object object0: this.stateMap.values()) {
                v1 += ((SessionEventsState)object0).getAccumulatedEventCount();
            }
            return v1;
        }
    }

    private final SessionEventsState getSessionEventsState(AccessTokenAppIdPair accessTokenAppIdPair0) {
        synchronized(this) {
            SessionEventsState sessionEventsState0 = (SessionEventsState)this.stateMap.get(accessTokenAppIdPair0);
            if(sessionEventsState0 == null) {
                Context context0 = FacebookSdk.getApplicationContext();
                AttributionIdentifiers attributionIdentifiers0 = AttributionIdentifiers.Companion.getAttributionIdentifiers(context0);
                if(attributionIdentifiers0 != null) {
                    sessionEventsState0 = new SessionEventsState(attributionIdentifiers0, AppEventsLogger.Companion.getAnonymousAppDeviceGUID(context0));
                }
            }
            if(sessionEventsState0 == null) {
                return null;
            }
            this.stateMap.put(accessTokenAppIdPair0, sessionEventsState0);
            return sessionEventsState0;
        }
    }

    @NotNull
    public final Set keySet() {
        synchronized(this) {
            Set set0 = this.stateMap.keySet();
            q.f(set0, "stateMap.keys");
            return set0;
        }
    }
}

