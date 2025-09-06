package kotlinx.coroutines.android;

import ie.d;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay.DefaultImpls;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004R\u0012\u0010\u0005\u001A\u00020\u0000X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007\u0082\u0001\u0001\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "<init>", "()V", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/android/HandlerContext;", "kotlinx-coroutines-android"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public abstract class HandlerDispatcher extends MainCoroutineDispatcher implements Delay {
    private HandlerDispatcher() {
    }

    public HandlerDispatcher(DefaultConstructorMarker defaultConstructorMarker0) {
    }

    @d
    @Nullable
    public Object delay(long v, @NotNull Continuation continuation0) {
        return DefaultImpls.delay(this, v, continuation0);
    }

    @NotNull
    public abstract HandlerDispatcher getImmediate();

    @Override  // kotlinx.coroutines.Delay
    @NotNull
    public DisposableHandle invokeOnTimeout(long v, @NotNull Runnable runnable0, @NotNull i i0) {
        return DefaultImpls.invokeOnTimeout(this, v, runnable0, i0);
    }

    @Override  // kotlinx.coroutines.Delay
    public abstract void scheduleResumeAfterDelay(long arg1, @NotNull CancellableContinuation arg2);
}

