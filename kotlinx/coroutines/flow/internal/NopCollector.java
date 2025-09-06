package kotlinx.coroutines.flow.internal;

import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001A\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/flow/internal/NopCollector;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "<init>", "()V", "value", "Lie/H;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class NopCollector implements FlowCollector {
    @NotNull
    public static final NopCollector INSTANCE;

    static {
        NopCollector.INSTANCE = new NopCollector();
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(@Nullable Object object0, @NotNull Continuation continuation0) {
        return H.a;
    }
}

