package b3;

import android.net.Uri;

public final class r {
    public final Uri a;
    public static final String b;

    static {
        r.b = "0";
    }

    public r(M m0) {
        this.a = (Uri)m0.a;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof r ? this.a.equals(((r)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode() * 0x1F;
    }
}

