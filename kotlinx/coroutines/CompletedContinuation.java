package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.o;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\n\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BW\u0012\u0006\u0010\u0003\u001A\u00028\u0000\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\"\b\u0002\u0010\n\u001A\u001C\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0007\u00A2\u0006\u0004\b\r\u0010\u000EJ!\u0010\u0012\u001A\u00020\t2\n\u0010\u0010\u001A\u0006\u0012\u0002\b\u00030\u000F2\u0006\u0010\u0011\u001A\u00020\u0007\u00A2\u0006\u0004\b\u0012\u0010\u0013Jh\u0010\u0014\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001A\u00028\u00002\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00042\"\b\u0002\u0010\n\u001A\u001C\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0007H\u00C6\u0001\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001A\u00020\u0016H\u00D6\u0001\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001A\u001A\u00020\u0019H\u00D6\u0001\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u001A\u0010\u001E\u001A\u00020\u001D2\b\u0010\u001C\u001A\u0004\u0018\u00010\u0002H\u00D6\u0003\u00A2\u0006\u0004\b\u001E\u0010\u001FR\u0014\u0010\u0003\u001A\u00028\u00008\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010 R\u0016\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u0010!R.\u0010\n\u001A\u001C\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00068\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\n\u0010\"R\u0016\u0010\u000B\u001A\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\u000B\u0010 R\u0016\u0010\f\u001A\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\f\u0010#R\u0011\u0010&\u001A\u00020\u001D8F\u00A2\u0006\u0006\u001A\u0004\b$\u0010%\u00A8\u0006\'"}, d2 = {"Lkotlinx/coroutines/CompletedContinuation;", "R", "", "result", "Lkotlinx/coroutines/CancelHandler;", "cancelHandler", "Lkotlin/Function3;", "", "Lme/i;", "Lie/H;", "onCancellation", "idempotentResume", "cancelCause", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/CancelHandler;Lwe/o;Ljava/lang/Object;Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/CancellableContinuationImpl;", "cont", "cause", "invokeHandlers", "(Lkotlinx/coroutines/CancellableContinuationImpl;Ljava/lang/Throwable;)V", "copy", "(Ljava/lang/Object;Lkotlinx/coroutines/CancelHandler;Lwe/o;Ljava/lang/Object;Ljava/lang/Throwable;)Lkotlinx/coroutines/CompletedContinuation;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "Lkotlinx/coroutines/CancelHandler;", "Lwe/o;", "Ljava/lang/Throwable;", "getCancelled", "()Z", "cancelled", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class CompletedContinuation {
    @Nullable
    public final Throwable cancelCause;
    @Nullable
    public final CancelHandler cancelHandler;
    @Nullable
    public final Object idempotentResume;
    @Nullable
    public final o onCancellation;
    public final Object result;

    public CompletedContinuation(Object object0, @Nullable CancelHandler cancelHandler0, @Nullable o o0, @Nullable Object object1, @Nullable Throwable throwable0) {
        this.result = object0;
        this.cancelHandler = cancelHandler0;
        this.onCancellation = o0;
        this.idempotentResume = object1;
        this.cancelCause = throwable0;
    }

    public CompletedContinuation(Object object0, CancelHandler cancelHandler0, o o0, Object object1, Throwable throwable0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 2) != 0) {
            cancelHandler0 = null;
        }
        if((v & 4) != 0) {
            o0 = null;
        }
        if((v & 8) != 0) {
            object1 = null;
        }
        this(object0, cancelHandler0, o0, object1, ((v & 16) == 0 ? throwable0 : null));
    }

    @NotNull
    public final CompletedContinuation copy(Object object0, @Nullable CancelHandler cancelHandler0, @Nullable o o0, @Nullable Object object1, @Nullable Throwable throwable0) {
        return new CompletedContinuation(object0, cancelHandler0, o0, object1, throwable0);
    }

    public static CompletedContinuation copy$default(CompletedContinuation completedContinuation0, Object object0, CancelHandler cancelHandler0, o o0, Object object1, Throwable throwable0, int v, Object object2) {
        if((v & 1) != 0) {
            object0 = completedContinuation0.result;
        }
        if((v & 2) != 0) {
            cancelHandler0 = completedContinuation0.cancelHandler;
        }
        if((v & 4) != 0) {
            o0 = completedContinuation0.onCancellation;
        }
        if((v & 8) != 0) {
            object1 = completedContinuation0.idempotentResume;
        }
        if((v & 16) != 0) {
            throwable0 = completedContinuation0.cancelCause;
        }
        return completedContinuation0.copy(object0, cancelHandler0, o0, object1, throwable0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof CompletedContinuation)) {
            return false;
        }
        if(!q.b(this.result, ((CompletedContinuation)object0).result)) {
            return false;
        }
        if(!q.b(this.cancelHandler, ((CompletedContinuation)object0).cancelHandler)) {
            return false;
        }
        if(!q.b(this.onCancellation, ((CompletedContinuation)object0).onCancellation)) {
            return false;
        }
        return q.b(this.idempotentResume, ((CompletedContinuation)object0).idempotentResume) ? q.b(this.cancelCause, ((CompletedContinuation)object0).cancelCause) : false;
    }

    public final boolean getCancelled() {
        return this.cancelCause != null;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.result == null ? 0 : this.result.hashCode();
        int v2 = this.cancelHandler == null ? 0 : this.cancelHandler.hashCode();
        int v3 = this.onCancellation == null ? 0 : this.onCancellation.hashCode();
        int v4 = this.idempotentResume == null ? 0 : this.idempotentResume.hashCode();
        Throwable throwable0 = this.cancelCause;
        if(throwable0 != null) {
            v = throwable0.hashCode();
        }
        return (((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v;
    }

    public final void invokeHandlers(@NotNull CancellableContinuationImpl cancellableContinuationImpl0, @NotNull Throwable throwable0) {
        CancelHandler cancelHandler0 = this.cancelHandler;
        if(cancelHandler0 != null) {
            cancellableContinuationImpl0.callCancelHandler(cancelHandler0, throwable0);
        }
        o o0 = this.onCancellation;
        if(o0 != null) {
            cancellableContinuationImpl0.callOnCancellation(o0, throwable0, this.result);
        }
    }

    @Override
    @NotNull
    public String toString() {
        return "CompletedContinuation(result=" + this.result + ", cancelHandler=" + this.cancelHandler + ", onCancellation=" + this.onCancellation + ", idempotentResume=" + this.idempotentResume + ", cancelCause=" + this.cancelCause + ')';
    }
}

