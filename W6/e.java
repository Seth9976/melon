package W6;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import d5.l;

public final class e {
    public final l a;

    public e(AppMeasurementSdk appMeasurementSdk0, l l0) {
        this.a = l0;
        appMeasurementSdk0.registerOnMeasurementEventListener(new d(this));
    }
}

