package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

public final class DvbSubtitleReader implements ElementaryStreamReader {
    private int bytesToCheck;
    private final TrackOutput[] outputs;
    private int sampleBytesWritten;
    private long sampleTimeUs;
    private final List subtitleInfos;
    private boolean writingSample;

    public DvbSubtitleReader(List list0) {
        this.subtitleInfos = list0;
        this.outputs = new TrackOutput[list0.size()];
    }

    private boolean checkNextByte(ParsableByteArray parsableByteArray0, int v) {
        if(parsableByteArray0.bytesLeft() == 0) {
            return false;
        }
        if(parsableByteArray0.readUnsignedByte() != v) {
            this.writingSample = false;
        }
        --this.bytesToCheck;
        return this.writingSample;
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray0) {
        if(this.writingSample && (this.bytesToCheck != 2 || this.checkNextByte(parsableByteArray0, 0x20)) && (this.bytesToCheck != 1 || this.checkNextByte(parsableByteArray0, 0))) {
            int v1 = parsableByteArray0.getPosition();
            int v2 = parsableByteArray0.bytesLeft();
            TrackOutput[] arr_trackOutput = this.outputs;
            for(int v = 0; v < arr_trackOutput.length; ++v) {
                TrackOutput trackOutput0 = arr_trackOutput[v];
                parsableByteArray0.setPosition(v1);
                trackOutput0.sampleData(parsableByteArray0, v2);
            }
            this.sampleBytesWritten += v2;
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput0, TrackIdGenerator tsPayloadReader$TrackIdGenerator0) {
        for(int v = 0; v < this.outputs.length; ++v) {
            DvbSubtitleInfo tsPayloadReader$DvbSubtitleInfo0 = (DvbSubtitleInfo)this.subtitleInfos.get(v);
            tsPayloadReader$TrackIdGenerator0.generateNewId();
            TrackOutput trackOutput0 = extractorOutput0.track(tsPayloadReader$TrackIdGenerator0.getTrackId(), 3);
            trackOutput0.format(Format.createImageSampleFormat(tsPayloadReader$TrackIdGenerator0.getFormatId(), "application/dvbsubs", null, -1, 0, Collections.singletonList(tsPayloadReader$DvbSubtitleInfo0.initializationData), tsPayloadReader$DvbSubtitleInfo0.language, null));
            this.outputs[v] = trackOutput0;
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
        if(this.writingSample) {
            TrackOutput[] arr_trackOutput = this.outputs;
            for(int v = 0; v < arr_trackOutput.length; ++v) {
                arr_trackOutput[v].sampleMetadata(this.sampleTimeUs, 1, this.sampleBytesWritten, 0, null);
            }
            this.writingSample = false;
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long v, int v1) {
        if((v1 & 4) == 0) {
            return;
        }
        this.writingSample = true;
        this.sampleTimeUs = v;
        this.sampleBytesWritten = 0;
        this.bytesToCheck = 2;
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.writingSample = false;
    }
}

