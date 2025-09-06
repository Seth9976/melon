package kotlinx.coroutines.guava;

import M6.B;
import M6.H;
import M6.a;
import d5.f;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001A\u00028\u00002\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00028\u0000¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000E¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00028\u0000H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0014\u001A\u00028\u00002\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0019\u001A\u00020\u0018H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u001AJ#\u0010!\u001A\u00020 2\n\u0010\u001D\u001A\u00060\u001Bj\u0002`\u001C2\u0006\u0010\u001F\u001A\u00020\u001EH\u0016¢\u0006\u0004\b!\u0010\"J\u000F\u0010#\u001A\u00020\u000BH\u0016¢\u0006\u0004\b#\u0010\u0013J\u0017\u0010%\u001A\u00020\u000B2\u0006\u0010$\u001A\u00020\u000BH\u0016¢\u0006\u0004\b%\u0010&J\u000F\u0010(\u001A\u00020\'H\u0016¢\u0006\u0004\b(\u0010)R\u0014\u0010\u0004\u001A\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010*R,\u0010-\u001A\u001A\u0012\u0006\u0012\u0004\u0018\u00010\u0007 ,*\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010+0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001A\u00020\u000B8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b/\u00100¨\u00061"}, d2 = {"Lkotlinx/coroutines/guava/JobListenableFuture;", "T", "LM6/B;", "Lkotlinx/coroutines/Job;", "jobToCancel", "<init>", "(Lkotlinx/coroutines/Job;)V", "", "result", "getInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "complete", "(Ljava/lang/Object;)Z", "", "t", "completeExceptionallyOrCancel", "(Ljava/lang/Throwable;)Z", "isCancelled", "()Z", "get", "()Ljava/lang/Object;", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "listener", "Ljava/util/concurrent/Executor;", "executor", "Lie/H;", "addListener", "(Ljava/lang/Runnable;Ljava/util/concurrent/Executor;)V", "isDone", "mayInterruptIfRunning", "cancel", "(Z)Z", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/Job;", "LM6/H;", "kotlin.jvm.PlatformType", "auxFuture", "LM6/H;", "auxFutureIsFailed", "Z", "kotlinx-coroutines-guava"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class JobListenableFuture implements B {
    private final H auxFuture;
    private boolean auxFutureIsFailed;
    @NotNull
    private final Job jobToCancel;

    public JobListenableFuture(@NotNull Job job0) {
        this.jobToCancel = job0;
        this.auxFuture = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // M6.B
    public void addListener(@NotNull Runnable runnable0, @NotNull Executor executor0) {
        this.auxFuture.addListener(runnable0, executor0);
    }

    @Override
    public boolean cancel(boolean z) {
        if(this.auxFuture.cancel(z)) {
            DefaultImpls.cancel$default(this.jobToCancel, null, 1, null);
            return true;
        }
        return false;
    }

    public final boolean complete(Object object0) {
        return this.auxFuture.k(object0);
    }

    public final boolean completeExceptionallyOrCancel(@NotNull Throwable throwable0) {
        if(throwable0 instanceof CancellationException) {
            Cancelled cancelled0 = new Cancelled(((CancellationException)throwable0));
            return this.auxFuture.k(cancelled0);
        }
        boolean z = this.auxFuture.l(throwable0);
        if(z) {
            this.auxFutureIsFailed = true;
        }
        return z;
    }

    @Override
    public Object get() {
        return this.getInternal(this.auxFuture.get());
    }

    @Override
    public Object get(long v, @NotNull TimeUnit timeUnit0) {
        return this.getInternal(this.auxFuture.get(v, timeUnit0));
    }

    private final Object getInternal(Object object0) {
        if(object0 instanceof Cancelled) {
            throw new CancellationException().initCause(((Cancelled)object0).exception);
        }
        return object0;
    }

    @Override
    public boolean isCancelled() {
        if(!(this.auxFuture.a instanceof a)) {
            if(this.isDone() && !this.auxFutureIsFailed) {
                try {
                    return f.H(this.auxFuture) instanceof Cancelled;
                }
                catch(CancellationException unused_ex) {
                    return true;
                }
                catch(ExecutionException unused_ex) {
                    this.auxFutureIsFailed = true;
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    @Override
    public boolean isDone() {
        return this.auxFuture.isDone();
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(super.toString());
        stringBuilder0.append("[status=");
        if(this.isDone()) {
            try {
                Object object0 = f.H(this.auxFuture);
                if(object0 instanceof Cancelled) {
                    stringBuilder0.append("CANCELLED, cause=[" + ((Cancelled)object0).exception + ']');
                }
                else {
                    stringBuilder0.append("SUCCESS, result=[" + object0 + ']');
                }
                goto label_21;
            }
            catch(CancellationException unused_ex) {
            }
            catch(ExecutionException executionException0) {
                stringBuilder0.append("FAILURE, cause=[" + executionException0.getCause() + ']');
                goto label_21;
            }
            catch(Throwable throwable0) {
                stringBuilder0.append("UNKNOWN, cause=[" + throwable0.getClass() + " thrown from get()]");
                stringBuilder0.append(']');
                return stringBuilder0.toString();
            }
            stringBuilder0.append("CANCELLED");
        }
        else {
            stringBuilder0.append("PENDING, delegate=[" + this.auxFuture + ']');
        }
    label_21:
        stringBuilder0.append(']');
        return stringBuilder0.toString();
    }
}

