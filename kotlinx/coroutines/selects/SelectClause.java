package kotlinx.coroutines.selects;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.o;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001R\u0014\u0010\u0004\u001A\u00020\u00018&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0002\u0010\u0003R6\u0010\u000B\u001A$\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\b8&X¦\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\nR6\u0010\u000E\u001A$\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005j\u0002`\f8&X¦\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\nRV\u0010\u0013\u001AD\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u001E\u0012\u001C\u0012\u0004\u0012\u00020\u000F\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00070\u0005\u0018\u00010\u0005j\u0004\u0018\u0001`\u00118&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\n\u0082\u0001\u0002\u0014\u0015¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/selects/SelectClause;", "", "getClauseObject", "()Ljava/lang/Object;", "clauseObject", "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lie/H;", "Lkotlinx/coroutines/selects/RegistrationFunction;", "getRegFunc", "()Lwe/o;", "regFunc", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "getProcessResFunc", "processResFunc", "", "Lme/i;", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "getOnCancellationConstructor", "onCancellationConstructor", "Lkotlinx/coroutines/selects/SelectClause0;", "Lkotlinx/coroutines/selects/SelectClause1;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public interface SelectClause {
    @NotNull
    Object getClauseObject();

    @Nullable
    o getOnCancellationConstructor();

    @NotNull
    o getProcessResFunc();

    @NotNull
    o getRegFunc();
}

