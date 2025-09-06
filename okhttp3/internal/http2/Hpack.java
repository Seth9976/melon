package okhttp3.internal.http2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import je.n;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0015\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u0005J\u0014\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002R\u001D\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u000E\u0010\t\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0019\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\n\n\u0002\u0010\u0014\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u001A"}, d2 = {"Lokhttp3/internal/http2/Hpack;", "", "()V", "NAME_TO_FIRST_INDEX", "", "Lokio/ByteString;", "", "getNAME_TO_FIRST_INDEX", "()Ljava/util/Map;", "PREFIX_4_BITS", "PREFIX_5_BITS", "PREFIX_6_BITS", "PREFIX_7_BITS", "SETTINGS_HEADER_TABLE_SIZE", "SETTINGS_HEADER_TABLE_SIZE_LIMIT", "STATIC_HEADER_TABLE", "", "Lokhttp3/internal/http2/Header;", "getSTATIC_HEADER_TABLE", "()[Lokhttp3/internal/http2/Header;", "[Lokhttp3/internal/http2/Header;", "checkLowercase", "name", "nameToFirstIndex", "Reader", "Writer", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Hpack {
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\f\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b\f\u0010\u000BJ\u0017\u0010\u000E\u001A\u00020\u00042\u0006\u0010\r\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0011\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0013\u0010\u000FJ\u0017\u0010\u0014\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0014\u0010\u0012J\u000F\u0010\u0015\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b\u0015\u0010\u000BJ\u0017\u0010\u0017\u001A\u00020\t2\u0006\u0010\u0016\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0017\u0010\u0012J\u000F\u0010\u0018\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b\u0018\u0010\u000BJ\u0017\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u0010\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0017\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u0010\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u001F\u0010!\u001A\u00020\t2\u0006\u0010\u0010\u001A\u00020\u00042\u0006\u0010 \u001A\u00020\u001FH\u0002\u00A2\u0006\u0004\b!\u0010\"J\u000F\u0010#\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b#\u0010$J\u0013\u0010&\u001A\b\u0012\u0004\u0012\u00020\u001F0%\u00A2\u0006\u0004\b&\u0010\'J\r\u0010\u0006\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0006\u0010$J\r\u0010(\u001A\u00020\t\u00A2\u0006\u0004\b(\u0010\u000BJ\u001D\u0010+\u001A\u00020\u00042\u0006\u0010)\u001A\u00020\u00042\u0006\u0010*\u001A\u00020\u0004\u00A2\u0006\u0004\b+\u0010,J\r\u0010-\u001A\u00020\u0019\u00A2\u0006\u0004\b-\u0010.R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u0010/R\u0016\u0010\u0006\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u0006\u0010/R\u001A\u00101\u001A\b\u0012\u0004\u0012\u00020\u001F008\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b1\u00102R\u0014\u0010\u0003\u001A\u0002038\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u00104R\u001E\u00106\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u001F058\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b8\u0010/R\u0016\u00109\u001A\u00020\u00048\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0006\n\u0004\b9\u0010/R\u0016\u0010:\u001A\u00020\u00048\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0006\n\u0004\b:\u0010/\u00A8\u0006;"}, d2 = {"Lokhttp3/internal/http2/Hpack$Reader;", "", "Lokio/Source;", "source", "", "headerTableSizeSetting", "maxDynamicTableByteCount", "<init>", "(Lokio/Source;II)V", "Lie/H;", "adjustDynamicTableByteCount", "()V", "clearDynamicTable", "bytesToRecover", "evictToRecoverBytes", "(I)I", "index", "readIndexedHeader", "(I)V", "dynamicTableIndex", "readLiteralHeaderWithoutIndexingIndexedName", "readLiteralHeaderWithoutIndexingNewName", "nameIndex", "readLiteralHeaderWithIncrementalIndexingIndexedName", "readLiteralHeaderWithIncrementalIndexingNewName", "Lokio/ByteString;", "getName", "(I)Lokio/ByteString;", "", "isStaticHeader", "(I)Z", "Lokhttp3/internal/http2/Header;", "entry", "insertIntoDynamicTable", "(ILokhttp3/internal/http2/Header;)V", "readByte", "()I", "", "getAndResetHeaderList", "()Ljava/util/List;", "readHeaders", "firstByte", "prefixMask", "readInt", "(II)I", "readByteString", "()Lokio/ByteString;", "I", "", "headerList", "Ljava/util/List;", "Lokio/BufferedSource;", "Lokio/BufferedSource;", "", "dynamicTable", "[Lokhttp3/internal/http2/Header;", "nextHeaderIndex", "headerCount", "dynamicTableByteCount", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Reader {
        @NotNull
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        public int headerCount;
        @NotNull
        private final List headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        @NotNull
        private final BufferedSource source;

        public Reader(@NotNull Source source0, int v) {
            q.g(source0, "source");
            this(source0, v, 0, 4, null);
        }

        public Reader(@NotNull Source source0, int v, int v1) {
            q.g(source0, "source");
            super();
            this.headerTableSizeSetting = v;
            this.maxDynamicTableByteCount = v1;
            this.headerList = new ArrayList();
            this.source = Okio.buffer(source0);
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = 7;
        }

        public Reader(Source source0, int v, int v1, int v2, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v2 & 4) != 0) {
                v1 = v;
            }
            this(source0, v, v1);
        }

        private final void adjustDynamicTableByteCount() {
            int v = this.maxDynamicTableByteCount;
            int v1 = this.dynamicTableByteCount;
            if(v < v1) {
                if(v == 0) {
                    this.clearDynamicTable();
                    return;
                }
                this.evictToRecoverBytes(v1 - v);
            }
        }

        private final void clearDynamicTable() {
            n.f0(this.dynamicTable, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int dynamicTableIndex(int v) {
            return this.nextHeaderIndex + 1 + v;
        }

        private final int evictToRecoverBytes(int v) {
            int v3;
            int v1 = 0;
            if(v > 0) {
                for(int v2 = this.dynamicTable.length - 1; true; --v2) {
                    v3 = this.nextHeaderIndex;
                    if(v2 < v3 || v <= 0) {
                        break;
                    }
                    Header header0 = this.dynamicTable[v2];
                    q.d(header0);
                    v -= header0.hpackSize;
                    this.dynamicTableByteCount -= header0.hpackSize;
                    --this.headerCount;
                    ++v1;
                }
                System.arraycopy(this.dynamicTable, v3 + 1, this.dynamicTable, v3 + 1 + v1, this.headerCount);
                this.nextHeaderIndex += v1;
            }
            return v1;
        }

        @NotNull
        public final List getAndResetHeaderList() {
            List list0 = p.P0(this.headerList);
            this.headerList.clear();
            return list0;
        }

        private final ByteString getName(int v) {
            if(this.isStaticHeader(v)) {
                return Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[v].name;
            }
            int v1 = this.dynamicTableIndex(v - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if(v1 >= 0) {
                Header[] arr_header = this.dynamicTable;
                if(v1 < arr_header.length) {
                    Header header0 = arr_header[v1];
                    q.d(header0);
                    return header0.name;
                }
            }
            throw new IOException("Header index too large " + (v + 1));
        }

        private final void insertIntoDynamicTable(int v, Header header0) {
            this.headerList.add(header0);
            int v1 = header0.hpackSize;
            if(v != -1) {
                Header header1 = this.dynamicTable[this.dynamicTableIndex(v)];
                q.d(header1);
                v1 -= header1.hpackSize;
            }
            int v2 = this.maxDynamicTableByteCount;
            if(v1 > v2) {
                this.clearDynamicTable();
                return;
            }
            int v3 = this.evictToRecoverBytes(this.dynamicTableByteCount + v1 - v2);
            if(v == -1) {
                Header[] arr_header = this.dynamicTable;
                if(this.headerCount + 1 > arr_header.length) {
                    Header[] arr_header1 = new Header[arr_header.length * 2];
                    System.arraycopy(arr_header, 0, arr_header1, arr_header.length, arr_header.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = arr_header1;
                }
                int v4 = this.nextHeaderIndex;
                this.nextHeaderIndex = v4 - 1;
                this.dynamicTable[v4] = header0;
                ++this.headerCount;
            }
            else {
                this.dynamicTable[this.dynamicTableIndex(v) + v3 + v] = header0;
            }
            this.dynamicTableByteCount += v1;
        }

        private final boolean isStaticHeader(int v) {
            return v >= 0 && v <= Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length - 1;
        }

        public final int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        private final int readByte() {
            return Util.and(this.source.readByte(), ((byte)0xFF));
        }

        @NotNull
        public final ByteString readByteString() {
            int v = this.readByte();
            long v1 = (long)this.readInt(v, 0x7F);
            if((v & 0x80) == 0x80) {
                Buffer buffer0 = new Buffer();
                Huffman.INSTANCE.decode(this.source, v1, buffer0);
                return buffer0.readByteString();
            }
            return this.source.readByteString(v1);
        }

        public final void readHeaders() {
            while(!this.source.exhausted()) {
                int v = Util.and(this.source.readByte(), ((byte)0xFF));
                if(v == 0x80) {
                    throw new IOException("index == 0");
                }
                if((v & 0x80) == 0x80) {
                    this.readIndexedHeader(this.readInt(v, 0x7F) - 1);
                }
                else if(v == 0x40) {
                    this.readLiteralHeaderWithIncrementalIndexingNewName();
                }
                else if((v & 0x40) == 0x40) {
                    this.readLiteralHeaderWithIncrementalIndexingIndexedName(this.readInt(v, 0x3F) - 1);
                }
                else if((v & 0x20) == 0x20) {
                    int v1 = this.readInt(v, 0x1F);
                    this.maxDynamicTableByteCount = v1;
                    if(v1 < 0 || v1 > this.headerTableSizeSetting) {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    this.adjustDynamicTableByteCount();
                }
                else if(v != 0 && v != 16) {
                    this.readLiteralHeaderWithoutIndexingIndexedName(this.readInt(v, 15) - 1);
                }
                else {
                    this.readLiteralHeaderWithoutIndexingNewName();
                }
            }
        }

        private final void readIndexedHeader(int v) {
            if(this.isStaticHeader(v)) {
                this.headerList.add(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[v]);
                return;
            }
            int v1 = this.dynamicTableIndex(v - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if(v1 >= 0) {
                Header[] arr_header = this.dynamicTable;
                if(v1 < arr_header.length) {
                    Header header0 = arr_header[v1];
                    q.d(header0);
                    this.headerList.add(header0);
                    return;
                }
            }
            throw new IOException("Header index too large " + (v + 1));
        }

        public final int readInt(int v, int v1) {
            int v4;
            int v2 = v & v1;
            if(v2 < v1) {
                return v2;
            }
            int v3;
            for(v3 = 0; true; v3 += 7) {
                v4 = this.readByte();
                if((v4 & 0x80) == 0) {
                    break;
                }
                v1 += (v4 & 0x7F) << v3;
            }
            return v1 + (v4 << v3);
        }

        private final void readLiteralHeaderWithIncrementalIndexingIndexedName(int v) {
            this.insertIntoDynamicTable(-1, new Header(this.getName(v), this.readByteString()));
        }

        private final void readLiteralHeaderWithIncrementalIndexingNewName() {
            ByteString byteString0 = this.readByteString();
            this.insertIntoDynamicTable(-1, new Header(Hpack.INSTANCE.checkLowercase(byteString0), this.readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingIndexedName(int v) {
            Header header0 = new Header(this.getName(v), this.readByteString());
            this.headerList.add(header0);
        }

        private final void readLiteralHeaderWithoutIndexingNewName() {
            ByteString byteString0 = this.readByteString();
            Header header0 = new Header(Hpack.INSTANCE.checkLowercase(byteString0), this.readByteString());
            this.headerList.add(header0);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\b\u0007\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000E\u001A\u00020\u00022\u0006\u0010\r\u001A\u00020\u0002H\u0002\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0012\u001A\u00020\n2\u0006\u0010\u0011\u001A\u00020\u0010H\u0002\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b\u0014\u0010\fJ\u001B\u0010\u0017\u001A\u00020\n2\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00100\u0015\u00A2\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u001C\u001A\u00020\n2\u0006\u0010\u0019\u001A\u00020\u00022\u0006\u0010\u001A\u001A\u00020\u00022\u0006\u0010\u001B\u001A\u00020\u0002\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0015\u0010 \u001A\u00020\n2\u0006\u0010\u001F\u001A\u00020\u001E\u00A2\u0006\u0004\b \u0010!J\u0015\u0010\"\u001A\u00020\n2\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\"\u0010#R\u0016\u0010\u0003\u001A\u00020\u00028\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0006\n\u0004\b\u0003\u0010$R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u0010%R\u0014\u0010\u0007\u001A\u00020\u00068\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0007\u0010&R\u0016\u0010\'\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\'\u0010$R\u0016\u0010(\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b(\u0010%R\u0016\u0010)\u001A\u00020\u00028\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0006\n\u0004\b)\u0010$R\u001E\u0010+\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100*8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001A\u00020\u00028\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b-\u0010$R\u0016\u0010.\u001A\u00020\u00028\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0006\n\u0004\b.\u0010$R\u0016\u0010/\u001A\u00020\u00028\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0006\n\u0004\b/\u0010$\u00A8\u00060"}, d2 = {"Lokhttp3/internal/http2/Hpack$Writer;", "", "", "headerTableSizeSetting", "", "useCompression", "Lokio/Buffer;", "out", "<init>", "(IZLokio/Buffer;)V", "Lie/H;", "clearDynamicTable", "()V", "bytesToRecover", "evictToRecoverBytes", "(I)I", "Lokhttp3/internal/http2/Header;", "entry", "insertIntoDynamicTable", "(Lokhttp3/internal/http2/Header;)V", "adjustDynamicTableByteCount", "", "headerBlock", "writeHeaders", "(Ljava/util/List;)V", "value", "prefixMask", "bits", "writeInt", "(III)V", "Lokio/ByteString;", "data", "writeByteString", "(Lokio/ByteString;)V", "resizeHeaderTable", "(I)V", "I", "Z", "Lokio/Buffer;", "smallestHeaderTableSizeSetting", "emitDynamicTableSizeUpdate", "maxDynamicTableByteCount", "", "dynamicTable", "[Lokhttp3/internal/http2/Header;", "nextHeaderIndex", "headerCount", "dynamicTableByteCount", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Writer {
        @NotNull
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        public int headerCount;
        public int headerTableSizeSetting;
        public int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        @NotNull
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        public Writer(int v, @NotNull Buffer buffer0) {
            q.g(buffer0, "out");
            this(v, false, buffer0, 2, null);
        }

        public Writer(int v, boolean z, @NotNull Buffer buffer0) {
            q.g(buffer0, "out");
            super();
            this.headerTableSizeSetting = v;
            this.useCompression = z;
            this.out = buffer0;
            this.smallestHeaderTableSizeSetting = 0x7FFFFFFF;
            this.maxDynamicTableByteCount = v;
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = 7;
        }

        public Writer(int v, boolean z, Buffer buffer0, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v1 & 1) != 0) {
                v = 0x1000;
            }
            if((v1 & 2) != 0) {
                z = true;
            }
            this(v, z, buffer0);
        }

        public Writer(@NotNull Buffer buffer0) {
            q.g(buffer0, "out");
            this(0, false, buffer0, 3, null);
        }

        private final void adjustDynamicTableByteCount() {
            int v = this.maxDynamicTableByteCount;
            int v1 = this.dynamicTableByteCount;
            if(v < v1) {
                if(v == 0) {
                    this.clearDynamicTable();
                    return;
                }
                this.evictToRecoverBytes(v1 - v);
            }
        }

        private final void clearDynamicTable() {
            n.f0(this.dynamicTable, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int evictToRecoverBytes(int v) {
            int v3;
            int v1 = 0;
            if(v > 0) {
                for(int v2 = this.dynamicTable.length - 1; true; --v2) {
                    v3 = this.nextHeaderIndex;
                    if(v2 < v3 || v <= 0) {
                        break;
                    }
                    Header header0 = this.dynamicTable[v2];
                    q.d(header0);
                    v -= header0.hpackSize;
                    int v4 = this.dynamicTableByteCount;
                    Header header1 = this.dynamicTable[v2];
                    q.d(header1);
                    this.dynamicTableByteCount = v4 - header1.hpackSize;
                    --this.headerCount;
                    ++v1;
                }
                System.arraycopy(this.dynamicTable, v3 + 1, this.dynamicTable, v3 + 1 + v1, this.headerCount);
                Arrays.fill(this.dynamicTable, this.nextHeaderIndex + 1, this.nextHeaderIndex + 1 + v1, null);
                this.nextHeaderIndex += v1;
            }
            return v1;
        }

        private final void insertIntoDynamicTable(Header header0) {
            int v = header0.hpackSize;
            int v1 = this.maxDynamicTableByteCount;
            if(v > v1) {
                this.clearDynamicTable();
                return;
            }
            this.evictToRecoverBytes(this.dynamicTableByteCount + v - v1);
            Header[] arr_header = this.dynamicTable;
            if(this.headerCount + 1 > arr_header.length) {
                Header[] arr_header1 = new Header[arr_header.length * 2];
                System.arraycopy(arr_header, 0, arr_header1, arr_header.length, arr_header.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = arr_header1;
            }
            int v2 = this.nextHeaderIndex;
            this.nextHeaderIndex = v2 - 1;
            this.dynamicTable[v2] = header0;
            ++this.headerCount;
            this.dynamicTableByteCount += v;
        }

        public final void resizeHeaderTable(int v) {
            this.headerTableSizeSetting = v;
            int v1 = Math.min(v, 0x4000);
            int v2 = this.maxDynamicTableByteCount;
            if(v2 == v1) {
                return;
            }
            if(v1 < v2) {
                this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, v1);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = v1;
            this.adjustDynamicTableByteCount();
        }

        public final void writeByteString(@NotNull ByteString byteString0) {
            q.g(byteString0, "data");
            if(this.useCompression) {
                Huffman huffman0 = Huffman.INSTANCE;
                if(huffman0.encodedLength(byteString0) < byteString0.size()) {
                    Buffer buffer0 = new Buffer();
                    huffman0.encode(byteString0, buffer0);
                    ByteString byteString1 = buffer0.readByteString();
                    this.writeInt(byteString1.size(), 0x7F, 0x80);
                    this.out.write(byteString1);
                    return;
                }
            }
            this.writeInt(byteString0.size(), 0x7F, 0);
            this.out.write(byteString0);
        }

        public final void writeHeaders(@NotNull List list0) {
            int v5;
            int v4;
            q.g(list0, "headerBlock");
            if(this.emitDynamicTableSizeUpdate) {
                int v = this.smallestHeaderTableSizeSetting;
                if(v < this.maxDynamicTableByteCount) {
                    this.writeInt(v, 0x1F, 0x20);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = 0x7FFFFFFF;
                this.writeInt(this.maxDynamicTableByteCount, 0x1F, 0x20);
            }
            int v1 = list0.size();
            int v2 = 0;
            while(v2 < v1) {
                Header header0 = (Header)list0.get(v2);
                ByteString byteString0 = header0.name.toAsciiLowercase();
                ByteString byteString1 = header0.value;
                Hpack hpack0 = Hpack.INSTANCE;
                Integer integer0 = (Integer)hpack0.getNAME_TO_FIRST_INDEX().get(byteString0);
                if(integer0 == null) {
                    v5 = -1;
                }
                else {
                    int v3 = (int)integer0;
                    v4 = v3 + 1;
                    if(2 <= v4 && v4 < 8) {
                        if(q.b(hpack0.getSTATIC_HEADER_TABLE()[v3].value, byteString1)) {
                            v5 = v4;
                            goto label_32;
                        }
                        else if(q.b(hpack0.getSTATIC_HEADER_TABLE()[v4].value, byteString1)) {
                            v5 = v4;
                            v4 = v3 + 2;
                            goto label_32;
                        }
                    }
                    v5 = v4;
                }
                v4 = -1;
            label_32:
                if(v4 == -1) {
                    for(int v6 = this.nextHeaderIndex + 1; v6 < this.dynamicTable.length; ++v6) {
                        Header header1 = this.dynamicTable[v6];
                        q.d(header1);
                        if(q.b(header1.name, byteString0)) {
                            Header header2 = this.dynamicTable[v6];
                            q.d(header2);
                            if(q.b(header2.value, byteString1)) {
                                v4 = Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length + (v6 - this.nextHeaderIndex);
                                break;
                            }
                            else if(v5 == -1) {
                                v5 = v6 - this.nextHeaderIndex + Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length;
                            }
                        }
                    }
                }
                if(v4 != -1) {
                    this.writeInt(v4, 0x7F, 0x80);
                }
                else if(v5 == -1) {
                    this.out.writeByte(0x40);
                    this.writeByteString(byteString0);
                    this.writeByteString(byteString1);
                    this.insertIntoDynamicTable(header0);
                }
                else if(!byteString0.startsWith(Header.PSEUDO_PREFIX) || q.b(Header.TARGET_AUTHORITY, byteString0)) {
                    this.writeInt(v5, 0x3F, 0x40);
                    this.writeByteString(byteString1);
                    this.insertIntoDynamicTable(header0);
                }
                else {
                    this.writeInt(v5, 15, 0);
                    this.writeByteString(byteString1);
                }
                ++v2;
            }
        }

        public final void writeInt(int v, int v1, int v2) {
            if(v < v1) {
                this.out.writeByte(v | v2);
                return;
            }
            this.out.writeByte(v2 | v1);
            int v3;
            for(v3 = v - v1; v3 >= 0x80; v3 >>>= 7) {
                this.out.writeByte(0x80 | v3 & 0x7F);
            }
            this.out.writeByte(v3);
        }
    }

    @NotNull
    public static final Hpack INSTANCE = null;
    @NotNull
    private static final Map NAME_TO_FIRST_INDEX = null;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 0x1F;
    private static final int PREFIX_6_BITS = 0x3F;
    private static final int PREFIX_7_BITS = 0x7F;
    private static final int SETTINGS_HEADER_TABLE_SIZE = 0x1000;
    private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 0x4000;
    @NotNull
    private static final Header[] STATIC_HEADER_TABLE;

    static {
        Hpack hpack0 = new Hpack();
        Hpack.INSTANCE = hpack0;
        Hpack.STATIC_HEADER_TABLE = new Header[]{new Header(Header.TARGET_AUTHORITY, ""), new Header(Header.TARGET_METHOD, "GET"), new Header(Header.TARGET_METHOD, "POST"), new Header(Header.TARGET_PATH, "/"), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, "http"), new Header(Header.TARGET_SCHEME, "https"), new Header(Header.RESPONSE_STATUS, "200"), new Header(Header.RESPONSE_STATUS, "204"), new Header(Header.RESPONSE_STATUS, "206"), new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        Hpack.NAME_TO_FIRST_INDEX = hpack0.nameToFirstIndex();
    }

    @NotNull
    public final ByteString checkLowercase(@NotNull ByteString byteString0) {
        q.g(byteString0, "name");
        int v = byteString0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            int v2 = byteString0.getByte(v1);
            if(65 <= v2 && v2 < 91) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString0.utf8());
            }
        }
        return byteString0;
    }

    @NotNull
    public final Map getNAME_TO_FIRST_INDEX() {
        return Hpack.NAME_TO_FIRST_INDEX;
    }

    @NotNull
    public final Header[] getSTATIC_HEADER_TABLE() {
        return Hpack.STATIC_HEADER_TABLE;
    }

    private final Map nameToFirstIndex() {
        LinkedHashMap linkedHashMap0 = new LinkedHashMap(Hpack.STATIC_HEADER_TABLE.length);
        for(int v = 0; v < Hpack.STATIC_HEADER_TABLE.length; ++v) {
            Header[] arr_header = Hpack.STATIC_HEADER_TABLE;
            if(!linkedHashMap0.containsKey(arr_header[v].name)) {
                linkedHashMap0.put(arr_header[v].name, v);
            }
        }
        Map map0 = Collections.unmodifiableMap(linkedHashMap0);
        q.f(map0, "unmodifiableMap(result)");
        return map0;
    }
}

