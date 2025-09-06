package com.gaudiolab.sol.android;

import java.io.Serializable;

public class Configuration implements Serializable {
    public Format format;
    public int numInputChannels;
    public int numOutputChannels;
    public int sampleRate;
    public int samplesPerBlock;

    public Configuration() {
        this.numInputChannels = 0;
        this.numOutputChannels = 0;
        this.sampleRate = 0;
        this.samplesPerBlock = 0;
        this.format = Format.kF32leI;
    }
}

