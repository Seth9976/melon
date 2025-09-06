package com.facebook.appevents;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.integrity.RedactedEventsManager;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.Logger;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.N;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 -2\u00020\u0001:\u0002-.BQ\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\n\u0012\b\u0010\f\u001A\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F¢\u0006\u0002\u0010\u0010B\'\b\u0012\u0012\u0006\u0010\u0011\u001A\u00020\u0003\u0012\u0006\u0010\u0012\u001A\u00020\u0003\u0012\u0006\u0010\u0013\u001A\u00020\n\u0012\u0006\u0010\u0014\u001A\u00020\n¢\u0006\u0002\u0010\u0015J\u0006\u0010 \u001A\u00020\nJ\u0006\u0010!\u001A\u00020\u0018J;\u0010\"\u001A\u00020\u00182\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\b\u0010\u0005\u001A\u0004\u0018\u00010\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\b2\b\u0010\f\u001A\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010#J\u0006\u0010$\u001A\u00020\u0018J\u0010\u0010$\u001A\u0004\u0018\u00010\u00182\u0006\u0010%\u001A\u00020&J\b\u0010\'\u001A\u00020\u0003H\u0016J(\u0010(\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030)2\u0006\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010*\u001A\u00020\nH\u0002J\b\u0010+\u001A\u00020,H\u0002R\u000E\u0010\u0014\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0016R\u0011\u0010\u0017\u001A\u00020\u0018¢\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u0011\u0010\u001B\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001DR\u0011\u0010\u001E\u001A\u00020\u0018¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010\u001A¨\u0006/"}, d2 = {"Lcom/facebook/appevents/AppEvent;", "Ljava/io/Serializable;", "contextName", "", "eventName", "valueToSum", "", "parameters", "Landroid/os/Bundle;", "isImplicitlyLogged", "", "isInBackground", "currentSessionId", "Ljava/util/UUID;", "operationalParameters", "Lcom/facebook/appevents/OperationalData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;ZZLjava/util/UUID;Lcom/facebook/appevents/OperationalData;)V", "jsonString", "operationalJsonString", "isImplicit", "inBackground", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "()Z", "jsonObject", "Lorg/json/JSONObject;", "getJsonObject", "()Lorg/json/JSONObject;", "name", "getName", "()Ljava/lang/String;", "operationalJsonObject", "getOperationalJsonObject", "getIsImplicit", "getJSONObject", "getJSONObjectForAppEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;Ljava/util/UUID;)Lorg/json/JSONObject;", "getOperationalJSONObject", "type", "Lcom/facebook/appevents/OperationalDataEnum;", "toString", "validateParameters", "", "isOperational", "writeReplace", "", "Companion", "SerializationProxyV2", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AppEvent implements Serializable {
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001A\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000BR\u0014\u0010\r\u001A\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000ER$\u0010\u0011\u001A\u0012\u0012\u0004\u0012\u00020\u00040\u000Fj\b\u0012\u0004\u0012\u00020\u0004`\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/facebook/appevents/AppEvent$Companion;", "", "<init>", "()V", "", "identifier", "Lie/H;", "validateIdentifier", "(Ljava/lang/String;)V", "", "MAX_IDENTIFIER_LENGTH", "I", "", "serialVersionUID", "J", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "validatedIdentifiers", "Ljava/util/HashSet;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final void validateIdentifier(@NotNull String s) {
            q.g(s, "identifier");
            if(s.length() == 0 || s.length() > 40) {
                throw new FacebookException(String.format(Locale.ROOT, "Identifier \'%s\' must be less than %d characters", Arrays.copyOf(new Object[]{s, 40}, 2)));
            }
            synchronized(AppEvent.validatedIdentifiers) {
                boolean z = AppEvent.validatedIdentifiers.contains(s);
            }
            if(!z) {
                Pattern pattern0 = Pattern.compile("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$");
                q.f(pattern0, "compile(...)");
                if(!pattern0.matcher(s).matches()) {
                    throw new FacebookException(String.format("Skipping event named \'%s\' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", Arrays.copyOf(new Object[]{s}, 1)));
                }
                synchronized(AppEvent.validatedIdentifiers) {
                    AppEvent.validatedIdentifiers.add(s);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000B2\u00020\u0001:\u0001\u000BB%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0002\u0010\bJ\b\u0010\t\u001A\u00020\nH\u0002R\u000E\u0010\u0007\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/appevents/AppEvent$SerializationProxyV2;", "Ljava/io/Serializable;", "jsonString", "", "operationalJsonString", "isImplicit", "", "inBackground", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "readResolve", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class SerializationProxyV2 implements Serializable {
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/appevents/AppEvent$SerializationProxyV2$Companion;", "", "()V", "serialVersionUID", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static final class com.facebook.appevents.AppEvent.SerializationProxyV2.Companion {
            private com.facebook.appevents.AppEvent.SerializationProxyV2.Companion() {
            }

            public com.facebook.appevents.AppEvent.SerializationProxyV2.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        @NotNull
        public static final com.facebook.appevents.AppEvent.SerializationProxyV2.Companion Companion = null;
        private final boolean inBackground;
        private final boolean isImplicit;
        @NotNull
        private final String jsonString;
        @NotNull
        private final String operationalJsonString;
        private static final long serialVersionUID = 20160803001L;

        static {
            SerializationProxyV2.Companion = new com.facebook.appevents.AppEvent.SerializationProxyV2.Companion(null);
        }

        public SerializationProxyV2(@NotNull String s, @NotNull String s1, boolean z, boolean z1) {
            q.g(s, "jsonString");
            q.g(s1, "operationalJsonString");
            super();
            this.jsonString = s;
            this.operationalJsonString = s1;
            this.isImplicit = z;
            this.inBackground = z1;
        }

        private final Object readResolve() {
            return new AppEvent(this.jsonString, this.operationalJsonString, this.isImplicit, this.inBackground, null);
        }
    }

    @NotNull
    public static final Companion Companion = null;
    private static final int MAX_IDENTIFIER_LENGTH = 40;
    private final boolean inBackground;
    private final boolean isImplicit;
    @NotNull
    private final JSONObject jsonObject;
    @NotNull
    private final String name;
    @NotNull
    private final JSONObject operationalJsonObject;
    private static final long serialVersionUID = 1L;
    @NotNull
    private static final HashSet validatedIdentifiers;

    static {
        AppEvent.Companion = new Companion(null);
        AppEvent.validatedIdentifiers = new HashSet();
    }

    public AppEvent(@NotNull String s, @NotNull String s1, @Nullable Double double0, @Nullable Bundle bundle0, boolean z, boolean z1, @Nullable UUID uUID0, @Nullable OperationalData operationalData0) {
        q.g(s, "contextName");
        JSONObject jSONObject0;
        q.g(s1, "eventName");
        super();
        this.isImplicit = z;
        this.inBackground = z1;
        this.name = s1;
        if(operationalData0 == null) {
            jSONObject0 = new JSONObject();
        }
        else {
            jSONObject0 = operationalData0.toJSON();
            if(jSONObject0 == null) {
                jSONObject0 = new JSONObject();
            }
        }
        this.operationalJsonObject = jSONObject0;
        this.jsonObject = this.getJSONObjectForAppEvent(s, s1, double0, bundle0, uUID0);
    }

    public AppEvent(String s, String s1, Double double0, Bundle bundle0, boolean z, boolean z1, UUID uUID0, OperationalData operationalData0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        this(s, s1, double0, bundle0, z, z1, uUID0, ((v & 0x80) == 0 ? operationalData0 : null));
    }

    private AppEvent(String s, String s1, boolean z, boolean z1) {
        JSONObject jSONObject0 = new JSONObject(s);
        this.jsonObject = jSONObject0;
        this.operationalJsonObject = new JSONObject(s1);
        this.isImplicit = z;
        String s2 = jSONObject0.optString("_eventName");
        q.f(s2, "jsonObject.optString(Con…nts.EVENT_NAME_EVENT_KEY)");
        this.name = s2;
        this.inBackground = z1;
    }

    public AppEvent(String s, String s1, boolean z, boolean z1, DefaultConstructorMarker defaultConstructorMarker0) {
        this(s, s1, z, z1);
    }

    public final boolean getIsImplicit() {
        return this.isImplicit;
    }

    @NotNull
    public final JSONObject getJSONObject() {
        return this.jsonObject;
    }

    private final JSONObject getJSONObjectForAppEvent(String s, String s1, Double double0, Bundle bundle0, UUID uUID0) {
        AppEvent.Companion.validateIdentifier(s1);
        JSONObject jSONObject0 = new JSONObject();
        String s2 = RestrictiveDataManager.processEvent(s1);
        if(q.b(s2, s1)) {
            s2 = RedactedEventsManager.processEventsRedaction(s1);
        }
        jSONObject0.put("_eventName", s2);
        jSONObject0.put("_logTime", System.currentTimeMillis() / 1000L);
        jSONObject0.put("_ui", s);
        if(uUID0 != null) {
            jSONObject0.put("_session_id", uUID0);
        }
        if(bundle0 != null) {
            Map map0 = AppEvent.validateParameters$default(this, bundle0, false, 2, null);
            for(Object object0: map0.keySet()) {
                jSONObject0.put(((String)object0), map0.get(((String)object0)));
            }
        }
        if(double0 != null) {
            jSONObject0.put("_valueToSum", ((double)double0));
        }
        if(this.inBackground) {
            jSONObject0.put("_inBackground", "1");
        }
        if(this.isImplicit) {
            jSONObject0.put("_implicitlyLogged", "1");
            return jSONObject0;
        }
        String s3 = jSONObject0.toString();
        q.f(s3, "eventObject.toString()");
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Created app event \'%s\'", new Object[]{s3});
        return jSONObject0;
    }

    @NotNull
    public final JSONObject getJsonObject() {
        return this.jsonObject;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final JSONObject getOperationalJSONObject() {
        return this.operationalJsonObject;
    }

    @Nullable
    public final JSONObject getOperationalJSONObject(@NotNull OperationalDataEnum operationalDataEnum0) {
        q.g(operationalDataEnum0, "type");
        return this.operationalJsonObject.optJSONObject(operationalDataEnum0.getValue());
    }

    @NotNull
    public final JSONObject getOperationalJsonObject() {
        return this.operationalJsonObject;
    }

    public final boolean isImplicit() {
        return this.isImplicit;
    }

    @Override
    @NotNull
    public String toString() {
        return String.format("\"%s\", implicit: %b, json: %s", Arrays.copyOf(new Object[]{this.jsonObject.optString("_eventName"), Boolean.valueOf(this.isImplicit), this.jsonObject.toString()}, 3));
    }

    private final Map validateParameters(Bundle bundle0, boolean z) {
        Map map0 = new HashMap();
        for(Object object0: bundle0.keySet()) {
            String s = (String)object0;
            q.f(s, "key");
            AppEvent.Companion.validateIdentifier(s);
            Object object1 = bundle0.get(s);
            if(!(object1 instanceof String) && !(object1 instanceof Number)) {
                throw new FacebookException(String.format("Parameter value \'%s\' for key \'%s\' should be a string or a numeric type.", Arrays.copyOf(new Object[]{object1, s}, 2)));
            }
            map0.put(s, object1.toString());
        }
        if(!z) {
            IntegrityManager.processParameters(map0);
            RestrictiveDataManager.processParameters(N.c(map0), this.name);
            EventDeactivationManager.processDeprecatedParameters(N.c(map0), this.name);
        }
        return map0;
    }

    public static Map validateParameters$default(AppEvent appEvent0, Bundle bundle0, boolean z, int v, Object object0) {
        if((v & 2) != 0) {
            z = false;
        }
        return appEvent0.validateParameters(bundle0, z);
    }

    private final Object writeReplace() {
        String s = this.jsonObject.toString();
        q.f(s, "jsonObject.toString()");
        String s1 = this.operationalJsonObject.toString();
        q.f(s1, "operationalJsonObject.toString()");
        return new SerializationProxyV2(s, s1, this.isImplicit, this.inBackground);
    }
}

