package kotlinx.coroutines.selects;

import kotlin.Metadata;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bw\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J!\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0003\u001A\u00020\u00022\b\u0010\u0004\u001A\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001A\u00020\t2\b\u0010\b\u001A\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\n\u0010\u000BR\u0014\u0010\u000F\u001A\u00020\f8&X¦\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000E¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/selects/SelectInstance;", "R", "", "clauseObject", "result", "", "trySelect", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "internalResult", "Lie/H;", "selectInRegistrationPhase", "(Ljava/lang/Object;)V", "Lme/i;", "getContext", "()Lme/i;", "context", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public interface SelectInstance {
    @NotNull
    i getContext();

    void selectInRegistrationPhase(@Nullable Object arg1);

    boolean trySelect(@NotNull Object arg1, @Nullable Object arg2);
}

