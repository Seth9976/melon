package kotlinx.coroutines;

import d5.n;
import ie.H;
import java.util.Collection;
import je.w;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u001E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A<\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\u001E\u0010\u0003\u001A\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001\"\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006\u001A,\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0007H\u0086@¢\u0006\u0004\b\u0005\u0010\b\u001A$\u0010\f\u001A\u00020\u000B2\u0012\u0010\n\u001A\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0001\"\u00020\tH\u0086@¢\u0006\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"T", "", "Lkotlinx/coroutines/Deferred;", "deferreds", "", "awaitAll", "([Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/Job;", "jobs", "Lie/H;", "joinAll", "([Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class AwaitKt {
    @Nullable
    public static final Object awaitAll(@NotNull Collection collection0, @NotNull Continuation continuation0) {
        return collection0.isEmpty() ? w.a : new AwaitAll(((Deferred[])collection0.toArray(new Deferred[0]))).await(continuation0);
    }

    @Nullable
    public static final Object awaitAll(@NotNull Deferred[] arr_deferred, @NotNull Continuation continuation0) {
        return arr_deferred.length == 0 ? w.a : new AwaitAll(arr_deferred).await(continuation0);
    }

    @Nullable
    public static final Object joinAll(@NotNull Job[] arr_job, @NotNull Continuation continuation0) {
        int v2;
        Job[] arr_job1;
        int v1;
        kotlinx.coroutines.AwaitKt.joinAll.1 awaitKt$joinAll$10;
        if(continuation0 instanceof kotlinx.coroutines.AwaitKt.joinAll.1) {
            awaitKt$joinAll$10 = (kotlinx.coroutines.AwaitKt.joinAll.1)continuation0;
            int v = awaitKt$joinAll$10.label;
            if((v & 0x80000000) == 0) {
                awaitKt$joinAll$10 = new c(continuation0) {
                    int I$0;
                    int I$1;
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return AwaitKt.joinAll(null, this);
                    }
                };
            }
            else {
                awaitKt$joinAll$10.label = v ^ 0x80000000;
            }
        }
        else {
            awaitKt$joinAll$10 = new c(continuation0) {
                int I$0;
                int I$1;
                Object L$0;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return AwaitKt.joinAll(null, this);
                }
            };
        }
        Object object0 = awaitKt$joinAll$10.result;
        a a0 = a.a;
        switch(awaitKt$joinAll$10.label) {
            case 0: {
                n.D(object0);
                v1 = 0;
                arr_job1 = arr_job;
                v2 = arr_job.length;
                goto label_24;
            }
            case 1: {
                v2 = awaitKt$joinAll$10.I$1;
                v1 = awaitKt$joinAll$10.I$0;
                Job[] arr_job2 = (Job[])awaitKt$joinAll$10.L$0;
                n.D(object0);
                arr_job1 = arr_job2;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(true) {
            ++v1;
        label_24:
            if(v1 >= v2) {
                break;
            }
            awaitKt$joinAll$10.L$0 = arr_job1;
            awaitKt$joinAll$10.I$0 = v1;
            awaitKt$joinAll$10.I$1 = v2;
            awaitKt$joinAll$10.label = 1;
            if(arr_job1[v1].join(awaitKt$joinAll$10) != a0) {
                continue;
            }
            return a0;
        }
        return H.a;
    }
}

