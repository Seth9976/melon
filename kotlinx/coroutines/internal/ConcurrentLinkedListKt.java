package kotlinx.coroutines.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import we.n;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001AK\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\u0006\u0010\u0003\u001A\u00020\u00022\u0018\u0010\u0005\u001A\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001A#\u0010\u000B\u001A\u00028\u0000\"\u000E\b\u0000\u0010\n*\b\u0012\u0004\u0012\u00028\u00000\t*\u00028\u0000H\u0000¢\u0006\u0004\b\u000B\u0010\f\u001A0\u0010\u0013\u001A\u00020\u0011*\u00020\r2\u0006\u0010\u000F\u001A\u00020\u000E2\u0012\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u00110\u0010H\u0082\b¢\u0006\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0016\u001A\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/internal/Segment;", "S", "", "id", "Lkotlin/Function2;", "createNewSegment", "Lkotlinx/coroutines/internal/SegmentOrClosed;", "findSegmentInternal", "(Lkotlinx/coroutines/internal/Segment;JLwe/n;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "N", "close", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "Lkotlinx/atomicfu/AtomicInt;", "", "delta", "Lkotlin/Function1;", "", "condition", "addConditionally", "(Lkotlinx/atomicfu/AtomicInt;ILwe/k;)Z", "Lkotlinx/coroutines/internal/Symbol;", "CLOSED", "Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class ConcurrentLinkedListKt {
    @NotNull
    private static final Symbol CLOSED;

    static {
        ConcurrentLinkedListKt.CLOSED = new Symbol("CLOSED");
    }

    @NotNull
    public static final ConcurrentLinkedListNode close(@NotNull ConcurrentLinkedListNode concurrentLinkedListNode0) {
        while(true) {
            Object object0 = ConcurrentLinkedListNode.access$getNextOrClosed(concurrentLinkedListNode0);
            if(object0 == ConcurrentLinkedListKt.CLOSED) {
                return concurrentLinkedListNode0;
            }
            if(((ConcurrentLinkedListNode)object0) == null) {
                if(!concurrentLinkedListNode0.markAsClosed()) {
                    continue;
                }
                return concurrentLinkedListNode0;
            }
            concurrentLinkedListNode0 = (ConcurrentLinkedListNode)object0;
        }
    }

    @NotNull
    public static final Object findSegmentInternal(@NotNull Segment segment0, long v, @NotNull n n0) {
        while(true) {
            if(segment0.id >= v && !segment0.isRemoved()) {
                return segment0;
            }
            Object object0 = segment0.getNextOrClosed();
            if(object0 == ConcurrentLinkedListKt.CLOSED) {
                return ConcurrentLinkedListKt.CLOSED;
            }
            Segment segment1 = (Segment)(((ConcurrentLinkedListNode)object0));
            if(segment1 == null) {
                segment1 = (Segment)n0.invoke(((long)(segment0.id + 1L)), segment0);
                if(!segment0.trySetNext(segment1)) {
                    continue;
                }
                if(segment0.isRemoved()) {
                    segment0.remove();
                }
            }
            segment0 = segment1;
        }
    }
}

