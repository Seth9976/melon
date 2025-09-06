package com.kakao.sdk.auth.model;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.serialization.SerialName;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001A\u00020\u00048F¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000B"}, d2 = {"Lcom/kakao/sdk/auth/model/Prompt;", "", "(Ljava/lang/String;I)V", "value", "", "getValue", "()Ljava/lang/String;", "LOGIN", "CREATE", "SELECT_ACCOUNT", "CERT", "auth_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public enum Prompt {
    @SerialName("login")
    LOGIN,
    @SerialName("create")
    CREATE,
    @SerialName("select_account")
    SELECT_ACCOUNT,
    @SerialName("cert")
    CERT;

    private static final Prompt[] $values() [...] // Inlined contents

    @NotNull
    public final String getValue() {
        Annotation annotation0 = Prompt.class.getField(this.name()).getAnnotation(SerialName.class);
        q.d(annotation0);
        return ((SerialName)annotation0).value();
    }
}

