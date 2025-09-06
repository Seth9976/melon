package com.facebook.internal;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import e.k;
import java.util.Arrays;
import java.util.Collection;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b:\n\u0002\u0010\u001E\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u00C6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00A2\u0006\u0002\u0010\u0002J\b\u0010;\u001A\u00020\u0004H\u0007J\b\u0010<\u001A\u00020\u0004H\u0007J\b\u0010=\u001A\u00020\u0004H\u0007J\u000E\u0010>\u001A\b\u0012\u0004\u0012\u00020\u00040?H\u0007J\u000E\u0010@\u001A\b\u0012\u0004\u0012\u00020\u00040?H\u0007J\b\u0010A\u001A\u00020\u0004H\u0007J\b\u0010B\u001A\u00020\u0004H\u0007J\b\u0010C\u001A\u00020\u0004H\u0007J\u0010\u0010D\u001A\u00020\u00042\u0006\u0010E\u001A\u00020\u0004H\u0007J\b\u0010F\u001A\u00020\u0004H\u0007J\b\u0010G\u001A\u00020\u0004H\u0007J$\u0010H\u001A\u0004\u0018\u00010I2\u0006\u0010J\u001A\u00020\u00042\u0006\u0010K\u001A\u00020L2\b\u0010M\u001A\u0004\u0018\u00010IH\u0007R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0018\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001A\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001B\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001C\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001D\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001E\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u001F\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010 \u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010!\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\"\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010#\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010$\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010%\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010&\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010\'\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010(\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010)\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010*\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010+\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010,\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010-\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010.\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u0010/\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u00100\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u00101\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u00102\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u00103\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u00104\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u000E\u00105\u001A\u00020\u0004X\u0082T\u00A2\u0006\u0002\n\u0000R\u000E\u00106\u001A\u00020\u0004X\u0082T\u00A2\u0006\u0002\n\u0000R\u000E\u00107\u001A\u00020\u0004X\u0082T\u00A2\u0006\u0002\n\u0000R\u000E\u00108\u001A\u00020\u0004X\u0086T\u00A2\u0006\u0002\n\u0000R\u0016\u00109\u001A\n :*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00A2\u0006\u0002\n\u0000\u00A8\u0006N"}, d2 = {"Lcom/facebook/internal/ServerProtocol;", "", "()V", "DIALOG_AUTHORITY_FORMAT", "", "DIALOG_CANCEL_URI", "DIALOG_PARAM_ACCESS_TOKEN", "DIALOG_PARAM_APP_ID", "DIALOG_PARAM_AUTHENTICATION_TOKEN", "DIALOG_PARAM_AUTH_TYPE", "DIALOG_PARAM_CBT", "DIALOG_PARAM_CCT_OVER_LOGGED_OUT_APP_SWITCH", "DIALOG_PARAM_CLIENT_ID", "DIALOG_PARAM_CODE_CHALLENGE", "DIALOG_PARAM_CODE_CHALLENGE_METHOD", "DIALOG_PARAM_CODE_REDIRECT_URI", "DIALOG_PARAM_CUSTOM_TABS_PREFETCHING", "DIALOG_PARAM_DEFAULT_AUDIENCE", "DIALOG_PARAM_DISPLAY", "DIALOG_PARAM_DISPLAY_TOUCH", "DIALOG_PARAM_E2E", "DIALOG_PARAM_FAIL_ON_LOGGED_OUT", "DIALOG_PARAM_FX_APP", "DIALOG_PARAM_IES", "DIALOG_PARAM_LEGACY_OVERRIDE", "DIALOG_PARAM_LOGIN_BEHAVIOR", "DIALOG_PARAM_MESSENGER_PAGE_ID", "DIALOG_PARAM_NONCE", "DIALOG_PARAM_REDIRECT_URI", "DIALOG_PARAM_RESET_MESSENGER_STATE", "DIALOG_PARAM_RESPONSE_TYPE", "DIALOG_PARAM_RETURN_SCOPES", "DIALOG_PARAM_SCOPE", "DIALOG_PARAM_SDK_VERSION", "DIALOG_PARAM_SKIP_DEDUPE", "DIALOG_PARAM_SSO_DEVICE", "DIALOG_PARAM_STATE", "DIALOG_PATH", "DIALOG_REDIRECT_CHROME_OS_URI", "DIALOG_REDIRECT_URI", "DIALOG_REREQUEST_AUTH_TYPE", "DIALOG_RESPONSE_TYPE_CODE", "DIALOG_RESPONSE_TYPE_ID_TOKEN_AND_SIGNED_REQUEST", "DIALOG_RESPONSE_TYPE_TOKEN_AND_SCOPES", "DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST", "DIALOG_RETURN_SCOPES_TRUE", "FALLBACK_DIALOG_DISPLAY_VALUE_TOUCH", "FALLBACK_DIALOG_PARAM_APP_ID", "FALLBACK_DIALOG_PARAM_BRIDGE_ARGS", "FALLBACK_DIALOG_PARAM_KEY_HASH", "FALLBACK_DIALOG_PARAM_METHOD_ARGS", "FALLBACK_DIALOG_PARAM_METHOD_RESULTS", "FALLBACK_DIALOG_PARAM_VERSION", "GAMING_DIALOG_AUTHORITY_FORMAT", "GRAPH_URL_FORMAT", "GRAPH_VIDEO_URL_FORMAT", "INSTAGRAM_OAUTH_PATH", "TAG", "kotlin.jvm.PlatformType", "getDefaultAPIVersion", "getDialogAuthority", "getErrorConnectionFailure", "getErrorsProxyAuthDisabled", "", "getErrorsUserCanceled", "getFacebookGraphUrlBase", "getGamingDialogAuthority", "getGraphUrlBase", "getGraphUrlBaseForSubdomain", "subdomain", "getGraphVideoUrlBase", "getInstagramDialogAuthority", "getQueryParamsForPlatformActivityIntentWebFallback", "Landroid/os/Bundle;", "callId", "version", "", "methodArgs", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ServerProtocol {
    @NotNull
    private static final String DIALOG_AUTHORITY_FORMAT = "m.%s";
    @NotNull
    public static final String DIALOG_CANCEL_URI = "fbconnect://cancel";
    @NotNull
    public static final String DIALOG_PARAM_ACCESS_TOKEN = "access_token";
    @NotNull
    public static final String DIALOG_PARAM_APP_ID = "app_id";
    @NotNull
    public static final String DIALOG_PARAM_AUTHENTICATION_TOKEN = "id_token";
    @NotNull
    public static final String DIALOG_PARAM_AUTH_TYPE = "auth_type";
    @NotNull
    public static final String DIALOG_PARAM_CBT = "cbt";
    @NotNull
    public static final String DIALOG_PARAM_CCT_OVER_LOGGED_OUT_APP_SWITCH = "cct_over_app_switch";
    @NotNull
    public static final String DIALOG_PARAM_CLIENT_ID = "client_id";
    @NotNull
    public static final String DIALOG_PARAM_CODE_CHALLENGE = "code_challenge";
    @NotNull
    public static final String DIALOG_PARAM_CODE_CHALLENGE_METHOD = "code_challenge_method";
    @NotNull
    public static final String DIALOG_PARAM_CODE_REDIRECT_URI = "code_redirect_uri";
    @NotNull
    public static final String DIALOG_PARAM_CUSTOM_TABS_PREFETCHING = "cct_prefetching";
    @NotNull
    public static final String DIALOG_PARAM_DEFAULT_AUDIENCE = "default_audience";
    @NotNull
    public static final String DIALOG_PARAM_DISPLAY = "display";
    @NotNull
    public static final String DIALOG_PARAM_DISPLAY_TOUCH = "touch";
    @NotNull
    public static final String DIALOG_PARAM_E2E = "e2e";
    @NotNull
    public static final String DIALOG_PARAM_FAIL_ON_LOGGED_OUT = "fail_on_logged_out";
    @NotNull
    public static final String DIALOG_PARAM_FX_APP = "fx_app";
    @NotNull
    public static final String DIALOG_PARAM_IES = "ies";
    @NotNull
    public static final String DIALOG_PARAM_LEGACY_OVERRIDE = "legacy_override";
    @NotNull
    public static final String DIALOG_PARAM_LOGIN_BEHAVIOR = "login_behavior";
    @NotNull
    public static final String DIALOG_PARAM_MESSENGER_PAGE_ID = "messenger_page_id";
    @NotNull
    public static final String DIALOG_PARAM_NONCE = "nonce";
    @NotNull
    public static final String DIALOG_PARAM_REDIRECT_URI = "redirect_uri";
    @NotNull
    public static final String DIALOG_PARAM_RESET_MESSENGER_STATE = "reset_messenger_state";
    @NotNull
    public static final String DIALOG_PARAM_RESPONSE_TYPE = "response_type";
    @NotNull
    public static final String DIALOG_PARAM_RETURN_SCOPES = "return_scopes";
    @NotNull
    public static final String DIALOG_PARAM_SCOPE = "scope";
    @NotNull
    public static final String DIALOG_PARAM_SDK_VERSION = "sdk";
    @NotNull
    public static final String DIALOG_PARAM_SKIP_DEDUPE = "skip_dedupe";
    @NotNull
    public static final String DIALOG_PARAM_SSO_DEVICE = "sso";
    @NotNull
    public static final String DIALOG_PARAM_STATE = "state";
    @NotNull
    public static final String DIALOG_PATH = "dialog/";
    @NotNull
    public static final String DIALOG_REDIRECT_CHROME_OS_URI = "fbconnect://chrome_os_success";
    @NotNull
    public static final String DIALOG_REDIRECT_URI = "fbconnect://success";
    @NotNull
    public static final String DIALOG_REREQUEST_AUTH_TYPE = "rerequest";
    @NotNull
    public static final String DIALOG_RESPONSE_TYPE_CODE = "code,signed_request,graph_domain";
    @NotNull
    public static final String DIALOG_RESPONSE_TYPE_ID_TOKEN_AND_SIGNED_REQUEST = "id_token,token,signed_request,graph_domain";
    @NotNull
    public static final String DIALOG_RESPONSE_TYPE_TOKEN_AND_SCOPES = "token,signed_request,graph_domain,granted_scopes";
    @NotNull
    public static final String DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST = "token,signed_request,graph_domain";
    @NotNull
    public static final String DIALOG_RETURN_SCOPES_TRUE = "true";
    @NotNull
    public static final String FALLBACK_DIALOG_DISPLAY_VALUE_TOUCH = "touch";
    @NotNull
    public static final String FALLBACK_DIALOG_PARAM_APP_ID = "app_id";
    @NotNull
    public static final String FALLBACK_DIALOG_PARAM_BRIDGE_ARGS = "bridge_args";
    @NotNull
    public static final String FALLBACK_DIALOG_PARAM_KEY_HASH = "android_key_hash";
    @NotNull
    public static final String FALLBACK_DIALOG_PARAM_METHOD_ARGS = "method_args";
    @NotNull
    public static final String FALLBACK_DIALOG_PARAM_METHOD_RESULTS = "method_results";
    @NotNull
    public static final String FALLBACK_DIALOG_PARAM_VERSION = "version";
    @NotNull
    private static final String GAMING_DIALOG_AUTHORITY_FORMAT = "%s";
    @NotNull
    private static final String GRAPH_URL_FORMAT = "https://graph.%s";
    @NotNull
    private static final String GRAPH_VIDEO_URL_FORMAT = "https://graph-video.%s";
    @NotNull
    public static final String INSTAGRAM_OAUTH_PATH = "oauth/authorize";
    @NotNull
    public static final ServerProtocol INSTANCE;
    private static final String TAG;

    static {
        ServerProtocol.INSTANCE = new ServerProtocol();
        ServerProtocol.TAG = "com.facebook.internal.ServerProtocol";
    }

    @NotNull
    public static final String getDefaultAPIVersion() [...] // Inlined contents

    // 去混淆评级： 低(20)
    @NotNull
    public static final String getDialogAuthority() [...] // 潜在的解密器

    @NotNull
    public static final String getErrorConnectionFailure() [...] // Inlined contents

    @NotNull
    public static final Collection getErrorsProxyAuthDisabled() {
        return k.A(new String[]{"service_disabled", "AndroidAuthKillSwitchException"});
    }

    @NotNull
    public static final Collection getErrorsUserCanceled() {
        return k.A(new String[]{"access_denied", "OAuthAccessDeniedException"});
    }

    // 去混淆评级： 低(20)
    @NotNull
    public static final String getFacebookGraphUrlBase() {
        return "https://graph.null";
    }

    // 去混淆评级： 低(20)
    @NotNull
    public static final String getGamingDialogAuthority() [...] // 潜在的解密器

    @NotNull
    public static final String getGraphUrlBase() {
        return String.format("https://graph.%s", Arrays.copyOf(new Object[]{FacebookSdk.getGraphDomain()}, 1));
    }

    @NotNull
    public static final String getGraphUrlBaseForSubdomain(@NotNull String s) {
        q.g(s, "subdomain");
        return String.format("https://graph.%s", Arrays.copyOf(new Object[]{s}, 1));
    }

    @NotNull
    public static final String getGraphVideoUrlBase() {
        return String.format("https://graph-video.%s", Arrays.copyOf(new Object[]{FacebookSdk.getGraphDomain()}, 1));
    }

    // 去混淆评级： 低(20)
    @NotNull
    public static final String getInstagramDialogAuthority() [...] // 潜在的解密器

    @Nullable
    public static final Bundle getQueryParamsForPlatformActivityIntentWebFallback(@NotNull String s, int v, @Nullable Bundle bundle0) {
        q.g(s, "callId");
        String s1 = FacebookSdk.getApplicationSignature(FacebookSdk.getApplicationContext());
        if(Utility.isNullOrEmpty(s1)) {
            return null;
        }
        Bundle bundle1 = Y.b("android_key_hash", s1);
        bundle1.putString("app_id", FacebookSdk.getApplicationId());
        bundle1.putInt("version", v);
        bundle1.putString("display", "touch");
        Bundle bundle2 = new Bundle();
        bundle2.putString("action_id", s);
        try {
            JSONObject jSONObject0 = BundleJSONConverter.convertToJSON(bundle2);
            if(bundle0 == null) {
                bundle0 = new Bundle();
            }
            JSONObject jSONObject1 = BundleJSONConverter.convertToJSON(bundle0);
            if(jSONObject0 != null && jSONObject1 != null) {
                bundle1.putString("bridge_args", jSONObject0.toString());
                bundle1.putString("method_args", jSONObject1.toString());
                return bundle1;
            }
            return null;
        }
        catch(JSONException jSONException0) {
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            q.f("com.facebook.internal.ServerProtocol", "TAG");
            Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, 6, "com.facebook.internal.ServerProtocol", "Error creating Url -- " + illegalArgumentException0);
            return null;
        }
        q.f("com.facebook.internal.ServerProtocol", "TAG");
        Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, 6, "com.facebook.internal.ServerProtocol", "Error creating Url -- " + jSONException0);
        return null;
    }
}

