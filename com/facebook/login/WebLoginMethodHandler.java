package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.AuthenticationToken;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.internal.Utility;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\'\u0018\u0000 $2\u00020\u0001:\u0001$B\u0011\b\u0010\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u0011\u0010\n\u001A\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\tH\u0002¢\u0006\u0004\b\u000E\u0010\u000FJ\u0011\u0010\u0010\u001A\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u0010\u0010\u000BJ\u0017\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0012\u001A\u00020\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u001F\u0010\u0017\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u00132\u0006\u0010\u0012\u001A\u00020\u0011H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001C\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\u00112\b\u0010\u0019\u001A\u0004\u0018\u00010\u00132\b\u0010\u001B\u001A\u0004\u0018\u00010\u001AH\u0017¢\u0006\u0004\b\u001C\u0010\u001DR\u0018\u0010\u001E\u001A\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001E\u0010\u001FR\u0014\u0010#\u001A\u00020 8&X¦\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/facebook/login/WebLoginMethodHandler;", "Lcom/facebook/login/LoginMethodHandler;", "Lcom/facebook/login/LoginClient;", "loginClient", "<init>", "(Lcom/facebook/login/LoginClient;)V", "Landroid/os/Parcel;", "source", "(Landroid/os/Parcel;)V", "", "loadCookieToken", "()Ljava/lang/String;", "token", "Lie/H;", "saveCookieToken", "(Ljava/lang/String;)V", "getSSODevice", "Lcom/facebook/login/LoginClient$Request;", "request", "Landroid/os/Bundle;", "getParameters", "(Lcom/facebook/login/LoginClient$Request;)Landroid/os/Bundle;", "parameters", "addExtraParameters", "(Landroid/os/Bundle;Lcom/facebook/login/LoginClient$Request;)Landroid/os/Bundle;", "values", "Lcom/facebook/FacebookException;", "error", "onComplete", "(Lcom/facebook/login/LoginClient$Request;Landroid/os/Bundle;Lcom/facebook/FacebookException;)V", "e2e", "Ljava/lang/String;", "Lcom/facebook/AccessTokenSource;", "getTokenSource", "()Lcom/facebook/AccessTokenSource;", "tokenSource", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public abstract class WebLoginMethodHandler extends LoginMethodHandler {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/login/WebLoginMethodHandler$Companion;", "", "()V", "WEB_VIEW_AUTH_HANDLER_STORE", "", "WEB_VIEW_AUTH_HANDLER_TOKEN_KEY", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String WEB_VIEW_AUTH_HANDLER_STORE = "com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY";
    @NotNull
    private static final String WEB_VIEW_AUTH_HANDLER_TOKEN_KEY = "TOKEN";
    @Nullable
    private String e2e;

    static {
        WebLoginMethodHandler.Companion = new Companion(null);
    }

    public WebLoginMethodHandler(@NotNull Parcel parcel0) {
        q.g(parcel0, "source");
        super(parcel0);
    }

    public WebLoginMethodHandler(@NotNull LoginClient loginClient0) {
        q.g(loginClient0, "loginClient");
        super(loginClient0);
    }

    @NotNull
    public Bundle addExtraParameters(@NotNull Bundle bundle0, @NotNull Request loginClient$Request0) {
        q.g(bundle0, "parameters");
        q.g(loginClient$Request0, "request");
        bundle0.putString("redirect_uri", this.getRedirectUrl());
        if(loginClient$Request0.isInstagramLogin()) {
            bundle0.putString("app_id", loginClient$Request0.getApplicationId());
        }
        else {
            bundle0.putString("client_id", loginClient$Request0.getApplicationId());
        }
        bundle0.putString("e2e", "{\"init\":1757129017239}");
        if(loginClient$Request0.isInstagramLogin()) {
            bundle0.putString("response_type", "token,signed_request,graph_domain,granted_scopes");
        }
        else {
            if(loginClient$Request0.getPermissions().contains("openid")) {
                bundle0.putString("nonce", loginClient$Request0.getNonce());
            }
            bundle0.putString("response_type", "id_token,token,signed_request,graph_domain");
        }
        bundle0.putString("code_challenge", loginClient$Request0.getCodeChallenge());
        CodeChallengeMethod codeChallengeMethod0 = loginClient$Request0.getCodeChallengeMethod();
        bundle0.putString("code_challenge_method", (codeChallengeMethod0 == null ? null : codeChallengeMethod0.name()));
        bundle0.putString("return_scopes", "true");
        bundle0.putString("auth_type", loginClient$Request0.getAuthType());
        bundle0.putString("login_behavior", loginClient$Request0.getLoginBehavior().name());
        bundle0.putString("sdk", "android-18.1.3");
        if(this.getSSODevice() != null) {
            bundle0.putString("sso", this.getSSODevice());
        }
        String s = "0";
        bundle0.putString("cct_prefetching", "0");
        if(loginClient$Request0.isFamilyLogin()) {
            bundle0.putString("fx_app", loginClient$Request0.getLoginTargetApp().toString());
        }
        if(loginClient$Request0.shouldSkipAccountDeduplication()) {
            bundle0.putString("skip_dedupe", "true");
        }
        if(loginClient$Request0.getMessengerPageId() != null) {
            bundle0.putString("messenger_page_id", loginClient$Request0.getMessengerPageId());
            if(loginClient$Request0.getResetMessengerState()) {
                s = "1";
            }
            bundle0.putString("reset_messenger_state", s);
        }
        return bundle0;
    }

    @NotNull
    public Bundle getParameters(@NotNull Request loginClient$Request0) {
        q.g(loginClient$Request0, "request");
        Bundle bundle0 = new Bundle();
        if(!Utility.isNullOrEmpty(loginClient$Request0.getPermissions())) {
            String s = TextUtils.join(",", loginClient$Request0.getPermissions());
            bundle0.putString("scope", s);
            this.addLoggingExtra("scope", s);
        }
        bundle0.putString("default_audience", (loginClient$Request0.getDefaultAudience() == null ? DefaultAudience.NONE : loginClient$Request0.getDefaultAudience()).getNativeProtocolAudience());
        bundle0.putString("state", this.getClientState(loginClient$Request0.getAuthId()));
        AccessToken accessToken0 = AccessToken.Companion.getCurrentAccessToken();
        String s1 = accessToken0 == null ? null : accessToken0.getToken();
        String s2 = "0";
        if(s1 == null || !s1.equals(this.loadCookieToken())) {
            FragmentActivity fragmentActivity0 = this.getLoginClient().getActivity();
            if(fragmentActivity0 != null) {
                Utility.clearFacebookCookies(fragmentActivity0);
            }
            this.addLoggingExtra("access_token", "0");
        }
        else {
            bundle0.putString("access_token", s1);
            this.addLoggingExtra("access_token", "1");
        }
        bundle0.putString("cbt", "1757129017273");
        if(FacebookSdk.getAutoLogAppEventsEnabled()) {
            s2 = "1";
        }
        bundle0.putString("ies", s2);
        return bundle0;
    }

    @Nullable
    public String getSSODevice() {
        return null;
    }

    @NotNull
    public abstract AccessTokenSource getTokenSource();

    private final String loadCookieToken() {
        Context context0 = this.getLoginClient().getActivity();
        if(context0 == null) {
            context0 = FacebookSdk.getApplicationContext();
        }
        return context0.getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).getString("TOKEN", "");
    }

    public void onComplete(@NotNull Request loginClient$Request0, @Nullable Bundle bundle0, @Nullable FacebookException facebookException0) {
        String s1;
        Result loginClient$Result0;
        q.g(loginClient$Request0, "request");
        LoginClient loginClient0 = this.getLoginClient();
        this.e2e = null;
        if(bundle0 != null) {
            if(bundle0.containsKey("e2e")) {
                this.e2e = bundle0.getString("e2e");
            }
            try {
                AccessTokenSource accessTokenSource0 = this.getTokenSource();
                AccessToken accessToken0 = LoginMethodHandler.Companion.createAccessTokenFromWebBundle(loginClient$Request0.getPermissions(), bundle0, accessTokenSource0, loginClient$Request0.getApplicationId());
                AuthenticationToken authenticationToken0 = LoginMethodHandler.Companion.createAuthenticationTokenFromWebBundle(bundle0, loginClient$Request0.getNonce());
                loginClient$Result0 = Result.Companion.createCompositeTokenResult(loginClient0.getPendingRequest(), accessToken0, authenticationToken0);
                if(loginClient0.getActivity() != null) {
                    try {
                        CookieSyncManager.createInstance(loginClient0.getActivity()).sync();
                    }
                    catch(Exception unused_ex) {
                    }
                    if(accessToken0 != null) {
                        this.saveCookieToken(accessToken0.getToken());
                    }
                }
            }
            catch(FacebookException facebookException1) {
                loginClient$Result0 = com.facebook.login.LoginClient.Result.Companion.createErrorResult$default(Result.Companion, loginClient0.getPendingRequest(), null, facebookException1.getMessage(), null, 8, null);
            }
        }
        else if(facebookException0 instanceof FacebookOperationCanceledException) {
            loginClient$Result0 = Result.Companion.createCancelResult(loginClient0.getPendingRequest(), "User canceled log in.");
        }
        else {
            this.e2e = null;
            String s = facebookException0 == null ? null : facebookException0.getMessage();
            if(facebookException0 instanceof FacebookServiceException) {
                FacebookRequestError facebookRequestError0 = ((FacebookServiceException)facebookException0).getRequestError();
                s1 = String.valueOf(facebookRequestError0.getErrorCode());
                s = facebookRequestError0.toString();
            }
            else {
                s1 = null;
            }
            loginClient$Result0 = Result.Companion.createErrorResult(loginClient0.getPendingRequest(), null, s, s1);
        }
        if(!Utility.isNullOrEmpty(this.e2e)) {
            this.logWebLoginCompleted(this.e2e);
        }
        loginClient0.completeAndValidate(loginClient$Result0);
    }

    private final void saveCookieToken(String s) {
        Context context0 = this.getLoginClient().getActivity();
        if(context0 == null) {
            context0 = FacebookSdk.getApplicationContext();
        }
        context0.getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).edit().putString("TOKEN", s).apply();
    }
}

