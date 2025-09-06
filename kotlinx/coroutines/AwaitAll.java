package kotlinx.coroutines;

import e1.u;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u000E\u000FB\u001D\u0012\u0014\u0010\u0003\u001A\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\fH\u0086@¢\u0006\u0002\u0010\rR\u001E\u0010\u0003\u001A\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\t\u0010\t\u001A\u00020\nX\u0082\u0004¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/AwaitAll;", "T", "", "deferreds", "", "Lkotlinx/coroutines/Deferred;", "<init>", "([Lkotlinx/coroutines/Deferred;)V", "[Lkotlinx/coroutines/Deferred;", "notCompletedCount", "Lkotlinx/atomicfu/AtomicInt;", "await", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "DisposeHandlersOnCancel", "AwaitAllNode", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class AwaitAll {
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001B\u0012\u0012\u0010\u0004\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001A\u00020\t2\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000BR \u0010\u0004\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\fR\"\u0010\u000E\u001A\u00020\r8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000E\u0010\u000F\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R<\u0010\u001B\u001A\u000E\u0018\u00010\u0014R\b\u0012\u0004\u0012\u00028\u00000\u00152\u0012\u0010\u0016\u001A\u000E\u0018\u00010\u0014R\b\u0012\u0004\u0012\u00028\u00000\u00158F@FX\u0086\u000E¢\u0006\f\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001AR\u0014\u0010\u001F\u001A\u00020\u001C8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001ER\u001D\u0010!\u001A\u0014\u0012\u0010\u0012\u000E\u0018\u00010\u0014R\b\u0012\u0004\u0012\u00028\u00000\u00150 8\u0002X\u0082\u0004¨\u0006\""}, d2 = {"Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/CancellableContinuation;", "", "continuation", "<init>", "(Lkotlinx/coroutines/AwaitAll;Lkotlinx/coroutines/CancellableContinuation;)V", "", "cause", "Lie/H;", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlinx/coroutines/DisposableHandle;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "getHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/AwaitAll;", "value", "getDisposer", "()Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "setDisposer", "(Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;)V", "disposer", "", "getOnCancelling", "()Z", "onCancelling", "Lkotlinx/atomicfu/AtomicRef;", "_disposer", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    final class AwaitAllNode extends JobNode {
        private volatile Object _disposer$volatile;
        private static final AtomicReferenceFieldUpdater _disposer$volatile$FU;
        @NotNull
        private final CancellableContinuation continuation;
        public DisposableHandle handle;

        static {
            AwaitAllNode._disposer$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(AwaitAllNode.class, Object.class, "_disposer$volatile");
        }

        public AwaitAllNode(@NotNull CancellableContinuation cancellableContinuation0) {
            this.continuation = cancellableContinuation0;
        }

        @Nullable
        public final DisposeHandlersOnCancel getDisposer() {
            return (DisposeHandlersOnCancel)AwaitAllNode._disposer$volatile$FU.get(this);
        }

        @NotNull
        public final DisposableHandle getHandle() {
            DisposableHandle disposableHandle0 = this.handle;
            if(disposableHandle0 != null) {
                return disposableHandle0;
            }
            q.m("handle");
            throw null;
        }

        @Override  // kotlinx.coroutines.JobNode
        public boolean getOnCancelling() {
            return false;
        }

        @Override  // kotlinx.coroutines.JobNode
        public void invoke(@Nullable Throwable throwable0) {
            if(throwable0 != null) {
                Object object0 = this.continuation.tryResumeWithException(throwable0);
                if(object0 != null) {
                    this.continuation.completeResume(object0);
                    DisposeHandlersOnCancel awaitAll$DisposeHandlersOnCancel0 = this.getDisposer();
                    if(awaitAll$DisposeHandlersOnCancel0 != null) {
                        awaitAll$DisposeHandlersOnCancel0.disposeAll();
                    }
                }
            }
            else if(AwaitAll.notCompletedCount$volatile$FU.decrementAndGet(AwaitAll.this) == 0) {
                CancellableContinuation cancellableContinuation0 = this.continuation;
                Deferred[] arr_deferred = AwaitAll.this.deferreds;
                ArrayList arrayList0 = new ArrayList(arr_deferred.length);
                for(int v = 0; v < arr_deferred.length; ++v) {
                    arrayList0.add(arr_deferred[v].getCompleted());
                }
                cancellableContinuation0.resumeWith(arrayList0);
            }
        }

        public final void setDisposer(@Nullable DisposeHandlersOnCancel awaitAll$DisposeHandlersOnCancel0) {
            AwaitAllNode._disposer$volatile$FU.set(this, awaitAll$DisposeHandlersOnCancel0);
        }

        public final void setHandle(@NotNull DisposableHandle disposableHandle0) {
            this.handle = disposableHandle0;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001F\u0012\u0016\u0010\u0005\u001A\u0012\u0012\u000E\u0012\f0\u0003R\b\u0012\u0004\u0012\u00028\u00000\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001A\u00020\b2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0005\u001A\u0012\u0012\u000E\u0012\f0\u0003R\b\u0012\u0004\u0012\u00028\u00000\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "", "Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/AwaitAll;", "nodes", "<init>", "(Lkotlinx/coroutines/AwaitAll;[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;)V", "Lie/H;", "disposeAll", "()V", "", "cause", "invoke", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    final class DisposeHandlersOnCancel implements CancelHandler {
        @NotNull
        private final AwaitAllNode[] nodes;

        public DisposeHandlersOnCancel(@NotNull AwaitAllNode[] arr_awaitAll$AwaitAllNode) {
            this.nodes = arr_awaitAll$AwaitAllNode;
        }

        public final void disposeAll() {
            AwaitAllNode[] arr_awaitAll$AwaitAllNode = this.nodes;
            for(int v = 0; v < arr_awaitAll$AwaitAllNode.length; ++v) {
                arr_awaitAll$AwaitAllNode[v].getHandle().dispose();
            }
        }

        @Override  // kotlinx.coroutines.CancelHandler
        public void invoke(@Nullable Throwable throwable0) {
            this.disposeAll();
        }

        @Override
        @NotNull
        public String toString() {
            return "DisposeHandlersOnCancel[" + this.nodes + ']';
        }
    }

    @NotNull
    private final Deferred[] deferreds;
    private volatile int notCompletedCount$volatile;
    private static final AtomicIntegerFieldUpdater notCompletedCount$volatile$FU;

    static {
        AwaitAll.notCompletedCount$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(AwaitAll.class, "notCompletedCount$volatile");
    }

    public AwaitAll(@NotNull Deferred[] arr_deferred) {
        this.deferreds = arr_deferred;
        this.notCompletedCount$volatile = arr_deferred.length;
    }

    @Nullable
    public final Object await(@NotNull Continuation continuation0) {
        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(continuation0), 1);
        cancellableContinuationImpl0.initCancellability();
        Deferred[] arr_deferred = this.deferreds;
        AwaitAllNode[] arr_awaitAll$AwaitAllNode = new AwaitAllNode[arr_deferred.length];
        for(int v1 = 0; v1 < arr_deferred.length; ++v1) {
            Deferred deferred0 = this.deferreds[v1];
            deferred0.start();
            AwaitAllNode awaitAll$AwaitAllNode0 = new AwaitAllNode(this, cancellableContinuationImpl0);
            awaitAll$AwaitAllNode0.setHandle(JobKt.invokeOnCompletion$default(deferred0, false, awaitAll$AwaitAllNode0, 1, null));
            arr_awaitAll$AwaitAllNode[v1] = awaitAll$AwaitAllNode0;
        }
        DisposeHandlersOnCancel awaitAll$DisposeHandlersOnCancel0 = new DisposeHandlersOnCancel(this, arr_awaitAll$AwaitAllNode);
        for(int v = 0; v < arr_deferred.length; ++v) {
            arr_awaitAll$AwaitAllNode[v].setDisposer(awaitAll$DisposeHandlersOnCancel0);
        }
        if(cancellableContinuationImpl0.isCompleted()) {
            awaitAll$DisposeHandlersOnCancel0.disposeAll();
            return cancellableContinuationImpl0.getResult();
        }
        CancellableContinuationKt.invokeOnCancellation(cancellableContinuationImpl0, awaitAll$DisposeHandlersOnCancel0);
        return cancellableContinuationImpl0.getResult();
    }
}

