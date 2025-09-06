package com.gaudiolab.sol.android;

import java.io.Serializable;

class ConfigWrapper implements Serializable {
    public int format;
    public int numInputChannels;
    public int numOutputChannels;
    public int sampleRate;
    public int samplesPerBlock;

    public ConfigWrapper() {
        this.numInputChannels = 0;
        this.numOutputChannels = 0;
        this.sampleRate = 0;
        this.samplesPerBlock = 0;
        this.format = 0;
    }

    public ConfigWrapper(Configuration configuration0) {
        WrapperConverter.convert(configuration0, this);
    }
}

