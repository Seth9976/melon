package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.AuthenticationToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility.GraphMeRequestWithCacheCallback;
import com.facebook.internal.Utility;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import je.w;
import je.y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001!B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0013\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\f2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001D\u0010\u0015\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0014J\u001D\u0010\u0016\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0014J\u000F\u0010\u0017\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001A\u001A\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001A\u0010\u001BR\u001A\u0010\u001D\u001A\u00020\u001C8\u0016X\u0096D¢\u0006\f\n\u0004\b\u001D\u0010\u001E\u001A\u0004\b\u001F\u0010 ¨\u0006\""}, d2 = {"Lcom/facebook/login/GetTokenLoginMethodHandler;", "Lcom/facebook/login/LoginMethodHandler;", "Lcom/facebook/login/LoginClient;", "loginClient", "<init>", "(Lcom/facebook/login/LoginClient;)V", "Landroid/os/Parcel;", "source", "(Landroid/os/Parcel;)V", "Lie/H;", "cancel", "()V", "Lcom/facebook/login/LoginClient$Request;", "request", "", "tryAuthorize", "(Lcom/facebook/login/LoginClient$Request;)I", "Landroid/os/Bundle;", "result", "getTokenCompleted", "(Lcom/facebook/login/LoginClient$Request;Landroid/os/Bundle;)V", "onComplete", "complete", "describeContents", "()I", "Lcom/facebook/login/GetTokenClient;", "getTokenClient", "Lcom/facebook/login/GetTokenClient;", "", "nameForLogging", "Ljava/lang/String;", "getNameForLogging", "()Ljava/lang/String;", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class GetTokenLoginMethodHandler extends LoginMethodHandler {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/login/GetTokenLoginMethodHandler$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/login/GetTokenLoginMethodHandler;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Parcelable.Creator CREATOR;
    @NotNull
    public static final Companion Companion;
    @Nullable
    private GetTokenClient getTokenClient;
    @NotNull
    private final String nameForLogging;

    static {
        GetTokenLoginMethodHandler.Companion = new Companion(null);
        GetTokenLoginMethodHandler.CREATOR = new GetTokenLoginMethodHandler.Companion.CREATOR.1();
    }

    public GetTokenLoginMethodHandler(@NotNull Parcel parcel0) {
        q.g(parcel0, "source");
        super(parcel0);
        this.nameForLogging = "get_token";
    }

    public GetTokenLoginMethodHandler(@NotNull LoginClient loginClient0) {
        q.g(loginClient0, "loginClient");
        super(loginClient0);
        this.nameForLogging = "get_token";
    }

    @Override  // com.facebook.login.LoginMethodHandler
    public void cancel() {
        GetTokenClient getTokenClient0 = this.getTokenClient;
        if(getTokenClient0 != null) {
            getTokenClient0.cancel();
            getTokenClient0.setCompletedListener(null);
            this.getTokenClient = null;
        }
    }

    public final void complete(@NotNull Request loginClient$Request0, @NotNull Bundle bundle0) {
        q.g(loginClient$Request0, "request");
        q.g(bundle0, "result");
        String s = bundle0.getString("com.facebook.platform.extra.USER_ID");
        if(s != null && s.length() != 0) {
            this.onComplete(loginClient$Request0, bundle0);
            return;
        }
        this.getLoginClient().notifyBackgroundProcessingStart();
        String s1 = bundle0.getString("com.facebook.platform.extra.ACCESS_TOKEN");
        if(s1 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        Utility.getGraphMeRequestWithCacheAsync(s1, new GraphMeRequestWithCacheCallback() {
            @Override  // com.facebook.internal.Utility$GraphMeRequestWithCacheCallback
            public void onFailure(@Nullable FacebookException facebookException0) {
                LoginClient loginClient0 = loginClient$Request0.getLoginClient();
                Request loginClient$Request0 = loginClient$Request0.getLoginClient().getPendingRequest();
                loginClient0.complete(com.facebook.login.LoginClient.Result.Companion.createErrorResult$default(Result.Companion, loginClient$Request0, "Caught exception", (facebookException0 == null ? null : facebookException0.getMessage()), null, 8, null));
            }

            @Override  // com.facebook.internal.Utility$GraphMeRequestWithCacheCallback
            public void onSuccess(@Nullable JSONObject jSONObject0) {
                try {
                    String s = jSONObject0 == null ? null : jSONObject0.getString("id");
                    this.putString("com.facebook.platform.extra.USER_ID", s);
                    loginClient$Request0.onComplete(this.$request, this);
                }
                catch(JSONException jSONException0) {
                    LoginClient loginClient0 = loginClient$Request0.getLoginClient();
                    Request loginClient$Request0 = loginClient$Request0.getLoginClient().getPendingRequest();
                    loginClient0.complete(com.facebook.login.LoginClient.Result.Companion.createErrorResult$default(Result.Companion, loginClient$Request0, "Caught exception", jSONException0.getMessage(), null, 8, null));
                }
            }
        });
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override  // com.facebook.login.LoginMethodHandler
    @NotNull
    public String getNameForLogging() {
        return this.nameForLogging;
    }

    public final void getTokenCompleted(@NotNull Request loginClient$Request0, @Nullable Bundle bundle0) {
        q.g(loginClient$Request0, "request");
        GetTokenClient getTokenClient0 = this.getTokenClient;
        if(getTokenClient0 != null) {
            getTokenClient0.setCompletedListener(null);
        }
        this.getTokenClient = null;
        this.getLoginClient().notifyBackgroundProcessingStop();
        if(bundle0 != null) {
            ArrayList arrayList0 = bundle0.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
            if(arrayList0 == null) {
                arrayList0 = w.a;
            }
            Set set0 = loginClient$Request0.getPermissions();
            if(set0 == null) {
                set0 = y.a;
            }
            String s = bundle0.getString("com.facebook.platform.extra.ID_TOKEN");
            if(set0.contains("openid") && (s == null || s.length() == 0)) {
                this.getLoginClient().tryNextHandler();
                return;
            }
            if(arrayList0.containsAll(set0)) {
                this.complete(loginClient$Request0, bundle0);
                return;
            }
            HashSet hashSet0 = new HashSet();
            for(Object object0: set0) {
                String s1 = (String)object0;
                if(!arrayList0.contains(s1)) {
                    hashSet0.add(s1);
                }
            }
            if(!hashSet0.isEmpty()) {
                this.addLoggingExtra("new_permissions", TextUtils.join(",", hashSet0));
            }
            loginClient$Request0.setPermissions(hashSet0);
        }
        this.getLoginClient().tryNextHandler();
    }

    public final void onComplete(@NotNull Request loginClient$Request0, @NotNull Bundle bundle0) {
        Result loginClient$Result0;
        q.g(loginClient$Request0, "request");
        q.g(bundle0, "result");
        try {
            AccessToken accessToken0 = LoginMethodHandler.Companion.createAccessTokenFromNativeLogin(bundle0, AccessTokenSource.FACEBOOK_APPLICATION_SERVICE, loginClient$Request0.getApplicationId());
            AuthenticationToken authenticationToken0 = LoginMethodHandler.Companion.createAuthenticationTokenFromNativeLogin(bundle0, loginClient$Request0.getNonce());
            loginClient$Result0 = Result.Companion.createCompositeTokenResult(loginClient$Request0, accessToken0, authenticationToken0);
        }
        catch(FacebookException facebookException0) {
            Request loginClient$Request1 = this.getLoginClient().getPendingRequest();
            loginClient$Result0 = com.facebook.login.LoginClient.Result.Companion.createErrorResult$default(Result.Companion, loginClient$Request1, null, facebookException0.getMessage(), null, 8, null);
        }
        this.getLoginClient().completeAndValidate(loginClient$Result0);
    }

    @Override  // com.facebook.login.LoginMethodHandler
    public int tryAuthorize(@NotNull Request loginClient$Request0) {
        q.g(loginClient$Request0, "request");
        Context context0 = this.getLoginClient().getActivity();
        if(context0 == null) {
            context0 = FacebookSdk.getApplicationContext();
        }
        GetTokenClient getTokenClient0 = new GetTokenClient(context0, loginClient$Request0);
        this.getTokenClient = getTokenClient0;
        if(!getTokenClient0.start()) {
            return 0;
        }
        this.getLoginClient().notifyBackgroundProcessingStart();
        g g0 = new g(this, loginClient$Request0);
        GetTokenClient getTokenClient1 = this.getTokenClient;
        if(getTokenClient1 != null) {
            getTokenClient1.setCompletedListener(g0);
        }
        return 1;
    }

    private static final void tryAuthorize$lambda$1(GetTokenLoginMethodHandler getTokenLoginMethodHandler0, Request loginClient$Request0, Bundle bundle0) {
        q.g(getTokenLoginMethodHandler0, "this$0");
        q.g(loginClient$Request0, "$request");
        getTokenLoginMethodHandler0.getTokenCompleted(loginClient$Request0, bundle0);
    }
}

