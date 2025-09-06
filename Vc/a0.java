package Vc;

import A7.d;
import Oc.m;
import U4.x;
import com.melon.ui.K4;
import java.util.ArrayList;

public final class a0 implements K4 {
    public final String a;
    public final String b;
    public final boolean c;
    public final m d;
    public final ArrayList e;

    public a0(String s, String s1, boolean z, m m0, ArrayList arrayList0) {
        this.a = s;
        this.b = s1;
        this.c = z;
        this.d = m0;
        this.e = arrayList0;
    }

    // 去混淆评级： 中等(50)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof a0 && this.a.equals(((a0)object0).a) && this.b.equals(((a0)object0).b) && this.c == ((a0)object0).c && this.d.equals(((a0)object0).d) && this.e.equals(((a0)object0).e);
    }

    @Override
    public final int hashCode() {
        return this.e.hashCode() + (this.d.hashCode() + d.e(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c)) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("PersonalSlotUiState(title=", this.a, ", mainTitle=", this.b, ", isHighContrastMode=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", userEvent=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", itemUiStateList=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

