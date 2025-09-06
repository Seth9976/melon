package com.facebook.appevents;

import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000  2\u00020\u0001:\u0002 !B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B9\b\u0016\u0012.\u0010\t\u001A*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\b¢\u0006\u0004\b\u0002\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00050\u000E¢\u0006\u0004\b\u000F\u0010\u0010J%\u0010\u0012\u001A\u001A\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00110\u000E¢\u0006\u0004\b\u0012\u0010\u0010J \u0010\u0015\u001A\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00142\u0006\u0010\u0013\u001A\u00020\u0005H\u0086\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0013\u001A\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u0013\u001A\u00020\u00052\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0004\b\u001C\u0010\u001DR<\u0010\u001E\u001A*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001E\u0010\u001F¨\u0006\""}, d2 = {"Lcom/facebook/appevents/PersistedEvents;", "Ljava/io/Serializable;", "<init>", "()V", "Ljava/util/HashMap;", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "", "Lcom/facebook/appevents/AppEvent;", "Lkotlin/collections/HashMap;", "appEventMap", "(Ljava/util/HashMap;)V", "", "writeReplace", "()Ljava/lang/Object;", "", "keySet", "()Ljava/util/Set;", "", "entrySet", "accessTokenAppIdPair", "", "get", "(Lcom/facebook/appevents/AccessTokenAppIdPair;)Ljava/util/List;", "", "containsKey", "(Lcom/facebook/appevents/AccessTokenAppIdPair;)Z", "appEvents", "Lie/H;", "addEvents", "(Lcom/facebook/appevents/AccessTokenAppIdPair;Ljava/util/List;)V", "events", "Ljava/util/HashMap;", "Companion", "SerializationProxyV1", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class PersistedEvents implements Serializable {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/appevents/PersistedEvents$Companion;", "", "()V", "serialVersionUID", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000B2\u00020\u0001:\u0001\u000BB5\u0012.\u0010\u0002\u001A*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005`\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001A\u00020\nH\u0002R6\u0010\u0002\u001A*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/appevents/PersistedEvents$SerializationProxyV1;", "Ljava/io/Serializable;", "proxyEvents", "Ljava/util/HashMap;", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "", "Lcom/facebook/appevents/AppEvent;", "Lkotlin/collections/HashMap;", "(Ljava/util/HashMap;)V", "readResolve", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class SerializationProxyV1 implements Serializable {
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/appevents/PersistedEvents$SerializationProxyV1$Companion;", "", "()V", "serialVersionUID", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static final class com.facebook.appevents.PersistedEvents.SerializationProxyV1.Companion {
            private com.facebook.appevents.PersistedEvents.SerializationProxyV1.Companion() {
            }

            public com.facebook.appevents.PersistedEvents.SerializationProxyV1.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        @NotNull
        public static final com.facebook.appevents.PersistedEvents.SerializationProxyV1.Companion Companion = null;
        @NotNull
        private final HashMap proxyEvents;
        private static final long serialVersionUID = 20160629001L;

        static {
            SerializationProxyV1.Companion = new com.facebook.appevents.PersistedEvents.SerializationProxyV1.Companion(null);
        }

        public SerializationProxyV1(@NotNull HashMap hashMap0) {
            q.g(hashMap0, "proxyEvents");
            super();
            this.proxyEvents = hashMap0;
        }

        private final Object readResolve() {
            return new PersistedEvents(this.proxyEvents);
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private final HashMap events;
    private static final long serialVersionUID = 20160629001L;

    static {
        PersistedEvents.Companion = new Companion(null);
    }

    public PersistedEvents() {
        this.events = new HashMap();
    }

    public PersistedEvents(@NotNull HashMap hashMap0) {
        q.g(hashMap0, "appEventMap");
        super();
        HashMap hashMap1 = new HashMap();
        this.events = hashMap1;
        hashMap1.putAll(hashMap0);
    }

    public final void addEvents(@NotNull AccessTokenAppIdPair accessTokenAppIdPair0, @NotNull List list0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        else {
            try {
                q.g(accessTokenAppIdPair0, "accessTokenAppIdPair");
                q.g(list0, "appEvents");
                if(!this.events.containsKey(accessTokenAppIdPair0)) {
                    ArrayList arrayList0 = p.Q0(list0);
                    this.events.put(accessTokenAppIdPair0, arrayList0);
                    return;
                }
                List list1 = (List)this.events.get(accessTokenAppIdPair0);
                if(list1 != null) {
                    list1.addAll(list0);
                }
                return;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
    }

    public final boolean containsKey(@NotNull AccessTokenAppIdPair accessTokenAppIdPair0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            q.g(accessTokenAppIdPair0, "accessTokenAppIdPair");
            return this.events.containsKey(accessTokenAppIdPair0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return false;
        }
    }

    @NotNull
    public final Set entrySet() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Set set0 = this.events.entrySet();
            q.f(set0, "events.entries");
            return set0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    @Nullable
    public final List get(@NotNull AccessTokenAppIdPair accessTokenAppIdPair0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            q.g(accessTokenAppIdPair0, "accessTokenAppIdPair");
            return (List)this.events.get(accessTokenAppIdPair0);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    @NotNull
    public final Set keySet() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Set set0 = this.events.keySet();
            q.f(set0, "events.keys");
            return set0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    private final Object writeReplace() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return new SerializationProxyV1(this.events);
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }
}

