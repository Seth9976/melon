package n1;

import G.e;
import G.o;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import e1.m;
import java.util.Set;
import je.n;
import kotlin.jvm.internal.q;

public final class a implements ComposeAnimation {
    public final r a;
    public final o b;
    public final e c;
    public final Set d;
    public static final boolean e;

    static {
        ComposeAnimationType[] arr_composeAnimationType = ComposeAnimationType.values();
        boolean z = false;
        for(int v = 0; v < arr_composeAnimationType.length; ++v) {
            if(q.b(arr_composeAnimationType[v].name(), "ANIMATE_X_AS_STATE")) {
                z = true;
                break;
            }
        }
        a.e = z;
    }

    public a(e e0, o o0, r r0) {
        this.a = r0;
        this.b = o0;
        this.c = e0;
        Object object0 = e0.d();
        q.e(object0, "null cannot be cast to non-null type kotlin.Any");
        Object[] arr_object = object0.getClass().getEnumConstants();
        this.d = arr_object == null ? m.E(object0) : n.A0(arr_object);
    }
}

