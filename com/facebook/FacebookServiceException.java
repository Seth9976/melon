package com.facebook;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001A\u00020\u0005H\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u000B"}, d2 = {"Lcom/facebook/FacebookServiceException;", "Lcom/facebook/FacebookException;", "requestError", "Lcom/facebook/FacebookRequestError;", "errorMessage", "", "(Lcom/facebook/FacebookRequestError;Ljava/lang/String;)V", "getRequestError", "()Lcom/facebook/FacebookRequestError;", "toString", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FacebookServiceException extends FacebookException {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/FacebookServiceException$Companion;", "", "()V", "serialVersionUID", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private final FacebookRequestError requestError;
    private static final long serialVersionUID = 1L;

    static {
        FacebookServiceException.Companion = new Companion(null);
    }

    public FacebookServiceException(@NotNull FacebookRequestError facebookRequestError0, @Nullable String s) {
        q.g(facebookRequestError0, "requestError");
        super(s);
        this.requestError = facebookRequestError0;
    }

    @NotNull
    public final FacebookRequestError getRequestError() {
        return this.requestError;
    }

    @Override  // com.facebook.FacebookException
    @NotNull
    public String toString() {
        String s = "{FacebookServiceException: httpResponseCode: " + this.requestError.getRequestStatusCode() + ", facebookErrorCode: " + this.requestError.getErrorCode() + ", facebookErrorType: " + this.requestError.getErrorType() + ", message: " + this.requestError.getErrorMessage() + "}";
        q.f(s, "StringBuilder()\n        …(\"}\")\n        .toString()");
        return s;
    }
}

