package n1;

import G.t0;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import java.util.Set;
import kotlin.jvm.internal.q;

public final class b implements ComposeAnimation, s {
    public final t0 a;
    public final Set b;
    public static final boolean c;

    static {
        ComposeAnimationType[] arr_composeAnimationType = ComposeAnimationType.values();
        boolean z = false;
        for(int v = 0; v < arr_composeAnimationType.length; ++v) {
            if(q.b(arr_composeAnimationType[v].name(), "ANIMATED_CONTENT")) {
                z = true;
                break;
            }
        }
        b.c = z;
    }

    public b(t0 t00, Set set0) {
        this.a = t00;
        this.b = set0;
    }

    @Override  // n1.s
    public final t0 a() {
        return this.a;
    }
}

