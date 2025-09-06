package okio;

import ie.d;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@d
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0005H\u0007J\u0010\u0010\b\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0007J\u0010\u0010\n\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0010\u0010\n\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u000FH\u0007J)\u0010\n\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u00112\u0012\u0010\u0012\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0015J\u0010\u0010\n\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u0017H\u0007J\u0010\u0010\f\u001A\u00020\r2\u0006\u0010\u0006\u001A\u00020\u0007H\u0007J\u0010\u0010\f\u001A\u00020\r2\u0006\u0010\u0018\u001A\u00020\u0019H\u0007J)\u0010\f\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u00112\u0012\u0010\u0012\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0007¢\u0006\u0002\u0010\u001AJ\u0010\u0010\f\u001A\u00020\r2\u0006\u0010\u0016\u001A\u00020\u0017H\u0007J\b\u0010\u001B\u001A\u00020\u0005H\u0007¨\u0006\u001C"}, d2 = {"Lokio/-DeprecatedOkio;", "", "<init>", "()V", "appendingSink", "Lokio/Sink;", "file", "Ljava/io/File;", "buffer", "Lokio/BufferedSink;", "sink", "Lokio/BufferedSource;", "source", "Lokio/Source;", "outputStream", "Ljava/io/OutputStream;", "path", "Ljava/nio/file/Path;", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "socket", "Ljava/net/Socket;", "inputStream", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "blackhole", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class -DeprecatedOkio {
    @NotNull
    public static final -DeprecatedOkio INSTANCE;

    static {
        -DeprecatedOkio.INSTANCE = new -DeprecatedOkio();
    }

    @d
    @NotNull
    public final Sink appendingSink(@NotNull File file0) {
        q.g(file0, "file");
        return Okio.appendingSink(file0);
    }

    @d
    @NotNull
    public final Sink blackhole() {
        return Okio.blackhole();
    }

    @d
    @NotNull
    public final BufferedSink buffer(@NotNull Sink sink0) {
        q.g(sink0, "sink");
        return Okio.buffer(sink0);
    }

    @d
    @NotNull
    public final BufferedSource buffer(@NotNull Source source0) {
        q.g(source0, "source");
        return Okio.buffer(source0);
    }

    @d
    @NotNull
    public final Sink sink(@NotNull File file0) {
        q.g(file0, "file");
        return Okio.sink$default(file0, false, 1, null);
    }

    @d
    @NotNull
    public final Sink sink(@NotNull OutputStream outputStream0) {
        q.g(outputStream0, "outputStream");
        return Okio.sink(outputStream0);
    }

    @d
    @NotNull
    public final Sink sink(@NotNull Socket socket0) {
        q.g(socket0, "socket");
        return Okio.sink(socket0);
    }

    @d
    @NotNull
    public final Sink sink(@NotNull Path path0, @NotNull OpenOption[] arr_openOption) {
        q.g(path0, "path");
        q.g(arr_openOption, "options");
        return Okio.sink(path0, ((OpenOption[])Arrays.copyOf(arr_openOption, arr_openOption.length)));
    }

    @d
    @NotNull
    public final Source source(@NotNull File file0) {
        q.g(file0, "file");
        return Okio.source(file0);
    }

    @d
    @NotNull
    public final Source source(@NotNull InputStream inputStream0) {
        q.g(inputStream0, "inputStream");
        return Okio.source(inputStream0);
    }

    @d
    @NotNull
    public final Source source(@NotNull Socket socket0) {
        q.g(socket0, "socket");
        return Okio.source(socket0);
    }

    @d
    @NotNull
    public final Source source(@NotNull Path path0, @NotNull OpenOption[] arr_openOption) {
        q.g(path0, "path");
        q.g(arr_openOption, "options");
        return Okio.source(path0, ((OpenOption[])Arrays.copyOf(arr_openOption, arr_openOption.length)));
    }
}

