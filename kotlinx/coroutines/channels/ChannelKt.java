package kotlinx.coroutines.channels;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001AE\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00012\b\b\u0002\u0010\u0004\u001A\u00020\u00032\u0016\b\u0002\u0010\u0007\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"E", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/Function1;", "Lie/H;", "onUndeliveredElement", "Lkotlinx/coroutines/channels/Channel;", "Channel", "(ILkotlinx/coroutines/channels/BufferOverflow;Lwe/k;)Lkotlinx/coroutines/channels/Channel;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class ChannelKt {
    @NotNull
    public static final Channel Channel(int v, @NotNull BufferOverflow bufferOverflow0, @Nullable k k0) {
        if(v != -2) {
            switch(v) {
                case -1: {
                    if(bufferOverflow0 != BufferOverflow.SUSPEND) {
                        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
                    }
                    return new ConflatedBufferedChannel(1, BufferOverflow.DROP_OLDEST, k0);
                }
                case 0: {
                    return bufferOverflow0 == BufferOverflow.SUSPEND ? new BufferedChannel(0, k0) : new ConflatedBufferedChannel(1, bufferOverflow0, k0);
                }
                default: {
                    if(v != 0x7FFFFFFF) {
                        return bufferOverflow0 == BufferOverflow.SUSPEND ? new BufferedChannel(v, k0) : new ConflatedBufferedChannel(v, bufferOverflow0, k0);
                    }
                    return new BufferedChannel(0x7FFFFFFF, k0);
                }
            }
        }
        return bufferOverflow0 == BufferOverflow.SUSPEND ? new BufferedChannel(0x40, k0) : new ConflatedBufferedChannel(1, bufferOverflow0, k0);
    }

    public static Channel Channel$default(int v, BufferOverflow bufferOverflow0, k k0, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = 0;
        }
        if((v1 & 2) != 0) {
            bufferOverflow0 = BufferOverflow.SUSPEND;
        }
        if((v1 & 4) != 0) {
            k0 = null;
        }
        return ChannelKt.Channel(v, bufferOverflow0, k0);
    }
}

