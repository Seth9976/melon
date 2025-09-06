package Nc;

import kotlin.jvm.internal.q;

public final class f1 implements g1 {
    public final d1 a;

    public f1(d1 d10) {
        q.g(d10, "genreNewMusicUiState");
        super();
        this.a = d10;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof f1 ? q.b(this.a, ((f1)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OnClickPlayButton(genreNewMusicUiState=" + this.a + ")";
    }
}

