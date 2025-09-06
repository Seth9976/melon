package Q5;

import N5.d;
import U4.x;
import android.util.Base64;
import d5.m;
import java.util.Arrays;

public final class j {
    public final String a;
    public final byte[] b;
    public final d c;

    public j(String s, byte[] arr_b, d d0) {
        this.a = s;
        this.b = arr_b;
        this.c = d0;
    }

    public static m a() {
        m m0 = new m(5, false);
        m0.d = d.a;
        return m0;
    }

    public final j b(d d0) {
        m m0 = j.a();
        m0.w(this.a);
        if(d0 == null) {
            throw new NullPointerException("Null priority");
        }
        m0.d = d0;
        m0.c = this.b;
        return m0.e();
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return !(object0 instanceof j) || !this.a.equals(((j)object0).a) ? false : Arrays.equals(this.b, (((j)object0) instanceof j ? ((j)object0).b : ((j)object0).b)) && this.c.equals(((j)object0).c);
    }

    @Override
    public final int hashCode() {
        int v = Arrays.hashCode(this.b);
        return ((this.a.hashCode() ^ 1000003) * 1000003 ^ v) * 1000003 ^ this.c.hashCode();
    }

    @Override
    public final String toString() {
        String s = this.b == null ? "" : Base64.encodeToString(this.b, 2);
        StringBuilder stringBuilder0 = new StringBuilder("TransportContext(");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", ");
        return x.m(stringBuilder0, s, ")");
    }
}

