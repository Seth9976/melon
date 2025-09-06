package v3;

import android.media.Spatializer.OnSpatializerStateChangedListener;
import android.media.Spatializer;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;

public final class i implements Spatializer.OnSpatializerStateChangedListener {
    public final DefaultTrackSelector a;

    public i(DefaultTrackSelector defaultTrackSelector0) {
        this.a = defaultTrackSelector0;
    }

    @Override  // android.media.Spatializer$OnSpatializerStateChangedListener
    public final void onSpatializerAvailableChanged(Spatializer spatializer0, boolean z) {
        this.a.e();
    }

    @Override  // android.media.Spatializer$OnSpatializerStateChangedListener
    public final void onSpatializerEnabledChanged(Spatializer spatializer0, boolean z) {
        this.a.e();
    }
}

