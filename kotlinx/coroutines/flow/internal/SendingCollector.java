package kotlinx.coroutines.flow.internal;

import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.FlowCollector;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00028\u0000H\u0096@¢\u0006\u0004\b\t\u0010\nR\u001A\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000B¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/flow/internal/SendingCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/channels/SendChannel;", "channel", "<init>", "(Lkotlinx/coroutines/channels/SendChannel;)V", "value", "Lie/H;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/SendChannel;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class SendingCollector implements FlowCollector {
    @NotNull
    private final SendChannel channel;

    public SendingCollector(@NotNull SendChannel sendChannel0) {
        this.channel = sendChannel0;
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(Object object0, @NotNull Continuation continuation0) {
        Object object1 = this.channel.send(object0, continuation0);
        return object1 == a.a ? object1 : H.a;
    }
}

