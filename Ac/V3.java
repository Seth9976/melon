package Ac;

import com.melon.ui.K4;
import java.util.List;

public final class v3 implements K4 {
    public final Object a;

    public v3(List list0) {
        this.a = list0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof v3 && this.a.equals(((v3)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "FilterUiState(filterList=" + this.a + ")";
    }
}

