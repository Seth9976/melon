package androidx.car.app.navigation.model;

import androidx.car.app.model.CarIcon;
import androidx.car.app.model.Distance;
import java.util.Objects;

public final class RoutingInfo implements f {
    private final Distance mCurrentDistance;
    private final Step mCurrentStep;
    private final boolean mIsLoading;
    private final CarIcon mJunctionImage;
    private final Step mNextStep;

    private RoutingInfo() {
        this.mCurrentStep = null;
        this.mCurrentDistance = null;
        this.mNextStep = null;
        this.mJunctionImage = null;
        this.mIsLoading = false;
    }

    public RoutingInfo(l l0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof RoutingInfo ? this.mIsLoading == ((RoutingInfo)object0).mIsLoading && Objects.equals(this.mCurrentStep, ((RoutingInfo)object0).mCurrentStep) && Objects.equals(this.mCurrentDistance, ((RoutingInfo)object0).mCurrentDistance) && Objects.equals(this.mNextStep, ((RoutingInfo)object0).mNextStep) && Objects.equals(this.mJunctionImage, ((RoutingInfo)object0).mJunctionImage) : false;
    }

    public Distance getCurrentDistance() {
        return this.mCurrentDistance;
    }

    public Step getCurrentStep() {
        return this.mCurrentStep;
    }

    public CarIcon getJunctionImage() {
        return this.mJunctionImage;
    }

    public Step getNextStep() {
        return this.mNextStep;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mCurrentStep, this.mCurrentDistance, this.mNextStep, this.mJunctionImage, Boolean.valueOf(this.mIsLoading)});
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    @Override
    public String toString() {
        return "RoutingInfo";
    }
}

