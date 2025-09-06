package kotlinx.coroutines;

import df.v;
import kotlin.Metadata;
import me.g;
import me.h;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0007\u001A\u0006\u0012\u0002\b\u00030\u00028VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/UndispatchedMarker;", "Lme/g;", "Lme/h;", "<init>", "()V", "getKey", "()Lme/h;", "key", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class UndispatchedMarker implements g, h {
    @NotNull
    public static final UndispatchedMarker INSTANCE;

    static {
        UndispatchedMarker.INSTANCE = new UndispatchedMarker();
    }

    @Override  // me.i
    public Object fold(Object object0, @NotNull n n0) {
        return v.v(this, object0, n0);
    }

    @Override  // me.i
    @Nullable
    public g get(@NotNull h h0) {
        return v.w(this, h0);
    }

    @Override  // me.g
    @NotNull
    public h getKey() {
        return this;
    }

    @Override  // me.i
    @NotNull
    public i minusKey(@NotNull h h0) {
        return v.E(this, h0);
    }

    @Override  // me.i
    @NotNull
    public i plus(@NotNull i i0) {
        return v.F(i0, this);
    }
}

