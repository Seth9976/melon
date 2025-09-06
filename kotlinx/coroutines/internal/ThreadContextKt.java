package kotlinx.coroutines.internal;

import Uc.a;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.ThreadContextElement;
import me.g;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0017\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001A#\u0010\u0006\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001A\u00020\u00002\b\u0010\u0005\u001A\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001A!\u0010\n\u001A\u00020\t2\u0006\u0010\u0001\u001A\u00020\u00002\b\u0010\b\u001A\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\n\u0010\u000B\"\u0014\u0010\r\u001A\u00020\f8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000E\"*\u0010\u0011\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\"2\u0010\u0014\u001A \u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00130\u000F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012\"&\u0010\u0016\u001A\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u000F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012¨\u0006\u0017"}, d2 = {"Lme/i;", "context", "", "threadContextElements", "(Lme/i;)Ljava/lang/Object;", "countOrElement", "updateThreadContext", "(Lme/i;Ljava/lang/Object;)Ljava/lang/Object;", "oldState", "Lie/H;", "restoreThreadContext", "(Lme/i;Ljava/lang/Object;)V", "Lkotlinx/coroutines/internal/Symbol;", "NO_THREAD_ELEMENTS", "Lkotlinx/coroutines/internal/Symbol;", "Lkotlin/Function2;", "Lme/g;", "countAll", "Lwe/n;", "Lkotlinx/coroutines/ThreadContextElement;", "findOne", "Lkotlinx/coroutines/internal/ThreadState;", "updateState", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class ThreadContextKt {
    @NotNull
    public static final Symbol NO_THREAD_ELEMENTS;
    @NotNull
    private static final n countAll;
    @NotNull
    private static final n findOne;
    @NotNull
    private static final n updateState;

    static {
        ThreadContextKt.NO_THREAD_ELEMENTS = new Symbol("NO_THREAD_ELEMENTS");
        ThreadContextKt.countAll = new a(9);
        ThreadContextKt.findOne = new a(10);
        ThreadContextKt.updateState = new kotlinx.coroutines.internal.a();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static ThreadContextElement a(ThreadContextElement threadContextElement0, g g0) {
        return ThreadContextKt.findOne$lambda$1(threadContextElement0, g0);
    }

    public static Object b(Object object0, g g0) {
        return ThreadContextKt.countAll$lambda$0(object0, g0);
    }

    private static final Object countAll$lambda$0(Object object0, g g0) {
        if(g0 instanceof ThreadContextElement) {
            Integer integer0 = object0 instanceof Integer ? ((Integer)object0) : null;
            int v = integer0 == null ? 1 : ((int)integer0);
            return v == 0 ? g0 : ((int)(v + 1));
        }
        return object0;
    }

    private static final ThreadContextElement findOne$lambda$1(ThreadContextElement threadContextElement0, g g0) {
        if(threadContextElement0 != null) {
            return threadContextElement0;
        }
        return g0 instanceof ThreadContextElement ? ((ThreadContextElement)g0) : null;
    }

    public static final void restoreThreadContext(@NotNull i i0, @Nullable Object object0) {
        if(object0 == ThreadContextKt.NO_THREAD_ELEMENTS) {
            return;
        }
        if(object0 instanceof ThreadState) {
            ((ThreadState)object0).restore(i0);
            return;
        }
        Object object1 = i0.fold(null, ThreadContextKt.findOne);
        q.e(object1, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((ThreadContextElement)object1).restoreThreadContext(i0, object0);
    }

    @NotNull
    public static final Object threadContextElements(@NotNull i i0) {
        Object object0 = i0.fold(0, ThreadContextKt.countAll);
        q.d(object0);
        return object0;
    }

    private static final ThreadState updateState$lambda$2(ThreadState threadState0, g g0) {
        if(g0 instanceof ThreadContextElement) {
            threadState0.append(((ThreadContextElement)g0), ((ThreadContextElement)g0).updateThreadContext(threadState0.context));
        }
        return threadState0;
    }

    @Nullable
    public static final Object updateThreadContext(@NotNull i i0, @Nullable Object object0) {
        if(object0 == null) {
            object0 = ThreadContextKt.threadContextElements(i0);
        }
        if(object0 == 0) {
            return ThreadContextKt.NO_THREAD_ELEMENTS;
        }
        if(object0 instanceof Integer) {
            return i0.fold(new ThreadState(i0, ((Number)object0).intValue()), ThreadContextKt.updateState);
        }
        q.e(object0, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((ThreadContextElement)object0).updateThreadContext(i0);
    }
}

