package Z8;

import android.app.Application;
import androidx.lifecycle.a;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.billing.SingleLiveEvent;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

public final class k extends a {
    public final g a;
    public final SingleLiveEvent b;
    public final SingleLiveEvent c;

    public k(@NotNull Application application0) {
        q.g(application0, "application");
        super(application0);
        this.a = ((MelonAppBase)application0).getOneStoreIapLifecycle();
        this.b = new SingleLiveEvent();
        this.c = new SingleLiveEvent();
    }
}

