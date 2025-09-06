package cd;

import A7.d;
import U4.x;
import com.melon.ui.K4;
import dd.z;

public final class a1 implements K4 {
    public final String a;
    public final String b;
    public final z c;

    public a1(String s, String s1, z z0) {
        this.a = s;
        this.b = s1;
        this.c = z0;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof a1 && this.a.equals(((a1)object0).a) && this.b.equals(((a1)object0).b) && this.c.equals(((a1)object0).c);
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + x.b(this.a.hashCode() * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("FooterSlotUiState(text1=", this.a, ", text2=", this.b, ", userEvent=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

