package cd;

import kotlin.jvm.internal.q;

public final class e0 implements g0 {
    public final d0 a;

    public e0(d0 d00) {
        this.a = d00;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof e0 ? q.b(this.a, ((e0)object0).a) : false;
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

