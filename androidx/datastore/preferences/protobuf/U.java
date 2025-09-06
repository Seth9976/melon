package androidx.datastore.preferences.protobuf;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map.Entry;

public final class u {
    public final g0 a;
    public boolean b;
    public static final int c;

    static {
        new u(0);
    }

    public u() {
        this.a = new g0();
    }

    public u(int v) {
        g0 g00 = new g0();
        super();
        this.a = g00;
        this.a();
        this.a();
    }

    public final void a() {
        if(this.b) {
            return;
        }
        g0 g00 = this.a;
        int v = g00.a.size();
        for(int v1 = 0; v1 < v; ++v1) {
            Map.Entry map$Entry0 = g00.c(v1);
            if(map$Entry0.getValue() instanceof A) {
                A a0 = (A)map$Entry0.getValue();
                a0.getClass();
                b0.c.getClass();
                Class class0 = a0.getClass();
                b0.c.a(class0).b(a0);
                a0.g();
            }
        }
        if(!g00.c) {
            if(g00.a.size() > 0) {
                g00.c(0).getKey().getClass();
                throw new ClassCastException();
            }
            Iterator iterator0 = g00.d().iterator();
            if(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                ((Map.Entry)object0).getKey().getClass();
                throw new ClassCastException();
            }
        }
        if(!g00.c) {
            g00.b = g00.b.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(g00.b);
            g00.e = g00.e.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(g00.e);
            g00.c = true;
        }
        this.b = true;
    }

    public static void b(o o0, z0 z00, int v, Object object0) {
        if(z00 == z0.d) {
            o0.H0(v, 3);
            ((A)(((a)object0))).k(o0);
            o0.H0(v, 4);
            return;
        }
        o0.H0(v, z00.b);
        switch(z00.ordinal()) {
            case 0: {
                o0.B0(Double.doubleToRawLongBits(((double)(((Double)object0)))));
                return;
            }
            case 1: {
                o0.z0(Float.floatToRawIntBits(((float)(((Float)object0)))));
                return;
            }
            case 2: {
                o0.L0(((long)(((Long)object0))));
                return;
            }
            case 3: {
                o0.L0(((long)(((Long)object0))));
                return;
            }
            case 4: {
                o0.D0(((int)(((Integer)object0))));
                return;
            }
            case 5: {
                o0.B0(((long)(((Long)object0))));
                return;
            }
            case 6: {
                o0.z0(((int)(((Integer)object0))));
                return;
            }
            case 7: {
                o0.t0(((byte)((Boolean)object0).booleanValue()));
                return;
            }
            case 8: {
                if(object0 instanceof j) {
                    o0.x0(((j)object0));
                    return;
                }
                o0.G0(((String)object0));
                return;
            }
            case 9: {
                ((A)(((a)object0))).k(o0);
                return;
            }
            case 10: {
                o0.getClass();
                o0.J0(((A)(((a)object0))).a(null));
                ((A)(((a)object0))).k(o0);
                return;
            }
            case 11: {
                if(object0 instanceof j) {
                    o0.x0(((j)object0));
                    return;
                }
                o0.J0(((byte[])object0).length);
                o0.u0(((byte[])object0), 0, ((byte[])object0).length);
                return;
            }
            case 12: {
                o0.J0(((int)(((Integer)object0))));
                return;
            }
            case 13: {
                o0.D0(((int)(((Integer)object0))));
                return;
            }
            case 14: {
                o0.z0(((int)(((Integer)object0))));
                return;
            }
            case 15: {
                o0.B0(((long)(((Long)object0))));
                return;
            }
            case 16: {
                int v1 = (int)(((Integer)object0));
                o0.J0(v1 >> 0x1F ^ v1 << 1);
                return;
            }
            case 17: {
                long v2 = (long)(((Long)object0));
                o0.L0(v2 >> 0x3F ^ v2 << 1);
            }
        }
    }

    @Override
    public final Object clone() {
        u u0 = new u();
        g0 g00 = this.a;
        if(g00.a.size() <= 0) {
            Iterator iterator0 = g00.d().iterator();
            if(!iterator0.hasNext()) {
                return u0;
            }
            Object object0 = iterator0.next();
            if(((Map.Entry)object0).getKey() != null) {
                throw new ClassCastException();
            }
            ((Map.Entry)object0).getValue();
            throw null;
        }
        Map.Entry map$Entry0 = g00.c(0);
        if(map$Entry0.getKey() != null) {
            throw new ClassCastException();
        }
        map$Entry0.getValue();
        throw null;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof u ? this.a.equals(((u)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }
}

