package okio;

import d8.d;
import e.k;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import je.p;
import je.t;
import ke.b;
import kotlin.Metadata;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001A\u00020\u0007*\u00020\u0006H\u0002\u00A2\u0006\u0004\b\b\u0010\tJ\'\u0010\u000E\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r2\u0006\u0010\n\u001A\u00020\u00062\u0006\u0010\f\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0011\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001A\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u001D\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00060\r2\u0006\u0010\n\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u000E\u0010\u0016J\u001F\u0010\u0017\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r2\u0006\u0010\n\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u0018\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\'\u0010\u001E\u001A\u00020\u00192\u0006\u0010\u0018\u001A\u00020\u00062\u0006\u0010\u001C\u001A\u00020\u000B2\u0006\u0010\u001D\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0017\u0010!\u001A\u00020 2\u0006\u0010\u0018\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b!\u0010\"J\u001F\u0010$\u001A\u00020#2\u0006\u0010\u0018\u001A\u00020\u00062\u0006\u0010\u001C\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b$\u0010%J\u001F\u0010&\u001A\u00020#2\u0006\u0010\u0018\u001A\u00020\u00062\u0006\u0010\u001D\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b&\u0010%J\u001F\u0010(\u001A\u00020\'2\u0006\u0010\n\u001A\u00020\u00062\u0006\u0010\u001C\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b(\u0010)J\u001F\u0010+\u001A\u00020\'2\u0006\u0010!\u001A\u00020\u00062\u0006\u0010*\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b+\u0010,J\u001F\u0010-\u001A\u00020\'2\u0006\u0010\u0010\u001A\u00020\u00062\u0006\u0010\u001D\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b-\u0010)J\u001F\u0010.\u001A\u00020\'2\u0006\u0010!\u001A\u00020\u00062\u0006\u0010*\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b.\u0010,J\u000F\u0010/\u001A\u00020\'H\u0016\u00A2\u0006\u0004\b/\u00100J\u000F\u00102\u001A\u000201H\u0016\u00A2\u0006\u0004\b2\u00103R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u00104\u00A8\u00065"}, d2 = {"Lokio/NioFileSystemWrappingFileSystem;", "Lokio/NioSystemFileSystem;", "Ljava/nio/file/FileSystem;", "nioFileSystem", "<init>", "(Ljava/nio/file/FileSystem;)V", "Lokio/Path;", "Ljava/nio/file/Path;", "resolve", "(Lokio/Path;)Ljava/nio/file/Path;", "dir", "", "throwOnFailure", "", "list", "(Lokio/Path;Z)Ljava/util/List;", "path", "canonicalize", "(Lokio/Path;)Lokio/Path;", "Lokio/FileMetadata;", "metadataOrNull", "(Lokio/Path;)Lokio/FileMetadata;", "(Lokio/Path;)Ljava/util/List;", "listOrNull", "file", "Lokio/FileHandle;", "openReadOnly", "(Lokio/Path;)Lokio/FileHandle;", "mustCreate", "mustExist", "openReadWrite", "(Lokio/Path;ZZ)Lokio/FileHandle;", "Lokio/Source;", "source", "(Lokio/Path;)Lokio/Source;", "Lokio/Sink;", "sink", "(Lokio/Path;Z)Lokio/Sink;", "appendingSink", "Lie/H;", "createDirectory", "(Lokio/Path;Z)V", "target", "atomicMove", "(Lokio/Path;Lokio/Path;)V", "delete", "createSymlink", "close", "()V", "", "toString", "()Ljava/lang/String;", "Ljava/nio/file/FileSystem;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class NioFileSystemWrappingFileSystem extends NioSystemFileSystem {
    @NotNull
    private final FileSystem nioFileSystem;

    public NioFileSystemWrappingFileSystem(@NotNull FileSystem fileSystem0) {
        q.g(fileSystem0, "nioFileSystem");
        super();
        this.nioFileSystem = fileSystem0;
    }

    @Override  // okio.JvmSystemFileSystem
    @NotNull
    public Sink appendingSink(@NotNull Path path0, boolean z) {
        q.g(path0, "file");
        b b0 = k.l();
        b0.add(StandardOpenOption.APPEND);
        if(!z) {
            b0.add(StandardOpenOption.CREATE);
        }
        b b1 = k.h(b0);
        java.nio.file.Path path1 = this.resolve(path0);
        StandardOpenOption[] arr_standardOpenOption = (StandardOpenOption[])b1.toArray(new StandardOpenOption[0]);
        OpenOption[] arr_openOption = (OpenOption[])Arrays.copyOf(arr_standardOpenOption, arr_standardOpenOption.length);
        OutputStream outputStream0 = Files.newOutputStream(path1, ((OpenOption[])Arrays.copyOf(arr_openOption, arr_openOption.length)));
        q.f(outputStream0, "newOutputStream(...)");
        return Okio.sink(outputStream0);
    }

    @Override  // okio.NioSystemFileSystem
    public void atomicMove(@NotNull Path path0, @NotNull Path path1) {
        q.g(path0, "source");
        q.g(path1, "target");
        try {
            q.f(Files.move(this.resolve(path0), this.resolve(path1), ((CopyOption[])Arrays.copyOf(new CopyOption[]{StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING}, 2))), "move(...)");
        }
        catch(NoSuchFileException noSuchFileException0) {
            throw new FileNotFoundException(noSuchFileException0.getMessage());
        }
        catch(UnsupportedOperationException unused_ex) {
            throw new IOException("atomic move not supported");
        }
    }

    @Override  // okio.JvmSystemFileSystem
    @NotNull
    public Path canonicalize(@NotNull Path path0) {
        q.g(path0, "path");
        try {
            java.nio.file.Path path1 = this.resolve(path0).toRealPath(new LinkOption[0]);
            q.f(path1, "toRealPath(...)");
            return Companion.get$default(Path.Companion, path1, false, 1, null);
        }
        catch(NoSuchFileException unused_ex) {
            throw new FileNotFoundException("no such file: " + path0);
        }
    }

    @Override  // okio.FileSystem
    public void close() {
        this.nioFileSystem.close();
    }

    @Override  // okio.JvmSystemFileSystem
    public void createDirectory(@NotNull Path path0, boolean z) {
        boolean z1 = true;
        q.g(path0, "dir");
        FileMetadata fileMetadata0 = this.metadataOrNull(path0);
        if(fileMetadata0 == null || !fileMetadata0.isDirectory()) {
            z1 = false;
        }
        else if(z) {
            throw new IOException(path0 + " already exists.");
        }
        try {
            q.f(Files.createDirectory(this.resolve(path0), ((FileAttribute[])Arrays.copyOf(new FileAttribute[0], 0))), "createDirectory(...)");
        }
        catch(IOException iOException0) {
            if(!z1) {
                throw new IOException("failed to create directory: " + path0, iOException0);
            }
        }
    }

    @Override  // okio.NioSystemFileSystem
    public void createSymlink(@NotNull Path path0, @NotNull Path path1) {
        q.g(path0, "source");
        q.g(path1, "target");
        q.f(Files.createSymbolicLink(this.resolve(path0), this.resolve(path1), ((FileAttribute[])Arrays.copyOf(new FileAttribute[0], 0))), "createSymbolicLink(...)");
    }

    @Override  // okio.JvmSystemFileSystem
    public void delete(@NotNull Path path0, boolean z) {
        q.g(path0, "path");
        if(Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        java.nio.file.Path path1 = this.resolve(path0);
        try {
            Files.delete(path1);
        }
        catch(NoSuchFileException unused_ex) {
            if(z) {
                throw new FileNotFoundException("no such file: " + path0);
            }
        }
        catch(IOException unused_ex) {
            if(Files.exists(path1, ((LinkOption[])Arrays.copyOf(new LinkOption[0], 0)))) {
                throw new IOException("failed to delete " + path0);
            }
        }
    }

    private final List list(Path path0, boolean z) {
        java.nio.file.Path path1 = this.resolve(path0);
        try {
            q.g(path1, "<this>");
            DirectoryStream directoryStream0 = Files.newDirectoryStream(path1, "*");
            try {
                q.d(directoryStream0);
                List list0 = p.P0(directoryStream0);
            }
            catch(Throwable throwable0) {
                d.l(directoryStream0, throwable0);
                throw throwable0;
            }
            d.l(directoryStream0, null);
        }
        catch(Exception unused_ex) {
            if(z) {
                if(Files.exists(path1, ((LinkOption[])Arrays.copyOf(new LinkOption[0], 0)))) {
                    throw new IOException("failed to list " + path0);
                }
                throw new FileNotFoundException("no such file: " + path0);
            }
            return null;
        }
        List list1 = new ArrayList();
        for(Object object0: list0) {
            list1.add(Companion.get$default(Path.Companion, ((java.nio.file.Path)object0), false, 1, null));
        }
        t.R(list1);
        return list1;
    }

    @Override  // okio.JvmSystemFileSystem
    @NotNull
    public List list(@NotNull Path path0) {
        q.g(path0, "dir");
        List list0 = this.list(path0, true);
        q.d(list0);
        return list0;
    }

    @Override  // okio.JvmSystemFileSystem
    @Nullable
    public List listOrNull(@NotNull Path path0) {
        q.g(path0, "dir");
        return this.list(path0, false);
    }

    @Override  // okio.NioSystemFileSystem
    @Nullable
    public FileMetadata metadataOrNull(@NotNull Path path0) {
        q.g(path0, "path");
        return this.metadataOrNull(this.resolve(path0));
    }

    @Override  // okio.JvmSystemFileSystem
    @NotNull
    public FileHandle openReadOnly(@NotNull Path path0) {
        FileChannel fileChannel0;
        q.g(path0, "file");
        try {
            fileChannel0 = FileChannel.open(this.resolve(path0), new OpenOption[]{StandardOpenOption.READ});
        }
        catch(NoSuchFileException unused_ex) {
            throw new FileNotFoundException("no such file: " + path0);
        }
        q.d(fileChannel0);
        return new NioFileSystemFileHandle(false, fileChannel0);
    }

    @Override  // okio.JvmSystemFileSystem
    @NotNull
    public FileHandle openReadWrite(@NotNull Path path0, boolean z, boolean z1) {
        FileChannel fileChannel0;
        q.g(path0, "file");
        if(z && z1) {
            throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.");
        }
        b b0 = k.l();
        b0.add(StandardOpenOption.READ);
        b0.add(StandardOpenOption.WRITE);
        if(z) {
            b0.add(StandardOpenOption.CREATE_NEW);
        }
        else if(!z1) {
            b0.add(StandardOpenOption.CREATE);
        }
        b b1 = k.h(b0);
        try {
            java.nio.file.Path path1 = this.resolve(path0);
            StandardOpenOption[] arr_standardOpenOption = (StandardOpenOption[])b1.toArray(new StandardOpenOption[0]);
            fileChannel0 = FileChannel.open(path1, ((OpenOption[])Arrays.copyOf(arr_standardOpenOption, arr_standardOpenOption.length)));
        }
        catch(NoSuchFileException unused_ex) {
            throw new FileNotFoundException("no such file: " + path0);
        }
        q.d(fileChannel0);
        return new NioFileSystemFileHandle(true, fileChannel0);
    }

    private final java.nio.file.Path resolve(Path path0) {
        java.nio.file.Path path1 = this.nioFileSystem.getPath(path0.toString(), new String[0]);
        q.f(path1, "getPath(...)");
        return path1;
    }

    @Override  // okio.JvmSystemFileSystem
    @NotNull
    public Sink sink(@NotNull Path path0, boolean z) {
        q.g(path0, "file");
        b b0 = k.l();
        if(z) {
            b0.add(StandardOpenOption.CREATE_NEW);
        }
        b b1 = k.h(b0);
        try {
            java.nio.file.Path path1 = this.resolve(path0);
            StandardOpenOption[] arr_standardOpenOption = (StandardOpenOption[])b1.toArray(new StandardOpenOption[0]);
            OpenOption[] arr_openOption = (OpenOption[])Arrays.copyOf(arr_standardOpenOption, arr_standardOpenOption.length);
            OutputStream outputStream0 = Files.newOutputStream(path1, ((OpenOption[])Arrays.copyOf(arr_openOption, arr_openOption.length)));
            q.f(outputStream0, "newOutputStream(...)");
            return Okio.sink(outputStream0);
        }
        catch(NoSuchFileException unused_ex) {
            throw new FileNotFoundException("no such file: " + path0);
        }
    }

    @Override  // okio.JvmSystemFileSystem
    @NotNull
    public Source source(@NotNull Path path0) {
        q.g(path0, "file");
        try {
            InputStream inputStream0 = Files.newInputStream(this.resolve(path0), ((OpenOption[])Arrays.copyOf(new OpenOption[0], 0)));
            q.f(inputStream0, "newInputStream(...)");
            return Okio.source(inputStream0);
        }
        catch(NoSuchFileException unused_ex) {
            throw new FileNotFoundException("no such file: " + path0);
        }
    }

    @Override  // okio.NioSystemFileSystem
    @NotNull
    public String toString() {
        Class class0 = this.nioFileSystem.getClass();
        String s = I.a.b(class0).m();
        q.d(s);
        return s;
    }
}

