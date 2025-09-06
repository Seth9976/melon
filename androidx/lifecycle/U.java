package androidx.lifecycle;

import Cc.j3;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;

public final class u {
    public final t a;
    public final s b;
    public final i c;
    public final j3 d;

    public u(t t0, s s0, i i0, Job job0) {
        q.g(i0, "dispatchQueue");
        super();
        this.a = t0;
        this.b = s0;
        this.c = i0;
        j3 j30 = new j3(1, this, job0);
        this.d = j30;
        if(t0.b() == s.a) {
            DefaultImpls.cancel$default(job0, null, 1, null);
            this.a();
            return;
        }
        t0.a(j30);
    }

    public final void a() {
        this.a.c(this.d);
        this.c.b = true;
        this.c.a();
    }
}

