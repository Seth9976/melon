package Lc;

import com.melon.ui.K4;

public final class q implements K4 {
    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof q)) {
            return false;
        }
        ((q)object0).getClass();
        return true;
    }

    @Override
    public final int hashCode() {
        return 0x4D5;
    }

    @Override
    public final String toString() {
        return "FailedTitleUiState(isSuspend=false)";
    }
}

