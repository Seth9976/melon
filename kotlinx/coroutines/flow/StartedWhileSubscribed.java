package kotlinx.coroutines.flow;

import H0.b;
import d5.n;
import e.k;
import ie.H;
import je.p;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.DelayKt;
import ne.a;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.o;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001C\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000BH\u0016J\b\u0010\r\u001A\u00020\u000EH\u0016J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001A\u00020\fH\u0017R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/flow/StartedWhileSubscribed;", "Lkotlinx/coroutines/flow/SharingStarted;", "stopTimeout", "", "replayExpiration", "<init>", "(JJ)V", "command", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "", "toString", "", "equals", "", "other", "", "hashCode", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class StartedWhileSubscribed implements SharingStarted {
    private final long replayExpiration;
    private final long stopTimeout;

    public StartedWhileSubscribed(long v, long v1) {
        this.stopTimeout = v;
        this.replayExpiration = v1;
        if(Long.compare(v, 0L) < 0) {
            throw new IllegalArgumentException(b.g(v, "stopTimeout(", " ms) cannot be negative").toString());
        }
        if(v1 < 0L) {
            throw new IllegalArgumentException(b.g(v1, "replayExpiration(", " ms) cannot be negative").toString());
        }
    }

    @Override  // kotlinx.coroutines.flow.SharingStarted
    @NotNull
    public Flow command(@NotNull StateFlow stateFlow0) {
        return FlowKt.distinctUntilChanged(FlowKt.dropWhile(FlowKt.transformLatest(stateFlow0, new o(null) {
            int I$0;
            private Object L$0;
            int label;

            {
                StartedWhileSubscribed.this = startedWhileSubscribed0;
                super(3, continuation0);
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((FlowCollector)object0), ((Number)object1).intValue(), ((Continuation)object2));
            }

            public final Object invoke(FlowCollector flowCollector0, int v, Continuation continuation0) {
                kotlinx.coroutines.flow.StartedWhileSubscribed.command.1 startedWhileSubscribed$command$10 = new kotlinx.coroutines.flow.StartedWhileSubscribed.command.1(StartedWhileSubscribed.this, continuation0);
                startedWhileSubscribed$command$10.L$0 = flowCollector0;
                startedWhileSubscribed$command$10.I$0 = v;
                return startedWhileSubscribed$command$10.invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                FlowCollector flowCollector0;
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        n.D(object0);
                        flowCollector0 = (FlowCollector)this.L$0;
                        if(this.I$0 > 0) {
                            this.label = 1;
                            return flowCollector0.emit(SharingCommand.START, this) != a0 ? H.a : a0;
                        }
                        this.L$0 = flowCollector0;
                        this.label = 2;
                        if(DelayKt.delay(StartedWhileSubscribed.this.stopTimeout, this) != a0) {
                        label_23:
                            if(StartedWhileSubscribed.this.replayExpiration > 0L) {
                                this.L$0 = flowCollector0;
                                this.label = 3;
                                if(flowCollector0.emit(SharingCommand.STOP, this) != a0) {
                                label_27:
                                    this.L$0 = flowCollector0;
                                    this.label = 4;
                                    if(DelayKt.delay(StartedWhileSubscribed.this.replayExpiration, this) != a0) {
                                        goto label_30;
                                    }
                                }
                            }
                            else {
                            label_30:
                                this.L$0 = null;
                                this.label = 5;
                                if(flowCollector0.emit(SharingCommand.STOP_AND_RESET_REPLAY_CACHE, this) != a0) {
                                    return H.a;
                                }
                            }
                        }
                        break;
                    }
                    case 2: {
                        flowCollector0 = (FlowCollector)this.L$0;
                        n.D(object0);
                        goto label_23;
                    }
                    case 3: {
                        flowCollector0 = (FlowCollector)this.L$0;
                        n.D(object0);
                        goto label_27;
                    }
                    case 4: {
                        flowCollector0 = (FlowCollector)this.L$0;
                        n.D(object0);
                        goto label_30;
                    }
                    case 1: 
                    case 5: {
                        n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                return a0;
            }
        }), new we.n() {
            Object L$0;
            int label;

            {
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new kotlinx.coroutines.flow.StartedWhileSubscribed.command.2(continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((SharingCommand)object0), ((Continuation)object1));
            }

            public final Object invoke(SharingCommand sharingCommand0, Continuation continuation0) {
                return ((kotlinx.coroutines.flow.StartedWhileSubscribed.command.2)this.create(sharingCommand0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                n.D(object0);
                return ((SharingCommand)this.L$0) == SharingCommand.START ? false : true;
            }
        }));
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        return object0 instanceof StartedWhileSubscribed && this.stopTimeout == ((StartedWhileSubscribed)object0).stopTimeout && this.replayExpiration == ((StartedWhileSubscribed)object0).replayExpiration;
    }

    @Override
    @IgnoreJRERequirement
    public int hashCode() {
        return Long.hashCode(this.replayExpiration) + Long.hashCode(this.stopTimeout) * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        ke.b b0 = new ke.b(2);
        if(Long.compare(this.stopTimeout, 0L) > 0) {
            b0.add("stopTimeout=" + this.stopTimeout + "ms");
        }
        if(this.replayExpiration < 0x7FFFFFFFFFFFFFFFL) {
            b0.add("replayExpiration=" + this.replayExpiration + "ms");
        }
        ke.b b1 = k.h(b0);
        return androidx.appcompat.app.o.r(new StringBuilder("SharingStarted.WhileSubscribed("), p.q0(b1, null, null, null, null, 0x3F), ')');
    }
}

