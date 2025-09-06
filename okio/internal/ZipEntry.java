package okio.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b$\n\u0002\u0010!\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u00B1\u0001\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\t\u0012\b\b\u0002\u0010\n\u001A\u00020\t\u0012\b\b\u0002\u0010\u000B\u001A\u00020\t\u0012\b\b\u0002\u0010\f\u001A\u00020\r\u0012\b\b\u0002\u0010\u000E\u001A\u00020\t\u0012\b\b\u0002\u0010\u000F\u001A\u00020\r\u0012\b\b\u0002\u0010\u0010\u001A\u00020\r\u0012\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001A\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0016\u001A\u0004\u0018\u00010\r\u00A2\u0006\u0004\b\u0017\u0010\u0018J-\u00105\u001A\u00020\u00002\b\u0010\u0014\u001A\u0004\u0018\u00010\r2\b\u0010\u0015\u001A\u0004\u0018\u00010\r2\b\u0010\u0016\u001A\u0004\u0018\u00010\rH\u0000\u00A2\u0006\u0004\b6\u00107R\u0011\u0010\u0002\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u001AR\u0011\u0010\u0004\u001A\u00020\u0005\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\u001BR\u0011\u0010\u0006\u001A\u00020\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001DR\u0011\u0010\b\u001A\u00020\t\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001FR\u0011\u0010\n\u001A\u00020\t\u00A2\u0006\b\n\u0000\u001A\u0004\b \u0010\u001FR\u0011\u0010\u000B\u001A\u00020\t\u00A2\u0006\b\n\u0000\u001A\u0004\b!\u0010\u001FR\u0011\u0010\f\u001A\u00020\r\u00A2\u0006\b\n\u0000\u001A\u0004\b\"\u0010#R\u0011\u0010\u000E\u001A\u00020\t\u00A2\u0006\b\n\u0000\u001A\u0004\b$\u0010\u001FR\u0011\u0010\u000F\u001A\u00020\r\u00A2\u0006\b\n\u0000\u001A\u0004\b%\u0010#R\u0011\u0010\u0010\u001A\u00020\r\u00A2\u0006\b\n\u0000\u001A\u0004\b&\u0010#R\u0015\u0010\u0011\u001A\u0004\u0018\u00010\t\u00A2\u0006\n\n\u0002\u0010)\u001A\u0004\b\'\u0010(R\u0015\u0010\u0012\u001A\u0004\u0018\u00010\t\u00A2\u0006\n\n\u0002\u0010)\u001A\u0004\b*\u0010(R\u0015\u0010\u0013\u001A\u0004\u0018\u00010\t\u00A2\u0006\n\n\u0002\u0010)\u001A\u0004\b+\u0010(R\u0015\u0010\u0014\u001A\u0004\u0018\u00010\r\u00A2\u0006\n\n\u0002\u0010.\u001A\u0004\b,\u0010-R\u0015\u0010\u0015\u001A\u0004\u0018\u00010\r\u00A2\u0006\n\n\u0002\u0010.\u001A\u0004\b/\u0010-R\u0015\u0010\u0016\u001A\u0004\u0018\u00010\r\u00A2\u0006\n\n\u0002\u0010.\u001A\u0004\b0\u0010-R\u0017\u00101\u001A\b\u0012\u0004\u0012\u00020\u000302\u00A2\u0006\b\n\u0000\u001A\u0004\b3\u00104R\u0016\u00108\u001A\u0004\u0018\u00010\t8@X\u0080\u0004\u00A2\u0006\u0006\u001A\u0004\b9\u0010(R\u0016\u0010:\u001A\u0004\u0018\u00010\t8@X\u0080\u0004\u00A2\u0006\u0006\u001A\u0004\b;\u0010(R\u0016\u0010<\u001A\u0004\u0018\u00010\t8@X\u0080\u0004\u00A2\u0006\u0006\u001A\u0004\b=\u0010(\u00A8\u0006>"}, d2 = {"Lokio/internal/ZipEntry;", "", "canonicalPath", "Lokio/Path;", "isDirectory", "", "comment", "", "crc", "", "compressedSize", "size", "compressionMethod", "", "offset", "dosLastModifiedAtDate", "dosLastModifiedAtTime", "ntfsLastModifiedAtFiletime", "ntfsLastAccessedAtFiletime", "ntfsCreatedAtFiletime", "extendedLastModifiedAtSeconds", "extendedLastAccessedAtSeconds", "extendedCreatedAtSeconds", "<init>", "(Lokio/Path;ZLjava/lang/String;JJJIJIILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCanonicalPath", "()Lokio/Path;", "()Z", "getComment", "()Ljava/lang/String;", "getCrc", "()J", "getCompressedSize", "getSize", "getCompressionMethod", "()I", "getOffset", "getDosLastModifiedAtDate", "getDosLastModifiedAtTime", "getNtfsLastModifiedAtFiletime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getNtfsLastAccessedAtFiletime", "getNtfsCreatedAtFiletime", "getExtendedLastModifiedAtSeconds", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExtendedLastAccessedAtSeconds", "getExtendedCreatedAtSeconds", "children", "", "getChildren", "()Ljava/util/List;", "copy", "copy$okio", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lokio/internal/ZipEntry;", "lastAccessedAtMillis", "getLastAccessedAtMillis$okio", "lastModifiedAtMillis", "getLastModifiedAtMillis$okio", "createdAtMillis", "getCreatedAtMillis$okio", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class ZipEntry {
    @NotNull
    private final Path canonicalPath;
    @NotNull
    private final List children;
    @NotNull
    private final String comment;
    private final long compressedSize;
    private final int compressionMethod;
    private final long crc;
    private final int dosLastModifiedAtDate;
    private final int dosLastModifiedAtTime;
    @Nullable
    private final Integer extendedCreatedAtSeconds;
    @Nullable
    private final Integer extendedLastAccessedAtSeconds;
    @Nullable
    private final Integer extendedLastModifiedAtSeconds;
    private final boolean isDirectory;
    @Nullable
    private final Long ntfsCreatedAtFiletime;
    @Nullable
    private final Long ntfsLastAccessedAtFiletime;
    @Nullable
    private final Long ntfsLastModifiedAtFiletime;
    private final long offset;
    private final long size;

    public ZipEntry(@NotNull Path path0, boolean z, @NotNull String s, long v, long v1, long v2, int v3, long v4, int v5, int v6, @Nullable Long long0, @Nullable Long long1, @Nullable Long long2, @Nullable Integer integer0, @Nullable Integer integer1, @Nullable Integer integer2) {
        q.g(path0, "canonicalPath");
        q.g(s, "comment");
        super();
        this.canonicalPath = path0;
        this.isDirectory = z;
        this.comment = s;
        this.crc = v;
        this.compressedSize = v1;
        this.size = v2;
        this.compressionMethod = v3;
        this.offset = v4;
        this.dosLastModifiedAtDate = v5;
        this.dosLastModifiedAtTime = v6;
        this.ntfsLastModifiedAtFiletime = long0;
        this.ntfsLastAccessedAtFiletime = long1;
        this.ntfsCreatedAtFiletime = long2;
        this.extendedLastModifiedAtSeconds = integer0;
        this.extendedLastAccessedAtSeconds = integer1;
        this.extendedCreatedAtSeconds = integer2;
        this.children = new ArrayList();
    }

    public ZipEntry(Path path0, boolean z, String s, long v, long v1, long v2, int v3, long v4, int v5, int v6, Long long0, Long long1, Long long2, Integer integer0, Integer integer1, Integer integer2, int v7, DefaultConstructorMarker defaultConstructorMarker0) {
        Integer integer5;
        Integer integer4;
        long v8 = -1L;
        int v9 = -1;
        if((v7 & 0x80) == 0) {
            v8 = v4;
        }
        if((v7 & 0x200) == 0) {
            v9 = v6;
        }
        Integer integer3 = (v7 & 0x2000) == 0 ? integer0 : null;
        if((v7 & 0x8000) == 0) {
            integer4 = integer3;
            integer5 = integer2;
        }
        else {
            integer4 = integer3;
            integer5 = null;
        }
        this(path0, ((v7 & 2) == 0 ? z : false), ((v7 & 4) == 0 ? s : ""), ((v7 & 8) == 0 ? v : -1L), ((v7 & 16) == 0 ? v1 : -1L), ((v7 & 0x20) == 0 ? v2 : -1L), ((v7 & 0x40) == 0 ? v3 : -1), v8, ((v7 & 0x100) == 0 ? v5 : -1), v9, ((v7 & 0x400) == 0 ? long0 : null), ((v7 & 0x800) == 0 ? long1 : null), ((v7 & 0x1000) == 0 ? long2 : null), integer4, ((v7 & 0x4000) == 0 ? integer1 : null), integer5);
    }

    @NotNull
    public final ZipEntry copy$okio(@Nullable Integer integer0, @Nullable Integer integer1, @Nullable Integer integer2) {
        return new ZipEntry(this.canonicalPath, this.isDirectory, this.comment, this.crc, this.compressedSize, this.size, this.compressionMethod, this.offset, this.dosLastModifiedAtDate, this.dosLastModifiedAtTime, this.ntfsLastModifiedAtFiletime, this.ntfsLastAccessedAtFiletime, this.ntfsCreatedAtFiletime, integer0, integer1, integer2);
    }

    @NotNull
    public final Path getCanonicalPath() {
        return this.canonicalPath;
    }

    @NotNull
    public final List getChildren() {
        return this.children;
    }

    @NotNull
    public final String getComment() {
        return this.comment;
    }

    public final long getCompressedSize() {
        return this.compressedSize;
    }

    public final int getCompressionMethod() {
        return this.compressionMethod;
    }

    public final long getCrc() {
        return this.crc;
    }

    @Nullable
    public final Long getCreatedAtMillis$okio() {
        Long long0 = this.ntfsCreatedAtFiletime;
        if(long0 != null) {
            return ZipFilesKt.filetimeToEpochMillis(((long)long0));
        }
        return this.extendedCreatedAtSeconds == null ? null : ((long)(((long)(((int)this.extendedCreatedAtSeconds))) * 1000L));
    }

    public final int getDosLastModifiedAtDate() {
        return this.dosLastModifiedAtDate;
    }

    public final int getDosLastModifiedAtTime() {
        return this.dosLastModifiedAtTime;
    }

    @Nullable
    public final Integer getExtendedCreatedAtSeconds() {
        return this.extendedCreatedAtSeconds;
    }

    @Nullable
    public final Integer getExtendedLastAccessedAtSeconds() {
        return this.extendedLastAccessedAtSeconds;
    }

    @Nullable
    public final Integer getExtendedLastModifiedAtSeconds() {
        return this.extendedLastModifiedAtSeconds;
    }

    @Nullable
    public final Long getLastAccessedAtMillis$okio() {
        Long long0 = this.ntfsLastAccessedAtFiletime;
        if(long0 != null) {
            return ZipFilesKt.filetimeToEpochMillis(((long)long0));
        }
        return this.extendedLastAccessedAtSeconds == null ? null : ((long)(((long)(((int)this.extendedLastAccessedAtSeconds))) * 1000L));
    }

    @Nullable
    public final Long getLastModifiedAtMillis$okio() {
        Long long0 = this.ntfsLastModifiedAtFiletime;
        if(long0 != null) {
            return ZipFilesKt.filetimeToEpochMillis(((long)long0));
        }
        Integer integer0 = this.extendedLastModifiedAtSeconds;
        if(integer0 != null) {
            return (long)(((long)(((int)integer0))) * 1000L);
        }
        return this.dosLastModifiedAtTime == -1 ? null : ZipFilesKt.dosDateTimeToEpochMillis(this.dosLastModifiedAtDate, this.dosLastModifiedAtTime);
    }

    @Nullable
    public final Long getNtfsCreatedAtFiletime() {
        return this.ntfsCreatedAtFiletime;
    }

    @Nullable
    public final Long getNtfsLastAccessedAtFiletime() {
        return this.ntfsLastAccessedAtFiletime;
    }

    @Nullable
    public final Long getNtfsLastModifiedAtFiletime() {
        return this.ntfsLastModifiedAtFiletime;
    }

    public final long getOffset() {
        return this.offset;
    }

    public final long getSize() {
        return this.size;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }
}

