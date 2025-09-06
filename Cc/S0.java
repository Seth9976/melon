package Cc;

import java.util.List;

public final class s0 {
    public final Object a;

    public s0(List list0) {
        this.a = list0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof s0 && this.a.equals(((s0)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "DetailButtonsUiState(buttonList=" + this.a + ")";
    }
}

