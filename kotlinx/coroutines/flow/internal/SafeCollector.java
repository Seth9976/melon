package kotlinx.coroutines.flow.internal;

import Tf.p;
import Uc.a;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowCollector;
import me.g;
import me.i;
import me.j;
import oe.c;
import oe.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u00032\u00020\u0004B\u001D\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\b\u0010\tJ\'\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\u0006\u0010\r\u001A\u00028\u0000H\u0002\u00A2\u0006\u0004\b\u000F\u0010\u0010J)\u0010\u0013\u001A\u00020\u000B2\u0006\u0010\u0011\u001A\u00020\u00062\b\u0010\u0012\u001A\u0004\u0018\u00010\u00062\u0006\u0010\r\u001A\u00028\u0000H\u0002\u00A2\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001A\u00020\u000B2\u0006\u0010\u0016\u001A\u00020\u00152\b\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0002\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001A\u001A\u0004\u0018\u00010\u0019H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u001F\u0010\u001E\u001A\u00020\u000E2\u000E\u0010\u001D\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000E0\u001CH\u0014\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u000F\u0010 \u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b \u0010!J\u0018\u0010\u000F\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00028\u0000H\u0096@\u00A2\u0006\u0004\b\u000F\u0010\"R\u001A\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0081\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u0010#R\u0014\u0010\u0007\u001A\u00020\u00068\u0000X\u0081\u0004\u00A2\u0006\u0006\n\u0004\b\u0007\u0010$R\u0014\u0010&\u001A\u00020%8\u0000X\u0081\u0004\u00A2\u0006\u0006\n\u0004\b&\u0010\'R\u0018\u0010(\u001A\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b(\u0010$R\u001E\u0010)\u001A\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\n8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001A\u0004\u0018\u00010\u00048VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b+\u0010,R\u0014\u00100\u001A\u00020\u00068VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b.\u0010/\u00A8\u00061"}, d2 = {"Lkotlinx/coroutines/flow/internal/SafeCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "Loe/c;", "Loe/d;", "collector", "Lme/i;", "collectContext", "<init>", "(Lkotlinx/coroutines/flow/FlowCollector;Lme/i;)V", "Lkotlin/coroutines/Continuation;", "Lie/H;", "uCont", "value", "", "emit", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)Ljava/lang/Object;", "currentContext", "previousContext", "checkContext", "(Lme/i;Lme/i;Ljava/lang/Object;)V", "Lkotlinx/coroutines/flow/internal/DownstreamExceptionContext;", "exception", "exceptionTransparencyViolated", "(Lkotlinx/coroutines/flow/internal/DownstreamExceptionContext;Ljava/lang/Object;)V", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "Lie/p;", "result", "invokeSuspend", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "()V", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lme/i;", "", "collectContextSize", "I", "lastEmissionContext", "completion_", "Lkotlin/coroutines/Continuation;", "getCallerFrame", "()Loe/d;", "callerFrame", "getContext", "()Lme/i;", "context", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class SafeCollector extends c implements FlowCollector {
    @NotNull
    public final i collectContext;
    public final int collectContextSize;
    @NotNull
    public final FlowCollector collector;
    @Nullable
    private Continuation completion_;
    @Nullable
    private i lastEmissionContext;

    public SafeCollector(@NotNull FlowCollector flowCollector0, @NotNull i i0) {
        super(NoOpContinuation.INSTANCE, j.a);
        this.collector = flowCollector0;
        this.collectContext = i0;
        this.collectContextSize = ((Number)i0.fold(0, new a(5))).intValue();
    }

    private final void checkContext(i i0, i i1, Object object0) {
        if(i1 instanceof DownstreamExceptionContext) {
            this.exceptionTransparencyViolated(((DownstreamExceptionContext)i1), object0);
        }
        SafeCollector_commonKt.checkContext(this, i0);
    }

    private static final int collectContextSize$lambda$0(int v, g g0) [...] // Inlined contents

    public static int d(int v, g g0) {
        return v + 1;
    }

    private final Object emit(Continuation continuation0, Object object0) {
        i i0 = continuation0.getContext();
        JobKt.ensureActive(i0);
        i i1 = this.lastEmissionContext;
        if(i1 != i0) {
            this.checkContext(i0, i1, object0);
            this.lastEmissionContext = i0;
        }
        this.completion_ = continuation0;
        q.e(this.collector, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        Object object1 = SafeCollectorKt.access$getEmitFun$p().invoke(this.collector, object0, this);
        if(!q.b(object1, ne.a.a)) {
            this.completion_ = null;
        }
        return object1;
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(Object object0, @NotNull Continuation continuation0) {
        ne.a a0;
        Object object1;
        try {
            object1 = this.emit(continuation0, object0);
            a0 = ne.a.a;
        }
        catch(Throwable throwable0) {
            this.lastEmissionContext = new DownstreamExceptionContext(throwable0, continuation0.getContext());
            throw throwable0;
        }
        if(object1 == a0) {
            q.g(continuation0, "frame");
        }
        return object1 == a0 ? object1 : H.a;
    }

    private final void exceptionTransparencyViolated(DownstreamExceptionContext downstreamExceptionContext0, Object object0) {
        throw new IllegalStateException(p.c0(("\n            Flow exception transparency is violated:\n                Previous \'emit\' call has thrown exception " + downstreamExceptionContext0.e + ", but then emission attempt of value \'" + object0 + "\' has been detected.\n                Emissions from \'catch\' blocks are prohibited in order to avoid unspecified behaviour, \'Flow.catch\' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ")).toString());
    }

    // 去混淆评级： 低(20)
    @Override  // oe.a
    @Nullable
    public d getCallerFrame() {
        return this.completion_ instanceof d ? ((d)this.completion_) : null;
    }

    @Override  // oe.c
    @NotNull
    public i getContext() {
        i i0 = this.lastEmissionContext;
        return i0 == null ? j.a : i0;
    }

    @Override  // oe.a
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override  // oe.a
    @NotNull
    public Object invokeSuspend(@NotNull Object object0) {
        Throwable throwable0 = ie.p.a(object0);
        if(throwable0 != null) {
            this.lastEmissionContext = new DownstreamExceptionContext(throwable0, this.getContext());
        }
        Continuation continuation0 = this.completion_;
        if(continuation0 != null) {
            continuation0.resumeWith(object0);
        }
        return ne.a.a;
    }

    @Override  // oe.c
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}

