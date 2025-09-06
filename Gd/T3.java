package gd;

import Ac.m4;
import com.iloen.melon.custom.l1;
import com.melon.ui.c3;

public final class t3 extends m4 {
    public final c3 a;

    public t3(c3 c30) {
        this.a = c30;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof t3 && this.a.equals(((t3)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return l1.k("Error(errorUiState=", this.a, ")");
    }
}

