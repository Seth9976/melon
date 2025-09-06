package com.google.gson.internal.bind;

import T7.l;
import U4.x;
import W7.a;
import W7.c;
import com.google.gson.p;
import com.google.gson.s;
import com.google.gson.t;
import com.google.gson.v;
import e0.b;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;

public final class h extends a {
    public String[] B;
    public int[] D;
    public static final g E;
    public static final Object G;
    public Object[] r;
    public int w;

    static {
        h.E = new g();
        h.G = new Object();
    }

    @Override  // W7.a
    public final String A() {
        return this.p0(false);
    }

    @Override  // W7.a
    public final String C() {
        return this.p0(true);
    }

    @Override  // W7.a
    public final boolean E() {
        switch(this.Z()) {
            case 2: 
            case 4: 
            case 10: {
                return false;
            }
            default: {
                return true;
            }
        }
    }

    @Override  // W7.a
    public final boolean H() {
        this.o0(8);
        boolean z = ((v)this.t0()).e();
        int v = this.w;
        if(v > 0) {
            ++this.D[v - 1];
        }
        return z;
    }

    @Override  // W7.a
    public final double K() {
        int v = this.Z();
        if(v != 6 && v != 7) {
            throw new IllegalStateException("Expected NUMBER but was " + x.B(v) + this.q0());
        }
        double f = ((v)this.s0()).f();
        if(this.o != 1 && (Double.isNaN(f) || Double.isInfinite(f))) {
            throw new c("JSON forbids NaN and infinities: " + f);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
        this.t0();
        int v1 = this.w;
        if(v1 > 0) {
            ++this.D[v1 - 1];
        }
        return f;
    }

    @Override  // W7.a
    public final int M() {
        int v = this.Z();
        if(v != 6 && v != 7) {
            throw new IllegalStateException("Expected NUMBER but was " + x.B(v) + this.q0());
        }
        v v1 = (v)this.s0();
        int v2 = v1.a instanceof Number ? v1.g().intValue() : Integer.parseInt(v1.b());
        this.t0();
        int v3 = this.w;
        if(v3 > 0) {
            ++this.D[v3 - 1];
        }
        return v2;
    }

    @Override  // W7.a
    public final long N() {
        int v = this.Z();
        if(v != 6 && v != 7) {
            throw new IllegalStateException("Expected NUMBER but was " + x.B(v) + this.q0());
        }
        v v1 = (v)this.s0();
        long v2 = v1.a instanceof Number ? v1.g().longValue() : Long.parseLong(v1.b());
        this.t0();
        int v3 = this.w;
        if(v3 > 0) {
            ++this.D[v3 - 1];
        }
        return v2;
    }

    @Override  // W7.a
    public final String P() {
        return this.r0(false);
    }

    @Override  // W7.a
    public final void T() {
        this.o0(9);
        this.t0();
        int v = this.w;
        if(v > 0) {
            ++this.D[v - 1];
        }
    }

    @Override  // W7.a
    public final String W() {
        int v = this.Z();
        if(v != 6 && v != 7) {
            throw new IllegalStateException("Expected STRING but was " + x.B(v) + this.q0());
        }
        String s = ((v)this.t0()).b();
        int v1 = this.w;
        if(v1 > 0) {
            ++this.D[v1 - 1];
        }
        return s;
    }

    @Override  // W7.a
    public final int Z() {
        if(this.w == 0) {
            return 10;
        }
        Object object0 = this.s0();
        if(object0 instanceof Iterator) {
            boolean z = this.r[this.w - 2] instanceof t;
            if(((Iterator)object0).hasNext()) {
                if(z) {
                    return 5;
                }
                Object object1 = ((Iterator)object0).next();
                this.u0(object1);
                return this.Z();
            }
            return z ? 4 : 2;
        }
        if(object0 instanceof t) {
            return 3;
        }
        if(object0 instanceof p) {
            return 1;
        }
        if(object0 instanceof v) {
            Serializable serializable0 = ((v)object0).a;
            if(serializable0 instanceof String) {
                return 6;
            }
            if(serializable0 instanceof Boolean) {
                return 8;
            }
            if(!(serializable0 instanceof Number)) {
                throw new AssertionError();
            }
            return 7;
        }
        if(object0 instanceof s) {
            return 9;
        }
        if(object0 != h.G) {
            throw new c("Custom JsonElement subclass " + object0.getClass().getName() + " is not supported");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
        throw new IllegalStateException("JsonReader is closed");
    }

    @Override  // W7.a
    public final void close() {
        this.r = new Object[]{h.G};
        this.w = 1;
    }

    @Override  // W7.a
    public final void h() {
        this.o0(1);
        this.u0(((p)this.s0()).a.iterator());
        this.D[this.w - 1] = 0;
    }

    @Override  // W7.a
    public final void i0() {
        switch(b.b(this.Z())) {
            case 1: {
                this.q();
                return;
            }
            case 3: {
                this.r();
                break;
            }
            case 4: {
                this.r0(true);
                return;
            label_6:
                this.t0();
                int v = this.w;
                if(v > 0) {
                    ++this.D[v - 1];
                    return;
                }
                break;
            }
            case 9: {
                break;
            }
            default: {
                goto label_6;
            }
        }
    }

    @Override  // W7.a
    public final void m() {
        this.o0(3);
        this.u0(((l)((t)this.s0()).a.entrySet()).iterator());
    }

    public final void o0(int v) {
        if(this.Z() != v) {
            throw new IllegalStateException("Expected " + x.B(v) + " but was " + x.B(this.Z()) + this.q0());
        }
    }

    public final String p0(boolean z) {
        StringBuilder stringBuilder0 = new StringBuilder("$");
        for(int v = 0; true; ++v) {
            int v1 = this.w;
            if(v >= v1) {
                break;
            }
            Object[] arr_object = this.r;
            Object object0 = arr_object[v];
            if(object0 instanceof p) {
                ++v;
                if(v < v1 && arr_object[v] instanceof Iterator) {
                    int v2 = this.D[v];
                    if(z && v2 > 0 && (v == v1 - 1 || v == v1 - 2)) {
                        --v2;
                    }
                    stringBuilder0.append('[');
                    stringBuilder0.append(v2);
                    stringBuilder0.append(']');
                }
            }
            else if(object0 instanceof t) {
                ++v;
                if(v < v1 && arr_object[v] instanceof Iterator) {
                    stringBuilder0.append('.');
                    String s = this.B[v];
                    if(s != null) {
                        stringBuilder0.append(s);
                    }
                }
            }
        }
        return stringBuilder0.toString();
    }

    @Override  // W7.a
    public final void q() {
        this.o0(2);
        this.t0();
        this.t0();
        int v = this.w;
        if(v > 0) {
            ++this.D[v - 1];
        }
    }

    public final String q0() {
        return " at path " + this.p0(false);
    }

    @Override  // W7.a
    public final void r() {
        this.o0(4);
        this.B[this.w - 1] = null;
        this.t0();
        this.t0();
        int v = this.w;
        if(v > 0) {
            ++this.D[v - 1];
        }
    }

    public final String r0(boolean z) {
        this.o0(5);
        Object object0 = ((Iterator)this.s0()).next();
        String s = (String)((Map.Entry)object0).getKey();
        this.B[this.w - 1] = z ? "<skipped>" : s;
        this.u0(((Map.Entry)object0).getValue());
        return s;
    }

    public final Object s0() {
        return this.r[this.w - 1];
    }

    public final Object t0() {
        Object[] arr_object = this.r;
        int v = this.w - 1;
        this.w = v;
        Object object0 = arr_object[v];
        arr_object[v] = null;
        return object0;
    }

    // 去混淆评级： 低(20)
    @Override  // W7.a
    public final String toString() {
        return "h" + this.q0();
    }

    public final void u0(Object object0) {
        int v = this.w;
        Object[] arr_object = this.r;
        if(v == arr_object.length) {
            this.r = Arrays.copyOf(arr_object, v * 2);
            this.D = Arrays.copyOf(this.D, v * 2);
            this.B = (String[])Arrays.copyOf(this.B, v * 2);
        }
        int v1 = this.w;
        this.w = v1 + 1;
        this.r[v1] = object0;
    }
}

