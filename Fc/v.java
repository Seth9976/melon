package Fc;

import com.melon.ui.U0;
import kotlin.jvm.internal.q;

public final class v extends x {
    public final U0 a;

    public v(U0 u00) {
        this.a = u00;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof v ? q.b(this.a, ((v)object0).a) : false;
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

