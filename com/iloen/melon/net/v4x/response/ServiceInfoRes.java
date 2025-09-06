package com.iloen.melon.net.v4x.response;

import S7.b;
import com.google.gson.t;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001A\u00020\u000BH\u0016R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/iloen/melon/net/v4x/response/ServiceInfoRes;", "Lcom/iloen/melon/net/v4x/response/ResponseV4Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v4x/response/ServiceInfoRes$Response;", "getResponse", "()Lcom/iloen/melon/net/v4x/response/ServiceInfoRes$Response;", "setResponse", "(Lcom/iloen/melon/net/v4x/response/ServiceInfoRes$Response;)V", "toString", "", "Response", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ServiceInfoRes extends ResponseV4Res {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\f\u0010\r\u001A\u0004\b\f\u0010\u000E\"\u0004\b\u000F\u0010\u0010R$\u0010\u0011\u001A\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u0011\u0010\u0006\u001A\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR$\u0010\u0015\u001A\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000E¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001A¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/net/v4x/response/ServiceInfoRes$Response;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "", "serviceType", "Ljava/lang/String;", "getServiceType", "()Ljava/lang/String;", "setServiceType", "(Ljava/lang/String;)V", "", "isAvailable", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setAvailable", "(Ljava/lang/Boolean;)V", "message", "getMessage", "setMessage", "Lcom/google/gson/t;", "extra", "Lcom/google/gson/t;", "getExtra", "()Lcom/google/gson/t;", "setExtra", "(Lcom/google/gson/t;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Response extends ResponseBase {
        public static final int $stable = 8;
        @b("EXTRA")
        @Nullable
        private t extra;
        @b("ISAVAILABLE")
        @Nullable
        private Boolean isAvailable;
        @b("MESSAGE")
        @Nullable
        private String message;
        @b("SERVICETYPE")
        @Nullable
        private String serviceType;

        @Nullable
        public final t getExtra() {
            return this.extra;
        }

        @Nullable
        public final String getMessage() {
            return this.message;
        }

        @Nullable
        public final String getServiceType() {
            return this.serviceType;
        }

        @Nullable
        public final Boolean isAvailable() {
            return this.isAvailable;
        }

        public final void setAvailable(@Nullable Boolean boolean0) {
            this.isAvailable = boolean0;
        }

        public final void setExtra(@Nullable t t0) {
            this.extra = t0;
        }

        public final void setMessage(@Nullable String s) {
            this.message = s;
        }

        public final void setServiceType(@Nullable String s) {
            this.serviceType = s;
        }
    }

    public static final int $stable = 8;
    @b("response")
    @Nullable
    private Response response;

    @Nullable
    public final Response getResponse() {
        return this.response;
    }

    public final void setResponse(@Nullable Response serviceInfoRes$Response0) {
        this.response = serviceInfoRes$Response0;
    }

    @Override
    @NotNull
    public String toString() {
        String s = ToStringUtil.toStringFields(this);
        q.f(s, "toStringFields(...)");
        return s;
    }
}

