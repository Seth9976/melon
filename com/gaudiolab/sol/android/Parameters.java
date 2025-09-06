package com.gaudiolab.sol.android;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Parameters implements Serializable {
    public float eleqVolume;
    public float environmentOffset;
    public int equalizerBandCount;
    public float[] equalizerBandGainDb;
    public float equalizerGlobalGainDb;
    public boolean equalizerLoudnessEnabled;
    public boolean isEnable;
    public LoudnessType loudnessType;
    public byte[] metadata;
    public int metadataLength;
    public Set preferenceFeatures;
    public float reverbIntensity;
    public float targetLoudness;
    public SpatialUpmixGenre upmixGenre;
    public float volumeGain;

    public Parameters() {
        this.isEnable = false;
        this.preferenceFeatures = new HashSet();
        this.loudnessType = LoudnessType.kOff;
        this.targetLoudness = 0.0f;
        this.environmentOffset = 0.0f;
        this.equalizerBandCount = 10;
        float[] arr_f = new float[10];
        this.equalizerBandGainDb = arr_f;
        Arrays.fill(arr_f, 0.0f);
        this.equalizerGlobalGainDb = 0.0f;
        this.equalizerLoudnessEnabled = true;
        this.eleqVolume = 0.0f;
        this.volumeGain = 0.0f;
        this.upmixGenre = SpatialUpmixGenre.kOff;
        this.reverbIntensity = 0.0f;
        this.metadata = null;
        this.metadataLength = 0;
    }
}

