package me;

import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

public abstract class b implements h {
    @NotNull
    private final k safeCast;
    @NotNull
    private final h topmostKey;

    public b(h h0, k k0) {
        q.g(h0, "baseKey");
        super();
        this.safeCast = k0;
        if(h0 instanceof b) {
            h0 = ((b)h0).topmostKey;
        }
        this.topmostKey = h0;
    }

    public final boolean isSubKey$kotlin_stdlib(@NotNull h h0) {
        q.g(h0, "key");
        return h0 == this || this.topmostKey == h0;
    }

    @Nullable
    public final g tryCast$kotlin_stdlib(@NotNull g g0) {
        q.g(g0, "element");
        return (g)this.safeCast.invoke(g0);
    }
}

