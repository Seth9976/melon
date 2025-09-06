package androidx.compose.runtime;

import org.jetbrains.annotations.NotNull;

public abstract class j0 {
    public static final void a(@NotNull String s) {
        throw new IllegalArgumentException(s);
    }

    public static final void b(@NotNull String s) {
        throw new IllegalStateException(s);
    }
}

