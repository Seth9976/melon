package com.facebook.login;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/login/CodeChallengeMethod;", "", "s", "", "(Ljava/lang/String;ILjava/lang/String;)V", "S256", "PLAIN", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public enum CodeChallengeMethod {
    S256("S256"),
    PLAIN("plain");

    private static final CodeChallengeMethod[] $values() [...] // Inlined contents

    private CodeChallengeMethod(String s1) {
    }

    public CodeChallengeMethod(String s1, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 1) != 0) {
            s1 = "S256";
        }
        this(s1);
    }
}

