package e7;

import G1.f;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.util.Objects;

public final class h {
    public final f a;
    public final g b;

    public h(f f0, FileStore fileStore0) {
        this.a = f0;
        this.b = new g(fileStore0);
    }

    public final void a(String s) {
        g g0 = this.b;
        synchronized(g0) {
            if(!Objects.equals(g0.b, s)) {
                g.a(g0.a, s, g0.c);
                g0.b = s;
            }
        }
    }
}

