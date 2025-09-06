package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okio.internal.DefaultSocket;
import okio.internal.PipeSocket;
import okio.internal.ResourceFileSystem;
import okio.internal.SocketAsyncTimeout;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0002\u001A\n\u0010\u0003\u001A\u00020\u0004*\u00020\u0005\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0006\u001A\n\u0010\u0003\u001A\u00020\u0004*\u00020\u0006\u001A\u0011\u0010\u0007\u001A\u00020\b*\u00020\u0006H\u0007¢\u0006\u0002\b\t\u001A\u0019\u0010\n\u001A\b\u0012\u0004\u0012\u00020\b0\u000B2\u0006\u0010\f\u001A\u00020\r¢\u0006\u0002\u0010\u000E\u001A\u0016\u0010\u0000\u001A\u00020\u0001*\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u0011H\u0007\u001A\n\u0010\u0012\u001A\u00020\u0001*\u00020\u000F\u001A\n\u0010\u0003\u001A\u00020\u0004*\u00020\u000F\u001A#\u0010\u0000\u001A\u00020\u0001*\u00020\u00132\u0012\u0010\u0014\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u000B\"\u00020\u0015¢\u0006\u0002\u0010\u0016\u001A#\u0010\u0003\u001A\u00020\u0004*\u00020\u00132\u0012\u0010\u0014\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u000B\"\u00020\u0015¢\u0006\u0002\u0010\u0017\u001A\u0012\u0010\u0018\u001A\u00020\u0019*\u00020\u00012\u0006\u0010\u001A\u001A\u00020\u001B\u001A\u0012\u0010\u001C\u001A\u00020\u001D*\u00020\u00042\u0006\u0010\u001A\u001A\u00020\u001B\u001A\u0012\u0010\u001E\u001A\u00020\u001F*\u00020\u00012\u0006\u0010 \u001A\u00020!\u001A\u0012\u0010\"\u001A\u00020#*\u00020\u00042\u0006\u0010 \u001A\u00020!\u001A\u0012\u0010\u001E\u001A\u00020\u001F*\u00020\u00012\u0006\u0010$\u001A\u00020%\u001A\u0012\u0010\"\u001A\u00020#*\u00020\u00042\u0006\u0010$\u001A\u00020%\u001A\n\u0010&\u001A\u00020\'*\u00020(¨\u0006)"}, d2 = {"sink", "Lokio/Sink;", "Ljava/io/OutputStream;", "source", "Lokio/Source;", "Ljava/io/InputStream;", "Ljava/net/Socket;", "asOkioSocket", "Lokio/Socket;", "socket", "inMemorySocketPair", "", "maxBufferSize", "", "(J)[Lokio/Socket;", "Ljava/io/File;", "append", "", "appendingSink", "Ljava/nio/file/Path;", "options", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "cipherSink", "Lokio/CipherSink;", "cipher", "Ljavax/crypto/Cipher;", "cipherSource", "Lokio/CipherSource;", "hashingSink", "Lokio/HashingSink;", "mac", "Ljavax/crypto/Mac;", "hashingSource", "Lokio/HashingSource;", "digest", "Ljava/security/MessageDigest;", "asResourceFileSystem", "Lokio/FileSystem;", "Ljava/lang/ClassLoader;", "okio"}, k = 5, mv = {2, 1, 0}, xi = 0x30, xs = "okio/Okio")
final class Okio__JvmOkioKt {
    @NotNull
    public static final Sink appendingSink(@NotNull File file0) {
        q.g(file0, "<this>");
        return Okio.sink(new FileOutputStream(file0, true));
    }

    @NotNull
    public static final FileSystem asResourceFileSystem(@NotNull ClassLoader classLoader0) {
        q.g(classLoader0, "<this>");
        return new ResourceFileSystem(classLoader0, true, null, 4, null);
    }

    @NotNull
    public static final CipherSink cipherSink(@NotNull Sink sink0, @NotNull Cipher cipher0) {
        q.g(sink0, "<this>");
        q.g(cipher0, "cipher");
        return new CipherSink(Okio.buffer(sink0), cipher0);
    }

    @NotNull
    public static final CipherSource cipherSource(@NotNull Source source0, @NotNull Cipher cipher0) {
        q.g(source0, "<this>");
        q.g(cipher0, "cipher");
        return new CipherSource(Okio.buffer(source0), cipher0);
    }

