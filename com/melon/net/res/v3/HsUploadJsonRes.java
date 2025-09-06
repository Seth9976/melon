package com.melon.net.res.v3;

import S7.b;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001E\u0010\n\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001E\u0010\u0010\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000FR\u001E\u0010\u0013\u001A\u00020\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000FR\u0011\u0010\u0016\u001A\u00020\u000B8F¢\u0006\u0006\u001A\u0004\b\u0017\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/melon/net/res/v3/HsUploadJsonRes;", "Lcom/melon/net/res/v3/CmtBaseRes;", "<init>", "()V", "code", "", "getCode", "()I", "setCode", "(I)V", "msg", "", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "file", "getFile", "setFile", "uploadtime", "getUploadtime", "setUploadtime", "fileUrl", "getFileUrl", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class HsUploadJsonRes extends CmtBaseRes {
    public static final int $stable = 8;
    @b("code")
    private int code;
    @b("file")
    @NotNull
    private String file;
    @b("msg")
    @NotNull
    private String msg;
    @b("uploadtime")
    @NotNull
    private String uploadtime;

    public HsUploadJsonRes() {
        this.msg = "";
        this.file = "";
        this.uploadtime = "";
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getFile() {
        return this.file;
    }

    @NotNull
    public final String getFileUrl() [...] // 潜在的解密器

    @NotNull
    public final String getMsg() {
        return this.msg;
    }

    @NotNull
    public final String getUploadtime() {
        return this.uploadtime;
    }

    public final void setCode(int v) {
        this.code = v;
    }

    public final void setFile(@NotNull String s) {
        q.g(s, "<set-?>");
        this.file = s;
    }

    public final void setMsg(@NotNull String s) {
        q.g(s, "<set-?>");
        this.msg = s;
    }

    public final void setUploadtime(@NotNull String s) {
        q.g(s, "<set-?>");
        this.uploadtime = s;
    }
}

