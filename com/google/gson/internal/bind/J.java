package com.google.gson.internal.bind;

import W7.b;
import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.s;
import com.google.gson.t;
import com.google.gson.v;
import com.iloen.melon.utils.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public final class j extends b {
    public static final i B;
    public static final v D;
    public final ArrayList o;
    public String r;
    public q w;

    static {
        j.B = new i();
        j.D = new v("closed");
    }

    public j() {
        super(j.B);
        this.o = new ArrayList();
        this.w = s.a;
    }

    @Override  // W7.b
    public final b B() {
        this.W(s.a);
        return this;
    }

    @Override  // W7.b
    public final void H(double f) {
        if(this.h != 1 && (Double.isNaN(f) || Double.isInfinite(f))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + f);
        }
        this.W(new v(f));
    }

    @Override  // W7.b
    public final void K(long v) {
        this.W(new v(v));
    }

    @Override  // W7.b
    public final void M(Boolean boolean0) {
        if(boolean0 == null) {
            this.W(s.a);
            return;
        }
        this.W(new v(boolean0));
    }

    @Override  // W7.b
    public final void N(Number number0) {
        if(number0 == null) {
            this.W(s.a);
            return;
        }
        if(this.h != 1) {
            double f = number0.doubleValue();
            if(Double.isNaN(f) || Double.isInfinite(f)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number0);
            }
        }
        this.W(new v(number0));
    }

    @Override  // W7.b
    public final void P(String s) {
        if(s == null) {
            this.W(s.a);
            return;
        }
        this.W(new v(s));
    }

    @Override  // W7.b
    public final void Q(boolean z) {
        this.W(new v(Boolean.valueOf(z)));
    }

    public final q V() {
        return (q)a.i(1, this.o);
    }

    public final void W(q q0) {
        if(this.r != null) {
            if(!(q0 instanceof s) || this.k) {
                ((t)this.V()).d(this.r, q0);
            }
            this.r = null;
            return;
        }
        if(this.o.isEmpty()) {
            this.w = q0;
            return;
        }
        q q1 = this.V();
        if(!(q1 instanceof p)) {
            throw new IllegalStateException();
        }
        ((p)q1).a.add(q0);
    }

    @Override  // W7.b
    public final void close() {
        ArrayList arrayList0 = this.o;
        if(!arrayList0.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        arrayList0.add(j.D);
    }

    @Override  // W7.b
    public final void flush() {
    }

    @Override  // W7.b
    public final void m() {
        p p0 = new p();
        this.W(p0);
        this.o.add(p0);
    }

    @Override  // W7.b
    public final void o() {
        t t0 = new t();
        this.W(t0);
        this.o.add(t0);
    }

    @Override  // W7.b
    public final void q() {
        ArrayList arrayList0 = this.o;
        if(arrayList0.isEmpty() || this.r != null || !(this.V() instanceof p)) {
            throw new IllegalStateException();
        }
        arrayList0.remove(arrayList0.size() - 1);
    }

    @Override  // W7.b
    public final void r() {
        ArrayList arrayList0 = this.o;
        if(arrayList0.isEmpty() || this.r != null || !(this.V() instanceof t)) {
            throw new IllegalStateException();
        }
        arrayList0.remove(arrayList0.size() - 1);
    }

    @Override  // W7.b
    public final void s(String s) {
        Objects.requireNonNull(s, "name == null");
        if(this.o.isEmpty() || this.r != null) {
            throw new IllegalStateException("Did not expect a name");
        }
        if(!(this.V() instanceof t)) {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        this.r = s;
    }
}

