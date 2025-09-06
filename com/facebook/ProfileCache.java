package com.facebook;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000F2\u00020\u0001:\u0001\u000FB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000B\u001A\u00020\b¢\u0006\u0004\b\u000B\u0010\u0003R\u0014\u0010\r\u001A\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000E¨\u0006\u0010"}, d2 = {"Lcom/facebook/ProfileCache;", "", "<init>", "()V", "Lcom/facebook/Profile;", "load", "()Lcom/facebook/Profile;", "profile", "Lie/H;", "save", "(Lcom/facebook/Profile;)V", "clear", "Landroid/content/SharedPreferences;", "sharedPreferences", "Landroid/content/SharedPreferences;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ProfileCache {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/ProfileCache$Companion;", "", "()V", "CACHED_PROFILE_KEY", "", "SHARED_PREFERENCES_NAME", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final String CACHED_PROFILE_KEY = "com.facebook.ProfileManager.CachedProfile";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String SHARED_PREFERENCES_NAME = "com.facebook.AccessTokenManager.SharedPreferences";
    @NotNull
    private final SharedPreferences sharedPreferences;

    static {
        ProfileCache.Companion = new Companion(null);
    }

    public ProfileCache() {
        SharedPreferences sharedPreferences0 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);
        q.f(sharedPreferences0, "getApplicationContext()\n…ME, Context.MODE_PRIVATE)");
        this.sharedPreferences = sharedPreferences0;
    }

    public final void clear() {
        this.sharedPreferences.edit().remove("com.facebook.ProfileManager.CachedProfile").apply();
    }

    @Nullable
    public final Profile load() {
        String s = this.sharedPreferences.getString("com.facebook.ProfileManager.CachedProfile", null);
        if(s != null) {
            try {
                return new Profile(new JSONObject(s));
            }
            catch(JSONException unused_ex) {
            }
        }
        return null;
    }

    public final void save(@NotNull Profile profile0) {
        q.g(profile0, "profile");
        JSONObject jSONObject0 = profile0.toJSONObject();
        if(jSONObject0 != null) {
            this.sharedPreferences.edit().putString("com.facebook.ProfileManager.CachedProfile", jSONObject0.toString()).apply();
        }
    }
}

