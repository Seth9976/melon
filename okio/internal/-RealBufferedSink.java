package okio.internal;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.RealBufferedSink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A$\u0010\u0006\u001A\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0003H\u0080\b\u00A2\u0006\u0004\b\u0006\u0010\u0007\u001A\u001C\u0010\u0006\u001A\u00020\n*\u00020\u00002\u0006\u0010\t\u001A\u00020\bH\u0080\b\u00A2\u0006\u0004\b\u0006\u0010\u000B\u001A,\u0010\u0006\u001A\u00020\n*\u00020\u00002\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u0004\u001A\u00020\fH\u0080\b\u00A2\u0006\u0004\b\u0006\u0010\u000E\u001A\u001C\u0010\u0011\u001A\u00020\n*\u00020\u00002\u0006\u0010\u0010\u001A\u00020\u000FH\u0080\b\u00A2\u0006\u0004\b\u0011\u0010\u0012\u001A,\u0010\u0011\u001A\u00020\n*\u00020\u00002\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u00020\f2\u0006\u0010\u0014\u001A\u00020\fH\u0080\b\u00A2\u0006\u0004\b\u0011\u0010\u0015\u001A\u001C\u0010\u0017\u001A\u00020\n*\u00020\u00002\u0006\u0010\u0016\u001A\u00020\fH\u0080\b\u00A2\u0006\u0004\b\u0017\u0010\u0018\u001A\u001C\u0010\u0006\u001A\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0019H\u0080\b\u00A2\u0006\u0004\b\u0006\u0010\u001A\u001A,\u0010\u0006\u001A\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00192\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u0004\u001A\u00020\fH\u0080\b\u00A2\u0006\u0004\b\u0006\u0010\u001B\u001A\u001C\u0010\u001D\u001A\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u001CH\u0080\b\u00A2\u0006\u0004\b\u001D\u0010\u001E\u001A$\u0010\u0006\u001A\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u001C2\u0006\u0010\u0004\u001A\u00020\u0003H\u0080\b\u00A2\u0006\u0004\b\u0006\u0010\u001F\u001A\u001C\u0010!\u001A\u00020\n*\u00020\u00002\u0006\u0010 \u001A\u00020\fH\u0080\b\u00A2\u0006\u0004\b!\u0010\u0018\u001A\u001C\u0010#\u001A\u00020\n*\u00020\u00002\u0006\u0010\"\u001A\u00020\fH\u0080\b\u00A2\u0006\u0004\b#\u0010\u0018\u001A\u001C\u0010$\u001A\u00020\n*\u00020\u00002\u0006\u0010\"\u001A\u00020\fH\u0080\b\u00A2\u0006\u0004\b$\u0010\u0018\u001A\u001C\u0010&\u001A\u00020\n*\u00020\u00002\u0006\u0010%\u001A\u00020\fH\u0080\b\u00A2\u0006\u0004\b&\u0010\u0018\u001A\u001C\u0010\'\u001A\u00020\n*\u00020\u00002\u0006\u0010%\u001A\u00020\fH\u0080\b\u00A2\u0006\u0004\b\'\u0010\u0018\u001A\u001C\u0010)\u001A\u00020\n*\u00020\u00002\u0006\u0010(\u001A\u00020\u0003H\u0080\b\u00A2\u0006\u0004\b)\u0010*\u001A\u001C\u0010+\u001A\u00020\n*\u00020\u00002\u0006\u0010(\u001A\u00020\u0003H\u0080\b\u00A2\u0006\u0004\b+\u0010*\u001A\u001C\u0010,\u001A\u00020\n*\u00020\u00002\u0006\u0010(\u001A\u00020\u0003H\u0080\b\u00A2\u0006\u0004\b,\u0010*\u001A\u001C\u0010-\u001A\u00020\n*\u00020\u00002\u0006\u0010(\u001A\u00020\u0003H\u0080\b\u00A2\u0006\u0004\b-\u0010*\u001A\u0014\u0010.\u001A\u00020\n*\u00020\u0000H\u0080\b\u00A2\u0006\u0004\b.\u0010/\u001A\u0014\u00100\u001A\u00020\n*\u00020\u0000H\u0080\b\u00A2\u0006\u0004\b0\u0010/\u001A\u0014\u00101\u001A\u00020\u0005*\u00020\u0000H\u0080\b\u00A2\u0006\u0004\b1\u00102\u001A\u0014\u00103\u001A\u00020\u0005*\u00020\u0000H\u0080\b\u00A2\u0006\u0004\b3\u00102\u001A\u0014\u00105\u001A\u000204*\u00020\u0000H\u0080\b\u00A2\u0006\u0004\b5\u00106\u001A\u0014\u00107\u001A\u00020\u000F*\u00020\u0000H\u0080\b\u00A2\u0006\u0004\b7\u00108\u00A8\u00069"}, d2 = {"Lokio/RealBufferedSink;", "Lokio/Buffer;", "source", "", "byteCount", "Lie/H;", "commonWrite", "(Lokio/RealBufferedSink;Lokio/Buffer;J)V", "Lokio/ByteString;", "byteString", "Lokio/BufferedSink;", "(Lokio/RealBufferedSink;Lokio/ByteString;)Lokio/BufferedSink;", "", "offset", "(Lokio/RealBufferedSink;Lokio/ByteString;II)Lokio/BufferedSink;", "", "string", "commonWriteUtf8", "(Lokio/RealBufferedSink;Ljava/lang/String;)Lokio/BufferedSink;", "beginIndex", "endIndex", "(Lokio/RealBufferedSink;Ljava/lang/String;II)Lokio/BufferedSink;", "codePoint", "commonWriteUtf8CodePoint", "(Lokio/RealBufferedSink;I)Lokio/BufferedSink;", "", "(Lokio/RealBufferedSink;[B)Lokio/BufferedSink;", "(Lokio/RealBufferedSink;[BII)Lokio/BufferedSink;", "Lokio/Source;", "commonWriteAll", "(Lokio/RealBufferedSink;Lokio/Source;)J", "(Lokio/RealBufferedSink;Lokio/Source;J)Lokio/BufferedSink;", "b", "commonWriteByte", "s", "commonWriteShort", "commonWriteShortLe", "i", "commonWriteInt", "commonWriteIntLe", "v", "commonWriteLong", "(Lokio/RealBufferedSink;J)Lokio/BufferedSink;", "commonWriteLongLe", "commonWriteDecimalLong", "commonWriteHexadecimalUnsignedLong", "commonEmitCompleteSegments", "(Lokio/RealBufferedSink;)Lokio/BufferedSink;", "commonEmit", "commonFlush", "(Lokio/RealBufferedSink;)V", "commonClose", "Lokio/Timeout;", "commonTimeout", "(Lokio/RealBufferedSink;)Lokio/Timeout;", "commonToString", "(Lokio/RealBufferedSink;)Ljava/lang/String;", "okio"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public final class -RealBufferedSink {
    public static final void commonClose(@NotNull RealBufferedSink realBufferedSink0) {
        q.g(realBufferedSink0, "<this>");
        if(!realBufferedSink0.closed) {
            try {
                if(realBufferedSink0.bufferField.size() > 0L) {
                    realBufferedSink0.sink.write(realBufferedSink0.bufferField, realBufferedSink0.bufferField.size());
                }
                throwable0 = null;
            }
            catch(Throwable throwable0) {
            }
            try {
                realBufferedSink0.sink.close();
            }
            catch(Throwable throwable1) {
                if(throwable0 == null) {
                    throwable0 = throwable1;
                }
            }
            realBufferedSink0.closed = true;
            if(throwable0 != null) {
                throw throwable0;
            }
        }
    }

    @NotNull
    public static final BufferedSink commonEmit(@NotNull RealBufferedSink realBufferedSink0) {
        q.g(realBufferedSink0, "<this>");
        if(realBufferedSink0.closed) {
            throw new IllegalStateException("closed");
        }
        long v = realBufferedSink0.bufferField.size();
        if(v > 0L) {
            realBufferedSink0.sink.write(realBufferedSink0.bufferField, v);
        }
        return realBufferedSink0;
    }

    @NotNull
    public static final BufferedSink commonEmitCompleteSegments(@NotNull RealBufferedSink realBufferedSink0) {
        q.g(realBufferedSink0, "<this>");
        if(realBufferedSink0.closed) {
            throw new IllegalStateException("closed");
        }
        long v = realBufferedSink0.bufferField.completeSegmentByteCount();
        if(v > 0L) {
            realBufferedSink0.sink.write(realBufferedSink0.bufferField, v);
        }
        return realBufferedSink0;
    }

    public static final void commonFlush(@NotNull RealBufferedSink realBufferedSink0) {
        q.g(realBufferedSink0, "<this>");
        if(realBufferedSink0.closed) {
            throw new IllegalStateException("closed");
        }
        if(realBufferedSink0.bufferField.size() > 0L) {
            realBufferedSink0.sink.write(realBufferedSink0.bufferField, realBufferedSink0.bufferField.size());
        }
        realBufferedSink0.sink.flush();
    }

    @NotNull
    public static final Timeout commonTimeout(@NotNull RealBufferedSink realBufferedSink0) {
        q.g(realBufferedSink0, "<this>");
        return realBufferedSink0.sink.timeout();
    }

    @NotNull
    public static final String commonToString(@NotNull RealBufferedSink realBufferedSink0) {
        q.g(realBufferedSink0, "<this>");
        return "buffer(" + realBufferedSink0.sink + ')';
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink realBufferedSink0, @NotNull ByteString byteString0) {
        q.g(realBufferedSink0, "<this>");
        q.g(byteString0, "byteString");
        if(realBufferedSink0.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink0.bufferField.write(byteString0);
        return realBufferedSink0.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink realBufferedSink0, @NotNull ByteString byteString0, int v, int v1) {
        q.g(realBufferedSink0, "<this>");
        q.g(byteString0, "byteString");
        if(realBufferedSink0.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink0.bufferField.write(byteString0, v, v1);
        return realBufferedSink0.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink realBufferedSink0, @NotNull Source source0, long v) {
        q.g(realBufferedSink0, "<this>");
        q.g(source0, "source");
        while(v > 0L) {
            long v1 = source0.read(realBufferedSink0.bufferField, v);
            if(v1 == -1L) {
                throw new EOFException();
            }
            v -= v1;
            realBufferedSink0.emitCompleteSegments();
        }
        return realBufferedSink0;
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink realBufferedSink0, @NotNull byte[] arr_b) {
        q.g(realBufferedSink0, "<this>");
        q.g(arr_b, "source");
        if(realBufferedSink0.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink0.bufferField.write(arr_b);
        return realBufferedSink0.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink realBufferedSink0, @NotNull byte[] arr_b, int v, int v1) {
        q.g(realBufferedSink0, "<this>");
        q.g(arr_b, "source");
        if(realBufferedSink0.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink0.bufferField.write(arr_b, v, v1);
        return realBufferedSink0.emitCompleteSegments();
    }

    public static final void commonWrite(@NotNull RealBufferedSink realBufferedSink0, @NotNull Buffer buffer0, long v) {
        q.g(realBufferedSink0, "<this>");
        q.g(buffer0, "source");
        if(realBufferedSink0.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink0.bufferField.write(buffer0, v);
        realBufferedSink0.emitCompleteSegments();
    }

    public static final long commonWriteAll(@NotNull RealBufferedSink realBufferedSink0, @NotNull Source source0) {
        q.g(realBufferedSink0, "<this>");
        q.g(source0, "source");
        long v = 0L;
        long v1;
        while((v1 = source0.read(realBufferedSink0.bufferField, 0x2000L)) != -1L) {
            v += v1;
            realBufferedSink0.emitCompleteSegments();
        }
        return v;
    }

    @NotNull
    public static final BufferedSink commonWriteByte(@NotNull RealBufferedSink realBufferedSink0, int v) {
        q.g(realBufferedSink0, "<this>");
        if(realBufferedSink0.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink0.bufferField.writeByte(v);
        return realBufferedSink0.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteDecimalLong(@NotNull RealBufferedSink realBufferedSink0, long v) {
        q.g(realBufferedSink0, "<this>");
        if(realBufferedSink0.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink0.bufferField.writeDecimalLong(v);
        return realBufferedSink0.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteHexadecimalUnsignedLong(@NotNull RealBufferedSink realBufferedSink0, long v) {
        q.g(realBufferedSink0, "<this>");
        if(realBufferedSink0.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink0.bufferField.writeHexadecimalUnsignedLong(v);
        return realBufferedSink0.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteInt(@NotNull RealBufferedSink realBufferedSink0, int v) {
        q.g(realBufferedSink0, "<this>");
        if(realBufferedSink0.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink0.bufferField.writeInt(v);
        return realBufferedSink0.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteIntLe(@NotNull RealBufferedSink realBufferedSink0, int v) {
        q.g(realBufferedSink0, "<this>");
        if(realBufferedSink0.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink0.bufferField.writeIntLe(v);
        return realBufferedSink0.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteLong(@NotNull RealBufferedSink realBufferedSink0, long v) {
        q.g(realBufferedSink0, "<this>");
        if(realBufferedSink0.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink0.bufferField.writeLong(v);
        return realBufferedSink0.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteLongLe(@NotNull RealBufferedSink realBufferedSink0, long v) {
        q.g(realBufferedSink0, "<this>");
        if(realBufferedSink0.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink0.bufferField.writeLongLe(v);
        return realBufferedSink0.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteShort(@NotNull RealBufferedSink realBufferedSink0, int v) {
        q.g(realBufferedSink0, "<this>");
        if(realBufferedSink0.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink0.bufferField.writeShort(v);
        return realBufferedSink0.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteShortLe(@NotNull RealBufferedSink realBufferedSink0, int v) {
        q.g(realBufferedSink0, "<this>");
        if(realBufferedSink0.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink0.bufferField.writeShortLe(v);
        return realBufferedSink0.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteUtf8(@NotNull RealBufferedSink realBufferedSink0, @NotNull String s) {
        q.g(realBufferedSink0, "<this>");
        q.g(s, "string");
        if(realBufferedSink0.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink0.bufferField.writeUtf8(s);
        return realBufferedSink0.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteUtf8(@NotNull RealBufferedSink realBufferedSink0, @NotNull String s, int v, int v1) {
        q.g(realBufferedSink0, "<this>");
        q.g(s, "string");
        if(realBufferedSink0.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink0.bufferField.writeUtf8(s, v, v1);
        return realBufferedSink0.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteUtf8CodePoint(@NotNull RealBufferedSink realBufferedSink0, int v) {
        q.g(realBufferedSink0, "<this>");
        if(realBufferedSink0.closed) {
            throw new IllegalStateException("closed");
        }
        realBufferedSink0.bufferField.writeUtf8CodePoint(v);
        return realBufferedSink0.emitCompleteSegments();
    }
}

