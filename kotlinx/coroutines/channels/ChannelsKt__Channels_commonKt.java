package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.ExceptionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\u001A!\u0010\u0004\u001A\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\b\u0010\u0002\u001A\u0004\u0018\u00010\u0001H\u0001¢\u0006\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001A\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/channels/ReceiveChannel;", "", "cause", "Lie/H;", "cancelConsumed", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Throwable;)V", "", "DEFAULT_CLOSE_MESSAGE", "Ljava/lang/String;", "kotlinx-coroutines-core"}, k = 5, mv = {2, 1, 0}, xi = 0x30, xs = "kotlinx/coroutines/channels/ChannelsKt")
abstract class ChannelsKt__Channels_commonKt {
    public static final void cancelConsumed(@NotNull ReceiveChannel receiveChannel0, @Nullable Throwable throwable0) {
        CancellationException cancellationException0 = null;
        if(throwable0 != null) {
            if(throwable0 instanceof CancellationException) {
                cancellationException0 = (CancellationException)throwable0;
            }
            if(cancellationException0 == null) {
                cancellationException0 = ExceptionsKt.CancellationException("Channel was consumed, consumer had failed", throwable0);
            }
        }
        receiveChannel0.cancel(cancellationException0);
    }
}

