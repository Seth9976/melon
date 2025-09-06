package kotlinx.coroutines.selects;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import we.k;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001AE\u0010\t\u001A\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001A\u00020\u00022\u001C\u0010\u0007\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"R", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "timeMillis", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "block", "Lie/H;", "onTimeout", "(Lkotlinx/coroutines/selects/SelectBuilder;JLwe/k;)V", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class OnTimeoutKt {
    public static final void onTimeout(@NotNull SelectBuilder selectBuilder0, long v, @NotNull k k0) {
        selectBuilder0.invoke(new OnTimeout(v).getSelectClause(), k0);
    }
}

