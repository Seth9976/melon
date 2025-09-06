package b3;

import e3.b;
import java.util.Arrays;

public final class v0 {
    public final int a;
    public final q0 b;
    public final boolean c;
    public final int[] d;
    public final boolean[] e;
    public static final String f;
    public static final String g;
    public static final String h;
    public static final String i;

    static {
        v0.f = "0";
        v0.g = "1";
        v0.h = "3";
        v0.i = "4";
    }

    public v0(q0 q00, boolean z, int[] arr_v, boolean[] arr_z) {
        this.a = q00.a;
        boolean z1 = false;
        b.c(q00.a == arr_v.length && q00.a == arr_z.length);
        this.b = q00;
        if(z && q00.a > 1) {
            z1 = true;
        }
        this.c = z1;
        this.d = (int[])arr_v.clone();
        this.e = (boolean[])arr_z.clone();
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return v0.class == class0 && this.c == ((v0)object0).c && this.b.equals(((v0)object0).b) && Arrays.equals(this.d, ((v0)object0).d) && Arrays.equals(this.e, ((v0)object0).e);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = Arrays.hashCode(this.d);
        return Arrays.hashCode(this.e) + (v + (this.b.hashCode() * 0x1F + this.c) * 0x1F) * 0x1F;
    }
}

