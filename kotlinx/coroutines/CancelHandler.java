package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001:\u0001\u0007J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/CancelHandler;", "Lkotlinx/coroutines/NotCompleted;", "", "cause", "Lie/H;", "invoke", "(Ljava/lang/Throwable;)V", "UserSupplied", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public interface CancelHandler extends NotCompleted {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001D\u0012\u0014\u0010\u0005\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001A\u00020\u00042\b\u0010\b\u001A\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0005\u001A\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000E¨\u0006\u000F"}, d2 = {"Lkotlinx/coroutines/CancelHandler$UserSupplied;", "Lkotlinx/coroutines/CancelHandler;", "Lkotlin/Function1;", "", "Lie/H;", "handler", "<init>", "(Lwe/k;)V", "cause", "invoke", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Lwe/k;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public static final class UserSupplied implements CancelHandler {
        @NotNull
        private final k handler;

        public UserSupplied(@NotNull k k0) {
            this.handler = k0;
        }

        @Override  // kotlinx.coroutines.CancelHandler
        public void invoke(@Nullable Throwable throwable0) {
            this.handler.invoke(throwable0);
        }

        @Override
        @NotNull
        public String toString() {
            return "CancelHandler.UserSupplied[" + DebugStringsKt.getClassSimpleName(this.handler) + '@' + DebugStringsKt.getHexAddress(this) + ']';
        }
    }

    void invoke(@Nullable Throwable arg1);
}

