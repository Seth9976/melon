package com.gaudiolab.sol.android;

import android.util.Pair;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class WrapperConverter {
    static final Map CAPS_MAP;
    static final Map FEATURE_MAP;
    static final Map LCO_TYPE_MAP;
    static final Map LSC_TYPE_MAP;

    static {
        HashMap hashMap0 = new HashMap();
        WrapperConverter.FEATURE_MAP = hashMap0;
        HashMap hashMap1 = new HashMap();
        WrapperConverter.LSC_TYPE_MAP = hashMap1;
        HashMap hashMap2 = new HashMap();
        WrapperConverter.LCO_TYPE_MAP = hashMap2;
        HashMap hashMap3 = new HashMap();
        WrapperConverter.CAPS_MAP = hashMap3;
        hashMap0.put(Feature.kEleq, com.gaudiolab.sol.android.Feature.kEleq);
        hashMap0.put(Feature.kEqualizer, com.gaudiolab.sol.android.Feature.kEqualizer);
        hashMap0.put(Feature.kSpatialUpmix, com.gaudiolab.sol.android.Feature.kSpatialUpmix);
        hashMap0.put(Feature.kSystemVolume, com.gaudiolab.sol.android.Feature.kSystemVolume);
        hashMap0.put(Feature.kLimiter, com.gaudiolab.sol.android.Feature.kLimiter);
        Pair pair0 = new Pair(com.gaudiolab.sol.android.Feature.kLoudnessServerClient, LSCType.kBasic);
        hashMap1.put(LoudnessType.kLSC_Basic, pair0);
        Pair pair1 = new Pair(com.gaudiolab.sol.android.Feature.kLoudnessServerClient, LSCType.kStrict);
        hashMap1.put(LoudnessType.kLSC_Strict, pair1);
        Pair pair2 = new Pair(com.gaudiolab.sol.android.Feature.kLoudnessServerClient, LSCType.kQualitySecure);
        hashMap1.put(LoudnessType.kLSC_QualitySecure, pair2);
        Pair pair3 = new Pair(com.gaudiolab.sol.android.Feature.kLoudnessServerClient, LSCType.kTransparent);
        hashMap1.put(LoudnessType.kLSC_Transparent, pair3);
        Pair pair4 = new Pair(com.gaudiolab.sol.android.Feature.kLoudnessClientOnly, LCOType.kOn);
        hashMap2.put(LoudnessType.kLCO_On, pair4);
        hashMap3.put(com.gaudiolab.sol.android.Feature.kEleq, Feature.kEleq);
        hashMap3.put(com.gaudiolab.sol.android.Feature.kEqualizer, Feature.kEqualizer);
        hashMap3.put(com.gaudiolab.sol.android.Feature.kSpatialUpmix, Feature.kSpatialUpmix);
        hashMap3.put(com.gaudiolab.sol.android.Feature.kSystemVolume, Feature.kSystemVolume);
        hashMap3.put(com.gaudiolab.sol.android.Feature.kLimiter, Feature.kLimiter);
        hashMap3.put(com.gaudiolab.sol.android.Feature.kLoudnessServerClient, Feature.kLoudness);
        hashMap3.put(com.gaudiolab.sol.android.Feature.kLoudnessClientOnly, Feature.kLoudness);
    }

    public static void convert(int v, Set set0) {
        for(Object object0: WrapperConverter.CAPS_MAP.keySet()) {
            com.gaudiolab.sol.android.Feature feature0 = (com.gaudiolab.sol.android.Feature)object0;
            if((feature0.mask() & v) != 0) {
                set0.add(((Feature)WrapperConverter.CAPS_MAP.get(feature0)));
            }
        }
    }

    public static void convert(Configuration configuration0, ConfigWrapper configWrapper0) {
        configWrapper0.numInputChannels = configuration0.numInputChannels;
        configWrapper0.numOutputChannels = configuration0.numOutputChannels;
        configWrapper0.sampleRate = configuration0.sampleRate;
        configWrapper0.samplesPerBlock = configuration0.samplesPerBlock;
        configWrapper0.format = configuration0.format.ordinal();
    }

    public static void convert(Parameters parameters0, ParamsWrapper paramsWrapper0) {
        paramsWrapper0.isEnable = parameters0.isEnable;
        for(Object object0: parameters0.preferenceFeatures) {
            Feature solMusicOne$Feature0 = (Feature)object0;
            Map map0 = WrapperConverter.FEATURE_MAP;
            if(map0.containsKey(solMusicOne$Feature0)) {
                int v = paramsWrapper0.preferenceFeatures;
                paramsWrapper0.preferenceFeatures = ((com.gaudiolab.sol.android.Feature)map0.get(solMusicOne$Feature0)).mask() | v;
            }
        }
        if(parameters0.preferenceFeatures.contains(Feature.kLoudness)) {
            Map map1 = WrapperConverter.LSC_TYPE_MAP;
            if(map1.containsKey(parameters0.loudnessType)) {
                com.gaudiolab.sol.android.Feature feature0 = (com.gaudiolab.sol.android.Feature)((Pair)map1.get(parameters0.loudnessType)).first;
                LSCType lSCType0 = (LSCType)((Pair)map1.get(parameters0.loudnessType)).second;
                paramsWrapper0.preferenceFeatures |= feature0.mask();
                paramsWrapper0.lscType = lSCType0.ordinal();
            }
            Map map2 = WrapperConverter.LCO_TYPE_MAP;
            if(map2.containsKey(parameters0.loudnessType)) {
                com.gaudiolab.sol.android.Feature feature1 = (com.gaudiolab.sol.android.Feature)((Pair)map2.get(parameters0.loudnessType)).first;
                LCOType lCOType0 = (LCOType)((Pair)map2.get(parameters0.loudnessType)).second;
                paramsWrapper0.preferenceFeatures |= feature1.mask();
                paramsWrapper0.lcoType = lCOType0.ordinal();
            }
        }
        paramsWrapper0.targetLoudness = parameters0.targetLoudness;
        paramsWrapper0.environmentOffset = parameters0.environmentOffset;
        int v1 = parameters0.equalizerBandCount;
        paramsWrapper0.equalizerBandCount = v1;
        byte[] arr_b = null;
        paramsWrapper0.equalizerBandGainDb = parameters0.equalizerBandGainDb == null ? null : Arrays.copyOf(parameters0.equalizerBandGainDb, v1);
        paramsWrapper0.equalizerGlobalGainDb = parameters0.equalizerGlobalGainDb;
        paramsWrapper0.equalizerLoudnessEnabled = parameters0.equalizerLoudnessEnabled;
        paramsWrapper0.eleqVolume = parameters0.eleqVolume;
        paramsWrapper0.volumeGain = parameters0.volumeGain;
        paramsWrapper0.upmixGenre = parameters0.upmixGenre.ordinal();
        paramsWrapper0.reverbIntensity = parameters0.reverbIntensity;
        byte[] arr_b1 = parameters0.metadata;
        if(arr_b1 != null) {
            arr_b = Arrays.copyOf(arr_b1, parameters0.metadataLength);
        }
        paramsWrapper0.metadata = arr_b;
        paramsWrapper0.metadataLength = parameters0.metadataLength;
    }
}

