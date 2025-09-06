package s3;

import I6.V;
import I6.p0;
import b3.q0;
import e3.b;

public final class g0 {
    public final int a;
    public final p0 b;
    public int c;
    public static final g0 d;
    public static final String e;

    static {
        g0.d = new g0(new q0[0]);
        g0.e = "0";
    }

    public g0(q0[] arr_q0) {
        p0 p00 = V.q(arr_q0);
        this.b = p00;
        this.a = arr_q0.length;
        for(int v = 0; v < p00.d; ++v) {
            for(int v1 = v + 1; v1 < p00.d; ++v1) {
                if(((q0)p00.get(v)).equals(p00.get(v1))) {
                    b.q("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
        }
    }

    public final q0 a(int v) {
        return (q0)this.b.get(v);
    }

    public final int b(q0 q00) {
        int v = this.b.indexOf(q00);
        return v < 0 ? -1 : v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 != null) {
                Class class0 = object0.getClass();
                return g0.class == class0 && this.a == ((g0)object0).a && this.b.equals(((g0)object0).b);
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        if(this.c == 0) {
            this.c = this.b.hashCode();
        }
        return this.c;
    }
}

