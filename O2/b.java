package o2;

import android.content.Context;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

public abstract class b {
    public static final boolean a(@NotNull Context context0, @NotNull String s) {
        q.g(context0, "context");
        q.g(s, "name");
        return context0.deleteSharedPreferences(s);
    }
}

