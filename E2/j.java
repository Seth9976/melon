package E2;

import android.os.StrictMode.VmPolicy.Builder;
import org.jetbrains.annotations.NotNull;

public final class j {
    public static final j a;

    static {
        j.a = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @NotNull
    public final StrictMode.VmPolicy.Builder a(@NotNull StrictMode.VmPolicy.Builder strictMode$VmPolicy$Builder0) {
        return strictMode$VmPolicy$Builder0.permitUnsafeIntentLaunch();
    }
}

