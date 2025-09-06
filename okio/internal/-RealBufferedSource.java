package okio.internal;

import h7.u0;
import java.io.EOFException;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okio.-SegmentedByteString;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.PeekSource;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\n\n\u0002\b\u001A\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A$\u0010\u0005\u001A\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0003H\u0080\b\u00A2\u0006\u0004\b\u0005\u0010\u0006\u001A\u0014\u0010\b\u001A\u00020\u0007*\u00020\u0000H\u0080\b\u00A2\u0006\u0004\b\b\u0010\t\u001A\u001C\u0010\u000B\u001A\u00020\n*\u00020\u00002\u0006\u0010\u0004\u001A\u00020\u0003H\u0080\b\u00A2\u0006\u0004\b\u000B\u0010\f\u001A\u001C\u0010\r\u001A\u00020\u0007*\u00020\u00002\u0006\u0010\u0004\u001A\u00020\u0003H\u0080\b\u00A2\u0006\u0004\b\r\u0010\u000E\u001A\u0014\u0010\u0010\u001A\u00020\u000F*\u00020\u0000H\u0080\b\u00A2\u0006\u0004\b\u0010\u0010\u0011\u001A\u0014\u0010\u0013\u001A\u00020\u0012*\u00020\u0000H\u0080\b\u00A2\u0006\u0004\b\u0013\u0010\u0014\u001A\u001C\u0010\u0013\u001A\u00020\u0012*\u00020\u00002\u0006\u0010\u0004\u001A\u00020\u0003H\u0080\b\u00A2\u0006\u0004\b\u0013\u0010\u0015\u001A\u001C\u0010\u0019\u001A\u00020\u0018*\u00020\u00002\u0006\u0010\u0017\u001A\u00020\u0016H\u0080\b\u00A2\u0006\u0004\b\u0019\u0010\u001A\u001A\u0014\u0010\u001C\u001A\u00020\u001B*\u00020\u0000H\u0080\b\u00A2\u0006\u0004\b\u001C\u0010\u001D\u001A\u001C\u0010\u001C\u001A\u00020\u001B*\u00020\u00002\u0006\u0010\u0004\u001A\u00020\u0003H\u0080\b\u00A2\u0006\u0004\b\u001C\u0010\u001E\u001A\u001C\u0010\u001F\u001A\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u001BH\u0080\b\u00A2\u0006\u0004\b\u001F\u0010 \u001A,\u0010\u0005\u001A\u00020\u0018*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u001B2\u0006\u0010!\u001A\u00020\u00182\u0006\u0010\u0004\u001A\u00020\u0018H\u0080\b\u00A2\u0006\u0004\b\u0005\u0010\"\u001A$\u0010\u001F\u001A\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0003H\u0080\b\u00A2\u0006\u0004\b\u001F\u0010#\u001A\u001C\u0010%\u001A\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001A\u00020$H\u0080\b\u00A2\u0006\u0004\b%\u0010&\u001A\u0014\u0010(\u001A\u00020\'*\u00020\u0000H\u0080\b\u00A2\u0006\u0004\b(\u0010)\u001A\u001C\u0010(\u001A\u00020\'*\u00020\u00002\u0006\u0010\u0004\u001A\u00020\u0003H\u0080\b\u00A2\u0006\u0004\b(\u0010*\u001A\u0016\u0010+\u001A\u0004\u0018\u00010\'*\u00020\u0000H\u0080\b\u00A2\u0006\u0004\b+\u0010)\u001A\u001C\u0010-\u001A\u00020\'*\u00020\u00002\u0006\u0010,\u001A\u00020\u0003H\u0080\b\u00A2\u0006\u0004\b-\u0010*\u001A\u0014\u0010.\u001A\u00020\u0018*\u00020\u0000H\u0080\b\u00A2\u0006\u0004\b.\u0010/\u001A\u0014\u00101\u001A\u000200*\u00020\u0000H\u0080\b\u00A2\u0006\u0004\b1\u00102\u001A\u0014\u00103\u001A\u000200*\u00020\u0000H\u0080\b\u00A2\u0006\u0004\b3\u00102\u001A\u0014\u00104\u001A\u00020\u0018*\u00020\u0000H\u0080\b\u00A2\u0006\u0004\b4\u0010/\u001A\u0014\u00105\u001A\u00020\u0018*\u00020\u0000H\u0080\b\u00A2\u0006\u0004\b5\u0010/\u001A\u0014\u00106\u001A\u00020\u0003*\u00020\u0000H\u0080\b\u00A2\u0006\u0004\b6\u00107\u001A\u0014\u00108\u001A\u00020\u0003*\u00020\u0000H\u0080\b\u00A2\u0006\u0004\b8\u00107\u001A\u0014\u00109\u001A\u00020\u0003*\u00020\u0000H\u0080\b\u00A2\u0006\u0004\b9\u00107\u001A\u0014\u0010:\u001A\u00020\u0003*\u00020\u0000H\u0080\b\u00A2\u0006\u0004\b:\u00107\u001A\u001C\u0010;\u001A\u00020\n*\u00020\u00002\u0006\u0010\u0004\u001A\u00020\u0003H\u0080\b\u00A2\u0006\u0004\b;\u0010\f\u001A,\u0010?\u001A\u00020\u0003*\u00020\u00002\u0006\u0010<\u001A\u00020\u000F2\u0006\u0010=\u001A\u00020\u00032\u0006\u0010>\u001A\u00020\u0003H\u0080\b\u00A2\u0006\u0004\b?\u0010@\u001AA\u0010?\u001A\u00020\u0003*\u00020\u00002\u0006\u0010A\u001A\u00020\u00122\b\b\u0002\u0010B\u001A\u00020\u00182\b\b\u0002\u0010\u0004\u001A\u00020\u00182\u0006\u0010=\u001A\u00020\u00032\b\b\u0002\u0010>\u001A\u00020\u0003H\u0000\u00A2\u0006\u0004\b?\u0010C\u001A;\u0010D\u001A\u00020\u0007*\u00020\u00012\u0006\u0010A\u001A\u00020\u00122\u0006\u0010B\u001A\u00020\u00182\u0006\u0010\u0004\u001A\u00020\u00182\u0006\u0010=\u001A\u00020\u00032\u0006\u0010>\u001A\u00020\u0003H\u0002\u00A2\u0006\u0004\bD\u0010E\u001A$\u0010G\u001A\u00020\u0003*\u00020\u00002\u0006\u0010F\u001A\u00020\u00122\u0006\u0010=\u001A\u00020\u0003H\u0080\b\u00A2\u0006\u0004\bG\u0010H\u001A4\u0010I\u001A\u00020\u0007*\u00020\u00002\u0006\u0010!\u001A\u00020\u00032\u0006\u0010A\u001A\u00020\u00122\u0006\u0010B\u001A\u00020\u00182\u0006\u0010\u0004\u001A\u00020\u0018H\u0080\b\u00A2\u0006\u0004\bI\u0010J\u001A\u0014\u0010L\u001A\u00020K*\u00020\u0000H\u0080\b\u00A2\u0006\u0004\bL\u0010M\u001A\u0014\u0010N\u001A\u00020\n*\u00020\u0000H\u0080\b\u00A2\u0006\u0004\bN\u0010O\u001A\u0014\u0010Q\u001A\u00020P*\u00020\u0000H\u0080\b\u00A2\u0006\u0004\bQ\u0010R\u001A\u0014\u0010S\u001A\u00020\'*\u00020\u0000H\u0080\b\u00A2\u0006\u0004\bS\u0010)\u00A8\u0006T"}, d2 = {"Lokio/RealBufferedSource;", "Lokio/Buffer;", "sink", "", "byteCount", "commonRead", "(Lokio/RealBufferedSource;Lokio/Buffer;J)J", "", "commonExhausted", "(Lokio/RealBufferedSource;)Z", "Lie/H;", "commonRequire", "(Lokio/RealBufferedSource;J)V", "commonRequest", "(Lokio/RealBufferedSource;J)Z", "", "commonReadByte", "(Lokio/RealBufferedSource;)B", "Lokio/ByteString;", "commonReadByteString", "(Lokio/RealBufferedSource;)Lokio/ByteString;", "(Lokio/RealBufferedSource;J)Lokio/ByteString;", "Lokio/Options;", "options", "", "commonSelect", "(Lokio/RealBufferedSource;Lokio/Options;)I", "", "commonReadByteArray", "(Lokio/RealBufferedSource;)[B", "(Lokio/RealBufferedSource;J)[B", "commonReadFully", "(Lokio/RealBufferedSource;[B)V", "offset", "(Lokio/RealBufferedSource;[BII)I", "(Lokio/RealBufferedSource;Lokio/Buffer;J)V", "Lokio/Sink;", "commonReadAll", "(Lokio/RealBufferedSource;Lokio/Sink;)J", "", "commonReadUtf8", "(Lokio/RealBufferedSource;)Ljava/lang/String;", "(Lokio/RealBufferedSource;J)Ljava/lang/String;", "commonReadUtf8Line", "limit", "commonReadUtf8LineStrict", "commonReadUtf8CodePoint", "(Lokio/RealBufferedSource;)I", "", "commonReadShort", "(Lokio/RealBufferedSource;)S", "commonReadShortLe", "commonReadInt", "commonReadIntLe", "commonReadLong", "(Lokio/RealBufferedSource;)J", "commonReadLongLe", "commonReadDecimalLong", "commonReadHexadecimalUnsignedLong", "commonSkip", "b", "fromIndex", "toIndex", "commonIndexOf", "(Lokio/RealBufferedSource;BJJ)J", "bytes", "bytesOffset", "(Lokio/RealBufferedSource;Lokio/ByteString;IIJJ)J", "isMatchPossibleByExpandingBuffer", "(Lokio/Buffer;Lokio/ByteString;IIJJ)Z", "targetBytes", "commonIndexOfElement", "(Lokio/RealBufferedSource;Lokio/ByteString;J)J", "commonRangeEquals", "(Lokio/RealBufferedSource;JLokio/ByteString;II)Z", "Lokio/BufferedSource;", "commonPeek", "(Lokio/RealBufferedSource;)Lokio/BufferedSource;", "commonClose", "(Lokio/RealBufferedSource;)V", "Lokio/Timeout;", "commonTimeout", "(Lokio/RealBufferedSource;)Lokio/Timeout;", "commonToString", "okio"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public final class -RealBufferedSource {
    public static final void commonClose(@NotNull RealBufferedSource realBufferedSource0) {
        q.g(realBufferedSource0, "<this>");
        if(realBufferedSource0.closed) {
            return;
        }
        realBufferedSource0.closed = true;
        realBufferedSource0.source.close();
        realBufferedSource0.bufferField.clear();
    }

    public static final boolean commonExhausted(@NotNull RealBufferedSource realBufferedSource0) {
        q.g(realBufferedSource0, "<this>");
        if(realBufferedSource0.closed) {
            throw new IllegalStateException("closed");
        }
        return realBufferedSource0.bufferField.exhausted() && realBufferedSource0.source.read(realBufferedSource0.bufferField, 0x2000L) == -1L;
    }

    public static final long commonIndexOf(@NotNull RealBufferedSource realBufferedSource0, byte b, long v, long v1) {
        q.g(realBufferedSource0, "<this>");
        if(realBufferedSource0.closed) {
            throw new IllegalStateException("closed");
        }
        if(0L <= v && v <= v1) {
            for(long v2 = v; Long.compare(v2, v1) < 0; v2 = Math.max(v2, v4)) {
                long v3 = realBufferedSource0.bufferField.indexOf(b, v2, v1);
                if(v3 != -1L) {
                    return v3;
                }
                long v4 = realBufferedSource0.bufferField.size();
                if(v4 >= v1 || realBufferedSource0.source.read(realBufferedSource0.bufferField, 0x2000L) == -1L) {
                    break;
                }
            }
            return -1L;
        }
        StringBuilder stringBuilder0 = Y.o(v, "fromIndex=", " toIndex=");
        stringBuilder0.append(v1);
        throw new IllegalArgumentException(stringBuilder0.toString().toString());
    }

    public static final long commonIndexOf(@NotNull RealBufferedSource realBufferedSource0, @NotNull ByteString byteString0, int v, int v1, long v2, long v3) {
        q.g(realBufferedSource0, "<this>");
        q.g(byteString0, "bytes");
        -SegmentedByteString.checkOffsetAndCount(byteString0.size(), v, v1);
        if(!realBufferedSource0.closed) {
            for(long v4 = v2; true; v4 = Math.max(v4, v6)) {
                long v5 = -Buffer.commonIndexOf(realBufferedSource0.bufferField, byteString0, v4, v3, v, v1);
                if(v5 != -1L) {
                    return v5;
                }
                long v6 = realBufferedSource0.bufferField.size() - ((long)v1) + 1L;
                if(v6 >= v3) {
                    return -1L;
                }
                if(!-RealBufferedSource.isMatchPossibleByExpandingBuffer(realBufferedSource0.bufferField, byteString0, v, v1, v4, v3)) {
                    return -1L;
                }
                if(realBufferedSource0.source.read(realBufferedSource0.bufferField, 0x2000L) == -1L) {
                    return -1L;
                }
            }
        }
        throw new IllegalStateException("closed");
    }

    public static long commonIndexOf$default(RealBufferedSource realBufferedSource0, ByteString byteString0, int v, int v1, long v2, long v3, int v4, Object object0) {
        if((v4 & 2) != 0) {
            v = 0;
        }
        if((v4 & 4) != 0) {
            v1 = byteString0.size();
        }
        return (v4 & 16) == 0 ? -RealBufferedSource.commonIndexOf(realBufferedSource0, byteString0, v, v1, v2, v3) : -RealBufferedSource.commonIndexOf(realBufferedSource0, byteString0, v, v1, v2, 0x7FFFFFFFFFFFFFFFL);
    }

    public static final long commonIndexOfElement(@NotNull RealBufferedSource realBufferedSource0, @NotNull ByteString byteString0, long v) {
        q.g(realBufferedSource0, "<this>");
        q.g(byteString0, "targetBytes");
        if(!realBufferedSource0.closed) {
            while(true) {
                long v1 = realBufferedSource0.bufferField.indexOfElement(byteString0, v);
                if(v1 != -1L) {
                    return v1;
                }
                long v2 = realBufferedSource0.bufferField.size();
                if(realBufferedSource0.source.read(realBufferedSource0.bufferField, 0x2000L) == -1L) {
                    return -1L;
                }
                v = Math.max(v, v2);
            }
        }
        throw new IllegalStateException("closed");
    }

    @NotNull
    public static final BufferedSource commonPeek(@NotNull RealBufferedSource realBufferedSource0) {
        q.g(realBufferedSource0, "<this>");
        return Okio.buffer(new PeekSource(realBufferedSource0));
    }

    public static final boolean commonRangeEquals(@NotNull RealBufferedSource realBufferedSource0, long v, @NotNull ByteString byteString0, int v1, int v2) {
        q.g(realBufferedSource0, "<this>");
        q.g(byteString0, "bytes");
        if(realBufferedSource0.closed) {
            throw new IllegalStateException("closed");
        }
        if(v2 < 0) {
            return false;
        }
        if(v < 0L) {
            return false;
        }
        if(v1 >= 0 && v1 + v2 <= byteString0.size()) {
            return v2 == 0 ? true : -RealBufferedSource.commonIndexOf(realBufferedSource0, byteString0, v1, v2, v, v + 1L) != -1L;
        }
        return false;
    }

    public static final int commonRead(@NotNull RealBufferedSource realBufferedSource0, @NotNull byte[] arr_b, int v, int v1) {
        q.g(realBufferedSource0, "<this>");
        q.g(arr_b, "sink");
        -SegmentedByteString.checkOffsetAndCount(arr_b.length, v, v1);
        if(realBufferedSource0.bufferField.size() == 0L) {
            if(v1 == 0) {
                return 0;
            }
            return realBufferedSource0.source.read(realBufferedSource0.bufferField, 0x2000L) == -1L ? -1 : realBufferedSource0.bufferField.read(arr_b, v, ((int)Math.min(v1, realBufferedSource0.bufferField.size())));
        }
        return realBufferedSource0.bufferField.read(arr_b, v, ((int)Math.min(v1, realBufferedSource0.bufferField.size())));
    }

    public static final long commonRead(@NotNull RealBufferedSource realBufferedSource0, @NotNull Buffer buffer0, long v) {
        q.g(realBufferedSource0, "<this>");
        q.g(buffer0, "sink");
        int v1 = Long.compare(v, 0L);
        if(v1 < 0) {
            throw new IllegalArgumentException(e.a(v, "byteCount < 0: ").toString());
        }
        if(realBufferedSource0.closed) {
            throw new IllegalStateException("closed");
        }
        if(realBufferedSource0.bufferField.size() == 0L) {
            if(v1 == 0) {
                return 0L;
            }
            return realBufferedSource0.source.read(realBufferedSource0.bufferField, 0x2000L) == -1L ? -1L : realBufferedSource0.bufferField.read(buffer0, Math.min(v, realBufferedSource0.bufferField.size()));
        }
        return realBufferedSource0.bufferField.read(buffer0, Math.min(v, realBufferedSource0.bufferField.size()));
    }

    public static final long commonReadAll(@NotNull RealBufferedSource realBufferedSource0, @NotNull Sink sink0) {
        q.g(realBufferedSource0, "<this>");
        q.g(sink0, "sink");
        long v = 0L;
        while(realBufferedSource0.source.read(realBufferedSource0.bufferField, 0x2000L) != -1L) {
            long v1 = realBufferedSource0.bufferField.completeSegmentByteCount();
            if(v1 > 0L) {
                v += v1;
                sink0.write(realBufferedSource0.bufferField, v1);
            }
        }
        if(realBufferedSource0.bufferField.size() > 0L) {
            sink0.write(realBufferedSource0.bufferField, realBufferedSource0.bufferField.size());
            return realBufferedSource0.bufferField.size() + v;
        }
        return v;
    }

    public static final byte commonReadByte(@NotNull RealBufferedSource realBufferedSource0) {
        q.g(realBufferedSource0, "<this>");
        realBufferedSource0.require(1L);
        return realBufferedSource0.bufferField.readByte();
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull RealBufferedSource realBufferedSource0) {
        q.g(realBufferedSource0, "<this>");
        realBufferedSource0.bufferField.writeAll(realBufferedSource0.source);
        return new byte[0];
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull RealBufferedSource realBufferedSource0, long v) {
        q.g(realBufferedSource0, "<this>");
        realBufferedSource0.require(v);
        return realBufferedSource0.bufferField.readByteArray(v);
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull RealBufferedSource realBufferedSource0) {
        q.g(realBufferedSource0, "<this>");
        realBufferedSource0.bufferField.writeAll(realBufferedSource0.source);
        return realBufferedSource0.bufferField.readByteString();
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull RealBufferedSource realBufferedSource0, long v) {
        q.g(realBufferedSource0, "<this>");
        realBufferedSource0.require(v);
        return realBufferedSource0.bufferField.readByteString(v);
    }

    public static final long commonReadDecimalLong(@NotNull RealBufferedSource realBufferedSource0) {
        q.g(realBufferedSource0, "<this>");
        realBufferedSource0.require(1L);
        for(long v = 0L; realBufferedSource0.request(v + 1L); ++v) {
            int v1 = realBufferedSource0.bufferField.getByte(v);
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
        return realBufferedSource0.bufferField.readDecimalLong();
    }

    public static final void commonReadFully(@NotNull RealBufferedSource realBufferedSource0, @NotNull Buffer buffer0, long v) {
        q.g(realBufferedSource0, "<this>");
        q.g(buffer0, "sink");
        try {
            realBufferedSource0.require(v);
        }
        catch(EOFException eOFException0) {
            buffer0.writeAll(realBufferedSource0.bufferField);
            throw eOFException0;
        }
        realBufferedSource0.bufferField.readFully(buffer0, v);
    }

    public static final void commonReadFully(@NotNull RealBufferedSource realBufferedSource0, @NotNull byte[] arr_b) {
        q.g(realBufferedSource0, "<this>");
        q.g(arr_b, "sink");
        try {
            realBufferedSource0.require(((long)arr_b.length));
        }
        catch(EOFException eOFException0) {
            for(int v = 0; realBufferedSource0.bufferField.size() > 0L; v += v1) {
                int v1 = realBufferedSource0.bufferField.read(arr_b, v, ((int)realBufferedSource0.bufferField.size()));
                if(v1 == -1) {
                    throw new AssertionError();
                }
            }
            throw eOFException0;
        }
        realBufferedSource0.bufferField.readFully(arr_b);
    }

    public static final long commonReadHexadecimalUnsignedLong(@NotNull RealBufferedSource realBufferedSource0) {
        q.g(realBufferedSource0, "<this>");
        realBufferedSource0.require(1L);
        int v = 0;
        while(realBufferedSource0.request(((long)(v + 1)))) {
            int v1 = realBufferedSource0.bufferField.getByte(((long)v));
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
        return realBufferedSource0.bufferField.readHexadecimalUnsignedLong();
    }

    public static final int commonReadInt(@NotNull RealBufferedSource realBufferedSource0) {
        q.g(realBufferedSource0, "<this>");
        realBufferedSource0.require(4L);
        return realBufferedSource0.bufferField.readInt();
    }

    public static final int commonReadIntLe(@NotNull RealBufferedSource realBufferedSource0) {
        q.g(realBufferedSource0, "<this>");
        realBufferedSource0.require(4L);
        return realBufferedSource0.bufferField.readIntLe();
    }

    public static final long commonReadLong(@NotNull RealBufferedSource realBufferedSource0) {
        q.g(realBufferedSource0, "<this>");
        realBufferedSource0.require(8L);
        return realBufferedSource0.bufferField.readLong();
    }

    public static final long commonReadLongLe(@NotNull RealBufferedSource realBufferedSource0) {
        q.g(realBufferedSource0, "<this>");
        realBufferedSource0.require(8L);
        return realBufferedSource0.bufferField.readLongLe();
    }

    public static final short commonReadShort(@NotNull RealBufferedSource realBufferedSource0) {
        q.g(realBufferedSource0, "<this>");
        realBufferedSource0.require(2L);
        return realBufferedSource0.bufferField.readShort();
    }

    public static final short commonReadShortLe(@NotNull RealBufferedSource realBufferedSource0) {
        q.g(realBufferedSource0, "<this>");
        realBufferedSource0.require(2L);
        return realBufferedSource0.bufferField.readShortLe();
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull RealBufferedSource realBufferedSource0) {
        q.g(realBufferedSource0, "<this>");
        realBufferedSource0.bufferField.writeAll(realBufferedSource0.source);
        return "";
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull RealBufferedSource realBufferedSource0, long v) {
        q.g(realBufferedSource0, "<this>");
        realBufferedSource0.require(v);
        return realBufferedSource0.bufferField.readUtf8(v);
    }

    public static final int commonReadUtf8CodePoint(@NotNull RealBufferedSource realBufferedSource0) {
        q.g(realBufferedSource0, "<this>");
        realBufferedSource0.require(1L);
        int v = realBufferedSource0.bufferField.getByte(0L);
        if((v & 0xE0) == 0xC0) {
            realBufferedSource0.require(2L);
            return realBufferedSource0.bufferField.readUtf8CodePoint();
        }
        if((v & 0xF0) == 0xE0) {
            realBufferedSource0.require(3L);
            return realBufferedSource0.bufferField.readUtf8CodePoint();
        }
        if((v & 0xF8) == 0xF0) {
            realBufferedSource0.require(4L);
        }
        return realBufferedSource0.bufferField.readUtf8CodePoint();
    }

    @Nullable
    public static final String commonReadUtf8Line(@NotNull RealBufferedSource realBufferedSource0) {
        q.g(realBufferedSource0, "<this>");
        long v = realBufferedSource0.indexOf(10);
        if(v == -1L) {
            return realBufferedSource0.bufferField.size() == 0L ? null : realBufferedSource0.readUtf8(realBufferedSource0.bufferField.size());
        }
        return -Buffer.readUtf8Line(realBufferedSource0.bufferField, v);
    }

    @NotNull
    public static final String commonReadUtf8LineStrict(@NotNull RealBufferedSource realBufferedSource0, long v) {
        q.g(realBufferedSource0, "<this>");
        if(v < 0L) {
            throw new IllegalArgumentException(e.a(v, "limit < 0: ").toString());
        }
        long v1 = Long.compare(v, 0x7FFFFFFFFFFFFFFFL) == 0 ? 0x7FFFFFFFFFFFFFFFL : v + 1L;
        long v2 = realBufferedSource0.indexOf(10, 0L, v1);
        if(v2 != -1L) {
            return -Buffer.readUtf8Line(realBufferedSource0.bufferField, v2);
        }
        if(v1 < 0x7FFFFFFFFFFFFFFFL && realBufferedSource0.request(v1) && realBufferedSource0.bufferField.getByte(v1 - 1L) == 13 && realBufferedSource0.request(v1 + 1L) && realBufferedSource0.bufferField.getByte(v1) == 10) {
            return -Buffer.readUtf8Line(realBufferedSource0.bufferField, v1);
        }
        Buffer buffer0 = new Buffer();
        realBufferedSource0.bufferField.copyTo(buffer0, 0L, Math.min(0x20L, realBufferedSource0.bufferField.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(realBufferedSource0.bufferField.size(), v) + " content=" + buffer0.readByteString().hex() + '…');
    }

    public static final boolean commonRequest(@NotNull RealBufferedSource realBufferedSource0, long v) {
        q.g(realBufferedSource0, "<this>");
        if(v < 0L) {
            throw new IllegalArgumentException(e.a(v, "byteCount < 0: ").toString());
        }
        if(realBufferedSource0.closed) {
            throw new IllegalStateException("closed");
        }
        while(realBufferedSource0.bufferField.size() < v) {
            if(realBufferedSource0.source.read(realBufferedSource0.bufferField, 0x2000L) == -1L) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return true;
    }

    public static final void commonRequire(@NotNull RealBufferedSource realBufferedSource0, long v) {
        q.g(realBufferedSource0, "<this>");
        if(!realBufferedSource0.request(v)) {
            throw new EOFException();
        }
    }

    public static final int commonSelect(@NotNull RealBufferedSource realBufferedSource0, @NotNull Options options0) {
        q.g(realBufferedSource0, "<this>");
        q.g(options0, "options");
        if(realBufferedSource0.closed) {
            throw new IllegalStateException("closed");
        }
    alab1:
        while(true) {
            int v = -Buffer.selectPrefix(realBufferedSource0.bufferField, options0, true);
            switch(v) {
                case -2: {
                    if(realBufferedSource0.source.read(realBufferedSource0.bufferField, 0x2000L) != -1L) {
                        break;
                    }
                    break alab1;
                }
                case -1: {
                    return -1;
                }
                default: {
                    realBufferedSource0.bufferField.skip(((long)options0.getByteStrings$okio()[v].size()));
                    return v;
                }
            }
        }
        return -1;
    }

    public static final void commonSkip(@NotNull RealBufferedSource realBufferedSource0, long v) {
        q.g(realBufferedSource0, "<this>");
        if(realBufferedSource0.closed) {
            throw new IllegalStateException("closed");
        }
        while(v > 0L) {
            if(realBufferedSource0.bufferField.size() == 0L && realBufferedSource0.source.read(realBufferedSource0.bufferField, 0x2000L) == -1L) {
                throw new EOFException();
            }
            long v1 = Math.min(v, realBufferedSource0.bufferField.size());
            realBufferedSource0.bufferField.skip(v1);
            v -= v1;
        }
    }

    @NotNull
    public static final Timeout commonTimeout(@NotNull RealBufferedSource realBufferedSource0) {
        q.g(realBufferedSource0, "<this>");
        return realBufferedSource0.source.timeout();
    }

    @NotNull
    public static final String commonToString(@NotNull RealBufferedSource realBufferedSource0) {
        q.g(realBufferedSource0, "<this>");
        return "buffer(" + realBufferedSource0.source + ')';
    }

    private static final boolean isMatchPossibleByExpandingBuffer(Buffer buffer0, ByteString byteString0, int v, int v1, long v2, long v3) {
        if(Long.compare(buffer0.size(), v3) < 0) {
            return true;
        }
        int v4 = (int)Math.max(1L, buffer0.size() - v3 + 1L);
        int v5 = ((int)Math.min(v1, buffer0.size() - v2 + 1L)) - 1;
        if(v4 <= v5) {
            for(int v6 = v5; true; --v6) {
                if(buffer0.rangeEquals(buffer0.size() - ((long)v6), byteString0, v, v6)) {
                    return true;
                }
                if(v6 == v4) {
                    break;
                }
            }
        }
        return false;
    }
}

