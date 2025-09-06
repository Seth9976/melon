package com.gaudiolab.sol.android;

enum Feature {
    kEleq,
    kEqualizer,
    kSpatialUpmix,
    kSystemVolume,
    kLoudnessServerClient,
    kLoudnessClientOnly,
    kLimiter;

    private static Feature[] $values() [...] // Inlined contents

    public int mask() {
        return 1 << this.ordinal();
    }
}

