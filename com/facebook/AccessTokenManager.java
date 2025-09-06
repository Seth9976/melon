package com.facebook;

import W2.b;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import b.l;
import com.facebook.internal.Utility;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 ,2\u00020\u0001:\u0005,-./0B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\r\u001A\u00020\f2\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0006\u0010\u000B\u001A\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000EJ#\u0010\u0010\u001A\u00020\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\b2\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001A\u00020\f2\b\u0010\u0017\u001A\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001A\u001A\u00020\n¢\u0006\u0004\b\u001A\u0010\u0015J\r\u0010\u001B\u001A\u00020\f¢\u0006\u0004\b\u001B\u0010\u0013J\r\u0010\u001C\u001A\u00020\f¢\u0006\u0004\b\u001C\u0010\u0013J\u0017\u0010\u001D\u001A\u00020\f2\b\u0010\u0017\u001A\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u001D\u0010\u0019R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001ER\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001FR\u0018\u0010 \u001A\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001A\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001A\u00020%8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b&\u0010\'R(\u0010\t\u001A\u0004\u0018\u00010\b2\b\u0010(\u001A\u0004\u0018\u00010\b8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b)\u0010*\"\u0004\b\r\u0010+¨\u00061"}, d2 = {"Lcom/facebook/AccessTokenManager;", "", "LW2/b;", "localBroadcastManager", "Lcom/facebook/AccessTokenCache;", "accessTokenCache", "<init>", "(LW2/b;Lcom/facebook/AccessTokenCache;)V", "Lcom/facebook/AccessToken;", "currentAccessToken", "", "saveToCache", "Lie/H;", "setCurrentAccessToken", "(Lcom/facebook/AccessToken;Z)V", "oldAccessToken", "sendCurrentAccessTokenChangedBroadcastIntent", "(Lcom/facebook/AccessToken;Lcom/facebook/AccessToken;)V", "setTokenExpirationBroadcastAlarm", "()V", "shouldExtendAccessToken", "()Z", "Lcom/facebook/AccessToken$AccessTokenRefreshCallback;", "callback", "refreshCurrentAccessTokenImpl", "(Lcom/facebook/AccessToken$AccessTokenRefreshCallback;)V", "loadCurrentAccessToken", "currentAccessTokenChanged", "extendAccessTokenIfNeeded", "refreshCurrentAccessToken", "LW2/b;", "Lcom/facebook/AccessTokenCache;", "currentAccessTokenField", "Lcom/facebook/AccessToken;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "tokenRefreshInProgress", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/Date;", "lastAttemptedTokenExtendDate", "Ljava/util/Date;", "value", "getCurrentAccessToken", "()Lcom/facebook/AccessToken;", "(Lcom/facebook/AccessToken;)V", "Companion", "FacebookRefreshTokenInfo", "InstagramRefreshTokenInfo", "RefreshResult", "RefreshTokenInfo", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AccessTokenManager {
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014H\u0002J\u0018\u0010\u0015\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0014H\u0002J\b\u0010\u0016\u001A\u00020\u000EH\u0007J\u0010\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0011\u001A\u00020\u0012H\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001A\u0004\u0018\u00010\u000EX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/facebook/AccessTokenManager$Companion;", "", "()V", "ACTION_CURRENT_ACCESS_TOKEN_CHANGED", "", "EXTRA_NEW_ACCESS_TOKEN", "EXTRA_OLD_ACCESS_TOKEN", "ME_PERMISSIONS_GRAPH_PATH", "SHARED_PREFERENCES_NAME", "TAG", "TOKEN_EXTEND_RETRY_SECONDS", "", "TOKEN_EXTEND_THRESHOLD_SECONDS", "instanceField", "Lcom/facebook/AccessTokenManager;", "createExtendAccessTokenRequest", "Lcom/facebook/GraphRequest;", "accessToken", "Lcom/facebook/AccessToken;", "callback", "Lcom/facebook/GraphRequest$Callback;", "createGrantedPermissionsRequest", "getInstance", "getRefreshTokenInfoForToken", "Lcom/facebook/AccessTokenManager$RefreshTokenInfo;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static final GraphRequest access$createExtendAccessTokenRequest(Companion accessTokenManager$Companion0, AccessToken accessToken0, Callback graphRequest$Callback0) {
            return accessTokenManager$Companion0.createExtendAccessTokenRequest(accessToken0, graphRequest$Callback0);
        }

        public static final GraphRequest access$createGrantedPermissionsRequest(Companion accessTokenManager$Companion0, AccessToken accessToken0, Callback graphRequest$Callback0) {
            return accessTokenManager$Companion0.createGrantedPermissionsRequest(accessToken0, graphRequest$Callback0);
        }

        private final GraphRequest createExtendAccessTokenRequest(AccessToken accessToken0, Callback graphRequest$Callback0) {
            RefreshTokenInfo accessTokenManager$RefreshTokenInfo0 = this.getRefreshTokenInfoForToken(accessToken0);
            Bundle bundle0 = new Bundle();
            bundle0.putString("grant_type", accessTokenManager$RefreshTokenInfo0.getGrantType());
            bundle0.putString("client_id", accessToken0.getApplicationId());
            bundle0.putString("fields", "access_token,expires_at,expires_in,data_access_expiration_time,graph_domain");
            String s = accessTokenManager$RefreshTokenInfo0.getGraphPath();
            GraphRequest graphRequest0 = GraphRequest.Companion.newGraphPathRequest(accessToken0, s, graphRequest$Callback0);
            graphRequest0.setParameters(bundle0);
            graphRequest0.setHttpMethod(HttpMethod.GET);
            return graphRequest0;
        }

        private final GraphRequest createGrantedPermissionsRequest(AccessToken accessToken0, Callback graphRequest$Callback0) {
            Bundle bundle0 = Y.b("fields", "permission,status");
            GraphRequest graphRequest0 = GraphRequest.Companion.newGraphPathRequest(accessToken0, "me/permissions", graphRequest$Callback0);
            graphRequest0.setParameters(bundle0);
            graphRequest0.setHttpMethod(HttpMethod.GET);
            return graphRequest0;
        }

        @NotNull
        public final AccessTokenManager getInstance() {
            AccessTokenManager accessTokenManager0 = AccessTokenManager.instanceField;
            if(accessTokenManager0 == null) {
                synchronized(this) {
                    AccessTokenManager accessTokenManager1 = AccessTokenManager.instanceField;
                    if(accessTokenManager1 == null) {
                        b b0 = b.a(FacebookSdk.getApplicationContext());
                        q.f(b0, "getInstance(applicationContext)");
                        AccessTokenManager accessTokenManager2 = new AccessTokenManager(b0, new AccessTokenCache());
                        AccessTokenManager.instanceField = accessTokenManager2;
                        accessTokenManager1 = accessTokenManager2;
                    }
                    return accessTokenManager1;
                }
            }
            return accessTokenManager0;
        }

        private final RefreshTokenInfo getRefreshTokenInfoForToken(AccessToken accessToken0) {
            String s = accessToken0.getGraphDomain();
            if(s == null) {
                s = "facebook";
            }
            return s.equals("instagram") ? new InstagramRefreshTokenInfo() : new FacebookRefreshTokenInfo();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001A\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001A\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/facebook/AccessTokenManager$FacebookRefreshTokenInfo;", "Lcom/facebook/AccessTokenManager$RefreshTokenInfo;", "()V", "grantType", "", "getGrantType", "()Ljava/lang/String;", "graphPath", "getGraphPath", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class FacebookRefreshTokenInfo implements RefreshTokenInfo {
        @NotNull
        private final String grantType;
        @NotNull
        private final String graphPath;

        public FacebookRefreshTokenInfo() {
            this.graphPath = "oauth/access_token";
            this.grantType = "fb_extend_sso_token";
        }

        @Override  // com.facebook.AccessTokenManager$RefreshTokenInfo
        @NotNull
        public String getGrantType() {
            return this.grantType;
        }

        @Override  // com.facebook.AccessTokenManager$RefreshTokenInfo
        @NotNull
        public String getGraphPath() {
            return this.graphPath;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001A\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001A\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/facebook/AccessTokenManager$InstagramRefreshTokenInfo;", "Lcom/facebook/AccessTokenManager$RefreshTokenInfo;", "()V", "grantType", "", "getGrantType", "()Ljava/lang/String;", "graphPath", "getGraphPath", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class InstagramRefreshTokenInfo implements RefreshTokenInfo {
        @NotNull
        private final String grantType;
        @NotNull
        private final String graphPath;

        public InstagramRefreshTokenInfo() {
            this.graphPath = "refresh_access_token";
            this.grantType = "ig_refresh_token";
        }

        @Override  // com.facebook.AccessTokenManager$RefreshTokenInfo
        @NotNull
        public String getGrantType() {
            return this.grantType;
        }

        @Override  // com.facebook.AccessTokenManager$RefreshTokenInfo
        @NotNull
        public String getGraphPath() {
            return this.graphPath;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000B\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001C\u0010\u0003\u001A\u0004\u0018\u00010\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001E\u0010\t\u001A\u0004\u0018\u00010\nX\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u000F\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u001A\u0010\u0010\u001A\u00020\u0011X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001A\u0010\u0016\u001A\u00020\u0011X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001C\u0010\u0019\u001A\u0004\u0018\u00010\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0006\"\u0004\b\u001B\u0010\b¨\u0006\u001C"}, d2 = {"Lcom/facebook/AccessTokenManager$RefreshResult;", "", "()V", "accessToken", "", "getAccessToken", "()Ljava/lang/String;", "setAccessToken", "(Ljava/lang/String;)V", "dataAccessExpirationTime", "", "getDataAccessExpirationTime", "()Ljava/lang/Long;", "setDataAccessExpirationTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "expiresAt", "", "getExpiresAt", "()I", "setExpiresAt", "(I)V", "expiresIn", "getExpiresIn", "setExpiresIn", "graphDomain", "getGraphDomain", "setGraphDomain", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    static final class RefreshResult {
        @Nullable
        private String accessToken;
        @Nullable
        private Long dataAccessExpirationTime;
        private int expiresAt;
        private int expiresIn;
        @Nullable
        private String graphDomain;

        @Nullable
        public final String getAccessToken() {
            return this.accessToken;
        }

        @Nullable
        public final Long getDataAccessExpirationTime() {
            return this.dataAccessExpirationTime;
        }

        public final int getExpiresAt() {
            return this.expiresAt;
        }

        public final int getExpiresIn() {
            return this.expiresIn;
        }

        @Nullable
        public final String getGraphDomain() {
            return this.graphDomain;
        }

        public final void setAccessToken(@Nullable String s) {
            this.accessToken = s;
        }

        public final void setDataAccessExpirationTime(@Nullable Long long0) {
            this.dataAccessExpirationTime = long0;
        }

        public final void setExpiresAt(int v) {
            this.expiresAt = v;
        }

        public final void setExpiresIn(int v) {
            this.expiresIn = v;
        }

        public final void setGraphDomain(@Nullable String s) {
            this.graphDomain = s;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/facebook/AccessTokenManager$RefreshTokenInfo;", "", "grantType", "", "getGrantType", "()Ljava/lang/String;", "graphPath", "getGraphPath", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface RefreshTokenInfo {
        @NotNull
        String getGrantType();

        @NotNull
        String getGraphPath();
    }

    @NotNull
    public static final String ACTION_CURRENT_ACCESS_TOKEN_CHANGED = "com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String EXTRA_NEW_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN";
    @NotNull
    public static final String EXTRA_OLD_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN";
    @NotNull
    private static final String ME_PERMISSIONS_GRAPH_PATH = "me/permissions";
    @NotNull
    public static final String SHARED_PREFERENCES_NAME = "com.facebook.AccessTokenManager.SharedPreferences";
    @NotNull
    public static final String TAG = "AccessTokenManager";
    private static final int TOKEN_EXTEND_RETRY_SECONDS = 3600;
    private static final int TOKEN_EXTEND_THRESHOLD_SECONDS = 86400;
    @NotNull
    private final AccessTokenCache accessTokenCache;
    @Nullable
    private AccessToken currentAccessTokenField;
    @Nullable
    private static AccessTokenManager instanceField;
    @NotNull
    private Date lastAttemptedTokenExtendDate;
    @NotNull
    private final b localBroadcastManager;
    @NotNull
    private final AtomicBoolean tokenRefreshInProgress;

    static {
        AccessTokenManager.Companion = new Companion(null);
    }

    public AccessTokenManager(@NotNull b b0, @NotNull AccessTokenCache accessTokenCache0) {
        q.g(b0, "localBroadcastManager");
        q.g(accessTokenCache0, "accessTokenCache");
        super();
        this.localBroadcastManager = b0;
        this.accessTokenCache = accessTokenCache0;
        this.tokenRefreshInProgress = new AtomicBoolean(false);
        this.lastAttemptedTokenExtendDate = new Date(0L);
    }

    public static void c(AccessTokenManager accessTokenManager0, AccessTokenRefreshCallback accessToken$AccessTokenRefreshCallback0) {
        AccessTokenManager.refreshCurrentAccessToken$lambda$0(accessTokenManager0, accessToken$AccessTokenRefreshCallback0);
    }

    public final void currentAccessTokenChanged() {
        this.sendCurrentAccessTokenChangedBroadcastIntent(this.getCurrentAccessToken(), this.getCurrentAccessToken());
    }

    public final void extendAccessTokenIfNeeded() {
        if(!this.shouldExtendAccessToken()) {
            return;
        }
        this.refreshCurrentAccessToken(null);
    }

    @Nullable
    public final AccessToken getCurrentAccessToken() {
        return this.currentAccessTokenField;
    }

    @NotNull
    public static final AccessTokenManager getInstance() {
        return AccessTokenManager.Companion.getInstance();
    }

    public final boolean loadCurrentAccessToken() {
        AccessToken accessToken0 = this.accessTokenCache.load();
        if(accessToken0 != null) {
            this.setCurrentAccessToken(accessToken0, false);
            return true;
        }
        return false;
    }

    public final void refreshCurrentAccessToken(@Nullable AccessTokenRefreshCallback accessToken$AccessTokenRefreshCallback0) {
        if(q.b(Looper.getMainLooper(), Looper.myLooper())) {
            this.refreshCurrentAccessTokenImpl(accessToken$AccessTokenRefreshCallback0);
            return;
        }
        new Handler(Looper.getMainLooper()).post(new l(2, this, accessToken$AccessTokenRefreshCallback0));
    }

    private static final void refreshCurrentAccessToken$lambda$0(AccessTokenManager accessTokenManager0, AccessTokenRefreshCallback accessToken$AccessTokenRefreshCallback0) {
        q.g(accessTokenManager0, "this$0");
        accessTokenManager0.refreshCurrentAccessTokenImpl(accessToken$AccessTokenRefreshCallback0);
    }

    private final void refreshCurrentAccessTokenImpl(AccessTokenRefreshCallback accessToken$AccessTokenRefreshCallback0) {
        AccessToken accessToken0 = this.getCurrentAccessToken();
        if(accessToken0 == null) {
            if(accessToken$AccessTokenRefreshCallback0 == null) {
                return;
            }
            accessToken$AccessTokenRefreshCallback0.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
            return;
        }
        if(!this.tokenRefreshInProgress.compareAndSet(false, true)) {
            if(accessToken$AccessTokenRefreshCallback0 != null) {
                accessToken$AccessTokenRefreshCallback0.OnTokenRefreshFailed(new FacebookException("Refresh already in progress"));
            }
            return;
        }
        this.lastAttemptedTokenExtendDate = new Date();
        HashSet hashSet0 = new HashSet();
        HashSet hashSet1 = new HashSet();
        HashSet hashSet2 = new HashSet();
        AtomicBoolean atomicBoolean0 = new AtomicBoolean(false);
        RefreshResult accessTokenManager$RefreshResult0 = new RefreshResult();
        a a0 = new a(atomicBoolean0, hashSet0, hashSet1, hashSet2, 0);
        GraphRequest graphRequest0 = Companion.access$createGrantedPermissionsRequest(AccessTokenManager.Companion, accessToken0, a0);
        com.facebook.b b0 = new com.facebook.b(accessTokenManager$RefreshResult0, 0);
        GraphRequestBatch graphRequestBatch0 = new GraphRequestBatch(new GraphRequest[]{graphRequest0, Companion.access$createExtendAccessTokenRequest(AccessTokenManager.Companion, accessToken0, b0)});
        graphRequestBatch0.addCallback(new c(accessTokenManager$RefreshResult0, accessToken0, accessToken$AccessTokenRefreshCallback0, atomicBoolean0, hashSet0, hashSet1, hashSet2, this));
        graphRequestBatch0.executeAsync();
    }

    private static final void refreshCurrentAccessTokenImpl$lambda$1(AtomicBoolean atomicBoolean0, Set set0, Set set1, Set set2, GraphResponse graphResponse0) {
        q.g(atomicBoolean0, "$permissionsCallSucceeded");
        q.g(set0, "$permissions");
        q.g(set1, "$declinedPermissions");
        q.g(set2, "$expiredPermissions");
        q.g(graphResponse0, "response");
        JSONObject jSONObject0 = graphResponse0.getJsonObject();
        if(jSONObject0 != null) {
            JSONArray jSONArray0 = jSONObject0.optJSONArray("data");
            if(jSONArray0 != null) {
                atomicBoolean0.set(true);
                int v = jSONArray0.length();
                for(int v1 = 0; v1 < v; ++v1) {
                    JSONObject jSONObject1 = jSONArray0.optJSONObject(v1);
                    if(jSONObject1 != null) {
                        String s = jSONObject1.optString("permission");
                        String s1 = jSONObject1.optString("status");
                        if(!Utility.isNullOrEmpty(s) && !Utility.isNullOrEmpty(s1)) {
                            q.f(s1, "status");
                            Locale locale0 = Locale.US;
                            q.f(locale0, "US");
                            String s2 = s1.toLowerCase(locale0);
                            q.f(s2, "this as java.lang.String).toLowerCase(locale)");
                            switch(s2) {
                                case "declined": {
                                    set1.add(s);
                                    break;
                                }
                                case "expired": {
                                    set2.add(s);
                                    break;
                                }
                                case "granted": {
                                    set0.add(s);
                                    break;
                                }
                                default: {
                                    Log.w("AccessTokenManager", "Unexpected status: " + s2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static final void refreshCurrentAccessTokenImpl$lambda$2(RefreshResult accessTokenManager$RefreshResult0, GraphResponse graphResponse0) {
        q.g(accessTokenManager$RefreshResult0, "$refreshResult");
        q.g(graphResponse0, "response");
        JSONObject jSONObject0 = graphResponse0.getJsonObject();
        if(jSONObject0 == null) {
            return;
        }
        accessTokenManager$RefreshResult0.setAccessToken(jSONObject0.optString("access_token"));
        accessTokenManager$RefreshResult0.setExpiresAt(jSONObject0.optInt("expires_at"));
        accessTokenManager$RefreshResult0.setExpiresIn(jSONObject0.optInt("expires_in"));
        accessTokenManager$RefreshResult0.setDataAccessExpirationTime(jSONObject0.optLong("data_access_expiration_time"));
        accessTokenManager$RefreshResult0.setGraphDomain(jSONObject0.optString("graph_domain", null));
    }

    private static final void refreshCurrentAccessTokenImpl$lambda$3(RefreshResult accessTokenManager$RefreshResult0, AccessToken accessToken0, AccessTokenRefreshCallback accessToken$AccessTokenRefreshCallback0, AtomicBoolean atomicBoolean0, Set set0, Set set1, Set set2, AccessTokenManager accessTokenManager0, GraphRequestBatch graphRequestBatch0) {
        AccessToken accessToken2;
        Date date1;
        Companion accessTokenManager$Companion1;
        q.g(accessTokenManager$RefreshResult0, "$refreshResult");
        q.g(atomicBoolean0, "$permissionsCallSucceeded");
        q.g(set0, "$permissions");
        q.g(set1, "$declinedPermissions");
        Set set3 = set2;
        q.g(set3, "$expiredPermissions");
        q.g(accessTokenManager0, "this$0");
        q.g(graphRequestBatch0, "it");
        String s = accessTokenManager$RefreshResult0.getAccessToken();
        int v = accessTokenManager$RefreshResult0.getExpiresAt();
        Long long0 = accessTokenManager$RefreshResult0.getDataAccessExpirationTime();
        String s1 = accessTokenManager$RefreshResult0.getGraphDomain();
        try {
            Companion accessTokenManager$Companion0 = AccessTokenManager.Companion;
            if(accessTokenManager$Companion0.getInstance().getCurrentAccessToken() == null) {
                goto label_49;
            }
            else {
                AccessToken accessToken1 = accessTokenManager$Companion0.getInstance().getCurrentAccessToken();
                if((accessToken1 == null ? null : accessToken1.getUserId()) == accessToken0.getUserId()) {
                    if(atomicBoolean0.get() || s != null || v != 0) {
                        Date date0 = accessToken0.getExpires();
                        if(accessTokenManager$RefreshResult0.getExpiresAt() == 0) {
                            accessTokenManager$Companion1 = accessTokenManager$Companion0;
                            date1 = accessTokenManager$RefreshResult0.getExpiresIn() == 0 ? date0 : new Date(((long)accessTokenManager$RefreshResult0.getExpiresIn()) * 1000L + new Date().getTime());
                        }
                        else {
                            accessTokenManager$Companion1 = accessTokenManager$Companion0;
                            date1 = new Date(((long)accessTokenManager$RefreshResult0.getExpiresAt()) * 1000L);
                        }
                        if(s == null) {
                            s = accessToken0.getToken();
                        }
                        String s2 = accessToken0.getApplicationId();
                        String s3 = accessToken0.getUserId();
                        Set set4 = atomicBoolean0.get() ? set0 : accessToken0.getPermissions();
                        Set set5 = atomicBoolean0.get() ? set1 : accessToken0.getDeclinedPermissions();
                        if(!atomicBoolean0.get()) {
                            set3 = accessToken0.getExpiredPermissions();
                        }
                        AccessTokenSource accessTokenSource0 = accessToken0.getSource();
                        Date date2 = new Date();
                        Date date3 = long0 == null ? accessToken0.getDataAccessExpirationTime() : new Date(((long)long0) * 1000L);
                        if(s1 == null) {
                            s1 = accessToken0.getGraphDomain();
                        }
                        accessToken2 = new AccessToken(s, s2, s3, set4, set5, set3, accessTokenSource0, date1, date2, date3, s1);
                        goto label_38;
                    }
                    goto label_46;
                }
                else {
                    goto label_49;
                }
            }
            goto label_58;
        }
        catch(Throwable throwable0) {
            goto label_53;
        }
        try {
        label_38:
            accessTokenManager$Companion1.getInstance().setCurrentAccessToken(accessToken2);
        }
        catch(Throwable throwable0) {
            goto label_54;
        }
        accessTokenManager0.tokenRefreshInProgress.set(false);
        if(accessToken$AccessTokenRefreshCallback0 != null) {
            accessToken$AccessTokenRefreshCallback0.OnTokenRefreshed(accessToken2);
        }
        return;
    label_46:
        if(accessToken$AccessTokenRefreshCallback0 != null) {
            try {
                accessToken$AccessTokenRefreshCallback0.OnTokenRefreshFailed(new FacebookException("Failed to refresh access token"));
                goto label_58;
            label_49:
                if(accessToken$AccessTokenRefreshCallback0 != null) {
                    accessToken$AccessTokenRefreshCallback0.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
                }
                goto label_58;
            }
            catch(Throwable throwable0) {
            label_53:
                accessToken2 = null;
            }
        label_54:
            accessTokenManager0.tokenRefreshInProgress.set(false);
            if(accessToken$AccessTokenRefreshCallback0 != null && accessToken2 != null) {
                accessToken$AccessTokenRefreshCallback0.OnTokenRefreshed(accessToken2);
            }
            throw throwable0;
        }
    label_58:
        accessTokenManager0.tokenRefreshInProgress.set(false);
    }

    private final void sendCurrentAccessTokenChangedBroadcastIntent(AccessToken accessToken0, AccessToken accessToken1) {
        Intent intent0 = new Intent(FacebookSdk.getApplicationContext(), CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent0.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        intent0.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", accessToken0);
        intent0.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", accessToken1);
        this.localBroadcastManager.c(intent0);
    }

    private final void setCurrentAccessToken(AccessToken accessToken0, boolean z) {
        AccessToken accessToken1 = this.currentAccessTokenField;
        this.currentAccessTokenField = accessToken0;
        this.tokenRefreshInProgress.set(false);
        this.lastAttemptedTokenExtendDate = new Date(0L);
        if(z) {
            if(accessToken0 == null) {
                this.accessTokenCache.clear();
                Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
            }
            else {
                this.accessTokenCache.save(accessToken0);
            }
        }
        if(!Utility.areObjectsEqual(accessToken1, accessToken0)) {
            this.sendCurrentAccessTokenChangedBroadcastIntent(accessToken1, accessToken0);
            this.setTokenExpirationBroadcastAlarm();
        }
    }

    public final void setCurrentAccessToken(@Nullable AccessToken accessToken0) {
        this.setCurrentAccessToken(accessToken0, true);
    }

    private final void setTokenExpirationBroadcastAlarm() {
        Context context0 = FacebookSdk.getApplicationContext();
        AccessToken accessToken0 = AccessToken.Companion.getCurrentAccessToken();
        AlarmManager alarmManager0 = (AlarmManager)context0.getSystemService("alarm");
        if(AccessToken.Companion.isCurrentAccessTokenActive() && ((accessToken0 == null ? null : accessToken0.getExpires()) != null && alarmManager0 != null)) {
            Intent intent0 = new Intent(context0, CurrentAccessTokenExpirationBroadcastReceiver.class);
            intent0.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
            PendingIntent pendingIntent0 = PendingIntent.getBroadcast(context0, 0, intent0, 0x4000000);
            try {
                alarmManager0.set(1, accessToken0.getExpires().getTime(), pendingIntent0);
            }
            catch(Exception unused_ex) {
            }
        }
    }

    private final boolean shouldExtendAccessToken() {
        AccessToken accessToken0 = this.getCurrentAccessToken();
        if(accessToken0 == null) {
            return false;
        }
        long v = new Date().getTime();
        return accessToken0.getSource().canExtendToken() && v - this.lastAttemptedTokenExtendDate.getTime() > 3600000L && v - accessToken0.getLastRefresh().getTime() > 86400000L;
    }
}

