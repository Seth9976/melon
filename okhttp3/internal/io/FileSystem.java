package okhttp3.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okio.Okio;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\bf\u0018\u0000 \u001A2\u00020\u0001:\u0001\u001AJ\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001A\u00020\u00072\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001A\u00020\u00072\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0013J\u001F\u0010\u0016\u001A\u00020\u000B2\u0006\u0010\u0014\u001A\u00020\u00022\u0006\u0010\u0015\u001A\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001A\u00020\u000B2\u0006\u0010\u0018\u001A\u00020\u0002H&¢\u0006\u0004\b\u0019\u0010\r¨\u0006\u001B"}, d2 = {"Lokhttp3/internal/io/FileSystem;", "", "Ljava/io/File;", "file", "Lokio/Source;", "source", "(Ljava/io/File;)Lokio/Source;", "Lokio/Sink;", "sink", "(Ljava/io/File;)Lokio/Sink;", "appendingSink", "Lie/H;", "delete", "(Ljava/io/File;)V", "", "exists", "(Ljava/io/File;)Z", "", "size", "(Ljava/io/File;)J", "from", "to", "rename", "(Ljava/io/File;Ljava/io/File;)V", "directory", "deleteContents", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public interface FileSystem {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0006"}, d2 = {"Lokhttp3/internal/io/FileSystem$Companion;", "", "()V", "SYSTEM", "Lokhttp3/internal/io/FileSystem;", "SystemFileSystem", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\f\u001A\u00020\t2\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u000BJ\u0017\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001F\u0010\u0018\u001A\u00020\r2\u0006\u0010\u0016\u001A\u00020\u00042\u0006\u0010\u0017\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001B\u001A\u00020\r2\u0006\u0010\u001A\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u001B\u0010\u000FJ\u000F\u0010\u001D\u001A\u00020\u001CH\u0016¢\u0006\u0004\b\u001D\u0010\u001E¨\u0006\u001F"}, d2 = {"Lokhttp3/internal/io/FileSystem$Companion$SystemFileSystem;", "Lokhttp3/internal/io/FileSystem;", "<init>", "()V", "Ljava/io/File;", "file", "Lokio/Source;", "source", "(Ljava/io/File;)Lokio/Source;", "Lokio/Sink;", "sink", "(Ljava/io/File;)Lokio/Sink;", "appendingSink", "Lie/H;", "delete", "(Ljava/io/File;)V", "", "exists", "(Ljava/io/File;)Z", "", "size", "(Ljava/io/File;)J", "from", "to", "rename", "(Ljava/io/File;Ljava/io/File;)V", "directory", "deleteContents", "", "toString", "()Ljava/lang/String;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        static final class SystemFileSystem implements FileSystem {
            @Override  // okhttp3.internal.io.FileSystem
            @NotNull
            public Sink appendingSink(@NotNull File file0) {
                q.g(file0, "file");
                try {
                    return Okio.appendingSink(file0);
                }
                catch(FileNotFoundException unused_ex) {
                    file0.getParentFile().mkdirs();
                    return Okio.appendingSink(file0);
                }
            }

            @Override  // okhttp3.internal.io.FileSystem
            public void delete(@NotNull File file0) {
                q.g(file0, "file");
                if(!file0.delete() && file0.exists()) {
                    throw new IOException("failed to delete " + file0);
                }
            }

            @Override  // okhttp3.internal.io.FileSystem
            public void deleteContents(@NotNull File file0) {
                q.g(file0, "directory");
                File[] arr_file = file0.listFiles();
                if(arr_file == null) {
                    throw new IOException("not a readable directory: " + file0);
                }
                for(int v = 0; v < arr_file.length; ++v) {
                    File file1 = arr_file[v];
                    if(file1.isDirectory()) {
                        this.deleteContents(file1);
                    }
                    if(!file1.delete()) {
                        throw new IOException("failed to delete " + file1);
                    }
                }
            }

            @Override  // okhttp3.internal.io.FileSystem
            public boolean exists(@NotNull File file0) {
                q.g(file0, "file");
                return file0.exists();
            }

            @Override  // okhttp3.internal.io.FileSystem
            public void rename(@NotNull File file0, @NotNull File file1) {
                q.g(file0, "from");
                q.g(file1, "to");
                this.delete(file1);
                if(!file0.renameTo(file1)) {
                    throw new IOException("failed to rename " + file0 + " to " + file1);
                }
            }

            @Override  // okhttp3.internal.io.FileSystem
            @NotNull
            public Sink sink(@NotNull File file0) {
                q.g(file0, "file");
                try {
                    return Okio.sink$default(file0, false, 1, null);
                }
                catch(FileNotFoundException unused_ex) {
                    file0.getParentFile().mkdirs();
                    return Okio.sink$default(file0, false, 1, null);
                }
            }

            @Override  // okhttp3.internal.io.FileSystem
            public long size(@NotNull File file0) {
                q.g(file0, "file");
                return file0.length();
            }

            @Override  // okhttp3.internal.io.FileSystem
            @NotNull
            public Source source(@NotNull File file0) {
                q.g(file0, "file");
                return Okio.source(file0);
            }

            @Override
            @NotNull
            public String toString() {
                return "FileSystem.SYSTEM";
            }
        }

        static final Companion $$INSTANCE;

        static {
            Companion.$$INSTANCE = new Companion();
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    public static final FileSystem SYSTEM;

    static {
        FileSystem.Companion = Companion.$$INSTANCE;
        FileSystem.SYSTEM = new SystemFileSystem();
    }

    @NotNull
    Sink appendingSink(@NotNull File arg1);

    void delete(@NotNull File arg1);

    void deleteContents(@NotNull File arg1);

    boolean exists(@NotNull File arg1);

    void rename(@NotNull File arg1, @NotNull File arg2);

    @NotNull
    Sink sink(@NotNull File arg1);

    long size(@NotNull File arg1);

    @NotNull
    Source source(@NotNull File arg1);
}

