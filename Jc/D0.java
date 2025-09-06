package Jc;

import H0.b;
import U4.x;
import b3.Z;
import java.util.ArrayList;
import we.a;

public final class d0 extends e0 {
    public final boolean a;
    public final String b;
    public final ArrayList c;
    public final a d;

    public d0(boolean z, String s, ArrayList arrayList0, a a0) {
        this.a = z;
        this.b = s;
        this.c = arrayList0;
        this.d = a0;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof d0 && this.a == ((d0)object0).a && this.b.equals(((d0)object0).b) && this.c.equals(((d0)object0).c) && this.d.equals(((d0)object0).d);
    }

    @Override
    public final int hashCode() {
        return this.d.hashCode() + b.a(this.c, x.b(Boolean.hashCode(this.a) * 0x1F, 0x1F, this.b), 0x1F);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = Z.p("VideoUiState(isViewAll=", ", albumId=", this.b, ", videoList=", this.a);
        stringBuilder0.append(this.c);
        stringBuilder0.append(", clickViewAll=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

