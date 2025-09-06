package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import gd.R7;
import i.n.i.b.a.s.e.P3;
import ie.H;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.NonDisposableHandle;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B#\b\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007\u00A2\u0006\u0004\b\t\u0010\nB\u001D\b\u0016\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u00A2\u0006\u0004\b\t\u0010\u000BJ#\u0010\u0012\u001A\u00020\u00112\u0006\u0010\r\u001A\u00020\f2\n\u0010\u0010\u001A\u00060\u000Ej\u0002`\u000FH\u0002\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001A\u00020\u00072\u0006\u0010\r\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001A\u00020\u00112\u0006\u0010\r\u001A\u00020\f2\n\u0010\u0010\u001A\u00060\u000Ej\u0002`\u000FH\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0013J%\u0010\u001B\u001A\u00020\u00112\u0006\u0010\u0018\u001A\u00020\u00172\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00110\u0019H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ+\u0010\u001E\u001A\u00020\u001D2\u0006\u0010\u0018\u001A\u00020\u00172\n\u0010\u0010\u001A\u00060\u000Ej\u0002`\u000F2\u0006\u0010\r\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u000F\u0010 \u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b \u0010!J\u001A\u0010$\u001A\u00020\u00072\b\u0010#\u001A\u0004\u0018\u00010\"H\u0096\u0002\u00A2\u0006\u0004\b$\u0010%J\u000F\u0010\'\u001A\u00020&H\u0016\u00A2\u0006\u0004\b\'\u0010(R\u0014\u0010\u0004\u001A\u00020\u00038\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0004\u0010)R\u0016\u0010\u0006\u001A\u0004\u0018\u00010\u00058\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0006\u0010*R\u0014\u0010\b\u001A\u00020\u00078\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\b\u0010+R\u001A\u0010,\u001A\u00020\u00008\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b,\u0010-\u001A\u0004\b.\u0010/\u00A8\u00060"}, d2 = {"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/Delay;", "Landroid/os/Handler;", "handler", "", "name", "", "invokeImmediately", "<init>", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "(Landroid/os/Handler;Ljava/lang/String;)V", "Lme/i;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lie/H;", "cancelOnRejection", "(Lme/i;Ljava/lang/Runnable;)V", "isDispatchNeeded", "(Lme/i;)Z", "dispatch", "", "timeMillis", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "(JLjava/lang/Runnable;Lme/i;)Lkotlinx/coroutines/DisposableHandle;", "toString", "()Ljava/lang/String;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Landroid/os/Handler;", "Ljava/lang/String;", "Z", "immediate", "Lkotlinx/coroutines/android/HandlerContext;", "getImmediate", "()Lkotlinx/coroutines/android/HandlerContext;", "kotlinx-coroutines-android"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class HandlerContext extends HandlerDispatcher implements Delay {
    @NotNull
    private final Handler handler;
    @NotNull
    private final HandlerContext immediate;
    private final boolean invokeImmediately;
    @Nullable
    private final String name;

    public HandlerContext(@NotNull Handler handler0, @Nullable String s) {
        this(handler0, s, false);
    }

    public HandlerContext(Handler handler0, String s, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 2) != 0) {
            s = null;
        }
        this(handler0, s);
    }

    private HandlerContext(Handler handler0, String s, boolean z) {
        super(null);
        this.handler = handler0;
        this.name = s;
        this.invokeImmediately = z;
        this.immediate = z ? this : new HandlerContext(handler0, s, true);
    }

    private final void cancelOnRejection(i i0, Runnable runnable0) {
        JobKt.cancel(i0, new CancellationException("The task was rejected, the handler underlying the dispatcher \'" + this + "\' was closed"));
        Dispatchers.getIO().dispatch(i0, runnable0);
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull i i0, @NotNull Runnable runnable0) {
        if(!this.handler.post(runnable0)) {
            this.cancelOnRejection(i0, runnable0);
        }
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        return object0 instanceof HandlerContext && ((HandlerContext)object0).handler == this.handler && ((HandlerContext)object0).invokeImmediately == this.invokeImmediately;
    }

    public static void f(CancellableContinuation cancellableContinuation0, HandlerContext handlerContext0) {
        HandlerContext.scheduleResumeAfterDelay$lambda$1(cancellableContinuation0, handlerContext0);
    }

    @Override  // kotlinx.coroutines.MainCoroutineDispatcher
    public MainCoroutineDispatcher getImmediate() {
        return this.getImmediate();
    }

    @NotNull
    public HandlerContext getImmediate() {
        return this.immediate;
    }

    @Override  // kotlinx.coroutines.android.HandlerDispatcher
    public HandlerDispatcher getImmediate() {
        return this.getImmediate();
    }

    @Override
    public int hashCode() {
        int v = System.identityHashCode(this.handler);
        return this.invokeImmediately ? v ^ 0x4CF : v ^ 0x4D5;
    }

    public static H i(HandlerContext handlerContext0, P3 p30, Throwable throwable0) {
        return HandlerContext.scheduleResumeAfterDelay$lambda$2(handlerContext0, p30, throwable0);
    }

    @Override  // kotlinx.coroutines.android.HandlerDispatcher, kotlinx.coroutines.Delay
    @NotNull
    public DisposableHandle invokeOnTimeout(long v, @NotNull Runnable runnable0, @NotNull i i0) {
        Handler handler0 = this.handler;
        if(v > 0x3FFFFFFFFFFFFFFFL) {
            v = 0x3FFFFFFFFFFFFFFFL;
        }
        if(handler0.postDelayed(runnable0, v)) {
            return () -> this.handler.removeCallbacks(runnable0);
        }
        this.cancelOnRejection(i0, runnable0);
        return NonDisposableHandle.INSTANCE;
    }

    // 检测为 Lambda 实现
    private static final void invokeOnTimeout$lambda$3(HandlerContext handlerContext0, Runnable runnable0) [...]

    // 去混淆评级： 低(20)
    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(@NotNull i i0) {
        return !this.invokeImmediately || !q.b(Looper.myLooper(), this.handler.getLooper());
    }

    @Override  // kotlinx.coroutines.android.HandlerDispatcher, kotlinx.coroutines.Delay
    public void scheduleResumeAfterDelay(long v, @NotNull CancellableContinuation cancellableContinuation0) {
        P3 p30 = new P3(14, cancellableContinuation0, this);
        Handler handler0 = this.handler;
        if(v > 0x3FFFFFFFFFFFFFFFL) {
            v = 0x3FFFFFFFFFFFFFFFL;
        }
        if(handler0.postDelayed(p30, v)) {
            cancellableContinuation0.invokeOnCancellation(new R7(23, this, p30));
            return;
        }
        this.cancelOnRejection(cancellableContinuation0.getContext(), p30);
    }

    private static final void scheduleResumeAfterDelay$lambda$1(CancellableContinuation cancellableContinuation0, HandlerContext handlerContext0) {
        cancellableContinuation0.resumeUndispatched(handlerContext0, H.a);
    }

    private static final H scheduleResumeAfterDelay$lambda$2(HandlerContext handlerContext0, Runnable runnable0, Throwable throwable0) {
        handlerContext0.handler.removeCallbacks(runnable0);
        return H.a;
    }

    @Override  // kotlinx.coroutines.MainCoroutineDispatcher
    @NotNull
    public String toString() {
        String s = this.toStringInternalImpl();
        if(s == null) {
            s = this.name == null ? this.handler.toString() : this.name;
            return this.invokeImmediately ? s + ".immediate" : s;
        }
        return s;
    }
}

