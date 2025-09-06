package g1;

import org.jetbrains.annotations.NotNull;

public abstract class a {
    public static final void a(@NotNull String s) {
        throw new IllegalArgumentException(s);
    }

    @NotNull
    public static final Void b(@NotNull String s) {
        throw new IllegalArgumentException(s);
    }

    public static final void c(@NotNull String s) {
        throw new IllegalStateException(s);
    }
}

