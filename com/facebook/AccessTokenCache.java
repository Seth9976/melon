package com.facebook;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\f\u001A\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000BJ\u000F\u0010\u000E\u001A\u0004\u0018\u00010\r¢\u0006\u0004\b\u000E\u0010\u000FJ\u0015\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001A\u00020\u0011¢\u0006\u0004\b\u0014\u0010\bR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0018\u0010\u0018\u001A\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001C\u001A\u00020\u00178CX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u001BR\u0016\u0010\u001E\u001A\u0004\u0018\u00010\r8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u000FR\u0016\u0010 \u001A\u0004\u0018\u00010\r8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010\u000F¨\u0006#"}, d2 = {"Lcom/facebook/AccessTokenCache;", "", "Landroid/content/SharedPreferences;", "sharedPreferences", "Lcom/facebook/AccessTokenCache$SharedPreferencesTokenCachingStrategyFactory;", "tokenCachingStrategyFactory", "<init>", "(Landroid/content/SharedPreferences;Lcom/facebook/AccessTokenCache$SharedPreferencesTokenCachingStrategyFactory;)V", "()V", "", "hasCachedAccessToken", "()Z", "shouldCheckLegacyToken", "Lcom/facebook/AccessToken;", "load", "()Lcom/facebook/AccessToken;", "accessToken", "Lie/H;", "save", "(Lcom/facebook/AccessToken;)V", "clear", "Landroid/content/SharedPreferences;", "Lcom/facebook/AccessTokenCache$SharedPreferencesTokenCachingStrategyFactory;", "Lcom/facebook/LegacyTokenHelper;", "tokenCachingStrategyField", "Lcom/facebook/LegacyTokenHelper;", "getTokenCachingStrategy", "()Lcom/facebook/LegacyTokenHelper;", "tokenCachingStrategy", "getCachedAccessToken", "cachedAccessToken", "getLegacyAccessToken", "legacyAccessToken", "Companion", "SharedPreferencesTokenCachingStrategyFactory", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AccessTokenCache {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/AccessTokenCache$Companion;", "", "()V", "CACHED_ACCESS_TOKEN_KEY", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001A\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/AccessTokenCache$SharedPreferencesTokenCachingStrategyFactory;", "", "()V", "create", "Lcom/facebook/LegacyTokenHelper;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class SharedPreferencesTokenCachingStrategyFactory {
        @NotNull
        public final LegacyTokenHelper create() {
            return new LegacyTokenHelper(FacebookSdk.getApplicationContext(), null, 2, null);
        }
    }

    @NotNull
    public static final String CACHED_ACCESS_TOKEN_KEY = "com.facebook.AccessTokenManager.CachedAccessToken";
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final SharedPreferences sharedPreferences;
    @NotNull
    private final SharedPreferencesTokenCachingStrategyFactory tokenCachingStrategyFactory;
    @Nullable
    private LegacyTokenHelper tokenCachingStrategyField;

    static {
        AccessTokenCache.Companion = new Companion(null);
    }

    public AccessTokenCache() {
        SharedPreferences sharedPreferences0 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);
        q.f(sharedPreferences0, "getApplicationContext()\n…ME, Context.MODE_PRIVATE)");
        this(sharedPreferences0, new SharedPreferencesTokenCachingStrategyFactory());
    }

    public AccessTokenCache(@NotNull SharedPreferences sharedPreferences0, @NotNull SharedPreferencesTokenCachingStrategyFactory accessTokenCache$SharedPreferencesTokenCachingStrategyFactory0) {
        q.g(sharedPreferences0, "sharedPreferences");
        q.g(accessTokenCache$SharedPreferencesTokenCachingStrategyFactory0, "tokenCachingStrategyFactory");
        super();
        this.sharedPreferences = sharedPreferences0;
        this.tokenCachingStrategyFactory = accessTokenCache$SharedPreferencesTokenCachingStrategyFactory0;
    }

    public final void clear() {
        this.sharedPreferences.edit().remove("com.facebook.AccessTokenManager.CachedAccessToken").apply();
        if(this.shouldCheckLegacyToken()) {
            this.getTokenCachingStrategy().clear();
        }
    }

    private final AccessToken getCachedAccessToken() {
        String s = this.sharedPreferences.getString("com.facebook.AccessTokenManager.CachedAccessToken", null);
        if(s != null) {
            try {
                JSONObject jSONObject0 = new JSONObject(s);
                return AccessToken.Companion.createFromJSONObject$facebook_core_release(jSONObject0);
            }
            catch(JSONException unused_ex) {
            }
        }
        return null;
    }

    private final AccessToken getLegacyAccessToken() {
        Bundle bundle0 = this.getTokenCachingStrategy().load();
        return bundle0 == null || !LegacyTokenHelper.Companion.hasTokenInformation(bundle0) ? null : AccessToken.Companion.createFromLegacyCache$facebook_core_release(bundle0);
    }

    private final LegacyTokenHelper getTokenCachingStrategy() {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            if(this.tokenCachingStrategyField == null) {
                synchronized(this) {
                    if(this.tokenCachingStrategyField == null) {
                        this.tokenCachingStrategyField = this.tokenCachingStrategyFactory.create();
                    }
                }
            }
            LegacyTokenHelper legacyTokenHelper0 = this.tokenCachingStrategyField;
            if(legacyTokenHelper0 == null) {
                throw new IllegalStateException("Required value was null.");
            }
            return legacyTokenHelper0;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return null;
    }

    private final boolean hasCachedAccessToken() {
        return this.sharedPreferences.contains("com.facebook.AccessTokenManager.CachedAccessToken");
    }

    @Nullable
    public final AccessToken load() {
        if(this.hasCachedAccessToken()) {
            return this.getCachedAccessToken();
        }
        if(this.shouldCheckLegacyToken()) {
            AccessToken accessToken0 = this.getLegacyAccessToken();
            if(accessToken0 != null) {
                this.save(accessToken0);
                this.getTokenCachingStrategy().clear();
            }
            return accessToken0;
        }
        return null;
    }

    public final void save(@NotNull AccessToken accessToken0) {
        q.g(accessToken0, "accessToken");
        try {
            JSONObject jSONObject0 = accessToken0.toJSONObject$facebook_core_release();
            this.sharedPreferences.edit().putString("com.facebook.AccessTokenManager.CachedAccessToken", jSONObject0.toString()).apply();
        }
        catch(JSONException unused_ex) {
        }
    }

    private final boolean shouldCheckLegacyToken() {
        return FacebookSdk.isLegacyTokenUpgradeSupported();
    }
}

