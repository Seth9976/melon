package okio;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okio.internal.-Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001/B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u001E\u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020\rH\u0087\u0002\u00A2\u0006\u0002\b J\u0016\u0010\u001E\u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020\u0003H\u0087\u0002\u00A2\u0006\u0002\b J\u0016\u0010\u001E\u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020\u0000H\u0087\u0002\u00A2\u0006\u0002\b J\u0018\u0010 \u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020\r2\b\b\u0002\u0010!\u001A\u00020\u0013J\u0018\u0010 \u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020\u00032\b\b\u0002\u0010!\u001A\u00020\u0013J\u0018\u0010 \u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020\u00002\b\b\u0002\u0010!\u001A\u00020\u0013J\u000E\u0010\"\u001A\u00020\u00002\u0006\u0010#\u001A\u00020\u0000J\u0006\u0010$\u001A\u00020\u0000J\u0006\u0010%\u001A\u00020&J\u0006\u0010\'\u001A\u00020(J\u0011\u0010)\u001A\u00020*2\u0006\u0010#\u001A\u00020\u0000H\u0096\u0002J\u0013\u0010+\u001A\u00020\u00132\b\u0010#\u001A\u0004\u0018\u00010,H\u0096\u0002J\b\u0010-\u001A\u00020*H\u0016J\b\u0010.\u001A\u00020\rH\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001A\u0004\u0018\u00010\u00008F\u00A2\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0017\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\f8F\u00A2\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0017\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00030\f8F\u00A2\u0006\u0006\u001A\u0004\b\u0011\u0010\u000FR\u0011\u0010\u0012\u001A\u00020\u00138F\u00A2\u0006\u0006\u001A\u0004\b\u0012\u0010\u0014R\u0011\u0010\u0015\u001A\u00020\u00138F\u00A2\u0006\u0006\u001A\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0016\u001A\u0004\u0018\u00010\u00178G\u00A2\u0006\u0006\u001A\u0004\b\u0016\u0010\u0018R\u0011\u0010\u0019\u001A\u00020\u00038G\u00A2\u0006\u0006\u001A\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001A\u001A\u00020\r8G\u00A2\u0006\u0006\u001A\u0004\b\u001A\u0010\u001BR\u0013\u0010\u001C\u001A\u0004\u0018\u00010\u00008G\u00A2\u0006\u0006\u001A\u0004\b\u001C\u0010\nR\u0011\u0010\u001D\u001A\u00020\u00138F\u00A2\u0006\u0006\u001A\u0004\b\u001D\u0010\u0014\u00A8\u00060"}, d2 = {"Lokio/Path;", "", "bytes", "Lokio/ByteString;", "<init>", "(Lokio/ByteString;)V", "getBytes$okio", "()Lokio/ByteString;", "root", "getRoot", "()Lokio/Path;", "segments", "", "", "getSegments", "()Ljava/util/List;", "segmentsBytes", "getSegmentsBytes", "isAbsolute", "", "()Z", "isRelative", "volumeLetter", "", "()Ljava/lang/Character;", "nameBytes", "name", "()Ljava/lang/String;", "parent", "isRoot", "div", "child", "resolve", "normalize", "relativeTo", "other", "normalized", "toFile", "Ljava/io/File;", "toNioPath", "Ljava/nio/file/Path;", "compareTo", "", "equals", "", "hashCode", "toString", "Companion", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class Path implements Comparable {
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\u0006\u001A\u00020\u0007*\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\tH\u0007¢\u0006\u0002\b\nJ\u001B\u0010\u000B\u001A\u00020\u0007*\u00020\f2\b\b\u0002\u0010\b\u001A\u00020\tH\u0007¢\u0006\u0002\b\nJ\u001B\u0010\u000B\u001A\u00020\u0007*\u00020\r2\b\b\u0002\u0010\b\u001A\u00020\tH\u0007¢\u0006\u0002\b\nR\u0010\u0010\u0004\u001A\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lokio/Path$Companion;", "", "<init>", "()V", "DIRECTORY_SEPARATOR", "", "toPath", "Lokio/Path;", "normalize", "", "get", "toOkioPath", "Ljava/io/File;", "Ljava/nio/file/Path;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final Path get(@NotNull File file0) {
            q.g(file0, "<this>");
            return Companion.get$default(this, file0, false, 1, null);
        }

        @NotNull
        public final Path get(@NotNull File file0, boolean z) {
            q.g(file0, "<this>");
            String s = file0.toString();
            q.f(s, "toString(...)");
            return this.get(s, z);
        }

        @NotNull
        public final Path get(@NotNull String s) {
            q.g(s, "<this>");
            return Companion.get$default(this, s, false, 1, null);
        }

        @NotNull
        public final Path get(@NotNull String s, boolean z) {
            q.g(s, "<this>");
            return -Path.commonToPath(s, z);
        }

        @NotNull
        public final Path get(@NotNull java.nio.file.Path path0) {
            q.g(path0, "<this>");
            return Companion.get$default(this, path0, false, 1, null);
        }

        @NotNull
        public final Path get(@NotNull java.nio.file.Path path0, boolean z) {
            q.g(path0, "<this>");
            return this.get(path0.toString(), z);
        }

        public static Path get$default(Companion path$Companion0, File file0, boolean z, int v, Object object0) {
            if((v & 1) != 0) {
                z = false;
            }
            return path$Companion0.get(file0, z);
        }

        public static Path get$default(Companion path$Companion0, String s, boolean z, int v, Object object0) {
            if((v & 1) != 0) {
                z = false;
            }
            return path$Companion0.get(s, z);
        }

        public static Path get$default(Companion path$Companion0, java.nio.file.Path path0, boolean z, int v, Object object0) {
            if((v & 1) != 0) {
                z = false;
            }
            return path$Companion0.get(path0, z);
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    public static final String DIRECTORY_SEPARATOR;
    @NotNull
    private final ByteString bytes;

    static {
        Path.Companion = new Companion(null);
        q.f("/", "separator");
        Path.DIRECTORY_SEPARATOR = "/";
    }

    public Path(@NotNull ByteString byteString0) {
        q.g(byteString0, "bytes");
        super();
        this.bytes = byteString0;
    }

    @Override
    public int compareTo(Object object0) {
        return this.compareTo(((Path)object0));
    }

    public int compareTo(@NotNull Path path0) {
        q.g(path0, "other");
        return this.getBytes$okio().compareTo(path0.getBytes$okio());
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(@Nullable Object object0) {
        return object0 instanceof Path && q.b(((Path)object0).getBytes$okio(), this.getBytes$okio());
    }

    @NotNull
    public static final Path get(@NotNull File file0) {
        return Path.Companion.get(file0);
    }

    @NotNull
    public static final Path get(@NotNull File file0, boolean z) {
        return Path.Companion.get(file0, z);
    }

    @NotNull
    public static final Path get(@NotNull String s) {
        return Path.Companion.get(s);
    }

    @NotNull
    public static final Path get(@NotNull String s, boolean z) {
        return Path.Companion.get(s, z);
    }

    @NotNull
    public static final Path get(@NotNull java.nio.file.Path path0) {
        return Path.Companion.get(path0);
    }

    @NotNull
    public static final Path get(@NotNull java.nio.file.Path path0, boolean z) {
        return Path.Companion.get(path0, z);
    }

    @NotNull
    public final ByteString getBytes$okio() {
        return this.bytes;
    }

    @Nullable
    public final Path getRoot() {
        int v = -Path.access$rootLength(this);
        return v == -1 ? null : new Path(this.getBytes$okio().substring(0, v));
    }

    @NotNull
    public final List getSegments() {
        ArrayList arrayList0 = new ArrayList();
        int v = -Path.access$rootLength(this);
        if(v == -1) {
            v = 0;
        }
        else if(v < this.getBytes$okio().size() && this.getBytes$okio().getByte(v) == 92) {
            ++v;
        }
        int v1 = this.getBytes$okio().size();
        int v2 = v;
        while(v < v1) {
            switch(this.getBytes$okio().getByte(v)) {
                case 0x2F: 
                case 92: {
                    arrayList0.add(this.getBytes$okio().substring(v2, v));
                    v2 = v + 1;
                }
            }
            ++v;
        }
        if(v2 < this.getBytes$okio().size()) {
            arrayList0.add(this.getBytes$okio().substring(v2, this.getBytes$okio().size()));
        }
        List list0 = new ArrayList(je.q.Q(10, arrayList0));
        for(Object object0: arrayList0) {
            list0.add(((ByteString)object0).utf8());
        }
        return list0;
    }

    @NotNull
    public final List getSegmentsBytes() {
        List list0 = new ArrayList();
        int v = -Path.access$rootLength(this);
        if(v == -1) {
            v = 0;
        }
        else if(v < this.getBytes$okio().size() && this.getBytes$okio().getByte(v) == 92) {
            ++v;
        }
        int v1 = this.getBytes$okio().size();
        int v2 = v;
        while(v < v1) {
            switch(this.getBytes$okio().getByte(v)) {
                case 0x2F: 
                case 92: {
                    list0.add(this.getBytes$okio().substring(v2, v));
                    v2 = v + 1;
                }
            }
            ++v;
        }
        if(v2 < this.getBytes$okio().size()) {
            list0.add(this.getBytes$okio().substring(v2, this.getBytes$okio().size()));
        }
        return list0;
    }

    @Override
    public int hashCode() {
        return this.getBytes$okio().hashCode();
    }

    public final boolean isAbsolute() {
        return -Path.access$rootLength(this) != -1;
    }

    public final boolean isRelative() {
        return -Path.access$rootLength(this) == -1;
    }

    public final boolean isRoot() {
        return -Path.access$rootLength(this) == this.getBytes$okio().size();
    }

    @NotNull
    public final String name() {
        return this.nameBytes().utf8();
    }

    @NotNull
    public final ByteString nameBytes() {
        int v = -Path.access$getIndexOfLastSlash(this);
        if(v != -1) {
            return ByteString.substring$default(this.getBytes$okio(), v + 1, 0, 2, null);
        }
        return this.volumeLetter() == null || this.getBytes$okio().size() != 2 ? this.getBytes$okio() : ByteString.EMPTY;
    }

    @NotNull
    public final Path normalized() {
        return Path.Companion.get(this.toString(), true);
    }

    @Nullable
    public final Path parent() {
        if(!q.b(this.getBytes$okio(), -Path.access$getDOT$p()) && !q.b(this.getBytes$okio(), -Path.access$getSLASH$p()) && !q.b(this.getBytes$okio(), -Path.access$getBACKSLASH$p()) && !-Path.access$lastSegmentIsDotDot(this)) {
            int v = -Path.access$getIndexOfLastSlash(this);
            if(v == 2 && this.volumeLetter() != null) {
                return this.getBytes$okio().size() == 3 ? null : new Path(ByteString.substring$default(this.getBytes$okio(), 0, 3, 1, null));
            }
            if(v == 1 && this.getBytes$okio().startsWith(-Path.access$getBACKSLASH$p())) {
                return null;
            }
            if(v == -1 && this.volumeLetter() != null) {
                return this.getBytes$okio().size() == 2 ? null : new Path(ByteString.substring$default(this.getBytes$okio(), 0, 2, 1, null));
            }
            if(v == -1) {
                return new Path(-Path.access$getDOT$p());
            }
            return v == 0 ? new Path(ByteString.substring$default(this.getBytes$okio(), 0, 1, 1, null)) : new Path(ByteString.substring$default(this.getBytes$okio(), 0, v, 1, null));
        }
        return null;
    }

    @NotNull
    public final Path relativeTo(@NotNull Path path0) {
        q.g(path0, "other");
        if(!q.b(this.getRoot(), path0.getRoot())) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + path0).toString());
        }
        List list0 = this.getSegmentsBytes();
        List list1 = path0.getSegmentsBytes();
        int v = Math.min(list0.size(), list1.size());
        int v1;
        for(v1 = 0; v1 < v && q.b(list0.get(v1), list1.get(v1)); ++v1) {
        }
        if(v1 == v && this.getBytes$okio().size() == path0.getBytes$okio().size()) {
            return Companion.get$default(Path.Companion, ".", false, 1, null);
        }
        if(list1.subList(v1, list1.size()).indexOf(-Path.access$getDOT_DOT$p()) != -1) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + path0).toString());
        }
        if(q.b(path0.getBytes$okio(), -Path.access$getDOT$p())) {
            return this;
        }
        Buffer buffer0 = new Buffer();
        ByteString byteString0 = -Path.access$getSlash(path0);
        if(byteString0 == null) {
            byteString0 = -Path.access$getSlash(this);
            if(byteString0 == null) {
                byteString0 = -Path.access$toSlash("/");
            }
        }
        int v2 = list1.size();
        for(int v3 = v1; v3 < v2; ++v3) {
            buffer0.write(-Path.access$getDOT_DOT$p());
            buffer0.write(byteString0);
        }
        int v4 = list0.size();
        while(v1 < v4) {
            buffer0.write(((ByteString)list0.get(v1)));
            buffer0.write(byteString0);
            ++v1;
        }
        return -Path.toPath(buffer0, false);
    }

    @NotNull
    public final Path resolve(@NotNull String s) {
        q.g(s, "child");
        return -Path.commonResolve(this, -Path.toPath(new Buffer().writeUtf8(s), false), false);
    }

    @NotNull
    public final Path resolve(@NotNull String s, boolean z) {
        q.g(s, "child");
        return -Path.commonResolve(this, -Path.toPath(new Buffer().writeUtf8(s), false), z);
    }

    @NotNull
    public final Path resolve(@NotNull ByteString byteString0) {
        q.g(byteString0, "child");
        return -Path.commonResolve(this, -Path.toPath(new Buffer().write(byteString0), false), false);
    }

    @NotNull
    public final Path resolve(@NotNull ByteString byteString0, boolean z) {
        q.g(byteString0, "child");
        return -Path.commonResolve(this, -Path.toPath(new Buffer().write(byteString0), false), z);
    }

    @NotNull
    public final Path resolve(@NotNull Path path0) {
        q.g(path0, "child");
        return -Path.commonResolve(this, path0, false);
    }

    @NotNull
    public final Path resolve(@NotNull Path path0, boolean z) {
        q.g(path0, "child");
        return -Path.commonResolve(this, path0, z);
    }

    public static Path resolve$default(Path path0, String s, boolean z, int v, Object object0) {
        if((v & 2) != 0) {
            z = false;
        }
        return path0.resolve(s, z);
    }

    public static Path resolve$default(Path path0, ByteString byteString0, boolean z, int v, Object object0) {
        if((v & 2) != 0) {
            z = false;
        }
        return path0.resolve(byteString0, z);
    }

    public static Path resolve$default(Path path0, Path path1, boolean z, int v, Object object0) {
        if((v & 2) != 0) {
            z = false;
        }
        return path0.resolve(path1, z);
    }

    @NotNull
    public final File toFile() {
        return new File(this.toString());
    }

    @NotNull
    public final java.nio.file.Path toNioPath() {
        java.nio.file.Path path0 = Paths.get(this.toString(), new String[0]);
        q.f(path0, "get(...)");
        return path0;
    }

    @Override
    @NotNull
    public String toString() {
        return this.getBytes$okio().utf8();
    }

    @Nullable
    public final Character volumeLetter() {
        if(ByteString.indexOf$default(this.getBytes$okio(), -Path.access$getSLASH$p(), 0, 2, null) != -1) {
            return null;
        }
        if(this.getBytes$okio().size() < 2) {
            return null;
        }
        if(this.getBytes$okio().getByte(1) != 58) {
            return null;
        }
        int v = (char)this.getBytes$okio().getByte(0);
        return (97 > v || v >= 0x7B) && (65 > v || v >= 91) ? null : Character.valueOf(((char)v));
    }
}

