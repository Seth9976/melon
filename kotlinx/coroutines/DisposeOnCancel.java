package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001A\u00020\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000E¨\u0006\u000F"}, d2 = {"Lkotlinx/coroutines/DisposeOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "Lkotlinx/coroutines/DisposableHandle;", "handle", "<init>", "(Lkotlinx/coroutines/DisposableHandle;)V", "", "cause", "Lie/H;", "invoke", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/DisposableHandle;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class DisposeOnCancel implements CancelHandler {
    @NotNull
    private final DisposableHandle handle;

    public DisposeOnCancel(@NotNull DisposableHandle disposableHandle0) {
        this.handle = disposableHandle0;
    }

    @Override  // kotlinx.coroutines.CancelHandler
    public void invoke(@Nullable Throwable throwable0) {
        this.handle.dispose();
    }

    @Override
    @NotNull
    public String toString() {
        return "DisposeOnCancel[" + this.handle + ']';
    }
}

