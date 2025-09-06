package kotlinx.coroutines;

import ie.d;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import me.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0017¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001A\u00020\bH\u0097@¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\r\u001A\u00060\u000Bj\u0002`\fH\u0017¢\u0006\u0004\b\r\u0010\u000EJ)\u0010\u0014\u001A\u00020\u00132\u0018\u0010\u0012\u001A\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\b0\u000Fj\u0002`\u0011H\u0017¢\u0006\u0004\b\u0014\u0010\u0015J9\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0016\u001A\u00020\u00052\u0006\u0010\u0017\u001A\u00020\u00052\u0018\u0010\u0012\u001A\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\b0\u000Fj\u0002`\u0011H\u0017¢\u0006\u0004\b\u0014\u0010\u0018J\u001F\u0010\u001A\u001A\u00020\b2\u000E\u0010\u0019\u001A\n\u0018\u00010\u000Bj\u0004\u0018\u0001`\fH\u0017¢\u0006\u0004\b\u001A\u0010\u001BJ\u0017\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u001D\u001A\u00020\u001CH\u0017¢\u0006\u0004\b\u001F\u0010 J\u000F\u0010\"\u001A\u00020!H\u0016¢\u0006\u0004\b\"\u0010#R\u001A\u0010$\u001A\u00020\u00058VX\u0097\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0004\u001A\u0004\b$\u0010\u0007R\u001A\u0010&\u001A\u00020\u00058VX\u0097\u0004¢\u0006\f\u0012\u0004\b\'\u0010\u0004\u001A\u0004\b&\u0010\u0007R\u001A\u0010(\u001A\u00020\u00058VX\u0097\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0004\u001A\u0004\b(\u0010\u0007¨\u0006*"}, d2 = {"Lkotlinx/coroutines/NonCancellable;", "Lme/a;", "Lkotlinx/coroutines/Job;", "<init>", "()V", "", "start", "()Z", "Lie/H;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(Lwe/k;)Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "(ZZLwe/k;)Lkotlinx/coroutines/DisposableHandle;", "cause", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "", "toString", "()Ljava/lang/String;", "isActive", "isActive$annotations", "isCompleted", "isCompleted$annotations", "isCancelled", "isCancelled$annotations", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class NonCancellable extends a implements Job {
    @NotNull
    public static final NonCancellable INSTANCE;

    static {
        NonCancellable.INSTANCE = new NonCancellable();
    }

    private NonCancellable() {
        super(Job.Key);
    }

    @Override  // kotlinx.coroutines.Job
    @d
    @NotNull
    public ChildHandle attachChild(@NotNull ChildJob childJob0) {
        return NonDisposableHandle.INSTANCE;
    }

    @Override  // kotlinx.coroutines.Job
    @d
    public void cancel(@Nullable CancellationException cancellationException0) {
    }

    @Override  // kotlinx.coroutines.Job
    @d
    @NotNull
    public CancellationException getCancellationException() {
        throw new IllegalStateException("This job is always active");
    }

    @Override  // kotlinx.coroutines.Job
    @d
    @NotNull
    public DisposableHandle invokeOnCompletion(@NotNull k k0) {
        return NonDisposableHandle.INSTANCE;
    }

    @Override  // kotlinx.coroutines.Job
    @d
    @NotNull
    public DisposableHandle invokeOnCompletion(boolean z, boolean z1, @NotNull k k0) {
        return NonDisposableHandle.INSTANCE;
    }

    @Override  // kotlinx.coroutines.Job
    public boolean isActive() {
        return true;
    }

    @Override  // kotlinx.coroutines.Job
    public boolean isCancelled() {
        return false;
    }

    @Override  // kotlinx.coroutines.Job
    public boolean isCompleted() {
        return false;
    }

    @Override  // kotlinx.coroutines.Job
    @d
    @Nullable
    public Object join(@NotNull Continuation continuation0) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override  // kotlinx.coroutines.Job
    @d
    public boolean start() {
        return false;
    }

    @Override
    @NotNull
    public String toString() {
        return "NonCancellable";
    }
}

