package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.selects.SelectClause1;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u0004B-\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\t\u001A\u00020\b\u0012\u0006\u0010\n\u001A\u00020\b\u00A2\u0006\u0004\b\u000B\u0010\fJ\u001D\u0010\u0010\u001A\u00020\u00032\u000E\u0010\u000F\u001A\n\u0018\u00010\rj\u0004\u0018\u0001`\u000E\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0016\u001A\u00020\u00032\u0006\u0010\u0015\u001A\u00028\u0000H\u0096A\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u001E\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00030\u00182\u0006\u0010\u0015\u001A\u00028\u0000H\u0096\u0001\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u001A\u0010\u001C\u001A\u00020\b2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0012H\u0096\u0001\u00A2\u0006\u0004\b\u001C\u0010\u001DJ&\u0010 \u001A\u00020\u00032\u0014\u0010\u001F\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u00030\u001EH\u0096\u0001\u00A2\u0006\u0004\b \u0010!J\u0010\u0010\"\u001A\u00028\u0000H\u0096A\u00A2\u0006\u0004\b\"\u0010#J\u0016\u0010%\u001A\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0096A\u00A2\u0006\u0004\b$\u0010#J\u0016\u0010(\u001A\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0096\u0001\u00A2\u0006\u0004\b&\u0010\'J\u0016\u0010*\u001A\b\u0012\u0004\u0012\u00028\u00000)H\u0096\u0003\u00A2\u0006\u0004\b*\u0010+R \u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u00048\u0004X\u0084\u0004\u00A2\u0006\f\n\u0004\b\u0007\u0010,\u001A\u0004\b-\u0010.R\u0017\u00100\u001A\b\u0012\u0004\u0012\u00028\u00000\u00048F\u00A2\u0006\u0006\u001A\u0004\b/\u0010.R\u0014\u00101\u001A\u00020\b8\u0016X\u0097\u0005\u00A2\u0006\u0006\u001A\u0004\b1\u00102R\u001A\u00106\u001A\b\u0012\u0004\u0012\u00028\u0000038\u0016X\u0096\u0005\u00A2\u0006\u0006\u001A\u0004\b4\u00105R \u00108\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0018038\u0016X\u0096\u0005\u00A2\u0006\u0006\u001A\u0004\b7\u00105\u00A8\u00069"}, d2 = {"Lkotlinx/coroutines/channels/ChannelCoroutine;", "E", "Lkotlinx/coroutines/AbstractCoroutine;", "Lie/H;", "Lkotlinx/coroutines/channels/Channel;", "Lme/i;", "parentContext", "_channel", "", "initParentJob", "active", "<init>", "(Lme/i;Lkotlinx/coroutines/channels/Channel;ZZ)V", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "", "cancelInternal", "(Ljava/lang/Throwable;)V", "element", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "close", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "handler", "invokeOnClose", "(Lwe/k;)V", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching-JP2dKIU", "receiveCatching", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "tryReceive", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "()Lkotlinx/coroutines/channels/ChannelIterator;", "Lkotlinx/coroutines/channels/Channel;", "get_channel", "()Lkotlinx/coroutines/channels/Channel;", "getChannel", "channel", "isClosedForSend", "()Z", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceive", "getOnReceiveCatching", "onReceiveCatching", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public abstract class ChannelCoroutine extends AbstractCoroutine implements Channel {
    @NotNull
    private final Channel _channel;

    public ChannelCoroutine(@NotNull i i0, @NotNull Channel channel0, boolean z, boolean z1) {
        super(i0, z, z1);
        this._channel = channel0;
    }

    @Override  // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job, kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(@Nullable CancellationException cancellationException0) {
        if(this.isCancelled()) {
            return;
        }
        if(cancellationException0 == null) {
            cancellationException0 = new JobCancellationException(JobSupport.access$cancellationExceptionMessage(this), null, this);
        }
        this.cancelInternal(cancellationException0);
    }

    @Override  // kotlinx.coroutines.JobSupport
    public void cancelInternal(@NotNull Throwable throwable0) {
        CancellationException cancellationException0 = JobSupport.toCancellationException$default(this, throwable0, null, 1, null);
        this._channel.cancel(cancellationException0);
        this.cancelCoroutine(cancellationException0);
    }

    @Override  // kotlinx.coroutines.channels.SendChannel
    public boolean close(@Nullable Throwable throwable0) {
        return this._channel.close(throwable0);
    }

    @NotNull
    public final Channel getChannel() {
        return this;
    }

    @Override  // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public SelectClause1 getOnReceive() {
        return this._channel.getOnReceive();
    }

    @Override  // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public SelectClause1 getOnReceiveCatching() {
        return this._channel.getOnReceiveCatching();
    }

    @NotNull
    public final Channel get_channel() {
        return this._channel;
    }

    @Override  // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(@NotNull k k0) {
        this._channel.invokeOnClose(k0);
    }

    @Override  // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this._channel.isClosedForSend();
    }

    @Override  // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public ChannelIterator iterator() {
        return this._channel.iterator();
    }

    @Override  // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    public Object receive(@NotNull Continuation continuation0) {
        return this._channel.receive(continuation0);
    }

    @Override  // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    public Object receiveCatching-JP2dKIU(@NotNull Continuation continuation0) {
        return this._channel.receiveCatching-JP2dKIU(continuation0);
    }

    @Override  // kotlinx.coroutines.channels.SendChannel
    @Nullable
    public Object send(Object object0, @NotNull Continuation continuation0) {
        return this._channel.send(object0, continuation0);
    }

    @Override  // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public Object tryReceive-PtdJZtk() {
        return this._channel.tryReceive-PtdJZtk();
    }

    @Override  // kotlinx.coroutines.channels.SendChannel
    @NotNull
    public Object trySend-JP2dKIU(Object object0) {
        return this._channel.trySend-JP2dKIU(object0);
    }
}

