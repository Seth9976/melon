package Nc;

import kotlin.jvm.internal.q;

public final class e1 implements g1 {
    public final d1 a;

    public e1(d1 d10) {
        q.g(d10, "genreNewMusicUiState");
        super();
        this.a = d10;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof e1 ? q.b(this.a, ((e1)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OnClickItem(genreNewMusicUiState=" + this.a + ")";
    }
}

