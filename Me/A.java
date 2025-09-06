package me;

import df.v;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

public abstract class a implements g {
    @NotNull
    private final h key;

    public a(h h0) {
        q.g(h0, "key");
        super();
        this.key = h0;
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
        return this.key;
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

