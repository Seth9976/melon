package com.facebook.internal;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\f\u001A\u00020\u000B2\u0006\u0010\t\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\u0006H\u0007¢\u0006\u0004\b\f\u0010\rR \u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/facebook/internal/ProfileInformationCache;", "", "<init>", "()V", "", "accessToken", "Lorg/json/JSONObject;", "getProfileInformation", "(Ljava/lang/String;)Lorg/json/JSONObject;", "key", "value", "Lie/H;", "putProfileInformation", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "Ljava/util/concurrent/ConcurrentHashMap;", "infoCache", "Ljava/util/concurrent/ConcurrentHashMap;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ProfileInformationCache {
    @NotNull
    public static final ProfileInformationCache INSTANCE;
    @NotNull
    private static final ConcurrentHashMap infoCache;

    static {
        ProfileInformationCache.INSTANCE = new ProfileInformationCache();
        ProfileInformationCache.infoCache = new ConcurrentHashMap();
    }

    @Nullable
    public static final JSONObject getProfileInformation(@NotNull String s) {
        q.g(s, "accessToken");
        return (JSONObject)ProfileInformationCache.infoCache.get(s);
    }

    public static final void putProfileInformation(@NotNull String s, @NotNull JSONObject jSONObject0) {
        q.g(s, "key");
        q.g(jSONObject0, "value");
        ProfileInformationCache.infoCache.put(s, jSONObject0);
    }
}

