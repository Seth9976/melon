package com.iloen.melon.utils;

import df.v;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import me.g;
import me.h;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001A\u0010\u0003\u001A\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/utils/ReentrantMutexContextElement;", "Lme/g;", "Lcom/iloen/melon/utils/ReentrantMutexContextKey;", "key", "<init>", "(Lcom/iloen/melon/utils/ReentrantMutexContextKey;)V", "a", "Lcom/iloen/melon/utils/ReentrantMutexContextKey;", "getKey", "()Lcom/iloen/melon/utils/ReentrantMutexContextKey;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ReentrantMutexContextElement implements g {
    public static final int $stable = 8;
    public final ReentrantMutexContextKey a;

    public ReentrantMutexContextElement(@NotNull ReentrantMutexContextKey reentrantMutexContextKey0) {
        q.g(reentrantMutexContextKey0, "key");
        super();
        this.a = reentrantMutexContextKey0;
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

    @NotNull
    public ReentrantMutexContextKey getKey() {
        return this.a;
    }

    @Override  // me.g
    public h getKey() {
        return this.getKey();
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

