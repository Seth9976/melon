package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/channels/BufferOverflow;", "", "<init>", "(Ljava/lang/String;I)V", "SUSPEND", "DROP_OLDEST", "DROP_LATEST", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public enum BufferOverflow {
    SUSPEND,
    DROP_OLDEST,
    DROP_LATEST;

    private static final a $ENTRIES;
    private static final BufferOverflow[] $VALUES;

    private static final BufferOverflow[] $values() [...] // Inlined contents

    static {
        BufferOverflow.$VALUES = arr_bufferOverflow;
        q.g(arr_bufferOverflow, "entries");
        BufferOverflow.$ENTRIES = new b(arr_bufferOverflow);
    }
}

