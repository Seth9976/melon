package I;

import Ce.g;
import androidx.compose.foundation.lazy.layout.i;
import g0.e;
import ie.H;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.CancellableContinuation;

public final class a {
    public final e a;

    public a(int v) {
        if(v != 1) {
            super();
            this.a = new e(new h[16]);
            return;
        }
        super();
        this.a = new e(new i[16]);
    }

    public void a(CancellationException cancellationException0) {
        e e0 = this.a;
        int v = e0.c;
        CancellableContinuation[] arr_cancellableContinuation = new CancellableContinuation[v];
        for(int v2 = 0; v2 < v; ++v2) {
            arr_cancellableContinuation[v2] = ((h)e0.a[v2]).b;
        }
        for(int v1 = 0; v1 < v; ++v1) {
            arr_cancellableContinuation[v1].cancel(cancellationException0);
        }
        if(e0.c == 0) {
            return;
        }
        L.a.c("uncancelled requests present");
    }

    public void b() {
        e e0 = this.a;
        g g0 = P4.a.K(0, e0.c);
        int v = g0.a;
        int v1 = g0.b;
        if(v <= v1) {
            while(true) {
                ((h)e0.a[v]).b.resumeWith(H.a);
                if(v == v1) {
                    break;
                }
                ++v;
            }
        }
        e0.g();
    }
}

