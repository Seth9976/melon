package kotlinx.coroutines;

import ie.d;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.LimitedDispatcher;
import kotlinx.coroutines.internal.LimitedDispatcherKt;
import me.a;
import me.b;
import me.e;
import me.f;
import me.g;
import me.h;
import me.i;
import me.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000E\u001A\u00020\u00002\u0006\u0010\u000B\u001A\u00020\n2\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u000E\u001A\u00020\u00002\u0006\u0010\u000B\u001A\u00020\nH\u0017¢\u0006\u0004\b\u000E\u0010\u0010J#\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0006\u001A\u00020\u00052\n\u0010\u0013\u001A\u00060\u0011j\u0002`\u0012H&¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0017\u001A\u00020\u00142\u0006\u0010\u0006\u001A\u00020\u00052\n\u0010\u0013\u001A\u00060\u0011j\u0002`\u0012H\u0017¢\u0006\u0004\b\u0017\u0010\u0016J\'\u0010\u001B\u001A\b\u0012\u0004\u0012\u00028\u00000\u0019\"\u0004\b\u0000\u0010\u00182\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u00028\u00000\u0019¢\u0006\u0004\b\u001B\u0010\u001CJ\u0019\u0010\u001D\u001A\u00020\u00142\n\u0010\u001A\u001A\u0006\u0012\u0002\b\u00030\u0019¢\u0006\u0004\b\u001D\u0010\u001EJ\u0018\u0010 \u001A\u00020\u00002\u0006\u0010\u001F\u001A\u00020\u0000H\u0087\u0002¢\u0006\u0004\b \u0010!J\u000F\u0010\"\u001A\u00020\fH\u0016¢\u0006\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher;", "Lme/a;", "Lme/f;", "<init>", "()V", "Lme/i;", "context", "", "isDispatchNeeded", "(Lme/i;)Z", "", "parallelism", "", "name", "limitedParallelism", "(ILjava/lang/String;)Lkotlinx/coroutines/CoroutineDispatcher;", "(I)Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lie/H;", "dispatch", "(Lme/i;Ljava/lang/Runnable;)V", "dispatchYield", "T", "Lkotlin/coroutines/Continuation;", "continuation", "interceptContinuation", "(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "releaseInterceptedContinuation", "(Lkotlin/coroutines/Continuation;)V", "other", "plus", "(Lkotlinx/coroutines/CoroutineDispatcher;)Lkotlinx/coroutines/CoroutineDispatcher;", "toString", "()Ljava/lang/String;", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public abstract class CoroutineDispatcher extends a implements f {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher$Key;", "Lme/b;", "Lme/f;", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public static final class Key extends b {
        private Key() {
            Wf.a a0 = new Wf.a(0);
            super(e.a, a0);
        }

        public Key(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        // 去混淆评级： 低(20)
        private static final CoroutineDispatcher _init_$lambda$0(g g0) {
            return g0 instanceof CoroutineDispatcher ? ((CoroutineDispatcher)g0) : null;
        }

        public static CoroutineDispatcher a(g g0) {
            return Key._init_$lambda$0(g0);
        }
    }

    @NotNull
    public static final Key Key;

    static {
        CoroutineDispatcher.Key = new Key(null);
    }

    public CoroutineDispatcher() {
        super(e.a);
    }

    public abstract void dispatch(@NotNull i arg1, @NotNull Runnable arg2);

    public void dispatchYield(@NotNull i i0, @NotNull Runnable runnable0) {
        DispatchedContinuationKt.safeDispatch(this, i0, runnable0);
    }

    @Override  // me.a, me.i
    @Nullable
    public g get(@NotNull h h0) {
        q.g(h0, "key");
        if(h0 instanceof b) {
            if(((b)h0).isSubKey$kotlin_stdlib(this.getKey())) {
                g g0 = ((b)h0).tryCast$kotlin_stdlib(this);
                return g0 == null ? null : g0;
            }
        }
        else if(e.a == h0) {
            return this;
        }
        return null;
    }

    @Override  // me.f
    @NotNull
    public final Continuation interceptContinuation(@NotNull Continuation continuation0) {
        return new DispatchedContinuation(this, continuation0);
    }

    public boolean isDispatchNeeded(@NotNull i i0) {
        return true;
    }

    @d
    public CoroutineDispatcher limitedParallelism(int v) {
        return this.limitedParallelism(v, null);
    }

    @NotNull
    public CoroutineDispatcher limitedParallelism(int v, @Nullable String s) {
        LimitedDispatcherKt.checkParallelism(v);
        return new LimitedDispatcher(this, v, s);
    }

    public static CoroutineDispatcher limitedParallelism$default(CoroutineDispatcher coroutineDispatcher0, int v, String s, int v1, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: limitedParallelism");
        }
        if((v1 & 2) != 0) {
            s = null;
        }
        return coroutineDispatcher0.limitedParallelism(v, s);
    }

    @Override  // me.a, me.i
    @NotNull
    public i minusKey(@NotNull h h0) {
        q.g(h0, "key");
        if(h0 instanceof b) {
            if(((b)h0).isSubKey$kotlin_stdlib(this.getKey()) && ((b)h0).tryCast$kotlin_stdlib(this) != null) {
                return j.a;
            }
        }
        else if(e.a == h0) {
            return j.a;
        }
        return this;
    }

    @d
    @NotNull
    public final CoroutineDispatcher plus(@NotNull CoroutineDispatcher coroutineDispatcher0) {
        return coroutineDispatcher0;
    }

    @Override  // me.f
    public final void releaseInterceptedContinuation(@NotNull Continuation continuation0) {
        q.e(continuation0, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((DispatchedContinuation)continuation0).release$kotlinx_coroutines_core();
    }

    @Override
    @NotNull
    public String toString() [...] // 潜在的解密器
}

