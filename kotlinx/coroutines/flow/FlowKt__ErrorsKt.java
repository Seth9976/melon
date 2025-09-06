package kotlinx.coroutines.flow;

import H0.b;
import d5.n;
import ie.H;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.Job;
import me.i;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.o;
import we.p;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u001AS\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012.\u0010\b\u001A*\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0002¢\u0006\u0004\b\t\u0010\n\u001AY\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000124\u0010\u000E\u001A0\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000B¢\u0006\u0004\b\u000F\u0010\u0010\u001A0\u0010\u0012\u001A\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0080@¢\u0006\u0004\b\u0012\u0010\u0013\u001A\u001B\u0010\u0018\u001A\u00020\r*\u00020\u00042\u0006\u0010\u0015\u001A\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001A\u001D\u0010\u001C\u001A\u00020\r*\u00020\u00042\b\u0010\u0019\u001A\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u001A\u0010\u001B¨\u0006\u001D"}, d2 = {"T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/coroutines/Continuation;", "Lie/H;", "", "action", "catch", "(Lkotlinx/coroutines/flow/Flow;Lwe/o;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function4;", "", "", "predicate", "retryWhen", "(Lkotlinx/coroutines/flow/Flow;Lwe/p;)Lkotlinx/coroutines/flow/Flow;", "collector", "catchImpl", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lme/i;", "coroutineContext", "isCancellationCause$FlowKt__ErrorsKt", "(Ljava/lang/Throwable;Lme/i;)Z", "isCancellationCause", "other", "isSameExceptionAs$FlowKt__ErrorsKt", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)Z", "isSameExceptionAs", "kotlinx-coroutines-core"}, k = 5, mv = {2, 1, 0}, xi = 0x30, xs = "kotlinx/coroutines/flow/FlowKt")
abstract class FlowKt__ErrorsKt {
    @NotNull
    public static final Flow catch(@NotNull Flow flow0, @NotNull o o0) {
        return new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                kotlinx.coroutines.flow.FlowKt__ErrorsKt.catch..inlined.unsafeFlow.1 flowKt__ErrorsKt$catch$$inlined$unsafeFlow$10;
                kotlinx.coroutines.flow.FlowKt__ErrorsKt.catch..inlined.unsafeFlow.1.1 flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$10;
                if(continuation0 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt.catch..inlined.unsafeFlow.1.1) {
                    flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$10 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt.catch..inlined.unsafeFlow.1.1)continuation0;
                    int v = flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$10.label;
                    if((v & 0x80000000) == 0) {
                        flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                            Object L$0;
                            Object L$1;
                            int label;
                            Object result;

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                this.result = object0;
                                this.label |= 0x80000000;
                                return continuation0.collect(null, this);
                            }
                        };
                    }
                    else {
                        flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$10.label = v ^ 0x80000000;
                    }
                }
                else {
                    flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        Object L$0;
                        Object L$1;
                        int label;
                        Object result;

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.collect(null, this);
                        }
                    };
                }
                Object object0 = flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$10.result;
                a a0 = a.a;
                switch(flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$10.label) {
                    case 0: {
                        n.D(object0);
                        flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$10.L$0 = this;
                        flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$10.L$1 = flowCollector0;
                        flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$10.label = 1;
                        object0 = FlowKt.catchImpl(flow0, flowCollector0, flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$10);
                        if(object0 == a0) {
                            return a0;
                        }
                        flowKt__ErrorsKt$catch$$inlined$unsafeFlow$10 = this;
                        break;
                    }
                    case 1: {
                        flowCollector0 = (FlowCollector)flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$10.L$1;
                        flowKt__ErrorsKt$catch$$inlined$unsafeFlow$10 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt.catch..inlined.unsafeFlow.1)flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$10.L$0;
                        n.D(object0);
                        break;
                    }
                    case 2: {
                        n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                if(((Throwable)object0) != null) {
                    flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$10.L$0 = null;
                    flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$10.L$1 = null;
                    flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$10.label = 2;
                    if(flowKt__ErrorsKt$catch$$inlined$unsafeFlow$10.$action$inlined.invoke(flowCollector0, ((Throwable)object0), flowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$10) == a0) {
                        return a0;
                    }
                }
                return H.a;
            }
        };
    }

    @Nullable
    public static final Object catchImpl(@NotNull Flow flow0, @NotNull FlowCollector flowCollector0, @NotNull Continuation continuation0) {
        kotlin.jvm.internal.H h1;
        kotlinx.coroutines.flow.FlowKt__ErrorsKt.catchImpl.1 flowKt__ErrorsKt$catchImpl$10;
        if(continuation0 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt.catchImpl.1) {
            flowKt__ErrorsKt$catchImpl$10 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt.catchImpl.1)continuation0;
            int v = flowKt__ErrorsKt$catchImpl$10.label;
            if((v & 0x80000000) == 0) {
                flowKt__ErrorsKt$catchImpl$10 = new c(continuation0) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return FlowKt.catchImpl(null, null, this);
                    }
                };
            }
            else {
                flowKt__ErrorsKt$catchImpl$10.label = v ^ 0x80000000;
            }
        }
        else {
            flowKt__ErrorsKt$catchImpl$10 = new c(continuation0) {
                Object L$0;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return FlowKt.catchImpl(null, null, this);
                }
            };
        }
        Object object0 = flowKt__ErrorsKt$catchImpl$10.result;
        a a0 = a.a;
        switch(flowKt__ErrorsKt$catchImpl$10.label) {
            case 0: {
                kotlin.jvm.internal.H h0 = b.p(object0);
                try {
                    kotlinx.coroutines.flow.FlowKt__ErrorsKt.catchImpl.2 flowKt__ErrorsKt$catchImpl$20 = new FlowCollector() {
                        @Override  // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(Object object0, Continuation continuation0) {
                            kotlinx.coroutines.flow.FlowKt__ErrorsKt.catchImpl.2 flowKt__ErrorsKt$catchImpl$20;
                            kotlinx.coroutines.flow.FlowKt__ErrorsKt.catchImpl.2.emit.1 flowKt__ErrorsKt$catchImpl$2$emit$10;
                            if(continuation0 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt.catchImpl.2.emit.1) {
                                flowKt__ErrorsKt$catchImpl$2$emit$10 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt.catchImpl.2.emit.1)continuation0;
                                int v = flowKt__ErrorsKt$catchImpl$2$emit$10.label;
                                if((v & 0x80000000) == 0) {
                                    flowKt__ErrorsKt$catchImpl$2$emit$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                        Object L$0;
                                        int label;
                                        Object result;

                                        @Override  // oe.a
                                        public final Object invokeSuspend(Object object0) {
                                            this.result = object0;
                                            this.label |= 0x80000000;
                                            return continuation0.emit(null, this);
                                        }
                                    };
                                }
                                else {
                                    flowKt__ErrorsKt$catchImpl$2$emit$10.label = v ^ 0x80000000;
                                }
                            }
                            else {
                                flowKt__ErrorsKt$catchImpl$2$emit$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                    Object L$0;
                                    int label;
                                    Object result;

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        this.result = object0;
                                        this.label |= 0x80000000;
                                        return continuation0.emit(null, this);
                                    }
                                };
                            }
                            Object object1 = flowKt__ErrorsKt$catchImpl$2$emit$10.result;
                            a a0 = a.a;
                            switch(flowKt__ErrorsKt$catchImpl$2$emit$10.label) {
                                case 0: {
                                    n.D(object1);
                                    try {
                                        flowKt__ErrorsKt$catchImpl$2$emit$10.L$0 = this;
                                        flowKt__ErrorsKt$catchImpl$2$emit$10.label = 1;
                                        return flowCollector0.emit(object0, flowKt__ErrorsKt$catchImpl$2$emit$10) == a0 ? a0 : H.a;
                                    }
                                    catch(Throwable throwable0) {
                                        flowKt__ErrorsKt$catchImpl$20 = this;
                                        flowKt__ErrorsKt$catchImpl$20.$fromDownstream.a = throwable0;
                                        throw throwable0;
                                    }
                                }
                                case 1: {
                                    flowKt__ErrorsKt$catchImpl$20 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt.catchImpl.2)flowKt__ErrorsKt$catchImpl$2$emit$10.L$0;
                                    try {
                                        n.D(object1);
                                        return H.a;
                                    }
                                    catch(Throwable throwable0) {
                                    }
                                    flowKt__ErrorsKt$catchImpl$20.$fromDownstream.a = throwable0;
                                    throw throwable0;
                                }
                                default: {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                            }
                        }
                    };
                    flowKt__ErrorsKt$catchImpl$10.L$0 = h0;
                    flowKt__ErrorsKt$catchImpl$10.label = 1;
                    return flow0.collect(flowKt__ErrorsKt$catchImpl$20, flowKt__ErrorsKt$catchImpl$10) == a0 ? a0 : null;
                }
                catch(Throwable object1) {
                    h1 = h0;
                    goto label_28;
                }
                return a0;
            }
            case 1: {
                h1 = (kotlin.jvm.internal.H)flowKt__ErrorsKt$catchImpl$10.L$0;
                try {
                    n.D(object0);
                    return null;
                }
                catch(Throwable object1) {
                }
            label_28:
                Throwable throwable0 = (Throwable)h1.a;
                if(FlowKt__ErrorsKt.isSameExceptionAs$FlowKt__ErrorsKt(((Throwable)object1), throwable0) || FlowKt__ErrorsKt.isCancellationCause$FlowKt__ErrorsKt(((Throwable)object1), flowKt__ErrorsKt$catchImpl$10.getContext())) {
                    throw object1;
                }
                if(throwable0 == null) {
                    return object1;
                }
                if(object1 instanceof CancellationException) {
                    e2.a.q(throwable0, ((Throwable)object1));
                    throw throwable0;
                }
                e2.a.q(((Throwable)object1), throwable0);
                throw object1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    private static final boolean isCancellationCause$FlowKt__ErrorsKt(Throwable throwable0, i i0) {
        Job job0 = (Job)i0.get(Job.Key);
        return job0 == null || !job0.isCancelled() ? false : FlowKt__ErrorsKt.isSameExceptionAs$FlowKt__ErrorsKt(throwable0, job0.getCancellationException());
    }

    private static final boolean isSameExceptionAs$FlowKt__ErrorsKt(Throwable throwable0, Throwable throwable1) {
        return throwable1 != null && q.b(throwable1, throwable0);
    }

    @NotNull
    public static final Flow retryWhen(@NotNull Flow flow0, @NotNull p p0) {
        return new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                Throwable throwable0;
                kotlinx.coroutines.flow.FlowKt__ErrorsKt.retryWhen..inlined.unsafeFlow.1 flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$11;
                FlowCollector flowCollector1;
                int v2;
                kotlinx.coroutines.flow.FlowKt__ErrorsKt.retryWhen..inlined.unsafeFlow.1 flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$10;
                long v1;
                kotlinx.coroutines.flow.FlowKt__ErrorsKt.retryWhen..inlined.unsafeFlow.1.1 flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10;
                if(continuation0 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt.retryWhen..inlined.unsafeFlow.1.1) {
                    flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt.retryWhen..inlined.unsafeFlow.1.1)continuation0;
                    int v = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10.label;
                    if((v & 0x80000000) == 0) {
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                            int I$0;
                            long J$0;
                            Object L$0;
                            Object L$1;
                            Object L$2;
                            int label;
                            Object result;

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                this.result = object0;
                                this.label |= 0x80000000;
                                return continuation0.collect(null, this);
                            }
                        };
                    }
                    else {
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10.label = v ^ 0x80000000;
                    }
                }
                else {
                    flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        int I$0;
                        long J$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        int label;
                        Object result;

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.collect(null, this);
                        }
                    };
                }
                Object object0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10.result;
                a a0 = a.a;
                switch(flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10.label) {
                    case 0: {
                        n.D(object0);
                        v1 = 0L;
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$10 = this;
                        goto label_35;
                    }
                    case 1: {
                        v2 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10.I$0;
                        v1 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10.J$0;
                        flowCollector1 = (FlowCollector)flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10.L$1;
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$11 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt.retryWhen..inlined.unsafeFlow.1)flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10.L$0;
                        n.D(object0);
                        goto label_47;
                    }
                    case 2: {
                        v1 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10.J$0;
                        throwable0 = (Throwable)flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10.L$2;
                        flowCollector1 = (FlowCollector)flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10.L$1;
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$11 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt.retryWhen..inlined.unsafeFlow.1)flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10.L$0;
                        n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            label_28:
                while(((Boolean)object0).booleanValue()) {
                    ++v1;
                    v2 = 1;
                    while(true) {
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$10 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$11;
                        if(v2 == 0) {
                            return H.a;
                        }
                        flowCollector0 = flowCollector1;
                    label_35:
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10.L$0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$10;
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10.L$1 = flowCollector0;
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10.L$2 = null;
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10.J$0 = v1;
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10.I$0 = 0;
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10.label = 1;
                        Object object1 = FlowKt.catchImpl(flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$10.$this_retryWhen$inlined, flowCollector0, flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10);
                        if(object1 == a0) {
                            break;
                        }
                        flowCollector1 = flowCollector0;
                        v2 = 0;
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$11 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$10;
                        object0 = object1;
                    label_47:
                        if(((Throwable)object0) == null) {
                            continue;
                        }
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10.L$0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$11;
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10.L$1 = flowCollector1;
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10.L$2 = (Throwable)object0;
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10.J$0 = v1;
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10.label = 2;
                        Object object2 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$11.$predicate$inlined.invoke(flowCollector1, ((Throwable)object0), new Long(v1), flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$10);
                        if(object2 == a0) {
                            break;
                        }
                        Throwable throwable1 = (Throwable)object0;
                        object0 = object2;
                        throwable0 = throwable1;
                        continue label_28;
                    }
                    return a0;
                }
                throw throwable0;
            }
        };
    }
}

