package androidx.fragment.app;

import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.B;
import androidx.lifecycle.D;
import androidx.lifecycle.r;
import androidx.lifecycle.t;
import java.util.Map;

public final class d0 implements B {
    public final String a;
    public final r0 b;
    public final t c;
    public final l0 d;

    public d0(l0 l00, String s, r0 r00, t t0) {
        this.d = l00;
        this.a = s;
        this.b = r00;
        this.c = t0;
    }

    @Override  // androidx.lifecycle.B
    public final void onStateChanged(D d0, r r0) {
        l0 l00 = this.d;
        Map map0 = l00.m;
        String s = this.a;
        if(r0 == r.ON_START) {
            Bundle bundle0 = (Bundle)map0.get(s);
            if(bundle0 != null) {
                this.b.b(bundle0, s);
                map0.remove(s);
                if(l0.P(2)) {
                    Log.v("FragmentManager", "Clearing fragment result with key " + s);
                }
            }
        }
        if(r0 == r.ON_DESTROY) {
            this.c.c(this);
            l00.n.remove(s);
        }
    }
}

