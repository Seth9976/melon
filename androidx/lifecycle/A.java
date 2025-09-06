package androidx.lifecycle;

import android.app.Application;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

public abstract class a extends m0 {
    @NotNull
    private final Application application;

    public a(Application application0) {
        this.application = application0;
    }

    @NotNull
    public Application getApplication() {
        q.e(this.application, "null cannot be cast to non-null type T of androidx.lifecycle.AndroidViewModel.getApplication");
        return this.application;
    }
}

