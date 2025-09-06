package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveChannel;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.n;
import we.o;
import we.p;
import we.q;
import we.r;

@Metadata(d1 = {"kotlinx/coroutines/flow/FlowKt__BuildersKt", "kotlinx/coroutines/flow/FlowKt__ChannelsKt", "kotlinx/coroutines/flow/FlowKt__CollectKt", "kotlinx/coroutines/flow/FlowKt__ContextKt", "kotlinx/coroutines/flow/FlowKt__DelayKt", "kotlinx/coroutines/flow/FlowKt__DistinctKt", "kotlinx/coroutines/flow/FlowKt__EmittersKt", "kotlinx/coroutines/flow/FlowKt__ErrorsKt", "kotlinx/coroutines/flow/FlowKt__LimitKt", "kotlinx/coroutines/flow/FlowKt__MergeKt", "kotlinx/coroutines/flow/FlowKt__ReduceKt", "kotlinx/coroutines/flow/FlowKt__ShareKt", "kotlinx/coroutines/flow/FlowKt__TransformKt", "kotlinx/coroutines/flow/FlowKt__ZipKt"}, d2 = {}, k = 4, mv = {2, 1, 0}, xi = 0x30)
public abstract class FlowKt {
    @NotNull
    public static final SharedFlow asSharedFlow(@NotNull MutableSharedFlow mutableSharedFlow0) {
        return FlowKt__ShareKt.asSharedFlow(mutableSharedFlow0);
    }

    @NotNull
    public static final StateFlow asStateFlow(@NotNull MutableStateFlow mutableStateFlow0) {
        return FlowKt__ShareKt.asStateFlow(mutableStateFlow0);
    }

    @NotNull
    public static final Flow buffer(@NotNull Flow flow0, int v, @NotNull BufferOverflow bufferOverflow0) {
        return FlowKt__ContextKt.buffer(flow0, v, bufferOverflow0);
    }

    @NotNull
    public static final Flow callbackFlow(@NotNull n n0) {
        return FlowKt__BuildersKt.callbackFlow(n0);
    }

    @NotNull
    public static final Flow catch(@NotNull Flow flow0, @NotNull o o0) {
        return FlowKt__ErrorsKt.catch(flow0, o0);
    }

    @Nullable
    public static final Object catchImpl(@NotNull Flow flow0, @NotNull FlowCollector flowCollector0, @NotNull Continuation continuation0) {
        return FlowKt__ErrorsKt.catchImpl(flow0, flowCollector0, continuation0);
    }

    @NotNull
    public static final Flow channelFlow(@NotNull n n0) {
        return FlowKt__BuildersKt.channelFlow(n0);
    }

    @Nullable
    public static final Object collect(@NotNull Flow flow0, @NotNull Continuation continuation0) {
        return FlowKt__CollectKt.collect(flow0, continuation0);
    }

    @Nullable
    public static final Object collectLatest(@NotNull Flow flow0, @NotNull n n0, @NotNull Continuation continuation0) {
        return FlowKt__CollectKt.collectLatest(flow0, n0, continuation0);
    }

    @NotNull
    public static final Flow combine(@NotNull Flow flow0, @NotNull Flow flow1, @NotNull Flow flow2, @NotNull Flow flow3, @NotNull Flow flow4, @NotNull r r0) {
        return FlowKt__ZipKt.combine(flow0, flow1, flow2, flow3, flow4, r0);
    }

    @NotNull
    public static final Flow combine(@NotNull Flow flow0, @NotNull Flow flow1, @NotNull Flow flow2, @NotNull Flow flow3, @NotNull q q0) {
        return FlowKt__ZipKt.combine(flow0, flow1, flow2, flow3, q0);
    }

    @NotNull
    public static final Flow combine(@NotNull Flow flow0, @NotNull Flow flow1, @NotNull Flow flow2, @NotNull p p0) {
        return FlowKt__ZipKt.combine(flow0, flow1, flow2, p0);
    }

    @NotNull
    public static final Flow combine(@NotNull Flow flow0, @NotNull Flow flow1, @NotNull o o0) {
        return FlowKt__ZipKt.combine(flow0, flow1, o0);
    }

    @NotNull
    public static final Flow conflate(@NotNull Flow flow0) {
        return FlowKt__ContextKt.conflate(flow0);
    }

    @NotNull
    public static final Flow debounce(@NotNull Flow flow0, long v) {
        return FlowKt__DelayKt.debounce(flow0, v);
    }

    @NotNull
    public static final Flow debounce(@NotNull Flow flow0, @NotNull k k0) {
        return FlowKt__DelayKt.debounce(flow0, k0);
    }

    @NotNull
    public static final Flow distinctUntilChanged(@NotNull Flow flow0) {
        return FlowKt__DistinctKt.distinctUntilChanged(flow0);
    }

    @NotNull
    public static final Flow distinctUntilChangedBy(@NotNull Flow flow0, @NotNull k k0) {
        return FlowKt__DistinctKt.distinctUntilChangedBy(flow0, k0);
    }

    @NotNull
    public static final Flow drop(@NotNull Flow flow0, int v) {
        return FlowKt__LimitKt.drop(flow0, v);
    }

    @NotNull
    public static final Flow dropWhile(@NotNull Flow flow0, @NotNull n n0) {
        return FlowKt__LimitKt.dropWhile(flow0, n0);
    }

    @Nullable
    public static final Object emitAll(@NotNull FlowCollector flowCollector0, @NotNull ReceiveChannel receiveChannel0, @NotNull Continuation continuation0) {
        return FlowKt__ChannelsKt.emitAll(flowCollector0, receiveChannel0, continuation0);
    }

