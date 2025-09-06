package com.facebook;

import W2.b;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.internal.Utility;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 \u001E2\u00020\u0001:\u0002\u001E\u001FB\u0019\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\r\u001A\u00020\f2\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0006\u0010\u000B\u001A\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000EJ#\u0010\u0010\u001A\u00020\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\b2\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001A\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001A\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u0018\u0010\u0018\u001A\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R(\u0010\t\u001A\u0004\u0018\u00010\b2\b\u0010\u001A\u001A\u0004\u0018\u00010\b8F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\r\u0010\u001D¨\u0006 "}, d2 = {"Lcom/facebook/AuthenticationTokenManager;", "", "LW2/b;", "localBroadcastManager", "Lcom/facebook/AuthenticationTokenCache;", "authenticationTokenCache", "<init>", "(LW2/b;Lcom/facebook/AuthenticationTokenCache;)V", "Lcom/facebook/AuthenticationToken;", "currentAuthenticationToken", "", "saveToCache", "Lie/H;", "setCurrentAuthenticationToken", "(Lcom/facebook/AuthenticationToken;Z)V", "oldAuthenticationToken", "sendCurrentAuthenticationTokenChangedBroadcastIntent", "(Lcom/facebook/AuthenticationToken;Lcom/facebook/AuthenticationToken;)V", "loadCurrentAuthenticationToken", "()Z", "currentAuthenticationTokenChanged", "()V", "LW2/b;", "Lcom/facebook/AuthenticationTokenCache;", "currentAuthenticationTokenField", "Lcom/facebook/AuthenticationToken;", "value", "getCurrentAuthenticationToken", "()Lcom/facebook/AuthenticationToken;", "(Lcom/facebook/AuthenticationToken;)V", "Companion", "CurrentAuthenticationTokenChangedBroadcastReceiver", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AuthenticationTokenManager {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000B\u001A\u00020\nH\u0007R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/AuthenticationTokenManager$Companion;", "", "()V", "ACTION_CURRENT_AUTHENTICATION_TOKEN_CHANGED", "", "EXTRA_NEW_AUTHENTICATION_TOKEN", "EXTRA_OLD_AUTHENTICATION_TOKEN", "SHARED_PREFERENCES_NAME", "TAG", "instanceField", "Lcom/facebook/AuthenticationTokenManager;", "getInstance", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final AuthenticationTokenManager getInstance() {
            AuthenticationTokenManager authenticationTokenManager0 = AuthenticationTokenManager.instanceField;
            if(authenticationTokenManager0 == null) {
                synchronized(this) {
                    AuthenticationTokenManager authenticationTokenManager1 = AuthenticationTokenManager.instanceField;
                    if(authenticationTokenManager1 == null) {
                        b b0 = b.a(FacebookSdk.getApplicationContext());
                        q.f(b0, "getInstance(applicationContext)");
                        AuthenticationTokenManager authenticationTokenManager2 = new AuthenticationTokenManager(b0, new AuthenticationTokenCache());
                        AuthenticationTokenManager.instanceField = authenticationTokenManager2;
                        authenticationTokenManager1 = authenticationTokenManager2;
                    }
                    return authenticationTokenManager1;
                }
            }
            return authenticationTokenManager0;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/facebook/AuthenticationTokenManager$CurrentAuthenticationTokenChangedBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "Lie/H;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class CurrentAuthenticationTokenChangedBroadcastReceiver extends BroadcastReceiver {
        @Override  // android.content.BroadcastReceiver
        public void onReceive(@NotNull Context context0, @NotNull Intent intent0) {
            q.g(context0, "context");
            q.g(intent0, "intent");
        }
    }

    @NotNull
    public static final String ACTION_CURRENT_AUTHENTICATION_TOKEN_CHANGED = "com.facebook.sdk.ACTION_CURRENT_AUTHENTICATION_TOKEN_CHANGED";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String EXTRA_NEW_AUTHENTICATION_TOKEN = "com.facebook.sdk.EXTRA_NEW_AUTHENTICATION_TOKEN";
    @NotNull
    public static final String EXTRA_OLD_AUTHENTICATION_TOKEN = "com.facebook.sdk.EXTRA_OLD_AUTHENTICATION_TOKEN";
    @NotNull
    public static final String SHARED_PREFERENCES_NAME = "com.facebook.AuthenticationTokenManager.SharedPreferences";
    @NotNull
    public static final String TAG = "AuthenticationTokenManager";
    @NotNull
    private final AuthenticationTokenCache authenticationTokenCache;
    @Nullable
    private AuthenticationToken currentAuthenticationTokenField;
    @Nullable
    private static AuthenticationTokenManager instanceField;
    @NotNull
    private final b localBroadcastManager;

    static {
        AuthenticationTokenManager.Companion = new Companion(null);
    }

    public AuthenticationTokenManager(@NotNull b b0, @NotNull AuthenticationTokenCache authenticationTokenCache0) {
        q.g(b0, "localBroadcastManager");
        q.g(authenticationTokenCache0, "authenticationTokenCache");
        super();
        this.localBroadcastManager = b0;
        this.authenticationTokenCache = authenticationTokenCache0;
    }

    public final void currentAuthenticationTokenChanged() {
        this.sendCurrentAuthenticationTokenChangedBroadcastIntent(this.getCurrentAuthenticationToken(), this.getCurrentAuthenticationToken());
    }

    @Nullable
    public final AuthenticationToken getCurrentAuthenticationToken() {
        return this.currentAuthenticationTokenField;
    }

    @NotNull
    public static final AuthenticationTokenManager getInstance() {
        return AuthenticationTokenManager.Companion.getInstance();
    }

    public final boolean loadCurrentAuthenticationToken() {
        AuthenticationToken authenticationToken0 = this.authenticationTokenCache.load();
        if(authenticationToken0 != null) {
            this.setCurrentAuthenticationToken(authenticationToken0, false);
            return true;
        }
        return false;
    }

    private final void sendCurrentAuthenticationTokenChangedBroadcastIntent(AuthenticationToken authenticationToken0, AuthenticationToken authenticationToken1) {
        Intent intent0 = new Intent(FacebookSdk.getApplicationContext(), CurrentAuthenticationTokenChangedBroadcastReceiver.class);
        intent0.setAction("com.facebook.sdk.ACTION_CURRENT_AUTHENTICATION_TOKEN_CHANGED");
        intent0.putExtra("com.facebook.sdk.EXTRA_OLD_AUTHENTICATION_TOKEN", authenticationToken0);
        intent0.putExtra("com.facebook.sdk.EXTRA_NEW_AUTHENTICATION_TOKEN", authenticationToken1);
        this.localBroadcastManager.c(intent0);
    }

    private final void setCurrentAuthenticationToken(AuthenticationToken authenticationToken0, boolean z) {
        AuthenticationToken authenticationToken1 = this.getCurrentAuthenticationToken();
        this.currentAuthenticationTokenField = authenticationToken0;
        if(z) {
            if(authenticationToken0 == null) {
                this.authenticationTokenCache.clear();
                Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
            }
            else {
                this.authenticationTokenCache.save(authenticationToken0);
            }
        }
        if(!Utility.areObjectsEqual(authenticationToken1, authenticationToken0)) {
            this.sendCurrentAuthenticationTokenChangedBroadcastIntent(authenticationToken1, authenticationToken0);
        }
    }

    public final void setCurrentAuthenticationToken(@Nullable AuthenticationToken authenticationToken0) {
        this.setCurrentAuthenticationToken(authenticationToken0, true);
    }
}

