package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.MpegAudioHeader;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class MpegAudioReader implements ElementaryStreamReader {
    private static final int HEADER_SIZE = 4;
    private static final int STATE_FINDING_HEADER = 0;
    private static final int STATE_READING_FRAME = 2;
    private static final int STATE_READING_HEADER = 1;
    private String formatId;
    private int frameBytesRead;
    private long frameDurationUs;
    private int frameSize;
    private boolean hasOutputFormat;
    private final MpegAudioHeader header;
    private final ParsableByteArray headerScratch;
    private final String language;
    private boolean lastByteWasFF;
    private TrackOutput output;
    private int state;
    private long timeUs;

    public MpegAudioReader() {
        this(null);
    }

    public MpegAudioReader(String s) {
        this.state = 0;
        ParsableByteArray parsableByteArray0 = new ParsableByteArray(4);
        this.headerScratch = parsableByteArray0;
        parsableByteArray0.data[0] = -1;
        this.header = new MpegAudioHeader();
        this.language = s;
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray0) {
        while(parsableByteArray0.bytesLeft() > 0) {
            switch(this.state) {
                case 0: {
                    this.findHeader(parsableByteArray0);
                    break;
                }
                case 1: {
                    this.readHeaderRemainder(parsableByteArray0);
                    break;
                }
                case 2: {
                    this.readFrameRemainder(parsableByteArray0);
                    break;
                }
                default: {
                    throw new IllegalStateException();
                }
            }
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput0, TrackIdGenerator tsPayloadReader$TrackIdGenerator0) {
        tsPayloadReader$TrackIdGenerator0.generateNewId();
        this.formatId = tsPayloadReader$TrackIdGenerator0.getFormatId();
        this.output = extractorOutput0.track(tsPayloadReader$TrackIdGenerator0.getTrackId(), 1);
    }

    private void findHeader(ParsableByteArray parsableByteArray0) {
        byte[] arr_b = parsableByteArray0.data;
        int v = parsableByteArray0.getPosition();
        int v1 = parsableByteArray0.limit();
        while(v < v1) {
            int v2 = arr_b[v];
            boolean z = this.lastByteWasFF && (v2 & 0xE0) == 0xE0;
            this.lastByteWasFF = (v2 & 0xFF) == 0xFF;
            if(z) {
                parsableByteArray0.setPosition(v + 1);
                this.lastByteWasFF = false;
                this.headerScratch.data[1] = arr_b[v];
                this.frameBytesRead = 2;
                this.state = 1;
                return;
            }
            ++v;
        }
        parsableByteArray0.setPosition(v1);
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long v, int v1) {
        this.timeUs = v;
    }

    private void readFrameRemainder(ParsableByteArray parsableByteArray0) {
        int v = Math.min(parsableByteArray0.bytesLeft(), this.frameSize - this.frameBytesRead);
        this.output.sampleData(parsableByteArray0, v);
        int v1 = this.frameBytesRead + v;
        this.frameBytesRead = v1;
        int v2 = this.frameSize;
        if(v1 < v2) {
            return;
        }
        this.output.sampleMetadata(this.timeUs, 1, v2, 0, null);
        this.timeUs += this.frameDurationUs;
        this.frameBytesRead = 0;
        this.state = 0;
    }

    private void readHeaderRemainder(ParsableByteArray parsableByteArray0) {
        int v = Math.min(parsableByteArray0.bytesLeft(), 4 - this.frameBytesRead);
        parsableByteArray0.readBytes(this.headerScratch.data, this.frameBytesRead, v);
        int v1 = this.frameBytesRead + v;
        this.frameBytesRead = v1;
        if(v1 < 4) {
            return;
        }
        this.headerScratch.setPosition(0);
        if(!MpegAudioHeader.populateHeader(this.headerScratch.readInt(), this.header)) {
            this.frameBytesRead = 0;
            this.state = 1;
            return;
        }
        MpegAudioHeader mpegAudioHeader0 = this.header;
        this.frameSize = mpegAudioHeader0.frameSize;
        if(!this.hasOutputFormat) {
            int v2 = mpegAudioHeader0.sampleRate;
            this.frameDurationUs = ((long)mpegAudioHeader0.samplesPerFrame) * 1000000L / ((long)v2);
            Format format0 = Format.createAudioSampleFormat(this.formatId, mpegAudioHeader0.mimeType, null, -1, 0x1000, mpegAudioHeader0.channels, v2, null, null, 0, this.language);
            this.output.format(format0);
            this.hasOutputFormat = true;
        }
        this.headerScratch.setPosition(0);
        this.output.sampleData(this.headerScratch, 4);
        this.state = 2;
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.state = 0;
        this.frameBytesRead = 0;
        this.lastByteWasFF = false;
    }
}

