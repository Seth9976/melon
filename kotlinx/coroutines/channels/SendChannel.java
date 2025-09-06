package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u0018\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00028\u0000H¦@¢\u0006\u0004\b\u0005\u0010\u0006J\u001D\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\u0003\u001A\u00028\u0000H&¢\u0006\u0004\b\b\u0010\tJ\u001B\u0010\u000E\u001A\u00020\r2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u000BH&¢\u0006\u0004\b\u000E\u0010\u000FJ%\u0010\u0012\u001A\u00020\u00042\u0014\u0010\u0011\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000B\u0012\u0004\u0012\u00020\u00040\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013R\u001A\u0010\u0014\u001A\u00020\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/channels/SendChannel;", "E", "", "element", "Lie/H;", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "handler", "invokeOnClose", "(Lwe/k;)V", "isClosedForSend", "()Z", "isClosedForSend$annotations", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public interface SendChannel {
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 0x30)
    public static abstract class DefaultImpls {
        public static boolean close$default(SendChannel sendChannel0, Throwable throwable0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
            }
            if((v & 1) != 0) {
                throwable0 = null;
            }
            return sendChannel0.close(throwable0);
        }
    }

    boolean close(@Nullable Throwable arg1);

    void invokeOnClose(@NotNull k arg1);

    boolean isClosedForSend();

    @Nullable
    Object send(Object arg1, @NotNull Continuation arg2);

    @NotNull
    Object trySend-JP2dKIU(Object arg1);
}

