package Ic;

import Ac.m4;
import com.melon.ui.c3;

public final class r extends m4 {
    public final c3 a;

    public r(c3 c30) {
        this.a = c30;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof r && this.a.equals(((r)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Error(uiState=" + this.a + ")";
    }
}

