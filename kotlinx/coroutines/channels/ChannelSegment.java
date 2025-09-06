package kotlinx.coroutines.channels;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Segment;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\u0002B7\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u000E\u0010\u0005\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006\u0012\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b\n\u0010\u000BJ!\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\f\u001A\u00020\b2\b\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0002\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u001F\u0010\u0014\u001A\u00020\u000F2\u0006\u0010\f\u001A\u00020\b2\u0006\u0010\u0012\u001A\u00028\u0000H\u0000\u00A2\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0017\u001A\u00028\u00002\u0006\u0010\f\u001A\u00020\bH\u0000\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001A\u00028\u00002\u0006\u0010\f\u001A\u00020\bH\u0000\u00A2\u0006\u0004\b\u0018\u0010\u0016J\u0017\u0010\u001C\u001A\u00020\u000F2\u0006\u0010\f\u001A\u00020\bH\u0000\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0019\u0010\u001E\u001A\u0004\u0018\u00010\r2\u0006\u0010\f\u001A\u00020\bH\u0000\u00A2\u0006\u0004\b\u001D\u0010\u0016J!\u0010 \u001A\u00020\u000F2\u0006\u0010\f\u001A\u00020\b2\b\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0000\u00A2\u0006\u0004\b\u001F\u0010\u0011J+\u0010&\u001A\u00020#2\u0006\u0010\f\u001A\u00020\b2\b\u0010!\u001A\u0004\u0018\u00010\r2\b\u0010\"\u001A\u0004\u0018\u00010\rH\u0000\u00A2\u0006\u0004\b$\u0010%J#\u0010*\u001A\u0004\u0018\u00010\r2\u0006\u0010\f\u001A\u00020\b2\b\u0010\'\u001A\u0004\u0018\u00010\rH\u0000\u00A2\u0006\u0004\b(\u0010)J)\u0010/\u001A\u00020\u000F2\u0006\u0010\f\u001A\u00020\b2\b\u0010,\u001A\u0004\u0018\u00010+2\u0006\u0010.\u001A\u00020-H\u0016\u00A2\u0006\u0004\b/\u00100J\u001D\u00102\u001A\u00020\u000F2\u0006\u0010\f\u001A\u00020\b2\u0006\u00101\u001A\u00020#\u00A2\u0006\u0004\b2\u00103R\u001C\u00104\u001A\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00068\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b4\u00105R\u0017\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u00068F\u00A2\u0006\u0006\u001A\u0004\b6\u00107R\u0014\u0010:\u001A\u00020\b8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b8\u00109R\u0013\u0010<\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\r0;8\u0002X\u0082\u0004\u00A8\u0006="}, d2 = {"Lkotlinx/coroutines/channels/ChannelSegment;", "E", "Lkotlinx/coroutines/internal/Segment;", "", "id", "prev", "Lkotlinx/coroutines/channels/BufferedChannel;", "channel", "", "pointers", "<init>", "(JLkotlinx/coroutines/channels/ChannelSegment;Lkotlinx/coroutines/channels/BufferedChannel;I)V", "index", "", "value", "Lie/H;", "setElementLazy", "(ILjava/lang/Object;)V", "element", "storeElement$kotlinx_coroutines_core", "storeElement", "getElement$kotlinx_coroutines_core", "(I)Ljava/lang/Object;", "getElement", "retrieveElement$kotlinx_coroutines_core", "retrieveElement", "cleanElement$kotlinx_coroutines_core", "(I)V", "cleanElement", "getState$kotlinx_coroutines_core", "getState", "setState$kotlinx_coroutines_core", "setState", "from", "to", "", "casState$kotlinx_coroutines_core", "(ILjava/lang/Object;Ljava/lang/Object;)Z", "casState", "update", "getAndSetState$kotlinx_coroutines_core", "(ILjava/lang/Object;)Ljava/lang/Object;", "getAndSetState", "", "cause", "Lme/i;", "context", "onCancellation", "(ILjava/lang/Throwable;Lme/i;)V", "receiver", "onCancelledRequest", "(IZ)V", "_channel", "Lkotlinx/coroutines/channels/BufferedChannel;", "getChannel", "()Lkotlinx/coroutines/channels/BufferedChannel;", "getNumberOfSlots", "()I", "numberOfSlots", "Lkotlinx/atomicfu/AtomicArray;", "data", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class ChannelSegment extends Segment {
    @Nullable
    private final BufferedChannel _channel;
    private final AtomicReferenceArray data;

    public ChannelSegment(long v, @Nullable ChannelSegment channelSegment0, @Nullable BufferedChannel bufferedChannel0, int v1) {
        super(v, channelSegment0, v1);
        this._channel = bufferedChannel0;
        this.data = new AtomicReferenceArray(BufferedChannelKt.SEGMENT_SIZE * 2);
    }

    public final boolean casState$kotlinx_coroutines_core(int v, @Nullable Object object0, @Nullable Object object1) {
        AtomicReferenceArray atomicReferenceArray0 = this.getData();
        int v1 = v * 2 + 1;
        do {
            if(atomicReferenceArray0.compareAndSet(v1, object0, object1)) {
                return true;
            }
        }
        while(atomicReferenceArray0.get(v1) == object0);
        return false;
    }

    public final void cleanElement$kotlinx_coroutines_core(int v) {
        this.setElementLazy(v, null);
    }

    @Nullable
    public final Object getAndSetState$kotlinx_coroutines_core(int v, @Nullable Object object0) {
        return this.getData().getAndSet(v * 2 + 1, object0);
    }

    @NotNull
    public final BufferedChannel getChannel() {
        q.d(this._channel);
        return this._channel;
    }

    private final AtomicReferenceArray getData() {
        return this.data;
    }

    public final Object getElement$kotlinx_coroutines_core(int v) {
        return this.getData().get(v * 2);
    }

    @Override  // kotlinx.coroutines.internal.Segment
    public int getNumberOfSlots() {
        return BufferedChannelKt.SEGMENT_SIZE;
    }

    @Nullable
    public final Object getState$kotlinx_coroutines_core(int v) {
        return this.getData().get(v * 2 + 1);
    }

    @Override  // kotlinx.coroutines.internal.Segment
    public void onCancellation(int v, @Nullable Throwable throwable0, @NotNull i i0) {
        Object object1;
        int v1 = BufferedChannelKt.SEGMENT_SIZE;
        int v2 = v < v1 ? 0 : 1;
        if(v2 != 0) {
            v -= v1;
        }
        Object object0 = this.getElement$kotlinx_coroutines_core(v);
        while(true) {
            do {
                object1 = this.getState$kotlinx_coroutines_core(v);
                if(object1 instanceof Waiter || object1 instanceof WaiterEB) {
                    goto label_17;
                }
                if(object1 == BufferedChannelKt.INTERRUPTED_SEND || object1 == BufferedChannelKt.INTERRUPTED_RCV) {
                    goto label_11;
                }
            }
            while(object1 == BufferedChannelKt.RESUMING_BY_EB || object1 == BufferedChannelKt.RESUMING_BY_RCV);
            if(object1 != BufferedChannelKt.DONE_RCV && object1 != BufferedChannelKt.BUFFERED && object1 != BufferedChannelKt.getCHANNEL_CLOSED()) {
                throw new IllegalStateException(("unexpected state: " + object1).toString());
            }
            break;
        label_11:
            this.cleanElement$kotlinx_coroutines_core(v);
            if(v2 == 0) {
                break;
            }
            k k0 = this.getChannel().onUndeliveredElement;
            if(k0 == null) {
                break;
            }
            OnUndeliveredElementKt.callUndeliveredElement(k0, object0, i0);
            return;
        label_17:
            if(this.casState$kotlinx_coroutines_core(v, object1, (v2 == 0 ? BufferedChannelKt.INTERRUPTED_RCV : BufferedChannelKt.INTERRUPTED_SEND))) {
                this.cleanElement$kotlinx_coroutines_core(v);
                this.onCancelledRequest(v, ((boolean)(v2 ^ 1)));
                if(v2 == 0) {
                    break;
                }
                k k1 = this.getChannel().onUndeliveredElement;
                if(k1 == null) {
                    break;
                }
                OnUndeliveredElementKt.callUndeliveredElement(k1, object0, i0);
                return;
            }
        }
    }

    public final void onCancelledRequest(int v, boolean z) {
        if(z) {
            this.getChannel().waitExpandBufferCompletion$kotlinx_coroutines_core(this.id * ((long)BufferedChannelKt.SEGMENT_SIZE) + ((long)v));
        }
        this.onSlotCleaned();
    }

    public final Object retrieveElement$kotlinx_coroutines_core(int v) {
        Object object0 = this.getElement$kotlinx_coroutines_core(v);
        this.cleanElement$kotlinx_coroutines_core(v);
        return object0;
    }

    private final void setElementLazy(int v, Object object0) {
        this.getData().set(v * 2, object0);
    }

    public final void setState$kotlinx_coroutines_core(int v, @Nullable Object object0) {
        this.getData().set(v * 2 + 1, object0);
    }

    public final void storeElement$kotlinx_coroutines_core(int v, Object object0) {
        this.setElementLazy(v, object0);
    }
}

