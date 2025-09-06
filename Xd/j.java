package xd;

import com.melon.ui.V0;
import kotlin.jvm.internal.q;

public final class j extends l {
    public final V0 a;

    public j(V0 v00) {
        this.a = v00;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof j ? q.b(this.a, ((j)object0).a) : false;
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

