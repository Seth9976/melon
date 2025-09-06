package com.melon.net.res.v3;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000E\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001A\u0010\n\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR\u001A\u0010\r\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR\u001A\u0010\u0010\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001A\u0010\u0013\u001A\u00020\u0014X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001A\u0010\u0019\u001A\u00020\u0014X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0016\"\u0004\b\u001B\u0010\u0018¨\u0006\u001C"}, d2 = {"Lcom/melon/net/res/v3/AttachList;", "", "<init>", "()V", "attachType", "", "getAttachType", "()Ljava/lang/String;", "setAttachType", "(Ljava/lang/String;)V", "attachValue", "getAttachValue", "setAttachValue", "attachThumbUrl", "getAttachThumbUrl", "setAttachThumbUrl", "attachVideoTitle", "getAttachVideoTitle", "setAttachVideoTitle", "attachVideoWidth", "", "getAttachVideoWidth", "()I", "setAttachVideoWidth", "(I)V", "attachVideoHeight", "getAttachVideoHeight", "setAttachVideoHeight", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class AttachList {
    public static final int $stable = 8;
    @NotNull
    private String attachThumbUrl;
    @NotNull
    private String attachType;
    @NotNull
    private String attachValue;
    private int attachVideoHeight;
    @NotNull
    private String attachVideoTitle;
    private int attachVideoWidth;

    public AttachList() {
        this.attachType = "";
        this.attachValue = "";
        this.attachThumbUrl = "";
        this.attachVideoTitle = "";
        this.attachVideoWidth = -1;
        this.attachVideoHeight = -1;
    }

    @NotNull
    public final String getAttachThumbUrl() [...] // 潜在的解密器

    @NotNull
    public final String getAttachType() [...] // 潜在的解密器

    @NotNull
    public final String getAttachValue() [...] // 潜在的解密器

    public final int getAttachVideoHeight() {
        return this.attachVideoHeight;
    }

    @NotNull
    public final String getAttachVideoTitle() [...] // 潜在的解密器

    public final int getAttachVideoWidth() {
        return this.attachVideoWidth;
    }

    public final void setAttachThumbUrl(@NotNull String s) {
        q.g(s, "<set-?>");
        this.attachThumbUrl = s;
    }

    public final void setAttachType(@NotNull String s) {
        q.g(s, "<set-?>");
        this.attachType = s;
    }

    public final void setAttachValue(@NotNull String s) {
        q.g(s, "<set-?>");
        this.attachValue = s;
    }

    public final void setAttachVideoHeight(int v) {
        this.attachVideoHeight = v;
    }

    public final void setAttachVideoTitle(@NotNull String s) {
        q.g(s, "<set-?>");
        this.attachVideoTitle = s;
    }

    public final void setAttachVideoWidth(int v) {
        this.attachVideoWidth = v;
    }
}

