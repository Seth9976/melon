package co.ab180.airbridge.internal.z;

import java.io.Closeable;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import we.a;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\b\"\u0006\b\u0000\u0010\u0004\u0018\u00012\u0018\b\b\u0010\u0007\u001A\u0012\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0006H\u0086\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000B\u001A\u00028\u0000\"\u0006\b\u0000\u0010\u0004\u0018\u0001H\u0086\b¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\u000E\u001A\u00020\rH\u0016¢\u0006\u0004\b\u000E\u0010\u0003R/\u0010\u0014\u001A\u001A\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u000Fj\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b`\u00108\u0006¢\u0006\f\n\u0004\b\t\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"Lco/ab180/airbridge/internal/z/j;", "Ljava/io/Closeable;", "<init>", "()V", "T", "Lkotlin/Function0;", "Lco/ab180/airbridge/internal/di/DebrisDefinitions;", "definition", "Lco/ab180/airbridge/internal/z/c;", "a", "(Lwe/a;)Lco/ab180/airbridge/internal/z/c;", "h", "()Ljava/lang/Object;", "Lie/H;", "close", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "m", "()Ljava/util/HashSet;", "beans", "airbridge_release"}, k = 1, mv = {1, 4, 3})
public final class j implements Closeable {
    @NotNull
    private final HashSet a;

    public j() {
        this.a = new HashSet();
    }

    public final c a(a a0) {
        q.g(a0, "definition");
        q.k();
        throw null;
    }

    @Override
    public void close() {
        for(Object object0: this.a) {
            ((c)object0).close();
        }
    }

    public final Object h() {
        h.b.a();
        q.k();
        throw null;
    }

    @NotNull
    public final HashSet m() {
        return this.a;
    }
}

