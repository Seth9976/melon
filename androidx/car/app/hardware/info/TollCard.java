package androidx.car.app.hardware.info;

import androidx.car.app.hardware.common.CarValue;
import java.util.Objects;
import u.g;

public final class TollCard {
    public static final int TOLLCARD_STATE_INVALID = 2;
    public static final int TOLLCARD_STATE_NOT_INSERTED = 3;
    public static final int TOLLCARD_STATE_UNKNOWN = 0;
    public static final int TOLLCARD_STATE_VALID = 1;
    private final CarValue mCardState;

    private TollCard() {
        this.mCardState = CarValue.UNKNOWN_INTEGER;
    }

    public TollCard(g g0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof TollCard ? Objects.equals(this.mCardState, ((TollCard)object0).mCardState) : false;
    }

    public CarValue getCardState() {
        Objects.requireNonNull(this.mCardState);
        return this.mCardState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mCardState});
    }

    @Override
    public String toString() {
        return "[ tollcard state: " + this.mCardState + "]";
    }
}

