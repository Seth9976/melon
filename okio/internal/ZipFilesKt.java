package okio.internal;

import Tf.o;
import Tf.v;
import e1.b;
import e2.a;
import ie.H;
import ie.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import je.C;
import je.p;
import jeb.synthetic.FIN;
import kotlin.Metadata;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.q;
import ld.j;
import okio.BufferedSource;
import okio.FileHandle;
import okio.FileSystem;
import okio.Okio;
import okio.Path.Companion;
import okio.Path;
import okio.ZipFileSystem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u001F\n\u0002\u0010\u000E\n\u0002\b\u0004\u001A5\u0010\t\u001A\u00020\b2\u0006\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u00022\u0014\b\u0002\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0000\u00A2\u0006\u0004\b\t\u0010\n\u001A)\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00050\r2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00050\u000BH\u0002\u00A2\u0006\u0004\b\u000E\u0010\u000F\u001A\u0013\u0010\u0011\u001A\u00020\u0005*\u00020\u0010H\u0000\u00A2\u0006\u0004\b\u0011\u0010\u0012\u001A\u0013\u0010\u0014\u001A\u00020\u0013*\u00020\u0010H\u0002\u00A2\u0006\u0004\b\u0014\u0010\u0015\u001A\u001B\u0010\u0017\u001A\u00020\u0013*\u00020\u00102\u0006\u0010\u0016\u001A\u00020\u0013H\u0002\u00A2\u0006\u0004\b\u0017\u0010\u0018\u001A5\u0010\u001F\u001A\u00020\u001D*\u00020\u00102\u0006\u0010\u001A\u001A\u00020\u00192\u0018\u0010\u001E\u001A\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001C\u0012\u0004\u0012\u00020\u001D0\u001BH\u0002\u00A2\u0006\u0004\b\u001F\u0010 \u001A\u0013\u0010!\u001A\u00020\u001D*\u00020\u0010H\u0000\u00A2\u0006\u0004\b!\u0010\"\u001A\u001B\u0010$\u001A\u00020\u0005*\u00020\u00102\u0006\u0010#\u001A\u00020\u0005H\u0000\u00A2\u0006\u0004\b$\u0010%\u001A\u001F\u0010&\u001A\u0004\u0018\u00010\u0005*\u00020\u00102\b\u0010#\u001A\u0004\u0018\u00010\u0005H\u0002\u00A2\u0006\u0004\b&\u0010%\u001A\u0017\u0010(\u001A\u00020\u001C2\u0006\u0010\'\u001A\u00020\u001CH\u0000\u00A2\u0006\u0004\b(\u0010)\u001A!\u0010,\u001A\u0004\u0018\u00010\u001C2\u0006\u0010*\u001A\u00020\u00192\u0006\u0010+\u001A\u00020\u0019H\u0000\u00A2\u0006\u0004\b,\u0010-\"\u0014\u0010.\u001A\u00020\u00198\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b.\u0010/\"\u0014\u00100\u001A\u00020\u00198\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b0\u0010/\"\u0014\u00101\u001A\u00020\u00198\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b1\u0010/\"\u0014\u00102\u001A\u00020\u00198\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b2\u0010/\"\u0014\u00103\u001A\u00020\u00198\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b3\u0010/\"\u0014\u00104\u001A\u00020\u00198\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b4\u0010/\"\u0014\u00105\u001A\u00020\u00198\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b5\u0010/\"\u0014\u00106\u001A\u00020\u00198\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b6\u0010/\"\u0014\u00107\u001A\u00020\u00198\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b7\u0010/\"\u0014\u00108\u001A\u00020\u001C8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b8\u00109\"\u0014\u0010:\u001A\u00020\u00198\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b:\u0010/\"\u0014\u0010;\u001A\u00020\u00198\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b;\u0010/\"\u0014\u0010<\u001A\u00020\u00198\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b<\u0010/\"\u0018\u0010@\u001A\u00020=*\u00020\u00198BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b>\u0010?\u00A8\u0006A"}, d2 = {"Lokio/Path;", "zipPath", "Lokio/FileSystem;", "fileSystem", "Lkotlin/Function1;", "Lokio/internal/ZipEntry;", "", "predicate", "Lokio/ZipFileSystem;", "openZip", "(Lokio/Path;Lokio/FileSystem;Lwe/k;)Lokio/ZipFileSystem;", "", "entries", "", "buildIndex", "(Ljava/util/List;)Ljava/util/Map;", "Lokio/BufferedSource;", "readCentralDirectoryZipEntry", "(Lokio/BufferedSource;)Lokio/internal/ZipEntry;", "Lokio/internal/EocdRecord;", "readEocdRecord", "(Lokio/BufferedSource;)Lokio/internal/EocdRecord;", "regularRecord", "readZip64EocdRecord", "(Lokio/BufferedSource;Lokio/internal/EocdRecord;)Lokio/internal/EocdRecord;", "", "extraSize", "Lkotlin/Function2;", "", "Lie/H;", "block", "readExtra", "(Lokio/BufferedSource;ILwe/n;)V", "skipLocalHeader", "(Lokio/BufferedSource;)V", "centralDirectoryZipEntry", "readLocalHeader", "(Lokio/BufferedSource;Lokio/internal/ZipEntry;)Lokio/internal/ZipEntry;", "readOrSkipLocalHeader", "filetime", "filetimeToEpochMillis", "(J)J", "date", "time", "dosDateTimeToEpochMillis", "(II)Ljava/lang/Long;", "LOCAL_FILE_HEADER_SIGNATURE", "I", "CENTRAL_FILE_HEADER_SIGNATURE", "END_OF_CENTRAL_DIRECTORY_SIGNATURE", "ZIP64_LOCATOR_SIGNATURE", "ZIP64_EOCD_RECORD_SIGNATURE", "COMPRESSION_METHOD_DEFLATED", "COMPRESSION_METHOD_STORED", "BIT_FLAG_ENCRYPTED", "BIT_FLAG_UNSUPPORTED_MASK", "MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE", "J", "HEADER_ID_ZIP64_EXTENDED_INFO", "HEADER_ID_NTFS_EXTRA", "HEADER_ID_EXTENDED_TIMESTAMP", "", "getHex", "(I)Ljava/lang/String;", "hex", "okio"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public final class ZipFilesKt {
    private static final int BIT_FLAG_ENCRYPTED = 1;
    private static final int BIT_FLAG_UNSUPPORTED_MASK = 1;
    private static final int CENTRAL_FILE_HEADER_SIGNATURE = 0x2014B50;
    public static final int COMPRESSION_METHOD_DEFLATED = 8;
    public static final int COMPRESSION_METHOD_STORED = 0;
    private static final int END_OF_CENTRAL_DIRECTORY_SIGNATURE = 101010256;
    private static final int HEADER_ID_EXTENDED_TIMESTAMP = 0x5455;
    private static final int HEADER_ID_NTFS_EXTRA = 10;
    private static final int HEADER_ID_ZIP64_EXTENDED_INFO = 1;
    private static final int LOCAL_FILE_HEADER_SIGNATURE = 0x4034B50;
    private static final long MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE = 0xFFFFFFFFL;
    private static final int ZIP64_EOCD_RECORD_SIGNATURE = 0x6064B50;
    private static final int ZIP64_LOCATOR_SIGNATURE = 0x7064B50;

    public static boolean a(ZipEntry zipEntry0) {
        return ZipFilesKt.openZip$lambda$0(zipEntry0);
    }

    public static H b(kotlin.jvm.internal.H h0, BufferedSource bufferedSource0, kotlin.jvm.internal.H h1, kotlin.jvm.internal.H h2, int v, long v1) {
        return ZipFilesKt.readOrSkipLocalHeader$lambda$10(bufferedSource0, h0, h1, h2, v, v1);
    }

    private static final Map buildIndex(List list0) {
        ZipEntry zipEntry1;
        Path path0 = Companion.get$default(Path.Companion, "/", false, 1, null);
        Map map0 = C.T(new m[]{new m(path0, new ZipEntry(path0, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, null, null, null, 0xFFFC, null))});
        Iterator iterator0 = p.J0(list0, new Comparator() {
            @Override
            public final int compare(Object object0, Object object1) {
                return b.r(((ZipEntry)object0).getCanonicalPath(), ((ZipEntry)object1).getCanonicalPath());
            }
        }).iterator();
    label_3:
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            ZipEntry zipEntry0 = (ZipEntry)object0;
            if(((ZipEntry)map0.put(zipEntry0.getCanonicalPath(), zipEntry0)) == null) {
                while(true) {
                    Path path1 = zipEntry0.getCanonicalPath().parent();
                    if(path1 == null) {
                        continue label_3;
                    }
                    zipEntry1 = (ZipEntry)((LinkedHashMap)map0).get(path1);
                    if(zipEntry1 != null) {
                        break;
                    }
                    ZipEntry zipEntry2 = new ZipEntry(path1, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, null, null, null, 0xFFFC, null);
                    map0.put(path1, zipEntry2);
                    zipEntry2.getChildren().add(zipEntry0.getCanonicalPath());
                    zipEntry0 = zipEntry2;
                }
                zipEntry1.getChildren().add(zipEntry0.getCanonicalPath());
            }
        }
        return map0;
    }

    @Nullable
    public static final Long dosDateTimeToEpochMillis(int v, int v1) {
        return v1 == -1 ? null : _ZlibJvmKt.datePartsToEpochMillis((v >> 9 & 0x7F) + 1980, v >> 5 & 15, v & 0x1F, v1 >> 11 & 0x1F, v1 >> 5 & 0x3F, (v1 & 0x1F) << 1);
    }

    public static final long filetimeToEpochMillis(long v) {
        return v / 10000L - 11644473600000L;
    }

    private static final String getHex(int v) [...] // 潜在的解密器

    @NotNull
    public static final ZipFileSystem openZip(@NotNull Path path0, @NotNull FileSystem fileSystem0, @NotNull k k0) {
        ZipFileSystem zipFileSystem0;
        Throwable throwable7;
        Throwable throwable5;
        int v3;
        BufferedSource bufferedSource0;
        q.g(path0, "zipPath");
        q.g(fileSystem0, "fileSystem");
        q.g(k0, "predicate");
        FileHandle fileHandle0 = fileSystem0.openReadOnly(path0);
        try {
            long v = fileHandle0.size() - 22L;
            if(v < 0L) {
                throw new IOException("not a zip: size=" + fileHandle0.size());
            }
            long v2 = Math.max(v - 0x10000L, 0L);
            while(true) {
                bufferedSource0 = Okio.buffer(fileHandle0.source(v));
                v3 = FIN.finallyOpen$NT();
                if(bufferedSource0.readIntLe() == 101010256) {
                    break;
                }
                FIN.finallyExec$NT(v3);
                --v;
                if(v < v2) {
                    throw new IOException("not a zip: end of central directory signature not found");
                }
            }
            EocdRecord eocdRecord0 = ZipFilesKt.readEocdRecord(bufferedSource0);
            String s = bufferedSource0.readUtf8(((long)eocdRecord0.getCommentByteCount()));
            FIN.finallyCodeBegin$NT(v3);
            bufferedSource0.close();
            FIN.finallyCodeEnd$NT(v3);
            Throwable throwable1 = null;
            if(Long.compare(v - 20L, 0L) > 0) {
                BufferedSource bufferedSource1 = Okio.buffer(fileHandle0.source(v - 20L));
                try {
                    if(bufferedSource1.readIntLe() == 0x7064B50) {
                        int v4 = bufferedSource1.readIntLe();
                        long v5 = bufferedSource1.readLongLe();
                        if(bufferedSource1.readIntLe() != 1 || v4 != 0) {
                            throw new IOException("unsupported zip: spanned");
                        }
                        BufferedSource bufferedSource2 = Okio.buffer(fileHandle0.source(v5));
                        try {
                            int v6 = bufferedSource2.readIntLe();
                            if(v6 != 0x6064B50) {
                                throw new IOException("bad zip: expected 0x6064b50 but was " + ZipFilesKt.getHex(v6));
                            }
                            eocdRecord0 = ZipFilesKt.readZip64EocdRecord(bufferedSource2, eocdRecord0);
                        }
                        catch(Throwable throwable3) {
                            if(bufferedSource2 != null) {
                                try {
                                    bufferedSource2.close();
                                }
                                catch(Throwable throwable4) {
                                    a.q(throwable3, throwable4);
                                }
                            }
                            throwable5 = throwable3;
                            goto label_48;
                        }
                        try {
                            bufferedSource2.close();
                            throwable5 = null;
                        }
                        catch(Throwable throwable5) {
                        }
                    label_48:
                        if(throwable5 != null) {
                            throw throwable5;
                        }
                    }
                }
                catch(Throwable throwable2) {
                    if(bufferedSource1 != null) {
                        try {
                            bufferedSource1.close();
                        }
                        catch(Throwable throwable6) {
                            a.q(throwable2, throwable6);
                        }
                    }
                    throwable7 = throwable2;
                    goto label_62;
                }
                try {
                    bufferedSource1.close();
                    throwable7 = null;
                }
                catch(Throwable throwable7) {
                }
            label_62:
                if(throwable7 != null) {
                    throw throwable7;
                }
            }
            ArrayList arrayList0 = new ArrayList();
            BufferedSource bufferedSource3 = Okio.buffer(fileHandle0.source(eocdRecord0.getCentralDirectoryOffset()));
            try {
                long v7 = eocdRecord0.getEntryCount();
                for(long v1 = 0L; v1 < v7; ++v1) {
                    ZipEntry zipEntry0 = ZipFilesKt.readCentralDirectoryZipEntry(bufferedSource3);
                    if(zipEntry0.getOffset() >= eocdRecord0.getCentralDirectoryOffset()) {
                        throw new IOException("bad zip: local file header offset >= central directory offset");
                    }
                    if(((Boolean)k0.invoke(zipEntry0)).booleanValue()) {
                        arrayList0.add(zipEntry0);
                    }
                }
                if(bufferedSource3 != null) {
                    goto label_85;
                }
            }
            catch(Throwable throwable8) {
                if(bufferedSource3 != null) {
                    try {
                        bufferedSource3.close();
                    }
                    catch(Throwable throwable9) {
                        a.q(throwable8, throwable9);
                    }
                }
                throwable1 = throwable8;
            }
            goto label_89;
            try {
            label_85:
                bufferedSource3.close();
            }
            catch(Throwable throwable10) {
                throwable1 = throwable10;
            }
        label_89:
            if(throwable1 != null) {
                throw throwable1;
            }
            zipFileSystem0 = new ZipFileSystem(path0, fileSystem0, ZipFilesKt.buildIndex(arrayList0), s);
        }
        catch(Throwable throwable0) {
            if(fileHandle0 != null) {
                try {
                    fileHandle0.close();
                }
                catch(Throwable throwable11) {
                    a.q(throwable0, throwable11);
                }
            }
            throw throwable0;
        }
        try {
            fileHandle0.close();
        }
        catch(Throwable unused_ex) {
        }
        return zipFileSystem0;
    }

    public static ZipFileSystem openZip$default(Path path0, FileSystem fileSystem0, k k0, int v, Object object0) {
        if((v & 4) != 0) {
            k0 = new j(12);
        }
        return ZipFilesKt.openZip(path0, fileSystem0, k0);
    }

    private static final boolean openZip$lambda$0(ZipEntry zipEntry0) {
        q.g(zipEntry0, "it");
        return true;
    }

    @NotNull
    public static final ZipEntry readCentralDirectoryZipEntry(@NotNull BufferedSource bufferedSource0) {
        q.g(bufferedSource0, "<this>");
        int v = bufferedSource0.readIntLe();
        if(v != 0x2014B50) {
            throw new IOException("bad zip: expected 0x2014b50 but was " + ZipFilesKt.getHex(v));
        }
        bufferedSource0.skip(4L);
        int v1 = bufferedSource0.readShortLe();
        if((v1 & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + ZipFilesKt.getHex(v1 & 0xFFFF));
        }
        int v2 = bufferedSource0.readShortLe();
        int v3 = bufferedSource0.readShortLe();
        int v4 = bufferedSource0.readShortLe();
        long v5 = ((long)bufferedSource0.readIntLe()) & 0xFFFFFFFFL;
        G g0 = new G();  // 初始化器: Ljava/lang/Object;-><init>()V
        g0.a = ((long)bufferedSource0.readIntLe()) & 0xFFFFFFFFL;
        G g1 = new G();  // 初始化器: Ljava/lang/Object;-><init>()V
        g1.a = ((long)bufferedSource0.readIntLe()) & 0xFFFFFFFFL;
        int v6 = bufferedSource0.readShortLe();
        int v7 = bufferedSource0.readShortLe();
        int v8 = bufferedSource0.readShortLe();
        bufferedSource0.skip(8L);
        G g2 = new G();  // 初始化器: Ljava/lang/Object;-><init>()V
        g2.a = ((long)bufferedSource0.readIntLe()) & 0xFFFFFFFFL;
        String s = bufferedSource0.readUtf8(((long)(v6 & 0xFFFF)));
        if(o.w0(s, '\u0000')) {
            throw new IOException("bad zip: filename contains 0x00");
        }
        long v9 = Long.compare(g1.a, 0xFFFFFFFFL) == 0 ? 8L : 0L;
        if(g0.a == 0xFFFFFFFFL) {
            v9 += 8L;
        }
        if(g2.a == 0xFFFFFFFFL) {
            v9 += 8L;
        }
        kotlin.jvm.internal.H h0 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
        kotlin.jvm.internal.H h1 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
        kotlin.jvm.internal.H h2 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
        kotlin.jvm.internal.C c0 = new kotlin.jvm.internal.C();  // 初始化器: Ljava/lang/Object;-><init>()V
        ZipFilesKt.readExtra(bufferedSource0, v7 & 0xFFFF, (int v1, long v2) -> switch(v1) {
            case 1: {
                if(c0.a) {
                    throw new IOException("bad zip: zip64 extra repeated");
                }
                c0.a = true;
                if(v2 < v9) {
                    throw new IOException("bad zip: zip64 extra too short");
                }
                g1.a = g1.a == 0xFFFFFFFFL ? bufferedSource0.readLongLe() : g1.a;
                long v3 = 0L;
                g0.a = Long.compare(g0.a, 0xFFFFFFFFL) == 0 ? bufferedSource0.readLongLe() : 0L;
                if(g2.a == 0xFFFFFFFFL) {
                    v3 = bufferedSource0.readLongLe();
                }
                g2.a = v3;
                return H.a;
            }
            case 10: {
                if(v2 < 4L) {
                    throw new IOException("bad zip: NTFS extra too short");
                }
                bufferedSource0.skip(4L);
                ZipFilesKt.readExtra(bufferedSource0, ((int)(v2 - 4L)), new okio.internal.a(h0, bufferedSource0, h1, h2));
                return H.a;
            }
            default: {
                return H.a;
            }
        });
        if(v9 > 0L && !c0.a) {
            throw new IOException("bad zip: zip64 extra required but absent");
        }
        String s1 = bufferedSource0.readUtf8(((long)(v8 & 0xFFFF)));
        return new ZipEntry(Companion.get$default(Path.Companion, "/", false, 1, null).resolve(s), v.i0(s, "/", false), s1, v5, g0.a, g1.a, v2 & 0xFFFF, g2.a, v4 & 0xFFFF, v3 & 0xFFFF, ((Long)h0.a), ((Long)h1.a), ((Long)h2.a), null, null, null, 0xE000, null);
    }

    // 检测为 Lambda 实现
    private static final H readCentralDirectoryZipEntry$lambda$8(kotlin.jvm.internal.C c0, long v, G g0, BufferedSource bufferedSource0, G g1, G g2, kotlin.jvm.internal.H h0, kotlin.jvm.internal.H h1, kotlin.jvm.internal.H h2, int v1, long v2) [...]

    private static final H readCentralDirectoryZipEntry$lambda$8$lambda$7(kotlin.jvm.internal.H h0, BufferedSource bufferedSource0, kotlin.jvm.internal.H h1, kotlin.jvm.internal.H h2, int v, long v1) {
        if(v == 1) {
            if(h0.a != null) {
                throw new IOException("bad zip: NTFS extra attribute tag 0x0001 repeated");
            }
            if(v1 != 24L) {
                throw new IOException("bad zip: NTFS extra attribute tag 0x0001 size != 24");
            }
            h0.a = bufferedSource0.readLongLe();
            h1.a = bufferedSource0.readLongLe();
            h2.a = bufferedSource0.readLongLe();
            return H.a;
        }
        return H.a;
    }

    private static final EocdRecord readEocdRecord(BufferedSource bufferedSource0) {
        int v = bufferedSource0.readShortLe();
        int v1 = bufferedSource0.readShortLe();
        int v2 = bufferedSource0.readShortLe();
        if(((long)(v2 & 0xFFFF)) != ((long)(bufferedSource0.readShortLe() & 0xFFFF)) || (v & 0xFFFF) != 0 || (v1 & 0xFFFF) != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        bufferedSource0.skip(4L);
        return new EocdRecord(((long)(v2 & 0xFFFF)), 0xFFFFFFFFL & ((long)bufferedSource0.readIntLe()), bufferedSource0.readShortLe() & 0xFFFF);
    }

    private static final void readExtra(BufferedSource bufferedSource0, int v, n n0) {
        for(long v1 = (long)v; v1 != 0L; v1 = v1 - 4L - v3) {
            if(v1 < 4L) {
                throw new IOException("bad zip: truncated header in extra field");
            }
            int v2 = bufferedSource0.readShortLe() & 0xFFFF;
            long v3 = ((long)bufferedSource0.readShortLe()) & 0xFFFFL;
            if(v1 - 4L < v3) {
                throw new IOException("bad zip: truncated value in extra field");
            }
            bufferedSource0.require(v3);
            long v4 = bufferedSource0.getBuffer().size();
            n0.invoke(v2, v3);
            long v5 = bufferedSource0.getBuffer().size() + v3 - v4;
            int v6 = Long.compare(v5, 0L);
            if(v6 < 0) {
                throw new IOException("unsupported zip: too many bytes processed for " + v2);
            }
            if(v6 > 0) {
                bufferedSource0.getBuffer().skip(v5);
            }
        }
    }

    @NotNull
    public static final ZipEntry readLocalHeader(@NotNull BufferedSource bufferedSource0, @NotNull ZipEntry zipEntry0) {
        q.g(bufferedSource0, "<this>");
        q.g(zipEntry0, "centralDirectoryZipEntry");
        ZipEntry zipEntry1 = ZipFilesKt.readOrSkipLocalHeader(bufferedSource0, zipEntry0);
        q.d(zipEntry1);
        return zipEntry1;
    }

    private static final ZipEntry readOrSkipLocalHeader(BufferedSource bufferedSource0, ZipEntry zipEntry0) {
        int v = bufferedSource0.readIntLe();
        if(v != 0x4034B50) {
            throw new IOException("bad zip: expected 0x4034b50 but was " + ZipFilesKt.getHex(v));
        }
        bufferedSource0.skip(2L);
        int v1 = bufferedSource0.readShortLe();
        if((v1 & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + ZipFilesKt.getHex(v1 & 0xFFFF));
        }
        bufferedSource0.skip(18L);
        long v2 = ((long)bufferedSource0.readShortLe()) & 0xFFFFL;
        int v3 = bufferedSource0.readShortLe();
        bufferedSource0.skip(v2);
        if(zipEntry0 == null) {
            bufferedSource0.skip(((long)(v3 & 0xFFFF)));
            return null;
        }
        kotlin.jvm.internal.H h0 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
        kotlin.jvm.internal.H h1 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
        kotlin.jvm.internal.H h2 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
        ZipFilesKt.readExtra(bufferedSource0, v3 & 0xFFFF, new okio.internal.a(bufferedSource0, h0, h1, h2));
        return zipEntry0.copy$okio(((Integer)h0.a), ((Integer)h1.a), ((Integer)h2.a));
    }

    private static final H readOrSkipLocalHeader$lambda$10(BufferedSource bufferedSource0, kotlin.jvm.internal.H h0, kotlin.jvm.internal.H h1, kotlin.jvm.internal.H h2, int v, long v1) {
        long v2 = 1L;
        if(v == 0x5455) {
            if(Long.compare(v1, 1L) < 0) {
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            int v3 = bufferedSource0.readByte();
            boolean z = false;
            boolean z1 = (v3 & 1) == 1;
            boolean z2 = (v3 & 2) == 2;
            if((v3 & 4) == 4) {
                z = true;
            }
            if(z1) {
                v2 = 5L;
            }
            if(z2) {
                v2 += 4L;
            }
            if(z) {
                v2 += 4L;
            }
            if(v1 < v2) {
                throw new IOException("bad zip: extended timestamp extra too short");
            }
            if(z1) {
                h0.a = bufferedSource0.readIntLe();
            }
            if(z2) {
                h1.a = bufferedSource0.readIntLe();
            }
            if(z) {
                h2.a = bufferedSource0.readIntLe();
                return H.a;
            }
        }
        return H.a;
    }

    private static final EocdRecord readZip64EocdRecord(BufferedSource bufferedSource0, EocdRecord eocdRecord0) {
        bufferedSource0.skip(12L);
        int v = bufferedSource0.readIntLe();
        int v1 = bufferedSource0.readIntLe();
        long v2 = bufferedSource0.readLongLe();
        if(v2 != bufferedSource0.readLongLe() || v != 0 || v1 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        bufferedSource0.skip(8L);
        return new EocdRecord(v2, bufferedSource0.readLongLe(), eocdRecord0.getCommentByteCount());
    }

    public static final void skipLocalHeader(@NotNull BufferedSource bufferedSource0) {
        q.g(bufferedSource0, "<this>");
        ZipFilesKt.readOrSkipLocalHeader(bufferedSource0, null);
    }
}

