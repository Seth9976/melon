package kotlinx.coroutines.sync;

import Bd.e;
import e1.u;
import ie.H;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;
import me.i;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.o;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nH\u0086@¢\u0006\u0004\b\u000B\u0010\fJ\u001D\u0010\u000B\u001A\u00020\n2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\n0\rH\u0005¢\u0006\u0004\b\u000B\u0010\u000FJ\r\u0010\u0010\u001A\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001A\u00020\nH\u0082@¢\u0006\u0004\b\u0012\u0010\fJ\u000F\u0010\u0013\u001A\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0015\u001A\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\u0011J\u0017\u0010\u0017\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000F\u0010\u0019\u001A\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\tJ\u0013\u0010\u001A\u001A\u00020\u0007*\u00020\u0001H\u0002¢\u0006\u0004\b\u001A\u0010\u001BR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001CR,\u0010 \u001A\u001A\u0012\u0004\u0012\u00020\u001E\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001F\u0012\u0004\u0012\u00020\n0\u001D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0011\u0010#\u001A\u00020\u00028F¢\u0006\u0006\u001A\u0004\b\"\u0010\u0014R\u0011\u0010&\u001A\b\u0012\u0004\u0012\u00020%0$8\u0002X\u0082\u0004R\u000B\u0010(\u001A\u00020\'8\u0002X\u0082\u0004R\u0011\u0010)\u001A\b\u0012\u0004\u0012\u00020%0$8\u0002X\u0082\u0004R\u000B\u0010*\u001A\u00020\'8\u0002X\u0082\u0004R\u000B\u0010,\u001A\u00020+8\u0002X\u0082\u0004¨\u0006-"}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreAndMutexImpl;", "", "", "permits", "acquiredPermits", "<init>", "(II)V", "", "tryAcquire", "()Z", "Lie/H;", "acquire", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CancellableContinuation;", "waiter", "(Lkotlinx/coroutines/CancellableContinuation;)V", "release", "()V", "acquireSlowPath", "decPermits", "()I", "coerceAvailablePermitsAtMaximum", "Lkotlinx/coroutines/Waiter;", "addAcquireToQueue", "(Lkotlinx/coroutines/Waiter;)Z", "tryResumeNextFromQueue", "tryResumeAcquire", "(Ljava/lang/Object;)Z", "I", "Lkotlin/Function3;", "", "Lme/i;", "onCancellationRelease", "Lwe/o;", "getAvailablePermits", "availablePermits", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "head", "Lkotlinx/atomicfu/AtomicLong;", "deqIdx", "tail", "enqIdx", "Lkotlinx/atomicfu/AtomicInt;", "_availablePermits", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public class SemaphoreAndMutexImpl {
    private volatile int _availablePermits$volatile;
    private static final AtomicIntegerFieldUpdater _availablePermits$volatile$FU;
    private volatile long deqIdx$volatile;
    private static final AtomicLongFieldUpdater deqIdx$volatile$FU;
    private volatile long enqIdx$volatile;
    private static final AtomicLongFieldUpdater enqIdx$volatile$FU;
    private volatile Object head$volatile;
    private static final AtomicReferenceFieldUpdater head$volatile$FU;
    @NotNull
    private final o onCancellationRelease;
    private final int permits;
    private volatile Object tail$volatile;
    private static final AtomicReferenceFieldUpdater tail$volatile$FU;

    static {
        SemaphoreAndMutexImpl.head$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, Object.class, "head$volatile");
        SemaphoreAndMutexImpl.deqIdx$volatile$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "deqIdx$volatile");
        SemaphoreAndMutexImpl.tail$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, Object.class, "tail$volatile");
        SemaphoreAndMutexImpl.enqIdx$volatile$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "enqIdx$volatile");
        SemaphoreAndMutexImpl._availablePermits$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "_availablePermits$volatile");
    }

    public SemaphoreAndMutexImpl(int v, int v1) {
        this.permits = v;
        if(v <= 0) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + v).toString());
        }
        if(v1 < 0 || v1 > v) {
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + v).toString());
        }
        SemaphoreSegment semaphoreSegment0 = new SemaphoreSegment(0L, null, 2);
        this.head$volatile = semaphoreSegment0;
        this.tail$volatile = semaphoreSegment0;
        this._availablePermits$volatile = v - v1;
        this.onCancellationRelease = new e(this, 17);
    }

    public static H a(SemaphoreAndMutexImpl semaphoreAndMutexImpl0, Throwable throwable0, H h0, i i0) {
        return SemaphoreAndMutexImpl.onCancellationRelease$lambda$2(semaphoreAndMutexImpl0, throwable0, h0, i0);
    }

    @Nullable
    public final Object acquire(@NotNull Continuation continuation0) {
        int v = this.decPermits();
        H h0 = H.a;
        if(v > 0) {
            return h0;
        }
        Object object0 = this.acquireSlowPath(continuation0);
        return object0 == a.a ? object0 : h0;
    }

    public final void acquire(@NotNull CancellableContinuation cancellableContinuation0) {
        do {
            if(this.decPermits() > 0) {
                cancellableContinuation0.resume(H.a, this.onCancellationRelease);
                return;
            }
            q.e(cancellableContinuation0, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
        }
        while(!this.addAcquireToQueue(((Waiter)cancellableContinuation0)));
    }

    private final Object acquireSlowPath(Continuation continuation0) {
        CancellableContinuationImpl cancellableContinuationImpl0 = CancellableContinuationKt.getOrCreateCancellableContinuation(u.D(continuation0));
        try {
            if(!this.addAcquireToQueue(cancellableContinuationImpl0)) {
                this.acquire(cancellableContinuationImpl0);
            }
        }
        catch(Throwable throwable0) {
            cancellableContinuationImpl0.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw throwable0;
        }
        Object object0 = cancellableContinuationImpl0.getResult();
        return object0 == a.a ? object0 : H.a;
    }

    private final boolean addAcquireToQueue(Waiter waiter0) {
        Object object0;
        SemaphoreSegment semaphoreSegment0 = (SemaphoreSegment)SemaphoreAndMutexImpl.tail$volatile$FU.get(this);
        long v = SemaphoreAndMutexImpl.enqIdx$volatile$FU.getAndIncrement(this);
        kotlinx.coroutines.sync.SemaphoreAndMutexImpl.addAcquireToQueue.createNewSegment.1 semaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$10 = kotlinx.coroutines.sync.SemaphoreAndMutexImpl.addAcquireToQueue.createNewSegment.1.INSTANCE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = SemaphoreAndMutexImpl.tail$volatile$FU;
        while(true) {
            object0 = ConcurrentLinkedListKt.findSegmentInternal(semaphoreSegment0, v / 16L, semaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$10);
            if(SegmentOrClosed.isClosed-impl(object0)) {
                goto label_22;
            }
            Segment segment0 = SegmentOrClosed.getSegment-impl(object0);
            while(true) {
                Segment segment1 = (Segment)atomicReferenceFieldUpdater0.get(this);
                if(segment1.id >= segment0.id) {
                    goto label_22;
                }
                if(!segment0.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                }
                do {
                    if(atomicReferenceFieldUpdater0.compareAndSet(this, segment1, segment0)) {
                        if(!segment1.decPointers$kotlinx_coroutines_core()) {
                            goto label_22;
                        }
                        segment1.remove();
                        goto label_22;
                    }
                }
                while(atomicReferenceFieldUpdater0.get(this) == segment1);
                if(segment0.decPointers$kotlinx_coroutines_core()) {
                    segment0.remove();
                }
            }
        }
        SemaphoreSegment semaphoreSegment1 = (SemaphoreSegment)SegmentOrClosed.getSegment-impl(object0);
        AtomicReferenceArray atomicReferenceArray0 = semaphoreSegment1.getAcquirers();
        goto label_24;
    label_22:
        semaphoreSegment1 = (SemaphoreSegment)SegmentOrClosed.getSegment-impl(object0);
        atomicReferenceArray0 = semaphoreSegment1.getAcquirers();
        do {
        label_24:
            if(atomicReferenceArray0.compareAndSet(((int)(v % 16L)), null, waiter0)) {
                waiter0.invokeOnCancellation(semaphoreSegment1, ((int)(v % 16L)));
                return true;
            }
        }
        while(atomicReferenceArray0.get(((int)(v % 16L))) == null);
        Symbol symbol0 = SemaphoreKt.access$getPERMIT$p();
        Symbol symbol1 = SemaphoreKt.access$getTAKEN$p();
        AtomicReferenceArray atomicReferenceArray1 = semaphoreSegment1.getAcquirers();
        do {
            if(atomicReferenceArray1.compareAndSet(((int)(v % 16L)), symbol0, symbol1)) {
                H h0 = H.a;
                if(waiter0 instanceof CancellableContinuation) {
                    q.e(waiter0, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
                    ((CancellableContinuation)waiter0).resume(h0, this.onCancellationRelease);
                    return true;
                }
                if(!(waiter0 instanceof SelectInstance)) {
                    throw new IllegalStateException(("unexpected: " + waiter0).toString());
                }
                ((SelectInstance)waiter0).selectInRegistrationPhase(h0);
                return true;
            }
        }
        while(atomicReferenceArray1.get(((int)(v % 16L))) == symbol0);
        return false;

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 0x30)
        final class kotlinx.coroutines.sync.SemaphoreAndMutexImpl.addAcquireToQueue.createNewSegment.1 extends n implements we.n {
            public static final kotlinx.coroutines.sync.SemaphoreAndMutexImpl.addAcquireToQueue.createNewSegment.1 INSTANCE;

            static {
                kotlinx.coroutines.sync.SemaphoreAndMutexImpl.addAcquireToQueue.createNewSegment.1.INSTANCE = new kotlinx.coroutines.sync.SemaphoreAndMutexImpl.addAcquireToQueue.createNewSegment.1();
            }

            public kotlinx.coroutines.sync.SemaphoreAndMutexImpl.addAcquireToQueue.createNewSegment.1() {
                super(2, SemaphoreKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((Number)object0).longValue(), ((SemaphoreSegment)object1));
            }

            public final SemaphoreSegment invoke(long v, SemaphoreSegment semaphoreSegment0) {
                return SemaphoreKt.access$createSegment(v, semaphoreSegment0);
            }
        }

    }

    private final void coerceAvailablePermitsAtMaximum() {
        do {
            int v = SemaphoreAndMutexImpl.get_availablePermits$volatile$FU().get(this);
        }
        while(v > this.permits && !SemaphoreAndMutexImpl.get_availablePermits$volatile$FU().compareAndSet(this, v, this.permits));
    }

    private final int decPermits() {
        int v;
        do {
            v = SemaphoreAndMutexImpl.get_availablePermits$volatile$FU().getAndDecrement(this);
        }
        while(v > this.permits);
        return v;
    }

    public final int getAvailablePermits() {
        return Math.max(SemaphoreAndMutexImpl._availablePermits$volatile$FU.get(this), 0);
    }

    private static final H onCancellationRelease$lambda$2(SemaphoreAndMutexImpl semaphoreAndMutexImpl0, Throwable throwable0, H h0, i i0) {
        semaphoreAndMutexImpl0.release();
        return H.a;
    }

    public final void release() {
        int v;
        while((v = SemaphoreAndMutexImpl._availablePermits$volatile$FU.getAndIncrement(this)) < this.permits) {
            if(v >= 0 || this.tryResumeNextFromQueue()) {
                return;
            }
        }
        this.coerceAvailablePermitsAtMaximum();
        throw new IllegalStateException(("The number of released permits cannot be greater than " + this.permits).toString());
    }

    public final boolean tryAcquire() {
        while(true) {
            int v = SemaphoreAndMutexImpl._availablePermits$volatile$FU.get(this);
            if(v > this.permits) {
                this.coerceAvailablePermitsAtMaximum();
            }
            else {
                if(v <= 0) {
                    return false;
                }
                if(SemaphoreAndMutexImpl._availablePermits$volatile$FU.compareAndSet(this, v, v - 1)) {
                    break;
                }
            }
        }
        return true;
    }

    private final boolean tryResumeAcquire(Object object0) {
        H h0 = H.a;
        if(object0 instanceof CancellableContinuation) {
            q.e(object0, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            Object object1 = ((CancellableContinuation)object0).tryResume(h0, null, this.onCancellationRelease);
            if(object1 != null) {
                ((CancellableContinuation)object0).completeResume(object1);
                return true;
            }
            return false;
        }
        if(!(object0 instanceof SelectInstance)) {
            throw new IllegalStateException(("unexpected: " + object0).toString());
        }
        return ((SelectInstance)object0).trySelect(this, h0);
    }

    private final boolean tryResumeNextFromQueue() {
        Object object0;
        SemaphoreSegment semaphoreSegment0 = (SemaphoreSegment)SemaphoreAndMutexImpl.head$volatile$FU.get(this);
        long v = SemaphoreAndMutexImpl.deqIdx$volatile$FU.getAndIncrement(this);
        kotlinx.coroutines.sync.SemaphoreAndMutexImpl.tryResumeNextFromQueue.createNewSegment.1 semaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$10 = kotlinx.coroutines.sync.SemaphoreAndMutexImpl.tryResumeNextFromQueue.createNewSegment.1.INSTANCE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = SemaphoreAndMutexImpl.head$volatile$FU;
    alab1:
        while(true) {
            object0 = ConcurrentLinkedListKt.findSegmentInternal(semaphoreSegment0, v / 16L, semaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$10);
            if(SegmentOrClosed.isClosed-impl(object0)) {
                break;
            }
            Segment segment0 = SegmentOrClosed.getSegment-impl(object0);
            while(true) {
                Segment segment1 = (Segment)atomicReferenceFieldUpdater0.get(this);
                if(segment1.id >= segment0.id) {
                    break alab1;
                }
                if(!segment0.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                }
                do {
                    if(atomicReferenceFieldUpdater0.compareAndSet(this, segment1, segment0)) {
                        if(!segment1.decPointers$kotlinx_coroutines_core()) {
                            break alab1;
                        }
                        segment1.remove();
                        break alab1;
                    }
                }
                while(atomicReferenceFieldUpdater0.get(this) == segment1);
                if(segment0.decPointers$kotlinx_coroutines_core()) {
                    segment0.remove();
                }
            }
        }
        SemaphoreSegment semaphoreSegment1 = (SemaphoreSegment)SegmentOrClosed.getSegment-impl(object0);
        semaphoreSegment1.cleanPrev();
        if(Long.compare(semaphoreSegment1.id, v / 16L) > 0) {
            return false;
        }
        Object object1 = semaphoreSegment1.getAcquirers().getAndSet(((int)(v % 16L)), SemaphoreKt.PERMIT);
        if(object1 == null) {
            for(int v1 = 0; v1 < 100; ++v1) {
                if(semaphoreSegment1.getAcquirers().get(((int)(v % 16L))) == SemaphoreKt.TAKEN) {
                    return true;
                }
            }
            Symbol symbol0 = SemaphoreKt.PERMIT;
            Symbol symbol1 = SemaphoreKt.BROKEN;
            AtomicReferenceArray atomicReferenceArray0 = semaphoreSegment1.getAcquirers();
            do {
                if(atomicReferenceArray0.compareAndSet(((int)(v % 16L)), symbol0, symbol1)) {
                    return 0;
                }
            }
            while(atomicReferenceArray0.get(((int)(v % 16L))) == symbol0);
            return 1;
        }
        return object1 == SemaphoreKt.CANCELLED ? false : this.tryResumeAcquire(object1);

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 0x30)
        final class kotlinx.coroutines.sync.SemaphoreAndMutexImpl.tryResumeNextFromQueue.createNewSegment.1 extends n implements we.n {
            public static final kotlinx.coroutines.sync.SemaphoreAndMutexImpl.tryResumeNextFromQueue.createNewSegment.1 INSTANCE;

            static {
                kotlinx.coroutines.sync.SemaphoreAndMutexImpl.tryResumeNextFromQueue.createNewSegment.1.INSTANCE = new kotlinx.coroutines.sync.SemaphoreAndMutexImpl.tryResumeNextFromQueue.createNewSegment.1();
            }

            public kotlinx.coroutines.sync.SemaphoreAndMutexImpl.tryResumeNextFromQueue.createNewSegment.1() {
                super(2, SemaphoreKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((Number)object0).longValue(), ((SemaphoreSegment)object1));
            }

            public final SemaphoreSegment invoke(long v, SemaphoreSegment semaphoreSegment0) {
                return SemaphoreKt.createSegment(v, semaphoreSegment0);
            }
        }

    }
}

