package com.facebook.login;

import I7.k;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import androidx.fragment.app.I;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.AuthenticationToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import e.b;
import ie.H;
import java.util.List;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\'\u0018\u00002\u00020\u0001B\u0011\b\u0010\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\u0004\u0010\bJ\u001F\u0010\u000E\u001A\u00020\r2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0019\u0010\u0012\u001A\u00020\r2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0002\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0015\u001A\u00020\u0014H\u0002\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001A\u001A\u00020\u00192\u0006\u0010\n\u001A\u00020\tH&\u00A2\u0006\u0004\b\u001A\u0010\u001BJ)\u0010\u001F\u001A\u00020\u00162\u0006\u0010\u001C\u001A\u00020\u00192\u0006\u0010\u001D\u001A\u00020\u00192\b\u0010\u001E\u001A\u0004\u0018\u00010\u0014H\u0016\u00A2\u0006\u0004\b\u001F\u0010 J7\u0010%\u001A\u00020\r2\b\u0010\n\u001A\u0004\u0018\u00010\t2\b\u0010\"\u001A\u0004\u0018\u00010!2\b\u0010#\u001A\u0004\u0018\u00010!2\b\u0010$\u001A\u0004\u0018\u00010!H\u0014\u00A2\u0006\u0004\b%\u0010&J\u001F\u0010\'\u001A\u00020\r2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000BH\u0014\u00A2\u0006\u0004\b\'\u0010\u000FJ!\u0010(\u001A\u00020\r2\b\u0010\n\u001A\u0004\u0018\u00010\t2\u0006\u0010\u001E\u001A\u00020\u0014H\u0014\u00A2\u0006\u0004\b(\u0010)J\u001B\u0010*\u001A\u0004\u0018\u00010!2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0014\u00A2\u0006\u0004\b*\u0010+J\u001B\u0010,\u001A\u0004\u0018\u00010!2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0014\u00A2\u0006\u0004\b,\u0010+J!\u0010-\u001A\u00020\u00162\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\u0006\u0010\u001C\u001A\u00020\u0019H\u0014\u00A2\u0006\u0004\b-\u0010.R\u001A\u00100\u001A\u00020/8\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b0\u00101\u001A\u0004\b2\u00103\u00A8\u00064"}, d2 = {"Lcom/facebook/login/NativeAppLoginMethodHandler;", "Lcom/facebook/login/LoginMethodHandler;", "Lcom/facebook/login/LoginClient;", "loginClient", "<init>", "(Lcom/facebook/login/LoginClient;)V", "Landroid/os/Parcel;", "source", "(Landroid/os/Parcel;)V", "Lcom/facebook/login/LoginClient$Request;", "request", "Landroid/os/Bundle;", "extras", "Lie/H;", "processSuccessResponse", "(Lcom/facebook/login/LoginClient$Request;Landroid/os/Bundle;)V", "Lcom/facebook/login/LoginClient$Result;", "outcome", "completeLogin", "(Lcom/facebook/login/LoginClient$Result;)V", "Landroid/content/Intent;", "intent", "", "isCallable", "(Landroid/content/Intent;)Z", "", "tryAuthorize", "(Lcom/facebook/login/LoginClient$Request;)I", "requestCode", "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)Z", "", "error", "errorMessage", "errorCode", "handleResultError", "(Lcom/facebook/login/LoginClient$Request;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "handleResultOk", "handleResultCancel", "(Lcom/facebook/login/LoginClient$Request;Landroid/content/Intent;)V", "getError", "(Landroid/os/Bundle;)Ljava/lang/String;", "getErrorMessage", "tryIntent", "(Landroid/content/Intent;I)Z", "Lcom/facebook/AccessTokenSource;", "tokenSource", "Lcom/facebook/AccessTokenSource;", "getTokenSource", "()Lcom/facebook/AccessTokenSource;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public abstract class NativeAppLoginMethodHandler extends LoginMethodHandler {
    @NotNull
    private final AccessTokenSource tokenSource;

    public NativeAppLoginMethodHandler(@NotNull Parcel parcel0) {
        q.g(parcel0, "source");
        super(parcel0);
        this.tokenSource = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
    }

    public NativeAppLoginMethodHandler(@NotNull LoginClient loginClient0) {
        q.g(loginClient0, "loginClient");
        super(loginClient0);
        this.tokenSource = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
    }

    public static void a(NativeAppLoginMethodHandler nativeAppLoginMethodHandler0, Request loginClient$Request0, Bundle bundle0) {
        NativeAppLoginMethodHandler.processSuccessResponse$lambda$0(nativeAppLoginMethodHandler0, loginClient$Request0, bundle0);
    }

    private final void completeLogin(Result loginClient$Result0) {
        if(loginClient$Result0 != null) {
            this.getLoginClient().completeAndValidate(loginClient$Result0);
            return;
        }
        this.getLoginClient().tryNextHandler();
    }

    @Nullable
    public String getError(@Nullable Bundle bundle0) {
        if(bundle0 != null) {
            String s = bundle0.getString("error");
            if(s != null) {
                return s;
            }
        }
        return bundle0 == null ? null : bundle0.getString("error_type");
    }

    @Nullable
    public String getErrorMessage(@Nullable Bundle bundle0) {
        if(bundle0 != null) {
            String s = bundle0.getString("error_message");
            if(s != null) {
                return s;
            }
        }
        return bundle0 == null ? null : bundle0.getString("error_description");
    }

    @NotNull
    public AccessTokenSource getTokenSource() {
        return this.tokenSource;
    }

    public void handleResultCancel(@Nullable Request loginClient$Request0, @NotNull Intent intent0) {
        String s1;
        q.g(intent0, "data");
        Bundle bundle0 = intent0.getExtras();
        String s = this.getError(bundle0);
        if(bundle0 == null) {
            s1 = null;
        }
        else {
            Object object0 = bundle0.get("error_code");
            s1 = object0 == null ? null : object0.toString();
        }
        if(q.b("CONNECTION_FAILURE", s1)) {
            String s2 = this.getErrorMessage(bundle0);
            this.completeLogin(Result.Companion.createErrorResult(loginClient$Request0, s, s2, s1));
            return;
        }
        this.completeLogin(Result.Companion.createCancelResult(loginClient$Request0, s));
    }

    public void handleResultError(@Nullable Request loginClient$Request0, @Nullable String s, @Nullable String s1, @Nullable String s2) {
        if(s != null && s.equals("logged_out")) {
            CustomTabLoginMethodHandler.calledThroughLoggedOutAppSwitch = true;
            this.completeLogin(null);
            return;
        }
        if(p.d0(ServerProtocol.getErrorsProxyAuthDisabled(), s)) {
            this.completeLogin(null);
            return;
        }
        if(p.d0(ServerProtocol.getErrorsUserCanceled(), s)) {
            this.completeLogin(Result.Companion.createCancelResult(loginClient$Request0, null));
            return;
        }
        this.completeLogin(Result.Companion.createErrorResult(loginClient$Request0, s, s1, s2));
    }

    public void handleResultOk(@NotNull Request loginClient$Request0, @NotNull Bundle bundle0) {
        q.g(loginClient$Request0, "request");
        q.g(bundle0, "extras");
        try {
            AccessTokenSource accessTokenSource0 = this.getTokenSource();
            AccessToken accessToken0 = LoginMethodHandler.Companion.createAccessTokenFromWebBundle(loginClient$Request0.getPermissions(), bundle0, accessTokenSource0, loginClient$Request0.getApplicationId());
            AuthenticationToken authenticationToken0 = LoginMethodHandler.Companion.createAuthenticationTokenFromWebBundle(bundle0, loginClient$Request0.getNonce());
            this.completeLogin(Result.Companion.createCompositeTokenResult(loginClient$Request0, accessToken0, authenticationToken0));
        }
        catch(FacebookException facebookException0) {
            this.completeLogin(Companion.createErrorResult$default(Result.Companion, loginClient$Request0, null, facebookException0.getMessage(), null, 8, null));
        }
    }

    private final boolean isCallable(Intent intent0) {
        List list0 = FacebookSdk.getApplicationContext().getPackageManager().queryIntentActivities(intent0, 0x10000);
        q.f(list0, "getApplicationContext()\n…nager.MATCH_DEFAULT_ONLY)");
        return !list0.isEmpty();
    }

    @Override  // com.facebook.login.LoginMethodHandler
    public boolean onActivityResult(int v, int v1, @Nullable Intent intent0) {
        Request loginClient$Request0 = this.getLoginClient().getPendingRequest();
        if(intent0 == null) {
            this.completeLogin(Result.Companion.createCancelResult(loginClient$Request0, "Operation canceled"));
            return true;
        }
        if(v1 == 0) {
            this.handleResultCancel(loginClient$Request0, intent0);
            return true;
        }
        if(v1 != -1) {
            this.completeLogin(Companion.createErrorResult$default(Result.Companion, loginClient$Request0, "Unexpected resultCode from authorization.", null, null, 8, null));
            return true;
        }
        Bundle bundle0 = intent0.getExtras();
        if(bundle0 == null) {
            this.completeLogin(Companion.createErrorResult$default(Result.Companion, loginClient$Request0, "Unexpected null from returned authorization data.", null, null, 8, null));
            return true;
        }
        String s = this.getError(bundle0);
        Object object0 = bundle0.get("error_code");
        String s1 = object0 == null ? null : object0.toString();
        String s2 = this.getErrorMessage(bundle0);
        String s3 = bundle0.getString("e2e");
        if(!Utility.isNullOrEmpty(s3)) {
            this.logWebLoginCompleted(s3);
        }
        if(s == null && s1 == null && s2 == null && loginClient$Request0 != null) {
            this.processSuccessResponse(loginClient$Request0, bundle0);
            return true;
        }
        this.handleResultError(loginClient$Request0, s, s2, s1);
        return true;
    }

    private final void processSuccessResponse(Request loginClient$Request0, Bundle bundle0) {
        if(bundle0.containsKey("code") && !Utility.isNullOrEmpty(bundle0.getString("code"))) {
            FacebookSdk.getExecutor().execute(new k(this, loginClient$Request0, bundle0, 23));
            return;
        }
        this.handleResultOk(loginClient$Request0, bundle0);
    }

    private static final void processSuccessResponse$lambda$0(NativeAppLoginMethodHandler nativeAppLoginMethodHandler0, Request loginClient$Request0, Bundle bundle0) {
        q.g(nativeAppLoginMethodHandler0, "this$0");
        q.g(loginClient$Request0, "$request");
        q.g(bundle0, "$extras");
        try {
            nativeAppLoginMethodHandler0.handleResultOk(loginClient$Request0, nativeAppLoginMethodHandler0.processCodeExchange(loginClient$Request0, bundle0));
        }
        catch(FacebookServiceException facebookServiceException0) {
            FacebookRequestError facebookRequestError0 = facebookServiceException0.getRequestError();
            nativeAppLoginMethodHandler0.handleResultError(loginClient$Request0, facebookRequestError0.getErrorType(), facebookRequestError0.getErrorMessage(), String.valueOf(facebookRequestError0.getErrorCode()));
        }
        catch(FacebookException facebookException0) {
            nativeAppLoginMethodHandler0.handleResultError(loginClient$Request0, null, facebookException0.getMessage(), null);
        }
    }

    @Override  // com.facebook.login.LoginMethodHandler
    public abstract int tryAuthorize(@NotNull Request arg1);

    public boolean tryIntent(@Nullable Intent intent0, int v) {
        if(intent0 != null && this.isCallable(intent0)) {
            I i0 = this.getLoginClient().getFragment();
            H h0 = null;
            LoginFragment loginFragment0 = i0 instanceof LoginFragment ? ((LoginFragment)i0) : null;
            if(loginFragment0 != null) {
                b b0 = loginFragment0.getLauncher();
                if(b0 != null) {
                    b0.b(intent0);
                    h0 = H.a;
                }
            }
            return h0 != null;
        }
        return false;
    }
}

