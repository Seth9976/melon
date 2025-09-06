package Ac;

import com.melon.ui.c3;

public final class k0 extends n0 {
    public final c3 a;

    public k0(c3 c30) {
        this.a = c30;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof k0 && this.a.equals(((k0)object0).a);
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

