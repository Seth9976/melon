package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveHostMessageRes;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v6x/response/MusicWaveHostMessageRes$Response;", "getResponse", "()Lcom/iloen/melon/net/v6x/response/MusicWaveHostMessageRes$Response;", "setResponse", "(Lcom/iloen/melon/net/v6x/response/MusicWaveHostMessageRes$Response;)V", "Response", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicWaveHostMessageRes extends ResponseV6Res {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000B\u0010\t\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\n\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u000EHÖ\u0003J\t\u0010\u000F\u001A\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001A\u00020\u0003HÖ\u0001R \u0010\u0002\u001A\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/net/v6x/response/MusicWaveHostMessageRes$Response;", "Lcom/melon/net/res/common/ResponseBase;", "status", "", "<init>", "(Ljava/lang/String;)V", "getStatus", "()Ljava/lang/String;", "setStatus", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Response extends ResponseBase {
        public static final int $stable = 8;
        @b("STATUS")
        @Nullable
        private String status;

        public Response() {
            this(null, 1, null);
        }

        public Response(@Nullable String s) {
            this.status = s;
        }

        public Response(String s, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                s = null;
            }
            this(s);
        }

        @Nullable
        public final String component1() {
            return this.status;
        }

        @NotNull
        public final Response copy(@Nullable String s) {
            return new Response(s);
        }

        public static Response copy$default(Response musicWaveHostMessageRes$Response0, String s, int v, Object object0) {
            if((v & 1) != 0) {
                s = musicWaveHostMessageRes$Response0.status;
            }
            return musicWaveHostMessageRes$Response0.copy(s);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof Response ? q.b(this.status, ((Response)object0).status) : false;
        }

        @Nullable
        public final String getStatus() {
            return this.status;
        }

        @Override
        public int hashCode() {
            return this.status == null ? 0 : this.status.hashCode();
        }

        public final void setStatus(@Nullable String s) {
            this.status = s;
        }

        @Override  // com.melon.net.res.common.ResponseBase
        @NotNull
        public String toString() {
            return "Response(status=" + this.status + ")";
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

    public final void setResponse(@Nullable Response musicWaveHostMessageRes$Response0) {
        this.response = musicWaveHostMessageRes$Response0;
    }
}

