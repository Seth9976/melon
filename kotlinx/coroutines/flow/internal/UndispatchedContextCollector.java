package kotlinx.coroutines.flow.internal;

import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;
import me.i;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001D\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00028\u0000H\u0096@¢\u0006\u0004\b\n\u0010\u000BR\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0014\u0010\u000E\u001A\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000E\u0010\u000FR0\u0010\u0012\u001A\u001E\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/flow/internal/UndispatchedContextCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "downstream", "Lme/i;", "emitContext", "<init>", "(Lkotlinx/coroutines/flow/FlowCollector;Lme/i;)V", "value", "Lie/H;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lme/i;", "", "countOrElement", "Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "emitRef", "Lwe/n;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class UndispatchedContextCollector implements FlowCollector {
    @NotNull
    private final Object countOrElement;
    @NotNull
    private final i emitContext;
    @NotNull
    private final n emitRef;

    public UndispatchedContextCollector(@NotNull FlowCollector flowCollector0, @NotNull i i0) {
        this.emitContext = i0;
        this.countOrElement = ThreadContextKt.threadContextElements(i0);
        this.emitRef = new n(null) {
            final FlowCollector $downstream;
            Object L$0;
            int label;

            {
                this.$downstream = flowCollector0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new kotlinx.coroutines.flow.internal.UndispatchedContextCollector.emitRef.1(this.$downstream, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(object0, ((Continuation)object1));
            }

            public final Object invoke(Object object0, Continuation continuation0) {
                return ((kotlinx.coroutines.flow.internal.UndispatchedContextCollector.emitRef.1)this.create(object0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        this.label = 1;
                        return this.$downstream.emit(this.L$0, this) == a0 ? a0 : H.a;
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

    @Override  // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(Object object0, @NotNull Continuation continuation0) {
        Object object1 = ChannelFlowKt.withContextUndispatched(this.emitContext, object0, this.countOrElement, this.emitRef, continuation0);
        return object1 == a.a ? object1 : H.a;
    }
}

