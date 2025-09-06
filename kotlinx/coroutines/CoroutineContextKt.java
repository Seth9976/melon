package kotlinx.coroutines;

import Fd.h;
import Uc.a;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.H;
import me.e;
import me.g;
import me.i;
import me.j;
import oe.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\u001A\u001B\u0010\u0003\u001A\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001A\u001B\u0010\u0003\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0006\u001A\u0013\u0010\b\u001A\u00020\u0007*\u00020\u0001H\u0002¢\u0006\u0004\b\b\u0010\t\u001A\'\u0010\r\u001A\u00020\u00012\u0006\u0010\n\u001A\u00020\u00012\u0006\u0010\u000B\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000E\u001A/\u0010\u0013\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0012*\u0006\u0012\u0002\b\u00030\u000F2\u0006\u0010\u0002\u001A\u00020\u00012\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001A\u001A\u0010\u0016\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u0012*\u00020\u0015H\u0080\u0010¢\u0006\u0004\b\u0016\u0010\u0017\"\u001A\u0010\u001B\u001A\u0004\u0018\u00010\u0018*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001A¨\u0006\u001C"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lme/i;", "context", "newCoroutineContext", "(Lkotlinx/coroutines/CoroutineScope;Lme/i;)Lme/i;", "addedContext", "(Lme/i;Lme/i;)Lme/i;", "", "hasCopyableElements", "(Lme/i;)Z", "originalContext", "appendContext", "isNewCoroutine", "foldCopies", "(Lme/i;Lme/i;Z)Lme/i;", "Lkotlin/coroutines/Continuation;", "", "oldValue", "Lkotlinx/coroutines/UndispatchedCoroutine;", "updateUndispatchedCompletion", "(Lkotlin/coroutines/Continuation;Lme/i;Ljava/lang/Object;)Lkotlinx/coroutines/UndispatchedCoroutine;", "Loe/d;", "undispatchedCompletion", "(Loe/d;)Lkotlinx/coroutines/UndispatchedCoroutine;", "", "getCoroutineName", "(Lme/i;)Ljava/lang/String;", "coroutineName", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class CoroutineContextKt {
    public static i a(H h0, boolean z, i i0, g g0) {
        return CoroutineContextKt.foldCopies$lambda$1(h0, z, i0, g0);
    }

    public static i b(i i0, g g0) {
        return CoroutineContextKt.foldCopies$lambda$2(i0, g0);
    }

    public static boolean c(boolean z, g g0) {
        return CoroutineContextKt.hasCopyableElements$lambda$0(z, g0);
    }

    private static final i foldCopies(i i0, i i1, boolean z) {
        boolean z1 = CoroutineContextKt.hasCopyableElements(i0);
        boolean z2 = CoroutineContextKt.hasCopyableElements(i1);
        if(!z1 && !z2) {
            return i0.plus(i1);
        }
        H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
        h0.a = i1;
        h h1 = new h(h0, z);
        j j0 = j.a;
        i i2 = (i)i0.fold(j0, h1);
        if(z2) {
            h0.a = ((i)h0.a).fold(j0, new a(2));
        }
        return i2.plus(((i)h0.a));
    }

    private static final i foldCopies$lambda$1(H h0, boolean z, i i0, g g0) {
        return i0.plus(g0);
    }

    private static final i foldCopies$lambda$2(i i0, g g0) {
        return i0.plus(g0);
    }

    @Nullable
    public static final String getCoroutineName(@NotNull i i0) [...] // Inlined contents

    private static final boolean hasCopyableElements(i i0) {
        a a0 = new a(1);
        return ((Boolean)i0.fold(Boolean.FALSE, a0)).booleanValue();
    }

    private static final boolean hasCopyableElements$lambda$0(boolean z, g g0) {
        return z;
    }

    @NotNull
    public static final i newCoroutineContext(@NotNull CoroutineScope coroutineScope0, @NotNull i i0) {
        i i1 = CoroutineContextKt.foldCopies(coroutineScope0.getCoroutineContext(), i0, true);
        return i1 == Dispatchers.getDefault() || i1.get(e.a) != null ? i1 : i1.plus(Dispatchers.getDefault());
    }

    @NotNull
    public static final i newCoroutineContext(@NotNull i i0, @NotNull i i1) {
        return CoroutineContextKt.hasCopyableElements(i1) ? CoroutineContextKt.foldCopies(i0, i1, false) : i0.plus(i1);
    }

    @Nullable
    public static final UndispatchedCoroutine undispatchedCompletion(@NotNull d d0) {
        do {
            if(d0 instanceof DispatchedCoroutine) {
                return null;
            }
            d0 = d0.getCallerFrame();
            if(d0 == null) {
                return null;
            }
        }
        while(!(d0 instanceof UndispatchedCoroutine));
        return (UndispatchedCoroutine)d0;
    }

    @Nullable
    public static final UndispatchedCoroutine updateUndispatchedCompletion(@NotNull Continuation continuation0, @NotNull i i0, @Nullable Object object0) {
        if(!(continuation0 instanceof d)) {
            return null;
        }
        if(i0.get(UndispatchedMarker.INSTANCE) != null) {
            UndispatchedCoroutine undispatchedCoroutine0 = CoroutineContextKt.undispatchedCompletion(((d)continuation0));
            if(undispatchedCoroutine0 != null) {
                undispatchedCoroutine0.saveThreadContext(i0, object0);
            }
            return undispatchedCoroutine0;
        }
        return null;
    }
}

