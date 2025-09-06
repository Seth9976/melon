package gd;

import Ac.m4;
import com.melon.ui.V0;
import kotlin.jvm.internal.q;

public final class f7 extends m4 {
    public final V0 a;

    public f7(V0 v00) {
        this.a = v00;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof f7 ? q.b(this.a, ((f7)object0).a) : false;
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

