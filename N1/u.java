package n1;

import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import kotlin.jvm.internal.q;

public final class u implements ComposeAnimation {
    public static final boolean a;

    static {
        ComposeAnimationType[] arr_composeAnimationType = ComposeAnimationType.values();
        boolean z = false;
        for(int v = 0; v < arr_composeAnimationType.length; ++v) {
            if(q.b(arr_composeAnimationType[v].name(), "UNSUPPORTED")) {
                z = true;
                break;
            }
        }
        u.a = z;
    }
}

