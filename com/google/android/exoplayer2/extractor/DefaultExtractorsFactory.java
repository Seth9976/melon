package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.ext.flac.FlacExtractor;
import com.google.android.exoplayer2.ext.flac.FlacLibrary;
import com.google.android.exoplayer2.extractor.amr.AmrExtractor;
import com.google.android.exoplayer2.extractor.flv.FlvExtractor;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer2.extractor.ogg.OggExtractor;
import com.google.android.exoplayer2.extractor.ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac4Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.extractor.wav.WavExtractor;
import java.lang.reflect.Constructor;

public final class DefaultExtractorsFactory implements ExtractorsFactory {
    private static final Constructor FLAC_EXTENSION_EXTRACTOR_CONSTRUCTOR;
    private int adtsFlags;
    private int amrFlags;
    private boolean constantBitrateSeekingEnabled;
    private int fragmentedMp4Flags;
    private int matroskaFlags;
    private int mp3Flags;
    private int mp4Flags;
    private int tsFlags;
    private int tsMode;

    static {
        Constructor constructor0 = null;
        try {
            Boolean boolean0 = Boolean.valueOf(FlacLibrary.isAvailable());
            if(Boolean.TRUE.equals(boolean0)) {
                try {
                    constructor0 = FlacExtractor.class.asSubclass(Extractor.class).getConstructor(null);
                }
                catch(ClassNotFoundException unused_ex) {
                }
            }
        }
        catch(Exception exception0) {
            throw new RuntimeException("Error instantiating FLAC extension", exception0);
        }
        DefaultExtractorsFactory.FLAC_EXTENSION_EXTRACTOR_CONSTRUCTOR = constructor0;
    }

    public DefaultExtractorsFactory() {
        this.tsMode = 1;
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public Extractor[] createExtractors() {
        synchronized(this) {
            Extractor[] arr_extractor = {new MatroskaExtractor(this.matroskaFlags), new FragmentedMp4Extractor(this.fragmentedMp4Flags), new Mp4Extractor(this.mp4Flags), new Mp3Extractor(this.mp3Flags | this.constantBitrateSeekingEnabled), new AdtsExtractor(this.adtsFlags | this.constantBitrateSeekingEnabled), new Ac3Extractor(), new TsExtractor(this.tsMode, this.tsFlags), new FlvExtractor(), new OggExtractor(), new PsExtractor(), new WavExtractor(), new AmrExtractor(this.amrFlags | this.constantBitrateSeekingEnabled), new Ac4Extractor(), null};
            Constructor constructor0 = DefaultExtractorsFactory.FLAC_EXTENSION_EXTRACTOR_CONSTRUCTOR;
            if(constructor0 == null) {
                arr_extractor[13] = new com.google.android.exoplayer2.extractor.flac.FlacExtractor();
            }
            else {
                try {
                    arr_extractor[13] = (Extractor)constructor0.newInstance(null);
                }
                catch(Exception exception0) {
                    throw new IllegalStateException("Unexpected error creating FLAC extractor", exception0);
                }
            }
            return arr_extractor;
        }
    }

    public DefaultExtractorsFactory setAdtsExtractorFlags(int v) {
        synchronized(this) {
            this.adtsFlags = v;
        }
        return this;
    }

    public DefaultExtractorsFactory setAmrExtractorFlags(int v) {
        synchronized(this) {
            this.amrFlags = v;
        }
        return this;
    }

    public DefaultExtractorsFactory setConstantBitrateSeekingEnabled(boolean z) {
        synchronized(this) {
            this.constantBitrateSeekingEnabled = z;
        }
        return this;
    }

    public DefaultExtractorsFactory setFragmentedMp4ExtractorFlags(int v) {
        synchronized(this) {
            this.fragmentedMp4Flags = v;
        }
        return this;
    }

    public DefaultExtractorsFactory setMatroskaExtractorFlags(int v) {
        synchronized(this) {
            this.matroskaFlags = v;
        }
        return this;
    }

    public DefaultExtractorsFactory setMp3ExtractorFlags(int v) {
        synchronized(this) {
            this.mp3Flags = v;
        }
        return this;
    }

    public DefaultExtractorsFactory setMp4ExtractorFlags(int v) {
        synchronized(this) {
            this.mp4Flags = v;
        }
        return this;
    }

    public DefaultExtractorsFactory setTsExtractorFlags(int v) {
        synchronized(this) {
            this.tsFlags = v;
        }
        return this;
    }

    public DefaultExtractorsFactory setTsExtractorMode(int v) {
        synchronized(this) {
            this.tsMode = v;
        }
        return this;
    }
}

