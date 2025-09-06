package Ac;

import com.melon.ui.U0;
import kotlin.jvm.internal.q;

public final class j4 extends m4 {
    public final U0 a;

    public j4(U0 u00) {
        this.a = u00;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof j4 ? q.b(this.a, ((j4)object0).a) : false;
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

