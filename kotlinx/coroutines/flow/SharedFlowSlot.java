package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0000\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001B\u0010\u0007\u001A\u00020\u00062\n\u0010\u0005\u001A\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\f\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\n0\t2\n\u0010\u0005\u001A\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000F\u001A\u00020\u000E8\u0006@\u0006X\u0087\u000E¢\u0006\u0006\n\u0004\b\u000F\u0010\u0010R\u001E\u0010\u0011\u001A\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\n8\u0006@\u0006X\u0087\u000E¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "<init>", "()V", "flow", "", "allocateLocked", "(Lkotlinx/coroutines/flow/SharedFlowImpl;)Z", "", "Lkotlin/coroutines/Continuation;", "Lie/H;", "freeLocked", "(Lkotlinx/coroutines/flow/SharedFlowImpl;)[Lkotlin/coroutines/Continuation;", "", "index", "J", "cont", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class SharedFlowSlot extends AbstractSharedFlowSlot {
    @Nullable
    public Continuation cont;
    public long index;

    public SharedFlowSlot() {
        this.index = -1L;
    }

    @Override  // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public boolean allocateLocked(Object object0) {
        return this.allocateLocked(((SharedFlowImpl)object0));
    }

    public boolean allocateLocked(@NotNull SharedFlowImpl sharedFlowImpl0) {
        if(this.index >= 0L) {
            return false;
        }
        this.index = sharedFlowImpl0.updateNewCollectorIndexLocked$kotlinx_coroutines_core();
        return true;
    }

    @Override  // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public Continuation[] freeLocked(Object object0) {
        return this.freeLocked(((SharedFlowImpl)object0));
    }

    @NotNull
    public Continuation[] freeLocked(@NotNull SharedFlowImpl sharedFlowImpl0) {
        long v = this.index;
        this.index = -1L;
        this.cont = null;
        return sharedFlowImpl0.updateCollectorIndexLocked$kotlinx_coroutines_core(v);
    }
}

