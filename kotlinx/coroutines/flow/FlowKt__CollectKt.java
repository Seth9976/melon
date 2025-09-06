package kotlinx.coroutines.flow;

import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.internal.NopCollector;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u0018\u0010\u0002\u001A\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0086@¢\u0006\u0004\b\u0002\u0010\u0003\u001A%\u0010\b\u001A\u00020\u0007\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\b\u0010\t\u001AD\u0010\u000E\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00002\"\u0010\r\u001A\u001E\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000B\u0012\u0006\u0012\u0004\u0018\u00010\f0\nH\u0086@¢\u0006\u0004\b\u000E\u0010\u000F\u001A.\u0010\u0012\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00102\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0086@¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/flow/Flow;", "Lie/H;", "collect", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/Job;", "launchIn", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;)Lkotlinx/coroutines/Job;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "action", "collectLatest", "(Lkotlinx/coroutines/flow/Flow;Lwe/n;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/FlowCollector;", "flow", "emitAll", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {2, 1, 0}, xi = 0x30, xs = "kotlinx/coroutines/flow/FlowKt")
abstract class FlowKt__CollectKt {
    @Nullable
    public static final Object collect(@NotNull Flow flow0, @NotNull Continuation continuation0) {
        Object object0 = flow0.collect(NopCollector.INSTANCE, continuation0);
        return object0 == a.a ? object0 : H.a;
    }

    @Nullable
    public static final Object collectLatest(@NotNull Flow flow0, @NotNull n n0, @NotNull Continuation continuation0) {
        Object object0 = FlowKt.collect(FlowKt__ContextKt.buffer$default(FlowKt.mapLatest(flow0, n0), 0, null, 2, null), continuation0);
        return object0 == a.a ? object0 : H.a;
    }

    @Nullable
    public static final Object emitAll(@NotNull FlowCollector flowCollector0, @NotNull Flow flow0, @NotNull Continuation continuation0) {
        FlowKt.ensureActive(flowCollector0);
        Object object0 = flow0.collect(flowCollector0, continuation0);
        return object0 == a.a ? object0 : H.a;
    }

    @NotNull
    public static final Job launchIn(@NotNull Flow flow0, @NotNull CoroutineScope coroutineScope0) {
        return BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new n(flow0, null) {
            final Flow $this_launchIn;
            int label;

            {
                this.$this_launchIn = flow0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new kotlinx.coroutines.flow.FlowKt__CollectKt.launchIn.1(this.$this_launchIn, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((kotlinx.coroutines.flow.FlowKt__CollectKt.launchIn.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        this.label = 1;
                        return FlowKt.collect(this.$this_launchIn, this) == a0 ? a0 : H.a;
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
        }, 3, null);
    }
}

