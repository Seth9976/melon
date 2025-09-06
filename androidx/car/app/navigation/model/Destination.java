package androidx.car.app.navigation.model;

import androidx.car.app.model.CarIcon;
import androidx.car.app.model.CarText;
import java.util.Objects;

public final class Destination {
    private final CarText mAddress;
    private final CarIcon mImage;
    private final CarText mName;

    private Destination() {
        this.mName = null;
        this.mAddress = null;
        this.mImage = null;
    }

    public Destination(a a0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Destination ? Objects.equals(this.mName, ((Destination)object0).mName) && Objects.equals(this.mAddress, ((Destination)object0).mAddress) && Objects.equals(this.mImage, ((Destination)object0).mImage) : false;
    }

    public CarText getAddress() {
        return this.mAddress;
    }

    public CarIcon getImage() {
        return this.mImage;
    }

    public CarText getName() {
        return this.mName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mName, this.mAddress, this.mImage});
    }

    @Override
    public String toString() {
        return "[name: " + CarText.toShortString(this.mName) + ", address: " + CarText.toShortString(this.mAddress) + ", image: " + this.mImage + "]";
    }
}

