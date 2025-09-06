package kotlinx.coroutines.channels;

import ie.H;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import me.i;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001D\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u001F\u0010\u0012\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001A\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/channels/ProducerCoroutine;", "E", "Lkotlinx/coroutines/channels/ChannelCoroutine;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lme/i;", "parentContext", "Lkotlinx/coroutines/channels/Channel;", "channel", "<init>", "(Lme/i;Lkotlinx/coroutines/channels/Channel;)V", "Lie/H;", "value", "onCompleted", "(Lie/H;)V", "", "cause", "", "handled", "onCancelled", "(Ljava/lang/Throwable;Z)V", "isActive", "()Z", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class ProducerCoroutine extends ChannelCoroutine implements ProducerScope {
    public ProducerCoroutine(@NotNull i i0, @NotNull Channel channel0) {
        super(i0, channel0, true, true);
    }

    @Override  // kotlinx.coroutines.channels.ProducerScope
    public SendChannel getChannel() {
        return this.getChannel();
    }

    @Override  // kotlinx.coroutines.AbstractCoroutine
    public boolean isActive() {
        return super.isActive();
    }

    @Override  // kotlinx.coroutines.AbstractCoroutine
    public void onCancelled(@NotNull Throwable throwable0, boolean z) {
        if(!this.get_channel().close(throwable0) && !z) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this.getContext(), throwable0);
        }
    }

    public void onCompleted(@NotNull H h0) {
        DefaultImpls.close$default(this.get_channel(), null, 1, null);
    }

    @Override  // kotlinx.coroutines.AbstractCoroutine
    public void onCompleted(Object object0) {
        this.onCompleted(((H)object0));
    }
}

