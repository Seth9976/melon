package androidx.car.app.navigation.model;

import androidx.car.app.model.CarColor;
import androidx.car.app.model.CarIcon;
import androidx.car.app.model.CarText;
import androidx.car.app.model.DateTimeWithZone;
import androidx.car.app.model.Distance;
import java.util.Objects;

public final class TravelEstimate {
    public static final long REMAINING_TIME_UNKNOWN = -1L;
    private final DateTimeWithZone mArrivalTimeAtDestination;
    private final Distance mRemainingDistance;
    private final CarColor mRemainingDistanceColor;
    private final CarColor mRemainingTimeColor;
    private final long mRemainingTimeSeconds;
    private final CarIcon mTripIcon;
    private final CarText mTripText;

    private TravelEstimate() {
        this.mRemainingDistance = null;
        this.mRemainingTimeSeconds = 0L;
        this.mArrivalTimeAtDestination = null;
        this.mRemainingTimeColor = CarColor.DEFAULT;
        this.mRemainingDistanceColor = CarColor.DEFAULT;
        this.mTripText = null;
        this.mTripIcon = null;
    }

    public TravelEstimate(m m0) {
        throw null;
    }

    // 去混淆评级： 低(23)
    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof TravelEstimate ? Objects.equals(this.mRemainingDistance, ((TravelEstimate)object0).mRemainingDistance) && this.mRemainingTimeSeconds == ((TravelEstimate)object0).mRemainingTimeSeconds && Objects.equals(this.mArrivalTimeAtDestination, ((TravelEstimate)object0).mArrivalTimeAtDestination) && Objects.equals(this.mRemainingTimeColor, ((TravelEstimate)object0).mRemainingTimeColor) && Objects.equals(this.mRemainingDistanceColor, ((TravelEstimate)object0).mRemainingDistanceColor) && Objects.equals(this.mTripText, ((TravelEstimate)object0).mTripText) && Objects.equals(this.mTripIcon, ((TravelEstimate)object0).mTripIcon) : false;
    }

    public DateTimeWithZone getArrivalTimeAtDestination() {
        return this.mArrivalTimeAtDestination;
    }

    public Distance getRemainingDistance() {
        return this.mRemainingDistance;
    }

    public CarColor getRemainingDistanceColor() {
        return this.mRemainingDistanceColor;
    }

    public CarColor getRemainingTimeColor() {
        return this.mRemainingTimeColor;
    }

    public long getRemainingTimeSeconds() {
        return this.mRemainingTimeSeconds < 0L ? -1L : this.mRemainingTimeSeconds;
    }

    public CarIcon getTripIcon() {
        return this.mTripIcon;
    }

    public CarText getTripText() {
        return this.mTripText;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mRemainingDistance, this.mRemainingTimeSeconds, this.mArrivalTimeAtDestination, this.mRemainingTimeColor, this.mRemainingDistanceColor, this.mTripText, this.mTripIcon});
    }

    @Override
    public String toString() {
        return "[ remaining distance: " + this.mRemainingDistance + ", time (s): " + this.mRemainingTimeSeconds + ", ETA: " + this.mArrivalTimeAtDestination + "]";
    }
}

