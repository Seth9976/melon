package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\r\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\r\u001A\u00020\u00012\u0006\u0010\u0010\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\r\u0010\u0011J\'\u0010\r\u001A\u00020\u00012\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u000B\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b\r\u0010\u0014J\u0017\u0010\u0017\u001A\u00020\u00012\u0006\u0010\u0016\u001A\u00020\u0015H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\'\u0010\u0017\u001A\u00020\u00012\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u00122\u0006\u0010\u001A\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u001BJ\u0017\u0010\u001D\u001A\u00020\u00012\u0006\u0010\u001C\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u001F\u0010!\u001A\u00020\u00012\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010 \u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\b!\u0010\"J/\u0010!\u001A\u00020\u00012\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u00122\u0006\u0010\u001A\u001A\u00020\u00122\u0006\u0010 \u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\b!\u0010#J\u0017\u0010\r\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020$H\u0016\u00A2\u0006\u0004\b\r\u0010%J\'\u0010\r\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020$2\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u000B\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b\r\u0010&J\u0017\u0010\r\u001A\u00020\u00122\u0006\u0010\t\u001A\u00020\'H\u0016\u00A2\u0006\u0004\b\r\u0010(J\u0017\u0010*\u001A\u00020\n2\u0006\u0010\t\u001A\u00020)H\u0016\u00A2\u0006\u0004\b*\u0010+J\u001F\u0010\r\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020)2\u0006\u0010\u000B\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\r\u0010,J\u0017\u0010.\u001A\u00020\u00012\u0006\u0010-\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b.\u0010\u001EJ\u0017\u00100\u001A\u00020\u00012\u0006\u0010/\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b0\u0010\u001EJ\u0017\u00101\u001A\u00020\u00012\u0006\u0010/\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b1\u0010\u001EJ\u0017\u00103\u001A\u00020\u00012\u0006\u00102\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b3\u0010\u001EJ\u0017\u00104\u001A\u00020\u00012\u0006\u00102\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b4\u0010\u001EJ\u0017\u00106\u001A\u00020\u00012\u0006\u00105\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b6\u00107J\u0017\u00108\u001A\u00020\u00012\u0006\u00105\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b8\u00107J\u0017\u00109\u001A\u00020\u00012\u0006\u00105\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b9\u00107J\u0017\u0010:\u001A\u00020\u00012\u0006\u00105\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b:\u00107J\u000F\u0010;\u001A\u00020\u0001H\u0016\u00A2\u0006\u0004\b;\u0010<J\u000F\u0010=\u001A\u00020\u0001H\u0016\u00A2\u0006\u0004\b=\u0010<J\u000F\u0010?\u001A\u00020>H\u0016\u00A2\u0006\u0004\b?\u0010@J\u000F\u0010A\u001A\u00020\fH\u0016\u00A2\u0006\u0004\bA\u0010BJ\u000F\u0010D\u001A\u00020CH\u0016\u00A2\u0006\u0004\bD\u0010EJ\u000F\u0010F\u001A\u00020\fH\u0016\u00A2\u0006\u0004\bF\u0010BJ\u000F\u0010H\u001A\u00020GH\u0016\u00A2\u0006\u0004\bH\u0010IJ\u000F\u0010J\u001A\u00020\u0015H\u0016\u00A2\u0006\u0004\bJ\u0010KR\u0014\u0010\u0003\u001A\u00020\u00028\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010LR\u0014\u0010M\u001A\u00020\u00068\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010O\u001A\u00020C8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0006\n\u0004\bO\u0010PR\u001B\u0010\u0007\u001A\u00020\u00068\u00D6\u0002X\u0096\u0004\u00A2\u0006\f\u0012\u0004\bR\u0010B\u001A\u0004\bQ\u0010\b\u00A8\u0006S"}, d2 = {"Lokio/RealBufferedSink;", "Lokio/BufferedSink;", "Lokio/Sink;", "sink", "<init>", "(Lokio/Sink;)V", "Lokio/Buffer;", "buffer", "()Lokio/Buffer;", "source", "", "byteCount", "Lie/H;", "write", "(Lokio/Buffer;J)V", "Lokio/ByteString;", "byteString", "(Lokio/ByteString;)Lokio/BufferedSink;", "", "offset", "(Lokio/ByteString;II)Lokio/BufferedSink;", "", "string", "writeUtf8", "(Ljava/lang/String;)Lokio/BufferedSink;", "beginIndex", "endIndex", "(Ljava/lang/String;II)Lokio/BufferedSink;", "codePoint", "writeUtf8CodePoint", "(I)Lokio/BufferedSink;", "Ljava/nio/charset/Charset;", "charset", "writeString", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Lokio/BufferedSink;", "(Ljava/lang/String;IILjava/nio/charset/Charset;)Lokio/BufferedSink;", "", "([B)Lokio/BufferedSink;", "([BII)Lokio/BufferedSink;", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)I", "Lokio/Source;", "writeAll", "(Lokio/Source;)J", "(Lokio/Source;J)Lokio/BufferedSink;", "b", "writeByte", "s", "writeShort", "writeShortLe", "i", "writeInt", "writeIntLe", "v", "writeLong", "(J)Lokio/BufferedSink;", "writeLongLe", "writeDecimalLong", "writeHexadecimalUnsignedLong", "emitCompleteSegments", "()Lokio/BufferedSink;", "emit", "Ljava/io/OutputStream;", "outputStream", "()Ljava/io/OutputStream;", "flush", "()V", "", "isOpen", "()Z", "close", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "toString", "()Ljava/lang/String;", "Lokio/Sink;", "bufferField", "Lokio/Buffer;", "closed", "Z", "getBuffer", "getBuffer$annotations", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class RealBufferedSink implements BufferedSink {
    @NotNull
    public final Buffer bufferField;
    public boolean closed;
    @NotNull
    public final Sink sink;

    public RealBufferedSink(@NotNull Sink sink0) {
        q.g(sink0, "sink");
        super();
        this.sink = sink0;
        this.bufferField = new Buffer();
    }

    @Override  // okio.BufferedSink
    @NotNull
    public Buffer buffer() {
        return this.bufferField;
    }

    @Override  // okio.Sink
    public void close() {
        if(!this.closed) {
            try {
                if(this.bufferField.size() > 0L) {
                    this.sink.write(this.bufferField, this.bufferField.size());
                }
                throwable0 = null;
            }
            catch(Throwable throwable0) {
            }
            try {
                this.sink.close();
            }
            catch(Throwable throwable1) {
                if(throwable0 == null) {
                    throwable0 = throwable1;
                }
            }
            this.closed = true;
            if(throwable0 != null) {
                throw throwable0;
            }
        }
    }

    @Override  // okio.BufferedSink
    @NotNull
    public BufferedSink emit() {
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        long v = this.bufferField.size();
        if(v > 0L) {
            this.sink.write(this.bufferField, v);
        }
        return this;
    }

    @Override  // okio.BufferedSink
    @NotNull
    public BufferedSink emitCompleteSegments() {
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        long v = this.bufferField.completeSegmentByteCount();
        if(v > 0L) {
            this.sink.write(this.bufferField, v);
        }
        return this;
    }

    @Override  // okio.BufferedSink
    public void flush() {
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        if(this.bufferField.size() > 0L) {
            this.sink.write(this.bufferField, this.bufferField.size());
        }
        this.sink.flush();
    }

    @Override  // okio.BufferedSink
    @NotNull
    public Buffer getBuffer() {
        return this.bufferField;
    }

    public static void getBuffer$annotations() {
    }

    @Override
    public boolean isOpen() {
        return !this.closed;
    }

    @Override  // okio.BufferedSink
    @NotNull
    public OutputStream outputStream() {
        return new OutputStream() {
            @Override
            public void close() {
                RealBufferedSink.this.close();
            }

            @Override
            public void flush() {
                RealBufferedSink realBufferedSink0 = RealBufferedSink.this;
                if(!realBufferedSink0.closed) {
                    realBufferedSink0.flush();
                }
            }

            @Override
            public String toString() {
                return RealBufferedSink.this + ".outputStream()";
            }

            @Override
            public void write(int v) {
                RealBufferedSink realBufferedSink0 = RealBufferedSink.this;
                if(realBufferedSink0.closed) {
                    throw new IOException("closed");
                }
                realBufferedSink0.bufferField.writeByte(((int)(((byte)v))));
                RealBufferedSink.this.emitCompleteSegments();
            }

            @Override
            public void write(byte[] arr_b, int v, int v1) {
                q.g(arr_b, "data");
                RealBufferedSink realBufferedSink0 = RealBufferedSink.this;
                if(realBufferedSink0.closed) {
                    throw new IOException("closed");
                }
                realBufferedSink0.bufferField.write(arr_b, v, v1);
                RealBufferedSink.this.emitCompleteSegments();
            }
        };
    }

    @Override  // okio.Sink
    @NotNull
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @Override
    @NotNull
    public String toString() {
        return "buffer(" + this.sink + ')';
    }

    @Override
    public int write(@NotNull ByteBuffer byteBuffer0) {
        q.g(byteBuffer0, "source");
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        int v = this.bufferField.write(byteBuffer0);
        this.emitCompleteSegments();
        return v;
    }

    @Override  // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull ByteString byteString0) {
        q.g(byteString0, "byteString");
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.write(byteString0);
        return this.emitCompleteSegments();
    }

    @Override  // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull ByteString byteString0, int v, int v1) {
        q.g(byteString0, "byteString");
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.write(byteString0, v, v1);
        return this.emitCompleteSegments();
    }

    @Override  // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull Source source0, long v) {
        q.g(source0, "source");
        while(v > 0L) {
            long v1 = source0.read(this.bufferField, v);
            if(v1 == -1L) {
                throw new EOFException();
            }
            v -= v1;
            this.emitCompleteSegments();
        }
        return this;
    }

    @Override  // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull byte[] arr_b) {
        q.g(arr_b, "source");
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.write(arr_b);
        return this.emitCompleteSegments();
    }

    @Override  // okio.BufferedSink
    @NotNull
    public BufferedSink write(@NotNull byte[] arr_b, int v, int v1) {
        q.g(arr_b, "source");
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.write(arr_b, v, v1);
        return this.emitCompleteSegments();
    }

    @Override  // okio.Sink
    public void write(@NotNull Buffer buffer0, long v) {
        q.g(buffer0, "source");
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.write(buffer0, v);
        this.emitCompleteSegments();
    }

    @Override  // okio.BufferedSink
    public long writeAll(@NotNull Source source0) {
        q.g(source0, "source");
        long v = 0L;
        long v1;
        while((v1 = source0.read(this.bufferField, 0x2000L)) != -1L) {
            v += v1;
            this.emitCompleteSegments();
        }
        return v;
    }

    @Override  // okio.BufferedSink
    @NotNull
    public BufferedSink writeByte(int v) {
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeByte(v);
        return this.emitCompleteSegments();
    }

    @Override  // okio.BufferedSink
    @NotNull
    public BufferedSink writeDecimalLong(long v) {
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeDecimalLong(v);
        return this.emitCompleteSegments();
    }

    @Override  // okio.BufferedSink
    @NotNull
    public BufferedSink writeHexadecimalUnsignedLong(long v) {
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeHexadecimalUnsignedLong(v);
        return this.emitCompleteSegments();
    }

    @Override  // okio.BufferedSink
    @NotNull
    public BufferedSink writeInt(int v) {
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeInt(v);
        return this.emitCompleteSegments();
    }

    @Override  // okio.BufferedSink
    @NotNull
    public BufferedSink writeIntLe(int v) {
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeIntLe(v);
        return this.emitCompleteSegments();
    }

    @Override  // okio.BufferedSink
    @NotNull
    public BufferedSink writeLong(long v) {
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeLong(v);
        return this.emitCompleteSegments();
    }

    @Override  // okio.BufferedSink
    @NotNull
    public BufferedSink writeLongLe(long v) {
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeLongLe(v);
        return this.emitCompleteSegments();
    }

    @Override  // okio.BufferedSink
    @NotNull
    public BufferedSink writeShort(int v) {
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeShort(v);
        return this.emitCompleteSegments();
    }

    @Override  // okio.BufferedSink
    @NotNull
    public BufferedSink writeShortLe(int v) {
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeShortLe(v);
        return this.emitCompleteSegments();
    }

    @Override  // okio.BufferedSink
    @NotNull
    public BufferedSink writeString(@NotNull String s, int v, int v1, @NotNull Charset charset0) {
        q.g(s, "string");
        q.g(charset0, "charset");
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeString(s, v, v1, charset0);
        return this.emitCompleteSegments();
    }

    @Override  // okio.BufferedSink
    @NotNull
    public BufferedSink writeString(@NotNull String s, @NotNull Charset charset0) {
        q.g(s, "string");
        q.g(charset0, "charset");
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeString(s, charset0);
        return this.emitCompleteSegments();
    }

    @Override  // okio.BufferedSink
    @NotNull
    public BufferedSink writeUtf8(@NotNull String s) {
        q.g(s, "string");
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeUtf8(s);
        return this.emitCompleteSegments();
    }

    @Override  // okio.BufferedSink
    @NotNull
    public BufferedSink writeUtf8(@NotNull String s, int v, int v1) {
        q.g(s, "string");
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeUtf8(s, v, v1);
        return this.emitCompleteSegments();
    }

    @Override  // okio.BufferedSink
    @NotNull
    public BufferedSink writeUtf8CodePoint(int v) {
        if(this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeUtf8CodePoint(v);
        return this.emitCompleteSegments();
    }
}

