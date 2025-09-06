package okhttp3.internal.connection;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.ws.RealWebSocket.Streams;
import okio.Buffer;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002STB\'\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0015\u0010\u0013\u001A\u00020\u000E2\u0006\u0010\u0012\u001A\u00020\u0011\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u001D\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0016\u001A\u00020\u0015\u00A2\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001A\u001A\u00020\u000E\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\r\u0010\u001C\u001A\u00020\u000E\u00A2\u0006\u0004\b\u001C\u0010\u001BJ\r\u0010\u001D\u001A\u00020\u000E\u00A2\u0006\u0004\b\u001D\u0010\u001BJ\u0017\u0010 \u001A\u0004\u0018\u00010\u001F2\u0006\u0010\u001E\u001A\u00020\u0015\u00A2\u0006\u0004\b \u0010!J\u0015\u0010$\u001A\u00020\u000E2\u0006\u0010#\u001A\u00020\"\u00A2\u0006\u0004\b$\u0010%J\u0015\u0010\'\u001A\u00020&2\u0006\u0010#\u001A\u00020\"\u00A2\u0006\u0004\b\'\u0010(J\r\u0010*\u001A\u00020)\u00A2\u0006\u0004\b*\u0010+J\r\u0010-\u001A\u00020,\u00A2\u0006\u0004\b-\u0010.J\r\u0010/\u001A\u00020\u000E\u00A2\u0006\u0004\b/\u0010\u001BJ\r\u00100\u001A\u00020\u000E\u00A2\u0006\u0004\b0\u0010\u001BJ\r\u00101\u001A\u00020\u000E\u00A2\u0006\u0004\b1\u0010\u001BJ\r\u00102\u001A\u00020\u000E\u00A2\u0006\u0004\b2\u0010\u001BJ9\u00108\u001A\u00028\u0000\"\n\b\u0000\u00103*\u0004\u0018\u00010\f2\u0006\u00105\u001A\u0002042\u0006\u00106\u001A\u00020\u00152\u0006\u00107\u001A\u00020\u00152\u0006\u0010\r\u001A\u00028\u0000\u00A2\u0006\u0004\b8\u00109J\r\u0010:\u001A\u00020\u000E\u00A2\u0006\u0004\b:\u0010\u001BR\u001A\u0010\u0003\u001A\u00020\u00028\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b\u0003\u0010;\u001A\u0004\b<\u0010=R\u001A\u0010\u0005\u001A\u00020\u00048\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b\u0005\u0010>\u001A\u0004\b?\u0010@R\u001A\u0010\u0007\u001A\u00020\u00068\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b\u0007\u0010A\u001A\u0004\bB\u0010CR\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\t\u0010DR$\u0010F\u001A\u00020\u00152\u0006\u0010E\u001A\u00020\u00158\u0000@BX\u0080\u000E\u00A2\u0006\f\n\u0004\bF\u0010G\u001A\u0004\bH\u0010IR$\u0010J\u001A\u00020\u00152\u0006\u0010E\u001A\u00020\u00158\u0000@BX\u0080\u000E\u00A2\u0006\f\n\u0004\bJ\u0010G\u001A\u0004\bK\u0010IR\u001A\u0010M\u001A\u00020L8\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\bM\u0010N\u001A\u0004\bO\u0010PR\u0014\u0010R\u001A\u00020\u00158@X\u0080\u0004\u00A2\u0006\u0006\u001A\u0004\bQ\u0010I\u00A8\u0006U"}, d2 = {"Lokhttp3/internal/connection/Exchange;", "", "Lokhttp3/internal/connection/RealCall;", "call", "Lokhttp3/EventListener;", "eventListener", "Lokhttp3/internal/connection/ExchangeFinder;", "finder", "Lokhttp3/internal/http/ExchangeCodec;", "codec", "<init>", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;Lokhttp3/internal/connection/ExchangeFinder;Lokhttp3/internal/http/ExchangeCodec;)V", "Ljava/io/IOException;", "e", "Lie/H;", "trackFailure", "(Ljava/io/IOException;)V", "Lokhttp3/Request;", "request", "writeRequestHeaders", "(Lokhttp3/Request;)V", "", "duplex", "Lokio/Sink;", "createRequestBody", "(Lokhttp3/Request;Z)Lokio/Sink;", "flushRequest", "()V", "finishRequest", "responseHeadersStart", "expectContinue", "Lokhttp3/Response$Builder;", "readResponseHeaders", "(Z)Lokhttp3/Response$Builder;", "Lokhttp3/Response;", "response", "responseHeadersEnd", "(Lokhttp3/Response;)V", "Lokhttp3/ResponseBody;", "openResponseBody", "(Lokhttp3/Response;)Lokhttp3/ResponseBody;", "Lokhttp3/Headers;", "trailers", "()Lokhttp3/Headers;", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "newWebSocketStreams", "()Lokhttp3/internal/ws/RealWebSocket$Streams;", "webSocketUpgradeFailed", "noNewExchangesOnConnection", "cancel", "detachWithViolence", "E", "", "bytesRead", "responseDone", "requestDone", "bodyComplete", "(JZZLjava/io/IOException;)Ljava/io/IOException;", "noRequestBody", "Lokhttp3/internal/connection/RealCall;", "getCall$okhttp", "()Lokhttp3/internal/connection/RealCall;", "Lokhttp3/EventListener;", "getEventListener$okhttp", "()Lokhttp3/EventListener;", "Lokhttp3/internal/connection/ExchangeFinder;", "getFinder$okhttp", "()Lokhttp3/internal/connection/ExchangeFinder;", "Lokhttp3/internal/http/ExchangeCodec;", "<set-?>", "isDuplex", "Z", "isDuplex$okhttp", "()Z", "hasFailure", "getHasFailure$okhttp", "Lokhttp3/internal/connection/RealConnection;", "connection", "Lokhttp3/internal/connection/RealConnection;", "getConnection$okhttp", "()Lokhttp3/internal/connection/RealConnection;", "isCoalescedConnection$okhttp", "isCoalescedConnection", "RequestBodySink", "ResponseBodySource", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Exchange {
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000B\u001A\u00028\u0000\"\n\b\u0000\u0010\t*\u0004\u0018\u00010\b2\u0006\u0010\n\u001A\u00028\u0000H\u0002¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0015\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0016\u0010\u0018\u001A\u00020\u00178\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001A\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001A\u0010\u0016R\u0016\u0010\u001B\u001A\u00020\u00178\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001B\u0010\u0019¨\u0006\u001C"}, d2 = {"Lokhttp3/internal/connection/Exchange$RequestBodySink;", "Lokio/ForwardingSink;", "Lokio/Sink;", "delegate", "", "contentLength", "<init>", "(Lokhttp3/internal/connection/Exchange;Lokio/Sink;J)V", "Ljava/io/IOException;", "E", "e", "complete", "(Ljava/io/IOException;)Ljava/io/IOException;", "Lokio/Buffer;", "source", "byteCount", "Lie/H;", "write", "(Lokio/Buffer;J)V", "flush", "()V", "close", "J", "", "completed", "Z", "bytesReceived", "closed", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    final class RequestBodySink extends ForwardingSink {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;

        public RequestBodySink(@NotNull Sink sink0, long v) {
            q.g(sink0, "delegate");
            Exchange.this = exchange0;
            super(sink0);
            this.contentLength = v;
        }

        @Override  // okio.ForwardingSink
        public void close() {
            if(this.closed) {
                return;
            }
            this.closed = true;
            if(this.contentLength != -1L && this.bytesReceived != this.contentLength) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                this.complete(null);
            }
            catch(IOException iOException0) {
                throw this.complete(iOException0);
            }
        }

        private final IOException complete(IOException iOException0) {
            if(this.completed) {
                return iOException0;
            }
            this.completed = true;
            return Exchange.this.bodyComplete(this.bytesReceived, false, true, iOException0);
        }

        @Override  // okio.ForwardingSink
        public void flush() {
            try {
                super.flush();
            }
            catch(IOException iOException0) {
                throw this.complete(iOException0);
            }
        }

        @Override  // okio.ForwardingSink
        public void write(@NotNull Buffer buffer0, long v) {
            q.g(buffer0, "source");
            if(!this.closed) {
                if(this.contentLength != -1L && this.bytesReceived + v > this.contentLength) {
                    throw new ProtocolException("expected " + this.contentLength + " bytes but received " + (this.bytesReceived + v));
                }
                try {
                    super.write(buffer0, v);
                    this.bytesReceived += v;
                    return;
                }
                catch(IOException iOException0) {
                    throw this.complete(iOException0);
                }
            }
            throw new IllegalStateException("closed");
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\u000B\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\u000E\u001A\u00020\rH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ!\u0010\u0013\u001A\u00028\u0000\"\n\b\u0000\u0010\u0011*\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001A\u00028\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0015R\u0016\u0010\u0016\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0018\u001A\u00020\u00178\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001A\u001A\u00020\u00178\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001A\u0010\u0019R\u0016\u0010\u001B\u001A\u00020\u00178\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001B\u0010\u0019¨\u0006\u001C"}, d2 = {"Lokhttp3/internal/connection/Exchange$ResponseBodySource;", "Lokio/ForwardingSource;", "Lokio/Source;", "delegate", "", "contentLength", "<init>", "(Lokhttp3/internal/connection/Exchange;Lokio/Source;J)V", "Lokio/Buffer;", "sink", "byteCount", "read", "(Lokio/Buffer;J)J", "Lie/H;", "close", "()V", "Ljava/io/IOException;", "E", "e", "complete", "(Ljava/io/IOException;)Ljava/io/IOException;", "J", "bytesReceived", "", "invokeStartEvent", "Z", "completed", "closed", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public final class ResponseBodySource extends ForwardingSource {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        private boolean invokeStartEvent;

        public ResponseBodySource(@NotNull Source source0, long v) {
            q.g(source0, "delegate");
            Exchange.this = exchange0;
            super(source0);
            this.contentLength = v;
            this.invokeStartEvent = true;
            if(v == 0L) {
                this.complete(null);
            }
        }

        @Override  // okio.ForwardingSource
        public void close() {
            if(this.closed) {
                return;
            }
            try {
                this.closed = true;
                super.close();
                this.complete(null);
            }
            catch(IOException iOException0) {
                throw this.complete(iOException0);
            }
        }

        public final IOException complete(IOException iOException0) {
            if(this.completed) {
                return iOException0;
            }
            this.completed = true;
            if(iOException0 == null && this.invokeStartEvent) {
                this.invokeStartEvent = false;
                Exchange.this.getEventListener$okhttp().responseBodyStart(Exchange.this.getCall$okhttp());
            }
            return Exchange.this.bodyComplete(this.bytesReceived, true, false, iOException0);
        }

        @Override  // okio.ForwardingSource
        public long read(@NotNull Buffer buffer0, long v) {
            q.g(buffer0, "sink");
            if(this.closed) {
                throw new IllegalStateException("closed");
            }
            try {
                long v1 = this.delegate().read(buffer0, v);
                if(this.invokeStartEvent) {
                    this.invokeStartEvent = false;
                    Exchange.this.getEventListener$okhttp().responseBodyStart(Exchange.this.getCall$okhttp());
                }
                if(Long.compare(v1, -1L) == 0) {
                    this.complete(null);
                    return -1L;
                }
                long v2 = this.bytesReceived + v1;
                long v3 = this.contentLength;
                if(v3 != -1L && v2 > v3) {
                    throw new ProtocolException("expected " + this.contentLength + " bytes but received " + v2);
                }
                this.bytesReceived = v2;
                if(v2 == v3) {
                    this.complete(null);
                }
                return v1;
            }
            catch(IOException iOException0) {
            }
            throw this.complete(iOException0);
        }
    }

    @NotNull
    private final RealCall call;
    @NotNull
    private final ExchangeCodec codec;
    @NotNull
    private final RealConnection connection;
    @NotNull
    private final EventListener eventListener;
    @NotNull
    private final ExchangeFinder finder;
    private boolean hasFailure;
    private boolean isDuplex;

    public Exchange(@NotNull RealCall realCall0, @NotNull EventListener eventListener0, @NotNull ExchangeFinder exchangeFinder0, @NotNull ExchangeCodec exchangeCodec0) {
        q.g(realCall0, "call");
        q.g(eventListener0, "eventListener");
        q.g(exchangeFinder0, "finder");
        q.g(exchangeCodec0, "codec");
        super();
        this.call = realCall0;
        this.eventListener = eventListener0;
        this.finder = exchangeFinder0;
        this.codec = exchangeCodec0;
        this.connection = exchangeCodec0.getConnection();
    }

    public final IOException bodyComplete(long v, boolean z, boolean z1, IOException iOException0) {
        if(iOException0 != null) {
            this.trackFailure(iOException0);
        }
        if(z1) {
            if(iOException0 == null) {
                this.eventListener.requestBodyEnd(this.call, v);
            }
            else {
                this.eventListener.requestFailed(this.call, iOException0);
            }
        }
        if(z) {
            if(iOException0 != null) {
                this.eventListener.responseFailed(this.call, iOException0);
                return this.call.messageDone$okhttp(this, z1, true, iOException0);
            }
            this.eventListener.responseBodyEnd(this.call, v);
        }
        return this.call.messageDone$okhttp(this, z1, z, iOException0);
    }

    public final void cancel() {
        this.codec.cancel();
    }

    @NotNull
    public final Sink createRequestBody(@NotNull Request request0, boolean z) {
        q.g(request0, "request");
        this.isDuplex = z;
        RequestBody requestBody0 = request0.body();
        q.d(requestBody0);
        long v = requestBody0.contentLength();
        this.eventListener.requestBodyStart(this.call);
        return new RequestBodySink(this, this.codec.createRequestBody(request0, v), v);
    }

    public final void detachWithViolence() {
        this.codec.cancel();
        this.call.messageDone$okhttp(this, true, true, null);
    }

    public final void finishRequest() {
        try {
            this.codec.finishRequest();
        }
        catch(IOException iOException0) {
            this.eventListener.requestFailed(this.call, iOException0);
            this.trackFailure(iOException0);
            throw iOException0;
        }
    }

    public final void flushRequest() {
        try {
            this.codec.flushRequest();
        }
        catch(IOException iOException0) {
            this.eventListener.requestFailed(this.call, iOException0);
            this.trackFailure(iOException0);
            throw iOException0;
        }
    }

    @NotNull
    public final RealCall getCall$okhttp() {
        return this.call;
    }

    @NotNull
    public final RealConnection getConnection$okhttp() {
        return this.connection;
    }

    @NotNull
    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    @NotNull
    public final ExchangeFinder getFinder$okhttp() {
        return this.finder;
    }

    public final boolean getHasFailure$okhttp() {
        return this.hasFailure;
    }

    public final boolean isCoalescedConnection$okhttp() {
        return !q.b(this.finder.getAddress$okhttp().url().host(), this.connection.route().address().url().host());
    }

    public final boolean isDuplex$okhttp() {
        return this.isDuplex;
    }

    @NotNull
    public final Streams newWebSocketStreams() {
        this.call.timeoutEarlyExit();
        return this.codec.getConnection().newWebSocketStreams$okhttp(this);
    }

    public final void noNewExchangesOnConnection() {
        this.codec.getConnection().noNewExchanges$okhttp();
    }

    public final void noRequestBody() {
        this.call.messageDone$okhttp(this, true, false, null);
    }

    @NotNull
    public final ResponseBody openResponseBody(@NotNull Response response0) {
        q.g(response0, "response");
        try {
            String s = Response.header$default(response0, "Content-Type", null, 2, null);
            long v = this.codec.reportedContentLength(response0);
            return new RealResponseBody(s, v, Okio.buffer(new ResponseBodySource(this, this.codec.openResponseBodySource(response0), v)));
        }
        catch(IOException iOException0) {
            this.eventListener.responseFailed(this.call, iOException0);
            this.trackFailure(iOException0);
            throw iOException0;
        }
    }

    @Nullable
    public final Builder readResponseHeaders(boolean z) {
        try {
            Builder response$Builder0 = this.codec.readResponseHeaders(z);
            if(response$Builder0 != null) {
                response$Builder0.initExchange$okhttp(this);
                return response$Builder0;
            }
            return null;
        }
        catch(IOException iOException0) {
            this.eventListener.responseFailed(this.call, iOException0);
            this.trackFailure(iOException0);
            throw iOException0;
        }
    }

    public final void responseHeadersEnd(@NotNull Response response0) {
        q.g(response0, "response");
        this.eventListener.responseHeadersEnd(this.call, response0);
    }

    public final void responseHeadersStart() {
        this.eventListener.responseHeadersStart(this.call);
    }

    private final void trackFailure(IOException iOException0) {
        this.hasFailure = true;
        this.finder.trackFailure(iOException0);
        this.codec.getConnection().trackFailure$okhttp(this.call, iOException0);
    }

    @NotNull
    public final Headers trailers() {
        return this.codec.trailers();
    }

    public final void webSocketUpgradeFailed() {
        this.bodyComplete(-1L, true, true, null);
    }

    public final void writeRequestHeaders(@NotNull Request request0) {
        q.g(request0, "request");
        try {
            this.eventListener.requestHeadersStart(this.call);
            this.codec.writeRequestHeaders(request0);
            this.eventListener.requestHeadersEnd(this.call, request0);
        }
        catch(IOException iOException0) {
            this.eventListener.requestFailed(this.call, iOException0);
            this.trackFailure(iOException0);
            throw iOException0;
        }
    }
}

