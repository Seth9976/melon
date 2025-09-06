package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import me.g;
import me.h;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J*\u0010\u000B\u001A\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\b*\u00020\u00072\f\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00000\tH\u0096\u0003¢\u0006\u0004\b\u000B\u0010\fJ>\u0010\u0012\u001A\u00028\u0000\"\n\b\u0000\u0010\u000E*\u0004\u0018\u00010\r2\u0006\u0010\u000F\u001A\u00028\u00002\u0018\u0010\u0011\u001A\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0010H\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0015\u001A\u00020\u00012\u0006\u0010\u0014\u001A\u00020\u0001H\u0096\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u001C\u0010\u0017\u001A\u00020\u00012\n\u0010\n\u001A\u0006\u0012\u0002\b\u00030\tH\u0096\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001A\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019¨\u0006\u001A"}, d2 = {"Lkotlinx/coroutines/flow/internal/DownstreamExceptionContext;", "Lme/i;", "", "e", "originalContext", "<init>", "(Ljava/lang/Throwable;Lme/i;)V", "Lme/g;", "E", "Lme/h;", "key", "get", "(Lme/h;)Lme/g;", "", "R", "initial", "Lkotlin/Function2;", "operation", "fold", "(Ljava/lang/Object;Lwe/n;)Ljava/lang/Object;", "context", "plus", "(Lme/i;)Lme/i;", "minusKey", "(Lme/h;)Lme/i;", "Ljava/lang/Throwable;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class DownstreamExceptionContext implements i {
    private final i $$delegate_0;
    @NotNull
    public final Throwable e;

    public DownstreamExceptionContext(@NotNull Throwable throwable0, @NotNull i i0) {
        this.$$delegate_0 = i0;
        this.e = throwable0;
    }

    @Override  // me.i
    public Object fold(Object object0, @NotNull n n0) {
        return this.$$delegate_0.fold(object0, n0);
    }

    @Override  // me.i
    @Nullable
    public g get(@NotNull h h0) {
        return this.$$delegate_0.get(h0);
    }

    @Override  // me.i
    @NotNull
    public i minusKey(@NotNull h h0) {
        return this.$$delegate_0.minusKey(h0);
    }

    @Override  // me.i
    @NotNull
    public i plus(@NotNull i i0) {
        return this.$$delegate_0.plus(i0);
    }
}

