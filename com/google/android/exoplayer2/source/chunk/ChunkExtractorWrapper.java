package com.google.android.exoplayer2.source.chunk;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput.CryptoData;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class ChunkExtractorWrapper implements ExtractorOutput {
    static final class BindingTrackOutput implements TrackOutput {
        private final DummyTrackOutput dummyTrackOutput;
        private long endTimeUs;
        private final int id;
        private final Format manifestFormat;
        public Format sampleFormat;
        private TrackOutput trackOutput;
        private final int type;

        public BindingTrackOutput(int v, int v1, Format format0) {
            this.id = v;
            this.type = v1;
            this.manifestFormat = format0;
            this.dummyTrackOutput = new DummyTrackOutput();
        }

        public void bind(TrackOutputProvider chunkExtractorWrapper$TrackOutputProvider0, long v) {
            if(chunkExtractorWrapper$TrackOutputProvider0 == null) {
                this.trackOutput = this.dummyTrackOutput;
                return;
            }
            this.endTimeUs = v;
            TrackOutput trackOutput0 = chunkExtractorWrapper$TrackOutputProvider0.track(this.id, this.type);
            this.trackOutput = trackOutput0;
            Format format0 = this.sampleFormat;
            if(format0 != null) {
                trackOutput0.format(format0);
            }
        }

        @Override  // com.google.android.exoplayer2.extractor.TrackOutput
        public void format(Format format0) {
            Format format1 = this.manifestFormat;
            if(format1 != null) {
                format0 = format0.copyWithManifestFormatInfo(format1);
            }
            this.sampleFormat = format0;
            this.trackOutput.format(format0);
        }

        @Override  // com.google.android.exoplayer2.extractor.TrackOutput
        public int sampleData(ExtractorInput extractorInput0, int v, boolean z) {
            return this.trackOutput.sampleData(extractorInput0, v, z);
        }

        @Override  // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleData(ParsableByteArray parsableByteArray0, int v) {
            this.trackOutput.sampleData(parsableByteArray0, v);
        }

        @Override  // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleMetadata(long v, int v1, int v2, int v3, CryptoData trackOutput$CryptoData0) {
            if(this.endTimeUs != 0x8000000000000001L && v >= this.endTimeUs) {
                this.trackOutput = this.dummyTrackOutput;
            }
            this.trackOutput.sampleMetadata(v, v1, v2, v3, trackOutput$CryptoData0);
        }
    }

    public interface TrackOutputProvider {
        TrackOutput track(int arg1, int arg2);
    }

    private final SparseArray bindingTrackOutputs;
    private long endTimeUs;
    public final Extractor extractor;
    private boolean extractorInitialized;
    private final Format primaryTrackManifestFormat;
    private final int primaryTrackType;
    private Format[] sampleFormats;
    private SeekMap seekMap;
    private TrackOutputProvider trackOutputProvider;

    public ChunkExtractorWrapper(Extractor extractor0, int v, Format format0) {
        this.extractor = extractor0;
        this.primaryTrackType = v;
        this.primaryTrackManifestFormat = format0;
        this.bindingTrackOutputs = new SparseArray();
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        Format[] arr_format = new Format[this.bindingTrackOutputs.size()];
        for(int v = 0; v < this.bindingTrackOutputs.size(); ++v) {
            arr_format[v] = ((BindingTrackOutput)this.bindingTrackOutputs.valueAt(v)).sampleFormat;
        }
        this.sampleFormats = arr_format;
    }

    public Format[] getSampleFormats() {
        return this.sampleFormats;
    }

    public SeekMap getSeekMap() {
        return this.seekMap;
    }

    public void init(TrackOutputProvider chunkExtractorWrapper$TrackOutputProvider0, long v, long v1) {
        this.trackOutputProvider = chunkExtractorWrapper$TrackOutputProvider0;
        this.endTimeUs = v1;
        if(!this.extractorInitialized) {
            this.extractor.init(this);
            if(v != 0x8000000000000001L) {
                this.extractor.seek(0L, v);
            }
            this.extractorInitialized = true;
            return;
        }
        Extractor extractor0 = this.extractor;
        if(v == 0x8000000000000001L) {
            v = 0L;
        }
        extractor0.seek(0L, v);
        for(int v2 = 0; v2 < this.bindingTrackOutputs.size(); ++v2) {
            ((BindingTrackOutput)this.bindingTrackOutputs.valueAt(v2)).bind(chunkExtractorWrapper$TrackOutputProvider0, v1);
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(SeekMap seekMap0) {
        this.seekMap = seekMap0;
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorOutput
    public TrackOutput track(int v, int v1) {
        TrackOutput trackOutput0 = (BindingTrackOutput)this.bindingTrackOutputs.get(v);
        if(trackOutput0 == null) {
            Assertions.checkState(this.sampleFormats == null);
            trackOutput0 = new BindingTrackOutput(v, v1, (v1 == this.primaryTrackType ? this.primaryTrackManifestFormat : null));
            ((BindingTrackOutput)trackOutput0).bind(this.trackOutputProvider, this.endTimeUs);
            this.bindingTrackOutputs.put(v, trackOutput0);
        }
        return trackOutput0;
    }
}

