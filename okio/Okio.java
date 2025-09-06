package okio;

import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.OpenOption;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"okio/Okio__JvmOkioKt", "okio/Okio__OkioKt", "okio/Okio__ZlibOkioKt"}, k = 4, mv = {2, 1, 0}, xi = 0x30)
public final class Okio {
    @NotNull
    public static final Sink appendingSink(@NotNull File file0) {
        return Okio__JvmOkioKt.appendingSink(file0);
    }

    @NotNull
    public static final FileSystem asResourceFileSystem(@NotNull ClassLoader classLoader0) {
        return Okio__JvmOkioKt.asResourceFileSystem(classLoader0);
    }

    @NotNull
    public static final Sink blackhole() {
        return Okio__OkioKt.blackhole();
    }

    @NotNull
    public static final BufferedSink buffer(@NotNull Sink sink0) {
        return Okio__OkioKt.buffer(sink0);
    }

    @NotNull
    public static final BufferedSource buffer(@NotNull Source source0) {
        return Okio__OkioKt.buffer(source0);
    }

    @NotNull
    public static final CipherSink cipherSink(@NotNull Sink sink0, @NotNull Cipher cipher0) {
        return Okio__JvmOkioKt.cipherSink(sink0, cipher0);
    }

    @NotNull
    public static final CipherSource cipherSource(@NotNull Source source0, @NotNull Cipher cipher0) {
        return Okio__JvmOkioKt.cipherSource(source0, cipher0);
    }

    @NotNull
    public static final HashingSink hashingSink(@NotNull Sink sink0, @NotNull MessageDigest messageDigest0) {
        return Okio__JvmOkioKt.hashingSink(sink0, messageDigest0);
    }

    @NotNull
    public static final HashingSink hashingSink(@NotNull Sink sink0, @NotNull Mac mac0) {
        return Okio__JvmOkioKt.hashingSink(sink0, mac0);
    }

    @NotNull
    public static final HashingSource hashingSource(@NotNull Source source0, @NotNull MessageDigest messageDigest0) {
        return Okio__JvmOkioKt.hashingSource(source0, messageDigest0);
    }

    @NotNull
    public static final HashingSource hashingSource(@NotNull Source source0, @NotNull Mac mac0) {
        return Okio__JvmOkioKt.hashingSource(source0, mac0);
    }

    @NotNull
    public static final Socket[] inMemorySocketPair(long v) {
        return Okio__JvmOkioKt.inMemorySocketPair(v);
    }

    @NotNull
    public static final FileSystem openZip(@NotNull FileSystem fileSystem0, @NotNull Path path0) {
        return Okio__ZlibOkioKt.openZip(fileSystem0, path0);
    }

    @NotNull
    public static final Sink sink(@NotNull File file0) {
        return Okio__JvmOkioKt.sink(file0);
    }

    @NotNull
    public static final Sink sink(@NotNull File file0, boolean z) {
        return Okio__JvmOkioKt.sink(file0, z);
    }

    @NotNull
    public static final Sink sink(@NotNull OutputStream outputStream0) {
        return Okio__JvmOkioKt.sink(outputStream0);
    }

    @NotNull
    public static final Sink sink(@NotNull java.net.Socket socket0) {
        return Okio__JvmOkioKt.sink(socket0);
    }

    @NotNull
    public static final Sink sink(@NotNull java.nio.file.Path path0, @NotNull OpenOption[] arr_openOption) {
        return Okio__JvmOkioKt.sink(path0, arr_openOption);
    }

    public static Sink sink$default(File file0, boolean z, int v, Object object0) {
        return Okio__JvmOkioKt.sink$default(file0, z, v, object0);
    }

    @NotNull
    public static final Socket socket(@NotNull java.net.Socket socket0) {
        return Okio__JvmOkioKt.socket(socket0);
    }

    @NotNull
    public static final Source source(@NotNull File file0) {
        return Okio__JvmOkioKt.source(file0);
    }

    @NotNull
    public static final Source source(@NotNull InputStream inputStream0) {
        return Okio__JvmOkioKt.source(inputStream0);
    }

    @NotNull
    public static final Source source(@NotNull java.net.Socket socket0) {
        return Okio__JvmOkioKt.source(socket0);
    }

    @NotNull
    public static final Source source(@NotNull java.nio.file.Path path0, @NotNull OpenOption[] arr_openOption) {
        return Okio__JvmOkioKt.source(path0, arr_openOption);
    }

    public static final Object use(Closeable closeable0, @NotNull k k0) {
        return Okio__OkioKt.use(closeable0, k0);
    }
}