    @NotNull
    public static final HashingSink hashingSink(@NotNull Sink sink0, @NotNull MessageDigest messageDigest0) {
        q.g(sink0, "<this>");
        q.g(messageDigest0, "digest");
        return new HashingSink(sink0, messageDigest0);
    }

    @NotNull
    public static final HashingSink hashingSink(@NotNull Sink sink0, @NotNull Mac mac0) {
        q.g(sink0, "<this>");
        q.g(mac0, "mac");
        return new HashingSink(sink0, mac0);
    }

    @NotNull
    public static final HashingSource hashingSource(@NotNull Source source0, @NotNull MessageDigest messageDigest0) {
        q.g(source0, "<this>");
        q.g(messageDigest0, "digest");
        return new HashingSource(source0, messageDigest0);
    }

    @NotNull
    public static final HashingSource hashingSource(@NotNull Source source0, @NotNull Mac mac0) {
        q.g(source0, "<this>");
        q.g(mac0, "mac");
        return new HashingSource(source0, mac0);
    }

    @NotNull
    public static final Socket[] inMemorySocketPair(long v) {
        Pipe pipe0 = new Pipe(v);
        Pipe pipe1 = new Pipe(v);
        return new Socket[]{new PipeSocket(pipe0, pipe1), new PipeSocket(pipe1, pipe0)};
    }

    @NotNull
    public static final Sink sink(@NotNull File file0) {
        q.g(file0, "<this>");
        return Okio.sink$default(file0, false, 1, null);
    }

    @NotNull
    public static final Sink sink(@NotNull File file0, boolean z) {
        q.g(file0, "<this>");
        return Okio.sink(new FileOutputStream(file0, z));
    }

    @NotNull
    public static final Sink sink(@NotNull OutputStream outputStream0) {
        q.g(outputStream0, "<this>");
        return new OutputStreamSink(outputStream0, new Timeout());
    }

    @NotNull
    public static final Sink sink(@NotNull java.net.Socket socket0) {
        q.g(socket0, "<this>");
        SocketAsyncTimeout socketAsyncTimeout0 = new SocketAsyncTimeout(socket0);
        OutputStream outputStream0 = socket0.getOutputStream();
        q.f(outputStream0, "getOutputStream(...)");
        return socketAsyncTimeout0.sink(new OutputStreamSink(outputStream0, socketAsyncTimeout0));
    }

    @NotNull
    public static final Sink sink(@NotNull Path path0, @NotNull OpenOption[] arr_openOption) {
        q.g(path0, "<this>");
        q.g(arr_openOption, "options");
        OutputStream outputStream0 = Files.newOutputStream(path0, ((OpenOption[])Arrays.copyOf(arr_openOption, arr_openOption.length)));
        q.f(outputStream0, "newOutputStream(...)");
        return Okio.sink(outputStream0);
    }

    public static Sink sink$default(File file0, boolean z, int v, Object object0) {
        if((v & 1) != 0) {
            z = false;
        }
        return Okio.sink(file0, z);
    }

    @NotNull
    public static final Socket socket(@NotNull java.net.Socket socket0) {
        q.g(socket0, "<this>");
        return new DefaultSocket(socket0);
    }

    @NotNull
    public static final Source source(@NotNull File file0) {
        q.g(file0, "<this>");
        return new InputStreamSource(new FileInputStream(file0), Timeout.NONE);
    }

    @NotNull
    public static final Source source(@NotNull InputStream inputStream0) {
        q.g(inputStream0, "<this>");
        return new InputStreamSource(inputStream0, new Timeout());
    }

    @NotNull
    public static final Source source(@NotNull java.net.Socket socket0) {
        q.g(socket0, "<this>");
        SocketAsyncTimeout socketAsyncTimeout0 = new SocketAsyncTimeout(socket0);
        InputStream inputStream0 = socket0.getInputStream();
        q.f(inputStream0, "getInputStream(...)");
        return socketAsyncTimeout0.source(new InputStreamSource(inputStream0, socketAsyncTimeout0));
    }

    @NotNull
    public static final Source source(@NotNull Path path0, @NotNull OpenOption[] arr_openOption) {
        q.g(path0, "<this>");
        q.g(arr_openOption, "options");
        InputStream inputStream0 = Files.newInputStream(path0, ((OpenOption[])Arrays.copyOf(arr_openOption, arr_openOption.length)));
        q.f(inputStream0, "newInputStream(...)");
        return Okio.source(inputStream0);
    }
}

