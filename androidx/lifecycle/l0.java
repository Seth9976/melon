package androidx.lifecycle;

import android.os.Handler;

public final class l0 {
    public final F a;
    public final Handler b;
    public k0 c;

    public l0(LifecycleService lifecycleService0) {
        this.a = new F(lifecycleService0);
        this.b = new Handler();
    }

    public final void a(r r0) {
        k0 k00 = this.c;
        if(k00 != null) {
            k00.run();
        }
        k0 k01 = new k0(this.a, r0);
        this.c = k01;
        this.b.postAtFrontOfQueue(k01);
    }
}

