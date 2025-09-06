package kotlinx.coroutines;

import ie.d;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@d
@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0003\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\'R\u001C\u0010\u0002\u001A\u0004\u0018\u00010\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/ChildHandle;", "Lkotlinx/coroutines/DisposableHandle;", "parent", "Lkotlinx/coroutines/Job;", "getParent$annotations", "()V", "getParent", "()Lkotlinx/coroutines/Job;", "childCancelled", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public interface ChildHandle extends DisposableHandle {
    boolean childCancelled(@NotNull Throwable arg1);

    @Nullable
    Job getParent();
}

