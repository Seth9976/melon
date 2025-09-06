package gd;

import Ac.m4;
import com.melon.ui.c3;

public final class j8 extends m4 {
    public final c3 a;

    public j8(c3 c30) {
        this.a = c30;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof j8 && this.a.equals(((j8)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Error(errorUiState=" + this.a + ")";
    }
}

