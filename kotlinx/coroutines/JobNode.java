package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u000F\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001A\u00020\u00062\b\u0010\f\u001A\u0004\u0018\u00010\u000BH&¢\u0006\u0004\b\r\u0010\u000ER\"\u0010\u0010\u001A\u00020\u000F8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001A\u00020\u00168&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001A\u001A\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u0018R\u0016\u0010\u001E\u001A\u0004\u0018\u00010\u001B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001D¨\u0006\u001F"}, d2 = {"Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Incomplete;", "<init>", "()V", "Lie/H;", "dispose", "", "toString", "()Ljava/lang/String;", "", "cause", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/JobSupport;", "job", "Lkotlinx/coroutines/JobSupport;", "getJob", "()Lkotlinx/coroutines/JobSupport;", "setJob", "(Lkotlinx/coroutines/JobSupport;)V", "", "getOnCancelling", "()Z", "onCancelling", "isActive", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "list", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public abstract class JobNode extends LockFreeLinkedListNode implements DisposableHandle, Incomplete {
    public JobSupport job;

    @Override  // kotlinx.coroutines.DisposableHandle
    public void dispose() {
        this.getJob().removeNode$kotlinx_coroutines_core(this);
    }

    @NotNull
    public final JobSupport getJob() {
        JobSupport jobSupport0 = this.job;
        if(jobSupport0 != null) {
            return jobSupport0;
        }
        q.m("job");
        throw null;
    }

    @Override  // kotlinx.coroutines.Incomplete
    @Nullable
    public NodeList getList() {
        return null;
    }

    public abstract boolean getOnCancelling();

    public abstract void invoke(@Nullable Throwable arg1);

    @Override  // kotlinx.coroutines.Incomplete
    public boolean isActive() {
        return true;
    }

    public final void setJob(@NotNull JobSupport jobSupport0) {
        this.job = jobSupport0;
    }

    @Override  // kotlinx.coroutines.internal.LockFreeLinkedListNode
    @NotNull
    public String toString() {
        return DebugStringsKt.getClassSimpleName(this) + '@' + DebugStringsKt.getHexAddress(this) + "[job@" + DebugStringsKt.getHexAddress(this.getJob()) + ']';
    }
}

