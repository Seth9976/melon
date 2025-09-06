package kotlinx.coroutines.channels;

import Vb.i;
import d5.n;
import e1.u;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import me.j;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;
import we.k;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A(\u0010\u0004\u001A\u00020\u0002*\u0006\u0012\u0002\b\u00030\u00002\u000E\b\u0002\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005\u001A_\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00000\u000F\"\u0004\b\u0000\u0010\u0006*\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\n2*\b\u0001\u0010\u0003\u001A$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001A\u0093\u0001\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00000\u000F\"\u0004\b\u0000\u0010\u0006*\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\b2\b\b\u0002\u0010\u000B\u001A\u00020\n2\b\b\u0002\u0010\u0013\u001A\u00020\u00122\b\b\u0002\u0010\u0015\u001A\u00020\u00142\u001E\b\u0002\u0010\u0019\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0016j\u0004\u0018\u0001`\u00182*\b\u0001\u0010\u0003\u001A$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\fH\u0000¢\u0006\u0004\b\u0010\u0010\u001A¨\u0006\u001B"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/Function0;", "Lie/H;", "block", "awaitClose", "(Lkotlinx/coroutines/channels/ProducerScope;Lwe/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "E", "Lkotlinx/coroutines/CoroutineScope;", "Lme/i;", "context", "", "capacity", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlinx/coroutines/channels/ReceiveChannel;", "produce", "(Lkotlinx/coroutines/CoroutineScope;Lme/i;ILwe/n;)Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/CoroutineStart;", "start", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/CompletionHandler;", "onCompletion", "(Lkotlinx/coroutines/CoroutineScope;Lme/i;ILkotlinx/coroutines/channels/BufferOverflow;Lkotlinx/coroutines/CoroutineStart;Lwe/k;Lwe/n;)Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class ProduceKt {
    public static H a() {
        return ProduceKt.awaitClose$lambda$0();
    }

    @Nullable
    public static final Object awaitClose(@NotNull ProducerScope producerScope0, @NotNull a a0, @NotNull Continuation continuation0) {
        kotlinx.coroutines.channels.ProduceKt.awaitClose.1 produceKt$awaitClose$10;
        if(continuation0 instanceof kotlinx.coroutines.channels.ProduceKt.awaitClose.1) {
            produceKt$awaitClose$10 = (kotlinx.coroutines.channels.ProduceKt.awaitClose.1)continuation0;
            int v = produceKt$awaitClose$10.label;
            if((v & 0x80000000) == 0) {
                produceKt$awaitClose$10 = new c(continuation0) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return ProduceKt.awaitClose(null, null, this);
                    }
                };
            }
            else {
                produceKt$awaitClose$10.label = v ^ 0x80000000;
            }
        }
        else {
            produceKt$awaitClose$10 = new c(continuation0) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return ProduceKt.awaitClose(null, null, this);
                }
            };
        }
        Object object0 = produceKt$awaitClose$10.result;
        ne.a a1 = ne.a.a;
        switch(produceKt$awaitClose$10.label) {
            case 0: {
                n.D(object0);
                if(produceKt$awaitClose$10.getContext().get(Job.Key) != producerScope0) {
                    throw new IllegalStateException("awaitClose() can only be invoked from the producer context");
                }
                try {
                    produceKt$awaitClose$10.L$0 = producerScope0;
                    produceKt$awaitClose$10.L$1 = a0;
                    produceKt$awaitClose$10.label = 1;
                    CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(produceKt$awaitClose$10), 1);
                    cancellableContinuationImpl0.initCancellability();
                    producerScope0.invokeOnClose(new k() {
                        @Override  // we.k
                        public Object invoke(Object object0) {
                            this.invoke(((Throwable)object0));
                            return H.a;
                        }

                        public final void invoke(Throwable throwable0) {
                            cancellableContinuationImpl0.resumeWith(H.a);
                        }
                    });
                    if(cancellableContinuationImpl0.getResult() == a1) {
                        return a1;
                    }
                    break;
                }
                catch(Throwable throwable0) {
                    a0.invoke();
                    throw throwable0;
                }
            }
            case 1: {
                a0 = (a)produceKt$awaitClose$10.L$1;
                ProducerScope producerScope1 = (ProducerScope)produceKt$awaitClose$10.L$0;
                try {
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable0) {
                    a0.invoke();
                    throw throwable0;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        a0.invoke();
        return H.a;
    }

    public static Object awaitClose$default(ProducerScope producerScope0, a a0, Continuation continuation0, int v, Object object0) {
        if((v & 1) != 0) {
            a0 = new i(5);
        }
        return ProduceKt.awaitClose(producerScope0, a0, continuation0);
    }

    private static final H awaitClose$lambda$0() {
        return H.a;
    }

    @NotNull
    public static final ReceiveChannel produce(@NotNull CoroutineScope coroutineScope0, @NotNull me.i i0, int v, @NotNull BufferOverflow bufferOverflow0, @NotNull CoroutineStart coroutineStart0, @Nullable k k0, @NotNull we.n n0) {
        Channel channel0 = ChannelKt.Channel$default(v, bufferOverflow0, null, 4, null);
        ReceiveChannel receiveChannel0 = new ProducerCoroutine(CoroutineContextKt.newCoroutineContext(coroutineScope0, i0), channel0);
        if(k0 != null) {
            ((JobSupport)receiveChannel0).invokeOnCompletion(k0);
        }
        ((AbstractCoroutine)receiveChannel0).start(coroutineStart0, receiveChannel0, n0);
        return receiveChannel0;
    }

    @NotNull
    public static final ReceiveChannel produce(@NotNull CoroutineScope coroutineScope0, @NotNull me.i i0, int v, @NotNull we.n n0) {
        return ProduceKt.produce(coroutineScope0, i0, v, BufferOverflow.SUSPEND, CoroutineStart.DEFAULT, null, n0);
    }

    public static ReceiveChannel produce$default(CoroutineScope coroutineScope0, me.i i0, int v, BufferOverflow bufferOverflow0, CoroutineStart coroutineStart0, k k0, we.n n0, int v1, Object object0) {
        if((v1 & 1) != 0) {
            i0 = j.a;
        }
        if((v1 & 2) != 0) {
            v = 0;
        }
        if((v1 & 4) != 0) {
            bufferOverflow0 = BufferOverflow.SUSPEND;
        }
        if((v1 & 8) != 0) {
            coroutineStart0 = CoroutineStart.DEFAULT;
        }
        if((v1 & 16) != 0) {
            k0 = null;
        }
        return ProduceKt.produce(coroutineScope0, i0, v, bufferOverflow0, coroutineStart0, k0, n0);
    }

    public static ReceiveChannel produce$default(CoroutineScope coroutineScope0, me.i i0, int v, we.n n0, int v1, Object object0) {
        if((v1 & 1) != 0) {
            i0 = j.a;
        }
        if((v1 & 2) != 0) {
            v = 0;
        }
        return ProduceKt.produce(coroutineScope0, i0, v, n0);
    }
}

