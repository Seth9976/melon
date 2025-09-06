package b3;

import android.media.AudioManager;
import android.media.Spatializer;
import androidx.media3.session.p0;
import v3.i;

public abstract class c {
    public static Spatializer b(AudioManager audioManager0) {
        return audioManager0.getSpatializer();
    }

    public static void e(Spatializer spatializer0, p0 p00, i i0) {
        spatializer0.addOnSpatializerStateChangedListener(p00, i0);
    }

    public static void f(Spatializer spatializer0, i i0) {
        spatializer0.removeOnSpatializerStateChangedListener(i0);
    }
}

