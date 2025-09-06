package kotlinx.coroutines.flow;

import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import me.i;
import me.j;
import ne.a;
import org.jetbrains.annotations.NotNull;
import we.n;

@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A=\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\t\u0010\n\u001A-\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00000\u000B\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\r\u001AM\u0010\u0018\u001A\u00020\u0015\"\u0004\b\u0000\u0010\u0000*\u00020\u00022\u0006\u0010\u0010\u001A\u00020\u000F2\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u00122\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0014\u001A\u00028\u0000H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001A;\u0010\u001A\u001A\b\u0012\u0004\u0012\u00028\u00000\u0019\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0014\u001A\u00028\u0000¢\u0006\u0004\b\u001A\u0010\u001B\u001A#\u0010\u001C\u001A\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0012¢\u0006\u0004\b\u001C\u0010\u001D\u001A#\u0010\u001F\u001A\b\u0012\u0004\u0012\u00028\u00000\u0019\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001E¢\u0006\u0004\b\u001F\u0010 ¨\u0006!"}, d2 = {"T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/flow/SharingStarted;", "started", "", "replay", "Lkotlinx/coroutines/flow/SharedFlow;", "shareIn", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/flow/SharingStarted;I)Lkotlinx/coroutines/flow/SharedFlow;", "Lkotlinx/coroutines/flow/SharingConfig;", "configureSharing$FlowKt__ShareKt", "(Lkotlinx/coroutines/flow/Flow;I)Lkotlinx/coroutines/flow/SharingConfig;", "configureSharing", "Lme/i;", "context", "upstream", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "shared", "initialValue", "Lkotlinx/coroutines/Job;", "launchSharing$FlowKt__ShareKt", "(Lkotlinx/coroutines/CoroutineScope;Lme/i;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/MutableSharedFlow;Lkotlinx/coroutines/flow/SharingStarted;Ljava/lang/Object;)Lkotlinx/coroutines/Job;", "launchSharing", "Lkotlinx/coroutines/flow/StateFlow;", "stateIn", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/flow/SharingStarted;Ljava/lang/Object;)Lkotlinx/coroutines/flow/StateFlow;", "asSharedFlow", "(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "asStateFlow", "(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;", "kotlinx-coroutines-core"}, k = 5, mv = {2, 1, 0}, xi = 0x30, xs = "kotlinx/coroutines/flow/FlowKt")
abstract class FlowKt__ShareKt {
    @NotNull
    public static final SharedFlow asSharedFlow(@NotNull MutableSharedFlow mutableSharedFlow0) {
        return new ReadonlySharedFlow(mutableSharedFlow0, null);
    }

    @NotNull
    public static final StateFlow asStateFlow(@NotNull MutableStateFlow mutableStateFlow0) {
        return new ReadonlyStateFlow(mutableStateFlow0, null);
    }

    private static final SharingConfig configureSharing$FlowKt__ShareKt(Flow flow0, int v) {
        int v1 = (v < 0x40 ? 0x40 : v) - v;
        if(flow0 instanceof ChannelFlow) {
            Flow flow1 = ((ChannelFlow)flow0).dropChannelOperators();
            if(flow1 != null) {
                int v2 = ((ChannelFlow)flow0).capacity;
                if(v2 != -3 && (v2 != -2 && v2 != 0)) {
                    return new SharingConfig(flow1, v2, ((ChannelFlow)flow0).onBufferOverflow, ((ChannelFlow)flow0).context);
                }
                if(((ChannelFlow)flow0).onBufferOverflow == BufferOverflow.SUSPEND) {
                    return v2 == 0 ? new SharingConfig(flow1, 0, ((ChannelFlow)flow0).onBufferOverflow, ((ChannelFlow)flow0).context) : new SharingConfig(flow1, v1, ((ChannelFlow)flow0).onBufferOverflow, ((ChannelFlow)flow0).context);
                }
                return v == 0 ? new SharingConfig(flow1, 1, ((ChannelFlow)flow0).onBufferOverflow, ((ChannelFlow)flow0).context) : new SharingConfig(flow1, 0, ((ChannelFlow)flow0).onBufferOverflow, ((ChannelFlow)flow0).context);
            }
        }
        return new SharingConfig(flow0, v1, BufferOverflow.SUSPEND, j.a);
    }

    // 去混淆评级： 低(20)
    private static final Job launchSharing$FlowKt__ShareKt(CoroutineScope coroutineScope0, i i0, Flow flow0, MutableSharedFlow mutableSharedFlow0, SharingStarted sharingStarted0, Object object0) {
        return q.b(sharingStarted0, SharingStarted.Companion.getEagerly()) ? BuildersKt.launch(coroutineScope0, i0, CoroutineStart.DEFAULT, new n(sharingStarted0, flow0, mutableSharedFlow0, object0, null) {
            final Object $initialValue;
            final MutableSharedFlow $shared;
            final SharingStarted $started;
            final Flow $upstream;
            int label;

            {
                this.$started = sharingStarted0;
                this.$upstream = flow0;
                this.$shared = mutableSharedFlow0;
                this.$initialValue = object0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new kotlinx.coroutines.flow.FlowKt__ShareKt.launchSharing.1(this.$started, this.$upstream, this.$shared, this.$initialValue, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((kotlinx.coroutines.flow.FlowKt__ShareKt.launchSharing.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        Companion sharingStarted$Companion0 = SharingStarted.Companion;
                        if(this.$started == sharingStarted$Companion0.getEagerly()) {
                            this.label = 1;
                            if(this.$upstream.collect(this.$shared, this) == a0) {
                                return a0;
                            }
                        }
                        else if(this.$started == sharingStarted$Companion0.getLazily()) {
                            StateFlow stateFlow0 = this.$shared.getSubscriptionCount();
                            kotlinx.coroutines.flow.FlowKt__ShareKt.launchSharing.1.1 flowKt__ShareKt$launchSharing$1$10 = new n() {
                                int I$0;
                                int label;

                                {
                                    super(2, continuation0);
                                }

                                @Override  // oe.a
                                public final Continuation create(Object object0, Continuation continuation0) {
                                    Continuation continuation1 = new kotlinx.coroutines.flow.FlowKt__ShareKt.launchSharing.1.1(continuation0);
                                    continuation1.I$0 = ((Number)object0).intValue();
                                    return continuation1;
                                }

                                public final Object invoke(int v, Continuation continuation0) {
                                    return ((kotlinx.coroutines.flow.FlowKt__ShareKt.launchSharing.1.1)this.create(v, continuation0)).invokeSuspend(H.a);
                                }

                                @Override  // we.n
                                public Object invoke(Object object0, Object object1) {
                                    return this.invoke(((Number)object0).intValue(), ((Continuation)object1));
                                }

                                @Override  // oe.a
                                public final Object invokeSuspend(Object object0) {
                                    if(this.label != 0) {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                    d5.n.D(object0);
                                    return this.I$0 <= 0 ? false : true;
                                }
                            };
                            this.label = 2;
                            if(FlowKt.first(stateFlow0, flowKt__ShareKt$launchSharing$1$10, this) == a0) {
                                return a0;
                            }
                        label_18:
                            this.label = 3;
                            if(this.$upstream.collect(this.$shared, this) == a0) {
                                return a0;
                            }
                        }
                        else {
                            StateFlow stateFlow1 = this.$shared.getSubscriptionCount();
                            Flow flow0 = FlowKt.distinctUntilChanged(this.$started.command(stateFlow1));
                            kotlinx.coroutines.flow.FlowKt__ShareKt.launchSharing.1.2 flowKt__ShareKt$launchSharing$1$20 = new n(this.$shared, this.$initialValue, null) {
                                @Metadata(k = 3, mv = {2, 1, 0}, xi = 0x30)
                                public abstract class WhenMappings {
                                    public static final int[] $EnumSwitchMapping$0;

                                    static {
                                        int[] arr_v = new int[SharingCommand.values().length];
                                        try {
                                            arr_v[SharingCommand.START.ordinal()] = 1;
                                        }
                                        catch(NoSuchFieldError unused_ex) {
                                        }
                                        try {
                                            arr_v[SharingCommand.STOP.ordinal()] = 2;
                                        }
                                        catch(NoSuchFieldError unused_ex) {
                                        }
                                        try {
                                            arr_v[SharingCommand.STOP_AND_RESET_REPLAY_CACHE.ordinal()] = 3;
                                        }
                                        catch(NoSuchFieldError unused_ex) {
                                        }
                                        WhenMappings.$EnumSwitchMapping$0 = arr_v;
                                    }
                                }

                                final Object $initialValue;
                                final MutableSharedFlow $shared;
                                final Flow $upstream;
                                Object L$0;
                                int label;

                                {
                                    this.$upstream = flow0;
                                    this.$shared = mutableSharedFlow0;
                                    this.$initialValue = object0;
                                    super(2, continuation0);
                                }

                                @Override  // oe.a
                                public final Continuation create(Object object0, Continuation continuation0) {
                                    Continuation continuation1 = new kotlinx.coroutines.flow.FlowKt__ShareKt.launchSharing.1.2(this.$upstream, this.$shared, this.$initialValue, continuation0);
                                    continuation1.L$0 = object0;
                                    return continuation1;
                                }

                                @Override  // we.n
                                public Object invoke(Object object0, Object object1) {
                                    return this.invoke(((SharingCommand)object0), ((Continuation)object1));
                                }

                                public final Object invoke(SharingCommand sharingCommand0, Continuation continuation0) {
                                    return ((kotlinx.coroutines.flow.FlowKt__ShareKt.launchSharing.1.2)this.create(sharingCommand0, continuation0)).invokeSuspend(H.a);
                                }

                                @Override  // oe.a
                                public final Object invokeSuspend(Object object0) {
                                    a a0 = a.a;
                                    switch(this.label) {
                                        case 0: {
                                            d5.n.D(object0);
                                            switch(WhenMappings.$EnumSwitchMapping$0[((SharingCommand)this.L$0).ordinal()]) {
                                                case 1: {
                                                    this.label = 1;
                                                    if(this.$upstream.collect(this.$shared, this) == a0) {
                                                        return a0;
                                                    }
                                                    break;
                                                }
                                                case 2: {
                                                    break;
                                                }
                                                case 3: {
                                                    Object object1 = this.$initialValue;
                                                    if(object1 == SharedFlowKt.NO_VALUE) {
                                                        this.$shared.resetReplayCache();
                                                        return H.a;
                                                    }
                                                    this.$shared.tryEmit(object1);
                                                    return H.a;
                                                }
                                                default: {
                                                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                                }
                                            }
                                            return H.a;
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
                            this.label = 4;
                            if(FlowKt.collectLatest(flow0, flowKt__ShareKt$launchSharing$1$20, this) == a0) {
                                return a0;
                            }
                        }
                        break;
                    }
                    case 2: {
                        d5.n.D(object0);
                        goto label_18;
                    }
                    case 1: 
                    case 3: 
                    case 4: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                return H.a;
            }
        }) : BuildersKt.launch(coroutineScope0, i0, CoroutineStart.UNDISPATCHED, new n(sharingStarted0, flow0, mutableSharedFlow0, object0, null) {
            final Object $initialValue;
            final MutableSharedFlow $shared;
            final SharingStarted $started;
            final Flow $upstream;
            int label;

            {
                this.$started = sharingStarted0;
                this.$upstream = flow0;
                this.$shared = mutableSharedFlow0;
                this.$initialValue = object0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new kotlinx.coroutines.flow.FlowKt__ShareKt.launchSharing.1(this.$started, this.$upstream, this.$shared, this.$initialValue, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((kotlinx.coroutines.flow.FlowKt__ShareKt.launchSharing.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        Companion sharingStarted$Companion0 = SharingStarted.Companion;
                        if(this.$started == sharingStarted$Companion0.getEagerly()) {
                            this.label = 1;
                            if(this.$upstream.collect(this.$shared, this) == a0) {
                                return a0;
                            }
                        }
                        else if(this.$started == sharingStarted$Companion0.getLazily()) {
                            StateFlow stateFlow0 = this.$shared.getSubscriptionCount();
                            kotlinx.coroutines.flow.FlowKt__ShareKt.launchSharing.1.1 flowKt__ShareKt$launchSharing$1$10 = new n() {
                                int I$0;
                                int label;

                                {
                                    super(2, continuation0);
                                }

                                @Override  // oe.a
                                public final Continuation create(Object object0, Continuation continuation0) {
                                    Continuation continuation1 = new kotlinx.coroutines.flow.FlowKt__ShareKt.launchSharing.1.1(continuation0);
                                    continuation1.I$0 = ((Number)object0).intValue();
                                    return continuation1;
                                }

                                public final Object invoke(int v, Continuation continuation0) {
                                    return ((kotlinx.coroutines.flow.FlowKt__ShareKt.launchSharing.1.1)this.create(v, continuation0)).invokeSuspend(H.a);
                                }

                                @Override  // we.n
                                public Object invoke(Object object0, Object object1) {
                                    return this.invoke(((Number)object0).intValue(), ((Continuation)object1));
                                }

                                @Override  // oe.a
                                public final Object invokeSuspend(Object object0) {
                                    if(this.label != 0) {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                    d5.n.D(object0);
                                    return this.I$0 <= 0 ? false : true;
                                }
                            };
                            this.label = 2;
                            if(FlowKt.first(stateFlow0, flowKt__ShareKt$launchSharing$1$10, this) == a0) {
                                return a0;
                            }
                        label_18:
                            this.label = 3;
                            if(this.$upstream.collect(this.$shared, this) == a0) {
                                return a0;
                            }
                        }
                        else {
                            StateFlow stateFlow1 = this.$shared.getSubscriptionCount();
                            Flow flow0 = FlowKt.distinctUntilChanged(this.$started.command(stateFlow1));
                            kotlinx.coroutines.flow.FlowKt__ShareKt.launchSharing.1.2 flowKt__ShareKt$launchSharing$1$20 = new n(this.$shared, this.$initialValue, null) {
                                @Metadata(k = 3, mv = {2, 1, 0}, xi = 0x30)
                                public abstract class WhenMappings {
                                    public static final int[] $EnumSwitchMapping$0;

                                    static {
                                        int[] arr_v = new int[SharingCommand.values().length];
                                        try {
                                            arr_v[SharingCommand.START.ordinal()] = 1;
                                        }
                                        catch(NoSuchFieldError unused_ex) {
                                        }
                                        try {
                                            arr_v[SharingCommand.STOP.ordinal()] = 2;
                                        }
                                        catch(NoSuchFieldError unused_ex) {
                                        }
                                        try {
                                            arr_v[SharingCommand.STOP_AND_RESET_REPLAY_CACHE.ordinal()] = 3;
                                        }
                                        catch(NoSuchFieldError unused_ex) {
                                        }
                                        WhenMappings.$EnumSwitchMapping$0 = arr_v;
                                    }
                                }

                                final Object $initialValue;
                                final MutableSharedFlow $shared;
                                final Flow $upstream;
                                Object L$0;
                                int label;

                                {
                                    this.$upstream = flow0;
                                    this.$shared = mutableSharedFlow0;
                                    this.$initialValue = object0;
                                    super(2, continuation0);
                                }

                                @Override  // oe.a
                                public final Continuation create(Object object0, Continuation continuation0) {
                                    Continuation continuation1 = new kotlinx.coroutines.flow.FlowKt__ShareKt.launchSharing.1.2(this.$upstream, this.$shared, this.$initialValue, continuation0);
                                    continuation1.L$0 = object0;
                                    return continuation1;
                                }

                                @Override  // we.n
                                public Object invoke(Object object0, Object object1) {
                                    return this.invoke(((SharingCommand)object0), ((Continuation)object1));
                                }

                                public final Object invoke(SharingCommand sharingCommand0, Continuation continuation0) {
                                    return ((kotlinx.coroutines.flow.FlowKt__ShareKt.launchSharing.1.2)this.create(sharingCommand0, continuation0)).invokeSuspend(H.a);
                                }

                                @Override  // oe.a
                                public final Object invokeSuspend(Object object0) {
                                    a a0 = a.a;
                                    switch(this.label) {
                                        case 0: {
                                            d5.n.D(object0);
                                            switch(WhenMappings.$EnumSwitchMapping$0[((SharingCommand)this.L$0).ordinal()]) {
                                                case 1: {
                                                    this.label = 1;
                                                    if(this.$upstream.collect(this.$shared, this) == a0) {
                                                        return a0;
                                                    }
                                                    break;
                                                }
                                                case 2: {
                                                    break;
                                                }
                                                case 3: {
                                                    Object object1 = this.$initialValue;
                                                    if(object1 == SharedFlowKt.NO_VALUE) {
                                                        this.$shared.resetReplayCache();
                                                        return H.a;
                                                    }
                                                    this.$shared.tryEmit(object1);
                                                    return H.a;
                                                }
                                                default: {
                                                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                                }
                                            }
                                            return H.a;
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
                            this.label = 4;
                            if(FlowKt.collectLatest(flow0, flowKt__ShareKt$launchSharing$1$20, this) == a0) {
                                return a0;
                            }
                        }
                        break;
                    }
                    case 2: {
                        d5.n.D(object0);
                        goto label_18;
                    }
                    case 1: 
                    case 3: 
                    case 4: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                return H.a;
            }
        });
    }

    @NotNull
    public static final SharedFlow shareIn(@NotNull Flow flow0, @NotNull CoroutineScope coroutineScope0, @NotNull SharingStarted sharingStarted0, int v) {
        SharingConfig sharingConfig0 = FlowKt__ShareKt.configureSharing$FlowKt__ShareKt(flow0, v);
        MutableSharedFlow mutableSharedFlow0 = SharedFlowKt.MutableSharedFlow(v, sharingConfig0.extraBufferCapacity, sharingConfig0.onBufferOverflow);
        return new ReadonlySharedFlow(mutableSharedFlow0, FlowKt__ShareKt.launchSharing$FlowKt__ShareKt(coroutineScope0, sharingConfig0.context, sharingConfig0.upstream, mutableSharedFlow0, sharingStarted0, SharedFlowKt.NO_VALUE));
    }

    @NotNull
    public static final StateFlow stateIn(@NotNull Flow flow0, @NotNull CoroutineScope coroutineScope0, @NotNull SharingStarted sharingStarted0, Object object0) {
        SharingConfig sharingConfig0 = FlowKt__ShareKt.configureSharing$FlowKt__ShareKt(flow0, 1);
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(object0);
        return new ReadonlyStateFlow(mutableStateFlow0, FlowKt__ShareKt.launchSharing$FlowKt__ShareKt(coroutineScope0, sharingConfig0.context, sharingConfig0.upstream, mutableStateFlow0, sharingStarted0, object0));
    }
}

