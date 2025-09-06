package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001A\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0014\u0010\r\u001A\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\f¨\u0006\u000E"}, d2 = {"Lkotlinx/coroutines/NodeList;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/Incomplete;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "isActive", "()Z", "getList", "()Lkotlinx/coroutines/NodeList;", "list", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class NodeList extends LockFreeLinkedListHead implements Incomplete {
    @Override  // kotlinx.coroutines.Incomplete
    @NotNull
    public NodeList getList() {
        return this;
    }

    @Override  // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return true;
    }

    @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode
    @NotNull
    public String toString() {
        return super.toString();
    }
}

