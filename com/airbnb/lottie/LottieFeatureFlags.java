package com.airbnb.lottie;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import com.airbnb.lottie.utils.Logger;
import java.util.HashSet;

class LottieFeatureFlags {
    private final HashSet enabledFlags;

    public LottieFeatureFlags() {
        this.enabledFlags = new HashSet();
    }

    @SuppressLint({"DefaultLocale"})
    public boolean enableFlag(LottieFeatureFlag lottieFeatureFlag0, boolean z) {
        if(z) {
            if(Build.VERSION.SDK_INT < lottieFeatureFlag0.minRequiredSdkVersion) {
                Logger.warning(String.format("%s is not supported pre SDK %d", lottieFeatureFlag0.name(), lottieFeatureFlag0.minRequiredSdkVersion));
                return false;
            }
            return this.enabledFlags.add(lottieFeatureFlag0);
        }
        return this.enabledFlags.remove(lottieFeatureFlag0);
    }

    public boolean isFlagEnabled(LottieFeatureFlag lottieFeatureFlag0) {
        return this.enabledFlags.contains(lottieFeatureFlag0);
    }
}

