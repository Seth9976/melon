package okio;

import ie.d;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u00012\u00020\u0002J\u000F\u0010\u0004\u001A\u00020\u0003H\'\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001A\u00020\u00002\u0006\u0010\u0007\u001A\u00020\u0006H&\u00A2\u0006\u0004\b\b\u0010\tJ\'\u0010\b\u001A\u00020\u00002\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH&\u00A2\u0006\u0004\b\b\u0010\rJ\u0017\u0010\b\u001A\u00020\u00002\u0006\u0010\u000F\u001A\u00020\u000EH&\u00A2\u0006\u0004\b\b\u0010\u0010J\'\u0010\b\u001A\u00020\u00002\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH&\u00A2\u0006\u0004\b\b\u0010\u0011J\u0017\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u000F\u001A\u00020\u0012H&\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u001F\u0010\b\u001A\u00020\u00002\u0006\u0010\u000F\u001A\u00020\u00122\u0006\u0010\f\u001A\u00020\u0013H&\u00A2\u0006\u0004\b\b\u0010\u0016J\u0017\u0010\u0019\u001A\u00020\u00002\u0006\u0010\u0018\u001A\u00020\u0017H&\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\'\u0010\u0019\u001A\u00020\u00002\u0006\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u001B\u001A\u00020\n2\u0006\u0010\u001C\u001A\u00020\nH&\u00A2\u0006\u0004\b\u0019\u0010\u001DJ\u0017\u0010\u001F\u001A\u00020\u00002\u0006\u0010\u001E\u001A\u00020\nH&\u00A2\u0006\u0004\b\u001F\u0010 J\u001F\u0010#\u001A\u00020\u00002\u0006\u0010\u0018\u001A\u00020\u00172\u0006\u0010\"\u001A\u00020!H&\u00A2\u0006\u0004\b#\u0010$J/\u0010#\u001A\u00020\u00002\u0006\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u001B\u001A\u00020\n2\u0006\u0010\u001C\u001A\u00020\n2\u0006\u0010\"\u001A\u00020!H&\u00A2\u0006\u0004\b#\u0010%J\u0017\u0010\'\u001A\u00020\u00002\u0006\u0010&\u001A\u00020\nH&\u00A2\u0006\u0004\b\'\u0010 J\u0017\u0010)\u001A\u00020\u00002\u0006\u0010(\u001A\u00020\nH&\u00A2\u0006\u0004\b)\u0010 J\u0017\u0010*\u001A\u00020\u00002\u0006\u0010(\u001A\u00020\nH&\u00A2\u0006\u0004\b*\u0010 J\u0017\u0010,\u001A\u00020\u00002\u0006\u0010+\u001A\u00020\nH&\u00A2\u0006\u0004\b,\u0010 J\u0017\u0010-\u001A\u00020\u00002\u0006\u0010+\u001A\u00020\nH&\u00A2\u0006\u0004\b-\u0010 J\u0017\u0010/\u001A\u00020\u00002\u0006\u0010.\u001A\u00020\u0013H&\u00A2\u0006\u0004\b/\u00100J\u0017\u00101\u001A\u00020\u00002\u0006\u0010.\u001A\u00020\u0013H&\u00A2\u0006\u0004\b1\u00100J\u0017\u00102\u001A\u00020\u00002\u0006\u0010.\u001A\u00020\u0013H&\u00A2\u0006\u0004\b2\u00100J\u0017\u00103\u001A\u00020\u00002\u0006\u0010.\u001A\u00020\u0013H&\u00A2\u0006\u0004\b3\u00100J\u000F\u00105\u001A\u000204H&\u00A2\u0006\u0004\b5\u00106J\u000F\u00107\u001A\u00020\u0000H&\u00A2\u0006\u0004\b7\u00108J\u000F\u00109\u001A\u00020\u0000H&\u00A2\u0006\u0004\b9\u00108J\u000F\u0010;\u001A\u00020:H&\u00A2\u0006\u0004\b;\u0010<R\u0014\u0010\u0004\u001A\u00020\u00038&X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b=\u0010\u0005\u0082\u0001\u0002\u0003>\u00F8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00A8\u0006?\u00C0\u0006\u0001"}, d2 = {"Lokio/BufferedSink;", "Lokio/Sink;", "Ljava/nio/channels/WritableByteChannel;", "Lokio/Buffer;", "buffer", "()Lokio/Buffer;", "Lokio/ByteString;", "byteString", "write", "(Lokio/ByteString;)Lokio/BufferedSink;", "", "offset", "byteCount", "(Lokio/ByteString;II)Lokio/BufferedSink;", "", "source", "([B)Lokio/BufferedSink;", "([BII)Lokio/BufferedSink;", "Lokio/Source;", "", "writeAll", "(Lokio/Source;)J", "(Lokio/Source;J)Lokio/BufferedSink;", "", "string", "writeUtf8", "(Ljava/lang/String;)Lokio/BufferedSink;", "beginIndex", "endIndex", "(Ljava/lang/String;II)Lokio/BufferedSink;", "codePoint", "writeUtf8CodePoint", "(I)Lokio/BufferedSink;", "Ljava/nio/charset/Charset;", "charset", "writeString", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Lokio/BufferedSink;", "(Ljava/lang/String;IILjava/nio/charset/Charset;)Lokio/BufferedSink;", "b", "writeByte", "s", "writeShort", "writeShortLe", "i", "writeInt", "writeIntLe", "v", "writeLong", "(J)Lokio/BufferedSink;", "writeLongLe", "writeDecimalLong", "writeHexadecimalUnsignedLong", "Lie/H;", "flush", "()V", "emit", "()Lokio/BufferedSink;", "emitCompleteSegments", "Ljava/io/OutputStream;", "outputStream", "()Ljava/io/OutputStream;", "getBuffer", "Lokio/RealBufferedSink;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public interface BufferedSink extends WritableByteChannel, Sink {
    @d
    @NotNull
    Buffer buffer();

    @NotNull
    BufferedSink emit();

    @NotNull
    BufferedSink emitCompleteSegments();

    @Override  // okio.Sink
    void flush();

    @NotNull
    Buffer getBuffer();

    @NotNull
    OutputStream outputStream();

    @NotNull
    BufferedSink write(@NotNull ByteString arg1);

    @NotNull
    BufferedSink write(@NotNull ByteString arg1, int arg2, int arg3);

    @NotNull
    BufferedSink write(@NotNull Source arg1, long arg2);

    @NotNull
    BufferedSink write(@NotNull byte[] arg1);

    @NotNull
    BufferedSink write(@NotNull byte[] arg1, int arg2, int arg3);

    long writeAll(@NotNull Source arg1);

    @NotNull
    BufferedSink writeByte(int arg1);

    @NotNull
    BufferedSink writeDecimalLong(long arg1);

    @NotNull
    BufferedSink writeHexadecimalUnsignedLong(long arg1);

    @NotNull
    BufferedSink writeInt(int arg1);

    @NotNull
    BufferedSink writeIntLe(int arg1);

    @NotNull
    BufferedSink writeLong(long arg1);

    @NotNull
    BufferedSink writeLongLe(long arg1);

    @NotNull
    BufferedSink writeShort(int arg1);

    @NotNull
    BufferedSink writeShortLe(int arg1);

    @NotNull
    BufferedSink writeString(@NotNull String arg1, int arg2, int arg3, @NotNull Charset arg4);

    @NotNull
    BufferedSink writeString(@NotNull String arg1, @NotNull Charset arg2);

    @NotNull
    BufferedSink writeUtf8(@NotNull String arg1);

    @NotNull
    BufferedSink writeUtf8(@NotNull String arg1, int arg2, int arg3);

    @NotNull
    BufferedSink writeUtf8CodePoint(int arg1);
}

