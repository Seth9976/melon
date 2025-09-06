package com.kakao.sdk.common.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\t\u0010\f\u001A\u00020\u0005HÆ\u0003J\u001D\u0010\r\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001A\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/kakao/sdk/common/model/ClientError;", "Lcom/kakao/sdk/common/model/KakaoSdkError;", "reason", "Lcom/kakao/sdk/common/model/ClientErrorCause;", "msg", "", "(Lcom/kakao/sdk/common/model/ClientErrorCause;Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "getReason", "()Lcom/kakao/sdk/common/model/ClientErrorCause;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ClientError extends KakaoSdkError {
    @NotNull
    private final String msg;
    @NotNull
    private final ClientErrorCause reason;

    public ClientError(@NotNull ClientErrorCause clientErrorCause0, @NotNull String s) {
        q.g(clientErrorCause0, "reason");
        q.g(s, "msg");
        super(s, null);
        this.reason = clientErrorCause0;
        this.msg = s;
    }

    public ClientError(ClientErrorCause clientErrorCause0, String s, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 2) != 0) {
            Description description0 = (Description)clientErrorCause0.getClass().getField(clientErrorCause0.name()).getAnnotation(Description.class);
            if(description0 == null) {
                s = "Client-side error";
            }
            else {
                s = description0.value();
                if(s == null) {
                    s = "Client-side error";
                }
            }
        }
        this(clientErrorCause0, s);
    }

    @NotNull
    public final ClientErrorCause component1() {
        return this.reason;
    }

    @NotNull
    public final String component2() {
        return this.getMsg();
    }

    @NotNull
    public final ClientError copy(@NotNull ClientErrorCause clientErrorCause0, @NotNull String s) {
        q.g(clientErrorCause0, "reason");
        q.g(s, "msg");
        return new ClientError(clientErrorCause0, s);
    }

    public static ClientError copy$default(ClientError clientError0, ClientErrorCause clientErrorCause0, String s, int v, Object object0) {
        if((v & 1) != 0) {
            clientErrorCause0 = clientError0.reason;
        }
        if((v & 2) != 0) {
            s = clientError0.getMsg();
        }
        return clientError0.copy(clientErrorCause0, s);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ClientError)) {
            return false;
        }
        return this.reason == ((ClientError)object0).reason ? q.b(this.getMsg(), ((ClientError)object0).getMsg()) : false;
    }

    @Override  // com.kakao.sdk.common.model.KakaoSdkError
    @NotNull
    public String getMsg() {
        return this.msg;
    }

    @NotNull
    public final ClientErrorCause getReason() {
        return this.reason;
    }

    @Override
    public int hashCode() {
        return this.getMsg().hashCode() + this.reason.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "ClientError(reason=" + this.reason + ", msg=" + this.getMsg() + ")";
    }
}

