package cd;

import kotlin.jvm.internal.q;

public final class f0 implements g0 {
    public final d0 a;

    public f0(d0 d00) {
        this.a = d00;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof f0 ? q.b(this.a, ((f0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OnItemShown(flexibleMusicWaveItemUiState=" + this.a + ")";
    }
}

