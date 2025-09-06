package androidx.car.app.navigation.model;

import androidx.car.app.model.CarIcon;
import androidx.car.app.model.CarText;
import androidx.car.app.utils.g;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import v.b;

public final class Step {
    private final CarText mCue;
    private final List mLanes;
    private final CarIcon mLanesImage;
    private final Maneuver mManeuver;
    private final CarText mRoad;

    private Step() {
        this.mManeuver = null;
        this.mLanes = Collections.EMPTY_LIST;
        this.mLanesImage = null;
        this.mCue = null;
        this.mRoad = null;
    }

    public Step(Maneuver maneuver0, List list0, CarIcon carIcon0, CarText carText0, CarText carText1) {
        this.mManeuver = maneuver0;
        this.mLanes = g.g(list0);
        b.b.a(carIcon0);
        this.mLanesImage = carIcon0;
        this.mCue = carText0;
        this.mRoad = carText1;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof Step ? Objects.equals(this.mManeuver, ((Step)object0).mManeuver) && Objects.equals(this.mLanes, ((Step)object0).mLanes) && Objects.equals(this.mLanesImage, ((Step)object0).mLanesImage) && Objects.equals(this.mCue, ((Step)object0).mCue) && Objects.equals(this.mRoad, ((Step)object0).mRoad) : false;
    }

    public CarText getCue() {
        return this.mCue;
    }

    public List getLanes() {
        return this.mLanes == null ? Collections.EMPTY_LIST : this.mLanes;
    }

    public CarIcon getLanesImage() {
        return this.mLanesImage;
    }

    public Maneuver getManeuver() {
        return this.mManeuver;
    }

    public CarText getRoad() {
        return this.mRoad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mManeuver, this.mLanes, this.mLanesImage, this.mCue, this.mRoad});
    }

    @Override
    public String toString() {
        return "[maneuver: " + this.mManeuver + ", lane count: " + (this.mLanes == null ? 0 : this.mLanes.size()) + ", lanes image: " + this.mLanesImage + ", cue: " + CarText.toShortString(this.mCue) + ", road: " + CarText.toShortString(this.mRoad) + "]";
    }
}

