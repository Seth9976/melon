package Lc;

import com.melon.ui.K4;

public final class s implements K4 {
    public final boolean a;

    public s(boolean z) {
        this.a = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof s ? this.a == ((s)object0).a : false;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return "PendingTitleUiState(isSuspend=" + this.a + ")";
    }
}

