package com.facebook;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001A\u00020\u0005H\u0016R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/facebook/FacebookGraphResponseException;", "Lcom/facebook/FacebookException;", "graphResponse", "Lcom/facebook/GraphResponse;", "errorMessage", "", "(Lcom/facebook/GraphResponse;Ljava/lang/String;)V", "getGraphResponse", "()Lcom/facebook/GraphResponse;", "toString", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FacebookGraphResponseException extends FacebookException {
    @Nullable
    private final GraphResponse graphResponse;

    public FacebookGraphResponseException(@Nullable GraphResponse graphResponse0, @Nullable String s) {
        super(s);
        this.graphResponse = graphResponse0;
    }

    @Nullable
    public final GraphResponse getGraphResponse() {
        return this.graphResponse;
    }

    @Override  // com.facebook.FacebookException
    @NotNull
    public String toString() {
        FacebookRequestError facebookRequestError0 = this.graphResponse == null ? null : this.graphResponse.getError();
        StringBuilder stringBuilder0 = new StringBuilder("{FacebookGraphResponseException: ");
        String s = this.getMessage();
        if(s != null) {
            stringBuilder0.append(s);
            stringBuilder0.append(" ");
        }
        if(facebookRequestError0 != null) {
            stringBuilder0.append("httpResponseCode: ");
            stringBuilder0.append(facebookRequestError0.getRequestStatusCode());
            stringBuilder0.append(", facebookErrorCode: ");
            stringBuilder0.append(facebookRequestError0.getErrorCode());
            stringBuilder0.append(", facebookErrorType: ");
            stringBuilder0.append(facebookRequestError0.getErrorType());
            stringBuilder0.append(", message: ");
            stringBuilder0.append(facebookRequestError0.getErrorMessage());
            stringBuilder0.append("}");
        }
        String s1 = stringBuilder0.toString();
        q.f(s1, "errorStringBuilder.toString()");
        return s1;
    }
}

