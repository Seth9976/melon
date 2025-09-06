package kotlinx.coroutines.flow;

import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.C;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import we.n;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001C\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\n\u001A\u00020\u000BH\u0016¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/flow/StartedLazily;", "Lkotlinx/coroutines/flow/SharingStarted;", "<init>", "()V", "command", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class StartedLazily implements SharingStarted {
    @Override  // kotlinx.coroutines.flow.SharingStarted
    @NotNull
    public Flow command(@NotNull StateFlow stateFlow0) {
        return FlowKt.flow(new n(null) {
            final StateFlow $subscriptionCount;
            private Object L$0;
            int label;

            {
                this.$subscriptionCount = stateFlow0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new kotlinx.coroutines.flow.StartedLazily.command.1(this.$subscriptionCount, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((FlowCollector)object0), ((Continuation)object1));
            }

            public final Object invoke(FlowCollector flowCollector0, Continuation continuation0) {
                return ((kotlinx.coroutines.flow.StartedLazily.command.1)this.create(flowCollector0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        FlowCollector flowCollector0 = (FlowCollector)this.L$0;
                        kotlinx.coroutines.flow.StartedLazily.command.1.1 startedLazily$command$1$10 = new FlowCollector() {
                            public final Object emit(int v, Continuation continuation0) {
                                kotlinx.coroutines.flow.StartedLazily.command.1.1.emit.1 startedLazily$command$1$1$emit$10;
                                if(continuation0 instanceof kotlinx.coroutines.flow.StartedLazily.command.1.1.emit.1) {
                                    startedLazily$command$1$1$emit$10 = (kotlinx.coroutines.flow.StartedLazily.command.1.1.emit.1)continuation0;
                                    int v1 = startedLazily$command$1$1$emit$10.label;
                                    if((v1 & 0x80000000) == 0) {
                                        startedLazily$command$1$1$emit$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                            int label;
                                            Object result;

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                this.result = object0;
                                                this.label |= 0x80000000;
                                                return continuation0.emit(0, this);
                                            }
                                        };
                                    }
                                    else {
                                        startedLazily$command$1$1$emit$10.label = v1 ^ 0x80000000;
                                    }
                                }
                                else {
                                    startedLazily$command$1$1$emit$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                        int label;
                                        Object result;

                                        @Override  // oe.a
                                        public final Object invokeSuspend(Object object0) {
                                            this.result = object0;
                                            this.label |= 0x80000000;
                                            return continuation0.emit(0, this);
                                        }
                                    };
                                }
                                Object object0 = startedLazily$command$1$1$emit$10.result;
                                a a0 = a.a;
                                H h0 = H.a;
                                switch(startedLazily$command$1$1$emit$10.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        if(v > 0) {
                                            C c0 = flowCollector0;
                                            if(!c0.a) {
                                                c0.a = true;
                                                startedLazily$command$1$1$emit$10.label = 1;
                                                if(this.$$this$flow.emit(SharingCommand.START, startedLazily$command$1$1$emit$10) == a0) {
                                                    return a0;
                                                }
                                            }
                                        }
                                        return h0;
                                    }
                                    case 1: {
                                        d5.n.D(object0);
                                        return h0;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                            }

                            @Override  // kotlinx.coroutines.flow.FlowCollector
                            public Object emit(Object object0, Continuation continuation0) {
                                return this.emit(((Number)object0).intValue(), continuation0);
                            }
                        };
                        this.label = 1;
                        if(this.$subscriptionCount.collect(startedLazily$command$1$10, this) == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        });
    }

    @Override
    @NotNull
    public String toString() {
        return "SharingStarted.Lazily";
    }
}

