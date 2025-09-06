package com.facebook;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001C2\u00020\u0001:\u0001\u001CB\u001D\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\'\u0010\u000E\u001A\u00020\r2\u0006\u0010\b\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\u000E\u0010\u000FJ\u001F\u0010\u0010\u001A\u00020\r2\u0006\u0010\b\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0012\u001A\u0004\u0018\u00010\t¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001A\u00020\r2\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001A\u00020\r¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0014\u0010\u001A\u001A\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001A\u0010\u001B¨\u0006\u001D"}, d2 = {"Lcom/facebook/LegacyTokenHelper;", "", "Landroid/content/Context;", "context", "", "cacheKey", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "key", "Landroid/os/Bundle;", "bundle", "Landroid/content/SharedPreferences$Editor;", "editor", "Lie/H;", "serializeKey", "(Ljava/lang/String;Landroid/os/Bundle;Landroid/content/SharedPreferences$Editor;)V", "deserializeKey", "(Ljava/lang/String;Landroid/os/Bundle;)V", "load", "()Landroid/os/Bundle;", "save", "(Landroid/os/Bundle;)V", "clear", "()V", "Ljava/lang/String;", "Landroid/content/SharedPreferences;", "cache", "Landroid/content/SharedPreferences;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class LegacyTokenHelper {
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u001E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b0\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J%\u0010\t\u001A\u0004\u0018\u00010\b2\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0002\u00A2\u0006\u0004\b\t\u0010\nJ)\u0010\r\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u000B\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0019\u0010\u0010\u001A\u00020\u000F2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u001F\u0010\u0015\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0014\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001A\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u001F\u0010\u0019\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0014\u001A\u00020\bH\u0007\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0017\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u001F\u0010\u001E\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0014\u001A\u00020\u001BH\u0007\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u001F\u0010!\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010 2\u0006\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b!\u0010\"J%\u0010$\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00060#H\u0007\u00A2\u0006\u0004\b$\u0010%J%\u0010&\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00060#H\u0007\u00A2\u0006\u0004\b&\u0010%J%\u0010\'\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00060#H\u0007\u00A2\u0006\u0004\b\'\u0010%J\u0019\u0010)\u001A\u0004\u0018\u00010(2\u0006\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b)\u0010*J\u001F\u0010+\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0014\u001A\u00020(H\u0007\u00A2\u0006\u0004\b+\u0010,J\u0019\u0010-\u001A\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b-\u0010\u0018J\u001F\u0010.\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0014\u001A\u00020\bH\u0007\u00A2\u0006\u0004\b.\u0010\u001AJ\u0017\u0010/\u001A\u00020\u001B2\u0006\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b/\u0010\u001DJ\u001F\u00100\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0014\u001A\u00020\u001BH\u0007\u00A2\u0006\u0004\b0\u0010\u001FJ\u0019\u00101\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b1\u0010\u0013J!\u00102\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0014\u001A\u0004\u0018\u00010\u0006H\u0007\u00A2\u0006\u0004\b2\u0010\u0016R\u0014\u00103\u001A\u00020\u00068\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00105\u001A\u00020\u00068\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b5\u00104R\u0014\u00106\u001A\u00020\u00068\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b6\u00104R\u0014\u00107\u001A\u00020\u00068\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b7\u00104R\u0014\u00108\u001A\u00020\u00068\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b8\u00104R\u0014\u00109\u001A\u00020\u001B8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010;\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b;\u00104R\u0014\u0010<\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b<\u00104R\u0014\u0010=\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b=\u00104R\u0014\u0010>\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b>\u00104R\u0014\u0010?\u001A\u00020\u00068\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b?\u00104R\u0014\u0010@\u001A\u00020\u00068\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b@\u00104R\u001C\u0010B\u001A\n A*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bB\u00104R\u0014\u0010C\u001A\u00020\u00068\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\bC\u00104R\u0014\u0010D\u001A\u00020\u00068\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\bD\u00104R\u0014\u0010E\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bE\u00104R\u0014\u0010F\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bF\u00104R\u0014\u0010G\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bG\u00104R\u0014\u0010H\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bH\u00104R\u0014\u0010I\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bI\u00104R\u0014\u0010J\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bJ\u00104R\u0014\u0010K\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bK\u00104R\u0014\u0010L\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bL\u00104R\u0014\u0010M\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bM\u00104R\u0014\u0010N\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bN\u00104R\u0014\u0010O\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bO\u00104R\u0014\u0010P\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bP\u00104R\u0014\u0010Q\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bQ\u00104R\u0014\u0010R\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bR\u00104R\u0014\u0010S\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bS\u00104R\u0014\u0010T\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bT\u00104R\u0014\u0010U\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bU\u00104R\u0014\u0010V\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bV\u00104R\u0014\u0010W\u001A\u00020\u00068\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bW\u00104\u00A8\u0006X"}, d2 = {"Lcom/facebook/LegacyTokenHelper$Companion;", "", "<init>", "()V", "Landroid/os/Bundle;", "bundle", "", "key", "Ljava/util/Date;", "getDate", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/util/Date;", "date", "Lie/H;", "putDate", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/util/Date;)V", "", "hasTokenInformation", "(Landroid/os/Bundle;)Z", "getToken", "(Landroid/os/Bundle;)Ljava/lang/String;", "value", "putToken", "(Landroid/os/Bundle;Ljava/lang/String;)V", "getExpirationDate", "(Landroid/os/Bundle;)Ljava/util/Date;", "putExpirationDate", "(Landroid/os/Bundle;Ljava/util/Date;)V", "", "getExpirationMilliseconds", "(Landroid/os/Bundle;)J", "putExpirationMilliseconds", "(Landroid/os/Bundle;J)V", "", "getPermissions", "(Landroid/os/Bundle;)Ljava/util/Set;", "", "putPermissions", "(Landroid/os/Bundle;Ljava/util/Collection;)V", "putDeclinedPermissions", "putExpiredPermissions", "Lcom/facebook/AccessTokenSource;", "getSource", "(Landroid/os/Bundle;)Lcom/facebook/AccessTokenSource;", "putSource", "(Landroid/os/Bundle;Lcom/facebook/AccessTokenSource;)V", "getLastRefreshDate", "putLastRefreshDate", "getLastRefreshMilliseconds", "putLastRefreshMilliseconds", "getApplicationId", "putApplicationId", "APPLICATION_ID_KEY", "Ljava/lang/String;", "DECLINED_PERMISSIONS_KEY", "DEFAULT_CACHE_KEY", "EXPIRATION_DATE_KEY", "EXPIRED_PERMISSIONS_KEY", "INVALID_BUNDLE_MILLISECONDS", "J", "IS_SSO_KEY", "JSON_VALUE", "JSON_VALUE_ENUM_TYPE", "JSON_VALUE_TYPE", "LAST_REFRESH_DATE_KEY", "PERMISSIONS_KEY", "kotlin.jvm.PlatformType", "TAG", "TOKEN_KEY", "TOKEN_SOURCE_KEY", "TYPE_BOOLEAN", "TYPE_BOOLEAN_ARRAY", "TYPE_BYTE", "TYPE_BYTE_ARRAY", "TYPE_CHAR", "TYPE_CHAR_ARRAY", "TYPE_DOUBLE", "TYPE_DOUBLE_ARRAY", "TYPE_ENUM", "TYPE_FLOAT", "TYPE_FLOAT_ARRAY", "TYPE_INTEGER", "TYPE_INTEGER_ARRAY", "TYPE_LONG", "TYPE_LONG_ARRAY", "TYPE_SHORT", "TYPE_SHORT_ARRAY", "TYPE_STRING", "TYPE_STRING_LIST", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @Nullable
        public final String getApplicationId(@NotNull Bundle bundle0) {
            q.g(bundle0, "bundle");
            return bundle0.getString("com.facebook.TokenCachingStrategy.ApplicationId");
        }

        private final Date getDate(Bundle bundle0, String s) {
            if(bundle0 == null) {
                return null;
            }
            long v = bundle0.getLong(s, 0x8000000000000000L);
            return v == 0x8000000000000000L ? null : new Date(v);
        }

        @Nullable
        public final Date getExpirationDate(@NotNull Bundle bundle0) {
            q.g(bundle0, "bundle");
            return this.getDate(bundle0, "com.facebook.TokenCachingStrategy.ExpirationDate");
        }

        public final long getExpirationMilliseconds(@NotNull Bundle bundle0) {
            q.g(bundle0, "bundle");
            return bundle0.getLong("com.facebook.TokenCachingStrategy.ExpirationDate");
        }

        @Nullable
        public final Date getLastRefreshDate(@NotNull Bundle bundle0) {
            q.g(bundle0, "bundle");
            return this.getDate(bundle0, "com.facebook.TokenCachingStrategy.LastRefreshDate");
        }

        public final long getLastRefreshMilliseconds(@NotNull Bundle bundle0) {
            q.g(bundle0, "bundle");
            return bundle0.getLong("com.facebook.TokenCachingStrategy.LastRefreshDate");
        }

        @Nullable
        public final Set getPermissions(@NotNull Bundle bundle0) {
            q.g(bundle0, "bundle");
            ArrayList arrayList0 = bundle0.getStringArrayList("com.facebook.TokenCachingStrategy.Permissions");
            return arrayList0 == null ? null : new HashSet(arrayList0);
        }

        @Nullable
        public final AccessTokenSource getSource(@NotNull Bundle bundle0) {
            q.g(bundle0, "bundle");
            if(bundle0.containsKey("com.facebook.TokenCachingStrategy.AccessTokenSource")) {
                return (AccessTokenSource)bundle0.getSerializable("com.facebook.TokenCachingStrategy.AccessTokenSource");
            }
            return bundle0.getBoolean("com.facebook.TokenCachingStrategy.IsSSO") ? AccessTokenSource.FACEBOOK_APPLICATION_WEB : AccessTokenSource.WEB_VIEW;
        }

        @Nullable
        public final String getToken(@NotNull Bundle bundle0) {
            q.g(bundle0, "bundle");
            return bundle0.getString("com.facebook.TokenCachingStrategy.Token");
        }

        public final boolean hasTokenInformation(@Nullable Bundle bundle0) {
            if(bundle0 == null) {
                return false;
            }
            String s = bundle0.getString("com.facebook.TokenCachingStrategy.Token");
            return s != null && s.length() != 0 && bundle0.getLong("com.facebook.TokenCachingStrategy.ExpirationDate", 0L) != 0L;
        }

        public final void putApplicationId(@NotNull Bundle bundle0, @Nullable String s) {
            q.g(bundle0, "bundle");
            bundle0.putString("com.facebook.TokenCachingStrategy.ApplicationId", s);
        }

        private final void putDate(Bundle bundle0, String s, Date date0) {
            bundle0.putLong(s, date0.getTime());
        }

        public final void putDeclinedPermissions(@NotNull Bundle bundle0, @NotNull Collection collection0) {
            q.g(bundle0, "bundle");
            q.g(collection0, "value");
            bundle0.putStringArrayList("com.facebook.TokenCachingStrategy.DeclinedPermissions", new ArrayList(collection0));
        }

        public final void putExpirationDate(@NotNull Bundle bundle0, @NotNull Date date0) {
            q.g(bundle0, "bundle");
            q.g(date0, "value");
            this.putDate(bundle0, "com.facebook.TokenCachingStrategy.ExpirationDate", date0);
        }

        public final void putExpirationMilliseconds(@NotNull Bundle bundle0, long v) {
            q.g(bundle0, "bundle");
            bundle0.putLong("com.facebook.TokenCachingStrategy.ExpirationDate", v);
        }

        public final void putExpiredPermissions(@NotNull Bundle bundle0, @NotNull Collection collection0) {
            q.g(bundle0, "bundle");
            q.g(collection0, "value");
            bundle0.putStringArrayList("com.facebook.TokenCachingStrategy.ExpiredPermissions", new ArrayList(collection0));
        }

        public final void putLastRefreshDate(@NotNull Bundle bundle0, @NotNull Date date0) {
            q.g(bundle0, "bundle");
            q.g(date0, "value");
            this.putDate(bundle0, "com.facebook.TokenCachingStrategy.LastRefreshDate", date0);
        }

        public final void putLastRefreshMilliseconds(@NotNull Bundle bundle0, long v) {
            q.g(bundle0, "bundle");
            bundle0.putLong("com.facebook.TokenCachingStrategy.LastRefreshDate", v);
        }

        public final void putPermissions(@NotNull Bundle bundle0, @NotNull Collection collection0) {
            q.g(bundle0, "bundle");
            q.g(collection0, "value");
            bundle0.putStringArrayList("com.facebook.TokenCachingStrategy.Permissions", new ArrayList(collection0));
        }

        public final void putSource(@NotNull Bundle bundle0, @NotNull AccessTokenSource accessTokenSource0) {
            q.g(bundle0, "bundle");
            q.g(accessTokenSource0, "value");
            bundle0.putSerializable("com.facebook.TokenCachingStrategy.AccessTokenSource", accessTokenSource0);
        }

        public final void putToken(@NotNull Bundle bundle0, @NotNull String s) {
            q.g(bundle0, "bundle");
            q.g(s, "value");
            bundle0.putString("com.facebook.TokenCachingStrategy.Token", s);
        }
    }

    @NotNull
    public static final String APPLICATION_ID_KEY = "com.facebook.TokenCachingStrategy.ApplicationId";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String DECLINED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.DeclinedPermissions";
    @NotNull
    public static final String DEFAULT_CACHE_KEY = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";
    @NotNull
    public static final String EXPIRATION_DATE_KEY = "com.facebook.TokenCachingStrategy.ExpirationDate";
    @NotNull
    public static final String EXPIRED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.ExpiredPermissions";
    private static final long INVALID_BUNDLE_MILLISECONDS = 0x8000000000000000L;
    @NotNull
    private static final String IS_SSO_KEY = "com.facebook.TokenCachingStrategy.IsSSO";
    @NotNull
    private static final String JSON_VALUE = "value";
    @NotNull
    private static final String JSON_VALUE_ENUM_TYPE = "enumType";
    @NotNull
    private static final String JSON_VALUE_TYPE = "valueType";
    @NotNull
    public static final String LAST_REFRESH_DATE_KEY = "com.facebook.TokenCachingStrategy.LastRefreshDate";
    @NotNull
    public static final String PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.Permissions";
    private static final String TAG = null;
    @NotNull
    public static final String TOKEN_KEY = "com.facebook.TokenCachingStrategy.Token";
    @NotNull
    public static final String TOKEN_SOURCE_KEY = "com.facebook.TokenCachingStrategy.AccessTokenSource";
    @NotNull
    private static final String TYPE_BOOLEAN = "bool";
    @NotNull
    private static final String TYPE_BOOLEAN_ARRAY = "bool[]";
    @NotNull
    private static final String TYPE_BYTE = "byte";
    @NotNull
    private static final String TYPE_BYTE_ARRAY = "byte[]";
    @NotNull
    private static final String TYPE_CHAR = "char";
    @NotNull
    private static final String TYPE_CHAR_ARRAY = "char[]";
    @NotNull
    private static final String TYPE_DOUBLE = "double";
    @NotNull
    private static final String TYPE_DOUBLE_ARRAY = "double[]";
    @NotNull
    private static final String TYPE_ENUM = "enum";
    @NotNull
    private static final String TYPE_FLOAT = "float";
    @NotNull
    private static final String TYPE_FLOAT_ARRAY = "float[]";
    @NotNull
    private static final String TYPE_INTEGER = "int";
    @NotNull
    private static final String TYPE_INTEGER_ARRAY = "int[]";
    @NotNull
    private static final String TYPE_LONG = "long";
    @NotNull
    private static final String TYPE_LONG_ARRAY = "long[]";
    @NotNull
    private static final String TYPE_SHORT = "short";
    @NotNull
    private static final String TYPE_SHORT_ARRAY = "short[]";
    @NotNull
    private static final String TYPE_STRING = "string";
    @NotNull
    private static final String TYPE_STRING_LIST = "stringList";
    @NotNull
    private final SharedPreferences cache;
    @NotNull
    private final String cacheKey;

    static {
        LegacyTokenHelper.Companion = new Companion(null);
        LegacyTokenHelper.TAG = "LegacyTokenHelper";
    }

    public LegacyTokenHelper(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null, 2, null);
    }

    public LegacyTokenHelper(@NotNull Context context0, @Nullable String s) {
        q.g(context0, "context");
        super();
        if(s == null || s.length() == 0) {
            s = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";
        }
        this.cacheKey = s;
        Context context1 = context0.getApplicationContext();
        if(context1 != null) {
            context0 = context1;
        }
        SharedPreferences sharedPreferences0 = context0.getSharedPreferences(s, 0);
        q.f(sharedPreferences0, "context.getSharedPrefere…ey, Context.MODE_PRIVATE)");
        this.cache = sharedPreferences0;
    }

    public LegacyTokenHelper(Context context0, String s, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 2) != 0) {
            s = null;
        }
        this(context0, s);
    }

    public final void clear() {
        this.cache.edit().clear().apply();
    }

    private final void deserializeKey(String s, Bundle bundle0) {
        String s3;
        String s1 = this.cache.getString(s, "{}");
        if(s1 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        JSONObject jSONObject0 = new JSONObject(s1);
        String s2 = jSONObject0.getString("valueType");
        if(s2 != null) {
            int v = 0;
            switch(s2) {
                case "bool": {
                    bundle0.putBoolean(s, jSONObject0.getBoolean("value"));
                    return;
                }
                case "bool[]": {
                    JSONArray jSONArray1 = jSONObject0.getJSONArray("value");
                    int v2 = jSONArray1.length();
                    boolean[] arr_z = new boolean[v2];
                    while(v < v2) {
                        arr_z[v] = jSONArray1.getBoolean(v);
                        ++v;
                    }
                    bundle0.putBooleanArray(s, arr_z);
                    return;
                }
                case "byte": {
                    bundle0.putByte(s, ((byte)jSONObject0.getInt("value")));
                    return;
                }
                case "byte[]": {
                    JSONArray jSONArray2 = jSONObject0.getJSONArray("value");
                    int v3 = jSONArray2.length();
                    byte[] arr_b = new byte[v3];
                    while(v < v3) {
                        arr_b[v] = (byte)jSONArray2.getInt(v);
                        ++v;
                    }
                    bundle0.putByteArray(s, arr_b);
                    return;
                }
                case "char": {
                    String s5 = jSONObject0.getString("value");
                    if(s5 != null && s5.length() == 1) {
                        bundle0.putChar(s, s5.charAt(0));
                        return;
                    }
                    break;
                }
                case "char[]": {
                    JSONArray jSONArray3 = jSONObject0.getJSONArray("value");
                    int v4 = jSONArray3.length();
                    char[] arr_c = new char[v4];
                    for(int v5 = 0; v5 < v4; ++v5) {
                        String s4 = jSONArray3.getString(v5);
                        if(s4 != null && s4.length() == 1) {
                            arr_c[v5] = s4.charAt(0);
                        }
                    }
                    bundle0.putCharArray(s, arr_c);
                    return;
                }
                case "double": {
                    bundle0.putDouble(s, jSONObject0.getDouble("value"));
                    return;
                }
                case "double[]": {
                    JSONArray jSONArray7 = jSONObject0.getJSONArray("value");
                    int v9 = jSONArray7.length();
                    double[] arr_f1 = new double[v9];
                    while(v < v9) {
                        arr_f1[v] = jSONArray7.getDouble(v);
                        ++v;
                    }
                    bundle0.putDoubleArray(s, arr_f1);
                    return;
                }
                case "enum": {
                    try {
                        bundle0.putSerializable(s, Enum.valueOf(Class.forName(jSONObject0.getString("enumType")), jSONObject0.getString("value")));
                        return;
                    }
                    catch(ClassNotFoundException | IllegalArgumentException unused_ex) {
                        break;
                    }
                }
                case "float": {
                    bundle0.putFloat(s, ((float)jSONObject0.getDouble("value")));
                    return;
                }
                case "float[]": {
                    JSONArray jSONArray5 = jSONObject0.getJSONArray("value");
                    int v7 = jSONArray5.length();
                    float[] arr_f = new float[v7];
                    while(v < v7) {
                        arr_f[v] = (float)jSONArray5.getDouble(v);
                        ++v;
                    }
                    bundle0.putFloatArray(s, arr_f);
                    return;
                }
                case "int": {
                    bundle0.putInt(s, jSONObject0.getInt("value"));
                    return;
                }
                case "int[]": {
                    JSONArray jSONArray6 = jSONObject0.getJSONArray("value");
                    int v8 = jSONArray6.length();
                    int[] arr_v1 = new int[v8];
                    while(v < v8) {
                        arr_v1[v] = jSONArray6.getInt(v);
                        ++v;
                    }
                    bundle0.putIntArray(s, arr_v1);
                    return;
                }
                case "long": {
                    bundle0.putLong(s, jSONObject0.getLong("value"));
                    return;
                }
                case "long[]": {
                    JSONArray jSONArray4 = jSONObject0.getJSONArray("value");
                    int v6 = jSONArray4.length();
                    long[] arr_v = new long[v6];
                    while(v < v6) {
                        arr_v[v] = jSONArray4.getLong(v);
                        ++v;
                    }
                    bundle0.putLongArray(s, arr_v);
                    return;
                }
                case "short": {
                    bundle0.putShort(s, ((short)jSONObject0.getInt("value")));
                    return;
                }
                case "short[]": {
                    JSONArray jSONArray8 = jSONObject0.getJSONArray("value");
                    int v10 = jSONArray8.length();
                    short[] arr_v2 = new short[v10];
                    while(v < v10) {
                        arr_v2[v] = (short)jSONArray8.getInt(v);
                        ++v;
                    }
                    bundle0.putShortArray(s, arr_v2);
                    return;
                }
                case "string": {
                    bundle0.putString(s, jSONObject0.getString("value"));
                    return;
                }
                case "stringList": {
                    JSONArray jSONArray0 = jSONObject0.getJSONArray("value");
                    int v1 = jSONArray0.length();
                    ArrayList arrayList0 = new ArrayList(v1);
                    while(v < v1) {
                        Object object0 = jSONArray0.get(v);
                        if(object0 == JSONObject.NULL) {
                            s3 = null;
                        }
                        else {
                            q.e(object0, "null cannot be cast to non-null type kotlin.String");
                            s3 = (String)object0;
                        }
                        arrayList0.add(v, s3);
                        ++v;
                    }
                    bundle0.putStringArrayList(s, arrayList0);
                }
            }
        }
    }

    @Nullable
    public static final String getApplicationId(@NotNull Bundle bundle0) {
        return LegacyTokenHelper.Companion.getApplicationId(bundle0);
    }

    @Nullable
    public static final Date getExpirationDate(@NotNull Bundle bundle0) {
        return LegacyTokenHelper.Companion.getExpirationDate(bundle0);
    }

    public static final long getExpirationMilliseconds(@NotNull Bundle bundle0) {
        return LegacyTokenHelper.Companion.getExpirationMilliseconds(bundle0);
    }

    @Nullable
    public static final Date getLastRefreshDate(@NotNull Bundle bundle0) {
        return LegacyTokenHelper.Companion.getLastRefreshDate(bundle0);
    }

    public static final long getLastRefreshMilliseconds(@NotNull Bundle bundle0) {
        return LegacyTokenHelper.Companion.getLastRefreshMilliseconds(bundle0);
    }

    @Nullable
    public static final Set getPermissions(@NotNull Bundle bundle0) {
        return LegacyTokenHelper.Companion.getPermissions(bundle0);
    }

    @Nullable
    public static final AccessTokenSource getSource(@NotNull Bundle bundle0) {
        return LegacyTokenHelper.Companion.getSource(bundle0);
    }

    @Nullable
    public static final String getToken(@NotNull Bundle bundle0) {
        return LegacyTokenHelper.Companion.getToken(bundle0);
    }

    public static final boolean hasTokenInformation(@Nullable Bundle bundle0) {
        return LegacyTokenHelper.Companion.hasTokenInformation(bundle0);
    }

    @Nullable
    public final Bundle load() {
        Bundle bundle0 = new Bundle();
        for(Object object0: this.cache.getAll().keySet()) {
            String s = (String)object0;
            try {
                q.f(s, "key");
                this.deserializeKey(s, bundle0);
            }
            catch(JSONException jSONException0) {
                q.f("LegacyTokenHelper", "TAG");
                Logger.Companion.log(LoggingBehavior.CACHE, 5, "LegacyTokenHelper", "Error reading cached value for key: \'" + s + "\' -- " + jSONException0);
                return null;
            }
        }
        return bundle0;
    }

    public static final void putApplicationId(@NotNull Bundle bundle0, @Nullable String s) {
        LegacyTokenHelper.Companion.putApplicationId(bundle0, s);
    }

    public static final void putDeclinedPermissions(@NotNull Bundle bundle0, @NotNull Collection collection0) {
        LegacyTokenHelper.Companion.putDeclinedPermissions(bundle0, collection0);
    }

    public static final void putExpirationDate(@NotNull Bundle bundle0, @NotNull Date date0) {
        LegacyTokenHelper.Companion.putExpirationDate(bundle0, date0);
    }

    public static final void putExpirationMilliseconds(@NotNull Bundle bundle0, long v) {
        LegacyTokenHelper.Companion.putExpirationMilliseconds(bundle0, v);
    }

    public static final void putExpiredPermissions(@NotNull Bundle bundle0, @NotNull Collection collection0) {
        LegacyTokenHelper.Companion.putExpiredPermissions(bundle0, collection0);
    }

    public static final void putLastRefreshDate(@NotNull Bundle bundle0, @NotNull Date date0) {
        LegacyTokenHelper.Companion.putLastRefreshDate(bundle0, date0);
    }

    public static final void putLastRefreshMilliseconds(@NotNull Bundle bundle0, long v) {
        LegacyTokenHelper.Companion.putLastRefreshMilliseconds(bundle0, v);
    }

    public static final void putPermissions(@NotNull Bundle bundle0, @NotNull Collection collection0) {
        LegacyTokenHelper.Companion.putPermissions(bundle0, collection0);
    }

    public static final void putSource(@NotNull Bundle bundle0, @NotNull AccessTokenSource accessTokenSource0) {
        LegacyTokenHelper.Companion.putSource(bundle0, accessTokenSource0);
    }

    public static final void putToken(@NotNull Bundle bundle0, @NotNull String s) {
        LegacyTokenHelper.Companion.putToken(bundle0, s);
    }

    public final void save(@NotNull Bundle bundle0) {
        q.g(bundle0, "bundle");
        SharedPreferences.Editor sharedPreferences$Editor0 = this.cache.edit();
        for(Object object0: bundle0.keySet()) {
            String s = (String)object0;
            try {
                q.f(s, "key");
                q.f(sharedPreferences$Editor0, "editor");
                this.serializeKey(s, bundle0, sharedPreferences$Editor0);
            }
            catch(JSONException jSONException0) {
                q.f("LegacyTokenHelper", "TAG");
                Logger.Companion.log(LoggingBehavior.CACHE, 5, "LegacyTokenHelper", "Error processing value for key: \'" + s + "\' -- " + jSONException0);
                return;
            }
        }
        sharedPreferences$Editor0.apply();
    }

    private final void serializeKey(String s, Bundle bundle0, SharedPreferences.Editor sharedPreferences$Editor0) {
        JSONArray jSONArray0;
        Object object0 = bundle0.get(s);
        if(object0 != null) {
            JSONObject jSONObject0 = new JSONObject();
            String s1 = null;
            if(object0 instanceof Byte) {
                jSONObject0.put("value", ((Number)object0).byteValue());
                jSONArray0 = null;
                s1 = "byte";
            }
            else if(object0 instanceof Short) {
                jSONObject0.put("value", ((Number)object0).shortValue());
                jSONArray0 = null;
                s1 = "short";
            }
            else if(object0 instanceof Integer) {
                jSONObject0.put("value", ((Number)object0).intValue());
                jSONArray0 = null;
                s1 = "int";
            }
            else if(object0 instanceof Long) {
                jSONObject0.put("value", ((Number)object0).longValue());
                jSONArray0 = null;
                s1 = "long";
            }
            else if(object0 instanceof Float) {
                jSONObject0.put("value", ((double)((Number)object0).floatValue()));
                jSONArray0 = null;
                s1 = "float";
            }
            else if(object0 instanceof Double) {
                jSONObject0.put("value", ((Number)object0).doubleValue());
                jSONArray0 = null;
                s1 = "double";
            }
            else if(object0 instanceof Boolean) {
                jSONObject0.put("value", ((Boolean)object0).booleanValue());
                jSONArray0 = null;
                s1 = "bool";
            }
            else if(object0 instanceof Character) {
                jSONObject0.put("value", object0.toString());
                jSONArray0 = null;
                s1 = "char";
            }
            else if(object0 instanceof String) {
                jSONObject0.put("value", object0);
                jSONArray0 = null;
                s1 = "string";
            }
            else if(object0 instanceof Enum) {
                jSONObject0.put("value", object0.toString());
                jSONObject0.put("enumType", object0.getClass().getName());
                jSONArray0 = null;
                s1 = "enum";
            }
            else {
                jSONArray0 = new JSONArray();
                int v = 0;
                if(object0 instanceof byte[]) {
                    while(v < ((byte[])object0).length) {
                        jSONArray0.put(((int)((byte[])object0)[v]));
                        ++v;
                    }
                    s1 = "byte[]";
                }
                else if(object0 instanceof short[]) {
                    while(v < ((short[])object0).length) {
                        jSONArray0.put(((int)((short[])object0)[v]));
                        ++v;
                    }
                    s1 = "short[]";
                }
                else if(object0 instanceof int[]) {
                    while(v < ((int[])object0).length) {
                        jSONArray0.put(((int[])object0)[v]);
                        ++v;
                    }
                    s1 = "int[]";
                }
                else if(object0 instanceof long[]) {
                    while(v < ((long[])object0).length) {
                        jSONArray0.put(((long[])object0)[v]);
                        ++v;
                    }
                    s1 = "long[]";
                }
                else if(object0 instanceof float[]) {
                    while(v < ((float[])object0).length) {
                        jSONArray0.put(((double)((float[])object0)[v]));
                        ++v;
                    }
                    s1 = "float[]";
                }
                else if(object0 instanceof double[]) {
                    while(v < ((double[])object0).length) {
                        jSONArray0.put(((double[])object0)[v]);
                        ++v;
                    }
                    s1 = "double[]";
                }
                else if(object0 instanceof boolean[]) {
                    while(v < ((boolean[])object0).length) {
                        jSONArray0.put(((boolean[])object0)[v]);
                        ++v;
                    }
                    s1 = "bool[]";
                }
                else if(object0 instanceof char[]) {
                    while(v < ((char[])object0).length) {
                        jSONArray0.put(String.valueOf(((char[])object0)[v]));
                        ++v;
                    }
                    s1 = "char[]";
                }
                else if(object0 instanceof List) {
                    for(Object object1: ((List)object0)) {
                        String s2 = (String)object1;
                        if(s2 == null) {
                            s2 = JSONObject.NULL;
                        }
                        jSONArray0.put(s2);
                    }
                    s1 = "stringList";
                }
                else {
                    jSONArray0 = null;
                }
            }
            if(s1 != null) {
                jSONObject0.put("valueType", s1);
                if(jSONArray0 != null) {
                    jSONObject0.putOpt("value", jSONArray0);
                }
                String s3 = jSONObject0.toString();
                q.f(s3, "json.toString()");
                sharedPreferences$Editor0.putString(s, s3);
            }
        }
    }
}

