package androidx.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class z extends j {
    @Override  // androidx.lifecycle.j
    public void onActivityCreated(@NotNull Activity activity0, @Nullable Bundle bundle0) {
        q.g(activity0, "activity");
        Z.b(activity0);
    }
}

