package okhttp3;

import Tf.a;
import ie.H;
import ie.d;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e;
import we.k;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 +2\u00020\u0001:\u0002,+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u000B\u001A\u00028\u0000\"\b\b\u0000\u0010\u0005*\u00020\u00042\u0012\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u00062\u0012\u0010\n\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\u0006H\u0082\b¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\u000E\u001A\u00020\rH\u0002¢\u0006\u0004\b\u000E\u0010\u000FJ\u0011\u0010\u0011\u001A\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0014\u001A\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001A\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000F\u0010\u0019\u001A\u00020\u0007H&¢\u0006\u0004\b\u0019\u0010\u001AJ\r\u0010\u001C\u001A\u00020\u001B¢\u0006\u0004\b\u001C\u0010\u001DJ\r\u0010\u001F\u001A\u00020\u001E¢\u0006\u0004\b\u001F\u0010 J\r\u0010\"\u001A\u00020!¢\u0006\u0004\b\"\u0010#J\r\u0010%\u001A\u00020$¢\u0006\u0004\b%\u0010&J\u000F\u0010(\u001A\u00020\'H\u0016¢\u0006\u0004\b(\u0010\u0003R\u0018\u0010)\u001A\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lokhttp3/ResponseBody;", "Ljava/io/Closeable;", "<init>", "()V", "", "T", "Lkotlin/Function1;", "Lokio/BufferedSource;", "consumer", "", "sizeMapper", "consumeSource", "(Lwe/k;Lwe/k;)Ljava/lang/Object;", "Ljava/nio/charset/Charset;", "charset", "()Ljava/nio/charset/Charset;", "Lokhttp3/MediaType;", "contentType", "()Lokhttp3/MediaType;", "", "contentLength", "()J", "Ljava/io/InputStream;", "byteStream", "()Ljava/io/InputStream;", "source", "()Lokio/BufferedSource;", "", "bytes", "()[B", "Lokio/ByteString;", "byteString", "()Lokio/ByteString;", "Ljava/io/Reader;", "charStream", "()Ljava/io/Reader;", "", "string", "()Ljava/lang/String;", "Lie/H;", "close", "reader", "Ljava/io/Reader;", "Companion", "BomAwareReader", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public abstract class ResponseBody implements Closeable {
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\'\u0010\r\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0016\u0010\u0015\u001A\u00020\u00148\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001A\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lokhttp3/ResponseBody$BomAwareReader;", "Ljava/io/Reader;", "Lokio/BufferedSource;", "source", "Ljava/nio/charset/Charset;", "charset", "<init>", "(Lokio/BufferedSource;Ljava/nio/charset/Charset;)V", "", "cbuf", "", "off", "len", "read", "([CII)I", "Lie/H;", "close", "()V", "Lokio/BufferedSource;", "Ljava/nio/charset/Charset;", "", "closed", "Z", "delegate", "Ljava/io/Reader;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class BomAwareReader extends Reader {
        @NotNull
        private final Charset charset;
        private boolean closed;
        @Nullable
        private Reader delegate;
        @NotNull
        private final BufferedSource source;

        public BomAwareReader(@NotNull BufferedSource bufferedSource0, @NotNull Charset charset0) {
            q.g(bufferedSource0, "source");
            q.g(charset0, "charset");
            super();
            this.source = bufferedSource0;
            this.charset = charset0;
        }

        @Override
        public void close() {
            H h0;
            this.closed = true;
            Reader reader0 = this.delegate;
            if(reader0 == null) {
                h0 = null;
            }
            else {
                reader0.close();
                h0 = H.a;
            }
            if(h0 == null) {
                this.source.close();
            }
        }

        @Override
        public int read(@NotNull char[] arr_c, int v, int v1) {
            q.g(arr_c, "cbuf");
            if(this.closed) {
                throw new IOException("Stream closed");
            }
            Reader reader0 = this.delegate;
            if(reader0 == null) {
                reader0 = new InputStreamReader(this.source.inputStream(), Util.readBomAsCharset(this.source, this.charset));
                this.delegate = reader0;
            }
            return reader0.read(arr_c, v, v1);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001A\u0010\u0003\u001A\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001A\u00020\bH\u0007J\"\u0010\u0003\u001A\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u00062\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u0007\u001A\u00020\u000BH\u0007J\u001A\u0010\u0003\u001A\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001A\u00020\fH\u0007J\u001A\u0010\u0003\u001A\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001A\u00020\rH\u0007J\'\u0010\u000E\u001A\u00020\u0004*\u00020\u000B2\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001A\u00020\nH\u0007¢\u0006\u0002\b\u0003J\u001D\u0010\u000F\u001A\u00020\u0004*\u00020\b2\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b\u0003J\u001D\u0010\u000F\u001A\u00020\u0004*\u00020\f2\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b\u0003J\u001D\u0010\u000F\u001A\u00020\u0004*\u00020\r2\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\b\u0003¨\u0006\u0010"}, d2 = {"Lokhttp3/ResponseBody$Companion;", "", "()V", "create", "Lokhttp3/ResponseBody;", "contentType", "Lokhttp3/MediaType;", "content", "", "contentLength", "", "Lokio/BufferedSource;", "", "Lokio/ByteString;", "asResponseBody", "toResponseBody", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ResponseBody create(@NotNull String s, @Nullable MediaType mediaType0) {
            q.g(s, "<this>");
            Charset charset0 = a.a;
            if(mediaType0 != null) {
                Charset charset1 = MediaType.charset$default(mediaType0, null, 1, null);
                if(charset1 == null) {
                    mediaType0 = MediaType.Companion.parse(mediaType0 + "; charset=utf-8");
                }
                else {
                    charset0 = charset1;
                }
            }
            Buffer buffer0 = new Buffer().writeString(s, charset0);
            return this.create(buffer0, mediaType0, buffer0.size());
        }

        @d
        @NotNull
        public final ResponseBody create(@Nullable MediaType mediaType0, long v, @NotNull BufferedSource bufferedSource0) {
            q.g(bufferedSource0, "content");
            return this.create(bufferedSource0, mediaType0, v);
        }

        @d
        @NotNull
        public final ResponseBody create(@Nullable MediaType mediaType0, @NotNull String s) {
            q.g(s, "content");
            return this.create(s, mediaType0);
        }

        @d
        @NotNull
        public final ResponseBody create(@Nullable MediaType mediaType0, @NotNull ByteString byteString0) {
            q.g(byteString0, "content");
            return this.create(byteString0, mediaType0);
        }

        @d
        @NotNull
        public final ResponseBody create(@Nullable MediaType mediaType0, @NotNull byte[] arr_b) {
            q.g(arr_b, "content");
            return this.create(arr_b, mediaType0);
        }

        @NotNull
        public final ResponseBody create(@NotNull BufferedSource bufferedSource0, @Nullable MediaType mediaType0, long v) {
            q.g(bufferedSource0, "<this>");
            return new ResponseBody() {
                @Override  // okhttp3.ResponseBody
                public long contentLength() {
                    return bufferedSource0;
                }

                @Override  // okhttp3.ResponseBody
                @Nullable
                public MediaType contentType() {
                    return v;
                }

                @Override  // okhttp3.ResponseBody
                @NotNull
                public BufferedSource source() {
                    return this.$this_asResponseBody;
                }
            };
        }

        @NotNull
        public final ResponseBody create(@NotNull ByteString byteString0, @Nullable MediaType mediaType0) {
            q.g(byteString0, "<this>");
            return this.create(new Buffer().write(byteString0), mediaType0, ((long)byteString0.size()));
        }

        @NotNull
        public final ResponseBody create(@NotNull byte[] arr_b, @Nullable MediaType mediaType0) {
            q.g(arr_b, "<this>");
            return this.create(new Buffer().write(arr_b), mediaType0, ((long)arr_b.length));
        }

        public static ResponseBody create$default(Companion responseBody$Companion0, String s, MediaType mediaType0, int v, Object object0) {
            if((v & 1) != 0) {
                mediaType0 = null;
            }
            return responseBody$Companion0.create(s, mediaType0);
        }

        public static ResponseBody create$default(Companion responseBody$Companion0, BufferedSource bufferedSource0, MediaType mediaType0, long v, int v1, Object object0) {
            if((v1 & 1) != 0) {
                mediaType0 = null;
            }
            if((v1 & 2) != 0) {
                v = -1L;
            }
            return responseBody$Companion0.create(bufferedSource0, mediaType0, v);
        }

        public static ResponseBody create$default(Companion responseBody$Companion0, ByteString byteString0, MediaType mediaType0, int v, Object object0) {
            if((v & 1) != 0) {
                mediaType0 = null;
            }
            return responseBody$Companion0.create(byteString0, mediaType0);
        }

        public static ResponseBody create$default(Companion responseBody$Companion0, byte[] arr_b, MediaType mediaType0, int v, Object object0) {
            if((v & 1) != 0) {
                mediaType0 = null;
            }
            return responseBody$Companion0.create(arr_b, mediaType0);
        }
    }

    @NotNull
    public static final Companion Companion;
    @Nullable
    private Reader reader;

    static {
        ResponseBody.Companion = new Companion(null);
    }

    @NotNull
    public final InputStream byteStream() {
        return this.source().inputStream();
    }

    @NotNull
    public final ByteString byteString() {
        ByteString byteString0;
        long v = this.contentLength();
        if(v > 0x7FFFFFFFL) {
            throw new IOException(e.a(v, "Cannot buffer entire body for content length: "));
        }
        BufferedSource bufferedSource0 = this.source();
        try {
            byteString0 = bufferedSource0.readByteString();
        }
        catch(Throwable throwable0) {
            d8.d.l(bufferedSource0, throwable0);
            throw throwable0;
        }
        d8.d.l(bufferedSource0, null);
        int v1 = byteString0.size();
        if(v != -1L && v != ((long)v1)) {
            throw new IOException("Content-Length (" + v + ") and stream length (" + v1 + ") disagree");
        }
        return byteString0;
    }

    @NotNull
    public final byte[] bytes() {
        byte[] arr_b;
        long v = this.contentLength();
        if(v > 0x7FFFFFFFL) {
            throw new IOException(e.a(v, "Cannot buffer entire body for content length: "));
        }
        BufferedSource bufferedSource0 = this.source();
        try {
            arr_b = bufferedSource0.readByteArray();
        }
        catch(Throwable throwable0) {
            d8.d.l(bufferedSource0, throwable0);
            throw throwable0;
        }
        d8.d.l(bufferedSource0, null);
        if(v != -1L && v != ((long)arr_b.length)) {
            throw new IOException("Content-Length (" + v + ") and stream length (" + arr_b.length + ") disagree");
        }
        return arr_b;
    }

    @NotNull
    public final Reader charStream() {
        Reader reader0 = this.reader;
        if(reader0 == null) {
            reader0 = new BomAwareReader(this.source(), this.charset());
            this.reader = reader0;
        }
        return reader0;
    }

    private final Charset charset() {
        MediaType mediaType0 = this.contentType();
        if(mediaType0 != null) {
            Charset charset0 = mediaType0.charset(a.a);
            return charset0 == null ? a.a : charset0;
        }
        return a.a;
    }

    @Override
    public void close() {
        Util.closeQuietly(this.source());
    }

    private final Object consumeSource(k k0, k k1) {
        Object object0;
        long v = this.contentLength();
        if(v > 0x7FFFFFFFL) {
            throw new IOException(e.a(v, "Cannot buffer entire body for content length: "));
        }
        BufferedSource bufferedSource0 = this.source();
        try {
            object0 = k0.invoke(bufferedSource0);
        }
        catch(Throwable throwable0) {
            d8.d.l(bufferedSource0, throwable0);
            throw throwable0;
        }
        d8.d.l(bufferedSource0, null);
        int v1 = ((Number)k1.invoke(object0)).intValue();
        if(v != -1L && v != ((long)v1)) {
            throw new IOException("Content-Length (" + v + ") and stream length (" + v1 + ") disagree");
        }
        return object0;
    }

    public abstract long contentLength();

    @Nullable
    public abstract MediaType contentType();

    @NotNull
    public static final ResponseBody create(@NotNull String s, @Nullable MediaType mediaType0) {
        return ResponseBody.Companion.create(s, mediaType0);
    }

    @d
    @NotNull
    public static final ResponseBody create(@Nullable MediaType mediaType0, long v, @NotNull BufferedSource bufferedSource0) {
        return ResponseBody.Companion.create(mediaType0, v, bufferedSource0);
    }

    @d
    @NotNull
    public static final ResponseBody create(@Nullable MediaType mediaType0, @NotNull String s) {
        return ResponseBody.Companion.create(mediaType0, s);
    }

    @d
    @NotNull
    public static final ResponseBody create(@Nullable MediaType mediaType0, @NotNull ByteString byteString0) {
        return ResponseBody.Companion.create(mediaType0, byteString0);
    }

    @d
    @NotNull
    public static final ResponseBody create(@Nullable MediaType mediaType0, @NotNull byte[] arr_b) {
        return ResponseBody.Companion.create(mediaType0, arr_b);
    }

    @NotNull
    public static final ResponseBody create(@NotNull BufferedSource bufferedSource0, @Nullable MediaType mediaType0, long v) {
        return ResponseBody.Companion.create(bufferedSource0, mediaType0, v);
    }

    @NotNull
    public static final ResponseBody create(@NotNull ByteString byteString0, @Nullable MediaType mediaType0) {
        return ResponseBody.Companion.create(byteString0, mediaType0);
    }

    @NotNull
    public static final ResponseBody create(@NotNull byte[] arr_b, @Nullable MediaType mediaType0) {
        return ResponseBody.Companion.create(arr_b, mediaType0);
    }

    @NotNull
    public abstract BufferedSource source();

    @NotNull
    public final String string() {
        String s;
        BufferedSource bufferedSource0 = this.source();
        try {
            s = bufferedSource0.readString(Util.readBomAsCharset(bufferedSource0, this.charset()));
        }
        catch(Throwable throwable0) {
            d8.d.l(bufferedSource0, throwable0);
            throw throwable0;
        }
        d8.d.l(bufferedSource0, null);
        return s;
    }
}

