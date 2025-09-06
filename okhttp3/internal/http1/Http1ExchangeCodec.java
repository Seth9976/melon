package okhttp3.internal.http1;

import Tf.o;
import Tf.v;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy.Type;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response.Builder;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e;

@Metadata(d1 = {"\u0000\u008C\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 R2\u00020\u0001:\u0007STURVWXB)\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u0011\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0014\u001A\u00020\u0013H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001A\u00020\u00132\u0006\u0010\r\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001A\u001A\u00020\u000E2\u0006\u0010\u0019\u001A\u00020\u0018H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0017\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u0019\u001A\u00020\u0018H\u0016\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010 \u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\b \u0010!J\u000F\u0010\"\u001A\u00020\u0013H\u0016\u00A2\u0006\u0004\b\"\u0010\u0015J\u000F\u0010#\u001A\u00020\u0013H\u0016\u00A2\u0006\u0004\b#\u0010\u0015J\u001D\u0010\'\u001A\u00020\u00132\u0006\u0010$\u001A\u00020\u001F2\u0006\u0010&\u001A\u00020%\u00A2\u0006\u0004\b\'\u0010(J\u0019\u0010,\u001A\u0004\u0018\u00010+2\u0006\u0010*\u001A\u00020)H\u0016\u00A2\u0006\u0004\b,\u0010-J\u0015\u0010.\u001A\u00020\u00132\u0006\u0010\u0019\u001A\u00020\u0018\u00A2\u0006\u0004\b.\u0010/J\u000F\u00100\u001A\u00020\u0010H\u0002\u00A2\u0006\u0004\b0\u00101J\u000F\u00102\u001A\u00020\u0010H\u0002\u00A2\u0006\u0004\b2\u00101J\u0017\u00104\u001A\u00020\u001C2\u0006\u00103\u001A\u00020\u000EH\u0002\u00A2\u0006\u0004\b4\u00105J\u0017\u00108\u001A\u00020\u001C2\u0006\u00107\u001A\u000206H\u0002\u00A2\u0006\u0004\b8\u00109J\u000F\u0010:\u001A\u00020\u001CH\u0002\u00A2\u0006\u0004\b:\u0010;J\u0017\u0010>\u001A\u00020\u00132\u0006\u0010=\u001A\u00020<H\u0002\u00A2\u0006\u0004\b>\u0010?R\u0016\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010@R\u001A\u0010\u0005\u001A\u00020\u00048\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0005\u0010A\u001A\u0004\bB\u0010CR\u0014\u0010\u0007\u001A\u00020\u00068\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0007\u0010DR\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\t\u0010ER\u0016\u0010G\u001A\u00020F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010J\u001A\u00020I8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010 \u001A\u0004\u0018\u00010\u001F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b \u0010LR\u0011\u0010M\u001A\u00020)8F\u00A2\u0006\u0006\u001A\u0004\bM\u0010NR\u0018\u0010O\u001A\u00020)*\u00020\u00188BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bO\u0010PR\u0018\u0010O\u001A\u00020)*\u00020\f8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bO\u0010Q\u00A8\u0006Y"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec;", "Lokhttp3/internal/http/ExchangeCodec;", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/internal/connection/RealConnection;", "connection", "Lokio/BufferedSource;", "source", "Lokio/BufferedSink;", "sink", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/connection/RealConnection;Lokio/BufferedSource;Lokio/BufferedSink;)V", "Lokhttp3/Request;", "request", "", "contentLength", "Lokio/Sink;", "createRequestBody", "(Lokhttp3/Request;J)Lokio/Sink;", "Lie/H;", "cancel", "()V", "writeRequestHeaders", "(Lokhttp3/Request;)V", "Lokhttp3/Response;", "response", "reportedContentLength", "(Lokhttp3/Response;)J", "Lokio/Source;", "openResponseBodySource", "(Lokhttp3/Response;)Lokio/Source;", "Lokhttp3/Headers;", "trailers", "()Lokhttp3/Headers;", "flushRequest", "finishRequest", "headers", "", "requestLine", "writeRequest", "(Lokhttp3/Headers;Ljava/lang/String;)V", "", "expectContinue", "Lokhttp3/Response$Builder;", "readResponseHeaders", "(Z)Lokhttp3/Response$Builder;", "skipConnectBody", "(Lokhttp3/Response;)V", "newChunkedSink", "()Lokio/Sink;", "newKnownLengthSink", "length", "newFixedLengthSource", "(J)Lokio/Source;", "Lokhttp3/HttpUrl;", "url", "newChunkedSource", "(Lokhttp3/HttpUrl;)Lokio/Source;", "newUnknownLengthSource", "()Lokio/Source;", "Lokio/ForwardingTimeout;", "timeout", "detachTimeout", "(Lokio/ForwardingTimeout;)V", "Lokhttp3/OkHttpClient;", "Lokhttp3/internal/connection/RealConnection;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "", "state", "I", "Lokhttp3/internal/http1/HeadersReader;", "headersReader", "Lokhttp3/internal/http1/HeadersReader;", "Lokhttp3/Headers;", "isClosed", "()Z", "isChunked", "(Lokhttp3/Response;)Z", "(Lokhttp3/Request;)Z", "Companion", "AbstractSource", "ChunkedSink", "ChunkedSource", "FixedLengthSource", "KnownLengthSink", "UnknownLengthSource", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Http1ExchangeCodec implements ExchangeCodec {
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\b¢\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001F\u0010\u000B\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\r\u0010\u000E\u001A\u00020\r¢\u0006\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0005\u001A\u00020\u00108\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001A\u00020\u00148\u0004@\u0004X\u0084\u000E¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001A¨\u0006\u001B"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokio/Source;", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "Lokio/Buffer;", "sink", "", "byteCount", "read", "(Lokio/Buffer;J)J", "Lie/H;", "responseBodyComplete", "()V", "Lokio/ForwardingTimeout;", "Lokio/ForwardingTimeout;", "getTimeout", "()Lokio/ForwardingTimeout;", "", "closed", "Z", "getClosed", "()Z", "setClosed", "(Z)V", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    abstract class AbstractSource implements Source {
        private boolean closed;
        @NotNull
        private final ForwardingTimeout timeout;

        public AbstractSource() {
            this.timeout = new ForwardingTimeout(http1ExchangeCodec0.source.timeout());
        }

        public final boolean getClosed() {
            return this.closed;
        }

        @NotNull
        public final ForwardingTimeout getTimeout() {
            return this.timeout;
        }

        @Override  // okio.Source
        public long read(@NotNull Buffer buffer0, long v) {
            q.g(buffer0, "sink");
            try {
                return Http1ExchangeCodec.this.source.read(buffer0, v);
            }
            catch(IOException iOException0) {
                Http1ExchangeCodec.this.getConnection().noNewExchanges$okhttp();
                this.responseBodyComplete();
                throw iOException0;
            }
        }

        public final void responseBodyComplete() {
            switch(Http1ExchangeCodec.this.state) {
                case 5: {
                    Http1ExchangeCodec.this.detachTimeout(this.timeout);
                    Http1ExchangeCodec.this.state = 6;
                    return;
                }
                case 6: {
                    return;
                }
                default: {
                    throw new IllegalStateException("state: " + Http1ExchangeCodec.this.state);
                }
            }
        }

        public final void setClosed(boolean z) {
            this.closed = z;
        }

        @Override  // okio.Source
        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001F\u0010\f\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0010\u0010\u000FR\u0014\u0010\u0005\u001A\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0016\u0010\u0014\u001A\u00020\u00138\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$ChunkedSink;", "Lokio/Sink;", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "Lokio/Buffer;", "source", "", "byteCount", "Lie/H;", "write", "(Lokio/Buffer;J)V", "flush", "()V", "close", "Lokio/ForwardingTimeout;", "Lokio/ForwardingTimeout;", "", "closed", "Z", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    final class ChunkedSink implements Sink {
        private boolean closed;
        @NotNull
        private final ForwardingTimeout timeout;

        public ChunkedSink() {
            this.timeout = new ForwardingTimeout(http1ExchangeCodec0.sink.timeout());
        }

        @Override  // okio.Sink
        public void close() {
            synchronized(this) {
                if(this.closed) {
                    return;
                }
                this.closed = true;
                Http1ExchangeCodec.this.sink.writeUtf8("0\r\n\r\n");
                Http1ExchangeCodec.this.detachTimeout(this.timeout);
                Http1ExchangeCodec.this.state = 3;
            }
        }

        @Override  // okio.Sink
        public void flush() {
            synchronized(this) {
                if(this.closed) {
                    return;
                }
                Http1ExchangeCodec.this.sink.flush();
            }
        }

        @Override  // okio.Sink
        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }

        @Override  // okio.Sink
        public void write(@NotNull Buffer buffer0, long v) {
            q.g(buffer0, "source");
            if(this.closed) {
                throw new IllegalStateException("closed");
            }
            if(v == 0L) {
                return;
            }
            Http1ExchangeCodec.this.sink.writeHexadecimalUnsignedLong(v);
            Http1ExchangeCodec.this.sink.writeUtf8("\r\n");
            Http1ExchangeCodec.this.sink.write(buffer0, v);
            Http1ExchangeCodec.this.sink.writeUtf8("\r\n");
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\u000E\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\tR\u0014\u0010\u0004\u001A\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0011R\u0016\u0010\u0012\u001A\u00020\f8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001A\u00020\u00148\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$ChunkedSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "Lokhttp3/HttpUrl;", "url", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;Lokhttp3/HttpUrl;)V", "Lie/H;", "readChunkSize", "()V", "Lokio/Buffer;", "sink", "", "byteCount", "read", "(Lokio/Buffer;J)J", "close", "Lokhttp3/HttpUrl;", "bytesRemainingInChunk", "J", "", "hasMoreChunks", "Z", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    final class ChunkedSource extends AbstractSource {
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        @NotNull
        private final HttpUrl url;

        public ChunkedSource(@NotNull HttpUrl httpUrl0) {
            q.g(httpUrl0, "url");
            Http1ExchangeCodec.this = http1ExchangeCodec0;
            super();
            this.url = httpUrl0;
            this.bytesRemainingInChunk = -1L;
            this.hasMoreChunks = true;
        }

        @Override  // okio.Source
        public void close() {
            if(this.getClosed()) {
                return;
            }
            if(this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                Http1ExchangeCodec.this.getConnection().noNewExchanges$okhttp();
                this.responseBodyComplete();
            }
            this.setClosed(true);
        }

        @Override  // okhttp3.internal.http1.Http1ExchangeCodec$AbstractSource
        public long read(@NotNull Buffer buffer0, long v) {
            q.g(buffer0, "sink");
            if(v < 0L) {
                throw new IllegalArgumentException(e.a(v, "byteCount < 0: ").toString());
            }
            if(this.getClosed()) {
                throw new IllegalStateException("closed");
            }
            if(!this.hasMoreChunks) {
                return -1L;
            }
            if(this.bytesRemainingInChunk == 0L || this.bytesRemainingInChunk == -1L) {
                this.readChunkSize();
                if(!this.hasMoreChunks) {
                    return -1L;
                }
            }
            long v1 = super.read(buffer0, Math.min(v, this.bytesRemainingInChunk));
            if(v1 != -1L) {
                this.bytesRemainingInChunk -= v1;
                return v1;
            }
            Http1ExchangeCodec.this.getConnection().noNewExchanges$okhttp();
            ProtocolException protocolException0 = new ProtocolException("unexpected end of stream");
            this.responseBodyComplete();
            throw protocolException0;
        }

        private final void readChunkSize() {
            if(this.bytesRemainingInChunk != -1L) {
                Http1ExchangeCodec.this.source.readUtf8LineStrict();
            }
            try {
                this.bytesRemainingInChunk = Http1ExchangeCodec.this.source.readHexadecimalUnsignedLong();
                String s = o.e1(Http1ExchangeCodec.this.source.readUtf8LineStrict()).toString();
                if(this.bytesRemainingInChunk < 0L || s.length() > 0 && !v.r0(s, ";", false)) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + s + '\"');
                }
            }
            catch(NumberFormatException numberFormatException0) {
                throw new ProtocolException(numberFormatException0.getMessage());
            }
            if(this.bytesRemainingInChunk == 0L) {
                this.hasMoreChunks = false;
                Headers headers0 = Http1ExchangeCodec.this.headersReader.readHeaders();
                Http1ExchangeCodec.this.trailers = headers0;
                OkHttpClient okHttpClient0 = Http1ExchangeCodec.this.client;
                q.d(okHttpClient0);
                Headers headers1 = Http1ExchangeCodec.this.trailers;
                q.d(headers1);
                HttpHeaders.receiveHeaders(okHttpClient0.cookieJar(), this.url, headers1);
                this.responseBodyComplete();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$Companion;", "", "()V", "NO_CHUNK_YET", "", "STATE_CLOSED", "", "STATE_IDLE", "STATE_OPEN_REQUEST_BODY", "STATE_OPEN_RESPONSE_BODY", "STATE_READING_RESPONSE_BODY", "STATE_READ_RESPONSE_HEADERS", "STATE_WRITING_REQUEST_BODY", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001F\u0010\n\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000ER\u0016\u0010\u0004\u001A\u00020\u00038\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0004\u0010\u000F¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$FixedLengthSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "", "bytesRemaining", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;J)V", "Lokio/Buffer;", "sink", "byteCount", "read", "(Lokio/Buffer;J)J", "Lie/H;", "close", "()V", "J", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    final class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;

        public FixedLengthSource(long v) {
            this.bytesRemaining = v;
            if(v == 0L) {
                this.responseBodyComplete();
            }
        }

        @Override  // okio.Source
        public void close() {
            if(this.getClosed()) {
                return;
            }
            if(this.bytesRemaining != 0L && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                Http1ExchangeCodec.this.getConnection().noNewExchanges$okhttp();
                this.responseBodyComplete();
            }
            this.setClosed(true);
        }

        @Override  // okhttp3.internal.http1.Http1ExchangeCodec$AbstractSource
        public long read(@NotNull Buffer buffer0, long v) {
            q.g(buffer0, "sink");
            if(v < 0L) {
                throw new IllegalArgumentException(e.a(v, "byteCount < 0: ").toString());
            }
            if(this.getClosed()) {
                throw new IllegalStateException("closed");
            }
            long v1 = this.bytesRemaining;
            if(Long.compare(v1, 0L) == 0) {
                return -1L;
            }
            long v2 = super.read(buffer0, Math.min(v1, v));
            if(v2 != -1L) {
                long v3 = this.bytesRemaining - v2;
                this.bytesRemaining = v3;
                if(v3 == 0L) {
                    this.responseBodyComplete();
                }
                return v2;
            }
            Http1ExchangeCodec.this.getConnection().noNewExchanges$okhttp();
            ProtocolException protocolException0 = new ProtocolException("unexpected end of stream");
            this.responseBodyComplete();
            throw protocolException0;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001F\u0010\f\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0010\u0010\u000FR\u0014\u0010\u0005\u001A\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0016\u0010\u0014\u001A\u00020\u00138\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$KnownLengthSink;", "Lokio/Sink;", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "Lokio/Buffer;", "source", "", "byteCount", "Lie/H;", "write", "(Lokio/Buffer;J)V", "flush", "()V", "close", "Lokio/ForwardingTimeout;", "Lokio/ForwardingTimeout;", "", "closed", "Z", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    final class KnownLengthSink implements Sink {
        private boolean closed;
        @NotNull
        private final ForwardingTimeout timeout;

        public KnownLengthSink() {
            this.timeout = new ForwardingTimeout(http1ExchangeCodec0.sink.timeout());
        }

        @Override  // okio.Sink
        public void close() {
            if(this.closed) {
                return;
            }
            this.closed = true;
            Http1ExchangeCodec.this.detachTimeout(this.timeout);
            Http1ExchangeCodec.this.state = 3;
        }

        @Override  // okio.Sink
        public void flush() {
            if(this.closed) {
                return;
            }
            Http1ExchangeCodec.this.sink.flush();
        }

        @Override  // okio.Sink
        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }

        @Override  // okio.Sink
        public void write(@NotNull Buffer buffer0, long v) {
            q.g(buffer0, "source");
            if(this.closed) {
                throw new IllegalStateException("closed");
            }
            Util.checkOffsetAndCount(buffer0.size(), 0L, v);
            Http1ExchangeCodec.this.sink.write(buffer0, v);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001F\u0010\t\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000F\u001A\u00020\u000E8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lokhttp3/internal/http1/Http1ExchangeCodec$UnknownLengthSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "<init>", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "Lokio/Buffer;", "sink", "", "byteCount", "read", "(Lokio/Buffer;J)J", "Lie/H;", "close", "()V", "", "inputExhausted", "Z", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    final class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;

        @Override  // okio.Source
        public void close() {
            if(this.getClosed()) {
                return;
            }
            if(!this.inputExhausted) {
                this.responseBodyComplete();
            }
            this.setClosed(true);
        }

        @Override  // okhttp3.internal.http1.Http1ExchangeCodec$AbstractSource
        public long read(@NotNull Buffer buffer0, long v) {
            q.g(buffer0, "sink");
            if(v < 0L) {
                throw new IllegalArgumentException(e.a(v, "byteCount < 0: ").toString());
            }
            if(this.getClosed()) {
                throw new IllegalStateException("closed");
            }
            if(this.inputExhausted) {
                return -1L;
            }
            long v1 = super.read(buffer0, v);
            if(v1 == -1L) {
                this.inputExhausted = true;
                this.responseBodyComplete();
                return -1L;
            }
            return v1;
        }
    }

    @NotNull
    public static final Companion Companion = null;
    private static final long NO_CHUNK_YET = -1L;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    @Nullable
    private final OkHttpClient client;
    @NotNull
    private final RealConnection connection;
    @NotNull
    private final HeadersReader headersReader;
    @NotNull
    private final BufferedSink sink;
    @NotNull
    private final BufferedSource source;
    private int state;
    @Nullable
    private Headers trailers;

    static {
        Http1ExchangeCodec.Companion = new Companion(null);
    }

    public Http1ExchangeCodec(@Nullable OkHttpClient okHttpClient0, @NotNull RealConnection realConnection0, @NotNull BufferedSource bufferedSource0, @NotNull BufferedSink bufferedSink0) {
        q.g(realConnection0, "connection");
        q.g(bufferedSource0, "source");
        q.g(bufferedSink0, "sink");
        super();
        this.client = okHttpClient0;
        this.connection = realConnection0;
        this.source = bufferedSource0;
        this.sink = bufferedSink0;
        this.headersReader = new HeadersReader(bufferedSource0);
    }

    @Override  // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        this.getConnection().cancel();
    }

    @Override  // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public Sink createRequestBody(@NotNull Request request0, long v) {
        q.g(request0, "request");
        boolean z = request0.body() == null;
        if(this.isChunked(request0)) {
            return this.newChunkedSink();
        }
        if(v == -1L) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
        return this.newKnownLengthSink();
    }

    private final void detachTimeout(ForwardingTimeout forwardingTimeout0) {
        Timeout timeout0 = forwardingTimeout0.delegate();
        forwardingTimeout0.setDelegate(Timeout.NONE);
        timeout0.clearDeadline();
        timeout0.clearTimeout();
    }

    @Override  // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() {
        this.sink.flush();
    }

    @Override  // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() {
        this.sink.flush();
    }

    @Override  // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public RealConnection getConnection() {
        return this.connection;
    }

    private final boolean isChunked(Request request0) {
        return "chunked".equalsIgnoreCase(request0.header("Transfer-Encoding"));
    }

    private final boolean isChunked(Response response0) {
        return "chunked".equalsIgnoreCase(Response.header$default(response0, "Transfer-Encoding", null, 2, null));
    }

    public final boolean isClosed() {
        return this.state == 6;
    }

    private final Sink newChunkedSink() {
        if(this.state != 1) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        this.state = 2;
        return new ChunkedSink(this);
    }

    private final Source newChunkedSource(HttpUrl httpUrl0) {
        if(this.state != 4) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        this.state = 5;
        return new ChunkedSource(this, httpUrl0);
    }

    private final Source newFixedLengthSource(long v) {
        if(this.state != 4) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        this.state = 5;
        return new FixedLengthSource(this, v);
    }

    private final Sink newKnownLengthSink() {
        if(this.state != 1) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        this.state = 2;
        return new KnownLengthSink(this);
    }

    private final Source newUnknownLengthSource() {
        if(this.state != 4) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        this.state = 5;
        this.getConnection().noNewExchanges$okhttp();
        return new UnknownLengthSource(this);
    }

    @Override  // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public Source openResponseBodySource(@NotNull Response response0) {
        q.g(response0, "response");
        if(!HttpHeaders.promisesBody(response0)) {
            return this.newFixedLengthSource(0L);
        }
        if(this.isChunked(response0)) {
            return this.newChunkedSource(response0.request().url());
        }
        long v = Util.headersContentLength(response0);
        return v == -1L ? this.newUnknownLengthSource() : this.newFixedLengthSource(v);
    }

    @Override  // okhttp3.internal.http.ExchangeCodec
    @Nullable
    public Builder readResponseHeaders(boolean z) {
        if(this.state != 1 && (this.state != 2 && this.state != 3)) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        try {
            String s = this.headersReader.readLine();
            StatusLine statusLine0 = StatusLine.Companion.parse(s);
            Builder response$Builder0 = new Builder().protocol(statusLine0.protocol).code(statusLine0.code).message(statusLine0.message).headers(this.headersReader.readHeaders());
            if(z && statusLine0.code == 100) {
                return null;
            }
            int v = statusLine0.code;
            if(v == 100) {
                this.state = 3;
                return response$Builder0;
            }
            if(102 <= v && v < 200) {
                this.state = 3;
                return response$Builder0;
            }
            this.state = 4;
            return response$Builder0;
        }
        catch(EOFException eOFException0) {
        }
        throw new IOException(e.b("unexpected end of stream on ", this.getConnection().route().address().url().redact()), eOFException0);
    }

    @Override  // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(@NotNull Response response0) {
        q.g(response0, "response");
        if(!HttpHeaders.promisesBody(response0)) {
            return 0L;
        }
        return this.isChunked(response0) ? -1L : Util.headersContentLength(response0);
    }

    public final void skipConnectBody(@NotNull Response response0) {
        q.g(response0, "response");
        long v = Util.headersContentLength(response0);
        if(v == -1L) {
            return;
        }
        Source source0 = this.newFixedLengthSource(v);
        Util.skipAll(source0, 0x7FFFFFFF, TimeUnit.MILLISECONDS);
        source0.close();
    }

    @Override  // okhttp3.internal.http.ExchangeCodec
    @NotNull
    public Headers trailers() {
        if(this.state != 6) {
            throw new IllegalStateException("too early; can\'t read the trailers yet");
        }
        return this.trailers == null ? Util.EMPTY_HEADERS : this.trailers;
    }

    public final void writeRequest(@NotNull Headers headers0, @NotNull String s) {
        q.g(headers0, "headers");
        q.g(s, "requestLine");
        if(this.state != 0) {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
        this.sink.writeUtf8(s).writeUtf8("\r\n");
        int v = headers0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            String s1 = headers0.name(v1);
            this.sink.writeUtf8(s1).writeUtf8(": ").writeUtf8(headers0.value(v1)).writeUtf8("\r\n");
        }
        this.sink.writeUtf8("\r\n");
        this.state = 1;
    }

    @Override  // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(@NotNull Request request0) {
        q.g(request0, "request");
        Proxy.Type proxy$Type0 = this.getConnection().route().proxy().type();
        q.f(proxy$Type0, "connection.route().proxy.type()");
        this.writeRequest(request0.headers(), RequestLine.INSTANCE.get(request0, proxy$Type0));
    }
}

