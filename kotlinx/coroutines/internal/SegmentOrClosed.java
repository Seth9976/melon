package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\t\b\u0081@\u0018\u0000*\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003B\u0011\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\n\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0017\u0010\u000F\u001A\u00028\u00008F¢\u0006\f\u0012\u0004\b\r\u0010\u000E\u001A\u0004\b\u000B\u0010\f\u0088\u0001\u0004\u0092\u0001\u0004\u0018\u00010\u0003¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/internal/SegmentOrClosed;", "Lkotlinx/coroutines/internal/Segment;", "S", "", "value", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "isClosed-impl", "(Ljava/lang/Object;)Z", "isClosed", "getSegment-impl", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/Segment;", "getSegment$annotations", "()V", "segment", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public abstract class SegmentOrClosed {
    @NotNull
    public static Object constructor-impl(@Nullable Object object0) [...] // Inlined contents

    @NotNull
    public static final Segment getSegment-impl(Object object0) {
        if(object0 == ConcurrentLinkedListKt.CLOSED) {
            throw new IllegalStateException("Does not contain segment");
        }
        q.e(object0, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (Segment)object0;
    }

    public static final boolean isClosed-impl(Object object0) {
        return object0 == ConcurrentLinkedListKt.CLOSED;
    }
}

