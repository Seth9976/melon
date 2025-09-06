package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class Id3Reader implements ElementaryStreamReader {
    private static final String TAG = "Id3Reader";
    private final ParsableByteArray id3Header;
    private TrackOutput output;
    private int sampleBytesRead;
    private int sampleSize;
    private long sampleTimeUs;
    private boolean writingSample;

    public Id3Reader() {
        this.id3Header = new ParsableByteArray(10);
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray0) {
        if(!this.writingSample) {
            return;
        }
        int v = parsableByteArray0.bytesLeft();
        int v1 = this.sampleBytesRead;
        if(v1 < 10) {
            int v2 = Math.min(v, 10 - v1);
            System.arraycopy(parsableByteArray0.data, parsableByteArray0.getPosition(), this.id3Header.data, this.sampleBytesRead, v2);
            if(this.sampleBytesRead + v2 == 10) {
                this.id3Header.setPosition(0);
                if(73 == this.id3Header.readUnsignedByte() && 68 == this.id3Header.readUnsignedByte() && 51 == this.id3Header.readUnsignedByte()) {
                    this.id3Header.skipBytes(3);
                    this.sampleSize = this.id3Header.readSynchSafeInt() + 10;
                    goto label_16;
                }
                Log.w("Id3Reader", "Discarding invalid ID3 tag");
                this.writingSample = false;
                return;
            }
        }
    label_16:
        int v3 = Math.min(v, this.sampleSize - this.sampleBytesRead);
        this.output.sampleData(parsableByteArray0, v3);
        this.sampleBytesRead += v3;
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput0, TrackIdGenerator tsPayloadReader$TrackIdGenerator0) {
        tsPayloadReader$TrackIdGenerator0.generateNewId();
        TrackOutput trackOutput0 = extractorOutput0.track(tsPayloadReader$TrackIdGenerator0.getTrackId(), 4);
        this.output = trackOutput0;
        trackOutput0.format(Format.createSampleFormat(tsPayloadReader$TrackIdGenerator0.getFormatId(), "application/id3", null, -1, null));
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
        if(this.writingSample) {
            int v = this.sampleSize;
            if(v != 0 && this.sampleBytesRead == v) {
                this.output.sampleMetadata(this.sampleTimeUs, 1, v, 0, null);
                this.writingSample = false;
            }
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long v, int v1) {
        if((v1 & 4) == 0) {
            return;
        }
        this.writingSample = true;
        this.sampleTimeUs = v;
        this.sampleSize = 0;
        this.sampleBytesRead = 0;
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.writingSample = false;
    }
}

