package com.iloen.melon.utils.image;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t5.k;
import t5.s;
import w5.b;
import w5.d;
import w5.e;
import w5.f;
import w5.g;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001F\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u001A\u0010\u0010\u001A\u00020\u000F2\b\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/utils/image/CrossFadeTransitionIncludeCacheLoadFactory;", "Lw5/e;", "", "durationMillis", "<init>", "(I)V", "Lw5/g;", "target", "Lt5/k;", "result", "Lw5/f;", "create", "(Lw5/g;Lt5/k;)Lw5/f;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "b", "I", "getDurationMillis", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CrossFadeTransitionIncludeCacheLoadFactory implements e {
    public static final int $stable;
    public final int b;

    public CrossFadeTransitionIncludeCacheLoadFactory(int v) {
        this.b = v;
        if(v <= 0) {
            throw new IllegalArgumentException("durationMillis must be > 0.");
        }
    }

    @Override  // w5.e
    @NotNull
    public f create(@NotNull g g0, @NotNull k k0) {
        q.g(g0, "target");
        q.g(k0, "result");
        return !(k0 instanceof s) ? new d(g0, k0) : new b(g0, k0, this.b);
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 ? true : object0 instanceof CrossFadeTransitionIncludeCacheLoadFactory && this.b == ((CrossFadeTransitionIncludeCacheLoadFactory)object0).b;
    }

    public final int getDurationMillis() {
        return this.b;
    }

    @Override
    public int hashCode() {
        return this.b * 0x1F;
    }
}