    @Nullable
    public static final Object emitAll(@NotNull FlowCollector flowCollector0, @NotNull Flow flow0, @NotNull Continuation continuation0) {
        return FlowKt__CollectKt.emitAll(flowCollector0, flow0, continuation0);
    }

    @NotNull
    public static final Flow emptyFlow() {
        return FlowKt__BuildersKt.emptyFlow();
    }

    public static final void ensureActive(@NotNull FlowCollector flowCollector0) {
        FlowKt__EmittersKt.ensureActive(flowCollector0);
    }

    @NotNull
    public static final Flow filterNotNull(@NotNull Flow flow0) {
        return FlowKt__TransformKt.filterNotNull(flow0);
    }

    @Nullable
    public static final Object first(@NotNull Flow flow0, @NotNull Continuation continuation0) {
        return FlowKt__ReduceKt.first(flow0, continuation0);
    }

    @Nullable
    public static final Object first(@NotNull Flow flow0, @NotNull n n0, @NotNull Continuation continuation0) {
        return FlowKt__ReduceKt.first(flow0, n0, continuation0);
    }

    @Nullable
    public static final Object firstOrNull(@NotNull Flow flow0, @NotNull Continuation continuation0) {
        return FlowKt__ReduceKt.firstOrNull(flow0, continuation0);
    }

    @NotNull
    public static final ReceiveChannel fixedPeriodTicker(@NotNull CoroutineScope coroutineScope0, long v) {
        return FlowKt__DelayKt.fixedPeriodTicker(coroutineScope0, v);
    }

    @NotNull
    public static final Flow flatMapConcat(@NotNull Flow flow0, @NotNull n n0) {
        return FlowKt__MergeKt.flatMapConcat(flow0, n0);
    }

    @NotNull
    public static final Flow flattenConcat(@NotNull Flow flow0) {
        return FlowKt__MergeKt.flattenConcat(flow0);
    }

    @NotNull
    public static final Flow flow(@NotNull n n0) {
        return FlowKt__BuildersKt.flow(n0);
    }

    @NotNull
    public static final Flow flowCombine(@NotNull Flow flow0, @NotNull Flow flow1, @NotNull o o0) {
        return FlowKt__ZipKt.flowCombine(flow0, flow1, o0);
    }

    @NotNull
    public static final Flow flowOf(Object object0) {
        return FlowKt__BuildersKt.flowOf(object0);
    }

    @NotNull
    public static final Flow flowOn(@NotNull Flow flow0, @NotNull i i0) {
        return FlowKt__ContextKt.flowOn(flow0, i0);
    }

    @NotNull
    public static final Job launchIn(@NotNull Flow flow0, @NotNull CoroutineScope coroutineScope0) {
        return FlowKt__CollectKt.launchIn(flow0, coroutineScope0);
    }

    @NotNull
    public static final Flow mapLatest(@NotNull Flow flow0, @NotNull n n0) {
        return FlowKt__MergeKt.mapLatest(flow0, n0);
    }

    @NotNull
    public static final Flow merge(@NotNull Iterable iterable0) {
        return FlowKt__MergeKt.merge(iterable0);
    }

    @NotNull
    public static final Flow merge(@NotNull Flow[] arr_flow) {
        return FlowKt__MergeKt.merge(arr_flow);
    }

    @NotNull
    public static final Flow onCompletion(@NotNull Flow flow0, @NotNull o o0) {
        return FlowKt__EmittersKt.onCompletion(flow0, o0);
    }

    @NotNull
    public static final Flow onEach(@NotNull Flow flow0, @NotNull n n0) {
        return FlowKt__TransformKt.onEach(flow0, n0);
    }

    @NotNull
    public static final Flow onStart(@NotNull Flow flow0, @NotNull n n0) {
        return FlowKt__EmittersKt.onStart(flow0, n0);
    }

    @NotNull
    public static final Flow receiveAsFlow(@NotNull ReceiveChannel receiveChannel0) {
        return FlowKt__ChannelsKt.receiveAsFlow(receiveChannel0);
    }

    @NotNull
    public static final Flow retryWhen(@NotNull Flow flow0, @NotNull p p0) {
        return FlowKt__ErrorsKt.retryWhen(flow0, p0);
    }

    @NotNull
    public static final Flow sample(@NotNull Flow flow0, long v) {
        return FlowKt__DelayKt.sample(flow0, v);
    }

    @NotNull
    public static final SharedFlow shareIn(@NotNull Flow flow0, @NotNull CoroutineScope coroutineScope0, @NotNull SharingStarted sharingStarted0, int v) {
        return FlowKt__ShareKt.shareIn(flow0, coroutineScope0, sharingStarted0, v);
    }

    @NotNull
    public static final StateFlow stateIn(@NotNull Flow flow0, @NotNull CoroutineScope coroutineScope0, @NotNull SharingStarted sharingStarted0, Object object0) {
        return FlowKt__ShareKt.stateIn(flow0, coroutineScope0, sharingStarted0, object0);
    }

    @NotNull
    public static final Flow takeWhile(@NotNull Flow flow0, @NotNull n n0) {
        return FlowKt__LimitKt.takeWhile(flow0, n0);
    }

    @NotNull
    public static final Flow transformLatest(@NotNull Flow flow0, @NotNull o o0) {
        return FlowKt__MergeKt.transformLatest(flow0, o0);
    }
}

