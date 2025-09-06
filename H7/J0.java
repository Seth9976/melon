package h7;

import androidx.appcompat.app.o;

public final class j0 extends L0 {
    public final int a;
    public final String b;
    public final String c;
    public final boolean d;

    public j0(int v, String s, String s1, boolean z) {
        this.a = v;
        this.b = s;
        this.c = s1;
        this.d = z;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return object0 == this ? true : object0 instanceof L0 && this.a == ((j0)(((L0)object0))).a && this.b.equals(((j0)(((L0)object0))).b) && this.c.equals(((j0)(((L0)object0))).c) && this.d == ((j0)(((L0)object0))).d;
    }

    @Override
    public final int hashCode() {
        int v = (((this.a ^ 1000003) * 1000003 ^ this.b.hashCode()) * 1000003 ^ this.c.hashCode()) * 1000003;
        return this.d ? v ^ 0x4CF : v ^ 0x4D5;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("OperatingSystem{platform=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", version=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", buildVersion=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", jailbroken=");
        return o.s(stringBuilder0, this.d, "}");
    }
}

