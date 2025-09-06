package androidx.car.app.model.signin;

import androidx.car.app.model.CarText;
import java.util.Objects;
import w.c;

public final class PinSignInMethod implements c {
    private static final int MAX_PIN_LENGTH = 12;
    private final CarText mPinCode;

    private PinSignInMethod() {
        this.mPinCode = null;
    }

    public PinSignInMethod(CharSequence charSequence0) {
        Objects.requireNonNull(charSequence0);
        int v = charSequence0.length();
        if(v == 0) {
            throw new IllegalArgumentException("PIN must not be empty");
        }
        if(v > 12) {
            throw new IllegalArgumentException("PIN must not be longer than 12 characters");
        }
        this.mPinCode = CarText.create(charSequence0);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof PinSignInMethod ? Objects.equals(this.mPinCode, ((PinSignInMethod)object0).mPinCode) : false;
    }

    public CarText getPinCode() {
        Objects.requireNonNull(this.mPinCode);
        return this.mPinCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mPinCode});
    }
}

