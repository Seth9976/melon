package com.melon.net.res;

import S7.b;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001E\u0010\n\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/melon/net/res/RedDotInfo;", "", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "expiration", "getExpiration", "setExpiration", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class RedDotInfo {
    public static final int $stable = 8;
    @b("expiration")
    @NotNull
    private String expiration;
    @b("id")
    @NotNull
    private String id;

    public RedDotInfo() {
        this.id = "";
        this.expiration = "";
    }

    @NotNull
    public final String getExpiration() {
        return this.expiration;
    }

    @NotNull
    public final String getId() [...] // 潜在的解密器

    public final void setExpiration(@NotNull String s) {
        q.g(s, "<set-?>");
        this.expiration = s;
    }

    public final void setId(@NotNull String s) {
        q.g(s, "<set-?>");
        this.id = s;
    }
}

