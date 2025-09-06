package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.selects.SelectClause1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u0010\u0010\u0003\u001A\u00028\u0000H¦@¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005H¦@¢\u0006\u0004\b\u0006\u0010\u0004J\u0015\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u000BH¦\u0002¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001A\u00020\u00112\u0010\b\u0002\u0010\u0010\u001A\n\u0018\u00010\u000Ej\u0004\u0018\u0001`\u000FH&¢\u0006\u0004\b\u0012\u0010\u0013R\u001A\u0010\u0017\u001A\b\u0012\u0004\u0012\u00028\u00000\u00148&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016R \u0010\u0019\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u00148&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0016¨\u0006\u001A"}, d2 = {"Lkotlinx/coroutines/channels/ReceiveChannel;", "E", "", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "receiveCatching-JP2dKIU", "receiveCatching", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "tryReceive", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "()Lkotlinx/coroutines/channels/ChannelIterator;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "Lie/H;", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceive", "getOnReceiveCatching", "onReceiveCatching", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public interface ReceiveChannel {
    void cancel(@Nullable CancellationException arg1);

    @NotNull
    SelectClause1 getOnReceive();

    @NotNull
    SelectClause1 getOnReceiveCatching();

    @NotNull
    ChannelIterator iterator();

    @Nullable
    Object receive(@NotNull Continuation arg1);

    @Nullable
    Object receiveCatching-JP2dKIU(@NotNull Continuation arg1);

    @NotNull
    Object tryReceive-PtdJZtk();
}

