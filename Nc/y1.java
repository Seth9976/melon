package Nc;

import kotlin.jvm.internal.q;

public final class y1 implements B1 {
    public final v1 a;

    public y1(v1 v10) {
        q.g(v10, "genreSongUiState");
        super();
        this.a = v10;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof y1 ? q.b(this.a, ((y1)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OnClickPlayButton(genreSongUiState=" + this.a + ")";
    }
}

