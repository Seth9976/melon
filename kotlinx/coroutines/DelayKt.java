package kotlinx.coroutines;

import Uf.b;
import Uf.d;
import d5.n;
import e1.u;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import me.e;
import me.g;
import me.i;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0010\u0010\u0001\u001A\u00020\u0000H\u0086@¢\u0006\u0004\b\u0001\u0010\u0002\u001A\u0018\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00020\u0003H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007\u001A\u0018\u0010\u0006\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\bH\u0086@¢\u0006\u0004\b\n\u0010\u0007\u001A\u0013\u0010\r\u001A\u00020\u0003*\u00020\bH\u0000¢\u0006\u0004\b\u000B\u0010\f\"\u0018\u0010\u0006\u001A\u00020\u000F*\u00020\u000E8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"", "awaitCancellation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "timeMillis", "Lie/H;", "delay", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LUf/b;", "duration", "delay-VtjQ1oo", "toDelayMillis-LRDsOJo", "(J)J", "toDelayMillis", "Lme/i;", "Lkotlinx/coroutines/Delay;", "getDelay", "(Lme/i;)Lkotlinx/coroutines/Delay;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class DelayKt {
    @Nullable
    public static final Object awaitCancellation(@NotNull Continuation continuation0) {
        kotlinx.coroutines.DelayKt.awaitCancellation.1 delayKt$awaitCancellation$10;
        if(continuation0 instanceof kotlinx.coroutines.DelayKt.awaitCancellation.1) {
            delayKt$awaitCancellation$10 = (kotlinx.coroutines.DelayKt.awaitCancellation.1)continuation0;
            int v = delayKt$awaitCancellation$10.label;
            if((v & 0x80000000) == 0) {
                delayKt$awaitCancellation$10 = new c(continuation0) {
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return DelayKt.awaitCancellation(this);
                    }
                };
            }
            else {
                delayKt$awaitCancellation$10.label = v ^ 0x80000000;
            }
        }
        else {
            delayKt$awaitCancellation$10 = new c(continuation0) {
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return DelayKt.awaitCancellation(this);
                }
            };
        }
        Object object0 = delayKt$awaitCancellation$10.result;
        a a0 = a.a;
        switch(delayKt$awaitCancellation$10.label) {
            case 0: {
                n.D(object0);
                delayKt$awaitCancellation$10.label = 1;
                CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(delayKt$awaitCancellation$10), 1);
                cancellableContinuationImpl0.initCancellability();
                if(cancellableContinuationImpl0.getResult() == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    @Nullable
    public static final Object delay(long v, @NotNull Continuation continuation0) {
        if(v > 0L) {
            CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(continuation0), 1);
            cancellableContinuationImpl0.initCancellability();
            if(v < 0x7FFFFFFFFFFFFFFFL) {
                DelayKt.getDelay(cancellableContinuationImpl0.getContext()).scheduleResumeAfterDelay(v, cancellableContinuationImpl0);
            }
            Object object0 = cancellableContinuationImpl0.getResult();
            if(object0 == a.a) {
                return object0;
            }
        }
        return H.a;
    }

    @Nullable
    public static final Object delay-VtjQ1oo(long v, @NotNull Continuation continuation0) {
        Object object0 = DelayKt.delay(DelayKt.toDelayMillis-LRDsOJo(v), continuation0);
        return object0 == a.a ? object0 : H.a;
    }

    @NotNull
    public static final Delay getDelay(@NotNull i i0) {
        g g0 = i0.get(e.a);
        Delay delay0 = g0 instanceof Delay ? ((Delay)g0) : null;
        return delay0 == null ? DefaultExecutorKt.getDefaultDelay() : delay0;
    }

    // 去混淆评级： 低(30)
    public static final long toDelayMillis-LRDsOJo(long v) {
        return Long.compare(v, 0L) <= 0 ? b.d(b.h(v, x1.a.Q(0xF423FL, d.b))) : 0L;
    }
}

