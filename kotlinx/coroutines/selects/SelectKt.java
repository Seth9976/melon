package kotlinx.coroutines.selects;

import ie.H;
import kotlin.Metadata;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import we.o;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A=\u0010\b\u001A\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00010\u00002\"\u0010\u0006\u001A\u001E\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002H\u0002\u00A2\u0006\u0004\b\b\u0010\t\u001A\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b\r\u0010\u000E\"6\u0010\u0010\u001A$\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002j\u0002`\u000F8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\"\u0014\u0010\u0013\u001A\u00020\u00128\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0015\u001A\u00020\u00128\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0015\u0010\u0014\"\u0014\u0010\u0016\u001A\u00020\u00128\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0016\u0010\u0014\"\u0014\u0010\u0017\u001A\u00020\u00128\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0017\u0010\u0014\"\u001A\u0010\u0018\u001A\u00020\u00128\u0000X\u0080\u0004\u00A2\u0006\f\n\u0004\b\u0018\u0010\u0014\u001A\u0004\b\u0019\u0010\u001A*H\b\u0007\u0010\u001C\" \u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001B\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00010\u00022 \u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001B\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00010\u0002*H\b\u0007\u0010\u001D\" \u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022 \u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002*\u0080\u0001\b\u0007\u0010\u001E\"<\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001B\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u001E\u0012\u001C\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00020\u00022<\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001B\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u001E\u0012\u001C\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00020\u0002\u00A8\u0006\u001F"}, d2 = {"Lkotlinx/coroutines/CancellableContinuation;", "Lie/H;", "Lkotlin/Function3;", "", "", "Lme/i;", "onCancellation", "", "tryResume", "(Lkotlinx/coroutines/CancellableContinuation;Lwe/o;)Z", "", "trySelectInternalResult", "Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "TrySelectDetailedResult", "(I)Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "DUMMY_PROCESS_RESULT_FUNCTION", "Lwe/o;", "Lkotlinx/coroutines/internal/Symbol;", "STATE_REG", "Lkotlinx/coroutines/internal/Symbol;", "STATE_COMPLETED", "STATE_CANCELLED", "NO_RESULT", "PARAM_CLAUSE_0", "getPARAM_CLAUSE_0", "()Lkotlinx/coroutines/internal/Symbol;", "Lkotlinx/coroutines/selects/SelectInstance;", "RegistrationFunction", "ProcessResultFunction", "OnCancellationConstructor", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class SelectKt {
    @NotNull
    private static final o DUMMY_PROCESS_RESULT_FUNCTION;
    @NotNull
    private static final Symbol NO_RESULT;
    @NotNull
    private static final Symbol PARAM_CLAUSE_0;
    @NotNull
    private static final Symbol STATE_CANCELLED;
    @NotNull
    private static final Symbol STATE_COMPLETED;
    @NotNull
    private static final Symbol STATE_REG;

    static {
        SelectKt.DUMMY_PROCESS_RESULT_FUNCTION = (Object object0, Object object1, Object object2) -> null;
        SelectKt.STATE_REG = new Symbol("STATE_REG");
        SelectKt.STATE_COMPLETED = new Symbol("STATE_COMPLETED");
        SelectKt.STATE_CANCELLED = new Symbol("STATE_CANCELLED");
        SelectKt.NO_RESULT = new Symbol("NO_RESULT");
        SelectKt.PARAM_CLAUSE_0 = new Symbol("PARAM_CLAUSE_0");
    }

    private static final TrySelectDetailedResult TrySelectDetailedResult(int v) {
        switch(v) {
            case 0: {
                return TrySelectDetailedResult.SUCCESSFUL;
            }
            case 1: {
                return TrySelectDetailedResult.REREGISTER;
            }
            case 2: {
                return TrySelectDetailedResult.CANCELLED;
            }
            case 3: {
                return TrySelectDetailedResult.ALREADY_SELECTED;
            }
            default: {
                throw new IllegalStateException(("Unexpected internal result: " + v).toString());
            }
        }
    }

    public static final o access$getDUMMY_PROCESS_RESULT_FUNCTION$p() {
        return SelectKt.DUMMY_PROCESS_RESULT_FUNCTION;
    }

    @NotNull
    public static final Symbol getPARAM_CLAUSE_0() {
        return SelectKt.PARAM_CLAUSE_0;
    }

    private static final boolean tryResume(CancellableContinuation cancellableContinuation0, o o0) {
        Object object0 = cancellableContinuation0.tryResume(H.a, null, o0);
        if(object0 == null) {
            return false;
        }
        cancellableContinuation0.completeResume(object0);
        return true;
    }
}

