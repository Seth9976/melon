package xd;

import com.melon.ui.U0;
import kotlin.jvm.internal.q;

public final class i extends l {
    public final U0 a;

    public i(U0 u00) {
        this.a = u00;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof i ? q.b(this.a, ((i)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "Empty(emptyUiState=" + this.a + ")";
    }
}

