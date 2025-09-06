package com.melon.playback.melon.streaming.tracker;

import U4.x;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0005HÆ\u0003J\'\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/melon/playback/melon/streaming/tracker/ResponseInfo;", "", "code", "", "message", "", "protocol", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getProtocol", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ResponseInfo {
    public static final int $stable;
    private final int code;
    @NotNull
    private final String message;
    @NotNull
    private final String protocol;

    public ResponseInfo(int v, @NotNull String s, @NotNull String s1) {
        q.g(s, "message");
        q.g(s1, "protocol");
        super();
        this.code = v;
        this.message = s;
        this.protocol = s1;
    }

    public final int component1() {
        return this.code;
    }

    @NotNull
    public final String component2() {
        return this.message;
    }

    @NotNull
    public final String component3() {
        return this.protocol;
    }

    @NotNull
    public final ResponseInfo copy(int v, @NotNull String s, @NotNull String s1) {
        q.g(s, "message");
        q.g(s1, "protocol");
        return new ResponseInfo(v, s, s1);
    }

    public static ResponseInfo copy$default(ResponseInfo responseInfo0, int v, String s, String s1, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = responseInfo0.code;
        }
        if((v1 & 2) != 0) {
            s = responseInfo0.message;
        }
        if((v1 & 4) != 0) {
            s1 = responseInfo0.protocol;
        }
        return responseInfo0.copy(v, s, s1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ResponseInfo)) {
            return false;
        }
        if(this.code != ((ResponseInfo)object0).code) {
            return false;
        }
        return q.b(this.message, ((ResponseInfo)object0).message) ? q.b(this.protocol, ((ResponseInfo)object0).protocol) : false;
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    public final String getProtocol() {
        return this.protocol;
    }

    @Override
    public int hashCode() {
        return this.protocol.hashCode() + x.b(this.code * 0x1F, 0x1F, this.message);
    }

    @Override
    @NotNull
    public String toString() {
        return x.m(x.o(this.code, "ResponseInfo(code=", ", message=", this.message, ", protocol="), this.protocol, ")");
    }
}

