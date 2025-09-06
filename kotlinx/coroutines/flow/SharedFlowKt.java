package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.internal.Symbol;
import me.i;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A7\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00012\b\b\u0002\u0010\u0003\u001A\u00020\u00012\b\b\u0002\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001A%\u0010\r\u001A\u0004\u0018\u00010\n*\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\f\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\r\u0010\u000E\u001A-\u0010\u0011\u001A\u00020\u0010*\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\f\u001A\u00020\u000B2\b\u0010\u000F\u001A\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001A=\u0010\u0018\u001A\b\u0012\u0004\u0012\u00028\u00000\u0017\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0016\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0004H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\"\u0014\u0010\u001B\u001A\u00020\u001A8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u001B\u0010\u001C¨\u0006\u001D"}, d2 = {"T", "", "replay", "extraBufferCapacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "MutableSharedFlow", "(IILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "", "", "index", "getBufferAt", "([Ljava/lang/Object;J)Ljava/lang/Object;", "item", "Lie/H;", "setBufferAt", "([Ljava/lang/Object;JLjava/lang/Object;)V", "Lkotlinx/coroutines/flow/SharedFlow;", "Lme/i;", "context", "capacity", "Lkotlinx/coroutines/flow/Flow;", "fuseSharedFlow", "(Lkotlinx/coroutines/flow/SharedFlow;Lme/i;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/internal/Symbol;", "NO_VALUE", "Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class SharedFlowKt {
    @NotNull
    public static final Symbol NO_VALUE;

    static {
        SharedFlowKt.NO_VALUE = new Symbol("NO_VALUE");
    }

    @NotNull
    public static final MutableSharedFlow MutableSharedFlow(int v, int v1, @NotNull BufferOverflow bufferOverflow0) {
        if(v < 0) {
            throw new IllegalArgumentException(("replay cannot be negative, but was " + v).toString());
        }
        if(v1 < 0) {
            throw new IllegalArgumentException(("extraBufferCapacity cannot be negative, but was " + v1).toString());
        }
        if(v <= 0 && v1 <= 0 && bufferOverflow0 != BufferOverflow.SUSPEND) {
            throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + bufferOverflow0).toString());
        }
        return new SharedFlowImpl(v, (v1 + v >= 0 ? v1 + v : 0x7FFFFFFF), bufferOverflow0);
    }

    public static MutableSharedFlow MutableSharedFlow$default(int v, int v1, BufferOverflow bufferOverflow0, int v2, Object object0) {
        if((v2 & 1) != 0) {
            v = 0;
        }
        if((v2 & 2) != 0) {
            v1 = 0;
        }
        if((v2 & 4) != 0) {
            bufferOverflow0 = BufferOverflow.SUSPEND;
        }
        return SharedFlowKt.MutableSharedFlow(v, v1, bufferOverflow0);
    }

    @NotNull
    public static final Flow fuseSharedFlow(@NotNull SharedFlow sharedFlow0, @NotNull i i0, int v, @NotNull BufferOverflow bufferOverflow0) {
        return (v == -3 || v == 0) && bufferOverflow0 == BufferOverflow.SUSPEND ? sharedFlow0 : new ChannelFlowOperatorImpl(sharedFlow0, i0, v, bufferOverflow0);
    }

    private static final Object getBufferAt(Object[] arr_object, long v) {
        return arr_object[((int)v) & arr_object.length - 1];
    }

    private static final void setBufferAt(Object[] arr_object, long v, Object object0) {
        arr_object[((int)v) & arr_object.length - 1] = object0;
    }
}

