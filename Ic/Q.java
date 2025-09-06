package Ic;

import com.melon.ui.K4;

public final class q implements K4 {
    public final String a;

    public q(String s) {
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof q ? kotlin.jvm.internal.q.b(this.a, ((q)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "BookletUiState(imageUrl=" + this.a + ")";
    }
}

