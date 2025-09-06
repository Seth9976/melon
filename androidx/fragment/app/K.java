package androidx.fragment.app;

import android.util.Log;
import kotlin.jvm.internal.q;

public final class k implements Runnable {
    public final int a;
    public final L0 b;
    public final n c;

    public k(L0 l00, n n0, int v) {
        this.a = v;
        this.b = l00;
        this.c = n0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            L0 l00 = this.b;
            q.g(l00, "$operation");
            n n0 = this.c;
            q.g(n0, "this$0");
            if(l0.P(2)) {
                Log.v("FragmentManager", "Transition for operation " + l00 + " has completed");
            }
            l00.c(n0);
            return;
        }
        L0 l01 = this.b;
        q.g(l01, "$operation");
        n n1 = this.c;
        q.g(n1, "this$0");
        if(l0.P(2)) {
            Log.v("FragmentManager", "Transition for operation " + l01 + " has completed");
        }
        l01.c(n1);
    }
}

