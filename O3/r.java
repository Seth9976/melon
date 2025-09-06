package o3;

import U4.x;
import android.text.TextUtils;

public final class r {
    public final String a;
    public final boolean b;
    public final boolean c;

    public r(String s, boolean z, boolean z1) {
        this.a = s;
        this.b = z;
        this.c = z1;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 != null && object0.getClass() == r.class && TextUtils.equals(this.a, ((r)object0).a) && this.b == ((r)object0).b && this.c == ((r)object0).c;
    }

    @Override
    public final int hashCode() {
        int v = x.b(0x1F, 0x1F, this.a);
        int v1 = 0x4D5;
        int v2 = this.b ? 0x4CF : 0x4D5;
        if(this.c) {
            v1 = 0x4CF;
        }
        return (v + v2) * 0x1F + v1;
    }
}

