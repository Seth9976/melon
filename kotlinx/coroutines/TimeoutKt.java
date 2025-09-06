package kotlinx.coroutines;

import H0.b;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001AO\u0010\b\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u00012\"\u0010\u0007\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003H\u0086@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\b\u0010\t\u001AO\u0010\b\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u000B\u001A\u00020\n2\"\u0010\u0007\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003H\u0086@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\f\u0010\t\u001AD\u0010\r\u001A\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001A\u00020\u00012\"\u0010\u0007\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003H\u0086@¢\u0006\u0004\b\r\u0010\t\u001AY\u0010\u0011\u001A\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u000E\"\b\b\u0001\u0010\u0000*\u00028\u00002\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000F2\"\u0010\u0007\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001A\'\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0013\u001A\u00020\u00012\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0010\u001A\u00020\u0016H\u0000¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2 = {"T", "", "timeMillis", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "block", "withTimeout", "(JLwe/n;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LUf/b;", "timeout", "withTimeout-KLykuaI", "withTimeoutOrNull", "U", "Lkotlinx/coroutines/TimeoutCoroutine;", "coroutine", "setupTimeout", "(Lkotlinx/coroutines/TimeoutCoroutine;Lwe/n;)Ljava/lang/Object;", "time", "Lkotlinx/coroutines/Delay;", "delay", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/TimeoutCancellationException;", "TimeoutCancellationException", "(JLkotlinx/coroutines/Delay;Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/TimeoutCancellationException;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class TimeoutKt {
    @NotNull
    public static final TimeoutCancellationException TimeoutCancellationException(long v, @NotNull Delay delay0, @NotNull Job job0) {
        return new TimeoutCancellationException(b.g(v, "Timed out waiting for ", " ms"), job0);
    }

    private static final Object setupTimeout(TimeoutCoroutine timeoutCoroutine0, n n0) {
        JobKt.disposeOnCompletion(timeoutCoroutine0, DelayKt.getDelay(timeoutCoroutine0.uCont.getContext()).invokeOnTimeout(timeoutCoroutine0.time, timeoutCoroutine0, timeoutCoroutine0.getContext()));
        return UndispatchedKt.startUndispatchedOrReturnIgnoreTimeout(timeoutCoroutine0, timeoutCoroutine0, n0);
    }

    @Nullable
    public static final Object withTimeout(long v, @NotNull n n0, @NotNull Continuation continuation0) {
        if(v <= 0L) {
            throw new TimeoutCancellationException("Timed out immediately");
        }
        Object object0 = TimeoutKt.setupTimeout(new TimeoutCoroutine(v, continuation0), n0);
        if(object0 == a.a) {
            q.g(continuation0, "frame");
        }
        return object0;
    }

    @Nullable
    public static final Object withTimeout-KLykuaI(long v, @NotNull n n0, @NotNull Continuation continuation0) {
        return TimeoutKt.withTimeout(DelayKt.toDelayMillis-LRDsOJo(v), n0, continuation0);
    }

    @Nullable
    public static final Object withTimeoutOrNull(long v, @NotNull n n0, @NotNull Continuation continuation0) {
        H h1;
        Object object1;
        kotlinx.coroutines.TimeoutKt.withTimeoutOrNull.1 timeoutKt$withTimeoutOrNull$10;
        if(continuation0 instanceof kotlinx.coroutines.TimeoutKt.withTimeoutOrNull.1) {
            timeoutKt$withTimeoutOrNull$10 = (kotlinx.coroutines.TimeoutKt.withTimeoutOrNull.1)continuation0;
            int v1 = timeoutKt$withTimeoutOrNull$10.label;
            if((v1 & 0x80000000) == 0) {
                timeoutKt$withTimeoutOrNull$10 = new c(continuation0) {
                    long J$0;
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return TimeoutKt.withTimeoutOrNull(0L, null, this);
                    }
                };
            }
            else {
                timeoutKt$withTimeoutOrNull$10.label = v1 ^ 0x80000000;
            }
        }
        else {
            timeoutKt$withTimeoutOrNull$10 = new c(continuation0) {
                long J$0;
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return TimeoutKt.withTimeoutOrNull(0L, null, this);
                }
            };
        }
        Object object0 = timeoutKt$withTimeoutOrNull$10.result;
        a a0 = a.a;
        switch(timeoutKt$withTimeoutOrNull$10.label) {
            case 0: {
                d5.n.D(object0);
                if(v <= 0L) {
                    return null;
                }
                H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                try {
                    timeoutKt$withTimeoutOrNull$10.L$0 = n0;
                    timeoutKt$withTimeoutOrNull$10.L$1 = h0;
                    timeoutKt$withTimeoutOrNull$10.J$0 = v;
                    timeoutKt$withTimeoutOrNull$10.label = 1;
                    TimeoutCoroutine timeoutCoroutine0 = new TimeoutCoroutine(v, timeoutKt$withTimeoutOrNull$10);
                    h0.a = timeoutCoroutine0;
                    object1 = TimeoutKt.setupTimeout(timeoutCoroutine0, n0);
                }
                catch(TimeoutCancellationException timeoutCancellationException0) {
                    h1 = h0;
                    goto label_36;
                }
                return object1 == a0 ? a0 : object1;
            }
            case 1: {
                h1 = (H)timeoutKt$withTimeoutOrNull$10.L$1;
                n n1 = (n)timeoutKt$withTimeoutOrNull$10.L$0;
                try {
                    d5.n.D(object0);
                    return object0;
                }
                catch(TimeoutCancellationException timeoutCancellationException0) {
                }
            label_36:
                if(timeoutCancellationException0.coroutine != h1.a) {
                    throw timeoutCancellationException0;
                }
                return null;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

