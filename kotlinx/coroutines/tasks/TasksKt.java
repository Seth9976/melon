package kotlinx.coroutines.tasks;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import d5.n;
import e1.u;
import ie.H;
import ie.o;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CancellableContinuation.DefaultImpls;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A \u0010\u0002\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@¢\u0006\u0004\b\u0002\u0010\u0003\u001A*\u0010\u0006\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0082@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"T", "Lcom/google/android/gms/tasks/Task;", "await", "(Lcom/google/android/gms/tasks/Task;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/android/gms/tasks/CancellationTokenSource;", "cancellationTokenSource", "awaitImpl", "(Lcom/google/android/gms/tasks/Task;Lcom/google/android/gms/tasks/CancellationTokenSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-play-services"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class TasksKt {
    @Nullable
    public static final Object await(@NotNull Task task0, @NotNull Continuation continuation0) {
        return TasksKt.awaitImpl(task0, null, continuation0);
    }

    private static final Object awaitImpl(Task task0, CancellationTokenSource cancellationTokenSource0, Continuation continuation0) {
        if(task0.isComplete()) {
            Exception exception0 = task0.getException();
            if(exception0 != null) {
                throw exception0;
            }
            if(task0.isCanceled()) {
                throw new CancellationException("Task " + task0 + " was cancelled normally.");
            }
            return task0.getResult();
        }
        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(continuation0), 1);
        cancellableContinuationImpl0.initCancellability();
        kotlinx.coroutines.tasks.TasksKt.awaitImpl.2.1 tasksKt$awaitImpl$2$10 = new OnCompleteListener() {
            @Override  // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task0) {
                Exception exception0 = task0.getException();
                if(exception0 == null) {
                    if(task0.isCanceled()) {
                        DefaultImpls.cancel$default(cancellableContinuationImpl0, null, 1, null);
                        return;
                    }
                    Object object0 = task0.getResult();
                    cancellableContinuationImpl0.resumeWith(object0);
                    return;
                }
                o o0 = n.t(exception0);
                cancellableContinuationImpl0.resumeWith(o0);
            }
        };
        task0.addOnCompleteListener((DirectExecutor this) -> runnable0.run(), tasksKt$awaitImpl$2$10);
        if(cancellationTokenSource0 != null) {
            cancellableContinuationImpl0.invokeOnCancellation(new k() {
                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((Throwable)object0));
                    return H.a;
                }

                public final void invoke(Throwable throwable0) {
                    cancellationTokenSource0.cancel();
                }
            });
        }
        return cancellableContinuationImpl0.getResult();
    }
}

