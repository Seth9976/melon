package com.facebook.login;

import Tf.a;
import Tf.o;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.AuthenticationToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.Utility;
import e.k;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import je.C;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u000E\b\'\u0018\u0000 B2\u00020\u0001:\u0001BB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0014\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\u0004\u0010\bJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\tH&\u00A2\u0006\u0004\b\f\u0010\rJ)\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000B2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0015\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u000F\u0010\u0018\u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001C\u001A\u00020\u00172\u0006\u0010\u001B\u001A\u00020\u001AH\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u000F\u0010\u001F\u001A\u00020\u001EH\u0014\u00A2\u0006\u0004\b\u001F\u0010 J\u0017\u0010\"\u001A\u00020\u001E2\u0006\u0010!\u001A\u00020\u001EH\u0014\u00A2\u0006\u0004\b\"\u0010#J#\u0010\'\u001A\u00020\u00172\b\u0010$\u001A\u0004\u0018\u00010\u001E2\b\u0010&\u001A\u0004\u0018\u00010%H\u0014\u00A2\u0006\u0004\b\'\u0010(J\u0019\u0010*\u001A\u00020\u00172\b\u0010)\u001A\u0004\u0018\u00010\u001EH\u0014\u00A2\u0006\u0004\b*\u0010+J\u001F\u0010.\u001A\u00020,2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010-\u001A\u00020,H\u0014\u00A2\u0006\u0004\b.\u0010/J\u001F\u00102\u001A\u00020\u00172\u0006\u00100\u001A\u00020\u00062\u0006\u00101\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b2\u00103J\u000F\u00104\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b4\u0010\u0016R4\u00106\u001A\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u001E\u0012\u0006\u0012\u0004\u0018\u00010\u001E\u0018\u0001058\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b6\u00107\u001A\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010\u0003\u001A\u00020\u00028\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\b\u0003\u0010<\u001A\u0004\b=\u0010>\"\u0004\b?\u0010\u0005R\u0014\u0010A\u001A\u00020\u001E8&X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b@\u0010 \u00A8\u0006C"}, d2 = {"Lcom/facebook/login/LoginMethodHandler;", "Landroid/os/Parcelable;", "Lcom/facebook/login/LoginClient;", "loginClient", "<init>", "(Lcom/facebook/login/LoginClient;)V", "Landroid/os/Parcel;", "source", "(Landroid/os/Parcel;)V", "Lcom/facebook/login/LoginClient$Request;", "request", "", "tryAuthorize", "(Lcom/facebook/login/LoginClient$Request;)I", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "", "onActivityResult", "(IILandroid/content/Intent;)Z", "needsInternetPermission", "()Z", "Lie/H;", "cancel", "()V", "Lorg/json/JSONObject;", "param", "putChallengeParam", "(Lorg/json/JSONObject;)V", "", "getRedirectUrl", "()Ljava/lang/String;", "authId", "getClientState", "(Ljava/lang/String;)Ljava/lang/String;", "key", "", "value", "addLoggingExtra", "(Ljava/lang/String;Ljava/lang/Object;)V", "e2e", "logWebLoginCompleted", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "values", "processCodeExchange", "(Lcom/facebook/login/LoginClient$Request;Landroid/os/Bundle;)Landroid/os/Bundle;", "dest", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "shouldKeepTrackOfMultipleIntents", "", "methodLoggingExtras", "Ljava/util/Map;", "getMethodLoggingExtras", "()Ljava/util/Map;", "setMethodLoggingExtras", "(Ljava/util/Map;)V", "Lcom/facebook/login/LoginClient;", "getLoginClient", "()Lcom/facebook/login/LoginClient;", "setLoginClient", "getNameForLogging", "nameForLogging", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public abstract class LoginMethodHandler implements Parcelable {
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0007\u001A\u0004\u0018\u00010\b2\u0006\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\f2\u0006\u0010\r\u001A\u00020\u0004H\u0007J6\u0010\u000E\u001A\u0004\u0018\u00010\b2\u0010\u0010\u000F\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00102\u0006\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\f2\u0006\u0010\r\u001A\u00020\u0004H\u0007J\u001C\u0010\u0011\u001A\u0004\u0018\u00010\u00122\u0006\u0010\t\u001A\u00020\n2\b\u0010\u0013\u001A\u0004\u0018\u00010\u0004H\u0007J\u001C\u0010\u0014\u001A\u0004\u0018\u00010\u00122\u0006\u0010\t\u001A\u00020\n2\b\u0010\u0013\u001A\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0015\u001A\u00020\u00042\b\u0010\u0016\u001A\u0004\u0018\u00010\u0004H\u0007R\u000E\u0010\u0003\u001A\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/facebook/login/LoginMethodHandler$Companion;", "", "()V", "NO_SIGNED_REQUEST_ERROR_MESSAGE", "", "NO_USER_ID_ERROR_MESSAGE", "USER_CANCELED_LOG_IN_ERROR_MESSAGE", "createAccessTokenFromNativeLogin", "Lcom/facebook/AccessToken;", "bundle", "Landroid/os/Bundle;", "source", "Lcom/facebook/AccessTokenSource;", "applicationId", "createAccessTokenFromWebBundle", "requestedPermissions", "", "createAuthenticationTokenFromNativeLogin", "Lcom/facebook/AuthenticationToken;", "expectedNonce", "createAuthenticationTokenFromWebBundle", "getUserIDFromSignedRequest", "signedRequest", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @Nullable
        public final AccessToken createAccessTokenFromNativeLogin(@NotNull Bundle bundle0, @Nullable AccessTokenSource accessTokenSource0, @NotNull String s) {
            q.g(bundle0, "bundle");
            q.g(s, "applicationId");
            Date date0 = Utility.getBundleLongAsDate(bundle0, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", new Date(0L));
            ArrayList arrayList0 = bundle0.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
            String s1 = bundle0.getString("com.facebook.platform.extra.ACCESS_TOKEN");
            Date date1 = Utility.getBundleLongAsDate(bundle0, "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME", new Date(0L));
            if(s1 != null && s1.length() != 0) {
                String s2 = bundle0.getString("com.facebook.platform.extra.USER_ID");
                if(s2 != null && s2.length() != 0) {
                    String s3 = bundle0.getString("graph_domain");
                    return new AccessToken(s1, s, s2, arrayList0, null, null, accessTokenSource0, date0, new Date(), date1, s3);
                }
            }
            return null;
        }

        @Nullable
        public final AccessToken createAccessTokenFromWebBundle(@Nullable Collection collection0, @NotNull Bundle bundle0, @Nullable AccessTokenSource accessTokenSource0, @NotNull String s) {
            ArrayList arrayList1;
            ArrayList arrayList0;
            q.g(bundle0, "bundle");
            q.g(s, "applicationId");
            Date date0 = Utility.getBundleLongAsDate(bundle0, "expires_in", new Date());
            String s1 = bundle0.getString("access_token");
            if(s1 != null) {
                Date date1 = Utility.getBundleLongAsDate(bundle0, "data_access_expiration_time", new Date(0L));
                String s2 = bundle0.getString("granted_scopes");
                if(s2 != null && s2.length() > 0) {
                    String[] arr_s = (String[])o.R0(s2, new String[]{","}, 0, 6).toArray(new String[0]);
                    collection0 = k.e(Arrays.copyOf(arr_s, arr_s.length));
                }
                String s3 = bundle0.getString("denied_scopes");
                if(s3 == null || s3.length() <= 0) {
                    arrayList0 = null;
                }
                else {
                    String[] arr_s1 = (String[])o.R0(s3, new String[]{","}, 0, 6).toArray(new String[0]);
                    arrayList0 = k.e(Arrays.copyOf(arr_s1, arr_s1.length));
                }
                String s4 = bundle0.getString("expired_scopes");
                if(s4 == null || s4.length() <= 0) {
                    arrayList1 = null;
                }
                else {
                    String[] arr_s2 = (String[])o.R0(s4, new String[]{","}, 0, 6).toArray(new String[0]);
                    arrayList1 = k.e(Arrays.copyOf(arr_s2, arr_s2.length));
                }
                if(!Utility.isNullOrEmpty(s1)) {
                    String s5 = bundle0.getString("graph_domain");
                    return new AccessToken(s1, s, this.getUserIDFromSignedRequest(bundle0.getString("signed_request")), collection0, arrayList0, arrayList1, accessTokenSource0, date0, new Date(), date1, s5);
                }
            }
            return null;
        }

        @Nullable
        public final AuthenticationToken createAuthenticationTokenFromNativeLogin(@NotNull Bundle bundle0, @Nullable String s) {
            q.g(bundle0, "bundle");
            String s1 = bundle0.getString("com.facebook.platform.extra.ID_TOKEN");
            if(s1 != null && s1.length() != 0 && s != null && s.length() != 0) {
                try {
                    return new AuthenticationToken(s1, s);
                }
                catch(Exception exception0) {
                    throw new FacebookException(exception0.getMessage());
                }
            }
            return null;
        }

        @Nullable
        public final AuthenticationToken createAuthenticationTokenFromWebBundle(@NotNull Bundle bundle0, @Nullable String s) {
            q.g(bundle0, "bundle");
            String s1 = bundle0.getString("id_token");
            if(s1 != null && s1.length() != 0 && s != null && s.length() != 0) {
                try {
                    return new AuthenticationToken(s1, s);
                }
                catch(Exception exception0) {
                    throw new FacebookException(exception0.getMessage(), exception0);
                }
            }
            return null;
        }

        @NotNull
        public final String getUserIDFromSignedRequest(@Nullable String s) {
            if(s == null || s.length() == 0) {
                throw new FacebookException("Authorization response does not contain the signed_request");
            }
            try {
                String[] arr_s = (String[])o.R0(s, new String[]{"."}, 0, 6).toArray(new String[0]);
                if(arr_s.length == 2) {
                    byte[] arr_b = Base64.decode(arr_s[1], 0);
                    q.f(arr_b, "data");
                    String s1 = new JSONObject(new String(arr_b, a.a)).getString("user_id");
                    q.f(s1, "jsonObject.getString(\"user_id\")");
                    return s1;
                }
            }
            catch(UnsupportedEncodingException | JSONException unused_ex) {
            }
            throw new FacebookException("Failed to retrieve user_id from signed_request");
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String NO_SIGNED_REQUEST_ERROR_MESSAGE = "Authorization response does not contain the signed_request";
    @NotNull
    public static final String NO_USER_ID_ERROR_MESSAGE = "Failed to retrieve user_id from signed_request";
    @NotNull
    public static final String USER_CANCELED_LOG_IN_ERROR_MESSAGE = "User canceled log in.";
    public LoginClient loginClient;
    @Nullable
    private Map methodLoggingExtras;

    static {
        LoginMethodHandler.Companion = new Companion(null);
    }

    public LoginMethodHandler(@NotNull Parcel parcel0) {
        q.g(parcel0, "source");
        super();
        Map map0 = Utility.readStringMapFromParcel(parcel0);
        this.methodLoggingExtras = map0 == null ? null : C.a0(map0);
    }

    public LoginMethodHandler(@NotNull LoginClient loginClient0) {
        q.g(loginClient0, "loginClient");
        super();
        this.setLoginClient(loginClient0);
    }

    public void addLoggingExtra(@Nullable String s, @Nullable Object object0) {
        if(this.methodLoggingExtras == null) {
            this.methodLoggingExtras = new HashMap();
        }
        Map map0 = this.methodLoggingExtras;
        if(map0 != null) {
            String s1 = (String)map0.put(s, (object0 == null ? null : object0.toString()));
        }
    }

    public void cancel() {
    }

    @Nullable
    public static final AccessToken createAccessTokenFromNativeLogin(@NotNull Bundle bundle0, @Nullable AccessTokenSource accessTokenSource0, @NotNull String s) {
        return LoginMethodHandler.Companion.createAccessTokenFromNativeLogin(bundle0, accessTokenSource0, s);
    }

    @Nullable
    public static final AccessToken createAccessTokenFromWebBundle(@Nullable Collection collection0, @NotNull Bundle bundle0, @Nullable AccessTokenSource accessTokenSource0, @NotNull String s) {
        return LoginMethodHandler.Companion.createAccessTokenFromWebBundle(collection0, bundle0, accessTokenSource0, s);
    }

    @Nullable
    public static final AuthenticationToken createAuthenticationTokenFromNativeLogin(@NotNull Bundle bundle0, @Nullable String s) {
        return LoginMethodHandler.Companion.createAuthenticationTokenFromNativeLogin(bundle0, s);
    }

    @Nullable
    public static final AuthenticationToken createAuthenticationTokenFromWebBundle(@NotNull Bundle bundle0, @Nullable String s) {
        return LoginMethodHandler.Companion.createAuthenticationTokenFromWebBundle(bundle0, s);
    }

    @NotNull
    public String getClientState(@NotNull String s) {
        q.g(s, "authId");
        JSONObject jSONObject0 = new JSONObject();
        try {
            jSONObject0.put("0_auth_logger_id", s);
            jSONObject0.put("3_method", this.getNameForLogging());
            this.putChallengeParam(jSONObject0);
        }
        catch(JSONException jSONException0) {
            Log.w("LoginMethodHandler", "Error creating client state json: " + jSONException0.getMessage());
        }
        String s1 = jSONObject0.toString();
        q.f(s1, "param.toString()");
        return s1;
    }

    @NotNull
    public final LoginClient getLoginClient() {
        LoginClient loginClient0 = this.loginClient;
        if(loginClient0 != null) {
            return loginClient0;
        }
        q.m("loginClient");
        throw null;
    }

    @Nullable
    public final Map getMethodLoggingExtras() {
        return this.methodLoggingExtras;
    }

    @NotNull
    public abstract String getNameForLogging();

    @NotNull
    public String getRedirectUrl() {
        return "fb" + FacebookSdk.getApplicationId() + "://authorize/";
    }

    @NotNull
    public static final String getUserIDFromSignedRequest(@Nullable String s) {
        return LoginMethodHandler.Companion.getUserIDFromSignedRequest(s);
    }

    public void logWebLoginCompleted(@Nullable String s) {
        String s1;
        Request loginClient$Request0 = this.getLoginClient().getPendingRequest();
        if(loginClient$Request0 == null) {
            s1 = FacebookSdk.getApplicationId();
        }
        else {
            s1 = loginClient$Request0.getApplicationId();
            if(s1 == null) {
                s1 = FacebookSdk.getApplicationId();
            }
        }
        InternalAppEventsLogger internalAppEventsLogger0 = new InternalAppEventsLogger(this.getLoginClient().getActivity(), s1);
        Bundle bundle0 = Y.b("fb_web_login_e2e", s);
        bundle0.putLong("fb_web_login_switchback_time", System.currentTimeMillis());
        bundle0.putString("app_id", s1);
        internalAppEventsLogger0.logEventImplicitly("fb_dialogs_web_login_dialog_complete", null, bundle0);
    }

    public boolean needsInternetPermission() {
        return false;
    }

    public boolean onActivityResult(int v, int v1, @Nullable Intent intent0) {
        return false;
    }

    @NotNull
    public Bundle processCodeExchange(@NotNull Request loginClient$Request0, @NotNull Bundle bundle0) {
        q.g(loginClient$Request0, "request");
        q.g(bundle0, "values");
        String s = bundle0.getString("code");
        if(Utility.isNullOrEmpty(s)) {
            throw new FacebookException("No code param found from the request");
        }
        if(s != null) {
            String s1 = this.getRedirectUrl();
            String s2 = loginClient$Request0.getCodeVerifier();
            if(s2 == null) {
                s2 = "";
            }
            GraphRequest graphRequest0 = PKCEUtil.createCodeExchangeRequest(s, s1, s2);
            if(graphRequest0 != null) {
                GraphResponse graphResponse0 = graphRequest0.executeAndWait();
                FacebookRequestError facebookRequestError0 = graphResponse0.getError();
                if(facebookRequestError0 != null) {
                    throw new FacebookServiceException(facebookRequestError0, facebookRequestError0.getErrorMessage());
                }
                try {
                    JSONObject jSONObject0 = graphResponse0.getJSONObject();
                    String s3 = jSONObject0 == null ? null : jSONObject0.getString("access_token");
                    if(jSONObject0 == null || Utility.isNullOrEmpty(s3)) {
                        throw new FacebookException("No access token found from result");
                    }
                    bundle0.putString("access_token", s3);
                    if(jSONObject0.has("id_token")) {
                        bundle0.putString("id_token", jSONObject0.getString("id_token"));
                    }
                    return bundle0;
                }
                catch(JSONException jSONException0) {
                }
                throw new FacebookException("Fail to process code exchange response: " + jSONException0.getMessage());
            }
        }
        throw new FacebookException("Failed to create code exchange request");
    }

    public void putChallengeParam(@NotNull JSONObject jSONObject0) {
        q.g(jSONObject0, "param");
    }

    public final void setLoginClient(@NotNull LoginClient loginClient0) {
        q.g(loginClient0, "<set-?>");
        this.loginClient = loginClient0;
    }

    public final void setMethodLoggingExtras(@Nullable Map map0) {
        this.methodLoggingExtras = map0;
    }

    public boolean shouldKeepTrackOfMultipleIntents() {
        return false;
    }

    public abstract int tryAuthorize(@NotNull Request arg1);

    @Override  // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        Utility.writeStringMapToParcel(parcel0, this.methodLoggingExtras);
    }
}

