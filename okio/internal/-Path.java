package okio.internal;

import e.k;
import java.util.ArrayList;
import java.util.List;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okio.Buffer;
import okio.ByteString;
import okio.Path.Companion;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0002\u001A\u000F\u0010\u0006\u001A\u0004\u0018\u00010\u0007*\u00020\u0007H\u0080\b\u001A\u0013\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t*\u00020\u0007H\u0080\b\u001A\u0013\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00010\t*\u00020\u0007H\u0080\b\u001A\f\u0010\f\u001A\u00020\r*\u00020\u0007H\u0002\u001A\r\u0010\u000E\u001A\u00020\u000F*\u00020\u0007H\u0080\b\u001A\r\u0010\u0010\u001A\u00020\u000F*\u00020\u0007H\u0080\b\u001A\u0014\u0010\u0011\u001A\u0004\u0018\u00010\u0012*\u00020\u0007H\u0080\b\u00A2\u0006\u0002\u0010\u0013\u001A\r\u0010\u0017\u001A\u00020\u0001*\u00020\u0007H\u0080\b\u001A\r\u0010\u0018\u001A\u00020\n*\u00020\u0007H\u0080\b\u001A\u000F\u0010\u0019\u001A\u0004\u0018\u00010\u0007*\u00020\u0007H\u0080\b\u001A\f\u0010\u001A\u001A\u00020\u000F*\u00020\u0007H\u0002\u001A\r\u0010\u001B\u001A\u00020\u000F*\u00020\u0007H\u0080\b\u001A\u001D\u0010\u001C\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\u001D\u001A\u00020\n2\u0006\u0010\u001E\u001A\u00020\u000FH\u0080\b\u001A\u001D\u0010\u001C\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\u001D\u001A\u00020\u00012\u0006\u0010\u001E\u001A\u00020\u000FH\u0080\b\u001A\u001D\u0010\u001C\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\u001D\u001A\u00020\u001F2\u0006\u0010\u001E\u001A\u00020\u000FH\u0080\b\u001A\u001C\u0010\u001C\u001A\u00020\u0007*\u00020\u00072\u0006\u0010\u001D\u001A\u00020\u00072\u0006\u0010\u001E\u001A\u00020\u000FH\u0000\u001A\u0015\u0010 \u001A\u00020\u0007*\u00020\u00072\u0006\u0010!\u001A\u00020\u0007H\u0080\b\u001A\r\u0010\"\u001A\u00020\u0007*\u00020\u0007H\u0080\b\u001A\u0015\u0010&\u001A\u00020\r*\u00020\u00072\u0006\u0010!\u001A\u00020\u0007H\u0080\b\u001A\u0017\u0010\'\u001A\u00020\u000F*\u00020\u00072\b\u0010!\u001A\u0004\u0018\u00010(H\u0080\b\u001A\r\u0010)\u001A\u00020\r*\u00020\u0007H\u0080\b\u001A\r\u0010*\u001A\u00020\n*\u00020\u0007H\u0080\b\u001A\u0014\u0010+\u001A\u00020\u0007*\u00020\n2\u0006\u0010\u001E\u001A\u00020\u000FH\u0000\u001A\u0014\u0010,\u001A\u00020\u0007*\u00020\u001F2\u0006\u0010\u001E\u001A\u00020\u000FH\u0000\u001A\f\u0010-\u001A\u00020\u0001*\u00020\nH\u0002\u001A\f\u0010-\u001A\u00020\u0001*\u00020.H\u0002\u001A\u0014\u0010/\u001A\u00020\u000F*\u00020\u001F2\u0006\u0010#\u001A\u00020\u0001H\u0002\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004\u00A2\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082\u0004\u00A2\u0006\u0002\n\u0000\"\u000E\u0010\u0003\u001A\u00020\u0001X\u0082\u0004\u00A2\u0006\u0002\n\u0000\"\u000E\u0010\u0004\u001A\u00020\u0001X\u0082\u0004\u00A2\u0006\u0002\n\u0000\"\u000E\u0010\u0005\u001A\u00020\u0001X\u0082\u0004\u00A2\u0006\u0002\n\u0000\"\u0018\u0010\u0014\u001A\u00020\r*\u00020\u00078BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016\"\u001A\u0010#\u001A\u0004\u0018\u00010\u0001*\u00020\u00078BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b$\u0010%\u00A8\u00060"}, d2 = {"SLASH", "Lokio/ByteString;", "BACKSLASH", "ANY_SLASH", "DOT", "DOT_DOT", "commonRoot", "Lokio/Path;", "commonSegments", "", "", "commonSegmentsBytes", "rootLength", "", "commonIsAbsolute", "", "commonIsRelative", "commonVolumeLetter", "", "(Lokio/Path;)Ljava/lang/Character;", "indexOfLastSlash", "getIndexOfLastSlash", "(Lokio/Path;)I", "commonNameBytes", "commonName", "commonParent", "lastSegmentIsDotDot", "commonIsRoot", "commonResolve", "child", "normalize", "Lokio/Buffer;", "commonRelativeTo", "other", "commonNormalized", "slash", "getSlash", "(Lokio/Path;)Lokio/ByteString;", "commonCompareTo", "commonEquals", "", "commonHashCode", "commonToString", "commonToPath", "toPath", "toSlash", "", "startsWithVolumeLetterAndColon", "okio"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public final class -Path {
    @NotNull
    private static final ByteString ANY_SLASH;
    @NotNull
    private static final ByteString BACKSLASH;
    @NotNull
    private static final ByteString DOT;
    @NotNull
    private static final ByteString DOT_DOT;
    @NotNull
    private static final ByteString SLASH;

    static {
        -Path.SLASH = ByteString.Companion.encodeUtf8("/");
        -Path.BACKSLASH = ByteString.Companion.encodeUtf8("\\");
        -Path.ANY_SLASH = ByteString.Companion.encodeUtf8("/\\");
        -Path.DOT = ByteString.Companion.encodeUtf8(".");
        -Path.DOT_DOT = ByteString.Companion.encodeUtf8("..");
    }

    public static final int commonCompareTo(@NotNull Path path0, @NotNull Path path1) {
        q.g(path0, "<this>");
        q.g(path1, "other");
        return path0.getBytes$okio().compareTo(path1.getBytes$okio());
    }

    public static final boolean commonEquals(@NotNull Path path0, @Nullable Object object0) {
        q.g(path0, "<this>");
        return object0 instanceof Path && q.b(((Path)object0).getBytes$okio(), path0.getBytes$okio());
    }

    public static final int commonHashCode(@NotNull Path path0) {
        q.g(path0, "<this>");
        return path0.getBytes$okio().hashCode();
    }

    public static final boolean commonIsAbsolute(@NotNull Path path0) {
        q.g(path0, "<this>");
        return -Path.rootLength(path0) != -1;
    }

    public static final boolean commonIsRelative(@NotNull Path path0) {
        q.g(path0, "<this>");
        return -Path.rootLength(path0) == -1;
    }

    public static final boolean commonIsRoot(@NotNull Path path0) {
        q.g(path0, "<this>");
        return -Path.rootLength(path0) == path0.getBytes$okio().size();
    }

    @NotNull
    public static final String commonName(@NotNull Path path0) {
        q.g(path0, "<this>");
        return path0.nameBytes().utf8();
    }

    @NotNull
    public static final ByteString commonNameBytes(@NotNull Path path0) {
        q.g(path0, "<this>");
        int v = -Path.getIndexOfLastSlash(path0);
        if(v != -1) {
            return ByteString.substring$default(path0.getBytes$okio(), v + 1, 0, 2, null);
        }
        return path0.volumeLetter() == null || path0.getBytes$okio().size() != 2 ? path0.getBytes$okio() : ByteString.EMPTY;
    }

    @NotNull
    public static final Path commonNormalized(@NotNull Path path0) {
        q.g(path0, "<this>");
        return Path.Companion.get(path0.toString(), true);
    }

    @Nullable
    public static final Path commonParent(@NotNull Path path0) {
        q.g(path0, "<this>");
        if(!q.b(path0.getBytes$okio(), -Path.DOT) && !q.b(path0.getBytes$okio(), -Path.SLASH) && !q.b(path0.getBytes$okio(), -Path.BACKSLASH) && !-Path.lastSegmentIsDotDot(path0)) {
            int v = -Path.getIndexOfLastSlash(path0);
            if(v == 2 && path0.volumeLetter() != null) {
                return path0.getBytes$okio().size() == 3 ? null : new Path(ByteString.substring$default(path0.getBytes$okio(), 0, 3, 1, null));
            }
            if(v == 1 && path0.getBytes$okio().startsWith(-Path.BACKSLASH)) {
                return null;
            }
            if(v == -1 && path0.volumeLetter() != null) {
                return path0.getBytes$okio().size() == 2 ? null : new Path(ByteString.substring$default(path0.getBytes$okio(), 0, 2, 1, null));
            }
            if(v == -1) {
                return new Path(-Path.DOT);
            }
            return v == 0 ? new Path(ByteString.substring$default(path0.getBytes$okio(), 0, 1, 1, null)) : new Path(ByteString.substring$default(path0.getBytes$okio(), 0, v, 1, null));
        }
        return null;
    }

    @NotNull
    public static final Path commonRelativeTo(@NotNull Path path0, @NotNull Path path1) {
        q.g(path0, "<this>");
        q.g(path1, "other");
        if(!q.b(path0.getRoot(), path1.getRoot())) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + path0 + " and " + path1).toString());
        }
        List list0 = path0.getSegmentsBytes();
        List list1 = path1.getSegmentsBytes();
        int v = Math.min(list0.size(), list1.size());
        int v1;
        for(v1 = 0; v1 < v && q.b(list0.get(v1), list1.get(v1)); ++v1) {
        }
        if(v1 == v && path0.getBytes$okio().size() == path1.getBytes$okio().size()) {
            return Companion.get$default(Path.Companion, ".", false, 1, null);
        }
        if(list1.subList(v1, list1.size()).indexOf(-Path.DOT_DOT) != -1) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + path0 + " and " + path1).toString());
        }
        if(q.b(path1.getBytes$okio(), -Path.DOT)) {
            return path0;
        }
        Buffer buffer0 = new Buffer();
        ByteString byteString0 = -Path.getSlash(path1);
        if(byteString0 == null) {
            byteString0 = -Path.getSlash(path0);
            if(byteString0 == null) {
                byteString0 = -Path.toSlash("/");
            }
        }
        int v2 = list1.size();
        for(int v3 = v1; v3 < v2; ++v3) {
            buffer0.write(-Path.DOT_DOT);
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
    public static final Path commonResolve(@NotNull Path path0, @NotNull String s, boolean z) {
        q.g(path0, "<this>");
        q.g(s, "child");
        return -Path.commonResolve(path0, -Path.toPath(new Buffer().writeUtf8(s), false), z);
    }

    @NotNull
    public static final Path commonResolve(@NotNull Path path0, @NotNull Buffer buffer0, boolean z) {
        q.g(path0, "<this>");
        q.g(buffer0, "child");
        return -Path.commonResolve(path0, -Path.toPath(buffer0, false), z);
    }

    @NotNull
    public static final Path commonResolve(@NotNull Path path0, @NotNull ByteString byteString0, boolean z) {
        q.g(path0, "<this>");
        q.g(byteString0, "child");
        return -Path.commonResolve(path0, -Path.toPath(new Buffer().write(byteString0), false), z);
    }

    @NotNull
    public static final Path commonResolve(@NotNull Path path0, @NotNull Path path1, boolean z) {
        q.g(path0, "<this>");
        q.g(path1, "child");
        if(!path1.isAbsolute() && path1.volumeLetter() == null) {
            ByteString byteString0 = -Path.getSlash(path0);
            if(byteString0 == null) {
                byteString0 = -Path.getSlash(path1);
                if(byteString0 == null) {
                    byteString0 = -Path.toSlash("/");
                }
            }
            Buffer buffer0 = new Buffer();
            buffer0.write(path0.getBytes$okio());
            if(buffer0.size() > 0L) {
                buffer0.write(byteString0);
            }
            buffer0.write(path1.getBytes$okio());
            return -Path.toPath(buffer0, z);
        }
        return path1;
    }

    @Nullable
    public static final Path commonRoot(@NotNull Path path0) {
        q.g(path0, "<this>");
        int v = -Path.rootLength(path0);
        return v == -1 ? null : new Path(path0.getBytes$okio().substring(0, v));
    }

    @NotNull
    public static final List commonSegments(@NotNull Path path0) {
        q.g(path0, "<this>");
        ArrayList arrayList0 = new ArrayList();
        int v = -Path.rootLength(path0);
        if(v == -1) {
            v = 0;
        }
        else if(v < path0.getBytes$okio().size() && path0.getBytes$okio().getByte(v) == 92) {
            ++v;
        }
        int v1 = path0.getBytes$okio().size();
        int v2 = v;
        while(v < v1) {
            switch(path0.getBytes$okio().getByte(v)) {
                case 0x2F: 
                case 92: {
                    arrayList0.add(path0.getBytes$okio().substring(v2, v));
                    v2 = v + 1;
                }
            }
            ++v;
        }
        if(v2 < path0.getBytes$okio().size()) {
            arrayList0.add(path0.getBytes$okio().substring(v2, path0.getBytes$okio().size()));
        }
        List list0 = new ArrayList(je.q.Q(10, arrayList0));
        for(Object object0: arrayList0) {
            list0.add(((ByteString)object0).utf8());
        }
        return list0;
    }

    @NotNull
    public static final List commonSegmentsBytes(@NotNull Path path0) {
        q.g(path0, "<this>");
        List list0 = new ArrayList();
        int v = -Path.rootLength(path0);
        if(v == -1) {
            v = 0;
        }
        else if(v < path0.getBytes$okio().size() && path0.getBytes$okio().getByte(v) == 92) {
            ++v;
        }
        int v1 = path0.getBytes$okio().size();
        int v2 = v;
        while(v < v1) {
            switch(path0.getBytes$okio().getByte(v)) {
                case 0x2F: 
                case 92: {
                    list0.add(path0.getBytes$okio().substring(v2, v));
                    v2 = v + 1;
                }
            }
            ++v;
        }
        if(v2 < path0.getBytes$okio().size()) {
            list0.add(path0.getBytes$okio().substring(v2, path0.getBytes$okio().size()));
        }
        return list0;
    }

    @NotNull
    public static final Path commonToPath(@NotNull String s, boolean z) {
        q.g(s, "<this>");
        return -Path.toPath(new Buffer().writeUtf8(s), z);
    }

    @NotNull
    public static final String commonToString(@NotNull Path path0) {
        q.g(path0, "<this>");
        return path0.getBytes$okio().utf8();
    }

    @Nullable
    public static final Character commonVolumeLetter(@NotNull Path path0) {
        q.g(path0, "<this>");
        if(ByteString.indexOf$default(path0.getBytes$okio(), -Path.SLASH, 0, 2, null) != -1) {
            return null;
        }
        if(path0.getBytes$okio().size() < 2) {
            return null;
        }
        if(path0.getBytes$okio().getByte(1) != 58) {
            return null;
        }
        int v = (char)path0.getBytes$okio().getByte(0);
        return (97 > v || v >= 0x7B) && (65 > v || v >= 91) ? null : Character.valueOf(((char)v));
    }

    private static final int getIndexOfLastSlash(Path path0) {
        int v = ByteString.lastIndexOf$default(path0.getBytes$okio(), -Path.SLASH, 0, 2, null);
        return v == -1 ? ByteString.lastIndexOf$default(path0.getBytes$okio(), -Path.BACKSLASH, 0, 2, null) : v;
    }

    private static final ByteString getSlash(Path path0) {
        ByteString byteString0 = -Path.SLASH;
        if(ByteString.indexOf$default(path0.getBytes$okio(), byteString0, 0, 2, null) != -1) {
            return byteString0;
        }
        return ByteString.indexOf$default(path0.getBytes$okio(), -Path.BACKSLASH, 0, 2, null) == -1 ? null : -Path.BACKSLASH;
    }

    private static final boolean lastSegmentIsDotDot(Path path0) {
        if(path0.getBytes$okio().endsWith(-Path.DOT_DOT)) {
            if(path0.getBytes$okio().size() == 2) {
                return true;
            }
            return path0.getBytes$okio().rangeEquals(path0.getBytes$okio().size() - 3, -Path.SLASH, 0, 1) ? true : path0.getBytes$okio().rangeEquals(path0.getBytes$okio().size() - 3, -Path.BACKSLASH, 0, 1);
        }
        return false;
    }

    private static final int rootLength(Path path0) {
        if(path0.getBytes$okio().size() == 0) {
            return -1;
        }
        switch(path0.getBytes$okio().getByte(0)) {
            case 0x2F: {
                return 1;
            }
            case 92: {
                if(path0.getBytes$okio().size() > 2 && path0.getBytes$okio().getByte(1) == 92) {
                    int v1 = path0.getBytes$okio().indexOf(-Path.BACKSLASH, 2);
                    return v1 == -1 ? path0.getBytes$okio().size() : v1;
                }
                return 1;
            }
            default: {
                if(path0.getBytes$okio().size() > 2 && path0.getBytes$okio().getByte(1) == 58 && path0.getBytes$okio().getByte(2) == 92) {
                    int v = (char)path0.getBytes$okio().getByte(0);
                    return (97 > v || v >= 0x7B) && (65 > v || v >= 91) ? -1 : 3;
                }
                return -1;
            }
        }
    }

    private static final boolean startsWithVolumeLetterAndColon(Buffer buffer0, ByteString byteString0) {
        if(!q.b(byteString0, -Path.BACKSLASH)) {
            return false;
        }
        if(buffer0.size() < 2L) {
            return false;
        }
        if(buffer0.getByte(1L) != 58) {
            return false;
        }
        int v = (char)buffer0.getByte(0L);
        return 97 <= v && v < 0x7B || 65 <= v && v < 91;
    }

    @NotNull
    public static final Path toPath(@NotNull Buffer buffer0, boolean z) {
        ByteString byteString2;
        ByteString byteString1;
        q.g(buffer0, "<this>");
        Buffer buffer1 = new Buffer();
        ByteString byteString0 = null;
        int v1 = 0;
        while(true) {
            if(!buffer0.rangeEquals(0L, -Path.SLASH)) {
                byteString1 = -Path.BACKSLASH;
                if(buffer0.rangeEquals(0L, byteString1)) {
                    goto label_8;
                }
                break;
            }
        label_8:
            int v2 = buffer0.readByte();
            if(byteString0 == null) {
                byteString0 = -Path.toSlash(((byte)v2));
            }
            ++v1;
        }
        boolean z1 = v1 >= 2 && q.b(byteString0, byteString1);
        if(z1) {
            q.d(byteString0);
            buffer1.write(byteString0);
            buffer1.write(byteString0);
        }
        else if(v1 > 0) {
            q.d(byteString0);
            buffer1.write(byteString0);
        }
        else {
            long v3 = buffer0.indexOfElement(-Path.ANY_SLASH);
            if(byteString0 == null) {
                byteString0 = v3 == -1L ? -Path.toSlash("/") : -Path.toSlash(buffer0.getByte(v3));
            }
            if(-Path.startsWithVolumeLetterAndColon(buffer0, byteString0)) {
                if(v3 == 2L) {
                    buffer1.write(buffer0, 3L);
                }
                else {
                    buffer1.write(buffer0, 2L);
                }
            }
        }
        boolean z2 = buffer1.size() > 0L;
        ArrayList arrayList0 = new ArrayList();
        while(!buffer0.exhausted()) {
            long v4 = buffer0.indexOfElement(-Path.ANY_SLASH);
            if(v4 == -1L) {
                byteString2 = buffer0.readByteString();
            }
            else {
                byteString2 = buffer0.readByteString(v4);
                buffer0.readByte();
            }
            ByteString byteString3 = -Path.DOT_DOT;
            if(q.b(byteString2, byteString3)) {
                if(z2 && arrayList0.isEmpty()) {
                    continue;
                }
                if(!z || !z2 && (arrayList0.isEmpty() || q.b(p.s0(arrayList0), byteString3))) {
                    arrayList0.add(byteString2);
                }
                else {
                    if(z1 && arrayList0.size() == 1 || arrayList0.isEmpty()) {
                        continue;
                    }
                    arrayList0.remove(k.s(arrayList0));
                }
            }
            else if(!q.b(byteString2, -Path.DOT) && !q.b(byteString2, ByteString.EMPTY)) {
                arrayList0.add(byteString2);
            }
        }
        int v5 = arrayList0.size();
        for(int v = 0; v < v5; ++v) {
            if(v > 0) {
                buffer1.write(byteString0);
            }
            buffer1.write(((ByteString)arrayList0.get(v)));
        }
        if(buffer1.size() == 0L) {
            buffer1.write(-Path.DOT);
        }
        return new Path(buffer1.readByteString());
    }

    private static final ByteString toSlash(byte b) {
        switch(b) {
            case 0x2F: {
                return -Path.SLASH;
            }
            case 92: {
                return -Path.BACKSLASH;
            }
            default: {
                throw new IllegalArgumentException("not a directory separator: " + ((int)b));
            }
        }
    }

    private static final ByteString toSlash(String s) {
        if(q.b(s, "/")) {
            return -Path.SLASH;
        }
        if(!q.b(s, "\\")) {
            throw new IllegalArgumentException("not a directory separator: " + s);
        }
        return -Path.BACKSLASH;
    }
}

