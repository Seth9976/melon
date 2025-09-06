package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.o;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012(\u0010\b\u001A$\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0007\u0012J\b\u0002\u0010\f\u001AD\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u001E\u0012\u001C\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\u0004\u0018\u00010\u0004j\u0004\u0018\u0001`\u000B¢\u0006\u0004\b\r\u0010\u000ER\u001A\u0010\u0003\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u000F\u001A\u0004\b\u0010\u0010\u0011R<\u0010\b\u001A$\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014R\\\u0010\f\u001AD\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u001E\u0012\u001C\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\u0004\u0018\u00010\u0004j\u0004\u0018\u0001`\u000B8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\u0012\u001A\u0004\b\u0015\u0010\u0014R<\u0010\u0017\u001A$\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004j\u0002`\u00168\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001A\u0004\b\u0018\u0010\u0014¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/selects/SelectClause0Impl;", "Lkotlinx/coroutines/selects/SelectClause0;", "", "clauseObject", "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lie/H;", "Lkotlinx/coroutines/selects/RegistrationFunction;", "regFunc", "", "Lme/i;", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "onCancellationConstructor", "<init>", "(Ljava/lang/Object;Lwe/o;Lwe/o;)V", "Ljava/lang/Object;", "getClauseObject", "()Ljava/lang/Object;", "Lwe/o;", "getRegFunc", "()Lwe/o;", "getOnCancellationConstructor", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "processResFunc", "getProcessResFunc", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class SelectClause0Impl implements SelectClause0 {
    @NotNull
    private final Object clauseObject;
    @Nullable
    private final o onCancellationConstructor;
    @NotNull
    private final o processResFunc;
    @NotNull
    private final o regFunc;

    public SelectClause0Impl(@NotNull Object object0, @NotNull o o0, @Nullable o o1) {
        this.clauseObject = object0;
        this.regFunc = o0;
        this.onCancellationConstructor = o1;
        this.processResFunc = SelectKt.access$getDUMMY_PROCESS_RESULT_FUNCTION$p();
    }

    public SelectClause0Impl(Object object0, o o0, o o1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 4) != 0) {
            o1 = null;
        }
        this(object0, o0, o1);
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

