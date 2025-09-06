package com.kakao.sdk.auth;

import com.kakao.sdk.auth.model.OAuthToken;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001A\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/kakao/sdk/auth/TokenManageable;", "", "Lcom/kakao/sdk/auth/model/OAuthToken;", "getToken", "()Lcom/kakao/sdk/auth/model/OAuthToken;", "token", "Lie/H;", "setToken", "(Lcom/kakao/sdk/auth/model/OAuthToken;)V", "clear", "()V", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public interface TokenManageable {
    void clear();

    @Nullable
    OAuthToken getToken();

    void setToken(@NotNull OAuthToken arg1);
}

