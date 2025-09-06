package androidx.car.app.navigation.model;

import androidx.appcompat.app.o;
import androidx.car.app.model.CarText;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Trip {
    private final CarText mCurrentRoad;
    private final List mDestinationTravelEstimates;
    private final List mDestinations;
    private final boolean mIsLoading;
    private final List mStepTravelEstimates;
    private final List mSteps;

    private Trip() {
        this.mDestinations = Collections.EMPTY_LIST;
        this.mSteps = Collections.EMPTY_LIST;
        this.mDestinationTravelEstimates = Collections.EMPTY_LIST;
        this.mStepTravelEstimates = Collections.EMPTY_LIST;
        this.mCurrentRoad = null;
        this.mIsLoading = false;
    }

    public Trip(n n0) {
        throw null;
    }

    // 去混淆评级： 低(23)
    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Trip ? Objects.equals(this.mDestinations, ((Trip)object0).mDestinations) && Objects.equals(this.mSteps, ((Trip)object0).mSteps) && Objects.equals(this.mDestinationTravelEstimates, ((Trip)object0).mDestinationTravelEstimates) && Objects.equals(this.mStepTravelEstimates, ((Trip)object0).mStepTravelEstimates) && Objects.equals(this.mCurrentRoad, ((Trip)object0).mCurrentRoad) && Boolean.valueOf(this.mIsLoading).equals(Boolean.valueOf(((Trip)object0).mIsLoading)) : false;
    }

    public CarText getCurrentRoad() {
        return this.mCurrentRoad;
    }

    public List getDestinationTravelEstimates() {
        return this.mDestinationTravelEstimates == null ? Collections.EMPTY_LIST : this.mDestinationTravelEstimates;
    }

    public List getDestinations() {
        return this.mDestinations == null ? Collections.EMPTY_LIST : this.mDestinations;
    }

    public List getStepTravelEstimates() {
        return this.mStepTravelEstimates == null ? Collections.EMPTY_LIST : this.mStepTravelEstimates;
    }

    public List getSteps() {
        return this.mSteps == null ? Collections.EMPTY_LIST : this.mSteps;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mDestinations, this.mSteps, this.mDestinationTravelEstimates, this.mStepTravelEstimates, this.mCurrentRoad});
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("[ destinations : ");
        stringBuilder0.append(this.mDestinations.toString());
        stringBuilder0.append(", steps: ");
        stringBuilder0.append(this.mSteps.toString());
        stringBuilder0.append(", dest estimates: ");
        stringBuilder0.append(this.mDestinationTravelEstimates.toString());
        stringBuilder0.append(", step estimates: ");
        stringBuilder0.append(this.mStepTravelEstimates.toString());
        stringBuilder0.append(", road: ");
        stringBuilder0.append(CarText.toShortString(this.mCurrentRoad));
        stringBuilder0.append(", isLoading: ");
        return o.s(stringBuilder0, this.mIsLoading, "]");
    }
}

