package com.melon.playback.melon.streaming.tracker;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\u0015\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u0015\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J?\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\u0014\b\u0002\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\u0014\b\u0002\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00132\b\u0010\u0014\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001A\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u001D\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u001D\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/melon/playback/melon/streaming/tracker/RequestInfo;", "", "method", "", "params", "", "headers", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getMethod", "()Ljava/lang/String;", "getParams", "()Ljava/util/Map;", "getHeaders", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class RequestInfo {
    public static final int $stable = 8;
    @NotNull
    private final Map headers;
    @NotNull
    private final String method;
    @NotNull
    private final Map params;

    public RequestInfo(@NotNull String s, @NotNull Map map0, @NotNull Map map1) {
        q.g(s, "method");
        q.g(map0, "params");
        q.g(map1, "headers");
        super();
        this.method = s;
        this.params = map0;
        this.headers = map1;
    }

    @NotNull
    public final String component1() {
        return this.method;
    }

    @NotNull
    public final Map component2() {
        return this.params;
    }

    @NotNull
    public final Map component3() {
        return this.headers;
    }

    @NotNull
    public final RequestInfo copy(@NotNull String s, @NotNull Map map0, @NotNull Map map1) {
        q.g(s, "method");
        q.g(map0, "params");
        q.g(map1, "headers");
        return new RequestInfo(s, map0, map1);
    }

    public static RequestInfo copy$default(RequestInfo requestInfo0, String s, Map map0, Map map1, int v, Object object0) {
        if((v & 1) != 0) {
            s = requestInfo0.method;
        }
        if((v & 2) != 0) {
            map0 = requestInfo0.params;
        }
        if((v & 4) != 0) {
            map1 = requestInfo0.headers;
        }
        return requestInfo0.copy(s, map0, map1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof RequestInfo)) {
            return false;
        }
        if(!q.b(this.method, ((RequestInfo)object0).method)) {
            return false;
        }
        return q.b(this.params, ((RequestInfo)object0).params) ? q.b(this.headers, ((RequestInfo)object0).headers) : false;
    }

    @NotNull
    public final Map getHeaders() {
        return this.headers;
    }

    @NotNull
    public final String getMethod() {
        return this.method;
    }

    @NotNull
    public final Map getParams() {
        return this.params;
    }

    @Override
    public int hashCode() {
        return this.headers.hashCode() + (this.params.hashCode() + this.method.hashCode() * 0x1F) * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "RequestInfo(method=" + this.method + ", params=" + this.params + ", headers=" + this.headers + ")";
    }
}

