package com.facebook.internal;

import com.facebook.FacebookRequestError.Category;
import ie.m;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import je.C;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u007F\b\u0000\u0012\u001C\u0010\u0002\u001A\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012\u001C\u0010\u0006\u001A\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012\u001C\u0010\u0007\u001A\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0005\u0018\u00010\u0003\u0012\b\u0010\b\u001A\u0004\u0018\u00010\t\u0012\b\u0010\n\u001A\u0004\u0018\u00010\t\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\t¢\u0006\u0002\u0010\fJ\u001E\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00042\u0006\u0010\u0014\u001A\u00020\u00042\u0006\u0010\u0015\u001A\u00020\u0016J\u0012\u0010\u0017\u001A\u0004\u0018\u00010\t2\b\u0010\u0018\u001A\u0004\u0018\u00010\u0012R\'\u0010\u0007\u001A\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0010\u0010\u000B\u001A\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\'\u0010\u0002\u001A\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000ER\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\'\u0010\u0006\u001A\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000ER\u0010\u0010\n\u001A\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2 = {"Lcom/facebook/internal/FacebookRequestErrorClassification;", "", "otherErrors", "", "", "", "transientErrors", "loginRecoverableErrors", "otherRecoveryMessage", "", "transientRecoveryMessage", "loginRecoverableRecoveryMessage", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLoginRecoverableErrors", "()Ljava/util/Map;", "getOtherErrors", "getTransientErrors", "classify", "Lcom/facebook/FacebookRequestError$Category;", "errorCode", "errorSubCode", "isTransient", "", "getRecoveryMessage", "category", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FacebookRequestErrorClassification {
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u001C\u001A\u0004\u0018\u00010\u00152\b\u0010\u001D\u001A\u0004\u0018\u00010\u001EH\u0007J&\u0010\u001F\u001A\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010!\u0018\u00010 2\u0006\u0010\"\u001A\u00020#H\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u000FX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u000FX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u000FX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u000FX\u0086T¢\u0006\u0002\n\u0000R\u001A\u0010\u0014\u001A\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0002\u001A\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001A\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u0018R\u0010\u0010\u001B\u001A\u0004\u0018\u00010\u0015X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/facebook/internal/FacebookRequestErrorClassification$Companion;", "", "()V", "EC_APP_NOT_INSTALLED", "", "EC_APP_TOO_MANY_CALLS", "EC_INVALID_SESSION", "EC_INVALID_TOKEN", "EC_RATE", "EC_SERVICE_UNAVAILABLE", "EC_TOO_MANY_USER_ACTION_CALLS", "EC_USER_TOO_MANY_CALLS", "ESC_APP_INACTIVE", "ESC_APP_NOT_INSTALLED", "KEY_LOGIN_RECOVERABLE", "", "KEY_NAME", "KEY_OTHER", "KEY_RECOVERY_MESSAGE", "KEY_TRANSIENT", "defaultErrorClassification", "Lcom/facebook/internal/FacebookRequestErrorClassification;", "getDefaultErrorClassification$annotations", "getDefaultErrorClassification", "()Lcom/facebook/internal/FacebookRequestErrorClassification;", "defaultErrorClassificationImpl", "getDefaultErrorClassificationImpl", "defaultInstance", "createFromJSON", "jsonArray", "Lorg/json/JSONArray;", "parseJSONDefinition", "", "", "definition", "Lorg/json/JSONObject;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @Nullable
        public final FacebookRequestErrorClassification createFromJSON(@Nullable JSONArray jSONArray0) {
            if(jSONArray0 == null) {
                return null;
            }
            int v = jSONArray0.length();
            Map map0 = null;
            Map map1 = null;
            Map map2 = null;
            String s = null;
            String s1 = null;
            String s2 = null;
            for(int v1 = 0; v1 < v; ++v1) {
                JSONObject jSONObject0 = jSONArray0.optJSONObject(v1);
                if(jSONObject0 != null) {
                    String s3 = jSONObject0.optString("name");
                    if(s3 != null) {
                        if(s3.equalsIgnoreCase("other")) {
                            s = jSONObject0.optString("recovery_message", null);
                            map0 = this.parseJSONDefinition(jSONObject0);
                        }
                        else if(s3.equalsIgnoreCase("transient")) {
                            s1 = jSONObject0.optString("recovery_message", null);
                            map1 = this.parseJSONDefinition(jSONObject0);
                        }
                        else if(s3.equalsIgnoreCase("login_recoverable")) {
                            s2 = jSONObject0.optString("recovery_message", null);
                            map2 = this.parseJSONDefinition(jSONObject0);
                        }
                    }
                }
            }
            return new FacebookRequestErrorClassification(map0, map1, map2, s, s1, s2);
        }

        @NotNull
        public final FacebookRequestErrorClassification getDefaultErrorClassification() {
            synchronized(this) {
                if(FacebookRequestErrorClassification.defaultInstance == null) {
                    FacebookRequestErrorClassification.defaultInstance = this.getDefaultErrorClassificationImpl();
                }
                FacebookRequestErrorClassification facebookRequestErrorClassification0 = FacebookRequestErrorClassification.defaultInstance;
                q.e(facebookRequestErrorClassification0, "null cannot be cast to non-null type com.facebook.internal.FacebookRequestErrorClassification");
                return facebookRequestErrorClassification0;
            }
        }

        public static void getDefaultErrorClassification$annotations() {
        }

        private final FacebookRequestErrorClassification getDefaultErrorClassificationImpl() {
            return new FacebookRequestErrorClassification(null, C.R(new m[]{new m(2, null), new m(4, null), new m(9, null), new m(17, null), new m(341, null)}), C.R(new m[]{new m(102, null), new m(190, null), new m(412, null)}), null, null, null);
        }

        private final Map parseJSONDefinition(JSONObject jSONObject0) {
            HashSet hashSet0;
            JSONArray jSONArray0 = jSONObject0.optJSONArray("items");
            if(jSONArray0 != null && jSONArray0.length() != 0) {
                Map map0 = new HashMap();
                int v = jSONArray0.length();
                for(int v1 = 0; v1 < v; ++v1) {
                    JSONObject jSONObject1 = jSONArray0.optJSONObject(v1);
                    if(jSONObject1 != null) {
                        int v2 = jSONObject1.optInt("code");
                        if(v2 != 0) {
                            JSONArray jSONArray1 = jSONObject1.optJSONArray("subcodes");
                            if(jSONArray1 == null || jSONArray1.length() <= 0) {
                                hashSet0 = null;
                            }
                            else {
                                hashSet0 = new HashSet();
                                int v3 = jSONArray1.length();
                                for(int v4 = 0; v4 < v3; ++v4) {
                                    int v5 = jSONArray1.optInt(v4);
                                    if(v5 != 0) {
                                        hashSet0.add(v5);
                                    }
                                }
                            }
                            map0.put(v2, hashSet0);
                        }
                    }
                }
                return map0;
            }
            return null;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 0x30)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[Category.values().length];
            try {
                arr_v[Category.OTHER.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Category.LOGIN_RECOVERABLE.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Category.TRANSIENT.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    @NotNull
    public static final Companion Companion = null;
    public static final int EC_APP_NOT_INSTALLED = 412;
    public static final int EC_APP_TOO_MANY_CALLS = 4;
    public static final int EC_INVALID_SESSION = 102;
    public static final int EC_INVALID_TOKEN = 190;
    public static final int EC_RATE = 9;
    public static final int EC_SERVICE_UNAVAILABLE = 2;
    public static final int EC_TOO_MANY_USER_ACTION_CALLS = 341;
    public static final int EC_USER_TOO_MANY_CALLS = 17;
    public static final int ESC_APP_INACTIVE = 493;
    public static final int ESC_APP_NOT_INSTALLED = 458;
    @NotNull
    public static final String KEY_LOGIN_RECOVERABLE = "login_recoverable";
    @NotNull
    public static final String KEY_NAME = "name";
    @NotNull
    public static final String KEY_OTHER = "other";
    @NotNull
    public static final String KEY_RECOVERY_MESSAGE = "recovery_message";
    @NotNull
    public static final String KEY_TRANSIENT = "transient";
    @Nullable
    private static FacebookRequestErrorClassification defaultInstance;
    @Nullable
    private final Map loginRecoverableErrors;
    @Nullable
    private final String loginRecoverableRecoveryMessage;
    @Nullable
    private final Map otherErrors;
    @Nullable
    private final String otherRecoveryMessage;
    @Nullable
    private final Map transientErrors;
    @Nullable
    private final String transientRecoveryMessage;

    static {
        FacebookRequestErrorClassification.Companion = new Companion(null);
    }

    public FacebookRequestErrorClassification(@Nullable Map map0, @Nullable Map map1, @Nullable Map map2, @Nullable String s, @Nullable String s1, @Nullable String s2) {
        this.otherErrors = map0;
        this.transientErrors = map1;
        this.loginRecoverableErrors = map2;
        this.otherRecoveryMessage = s;
        this.transientRecoveryMessage = s1;
        this.loginRecoverableRecoveryMessage = s2;
    }

    @NotNull
    public final Category classify(int v, int v1, boolean z) {
        if(z) {
            return Category.TRANSIENT;
        }
        if(this.otherErrors != null && this.otherErrors.containsKey(v)) {
            Set set0 = (Set)this.otherErrors.get(v);
            if(set0 == null || set0.contains(v1)) {
                return Category.OTHER;
            }
        }
        if(this.loginRecoverableErrors != null && this.loginRecoverableErrors.containsKey(v)) {
            Set set1 = (Set)this.loginRecoverableErrors.get(v);
            if(set1 == null || set1.contains(v1)) {
                return Category.LOGIN_RECOVERABLE;
            }
        }
        if(this.transientErrors != null && this.transientErrors.containsKey(v)) {
            Set set2 = (Set)this.transientErrors.get(v);
            return set2 != null && !set2.contains(v1) ? Category.OTHER : Category.TRANSIENT;
        }
        return Category.OTHER;
    }

    @Nullable
    public static final FacebookRequestErrorClassification createFromJSON(@Nullable JSONArray jSONArray0) {
        return FacebookRequestErrorClassification.Companion.createFromJSON(jSONArray0);
    }

    @NotNull
    public static final FacebookRequestErrorClassification getDefaultErrorClassification() {
        synchronized(FacebookRequestErrorClassification.class) {
            return FacebookRequestErrorClassification.Companion.getDefaultErrorClassification();
        }
    }

    @Nullable
    public final Map getLoginRecoverableErrors() {
        return this.loginRecoverableErrors;
    }

    @Nullable
    public final Map getOtherErrors() {
        return this.otherErrors;
    }

    @Nullable
    public final String getRecoveryMessage(@Nullable Category facebookRequestError$Category0) {
        switch((facebookRequestError$Category0 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[facebookRequestError$Category0.ordinal()])) {
            case 1: {
                return this.otherRecoveryMessage;
            }
            case 2: {
                return this.loginRecoverableRecoveryMessage;
            }
            case 3: {
                return this.transientRecoveryMessage;
            }
            default: {
                return null;
            }
        }
    }

    @Nullable
    public final Map getTransientErrors() {
        return this.transientErrors;
    }
}

