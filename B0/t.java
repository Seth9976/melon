package b0;

import A0.f;
import A0.i;
import G.I;
import androidx.compose.runtime.b1;
import ie.H;
import kotlin.jvm.internal.r;
import we.k;

public final class t extends r implements k {
    public final long f;
    public final i g;
    public final b1 h;
    public final b1 i;
    public final b1 j;
    public final b1 k;
    public final float l;
    public final long m;

    public t(long v, i i0, I i1, I i2, I i3, I i4, float f, long v1) {
        this.f = v;
        this.g = i0;
        this.h = i1;
        this.i = i2;
        this.j = i3;
        this.k = i4;
        this.l = f;
        this.m = v1;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        w.c(((f)object0), 0.0f, 360.0f, this.f, this.g);
        float f = ((Number)this.h.getValue()).floatValue();
        float f1 = Math.abs(((Number)this.i.getValue()).floatValue() - ((Number)this.j.getValue()).floatValue());
        float f2 = ((Number)this.k.getValue()).floatValue();
        w.c(((f)object0), ((Number)this.j.getValue()).floatValue() + (f2 + (f * 216.0f % 360.0f - 90.0f)) + (this.g.d == 0 ? 0.0f : this.l / (w.b / 2.0f) * 57.29578f / 2.0f), Math.max(f1, 0.1f), this.m, this.g);
        return H.a;
    }
}

