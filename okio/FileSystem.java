package okio;

import e2.a;
import java.io.Closeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okio.internal.-FileSystem;
import okio.internal.ResourceFileSystem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000F\b&\u0018\u0000 D2\u00060\u0001j\u0002`\u0002:\u0001DB\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0005H&\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u0005\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0019\u0010\f\u001A\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001A\u00020\u0005H&\u00A2\u0006\u0004\b\f\u0010\u000BJ\u0015\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0006\u001A\u00020\u0005\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u001D\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00050\u00112\u0006\u0010\u0010\u001A\u00020\u0005H&\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u001F\u0010\u0014\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00112\u0006\u0010\u0010\u001A\u00020\u0005H&\u00A2\u0006\u0004\b\u0014\u0010\u0013J\'\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00050\u00162\u0006\u0010\u0010\u001A\u00020\u00052\b\b\u0002\u0010\u0015\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u001B\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00050\u00162\u0006\u0010\u0010\u001A\u00020\u0005\u00A2\u0006\u0004\b\u0017\u0010\u0019J\u0017\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001A\u001A\u00020\u0005H&\u00A2\u0006\u0004\b\u001C\u0010\u001DJ+\u0010 \u001A\u00020\u001B2\u0006\u0010\u001A\u001A\u00020\u00052\b\b\u0002\u0010\u001E\u001A\u00020\r2\b\b\u0002\u0010\u001F\u001A\u00020\rH&\u00A2\u0006\u0004\b \u0010!J\u0015\u0010 \u001A\u00020\u001B2\u0006\u0010\u001A\u001A\u00020\u0005\u00A2\u0006\u0004\b \u0010\u001DJ\u0017\u0010#\u001A\u00020\"2\u0006\u0010\u001A\u001A\u00020\u0005H&\u00A2\u0006\u0004\b#\u0010$JB\u0010+\u001A\u00028\u0000\"\u0004\b\u0000\u0010%2\u0006\u0010\u001A\u001A\u00020\u00052\u0012\u0010(\u001A\u000E\u0012\u0004\u0012\u00020\'\u0012\u0004\u0012\u00028\u00000&H\u0087\b\u00F8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u00A2\u0006\u0004\b)\u0010*J!\u0010-\u001A\u00020,2\u0006\u0010\u001A\u001A\u00020\u00052\b\b\u0002\u0010\u001E\u001A\u00020\rH&\u00A2\u0006\u0004\b-\u0010.J\u0015\u0010-\u001A\u00020,2\u0006\u0010\u001A\u001A\u00020\u0005\u00A2\u0006\u0004\b-\u0010/JL\u00104\u001A\u00028\u0000\"\u0004\b\u0000\u0010%2\u0006\u0010\u001A\u001A\u00020\u00052\b\b\u0002\u0010\u001E\u001A\u00020\r2\u0012\u00101\u001A\u000E\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00028\u00000&H\u0087\b\u00F8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001\u00A2\u0006\u0004\b2\u00103J!\u00105\u001A\u00020,2\u0006\u0010\u001A\u001A\u00020\u00052\b\b\u0002\u0010\u001F\u001A\u00020\rH&\u00A2\u0006\u0004\b5\u0010.J\u0015\u00105\u001A\u00020,2\u0006\u0010\u001A\u001A\u00020\u0005\u00A2\u0006\u0004\b5\u0010/J!\u00107\u001A\u0002062\u0006\u0010\u0010\u001A\u00020\u00052\b\b\u0002\u0010\u001E\u001A\u00020\rH&\u00A2\u0006\u0004\b7\u00108J\u0015\u00107\u001A\u0002062\u0006\u0010\u0010\u001A\u00020\u0005\u00A2\u0006\u0004\b7\u00109J\u001F\u0010:\u001A\u0002062\u0006\u0010\u0010\u001A\u00020\u00052\b\b\u0002\u0010\u001E\u001A\u00020\r\u00A2\u0006\u0004\b:\u00108J\u0015\u0010:\u001A\u0002062\u0006\u0010\u0010\u001A\u00020\u0005\u00A2\u0006\u0004\b:\u00109J\u001F\u0010<\u001A\u0002062\u0006\u0010#\u001A\u00020\u00052\u0006\u0010;\u001A\u00020\u0005H&\u00A2\u0006\u0004\b<\u0010=J\u001F\u0010>\u001A\u0002062\u0006\u0010#\u001A\u00020\u00052\u0006\u0010;\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b>\u0010=J!\u0010?\u001A\u0002062\u0006\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u001F\u001A\u00020\rH&\u00A2\u0006\u0004\b?\u00108J\u0015\u0010?\u001A\u0002062\u0006\u0010\u0006\u001A\u00020\u0005\u00A2\u0006\u0004\b?\u00109J!\u0010A\u001A\u0002062\u0006\u0010@\u001A\u00020\u00052\b\b\u0002\u0010\u001F\u001A\u00020\rH\u0016\u00A2\u0006\u0004\bA\u00108J\u0015\u0010A\u001A\u0002062\u0006\u0010@\u001A\u00020\u0005\u00A2\u0006\u0004\bA\u00109J\u001F\u0010B\u001A\u0002062\u0006\u0010#\u001A\u00020\u00052\u0006\u0010;\u001A\u00020\u0005H&\u00A2\u0006\u0004\bB\u0010=J\u000F\u0010C\u001A\u000206H\u0016\u00A2\u0006\u0004\bC\u0010\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00A8\u0006E"}, d2 = {"Lokio/FileSystem;", "Ljava/io/Closeable;", "Lokio/Closeable;", "<init>", "()V", "Lokio/Path;", "path", "canonicalize", "(Lokio/Path;)Lokio/Path;", "Lokio/FileMetadata;", "metadata", "(Lokio/Path;)Lokio/FileMetadata;", "metadataOrNull", "", "exists", "(Lokio/Path;)Z", "dir", "", "list", "(Lokio/Path;)Ljava/util/List;", "listOrNull", "followSymlinks", "LSf/k;", "listRecursively", "(Lokio/Path;Z)LSf/k;", "(Lokio/Path;)LSf/k;", "file", "Lokio/FileHandle;", "openReadOnly", "(Lokio/Path;)Lokio/FileHandle;", "mustCreate", "mustExist", "openReadWrite", "(Lokio/Path;ZZ)Lokio/FileHandle;", "Lokio/Source;", "source", "(Lokio/Path;)Lokio/Source;", "T", "Lkotlin/Function1;", "Lokio/BufferedSource;", "readerAction", "-read", "(Lokio/Path;Lwe/k;)Ljava/lang/Object;", "read", "Lokio/Sink;", "sink", "(Lokio/Path;Z)Lokio/Sink;", "(Lokio/Path;)Lokio/Sink;", "Lokio/BufferedSink;", "writerAction", "-write", "(Lokio/Path;ZLwe/k;)Ljava/lang/Object;", "write", "appendingSink", "Lie/H;", "createDirectory", "(Lokio/Path;Z)V", "(Lokio/Path;)V", "createDirectories", "target", "atomicMove", "(Lokio/Path;Lokio/Path;)V", "copy", "delete", "fileOrDirectory", "deleteRecursively", "createSymlink", "close", "Companion", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public abstract class FileSystem implements Closeable {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\t\u001A\u00020\u0005*\u00020\nH\u0007¢\u0006\u0002\b\u000BR\u0010\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lokio/FileSystem$Companion;", "", "<init>", "()V", "SYSTEM", "Lokio/FileSystem;", "SYSTEM_TEMPORARY_DIRECTORY", "Lokio/Path;", "RESOURCES", "asOkioFileSystem", "Ljava/nio/file/FileSystem;", "get", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final FileSystem get(@NotNull java.nio.file.FileSystem fileSystem0) {
            q.g(fileSystem0, "<this>");
            return new NioFileSystemWrappingFileSystem(fileSystem0);
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    public static final FileSystem RESOURCES;
    @NotNull
    public static final FileSystem SYSTEM;
    @NotNull
    public static final Path SYSTEM_TEMPORARY_DIRECTORY;

    public final Object -read(@NotNull Path path0, @NotNull k k0) {
        Object object1;
        q.g(path0, "file");
        q.g(k0, "readerAction");
        BufferedSource bufferedSource0 = Okio.buffer(this.source(path0));
        Object object0 = null;
        try {
            object1 = k0.invoke(bufferedSource0);
        }
        catch(Throwable throwable0) {
            if(bufferedSource0 != null) {
                try {
                    bufferedSource0.close();
                }
                catch(Throwable throwable1) {
                    a.q(throwable0, throwable1);
                }
            }
            goto label_20;
        }
        if(bufferedSource0 != null) {
            try {
                bufferedSource0.close();
            }
            catch(Throwable object0) {
            }
        }
        Object object2 = object0;
        object0 = object1;
        throwable0 = object2;
    label_20:
        if(throwable0 != null) {
            throw throwable0;
        }
        return object0;
    }

    public final Object -write(@NotNull Path path0, boolean z, @NotNull k k0) {
        Object object0;
        q.g(path0, "file");
        q.g(k0, "writerAction");
        BufferedSink bufferedSink0 = Okio.buffer(this.sink(path0, z));
        Throwable throwable0 = null;
        try {
            object0 = k0.invoke(bufferedSink0);
        }
        catch(Throwable throwable1) {
            if(bufferedSink0 != null) {
                try {
                    bufferedSink0.close();
                }
                catch(Throwable throwable2) {
                    a.q(throwable1, throwable2);
                }
            }
            goto label_19;
        }
        if(bufferedSink0 != null) {
            try {
                bufferedSink0.close();
            }
            catch(Throwable throwable0) {
            }
        }
        throwable1 = throwable0;
        throwable0 = object0;
    label_19:
        if(throwable1 != null) {
            throw throwable1;
        }
        return throwable0;
    }

    public static Object -write$default(FileSystem fileSystem0, Path path0, boolean z, k k0, int v, Object object0) {
        Object object1;
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
        }
        if((v & 2) != 0) {
            z = false;
        }
        q.g(path0, "file");
        q.g(k0, "writerAction");
        BufferedSink bufferedSink0 = Okio.buffer(fileSystem0.sink(path0, z));
        Throwable throwable0 = null;
        try {
            object1 = k0.invoke(bufferedSink0);
        }
        catch(Throwable throwable1) {
            if(bufferedSink0 != null) {
                try {
                    bufferedSink0.close();
                }
                catch(Throwable throwable2) {
                    a.q(throwable1, throwable2);
                }
            }
            goto label_22;
        }
        if(bufferedSink0 != null) {
            try {
                bufferedSink0.close();
            }
            catch(Throwable throwable0) {
            }
        }
        throwable1 = throwable0;
        throwable0 = object1;
    label_22:
        if(throwable1 != null) {
            throw throwable1;
        }
        return throwable0;
    }

    static {
        JvmSystemFileSystem jvmSystemFileSystem0;
        FileSystem.Companion = new Companion(null);
        try {
            jvmSystemFileSystem0 = new NioSystemFileSystem();
        }
        catch(ClassNotFoundException unused_ex) {
            jvmSystemFileSystem0 = new JvmSystemFileSystem();
        }
        FileSystem.SYSTEM = jvmSystemFileSystem0;
        q.f("/data/user/0/com.iloen.melon/cache", "getProperty(...)");
        FileSystem.SYSTEM_TEMPORARY_DIRECTORY = okio.Path.Companion.get$default(Path.Companion, "/data/user/0/com.iloen.melon/cache", false, 1, null);
        ClassLoader classLoader0 = ResourceFileSystem.class.getClassLoader();
        q.f(classLoader0, "getClassLoader(...)");
        FileSystem.RESOURCES = new ResourceFileSystem(classLoader0, false, null, 4, null);
    }

    @NotNull
    public final Sink appendingSink(@NotNull Path path0) {
        q.g(path0, "file");
        return this.appendingSink(path0, false);
    }

    @NotNull
    public abstract Sink appendingSink(@NotNull Path arg1, boolean arg2);

    public static Sink appendingSink$default(FileSystem fileSystem0, Path path0, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: appendingSink");
        }
        if((v & 2) != 0) {
            z = false;
        }
        return fileSystem0.appendingSink(path0, z);
    }

    public abstract void atomicMove(@NotNull Path arg1, @NotNull Path arg2);

    @NotNull
    public abstract Path canonicalize(@NotNull Path arg1);

    @Override
    public void close() {
    }

    public void copy(@NotNull Path path0, @NotNull Path path1) {
        q.g(path0, "source");
        q.g(path1, "target");
        -FileSystem.commonCopy(this, path0, path1);
    }

    public final void createDirectories(@NotNull Path path0) {
        q.g(path0, "dir");
        this.createDirectories(path0, false);
    }

    public final void createDirectories(@NotNull Path path0, boolean z) {
        q.g(path0, "dir");
        -FileSystem.commonCreateDirectories(this, path0, z);
    }

    public static void createDirectories$default(FileSystem fileSystem0, Path path0, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectories");
        }
        if((v & 2) != 0) {
            z = false;
        }
        fileSystem0.createDirectories(path0, z);
    }

    public final void createDirectory(@NotNull Path path0) {
        q.g(path0, "dir");
        this.createDirectory(path0, false);
    }

    public abstract void createDirectory(@NotNull Path arg1, boolean arg2);

    public static void createDirectory$default(FileSystem fileSystem0, Path path0, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectory");
        }
        if((v & 2) != 0) {
            z = false;
        }
        fileSystem0.createDirectory(path0, z);
    }

    public abstract void createSymlink(@NotNull Path arg1, @NotNull Path arg2);

    public final void delete(@NotNull Path path0) {
        q.g(path0, "path");
        this.delete(path0, false);
    }

    public abstract void delete(@NotNull Path arg1, boolean arg2);

    public static void delete$default(FileSystem fileSystem0, Path path0, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }
        if((v & 2) != 0) {
            z = false;
        }
        fileSystem0.delete(path0, z);
    }

    public final void deleteRecursively(@NotNull Path path0) {
        q.g(path0, "fileOrDirectory");
        this.deleteRecursively(path0, false);
    }

    public void deleteRecursively(@NotNull Path path0, boolean z) {
        q.g(path0, "fileOrDirectory");
        -FileSystem.commonDeleteRecursively(this, path0, z);
    }

    public static void deleteRecursively$default(FileSystem fileSystem0, Path path0, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteRecursively");
        }
        if((v & 2) != 0) {
            z = false;
        }
        fileSystem0.deleteRecursively(path0, z);
    }

    public final boolean exists(@NotNull Path path0) {
        q.g(path0, "path");
        return -FileSystem.commonExists(this, path0);
    }

    @NotNull
    public static final FileSystem get(@NotNull java.nio.file.FileSystem fileSystem0) {
        return FileSystem.Companion.get(fileSystem0);
    }

    @NotNull
    public abstract List list(@NotNull Path arg1);

    @Nullable
    public abstract List listOrNull(@NotNull Path arg1);

    @NotNull
    public final Sf.k listRecursively(@NotNull Path path0) {
        q.g(path0, "dir");
        return this.listRecursively(path0, false);
    }

    @NotNull
    public Sf.k listRecursively(@NotNull Path path0, boolean z) {
        q.g(path0, "dir");
        return -FileSystem.commonListRecursively(this, path0, z);
    }

    public static Sf.k listRecursively$default(FileSystem fileSystem0, Path path0, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listRecursively");
        }
        if((v & 2) != 0) {
            z = false;
        }
        return fileSystem0.listRecursively(path0, z);
    }

    @NotNull
    public final FileMetadata metadata(@NotNull Path path0) {
        q.g(path0, "path");
        return -FileSystem.commonMetadata(this, path0);
    }

    @Nullable
    public abstract FileMetadata metadataOrNull(@NotNull Path arg1);

    @NotNull
    public abstract FileHandle openReadOnly(@NotNull Path arg1);

    @NotNull
    public final FileHandle openReadWrite(@NotNull Path path0) {
        q.g(path0, "file");
        return this.openReadWrite(path0, false, false);
    }

    @NotNull
    public abstract FileHandle openReadWrite(@NotNull Path arg1, boolean arg2, boolean arg3);

    public static FileHandle openReadWrite$default(FileSystem fileSystem0, Path path0, boolean z, boolean z1, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openReadWrite");
        }
        if((v & 2) != 0) {
            z = false;
        }
        if((v & 4) != 0) {
            z1 = false;
        }
        return fileSystem0.openReadWrite(path0, z, z1);
    }

    @NotNull
    public final Sink sink(@NotNull Path path0) {
        q.g(path0, "file");
        return this.sink(path0, false);
    }

    @NotNull
    public abstract Sink sink(@NotNull Path arg1, boolean arg2);

    public static Sink sink$default(FileSystem fileSystem0, Path path0, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
        }
        if((v & 2) != 0) {
            z = false;
        }
        return fileSystem0.sink(path0, z);
    }

    @NotNull
    public abstract Source source(@NotNull Path arg1);
}

