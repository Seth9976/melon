package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESSFUL", "REREGISTER", "CANCELLED", "ALREADY_SELECTED", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public enum TrySelectDetailedResult {
    SUCCESSFUL,
    REREGISTER,
    CANCELLED,
    ALREADY_SELECTED;

    private static final a $ENTRIES;
    private static final TrySelectDetailedResult[] $VALUES;

    private static final TrySelectDetailedResult[] $values() [...] // Inlined contents

    static {
        TrySelectDetailedResult.$VALUES = arr_trySelectDetailedResult;
        q.g(arr_trySelectDetailedResult, "entries");
        TrySelectDetailedResult.$ENTRIES = new b(arr_trySelectDetailedResult);
    }
}

