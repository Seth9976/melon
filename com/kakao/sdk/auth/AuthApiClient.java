package com.kakao.sdk.auth;

import com.kakao.sdk.auth.model.CertType;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.model.ClientError;
import com.kakao.sdk.common.model.ClientErrorCause;
import d3.g;
import ie.d;
import ie.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 +2\u00020\u0001:\u0001+B\u001B\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b\t\u0010\nJ?\u0010\u0013\u001A\u00020\u00112\u0006\u0010\f\u001A\u00020\u000B2\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000B2\u001C\u0010\u0012\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000F\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00110\u000E\u00A2\u0006\u0004\b\u0013\u0010\u0014J?\u0010\u0016\u001A\u00020\u00112\u0006\u0010\f\u001A\u00020\u000B2\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u000B2\u001C\u0010\u0012\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00110\u000E\u00A2\u0006\u0004\b\u0016\u0010\u0014J7\u0010\u0018\u001A\u00020\u00112\b\b\u0002\u0010\u0017\u001A\u00020\u000F2\u001C\u0010\u0012\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000F\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00110\u000EH\u0007\u00A2\u0006\u0004\b\u0018\u0010\u0019J7\u0010\u001A\u001A\u00020\u00112\b\b\u0002\u0010\u0017\u001A\u00020\u000F2\u001C\u0010\u0012\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000F\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00110\u000EH\u0007\u00A2\u0006\u0004\b\u001A\u0010\u0019J+\u0010\u001B\u001A\u00020\u00112\u001C\u0010\u0012\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000B\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00110\u000E\u00A2\u0006\u0004\b\u001B\u0010\u001CJi\u0010%\u001A\u00020\u00112\n\b\u0002\u0010\u001D\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010\u001E\u001A\u0004\u0018\u00010\u000B2\n\b\u0002\u0010\u001F\u001A\u0004\u0018\u00010\u000B2\u0010\b\u0002\u0010\"\u001A\n\u0012\u0004\u0012\u00020!\u0018\u00010 2\u0006\u0010$\u001A\u00020#2\u001C\u0010\u0012\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000B\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00110\u000E\u00A2\u0006\u0004\b%\u0010&R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010\'R\u0017\u0010\u0005\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010(\u001A\u0004\b)\u0010*\u00A8\u0006,"}, d2 = {"Lcom/kakao/sdk/auth/AuthApiClient;", "", "Lcom/kakao/sdk/auth/AuthApiManager;", "manager", "Lcom/kakao/sdk/auth/TokenManagerProvider;", "tokenManagerProvider", "<init>", "(Lcom/kakao/sdk/auth/AuthApiManager;Lcom/kakao/sdk/auth/TokenManagerProvider;)V", "", "hasToken", "()Z", "", "code", "codeVerifier", "Lkotlin/Function2;", "Lcom/kakao/sdk/auth/model/OAuthToken;", "", "Lie/H;", "callback", "issueAccessToken", "(Ljava/lang/String;Ljava/lang/String;Lwe/n;)V", "Lcom/kakao/sdk/auth/model/CertTokenInfo;", "issueAccessTokenWithCert", "oldToken", "refreshAccessToken", "(Lcom/kakao/sdk/auth/model/OAuthToken;Lwe/n;)V", "refreshToken", "agt", "(Lwe/n;)V", "settleId", "signData", "txId", "", "Lcom/kakao/sdk/auth/model/IdentifyItem;", "identifyItems", "Lcom/kakao/sdk/auth/model/CertType;", "certType", "prepare", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/kakao/sdk/auth/model/CertType;Lwe/n;)V", "Lcom/kakao/sdk/auth/AuthApiManager;", "Lcom/kakao/sdk/auth/TokenManagerProvider;", "getTokenManagerProvider", "()Lcom/kakao/sdk/auth/TokenManagerProvider;", "Companion", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AuthApiClient {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R!\u0010\n\u001A\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001A\u0004\b\u0007\u0010\b¨\u0006\u000B"}, d2 = {"Lcom/kakao/sdk/auth/AuthApiClient$Companion;", "", "<init>", "()V", "Lcom/kakao/sdk/auth/AuthApiClient;", "instance$delegate", "Lie/j;", "getInstance", "()Lcom/kakao/sdk/auth/AuthApiClient;", "getInstance$annotations", "instance", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final AuthApiClient getInstance() {
            return (AuthApiClient)AuthApiClient.instance$delegate.getValue();
        }

        public static void getInstance$annotations() {
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final j instance$delegate;
    @NotNull
    private final AuthApiManager manager;
    @NotNull
    private final TokenManagerProvider tokenManagerProvider;

    static {
        AuthApiClient.Companion = new Companion(null);
        AuthApiClient.instance$delegate = g.Q(AuthApiClient.Companion.instance.2.INSTANCE);
    }

    public AuthApiClient() {
        this(null, null, 3, null);
    }

    public AuthApiClient(@NotNull AuthApiManager authApiManager0, @NotNull TokenManagerProvider tokenManagerProvider0) {
        q.g(authApiManager0, "manager");
        q.g(tokenManagerProvider0, "tokenManagerProvider");
        super();
        this.manager = authApiManager0;
        this.tokenManagerProvider = tokenManagerProvider0;
    }

    public AuthApiClient(AuthApiManager authApiManager0, TokenManagerProvider tokenManagerProvider0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            authApiManager0 = AuthApiManager.Companion.getInstance();
        }
        if((v & 2) != 0) {
            tokenManagerProvider0 = TokenManagerProvider.Companion.getInstance();
        }
        this(authApiManager0, tokenManagerProvider0);
    }

    public final void agt(@NotNull n n0) {
        q.g(n0, "callback");
        this.manager.agt$auth_release(n0);
    }

    @NotNull
    public static final AuthApiClient getInstance() {
        return AuthApiClient.Companion.getInstance();
    }

    @NotNull
    public final TokenManagerProvider getTokenManagerProvider() {
        return this.tokenManagerProvider;
    }

    public final boolean hasToken() {
        return this.manager.hasToken$auth_release();
    }

    public final void issueAccessToken(@NotNull String s, @Nullable String s1, @NotNull n n0) {
        q.g(s, "code");
        q.g(n0, "callback");
        this.manager.issueAccessToken$auth_release(s, s1, n0);
    }

    public static void issueAccessToken$default(AuthApiClient authApiClient0, String s, String s1, n n0, int v, Object object0) {
        if((v & 2) != 0) {
            s1 = null;
        }
        authApiClient0.issueAccessToken(s, s1, n0);
    }

    public final void issueAccessTokenWithCert(@NotNull String s, @Nullable String s1, @NotNull n n0) {
        q.g(s, "code");
        q.g(n0, "callback");
        this.manager.issueAccessTokenWithCert$auth_release(s, s1, n0);
    }

    public static void issueAccessTokenWithCert$default(AuthApiClient authApiClient0, String s, String s1, n n0, int v, Object object0) {
        if((v & 2) != 0) {
            s1 = null;
        }
        authApiClient0.issueAccessTokenWithCert(s, s1, n0);
    }

    public final void prepare(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable List list0, @NotNull CertType certType0, @NotNull n n0) {
        q.g(certType0, "certType");
        q.g(n0, "callback");
        this.manager.prepare$auth_release(s, list0, s1, s2, certType0, n0);
    }

    public static void prepare$default(AuthApiClient authApiClient0, String s, String s1, String s2, List list0, CertType certType0, n n0, int v, Object object0) {
        if((v & 1) != 0) {
            s = null;
        }
        if((v & 2) != 0) {
            s1 = null;
        }
        if((v & 4) != 0) {
            s2 = null;
        }
        if((v & 8) != 0) {
            list0 = null;
        }
        authApiClient0.prepare(s, s1, s2, list0, certType0, n0);
    }

    @d
    public final void refreshAccessToken(@NotNull OAuthToken oAuthToken0, @NotNull n n0) {
        q.g(oAuthToken0, "oldToken");
        q.g(n0, "callback");
        this.manager.refreshToken$auth_release(oAuthToken0, n0);
    }

    @d
    public final void refreshAccessToken(@NotNull n n0) {
        q.g(n0, "callback");
        AuthApiClient.refreshAccessToken$default(this, null, n0, 1, null);
    }

    public static void refreshAccessToken$default(AuthApiClient authApiClient0, OAuthToken oAuthToken0, n n0, int v, Object object0) {
        if((v & 1) != 0) {
            oAuthToken0 = authApiClient0.tokenManagerProvider.getManager().getToken();
            if(oAuthToken0 == null) {
                throw new ClientError(ClientErrorCause.TokenNotFound, "Refresh token not found. You must login first.");
            }
        }
        authApiClient0.refreshAccessToken(oAuthToken0, n0);
    }

    public final void refreshToken(@NotNull OAuthToken oAuthToken0, @NotNull n n0) {
        q.g(oAuthToken0, "oldToken");
        q.g(n0, "callback");
        this.manager.refreshToken$auth_release(oAuthToken0, n0);
    }

    public final void refreshToken(@NotNull n n0) {
        q.g(n0, "callback");
        AuthApiClient.refreshToken$default(this, null, n0, 1, null);
    }

    public static void refreshToken$default(AuthApiClient authApiClient0, OAuthToken oAuthToken0, n n0, int v, Object object0) {
        if((v & 1) != 0) {
            oAuthToken0 = authApiClient0.tokenManagerProvider.getManager().getToken();
            if(oAuthToken0 == null) {
                throw new ClientError(ClientErrorCause.TokenNotFound, "Refresh token not found. You must login first.");
            }
        }
        authApiClient0.refreshToken(oAuthToken0, n0);
    }
}

