package okio;

import com.iloen.melon.utils.a;
import e.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import je.f;
import je.l;
import je.t;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000E\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0018B!\b\u0002\u0012\u000E\u0010\u0006\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001A\u00020\u00022\u0006\u0010\f\u001A\u00020\u000BH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000ER\"\u0010\u0006\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u000F\u001A\u0004\b\u0010\u0010\u0011R\u001A\u0010\b\u001A\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lokio/Options;", "Lje/f;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "byteStrings", "", "trie", "<init>", "([Lokio/ByteString;[I)V", "", "index", "get", "(I)Lokio/ByteString;", "[Lokio/ByteString;", "getByteStrings$okio", "()[Lokio/ByteString;", "[I", "getTrie$okio", "()[I", "getSize", "()I", "size", "Companion", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class Options extends f implements RandomAccess {
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J[\u0010\u0011\u001A\u00020\u00102\b\b\u0002\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\b\b\u0002\u0010\t\u001A\u00020\b2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\b\b\u0002\u0010\r\u001A\u00020\b2\b\b\u0002\u0010\u000E\u001A\u00020\b2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\b0\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0015\u001A\u00020\u00142\u0012\u0010\f\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u000B0\u0013\"\u00020\u000BH\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001A\u00020\u0004*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018¨\u0006\u001A"}, d2 = {"Lokio/Options$Companion;", "", "<init>", "()V", "", "nodeOffset", "Lokio/Buffer;", "node", "", "byteStringOffset", "", "Lokio/ByteString;", "byteStrings", "fromIndex", "toIndex", "indexes", "Lie/H;", "buildTrieRecursive", "(JLokio/Buffer;ILjava/util/List;IILjava/util/List;)V", "", "Lokio/Options;", "of", "([Lokio/ByteString;)Lokio/Options;", "getIntCount", "(Lokio/Buffer;)J", "intCount", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        private final void buildTrieRecursive(long v, Buffer buffer0, int v1, List list0, int v2, int v3, List list1) {
            long v15;
            int v14;
            int v6;
            int v5;
            if(v2 >= v3) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            for(int v4 = v2; v4 < v3; ++v4) {
                if(((ByteString)list0.get(v4)).size() < v1) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
            }
            ByteString byteString0 = (ByteString)list0.get(v2);
            ByteString byteString1 = (ByteString)list0.get(v3 - 1);
            if(v1 == byteString0.size()) {
                v5 = v2 + 1;
                v6 = ((Number)list1.get(v2)).intValue();
                byteString0 = (ByteString)list0.get(v2 + 1);
            }
            else {
                v5 = v2;
                v6 = -1;
            }
            if(byteString0.getByte(v1) != byteString1.getByte(v1)) {
                int v7 = v5 + 1;
                int v8 = 1;
                while(v7 < v3) {
                    if(((ByteString)list0.get(v7 - 1)).getByte(v1) != ((ByteString)list0.get(v7)).getByte(v1)) {
                        ++v8;
                    }
                    ++v7;
                }
                long v9 = v + this.getIntCount(buffer0) + 2L + ((long)(v8 * 2));
                buffer0.writeInt(v8);
                buffer0.writeInt(v6);
                for(int v10 = v5; v10 < v3; ++v10) {
                    int v11 = ((ByteString)list0.get(v10)).getByte(v1);
                    if(v10 == v5 || v11 != ((ByteString)list0.get(v10 - 1)).getByte(v1)) {
                        buffer0.writeInt(v11 & 0xFF);
                    }
                }
                Buffer buffer1 = new Buffer();
                while(v5 < v3) {
                    int v12 = ((ByteString)list0.get(v5)).getByte(v1);
                    int v13 = v5 + 1;
                    while(true) {
                        if(v13 < v3) {
                            if(v12 == ((ByteString)list0.get(v13)).getByte(v1)) {
                                ++v13;
                                continue;
                            }
                            else {
                                v14 = v13;
                                break;
                            }
                        }
                        v14 = v3;
                        break;
                    }
                    if(v5 + 1 != v14 || v1 + 1 != ((ByteString)list0.get(v5)).size()) {
                        buffer0.writeInt(-((int)(this.getIntCount(buffer1) + v9)));
                        v15 = v9;
                        this.buildTrieRecursive(v15, buffer1, v1 + 1, list0, v5, v14, list1);
                    }
                    else {
                        buffer0.writeInt(((Number)list1.get(v5)).intValue());
                        v15 = v9;
                    }
                    v9 = v15;
                    v5 = v14;
                }
                buffer0.writeAll(buffer1);
                return;
            }
            int v16 = Math.min(byteString0.size(), byteString1.size());
            int v17 = 0;
            for(int v18 = v1; v18 < v16 && byteString0.getByte(v18) == byteString1.getByte(v18); ++v18) {
                ++v17;
            }
            long v19 = this.getIntCount(buffer0);
            buffer0.writeInt(-v17);
            buffer0.writeInt(v6);
            int v20 = v1 + v17;
            while(v1 < v20) {
                buffer0.writeInt(byteString0.getByte(v1) & 0xFF);
                ++v1;
            }
            if(v5 + 1 == v3) {
                if(v20 != ((ByteString)list0.get(v5)).size()) {
                    throw new IllegalStateException("Check failed.");
                }
                buffer0.writeInt(((Number)list1.get(v5)).intValue());
                return;
            }
            long v21 = v + v19 + 2L + ((long)v17) + 1L;
            Buffer buffer2 = new Buffer();
            buffer0.writeInt(-((int)(this.getIntCount(buffer2) + v21)));
            this.buildTrieRecursive(v21, buffer2, v20, list0, v5, v3, list1);
            buffer0.writeAll(buffer2);
        }

        public static void buildTrieRecursive$default(Companion options$Companion0, long v, Buffer buffer0, int v1, List list0, int v2, int v3, List list1, int v4, Object object0) {
            if((v4 & 1) != 0) {
                v = 0L;
            }
            options$Companion0.buildTrieRecursive(v, buffer0, ((v4 & 4) == 0 ? v1 : 0), list0, ((v4 & 16) == 0 ? v2 : 0), ((v4 & 0x20) == 0 ? v3 : list0.size()), list1);
        }

        private final long getIntCount(Buffer buffer0) {
            return buffer0.size() / 4L;
        }

        @NotNull
        public final Options of(@NotNull ByteString[] arr_byteString) {
            q.g(arr_byteString, "byteStrings");
            if(arr_byteString.length == 0) {
                return new Options(new ByteString[0], new int[]{0, -1}, null);
            }
            ArrayList arrayList0 = new ArrayList(new l(arr_byteString, false));
            t.R(arrayList0);
            int v1 = arrayList0.size();
            ArrayList arrayList1 = new ArrayList(v1);
            for(int v2 = 0; v2 < v1; v2 = a.d(-1, v2, 1, arrayList1)) {
            }
            int v3 = 0;
            for(int v4 = 0; v3 < arr_byteString.length; ++v4) {
                arrayList1.set(k.g(arrayList0, arr_byteString[v3]), v4);
                ++v3;
            }
            if(((ByteString)arrayList0.get(0)).size() <= 0) {
                throw new IllegalArgumentException("the empty byte string is not a supported option");
            }
            for(int v5 = 0; v5 < arrayList0.size(); ++v5) {
                ByteString byteString0 = (ByteString)arrayList0.get(v5);
                int v6 = v5 + 1;
                while(v6 < arrayList0.size()) {
                    ByteString byteString1 = (ByteString)arrayList0.get(v6);
                    if(!byteString1.startsWith(byteString0)) {
                        break;
                    }
                    if(byteString1.size() == byteString0.size()) {
                        throw new IllegalArgumentException(("duplicate option: " + byteString1).toString());
                    }
                    if(((Number)arrayList1.get(v6)).intValue() > ((Number)arrayList1.get(v5)).intValue()) {
                        arrayList0.remove(v6);
                        ((Number)arrayList1.remove(v6)).intValue();
                    }
                    else {
                        ++v6;
                    }
                }
            }
            Buffer buffer0 = new Buffer();
            Companion.buildTrieRecursive$default(this, 0L, buffer0, 0, arrayList0, 0, 0, arrayList1, 53, null);
            int v7 = (int)this.getIntCount(buffer0);
            int[] arr_v = new int[v7];
            for(int v = 0; v < v7; ++v) {
                arr_v[v] = buffer0.readInt();
            }
            Object[] arr_object = Arrays.copyOf(arr_byteString, arr_byteString.length);
            q.f(arr_object, "copyOf(...)");
            return new Options(((ByteString[])arr_object), arr_v, null);
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final ByteString[] byteStrings;
    @NotNull
    private final int[] trie;

    static {
        Options.Companion = new Companion(null);
    }

    private Options(ByteString[] arr_byteString, int[] arr_v) {
        this.byteStrings = arr_byteString;
        this.trie = arr_v;
    }

    public Options(ByteString[] arr_byteString, int[] arr_v, DefaultConstructorMarker defaultConstructorMarker0) {
        this(arr_byteString, arr_v);
    }

    @Override  // je.a
    public final boolean contains(Object object0) {
        return object0 instanceof ByteString ? this.contains(((ByteString)object0)) : false;
    }

    public boolean contains(ByteString byteString0) {
        return super.contains(byteString0);
    }

    @Override
    public Object get(int v) {
        return this.get(v);
    }

    @NotNull
    public ByteString get(int v) {
        return this.byteStrings[v];
    }

    @NotNull
    public final ByteString[] getByteStrings$okio() {
        return this.byteStrings;
    }

    @Override  // je.a
    public int getSize() {
        return this.byteStrings.length;
    }

    @NotNull
    public final int[] getTrie$okio() {
        return this.trie;
    }

    @Override  // je.f
    public final int indexOf(Object object0) {
        return object0 instanceof ByteString ? this.indexOf(((ByteString)object0)) : -1;
    }

    public int indexOf(ByteString byteString0) {
        return super.indexOf(byteString0);
    }

    @Override  // je.f
    public final int lastIndexOf(Object object0) {
        return object0 instanceof ByteString ? this.lastIndexOf(((ByteString)object0)) : -1;
    }

    public int lastIndexOf(ByteString byteString0) {
        return super.lastIndexOf(byteString0);
    }

    @NotNull
    public static final Options of(@NotNull ByteString[] arr_byteString) {
        return Options.Companion.of(arr_byteString);
    }
}

