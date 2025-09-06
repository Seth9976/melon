package hd;

import com.melon.ui.U0;
import kotlin.jvm.internal.q;

public final class u1 extends x1 {
    public final U0 a;

    public u1(U0 u00) {
        this.a = u00;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof u1 ? q.b(this.a, ((u1)object0).a) : false;
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

