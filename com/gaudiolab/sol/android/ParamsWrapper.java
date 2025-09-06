package com.gaudiolab.sol.android;

import java.io.Serializable;
import java.util.Arrays;

class ParamsWrapper implements Serializable {
    public float eleqVolume;
    public float environmentOffset;
    public int equalizerBandCount;
    public float[] equalizerBandGainDb;
    public float equalizerGlobalGainDb;
    public boolean equalizerLoudnessEnabled;
    public boolean isEnable;
    public int lcoType;
    public int lscType;
    public byte[] metadata;
    public int metadataLength;
    public int preferenceFeatures;
    public float reverbIntensity;
    public float targetLoudness;
    public int upmixGenre;
    public float volumeGain;

    public ParamsWrapper() {
        this.initialize();
    }

    public ParamsWrapper(Parameters parameters0) {
        this.initialize();
        WrapperConverter.convert(parameters0, this);
    }

    private void initialize() {
        this.isEnable = false;
        this.preferenceFeatures = 0;
        this.lscType = 0;
        this.lcoType = 0;
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
        this.upmixGenre = 0;
        this.reverbIntensity = 0.0f;
        this.metadata = null;
        this.metadataLength = 0;
    }
}

