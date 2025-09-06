package y8;

import com.gaudiolab.sol.android.Parameters;
import com.gaudiolab.sol.android.SolMusicOne.Feature;
import com.gaudiolab.sol.android.SolMusicOne.LoudnessType;
import com.gaudiolab.sol.android.SolMusicOne.SpatialUpmixGenre;
import java.util.Arrays;

public abstract class q {
    public static j a(int v) {
        j[] arr_j = r.b;
        for(int v1 = 0; v1 < arr_j.length; ++v1) {
            j j0 = arr_j[v1];
            if(j0.a == v) {
                return j0;
            }
        }
        return null;
    }

    public static void b(Parameters parameters0, p p0) {
        kotlin.jvm.internal.q.g(parameters0, "params");
        kotlin.jvm.internal.q.g(p0, "presetType");
        parameters0.preferenceFeatures.clear();
        Feature solMusicOne$Feature0 = Feature.kEqualizer;
        parameters0.preferenceFeatures.add(solMusicOne$Feature0);
        parameters0.preferenceFeatures.add(Feature.kLimiter);
        if(parameters0.loudnessType != LoudnessType.kOff) {
            parameters0.preferenceFeatures.add(Feature.kLoudness);
        }
        parameters0.upmixGenre = SpatialUpmixGenre.kOff;
        parameters0.reverbIntensity = 0.0f;
        parameters0.environmentOffset = 0.0f;
        parameters0.equalizerBandCount = 10;
        float[] arr_f = parameters0.equalizerBandGainDb;
        kotlin.jvm.internal.q.f(arr_f, "equalizerBandGainDb");
        Arrays.fill(arr_f, 0, arr_f.length, 0.0f);
        parameters0.equalizerGlobalGainDb = 0.0f;
        switch(p0.ordinal()) {
            case 2: {
                float[] arr_f1 = parameters0.equalizerBandGainDb;
                kotlin.jvm.internal.q.f(arr_f1, "equalizerBandGainDb");
                Arrays.fill(arr_f1, 0, arr_f1.length, 0.0f);
                return;
            }
            case 3: {
                parameters0.equalizerBandGainDb = new float[]{5.0f, 4.0f, 3.0f, 2.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                return;
            }
            case 4: {
                parameters0.equalizerBandGainDb = new float[]{-5.0f, -4.0f, -3.0f, -2.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                return;
            }
            case 5: {
                parameters0.equalizerBandGainDb = (float[])r.a.e.clone();
                return;
            }
            case 6: {
                parameters0.equalizerBandGainDb = new float[]{-1.0f, -1.0f, -1.0f, 2.0f, 4.0f, 4.0f, 3.0f, 1.0f, 0.0f, -1.0f};
                return;
            }
            case 7: {
                parameters0.equalizerBandGainDb = new float[]{-1.0f, -1.0f, 0.0f, 1.0f, 3.0f, 3.0f, 2.0f, 0.0f, -1.0f, -1.0f};
                return;
            }
            case 8: {
                parameters0.equalizerBandGainDb = new float[]{4.0f, 4.0f, 3.0f, 0.0f, 2.0f, 3.0f, 5.0f, 5.0f, 4.0f, 0.0f};
                return;
            }
            case 9: {
                parameters0.equalizerBandGainDb = new float[]{2.0f, 1.0f, 2.0f, -1.0f, -2.0f, 0.0f, -2.0f, 2.0f, 2.0f, 3.0f};
                return;
            }
            case 10: {
                parameters0.equalizerBandGainDb = new float[]{4.0f, 3.0f, 2.0f, 1.0f, 0.0f, -1.0f, 1.0f, 2.0f, 3.0f, 4.0f};
                return;
            }
            case 11: {
                parameters0.equalizerBandGainDb = new float[]{4.0f, 3.0f, 2.0f, 3.0f, -1.0f, -1.0f, 0.0f, 1.0f, 3.0f, 4.0f};
                return;
            }
            case 12: {
                parameters0.equalizerBandGainDb = new float[]{3.0f, 4.0f, 3.0f, 1.0f, -1.0f, -1.0f, 1.0f, 3.0f, 2.0f, 3.0f};
                return;
            }
            case 13: {
                parameters0.equalizerBandGainDb = new float[]{3.0f, 2.0f, 1.0f, 0.0f, -1.0f, -1.0f, -1.0f, 0.0f, 2.0f, 3.0f};
                return;
            }
            case 14: {
                parameters0.equalizerBandGainDb = new float[]{4.0f, 3.0f, 2.0f, 2.0f, -2.0f, 1.0f, 2.0f, 3.0f, 1.0f, 3.0f};
                return;
            }
            case 15: {
                parameters0.equalizerBandGainDb = new float[]{4.0f, 3.0f, 1.0f, 0.0f, -1.0f, 2.0f, 1.0f, 1.0f, 3.0f, 4.0f};
                return;
            }
            case 16: {
                parameters0.equalizerBandGainDb = new float[]{4.0f, 4.0f, 2.0f, 3.0f, 2.0f, -1.0f, -2.0f, 2.0f, 2.0f, 3.0f};
                return;
            }
            case 17: {
                parameters0.equalizerBandGainDb = new float[]{4.0f, 4.0f, 3.0f, 1.0f, -2.0f, -1.0f, 0.0f, 1.0f, 4.0f, 4.0f};
                return;
            }
            case 18: {
                parameters0.equalizerBandGainDb = new float[]{5.0f, 4.0f, 3.0f, 3.0f, -2.0f, -2.0f, 0.0f, 2.0f, 3.0f, 4.0f};
                return;
            }
            case 19: {
                parameters0.equalizerBandGainDb = new float[]{5.0f, 4.0f, 2.0f, 3.0f, -1.0f, -1.0f, 2.0f, 0.0f, 2.0f, 3.0f};
                return;
            }
            case 20: {
                parameters0.equalizerBandGainDb = new float[]{2.0f, 1.0f, 0.0f, 1.0f, 2.0f, 1.0f, 2.0f, 4.0f, 1.0f, 1.0f};
                return;
            }
            case 21: {
                parameters0.equalizerBandGainDb = new float[]{5.0f, 5.0f, 4.0f, 1.0f, 2.0f, 1.0f, 3.0f, 4.0f, 4.0f, 2.0f};
                return;
            }
            default: {
                parameters0.preferenceFeatures.remove(solMusicOne$Feature0);
            }
        }
    }
}

