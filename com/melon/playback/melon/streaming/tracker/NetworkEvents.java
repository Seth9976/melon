package com.melon.playback.melon.streaming.tracker;

import java.util.List;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\r\u001A\n\u0018\u00010\u000Bj\u0004\u0018\u0001`\f\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0016\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001A\u0004\u0018\u00010\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001A\u0004\u0018\u00010\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001A\u0004\u0018\u00010\tH\u00C6\u0003\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0018\u001A\n\u0018\u00010\u000Bj\u0004\u0018\u0001`\fH\u00C6\u0003\u00A2\u0006\u0004\b\u0018\u0010\u0019JV\u0010\u001A\u001A\u00020\u00002\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\r\u001A\n\u0018\u00010\u000Bj\u0004\u0018\u0001`\fH\u00C6\u0001\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0010\u0010\u001D\u001A\u00020\u001CH\u00D6\u0001\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0010\u0010 \u001A\u00020\u001FH\u00D6\u0001\u00A2\u0006\u0004\b \u0010!J\u001A\u0010$\u001A\u00020#2\b\u0010\"\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b$\u0010%R\u001D\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0004\u0010&\u001A\u0004\b\'\u0010\u0011R\u0019\u0010\u0006\u001A\u0004\u0018\u00010\u00058\u0006\u00A2\u0006\f\n\u0004\b\u0006\u0010(\u001A\u0004\b)\u0010\u0013R\u0019\u0010\b\u001A\u0004\u0018\u00010\u00078\u0006\u00A2\u0006\f\n\u0004\b\b\u0010*\u001A\u0004\b+\u0010\u0015R\u0019\u0010\n\u001A\u0004\u0018\u00010\t8\u0006\u00A2\u0006\f\n\u0004\b\n\u0010,\u001A\u0004\b-\u0010\u0017R\u001F\u0010\r\u001A\n\u0018\u00010\u000Bj\u0004\u0018\u0001`\f8\u0006\u00A2\u0006\f\n\u0004\b\r\u0010.\u001A\u0004\b/\u0010\u0019\u00A8\u00060"}, d2 = {"Lcom/melon/playback/melon/streaming/tracker/NetworkEvents;", "", "", "Ldc/a;", "events", "Lcom/melon/playback/melon/streaming/tracker/ConnectionInfo;", "connection", "Lcom/melon/playback/melon/streaming/tracker/RequestInfo;", "request", "Lcom/melon/playback/melon/streaming/tracker/ResponseInfo;", "response", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "<init>", "(Ljava/util/List;Lcom/melon/playback/melon/streaming/tracker/ConnectionInfo;Lcom/melon/playback/melon/streaming/tracker/RequestInfo;Lcom/melon/playback/melon/streaming/tracker/ResponseInfo;Ljava/lang/Exception;)V", "component1", "()Ljava/util/List;", "component2", "()Lcom/melon/playback/melon/streaming/tracker/ConnectionInfo;", "component3", "()Lcom/melon/playback/melon/streaming/tracker/RequestInfo;", "component4", "()Lcom/melon/playback/melon/streaming/tracker/ResponseInfo;", "component5", "()Ljava/lang/Exception;", "copy", "(Ljava/util/List;Lcom/melon/playback/melon/streaming/tracker/ConnectionInfo;Lcom/melon/playback/melon/streaming/tracker/RequestInfo;Lcom/melon/playback/melon/streaming/tracker/ResponseInfo;Ljava/lang/Exception;)Lcom/melon/playback/melon/streaming/tracker/NetworkEvents;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getEvents", "Lcom/melon/playback/melon/streaming/tracker/ConnectionInfo;", "getConnection", "Lcom/melon/playback/melon/streaming/tracker/RequestInfo;", "getRequest", "Lcom/melon/playback/melon/streaming/tracker/ResponseInfo;", "getResponse", "Ljava/lang/Exception;", "getError", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class NetworkEvents {
    public static final int $stable = 8;
    @Nullable
    private final ConnectionInfo connection;
    @Nullable
    private final Exception error;
    @NotNull
    private final List events;
    @Nullable
    private final RequestInfo request;
    @Nullable
    private final ResponseInfo response;

    public NetworkEvents() {
        this(null, null, null, null, null, 0x1F, null);
    }

    public NetworkEvents(@NotNull List list0, @Nullable ConnectionInfo connectionInfo0, @Nullable RequestInfo requestInfo0, @Nullable ResponseInfo responseInfo0, @Nullable Exception exception0) {
        q.g(list0, "events");
        super();
        this.events = list0;
        this.connection = connectionInfo0;
        this.request = requestInfo0;
        this.response = responseInfo0;
        this.error = exception0;
    }

    public NetworkEvents(List list0, ConnectionInfo connectionInfo0, RequestInfo requestInfo0, ResponseInfo responseInfo0, Exception exception0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        ConnectionInfo connectionInfo1;
        List list1;
        ResponseInfo responseInfo1;
        RequestInfo requestInfo1;
        Exception exception1;
        if((v & 1) != 0) {
            list0 = w.a;
        }
        if((v & 2) != 0) {
            connectionInfo0 = null;
        }
        if((v & 4) != 0) {
            requestInfo0 = null;
        }
        if((v & 8) != 0) {
            responseInfo0 = null;
        }
        if((v & 16) == 0) {
            exception1 = exception0;
            responseInfo1 = responseInfo0;
            connectionInfo1 = connectionInfo0;
            requestInfo1 = requestInfo0;
            list1 = list0;
        }
        else {
            exception1 = null;
            requestInfo1 = requestInfo0;
            responseInfo1 = responseInfo0;
            list1 = list0;
            connectionInfo1 = connectionInfo0;
        }
        this(list1, connectionInfo1, requestInfo1, responseInfo1, exception1);
    }

    @NotNull
    public final List component1() {
        return this.events;
    }

    @Nullable
    public final ConnectionInfo component2() {
        return this.connection;
    }

    @Nullable
    public final RequestInfo component3() {
        return this.request;
    }

    @Nullable
    public final ResponseInfo component4() {
        return this.response;
    }

    @Nullable
    public final Exception component5() {
        return this.error;
    }

    @NotNull
    public final NetworkEvents copy(@NotNull List list0, @Nullable ConnectionInfo connectionInfo0, @Nullable RequestInfo requestInfo0, @Nullable ResponseInfo responseInfo0, @Nullable Exception exception0) {
        q.g(list0, "events");
        return new NetworkEvents(list0, connectionInfo0, requestInfo0, responseInfo0, exception0);
    }

    public static NetworkEvents copy$default(NetworkEvents networkEvents0, List list0, ConnectionInfo connectionInfo0, RequestInfo requestInfo0, ResponseInfo responseInfo0, Exception exception0, int v, Object object0) {
        if((v & 1) != 0) {
            list0 = networkEvents0.events;
        }
        if((v & 2) != 0) {
            connectionInfo0 = networkEvents0.connection;
        }
        if((v & 4) != 0) {
            requestInfo0 = networkEvents0.request;
        }
        if((v & 8) != 0) {
            responseInfo0 = networkEvents0.response;
        }
        if((v & 16) != 0) {
            exception0 = networkEvents0.error;
        }
        return networkEvents0.copy(list0, connectionInfo0, requestInfo0, responseInfo0, exception0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof NetworkEvents)) {
            return false;
        }
        if(!q.b(this.events, ((NetworkEvents)object0).events)) {
            return false;
        }
        if(!q.b(this.connection, ((NetworkEvents)object0).connection)) {
            return false;
        }
        if(!q.b(this.request, ((NetworkEvents)object0).request)) {
            return false;
        }
        return q.b(this.response, ((NetworkEvents)object0).response) ? q.b(this.error, ((NetworkEvents)object0).error) : false;
    }

    @Nullable
    public final ConnectionInfo getConnection() {
        return this.connection;
    }

    @Nullable
    public final Exception getError() {
        return this.error;
    }

    @NotNull
    public final List getEvents() {
        return this.events;
    }

    @Nullable
    public final RequestInfo getRequest() {
        return this.request;
    }

    @Nullable
    public final ResponseInfo getResponse() {
        return this.response;
    }

    @Override
    public int hashCode() {
        int v = this.events.hashCode();
        int v1 = 0;
        int v2 = this.connection == null ? 0 : this.connection.hashCode();
        int v3 = this.request == null ? 0 : this.request.hashCode();
        int v4 = this.response == null ? 0 : this.response.hashCode();
        Exception exception0 = this.error;
        if(exception0 != null) {
            v1 = exception0.hashCode();
        }
        return (((v * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v1;
    }

    @Override
    @NotNull
    public String toString() {
        return "NetworkEvents(events=" + this.events + ", connection=" + this.connection + ", request=" + this.request + ", response=" + this.response + ", error=" + this.error + ")";
    }
}

