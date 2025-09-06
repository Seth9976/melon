package cd;

import kotlin.jvm.internal.q;

public final class c implements g {
    public final b a;

    public c(b b0) {
        q.g(b0, "chartItemUiState");
        super();
        this.a = b0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof c ? q.b(this.a, ((c)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OnAlbumClick(chartItemUiState=" + this.a + ")";
    }
}

