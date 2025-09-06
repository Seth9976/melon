package Dd;

import com.melon.ui.I4;
import java.util.ArrayList;

public final class b2 implements I4 {
    public final String a;
    public final ArrayList b;

    public b2(String s, ArrayList arrayList0) {
        this.a = s;
        this.b = arrayList0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof b2 && this.a.equals(((b2)object0).a) && this.b.equals(((b2)object0).b);
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "SnsListPopup(title=" + this.a + ", snsInfoList=" + this.b + ")";
    }
}

