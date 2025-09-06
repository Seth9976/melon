package d0;

import ie.H;
import kotlin.jvm.internal.r;
import we.k;
import x0.e;
import y0.N;
import y0.Q;

public final class f extends r implements k {
    public final q f;
    public final boolean g;
    public final float h;
    public final float i;
    public final Q j;

    public f(q q0, boolean z, float f, float f1, Q q1) {
        this.f = q0;
        this.g = z;
        this.h = f;
        this.i = f1;
        this.j = q1;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        float f = 0.0f;
        boolean z = Float.compare(((Number)((s)this.f).a.d()).floatValue(), 0.0f) > 0 || this.g;
        ((N)object0).I(((Number)((s)this.f).a.d()).floatValue() * ((float)((N)object0).z(this.h)) - e.b(((N)object0).B));
        if(z) {
            f = ((N)object0).D.b() * this.i;
        }
        ((N)object0).y(f);
        ((N)object0).A(this.j);
        ((N)object0).f(true);
        return H.a;
    }
}

