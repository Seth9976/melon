package com.melon.net.res.v3;

import S7.b;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000B\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/melon/net/res/v3/AuthHsJsonRes;", "Lcom/melon/net/res/v3/CmtBaseRes;", "<init>", "()V", "authKey", "", "getAuthKey", "()Ljava/lang/String;", "setAuthKey", "(Ljava/lang/String;)V", "file", "getFile", "setFile", "authTime", "getAuthTime", "setAuthTime", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class AuthHsJsonRes extends CmtBaseRes {
    public static final int $stable = 8;
    @b("authKey")
    @Nullable
    private String authKey;
    @b("authTime")
    @Nullable
    private String authTime;
    @b("file")
    @Nullable
    private String file;

    @Nullable
    public final String getAuthKey() {
        return this.authKey;
    }

    @Nullable
    public final String getAuthTime() {
        return this.authTime;
    }

    @Nullable
    public final String getFile() {
        return this.file;
    }

    public final void setAuthKey(@Nullable String s) {
        this.authKey = s;
    }

    public final void setAuthTime(@Nullable String s) {
        this.authTime = s;
    }

    public final void setFile(@Nullable String s) {
        this.file = s;
    }
}

