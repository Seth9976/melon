package H0;

import android.view.KeyEvent;
import r0.p;
import we.k;

public final class g extends p implements f {
    public k a;
    public k b;

    @Override  // H0.f
    public final boolean A(KeyEvent keyEvent0) {
        return this.b == null ? false : ((Boolean)this.b.invoke(new d(keyEvent0))).booleanValue();
    }

    @Override  // H0.f
    public final boolean K(KeyEvent keyEvent0) {
        return this.a == null ? false : ((Boolean)this.a.invoke(new d(keyEvent0))).booleanValue();
    }
}

