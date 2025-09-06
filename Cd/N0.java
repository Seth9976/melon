package cd;

import kotlin.jvm.internal.q;

public final class n0 implements p0 {
    public final j0 a;

    public n0(j0 j00) {
        q.g(j00, "flexibleMusicWaveItemUiState");
        super();
        this.a = j00;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof n0 ? q.b(this.a, ((n0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "OnItemClick(flexibleMusicWaveItemUiState=" + this.a + ")";
    }
}

