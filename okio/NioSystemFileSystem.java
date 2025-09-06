package okio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001A\u0004\u0018\u00010\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000B\u001A\u0004\u0018\u00010\n2\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u0019\u0010\u000B\u001A\u0004\u0018\u00010\n2\u0006\u0010\u000E\u001A\u00020\rH\u0004¢\u0006\u0004\b\u000B\u0010\u000FJ\u001F\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0010\u001A\u00020\b2\u0006\u0010\u0011\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001F\u0010\u0015\u001A\u00020\u00122\u0006\u0010\u0010\u001A\u00020\b2\u0006\u0010\u0011\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000F\u0010\u0017\u001A\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lokio/NioSystemFileSystem;", "Lokio/JvmSystemFileSystem;", "<init>", "()V", "Ljava/nio/file/attribute/FileTime;", "", "zeroToNull", "(Ljava/nio/file/attribute/FileTime;)Ljava/lang/Long;", "Lokio/Path;", "path", "Lokio/FileMetadata;", "metadataOrNull", "(Lokio/Path;)Lokio/FileMetadata;", "Ljava/nio/file/Path;", "nioPath", "(Ljava/nio/file/Path;)Lokio/FileMetadata;", "source", "target", "Lie/H;", "atomicMove", "(Lokio/Path;Lokio/Path;)V", "createSymlink", "", "toString", "()Ljava/lang/String;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public class NioSystemFileSystem extends JvmSystemFileSystem {
    @Override  // okio.JvmSystemFileSystem
    public void atomicMove(@NotNull Path path0, @NotNull Path path1) {
        q.g(path0, "source");
        q.g(path1, "target");
        try {
            Files.move(path0.toNioPath(), path1.toNioPath(), new CopyOption[]{StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING});
        }
        catch(NoSuchFileException noSuchFileException0) {
            throw new FileNotFoundException(noSuchFileException0.getMessage());
        }
        catch(UnsupportedOperationException unused_ex) {
            throw new IOException("atomic move not supported");
        }
    }

    @Override  // okio.JvmSystemFileSystem
    public void createSymlink(@NotNull Path path0, @NotNull Path path1) {
        q.g(path0, "source");
        q.g(path1, "target");
        Files.createSymbolicLink(path0.toNioPath(), path1.toNioPath(), new FileAttribute[0]);
    }

    @Nullable
    public final FileMetadata metadataOrNull(@NotNull java.nio.file.Path path0) {
        BasicFileAttributes basicFileAttributes0;
        q.g(path0, "nioPath");
        Long long0 = null;
        try {
            basicFileAttributes0 = Files.readAttributes(path0, BasicFileAttributes.class, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
        }
        catch(NoSuchFileException | FileSystemException unused_ex) {
            return null;
        }
        java.nio.file.Path path1 = basicFileAttributes0.isSymbolicLink() ? Files.readSymbolicLink(path0) : null;
        boolean z = basicFileAttributes0.isRegularFile();
        boolean z1 = basicFileAttributes0.isDirectory();
        Path path2 = path1 == null ? null : Companion.get$default(Path.Companion, path1, false, 1, null);
        Long long1 = basicFileAttributes0.size();
        FileTime fileTime0 = basicFileAttributes0.creationTime();
        Long long2 = fileTime0 == null ? null : this.zeroToNull(fileTime0);
        FileTime fileTime1 = basicFileAttributes0.lastModifiedTime();
        Long long3 = fileTime1 == null ? null : this.zeroToNull(fileTime1);
        FileTime fileTime2 = basicFileAttributes0.lastAccessTime();
        if(fileTime2 != null) {
            long0 = this.zeroToNull(fileTime2);
        }
        return new FileMetadata(z, z1, path2, long1, long2, long3, long0, null, 0x80, null);
    }

    @Override  // okio.JvmSystemFileSystem
    @Nullable
    public FileMetadata metadataOrNull(@NotNull Path path0) {
        q.g(path0, "path");
        return this.metadataOrNull(path0.toNioPath());
    }

    @Override  // okio.JvmSystemFileSystem
    @NotNull
    public String toString() {
        return "NioSystemFileSystem";
    }

    private final Long zeroToNull(FileTime fileTime0) {
        Long long0 = fileTime0.toMillis();
        return long0.longValue() == 0L ? null : long0;
    }
}

