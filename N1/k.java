package n1;

import G.L;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import e1.m;
import java.util.Set;
import kotlin.jvm.internal.q;

public final class k implements ComposeAnimation {
    public final L a;
    public final Set b;
    public static final boolean c;

    static {
        ComposeAnimationType[] arr_composeAnimationType = ComposeAnimationType.values();
        boolean z = false;
        for(int v = 0; v < arr_composeAnimationType.length; ++v) {
            if(q.b(arr_composeAnimationType[v].name(), "INFINITE_TRANSITION")) {
                z = true;
                break;
            }
        }
        k.c = z;
    }

    public k(L l0) {
        this.a = l0;
        this.b = m.E(0);
    }
}

