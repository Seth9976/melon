package com.kakao.sdk.auth;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tg.d;
import vg.c;
import vg.e;
import vg.o;

@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J_\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\b\b\u0001\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\u0004\u001A\u00020\u00022\b\b\u0001\u0010\u0005\u001A\u00020\u00022\b\b\u0001\u0010\u0006\u001A\u00020\u00022\n\b\u0003\u0010\u0007\u001A\u0004\u0018\u00010\u00022\n\b\u0003\u0010\b\u001A\u0004\u0018\u00010\u00022\b\b\u0003\u0010\t\u001A\u00020\u0002H\'¢\u0006\u0004\b\f\u0010\rJI\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\b\b\u0001\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\u0004\u001A\u00020\u00022\b\b\u0001\u0010\u000E\u001A\u00020\u00022\n\b\u0003\u0010\b\u001A\u0004\u0018\u00010\u00022\b\b\u0003\u0010\t\u001A\u00020\u0002H\'¢\u0006\u0004\b\u000E\u0010\u000FJ)\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00110\n2\b\b\u0001\u0010\u0003\u001A\u00020\u00022\b\b\u0001\u0010\u0010\u001A\u00020\u0002H\'¢\u0006\u0004\b\u0012\u0010\u0013JY\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00190\n2\b\b\u0001\u0010\u0003\u001A\u00020\u00022\n\b\u0003\u0010\u0014\u001A\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0015\u001A\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0016\u001A\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0017\u001A\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0018\u001A\u00020\u0002H\'¢\u0006\u0004\b\u001A\u0010\u001B¨\u0006\u001C"}, d2 = {"Lcom/kakao/sdk/auth/AuthApi;", "", "", "clientId", "androidKeyHash", "code", "redirectUri", "codeVerifier", "approvalType", "grantType", "Ltg/d;", "Lcom/kakao/sdk/auth/model/AccessTokenResponse;", "issueAccessToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ltg/d;", "refreshToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ltg/d;", "accessToken", "Lcom/kakao/sdk/auth/model/AgtResponse;", "agt", "(Ljava/lang/String;Ljava/lang/String;)Ltg/d;", "settleId", "signIdentifyItems", "signData", "txId", "certType", "Lcom/kakao/sdk/auth/model/PrepareResponse;", "prepare", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ltg/d;", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public interface AuthApi {
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 0x30)
    public static final class DefaultImpls {
        public static d issueAccessToken$default(AuthApi authApi0, String s, String s1, String s2, String s3, String s4, String s5, String s6, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: issueAccessToken");
            }
            if((v & 16) != 0) {
                s4 = null;
            }
            if((v & 0x20) != 0) {
                s5 = null;
            }
            if((v & 0x40) != 0) {
                s6 = "authorization_code";
            }
            return authApi0.issueAccessToken(s, s1, s2, s3, s4, s5, s6);
        }

        public static d prepare$default(AuthApi authApi0, String s, String s1, String s2, String s3, String s4, String s5, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: prepare");
            }
            if((v & 2) != 0) {
                s1 = null;
            }
            if((v & 4) != 0) {
                s2 = null;
            }
            if((v & 8) != 0) {
                s3 = null;
            }
            if((v & 16) != 0) {
                s4 = null;
            }
            return authApi0.prepare(s, s1, s2, s3, s4, s5);
        }

        public static d refreshToken$default(AuthApi authApi0, String s, String s1, String s2, String s3, String s4, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshToken");
            }
            if((v & 8) != 0) {
                s3 = null;
            }
            if((v & 16) != 0) {
                s4 = "refresh_token";
            }
            return authApi0.refreshToken(s, s1, s2, s3, s4);
        }
    }

    @NotNull
    @e
    @o("api/agt")
    d agt(@NotNull @c("client_id") String arg1, @NotNull @c("access_token") String arg2);

    @NotNull
    @e
    @o("oauth/token")
    d issueAccessToken(@NotNull @c("client_id") String arg1, @NotNull @c("android_key_hash") String arg2, @NotNull @c("code") String arg3, @NotNull @c("redirect_uri") String arg4, @Nullable @c("code_verifier") String arg5, @Nullable @c("approval_type") String arg6, @NotNull @c("grant_type") String arg7);

    @NotNull
    @e
    @o("oauth/authorize/prepare")
    d prepare(@NotNull @c("client_id") String arg1, @Nullable @c("settle_id") String arg2, @Nullable @c("sign_identify_items") String arg3, @Nullable @c("sign_data") String arg4, @Nullable @c("tx_id") String arg5, @NotNull @c("cert_type") String arg6);

    @NotNull
    @e
    @o("oauth/token")
    d refreshToken(@NotNull @c("client_id") String arg1, @NotNull @c("android_key_hash") String arg2, @NotNull @c("refresh_token") String arg3, @Nullable @c("approval_type") String arg4, @NotNull @c("grant_type") String arg5);
}

