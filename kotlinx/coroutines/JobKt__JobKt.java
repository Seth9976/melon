package kotlinx.coroutines;

import ie.H;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import me.i;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\u001A%\u0010\u0006\u001A\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001A\u0019\u0010\n\u001A\u00020\t2\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0000¢\u0006\u0004\b\n\u0010\u000B\u001A\u001B\u0010\r\u001A\u00020\u0005*\u00020\u00002\u0006\u0010\f\u001A\u00020\u0005H\u0000¢\u0006\u0004\b\r\u0010\u000E\u001A\u0014\u0010\u0010\u001A\u00020\u000F*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0010\u0010\u0011\u001A#\u0010\u0016\u001A\u00020\u000F*\u00020\u00122\u0010\b\u0002\u0010\u0015\u001A\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014¢\u0006\u0004\b\u0016\u0010\u0017\u001A\u0011\u0010\u0018\u001A\u00020\u000F*\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001A\u0011\u0010\u0018\u001A\u00020\u000F*\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u001A\u001A%\u0010\u0016\u001A\u00020\u000F*\u00020\u00002\u0006\u0010\u001C\u001A\u00020\u001B2\n\b\u0002\u0010\u0015\u001A\u0004\u0018\u00010\u001D¢\u0006\u0004\b\u0016\u0010\u001E\"\u0015\u0010\u001F\u001A\u00020\u0001*\u00020\u00128F¢\u0006\u0006\u001A\u0004\b\u001F\u0010 \"\u0015\u0010#\u001A\u00020\u0000*\u00020\u00128F¢\u0006\u0006\u001A\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lkotlinx/coroutines/Job;", "", "invokeImmediately", "Lkotlinx/coroutines/JobNode;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(Lkotlinx/coroutines/Job;ZLkotlinx/coroutines/JobNode;)Lkotlinx/coroutines/DisposableHandle;", "parent", "Lkotlinx/coroutines/CompletableJob;", "Job", "(Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/CompletableJob;", "handle", "disposeOnCompletion", "(Lkotlinx/coroutines/Job;Lkotlinx/coroutines/DisposableHandle;)Lkotlinx/coroutines/DisposableHandle;", "Lie/H;", "cancelAndJoin", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lme/i;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "cancel", "(Lme/i;Ljava/util/concurrent/CancellationException;)V", "ensureActive", "(Lkotlinx/coroutines/Job;)V", "(Lme/i;)V", "", "message", "", "(Lkotlinx/coroutines/Job;Ljava/lang/String;Ljava/lang/Throwable;)V", "isActive", "(Lme/i;)Z", "getJob", "(Lme/i;)Lkotlinx/coroutines/Job;", "job", "kotlinx-coroutines-core"}, k = 5, mv = {2, 1, 0}, xi = 0x30, xs = "kotlinx/coroutines/JobKt")
abstract class JobKt__JobKt {
    @NotNull
    public static final CompletableJob Job(@Nullable Job job0) {
        return new JobImpl(job0);
    }

    public static CompletableJob Job$default(Job job0, int v, Object object0) {
        if((v & 1) != 0) {
            job0 = null;
        }
        return JobKt.Job(job0);
    }

    public static final void cancel(@NotNull Job job0, @NotNull String s, @Nullable Throwable throwable0) {
        job0.cancel(ExceptionsKt.CancellationException(s, throwable0));
    }

    public static final void cancel(@NotNull i i0, @Nullable CancellationException cancellationException0) {
        Job job0 = (Job)i0.get(Job.Key);
        if(job0 != null) {
            job0.cancel(cancellationException0);
        }
    }

    public static void cancel$default(Job job0, String s, Throwable throwable0, int v, Object object0) {
        if((v & 2) != 0) {
            throwable0 = null;
        }
        JobKt.cancel(job0, s, throwable0);
    }

    public static void cancel$default(i i0, CancellationException cancellationException0, int v, Object object0) {
        if((v & 1) != 0) {
            cancellationException0 = null;
        }
        JobKt.cancel(i0, cancellationException0);
    }

    @Nullable
    public static final Object cancelAndJoin(@NotNull Job job0, @NotNull Continuation continuation0) {
        DefaultImpls.cancel$default(job0, null, 1, null);
        Object object0 = job0.join(continuation0);
        return object0 == a.a ? object0 : H.a;
    }

    @NotNull
    public static final DisposableHandle disposeOnCompletion(@NotNull Job job0, @NotNull DisposableHandle disposableHandle0) {
        return JobKt.invokeOnCompletion$default(job0, false, new DisposeOnCompletion(disposableHandle0), 1, null);
    }

    public static final void ensureActive(@NotNull Job job0) {
        if(!job0.isActive()) {
            throw job0.getCancellationException();
        }
    }

    public static final void ensureActive(@NotNull i i0) {
        Job job0 = (Job)i0.get(Job.Key);
        if(job0 != null) {
            JobKt.ensureActive(job0);
        }
    }

    @NotNull
    public static final Job getJob(@NotNull i i0) {
        Job job0 = (Job)i0.get(Job.Key);
        if(job0 == null) {
            throw new IllegalStateException(("Current context doesn\'t contain Job in it: " + i0).toString());
        }
        return job0;
    }

    // 去混淆评级： 低(20)
    @NotNull
    public static final DisposableHandle invokeOnCompletion(@NotNull Job job0, boolean z, @NotNull JobNode jobNode0) {
        return job0 instanceof JobSupport ? ((JobSupport)job0).invokeOnCompletionInternal$kotlinx_coroutines_core(z, jobNode0) : job0.invokeOnCompletion(jobNode0.getOnCancelling(), z, new k(jobNode0) {
            {
                super(1, 0, JobNode.class, object0, "invoke", "invoke(Ljava/lang/Throwable;)V");
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Throwable)object0));
                return H.a;
            }

            public final void invoke(Throwable throwable0) {
                ((JobNode)this.receiver).invoke(throwable0);
            }
        });
    }

    public static DisposableHandle invokeOnCompletion$default(Job job0, boolean z, JobNode jobNode0, int v, Object object0) {
        if((v & 1) != 0) {
            z = true;
        }
        return JobKt.invokeOnCompletion(job0, z, jobNode0);
    }

    public static final boolean isActive(@NotNull i i0) {
        Job job0 = (Job)i0.get(Job.Key);
        return job0 == null ? true : job0.isActive();
    }
}

