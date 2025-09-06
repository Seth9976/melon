package com.kakao.sdk.auth;

import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.util.AESCipher;
import com.kakao.sdk.common.util.Cipher;
import com.kakao.sdk.common.util.KakaoJson;
import com.kakao.sdk.common.util.PersistentKVStore.DefaultImpls;
import com.kakao.sdk.common.util.PersistentKVStore;
import com.kakao.sdk.common.util.SdkLog;
import com.kakao.sdk.common.util.SharedPrefsWrapper;
import d3.g;
import ie.j;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u001A2\u00020\u0001:\u0001\u001AB\u001B\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000F\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0011\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\nR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001A\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001A\u0004\u0018\u00010\u000B8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001B"}, d2 = {"Lcom/kakao/sdk/auth/TokenManager;", "Lcom/kakao/sdk/auth/TokenManageable;", "Lcom/kakao/sdk/common/util/PersistentKVStore;", "appCache", "Lcom/kakao/sdk/common/util/Cipher;", "encryptor", "<init>", "(Lcom/kakao/sdk/common/util/PersistentKVStore;Lcom/kakao/sdk/common/util/Cipher;)V", "Lie/H;", "migrateFromOldVersion", "()V", "Lcom/kakao/sdk/auth/model/OAuthToken;", "getToken", "()Lcom/kakao/sdk/auth/model/OAuthToken;", "token", "setToken", "(Lcom/kakao/sdk/auth/model/OAuthToken;)V", "clear", "Lcom/kakao/sdk/common/util/PersistentKVStore;", "getAppCache", "()Lcom/kakao/sdk/common/util/PersistentKVStore;", "Lcom/kakao/sdk/common/util/Cipher;", "getEncryptor", "()Lcom/kakao/sdk/common/util/Cipher;", "currentToken", "Lcom/kakao/sdk/auth/model/OAuthToken;", "Companion", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class TokenManager implements TokenManageable {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R!\u0010\n\u001A\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001A\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001A\u00020\u000B8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000E\u001A\u00020\u000B8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000E\u0010\rR\u0014\u0010\u000F\u001A\u00020\u000B8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000F\u0010\rR\u0014\u0010\u0010\u001A\u00020\u000B8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001A\u00020\u000B8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001A\u00020\u000B8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0014\u0010\u0013\u001A\u00020\u000B8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/kakao/sdk/auth/TokenManager$Companion;", "", "<init>", "()V", "Lcom/kakao/sdk/auth/TokenManager;", "instance$delegate", "Lie/j;", "getInstance", "()Lcom/kakao/sdk/auth/TokenManager;", "getInstance$annotations", "instance", "", "atExpiresAtKey", "Ljava/lang/String;", "atKey", "rtExpiresAtKey", "rtKey", "secureModeKey", "tokenKey", "versionKey", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final TokenManager getInstance() {
            return (TokenManager)TokenManager.instance$delegate.getValue();
        }

        public static void getInstance$annotations() {
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private final PersistentKVStore appCache;
    @NotNull
    public static final String atExpiresAtKey = "com.kakao.token.OAuthToken.ExpiresAt";
    @NotNull
    public static final String atKey = "com.kakao.token.AccessToken";
    @Nullable
    private OAuthToken currentToken;
    @NotNull
    private final Cipher encryptor;
    @NotNull
    private static final j instance$delegate = null;
    @NotNull
    public static final String rtExpiresAtKey = "com.kakao.token.RefreshToken.ExpiresAt";
    @NotNull
    public static final String rtKey = "com.kakao.token.RefreshToken";
    @NotNull
    public static final String secureModeKey = "com.kakao.token.KakaoSecureMode";
    @NotNull
    public static final String tokenKey = "com.kakao.sdk.oauth_token";
    @NotNull
    public static final String versionKey = "com.kakao.sdk.version";

    static {
        TokenManager.Companion = new Companion(null);
        TokenManager.instance$delegate = g.Q(TokenManager.Companion.instance.2.INSTANCE);
    }

    public TokenManager() {
        this(null, null, 3, null);
    }

    public TokenManager(@NotNull PersistentKVStore persistentKVStore0, @NotNull Cipher cipher0) {
        q.g(persistentKVStore0, "appCache");
        q.g(cipher0, "encryptor");
        super();
        this.appCache = persistentKVStore0;
        this.encryptor = cipher0;
        OAuthToken oAuthToken0 = null;
        if(DefaultImpls.getString$default(persistentKVStore0, "com.kakao.sdk.version", null, 2, null) == null) {
            this.migrateFromOldVersion();
        }
        String s = DefaultImpls.getString$default(persistentKVStore0, "com.kakao.sdk.oauth_token", null, 2, null);
        if(s != null) {
            try {
                String s1 = cipher0.decrypt(s);
                Json json0 = KakaoJson.INSTANCE.getJson();
                json0.getSerializersModule();
                oAuthToken0 = (OAuthToken)json0.decodeFromString(OAuthToken.Companion.serializer(), s1);
            }
            catch(Throwable throwable0) {
                SdkLog.Companion.e(throwable0);
            }
        }
        this.currentToken = oAuthToken0;
    }

    public TokenManager(PersistentKVStore persistentKVStore0, Cipher cipher0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            persistentKVStore0 = new SharedPrefsWrapper(KakaoSdk.INSTANCE.getApplicationContextInfo().getSharedPreferences());
        }
        if((v & 2) != 0) {
            cipher0 = new AESCipher(null, 1, null);
        }
        this(persistentKVStore0, cipher0);
    }

    @Override  // com.kakao.sdk.auth.TokenManageable
    public void clear() {
        this.currentToken = null;
        this.appCache.remove("com.kakao.sdk.oauth_token").commit();
    }

    @NotNull
    public final PersistentKVStore getAppCache() {
        return this.appCache;
    }

    @NotNull
    public final Cipher getEncryptor() {
        return this.encryptor;
    }

    @NotNull
    public static final TokenManager getInstance() {
        return TokenManager.Companion.getInstance();
    }

    @Override  // com.kakao.sdk.auth.TokenManageable
    @Nullable
    public OAuthToken getToken() {
        return this.currentToken;
    }

    private final void migrateFromOldVersion() {
        Long long1;
        String s7;
        String s6;
        String s4;
        String s3;
        String s1;
        com.kakao.sdk.common.util.SdkLog.Companion sdkLog$Companion0 = SdkLog.Companion;
        sdkLog$Companion0.i("=== Migrate from old version token");
        this.appCache.putString("com.kakao.sdk.version", "2.21.4").commit();
        Long long0 = null;
        String s = this.appCache.getString("com.kakao.token.KakaoSecureMode", null);
        if(s == null) {
            s1 = "false";
        }
        else {
            Json json0 = KakaoJson.INSTANCE.getJson();
            json0.getSerializersModule();
            JsonElement jsonElement0 = (JsonElement)((JsonObject)json0.decodeFromString(JsonObject.Companion.serializer(), s)).get("value");
            if(jsonElement0 == null) {
                s1 = null;
            }
            else {
                JsonPrimitive jsonPrimitive0 = JsonElementKt.getJsonPrimitive(jsonElement0);
                s1 = jsonPrimitive0 == null ? null : jsonPrimitive0.getContent();
            }
            if(s1 == null) {
                s1 = "false";
            }
        }
        sdkLog$Companion0.i("secureMode: " + s1);
        try {
            String s2 = this.appCache.getString("com.kakao.token.AccessToken", null);
            if(s2 == null) {
                s3 = null;
            }
            else {
                Json json1 = KakaoJson.INSTANCE.getJson();
                json1.getSerializersModule();
                JsonElement jsonElement1 = (JsonElement)((JsonObject)json1.decodeFromString(JsonObject.Companion.serializer(), s2)).get("value");
                if(jsonElement1 == null) {
                    s3 = null;
                }
                else {
                    JsonPrimitive jsonPrimitive1 = JsonElementKt.getJsonPrimitive(jsonElement1);
                    s3 = jsonPrimitive1 == null ? null : jsonPrimitive1.getContent();
                }
                if(s3 != null && s1.equals("true")) {
                    s3 = this.encryptor.decrypt(s3);
                }
            }
            s4 = s3;
        }
        catch(Exception exception0) {
            SdkLog.Companion.e(exception0);
            s4 = null;
        }
        SdkLog.Companion.i("accessToken: " + s4);
        try {
            String s5 = this.appCache.getString("com.kakao.token.RefreshToken", null);
            if(s5 == null) {
                s6 = null;
            }
            else {
                Json json2 = KakaoJson.INSTANCE.getJson();
                json2.getSerializersModule();
                JsonElement jsonElement2 = (JsonElement)((JsonObject)json2.decodeFromString(JsonObject.Companion.serializer(), s5)).get("value");
                if(jsonElement2 == null) {
                    s6 = null;
                }
                else {
                    JsonPrimitive jsonPrimitive2 = JsonElementKt.getJsonPrimitive(jsonElement2);
                    s6 = jsonPrimitive2 == null ? null : jsonPrimitive2.getContent();
                }
                if(s6 != null && s1.equals("true")) {
                    s6 = this.encryptor.decrypt(s6);
                }
            }
            s7 = s6;
        }
        catch(Exception exception1) {
            SdkLog.Companion.e(exception1);
            s7 = null;
        }
        SdkLog.Companion.i("refreshToken: " + s7);
        try {
            String s8 = this.appCache.getString("com.kakao.token.OAuthToken.ExpiresAt", null);
            if(s8 == null) {
                goto label_86;
            }
            else {
                Json json3 = KakaoJson.INSTANCE.getJson();
                json3.getSerializersModule();
                JsonElement jsonElement3 = (JsonElement)((JsonObject)json3.decodeFromString(JsonObject.Companion.serializer(), s8)).get("value");
                if(jsonElement3 == null) {
                    long1 = null;
                }
                else {
                    JsonPrimitive jsonPrimitive3 = JsonElementKt.getJsonPrimitive(jsonElement3);
                    long1 = jsonPrimitive3 == null ? null : JsonElementKt.getLong(jsonPrimitive3);
                }
            }
        }
        catch(Exception exception2) {
            SdkLog.Companion.e(exception2);
            long1 = null;
        }
        goto label_87;
    label_86:
        long1 = null;
    label_87:
        long v = long1 == null ? 0L : ((long)long1);
        try {
            String s9 = this.appCache.getString("com.kakao.token.RefreshToken.ExpiresAt", null);
            if(s9 != null) {
                Json json4 = KakaoJson.INSTANCE.getJson();
                json4.getSerializersModule();
                JsonElement jsonElement4 = (JsonElement)((JsonObject)json4.decodeFromString(JsonObject.Companion.serializer(), s9)).get("value");
                if(jsonElement4 != null) {
                    JsonPrimitive jsonPrimitive4 = JsonElementKt.getJsonPrimitive(jsonElement4);
                    if(jsonPrimitive4 != null) {
                        long0 = JsonElementKt.getLong(jsonPrimitive4);
                    }
                }
            }
        }
        catch(Exception exception3) {
            SdkLog.Companion.e(exception3);
        }
        long v1 = long0 == null ? 0x7FFFFFFFFFFFFFFFL : ((long)long0);
        if(s4 != null && s7 != null) {
            OAuthToken oAuthToken0 = new OAuthToken(s4, new Date(v), s7, new Date(v1), null, null, 0x30, null);
            Json json5 = KakaoJson.INSTANCE.getJson();
            json5.getSerializersModule();
            String s10 = json5.encodeToString(OAuthToken.Companion.serializer(), oAuthToken0);
            String s11 = this.encryptor.encrypt(s10);
            this.appCache.putString("com.kakao.sdk.oauth_token", s11).remove("com.kakao.token.KakaoSecureMode").remove("com.kakao.token.AccessToken").remove("com.kakao.token.RefreshToken").remove("com.kakao.token.OAuthToken.ExpiresAt").remove("com.kakao.token.RefreshToken.ExpiresAt").commit();
        }
    }

    @Override  // com.kakao.sdk.auth.TokenManageable
    public void setToken(@NotNull OAuthToken oAuthToken0) {
        synchronized(this) {
            q.g(oAuthToken0, "token");
            OAuthToken oAuthToken1 = OAuthToken.copy$default(oAuthToken0, null, null, null, null, null, null, 0x3F, null);
            try {
                Json json0 = KakaoJson.INSTANCE.getJson();
                json0.getSerializersModule();
                String s = json0.encodeToString(OAuthToken.Companion.serializer(), oAuthToken1);
                String s1 = this.encryptor.encrypt(s);
                this.appCache.putString("com.kakao.sdk.oauth_token", s1).commit();
            }
            catch(Throwable throwable0) {
                SdkLog.Companion.e(throwable0);
            }
            this.currentToken = oAuthToken1;
        }
    }
}

