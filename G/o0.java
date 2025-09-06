package G;

import androidx.compose.runtime.I0;
import androidx.compose.runtime.M0;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.Z;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.b1;
import androidx.compose.runtime.w;
import java.util.Map;
import kotlin.jvm.internal.q;
import p0.p;

public final class o0 implements b1 {
    public final y0 a;
    public final b0 b;
    public final b0 c;
    public final b0 d;
    public final b0 e;
    public final Z f;
    public boolean g;
    public final b0 h;
    public u i;
    public final M0 j;
    public boolean k;
    public final a0 l;
    public final t0 m;

    public o0(t0 t00, Object object0, u u0, y0 y00) {
        this.m = t00;
        this.a = y00;
        b0 b00 = w.s(object0);
        this.b = b00;
        Object object1 = null;
        b0 b01 = w.s(f.q(0.0f, 7, null));
        this.c = b01;
        this.d = w.s(new j0(((D)((O0)b01).getValue()), y00, object0, ((O0)b00).getValue(), u0));
        this.e = w.s(Boolean.TRUE);
        this.f = w.o(-1.0f);
        this.h = w.s(object0);
        this.i = u0;
        this.j = w.q(this.a().e());
        Float float0 = (Float)((Map)J0.a).get(y00);
        if(float0 != null) {
            float f = float0.floatValue();
            u u1 = (u)y00.a.invoke(object0);
            int v = u1.b();
            for(int v1 = 0; v1 < v; ++v1) {
                u1.e(f, v1);
            }
            object1 = this.a.b.invoke(u1);
        }
        this.l = f.q(0.0f, 3, object1);
    }

    public final j0 a() {
        return (j0)((O0)this.d).getValue();
    }

    public final float b() {
        return ((I0)this.f).m();
    }

    public final void e() {
        if(this.b() == -1.0f) {
            this.k = true;
            j0 j00 = this.a();
            j0 j01 = this.a();
            boolean z = q.b(j00.c, j01.d);
            b0 b00 = this.h;
            if(z) {
                ((O0)b00).setValue(this.a().c);
                return;
            }
            ((O0)b00).setValue(this.a().g(0L));
            this.i = this.a().c(0L);
        }
    }

    public final void f(Object object0, boolean z) {
        t0 t00 = this.m;
        b0 b00 = t00.h;
        O0 o00 = (O0)this.b;
        boolean z1 = q.b(null, o00.getValue());
        M0 m00 = this.j;
        b0 b01 = this.d;
        D d0 = this.l;
        if(z1) {
            u u0 = this.i.c();
            ((O0)b01).setValue(new j0(d0, this.a, object0, object0, u0));
            this.g = true;
            m00.n(this.a().e());
            return;
        }
        b0 b02 = this.c;
        if(!z || this.k) {
            d0 = (D)((O0)b02).getValue();
        }
        else if(((D)((O0)b02).getValue()) instanceof a0) {
            d0 = (D)((O0)b02).getValue();
        }
        D d1 = t00.e() <= 0L ? d0 : new G.b0(d0, t00.e());
        Object object1 = o00.getValue();
        ((O0)b01).setValue(new j0(d1, this.a, object0, object1, this.i));
        m00.n(this.a().e());
        this.g = false;
        ((O0)b00).setValue(Boolean.TRUE);
        if(t00.g()) {
            p p0 = t00.i;
            int v1 = p0.size();
            long v2 = 0L;
            for(int v = 0; v < v1; ++v) {
                o0 o01 = (o0)p0.get(v);
                v2 = Math.max(v2, o01.j.m());
                o01.e();
            }
            ((O0)b00).setValue(Boolean.FALSE);
        }
    }

    public final void g(Object object0, Object object1, D d0) {
        ((O0)this.b).setValue(object1);
        ((O0)this.c).setValue(d0);
        if(q.b(this.a().d, object0) && q.b(this.a().c, object1)) {
            return;
        }
        this.f(object0, false);
    }

    @Override  // androidx.compose.runtime.b1
    public final Object getValue() {
        return ((O0)this.h).getValue();
    }

    public final void i(Object object0, D d0) {
        if(!this.g || !q.b(object0, null)) {
            b0 b00 = this.b;
            if(!q.b(((O0)b00).getValue(), object0) || this.b() != -1.0f) {
                ((O0)b00).setValue(object0);
                ((O0)this.c).setValue(d0);
                int v = Float.compare(this.b(), -3.0f);
                b0 b01 = this.h;
                Object object1 = v == 0 ? object0 : ((O0)b01).getValue();
                b0 b02 = this.e;
                boolean z = true;
                this.f(object1, !((Boolean)((O0)b02).getValue()).booleanValue());
                if(Float.compare(this.b(), -3.0f) != 0) {
                    z = false;
                }
                ((O0)b02).setValue(Boolean.valueOf(z));
                if(this.b() >= 0.0f) {
                    long v1 = this.a().e();
                    ((O0)b01).setValue(this.a().g(((long)(this.b() * ((float)v1)))));
                }
                else if(this.b() == -3.0f) {
                    ((O0)b01).setValue(object0);
                }
                this.g = false;
                ((I0)this.f).n(-1.0f);
            }
        }
    }

    @Override
    public final String toString() {
        return "current value: " + ((O0)this.h).getValue() + ", target: " + ((O0)this.b).getValue() + ", spec: " + ((D)((O0)this.c).getValue());
    }
}

