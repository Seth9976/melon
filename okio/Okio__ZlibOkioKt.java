package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okio.internal.ZipFilesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0012\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003¨\u0006\u0004"}, d2 = {"openZip", "Lokio/FileSystem;", "zipPath", "Lokio/Path;", "okio"}, k = 5, mv = {2, 1, 0}, xi = 0x30, xs = "okio/Okio")
final class Okio__ZlibOkioKt {
    @NotNull
    public static final FileSystem openZip(@NotNull FileSystem fileSystem0, @NotNull Path path0) {
        q.g(fileSystem0, "<this>");
        q.g(path0, "zipPath");
        return ZipFilesKt.openZip$default(path0, fileSystem0, null, 4, null);
    }
}

