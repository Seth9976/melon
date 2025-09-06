package kotlinx.coroutines.selects;

import e1.u;
import ie.H;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import je.p;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import me.i;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.n;
import we.o;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004:\u0001LB\u000F\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001A\u00028\u0000H\u0091@\u00A2\u0006\u0004\b\t\u0010\nJ2\u0010\u0010\u001A\u00020\u000F*\u00020\u000B2\u001C\u0010\u000E\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0012\u0004\u0018\u00010\u00040\fH\u0096\u0002\u00A2\u0006\u0004\b\u0010\u0010\u0011JD\u0010\u0010\u001A\u00020\u000F\"\u0004\b\u0001\u0010\u0012*\b\u0012\u0004\u0012\u00028\u00010\u00132\"\u0010\u000E\u001A\u001E\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0014H\u0096\u0002\u00A2\u0006\u0004\b\u0010\u0010\u0015J\'\u0010\u0019\u001A\u00020\u000F*\f0\u0016R\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0018\u001A\u00020\u0017H\u0001\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0017\u0010\u001D\u001A\u00020\u000F2\u0006\u0010\u001C\u001A\u00020\u001BH\u0016\u00A2\u0006\u0004\b\u001D\u0010\u001EJ#\u0010#\u001A\u00020\u000F2\n\u0010 \u001A\u0006\u0012\u0002\b\u00030\u001F2\u0006\u0010\"\u001A\u00020!H\u0016\u00A2\u0006\u0004\b#\u0010$J\u0019\u0010&\u001A\u00020\u000F2\b\u0010%\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b&\u0010\'J!\u0010*\u001A\u00020\u00172\u0006\u0010(\u001A\u00020\u00042\b\u0010)\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b*\u0010+J\u001F\u0010-\u001A\u00020,2\u0006\u0010(\u001A\u00020\u00042\b\u0010)\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b-\u0010.J\u0019\u0010\u0010\u001A\u00020\u000F2\b\u00100\u001A\u0004\u0018\u00010/H\u0016\u00A2\u0006\u0004\b\u0010\u00101J\u0010\u00102\u001A\u00028\u0000H\u0082@\u00A2\u0006\u0004\b2\u0010\nJ\u0017\u00103\u001A\u00020\u000F2\u0006\u0010(\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b3\u0010\'J\u0010\u00104\u001A\u00020\u000FH\u0082@\u00A2\u0006\u0004\b4\u0010\nJ\u0017\u00105\u001A\u00020\u000F2\u0006\u0010(\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b5\u0010\'J!\u00106\u001A\u00020!2\u0006\u0010(\u001A\u00020\u00042\b\u0010%\u001A\u0004\u0018\u00010\u0004H\u0002\u00A2\u0006\u0004\b6\u00107J#\u00108\u001A\u000E\u0018\u00010\u0016R\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010(\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b8\u00109J\u0010\u0010:\u001A\u00028\u0000H\u0082@\u00A2\u0006\u0004\b:\u0010\nJ!\u0010<\u001A\u00020\u000F2\u0010\u0010;\u001A\f0\u0016R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002\u00A2\u0006\u0004\b<\u0010=R\u001A\u0010\u0006\u001A\u00020\u00058\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b\u0006\u0010>\u001A\u0004\b?\u0010@R(\u0010B\u001A\u0014\u0012\u000E\u0012\f0\u0016R\b\u0012\u0004\u0012\u00028\u00000\u0000\u0018\u00010A8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010D\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001A\u00020!8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010%\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b%\u0010ER\u0014\u0010H\u001A\u00020\u00178BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bH\u0010IR\u0011\u0010K\u001A\b\u0012\u0004\u0012\u00020\u00040J8\u0002X\u0082\u0004\u00A8\u0006M"}, d2 = {"Lkotlinx/coroutines/selects/SelectImplementation;", "R", "Lkotlinx/coroutines/CancelHandler;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lme/i;", "context", "<init>", "(Lme/i;)V", "doSelect", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectClause0;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "block", "Lie/H;", "invoke", "(Lkotlinx/coroutines/selects/SelectClause0;Lwe/k;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lwe/n;)V", "Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "", "reregister", "register", "(Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;Z)V", "Lkotlinx/coroutines/DisposableHandle;", "disposableHandle", "disposeOnCompletion", "(Lkotlinx/coroutines/DisposableHandle;)V", "Lkotlinx/coroutines/internal/Segment;", "segment", "", "index", "invokeOnCancellation", "(Lkotlinx/coroutines/internal/Segment;I)V", "internalResult", "selectInRegistrationPhase", "(Ljava/lang/Object;)V", "clauseObject", "result", "trySelect", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "trySelectDetailed", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "", "cause", "(Ljava/lang/Throwable;)V", "doSelectSuspend", "checkClauseObject", "waitUntilSelected", "reregisterClause", "trySelectInternal", "(Ljava/lang/Object;Ljava/lang/Object;)I", "findClause", "(Ljava/lang/Object;)Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "complete", "selectedClause", "cleanup", "(Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;)V", "Lme/i;", "getContext", "()Lme/i;", "", "clauses", "Ljava/util/List;", "disposableHandleOrSegment", "Ljava/lang/Object;", "indexInSegment", "I", "isSelected", "()Z", "Lkotlinx/atomicfu/AtomicRef;", "state", "ClauseData", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public class SelectImplementation implements CancelHandler, Waiter, SelectBuilder, SelectInstance {
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B\u00BF\u0001\u0012\u0006\u0010\u0002\u001A\u00020\u0001\u0012(\u0010\u0007\u001A$\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0006\u0012(\u0010\t\u001A$\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003j\u0002`\b\u0012\b\u0010\n\u001A\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000B\u001A\u00020\u0001\u0012H\u0010\u000F\u001AD\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u001E\u0012\u001C\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u0003\u0018\u00010\u0003j\u0004\u0018\u0001`\u000E\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u001B\u0010\u0015\u001A\u00020\u00142\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00028\u00000\u0012\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001A\u0004\u0018\u00010\u00012\b\u0010\u0017\u001A\u0004\u0018\u00010\u0001\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u001A\u0010\u001B\u001A\u00028\u00002\b\u0010\u001A\u001A\u0004\u0018\u00010\u0001H\u0086@\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\r\u0010\u001D\u001A\u00020\u0005\u00A2\u0006\u0004\b\u001D\u0010\u001EJ?\u0010 \u001A\u001E\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\n\u0010\u0013\u001A\u0006\u0012\u0002\b\u00030\u00042\b\u0010\u001F\u001A\u0004\u0018\u00010\u0001\u00A2\u0006\u0004\b \u0010!R\u0014\u0010\u0002\u001A\u00020\u00018\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\u0002\u0010\"R6\u0010\u0007\u001A$\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u00068\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0007\u0010#R6\u0010\t\u001A$\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003j\u0002`\b8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\t\u0010#R\u0016\u0010\n\u001A\u0004\u0018\u00010\u00018\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\n\u0010\"R\u0014\u0010\u000B\u001A\u00020\u00018\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u000B\u0010\"RV\u0010\u000F\u001AD\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u001E\u0012\u001C\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u0003\u0018\u00010\u0003j\u0004\u0018\u0001`\u000E8\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\u000F\u0010#R\u0018\u0010$\u001A\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010&\u001A\u00020%8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0006\n\u0004\b&\u0010\'\u00A8\u0006("}, d2 = {"Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "", "clauseObject", "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lie/H;", "Lkotlinx/coroutines/selects/RegistrationFunction;", "regFunc", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "processResFunc", "param", "block", "", "Lme/i;", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "onCancellationConstructor", "<init>", "(Lkotlinx/coroutines/selects/SelectImplementation;Ljava/lang/Object;Lwe/o;Lwe/o;Ljava/lang/Object;Ljava/lang/Object;Lwe/o;)V", "Lkotlinx/coroutines/selects/SelectImplementation;", "select", "", "tryRegisterAsWaiter", "(Lkotlinx/coroutines/selects/SelectImplementation;)Z", "result", "processResult", "(Ljava/lang/Object;)Ljava/lang/Object;", "argument", "invokeBlock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispose", "()V", "internalResult", "createOnCancellationAction", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)Lwe/o;", "Ljava/lang/Object;", "Lwe/o;", "disposableHandleOrSegment", "", "indexInSegment", "I", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public final class ClauseData {
        @NotNull
        private final Object block;
        @NotNull
        public final Object clauseObject;
        @Nullable
        public Object disposableHandleOrSegment;
        public int indexInSegment;
        @Nullable
        public final o onCancellationConstructor;
        @Nullable
        private final Object param;
        @NotNull
        private final o processResFunc;
        @NotNull
        private final o regFunc;

        public ClauseData(@NotNull Object object0, @NotNull o o0, @NotNull o o1, @Nullable Object object1, @NotNull Object object2, @Nullable o o2) {
            this.clauseObject = object0;
            this.regFunc = o0;
            this.processResFunc = o1;
            this.param = object1;
            this.block = object2;
            this.onCancellationConstructor = o2;
            this.indexInSegment = -1;
        }

        @Nullable
        public final o createOnCancellationAction(@NotNull SelectInstance selectInstance0, @Nullable Object object0) {
            return this.onCancellationConstructor == null ? null : ((o)this.onCancellationConstructor.invoke(selectInstance0, this.param, object0));
        }

        public final void dispose() {
            Object object0 = this.disposableHandleOrSegment;
            SelectImplementation selectImplementation0 = SelectImplementation.this;
            DisposableHandle disposableHandle0 = null;
            if(object0 instanceof Segment) {
                ((Segment)object0).onCancellation(this.indexInSegment, null, selectImplementation0.getContext());
                return;
            }
            if(object0 instanceof DisposableHandle) {
                disposableHandle0 = (DisposableHandle)object0;
            }
            if(disposableHandle0 != null) {
                disposableHandle0.dispose();
            }
        }

        @Nullable
        public final Object invokeBlock(@Nullable Object object0, @NotNull Continuation continuation0) {
            Object object1 = this.block;
            if(this.param == SelectKt.getPARAM_CLAUSE_0()) {
                q.e(object1, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
                return ((k)object1).invoke(continuation0);
            }
            q.e(object1, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
            return ((n)object1).invoke(object0, continuation0);
        }

        @Nullable
        public final Object processResult(@Nullable Object object0) {
            return this.processResFunc.invoke(this.clauseObject, this.param, object0);
        }

        public final boolean tryRegisterAsWaiter(@NotNull SelectImplementation selectImplementation0) {
            this.regFunc.invoke(this.clauseObject, selectImplementation0, this.param);
            return selectImplementation0.internalResult == SelectKt.NO_RESULT;
        }
    }

    @Nullable
    private List clauses;
    @NotNull
    private final i context;
    @Nullable
    private Object disposableHandleOrSegment;
    private int indexInSegment;
    @Nullable
    private Object internalResult;
    private volatile Object state$volatile;
    private static final AtomicReferenceFieldUpdater state$volatile$FU;

    static {
        SelectImplementation.state$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, "state$volatile");
    }

    public SelectImplementation(@NotNull i i0) {
        this.context = i0;
        this.state$volatile = SelectKt.access$getSTATE_REG$p();
        this.clauses = new ArrayList(2);
        this.indexInSegment = -1;
        this.internalResult = SelectKt.access$getNO_RESULT$p();
    }

    private final void checkClauseObject(Object object0) {
        List list0 = this.clauses;
        q.d(list0);
        if(list0 instanceof Collection && list0.isEmpty()) {
            return;
        }
        for(Object object1: list0) {
            if(((ClauseData)object1).clauseObject == object0) {
                throw new IllegalStateException(("Cannot use select clauses on the same object: " + object0).toString());
            }
            if(false) {
                break;
            }
        }
    }

    private final void cleanup(ClauseData selectImplementation$ClauseData0) {
        List list0 = this.clauses;
        if(list0 == null) {
            return;
        }
        for(Object object0: list0) {
            ClauseData selectImplementation$ClauseData1 = (ClauseData)object0;
            if(selectImplementation$ClauseData1 != selectImplementation$ClauseData0) {
                selectImplementation$ClauseData1.dispose();
            }
        }
        SelectImplementation.state$volatile$FU.set(this, SelectKt.access$getSTATE_COMPLETED$p());
        this.internalResult = SelectKt.access$getNO_RESULT$p();
        this.clauses = null;
    }

    private final Object complete(Continuation continuation0) {
        Object object0 = SelectImplementation.getState$volatile$FU().get(this);
        q.e(object0, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        Object object1 = this.internalResult;
        this.cleanup(((ClauseData)object0));
        return ((ClauseData)object0).invokeBlock(((ClauseData)object0).processResult(object1), continuation0);
    }

    public void disposeOnCompletion(@NotNull DisposableHandle disposableHandle0) {
        this.disposableHandleOrSegment = disposableHandle0;
    }

    @Nullable
    public Object doSelect(@NotNull Continuation continuation0) {
        return SelectImplementation.doSelect$suspendImpl(this, continuation0);
    }

    // 去混淆评级： 低(20)
    public static Object doSelect$suspendImpl(SelectImplementation selectImplementation0, Continuation continuation0) {
        return selectImplementation0.isSelected() ? selectImplementation0.complete(continuation0) : selectImplementation0.doSelectSuspend(continuation0);
    }

    private final Object doSelectSuspend(Continuation continuation0) {
        SelectImplementation selectImplementation0;
        kotlinx.coroutines.selects.SelectImplementation.doSelectSuspend.1 selectImplementation$doSelectSuspend$10;
        if(continuation0 instanceof kotlinx.coroutines.selects.SelectImplementation.doSelectSuspend.1) {
            selectImplementation$doSelectSuspend$10 = (kotlinx.coroutines.selects.SelectImplementation.doSelectSuspend.1)continuation0;
            int v = selectImplementation$doSelectSuspend$10.label;
            if((v & 0x80000000) == 0) {
                selectImplementation$doSelectSuspend$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.doSelectSuspend(this);
                    }
                };
            }
            else {
                selectImplementation$doSelectSuspend$10.label = v ^ 0x80000000;
            }
        }
        else {
            selectImplementation$doSelectSuspend$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.doSelectSuspend(this);
                }
            };
        }
        Object object0 = selectImplementation$doSelectSuspend$10.result;
        a a0 = a.a;
        switch(selectImplementation$doSelectSuspend$10.label) {
            case 0: {
                d5.n.D(object0);
                selectImplementation$doSelectSuspend$10.L$0 = this;
                selectImplementation$doSelectSuspend$10.label = 1;
                if(this.waitUntilSelected(selectImplementation$doSelectSuspend$10) == a0) {
                    return a0;
                }
                selectImplementation0 = this;
                break;
            }
            case 1: {
                selectImplementation0 = (SelectImplementation)selectImplementation$doSelectSuspend$10.L$0;
                d5.n.D(object0);
                break;
            }
            case 2: {
                d5.n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        selectImplementation$doSelectSuspend$10.L$0 = null;
        selectImplementation$doSelectSuspend$10.label = 2;
        Object object1 = selectImplementation0.complete(selectImplementation$doSelectSuspend$10);
        return object1 == a0 ? a0 : object1;
    }

    private final ClauseData findClause(Object object0) {
        List list0 = this.clauses;
        Object object1 = null;
        if(list0 == null) {
            return null;
        }
        for(Object object2: list0) {
            if(((ClauseData)object2).clauseObject == object0) {
                object1 = object2;
                break;
            }
            if(false) {
                break;
            }
        }
        if(((ClauseData)object1) == null) {
            throw new IllegalStateException(("Clause with object " + object0 + " is not found").toString());
        }
        return (ClauseData)object1;
    }

    @Override  // kotlinx.coroutines.selects.SelectInstance
    @NotNull
    public i getContext() {
        return this.context;
    }

    @Override  // kotlinx.coroutines.CancelHandler
    public void invoke(@Nullable Throwable throwable0) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = SelectImplementation.state$volatile$FU;
        Object object0;
        while((object0 = atomicReferenceFieldUpdater0.get(this)) != SelectKt.STATE_COMPLETED) {
            Symbol symbol0 = SelectKt.STATE_CANCELLED;
        label_4:
            if(atomicReferenceFieldUpdater0.compareAndSet(this, object0, symbol0)) {
                List list0 = this.clauses;
                if(list0 == null) {
                    break;
                }
                for(Object object1: list0) {
                    ((ClauseData)object1).dispose();
                }
                this.internalResult = SelectKt.NO_RESULT;
                this.clauses = null;
                return;
            }
            if(atomicReferenceFieldUpdater0.get(this) != object0) {
                continue;
            }
            if(false) {
                break;
            }
            goto label_4;
        }
    }

    @Override  // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(@NotNull SelectClause0 selectClause00, @NotNull k k0) {
        SelectImplementation.register$default(this, new ClauseData(this, selectClause00.getClauseObject(), selectClause00.getRegFunc(), selectClause00.getProcessResFunc(), SelectKt.getPARAM_CLAUSE_0(), k0, selectClause00.getOnCancellationConstructor()), false, 1, null);
    }

    @Override  // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(@NotNull SelectClause1 selectClause10, @NotNull n n0) {
        SelectImplementation.register$default(this, new ClauseData(this, selectClause10.getClauseObject(), selectClause10.getRegFunc(), selectClause10.getProcessResFunc(), null, n0, selectClause10.getOnCancellationConstructor()), false, 1, null);
    }

    @Override  // kotlinx.coroutines.Waiter
    public void invokeOnCancellation(@NotNull Segment segment0, int v) {
        this.disposableHandleOrSegment = segment0;
        this.indexInSegment = v;
    }

    private final boolean isSelected() {
        return SelectImplementation.state$volatile$FU.get(this) instanceof ClauseData;
    }

    public final void register(@NotNull ClauseData selectImplementation$ClauseData0, boolean z) {
        if(SelectImplementation.state$volatile$FU.get(this) instanceof ClauseData) {
            return;
        }
        if(!z) {
            this.checkClauseObject(selectImplementation$ClauseData0.clauseObject);
        }
        if(selectImplementation$ClauseData0.tryRegisterAsWaiter(this)) {
            if(!z) {
                List list0 = this.clauses;
                q.d(list0);
                list0.add(selectImplementation$ClauseData0);
            }
            selectImplementation$ClauseData0.disposableHandleOrSegment = this.disposableHandleOrSegment;
            selectImplementation$ClauseData0.indexInSegment = this.indexInSegment;
            this.disposableHandleOrSegment = null;
            this.indexInSegment = -1;
            return;
        }
        SelectImplementation.state$volatile$FU.set(this, selectImplementation$ClauseData0);
    }

    public static void register$default(SelectImplementation selectImplementation0, ClauseData selectImplementation$ClauseData0, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
        }
        if((v & 1) != 0) {
            z = false;
        }
        selectImplementation0.register(selectImplementation$ClauseData0, z);
    }

    private final void reregisterClause(Object object0) {
        ClauseData selectImplementation$ClauseData0 = this.findClause(object0);
        q.d(selectImplementation$ClauseData0);
        selectImplementation$ClauseData0.disposableHandleOrSegment = null;
        selectImplementation$ClauseData0.indexInSegment = -1;
        this.register(selectImplementation$ClauseData0, true);
    }

    @Override  // kotlinx.coroutines.selects.SelectInstance
    public void selectInRegistrationPhase(@Nullable Object object0) {
        this.internalResult = object0;
    }

    @Override  // kotlinx.coroutines.selects.SelectInstance
    public boolean trySelect(@NotNull Object object0, @Nullable Object object1) {
        return this.trySelectInternal(object0, object1) == 0;
    }

    @NotNull
    public final TrySelectDetailedResult trySelectDetailed(@NotNull Object object0, @Nullable Object object1) {
        return SelectKt.TrySelectDetailedResult(this.trySelectInternal(object0, object1));
    }

    private final int trySelectInternal(Object object0, Object object1) {
    alab1:
        while(true) {
            Object object2 = SelectImplementation.state$volatile$FU.get(this);
            if(!(object2 instanceof CancellableContinuation)) {
                if(!q.b(object2, SelectKt.STATE_COMPLETED) && !(object2 instanceof ClauseData)) {
                    if(q.b(object2, SelectKt.STATE_CANCELLED)) {
                        return 2;
                    }
                    if(q.b(object2, SelectKt.STATE_REG)) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater1 = SelectImplementation.state$volatile$FU;
                        List list0 = e.k.z(object0);
                        while(true) {
                            if(atomicReferenceFieldUpdater1.compareAndSet(this, object2, list0)) {
                                return 1;
                            }
                            if(atomicReferenceFieldUpdater1.get(this) == object2) {
                                continue;
                            }
                            continue alab1;
                        }
                    }
                    else {
                        if(!(object2 instanceof List)) {
                            throw new IllegalStateException(("Unexpected state: " + object2).toString());
                        }
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = SelectImplementation.state$volatile$FU;
                        ArrayList arrayList0 = p.z0(object0, ((Collection)object2));
                        do {
                            if(atomicReferenceFieldUpdater2.compareAndSet(this, object2, arrayList0)) {
                                return 1;
                            }
                        }
                        while(atomicReferenceFieldUpdater2.get(this) == object2);
                        continue;
                    }
                }
                break;
            }
            ClauseData selectImplementation$ClauseData0 = this.findClause(object0);
            if(selectImplementation$ClauseData0 != null) {
                o o0 = selectImplementation$ClauseData0.createOnCancellationAction(this, object1);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = SelectImplementation.state$volatile$FU;
                do {
                    if(atomicReferenceFieldUpdater0.compareAndSet(this, object2, selectImplementation$ClauseData0)) {
                        this.internalResult = object1;
                        if(SelectKt.tryResume(((CancellableContinuation)object2), o0)) {
                            return 0;
                        }
                        this.internalResult = SelectKt.NO_RESULT;
                        return 2;
                    }
                }
                while(atomicReferenceFieldUpdater0.get(this) == object2);
            }
        }
        return 3;
    }

    private final Object waitUntilSelected(Continuation continuation0) {
        H h0;
        Object object0;
        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(continuation0), 1);
        cancellableContinuationImpl0.initCancellability();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = SelectImplementation.state$volatile$FU;
        while(true) {
            object0 = atomicReferenceFieldUpdater0.get(this);
            h0 = H.a;
            if(object0 == SelectKt.STATE_REG) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater1 = SelectImplementation.state$volatile$FU;
                do {
                    if(atomicReferenceFieldUpdater1.compareAndSet(this, object0, cancellableContinuationImpl0)) {
                        CancellableContinuationKt.invokeOnCancellation(cancellableContinuationImpl0, this);
                        goto label_26;
                    }
                }
                while(atomicReferenceFieldUpdater1.get(this) == object0);
            }
            else {
                if(!(object0 instanceof List)) {
                    break;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = SelectImplementation.state$volatile$FU;
                Symbol symbol0 = SelectKt.STATE_REG;
                do {
                    if(atomicReferenceFieldUpdater2.compareAndSet(this, object0, symbol0)) {
                        for(Object object1: ((Iterable)object0)) {
                            this.reregisterClause(object1);
                        }
                        break;
                    }
                }
                while(atomicReferenceFieldUpdater2.get(this) == object0);
            }
        }
        if(!(object0 instanceof ClauseData)) {
            throw new IllegalStateException(("unexpected state: " + object0).toString());
        }
        cancellableContinuationImpl0.resume(h0, ((ClauseData)object0).createOnCancellationAction(this, this.internalResult));
    label_26:
        Object object2 = cancellableContinuationImpl0.getResult();
        return object2 == a.a ? object2 : h0;
    }
}

