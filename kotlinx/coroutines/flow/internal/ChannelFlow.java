package kotlinx.coroutines.flow.internal;

import androidx.appcompat.app.o;
import ie.H;
import java.util.ArrayList;
import je.p;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import me.i;
import me.j;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001F\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007\u00A2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000BH\u0016\u00A2\u0006\u0004\b\f\u0010\rJ-\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00000\u000B2\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\u000E\u0010\u000FJ-\u0010\u0010\u001A\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u0007H$\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u001E\u0010\u0015\u001A\u00020\u00142\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0012H\u00A4@\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u001D\u0010\u0019\u001A\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u0013\u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u001E\u0010\u001D\u001A\u00020\u00142\f\u0010\u001C\u001A\b\u0012\u0004\u0012\u00028\u00000\u001BH\u0096@\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0011\u0010 \u001A\u0004\u0018\u00010\u001FH\u0014\u00A2\u0006\u0004\b \u0010!J\u000F\u0010\"\u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\b\"\u0010!R\u0014\u0010\u0004\u001A\u00020\u00038\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\u0004\u0010#R\u0014\u0010\u0006\u001A\u00020\u00058\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\u0006\u0010$R\u0014\u0010\b\u001A\u00020\u00078\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\b\u0010%R6\u0010+\u001A$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\'\u0012\u0006\u0012\u0004\u0018\u00010(0&8@X\u0080\u0004\u00A2\u0006\u0006\u001A\u0004\b)\u0010*R\u0014\u0010.\u001A\u00020\u00058@X\u0080\u0004\u00A2\u0006\u0006\u001A\u0004\b,\u0010-\u00A8\u0006/"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlow;", "T", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "Lme/i;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(Lme/i;ILkotlinx/coroutines/channels/BufferOverflow;)V", "Lkotlinx/coroutines/flow/Flow;", "dropChannelOperators", "()Lkotlinx/coroutines/flow/Flow;", "fuse", "(Lme/i;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "create", "(Lme/i;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/channels/ProducerScope;", "scope", "Lie/H;", "collectTo", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "produceImpl", "(Lkotlinx/coroutines/CoroutineScope;)Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "additionalToStringProps", "()Ljava/lang/String;", "toString", "Lme/i;", "I", "Lkotlinx/coroutines/channels/BufferOverflow;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "getCollectToFun$kotlinx_coroutines_core", "()Lwe/n;", "collectToFun", "getProduceCapacity$kotlinx_coroutines_core", "()I", "produceCapacity", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public abstract class ChannelFlow implements FusibleFlow {
    public final int capacity;
    @NotNull
    public final i context;
    @NotNull
    public final BufferOverflow onBufferOverflow;

    public ChannelFlow(@NotNull i i0, int v, @NotNull BufferOverflow bufferOverflow0) {
        this.context = i0;
        this.capacity = v;
        this.onBufferOverflow = bufferOverflow0;
    }

    @Nullable
    public String additionalToStringProps() {
        return null;
    }

    @Override  // kotlinx.coroutines.flow.Flow
    @Nullable
    public Object collect(@NotNull FlowCollector flowCollector0, @NotNull Continuation continuation0) {
        return ChannelFlow.collect$suspendImpl(this, flowCollector0, continuation0);
    }

    public static Object collect$suspendImpl(ChannelFlow channelFlow0, FlowCollector flowCollector0, Continuation continuation0) {
        Object object0 = CoroutineScopeKt.coroutineScope(new n(flowCollector0, channelFlow0, null) {
            final FlowCollector $collector;
            private Object L$0;
            int label;

            {
                this.$collector = flowCollector0;
                ChannelFlow.this = channelFlow0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new kotlinx.coroutines.flow.internal.ChannelFlow.collect.2(this.$collector, ChannelFlow.this, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((kotlinx.coroutines.flow.internal.ChannelFlow.collect.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        ReceiveChannel receiveChannel0 = ChannelFlow.this.produceImpl(((CoroutineScope)this.L$0));
                        this.label = 1;
                        return FlowKt.emitAll(this.$collector, receiveChannel0, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, continuation0);
        return object0 == a.a ? object0 : H.a;
    }

    @Nullable
    public abstract Object collectTo(@NotNull ProducerScope arg1, @NotNull Continuation arg2);

    @NotNull
    public abstract ChannelFlow create(@NotNull i arg1, int arg2, @NotNull BufferOverflow arg3);

    @Nullable
    public Flow dropChannelOperators() {
        return null;
    }

    @Override  // kotlinx.coroutines.flow.internal.FusibleFlow
    @NotNull
    public Flow fuse(@NotNull i i0, int v, @NotNull BufferOverflow bufferOverflow0) {
        i i1 = i0.plus(this.context);
        if(bufferOverflow0 == BufferOverflow.SUSPEND) {
            int v1 = this.capacity;
            if(v1 != -3) {
                if(v == -3) {
                    v = v1;
                }
                else if(v1 != -2) {
                    if(v == -2) {
                        v = v1;
                    }
                    else {
                        v += v1;
                        if(v < 0) {
                            v = 0x7FFFFFFF;
                        }
                    }
                }
            }
            bufferOverflow0 = this.onBufferOverflow;
        }
        return !q.b(i1, this.context) || v != this.capacity || bufferOverflow0 != this.onBufferOverflow ? this.create(i1, v, bufferOverflow0) : this;
    }

    @NotNull
    public final n getCollectToFun$kotlinx_coroutines_core() {
        return new n(null) {
            Object L$0;
            int label;

            {
                ChannelFlow.this = channelFlow0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new kotlinx.coroutines.flow.internal.ChannelFlow.collectToFun.1(ChannelFlow.this, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((ProducerScope)object0), ((Continuation)object1));
            }

            public final Object invoke(ProducerScope producerScope0, Continuation continuation0) {
                return ((kotlinx.coroutines.flow.internal.ChannelFlow.collectToFun.1)this.create(producerScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        this.label = 1;
                        return ChannelFlow.this.collectTo(((ProducerScope)this.L$0), this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        };
    }

    public final int getProduceCapacity$kotlinx_coroutines_core() {
        return this.capacity == -3 ? -2 : this.capacity;
    }

    @NotNull
    public ReceiveChannel produceImpl(@NotNull CoroutineScope coroutineScope0) {
        int v = this.getProduceCapacity$kotlinx_coroutines_core();
        n n0 = this.getCollectToFun$kotlinx_coroutines_core();
        return ProduceKt.produce$default(coroutineScope0, this.context, v, this.onBufferOverflow, CoroutineStart.ATOMIC, null, n0, 16, null);
    }

    @Override
    @NotNull
    public String toString() {
        ArrayList arrayList0 = new ArrayList(4);
        String s = this.additionalToStringProps();
        if(s != null) {
            arrayList0.add(s);
        }
        if(this.context != j.a) {
            arrayList0.add("context=" + this.context);
        }
        if(this.capacity != -3) {
            arrayList0.add("capacity=" + this.capacity);
        }
        if(this.onBufferOverflow != BufferOverflow.SUSPEND) {
            arrayList0.add("onBufferOverflow=" + this.onBufferOverflow);
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(DebugStringsKt.getClassSimpleName(this));
        stringBuilder0.append('[');
        return o.r(stringBuilder0, p.q0(arrayList0, ", ", null, null, null, 62), ']');
    }
}

