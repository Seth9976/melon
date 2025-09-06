package okio.internal;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0001H\u0000¨\u0006\u0004"}, d2 = {"setBitsOrZero", "", "Ljava/util/concurrent/atomic/AtomicInteger;", "bits", "okio"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public final class _AtomicKt {
    public static final int setBitsOrZero(@NotNull AtomicInteger atomicInteger0, int v) {
        int v2;
        q.g(atomicInteger0, "<this>");
        do {
            int v1 = atomicInteger0.get();
            if((v1 & v) != 0) {
                return 0;
            }
            v2 = v1 | v;
        }
        while(!atomicInteger0.compareAndSet(v1, v2));
        return v2;
    }
}

