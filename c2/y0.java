package c2;

import S1.d;
import android.os.Build.VERSION;
import android.view.View;
import java.util.Objects;

public class y0 {
    public final B0 a;
    public static final B0 b;

    static {
        o0 o00;
        int v = Build.VERSION.SDK_INT;
        if(v >= 34) {
            o00 = new q0();
        }
        else if(v >= 30) {
            o00 = new p0();
        }
        else if(v >= 29) {
            o00 = new o0();
        }
        else {
            o00 = new m0();
        }
        y0.b = o00.b().a.a().a.b().a.c();
    }

    public y0(B0 b00) {
        this.a = b00;
    }

    public B0 a() {
        return this.a;
    }

    public B0 b() {
        return this.a;
    }

    public B0 c() {
        return this.a;
    }

    public void d(View view0) {
    }

    public void e(B0 b00) {
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof y0 ? this.p() == ((y0)object0).p() && this.o() == ((y0)object0).o() && Objects.equals(this.l(), ((y0)object0).l()) && Objects.equals(this.j(), ((y0)object0).j()) && Objects.equals(this.f(), ((y0)object0).f()) : false;
    }

    public j f() {
        return null;
    }

    public d g(int v) {
        return d.e;
    }

    public d h(int v) {
        if((v & 8) != 0) {
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }
        return d.e;
    }

    @Override
    public int hashCode() {
        d d0 = this.l();
        d d1 = this.j();
        return Objects.hash(new Object[]{Boolean.valueOf(this.p()), Boolean.valueOf(this.o()), d0, d1, this.f()});
    }

    public d i() {
        return this.l();
    }

    public d j() {
        return d.e;
    }

    public d k() {
        return this.l();
    }

    public d l() {
        return d.e;
    }

    public d m() {
        return this.l();
    }

    public B0 n(int v, int v1, int v2, int v3) {
        return y0.b;
    }

    public boolean o() {
        return false;
    }

    public boolean p() {
        return false;
    }

    public boolean q(int v) {
        return true;
    }

    public void r(d[] arr_d) {
    }

    public void s(d d0) {
    }

    public void t(B0 b00) {
    }

    public void u(d d0) {
    }

    public void v(int v) {
    }
}

