package com.facebook;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \r2\u00020\u0001:\u0001\rB!\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001A\u00020\u0003H\u0016R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u000E"}, d2 = {"Lcom/facebook/FacebookDialogException;", "Lcom/facebook/FacebookException;", "message", "", "errorCode", "", "failingUrl", "(Ljava/lang/String;ILjava/lang/String;)V", "getErrorCode", "()I", "getFailingUrl", "()Ljava/lang/String;", "toString", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FacebookDialogException extends FacebookException {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/FacebookDialogException$Companion;", "", "()V", "serialVersionUID", "", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion = null;
    private final int errorCode;
    @Nullable
    private final String failingUrl;
    public static final long serialVersionUID = 1L;

    static {
        FacebookDialogException.Companion = new Companion(null);
    }

    public FacebookDialogException(@Nullable String s, int v, @Nullable String s1) {
        super(s);
        this.errorCode = v;
        this.failingUrl = s1;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    public final String getFailingUrl() {
        return this.failingUrl;
    }

    @Override  // com.facebook.FacebookException
    @NotNull
    public String toString() {
        String s = "{FacebookDialogException: errorCode: " + this.errorCode + ", message: " + this.getMessage() + ", url: " + this.failingUrl + "}";
        q.f(s, "StringBuilder()\n        …(\"}\")\n        .toString()");
        return s;
    }
}

