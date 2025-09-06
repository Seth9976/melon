package com.gaudiolab.sol.android;

import java.util.HashSet;
import java.util.Set;

public class SolMusicOne {
    public static enum Feature {
        kEleq,
        kEqualizer,
        kSpatialUpmix,
        kSystemVolume,
        kLoudness,
        kLimiter;

        private static Feature[] $values() [...] // Inlined contents

        @Override
        public String toString() {
            return super.toString().substring(1);
        }
    }

    public static enum Format {
        kF32leI,
        kF32leP,
        kS16leI,
        kS16leP;

        private static Format[] $values() [...] // Inlined contents

        @Override
        public String toString() {
            return super.toString().substring(1);
        }
    }

    public static enum LoudnessType {
        kOff,
        kLSC_Basic,
        kLSC_Strict,
        kLSC_QualitySecure,
        kLSC_Transparent,
        kLCO_On;

        private static LoudnessType[] $values() [...] // Inlined contents

        @Override
        public String toString() {
            return super.toString().substring(1).replace('_', ' ');
        }
    }

    public static enum SamplesPerBlock {
        kAuto(0),
        k512(0x200),
        kMax(0x8000);

        public final int raw;

        private static SamplesPerBlock[] $values() [...] // Inlined contents

        private SamplesPerBlock(int v1) {
            this.raw = v1;
        }

        @Override
        public String toString() {
            return super.toString().substring(1);
        }
    }

    public static enum SpatialUpmixGenre {
        kOff,
        kMovie,
        kMusic,
        kReverb,
        k3D,
        kVoice,
        kAuto;

        private static SpatialUpmixGenre[] $values() [...] // Inlined contents

        @Override
        public String toString() {
            return super.toString().substring(1);
        }
    }

    static final boolean $assertionsDisabled;
    private long instance_;

    static {
        System.loadLibrary("GaudioSolMusicOne");
    }

    private SolMusicOne() {
    }

    public SolMusicOne(String s) {
        this._create();
        this.setProfile(s);
    }

    private native int _create() {
    }

    private native int _destroy() {
    }

    private native int _getCaps() {
    }

    private native int _setup(ConfigWrapper arg1, ParamsWrapper arg2) {
    }

    private native int _update(ParamsWrapper arg1) {
    }

    @Override
    public void finalize() {
        super.finalize();
        this._destroy();
    }

    public native int flush() {
    }

    public native boolean getBooleanParameter(String arg1) {
    }

    public Set getCaps() {
        int v = this._getCaps();
        Set set0 = new HashSet();
        WrapperConverter.convert(v, set0);
        return set0;
    }

    public native float getFloatParameter(String arg1) {
    }

    public native int getIntParameter(String arg1) {
    }

    public native int getLatency() {
    }

    public static native String getVersion() {
    }

    public native int process(float[] arg1, float[] arg2, int arg3) {
    }

    public native int process(short[] arg1, short[] arg2, int arg3) {
    }

    public native int reset() {
    }

    public native void setParameter(String arg1, float arg2) {
    }

    public native void setParameter(String arg1, int arg2) {
    }

    public native void setParameter(String arg1, boolean arg2) {
    }

    public native int setProfile(String arg1) {
    }

    public int setup(Configuration configuration0, Parameters parameters0) {
        return this._setup(new ConfigWrapper(configuration0), new ParamsWrapper(parameters0));
    }

    public int update(Parameters parameters0) {
        return this._update(new ParamsWrapper(parameters0));
    }
}

