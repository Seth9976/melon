package ed;

import com.melon.ui.I4;
import kotlin.jvm.internal.q;

public final class d implements I4 {
    public final String a;

    public d(String s) {
        q.g(s, "genreCode");
        super();
        this.a = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof d ? q.b(this.a, ((d)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "GenreClickUiEvent(genreCode=" + this.a + ")";
    }
}

