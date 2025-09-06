package gd;

import Ac.m4;
import com.melon.ui.c3;

public final class s2 extends m4 {
    public final c3 a;

    public s2(c3 c30) {
        this.a = c30;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof s2 && this.a.equals(((s2)object0).a);
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

