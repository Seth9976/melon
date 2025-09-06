package kotlinx.coroutines.selects;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.o;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u00AF\u0001\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012(\u0010\t\u001A$\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\b\u0012(\u0010\u000B\u001A$\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005j\u0002`\n\u0012J\b\u0002\u0010\u000F\u001AD\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u001E\u0012\u001C\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u0005\u0018\u00010\u0005j\u0004\u0018\u0001`\u000E\u00A2\u0006\u0004\b\u0010\u0010\u0011R\u001A\u0010\u0004\u001A\u00020\u00038\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0004\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014R<\u0010\t\u001A$\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\b8\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\t\u0010\u0015\u001A\u0004\b\u0016\u0010\u0017R<\u0010\u000B\u001A$\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005j\u0002`\n8\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u000B\u0010\u0015\u001A\u0004\b\u0018\u0010\u0017R\\\u0010\u000F\u001AD\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u001E\u0012\u001C\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u0005\u0018\u00010\u0005j\u0004\u0018\u0001`\u000E8\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u000F\u0010\u0015\u001A\u0004\b\u0019\u0010\u0017\u00A8\u0006\u001A"}, d2 = {"Lkotlinx/coroutines/selects/SelectClause1Impl;", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "", "clauseObject", "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lie/H;", "Lkotlinx/coroutines/selects/RegistrationFunction;", "regFunc", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "processResFunc", "", "Lme/i;", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "onCancellationConstructor", "<init>", "(Ljava/lang/Object;Lwe/o;Lwe/o;Lwe/o;)V", "Ljava/lang/Object;", "getClauseObject", "()Ljava/lang/Object;", "Lwe/o;", "getRegFunc", "()Lwe/o;", "getProcessResFunc", "getOnCancellationConstructor", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class SelectClause1Impl implements SelectClause1 {
    @NotNull
    private final Object clauseObject;
    @Nullable
    private final o onCancellationConstructor;
    @NotNull
    private final o processResFunc;
    @NotNull
    private final o regFunc;

    public SelectClause1Impl(@NotNull Object object0, @NotNull o o0, @NotNull o o1, @Nullable o o2) {
        this.clauseObject = object0;
        this.regFunc = o0;
        this.processResFunc = o1;
        this.onCancellationConstructor = o2;
    }

    @Override  // kotlinx.coroutines.selects.SelectClause
    @NotNull
    public Object getClauseObject() {
        return this.clauseObject;
    }

    @Override  // kotlinx.coroutines.selects.SelectClause
    @Nullable
    public o getOnCancellationConstructor() {
        return this.onCancellationConstructor;
    }

    @Override  // kotlinx.coroutines.selects.SelectClause
    @NotNull
    public o getProcessResFunc() {
        return this.processResFunc;
    }

    @Override  // kotlinx.coroutines.selects.SelectClause
    @NotNull
    public o getRegFunc() {
        return this.regFunc;
    }
}

