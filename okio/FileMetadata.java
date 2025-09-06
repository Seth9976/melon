package okio;

import De.d;
import P4.a;
import java.util.ArrayList;
import java.util.Map;
import je.C;
import je.p;
import je.x;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0011\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0007\u0012\u0018\b\u0002\u0010\u000E\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u00010\f\u00A2\u0006\u0004\b\u000F\u0010\u0010J)\u0010\u0013\u001A\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0011*\u00020\u00012\u000E\u0010\u0012\u001A\n\u0012\u0006\b\u0001\u0012\u00028\u00000\r\u00A2\u0006\u0004\b\u0013\u0010\u0014Jw\u0010\u0015\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00022\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u00072\u0018\b\u0002\u0010\u000E\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u00010\f\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u000F\u0010\u0018\u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0003\u0010\u001A\u001A\u0004\b\u0003\u0010\u001BR\u0017\u0010\u0004\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0004\u0010\u001A\u001A\u0004\b\u0004\u0010\u001BR\u0019\u0010\u0006\u001A\u0004\u0018\u00010\u00058\u0006\u00A2\u0006\f\n\u0004\b\u0006\u0010\u001C\u001A\u0004\b\u001D\u0010\u001ER\u0019\u0010\b\u001A\u0004\u0018\u00010\u00078\u0006\u00A2\u0006\f\n\u0004\b\b\u0010\u001F\u001A\u0004\b \u0010!R\u0019\u0010\t\u001A\u0004\u0018\u00010\u00078\u0006\u00A2\u0006\f\n\u0004\b\t\u0010\u001F\u001A\u0004\b\"\u0010!R\u0019\u0010\n\u001A\u0004\u0018\u00010\u00078\u0006\u00A2\u0006\f\n\u0004\b\n\u0010\u001F\u001A\u0004\b#\u0010!R\u0019\u0010\u000B\u001A\u0004\u0018\u00010\u00078\u0006\u00A2\u0006\f\n\u0004\b\u000B\u0010\u001F\u001A\u0004\b$\u0010!R\'\u0010\u000E\u001A\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u00010\f8\u0006\u00A2\u0006\f\n\u0004\b\u000E\u0010%\u001A\u0004\b&\u0010\'\u00A8\u0006("}, d2 = {"Lokio/FileMetadata;", "", "", "isRegularFile", "isDirectory", "Lokio/Path;", "symlinkTarget", "", "size", "createdAtMillis", "lastModifiedAtMillis", "lastAccessedAtMillis", "", "LDe/d;", "extras", "<init>", "(ZZLokio/Path;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)V", "T", "type", "extra", "(LDe/d;)Ljava/lang/Object;", "copy", "(ZZLokio/Path;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)Lokio/FileMetadata;", "", "toString", "()Ljava/lang/String;", "Z", "()Z", "Lokio/Path;", "getSymlinkTarget", "()Lokio/Path;", "Ljava/lang/Long;", "getSize", "()Ljava/lang/Long;", "getCreatedAtMillis", "getLastModifiedAtMillis", "getLastAccessedAtMillis", "Ljava/util/Map;", "getExtras", "()Ljava/util/Map;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class FileMetadata {
    @Nullable
    private final Long createdAtMillis;
    @NotNull
    private final Map extras;
    private final boolean isDirectory;
    private final boolean isRegularFile;
    @Nullable
    private final Long lastAccessedAtMillis;
    @Nullable
    private final Long lastModifiedAtMillis;
    @Nullable
    private final Long size;
    @Nullable
    private final Path symlinkTarget;

    public FileMetadata() {
        this(false, false, null, null, null, null, null, null, 0xFF, null);
    }

    public FileMetadata(boolean z, boolean z1, @Nullable Path path0, @Nullable Long long0, @Nullable Long long1, @Nullable Long long2, @Nullable Long long3, @NotNull Map map0) {
        q.g(map0, "extras");
        super();
        this.isRegularFile = z;
        this.isDirectory = z1;
        this.symlinkTarget = path0;
        this.size = long0;
        this.createdAtMillis = long1;
        this.lastModifiedAtMillis = long2;
        this.lastAccessedAtMillis = long3;
        this.extras = C.Z(map0);
    }

    public FileMetadata(boolean z, boolean z1, Path path0, Long long0, Long long1, Long long2, Long long3, Map map0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            z = false;
        }
        if((v & 2) != 0) {
            z1 = false;
        }
        if((v & 4) != 0) {
            path0 = null;
        }
        if((v & 8) != 0) {
            long0 = null;
        }
        if((v & 16) != 0) {
            long1 = null;
        }
        if((v & 0x20) != 0) {
            long2 = null;
        }
        if((v & 0x40) != 0) {
            long3 = null;
        }
        if((v & 0x80) != 0) {
            map0 = x.a;
        }
        this(z, z1, path0, long0, long1, long2, long3, map0);
    }

    @NotNull
    public final FileMetadata copy(boolean z, boolean z1, @Nullable Path path0, @Nullable Long long0, @Nullable Long long1, @Nullable Long long2, @Nullable Long long3, @NotNull Map map0) {
        q.g(map0, "extras");
        return new FileMetadata(z, z1, path0, long0, long1, long2, long3, map0);
    }

    public static FileMetadata copy$default(FileMetadata fileMetadata0, boolean z, boolean z1, Path path0, Long long0, Long long1, Long long2, Long long3, Map map0, int v, Object object0) {
        if((v & 1) != 0) {
            z = fileMetadata0.isRegularFile;
        }
        if((v & 2) != 0) {
            z1 = fileMetadata0.isDirectory;
        }
        if((v & 4) != 0) {
            path0 = fileMetadata0.symlinkTarget;
        }
        if((v & 8) != 0) {
            long0 = fileMetadata0.size;
        }
        if((v & 16) != 0) {
            long1 = fileMetadata0.createdAtMillis;
        }
        if((v & 0x20) != 0) {
            long2 = fileMetadata0.lastModifiedAtMillis;
        }
        if((v & 0x40) != 0) {
            long3 = fileMetadata0.lastAccessedAtMillis;
        }
        if((v & 0x80) != 0) {
            map0 = fileMetadata0.extras;
        }
        return fileMetadata0.copy(z, z1, path0, long0, long1, long2, long3, map0);
    }

    @Nullable
    public final Object extra(@NotNull d d0) {
        q.g(d0, "type");
        Object object0 = this.extras.get(d0);
        if(object0 == null) {
            return null;
        }
        a.f(d0, object0);
        return object0;
    }

    @Nullable
    public final Long getCreatedAtMillis() {
        return this.createdAtMillis;
    }

    @NotNull
    public final Map getExtras() {
        return this.extras;
    }

    @Nullable
    public final Long getLastAccessedAtMillis() {
        return this.lastAccessedAtMillis;
    }

    @Nullable
    public final Long getLastModifiedAtMillis() {
        return this.lastModifiedAtMillis;
    }

    @Nullable
    public final Long getSize() {
        return this.size;
    }

    @Nullable
    public final Path getSymlinkTarget() {
        return this.symlinkTarget;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    public final boolean isRegularFile() {
        return this.isRegularFile;
    }

    @Override
    @NotNull
    public String toString() {
        ArrayList arrayList0 = new ArrayList();
        if(this.isRegularFile) {
            arrayList0.add("isRegularFile");
        }
        if(this.isDirectory) {
            arrayList0.add("isDirectory");
        }
        if(this.size != null) {
            arrayList0.add("byteCount=" + this.size);
        }
        if(this.createdAtMillis != null) {
            arrayList0.add("createdAt=" + this.createdAtMillis);
        }
        if(this.lastModifiedAtMillis != null) {
            arrayList0.add("lastModifiedAt=" + this.lastModifiedAtMillis);
        }
        if(this.lastAccessedAtMillis != null) {
            arrayList0.add("lastAccessedAt=" + this.lastAccessedAtMillis);
        }
        if(!this.extras.isEmpty()) {
            arrayList0.add("extras=" + this.extras);
        }
        return p.q0(arrayList0, ", ", "FileMetadata(", ")", null, 56);
    }
}

