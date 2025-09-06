package cd;

import com.melon.ui.K4;
import java.util.ArrayList;

public final class c2 implements K4 {
    public final ArrayList a;

    public c2(ArrayList arrayList0) {
        this.a = arrayList0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof c2 && this.a.equals(((c2)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "StrategySlotUiState(itemUiStateList=" + this.a + ")";
    }
}

