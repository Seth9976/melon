package kotlinx.coroutines.sync;

import Ac.a4;
import Bd.e;
import e1.u;
import ie.H;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.o;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\"B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001A\u00020\t2\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000BJ\u001A\u0010\r\u001A\u00020\f2\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0082@¢\u0006\u0004\b\r\u0010\u000EJ\u0019\u0010\u000F\u001A\u00020\t2\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u000F\u0010\u000BJ\u001A\u0010\u0010\u001A\u00020\f2\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0096@¢\u0006\u0004\b\u0010\u0010\u000EJ\u0019\u0010\u0011\u001A\u00020\u00032\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001A\u00020\f2\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0016\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017RR\u0010\u001D\u001A@\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u001E\u0012\u001C\u0012\u0004\u0012\u00020\u001A\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u001B\u0012\u0004\u0012\u00020\f0\u00180\u0018j\u0002`\u001C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001D\u0010\u001ER\u0014\u0010\u001F\u001A\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010 R\u0013\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070!8\u0002X\u0082\u0004¨\u0006#"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl;", "Lkotlinx/coroutines/sync/SemaphoreAndMutexImpl;", "Lkotlinx/coroutines/sync/Mutex;", "", "locked", "<init>", "(Z)V", "", "owner", "", "holdsLockImpl", "(Ljava/lang/Object;)I", "Lie/H;", "lockSuspend", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryLockImpl", "lock", "tryLock", "(Ljava/lang/Object;)Z", "unlock", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/SelectInstance;", "", "Lme/i;", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "onSelectCancellationUnlockConstructor", "Lwe/o;", "isLocked", "()Z", "Lkotlinx/atomicfu/AtomicRef;", "CancellableContinuationWithOwner", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public class MutexImpl extends SemaphoreAndMutexImpl implements Mutex {
    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001F\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u00A2\u0006\u0004\b\b\u0010\tJO\u0010\u0011\u001A\u0004\u0018\u00010\u0006\"\b\b\u0000\u0010\n*\u00020\u00022\u0006\u0010\u000B\u001A\u00028\u00002\b\u0010\f\u001A\u0004\u0018\u00010\u00062 \u0010\u0010\u001A\u001C\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rH\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012JC\u0010\u0013\u001A\u00020\u0002\"\b\b\u0000\u0010\n*\u00020\u00022\u0006\u0010\u000B\u001A\u00028\u00002 \u0010\u0010\u001A\u001C\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rH\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u001A\u0010\u0016\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001A\u00020\u000EH\u0097\u0001\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0019\u001A\u00020\u00022\u0006\u0010\u0018\u001A\u00020\u0006H\u0097\u0001\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u001A\u0010\u001D\u001A\u00020\u001C2\b\u0010\u001B\u001A\u0004\u0018\u00010\u000EH\u0096\u0001\u00A2\u0006\u0004\b\u001D\u0010\u001EJ*\u0010\"\u001A\u00020\u00022\u0018\u0010!\u001A\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000E\u0012\u0004\u0012\u00020\u00020\u001Fj\u0002` H\u0096\u0001\u00A2\u0006\u0004\b\"\u0010#J$\u0010\"\u001A\u00020\u00022\n\u0010%\u001A\u0006\u0012\u0002\b\u00030$2\u0006\u0010\'\u001A\u00020&H\u0096\u0001\u00A2\u0006\u0004\b\"\u0010(J\u001C\u0010*\u001A\u00020\u0002*\u00020)2\u0006\u0010\u000B\u001A\u00020\u0002H\u0097\u0001\u00A2\u0006\u0004\b*\u0010+J\u001E\u0010.\u001A\u00020\u00022\f\u0010-\u001A\b\u0012\u0004\u0012\u00020\u00020,H\u0096\u0001\u00A2\u0006\u0004\b.\u0010\u001AR\u001A\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u0010/R\u0016\u0010\u0007\u001A\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\u0007\u00100R\u0014\u00101\u001A\u00020\u001C8\u0016X\u0096\u0005\u00A2\u0006\u0006\u001A\u0004\b1\u00102R\u0014\u00103\u001A\u00020\u001C8\u0016X\u0096\u0005\u00A2\u0006\u0006\u001A\u0004\b3\u00102R\u0014\u00106\u001A\u00020\u000F8\u0016X\u0096\u0005\u00A2\u0006\u0006\u001A\u0004\b4\u00105\u00A8\u00067"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$CancellableContinuationWithOwner;", "Lkotlinx/coroutines/CancellableContinuation;", "Lie/H;", "Lkotlinx/coroutines/Waiter;", "Lkotlinx/coroutines/CancellableContinuationImpl;", "cont", "", "owner", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Lkotlinx/coroutines/CancellableContinuationImpl;Ljava/lang/Object;)V", "R", "value", "idempotent", "Lkotlin/Function3;", "", "Lme/i;", "onCancellation", "tryResume", "(Lie/H;Ljava/lang/Object;Lwe/o;)Ljava/lang/Object;", "resume", "(Lie/H;Lwe/o;)V", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "token", "completeResume", "(Ljava/lang/Object;)V", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "Lkotlinx/coroutines/CompletionHandler;", "handler", "invokeOnCancellation", "(Lwe/k;)V", "Lkotlinx/coroutines/internal/Segment;", "segment", "", "index", "(Lkotlinx/coroutines/internal/Segment;I)V", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Lie/H;)V", "Lie/p;", "result", "resumeWith", "Lkotlinx/coroutines/CancellableContinuationImpl;", "Ljava/lang/Object;", "isActive", "()Z", "isCompleted", "getContext", "()Lme/i;", "context", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    final class CancellableContinuationWithOwner implements CancellableContinuation, Waiter {
        @NotNull
        public final CancellableContinuationImpl cont;
        @Nullable
        public final Object owner;

        public CancellableContinuationWithOwner(@NotNull CancellableContinuationImpl cancellableContinuationImpl0, @Nullable Object object0) {
            this.cont = cancellableContinuationImpl0;
            this.owner = object0;
        }

        @Override  // kotlinx.coroutines.CancellableContinuation
        public boolean cancel(@Nullable Throwable throwable0) {
            return this.cont.cancel(throwable0);
        }

        @Override  // kotlinx.coroutines.CancellableContinuation
        public void completeResume(@NotNull Object object0) {
            this.cont.completeResume(object0);
        }

        @Override  // kotlin.coroutines.Continuation
        @NotNull
        public i getContext() {
            return this.cont.getContext();
        }

        @Override  // kotlinx.coroutines.Waiter
        public void invokeOnCancellation(@NotNull Segment segment0, int v) {
            this.cont.invokeOnCancellation(segment0, v);
        }

        @Override  // kotlinx.coroutines.CancellableContinuation
        public void invokeOnCancellation(@NotNull k k0) {
            this.cont.invokeOnCancellation(k0);
        }

        @Override  // kotlinx.coroutines.CancellableContinuation
        public boolean isActive() {
            return this.cont.isActive();
        }

        @Override  // kotlinx.coroutines.CancellableContinuation
        public boolean isCompleted() {
            return this.cont.isCompleted();
        }

        public void resume(@NotNull H h0, @Nullable o o0) {
            MutexImpl.owner$volatile$FU.set(MutexImpl.this, this.owner);
            b b0 = (Throwable throwable0) -> {
                MutexImpl.this.unlock(this.owner);
                return H.a;
            };
            this.cont.resume(h0, b0);
        }

        @Override  // kotlinx.coroutines.CancellableContinuation
        public void resume(Object object0, o o0) {
            this.resume(((H)object0), o0);
        }

        // 检测为 Lambda 实现
        private static final H resume$lambda$6(MutexImpl mutexImpl0, CancellableContinuationWithOwner mutexImpl$CancellableContinuationWithOwner0, Throwable throwable0) [...]

        public void resumeUndispatched(@NotNull CoroutineDispatcher coroutineDispatcher0, @NotNull H h0) {
            this.cont.resumeUndispatched(coroutineDispatcher0, h0);
        }

        @Override  // kotlinx.coroutines.CancellableContinuation
        public void resumeUndispatched(CoroutineDispatcher coroutineDispatcher0, Object object0) {
            this.resumeUndispatched(coroutineDispatcher0, ((H)object0));
        }

        @Override  // kotlin.coroutines.Continuation
        public void resumeWith(@NotNull Object object0) {
            this.cont.resumeWith(object0);
        }

        @Nullable
        public Object tryResume(@NotNull H h0, @Nullable Object object0, @Nullable o o0) {
            a a0 = (Throwable throwable0, H h0, i i0) -> {
                MutexImpl.owner$volatile$FU.set(MutexImpl.this, this.owner);
                MutexImpl.this.unlock(this.owner);
                return H.a;
            };
            Object object1 = this.cont.tryResume(h0, object0, a0);
            if(object1 != null) {
                MutexImpl.owner$volatile$FU.set(MutexImpl.this, this.owner);
            }
            return object1;
        }

        @Override  // kotlinx.coroutines.CancellableContinuation
        public Object tryResume(Object object0, Object object1, o o0) {
            return this.tryResume(((H)object0), object1, o0);
        }

        // 检测为 Lambda 实现
        private static final H tryResume$lambda$3(MutexImpl mutexImpl0, CancellableContinuationWithOwner mutexImpl$CancellableContinuationWithOwner0, Throwable throwable0, H h0, i i0) [...]

        @Override  // kotlinx.coroutines.CancellableContinuation
        @Nullable
        public Object tryResumeWithException(@NotNull Throwable throwable0) {
            return this.cont.tryResumeWithException(throwable0);
        }
    }

    @NotNull
    private final o onSelectCancellationUnlockConstructor;
    private volatile Object owner$volatile;
    private static final AtomicReferenceFieldUpdater owner$volatile$FU;

    static {
        MutexImpl.owner$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "owner$volatile");
    }

    public MutexImpl(boolean z) {
        super(1, ((int)z));
        this.owner$volatile = z ? null : MutexKt.access$getNO_OWNER$p();
        this.onSelectCancellationUnlockConstructor = new e(this, 16);
    }

    public static H b(MutexImpl mutexImpl0, Object object0, Throwable throwable0, Object object1, i i0) {
        return MutexImpl.onSelectCancellationUnlockConstructor$lambda$1$lambda$0(mutexImpl0, object0, throwable0, object1, i0);
    }

    public static o c(MutexImpl mutexImpl0, SelectInstance selectInstance0, Object object0, Object object1) {
        return MutexImpl.onSelectCancellationUnlockConstructor$lambda$1(mutexImpl0, selectInstance0, object0, object1);
    }

    private final int holdsLockImpl(Object object0) {
        Object object1;
        do {
            if(!this.isLocked()) {
                return 0;
            }
            object1 = MutexImpl.owner$volatile$FU.get(this);
        }
        while(object1 == MutexKt.access$getNO_OWNER$p());
        return object1 == object0 ? 1 : 2;
    }

    @Override  // kotlinx.coroutines.sync.Mutex
    public boolean isLocked() {
        return this.getAvailablePermits() == 0;
    }

    @Override  // kotlinx.coroutines.sync.Mutex
    @Nullable
    public Object lock(@Nullable Object object0, @NotNull Continuation continuation0) {
        return MutexImpl.lock$suspendImpl(this, object0, continuation0);
    }

    public static Object lock$suspendImpl(MutexImpl mutexImpl0, Object object0, Continuation continuation0) {
        boolean z = mutexImpl0.tryLock(object0);
        H h0 = H.a;
        if(z) {
            return h0;
        }
        Object object1 = mutexImpl0.lockSuspend(object0, continuation0);
        return object1 == ne.a.a ? object1 : h0;
    }

    private final Object lockSuspend(Object object0, Continuation continuation0) {
        CancellableContinuationImpl cancellableContinuationImpl0 = CancellableContinuationKt.getOrCreateCancellableContinuation(u.D(continuation0));
        try {
            this.acquire(new CancellableContinuationWithOwner(this, cancellableContinuationImpl0, object0));
        }
        catch(Throwable throwable0) {
            cancellableContinuationImpl0.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw throwable0;
        }
        Object object1 = cancellableContinuationImpl0.getResult();
        return object1 == ne.a.a ? object1 : H.a;
    }

    private static final o onSelectCancellationUnlockConstructor$lambda$1(MutexImpl mutexImpl0, SelectInstance selectInstance0, Object object0, Object object1) {
        return new a4(8, mutexImpl0, object0);
    }

    private static final H onSelectCancellationUnlockConstructor$lambda$1$lambda$0(MutexImpl mutexImpl0, Object object0, Throwable throwable0, Object object1, i i0) {
        mutexImpl0.unlock(object0);
        return H.a;
    }

    @Override
    @NotNull
    public String toString() {
        return "Mutex@" + DebugStringsKt.getHexAddress(this) + "[isLocked=" + this.isLocked() + ",owner=" + MutexImpl.owner$volatile$FU.get(this) + ']';
    }

    @Override  // kotlinx.coroutines.sync.Mutex
    public boolean tryLock(@Nullable Object object0) {
        int v = this.tryLockImpl(object0);
        switch(v) {
            case 0: {
                return true;
            }
            case 1: {
                return false;
            }
            default: {
                throw v == 2 ? new IllegalStateException(("This mutex is already locked by the specified owner: " + object0).toString()) : new IllegalStateException("unexpected");
            }
        }
    }

    private final int tryLockImpl(Object object0) {
    alab1:
        while(true) {
            if(this.tryAcquire()) {
                MutexImpl.owner$volatile$FU.set(this, object0);
                return 0;
            }
            if(object0 == null) {
                return 1;
            }
            switch(this.holdsLockImpl(object0)) {
                case 1: {
                    return 2;
                }
                case 2: {
                    break alab1;
                }
            }
        }
        return 1;
    }

    @Override  // kotlinx.coroutines.sync.Mutex
    public void unlock(@Nullable Object object0) {
        while(this.isLocked()) {
            Object object1 = MutexImpl.owner$volatile$FU.get(this);
            if(object1 != MutexKt.NO_OWNER) {
                if(object1 != object0 && object0 != null) {
                    throw new IllegalStateException(("This mutex is locked by " + object1 + ", but " + object0 + " is expected").toString());
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = MutexImpl.owner$volatile$FU;
                Symbol symbol0 = MutexKt.NO_OWNER;
                do {
                    if(atomicReferenceFieldUpdater0.compareAndSet(this, object1, symbol0)) {
                        this.release();
                        return;
                    }
                }
                while(atomicReferenceFieldUpdater0.get(this) == object1);
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }
}

