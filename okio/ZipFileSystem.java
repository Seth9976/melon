package okio;

import e2.a;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okio.internal.FixedLengthSource;
import okio.internal.ZipEntry;
import okio.internal.ZipFilesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 62\u00020\u0001:\u00016B7\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0001\u0012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\t\u001A\u0004\u0018\u00010\b\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\r\u001A\u00020\u00022\u0006\u0010\f\u001A\u00020\u0002H\u0002\u00A2\u0006\u0004\b\r\u0010\u000EJ\'\u0010\u0013\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00122\u0006\u0010\u000F\u001A\u00020\u00022\u0006\u0010\u0011\u001A\u00020\u0010H\u0002\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001A\u00020\u00022\u0006\u0010\f\u001A\u00020\u0002H\u0016\u00A2\u0006\u0004\b\u0015\u0010\u000EJ\u0019\u0010\u0017\u001A\u0004\u0018\u00010\u00162\u0006\u0010\f\u001A\u00020\u0002H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u0019\u001A\u00020\u0002H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\'\u0010\u001F\u001A\u00020\u001A2\u0006\u0010\u0019\u001A\u00020\u00022\u0006\u0010\u001D\u001A\u00020\u00102\u0006\u0010\u001E\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b\u001F\u0010 J\u001D\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u000F\u001A\u00020\u0002H\u0016\u00A2\u0006\u0004\b\u0013\u0010!J\u001F\u0010\"\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00122\u0006\u0010\u000F\u001A\u00020\u0002H\u0016\u00A2\u0006\u0004\b\"\u0010!J\u0017\u0010$\u001A\u00020#2\u0006\u0010\u0019\u001A\u00020\u0002H\u0016\u00A2\u0006\u0004\b$\u0010%J\u001F\u0010\'\u001A\u00020&2\u0006\u0010\u0019\u001A\u00020\u00022\u0006\u0010\u001D\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b\'\u0010(J\u001F\u0010)\u001A\u00020&2\u0006\u0010\u0019\u001A\u00020\u00022\u0006\u0010\u001E\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b)\u0010(J\u001F\u0010+\u001A\u00020*2\u0006\u0010\u000F\u001A\u00020\u00022\u0006\u0010\u001D\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b+\u0010,J\u001F\u0010.\u001A\u00020*2\u0006\u0010$\u001A\u00020\u00022\u0006\u0010-\u001A\u00020\u0002H\u0016\u00A2\u0006\u0004\b.\u0010/J\u001F\u00100\u001A\u00020*2\u0006\u0010\f\u001A\u00020\u00022\u0006\u0010\u001E\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b0\u0010,J\u001F\u00101\u001A\u00020*2\u0006\u0010$\u001A\u00020\u00022\u0006\u0010-\u001A\u00020\u0002H\u0016\u00A2\u0006\u0004\b1\u0010/R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u00102R\u0014\u0010\u0004\u001A\u00020\u00018\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0004\u00103R \u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0007\u00104R\u0016\u0010\t\u001A\u0004\u0018\u00010\b8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\t\u00105\u00A8\u00067"}, d2 = {"Lokio/ZipFileSystem;", "Lokio/FileSystem;", "Lokio/Path;", "zipPath", "fileSystem", "", "Lokio/internal/ZipEntry;", "entries", "", "comment", "<init>", "(Lokio/Path;Lokio/FileSystem;Ljava/util/Map;Ljava/lang/String;)V", "path", "canonicalizeInternal", "(Lokio/Path;)Lokio/Path;", "dir", "", "throwOnFailure", "", "list", "(Lokio/Path;Z)Ljava/util/List;", "canonicalize", "Lokio/FileMetadata;", "metadataOrNull", "(Lokio/Path;)Lokio/FileMetadata;", "file", "Lokio/FileHandle;", "openReadOnly", "(Lokio/Path;)Lokio/FileHandle;", "mustCreate", "mustExist", "openReadWrite", "(Lokio/Path;ZZ)Lokio/FileHandle;", "(Lokio/Path;)Ljava/util/List;", "listOrNull", "Lokio/Source;", "source", "(Lokio/Path;)Lokio/Source;", "Lokio/Sink;", "sink", "(Lokio/Path;Z)Lokio/Sink;", "appendingSink", "Lie/H;", "createDirectory", "(Lokio/Path;Z)V", "target", "atomicMove", "(Lokio/Path;Lokio/Path;)V", "delete", "createSymlink", "Lokio/Path;", "Lokio/FileSystem;", "Ljava/util/Map;", "Ljava/lang/String;", "Companion", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class ZipFileSystem extends FileSystem {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lokio/ZipFileSystem$Companion;", "", "<init>", "()V", "ROOT", "Lokio/Path;", "getROOT", "()Lokio/Path;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final Path getROOT() {
            return ZipFileSystem.ROOT;
        }
    }

    @NotNull
    private static final Companion Companion;
    @NotNull
    private static final Path ROOT;
    @Nullable
    private final String comment;
    @NotNull
    private final Map entries;
    @NotNull
    private final FileSystem fileSystem;
    @NotNull
    private final Path zipPath;

    static {
        ZipFileSystem.Companion = new Companion(null);
        ZipFileSystem.ROOT = okio.Path.Companion.get$default(Path.Companion, "/", false, 1, null);
    }

    public ZipFileSystem(@NotNull Path path0, @NotNull FileSystem fileSystem0, @NotNull Map map0, @Nullable String s) {
        q.g(path0, "zipPath");
        q.g(fileSystem0, "fileSystem");
        q.g(map0, "entries");
        super();
        this.zipPath = path0;
        this.fileSystem = fileSystem0;
        this.entries = map0;
        this.comment = s;
    }

    @Override  // okio.FileSystem
    @NotNull
    public Sink appendingSink(@NotNull Path path0, boolean z) {
        q.g(path0, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override  // okio.FileSystem
    public void atomicMove(@NotNull Path path0, @NotNull Path path1) {
        q.g(path0, "source");
        q.g(path1, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override  // okio.FileSystem
    @NotNull
    public Path canonicalize(@NotNull Path path0) {
        q.g(path0, "path");
        Path path1 = this.canonicalizeInternal(path0);
        if(!this.entries.containsKey(path1)) {
            throw new FileNotFoundException(String.valueOf(path0));
        }
        return path1;
    }

    private final Path canonicalizeInternal(Path path0) {
        return ZipFileSystem.ROOT.resolve(path0, true);
    }

    @Override  // okio.FileSystem
    public void createDirectory(@NotNull Path path0, boolean z) {
        q.g(path0, "dir");
        throw new IOException("zip file systems are read-only");
    }

    @Override  // okio.FileSystem
    public void createSymlink(@NotNull Path path0, @NotNull Path path1) {
        q.g(path0, "source");
        q.g(path1, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override  // okio.FileSystem
    public void delete(@NotNull Path path0, boolean z) {
        q.g(path0, "path");
        throw new IOException("zip file systems are read-only");
    }

    private final List list(Path path0, boolean z) {
        Path path1 = this.canonicalizeInternal(path0);
        ZipEntry zipEntry0 = (ZipEntry)this.entries.get(path1);
        if(zipEntry0 == null) {
            if(z) {
                throw new IOException("not a directory: " + path0);
            }
            return null;
        }
        return p.P0(zipEntry0.getChildren());
    }

    @Override  // okio.FileSystem
    @NotNull
    public List list(@NotNull Path path0) {
        q.g(path0, "dir");
        List list0 = this.list(path0, true);
        q.d(list0);
        return list0;
    }

    @Override  // okio.FileSystem
    @Nullable
    public List listOrNull(@NotNull Path path0) {
        q.g(path0, "dir");
        return this.list(path0, false);
    }

    @Override  // okio.FileSystem
    @Nullable
    public FileMetadata metadataOrNull(@NotNull Path path0) {
        Throwable throwable3;
        q.g(path0, "path");
        Path path1 = this.canonicalizeInternal(path0);
        ZipEntry zipEntry0 = (ZipEntry)this.entries.get(path1);
        if(zipEntry0 == null) {
            return null;
        }
        if(zipEntry0.getOffset() != -1L) {
            FileHandle fileHandle0 = this.fileSystem.openReadOnly(this.zipPath);
            try {
                BufferedSource bufferedSource0 = Okio.buffer(fileHandle0.source(zipEntry0.getOffset()));
                try {
                    zipEntry0 = ZipFilesKt.readLocalHeader(bufferedSource0, zipEntry0);
                }
                catch(Throwable throwable1) {
                    if(bufferedSource0 != null) {
                        try {
                            bufferedSource0.close();
                        }
                        catch(Throwable throwable2) {
                            a.q(throwable1, throwable2);
                        }
                    }
                    throwable3 = throwable1;
                    zipEntry0 = null;
                    goto label_25;
                }
                if(bufferedSource0 == null) {
                label_24:
                    throwable3 = null;
                }
                else {
                    try {
                        bufferedSource0.close();
                        goto label_24;
                    }
                    catch(Throwable throwable3) {
                    }
                }
            label_25:
                if(throwable3 != null) {
                    throw throwable3;
                }
                try {
                    fileHandle0.close();
                    throwable4 = null;
                }
                catch(Throwable throwable4) {
                }
            }
            catch(Throwable throwable0) {
                if(fileHandle0 != null) {
                    try {
                        fileHandle0.close();
                    }
                    catch(Throwable throwable5) {
                        a.q(throwable0, throwable5);
                    }
                }
                throwable4 = throwable0;
                zipEntry0 = null;
            }
            if(throwable4 != null) {
                throw throwable4;
            }
        }
        boolean z = zipEntry0.isDirectory();
        boolean z1 = zipEntry0.isDirectory();
        return zipEntry0.isDirectory() ? new FileMetadata(!z, z1, null, null, zipEntry0.getCreatedAtMillis$okio(), zipEntry0.getLastModifiedAtMillis$okio(), zipEntry0.getLastAccessedAtMillis$okio(), null, 0x80, null) : new FileMetadata(!z, z1, null, zipEntry0.getSize(), zipEntry0.getCreatedAtMillis$okio(), zipEntry0.getLastModifiedAtMillis$okio(), zipEntry0.getLastAccessedAtMillis$okio(), null, 0x80, null);
    }

    @Override  // okio.FileSystem
    @NotNull
    public FileHandle openReadOnly(@NotNull Path path0) {
        q.g(path0, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override  // okio.FileSystem
    @NotNull
    public FileHandle openReadWrite(@NotNull Path path0, boolean z, boolean z1) {
        q.g(path0, "file");
        throw new IOException("zip entries are not writable");
    }

    @Override  // okio.FileSystem
    @NotNull
    public Sink sink(@NotNull Path path0, boolean z) {
        q.g(path0, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override  // okio.FileSystem
    @NotNull
    public Source source(@NotNull Path path0) {
        BufferedSource bufferedSource0;
        q.g(path0, "file");
        Path path1 = this.canonicalizeInternal(path0);
        ZipEntry zipEntry0 = (ZipEntry)this.entries.get(path1);
        if(zipEntry0 == null) {
            throw new FileNotFoundException("no such file: " + path0);
        }
        FileHandle fileHandle0 = this.fileSystem.openReadOnly(this.zipPath);
        Throwable throwable0 = null;
        try {
            bufferedSource0 = Okio.buffer(fileHandle0.source(zipEntry0.getOffset()));
        }
        catch(Throwable throwable1) {
            if(fileHandle0 != null) {
                try {
                    fileHandle0.close();
                }
                catch(Throwable throwable2) {
                    a.q(throwable1, throwable2);
                }
            }
            goto label_20;
        }
        try {
            fileHandle0.close();
        }
        catch(Throwable throwable0) {
        }
        throwable1 = throwable0;
        throwable0 = bufferedSource0;
    label_20:
        if(throwable1 != null) {
            throw throwable1;
        }
        ZipFilesKt.skipLocalHeader(((BufferedSource)throwable0));
        return zipEntry0.getCompressionMethod() == 0 ? new FixedLengthSource(((Source)throwable0), zipEntry0.getSize(), true) : new FixedLengthSource(new InflaterSource(new FixedLengthSource(((Source)throwable0), zipEntry0.getCompressedSize(), true), new Inflater(true)), zipEntry0.getSize(), false);
    }
}

