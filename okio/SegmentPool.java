package okio;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000BH\u0002¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000F\u001A\u00020\u000E8\u0006¢\u0006\f\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001A\u00020\u000E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0010R\"\u0010\u0017\u001A\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000B0\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001A\u001A\u00020\u000E8F¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u0012¨\u0006\u001B"}, d2 = {"Lokio/SegmentPool;", "", "<init>", "()V", "Lokio/Segment;", "take", "()Lokio/Segment;", "segment", "Lie/H;", "recycle", "(Lokio/Segment;)V", "Ljava/util/concurrent/atomic/AtomicReference;", "firstRef", "()Ljava/util/concurrent/atomic/AtomicReference;", "", "MAX_SIZE", "I", "getMAX_SIZE", "()I", "LOCK", "Lokio/Segment;", "HASH_BUCKET_COUNT", "", "hashBuckets", "[Ljava/util/concurrent/atomic/AtomicReference;", "getByteCount", "byteCount", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class SegmentPool {
    private static final int HASH_BUCKET_COUNT;
    @NotNull
    public static final SegmentPool INSTANCE;
    @NotNull
    private static final Segment LOCK;
    private static final int MAX_SIZE;
    @NotNull
    private static final AtomicReference[] hashBuckets;

    static {
        SegmentPool.INSTANCE = new SegmentPool();
        SegmentPool.MAX_SIZE = 0x10000;
        SegmentPool.LOCK = new Segment(new byte[0], 0, 0, false, false);
        int v1 = Integer.highestOneBit(Runtime.getRuntime().availableProcessors() * 2 - 1);
        SegmentPool.HASH_BUCKET_COUNT = v1;
        AtomicReference[] arr_atomicReference = new AtomicReference[v1];
        for(int v = 0; v < v1; ++v) {
            arr_atomicReference[v] = new AtomicReference();
        }
        SegmentPool.hashBuckets = arr_atomicReference;
    }

    private final AtomicReference firstRef() {
        return SegmentPool.hashBuckets[((int)(Thread.currentThread().getId() & 7L))];
    }

    public final int getByteCount() {
        Segment segment0 = (Segment)this.firstRef().get();
        return segment0 == null ? 0 : segment0.limit;
    }

    public final int getMAX_SIZE() {
        return 0x10000;
    }

    public static final void recycle(@NotNull Segment segment0) {
        q.g(segment0, "segment");
        if(segment0.next != null || segment0.prev != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if(!segment0.shared) {
            AtomicReference atomicReference0 = SegmentPool.INSTANCE.firstRef();
            Segment segment1 = (Segment)atomicReference0.getAndSet(SegmentPool.LOCK);
            if(segment1 != SegmentPool.LOCK) {
                int v = segment1 == null ? 0 : segment1.limit;
                if(v >= 0x10000) {
                    atomicReference0.set(segment1);
                    return;
                }
                segment0.next = segment1;
                segment0.pos = 0;
                segment0.limit = v + 0x2000;
                atomicReference0.set(segment0);
            }
        }
    }

    @NotNull
    public static final Segment take() {
        AtomicReference atomicReference0 = SegmentPool.INSTANCE.firstRef();
        Segment segment0 = (Segment)atomicReference0.getAndSet(SegmentPool.LOCK);
        if(segment0 == SegmentPool.LOCK) {
            return new Segment();
        }
        if(segment0 == null) {
            atomicReference0.set(null);
            return new Segment();
        }
        atomicReference0.set(segment0.next);
        segment0.next = null;
        segment0.limit = 0;
        return segment0;
    }
}

