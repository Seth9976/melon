package b3;

import I6.V;
import I6.p0;

public final class w0 {
    public final V a;
    public static final w0 b;
    public static final String c;

    static {
        w0.b = new w0(p0.e);
        w0.c = "0";
    }

    public w0(p0 p00) {
        this.a = V.p(p00);
    }

    public final boolean a(int v) {
        for(int v1 = 0; true; ++v1) {
            V v2 = this.a;
            if(v1 >= v2.size()) {
                break;
            }
            v0 v00 = (v0)v2.get(v1);
            boolean[] arr_z = v00.e;
            for(int v3 = 0; v3 < arr_z.length; ++v3) {
                if(arr_z[v3]) {
                    if(v00.b.c != v) {
                        break;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return w0.class == class0 ? this.a.equals(((w0)object0).a) : false;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }
}

