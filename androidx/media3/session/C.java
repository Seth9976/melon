package androidx.media3.session;

import M6.B;
import M6.x;
import b3.N;
import com.google.firebase.messaging.u;
import java.lang.ref.WeakReference;

public final class c implements e {
    public final u a;
    public final w0 b;

    public c(u u0, w0 w00, N n0) {
        this.a = u0;
        this.b = w00;
    }

    @Override  // androidx.media3.session.e
    public final B run() {
        n0 n00 = (n0)((WeakReference)this.a.d).get();
        if(n00 != null) {
            n00.x(this.b);
        }
        return x.b;
    }
}

