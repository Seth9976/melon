package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.ThreadContextElement;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\f\u001A\u00020\u000B2\n\u0010\t\u001A\u0006\u0012\u0002\b\u00030\b2\b\u0010\n\u001A\u0004\u0018\u00010\u0001¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0003\u001A\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u001C\u0010\u0012\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001A\u0012\u0012\u000E\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\b0\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/internal/ThreadState;", "", "Lme/i;", "context", "", "n", "<init>", "(Lme/i;I)V", "Lkotlinx/coroutines/ThreadContextElement;", "element", "value", "Lie/H;", "append", "(Lkotlinx/coroutines/ThreadContextElement;Ljava/lang/Object;)V", "restore", "(Lme/i;)V", "Lme/i;", "", "values", "[Ljava/lang/Object;", "elements", "[Lkotlinx/coroutines/ThreadContextElement;", "i", "I", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class ThreadState {
    @NotNull
    public final i context;
    @NotNull
    private final ThreadContextElement[] elements;
    private int i;
    @NotNull
    private final Object[] values;

    public ThreadState(@NotNull i i0, int v) {
        this.context = i0;
        this.values = new Object[v];
        this.elements = new ThreadContextElement[v];
    }

    public final void append(@NotNull ThreadContextElement threadContextElement0, @Nullable Object object0) {
        int v = this.i;
        this.values[v] = object0;
        this.i = v + 1;
        q.e(threadContextElement0, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        this.elements[v] = threadContextElement0;
    }

    public final void restore(@NotNull i i0) {
        int v = this.elements.length - 1;
        if(v >= 0) {
            while(true) {
                ThreadContextElement threadContextElement0 = this.elements[v];
                q.d(threadContextElement0);
                threadContextElement0.restoreThreadContext(i0, this.values[v]);
                if(v - 1 < 0) {
                    break;
                }
                --v;
            }
        }
    }
}

