package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Segment;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J#\u0010\u0007\u001A\u00020\u00062\n\u0010\u0003\u001A\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/Waiter;", "", "Lkotlinx/coroutines/internal/Segment;", "segment", "", "index", "Lie/H;", "invokeOnCancellation", "(Lkotlinx/coroutines/internal/Segment;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public interface Waiter {
    void invokeOnCancellation(@NotNull Segment arg1, int arg2);
}

