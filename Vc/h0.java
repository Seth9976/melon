package Vc;

import A7.d;
import Hd.F0;
import U4.x;

public final class h0 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final F0 g;

    public h0(String s, String s1, String s2, String s3, String s4, String s5, F0 f00) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
        this.f = s5;
        this.g = f00;
    }

    // 去混淆评级： 中等(80)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof h0 && this.a.equals(((h0)object0).a) && this.b.equals(((h0)object0).b) && this.c.equals(((h0)object0).c) && this.d.equals(((h0)object0).d) && this.e.equals(((h0)object0).e) && this.f.equals(((h0)object0).f) && this.g.equals(((h0)object0).g);
    }

    @Override
    public final int hashCode() {
        return this.g.hashCode() + x.b(x.b(x.b(x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e), 0x1F, this.f);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("QuickPickItemUiState(upperText1=", this.a, ", upperText2=", this.b, ", contsName=");
        d.u(stringBuilder0, this.c, ", contsTypeCode=", this.d, ", contsIds=");
        d.u(stringBuilder0, this.e, ", imgUrl=", this.f, ", userEvent=");
        stringBuilder0.append(this.g);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

