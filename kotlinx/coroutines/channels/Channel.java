package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u0004*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/channels/Channel;", "E", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Factory", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public interface Channel extends ReceiveChannel, SendChannel {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0005\u001A\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/channels/Channel$Factory;", "", "<init>", "()V", "", "CHANNEL_DEFAULT_CAPACITY", "I", "getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core", "()I", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public static final class Factory {
        static final Factory $$INSTANCE;
        private static final int CHANNEL_DEFAULT_CAPACITY;

        static {
            Factory.$$INSTANCE = new Factory();
            Factory.CHANNEL_DEFAULT_CAPACITY = SystemPropsKt.systemProp("kotlinx.coroutines.channels.defaultBuffer", 0x40, 1, 0x7FFFFFFE);
        }

        public final int getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core() [...] // 潜在的解密器
    }

    @NotNull
    public static final Factory Factory;

    static {
        Channel.Factory = Factory.$$INSTANCE;
    }
}

