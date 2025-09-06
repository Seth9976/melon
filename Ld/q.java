package ld;

import A7.d;
import Cc.U3;
import U4.x;
import java.util.List;

public final class q extends r {
    public final boolean a;
    public final int b;
    public final boolean c;
    public final boolean d;
    public final List e;
    public final U3 f;

    public q(boolean z, int v, boolean z1, boolean z2, List list0, U3 u30) {
        this.a = z;
        this.b = v;
        this.c = z1;
        this.d = z2;
        this.e = list0;
        this.f = u30;
    }

    public static q a(q q0, int v, boolean z, List list0, U3 u30, int v1) {
        boolean z1 = q0.a;
        if((v1 & 2) != 0) {
            v = q0.b;
        }
        boolean z2 = (v1 & 4) == 0 ? false : q0.c;
        if((v1 & 8) != 0) {
            z = q0.d;
        }
        if((v1 & 0x20) != 0) {
            u30 = q0.f;
        }
        return new q(z1, v, z2, z, list0, u30);
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof q && this.a == ((q)object0).a && this.b == ((q)object0).b && this.c == ((q)object0).c && this.d == ((q)object0).d && this.e.equals(((q)object0).e) && this.f.equals(((q)object0).f);
    }

    @Override
    public final int hashCode() {
        return this.f.hashCode() + d.d(d.e(d.e(d.b(this.b, Boolean.hashCode(this.a) * 0x1F, 0x1F), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Success(filterVisible=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", filterIndex=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", buttonVisible=");
        x.y(stringBuilder0, this.c, ", checkAll=", this.d, ", songUiStateList=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", toolBarUiState=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

