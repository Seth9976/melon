package com.kakao.sdk.auth;

import com.kakao.sdk.auth.model.AccessTokenResponse;
import com.kakao.sdk.auth.model.AgtResponse;
import com.kakao.sdk.auth.model.CertTokenInfo;
import com.kakao.sdk.auth.model.CertType;
import com.kakao.sdk.auth.model.IdentifyItem;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.auth.model.PrepareResponse;
import com.kakao.sdk.auth.network.ApiFactoryKt;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ApplicationInfo;
import com.kakao.sdk.common.model.ApprovalType;
import com.kakao.sdk.common.model.AuthError;
import com.kakao.sdk.common.model.AuthErrorCause;
import com.kakao.sdk.common.model.AuthErrorResponse;
import com.kakao.sdk.common.model.ClientError;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.common.model.ContextInfo;
import com.kakao.sdk.common.util.KakaoJson;
import com.kakao.sdk.network.ApiFactory;
import d3.g;
import d5.n;
import ie.H;
import ie.j;
import ie.o;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import kotlinx.serialization.json.Json;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tg.Q;
import tg.d;
import tg.p;
import we.k;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 @2\u00020\u0001:\u0001@B9\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006\u0012\b\b\u0002\u0010\t\u001A\u00020\b\u0012\b\b\u0002\u0010\u000B\u001A\u00020\n\u00A2\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u0011\u001A\u00020\u000EH\u0000\u00A2\u0006\u0004\b\u000F\u0010\u0010JA\u0010\u001C\u001A\u00020\u00182\u0006\u0010\u0013\u001A\u00020\u00122\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u00122\u001C\u0010\u0019\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180\u0015H\u0000\u00A2\u0006\u0004\b\u001A\u0010\u001BJA\u0010\u001F\u001A\u00020\u00182\u0006\u0010\u0013\u001A\u00020\u00122\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u00122\u001C\u0010\u0019\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u001D\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180\u0015H\u0000\u00A2\u0006\u0004\b\u001E\u0010\u001BJ7\u0010#\u001A\u00020\u00182\b\b\u0002\u0010 \u001A\u00020\u00162\u001C\u0010\u0019\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180\u0015H\u0001\u00A2\u0006\u0004\b!\u0010\"J-\u0010&\u001A\u00020\u00182\u001C\u0010\u0019\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180\u0015H\u0000\u00A2\u0006\u0004\b$\u0010%J\u0019\u0010#\u001A\u00020\u00162\b\b\u0002\u0010 \u001A\u00020\u0016H\u0000\u00A2\u0006\u0004\b!\u0010\'Jk\u00102\u001A\u00020\u00182\n\b\u0002\u0010(\u001A\u0004\u0018\u00010\u00122\u0010\b\u0002\u0010+\u001A\n\u0012\u0004\u0012\u00020*\u0018\u00010)2\n\b\u0002\u0010,\u001A\u0004\u0018\u00010\u00122\n\b\u0002\u0010-\u001A\u0004\u0018\u00010\u00122\u0006\u0010/\u001A\u00020.2\u001C\u0010\u0019\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u00180\u0015H\u0000\u00A2\u0006\u0004\b0\u00101R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u00103R\u0017\u0010\u0005\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b\u0005\u00104\u001A\u0004\b5\u00106R\u0017\u0010\u0007\u001A\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\b\u0007\u00107\u001A\u0004\b8\u00109R\u0017\u0010\t\u001A\u00020\b8\u0006\u00A2\u0006\f\n\u0004\b\t\u0010:\u001A\u0004\b;\u0010<R\u0017\u0010\u000B\u001A\u00020\n8\u0006\u00A2\u0006\f\n\u0004\b\u000B\u0010=\u001A\u0004\b>\u0010?\u00A8\u0006A"}, d2 = {"Lcom/kakao/sdk/auth/AuthApiManager;", "", "Lcom/kakao/sdk/auth/AuthApi;", "authApi", "Lcom/kakao/sdk/auth/TokenManagerProvider;", "tokenManagerProvider", "Lcom/kakao/sdk/common/model/ApplicationInfo;", "applicationInfo", "Lcom/kakao/sdk/common/model/ContextInfo;", "contextInfo", "Lcom/kakao/sdk/common/model/ApprovalType;", "approvalType", "<init>", "(Lcom/kakao/sdk/auth/AuthApi;Lcom/kakao/sdk/auth/TokenManagerProvider;Lcom/kakao/sdk/common/model/ApplicationInfo;Lcom/kakao/sdk/common/model/ContextInfo;Lcom/kakao/sdk/common/model/ApprovalType;)V", "", "hasToken$auth_release", "()Z", "hasToken", "", "code", "codeVerifier", "Lkotlin/Function2;", "Lcom/kakao/sdk/auth/model/OAuthToken;", "", "Lie/H;", "callback", "issueAccessToken$auth_release", "(Ljava/lang/String;Ljava/lang/String;Lwe/n;)V", "issueAccessToken", "Lcom/kakao/sdk/auth/model/CertTokenInfo;", "issueAccessTokenWithCert$auth_release", "issueAccessTokenWithCert", "oldToken", "refreshToken$auth_release", "(Lcom/kakao/sdk/auth/model/OAuthToken;Lwe/n;)V", "refreshToken", "agt$auth_release", "(Lwe/n;)V", "agt", "(Lcom/kakao/sdk/auth/model/OAuthToken;)Lcom/kakao/sdk/auth/model/OAuthToken;", "settleId", "", "Lcom/kakao/sdk/auth/model/IdentifyItem;", "identifyItems", "signData", "txId", "Lcom/kakao/sdk/auth/model/CertType;", "certType", "prepare$auth_release", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/kakao/sdk/auth/model/CertType;Lwe/n;)V", "prepare", "Lcom/kakao/sdk/auth/AuthApi;", "Lcom/kakao/sdk/auth/TokenManagerProvider;", "getTokenManagerProvider", "()Lcom/kakao/sdk/auth/TokenManagerProvider;", "Lcom/kakao/sdk/common/model/ApplicationInfo;", "getApplicationInfo", "()Lcom/kakao/sdk/common/model/ApplicationInfo;", "Lcom/kakao/sdk/common/model/ContextInfo;", "getContextInfo", "()Lcom/kakao/sdk/common/model/ContextInfo;", "Lcom/kakao/sdk/common/model/ApprovalType;", "getApprovalType", "()Lcom/kakao/sdk/common/model/ApprovalType;", "Companion", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AuthApiManager {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R!\u0010\u000E\u001A\u00020\b8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\t\u0010\n\u0012\u0004\b\r\u0010\u0003\u001A\u0004\b\u000B\u0010\f¨\u0006\u000F"}, d2 = {"Lcom/kakao/sdk/auth/AuthApiManager$Companion;", "", "<init>", "()V", "", "t", "translateError", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Lcom/kakao/sdk/auth/AuthApiManager;", "instance$delegate", "Lie/j;", "getInstance", "()Lcom/kakao/sdk/auth/AuthApiManager;", "getInstance$annotations", "instance", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final AuthApiManager getInstance() {
            return (AuthApiManager)AuthApiManager.instance$delegate.getValue();
        }

        public static void getInstance$annotations() {
        }

        @NotNull
        public final Throwable translateError(@NotNull Throwable throwable0) {
            AuthErrorCause authErrorCause0;
            AuthErrorResponse authErrorResponse0;
            String s;
            q.g(throwable0, "t");
            try {
                if(!(throwable0 instanceof p)) {
                    return throwable0;
                }
                Q q0 = ((p)throwable0).c;
                if(q0 == null) {
                    s = null;
                }
                else {
                    ResponseBody responseBody0 = q0.c;
                    s = responseBody0 == null ? null : responseBody0.string();
                }
                q.d(s);
                Json json0 = KakaoJson.INSTANCE.getJson();
                json0.getSerializersModule();
                authErrorResponse0 = (AuthErrorResponse)json0.decodeFromString(AuthErrorResponse.Companion.serializer(), s);
            }
            catch(Throwable throwable0) {
                return throwable0;
            }
            try {
                Json json1 = KakaoJson.INSTANCE.getJson();
                json1.getSerializersModule();
                authErrorCause0 = (AuthErrorCause)json1.decodeFromString(AuthErrorCause.Companion.serializer(), authErrorResponse0.getError());
                goto label_22;
            }
            catch(Throwable throwable1) {
                try {
                    authErrorCause0 = n.t(throwable1);
                label_22:
                    AuthErrorCause authErrorCause1 = AuthErrorCause.Unknown;
                    if(authErrorCause0 instanceof o) {
                        authErrorCause0 = authErrorCause1;
                    }
                    return new AuthError(((p)throwable0).a, authErrorCause0, authErrorResponse0);
                }
                catch(Throwable throwable0) {
                }
                return throwable0;
            }
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final ApplicationInfo applicationInfo;
    @NotNull
    private final ApprovalType approvalType;
    @NotNull
    private final AuthApi authApi;
    @NotNull
    private final ContextInfo contextInfo;
    @NotNull
    private static final j instance$delegate;
    @NotNull
    private final TokenManagerProvider tokenManagerProvider;

    static {
        AuthApiManager.Companion = new Companion(null);
        AuthApiManager.instance$delegate = g.Q(AuthApiManager.Companion.instance.2.INSTANCE);
    }

    public AuthApiManager() {
        this(null, null, null, null, null, 0x1F, null);
    }

    public AuthApiManager(@NotNull AuthApi authApi0, @NotNull TokenManagerProvider tokenManagerProvider0, @NotNull ApplicationInfo applicationInfo0, @NotNull ContextInfo contextInfo0, @NotNull ApprovalType approvalType0) {
        q.g(authApi0, "authApi");
        q.g(tokenManagerProvider0, "tokenManagerProvider");
        q.g(applicationInfo0, "applicationInfo");
        q.g(contextInfo0, "contextInfo");
        q.g(approvalType0, "approvalType");
        super();
        this.authApi = authApi0;
        this.tokenManagerProvider = tokenManagerProvider0;
        this.applicationInfo = applicationInfo0;
        this.contextInfo = contextInfo0;
        this.approvalType = approvalType0;
    }

    public AuthApiManager(AuthApi authApi0, TokenManagerProvider tokenManagerProvider0, ApplicationInfo applicationInfo0, ContextInfo contextInfo0, ApprovalType approvalType0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            Object object0 = ApiFactoryKt.getKauth(ApiFactory.INSTANCE).b(AuthApi.class);
            q.f(object0, "ApiFactory.kauth.create(AuthApi::class.java)");
            authApi0 = (AuthApi)object0;
        }
        if((v & 2) != 0) {
            tokenManagerProvider0 = TokenManagerProvider.Companion.getInstance();
        }
        if((v & 4) != 0) {
            applicationInfo0 = KakaoSdk.INSTANCE.getApplicationContextInfo();
        }
        if((v & 8) != 0) {
            contextInfo0 = KakaoSdk.INSTANCE.getApplicationContextInfo();
        }
        if((v & 16) != 0) {
            approvalType0 = KakaoSdk.INSTANCE.getApprovalType();
        }
        this(authApi0, tokenManagerProvider0, applicationInfo0, contextInfo0, approvalType0);
    }

    public final void agt$auth_release(@NotNull we.n n0) {
        H h0;
        q.g(n0, "callback");
        OAuthToken oAuthToken0 = this.tokenManagerProvider.getManager().getToken();
        if(oAuthToken0 == null) {
            h0 = null;
        }
        else {
            String s = oAuthToken0.getAccessToken();
            if(s == null) {
                h0 = null;
            }
            else {
                String s1 = this.applicationInfo.getAppKey();
                this.authApi.agt(s1, s).enqueue(new tg.g() {
                    @Override  // tg.g
                    public void onFailure(@NotNull d d0, @NotNull Throwable throwable0) {
                        q.g(d0, "call");
                        q.g(throwable0, "t");
                        this.$callback.invoke(null, throwable0);
                    }

                    @Override  // tg.g
                    public void onResponse(@NotNull d d0, @NotNull Q q0) {
                        q.g(d0, "call");
                        q.g(q0, "response");
                        AgtResponse agtResponse0 = (AgtResponse)q0.b;
                        if(agtResponse0 != null) {
                            this.$callback.invoke(agtResponse0.getAgt(), null);
                            return;
                        }
                        p p0 = new p(q0);
                        Throwable throwable0 = AuthApiManager.Companion.translateError(p0);
                        this.$callback.invoke(null, throwable0);
                    }
                });
                h0 = H.a;
            }
        }
        if(h0 == null) {
            n0.invoke(null, new ClientError(ClientErrorCause.TokenNotFound, "Access token not found. You must login first."));
        }
    }

    @NotNull
    public final ApplicationInfo getApplicationInfo() {
        return this.applicationInfo;
    }

    @NotNull
    public final ApprovalType getApprovalType() {
        return this.approvalType;
    }

    @NotNull
    public final ContextInfo getContextInfo() {
        return this.contextInfo;
    }

    @NotNull
    public static final AuthApiManager getInstance() {
        return AuthApiManager.Companion.getInstance();
    }

    @NotNull
    public final TokenManagerProvider getTokenManagerProvider() {
        return this.tokenManagerProvider;
    }

    public final boolean hasToken$auth_release() {
        return this.tokenManagerProvider.getManager().getToken() != null;
    }

    public final void issueAccessToken$auth_release(@NotNull String s, @Nullable String s1, @NotNull we.n n0) {
        q.g(s, "code");
        q.g(n0, "callback");
        String s2 = this.applicationInfo.getAppKey();
        String s3 = this.contextInfo.getSigningKeyHash();
        String s4 = this.applicationInfo.getRedirectUri();
        DefaultImpls.issueAccessToken$default(this.authApi, s2, s3, s, s4, s1, this.approvalType.getValue(), null, 0x40, null).enqueue(new tg.g() {
            @Override  // tg.g
            public void onFailure(@NotNull d d0, @NotNull Throwable throwable0) {
                q.g(d0, "call");
                q.g(throwable0, "t");
                this.invoke(null, throwable0);
            }

            @Override  // tg.g
            public void onResponse(@NotNull d d0, @NotNull Q q0) {
                q.g(d0, "call");
                q.g(q0, "response");
                if(q0.a.isSuccessful()) {
                    AccessTokenResponse accessTokenResponse0 = (AccessTokenResponse)q0.b;
                    if(accessTokenResponse0 != null) {
                        OAuthToken oAuthToken0 = com.kakao.sdk.auth.model.OAuthToken.Companion.fromResponse$default(OAuthToken.Companion, accessTokenResponse0, null, 2, null);
                        AuthApiManager.this.getTokenManagerProvider().getManager().setToken(oAuthToken0);
                        this.invoke(oAuthToken0, null);
                        return;
                    }
                    ClientError clientError0 = new ClientError(ClientErrorCause.Unknown, "No body");
                    this.invoke(null, clientError0);
                    return;
                }
                p p0 = new p(q0);
                Throwable throwable0 = AuthApiManager.Companion.translateError(p0);
                this.invoke(null, throwable0);
            }
        });
    }

    public static void issueAccessToken$auth_release$default(AuthApiManager authApiManager0, String s, String s1, we.n n0, int v, Object object0) {
        if((v & 2) != 0) {
            s1 = null;
        }
        authApiManager0.issueAccessToken$auth_release(s, s1, n0);
    }

    public final void issueAccessTokenWithCert$auth_release(@NotNull String s, @Nullable String s1, @NotNull we.n n0) {
        q.g(s, "code");
        q.g(n0, "callback");
        String s2 = this.applicationInfo.getAppKey();
        String s3 = this.contextInfo.getSigningKeyHash();
        String s4 = this.applicationInfo.getRedirectUri();
        DefaultImpls.issueAccessToken$default(this.authApi, s2, s3, s, s4, s1, this.approvalType.getValue(), null, 0x40, null).enqueue(new tg.g() {
            @Override  // tg.g
            public void onFailure(@NotNull d d0, @NotNull Throwable throwable0) {
                q.g(d0, "call");
                q.g(throwable0, "t");
                this.invoke(null, throwable0);
            }

            @Override  // tg.g
            public void onResponse(@NotNull d d0, @NotNull Q q0) {
                q.g(d0, "call");
                q.g(q0, "response");
                if(q0.a.isSuccessful()) {
                    AccessTokenResponse accessTokenResponse0 = (AccessTokenResponse)q0.b;
                    if(accessTokenResponse0 != null) {
                        we.n n0 = this;
                        AuthApiManager authApiManager0 = AuthApiManager.this;
                        OAuthToken oAuthToken0 = com.kakao.sdk.auth.model.OAuthToken.Companion.fromResponse$default(OAuthToken.Companion, accessTokenResponse0, null, 2, null);
                        String s = accessTokenResponse0.getTxId();
                        if(s == null) {
                            n0.invoke(null, new ClientError(ClientErrorCause.Unknown, "txId is null"));
                            return;
                        }
                        authApiManager0.getTokenManagerProvider().getManager().setToken(oAuthToken0);
                        n0.invoke(new CertTokenInfo(oAuthToken0, s), null);
                        return;
                    }
                    ClientError clientError0 = new ClientError(ClientErrorCause.Unknown, "No body");
                    this.invoke(null, clientError0);
                    return;
                }
                p p0 = new p(q0);
                Throwable throwable0 = AuthApiManager.Companion.translateError(p0);
                this.invoke(null, throwable0);
            }
        });
    }

    public static void issueAccessTokenWithCert$auth_release$default(AuthApiManager authApiManager0, String s, String s1, we.n n0, int v, Object object0) {
        if((v & 2) != 0) {
            s1 = null;
        }
        authApiManager0.issueAccessTokenWithCert$auth_release(s, s1, n0);
    }

    public final void prepare$auth_release(@Nullable String s, @Nullable List list0, @Nullable String s1, @Nullable String s2, @NotNull CertType certType0, @NotNull we.n n0) {
        q.g(certType0, "certType");
        q.g(n0, "callback");
        String s3 = this.applicationInfo.getAppKey();
        String s4 = list0 == null || list0.isEmpty() ? null : je.p.q0(list0, ",", null, null, com.kakao.sdk.auth.AuthApiManager.prepare.1.INSTANCE, 30);
        this.authApi.prepare(s3, s, s4, s1, s2, certType0.getValue()).enqueue(new tg.g() {
            @Override  // tg.g
            public void onFailure(@NotNull d d0, @NotNull Throwable throwable0) {
                q.g(d0, "call");
                q.g(throwable0, "t");
                this.$callback.invoke(null, throwable0);
            }

            @Override  // tg.g
            public void onResponse(@NotNull d d0, @NotNull Q q0) {
                q.g(d0, "call");
                q.g(q0, "response");
                if(q0.a.isSuccessful()) {
                    PrepareResponse prepareResponse0 = (PrepareResponse)q0.b;
                    if(prepareResponse0 != null) {
                        this.$callback.invoke(prepareResponse0.getKauthTxId(), null);
                        return;
                    }
                    ClientError clientError0 = new ClientError(ClientErrorCause.Unknown, "No body");
                    this.$callback.invoke(null, clientError0);
                    return;
                }
                p p0 = new p(q0);
                Throwable throwable0 = AuthApiManager.Companion.translateError(p0);
                this.$callback.invoke(null, throwable0);
            }
        });

        @Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/kakao/sdk/auth/model/IdentifyItem;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 0x30)
        final class com.kakao.sdk.auth.AuthApiManager.prepare.1 extends r implements k {
            public static final com.kakao.sdk.auth.AuthApiManager.prepare.1 INSTANCE;

            static {
                com.kakao.sdk.auth.AuthApiManager.prepare.1.INSTANCE = new com.kakao.sdk.auth.AuthApiManager.prepare.1();
            }

            public com.kakao.sdk.auth.AuthApiManager.prepare.1() {
                super(1);
            }

            @NotNull
            public final CharSequence invoke(@NotNull IdentifyItem identifyItem0) {
                q.g(identifyItem0, "it");
                CharSequence charSequence0 = identifyItem0.name().toLowerCase(Locale.ROOT);
                q.f(charSequence0, "toLowerCase(...)");
                return charSequence0;
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((IdentifyItem)object0));
            }
        }

    }

    public static void prepare$auth_release$default(AuthApiManager authApiManager0, String s, List list0, String s1, String s2, CertType certType0, we.n n0, int v, Object object0) {
        if((v & 1) != 0) {
            s = null;
        }
        if((v & 2) != 0) {
            list0 = null;
        }
        if((v & 4) != 0) {
            s1 = null;
        }
        if((v & 8) != 0) {
            s2 = null;
        }
        authApiManager0.prepare$auth_release(s, list0, s1, s2, certType0, n0);
    }

    @NotNull
    public final OAuthToken refreshToken$auth_release(@NotNull OAuthToken oAuthToken0) {
        q.g(oAuthToken0, "oldToken");
        String s = this.applicationInfo.getAppKey();
        String s1 = this.contextInfo.getSigningKeyHash();
        Q q0 = DefaultImpls.refreshToken$default(this.authApi, s, s1, oAuthToken0.getRefreshToken(), this.approvalType.getValue(), null, 16, null).execute();
        AccessTokenResponse accessTokenResponse0 = (AccessTokenResponse)q0.b;
        if(accessTokenResponse0 != null) {
            OAuthToken oAuthToken1 = OAuthToken.Companion.fromResponse(accessTokenResponse0, oAuthToken0);
            if(oAuthToken1 != null) {
                this.tokenManagerProvider.getManager().setToken(oAuthToken1);
                return oAuthToken1;
            }
        }
        p p0 = new p(q0);
        throw AuthApiManager.Companion.translateError(p0);
    }

    public final void refreshToken$auth_release(@NotNull OAuthToken oAuthToken0, @NotNull we.n n0) {
        q.g(oAuthToken0, "oldToken");
        q.g(n0, "callback");
        String s = this.applicationInfo.getAppKey();
        String s1 = this.contextInfo.getSigningKeyHash();
        DefaultImpls.refreshToken$default(this.authApi, s, s1, oAuthToken0.getRefreshToken(), this.approvalType.getValue(), null, 16, null).enqueue(new tg.g() {
            @Override  // tg.g
            public void onFailure(@NotNull d d0, @NotNull Throwable throwable0) {
                q.g(d0, "call");
                q.g(throwable0, "t");
                oAuthToken0.invoke(null, throwable0);
            }

            @Override  // tg.g
            public void onResponse(@NotNull d d0, @NotNull Q q0) {
                q.g(d0, "call");
                q.g(q0, "response");
                if(q0.a.isSuccessful()) {
                    AccessTokenResponse accessTokenResponse0 = (AccessTokenResponse)q0.b;
                    if(accessTokenResponse0 != null) {
                        OAuthToken oAuthToken0 = OAuthToken.Companion.fromResponse(accessTokenResponse0, this);
                        AuthApiManager.this.getTokenManagerProvider().getManager().setToken(oAuthToken0);
                        oAuthToken0.invoke(oAuthToken0, null);
                        return;
                    }
                    ClientError clientError0 = new ClientError(ClientErrorCause.Unknown, "No body");
                    oAuthToken0.invoke(null, clientError0);
                    return;
                }
                p p0 = new p(q0);
                Throwable throwable0 = AuthApiManager.Companion.translateError(p0);
                oAuthToken0.invoke(null, throwable0);
            }
        });
    }

    public final void refreshToken$auth_release(@NotNull we.n n0) {
        q.g(n0, "callback");
        AuthApiManager.refreshToken$auth_release$default(this, null, n0, 1, null);
    }

    public static OAuthToken refreshToken$auth_release$default(AuthApiManager authApiManager0, OAuthToken oAuthToken0, int v, Object object0) {
        if((v & 1) != 0) {
            oAuthToken0 = authApiManager0.tokenManagerProvider.getManager().getToken();
            if(oAuthToken0 == null) {
                throw new ClientError(ClientErrorCause.TokenNotFound, "Refresh token not found. You must login first.");
            }
        }
        return authApiManager0.refreshToken$auth_release(oAuthToken0);
    }

    public static void refreshToken$auth_release$default(AuthApiManager authApiManager0, OAuthToken oAuthToken0, we.n n0, int v, Object object0) {
        if((v & 1) != 0) {
            oAuthToken0 = authApiManager0.tokenManagerProvider.getManager().getToken();
            if(oAuthToken0 == null) {
                throw new ClientError(ClientErrorCause.TokenNotFound, "Refresh token not found. You must login first.");
            }
        }
        authApiManager0.refreshToken$auth_release(oAuthToken0, n0);
    }
}

