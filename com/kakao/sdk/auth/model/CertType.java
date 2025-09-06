package com.kakao.sdk.auth.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/kakao/sdk/auth/model/CertType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "K2100", "K2220", "K3220", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public enum CertType {
    K2100("k2100"),
    K2220("k2220"),
    K3220("k3220");

    @NotNull
    private final String value;

    private static final CertType[] $values() [...] // Inlined contents

    private CertType(String s1) {
        this.value = s1;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}

