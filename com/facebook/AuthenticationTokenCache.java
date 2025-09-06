package com.facebook;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u0004\u0018\u00010\n¢\u0006\u0004\b\u000B\u0010\fJ\u0015\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\n¢\u0006\u0004\b\u000F\u0010\u0010J\r\u0010\u0011\u001A\u00020\u000E¢\u0006\u0004\b\u0011\u0010\u0006R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0016\u0010\u0014\u001A\u0004\u0018\u00010\n8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/facebook/AuthenticationTokenCache;", "", "Landroid/content/SharedPreferences;", "sharedPreferences", "<init>", "(Landroid/content/SharedPreferences;)V", "()V", "", "hasCachedAuthenticationToken", "()Z", "Lcom/facebook/AuthenticationToken;", "load", "()Lcom/facebook/AuthenticationToken;", "authenticationToken", "Lie/H;", "save", "(Lcom/facebook/AuthenticationToken;)V", "clear", "Landroid/content/SharedPreferences;", "getCachedAuthenticationToken", "cachedAuthenticationToken", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AuthenticationTokenCache {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/AuthenticationTokenCache$Companion;", "", "()V", "CACHED_AUTHENTICATION_TOKEN_KEY", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final String CACHED_AUTHENTICATION_TOKEN_KEY = "com.facebook.AuthenticationManager.CachedAuthenticationToken";
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final SharedPreferences sharedPreferences;

    static {
        AuthenticationTokenCache.Companion = new Companion(null);
    }

    public AuthenticationTokenCache() {
        SharedPreferences sharedPreferences0 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.AuthenticationTokenManager.SharedPreferences", 0);
        q.f(sharedPreferences0, "getApplicationContext()\n…ME, Context.MODE_PRIVATE)");
        this(sharedPreferences0);
    }

    public AuthenticationTokenCache(@NotNull SharedPreferences sharedPreferences0) {
        q.g(sharedPreferences0, "sharedPreferences");
        super();
        this.sharedPreferences = sharedPreferences0;
    }

    public final void clear() {
        this.sharedPreferences.edit().remove("com.facebook.AuthenticationManager.CachedAuthenticationToken").apply();
    }

    private final AuthenticationToken getCachedAuthenticationToken() {
        String s = this.sharedPreferences.getString("com.facebook.AuthenticationManager.CachedAuthenticationToken", null);
        if(s != null) {
            try {
                return new AuthenticationToken(new JSONObject(s));
            }
            catch(JSONException unused_ex) {
            }
        }
        return null;
    }

    private final boolean hasCachedAuthenticationToken() {
        return this.sharedPreferences.contains("com.facebook.AuthenticationManager.CachedAuthenticationToken");
    }

    // 去混淆评级： 低(20)
    @Nullable
    public final AuthenticationToken load() {
        return this.hasCachedAuthenticationToken() ? this.getCachedAuthenticationToken() : null;
    }

    public final void save(@NotNull AuthenticationToken authenticationToken0) {
        q.g(authenticationToken0, "authenticationToken");
        try {
            JSONObject jSONObject0 = authenticationToken0.toJSONObject$facebook_core_release();
            this.sharedPreferences.edit().putString("com.facebook.AuthenticationManager.CachedAuthenticationToken", jSONObject0.toString()).apply();
        }
        catch(JSONException unused_ex) {
        }
    }
}

