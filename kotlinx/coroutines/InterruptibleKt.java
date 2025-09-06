package kotlinx.coroutines;

import ie.H;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import me.i;
import me.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;
import we.n;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001A.\u0010\u0005\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006\u001A+\u0010\b\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0007\u001A\u00020\u00012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"T", "Lme/i;", "context", "Lkotlin/Function0;", "block", "runInterruptible", "(Lme/i;Lwe/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coroutineContext", "runInterruptibleInExpectedContext", "(Lme/i;Lwe/a;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class InterruptibleKt {
    @Nullable
    public static final Object runInterruptible(@NotNull i i0, @NotNull a a0, @NotNull Continuation continuation0) {
        return BuildersKt.withContext(i0, new n(a0, null) {
            final a $block;
            private Object L$0;
            int label;

            {
                this.$block = a0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new kotlinx.coroutines.InterruptibleKt.runInterruptible.2(this.$block, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((kotlinx.coroutines.InterruptibleKt.runInterruptible.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                return InterruptibleKt.runInterruptibleInExpectedContext(((CoroutineScope)this.L$0).getCoroutineContext(), this.$block);
            }
        }, continuation0);
    }

    public static Object runInterruptible$default(i i0, a a0, Continuation continuation0, int v, Object object0) {
        if((v & 1) != 0) {
            i0 = j.a;
        }
        return InterruptibleKt.runInterruptible(i0, a0, continuation0);
    }

    private static final Object runInterruptibleInExpectedContext(i i0, a a0) {
        try {
            ThreadState threadState0 = new ThreadState();
            threadState0.setup(JobKt.getJob(i0));
            try {
                return a0.invoke();
            }
            finally {
                threadState0.clearInterrupt();
            }
        }
        catch(InterruptedException interruptedException0) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(interruptedException0);
        }
    }
}

