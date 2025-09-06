package f;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class b {
    public abstract Intent createIntent(Context arg1, Object arg2);

    @Nullable
    public a getSynchronousResult(@NotNull Context context0, Object object0) {
        q.g(context0, "context");
        return null;
    }

    public abstract Object parseResult(int arg1, Intent arg2);
}

