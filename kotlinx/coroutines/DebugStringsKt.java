package kotlinx.coroutines;

import ie.p;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.DispatchedContinuation;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000E\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u0010\u0010\u0005\u001A\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0006H\u0000\"\u0018\u0010\u0000\u001A\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0007\u001A\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\u0004¨\u0006\t"}, d2 = {"hexAddress", "", "", "getHexAddress", "(Ljava/lang/Object;)Ljava/lang/String;", "toDebugString", "Lkotlin/coroutines/Continuation;", "classSimpleName", "getClassSimpleName", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class DebugStringsKt {
    @NotNull
    public static final String getClassSimpleName(@NotNull Object object0) {
        return object0.getClass().getSimpleName();
    }

    @NotNull
    public static final String getHexAddress(@NotNull Object object0) {
        return Integer.toHexString(System.identityHashCode(object0));
    }

    @NotNull
    public static final String toDebugString(@NotNull Continuation continuation0) {
        if(continuation0 instanceof DispatchedContinuation) {
            return ((DispatchedContinuation)continuation0).toString();
        }
        String s = continuation0 + '@' + DebugStringsKt.getHexAddress(continuation0);
        return p.a(s) == null ? s : continuation0.getClass().getName() + '@' + DebugStringsKt.getHexAddress(continuation0);
    }
}

