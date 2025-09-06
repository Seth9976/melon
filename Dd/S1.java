package Dd;

import A7.d;
import Cc.P0;
import U4.x;
import com.melon.ui.K4;

public final class s1 implements K4 {
    public final String a;
    public final String b;
    public final String c;
    public final P0 d;

    public s1(String s, String s1, String s2, P0 p00) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = p00;
    }

    // 去混淆评级： 中等(50)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof s1 && this.a.equals(((s1)object0).a) && this.b.equals(((s1)object0).b) && this.c.equals(((s1)object0).c) && this.d.equals(((s1)object0).d);
    }

    @Override
    public final int hashCode() {
        return this.d.hashCode() + x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("MagazineItemUiState(imageUrl=", this.a, ", title=", this.b, ", date=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", action=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

