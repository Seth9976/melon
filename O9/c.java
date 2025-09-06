package o9;

import H4.a;
import androidx.room.B;
import com.iloen.melon.utils.log.LogU;
import k8.Y;
import kotlin.jvm.internal.q;

public final class c extends B {
    @Override  // androidx.room.B
    public final void onCreate(a a0) {
        q.g(a0, "db");
        Y.t("onCreate() - version : ", a0.getVersion(), LogU.Companion, "PremiumDatabase");
    }

    @Override  // androidx.room.B
    public final void onOpen(a a0) {
        q.g(a0, "db");
        Y.t("onOpen() - version : ", a0.getVersion(), LogU.Companion, "PremiumDatabase");
    }
}

