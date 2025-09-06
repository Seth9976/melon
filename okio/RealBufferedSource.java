package okio;

import h7.u0;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okio.internal.-Buffer;
import okio.internal.-RealBufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e;

@Metadata(d1 = {"\u0000\u009A\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\n\n\u0002\b\u001E\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\f\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u000B\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0017\u001A\u00020\u0016H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u000F\u0010\u001A\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0017\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u000B\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001CJ\u0017\u0010 \u001A\u00020\u001F2\u0006\u0010\u001E\u001A\u00020\u001DH\u0016\u00A2\u0006\u0004\b \u0010!J)\u0010 \u001A\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010#*\u00020\"2\f\u0010\u001E\u001A\b\u0012\u0004\u0012\u00028\u00000$H\u0016\u00A2\u0006\u0004\b \u0010%J\u000F\u0010\'\u001A\u00020&H\u0016\u00A2\u0006\u0004\b\'\u0010(J\u0017\u0010\'\u001A\u00020&2\u0006\u0010\u000B\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\'\u0010)J\u0017\u0010\f\u001A\u00020\u001F2\u0006\u0010\t\u001A\u00020&H\u0016\u00A2\u0006\u0004\b\f\u0010*J\u0017\u0010+\u001A\u00020\u00112\u0006\u0010\t\u001A\u00020&H\u0016\u00A2\u0006\u0004\b+\u0010,J\'\u0010\f\u001A\u00020\u001F2\u0006\u0010\t\u001A\u00020&2\u0006\u0010-\u001A\u00020\u001F2\u0006\u0010\u000B\u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\b\f\u0010.J\u0017\u0010\f\u001A\u00020\u001F2\u0006\u0010\t\u001A\u00020/H\u0016\u00A2\u0006\u0004\b\f\u00100J\u001F\u0010+\u001A\u00020\u00112\u0006\u0010\t\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b+\u00101J\u0017\u00103\u001A\u00020\n2\u0006\u0010\t\u001A\u000202H\u0016\u00A2\u0006\u0004\b3\u00104J\u000F\u00106\u001A\u000205H\u0016\u00A2\u0006\u0004\b6\u00107J\u0017\u00106\u001A\u0002052\u0006\u0010\u000B\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b6\u00108J\u0017\u0010;\u001A\u0002052\u0006\u0010:\u001A\u000209H\u0016\u00A2\u0006\u0004\b;\u0010<J\u001F\u0010;\u001A\u0002052\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010:\u001A\u000209H\u0016\u00A2\u0006\u0004\b;\u0010=J\u0011\u0010>\u001A\u0004\u0018\u000105H\u0016\u00A2\u0006\u0004\b>\u00107J\u000F\u0010?\u001A\u000205H\u0016\u00A2\u0006\u0004\b?\u00107J\u0017\u0010?\u001A\u0002052\u0006\u0010@\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b?\u00108J\u000F\u0010A\u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\bA\u0010BJ\u000F\u0010D\u001A\u00020CH\u0016\u00A2\u0006\u0004\bD\u0010EJ\u000F\u0010F\u001A\u00020CH\u0016\u00A2\u0006\u0004\bF\u0010EJ\u000F\u0010G\u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\bG\u0010BJ\u000F\u0010H\u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\bH\u0010BJ\u000F\u0010I\u001A\u00020\nH\u0016\u00A2\u0006\u0004\bI\u0010JJ\u000F\u0010K\u001A\u00020\nH\u0016\u00A2\u0006\u0004\bK\u0010JJ\u000F\u0010L\u001A\u00020\nH\u0016\u00A2\u0006\u0004\bL\u0010JJ\u000F\u0010M\u001A\u00020\nH\u0016\u00A2\u0006\u0004\bM\u0010JJ\u0017\u0010N\u001A\u00020\u00112\u0006\u0010\u000B\u001A\u00020\nH\u0016\u00A2\u0006\u0004\bN\u0010\u0013J\u0017\u0010P\u001A\u00020\n2\u0006\u0010O\u001A\u00020\u0016H\u0016\u00A2\u0006\u0004\bP\u0010QJ\u001F\u0010P\u001A\u00020\n2\u0006\u0010O\u001A\u00020\u00162\u0006\u0010R\u001A\u00020\nH\u0016\u00A2\u0006\u0004\bP\u0010SJ\'\u0010P\u001A\u00020\n2\u0006\u0010O\u001A\u00020\u00162\u0006\u0010R\u001A\u00020\n2\u0006\u0010T\u001A\u00020\nH\u0016\u00A2\u0006\u0004\bP\u0010UJ\u0017\u0010P\u001A\u00020\n2\u0006\u0010V\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\bP\u0010WJ\u001F\u0010P\u001A\u00020\n2\u0006\u0010V\u001A\u00020\u00192\u0006\u0010R\u001A\u00020\nH\u0016\u00A2\u0006\u0004\bP\u0010XJ\'\u0010P\u001A\u00020\n2\u0006\u0010V\u001A\u00020\u00192\u0006\u0010R\u001A\u00020\n2\u0006\u0010T\u001A\u00020\nH\u0016\u00A2\u0006\u0004\bP\u0010YJ\u0017\u0010[\u001A\u00020\n2\u0006\u0010Z\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b[\u0010WJ\u001F\u0010[\u001A\u00020\n2\u0006\u0010Z\u001A\u00020\u00192\u0006\u0010R\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b[\u0010XJ\u001F\u0010\\\u001A\u00020\u000E2\u0006\u0010-\u001A\u00020\n2\u0006\u0010V\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b\\\u0010]J/\u0010\\\u001A\u00020\u000E2\u0006\u0010-\u001A\u00020\n2\u0006\u0010V\u001A\u00020\u00192\u0006\u0010^\u001A\u00020\u001F2\u0006\u0010\u000B\u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\b\\\u0010_J\u000F\u0010`\u001A\u00020\u0001H\u0016\u00A2\u0006\u0004\b`\u0010aJ\u000F\u0010c\u001A\u00020bH\u0016\u00A2\u0006\u0004\bc\u0010dJ\u000F\u0010e\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\be\u0010\u0010J\u000F\u0010f\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\bf\u0010gJ\u000F\u0010i\u001A\u00020hH\u0016\u00A2\u0006\u0004\bi\u0010jJ\u000F\u0010k\u001A\u000205H\u0016\u00A2\u0006\u0004\bk\u00107R\u0014\u0010\u0003\u001A\u00020\u00028\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010lR\u0014\u0010m\u001A\u00020\u00068\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010o\u001A\u00020\u000E8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0006\n\u0004\bo\u0010pR\u001B\u0010\u0007\u001A\u00020\u00068\u00D6\u0002X\u0096\u0004\u00A2\u0006\f\u0012\u0004\br\u0010g\u001A\u0004\bq\u0010\b\u00A8\u0006s"}, d2 = {"Lokio/RealBufferedSource;", "Lokio/BufferedSource;", "Lokio/Source;", "source", "<init>", "(Lokio/Source;)V", "Lokio/Buffer;", "buffer", "()Lokio/Buffer;", "sink", "", "byteCount", "read", "(Lokio/Buffer;J)J", "", "exhausted", "()Z", "Lie/H;", "require", "(J)V", "request", "(J)Z", "", "readByte", "()B", "Lokio/ByteString;", "readByteString", "()Lokio/ByteString;", "(J)Lokio/ByteString;", "Lokio/Options;", "options", "", "select", "(Lokio/Options;)I", "", "T", "Lokio/TypedOptions;", "(Lokio/TypedOptions;)Ljava/lang/Object;", "", "readByteArray", "()[B", "(J)[B", "([B)I", "readFully", "([B)V", "offset", "([BII)I", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)I", "(Lokio/Buffer;J)V", "Lokio/Sink;", "readAll", "(Lokio/Sink;)J", "", "readUtf8", "()Ljava/lang/String;", "(J)Ljava/lang/String;", "Ljava/nio/charset/Charset;", "charset", "readString", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "(JLjava/nio/charset/Charset;)Ljava/lang/String;", "readUtf8Line", "readUtf8LineStrict", "limit", "readUtf8CodePoint", "()I", "", "readShort", "()S", "readShortLe", "readInt", "readIntLe", "readLong", "()J", "readLongLe", "readDecimalLong", "readHexadecimalUnsignedLong", "skip", "b", "indexOf", "(B)J", "fromIndex", "(BJ)J", "toIndex", "(BJJ)J", "bytes", "(Lokio/ByteString;)J", "(Lokio/ByteString;J)J", "(Lokio/ByteString;JJ)J", "targetBytes", "indexOfElement", "rangeEquals", "(JLokio/ByteString;)Z", "bytesOffset", "(JLokio/ByteString;II)Z", "peek", "()Lokio/BufferedSource;", "Ljava/io/InputStream;", "inputStream", "()Ljava/io/InputStream;", "isOpen", "close", "()V", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "toString", "Lokio/Source;", "bufferField", "Lokio/Buffer;", "closed", "Z", "getBuffer", "getBuffer$annotations", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class RealBufferedSource implements BufferedSource {
    @NotNull
    public final Buffer bufferField;
    public boolean closed;
    @NotNull
    public final Source source;

    public RealBufferedSource(@NotNull Source source0) {
        q.g(source0, "source");
        super();
        this.source = source0;
        this.bufferField = new Buffer();
    }

    @Override  // okio.BufferedSource
    @NotNull
    public Buffer buffer() {
        return this.bufferField;
    }

    @Override  // okio.Source
    public void close() {
        if(!this.closed) {
            this.closed = true;
            this.source.close();
            this.bufferField.clear();
        }
    }

    @Override  // okio.BufferedSource
    public boolean exhausted() {
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        return this.bufferField.exhausted() && this.source.read(this.bufferField, 0x2000L) == -1L;
    }

    @Override  // okio.BufferedSource
    @NotNull
    public Buffer getBuffer() {
        return this.bufferField;
    }

    public static void getBuffer$annotations() {
    }

    @Override  // okio.BufferedSource
    public long indexOf(byte b) {
        return this.indexOf(b, 0L, 0x7FFFFFFFFFFFFFFFL);
    }

    @Override  // okio.BufferedSource
    public long indexOf(byte b, long v) {
        return this.indexOf(b, v, 0x7FFFFFFFFFFFFFFFL);
    }

    @Override  // okio.BufferedSource
    public long indexOf(byte b, long v, long v1) {
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        if(0L <= v && v <= v1) {
            for(long v2 = v; Long.compare(v2, v1) < 0; v2 = Math.max(v2, v4)) {
                long v3 = this.bufferField.indexOf(b, v2, v1);
                if(v3 != -1L) {
                    return v3;
                }
                long v4 = this.bufferField.size();
                if(v4 >= v1 || this.source.read(this.bufferField, 0x2000L) == -1L) {
                    break;
                }
            }
            return -1L;
        }
        StringBuilder stringBuilder0 = Y.o(v, "fromIndex=", " toIndex=");
        stringBuilder0.append(v1);
        throw new IllegalArgumentException(stringBuilder0.toString().toString());
    }

    @Override  // okio.BufferedSource
    public long indexOf(@NotNull ByteString byteString0) {
        q.g(byteString0, "bytes");
        return this.indexOf(byteString0, 0L);
    }

    @Override  // okio.BufferedSource
    public long indexOf(@NotNull ByteString byteString0, long v) {
        q.g(byteString0, "bytes");
        return this.indexOf(byteString0, v, 0x7FFFFFFFFFFFFFFFL);
    }

    @Override  // okio.BufferedSource
    public long indexOf(@NotNull ByteString byteString0, long v, long v1) {
        q.g(byteString0, "bytes");
        return -RealBufferedSource.commonIndexOf$default(this, byteString0, 0, 0, v, v1, 6, null);
    }

    @Override  // okio.BufferedSource
    public long indexOfElement(@NotNull ByteString byteString0) {
        q.g(byteString0, "targetBytes");
        return this.indexOfElement(byteString0, 0L);
    }

    @Override  // okio.BufferedSource
    public long indexOfElement(@NotNull ByteString byteString0, long v) {
        q.g(byteString0, "targetBytes");
        if(!this.closed) {
            while(true) {
                long v1 = this.bufferField.indexOfElement(byteString0, v);
                if(v1 != -1L) {
                    return v1;
                }
                long v2 = this.bufferField.size();
                if(this.source.read(this.bufferField, 0x2000L) == -1L) {
                    return -1L;
                }
                v = Math.max(v, v2);
            }
        }
        throw new IllegalStateException("closed");
    }

    @Override  // okio.BufferedSource
    @NotNull
    public InputStream inputStream() {
        return new InputStream() {
            @Override
            public int available() {
                RealBufferedSource realBufferedSource0 = RealBufferedSource.this;
                if(realBufferedSource0.closed) {
                    throw new IOException("closed");
                }
                return (int)Math.min(realBufferedSource0.bufferField.size(), 0x7FFFFFFFL);
            }

            @Override
            public void close() {
                RealBufferedSource.this.close();
            }

            @Override
            public int read() {
                RealBufferedSource realBufferedSource0 = RealBufferedSource.this;
                if(realBufferedSource0.closed) {
                    throw new IOException("closed");
                }
                return realBufferedSource0.bufferField.size() != 0L || RealBufferedSource.this.source.read(RealBufferedSource.this.bufferField, 0x2000L) != -1L ? RealBufferedSource.this.bufferField.readByte() & 0xFF : -1;
            }

            @Override
            public int read(byte[] arr_b, int v, int v1) {
                q.g(arr_b, "data");
                if(RealBufferedSource.this.closed) {
                    throw new IOException("closed");
                }
                -SegmentedByteString.checkOffsetAndCount(arr_b.length, v, v1);
                return RealBufferedSource.this.bufferField.size() != 0L || RealBufferedSource.this.source.read(RealBufferedSource.this.bufferField, 0x2000L) != -1L ? RealBufferedSource.this.bufferField.read(arr_b, v, v1) : -1;
            }

            @Override
            public String toString() {
                return RealBufferedSource.this + ".inputStream()";
            }

            @Override
            public long transferTo(OutputStream outputStream0) {
                q.g(outputStream0, "out");
                if(RealBufferedSource.this.closed) {
                    throw new IOException("closed");
                }
                long v = 0L;
                while(RealBufferedSource.this.bufferField.size() != 0L || RealBufferedSource.this.source.read(RealBufferedSource.this.bufferField, 0x2000L) != -1L) {
                    v += RealBufferedSource.this.bufferField.size();
                    Buffer.writeTo$default(RealBufferedSource.this.bufferField, outputStream0, 0L, 2, null);
                }
                return v;
            }
        };
    }

    @Override
    public boolean isOpen() {
        return !this.closed;
    }

    @Override  // okio.BufferedSource
    @NotNull
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override  // okio.BufferedSource
    public boolean rangeEquals(long v, @NotNull ByteString byteString0) {
        q.g(byteString0, "bytes");
        return this.rangeEquals(v, byteString0, 0, byteString0.size());
    }

    @Override  // okio.BufferedSource
    public boolean rangeEquals(long v, @NotNull ByteString byteString0, int v1, int v2) {
        q.g(byteString0, "bytes");
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        if(v2 < 0) {
            return false;
        }
        if(v < 0L) {
            return false;
        }
        if(v1 >= 0 && v1 + v2 <= byteString0.size()) {
            return v2 == 0 ? true : -RealBufferedSource.commonIndexOf(this, byteString0, v1, v2, v, v + 1L) != -1L;
        }
        return false;
    }

    @Override
    public int read(@NotNull ByteBuffer byteBuffer0) {
        q.g(byteBuffer0, "sink");
        return this.bufferField.size() != 0L || this.source.read(this.bufferField, 0x2000L) != -1L ? this.bufferField.read(byteBuffer0) : -1;
    }

    @Override  // okio.BufferedSource
    public int read(@NotNull byte[] arr_b) {
        q.g(arr_b, "sink");
        return this.read(arr_b, 0, arr_b.length);
    }

    @Override  // okio.BufferedSource
    public int read(@NotNull byte[] arr_b, int v, int v1) {
        q.g(arr_b, "sink");
        -SegmentedByteString.checkOffsetAndCount(arr_b.length, v, v1);
        if(this.bufferField.size() == 0L) {
            if(v1 == 0) {
                return 0;
            }
            return this.source.read(this.bufferField, 0x2000L) == -1L ? -1 : this.bufferField.read(arr_b, v, ((int)Math.min(v1, this.bufferField.size())));
        }
        return this.bufferField.read(arr_b, v, ((int)Math.min(v1, this.bufferField.size())));
    }

    @Override  // okio.Source
    public long read(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "sink");
        int v1 = Long.compare(v, 0L);
        if(v1 < 0) {
            throw new IllegalArgumentException(e.a(v, "byteCount < 0: ").toString());
        }
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        if(this.bufferField.size() == 0L) {
            if(v1 == 0) {
                return 0L;
            }
            return this.source.read(this.bufferField, 0x2000L) == -1L ? -1L : this.bufferField.read(buffer0, Math.min(v, this.bufferField.size()));
        }
        return this.bufferField.read(buffer0, Math.min(v, this.bufferField.size()));
    }

    @Override  // okio.BufferedSource
    public long readAll(@NotNull Sink sink0) {
        q.g(sink0, "sink");
        long v = 0L;
        while(this.source.read(this.bufferField, 0x2000L) != -1L) {
            long v1 = this.bufferField.completeSegmentByteCount();
            if(v1 > 0L) {
                v += v1;
                sink0.write(this.bufferField, v1);
            }
        }
        if(this.bufferField.size() > 0L) {
            sink0.write(this.bufferField, this.bufferField.size());
            return this.bufferField.size() + v;
        }
        return v;
    }

    @Override  // okio.BufferedSource
    public byte readByte() {
        this.require(1L);
        return this.bufferField.readByte();
    }

    @Override  // okio.BufferedSource
    @NotNull
    public byte[] readByteArray() {
        this.bufferField.writeAll(this.source);
        return new byte[0];
    }

    @Override  // okio.BufferedSource
    @NotNull
    public byte[] readByteArray(long v) {
        this.require(v);
        return this.bufferField.readByteArray(v);
    }

    @Override  // okio.BufferedSource
    @NotNull
    public ByteString readByteString() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteString();
    }

    @Override  // okio.BufferedSource
    @NotNull
    public ByteString readByteString(long v) {
        this.require(v);
        return this.bufferField.readByteString(v);
    }

    @Override  // okio.BufferedSource
    public long readDecimalLong() {
        this.require(1L);
        for(long v = 0L; this.request(v + 1L); ++v) {
            int v1 = this.bufferField.getByte(v);
            if(v1 < 0x30 || v1 > 57) {
                int v2 = Long.compare(v, 0L);
                if(v2 != 0 || v1 != 45) {
                    if(v2 != 0) {
                        break;
                    }
                    u0.l(16);
                    String s = Integer.toString(v1, 16);
                    q.f(s, "toString(...)");
                    throw new NumberFormatException("Expected a digit or \'-\' but was 0x" + s);
                }
            }
        }
        return this.bufferField.readDecimalLong();
    }

    @Override  // okio.BufferedSource
    public void readFully(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "sink");
        try {
            this.require(v);
        }
        catch(EOFException eOFException0) {
            buffer0.writeAll(this.bufferField);
            throw eOFException0;
        }
        this.bufferField.readFully(buffer0, v);
    }

    @Override  // okio.BufferedSource
    public void readFully(@NotNull byte[] arr_b) {
        q.g(arr_b, "sink");
        try {
            this.require(((long)arr_b.length));
        }
        catch(EOFException eOFException0) {
            for(int v = 0; this.bufferField.size() > 0L; v += v1) {
                int v1 = this.bufferField.read(arr_b, v, ((int)this.bufferField.size()));
                if(v1 == -1) {
                    throw new AssertionError();
                }
            }
            throw eOFException0;
        }
        this.bufferField.readFully(arr_b);
    }

    @Override  // okio.BufferedSource
    public long readHexadecimalUnsignedLong() {
        this.require(1L);
        int v = 0;
        while(this.request(((long)(v + 1)))) {
            int v1 = this.bufferField.getByte(((long)v));
            if(v1 >= 0x30 && v1 <= 57 || v1 >= 97 && v1 <= 102 || v1 >= 65 && v1 <= 70) {
                ++v;
                continue;
            }
            if(v != 0) {
                break;
            }
            u0.l(16);
            String s = Integer.toString(v1, 16);
            q.f(s, "toString(...)");
            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + s);
        }
        return this.bufferField.readHexadecimalUnsignedLong();
    }

    @Override  // okio.BufferedSource
    public int readInt() {
        this.require(4L);
        return this.bufferField.readInt();
    }

    @Override  // okio.BufferedSource
    public int readIntLe() {
        this.require(4L);
        return this.bufferField.readIntLe();
    }

    @Override  // okio.BufferedSource
    public long readLong() {
        this.require(8L);
        return this.bufferField.readLong();
    }

    @Override  // okio.BufferedSource
    public long readLongLe() {
        this.require(8L);
        return this.bufferField.readLongLe();
    }

    @Override  // okio.BufferedSource
    public short readShort() {
        this.require(2L);
        return this.bufferField.readShort();
    }

    @Override  // okio.BufferedSource
    public short readShortLe() {
        this.require(2L);
        return this.bufferField.readShortLe();
    }

    @Override  // okio.BufferedSource
    @NotNull
    public String readString(long v, @NotNull Charset charset0) {
        q.g(charset0, "charset");
        this.require(v);
        return this.bufferField.readString(v, charset0);
    }

    @Override  // okio.BufferedSource
    @NotNull
    public String readString(@NotNull Charset charset0) {
        q.g(charset0, "charset");
        this.bufferField.writeAll(this.source);
        return this.bufferField.readString(charset0);
    }

    @Override  // okio.BufferedSource
    @NotNull
    public String readUtf8() {
        this.bufferField.writeAll(this.source);
        return "";
    }

    @Override  // okio.BufferedSource
    @NotNull
    public String readUtf8(long v) {
        this.require(v);
        return this.bufferField.readUtf8(v);
    }

    @Override  // okio.BufferedSource
    public int readUtf8CodePoint() {
        this.require(1L);
        int v = this.bufferField.getByte(0L);
        if((v & 0xE0) == 0xC0) {
            this.require(2L);
            return this.bufferField.readUtf8CodePoint();
        }
        if((v & 0xF0) == 0xE0) {
            this.require(3L);
            return this.bufferField.readUtf8CodePoint();
        }
        if((v & 0xF8) == 0xF0) {
            this.require(4L);
        }
        return this.bufferField.readUtf8CodePoint();
    }

    @Override  // okio.BufferedSource
    @Nullable
    public String readUtf8Line() {
        long v = this.indexOf(10);
        if(v == -1L) {
            return this.bufferField.size() == 0L ? null : this.readUtf8(this.bufferField.size());
        }
        return -Buffer.readUtf8Line(this.bufferField, v);
    }

    @Override  // okio.BufferedSource
    @NotNull
    public String readUtf8LineStrict() {
        return this.readUtf8LineStrict(0x7FFFFFFFFFFFFFFFL);
    }

    @Override  // okio.BufferedSource
    @NotNull
    public String readUtf8LineStrict(long v) {
        if(v < 0L) {
            throw new IllegalArgumentException(e.a(v, "limit < 0: ").toString());
        }
        long v1 = Long.compare(v, 0x7FFFFFFFFFFFFFFFL) == 0 ? 0x7FFFFFFFFFFFFFFFL : v + 1L;
        long v2 = this.indexOf(10, 0L, v1);
        if(v2 != -1L) {
            return -Buffer.readUtf8Line(this.bufferField, v2);
        }
        if(v1 < 0x7FFFFFFFFFFFFFFFL && this.request(v1) && this.bufferField.getByte(v1 - 1L) == 13 && this.request(v1 + 1L) && this.bufferField.getByte(v1) == 10) {
            return -Buffer.readUtf8Line(this.bufferField, v1);
        }
        Buffer buffer0 = new Buffer();
        this.bufferField.copyTo(buffer0, 0L, Math.min(0x20L, this.bufferField.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.bufferField.size(), v) + " content=" + buffer0.readByteString().hex() + '…');
    }

    @Override  // okio.BufferedSource
    public boolean request(long v) {
        if(v < 0L) {
            throw new IllegalArgumentException(e.a(v, "byteCount < 0: ").toString());
        }
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        while(this.bufferField.size() < v) {
            if(this.source.read(this.bufferField, 0x2000L) == -1L) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return true;
    }

    @Override  // okio.BufferedSource
    public void require(long v) {
        if(!this.request(v)) {
            throw new EOFException();
        }
    }

    @Override  // okio.BufferedSource
    public int select(@NotNull Options options0) {
        q.g(options0, "options");
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
    alab1:
        while(true) {
            int v = -Buffer.selectPrefix(this.bufferField, options0, true);
            switch(v) {
                case -2: {
                    if(this.source.read(this.bufferField, 0x2000L) != -1L) {
                        break;
                    }
                    break alab1;
                }
                case -1: {
                    return -1;
                }
                default: {
                    this.bufferField.skip(((long)options0.getByteStrings$okio()[v].size()));
                    return v;
                }
            }
        }
        return -1;
    }

    @Override  // okio.BufferedSource
    @Nullable
    public Object select(@NotNull TypedOptions typedOptions0) {
        q.g(typedOptions0, "options");
        int v = this.select(typedOptions0.getOptions$okio());
        return v == -1 ? null : typedOptions0.get(v);
    }

    @Override  // okio.BufferedSource
    public void skip(long v) {
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        while(v > 0L) {
            if(this.bufferField.size() == 0L && this.source.read(this.bufferField, 0x2000L) == -1L) {
                throw new EOFException();
            }
            long v1 = Math.min(v, this.bufferField.size());
            this.bufferField.skip(v1);
            v -= v1;
        }
    }

    @Override  // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.source.timeout();
    }

    @Override
    @NotNull
    public String toString() {
        return "buffer(" + this.source + ')';
    }
}

