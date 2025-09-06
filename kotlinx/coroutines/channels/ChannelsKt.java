package kotlinx.coroutines.channels;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"kotlinx/coroutines/channels/ChannelsKt__ChannelsKt", "kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt"}, d2 = {}, k = 4, mv = {2, 1, 0}, xi = 0x30)
public abstract class ChannelsKt {
    public static final void cancelConsumed(@NotNull ReceiveChannel receiveChannel0, @Nullable Throwable throwable0) {
        ChannelsKt__Channels_commonKt.cancelConsumed(receiveChannel0, throwable0);
    }

    @NotNull
    public static final Object trySendBlocking(@NotNull SendChannel sendChannel0, Object object0) {
        return ChannelsKt__ChannelsKt.trySendBlocking(sendChannel0, object0);
    }
}

