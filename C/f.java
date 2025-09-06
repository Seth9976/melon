package c;

import androidx.compose.runtime.b0;
import e.b;
import e.g;
import ie.H;

public final class f extends b {
    public final a a;
    public final b0 b;

    public f(a a0, b0 b00) {
        this.a = a0;
        this.b = b00;
    }

    @Override  // e.b
    public final f.b a() {
        return (f.b)this.b.getValue();
    }

    @Override  // e.b
    public final void b(Object object0) {
        H h0;
        g g0 = this.a.a;
        if(g0 == null) {
            h0 = null;
        }
        else {
            g0.b(object0);
            h0 = H.a;
        }
        if(h0 == null) {
            throw new IllegalStateException("Launcher has not been initialized");
        }
    }

    @Override  // e.b
    public final void c() {
        throw new UnsupportedOperationException("Registration is automatically handled by rememberLauncherForActivityResult");
    }
}

