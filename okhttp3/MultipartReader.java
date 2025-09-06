package okhttp3;

import java.io.Closeable;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.internal.http1.HeadersReader;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0003&\'(B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u0017\u0010\r\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u0010\u001A\u0004\u0018\u00010\u000F¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0013\u001A\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0017\u0010\u0005\u001A\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001A\u0004\b\u0005\u0010\u0017R\u0014\u0010\u0019\u001A\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001AR\u0014\u0010\u001B\u001A\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001B\u0010\u001AR\u0016\u0010\u001D\u001A\u00020\u001C8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001D\u0010\u001ER\u0016\u0010 \u001A\u00020\u001F8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001A\u00020\u001F8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\"\u0010!R\u001C\u0010$\u001A\b\u0018\u00010#R\u00020\u00008\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lokhttp3/MultipartReader;", "Ljava/io/Closeable;", "Lokio/BufferedSource;", "source", "", "boundary", "<init>", "(Lokio/BufferedSource;Ljava/lang/String;)V", "Lokhttp3/ResponseBody;", "response", "(Lokhttp3/ResponseBody;)V", "", "maxResult", "currentPartBytesRemaining", "(J)J", "Lokhttp3/MultipartReader$Part;", "nextPart", "()Lokhttp3/MultipartReader$Part;", "Lie/H;", "close", "()V", "Lokio/BufferedSource;", "Ljava/lang/String;", "()Ljava/lang/String;", "Lokio/ByteString;", "dashDashBoundary", "Lokio/ByteString;", "crlfDashDashBoundary", "", "partCount", "I", "", "closed", "Z", "noMoreParts", "Lokhttp3/MultipartReader$PartSource;", "currentPart", "Lokhttp3/MultipartReader$PartSource;", "Companion", "Part", "PartSource", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class MultipartReader implements Closeable {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/MultipartReader$Companion;", "", "()V", "afterBoundaryOptions", "Lokio/Options;", "getAfterBoundaryOptions", "()Lokio/Options;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final Options getAfterBoundaryOptions() {
            return MultipartReader.afterBoundaryOptions;
        }
    }

    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001A\u00020\bH\u0096\u0001¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001A\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u000B\u001A\u0004\b\u0003\u0010\fR\u0017\u0010\u0005\u001A\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u0005\u0010\r\u001A\u0004\b\u0005\u0010\u000E¨\u0006\u000F"}, d2 = {"Lokhttp3/MultipartReader$Part;", "Ljava/io/Closeable;", "Lokhttp3/Headers;", "headers", "Lokio/BufferedSource;", "body", "<init>", "(Lokhttp3/Headers;Lokio/BufferedSource;)V", "Lie/H;", "close", "()V", "Lokhttp3/Headers;", "()Lokhttp3/Headers;", "Lokio/BufferedSource;", "()Lokio/BufferedSource;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Part implements Closeable {
        @NotNull
        private final BufferedSource body;
        @NotNull
        private final Headers headers;

        public Part(@NotNull Headers headers0, @NotNull BufferedSource bufferedSource0) {
            q.g(headers0, "headers");
            q.g(bufferedSource0, "body");
            super();
            this.headers = headers0;
            this.body = bufferedSource0;
        }

        @NotNull
        public final BufferedSource body() {
            return this.body;
        }

        @Override
        public void close() {
            this.body.close();
        }

        @NotNull
        public final Headers headers() {
            return this.headers;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001F\u0010\u000B\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\u000E\u001A\u00020\rH\u0016¢\u0006\u0004\b\u000E\u0010\u000FR\u0014\u0010\u000E\u001A\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000E\u0010\u0010¨\u0006\u0011"}, d2 = {"Lokhttp3/MultipartReader$PartSource;", "Lokio/Source;", "<init>", "(Lokhttp3/MultipartReader;)V", "Lie/H;", "close", "()V", "Lokio/Buffer;", "sink", "", "byteCount", "read", "(Lokio/Buffer;J)J", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "Lokio/Timeout;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    final class PartSource implements Source {
        @NotNull
        private final Timeout timeout;

        public PartSource() {
            this.timeout = new Timeout();
        }

        @Override  // okio.Source
        public void close() {
            if(q.b(MultipartReader.this.currentPart, this)) {
                MultipartReader.this.currentPart = null;
            }
        }

        @Override  // okio.Source
        public long read(@NotNull Buffer buffer0, long v) {
            long v8;
            long v6;
            q.g(buffer0, "sink");
            if(v < 0L) {
                throw new IllegalArgumentException(e.a(v, "byteCount < 0: ").toString());
            }
            if(!q.b(MultipartReader.this.currentPart, this)) {
                throw new IllegalStateException("closed");
            }
            Timeout timeout0 = MultipartReader.this.source.timeout();
            Timeout timeout1 = this.timeout;
            MultipartReader multipartReader0 = MultipartReader.this;
            long v1 = timeout0.timeoutNanos();
            long v2 = timeout1.timeoutNanos();
            long v3 = timeout0.timeoutNanos();
            TimeUnit timeUnit0 = TimeUnit.NANOSECONDS;
            timeout0.timeout(Timeout.Companion.minTimeout(v2, v3), timeUnit0);
            if(timeout0.hasDeadline()) {
                long v4 = timeout0.deadlineNanoTime();
                if(timeout1.hasDeadline()) {
                    timeout0.deadlineNanoTime(Math.min(timeout0.deadlineNanoTime(), timeout1.deadlineNanoTime()));
                }
                try {
                    long v5 = multipartReader0.currentPartBytesRemaining(v);
                    v6 = v5 == 0L ? -1L : multipartReader0.source.read(buffer0, v5);
                }
                catch(Throwable throwable0) {
                    timeout0.timeout(v1, TimeUnit.NANOSECONDS);
                    if(timeout1.hasDeadline()) {
                        timeout0.deadlineNanoTime(v4);
                    }
                    throw throwable0;
                }
                timeout0.timeout(v1, timeUnit0);
                if(timeout1.hasDeadline()) {
                    timeout0.deadlineNanoTime(v4);
                }
                return v6;
            }
            if(timeout1.hasDeadline()) {
                timeout0.deadlineNanoTime(timeout1.deadlineNanoTime());
            }
            try {
                long v7 = multipartReader0.currentPartBytesRemaining(v);
                v8 = v7 == 0L ? -1L : multipartReader0.source.read(buffer0, v7);
            }
            catch(Throwable throwable1) {
                timeout0.timeout(v1, TimeUnit.NANOSECONDS);
                if(timeout1.hasDeadline()) {
                    timeout0.clearDeadline();
                }
                throw throwable1;
            }
            timeout0.timeout(v1, timeUnit0);
            if(timeout1.hasDeadline()) {
                timeout0.clearDeadline();
            }
            return v8;
        }

        @Override  // okio.Source
        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final Options afterBoundaryOptions;
    @NotNull
    private final String boundary;
    private boolean closed;
    @NotNull
    private final ByteString crlfDashDashBoundary;
    @Nullable
    private PartSource currentPart;
    @NotNull
    private final ByteString dashDashBoundary;
    private boolean noMoreParts;
    private int partCount;
    @NotNull
    private final BufferedSource source;

    static {
        MultipartReader.Companion = new Companion(null);
        ByteString[] arr_byteString = {ByteString.Companion.encodeUtf8("\r\n"), ByteString.Companion.encodeUtf8("--"), ByteString.Companion.encodeUtf8(" "), ByteString.Companion.encodeUtf8("\t")};
        MultipartReader.afterBoundaryOptions = Options.Companion.of(arr_byteString);
    }

    public MultipartReader(@NotNull ResponseBody responseBody0) {
        q.g(responseBody0, "response");
        BufferedSource bufferedSource0 = responseBody0.source();
        MediaType mediaType0 = responseBody0.contentType();
        if(mediaType0 != null) {
            String s = mediaType0.parameter("boundary");
            if(s != null) {
                this(bufferedSource0, s);
                return;
            }
        }
        throw new ProtocolException("expected the Content-Type to have a boundary parameter");
    }

    public MultipartReader(@NotNull BufferedSource bufferedSource0, @NotNull String s) {
        q.g(bufferedSource0, "source");
        q.g(s, "boundary");
        super();
        this.source = bufferedSource0;
        this.boundary = s;
        this.dashDashBoundary = new Buffer().writeUtf8("--").writeUtf8(s).readByteString();
        this.crlfDashDashBoundary = new Buffer().writeUtf8("\r\n--").writeUtf8(s).readByteString();
    }

    @NotNull
    public final String boundary() {
        return this.boundary;
    }

    @Override
    public void close() {
        if(this.closed) {
            return;
        }
        this.closed = true;
        this.currentPart = null;
        this.source.close();
    }

    private final long currentPartBytesRemaining(long v) {
        this.source.require(((long)this.crlfDashDashBoundary.size()));
        long v1 = this.source.getBuffer().indexOf(this.crlfDashDashBoundary);
        return v1 == -1L ? Math.min(v, this.source.getBuffer().size() - ((long)this.crlfDashDashBoundary.size()) + 1L) : Math.min(v, v1);
    }

    @Nullable
    public final Part nextPart() {
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        if(this.noMoreParts) {
            return null;
        }
        if(this.partCount != 0 || !this.source.rangeEquals(0L, this.dashDashBoundary)) {
            long v;
            while((v = this.currentPartBytesRemaining(0x2000L)) != 0L) {
                this.source.skip(v);
            }
            this.source.skip(((long)this.crlfDashDashBoundary.size()));
        }
        else {
            this.source.skip(((long)this.dashDashBoundary.size()));
        }
        boolean z = false;
        int v1;
        while((v1 = this.source.select(MultipartReader.afterBoundaryOptions)) != -1) {
            switch(v1) {
                case 0: {
                    ++this.partCount;
                    Headers headers0 = new HeadersReader(this.source).readHeaders();
                    PartSource multipartReader$PartSource0 = new PartSource(this);
                    this.currentPart = multipartReader$PartSource0;
                    return new Part(headers0, Okio.buffer(multipartReader$PartSource0));
                }
                case 1: {
                    if(z) {
                        throw new ProtocolException("unexpected characters after boundary");
                    }
                    if(this.partCount == 0) {
                        throw new ProtocolException("expected at least 1 part");
                    }
                    this.noMoreParts = true;
                    return null;
                label_27:
                    if(v1 == 2 || v1 == 3) {
                        break;
                    }
                    continue;
                }
                default: {
                    goto label_27;
                }
            }
            z = true;
        }
        throw new ProtocolException("unexpected characters after boundary");
    }
}

