package Vc;

import Hd.F0;
import com.melon.ui.K4;
import java.util.List;

public final class s0 implements K4 {
    public final Object a;
    public final F0 b;

    public s0(List list0, F0 f00) {
        this.a = list0;
        this.b = f00;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof s0 && this.a.equals(((s0)object0).a) && this.b.equals(((s0)object0).b);
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "UserTasteSlotUiState(imageUrls=" + this.a + ", userEvent=" + this.b + ")";
    }
}

