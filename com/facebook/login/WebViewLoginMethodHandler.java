package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.Utility;
import com.facebook.internal.WebDialog.Builder;
import com.facebook.internal.WebDialog.OnCompleteListener;
import com.facebook.internal.WebDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 52\u00020\u0001:\u000265B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0018\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\u000F2\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\b\u0010\u0017\u001A\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ\u001F\u0010\u001E\u001A\u00020\f2\u0006\u0010\u001C\u001A\u00020\u00062\u0006\u0010\u001D\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u001E\u0010\u001FR$\u0010!\u001A\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b!\u0010\"\u001A\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010(\u001A\u0004\u0018\u00010\'8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b(\u0010)\u001A\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001A\u0010.\u001A\u00020\'8\u0016X\u0096D¢\u0006\f\n\u0004\b.\u0010)\u001A\u0004\b/\u0010+R\u001A\u00101\u001A\u0002008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b1\u00102\u001A\u0004\b3\u00104¨\u00067"}, d2 = {"Lcom/facebook/login/WebViewLoginMethodHandler;", "Lcom/facebook/login/WebLoginMethodHandler;", "Lcom/facebook/login/LoginClient;", "loginClient", "<init>", "(Lcom/facebook/login/LoginClient;)V", "Landroid/os/Parcel;", "source", "(Landroid/os/Parcel;)V", "", "needsInternetPermission", "()Z", "Lie/H;", "cancel", "()V", "Lcom/facebook/login/LoginClient$Request;", "request", "", "tryAuthorize", "(Lcom/facebook/login/LoginClient$Request;)I", "Landroid/os/Bundle;", "values", "Lcom/facebook/FacebookException;", "error", "onWebDialogComplete", "(Lcom/facebook/login/LoginClient$Request;Landroid/os/Bundle;Lcom/facebook/FacebookException;)V", "describeContents", "()I", "dest", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/facebook/internal/WebDialog;", "loginDialog", "Lcom/facebook/internal/WebDialog;", "getLoginDialog", "()Lcom/facebook/internal/WebDialog;", "setLoginDialog", "(Lcom/facebook/internal/WebDialog;)V", "", "e2e", "Ljava/lang/String;", "getE2e", "()Ljava/lang/String;", "setE2e", "(Ljava/lang/String;)V", "nameForLogging", "getNameForLogging", "Lcom/facebook/AccessTokenSource;", "tokenSource", "Lcom/facebook/AccessTokenSource;", "getTokenSource", "()Lcom/facebook/AccessTokenSource;", "Companion", "AuthDialogBuilder", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public class WebViewLoginMethodHandler extends WebLoginMethodHandler {
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001F\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0019\u001A\u00020\u001AH\u0016J\u0012\u0010\f\u001A\u00060\u0000R\u00020\u001B2\u0006\u0010\t\u001A\u00020\u0005J\u0012\u0010\u001C\u001A\u00060\u0000R\u00020\u001B2\u0006\u0010\u000E\u001A\u00020\u0005J\u0012\u0010\u001D\u001A\u00060\u0000R\u00020\u001B2\u0006\u0010\u0011\u001A\u00020\u0012J\u0012\u0010\u001E\u001A\u00060\u0000R\u00020\u001B2\u0006\u0010\u001F\u001A\u00020\u0012J\u0012\u0010 \u001A\u00060\u0000R\u00020\u001B2\u0006\u0010!\u001A\u00020\u0012J\u0012\u0010\"\u001A\u00060\u0000R\u00020\u001B2\u0006\u0010\u0013\u001A\u00020\u0014J\u0012\u0010#\u001A\u00060\u0000R\u00020\u001B2\u0006\u0010\u0017\u001A\u00020\u0018J\u0012\u0010$\u001A\u00060\u0000R\u00020\u001B2\u0006\u0010%\u001A\u00020\u0012R\u001A\u0010\t\u001A\u00020\u0005X\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u001A\u0010\u000E\u001A\u00020\u0005X\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u000B\"\u0004\b\u0010\u0010\rR\u000E\u0010\u0011\u001A\u00020\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0014X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0012X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0018X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/facebook/login/WebViewLoginMethodHandler$AuthDialogBuilder;", "Lcom/facebook/internal/WebDialog$Builder;", "context", "Landroid/content/Context;", "applicationId", "", "parameters", "Landroid/os/Bundle;", "(Lcom/facebook/login/WebViewLoginMethodHandler;Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)V", "authType", "getAuthType", "()Ljava/lang/String;", "setAuthType", "(Ljava/lang/String;)V", "e2e", "getE2e", "setE2e", "isFamilyLogin", "", "loginBehavior", "Lcom/facebook/login/LoginBehavior;", "redirect_uri", "shouldSkipDedupe", "targetApp", "Lcom/facebook/login/LoginTargetApp;", "build", "Lcom/facebook/internal/WebDialog;", "Lcom/facebook/login/WebViewLoginMethodHandler;", "setE2E", "setFamilyLogin", "setIsChromeOS", "isChromeOS", "setIsRerequest", "isRerequest", "setLoginBehavior", "setLoginTargetApp", "setShouldSkipDedupe", "shouldSkip", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public final class AuthDialogBuilder extends Builder {
        public String authType;
        public String e2e;
        private boolean isFamilyLogin;
        @NotNull
        private LoginBehavior loginBehavior;
        @NotNull
        private String redirect_uri;
        private boolean shouldSkipDedupe;
        @NotNull
        private LoginTargetApp targetApp;

        public AuthDialogBuilder(@NotNull Context context0, @NotNull String s, @NotNull Bundle bundle0) {
            q.g(context0, "context");
            q.g(s, "applicationId");
            q.g(bundle0, "parameters");
            WebViewLoginMethodHandler.this = webViewLoginMethodHandler0;
            super(context0, s, "oauth", bundle0);
            this.redirect_uri = "fbconnect://success";
            this.loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
            this.targetApp = LoginTargetApp.FACEBOOK;
        }

        @Override  // com.facebook.internal.WebDialog$Builder
        @NotNull
        public WebDialog build() {
            Bundle bundle0 = this.getParameters();
            q.e(bundle0, "null cannot be cast to non-null type android.os.Bundle");
            bundle0.putString("redirect_uri", this.redirect_uri);
            bundle0.putString("client_id", this.getApplicationId());
            bundle0.putString("e2e", this.getE2e());
            bundle0.putString("response_type", (this.targetApp == LoginTargetApp.INSTAGRAM ? "token,signed_request,graph_domain,granted_scopes" : "token,signed_request,graph_domain"));
            bundle0.putString("return_scopes", "true");
            bundle0.putString("auth_type", this.getAuthType());
            bundle0.putString("login_behavior", this.loginBehavior.name());
            if(this.isFamilyLogin) {
                bundle0.putString("fx_app", this.targetApp.toString());
            }
            if(this.shouldSkipDedupe) {
                bundle0.putString("skip_dedupe", "true");
            }
            Context context0 = this.getContext();
            q.e(context0, "null cannot be cast to non-null type android.content.Context");
            return WebDialog.Companion.newInstance(context0, "oauth", bundle0, this.getTheme(), this.targetApp, this.getListener());
        }

        @NotNull
        public final String getAuthType() {
            String s = this.authType;
            if(s != null) {
                return s;
            }
            q.m("authType");
            throw null;
        }

        @NotNull
        public final String getE2e() {
            String s = this.e2e;
            if(s != null) {
                return s;
            }
            q.m("e2e");
            throw null;
        }

        @NotNull
        public final AuthDialogBuilder setAuthType(@NotNull String s) {
            q.g(s, "authType");
            this.setAuthType(s);
            return this;
        }

        public final void setAuthType(@NotNull String s) {
            q.g(s, "<set-?>");
            this.authType = s;
        }

        @NotNull
        public final AuthDialogBuilder setE2E(@NotNull String s) {
            q.g(s, "e2e");
            this.setE2e(s);
            return this;
        }

        public final void setE2e(@NotNull String s) {
            q.g(s, "<set-?>");
            this.e2e = s;
        }

        @NotNull
        public final AuthDialogBuilder setFamilyLogin(boolean z) {
            this.isFamilyLogin = z;
            return this;
        }

        @NotNull
        public final AuthDialogBuilder setIsChromeOS(boolean z) {
            this.redirect_uri = z ? "fbconnect://chrome_os_success" : "fbconnect://success";
            return this;
        }

        @NotNull
        public final AuthDialogBuilder setIsRerequest(boolean z) {
            return this;
        }

        @NotNull
        public final AuthDialogBuilder setLoginBehavior(@NotNull LoginBehavior loginBehavior0) {
            q.g(loginBehavior0, "loginBehavior");
            this.loginBehavior = loginBehavior0;
            return this;
        }

        @NotNull
        public final AuthDialogBuilder setLoginTargetApp(@NotNull LoginTargetApp loginTargetApp0) {
            q.g(loginTargetApp0, "targetApp");
            this.targetApp = loginTargetApp0;
            return this;
        }

        @NotNull
        public final AuthDialogBuilder setShouldSkipDedupe(boolean z) {
            this.shouldSkipDedupe = z;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/facebook/login/WebViewLoginMethodHandler$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/WebViewLoginMethodHandler;", "OAUTH_DIALOG", "", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Parcelable.Creator CREATOR = null;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String OAUTH_DIALOG = "oauth";
    @Nullable
    private String e2e;
    @Nullable
    private WebDialog loginDialog;
    @NotNull
    private final String nameForLogging;
    @NotNull
    private final AccessTokenSource tokenSource;

    static {
        WebViewLoginMethodHandler.Companion = new Companion(null);
        WebViewLoginMethodHandler.CREATOR = new WebViewLoginMethodHandler.Companion.CREATOR.1();
    }

    public WebViewLoginMethodHandler(@NotNull Parcel parcel0) {
        q.g(parcel0, "source");
        super(parcel0);
        this.nameForLogging = "web_view";
        this.tokenSource = AccessTokenSource.WEB_VIEW;
        this.e2e = parcel0.readString();
    }

    public WebViewLoginMethodHandler(@NotNull LoginClient loginClient0) {
        q.g(loginClient0, "loginClient");
        super(loginClient0);
        this.nameForLogging = "web_view";
        this.tokenSource = AccessTokenSource.WEB_VIEW;
    }

    @Override  // com.facebook.login.LoginMethodHandler
    public void cancel() {
        WebDialog webDialog0 = this.loginDialog;
        if(webDialog0 != null) {
            webDialog0.cancel();
            this.loginDialog = null;
        }
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getE2e() {
        return this.e2e;
    }

    @Nullable
    public final WebDialog getLoginDialog() {
        return this.loginDialog;
    }

    @Override  // com.facebook.login.LoginMethodHandler
    @NotNull
    public String getNameForLogging() {
        return this.nameForLogging;
    }

    @Override  // com.facebook.login.WebLoginMethodHandler
    @NotNull
    public AccessTokenSource getTokenSource() {
        return this.tokenSource;
    }

    @Override  // com.facebook.login.LoginMethodHandler
    public boolean needsInternetPermission() {
        return true;
    }

    // 检测为 Lambda 实现
    public final void onWebDialogComplete(@NotNull Request loginClient$Request0, @Nullable Bundle bundle0, @Nullable FacebookException facebookException0) [...]

    public final void setE2e(@Nullable String s) {
        this.e2e = s;
    }

    public final void setLoginDialog(@Nullable WebDialog webDialog0) {
        this.loginDialog = webDialog0;
    }

    @Override  // com.facebook.login.LoginMethodHandler
    public int tryAuthorize(@NotNull Request loginClient$Request0) {
        q.g(loginClient$Request0, "request");
        Bundle bundle0 = this.getParameters(loginClient$Request0);
        com.facebook.login.WebViewLoginMethodHandler.tryAuthorize.listener.1 webViewLoginMethodHandler$tryAuthorize$listener$10 = (Bundle bundle0, FacebookException facebookException0) -> {
            q.g(this.$request, "request");
            super.onComplete(this.$request, bundle0, facebookException0);
        };
        this.e2e = "{\"init\":1757129021149}";
        this.addLoggingExtra("e2e", "{\"init\":1757129021149}");
        FragmentActivity fragmentActivity0 = this.getLoginClient().getActivity();
        if(fragmentActivity0 == null) {
            return 0;
        }
        boolean z = Utility.isChromeOS(fragmentActivity0);
        AuthDialogBuilder webViewLoginMethodHandler$AuthDialogBuilder0 = new AuthDialogBuilder(this, fragmentActivity0, loginClient$Request0.getApplicationId(), bundle0);
        String s = this.e2e;
        q.e(s, "null cannot be cast to non-null type kotlin.String");
        this.loginDialog = webViewLoginMethodHandler$AuthDialogBuilder0.setE2E(s).setIsChromeOS(z).setAuthType(loginClient$Request0.getAuthType()).setLoginBehavior(loginClient$Request0.getLoginBehavior()).setLoginTargetApp(loginClient$Request0.getLoginTargetApp()).setFamilyLogin(loginClient$Request0.isFamilyLogin()).setShouldSkipDedupe(loginClient$Request0.shouldSkipAccountDeduplication()).setOnCompleteListener(webViewLoginMethodHandler$tryAuthorize$listener$10).build();
        FacebookDialogFragment facebookDialogFragment0 = new FacebookDialogFragment();
        facebookDialogFragment0.setRetainInstance(true);
        facebookDialogFragment0.setInnerDialog(this.loginDialog);
        facebookDialogFragment0.show(fragmentActivity0.getSupportFragmentManager(), "FacebookDialogFragment");
        return 1;

        @Metadata(d1 = {"\u0000\u001D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/facebook/login/WebViewLoginMethodHandler$tryAuthorize$listener$1", "Lcom/facebook/internal/WebDialog$OnCompleteListener;", "Landroid/os/Bundle;", "values", "Lcom/facebook/FacebookException;", "error", "Lie/H;", "onComplete", "(Landroid/os/Bundle;Lcom/facebook/FacebookException;)V", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public final class com.facebook.login.WebViewLoginMethodHandler.tryAuthorize.listener.1 implements OnCompleteListener {
            public com.facebook.login.WebViewLoginMethodHandler.tryAuthorize.listener.1(WebViewLoginMethodHandler webViewLoginMethodHandler0, Request loginClient$Request0) {
            }

            @Override  // com.facebook.internal.WebDialog$OnCompleteListener
            public void onComplete(@Nullable Bundle bundle0, @Nullable FacebookException facebookException0) {
                WebViewLoginMethodHandler.this.onWebDialogComplete(this.$request, bundle0, facebookException0);
            }
        }

    }

    @Override  // com.facebook.login.LoginMethodHandler
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        super.writeToParcel(parcel0, v);
        parcel0.writeString(this.e2e);
    }
}

