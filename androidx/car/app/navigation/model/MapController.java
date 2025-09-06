package androidx.car.app.navigation.model;

import androidx.car.app.model.ActionStrip;
import java.util.Objects;

public final class MapController {
    private final ActionStrip mMapActionStrip;
    private final g mPanModeDelegate;

    private MapController() {
        this.mPanModeDelegate = null;
        this.mMapActionStrip = null;
    }

    public MapController(b b0) {
        throw null;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof MapController ? Boolean.valueOf(this.mPanModeDelegate == null).equals(Boolean.valueOf(((MapController)object0).mPanModeDelegate == null)) && Objects.equals(this.mMapActionStrip, ((MapController)object0).mMapActionStrip) : false;
    }

    public ActionStrip getMapActionStrip() {
        return this.mMapActionStrip;
    }

    public g getPanModeDelegate() {
        return this.mPanModeDelegate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mPanModeDelegate, this.mMapActionStrip});
    }
}

