package Nc;

import kotlin.jvm.internal.q;

public final class q1 extends s1 {
    public final p1 a;

    public q1(p1 p10) {
        q.g(p10, "genrePlaylistUiState");
        super();
        this.a = p10;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof q1 ? q.b(this.a, ((q1)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OnClickItem(genrePlaylistUiState=" + this.a + ")";
    }
}

