package okio;

import java.util.List;
import java.util.RandomAccess;
import je.f;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000E\u0018\u0000 \u0019*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00060\u0004j\u0002`\u0005:\u0001\u0019B\u001D\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\n\u0010\u000BJ\u0018\u0010\u000E\u001A\u00028\u00002\u0006\u0010\r\u001A\u00020\fH\u0096\u0002¢\u0006\u0004\b\u000E\u0010\u000FR\u001A\u0010\t\u001A\u00020\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012R \u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001A\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0017¨\u0006\u001A"}, d2 = {"Lokio/TypedOptions;", "", "T", "Lje/f;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "list", "Lokio/Options;", "options", "<init>", "(Ljava/util/List;Lokio/Options;)V", "", "index", "get", "(I)Ljava/lang/Object;", "Lokio/Options;", "getOptions$okio", "()Lokio/Options;", "Ljava/util/List;", "getList$okio", "()Ljava/util/List;", "getSize", "()I", "size", "Companion", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class TypedOptions extends f implements RandomAccess {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u001C\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00010\n\"\b\b\u0001\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00010\u00052\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\b0\u0007H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u000B\u0010\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lokio/TypedOptions$Companion;", "", "<init>", "()V", "T", "", "values", "Lkotlin/Function1;", "Lokio/ByteString;", "encode", "Lokio/TypedOptions;", "of", "(Ljava/lang/Iterable;Lwe/k;)Lokio/TypedOptions;", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final TypedOptions of(@NotNull Iterable iterable0, @NotNull k k0) {
            q.g(iterable0, "values");
            q.g(k0, "encode");
            List list0 = p.P0(iterable0);
            okio.Options.Companion options$Companion0 = Options.Companion;
            int v = list0.size();
            ByteString[] arr_byteString = new ByteString[v];
            for(int v1 = 0; v1 < v; ++v1) {
                arr_byteString[v1] = k0.invoke(list0.get(v1));
            }
            return new TypedOptions(list0, options$Companion0.of(arr_byteString));
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final List list;
    @NotNull
    private final Options options;

    static {
        TypedOptions.Companion = new Companion(null);
    }

    public TypedOptions(@NotNull List list0, @NotNull Options options0) {
        q.g(list0, "list");
        q.g(options0, "options");
        super();
        this.options = options0;
        List list1 = p.P0(list0);
        this.list = list1;
        if(list1.size() != options0.size()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    @Override
    @NotNull
    public Object get(int v) {
        return this.list.get(v);
    }

    @NotNull
    public final List getList$okio() {
        return this.list;
    }

    @NotNull
    public final Options getOptions$okio() {
        return this.options;
    }

    @Override  // je.a
    public int getSize() {
        return this.list.size();
    }

    @NotNull
    public static final TypedOptions of(@NotNull Iterable iterable0, @NotNull k k0) {
        return TypedOptions.Companion.of(iterable0, k0);
    }
}

