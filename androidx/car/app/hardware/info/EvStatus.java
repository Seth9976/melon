package androidx.car.app.hardware.info;

import androidx.car.app.hardware.common.CarValue;
import java.util.Objects;
import u.c;

public class EvStatus {
    private final CarValue mEvChargePortConnected;
    private final CarValue mEvChargePortOpen;

    private EvStatus() {
        this.mEvChargePortOpen = CarValue.UNKNOWN_BOOLEAN;
        this.mEvChargePortConnected = CarValue.UNKNOWN_BOOLEAN;
    }

    public EvStatus(c c0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof EvStatus ? Objects.equals(this.mEvChargePortConnected, ((EvStatus)object0).mEvChargePortConnected) && Objects.equals(this.mEvChargePortOpen, ((EvStatus)object0).mEvChargePortOpen) : false;
    }

    public CarValue getEvChargePortConnected() {
        Objects.requireNonNull(this.mEvChargePortConnected);
        return this.mEvChargePortConnected;
    }

    public CarValue getEvChargePortOpen() {
        Objects.requireNonNull(this.mEvChargePortOpen);
        return this.mEvChargePortOpen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mEvChargePortOpen, this.mEvChargePortConnected});
    }

    @Override
    public String toString() {
        return "[ EV charge port open: " + this.mEvChargePortOpen + ", EV charge port connected: " + this.mEvChargePortConnected + "]";
    }
}

