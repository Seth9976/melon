package i.n.i.b.a.s.e;

import android.content.Context;

public final class jj implements C0 {
    public final Context a;
    public final C5 b;

    public jj(Context context0) {
        C5 c50 = new C5();
        c50.c = null;
        super();
        this.a = context0.getApplicationContext();
        this.b = c50;
    }

    @Override  // i.n.i.b.a.s.e.C0
    public final D0 a() {
        D5 d50 = this.b.b();
        return new D4(this.a, d50);
    }
}

