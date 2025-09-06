package com.facebook.login;

import I7.k;
import Tf.v;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import com.facebook.AccessTokenSource;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.internal.CustomTab;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.InstagramCustomTab;
import com.facebook.internal.Utility;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 :2\u00020\u0001:\u0001:B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\u0004\u0010\bJ!\u0010\u000E\u001A\u00020\r2\b\u0010\n\u001A\u0004\u0018\u00010\t2\u0006\u0010\f\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0011\u001A\u00020\u0010H\u0002\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0015\u001A\u00020\tH\u0014\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0017\u001A\u0004\u0018\u00010\tH\u0014\u00A2\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u0019\u001A\u00020\u00182\u0006\u0010\f\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AJ)\u0010\u001F\u001A\u00020\u00122\u0006\u0010\u001B\u001A\u00020\u00182\u0006\u0010\u001C\u001A\u00020\u00182\b\u0010\u001E\u001A\u0004\u0018\u00010\u001DH\u0016\u00A2\u0006\u0004\b\u001F\u0010 J\u0017\u0010#\u001A\u00020\r2\u0006\u0010\"\u001A\u00020!H\u0016\u00A2\u0006\u0004\b#\u0010$J\u000F\u0010%\u001A\u00020\u0018H\u0016\u00A2\u0006\u0004\b%\u0010&J\u001F\u0010)\u001A\u00020\r2\u0006\u0010\'\u001A\u00020\u00062\u0006\u0010(\u001A\u00020\u0018H\u0016\u00A2\u0006\u0004\b)\u0010*R\u0018\u0010+\u001A\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001A\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b-\u0010,R\u0016\u0010.\u001A\u00020\t8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b.\u0010,R\u001A\u0010/\u001A\u00020\t8\u0016X\u0096D\u00A2\u0006\f\n\u0004\b/\u0010,\u001A\u0004\b0\u0010\u0016R\u001A\u00102\u001A\u0002018\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b2\u00103\u001A\u0004\b4\u00105R\u0014\u00107\u001A\u00020\t8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b6\u0010\u0016R\u0016\u00109\u001A\u0004\u0018\u00010\t8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b8\u0010\u0016\u00A8\u0006;"}, d2 = {"Lcom/facebook/login/CustomTabLoginMethodHandler;", "Lcom/facebook/login/WebLoginMethodHandler;", "Lcom/facebook/login/LoginClient;", "loginClient", "<init>", "(Lcom/facebook/login/LoginClient;)V", "Landroid/os/Parcel;", "source", "(Landroid/os/Parcel;)V", "", "url", "Lcom/facebook/login/LoginClient$Request;", "request", "Lie/H;", "onCustomTabComplete", "(Ljava/lang/String;Lcom/facebook/login/LoginClient$Request;)V", "Landroid/os/Bundle;", "values", "", "validateChallengeParam", "(Landroid/os/Bundle;)Z", "getRedirectUrl", "()Ljava/lang/String;", "getSSODevice", "", "tryAuthorize", "(Lcom/facebook/login/LoginClient$Request;)I", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)Z", "Lorg/json/JSONObject;", "param", "putChallengeParam", "(Lorg/json/JSONObject;)V", "describeContents", "()I", "dest", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "currentPackage", "Ljava/lang/String;", "expectedChallenge", "validRedirectURI", "nameForLogging", "getNameForLogging", "Lcom/facebook/AccessTokenSource;", "tokenSource", "Lcom/facebook/AccessTokenSource;", "getTokenSource", "()Lcom/facebook/AccessTokenSource;", "getDeveloperDefinedRedirectURI", "developerDefinedRedirectURI", "getChromePackage", "chromePackage", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class CustomTabLoginMethodHandler extends WebLoginMethodHandler {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001A\u00020\r8\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lcom/facebook/login/CustomTabLoginMethodHandler$Companion;", "", "()V", "API_EC_DIALOG_CANCEL", "", "CHALLENGE_LENGTH", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/CustomTabLoginMethodHandler;", "CUSTOM_TAB_REQUEST_CODE", "OAUTH_DIALOG", "", "calledThroughLoggedOutAppSwitch", "", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    private static final int API_EC_DIALOG_CANCEL = 4201;
    private static final int CHALLENGE_LENGTH = 20;
    @NotNull
    public static final Parcelable.Creator CREATOR = null;
    private static final int CUSTOM_TAB_REQUEST_CODE = 1;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String OAUTH_DIALOG = "oauth";
    public static boolean calledThroughLoggedOutAppSwitch;
    @Nullable
    private String currentPackage;
    @Nullable
    private String expectedChallenge;
    @NotNull
    private final String nameForLogging;
    @NotNull
    private final AccessTokenSource tokenSource;
    @NotNull
    private String validRedirectURI;

    static {
        CustomTabLoginMethodHandler.Companion = new Companion(null);
        CustomTabLoginMethodHandler.CREATOR = new CustomTabLoginMethodHandler.Companion.CREATOR.1();
    }

    public CustomTabLoginMethodHandler(@NotNull Parcel parcel0) {
        q.g(parcel0, "source");
        super(parcel0);
        this.nameForLogging = "custom_tab";
        this.tokenSource = AccessTokenSource.CHROME_CUSTOM_TAB;
        this.expectedChallenge = parcel0.readString();
        this.validRedirectURI = CustomTabUtils.getValidRedirectURI(this.getDeveloperDefinedRedirectURI());
    }

    public CustomTabLoginMethodHandler(@NotNull LoginClient loginClient0) {
        q.g(loginClient0, "loginClient");
        super(loginClient0);
        this.nameForLogging = "custom_tab";
        this.tokenSource = AccessTokenSource.CHROME_CUSTOM_TAB;
        this.expectedChallenge = "6pr8tv5t2ba0rrnmabfv";
        CustomTabLoginMethodHandler.calledThroughLoggedOutAppSwitch = false;
        this.validRedirectURI = CustomTabUtils.getValidRedirectURI(this.getDeveloperDefinedRedirectURI());
    }

    public static void a(CustomTabLoginMethodHandler customTabLoginMethodHandler0, Request loginClient$Request0, Bundle bundle0) {
        CustomTabLoginMethodHandler.onCustomTabComplete$lambda$0(customTabLoginMethodHandler0, loginClient$Request0, bundle0);
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private final String getChromePackage() {
        String s = this.currentPackage;
        if(s != null) {
            return s;
        }
        String s1 = CustomTabUtils.getChromePackage();
        this.currentPackage = s1;
        return s1;
    }

    private final String getDeveloperDefinedRedirectURI() {
        return super.getRedirectUrl();
    }

    @Override  // com.facebook.login.LoginMethodHandler
    @NotNull
    public String getNameForLogging() {
        return this.nameForLogging;
    }

    @Override  // com.facebook.login.LoginMethodHandler
    @NotNull
    public String getRedirectUrl() {
        return this.validRedirectURI;
    }

    @Override  // com.facebook.login.WebLoginMethodHandler
    @Nullable
    public String getSSODevice() {
        return "chrome_custom_tab";
    }

    @Override  // com.facebook.login.WebLoginMethodHandler
    @NotNull
    public AccessTokenSource getTokenSource() {
        return this.tokenSource;
    }

    @Override  // com.facebook.login.LoginMethodHandler
    public boolean onActivityResult(int v, int v1, @Nullable Intent intent0) {
        if(intent0 != null && intent0.getBooleanExtra("CustomTabMainActivity.no_activity_exception", false)) {
            return super.onActivityResult(v, v1, intent0);
        }
        if(v != 1) {
            return super.onActivityResult(v, v1, intent0);
        }
        String s = null;
        Request loginClient$Request0 = this.getLoginClient().getPendingRequest();
        if(loginClient$Request0 == null) {
            return false;
        }
        if(v1 == -1) {
            if(intent0 != null) {
                s = intent0.getStringExtra("CustomTabMainActivity.extra_url");
            }
            this.onCustomTabComplete(s, loginClient$Request0);
            return true;
        }
        super.onComplete(loginClient$Request0, null, new FacebookOperationCanceledException());
        return false;
    }

    private final void onCustomTabComplete(String s, Request loginClient$Request0) {
        if(s != null && (v.r0(s, "fbconnect://cct.", false) || v.r0(s, super.getRedirectUrl(), false))) {
            Uri uri0 = Uri.parse(s);
            Bundle bundle0 = Utility.parseUrlQueryString(uri0.getQuery());
            bundle0.putAll(Utility.parseUrlQueryString(uri0.getFragment()));
            if(!this.validateChallengeParam(bundle0)) {
                super.onComplete(loginClient$Request0, null, new FacebookException("Invalid state parameter"));
                return;
            }
            String s1 = bundle0.getString("error");
            if(s1 == null) {
                s1 = bundle0.getString("error_type");
            }
            String s2 = bundle0.getString("error_msg");
            if(s2 == null) {
                s2 = bundle0.getString("error_message");
            }
            if(s2 == null) {
                s2 = bundle0.getString("error_description");
            }
            String s3 = bundle0.getString("error_code");
            int v = -1;
            if(s3 != null) {
                try {
                    v = Integer.parseInt(s3);
                }
                catch(NumberFormatException unused_ex) {
                }
            }
            if(Utility.isNullOrEmpty(s1) && Utility.isNullOrEmpty(s2) && v == -1) {
                if(bundle0.containsKey("access_token")) {
                    super.onComplete(loginClient$Request0, bundle0, null);
                    return;
                }
                FacebookSdk.getExecutor().execute(new k(this, loginClient$Request0, bundle0, 22));
                return;
            }
            if(s1 != null && (s1.equals("access_denied") || s1.equals("OAuthAccessDeniedException"))) {
                super.onComplete(loginClient$Request0, null, new FacebookOperationCanceledException());
                return;
            }
            if(v == 4201) {
                super.onComplete(loginClient$Request0, null, new FacebookOperationCanceledException());
                return;
            }
            super.onComplete(loginClient$Request0, null, new FacebookServiceException(new FacebookRequestError(v, s1, s2), s2));
        }
    }

    private static final void onCustomTabComplete$lambda$0(CustomTabLoginMethodHandler customTabLoginMethodHandler0, Request loginClient$Request0, Bundle bundle0) {
        q.g(customTabLoginMethodHandler0, "this$0");
        q.g(loginClient$Request0, "$request");
        q.g(bundle0, "$values");
        try {
            customTabLoginMethodHandler0.onComplete(loginClient$Request0, customTabLoginMethodHandler0.processCodeExchange(loginClient$Request0, bundle0), null);
        }
        catch(FacebookException facebookException0) {
            customTabLoginMethodHandler0.onComplete(loginClient$Request0, null, facebookException0);
        }
    }

    @Override  // com.facebook.login.LoginMethodHandler
    public void putChallengeParam(@NotNull JSONObject jSONObject0) {
        q.g(jSONObject0, "param");
        jSONObject0.put("7_challenge", this.expectedChallenge);
    }

    @Override  // com.facebook.login.LoginMethodHandler
    public int tryAuthorize(@NotNull Request loginClient$Request0) {
        q.g(loginClient$Request0, "request");
        LoginClient loginClient0 = this.getLoginClient();
        if(this.getRedirectUrl().length() == 0) {
            return 0;
        }
        Bundle bundle0 = this.addExtraParameters(this.getParameters(loginClient$Request0), loginClient$Request0);
        if(CustomTabLoginMethodHandler.calledThroughLoggedOutAppSwitch) {
            bundle0.putString("cct_over_app_switch", "1");
        }
        if(FacebookSdk.hasCustomTabsPrefetching) {
            if(loginClient$Request0.isInstagramLogin()) {
                Uri uri0 = InstagramCustomTab.Companion.getURIForAction("oauth", bundle0);
                CustomTabPrefetchHelper.Companion.mayLaunchUrl(uri0);
            }
            else {
                Uri uri1 = CustomTab.Companion.getURIForAction("oauth", bundle0);
                CustomTabPrefetchHelper.Companion.mayLaunchUrl(uri1);
            }
        }
        FragmentActivity fragmentActivity0 = loginClient0.getActivity();
        if(fragmentActivity0 != null) {
            Intent intent0 = new Intent(fragmentActivity0, CustomTabMainActivity.class);
            intent0.putExtra("CustomTabMainActivity.extra_action", "oauth");
            intent0.putExtra("CustomTabMainActivity.extra_params", bundle0);
            intent0.putExtra("CustomTabMainActivity.extra_chromePackage", this.getChromePackage());
            intent0.putExtra("CustomTabMainActivity.extra_targetApp", loginClient$Request0.getLoginTargetApp().toString());
            I i0 = loginClient0.getFragment();
            if(i0 != null) {
                i0.startActivityForResult(intent0, 1);
            }
            return 1;
        }
        return 0;
    }

    private final boolean validateChallengeParam(Bundle bundle0) {
        try {
            String s = bundle0.getString("state");
            return s == null ? false : q.b(new JSONObject(s).getString("7_challenge"), this.expectedChallenge);
        }
        catch(JSONException unused_ex) {
            return false;
        }
    }

    @Override  // com.facebook.login.LoginMethodHandler
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        super.writeToParcel(parcel0, v);
        parcel0.writeString(this.expectedChallenge);
    }
}

