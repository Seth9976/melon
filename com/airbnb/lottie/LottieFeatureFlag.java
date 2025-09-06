package com.airbnb.lottie;

public enum LottieFeatureFlag {
    MergePathsApi19(19);

    public final int minRequiredSdkVersion;

    private static LottieFeatureFlag[] $values() [...] // Inlined contents

    private LottieFeatureFlag(int v1) {
        this.minRequiredSdkVersion = v1;
    }
}

