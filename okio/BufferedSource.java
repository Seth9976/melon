package okio;

import ie.d;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008C\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u00012\u00020\u0002J\u000F\u0010\u0004\u001A\u00020\u0003H\'\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H&\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\tH&\u00A2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000E\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\tH&\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0011\u001A\u00020\u0010H&\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0014\u001A\u00020\u0013H&\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0016\u001A\u00020\u0013H&\u00A2\u0006\u0004\b\u0016\u0010\u0015J\u000F\u0010\u0018\u001A\u00020\u0017H&\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u00020\u0017H&\u00A2\u0006\u0004\b\u001A\u0010\u0019J\u000F\u0010\u001B\u001A\u00020\tH&\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001D\u001A\u00020\tH&\u00A2\u0006\u0004\b\u001D\u0010\u001CJ\u000F\u0010\u001E\u001A\u00020\tH&\u00A2\u0006\u0004\b\u001E\u0010\u001CJ\u000F\u0010\u001F\u001A\u00020\tH&\u00A2\u0006\u0004\b\u001F\u0010\u001CJ\u0017\u0010 \u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\tH&\u00A2\u0006\u0004\b \u0010\rJ\u000F\u0010\"\u001A\u00020!H&\u00A2\u0006\u0004\b\"\u0010#J\u0017\u0010\"\u001A\u00020!2\u0006\u0010\n\u001A\u00020\tH&\u00A2\u0006\u0004\b\"\u0010$J\u0017\u0010\'\u001A\u00020\u00172\u0006\u0010&\u001A\u00020%H&\u00A2\u0006\u0004\b\'\u0010(J)\u0010\'\u001A\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010**\u00020)2\f\u0010&\u001A\b\u0012\u0004\u0012\u00028\u00000+H&\u00A2\u0006\u0004\b\'\u0010,J\u000F\u0010.\u001A\u00020-H&\u00A2\u0006\u0004\b.\u0010/J\u0017\u0010.\u001A\u00020-2\u0006\u0010\n\u001A\u00020\tH&\u00A2\u0006\u0004\b.\u00100J\u0017\u00102\u001A\u00020\u00172\u0006\u00101\u001A\u00020-H&\u00A2\u0006\u0004\b2\u00103J\u0017\u00104\u001A\u00020\u000B2\u0006\u00101\u001A\u00020-H&\u00A2\u0006\u0004\b4\u00105J\'\u00102\u001A\u00020\u00172\u0006\u00101\u001A\u00020-2\u0006\u00106\u001A\u00020\u00172\u0006\u0010\n\u001A\u00020\u0017H&\u00A2\u0006\u0004\b2\u00107J\u001F\u00104\u001A\u00020\u000B2\u0006\u00101\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\tH&\u00A2\u0006\u0004\b4\u00108J\u0017\u0010:\u001A\u00020\t2\u0006\u00101\u001A\u000209H&\u00A2\u0006\u0004\b:\u0010;J\u000F\u0010=\u001A\u00020<H&\u00A2\u0006\u0004\b=\u0010>J\u0017\u0010=\u001A\u00020<2\u0006\u0010\n\u001A\u00020\tH&\u00A2\u0006\u0004\b=\u0010?J\u0011\u0010@\u001A\u0004\u0018\u00010<H&\u00A2\u0006\u0004\b@\u0010>J\u000F\u0010A\u001A\u00020<H&\u00A2\u0006\u0004\bA\u0010>J\u0017\u0010A\u001A\u00020<2\u0006\u0010B\u001A\u00020\tH&\u00A2\u0006\u0004\bA\u0010?J\u000F\u0010C\u001A\u00020\u0017H&\u00A2\u0006\u0004\bC\u0010\u0019J\u0017\u0010F\u001A\u00020<2\u0006\u0010E\u001A\u00020DH&\u00A2\u0006\u0004\bF\u0010GJ\u001F\u0010F\u001A\u00020<2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010E\u001A\u00020DH&\u00A2\u0006\u0004\bF\u0010HJ\u0017\u0010J\u001A\u00020\t2\u0006\u0010I\u001A\u00020\u0010H&\u00A2\u0006\u0004\bJ\u0010KJ\u001F\u0010J\u001A\u00020\t2\u0006\u0010I\u001A\u00020\u00102\u0006\u0010L\u001A\u00020\tH&\u00A2\u0006\u0004\bJ\u0010MJ\'\u0010J\u001A\u00020\t2\u0006\u0010I\u001A\u00020\u00102\u0006\u0010L\u001A\u00020\t2\u0006\u0010N\u001A\u00020\tH&\u00A2\u0006\u0004\bJ\u0010OJ\u0017\u0010J\u001A\u00020\t2\u0006\u0010P\u001A\u00020!H&\u00A2\u0006\u0004\bJ\u0010QJ\u001F\u0010J\u001A\u00020\t2\u0006\u0010P\u001A\u00020!2\u0006\u0010L\u001A\u00020\tH&\u00A2\u0006\u0004\bJ\u0010RJ\'\u0010J\u001A\u00020\t2\u0006\u0010P\u001A\u00020!2\u0006\u0010L\u001A\u00020\t2\u0006\u0010N\u001A\u00020\tH&\u00A2\u0006\u0004\bJ\u0010SJ\u0017\u0010U\u001A\u00020\t2\u0006\u0010T\u001A\u00020!H&\u00A2\u0006\u0004\bU\u0010QJ\u001F\u0010U\u001A\u00020\t2\u0006\u0010T\u001A\u00020!2\u0006\u0010L\u001A\u00020\tH&\u00A2\u0006\u0004\bU\u0010RJ\u001F\u0010V\u001A\u00020\u00062\u0006\u00106\u001A\u00020\t2\u0006\u0010P\u001A\u00020!H&\u00A2\u0006\u0004\bV\u0010WJ/\u0010V\u001A\u00020\u00062\u0006\u00106\u001A\u00020\t2\u0006\u0010P\u001A\u00020!2\u0006\u0010X\u001A\u00020\u00172\u0006\u0010\n\u001A\u00020\u0017H&\u00A2\u0006\u0004\bV\u0010YJ\u000F\u0010Z\u001A\u00020\u0000H&\u00A2\u0006\u0004\bZ\u0010[J\u000F\u0010]\u001A\u00020\\H&\u00A2\u0006\u0004\b]\u0010^R\u0014\u0010\u0004\u001A\u00020\u00038&X\u00A6\u0004\u00A2\u0006\u0006\u001A\u0004\b_\u0010\u0005\u0082\u0001\u0002\u0003`\u00F8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00A8\u0006a\u00C0\u0006\u0001"}, d2 = {"Lokio/BufferedSource;", "Lokio/Source;", "Ljava/nio/channels/ReadableByteChannel;", "Lokio/Buffer;", "buffer", "()Lokio/Buffer;", "", "exhausted", "()Z", "", "byteCount", "Lie/H;", "require", "(J)V", "request", "(J)Z", "", "readByte", "()B", "", "readShort", "()S", "readShortLe", "", "readInt", "()I", "readIntLe", "readLong", "()J", "readLongLe", "readDecimalLong", "readHexadecimalUnsignedLong", "skip", "Lokio/ByteString;", "readByteString", "()Lokio/ByteString;", "(J)Lokio/ByteString;", "Lokio/Options;", "options", "select", "(Lokio/Options;)I", "", "T", "Lokio/TypedOptions;", "(Lokio/TypedOptions;)Ljava/lang/Object;", "", "readByteArray", "()[B", "(J)[B", "sink", "read", "([B)I", "readFully", "([B)V", "offset", "([BII)I", "(Lokio/Buffer;J)V", "Lokio/Sink;", "readAll", "(Lokio/Sink;)J", "", "readUtf8", "()Ljava/lang/String;", "(J)Ljava/lang/String;", "readUtf8Line", "readUtf8LineStrict", "limit", "readUtf8CodePoint", "Ljava/nio/charset/Charset;", "charset", "readString", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "(JLjava/nio/charset/Charset;)Ljava/lang/String;", "b", "indexOf", "(B)J", "fromIndex", "(BJ)J", "toIndex", "(BJJ)J", "bytes", "(Lokio/ByteString;)J", "(Lokio/ByteString;J)J", "(Lokio/ByteString;JJ)J", "targetBytes", "indexOfElement", "rangeEquals", "(JLokio/ByteString;)Z", "bytesOffset", "(JLokio/ByteString;II)Z", "peek", "()Lokio/BufferedSource;", "Ljava/io/InputStream;", "inputStream", "()Ljava/io/InputStream;", "getBuffer", "Lokio/RealBufferedSource;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public interface BufferedSource extends ReadableByteChannel, Source {
    @d
    @NotNull
    Buffer buffer();

    boolean exhausted();

    @NotNull
    Buffer getBuffer();

    long indexOf(byte arg1);

    long indexOf(byte arg1, long arg2);

    long indexOf(byte arg1, long arg2, long arg3);

    long indexOf(@NotNull ByteString arg1);

    long indexOf(@NotNull ByteString arg1, long arg2);

    long indexOf(@NotNull ByteString arg1, long arg2, long arg3);

    long indexOfElement(@NotNull ByteString arg1);

    long indexOfElement(@NotNull ByteString arg1, long arg2);

    @NotNull
    InputStream inputStream();

    @NotNull
    BufferedSource peek();

    boolean rangeEquals(long arg1, @NotNull ByteString arg2);

    boolean rangeEquals(long arg1, @NotNull ByteString arg2, int arg3, int arg4);

    int read(@NotNull byte[] arg1);

    int read(@NotNull byte[] arg1, int arg2, int arg3);

    long readAll(@NotNull Sink arg1);

    byte readByte();

    @NotNull
    byte[] readByteArray();

    @NotNull
    byte[] readByteArray(long arg1);

    @NotNull
    ByteString readByteString();

    @NotNull
    ByteString readByteString(long arg1);

    long readDecimalLong();

    void readFully(@NotNull Buffer arg1, long arg2);

    void readFully(@NotNull byte[] arg1);

    long readHexadecimalUnsignedLong();

    int readInt();

    int readIntLe();

    long readLong();

    long readLongLe();

    short readShort();

    short readShortLe();

    @NotNull
    String readString(long arg1, @NotNull Charset arg2);

    @NotNull
    String readString(@NotNull Charset arg1);

    @NotNull
    String readUtf8();

    @NotNull
    String readUtf8(long arg1);

    int readUtf8CodePoint();

    @Nullable
    String readUtf8Line();

    @NotNull
    String readUtf8LineStrict();

    @NotNull
    String readUtf8LineStrict(long arg1);

    boolean request(long arg1);

    void require(long arg1);

    int select(@NotNull Options arg1);

    @Nullable
    Object select(@NotNull TypedOptions arg1);

    void skip(long arg1);
}

