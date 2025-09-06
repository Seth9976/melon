package kotlinx.coroutines.channels;

import e2.a;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.I;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B;\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\"\b\u0002\u0010\n\u001A\u001C\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\t¢\u0006\u0004\b\u000B\u0010\fJ%\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\r\u001A\u00028\u00002\u0006\u0010\u000F\u001A\u00020\u000EH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\r\u001A\u00028\u00002\u0006\u0010\u000F\u001A\u00020\u000EH\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u0018\u0010\u0016\u001A\u00020\b2\u0006\u0010\r\u001A\u00028\u0000H\u0096@¢\u0006\u0004\b\u0016\u0010\u0017J\u001D\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\r\u001A\u00028\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0004\u001A\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001BR\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001CR\u0014\u0010\u001D\u001A\u00020\u000E8TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\u001D\u0010\u001E¨\u0006\u001F"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBufferedChannel;", "E", "Lkotlinx/coroutines/channels/BufferedChannel;", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/Function1;", "Lie/H;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;Lwe/k;)V", "element", "", "isSendOp", "Lkotlinx/coroutines/channels/ChannelResult;", "trySendImpl-Mj0NB7M", "(Ljava/lang/Object;Z)Ljava/lang/Object;", "trySendImpl", "trySendDropLatest-Mj0NB7M", "trySendDropLatest", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "I", "Lkotlinx/coroutines/channels/BufferOverflow;", "isConflatedDropOldest", "()Z", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public class ConflatedBufferedChannel extends BufferedChannel {
    private final int capacity;
    @NotNull
    private final BufferOverflow onBufferOverflow;

    public ConflatedBufferedChannel(int v, @NotNull BufferOverflow bufferOverflow0, @Nullable k k0) {
        super(v, k0);
        this.capacity = v;
        this.onBufferOverflow = bufferOverflow0;
        if(bufferOverflow0 == BufferOverflow.SUSPEND) {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + I.a.b(BufferedChannel.class).m() + " instead").toString());
        }
        if(v < 1) {
            throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + v + " was specified").toString());
        }
    }

    @Override  // kotlinx.coroutines.channels.BufferedChannel
    public boolean isConflatedDropOldest() {
        return this.onBufferOverflow == BufferOverflow.DROP_OLDEST;
    }

    @Override  // kotlinx.coroutines.channels.BufferedChannel
    @Nullable
    public Object send(Object object0, @NotNull Continuation continuation0) {
        return ConflatedBufferedChannel.send$suspendImpl(this, object0, continuation0);
    }

    public static Object send$suspendImpl(ConflatedBufferedChannel conflatedBufferedChannel0, Object object0, Continuation continuation0) {
        Object object1 = conflatedBufferedChannel0.trySendImpl-Mj0NB7M(object0, true);
        if(object1 instanceof Closed) {
            ChannelResult.exceptionOrNull-impl(object1);
            k k0 = conflatedBufferedChannel0.onUndeliveredElement;
            if(k0 != null) {
                UndeliveredElementException undeliveredElementException0 = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(k0, object0, null, 2, null);
                if(undeliveredElementException0 != null) {
                    a.q(undeliveredElementException0, conflatedBufferedChannel0.getSendException());
                    throw undeliveredElementException0;
                }
            }
            throw conflatedBufferedChannel0.getSendException();
        }
        return H.a;
    }

    @Override  // kotlinx.coroutines.channels.BufferedChannel
    @NotNull
    public Object trySend-JP2dKIU(Object object0) {
        return this.trySendImpl-Mj0NB7M(object0, false);
    }

    private final Object trySendDropLatest-Mj0NB7M(Object object0, boolean z) {
        Object object1 = super.trySend-JP2dKIU(object0);
        if(!ChannelResult.isSuccess-impl(object1) && !ChannelResult.isClosed-impl(object1)) {
            if(z) {
                k k0 = this.onUndeliveredElement;
                if(k0 != null) {
                    UndeliveredElementException undeliveredElementException0 = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(k0, object0, null, 2, null);
                    if(undeliveredElementException0 != null) {
                        throw undeliveredElementException0;
                    }
                }
            }
            return ChannelResult.Companion.success-JP2dKIU(H.a);
        }
        return object1;
    }

    private final Object trySendImpl-Mj0NB7M(Object object0, boolean z) {
        return this.onBufferOverflow == BufferOverflow.DROP_LATEST ? this.trySendDropLatest-Mj0NB7M(object0, z) : this.trySendDropOldest-JP2dKIU(object0);
    }
}

