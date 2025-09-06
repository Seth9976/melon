package com.kakao.sdk.user;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.kakao.sdk.auth.AppsHandlerActivity;
import com.kakao.sdk.auth.AuthApiClient;
import com.kakao.sdk.auth.AuthCodeClient;
import com.kakao.sdk.auth.SingleResultReceiver;
import com.kakao.sdk.auth.TokenManagerProvider;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.auth.network.ApiFactoryKt;
import com.kakao.sdk.common.model.AppsError;
import com.kakao.sdk.common.model.ClientError;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.common.util.KakaoJson;
import com.kakao.sdk.network.ApiCallback;
import com.kakao.sdk.network.ApiFactory;
import com.kakao.sdk.user.model.AccessTokenInfo;
import com.kakao.sdk.user.model.ScopeInfo;
import com.kakao.sdk.user.model.User;
import com.kakao.sdk.user.model.UserResponse;
import com.kakao.sdk.user.model.UserRevokedServiceTerms;
import com.kakao.sdk.user.model.UserServiceTerms;
import com.kakao.sdk.user.model.UserShippingAddresses;
import d3.g;
import ie.H;
import ie.j;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000\u00A0\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 O2\u00020\u0001:\u0001OB%\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\t\u00A2\u0006\u0004\b\f\u0010\rJo\u0010\u001A\u001A\u00020\u00182\u0006\u0010\n\u001A\u00020\t2\b\b\u0002\u0010\u000F\u001A\u00020\u000E2\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010\u0013\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00122\u0010\b\u0002\u0010\u0014\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00122\u001C\u0010\u0019\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180\u0015H\u0007\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0083\u0001\u0010\u001F\u001A\u00020\u00182\u0006\u0010\n\u001A\u00020\t2\u0010\b\u0002\u0010\u001D\u001A\n\u0012\u0004\u0012\u00020\u001C\u0018\u00010\u00122\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010\u0013\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00122\u0010\b\u0002\u0010\u0014\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00122\u001C\u0010\u0019\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180\u0015H\u0007\u00A2\u0006\u0004\b\u001F\u0010 JM\u0010\"\u001A\u00020\u00182\u0006\u0010\n\u001A\u00020\t2\f\u0010!\u001A\b\u0012\u0004\u0012\u00020\u00100\u00122\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u00102\u001C\u0010\u0019\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180\u0015\u00A2\u0006\u0004\b\"\u0010#JI\u0010\'\u001A\u00020\u00182\u0010\b\u0002\u0010$\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00122\b\b\u0002\u0010%\u001A\u00020\u000B2\u001C\u0010\u0019\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010&\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180\u0015H\u0007\u00A2\u0006\u0004\b\'\u0010(J;\u0010+\u001A\u00020\u00182\u0016\b\u0002\u0010$\u001A\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010)2\u0014\u0010\u0019\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180*\u00A2\u0006\u0004\b+\u0010,J+\u0010.\u001A\u00020\u00182\u001C\u0010\u0019\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010-\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180\u0015\u00A2\u0006\u0004\b.\u0010/J7\u00100\u001A\u00020\u00182\u0012\u0010$\u001A\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100)2\u0014\u0010\u0019\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180*\u00A2\u0006\u0004\b0\u0010,J#\u00101\u001A\u00020\u00182\u0014\u0010\u0019\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180*\u00A2\u0006\u0004\b1\u00102J#\u00103\u001A\u00020\u00182\u0014\u0010\u0019\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180*\u00A2\u0006\u0004\b3\u00102J3\u00105\u001A\u00020\u00182\u0006\u0010\n\u001A\u00020\t2\u001C\u0010\u0019\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u000104\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180\u0015\u00A2\u0006\u0004\b5\u00106JE\u0010;\u001A\u00020\u00182\n\b\u0002\u00108\u001A\u0004\u0018\u0001072\n\b\u0002\u00109\u001A\u0004\u0018\u00010\u000E2\u001C\u0010\u0019\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010:\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180\u0015H\u0007\u00A2\u0006\u0004\b;\u0010<J3\u0010;\u001A\u00020\u00182\u0006\u0010=\u001A\u0002042\u001C\u0010\u0019\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010:\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180\u0015\u00A2\u0006\u0004\b;\u0010>J=\u0010!\u001A\u00020\u00182\u0010\b\u0002\u0010!\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00122\u001C\u0010\u0019\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010?\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180\u0015\u00A2\u0006\u0004\b!\u0010@J9\u0010A\u001A\u00020\u00182\f\u0010!\u001A\b\u0012\u0004\u0012\u00020\u00100\u00122\u001C\u0010\u0019\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010?\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180\u0015\u00A2\u0006\u0004\bA\u0010@JI\u0010\u0014\u001A\u00020\u00182\u0010\b\u0002\u0010B\u001A\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00122\n\b\u0002\u0010C\u001A\u0004\u0018\u00010\u00102\u001C\u0010\u0019\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010D\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180\u0015\u00A2\u0006\u0004\b\u0014\u0010EJ9\u0010G\u001A\u00020\u00182\f\u0010B\u001A\b\u0012\u0004\u0012\u00020\u00100\u00122\u001C\u0010\u0019\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010F\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180\u0015\u00A2\u0006\u0004\bG\u0010@JG\u0010I\u001A\u00020\u00182\u0006\u0010\n\u001A\u00020\t2\u0006\u0010H\u001A\u00020\u00102\u001C\u0010\u0019\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u000104\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180\u00152\n\b\u0002\u0010=\u001A\u0004\u0018\u000104\u00A2\u0006\u0004\bI\u0010JJ-\u0010L\u001A\u00020\u00182\u001C\u0010\u0019\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010-\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180\u0015H\u0000\u00A2\u0006\u0004\bK\u0010/R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010MR\u0014\u0010\u0004\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0004\u0010MR\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0006\u0010N\u00A8\u0006P"}, d2 = {"Lcom/kakao/sdk/user/UserApiClient;", "", "Lcom/kakao/sdk/user/UserApi;", "userApi", "userApiNoLog", "Lcom/kakao/sdk/auth/TokenManagerProvider;", "tokenManagerProvider", "<init>", "(Lcom/kakao/sdk/user/UserApi;Lcom/kakao/sdk/user/UserApi;Lcom/kakao/sdk/auth/TokenManagerProvider;)V", "Landroid/content/Context;", "context", "", "isKakaoTalkLoginAvailable", "(Landroid/content/Context;)Z", "", "requestCode", "", "nonce", "", "channelPublicIds", "serviceTerms", "Lkotlin/Function2;", "Lcom/kakao/sdk/auth/model/OAuthToken;", "", "Lie/H;", "callback", "loginWithKakaoTalk", "(Landroid/content/Context;ILjava/lang/String;Ljava/util/List;Ljava/util/List;Lwe/n;)V", "Lcom/kakao/sdk/auth/model/Prompt;", "prompts", "loginHint", "loginWithKakaoAccount", "(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lwe/n;)V", "scopes", "loginWithNewScopes", "(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;Lwe/n;)V", "properties", "secureResource", "Lcom/kakao/sdk/user/model/User;", "me", "(Ljava/util/List;ZLwe/n;)V", "", "Lkotlin/Function1;", "signup", "(Ljava/util/Map;Lwe/k;)V", "Lcom/kakao/sdk/user/model/AccessTokenInfo;", "accessTokenInfo", "(Lwe/n;)V", "updateProfile", "logout", "(Lwe/k;)V", "unlink", "", "selectShippingAddress", "(Landroid/content/Context;Lwe/n;)V", "Ljava/util/Date;", "fromUpdatedAt", "pageSize", "Lcom/kakao/sdk/user/model/UserShippingAddresses;", "shippingAddresses", "(Ljava/util/Date;Ljava/lang/Integer;Lwe/n;)V", "addressId", "(JLwe/n;)V", "Lcom/kakao/sdk/user/model/ScopeInfo;", "(Ljava/util/List;Lwe/n;)V", "revokeScopes", "tags", "result", "Lcom/kakao/sdk/user/model/UserServiceTerms;", "(Ljava/util/List;Ljava/lang/String;Lwe/n;)V", "Lcom/kakao/sdk/user/model/UserRevokedServiceTerms;", "revokeServiceTerms", "path", "appsShippingAddress", "(Landroid/content/Context;Ljava/lang/String;Lwe/n;Ljava/lang/Long;)V", "checkAccessToken$user_release", "checkAccessToken", "Lcom/kakao/sdk/user/UserApi;", "Lcom/kakao/sdk/auth/TokenManagerProvider;", "Companion", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class UserApiClient {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R!\u0010\n\u001A\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001A\u0004\b\u0007\u0010\b¨\u0006\u000B"}, d2 = {"Lcom/kakao/sdk/user/UserApiClient$Companion;", "", "<init>", "()V", "Lcom/kakao/sdk/user/UserApiClient;", "instance$delegate", "Lie/j;", "getInstance", "()Lcom/kakao/sdk/user/UserApiClient;", "getInstance$annotations", "instance", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final UserApiClient getInstance() {
            return (UserApiClient)UserApiClient.instance$delegate.getValue();
        }

        public static void getInstance$annotations() {
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final j instance$delegate;
    @NotNull
    private final TokenManagerProvider tokenManagerProvider;
    @NotNull
    private final UserApi userApi;
    @NotNull
    private final UserApi userApiNoLog;

    static {
        UserApiClient.Companion = new Companion(null);
        UserApiClient.instance$delegate = g.Q(UserApiClient.Companion.instance.2.INSTANCE);
    }

    public UserApiClient() {
        this(null, null, null, 7, null);
    }

    public UserApiClient(@NotNull UserApi userApi0, @NotNull UserApi userApi1, @NotNull TokenManagerProvider tokenManagerProvider0) {
        q.g(userApi0, "userApi");
        q.g(userApi1, "userApiNoLog");
        q.g(tokenManagerProvider0, "tokenManagerProvider");
        super();
        this.userApi = userApi0;
        this.userApiNoLog = userApi1;
        this.tokenManagerProvider = tokenManagerProvider0;
    }

    public UserApiClient(UserApi userApi0, UserApi userApi1, TokenManagerProvider tokenManagerProvider0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        Class class0 = UserApi.class;
        if((v & 1) != 0) {
            Object object0 = ApiFactoryKt.getKapiWithOAuth(ApiFactory.INSTANCE).b(class0);
            q.f(object0, "ApiFactory.kapiWithOAuth…eate(UserApi::class.java)");
            userApi0 = (UserApi)object0;
        }
        if((v & 2) != 0) {
            Object object1 = ApiFactoryKt.getKapiWithOAuthNoLog(ApiFactory.INSTANCE).b(class0);
            q.f(object1, "ApiFactory.kapiWithOAuth…eate(UserApi::class.java)");
            userApi1 = (UserApi)object1;
        }
        if((v & 4) != 0) {
            tokenManagerProvider0 = TokenManagerProvider.Companion.getInstance();
        }
        this(userApi0, userApi1, tokenManagerProvider0);
    }

    public final void accessTokenInfo(@NotNull n n0) {
        q.g(n0, "callback");
        this.userApi.accessTokenInfo().enqueue(new ApiCallback() {
            final n $callback;

            {
                this.$callback = n0;
                super(false, 1, null);
            }

            public void onComplete(@Nullable AccessTokenInfo accessTokenInfo0, @Nullable Throwable throwable0) {
                this.$callback.invoke(accessTokenInfo0, throwable0);
            }

            @Override  // com.kakao.sdk.network.ApiCallback
            public void onComplete(Object object0, Throwable throwable0) {
                this.onComplete(((AccessTokenInfo)object0), throwable0);
            }
        });
    }

    public final void appsShippingAddress(@NotNull Context context0, @NotNull String s, @NotNull n n0, @Nullable Long long0) {
        q.g(context0, "context");
        q.g(s, "path");
        q.g(n0, "callback");
        com.kakao.sdk.auth.AuthApiClient.Companion authApiClient$Companion0 = AuthApiClient.Companion;
        if(!authApiClient$Companion0.getInstance().hasToken()) {
            n0.invoke(null, new ClientError(ClientErrorCause.TokenNotFound, "Token not found. You must login first."));
            return;
        }
        AuthApiClient.refreshToken$default(authApiClient$Companion0.getInstance(), null, new n(s, long0, context0) {
            final Long $addressId;
            final n $callback;
            final Context $context;
            final String $path;

            {
                this.$callback = n0;
                this.$path = s;
                this.$addressId = long0;
                this.$context = context0;
                super(2);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                this.invoke(((OAuthToken)object0), ((Throwable)object1));
                return H.a;
            }

            public final void invoke(@Nullable OAuthToken oAuthToken0, @Nullable Throwable throwable0) {
                if(throwable0 != null) {
                    this.$callback.invoke(null, throwable0);
                    return;
                }
                AuthApiClient.Companion.getInstance().agt(new n(this.$path, this.$addressId, this.$context) {
                    final Long $addressId;
                    final n $callback;
                    final Context $context;
                    final String $path;

                    {
                        this.$callback = n0;
                        this.$path = s;
                        this.$addressId = long0;
                        this.$context = context0;
                        super(2);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        this.invoke(((String)object0), ((Throwable)object1));
                        return H.a;
                    }

                    public final void invoke(@Nullable String s, @Nullable Throwable throwable0) {
                        if(throwable0 != null) {
                            this.$callback.invoke(null, throwable0);
                            return;
                        }
                        UriUtility uriUtility0 = new UriUtility(null, 1, null);
                        Uri uri0 = UriUtility.shippingAddressUrl$default(uriUtility0, this.$path, this.$addressId, null, null, null, 28, null);
                        q.d(s);
                        String s1 = uri0.toString();
                        q.f(s1, "continueUrl.toString()");
                        Uri uri1 = UriUtility.kpidtUrl$default(uriUtility0, s, s1, null, 4, null);
                        SingleResultReceiver singleResultReceiver0 = SingleResultReceiver.Companion.create(this.$callback, "Apps", com.kakao.sdk.user.UserApiClient.appsShippingAddress.1.1.resultReceiver.1.INSTANCE, com.kakao.sdk.user.UserApiClient.appsShippingAddress.1.1.resultReceiver.2.INSTANCE, com.kakao.sdk.user.UserApiClient.appsShippingAddress.1.1.resultReceiver.3.INSTANCE);
                        Intent intent0 = new Intent(this.$context, AppsHandlerActivity.class);
                        Bundle bundle0 = new Bundle();
                        bundle0.putParcelable("key.result.receiver", singleResultReceiver0);
                        bundle0.putParcelable("key.full_authorize_uri", uri1);
                        Intent intent1 = intent0.putExtra("key.bundle", bundle0).addFlags(0x10000000);
                        q.f(intent1, "Intent(context, T::class…t.FLAG_ACTIVITY_NEW_TASK)");
                        this.$context.startActivity(intent1);

                        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "uri", "Landroid/net/Uri;", "invoke", "(Landroid/net/Uri;)Ljava/lang/Long;"}, k = 3, mv = {1, 8, 0}, xi = 0x30)
                        final class com.kakao.sdk.user.UserApiClient.appsShippingAddress.1.1.resultReceiver.1 extends r implements k {
                            public static final com.kakao.sdk.user.UserApiClient.appsShippingAddress.1.1.resultReceiver.1 INSTANCE;

                            static {
                                com.kakao.sdk.user.UserApiClient.appsShippingAddress.1.1.resultReceiver.1.INSTANCE = new com.kakao.sdk.user.UserApiClient.appsShippingAddress.1.1.resultReceiver.1();
                            }

                            public com.kakao.sdk.user.UserApiClient.appsShippingAddress.1.1.resultReceiver.1() {
                                super(1);
                            }

                            @Nullable
                            public final Long invoke(@NotNull Uri uri0) {
                                q.g(uri0, "uri");
                                String s = uri0.getQueryParameter("address_id");
                                return s == null ? null : Long.parseLong(s);
                            }

                            @Override  // we.k
                            public Object invoke(Object object0) {
                                return this.invoke(((Uri)object0));
                            }
                        }


                        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "uri", "Landroid/net/Uri;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 0x30)
                        final class com.kakao.sdk.user.UserApiClient.appsShippingAddress.1.1.resultReceiver.2 extends r implements k {
                            public static final com.kakao.sdk.user.UserApiClient.appsShippingAddress.1.1.resultReceiver.2 INSTANCE;

                            static {
                                com.kakao.sdk.user.UserApiClient.appsShippingAddress.1.1.resultReceiver.2.INSTANCE = new com.kakao.sdk.user.UserApiClient.appsShippingAddress.1.1.resultReceiver.2();
                            }

                            public com.kakao.sdk.user.UserApiClient.appsShippingAddress.1.1.resultReceiver.2() {
                                super(1);
                            }

                            @Override  // we.k
                            public Object invoke(Object object0) {
                                return this.invoke(((Uri)object0));
                            }

                            @NotNull
                            public final Throwable invoke(@NotNull Uri uri0) {
                                q.g(uri0, "uri");
                                String s = uri0.getQueryParameter("error_code");
                                String s1 = uri0.getQueryParameter("error_msg");
                                return AppsError.Companion.create(302, s, s1);
                            }
                        }


                        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "uri", "Landroid/net/Uri;", "invoke", "(Landroid/net/Uri;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 0x30)
                        final class com.kakao.sdk.user.UserApiClient.appsShippingAddress.1.1.resultReceiver.3 extends r implements k {
                            public static final com.kakao.sdk.user.UserApiClient.appsShippingAddress.1.1.resultReceiver.3 INSTANCE;

                            static {
                                com.kakao.sdk.user.UserApiClient.appsShippingAddress.1.1.resultReceiver.3.INSTANCE = new com.kakao.sdk.user.UserApiClient.appsShippingAddress.1.1.resultReceiver.3();
                            }

                            public com.kakao.sdk.user.UserApiClient.appsShippingAddress.1.1.resultReceiver.3() {
                                super(1);
                            }

                            @NotNull
                            public final Boolean invoke(@NotNull Uri uri0) {
                                q.g(uri0, "uri");
                                return Boolean.valueOf(q.b(uri0.getQueryParameter("status"), "error"));
                            }

                            @Override  // we.k
                            public Object invoke(Object object0) {
                                return this.invoke(((Uri)object0));
                            }
                        }

                    }
                });
            }
        }, 1, null);
    }

    public static void appsShippingAddress$default(UserApiClient userApiClient0, Context context0, String s, n n0, Long long0, int v, Object object0) {
        if((v & 8) != 0) {
            long0 = null;
        }
        userApiClient0.appsShippingAddress(context0, s, n0, long0);
    }

    public final void checkAccessToken$user_release(@NotNull n n0) {
        q.g(n0, "callback");
        this.userApiNoLog.checkAccessToken().enqueue(new ApiCallback() {
            final n $callback;

            {
                this.$callback = n0;
                super(false);
            }

            public void onComplete(@Nullable AccessTokenInfo accessTokenInfo0, @Nullable Throwable throwable0) {
                this.$callback.invoke(accessTokenInfo0, throwable0);
            }

            @Override  // com.kakao.sdk.network.ApiCallback
            public void onComplete(Object object0, Throwable throwable0) {
                this.onComplete(((AccessTokenInfo)object0), throwable0);
            }
        });
    }

    @NotNull
    public static final UserApiClient getInstance() {
        return UserApiClient.Companion.getInstance();
    }

    public final boolean isKakaoTalkLoginAvailable(@NotNull Context context0) {
        q.g(context0, "context");
        return AuthCodeClient.Companion.getInstance().isKakaoTalkLoginAvailable(context0);
    }

    public final void loginWithKakaoAccount(@NotNull Context context0, @Nullable List list0, @Nullable String s, @Nullable String s1, @Nullable List list1, @Nullable List list2, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        AuthCodeClient.authorizeWithKakaoAccount$default(AuthCodeClient.Companion.getInstance(), context0, list0, null, s1, null, list1, list2, s, "zSDD7u4stKOUzdwh4wGAbh52U7G87UQ3zdjLH7TgUA8XYL4NaCTI4JIlLtYe+/RicHK5D2bXdOy+4tzM/a6dPg", null, new n("zSDD7u4stKOUzdwh4wGAbh52U7G87UQ3zdjLH7TgUA8XYL4NaCTI4JIlLtYe+/RicHK5D2bXdOy+4tzM/a6dPg") {
            final n $callback;
            final String $codeVerifier;

            {
                this.$callback = n0;
                this.$codeVerifier = s;
                super(2);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                this.invoke(((String)object0), ((Throwable)object1));
                return H.a;
            }

            public final void invoke(@Nullable String s, @Nullable Throwable throwable0) {
                if(throwable0 != null) {
                    this.$callback.invoke(null, throwable0);
                    return;
                }
                AuthApiClient authApiClient0 = AuthApiClient.Companion.getInstance();
                q.d(s);
                com.kakao.sdk.user.UserApiClient.loginWithKakaoAccount.1.1 userApiClient$loginWithKakaoAccount$1$10 = new n() {
                    final n $callback;

                    {
                        this.$callback = n0;
                        super(2);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        this.invoke(((OAuthToken)object0), ((Throwable)object1));
                        return H.a;
                    }

                    public final void invoke(@Nullable OAuthToken oAuthToken0, @Nullable Throwable throwable0) {
                        this.$callback.invoke(oAuthToken0, throwable0);
                    }
                };
                authApiClient0.issueAccessToken(s, this.$codeVerifier, userApiClient$loginWithKakaoAccount$1$10);
            }
        }, 532, null);
    }

    public final void loginWithKakaoAccount(@NotNull Context context0, @Nullable List list0, @Nullable String s, @Nullable String s1, @Nullable List list1, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        UserApiClient.loginWithKakaoAccount$default(this, context0, list0, s, s1, list1, null, n0, 0x20, null);
    }

    public final void loginWithKakaoAccount(@NotNull Context context0, @Nullable List list0, @Nullable String s, @Nullable String s1, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        UserApiClient.loginWithKakaoAccount$default(this, context0, list0, s, s1, null, null, n0, 0x30, null);
    }

    public final void loginWithKakaoAccount(@NotNull Context context0, @Nullable List list0, @Nullable String s, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        UserApiClient.loginWithKakaoAccount$default(this, context0, list0, s, null, null, null, n0, 56, null);
    }

    public final void loginWithKakaoAccount(@NotNull Context context0, @Nullable List list0, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        UserApiClient.loginWithKakaoAccount$default(this, context0, list0, null, null, null, null, n0, 60, null);
    }

    public final void loginWithKakaoAccount(@NotNull Context context0, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        UserApiClient.loginWithKakaoAccount$default(this, context0, null, null, null, null, null, n0, 62, null);
    }

    public static void loginWithKakaoAccount$default(UserApiClient userApiClient0, Context context0, List list0, String s, String s1, List list1, List list2, n n0, int v, Object object0) {
        if((v & 2) != 0) {
            list0 = null;
        }
        if((v & 4) != 0) {
            s = null;
        }
        if((v & 8) != 0) {
            s1 = null;
        }
        if((v & 16) != 0) {
            list1 = null;
        }
        if((v & 0x20) != 0) {
            list2 = null;
        }
        userApiClient0.loginWithKakaoAccount(context0, list0, s, s1, list1, list2, n0);
    }

    public final void loginWithKakaoTalk(@NotNull Context context0, int v, @Nullable String s, @Nullable List list0, @Nullable List list1, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        AuthCodeClient.authorizeWithKakaoTalk$default(AuthCodeClient.Companion.getInstance(), context0, null, v, s, list0, list1, "HByCdfUUOl//7TXRSeFFrVOMdmNsJDq8FhYsKljwRyh0+YqYL9smFV+SDtzeoTz4bL5L41zzdsrhFDoQ18rtQg", null, new n("HByCdfUUOl//7TXRSeFFrVOMdmNsJDq8FhYsKljwRyh0+YqYL9smFV+SDtzeoTz4bL5L41zzdsrhFDoQ18rtQg") {
            final n $callback;
            final String $codeVerifier;

            {
                this.$callback = n0;
                this.$codeVerifier = s;
                super(2);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                this.invoke(((String)object0), ((Throwable)object1));
                return H.a;
            }

            public final void invoke(@Nullable String s, @Nullable Throwable throwable0) {
                if(throwable0 != null) {
                    this.$callback.invoke(null, throwable0);
                    return;
                }
                AuthApiClient authApiClient0 = AuthApiClient.Companion.getInstance();
                q.d(s);
                com.kakao.sdk.user.UserApiClient.loginWithKakaoTalk.1.1 userApiClient$loginWithKakaoTalk$1$10 = new n() {
                    final n $callback;

                    {
                        this.$callback = n0;
                        super(2);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        this.invoke(((OAuthToken)object0), ((Throwable)object1));
                        return H.a;
                    }

                    public final void invoke(@Nullable OAuthToken oAuthToken0, @Nullable Throwable throwable0) {
                        this.$callback.invoke(oAuthToken0, throwable0);
                    }
                };
                authApiClient0.issueAccessToken(s, this.$codeVerifier, userApiClient$loginWithKakaoTalk$1$10);
            }
        }, 0x80, null);
    }

    public final void loginWithKakaoTalk(@NotNull Context context0, int v, @Nullable String s, @Nullable List list0, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        UserApiClient.loginWithKakaoTalk$default(this, context0, v, s, list0, null, n0, 16, null);
    }

    public final void loginWithKakaoTalk(@NotNull Context context0, int v, @Nullable String s, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        UserApiClient.loginWithKakaoTalk$default(this, context0, v, s, null, null, n0, 24, null);
    }

    public final void loginWithKakaoTalk(@NotNull Context context0, int v, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        UserApiClient.loginWithKakaoTalk$default(this, context0, v, null, null, null, n0, 28, null);
    }

    public final void loginWithKakaoTalk(@NotNull Context context0, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        UserApiClient.loginWithKakaoTalk$default(this, context0, 0, null, null, null, n0, 30, null);
    }

    public static void loginWithKakaoTalk$default(UserApiClient userApiClient0, Context context0, int v, String s, List list0, List list1, n n0, int v1, Object object0) {
        if((v1 & 2) != 0) {
            v = 10012;
        }
        userApiClient0.loginWithKakaoTalk(context0, v, ((v1 & 4) == 0 ? s : null), ((v1 & 8) == 0 ? list0 : null), ((v1 & 16) == 0 ? list1 : null), n0);
    }

    public final void loginWithNewScopes(@NotNull Context context0, @NotNull List list0, @Nullable String s, @NotNull n n0) {
        q.g(context0, "context");
        q.g(list0, "scopes");
        q.g(n0, "callback");
        AuthApiClient.Companion.getInstance().agt(new n(context0, list0, s) {
            final n $callback;
            final Context $context;
            final String $nonce;
            final List $scopes;

            {
                this.$callback = n0;
                this.$context = context0;
                this.$scopes = list0;
                this.$nonce = s;
                super(2);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                this.invoke(((String)object0), ((Throwable)object1));
                return H.a;
            }

            public final void invoke(@Nullable String s, @Nullable Throwable throwable0) {
                if(throwable0 != null) {
                    this.$callback.invoke(null, throwable0);
                    return;
                }
                AuthCodeClient authCodeClient0 = AuthCodeClient.Companion.getInstance();
                com.kakao.sdk.user.UserApiClient.loginWithNewScopes.1.1 userApiClient$loginWithNewScopes$1$10 = new n("977BDCxWwwSV1X86bnYnwZuDq+kakN9005dQA2q9hgR/oTiwNJPCg15XCah1pLQx78fAtIHRo80Mz9cJvekmzw") {
                    final n $callback;
                    final String $codeVerifier;

                    {
                        this.$callback = n0;
                        this.$codeVerifier = s;
                        super(2);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        this.invoke(((String)object0), ((Throwable)object1));
                        return H.a;
                    }

                    public final void invoke(@Nullable String s, @Nullable Throwable throwable0) {
                        if(throwable0 != null) {
                            this.$callback.invoke(null, throwable0);
                            return;
                        }
                        AuthApiClient authApiClient0 = AuthApiClient.Companion.getInstance();
                        q.d(s);
                        com.kakao.sdk.user.UserApiClient.loginWithNewScopes.1.1.1 userApiClient$loginWithNewScopes$1$1$10 = new n() {
                            final n $callback;

                            {
                                this.$callback = n0;
                                super(2);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                this.invoke(((OAuthToken)object0), ((Throwable)object1));
                                return H.a;
                            }

                            public final void invoke(@Nullable OAuthToken oAuthToken0, @Nullable Throwable throwable0) {
                                this.$callback.invoke(oAuthToken0, throwable0);
                            }
                        };
                        authApiClient0.issueAccessToken(s, this.$codeVerifier, userApiClient$loginWithNewScopes$1$1$10);
                    }
                };
                AuthCodeClient.authorizeWithKakaoAccount$default(authCodeClient0, this.$context, null, this.$scopes, this.$nonce, s, null, null, null, "977BDCxWwwSV1X86bnYnwZuDq+kakN9005dQA2q9hgR/oTiwNJPCg15XCah1pLQx78fAtIHRo80Mz9cJvekmzw", null, userApiClient$loginWithNewScopes$1$10, 738, null);
            }
        });
    }

    public static void loginWithNewScopes$default(UserApiClient userApiClient0, Context context0, List list0, String s, n n0, int v, Object object0) {
        if((v & 4) != 0) {
            s = null;
        }
        userApiClient0.loginWithNewScopes(context0, list0, s, n0);
    }

    public final void logout(@NotNull k k0) {
        q.g(k0, "callback");
        this.userApi.logout().enqueue(new ApiCallback(k0) {
            final k $callback;

            {
                UserApiClient.this = userApiClient0;
                this.$callback = k0;
                super(false, 1, null);
            }

            public void onComplete(@Nullable H h0, @Nullable Throwable throwable0) {
                UserApiClient.this.tokenManagerProvider.getManager().clear();
                this.$callback.invoke(throwable0);
            }

            @Override  // com.kakao.sdk.network.ApiCallback
            public void onComplete(Object object0, Throwable throwable0) {
                this.onComplete(((H)object0), throwable0);
            }
        });
    }

    public final void me(@Nullable List list0, @NotNull n n0) {
        q.g(n0, "callback");
        UserApiClient.me$default(this, list0, false, n0, 2, null);
    }

    public final void me(@Nullable List list0, boolean z, @NotNull n n0) {
        String s;
        q.g(n0, "callback");
        if(list0 == null) {
            s = null;
        }
        else {
            Json json0 = KakaoJson.INSTANCE.getJson();
            json0.getSerializersModule();
            s = json0.encodeToString(new ArrayListSerializer(StringSerializer.INSTANCE), list0);
        }
        this.userApi.me(z, s).enqueue(new ApiCallback() {
            final n $callback;

            {
                this.$callback = n0;
                super(false, 1, null);
            }

            public void onComplete(@Nullable UserResponse userResponse0, @Nullable Throwable throwable0) {
                if(userResponse0 != null) {
                    User user0 = userResponse0.toUser();
                    this.$callback.invoke(user0, null);
                    return;
                }
                this.$callback.invoke(null, throwable0);
            }

            @Override  // com.kakao.sdk.network.ApiCallback
            public void onComplete(Object object0, Throwable throwable0) {
                this.onComplete(((UserResponse)object0), throwable0);
            }
        });
    }

    public final void me(@NotNull n n0) {
        q.g(n0, "callback");
        UserApiClient.me$default(this, null, false, n0, 3, null);
    }

    public static void me$default(UserApiClient userApiClient0, List list0, boolean z, n n0, int v, Object object0) {
        if((v & 1) != 0) {
            list0 = null;
        }
        if((v & 2) != 0) {
            z = true;
        }
        userApiClient0.me(list0, z, n0);
    }

    public final void revokeScopes(@NotNull List list0, @NotNull n n0) {
        q.g(list0, "scopes");
        q.g(n0, "callback");
        Json json0 = KakaoJson.INSTANCE.getJson();
        json0.getSerializersModule();
        String s = json0.encodeToString(new ArrayListSerializer(StringSerializer.INSTANCE), list0);
        this.userApi.revokeScopes(s).enqueue(new ApiCallback() {
            final n $callback;

            {
                this.$callback = n0;
                super(false, 1, null);
            }

            public void onComplete(@Nullable ScopeInfo scopeInfo0, @Nullable Throwable throwable0) {
                this.$callback.invoke(scopeInfo0, throwable0);
            }

            @Override  // com.kakao.sdk.network.ApiCallback
            public void onComplete(Object object0, Throwable throwable0) {
                this.onComplete(((ScopeInfo)object0), throwable0);
            }
        });
    }

    public final void revokeServiceTerms(@NotNull List list0, @NotNull n n0) {
        q.g(list0, "tags");
        q.g(n0, "callback");
        String s = p.q0(list0, ",", null, null, null, 62);
        this.userApi.revokeServiceTerms(s).enqueue(new ApiCallback() {
            final n $callback;

            {
                this.$callback = n0;
                super(false, 1, null);
            }

            public void onComplete(@Nullable UserRevokedServiceTerms userRevokedServiceTerms0, @Nullable Throwable throwable0) {
                this.$callback.invoke(userRevokedServiceTerms0, throwable0);
            }

            @Override  // com.kakao.sdk.network.ApiCallback
            public void onComplete(Object object0, Throwable throwable0) {
                this.onComplete(((UserRevokedServiceTerms)object0), throwable0);
            }
        });
    }

    public final void scopes(@Nullable List list0, @NotNull n n0) {
        String s;
        q.g(n0, "callback");
        UserApi userApi0 = this.userApi;
        if(list0 == null) {
            s = null;
        }
        else {
            Json json0 = KakaoJson.INSTANCE.getJson();
            json0.getSerializersModule();
            s = json0.encodeToString(new ArrayListSerializer(StringSerializer.INSTANCE), list0);
        }
        userApi0.scopes(s).enqueue(new ApiCallback() {
            final n $callback;

            {
                this.$callback = n0;
                super(false, 1, null);
            }

            public void onComplete(@Nullable ScopeInfo scopeInfo0, @Nullable Throwable throwable0) {
                this.$callback.invoke(scopeInfo0, throwable0);
            }

            @Override  // com.kakao.sdk.network.ApiCallback
            public void onComplete(Object object0, Throwable throwable0) {
                this.onComplete(((ScopeInfo)object0), throwable0);
            }
        });
    }

    public static void scopes$default(UserApiClient userApiClient0, List list0, n n0, int v, Object object0) {
        if((v & 1) != 0) {
            list0 = null;
        }
        userApiClient0.scopes(list0, n0);
    }

    public final void selectShippingAddress(@NotNull Context context0, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        UserApiClient.appsShippingAddress$default(this, context0, "/user/address", n0, null, 8, null);
    }

    public final void serviceTerms(@Nullable List list0, @Nullable String s, @NotNull n n0) {
        q.g(n0, "callback");
        String s1 = list0 == null ? null : p.q0(list0, ",", null, null, null, 62);
        this.userApi.serviceTerms(s1, s).enqueue(new ApiCallback() {
            final n $callback;

            {
                this.$callback = n0;
                super(false, 1, null);
            }

            public void onComplete(@Nullable UserServiceTerms userServiceTerms0, @Nullable Throwable throwable0) {
                this.$callback.invoke(userServiceTerms0, throwable0);
            }

            @Override  // com.kakao.sdk.network.ApiCallback
            public void onComplete(Object object0, Throwable throwable0) {
                this.onComplete(((UserServiceTerms)object0), throwable0);
            }
        });
    }

    public static void serviceTerms$default(UserApiClient userApiClient0, List list0, String s, n n0, int v, Object object0) {
        if((v & 1) != 0) {
            list0 = null;
        }
        if((v & 2) != 0) {
            s = null;
        }
        userApiClient0.serviceTerms(list0, s, n0);
    }

    public final void shippingAddresses(long v, @NotNull n n0) {
        q.g(n0, "callback");
        DefaultImpls.shippingAddresses$default(this.userApi, v, null, null, 6, null).enqueue(new ApiCallback() {
            final n $callback;

            {
                this.$callback = n0;
                super(false, 1, null);
            }

            public void onComplete(@Nullable UserShippingAddresses userShippingAddresses0, @Nullable Throwable throwable0) {
                this.$callback.invoke(userShippingAddresses0, throwable0);
            }

            @Override  // com.kakao.sdk.network.ApiCallback
            public void onComplete(Object object0, Throwable throwable0) {
                this.onComplete(((UserShippingAddresses)object0), throwable0);
            }
        });
    }

    public final void shippingAddresses(@Nullable Date date0, @Nullable Integer integer0, @NotNull n n0) {
        q.g(n0, "callback");
        String s = date0 == null ? null : String.valueOf(date0.getTime() / 1000L);
        DefaultImpls.shippingAddresses$default(this.userApi, null, s, integer0, 1, null).enqueue(new ApiCallback() {
            final n $callback;

            {
                this.$callback = n0;
                super(false, 1, null);
            }

            public void onComplete(@Nullable UserShippingAddresses userShippingAddresses0, @Nullable Throwable throwable0) {
                this.$callback.invoke(userShippingAddresses0, throwable0);
            }

            @Override  // com.kakao.sdk.network.ApiCallback
            public void onComplete(Object object0, Throwable throwable0) {
                this.onComplete(((UserShippingAddresses)object0), throwable0);
            }
        });
    }

    public final void shippingAddresses(@Nullable Date date0, @NotNull n n0) {
        q.g(n0, "callback");
        UserApiClient.shippingAddresses$default(this, date0, null, n0, 2, null);
    }

    public final void shippingAddresses(@NotNull n n0) {
        q.g(n0, "callback");
        UserApiClient.shippingAddresses$default(this, null, null, n0, 3, null);
    }

    public static void shippingAddresses$default(UserApiClient userApiClient0, Date date0, Integer integer0, n n0, int v, Object object0) {
        if((v & 1) != 0) {
            date0 = null;
        }
        if((v & 2) != 0) {
            integer0 = null;
        }
        userApiClient0.shippingAddresses(date0, integer0, n0);
    }

    public final void signup(@Nullable Map map0, @NotNull k k0) {
        JsonObject jsonObject0;
        q.g(k0, "callback");
        if(map0 == null) {
            jsonObject0 = null;
        }
        else {
            JsonObjectBuilder jsonObjectBuilder0 = new JsonObjectBuilder();
            for(Object object0: map0.entrySet()) {
                String s = (String)((Map.Entry)object0).getKey();
                Object object1 = ((Map.Entry)object0).getValue();
                Json json0 = KakaoJson.INSTANCE.getJson();
                json0.getSerializersModule();
                jsonObjectBuilder0.put(s, json0.encodeToJsonElement(StringSerializer.INSTANCE, object1));
            }
            jsonObject0 = jsonObjectBuilder0.build();
        }
        this.userApi.signup(jsonObject0).enqueue(new ApiCallback() {
            final k $callback;

            {
                this.$callback = k0;
                super(false, 1, null);
            }

            public void onComplete(@Nullable H h0, @Nullable Throwable throwable0) {
                this.$callback.invoke(throwable0);
            }

            @Override  // com.kakao.sdk.network.ApiCallback
            public void onComplete(Object object0, Throwable throwable0) {
                this.onComplete(((H)object0), throwable0);
            }
        });
    }

    public static void signup$default(UserApiClient userApiClient0, Map map0, k k0, int v, Object object0) {
        if((v & 1) != 0) {
            map0 = null;
        }
        userApiClient0.signup(map0, k0);
    }

    public final void unlink(@NotNull k k0) {
        q.g(k0, "callback");
        this.userApi.unlink().enqueue(new ApiCallback(k0) {
            final k $callback;

            {
                UserApiClient.this = userApiClient0;
                this.$callback = k0;
                super(false, 1, null);
            }

            public void onComplete(@Nullable H h0, @Nullable Throwable throwable0) {
                if(throwable0 == null) {
                    UserApiClient.this.tokenManagerProvider.getManager().clear();
                }
                this.$callback.invoke(throwable0);
            }

            @Override  // com.kakao.sdk.network.ApiCallback
            public void onComplete(Object object0, Throwable throwable0) {
                this.onComplete(((H)object0), throwable0);
            }
        });
    }

    public final void updateProfile(@NotNull Map map0, @NotNull k k0) {
        q.g(map0, "properties");
        q.g(k0, "callback");
        UserApi userApi0 = this.userApi;
        JsonObjectBuilder jsonObjectBuilder0 = new JsonObjectBuilder();
        for(Object object0: map0.entrySet()) {
            String s = (String)((Map.Entry)object0).getKey();
            Object object1 = ((Map.Entry)object0).getValue();
            Json json0 = KakaoJson.INSTANCE.getJson();
            json0.getSerializersModule();
            jsonObjectBuilder0.put(s, json0.encodeToJsonElement(StringSerializer.INSTANCE, object1));
        }
        userApi0.updateProfile(jsonObjectBuilder0.build()).enqueue(new ApiCallback() {
            final k $callback;

            {
                this.$callback = k0;
                super(false, 1, null);
            }

            public void onComplete(@Nullable H h0, @Nullable Throwable throwable0) {
                this.$callback.invoke(throwable0);
            }

            @Override  // com.kakao.sdk.network.ApiCallback
            public void onComplete(Object object0, Throwable throwable0) {
                this.onComplete(((H)object0), throwable0);
            }
        });
    }
}

