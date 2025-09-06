package androidx.media3.session;

import java.util.Arrays;

public final class i1 {
    public final boolean a;
    public final boolean b;
    public static final i1 c;
    public static final String d;
    public static final String e;

    static {
        i1.c = new i1(false, false);
        i1.d = "0";
        i1.e = "1";
    }

    public i1(boolean z, boolean z1) {
        this.a = z;
        this.b = z1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof i1 ? this.a == ((i1)object0).a && this.b == ((i1)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.a), Boolean.valueOf(this.b)});
    }
}

